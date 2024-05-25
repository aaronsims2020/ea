/*
 * StartTrial.java
 *
 * Created on October 24, 2003, 6:23 PM
 */

package com.trinity.ea.rules.reader;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.Date;
import com.trinity.ea.util.EAProperties;

/**
 *
 * @author  aaronsc Trinity Software, LLC
 * Copyright ©2003-2005 Trinity Software, LLC. All rights reserved.
 */
public class StartTrial 
{
    //Call StartTrial() once to start eval. should be called by SetUp installer.
    //otherwise, customers can simply delete the log file, to restart their evaluation.
    /** Initialize the EvaluateAnywhere evaluation with a signature to the rules.eae file, located in the application root folder. */
    public static boolean initializeTrialByFile(String pathname)
    {
        try
        {
            return setInitializeTrialByURL(new File(pathname).toURL().toString());
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    public static boolean setInitializeTrialByURL(String strRulesFileURL)
    {   
        try
        {
            return setInitTrialByURL(strRulesFileURL);
        }
        catch(Exception e)
        {
            return false;
        }        
    }
    
    private static boolean setInitTrialByURL(String strRulesFileURL)
    {
        EAProperties props = new EAProperties();
        Cipher cenc1 = null;
        PBEKeySpec pbeKeySpec;
        PBEParameterSpec pbeParamSpec = null;
        SecretKeyFactory keyFac;
        SecretKey pbeKey = null;
        final Date currentDate = new Date(); 
        String strCurrentDate = "0";
        RuleHandler rh = new RuleHandler();
        byte[] salt = {(byte)0x34, (byte)0xae, (byte)0x4c, (byte)0xe4,(byte)0xd7, (byte)0x11, (byte)0xab, (byte)0xb2};
        int count = 947;       
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
           // e.printStackTrace();        
        }        
        catch(Exception e)
        {
           /// e.printStackTrace();        
        }
        try
        {
             strCurrentDate = String.valueOf(currentDate.getTime());           
        }
        catch(Exception e)
        {
            
        }
        try
        {
            FileInputStream fis;
            CipherInputStream cis1;
            cenc1.init(Cipher.DECRYPT_MODE, pbeKey, pbeParamSpec);
            
            File propFile = new File(new URL(strRulesFileURL).getFile());
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
                            try
                            {
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
                             }
                             catch(Exception e)
                             {
                                e.printStackTrace();   
                             }                            
                            
                            FileOutputStream fos;            
                            CipherOutputStream cos1;
                            /* Initialize the Cipher */
                            cenc1.init(Cipher.ENCRYPT_MODE, pbeKey, pbeParamSpec);
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
                                //ee.printStackTrace();
                                return false;
                            }
                        }
                        catch(InvalidAlgorithmParameterException e)
                        {
                            //e.printStackTrace();  
                            return false;
                        }
                        catch(InvalidKeyException e)
                        {
                            //e.printStackTrace(); 
                            return false;
                        }        
                        catch (UnsupportedEncodingException e) 
                        {
                            //e.printStackTrace();  
                            return false;         
                        } 
                        catch (java.io.IOException e) 
                        {
                            //e.printStackTrace();   
                            return false;
                        }                       
                    }
                    catch(IOException ee)
                    {
                        // ee.printStackTrace();                        
                        return false;
                    }
            }
            else
            {
                 return false;
            }
        }
        catch(MalformedURLException e)
        {
            // e.printStackTrace();   
            return false;
        }        
        catch(InvalidAlgorithmParameterException e)
        {
            // e.printStackTrace();   
            return false;
        }
        catch(InvalidKeyException e)
        {
            // e.printStackTrace();   
            return false;
        }               
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
