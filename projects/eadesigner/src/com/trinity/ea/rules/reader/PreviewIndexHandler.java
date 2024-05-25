/*
 * PreviewIndexHandler.java
 *
 * Created on January 19, 2005, 2:30 AM
 */

package com.trinity.ea.rules.reader;
import com.trinity.ea.design.common.file.ProjectManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.net.URL;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.security.*;
import javax.crypto.*; 
import javax.crypto.spec.*;
import java.util.Date;
import com.trinity.ea.util.EAProperties;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2005 Trinity Software. All rights reserved.
 */
public class PreviewIndexHandler 
{
    public static void reset()
    {
        try
        {   
            String vendorName = ProjectManager.get("product_vendor_name");
            String productName = ProjectManager.get("product_name");
            String productVersion = ProjectManager.get("product_version");
            PreviewTestIndexHandler ih = new PreviewTestIndexHandler();
            char[] vnamehcode = vendorName.toCharArray();
            long vnamelong = 0;
            char[] pnamehcode = productName.toCharArray();
            long pnamelong = 0;
            char[] pverhcode = productVersion.toCharArray();
            long pverlong = 0;
            int hcode = 0;
            for(int i = 0;i<vnamehcode.length;i++)
            {
                vnamelong = vnamelong + new Integer((int)vnamehcode[i]).longValue();
            }
            for(int i = 0;i<pnamehcode.length;i++)
            {
                pnamelong = pnamelong + new Integer((int)pnamehcode[i]).longValue();            
            } 
            for(int i = 0;i<pverhcode.length;i++)
            {
                pverlong = pverlong + new Integer((int)pverhcode[i]).longValue();            
            }
            hcode = new Long(vnamelong + pnamelong + pverlong).hashCode();
        
            final File indexFile = new File(new URL(new File(System.getProperty("user.home")).toURL().toString() + "ea.properties").getFile());
            try
            {
            if(indexFile.exists()==true)
            {
                // Read Index file entry, and return if it exists, and the timestamp of the install
                EAProperties props = new EAProperties();
                Cipher cenc1 = null;
                PBEKeySpec pbeKeySpec;
                PBEParameterSpec pbeParamSpec = null;
                SecretKeyFactory keyFac;
                SecretKey pbeKey = null;
                final Date currentDate = new Date(); 
                String strCurrentDate = String.valueOf(currentDate.getTime());
                byte[] salt = {(byte)0x34, (byte)0xae, (byte)0x4c, (byte)0xe4,(byte)0xd7, (byte)0x11, (byte)0xab, (byte)0xb2};
                int count = 947;      
                Provider sunJce = new com.sun.crypto.provider.SunJCE(); 
                Security.addProvider(sunJce);
                try
                {
                    // Create PBE parameter set
                    pbeParamSpec = new PBEParameterSpec(salt, count);
                    pbeKeySpec = new PBEKeySpec(getRealString(ih.getSeed()),salt,count);
                    keyFac = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
                    pbeKey = keyFac.generateSecret(pbeKeySpec);
                    cenc1=Cipher.getInstance("PBEWithMD5AndDES");
                }
                catch(NullPointerException e)
                {
                   // e.printStackTrace();        
                }        
                catch(Exception e)
                {
                   /// e.printStackTrace();        
                }
                    FileInputStream fis;
                    CipherInputStream cis1;

                    /* Initialize the Cipher */
                    cenc1.init(Cipher.DECRYPT_MODE, pbeKey, pbeParamSpec);
                    try
                    { 
                        fis = new FileInputStream(indexFile);
                        cis1 = new CipherInputStream(fis, cenc1);
                        props.load(cis1);
                        fis.close();
                        cis1.close();

                    }
                    catch(Exception e)
                    {}
                    if(props.get(String.valueOf(hcode))!=null)
                    {
                       if(((String)props.get(String.valueOf(hcode))).equalsIgnoreCase("")==false)
                       {      
                               if(props.get("#")!=null)
                               {
                                   if(((String)props.get("#")).indexOf("EvaluateAnywhere")!=-1)
                                   {
                                       try
                                       {
                                           try
                                           {
                                               props.put(String.valueOf(hcode),strCurrentDate);
                                           }
                                           catch(Exception e)
                                           {
                                               e.printStackTrace();   
                                           }                                 
                                            FileOutputStream fos;            
                                            CipherOutputStream cos1;
                                            cenc1.init(Cipher.ENCRYPT_MODE, pbeKey, pbeParamSpec);
                                            try
                                            {
                                                fos = new FileOutputStream(indexFile,false);
                                                cos1 = new CipherOutputStream(fos, cenc1);
                                                props.store(cos1);
                                                fos.close();
                                                cos1.close();
                                            }
                                            catch(FileNotFoundException ee)
                                            {
                                               // System.out.println(ee);
                                                //ee.printStackTrace();
                                            }
                                        }
                                        catch(InvalidAlgorithmParameterException e)
                                        {
                                            //e.printStackTrace();  
                                        }
                                        catch(InvalidKeyException e)
                                        {
                                            //e.printStackTrace(); 
                                        }        
                                        catch (UnsupportedEncodingException e) 
                                        {
                                            //e.printStackTrace();  
                                        } 
                                        catch (java.io.IOException e) 
                                        {
                                            //e.printStackTrace();   
                                        }        
                                   }
                               }
                            }
                        }
                }

            }
             catch(Exception e)
                {}
        }
        catch(Exception e)
        {}
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
