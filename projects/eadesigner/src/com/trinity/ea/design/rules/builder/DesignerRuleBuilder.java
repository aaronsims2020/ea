/*
 * DesignerRuleBuilder.java
 *
 * Created on October 26, 2003, 10:57 PM
 */ 

package com.trinity.ea.design.rules.builder;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.*;
import java.io.*;
//import sun.misc.BASE64Encoder;
//import sun.misc.BASE64Decoder;
import java.util.Date;
import com.trinity.ea.util.EAProperties;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003 Trinity Software. All rights reserved.
 */
public class DesignerRuleBuilder 
{
    private static EAProperties props = new EAProperties();
    private static String strRulesFileName = "lib/designer.eae"; 

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
    /** Creates a new instance of EncryptedRuleBuilder */
    public DesignerRuleBuilder(){}

    /** Write the Properties File. */
    public static boolean writeFile()
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
            //e.printStackTrace();
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
                        //ee.printStackTrace();
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

    /** Read the Properties File */
    public static boolean readPropertiesFile()
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
            //e.printStackTrace();        
        }        
        catch(Exception e)
        {
           // System.out.println(e);
            //e.printStackTrace();        
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
                        //ee.printStackTrace();                        
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
            //e.printStackTrace();   
            return false;
        }
        catch(InvalidKeyException e)
        {
           // System.out.println(e);
            //e.printStackTrace();   
            return false;
        }        
    }    
    
    /** Set the rules filename. */
    public static void setFileName(String strFileName)
    {
        strRulesFileName = strFileName;
    }
    
    /** Return the Rules File filename. Default Rules filename is rules.eax */
    public static String getFileName()
    {
        return strRulesFileName;
    }
    
    public static boolean put(String key, String value)
    {
         try
        {
            readPropertiesFile();
            props.put(key,value);
            writeFile();
            return true;
        }
        catch(Exception e)
        {
           //e.printStackTrace();
            return false;
        }       
    }
    
    public static String get(String key)
    {
        try
        {
            return (String)props.get(key);
        }
        catch(Exception e)
        {
            //e.printStackTrace();
            return null;
        }
    }   
    
    public static boolean remove(String key)
    {
        try
        {
            props.remove(key);
            return true;
        }
        catch(Exception e)
        {
            //e.printStackTrace();
            return false;
        }
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
    

    /** Write the Unecrypted Rules File, as encrypted. */
    public static boolean encryptAndWriteRulesFile()
    {
   
        try
        {
            RuleBuilder.readPropertiesFile();
            props = RuleBuilder.getProperties();
        }
        catch(Exception e)
        {
            
            System.out.println("Write Rules File As Encrypted Failed to Read Unencrypted Rules File: " + e); 
        //e.printStackTrace();
        }
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
            //System.out.println("The encryption key: " + theStr);
           // rh.setConstructCryptFunction(theStr.toCharArray());
         //   System.out.println("The Read and encrypt Properties Props: " + props.toString());           
         //   props.setProperty("67r67e87ychuhu", theStr);
        }
        catch(Exception e)
        {
           // System.out.println(e);
           // e.printStackTrace();
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
          //  System.out.println(e);
            //e.printStackTrace();        
        }        
        catch(Exception e)
        {
           // System.out.println(e);
            //e.printStackTrace();        
        }
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
                        return true;
                    }
                    catch(FileNotFoundException ee)
                    {
                        //System.out.println(ee);
                        //ee.printStackTrace();
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
                        return true;
                    }
                    catch(FileNotFoundException ee)
                    {
                      //  System.out.println(ee);
                        //ee.printStackTrace();
                        return false;
                    }
                }
                else
                {
                    return false;
                }
                
               
            }
        }
        catch(InvalidAlgorithmParameterException e)
        {
           // System.out.println(e);
            //e.printStackTrace();   
            return false;
        }
        catch(InvalidKeyException e)
        {
           // System.out.println(e);
            //e.printStackTrace();   
            return false;
        }        
        catch (UnsupportedEncodingException e) 
        {
          //  System.out.println(e);
            //e.printStackTrace();   
            return false;         
        } 
        catch (java.io.IOException e) 
        {
           // System.out.println(e);
            //e.printStackTrace(); 
            return false;
        }
    }    
    
    public synchronized static String getProjectFileName(String projectURL)
    {  
        return getPrjectFileName(projectURL);
    }
     
    private static String getPrjectFileName(String projectURL)
    {
            if(projectURL!=null)
            {
                    if(projectURL.lastIndexOf("/")!=-1)
                    {
                            return projectURL.substring(projectURL.lastIndexOf("/") + 1);
                    }
                    else
                    {
                            return projectURL;
                    }
            }
            else
            {
                    return null;
            }
    }
    
    public synchronized static String[] getRecentProjectsListWithTempFile()
    {
        if(get("prjRecentProjects")!=null)
        {
            Object[] objArray = getStringArraysFromString(get("prjRecentProjects"));
            int tempLength = objArray.length + 1;
            String[] strArray = new String[objArray.length + 1];
            if(getTempProject()!=null)
            {
                strArray[0]=getTempProject();
                for(int i = 1;i<tempLength;i++)
                {
                    strArray[i] = (String)objArray[i-1];
                }
                return strArray;
            }
            else
            {
                for(int i = 0;i<objArray.length;i++)
                {
                    strArray[i] = (String)objArray[i];
                }
                return strArray;
            }
        }
        else
        {
            String[] theArray = {};
            return theArray;
        }
    }
    
    public synchronized static String[] getRecentProjectsList()
    {
        if(get("prjRecentProjects")!=null)
        {
            Object[] objArray = getStringArraysFromString(get("prjRecentProjects"));
            String[] strArray = new String[objArray.length];
            for(int i = 0;i<objArray.length;i++)
            {
                strArray[i] = (String)objArray[i];
            }
            return strArray; 
        }
        else
        {
            String[] theArray = {};
            return theArray;
        }
    }
    public synchronized static boolean setEnclosedDirProject(String strBool)
    {
        return setEnclsedDirProject(strBool);
    }
    
    private static boolean setEnclsedDirProject(String strBool)
    {
        try
        {
            put("prjDefaultCreateEnclosingFolder",strBool);
            writeFile();
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }    
    
    public synchronized static boolean setTempProject(String urlPath)
    {
        return setTmpProject(urlPath);
    }
    
    private static boolean setTmpProject(String urlPath)
    {
        try
        {
            put("prjTempProject",urlPath);
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
     public synchronized static String getTempProject()
    {
        if(getTmpProject().equalsIgnoreCase("")==true)
        {
            return null;
        }
        return getTmpProject();
    }
    
    private static String getTmpProject()
    {
        try
        {
            if(get("prjTempProject")!=null)
            {
                return get("prjTempProject"); 
            }
            else
            {
                return null;
            }
        }
        catch(Exception e)
        {
            return null;
        }
    }   
    public synchronized static boolean setWorkingProject(String urlPath)
    {    
        return setWrkingProject(urlPath);
    }
    
    private static boolean setWrkingProject(String urlPath)
    {
            props.put("prjTempProject",urlPath);    
            props.put("prjCurrentProject",urlPath); 
            try
            {
                Object[] recentProjectsArray = getStringArraysFromString((String)props.get("prjRecentProjects"));
                if(0<recentProjectsArray.length)
                {
                    if(urlPath.equalsIgnoreCase(((String)recentProjectsArray[0]))==true)
                    {

                    }
                    else
                    {
                        props.put("prjRecentProjects",updateList(urlPath, get("prjRecentProjects"), get("prjDefaultMaxRecentProjects")));
                    }                   
                }
                else
                {
                    props.put("prjRecentProjects",updateList(urlPath, get("prjRecentProjects"), get("prjDefaultMaxRecentProjects")));
                }
                writeFile();
                return true;
            }
            catch(Exception e)
            {
                e.printStackTrace();
                return false;
            }
    }

    public static synchronized boolean removeProjectFromRecentFilesList(String strRecentFileIndex)
    { 
            try
            {
                Object[] recentProjectsArray = getStringArraysFromString((String)props.get("prjRecentProjects"));
                String tempArrayString = "";
                int intRecentFilesIndex = -1;
                for(int i = 0;i<recentProjectsArray.length;i++)
                {       
                   if(((String)recentProjectsArray[i]).equalsIgnoreCase(strRecentFileIndex)==true)
                   {
                       intRecentFilesIndex = i;
                       i = recentProjectsArray.length;
                   }
                }
                for(int i = 0;i<recentProjectsArray.length;i++)
                {
                    if(i!=intRecentFilesIndex)
                    {
                        if(tempArrayString.equalsIgnoreCase("")==false)
                        {
                            tempArrayString = tempArrayString + "," + (String)recentProjectsArray[i];                          
                        }
                        else
                        {
                            tempArrayString = (String)recentProjectsArray[i];
                        }
                    }
                    
                }
                props.put("prjRecentProjects", tempArrayString);
                recentProjectsArray = getStringArraysFromString((String)props.get("prjRecentProjects"));
                if(0<recentProjectsArray.length)
                {
                    props.put("prjTempProject", (String)recentProjectsArray[0]);
                    props.put("prjCurrentProject", (String)recentProjectsArray[0]);                     
                }
                else
                {
                    props.put("prjTempProject",".project.tmp");    
                    props.put("prjCurrentProject","");                    
                }
                writeFile();
                return true;
            }
            catch(Exception e)
            {
                e.printStackTrace();
                return false;
            }
    }    
    
    private synchronized static String updateList(String appendValue, String strArrayList, String strIntMaxValues)
    {
        if(strArrayList!=null)
        {
            if(appendValue!=null)
            {
                if(strIntMaxValues!=null)
                {
                    boolean valueAlreadyExists = false;
                    int indexValue = 0;
                    String theFoundValue = null;
                    Object[] theObjArray = getStringArraysFromString(strArrayList);
                    for(int i = 0;i<theObjArray.length;i++)
                    {
                        if(((String)theObjArray[i]).equalsIgnoreCase(appendValue)==true)
                        {
                            indexValue=i;
                            valueAlreadyExists=true;
                            theFoundValue=(String)theObjArray[i];
                        }
                    }
                    if(valueAlreadyExists==true)
                    {   
                        String[] theStriArray = new String[theObjArray.length - 1];
                        int j = 0;
                        for(int i = 0;i<theObjArray.length;i++)
                        {
                            if(i==indexValue)
                            {
                                  
                            }
                            else
                            {
                                theStriArray[j] = (String)theObjArray[i];
                                j++;
                            }
                        }
                        String[] theFinalArray = new String[theObjArray.length];
                        theFinalArray[0]=theFoundValue;
                        for(int i = 1;i<theFinalArray.length;i++)
                        {
                           theFinalArray[i] = theStriArray[i-1];
                        }
                        return getStringFromArray(theFinalArray);
                    }
                    
                    if(theObjArray.length>=Integer.parseInt(strIntMaxValues))
                    {
                         // remove last value, and add new value
                        Object[] theTransformArray = new Object[Integer.parseInt(strIntMaxValues)];
                        theTransformArray[0] = appendValue;
                        for(int i = 1;i<theTransformArray.length;i++)
                        { 
                            theTransformArray[i]=theObjArray[i-1];
                        }
                        return getStringFromArray(theTransformArray);
                    }
                    else
                    {
                        return appendValue + "," + strArrayList;
                    }
                }
                else
                {
                    return appendValue + "," + strArrayList;           
                }
            }
            else
            {
                if(strIntMaxValues!=null)
                {
                    Object[] theObjArray = getStringArraysFromString(strArrayList);
                    if(theObjArray.length>=Integer.parseInt(strIntMaxValues))
                    {
                        // remove last value, and add new value
                        Object[] theTransformArray = new Object[Integer.parseInt(strIntMaxValues)];
                        for(int i = 0;i<theTransformArray.length;i++)
                        { 
                            theTransformArray[i]=theObjArray[i];
                        }
                        return getStringFromArray(theTransformArray);
                    }
                    else
                    {
                        return strArrayList;
                    }                  
                }
                else
                {
                    return strArrayList;
                }
            }
        }
        else
        {
            if(appendValue!=null)
            {
                return appendValue;
            }
            else
            {
                return "";
            }
        }
    }
    
    private synchronized static String getStringFromArray(Object[] theArray)
    {
        String currentString = null;
        try
        {
            if(theArray.length!=0)
            {
                currentString = (String)theArray[0];
                for(int i = 1;i<theArray.length;i++)
                {
                    try
                    {
                        currentString = currentString + "," + (String)theArray[i];
                    }
                    catch(NullPointerException e)
                    {
                        if(currentString.endsWith(",")==true)
                        {
                            System.out.println("NullPointerException thrown CurrentString is: " + currentString.substring(0,currentString.lastIndexOf(",")));
                            currentString = currentString.substring(0,currentString.lastIndexOf(","));
                        }
                    }
                }
                return currentString;
            }
        }
        catch(Exception e)
        {
            if(currentString!=null)
            {
                if(currentString.endsWith(",")==false)
                {
                    return currentString;
                }
                else
                {
                    System.out.println("Exception thrown CurrentString is: " + currentString.substring(0,currentString.lastIndexOf(",")));
                    return currentString.substring(0,currentString.lastIndexOf(","));
                }
            }
        }
        return "";
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
}
