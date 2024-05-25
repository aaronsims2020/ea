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
import java.io.File;
import java.io.IOException;
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
                                Runnable runnable = new com.trinity.ea.autoupdate.net.FileDownloaderManager(EncryptedRuleReader.get("autoUpdateBaseURL"), getDownloadDirectory());

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
        UpdateInstaller uinst = new UpdateInstaller(EncryptedRuleReader.get("autoUpdateBaseURL"), getDownloadDirectory());
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

   private static String getDownloadDirectory()
   {
	try
	{
		String systemDir = "";
            if(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateDownloadDirSystemPropertyEnabled",EncryptedRuleReader.getOperatingSystemID()).equalsIgnoreCase("true")==true)
            {
                String unparsedString = null;
                String systemPropertyType = null;
                if(EncryptedRuleReader.get("autoUpdateDownloadDir")!=null)
                {
                    if(EncryptedRuleReader.get("autoUpdateTempFileName")!=null)
                    {
                    	systemPropertyType = EncryptedRuleReader.getSystemPropertyDefine(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateDownloadDir",EncryptedRuleReader.getOperatingSystemID()));
                    	if(systemPropertyType.equalsIgnoreCase("/$USER_HOME_DIR/$")==true)
                    	{    
		   			String tempRootDir = System.getProperty(EncryptedRuleReader.get("/$USER_HOME_DIR/$"));
					if(tempRootDir.equalsIgnoreCase("")==false)
					{
		   				if(tempRootDir.endsWith("/")==false)
		   				{
							systemDir = tempRootDir  + "/" +  EncryptedRuleReader.getSystemPropertyExtendedValue(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateDownloadDir",EncryptedRuleReader.getOperatingSystemID()));
						}
						else
						{
							systemDir = tempRootDir  + EncryptedRuleReader.getSystemPropertyExtendedValue(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateDownloadDir",EncryptedRuleReader.getOperatingSystemID()));
						}
					}
					else
					{
						systemDir = EncryptedRuleReader.getSystemPropertyExtendedValue(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateDownloadDir",EncryptedRuleReader.getOperatingSystemID()));
					}
                   	}
                    	else if(systemPropertyType.equalsIgnoreCase("/$DOWNLOAD_DIR/$")==true)
                    	{    
                        	unparsedString = EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateDownloadDir",EncryptedRuleReader.getOperatingSystemID());
 		    			String part1 = "";
		    			String part2 = "";
					try
					{
                        		if(EncryptedRuleReader.getSystemPropertyExtendedValue(unparsedString)!=null)
                        		{
                        	    		part1 = EncryptedRuleReader.getSystemPropertyExtendedValue(unparsedString);
                        		}
                        		if(EncryptedRuleReader.get("/$DOWNLOAD_DIR/$")!=null)
                        		{
                           			part2 = EncryptedRuleReader.getSystemPropertyPlatformValue("/$DOWNLOAD_DIR/$",EncryptedRuleReader.getOperatingSystemID());
                        		}
			   			String tempRootDir = System.getProperty(part2);

						if(tempRootDir.equalsIgnoreCase("")==false)
						{
			   				if(tempRootDir.endsWith("/")==false)
			   				{
								systemDir = tempRootDir + "/" +  part1;
							}
							else
							{
								systemDir = tempRootDir  + part1;								
							}
						}
						else
						{
							systemDir = part1;
						}

					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
                        	try
                        	{
						//System.out.println("Download Directory: " + systemDir);
                          		File theDirect2 = new File(systemDir);   
                          		if(theDirect2.exists()==false)
                          		{
                              		//System.out.println("Making directory: " + theDirect2.getAbsolutePath());
                              		boolean isCreated = theDirect2.mkdirs();
                              		//System.out.println("Created Directory: " + isCreated);
                          		}
                        	}
                        	catch(SecurityException e)
                        	{
		                        e.printStackTrace();             
            	            }
                  	      catch(Exception e) 
                        	{
                            		e.printStackTrace();
                        	} 					
                    	}
			  }
                }

            else
            {
                if(EncryptedRuleReader.get("autoUpdateDownloadDir")!=null)
                {
			   String tempRootDir = getRootDirectory();
			   if(tempRootDir.equalsIgnoreCase("")==false)
			   {
			   	if(tempRootDir.endsWith("/")==false)
			   	{
                     		systemDir = tempRootDir  + "/" +  EncryptedRuleReader.getSystemPropertyExtendedValue(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateDownloadDir",EncryptedRuleReader.getOperatingSystemID()));
			   	}
			   	else
			   	{
                     		systemDir = tempRootDir + EncryptedRuleReader.getSystemPropertyExtendedValue(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateDownloadDir",EncryptedRuleReader.getOperatingSystemID()));
 			   	}
			   }
			   else
			   {
                     		systemDir =  EncryptedRuleReader.getSystemPropertyExtendedValue(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateDownloadDir",EncryptedRuleReader.getOperatingSystemID()));
			   }
                     try
                     {
                     	File theDirect2 = new File(systemDir);   
                     	if(theDirect2.exists()==false)
                     	{
                       		//System.out.println("Making directory: " + theDirect2.getAbsolutePath());
                       		boolean isCreated = theDirect2.mkdirs();
                       		//System.out.println("Created Directory: " + isCreated);
                    	}
                     }
                     catch(SecurityException e)
                     {
		              e.printStackTrace();             
            	   }
                     catch(Exception e) 
                     {
                     	e.printStackTrace();
                     } 	
                }       
            }
		return systemDir;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
	  return "";
   }

    private static String getRootDirectory()
    {
	try
	{
            if(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRootDirSystemPropertyEnabled",EncryptedRuleReader.getOperatingSystemID()).equalsIgnoreCase("true")==true)
            {
                String unparsedString = null;
                String systemPropertyType = null;
		    String systemDir = "";
                if(EncryptedRuleReader.get("autoUpdateRootDir")!=null)
                {
                    if(EncryptedRuleReader.get("autoUpdateTempFileName")!=null)
                    {
                    	systemPropertyType = EncryptedRuleReader.getSystemPropertyDefine(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRootDir",EncryptedRuleReader.getOperatingSystemID()));
                    	if(systemPropertyType.equalsIgnoreCase("/$USER_HOME_DIR/$")==true)
                    	{    
					systemDir = System.getProperty(EncryptedRuleReader.get("/$USER_HOME_DIR/$"))  + "/" +  EncryptedRuleReader.getSystemPropertyExtendedValue(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRootDir",EncryptedRuleReader.getOperatingSystemID()));
					return systemDir;
                    	}
                    	else if(systemPropertyType.equalsIgnoreCase("/$ROOT_DIR/$")==true)
                    	{    
                        	unparsedString = EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRootDir",EncryptedRuleReader.getOperatingSystemID());
 		    			String part1 = "";
		    			String part2 = "";
					try
					{
                        		if(EncryptedRuleReader.getSystemPropertyExtendedValue(unparsedString)!=null)
                        		{
                        	    		part1 = EncryptedRuleReader.getSystemPropertyExtendedValue(unparsedString);
                        		}
                        		if(EncryptedRuleReader.get("/$ROOT_DIR/$")!=null)
                        		{
                           			part2 = EncryptedRuleReader.getSystemPropertyPlatformValue("/$ROOT_DIR/$",EncryptedRuleReader.getOperatingSystemID());
                        		}
						return System.getProperty(part2)  + "/" +  part1;
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
                    	}
			  }
                }
		}
            else
            {
                if(EncryptedRuleReader.get("autoUpdateRootDir")!=null)
                {
                     return System.getProperty("user.dir") + "/" + EncryptedRuleReader.getSystemPropertyExtendedValue(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRootDir",EncryptedRuleReader.getOperatingSystemID()));
                }       
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
	  return "";
    }

    public static void main(String args[])
    {
        new AutoUpdateManager();
           // JFrame TestFrame = new JFrame("Test Frame for URL Thread.");
    //TestFrame.setSize(400,400);
    //TestFrame.setVisible(true);
    }
}
