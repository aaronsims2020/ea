/*
 * Indexer.java
 *
 * Created on January 16, 2005, 3:34 PM
 */
package com.trinity.ea.rules.reader;
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
import com.trinity.ea.rules.reader.IndexHandler;
import com.trinity.ea.util.EAProperties;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2005 Trinity Software. All rights reserved.
 */
public class Indexer 
{
    protected Indexer(){}
    
    protected static Object[] getProductExistsInIndexFile(String vendorName, String productName, String productVersion)
    {
        return getProductExistsInIndexFile(vendorName, productName, productVersion, true);
    }
    
    // private static Object[] getProductExistsInIndexFile(String vendorName, String productName, String productVersion)
    private static Object[] getProductExistsInIndexFile(String vendorName, String productName, String productVersion, boolean filler)
    {
        Object[] theObjArray = new Object[2];
        try
        {       
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
        
            theObjArray[0] = new Boolean(false);
            int intIndexFileExists = getIndexFileExists();
            final File indexFile = new File(new URL(new File(System.getProperty("user.home")).toURL().toString() + "ea.properties").getFile());

            // Read Index file entry, and return if it exists, and the timestamp of the install
            EAProperties props = new EAProperties();
            Cipher cenc1 = null;
            PBEKeySpec pbeKeySpec;
            PBEParameterSpec pbeParamSpec = null;
            SecretKeyFactory keyFac;
            SecretKey pbeKey = null;
            final Date currentDate = new Date(); 
            String strCurrentDate = String.valueOf(currentDate.getTime());
            IndexHandler rh = new IndexHandler();
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
                FileInputStream fis;
                CipherInputStream cis1;

                /* Initialize the Cipher */
                cenc1.init(Cipher.DECRYPT_MODE, pbeKey, pbeParamSpec);

                if(intIndexFileExists==0)
                {
                    try
                    { 
                        fis = new FileInputStream(indexFile);
                        cis1 = new CipherInputStream(fis, cenc1);
                        props.load(cis1);
                        fis.close();
                        cis1.close();
                        try
                        {
                            try
                            { 
                                if(props.get(String.valueOf(hcode))!=null)
                                {
                                   if(((String)props.get(String.valueOf(hcode))).equalsIgnoreCase("")==false)
                                   {
                                       try
                                       {
                                           theObjArray[1] = ((String)props.get(String.valueOf(hcode)));
                                           theObjArray[0] = new Boolean(true);
                                           return theObjArray;
                                       }
                                       catch(Exception e)
                                       {
                                           return theObjArray;
                                       }
                                   }
                                   else
                                   {
                                       if(props.get("#")!=null)
                                       {
                                           if(((String)props.get("#")).indexOf("EvaluateAnywhere")!=-1)
                                           {
                                               try
                                               {
                                                   try
                                                   {
                                                       props.put("#","#ea.properties - EvaluateAnywhere Application Index 1.0 - Copyright 2005, Trinity Software, LLC. All rights reserved.");            
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
                                                theObjArray[0] = new Boolean(true);
                                                theObjArray[1] = strCurrentDate;
                                                return theObjArray; 
                                           }
                                           else
                                           {
                                                return theObjArray;
                                           }
                                       }
                                       else
                                       {
                                            return theObjArray;
                                       }
                                    }
                                }
                                else
                                {
                                   if(props.get("#")!=null)
                                   {
                                       if(((String)props.get("#")).indexOf("EvaluateAnywhere")!=-1)
                                       {                                    
                                           try
                                           {
                                               try
                                               {
                                                   props.put("#","#ea.properties - EvaluateAnywhere Application Index 1.0 - Copyright 2005, Trinity Software, LLC. All rights reserved.");            
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
                                            theObjArray[0] = new Boolean(true);
                                            theObjArray[1] = strCurrentDate;
                                            return theObjArray; 
                                        }
                                       else
                                       {
                                            return theObjArray;
                                       }
                                   }
                                   else
                                   {
                                        return theObjArray;
                                   }                                   
                                }
                             }
                             catch(Exception e)
                             {
                                  return theObjArray;
                             }                            
                        }
                        catch (Exception e) 
                        {
                            //e.printStackTrace();   
                            return theObjArray;
                        }                       
                    }
                    catch(IOException ee)
                    {
                        // ee.printStackTrace();                        
                        return theObjArray;
                    }
                }
                else
                {
/////////////////////////////////////////////////////////////////                    
                     if(intIndexFileExists==1)
                     {
                         try
                         {
                            indexFile.createNewFile();
                         }
                         catch(IOException e)
                         {

                         }
                     }   
                    try
                    { 
                       try
                       {
                           props.put("#","#ea.properties - EvaluateAnywhere Application Index 1.0 - Copyright 2005, Trinity Software, LLC. All rights reserved.");            
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
                        theObjArray[0] = new Boolean(true);
                        theObjArray[1] = strCurrentDate;
                        return theObjArray; 
                     }
                     catch(Exception e)
                     {
                          return theObjArray;
                     }                            
                }
            }
            catch(InvalidAlgorithmParameterException e)
            {
                // e.printStackTrace();   
                return theObjArray;
            }
            catch(InvalidKeyException e)
            {
                // e.printStackTrace();   
                return theObjArray;
            }                          
        }
        catch(Exception e)
        {
            //e.printStackTrace();
            return theObjArray;
        }
    }    
    
    protected static int getIndexFileExists()
    {
        return getIndexFileExists("(;The Index Public Key;)");
    }
    
    private static int getIndexFileExists(String publicKey)
    {
        try
        {
            final File indexFile = new File(new URL(new File(System.getProperty("user.home")).toURL().toString() + "ea.properties").getFile());
            if(indexFile.exists()==true)
            {
                return 0;
            }
            return 1;
        }
        catch(SecurityException e)
        {
            //e.printStackTrace();
            return 5;
        }
        catch(Exception e)
        {
            //e.printStackTrace();
            return 7;
        }
    }

    private static int writeIndexFile()
    {
        try
        {
            File indexFile = new File(new URL(new File(System.getProperty("user.home")).toURL().toString() + "ea.properties").getFile());
            if(indexFile.exists()==true)
            {
                //append to file, or read file
            }
            else
            {
                try
                {
                    indexFile.createNewFile();
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                    return 6;                    
                }
            }
            FileOutputStream fos = new FileOutputStream(indexFile);
            return 0;
        }
        catch(SecurityException e)
        {
            e.printStackTrace();
            return 5;
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();
            return 2;
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
            return 4;
        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();     
            return 1;
        }
   /*     catch(IOException e)
        {
            e.printStackTrace();  
            return 6;
        }*/
        catch(Exception e)
        {
            e.printStackTrace();
            return 7;
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
