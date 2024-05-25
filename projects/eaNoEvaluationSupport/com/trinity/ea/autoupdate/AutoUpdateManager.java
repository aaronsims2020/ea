/*
 * AutoUpdateManager.java
 *
 * Created on January 14, 2004, 2:21 PM
 */

package com.trinity.ea.autoupdate;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import com.trinity.ea.autoupdate.reader.EncryptedUpdateReader;
import com.trinity.ea.autoupdate.install.UpdateInstaller;
import com.trinity.ea.autoupdate.net.FileDownloaderManager;
import javax.swing.*;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2004 Trinity Software. All rights reserved.
 */
public class AutoUpdateManager 
{
    
    /** Creates a new instance of AutoUpdateManager */
    public AutoUpdateManager() 
    {
        try
        {
           // System.out.println("Starting Auto Update Manager...");
             //EncryptedRuleReader.readPropertiesFile();
                 // System.out.println("trying autoUpdateEnabled...");
                 if(EncryptedRuleReader.get("autoUpdateEnabled")!=null)
                 {
                    if(EncryptedRuleReader.get("autoUpdateEnabled").equalsIgnoreCase("true")==true)
                    {
                       // System.out.println("autoUpdateEnabled is true. Trying autoUpdateBaseURL: " + EncryptedRuleReader.get("autoUpdateBaseURL"));
                        if(EncryptedRuleReader.get("autoUpdateBaseURL")!=null)
                        {
                         //System.out.println("Made it. Trying autoUpdateWorkDir");                       
                            if(EncryptedRuleReader.get("autoUpdateDownloadDir")!=null)
                            {           
                          //System.out.println("Starting Thread.");                              
                                // Create the object with the run() method
                                Runnable runnable = new com.trinity.ea.autoupdate.net.FileDownloaderManager(EncryptedRuleReader.get("autoUpdateBaseURL"), EncryptedRuleReader.get("autoUpdateDownloadDir"));

                                // Create the thread supplying it with the runnable object
                                Thread thread = new Thread(runnable);

                                // Start the thread
                                thread.start();  
                          //System.out.println("Started Thread.");                                  
                            }
                        }
                    }
                    else
                    {
                       // System.out.println("autoUpdateEnabled is false.");                    
                    }
                 }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /* Step 1: Check for downloads complete. */
    /** returns 0 is true (ready to install update), 1 is false, 2 is Update File is corrupted, 3 Download List is corrupted - Repair List is necessary, please clean up data, and download undownloaded files. 8 - Exception thrown, 9 - Update File could not be read.
     * @return
     */
    public static int getUpdateDownloadsComplete()
    {
        try
        {
            if(EncryptedUpdateReader.readUpdateFile()==true)
            {
                return UpdateInstaller.getUpdateStatus();
            }
            else
            {
                return 9;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 8;
        }
    }

    /* Step 2: initialize install update */
    /** returns 0 is true (ready to install update), 1 is false, 2 is Update File is corrupted, 3 Download List is corrupted - Repair List is necessary, please clean up data, and download undownloaded files. 8 - Exception thrown.
     * @return
     */
    public static int getInstallUpdate()
    {
        UpdateInstaller uinst = new UpdateInstaller(EncryptedRuleReader.get("autoUpdateBaseURL"), EncryptedRuleReader.get("autoUpdateDownloadDir"));
        return uinst.getInstallUpdate();
    }    
    
    public static void getDownloadedFilesReset()
    {
        try
        {
            EncryptedUpdateReader.getDownloadedFilesReset();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String args[])
    {
        new AutoUpdateManager();
           // JFrame TestFrame = new JFrame("Test Frame for URL Thread.");
    //TestFrame.setSize(400,400);
    //TestFrame.setVisible(true);
    }
}
