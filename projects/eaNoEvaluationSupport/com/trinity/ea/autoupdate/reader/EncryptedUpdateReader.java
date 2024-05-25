/*
 * EncryptedUpdateReader.java
 *
 * Created on January 14, 2004, 2:39 PM
 */

package com.trinity.ea.autoupdate.reader;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.*;
import java.io.*;
import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;
import java.util.Date;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import com.trinity.ea.util.EAProperties;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2003-2004 Trinity Software. All rights reserved.
 */
public class EncryptedUpdateReader 
{
    private static EAProperties props = new EAProperties();
    private static String strRulesFileName = "update.eal"; 

    private static Cipher cenc1;
    private static Provider sunJce;
    private static PBEKeySpec pbeKeySpec;
    private static PBEParameterSpec pbeParamSpec;
    private static SecretKeyFactory keyFac;
    private static SecretKey pbeKey;
    final private static Date currentDate = new Date();    
    private static UpdateHandler rh = new UpdateHandler();
    private static byte[] salt = {(byte)0x34, (byte)0xae, (byte)0x4c, (byte)0xe4,(byte)0xd7, (byte)0x11, (byte)0xab, (byte)0xb2};
    private static int count = 947;
    private static Integer tempInt = new Integer(0);
    /** Creates a new instance of EncryptedUpdateReader */
    public EncryptedUpdateReader(){}


    /** Read the Properties File */
    private static synchronized boolean readUpdteFile()
    {
        Provider sunJce = new com.sun.crypto.provider.SunJCE(); 
        Security.addProvider(sunJce);
        try
        {
            // Create PBE parameter set
            try
            {
                count = tempInt.parseInt(EncryptedRuleReader.get("autoUpdatePwdCount"));
            }
            catch(NumberFormatException eee)
            {
            }
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
    
    /* Read Temporary Properties File */
    public static synchronized boolean readTempUpdateFile()
    {
        if(EncryptedRuleReader.get("autoUpdateDownloadDir")!=null)
        {
            if(EncryptedRuleReader.get("autoUpdateTempFileName")!=null)
            {
                strRulesFileName = EncryptedRuleReader.get("autoUpdateDownloadDir") + "/" + EncryptedRuleReader.get("autoUpdateTempFileName");
            }       
        }
        return readUpdteFile();
    }
    
     /* Read Properties File */
    public static synchronized boolean readUpdateFile()
    {
        if(EncryptedRuleReader.get("autoUpdateWorkDir")!=null)
        {        
            if(EncryptedRuleReader.get("autoUpdateFileName")!=null)
            {
                strRulesFileName = EncryptedRuleReader.get("autoUpdateWorkDir") + "/" + EncryptedRuleReader.get("autoUpdateFileName");
            }
        }
        return readUpdteFile(); 
    }   
   /** Write the Properties File. */
    private static synchronized boolean writeFile()
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
            readUpdteFile();
            return false;
        }        
        catch(Exception e)
        {
          //  System.out.println(e);
          //  e.printStackTrace();
            readUpdteFile();
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
                        fos.flush();
                        cos1.flush();
                        fos.close();
                        cos1.close();
                        readUpdteFile();
                        return true;
                    }
                    catch(FileNotFoundException ee)
                    {
                       // System.out.println(ee);
                      //  ee.printStackTrace();
                        readUpdteFile();
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
                        fos.flush();
                        cos1.flush();
                        fos.close();
                        cos1.close();
                        propFile.setLastModified(currentDate.getTime());
                        readUpdteFile();
                        return true;
                    }
                    catch(FileNotFoundException ee)
                    {
                        //System.out.println(ee);
                        //ee.printStackTrace();
                        readUpdteFile();
                        return false;
                    }
                }
                else
                {
                    readUpdteFile();
                    return false;
                }
                
               
            }
        }
        catch(InvalidAlgorithmParameterException e)
        {
            //System.out.println(e);
            //e.printStackTrace();  
            readUpdteFile();
            return false;
        }
        catch(InvalidKeyException e)
        {
            //System.out.println(e);
            //e.printStackTrace(); 
            readUpdteFile();
            return false;
        }        
        catch (UnsupportedEncodingException e) 
        {
            //System.out.println(e);
            //e.printStackTrace();  
            readUpdteFile();
            return false;         
        } 
        catch (java.io.IOException e) 
        {
            //System.out.println(e);
            //e.printStackTrace();   
            readUpdteFile();
            return false;
        }
    }   
    
    /** Return the Update File filename. Default Update filename is update.eau
     * @return
     */
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
 
    private static synchronized EAProperties getProperties()
    {
        return props;
    }   
    
    public static synchronized boolean downloadedFileList(String strDLFile)
    {
        return dwldFileList(strDLFile);
    }
    
    private static synchronized boolean dwldFileList(String strDLFile)
    {
         try
        {
            readUpdateFile();
            if(get("files")!=null)
            {
                 {               
                        if(props.get("dldFiles")!=null)
                        {
                            props.put("dldFiles",(String)props.get("dldFiles") + "," + strDLFile);
                            writeFile();
                            return true;                            
                        }
                        else
                        {
                            props.put("dldFiles",strDLFile);
                            writeFile();
                            return true;
                        }
                }
            }
        }
        catch(Exception e)
        {
            return false;
        }       
         return false;
    }    
    
    private static synchronized char[] getRealString(char[] theString)
    {
        char[] theArray = new char[theString.length];
        for(int i = 0;i<theString.length;i++)
        {
            char tempChar = theString[i];
            theArray[i] = (char)((int)tempChar-2);
        }
        return theArray;
    }
    public static synchronized void getDownloadedFilesReset()
    {
        try
        {
            props.remove("dldFiles");
        }
        catch(Exception e)
        {
            
        }
    }
    
    public static synchronized void setUpdateVC()
    {
        setUpdteVC();
    }
    private static void setUpdteVC()
    {
        try
        {
            props.remove("validationCode");
            writeFile();
        }
        catch(Exception e){}        
    }
}
