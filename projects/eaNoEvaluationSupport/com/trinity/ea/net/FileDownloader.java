/*
 * FileDownloader.java
 *
 * Created on January 2, 2004, 5:29 PM
 */

package com.trinity.ea.net;
import java.net.*;
import java.io.*;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2004 Trinity Software. All rights reserved.
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
}
