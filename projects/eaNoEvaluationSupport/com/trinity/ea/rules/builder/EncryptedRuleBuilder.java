/*
 * EncryptedRuleBuilder.java
 *
 * Created on October 26, 2003, 10:57 PM
 */

package com.trinity.ea.rules.builder;
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
public class EncryptedRuleBuilder 
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
    /** Creates a new instance of EncryptedRuleBuilder */
    public EncryptedRuleBuilder(){}

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
    
    /** Write the Unecrypted Rules File, as encrypted. */
    public static boolean encryptAndWriteRulesFile(File rulesFile, HashMap rulesProperties)
    {
   
        try
        {
            if(rulesProperties!=null && rulesFile!=null)
            {
                Set theSet = rulesProperties.keySet();
                Object[] objArray1 = theSet.toArray();
                EAProperties eaProps = new EAProperties();
                for(int i = 0;i<objArray1.length;i++)
                {
                    try
                    {
                        if(objArray1[i]!=null)
                        {
                            if(((String)objArray1[i]).equalsIgnoreCase("")==false)
                            {
                                eaProps.put((String)objArray1[i],rulesProperties.get((String)objArray1[i]));
                            }
                        }
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                props = eaProps;
            }
            else
            {
                if(rulesProperties!=null)
                {
                    System.out.println("Rules File is set to null, please set a valid File Path to generate the rules file.");                   
                }
                else
                {
                    System.out.println("Project Properties are set to null, please set a valid EAProperties object to generate the rules file.");                    
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Could not Read Project Properties: " + e); 
            //e.printStackTrace();
        }
        
        try
        {
            EncryptedRuleBuilder.setFileName(rulesFile.getAbsolutePath());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }        
        
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
}
