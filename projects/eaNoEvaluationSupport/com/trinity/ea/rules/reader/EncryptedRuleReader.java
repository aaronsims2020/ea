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
import com.trinity.ea.util.EAProperties;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2003 Trinity Software. All rights reserved.
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
    
    /** Creates a new instance of EncryptedRuleBuilder */
    public EncryptedRuleReader(){}

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
            else
            {
                if(EncryptedRuleReader.get("lockDownAction")!=null)
                {
                    try
                    {
                        //dispose();
                        Class.forName(get("lockDownAction")).newInstance();
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
                            //dispose();
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
                        //dispose();
                        Class.forName(get("paymentLockDownAction")).newInstance();
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
    
    /** Returns boolean value true if a new Trial was instanciated. Starts a new Trial period if a Trial period has not been set, and if start Internal Trials option is set to true, otherwise will not start a new Trial. */    
    private final static boolean strtTrial()
    {   
        
        try
        {
            readPropertiesFile();
            if(get("allowInternalStartTrialInstanciation").equalsIgnoreCase("true"))
            {
                if(get("runtimeMillasecondsStartTrial")!=null)
                {
                    if(get("runtimeMillasecondsStartTrial").equalsIgnoreCase("")==true)
                    {
                        //update install timestamp
                        props.put("runtimeMillasecondsStartTrial",String.valueOf(currentDate.getTime()));
                        writeFile();
                        return true;
                    }
                    return false;
                }
                else
                {
                        //update install timestamp
                        props.put("runtimeMillasecondsStartTrial",String.valueOf(currentDate.getTime()));
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
                    System.out.println("Updated " + pos + ": " + "URL: " + url);
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
    
    protected static synchronized void setMessageShoeBox(String url, String pos)
    {
        if(((RuleHandlerMessageShoe)mysteryObjectMsg).getReturn()==10777)
        {
            if(((RuleHandlerMessageShoe)mysteryObjectMsg).getProcess()!=false)
            {           
                if(shoeBoxMessageEnabled==true)
                {
                    props.put(pos,url);
                    System.out.println("Updated " + pos + ": " + "URL: " + url);
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
}
