/*
 * FileDownloader.java
 *
 * Created on January 2, 2004, 5:29 PM
 */

package com.trinity.ea.net;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.jar.JarInputStream;
import java.util.jar.JarEntry;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;
import com.trinity.ea.rules.reader.RuleEvaluator;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004-2005 Trinity Software. All rights reserved.
 */
public class FileDownloader
{
    public FileDownloader() 
    {
    }
    public static int downloadFile(String strUrl, String directory) 
    {
        try 
        {
            URL theUrl = new URL(strUrl);
            //System.out.println("Attempting Connection");
            URLConnection  theConn = theUrl.openConnection();
            //System.out.println("Opened Connection");
            InputStream    receiver = theConn.getInputStream();
            //System.out.println("Getting the Input Stream, and checking if the File exists on the Hard Drive");
            String tempFileName=null;
            
            if(theUrl.getFile().indexOf("/")!=-1)
            {
                tempFileName=theUrl.getFile();
                tempFileName=tempFileName.substring(theUrl.getFile().lastIndexOf("/") + 1);
                //System.out.println("Temporary File Name: " + tempFileName);
            }
            else
            {
                 tempFileName=theUrl.getFile();
                 //System.out.println("Temporary File Name: " + tempFileName);                
            }
            try
            {
              File theDirectory = new File(directory);   
              if(theDirectory.exists()==false)
              {
                  //System.out.println("Making directory: " + theDirectory.getAbsolutePath());
                  boolean isCreated = theDirectory.mkdirs();
                  //System.out.println("Created Directory: " + isCreated);
              }
            }
            catch(SecurityException e)
            {
                return 5;                  
              //e.printStackTrace();             
            }
            catch(Exception e) 
            {
                return 7;                  
                //e.printStackTrace();
            }
            File dlFile = new File(directory + System.getProperty("file.separator") + tempFileName);
            if(dlFile.exists()==true)
            {
                //System.out.println("File exists deleting file: " + tempFileName);
                dlFile.delete();
                //System.out.println("Deleted file.");    
                //System.out.println("Creating new file... ");
                dlFile.createNewFile();   
                //System.out.println("Created new file... " + dlFile.getPath());                
            }
            else
            {
                //System.out.println("Creating new file... ");
                dlFile.createNewFile();   
                //System.out.println("Created new file... " + dlFile.getPath());                
            }
            FileOutputStream esc = new FileOutputStream(dlFile);
            int         theChar = 0;
            while((theChar = receiver.read()) > -1) 
            {
                esc.write(theChar);
            }
            //System.out.println("Closing File Stream");
            esc.close();
            receiver.close();
        } 
        catch(MalformedURLException e)
        {
            //e.printStackTrace();
            return 1;
        }
        catch(UnknownHostException e)
        {
            // Called when the Host cannot be found, or the connection is unplugged.
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
        catch(IOException e)
        {
            //e.printStackTrace();    
            return 6;
        }
        
        catch(Exception e) 
        {
            //e.printStackTrace();    
            return 7;
        }
        //System.out.println("Completed Transfer.");
        return 0;
    }
    
    public static int downloadMessageFile(String strUrl, String directory, String strJarURL, boolean verifyJarEnabled, String x500Principal) 
    {
        try 
        {
            URL theUrl = new URL(strUrl);
            //System.out.println("Attempting Connection");
            URLConnection  theConn = theUrl.openConnection();
            //System.out.println("Opened Connection");
            InputStream receiver = theConn.getInputStream();

            //System.out.println("Getting the Input Stream, and checking if the File exists on the Hard Drive");
            String tempFileName=strJarURL;

            try
            {
              File theDirectory = new File(directory);   
              if(theDirectory.exists()==false)
              {
                  //System.out.println("Making directory: " + theDirectory.getAbsolutePath());
                  boolean isCreated = theDirectory.mkdirs();
                  //System.out.println("Created Directory: " + isCreated);
              }
            }
            catch(SecurityException e)
            {
                return 5;                  
              //e.printStackTrace();             
            }
            catch(Exception e) 
            {
                e.printStackTrace();
                return 7;                  
            }
            File dlFile = new File(directory + System.getProperty("file.separator") + tempFileName);
            if(dlFile.exists()==true)
            {
                //System.out.println("File exists deleting file: " + tempFileName);
                dlFile.delete();
                //System.out.println("Deleted file.");    
                //System.out.println("Creating new file... ");
                dlFile.createNewFile();   
                //System.out.println("Created new file... " + dlFile.getPath());                
            }
            else
            {
                //System.out.println("Creating new file... ");
                dlFile.createNewFile();   
                //System.out.println("Created new file... " + dlFile.getPath());                
            }
            FileOutputStream esc = new FileOutputStream(dlFile);
            int theChar = 0;
            try
            {
                JarInputStream jis = new JarInputStream(receiver, verifyJarEnabled);
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
                e.printStackTrace();    
                return 7;
            }  
            esc.close();
            receiver.close();
        } 
        catch(MalformedURLException e)
        {
            //e.printStackTrace();
            return 1;
        }
        catch(UnknownHostException e)
        {
            // Called when the Host cannot be found, or the connection is unplugged.
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
        catch(IOException e)
        {
            //e.printStackTrace();    
            return 6;
        }
        
        catch(Exception e) 
        {
            e.printStackTrace();    
            return 7;
        }
        //System.out.println("Completed Transfer.");
        return 0;
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
