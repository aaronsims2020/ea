/*
 * EncryptedProjectFile.java
 *
 * Created on March 19th, 2004 2:21PM
 */

package com.trinity.ea.design.common.file;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import com.trinity.ea.util.EAProperties;
import java.security.*;
import javax.crypto.*; 
import javax.crypto.spec.*;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2005 Trinity Software. All rights reserved.
 */
public class EncryptedProjectFile 
{
    private EAProperties props = new EAProperties();
    private String strRulesFileName = "My_Product.eax"; 
    File propFile = null;
    private Cipher cenc1;
    private Provider sunJce;
    private PBEKeySpec pbeKeySpec;
    private PBEParameterSpec pbeParamSpec;
    private SecretKeyFactory keyFac;
    private SecretKey pbeKey;
    private ProjectHandler rh = new ProjectHandler();
    final private byte[] salt = {(byte)0x34, (byte)0xae, (byte)0x4c, (byte)0xe4,(byte)0xd7, (byte)0x11, (byte)0xab, (byte)0xb2};
    final private int count = 856;    

    // Creates a new instance of EncryptedProjectFile 
    public EncryptedProjectFile(String strFileURL)
    {
        strRulesFileName=strFileURL;
        try
        {
            propFile = new File(new URL(getFileName()).getFile());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
   
    // Write the Project File.
    public boolean saveProject()
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
            return false;
        }        
        catch(Exception e)
        {
          //  System.out.println(e);
          //  e.printStackTrace();
            return false;
        }
        // Specify IV.
        try
        {
            FileOutputStream fos;            
            CipherOutputStream cos1;
            /* Initialize the Cipher */
            cenc1.init(Cipher.ENCRYPT_MODE, pbeKey, pbeParamSpec);
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
                       // System.out.println(ee);
                      //  ee.printStackTrace();
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
                    return false;
                }
            }
        }
        catch(InvalidAlgorithmParameterException e)
        {
            //System.out.println(e);
            //e.printStackTrace();  
            return false;
        }
        catch(InvalidKeyException e)
        {
            //System.out.println(e);
            //e.printStackTrace(); 
            return false;
        }        
        catch (java.io.IOException e) 
        {
            //System.out.println(e);
            //e.printStackTrace();   
            return false;
        }        
    }

    // Read the Project File 
    public boolean openProject()
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
    
    // Set the rules filename. 
    public void setFileName(String strFileName)
    {
        strRulesFileName = strFileName;
    }
    
    // Return the Project File filename. Default filename is My_Product.eax 
    public String getFileName()
    {
        return strRulesFileName;
    }
    
    public boolean put(String key, String value)
    {
         try
        {
            props.put(key,value);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }       
    }
    
    public String get(String key)
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
    
    public boolean remove(String key)
    {
        try
        {
            props.remove(key);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }    
    
    public void setProperties(EAProperties theEAProperties)
    {
        props=theEAProperties;
    }   
    
    public EAProperties getProperties()
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
 }
