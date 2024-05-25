/*
 * EncryptedRuleReader.java
 *
 * Created on October 26, 2003, 10:56 PM
 */

package com.trinity.ea.rules.reader;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.*;
import java.io.*;
import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;
import java.util.Date;
import java.text.NumberFormat;
import com.trinity.ea.util.EAProperties;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.MalformedURLException;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2003-2005 Trinity Software. All rights reserved.
 */
public class EncryptedRuleReader 
{
    private static EAProperties props = new EAProperties();
    private static String strRulesFileName = "rules.eae"; 

    private static Cipher cenc1;
    private static Provider sunJce;
    private static PBEKeySpec pbeKeySpec;
    private static PBEParameterSpec pbeParamSpec;
    private static SecretKeyFactory keyFac;
    private static SecretKey pbeKey;
    final private static Date currentDate = new Date();    
    private static RuleHandler rh = new RuleHandler();
    private static byte[] salt = {(byte)0x34, (byte)0xae, (byte)0x4c, (byte)0xe4,(byte)0xd7, (byte)0x11, (byte)0xab, (byte)0xb2};
    private static int count = 947;
    private static String valCode = "";
    private static Object mysteryObject = null;
    private static String valCodeMsg = "";
    private static Object mysteryObjectMsg = null;
    private static boolean localeEnabled = false;
    private static boolean landFSet = false;    
    private static String javaVersion = "";
    private static String osArch = ""; 
    private static String os = "";    
    private static int osID = 2;     
    //public final static int WINDOWS = 0;
    //public final static int UNIX = 1;
    //public final static int JAVA = 2;
    //public final static int OSX = 3;
    //Internationalization 
    private static Locale currentLocale;
    private static ResourceBundle messages;
    
    /** Creates a new instance of EncryptedRuleBuilder */
    public EncryptedRuleReader(){}    
    
    public static synchronized void setLocale(String language, String country)
    {
        setLocale("MessagesBundle", language, country);
    }
    
