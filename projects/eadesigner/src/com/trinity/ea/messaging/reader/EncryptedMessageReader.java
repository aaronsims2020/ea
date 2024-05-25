/*
 * EncryptedMessageReader.java
 *
 * Created on February 26, 2:39 PM
 */

package com.trinity.ea.messaging.reader;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.*;
import java.io.*;
import java.util.Date;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import com.trinity.ea.util.EAProperties;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.jar.JarInputStream;
import java.util.jar.JarEntry;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import com.trinity.ea.rules.reader.RuleEvaluator;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2005 Trinity Software. All rights reserved.
 */
public class EncryptedMessageReader 
{
    private static EAProperties props = new EAProperties();
    private static Cipher cenc1;
    private static Provider sunJce;
    private static PBEKeySpec pbeKeySpec;
    private static PBEParameterSpec pbeParamSpec;
    private static SecretKeyFactory keyFac;
    private static SecretKey pbeKey;
    final private static Date currentDate = new Date();    
    private static MessageHandler rh = new MessageHandler();
    private static byte[] salt = {(byte)0x36, (byte)0xae, (byte)0x4c, (byte)0xe4,(byte)0xd7, (byte)0x11, (byte)0xab, (byte)0xb2};
    private static int count = 947;
    private static Integer tempInt = new Integer(0);
    /** Creates a new instance of EncryptedMessageReader */
    public EncryptedMessageReader(){}

    public static synchronized int readMessage(String strUrl, String strJarURL, boolean verifyJarEnabled, String x500Principal)
    {
        Provider sunJce = new com.sun.crypto.provider.SunJCE();  
        Security.addProvider(sunJce);
        try
        {
            // Create PBE parameter set
            try
            {
                count = tempInt.parseInt(EncryptedRuleReader.get("msgPwdCount"));
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
            ByteArrayInputStream bais;
            JarInputStream jis;
            ByteArrayOutputStream esc;
            InputStream messageReceiver;
            URLConnection theMessageConn;
            URL theMessageURL;
            
            /* Initialize the Cipher */
            cenc1.init(Cipher.DECRYPT_MODE, pbeKey, pbeParamSpec);
            try
            {            
                theMessageURL = new URL(strUrl);
                //System.out.println("Attempting Connection");
                theMessageConn = theMessageURL.openConnection();
                //System.out.println("Opened Connection");
                messageReceiver = theMessageConn.getInputStream();

                esc = new ByteArrayOutputStream();
                int theChar = 0;
                try
                {
                    jis = new JarInputStream(messageReceiver, verifyJarEnabled);
                    JarEntry je=null;
                    JarEntry je2=null;                    
                    int b=0;
                    while ((je=jis.getNextJarEntry())!=null) 
                    {
                        if (!je.isDirectory()) 
                        {
                            je2 = je;
                        }                        
                        if(je.getName().indexOf(strJarURL)!=-1)
                        {
                            while ((b=jis.read())!=-1) 
                            {
                                 esc.write(b);
                            }
                        }
                    } 
                    if(verifyJarEnabled==true)
                    {
                        if(x500Principal!=null)
                        {
                            if(x500Principal.equalsIgnoreCase("")==false)
                            {
                                if(je2!=null)
                                {
                                Certificate[] certs = null;
					  if(RuleEvaluator.currentJavaVersionIsGreaterOrEqual("1.5")==true)
					  {
						ArrayList masterCertArrayList = new ArrayList();
						java.security.CodeSigner[] cs = je2.getCodeSigners();
						for(int i = 0;i<cs.length;i++)
						{
							java.security.cert.CertPath cp = cs[i].getSignerCertPath();
							Object[] certArray = cp.getCertificates().toArray();
							for(int j = 0;j<certArray.length;j++)
							{
								masterCertArrayList.add((Certificate)certArray[j]);
							}
						}
						masterCertArrayList.trimToSize();
						Object[] certArray1 = masterCertArrayList.toArray();
						certs = new Certificate[certArray1.length];
						for(int i = 0;i<certArray1.length;i++)
						{
							certs[i] = (Certificate)certArray1[i];
						}
					  }
					  else
					  {
                                	certs = je2.getCertificates(); 
					  }   
                                    if(getVerifyX500Principal(x500Principal, certs)==false)
                                    {
                                        return 5;
                                    }
                                }
                                else
                                {
                                    return 5;
                                }
	  			    }
				    else
				    {
				        return 5;
				    }
                        }
			      else
			      {
				    return 5;
			      }
                    }                    
                }
                catch(SecurityException e)
                {
                    return 5;
                }
                catch(Exception e) 
                {
                    //e.printStackTrace();    
                    return 7;
                }  
                bais = new ByteArrayInputStream(esc.toByteArray());
                esc.close();
                messageReceiver.close();
                //System.out.println("Getting the Message Input Stream.");
                //fis = new FileInputStream(propFile);
                cis1 = new CipherInputStream(bais, cenc1);
                //System.out.println("Decrypted Message File.");
                //System.out.println("Loading Properties File Document.");
                props.load(cis1);
                //System.out.println("Loaded Properties File Document.");                        
                bais.close();
                cis1.close();
                return 0;
            }
            catch(MalformedURLException e)
            {
                //e.printStackTrace();
                return 1;
            }
            catch(UnknownHostException e)
            {
                //Called when the Host cannot be found, or the connection is unplugged.
                //e.printStackTrace();
                return 2;
            }
            catch(UnknownServiceException e)
            {
                //e.printStackTrace();            
                return 3;
            }
            catch(FileNotFoundException e)
            {
                //e.printStackTrace();                
                return 4;
            }
            catch(SecurityException e)
            {
                //e.printStackTrace();                    
                return 5;
            }                   
            catch(IOException ee)
            {
               // ee.printStackTrace();                        
                return 6;
            }
            catch(Exception e) 
            {
                //e.printStackTrace();                    
                return 7;
                //e.printStackTrace();
            }                   
        }
        catch(InvalidAlgorithmParameterException e)
        {
           // System.out.println(e);
            e.printStackTrace();   
            return 8;
        }
        catch(InvalidKeyException e)
        {
           // System.out.println(e);
            e.printStackTrace();   
            return 9;
        }        
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
     
    private static boolean getVerifyX500Principal(String x500Principal, Certificate[] certs)
    {
       try 
       {
           if(x500Principal!=null)
           {
              if(certs != null)
              {
                 for(int i = 0; i < certs.length; i++)
                 {
                    if(((X509Certificate)certs[i]).getSubjectX500Principal().toString().equalsIgnoreCase(x500Principal)==true)
                    {
                        return true;
                    }
                 }
                 return false;
              }
              else
              {
                 return false;
              }
           }
       } 
       catch (Exception e) 
       {
           return false;
       }     
       return false;
    }         
}