    public static synchronized void setLocale(String bundleName, String language, String country)
    {
        try
        {
            currentLocale = new Locale(language, country);
            messages = ResourceBundle.getBundle(bundleName, currentLocale);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static synchronized Locale getLocale()
    {
        try
        {
            return Locale.getDefault();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }       
    }
    public static synchronized void setLocale()
    {
        setLocale("MessagesBundle"); 
    }
    
    public static synchronized void setLocale(String bundleName)
    {
        try
        {
            messages = ResourceBundle.getBundle(bundleName, getLocale());    
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }        
    }
    
    public static synchronized Locale getCurrentLocale()
    {
        return messages.getLocale();
    }
  
    static public String getNumberLocale(long numberToReturn) 
    {
      NumberFormat numberFormatter = NumberFormat.getNumberInstance(getCurrentLocale());
      return numberFormatter.format(numberToReturn);
   }

   static public String getCurrencyLocale(Double currency) 
   {
      NumberFormat currencyFormatter;
      currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);
      return currencyFormatter.format(currency);
   }   
    
    /** Read the Properties File */
    public static synchronized boolean readPropertiesFile()
    {
        
        Provider sunJce = new com.sun.crypto.provider.SunJCE(); 
        Security.addProvider(sunJce);
        try
        {
            // Create PBE parameter set
            pbeParamSpec = new PBEParameterSpec(salt, count);
            pbeKeySpec = new PBEKeySpec(getRealString(rh.getSeed()),salt,count);
            keyFac = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            pbeKey = keyFac.generateSecret(pbeKeySpec);
            cenc1=Cipher.getInstance("PBEWithMD5AndDES");
        }
        catch(NullPointerException e)
        {
           // System.out.println(e);
           // e.printStackTrace();        
        }        
        catch(Exception e)
        {
           // System.out.println(e);
           /// e.printStackTrace();        
        }
        try
        {
            FileInputStream fis;
            CipherInputStream cis1;

            /* Initialize the Cipher */
            cenc1.init(Cipher.DECRYPT_MODE, pbeKey, pbeParamSpec);

            File propFile = new File(getFileName());
            if(propFile.exists()==true)
            {
                    try
                    {
                        fis = new FileInputStream(propFile);
                        cis1 = new CipherInputStream(fis, cenc1);
                        props.load(cis1);
                        fis.close();
                        cis1.close();
                       try
                        {
                            if(EncryptedRuleReader.get("i18nBundleName")!=null)
                            {
                                if(EncryptedRuleReader.get("i18nBundleName").equalsIgnoreCase("")==false)
                                {                
                                    EncryptedRuleReader.setLocale(EncryptedRuleReader.get("i18nBundleName"));
                                    EncryptedRuleReader.setLocaleEnabled(true);
                                }
                                else
                                {
                                    EncryptedRuleReader.setLocale();
                                    EncryptedRuleReader.setLocaleEnabled(true);
                                }
                            }
                            else
                            { 
                                EncryptedRuleReader.setLocale();  
                                EncryptedRuleReader.setLocaleEnabled(true);
                            }
                        }
                        catch (Exception e)
                        {
                            System.out.println("Could not set default locale.");
                        }
                        // update OS Information, and Java Version
                        updateOSInfo();
                        return true;
                    }
                    catch(IOException ee)
                    {
                      //  System.out.println(ee);
                      //  ee.printStackTrace();                        
                        return false;
                    }
            }
            else
            {
                 return false;
            }
        }
        catch(InvalidAlgorithmParameterException e)
        {
           // System.out.println(e);
           // e.printStackTrace();   
            return false;
        }
        catch(InvalidKeyException e)
        {
           // System.out.println(e);
           // e.printStackTrace();   
            return false;
        }        
    }    
   /** Write the Properties File. */
    private static synchronized boolean writeFile()
    {
        Provider sunJce = new com.sun.crypto.provider.SunJCE(); 
        Security.addProvider(sunJce);
        /*
        Random random1 = new Random();
        long keyLong = random1.nextLong();
        try
        {
            String theStr = null;
            if(String.valueOf(keyLong)!=null)
            {
                theStr = String.valueOf(keyLong);
            }
           if(theStr.indexOf("-")!=-1)
            {
                theStr = theStr.substring(theStr.indexOf("-")+1);
            }  
            if(theStr.indexOf("#")!=-1)
            {
                theStr = theStr.substring(theStr.indexOf("#")+1);
            }             
            if(theStr.equals(""))
            {
                theStr = "jhgdskjfejhrfekjhrf";
            }           
        }
        catch(Exception e)
        {
            //System.out.println(e);
            //e.printStackTrace();
            readPropertiesFile();
            return false;
        }*/
        try
        {
            // Create PBE parameter set
            pbeParamSpec = new PBEParameterSpec(salt, count);
            pbeKeySpec = new PBEKeySpec(getRealString(rh.getSeed()),salt,count);
            keyFac = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            pbeKey = keyFac.generateSecret(pbeKeySpec);
            cenc1=Cipher.getInstance("PBEWithMD5AndDES");
        }
        catch(NullPointerException e)
        {
           // System.out.println(e);
            //e.printStackTrace(); 
            readPropertiesFile();
            return false;
        }        
        catch(Exception e)
        {
          //  System.out.println(e);
          //  e.printStackTrace();
            readPropertiesFile();
            return false;
        }
        // Specify IV.
        try
        {
            FileOutputStream fos;            
            CipherOutputStream cos1;
            /* Initialize the Cipher */
            cenc1.init(Cipher.ENCRYPT_MODE, pbeKey, pbeParamSpec);
            File propFile = new File(getFileName());
            if(propFile.exists()==true)
            {
                    try
                    {
                        fos = new FileOutputStream(propFile,false);
                        cos1 = new CipherOutputStream(fos, cenc1);
                        props.store(cos1);
                        fos.close();
                        cos1.close();
                        readPropertiesFile();
                        return true;
                    }
                    catch(FileNotFoundException ee)
                    {
                       // System.out.println(ee);
                      //  ee.printStackTrace();
                        readPropertiesFile();
                        return false;
                    }
            }
            else
            {
                if(propFile.createNewFile()==true)
                {
                    try
                    {
                        fos = new FileOutputStream(propFile,false);
                        cos1 = new CipherOutputStream(fos, cenc1);
                        props.store(cos1);
                        fos.close();
                        cos1.close();
                        propFile.setLastModified(currentDate.getTime());
                        readPropertiesFile();
                        return true;
                    }
                    catch(FileNotFoundException ee)
                    {
                        //System.out.println(ee);
                        //ee.printStackTrace();
                        readPropertiesFile();
                        return false;
                    }
                }
                else
                {
                    readPropertiesFile();
                    return false;
                }
                
               
            }
        }
        catch(InvalidAlgorithmParameterException e)
        {
            //System.out.println(e);
            //e.printStackTrace();  
            readPropertiesFile();
            return false;
        }
        catch(InvalidKeyException e)
        {
            //System.out.println(e);
            //e.printStackTrace(); 
            readPropertiesFile();
            return false;
        }        
        catch (UnsupportedEncodingException e) 
        {
            //System.out.println(e);
            //e.printStackTrace();  
            readPropertiesFile();
            return false;         
        } 
        catch (java.io.IOException e) 
        {
            //System.out.println(e);
            //e.printStackTrace();   
            readPropertiesFile();
            return false;
        }
    }    
    
    private synchronized static void updateOSInfo()
    {
        try
        {
            os = System.getProperty("os.name");       
            osArch = System.getProperty("os.arch");  
            javaVersion = System.getProperty("java.version");   
            if(os.startsWith("Windows")==true)
            {
                osID=0;
            }
            else if(os.startsWith("Mac OS X")==true)
            {
                osID=3;                
            }
            else if(os.startsWith("Linux")==true)
            {
                osID=1;     
            }
            else if(os.startsWith("HP-UX")==true)
            {
                osID=1;     
            }
            else if(os.startsWith("AIX")==true)
            {
                osID=1;     
            }
            else if(os.startsWith("Solaris")==true)
            {
                osID=1;     
            }    
            else if(os.startsWith("SunOS")==true)
            {
                osID=1;     
            } 
            else if(os.indexOf("UNIX")!=-1)
            {
                osID=1;     
            }             
            else
            {
                osID=2;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /** Return the Rules File filename. Default Rules filename is rules.eax */
    public static synchronized String getFileName()
    {
        return strRulesFileName;
    }
    
    public static synchronized String get(String key)
    {
        try
        {
            return (String)props.get(key);
        }
        catch(Exception e)
        {
            return null;
        }
    }   

    public static synchronized String getLocaleString(String key)
    {
        try
        {
            return (String)messages.getString(key);
        }
        catch(Exception e)
        {
            try
            {
                return get(key);
            }
            catch(Exception ee)
            {
                ee.printStackTrace();
                return null;
            }
        }
    }       
    
    public static synchronized boolean register(String value)
    {
        return reg(value);
    }
    
    private static boolean reg(String value)
    {
         try
        {
            readPropertiesFile();
            if(Integer.parseInt(get("regAttempts"))<Integer.parseInt(get("maxRegisterAttempts")))
            {           
                if(get("registeredCode")!=null)
                {
                    if(get("registeredCode").equalsIgnoreCase("")==false)
                    {                
                        Object[] regcodes = getStringArraysFromString(get("registeredCode"));
                        boolean isreg = false;
                        for(int i = 0;i<regcodes.length;i++)
                        {
                             if(regcodes[i]!=null)
                             {
                                 if(((String)regcodes[i]).equalsIgnoreCase(value)==true)
                                 {
                                    isreg=true;
                                 }
                             }
                        }
                        if(isreg==true)
                        {
                            props.put("isRegistered","true");
                            writeFile();
                            return true;                           
                        }
                        else
                        {
                            props.put("regAttempts",String.valueOf(Integer.parseInt(get("regAttempts")) + 1));
                            writeFile();
                            return false;                               
                        }
                    }
                    else
                    {
                        if(get("registeredCode").equalsIgnoreCase(value)==true)
                        {
                            props.put("isRegistered","true");
                            writeFile();
                            return true;
                        }        
                        else
                        {
                            props.put("regAttempts",String.valueOf(Integer.parseInt(get("regAttempts")) + 1));
                            writeFile();
                            return false;               
                        }                        
                    }
                }
            }
            else
            {
                if(EncryptedRuleReader.get("lockDownAction")!=null)
                {
                    try
                    {
            		// Create a new class loader with the directory
			      URL[] urls = {new File(getRunDirectory() + "/" + EncryptedRuleReader.get("rootJar")).toURL()};
            		ClassLoader cl = new URLClassLoader(urls);
        			// Load in the class
        			Class cls = cl.loadClass(get("lockDownAction"));
    
        			// Create a new instance of the new class
            		cls.newInstance();            
                    }
                    catch(InstantiationException e)
                    {
                        System.out.println(e);
                    }   
                    catch(IllegalAccessException e)
                    {
                        System.out.println(e);
                    }                      
                    catch(ClassNotFoundException e)
                    {
                        System.out.println(e);
                    }       
                }
                else
                {
                    //Problem in Properties File
                    return false;
                }
            }
        }
        catch(Exception e)
        {
//System.out.println("Exception thrown: ");
//e.printStackTrace();            
return false;
        }       
         return false;
    }  

    public static synchronized boolean expired()
    {
        return expred();
    }
    
    private static boolean expred()
    {
         try
        {
            readPropertiesFile();
            if(get("runtimeMillasecondsToExpire")!=null)
            {
                 if(get("runtimeMillasecondsToExpire").equalsIgnoreCase("0")!=true)
                {               
                        props.put("runtimeMillasecondsToExpire","0");
                        writeFile();
                        return true;             
                }
            }
        }
        catch(Exception e)
        {
            return false;
        }       
         return false;
    }  

    public static synchronized boolean optin(String name, String mail)
    {
        return optn(name,mail);
    }
    
    private static boolean optn(String name, String mail)
    {
         try
        {
            readPropertiesFile();
            if(get("optinIsEnabled")!=null)
            {
                 if(get("optinIsEnabled").equalsIgnoreCase("true")==true)
                {               
                     if(get("optinIsOptedIn")!=null)
                     {
                         if(get("optinIsOptedIn").equalsIgnoreCase("false")==true)
                         {                             
                              props.put("optinIsOptedIn","true");
                              props.put("optinEMail",mail);
                              props.put("optinName",name);                              
                              writeFile();
                              return true;
                         }
                     }
                     return false;
                }
            }
        }
        catch(Exception e)
        {
            return false;
        }       
         return false;
    }      
    
    public static synchronized void attemptPayment()
    {
        attmptPayment();
    }
    
    /** Payment attempt counter method. Used to cut down on brute force credit card payments that cost retailers, when chargebacks, and fraud occurs. Locks down trial once max payment attempts occurs. and allows customers to launch an action in response to their attempt (defense). */
    private static void attmptPayment()
    {
        try
        {
            readPropertiesFile();
            if(Integer.parseInt(get("paymentAttempts"))<Integer.parseInt(get("maxPaymentAttempts")))
            {           
                props.put("paymentAttempts",String.valueOf(Integer.parseInt(get("paymentAttempts")) + 1));
                writeFile();
                if(EncryptedRuleReader.get("paymentFailedAction")!=null)
                {
                    if(EncryptedRuleReader.get("paymentFailedAction").equalsIgnoreCase(""))
                    {
                    	try
                    	{
            			Class.forName(get("paymentFailedAction")).newInstance();      
                 		}
                    	catch(InstantiationException e)
                    	{
                    	    System.out.println(e);
                    	}   
                   	catch(IllegalAccessException e)
                   	{
                   	    System.out.println(e);
                   	}                      
                    	catch(ClassNotFoundException e)
                    	{
                    	    //System.out.println(e);
                    	}
                        return;      
                    }
                }
            }
            else
            {
                if(EncryptedRuleReader.get("paymentLockDownAction")!=null)
                {
                     	try
                    	{
            			// Create a new class loader with the directory
					URL[] urls = {new File(getRunDirectory() + "/" + EncryptedRuleReader.get("rootJar")).toURL()};
            			ClassLoader cl = new URLClassLoader(urls);
        				// Load in the class
        				Class cls = cl.loadClass(get("paymentLockDownAction"));
    
        				// Create a new instance of the new class
            			cls.newInstance();            
                 		}
                    	catch(InstantiationException e)
                    	{
                    	    System.out.println(e);
                    	}   
                   	catch(IllegalAccessException e)
                   	{
                   	    System.out.println(e);
                   	}                      
                    	catch(ClassNotFoundException e)
                    	{
                    	    //System.out.println(e);
                    	}   
                }
                else
                {
                    //Problem in Properties File
                    return;
                }
            }

        }
        catch(Exception e)
        {
            return;
        }       
         return;
    }      
    
    public final static synchronized boolean startTrial()
    {
        return strtTrial();
    }
    
    // Returns boolean value true if a new Trial was instanciated. Starts a new Trial period if a Trial period has not been set, and if start Internal Trials option is set to true, otherwise will not start a new Trial.     
    private final static boolean strtTrial()
    {   
        String strCurrentDate = "0";
        try
        {
             strCurrentDate = String.valueOf(currentDate.getTime());           
        }
        catch(Exception e){}        
        try
        {
            readPropertiesFile();
            if(get("allowInternalStartTrialInstanciation").equalsIgnoreCase("true"))
            {
                if(get("runtimeMillasecondsStartTrial")!=null)
                {
                    if(get("runtimeMillasecondsStartTrial").equalsIgnoreCase("")==true)
                    {
                        try
                        {
                            int fileExists = Indexer.getIndexFileExists();                           
                            if(fileExists==0)
                            {
                                // check index file for product previous install
                                Object[] result = Indexer.getProductExistsInIndexFile(((String)props.get("product_vendor_name")), ((String)props.get("product_name")), ((String)props.get("product_version")));
                                if(((Boolean)result[0]).booleanValue()==true)
                                { 
                                    // retrieve the timestamp and sign the rules file
                                    strCurrentDate = ((String)result[1]);
                                }
                            }
                            else if(fileExists==1)
                            {
                                // check index file for product previous install
                                Object[] result = Indexer.getProductExistsInIndexFile(((String)props.get("product_vendor_name")), ((String)props.get("product_name")), ((String)props.get("product_version")));
                                if(((Boolean)result[0]).booleanValue()==true)
                                { 
                                    // retrieve the timestamp and sign the rules file
                                    strCurrentDate = ((String)result[1]);
                                }
                            }                            
                        }
                        catch(Exception e)
                        {
                            //return false;
                        }                       
                        //update install timestamp
                        if(props.get("runtimeMillasecondsStartTrial")!=null)
                        {
                           if(((String)props.get("runtimeMillasecondsStartTrial")).equalsIgnoreCase("")==true)
                           {
                               //update install timestamp
                               props.put("runtimeMillasecondsStartTrial",strCurrentDate);
                           }
                        }
                        else
                        {
                              //update install timestamp
                              props.put("runtimeMillasecondsStartTrial",strCurrentDate);
                        }
                        writeFile();
                        return true;
                    }
                    return false;
                }
                else
                {
                    try
                    {
                        int fileExists = Indexer.getIndexFileExists();
                        if(fileExists==0)
                        {
                            // check index file for product previous install
                            Object[] result = Indexer.getProductExistsInIndexFile(((String)props.get("product_vendor_name")), ((String)props.get("product_name")), ((String)props.get("product_version")));
                            if(((Boolean)result[0]).booleanValue()==true)
                            { 
                                // retrieve the timestamp and sign the rules file
                                strCurrentDate = ((String)result[1]);
                            }
                        }
                        else if(fileExists==1)
                        {
                            // check index file for product previous install
                            Object[] result = Indexer.getProductExistsInIndexFile(((String)props.get("product_vendor_name")), ((String)props.get("product_name")), ((String)props.get("product_version")));
                            if(((Boolean)result[0]).booleanValue()==true)
                            { 
                                // retrieve the timestamp and sign the rules file
                                strCurrentDate = ((String)result[1]);
                            }
                        }                        
                    }
                    catch(Exception e)
                    {
                        //return false;
                    }                       
                    //update install timestamp
                    if(props.get("runtimeMillasecondsStartTrial")!=null)
                    {
                       if(((String)props.get("runtimeMillasecondsStartTrial")).equalsIgnoreCase("")==true)
                       {
                           //update install timestamp
                           props.put("runtimeMillasecondsStartTrial",strCurrentDate);
                       }
                    }
                    else
                    {
                          //update install timestamp
                          props.put("runtimeMillasecondsStartTrial",strCurrentDate);
                    }
                    writeFile();
                    return true;
                }
             }
            else
            {
                return false;
            }
        }
        catch(NullPointerException e)
        {
            return false;
        }
        catch(Exception e)
        {
            return false;
        }
    }    

    public final static synchronized boolean updateInProgress(boolean inProgress)
    {
        return updteInProgress(inProgress);
    }
    
    /** Returns boolean value true if a value was set. Sets update status. */    
    private final static boolean updteInProgress(boolean inProgress)
    {   
        
        try
        {
            readPropertiesFile();
            if(get("autoUpdateEnabled")!=null)
            {           
                if(get("autoUpdateEnabled").equalsIgnoreCase("true")==true)
                {
                    if(get("autoUpdateUpdateInProgress")!=null)
                    {
                        if(get("autoUpdateUpdateInProgress").equalsIgnoreCase(String.valueOf(inProgress))==false)
                        {
                            //update install timestamp
                            props.put("autoUpdateUpdateInProgress",String.valueOf(inProgress));
                            writeFile();
                            return true;
                        }
                        return false;
                    }
                 }
                else
                {
                    return false;
                }
            }
        }
        catch(NullPointerException e)
        {
            return false;
        }
        catch(Exception e)
        {
            return false;
        }
        return false;
    }    

    public final static synchronized boolean lastUpdate()
    {
        return lstUpdate();
    }
    
    /** Returns boolean value true if a value was set. Sets time of last update check. */    
    private final static boolean lstUpdate()
    {   
        
        try
        {
            readPropertiesFile();
            if(get("autoUpdateEnabled")!=null)
            {     
                if(get("autoUpdateEnabled").equalsIgnoreCase("true")==true)
                {
                    //update install timestamp
                    props.put("autoUpdateLastCheckedTimestamp",String.valueOf(currentDate.getTime()));
                    writeFile();
                    return true;
                }
            }
            return false;

        }
        catch(NullPointerException e)
        {
            return false;
        }
        catch(Exception e)
        {
            return false;
        }
    }      
    
    public final static synchronized boolean updateID(String updateID)
    {
        return updteID(updateID);
    }
    
    /** Returns boolean value true if a value was set. Sets update ID. autoUpdateUpdateInProgress must be set to true to modify this value. */    
    private final static boolean updteID(String updateID)
    {   
        
        try
        {
            readPropertiesFile();
            if(get("autoUpdateEnabled")!=null)
            {           
                if(get("autoUpdateEnabled").equalsIgnoreCase("true")==true)
                {
                    if(get("autoUpdateUpdateInProgress")!=null)
                    {
                        if(get("autoUpdateUpdateInProgress").equalsIgnoreCase("true")==true)
                        {
                            //update install timestamp
                            props.put("autoUpdateUpdateID",updateID);
                            props.put("autoUpdateRunDirUpdateNeeded","true");                           
                            writeFile();
                            return true;
                        }
                        return false;
                    }
                 }
                else
                {
                    return false;
                }
            }
        }
        catch(NullPointerException e)
        {
            return false;
        }
        catch(Exception e)
        {
            return false;
        }
        return false;
    }    
   
    /** Returns boolean value true if a value was set. Sets update file copy is needed. */
    public final static synchronized boolean updateNeeded(boolean isNeeded)
    {
        return updteNeeded(isNeeded);
    }
    
    private final static boolean updteNeeded(boolean isNeeded)
    {   
        
        try
        {
            readPropertiesFile();
            if(get("autoUpdateEnabled")!=null)
            {           
                if(get("autoUpdateEnabled").equalsIgnoreCase("true")==true)
                {
                    if(get("autoUpdateUpdateInProgress")!=null)
                    {
                        if(get("autoUpdateUpdateInProgress").equalsIgnoreCase("false")==true)
                        {
                            props.put("autoUpdateRunDirUpdateNeeded","false");                           
                            writeFile();
                            return true;
                        }
                        return false;
                    }
                 }
                else
                {
                    return false;
                }
            }
        }
        catch(NullPointerException e)
        {
            return false;
        }
        catch(Exception e)
        {
            return false;
        }
        return false;
    }        
    
    public static synchronized boolean allowUpdateAttempt(int maxAttempts)
    {
        return allowUpdteAttempt(maxAttempts);
    }
    
    private static boolean allowUpdteAttempt(int maxAttempts)
    {
        try
        {
            //Theoretically could permanently disable update is value is Rules file is corrupted or unavailable.
            if(Integer.parseInt(get("autoUpdateMaxAttempts"))<maxAttempts)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(Exception e)
        {
            return false;
        }       
    }   
    
    public static synchronized boolean updateStatus(int statusID)
    {
        return updteStatus(statusID);
    }
    
    private static boolean updteStatus(int statusID)
    {
        try
        {
            //Theoretically could permanently disable update is value is Rules file is corrupted or unavailable.
            props.put("lastUpdateStatus",String.valueOf(statusID));
            writeFile();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }       
    }

    public static synchronized int getLastUpdateStatus()
    {
        return getLastUpdteStatus();
    }
    
    private static int getLastUpdteStatus()
    {
        try
        {
            //Theoretically could permanently disable update is value is Rules file is corrupted or unavailable.
            return Integer.parseInt(get("lastUpdateStatus"));
        }
        catch(Exception e)
        {
            return -1;
        }       
    }     
    
    public final static synchronized boolean messageID(String messageID)
    {
        return msgID(messageID);
    }
    
    /** Returns boolean value true if a value was set. Sets update ID. autoUpdateUpdateInProgress must be set to true to modify this value. */    
    private final static boolean msgID(String messageID)
    {   
        
        try
        {
            readPropertiesFile();
            if(get("msgEnabled")!=null)
            {           
                if(get("msgEnabled").equalsIgnoreCase("true")==true)
                {
                            //update install timestamp
                            props.put("msgUpdateID",messageID);
                            writeFile();
                            return true;
                 }
                else
                {
                    return false;
                }
            }
        }
        catch(NullPointerException e)
        {
            return false;
        }
        catch(Exception e)
        {
            return false;
        }
        return false;
    }    
    
    private static EAProperties getProperties()
    {
        return props;
    }   
   
    
    private static char[] getRealString(char[] theString)
    {
        char[] theArray = new char[theString.length];
        for(int i = 0;i<theString.length;i++)
        {
            char tempChar = theString[i];
            theArray[i] = (char)((int)tempChar-2);
        }
        return theArray;
    } 
    
    public static synchronized void setURLUpdate(String AccessCode, String url, int position)
    {
        try
        {
            if(EncryptedRuleReader.get("autoUpdateBaseURLChangesAllowed")!=null)
            {
               if(EncryptedRuleReader.get("autoUpdateBaseURLChangesAllowed").equalsIgnoreCase("true")==true)
               {
                    shoeBoxEnabled = true;
                    valCode = AccessCode;

                    try
                    {
                        mysteryObject = Class.forName(EncryptedRuleReader.get("autoUpdateShoeHandler")).newInstance();
                        ((RuleHandlerShoe)mysteryObject).setShoeBox(url, position);
                        shoeBoxEnabled=false;
                    }
                    catch(InstantiationException e)
                    {
                        e.printStackTrace();
                        //System.out.println(e);
                    }   
                    catch(IllegalAccessException e)
                    {
                        e.printStackTrace();            
                        //System.out.println(e);
                    }                      
                    catch(ClassNotFoundException e)
                    {
                        e.printStackTrace();            
                        //System.out.println(e);
                    }      

                    valCode = "";
                    shoeBoxEnabled=false;               
               }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    protected static synchronized void setShoeBox(String url, String pos)
    {
        if(((RuleHandlerShoe)mysteryObject).getReturn()==10777)
        {
            if(((RuleHandlerShoe)mysteryObject).getProcess()!=false)
            {           
                if(shoeBoxEnabled==true)
                {
                    props.put(pos,url);
                    //System.out.println("Updated " + pos + ": " + "URL: " + url);
                }
            }
        }
        mysteryObject=null;
    }
    
    protected static synchronized String getValidationCode()
    {
        return valCode;
    }
    private static boolean shoeBoxEnabled = false;
    protected static boolean getShoeBoxIsEnabled()
    {
        return shoeBoxEnabled;
    }
    ///////////////////////////
    
    public static synchronized void setURLMessageUpdate(String AccessCode, String url, int position)
    {
        try
        {
            if(EncryptedRuleReader.get("msgBaseURLChangesAllowed")!=null)
            {
               if(EncryptedRuleReader.get("msgBaseURLChangesAllowed").equalsIgnoreCase("true")==true)
               {
                    shoeBoxMessageEnabled = true;
                    valCodeMsg = AccessCode;

                    try
                    {
                        mysteryObjectMsg = Class.forName(EncryptedRuleReader.get("msgShoeHandler")).newInstance();
                        ((RuleHandlerMessageShoe)mysteryObjectMsg).setMessageShoeBox(url, position);
                        shoeBoxMessageEnabled=false;
                    }
                    catch(InstantiationException e)
                    {
                        e.printStackTrace();
                        //System.out.println(e);
                    }   
                    catch(IllegalAccessException e)
                    {
                        e.printStackTrace();            
                        //System.out.println(e);
                    }                      
                    catch(ClassNotFoundException e)
                    {
                        e.printStackTrace();            
                        //System.out.println(e);
                    }      

                    valCodeMsg = "";
                    shoeBoxMessageEnabled=false;               
               }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
 //Added setLocaleEnabled, getLocaleEnabled, and selLAFSet, getLAFSet for GUI Level functions
    //7/10/2004 TODO: Move these utility methods to a different object in an upcoming release
    public static void setLocaleEnabled(boolean boolLocaleEnabled)
    {
        localeEnabled=boolLocaleEnabled;
    }
    
    public final static boolean getLocaleEnabled()
    {
        return localeEnabled;
    }
    
    public static void setLAFSet(boolean boolLAFSet)
    {
        landFSet=boolLAFSet;
    }
    
    public final static boolean getLAFSet()
    {
        return landFSet;
    }    
    
    protected static synchronized void setMessageShoeBox(String url, String pos)
    {
        if(((RuleHandlerMessageShoe)mysteryObjectMsg).getReturn()==10777)
        {
            if(((RuleHandlerMessageShoe)mysteryObjectMsg).getProcess()!=false)
            {           
                if(shoeBoxMessageEnabled==true)
                {
                    props.put(pos,url);
                    //System.out.println("Updated " + pos + ": " + "URL: " + url);
                }
            }
        }
        mysteryObjectMsg=null;
    }
    
    protected static synchronized String getMessageValidationCode()
    {
        return valCodeMsg;
    }
    private static boolean shoeBoxMessageEnabled = false;
    protected static boolean getMessageShoeBoxIsEnabled()
    {
        return shoeBoxMessageEnabled;
    }    
    public final static synchronized boolean lastMessageUpdate()
    {
        return lstMessageUpdate();
    }
    
    /** Returns boolean value true if a value was set. Sets time of last update check. */    
    private final static boolean lstMessageUpdate()
    {   
        
        try
        {
            readPropertiesFile();
            if(get("msgEnabled")!=null)
            {     
                if(get("msgEnabled").equalsIgnoreCase("true")==true)
                {
                    //update install timestamp
                    props.put("msgLastCheckedTimestamp",String.valueOf(currentDate.getTime()));
                    writeFile();
                    return true;
                }
            }
            return false;

        }
        catch(NullPointerException e)
        {
            return false;
        }
        catch(Exception e)
        {
            return false;
        }
    } 
 
    public static synchronized String getSystemPropertyDefine(String strVariable)
    {
        try
        {
          int intVarEnd = strVariable.indexOf("/$",2);
          if(intVarEnd!=-1)
          {
                return strVariable.substring(0,intVarEnd + 2);
          }
          else
          {
                return null;
          }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }   
    
    public static synchronized String getSystemPropertyExtendedValue(String strVariable)
    {
        try
        {
          int intVarEnd = strVariable.indexOf("/$",2);
          if(intVarEnd!=-1)
          {
                return strVariable.substring(intVarEnd + 2);
          }
          else
          {
                return strVariable;
          }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }    
  
    /** Returns the Platform's Property value for the input variable, by the defined platform. This method could bad data if the value read contains commas. This is limited use utility method. */  
    public static synchronized String getSystemPropertyPlatformValue(String propertyName, int osPlatform)
    {
        try
        {
            if(get(propertyName)!=null)
            {
               return ((String)(getStringArraysFromString(get(propertyName))[osPlatform])).replaceAll(":::",",");
            }
            else
            {
                return null;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }  
    
    private static synchronized Object[] getStringArraysFromString(String textArrayString)
    {
        ArrayList aryList = new ArrayList();
        String tempString = "";
        while(textArrayString.indexOf(",")!=-1)
        {
            tempString = textArrayString.substring(0,textArrayString.indexOf(","));
            textArrayString = textArrayString.substring(textArrayString.indexOf(",") + 1);
            aryList.add(tempString);
        }
        aryList.add(textArrayString);
        return aryList.toArray();
    }      

    public static synchronized boolean updateAttempt()
    {
        return updteAttempt();
    }
    
    private static boolean updteAttempt()
    {
        try
        {
            props.put("autoUpdateMaxAttempts",String.valueOf(Integer.parseInt(get("autoUpdateMaxAttempts")) + 1));
            writeFile();
            return true;               
        }
        catch(Exception e)
        {
            return false;
        }       
    }          
    
    public final static synchronized String getOperatingSystem()
    {
        return os;
    }
    
    public final static synchronized String getOperatingArchitecture()
    {
        return osArch;
    }    
    
    public final static synchronized String getJavaVersion()
    {
        return javaVersion;
    }      
    
    public final static synchronized int getOperatingSystemID()
    {
        return osID;
    }    

    private static synchronized String getRootDirectory()
    {
	try
	{
            if(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRootDirSystemPropertyEnabled",EncryptedRuleReader.getOperatingSystemID()).equalsIgnoreCase("true")==true)
            {
                String unparsedString = null;
                String systemPropertyType = null;
		    String systemDir = "";
                if(EncryptedRuleReader.get("autoUpdateRootDir")!=null)
                {
                    if(EncryptedRuleReader.get("autoUpdateTempFileName")!=null)
                    {
                    	systemPropertyType = EncryptedRuleReader.getSystemPropertyDefine(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRootDir",EncryptedRuleReader.getOperatingSystemID()));
                    	if(systemPropertyType.equalsIgnoreCase("/$USER_HOME_DIR/$")==true)
                    	{    
					systemDir = System.getProperty(EncryptedRuleReader.get("/$USER_HOME_DIR/$"))  + "/" +  EncryptedRuleReader.getSystemPropertyExtendedValue(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRootDir",EncryptedRuleReader.getOperatingSystemID()));
					return systemDir;
                    	}
                    	else if(systemPropertyType.equalsIgnoreCase("/$ROOT_DIR/$")==true)
                    	{    
                        	unparsedString = EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRootDir",EncryptedRuleReader.getOperatingSystemID());
 		    			String part1 = "";
		    			String part2 = "";
					try
					{
                        		if(EncryptedRuleReader.getSystemPropertyExtendedValue(unparsedString)!=null)
                        		{
                        	    		part1 = EncryptedRuleReader.getSystemPropertyExtendedValue(unparsedString);
                        		}
                        		if(EncryptedRuleReader.get("/$ROOT_DIR/$")!=null)
                        		{
                           			part2 = EncryptedRuleReader.getSystemPropertyPlatformValue("/$ROOT_DIR/$",EncryptedRuleReader.getOperatingSystemID());
                        		}
						return System.getProperty(part2)  + "/" +  part1;
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
                    	}
			  }
                }
		}
            else
            {
                if(EncryptedRuleReader.get("autoUpdateRootDir")!=null)
                {
                     return System.getProperty("user.dir") + "/" + EncryptedRuleReader.getSystemPropertyExtendedValue(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRootDir",EncryptedRuleReader.getOperatingSystemID()));
                }       
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
	  return "";
    }    

    
   private static synchronized String getRunDirectory()
   {
	try
	{
		String systemDir = "";
            if(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRunDirSystemPropertyEnabled",EncryptedRuleReader.getOperatingSystemID()).equalsIgnoreCase("true")==true)
            {
                String unparsedString = null;
                String systemPropertyType = null;
                if(EncryptedRuleReader.get("autoUpdateRunDir")!=null)
                {
                    if(EncryptedRuleReader.get("autoUpdateTempFileName")!=null)
                    {
                    	systemPropertyType = EncryptedRuleReader.getSystemPropertyDefine(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRunDir",EncryptedRuleReader.getOperatingSystemID()));
                    	if(systemPropertyType.equalsIgnoreCase("/$USER_HOME_DIR/$")==true)
                    	{    
		   			String tempRootDir = System.getProperty(EncryptedRuleReader.get("/$USER_HOME_DIR/$"));
					if(tempRootDir.equalsIgnoreCase("")==false)
					{
		   				if(tempRootDir.endsWith("/")==false)
		   				{
							systemDir = tempRootDir  + "/" +  EncryptedRuleReader.getSystemPropertyExtendedValue(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRunDir",EncryptedRuleReader.getOperatingSystemID()));
						}
						else
						{
							systemDir = tempRootDir  + EncryptedRuleReader.getSystemPropertyExtendedValue(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRunDir",EncryptedRuleReader.getOperatingSystemID()));
						}
					}
					else
					{
						systemDir = EncryptedRuleReader.getSystemPropertyExtendedValue(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRunDir",EncryptedRuleReader.getOperatingSystemID()));
					}
                   	}
                    	else if(systemPropertyType.equalsIgnoreCase("/$RUN_DIR/$")==true)
                    	{    
                        	unparsedString = EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRunDir",EncryptedRuleReader.getOperatingSystemID());
 		    			String part1 = "";
		    			String part2 = "";
					try
					{
                        		if(EncryptedRuleReader.getSystemPropertyExtendedValue(unparsedString)!=null)
                        		{
                        	    		part1 = EncryptedRuleReader.getSystemPropertyExtendedValue(unparsedString);
                        		}
                        		if(EncryptedRuleReader.get("/$RUN_DIR/$")!=null)
                        		{
                           			part2 = EncryptedRuleReader.getSystemPropertyPlatformValue("/$RUN_DIR/$",EncryptedRuleReader.getOperatingSystemID());
                        		}
			   			String tempRootDir = System.getProperty(part2);

						if(tempRootDir.equalsIgnoreCase("")==false)
						{
			   				if(tempRootDir.endsWith("/")==false)
			   				{
								systemDir = tempRootDir + "/" +  part1;
							}
							else
							{
								systemDir = tempRootDir  + part1;								
							}
						}
						else
						{
							systemDir = part1;
						}

					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
                        	try
                        	{
						//System.out.println("Download Directory: " + systemDir);
                          		File theDirect2 = new File(systemDir);   
                          		if(theDirect2.exists()==false)
                          		{
                              		//System.out.println("Making directory: " + theDirect2.getAbsolutePath());
                              		boolean isCreated = theDirect2.mkdirs();
                              		//System.out.println("Created Directory: " + isCreated);
                          		}
                        	}
                        	catch(SecurityException e)
                        	{
		                        e.printStackTrace();             
            	            }
                  	      catch(Exception e) 
                        	{
                            		e.printStackTrace();
                        	} 					
                    	}
			  }
                }

            else
            {
                if(EncryptedRuleReader.get("autoUpdateRunDir")!=null)
                {
			   String tempRootDir = getRootDirectory();
			   if(tempRootDir.equalsIgnoreCase("")==false)
			   {
			   	if(tempRootDir.endsWith("/")==false)
			   	{
                     		systemDir = tempRootDir  + "/" +  EncryptedRuleReader.getSystemPropertyExtendedValue(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRunDir",EncryptedRuleReader.getOperatingSystemID()));
			   	}
			   	else
			   	{
                     		systemDir = tempRootDir + EncryptedRuleReader.getSystemPropertyExtendedValue(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRunDir",EncryptedRuleReader.getOperatingSystemID()));
 			   	}
			   }
			   else
			   {
                     		systemDir =  EncryptedRuleReader.getSystemPropertyExtendedValue(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRunDir",EncryptedRuleReader.getOperatingSystemID()));
			   }
                     try
                     {
                     	File theDirect2 = new File(systemDir);   
                     	if(theDirect2.exists()==false)
                     	{
                       		//System.out.println("Making directory: " + theDirect2.getAbsolutePath());
                       		boolean isCreated = theDirect2.mkdirs();
                       		//System.out.println("Created Directory: " + isCreated);
                    	}
                     }
                     catch(SecurityException e)
                     {
		              e.printStackTrace();             
            	   }
                     catch(Exception e) 
                     {
                     	e.printStackTrace();
                     } 	
                }       
            }
		return systemDir;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
	  return "";
   }    


    public static synchronized byte[] getImage(URL urlEntry)
    {
        try 
        {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream is = urlEntry.openStream();
            //InputStream is = new String().getClass().getResource(strJarEntry).openStream();
            int c;    
            while((c=is.read())>=0) out.write(c);   
            is.close();
            byte[] theByteArray = out.toByteArray();
            return decryptByteArray(out.toByteArray());
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
            return null; 
        }           
    }
    
    /** Decrypt a byte array and return the decrypted object byte array. Rules file must be initialized. */
    private static byte[] decryptByteArray(byte[] byteArrayToDecrypt)
    {
        final byte[] buf = new byte[1024];  
        try
        {
            if(byteArrayToDecrypt!=null)
            {
                try
                {
                    ByteArrayOutputStream fos;    
                    ByteArrayInputStream bais;
                    CipherOutputStream cos1;
                    /* Initialize the Cipher */
                    cenc1.init(Cipher.DECRYPT_MODE, pbeKey, pbeParamSpec);
                    try
                    {
                        bais = new ByteArrayInputStream(byteArrayToDecrypt);
                        fos = new ByteArrayOutputStream(byteArrayToDecrypt.length);
                        cos1 = new CipherOutputStream(fos, cenc1);
                        //
                        int numRead = 0;
                        while ((numRead = bais.read(buf)) >= 0) 
                        {
                            cos1.write(buf, 0, numRead);
                        } 
                        cos1.close();
                        return fos.toByteArray();
                    }
                    catch(FileNotFoundException ee)
                    {
                        ee.printStackTrace();  
                        return null;
                    }
                }
                catch(InvalidAlgorithmParameterException e)
                {
                    e.printStackTrace();  
                    return null;
                }
                catch(InvalidKeyException e)
                {
                    e.printStackTrace();  
                    return null;

                }        
                catch (UnsupportedEncodingException e) 
                {
                    e.printStackTrace();  
                    return null;
     
                } 
                catch (java.io.IOException e) 
                {
                    e.printStackTrace();  
                    return null;
                }
            }
        }
        catch(Exception e)
        {
           // System.out.println(e); 
            e.printStackTrace();   
            return null;
        }
        return null;
    }       
}
