/*
 * LaunchApplicationAction.java
 *
 * Created on October 25, 2003, 4:49 PM
 */

package com.trinity.ea.actions;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import com.trinity.ea.actions.AUThreadLauncher;
import com.trinity.ea.util.SwingWorker;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.lang.reflect.Method; 
import java.lang.reflect.InvocationTargetException;
import com.trinity.ea.actions.*;
import com.trinity.ea.autoupdate.AutoUpdateManager;
import com.trinity.ea.messaging.MessageManager;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.URLClassLoader;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * //TODO: update the copyFile, and file copy checks to only run when a flag is set. Will substancially enhance performance.
 * @author  aaronsc Trinity Software
 * Copyright ©2003 Trinity Software. All rights reserved.
 */
public class LaunchApplicationAction 
{
    SwingWorker worker;   
    private Method mainMethod = null;    
    private static boolean boolSkipEnabled = false;
    Object ea = null;
    /** Creates a new instance of LaunchApplicationAction */
    public LaunchApplicationAction() 
    {
        // TODO: Command Line implementation
        // TODO: MIDP implementation
        // Trial Expired

        SwingWorker worker = new SwingWorker() 
        {
                public Object construct() 
                {
                    return launch();
                }
                public void finished() 
                {
                    //worker.stop();
                }
         };
        worker.start();
        // rtn = (RtnObject)worker.get();
        //worker = null;     
    }
   /*
    public static void main(String[] args)
    {
        EncryptedRuleReader.readPropertiesFile();
        new LaunchApplicationAction();
    }
    */
        private Object launch()
        {
            //getMessage();
            
            if(EncryptedRuleReader.get("autoUpdateEnabled")!=null)
            {
                if(EncryptedRuleReader.get("autoUpdateEnabled").equalsIgnoreCase("true")==true)
                {
            // ex1.getStartButton().requestFocus();  //XXX: can't do this until now
                    if(boolSkipEnabled==false)
                    {
                        getAvailableUpdate();
                    }
                    else
                    {
                        getLaunchAppIsReady();
                    }
                }
                else
                {
                    getLaunchAppIsReady();                    
                }
            }
            else
            {
                getLaunchAppIsReady();
            }                 
               return "";
        }
        
        private void getAvailableUpdate()
        {
        /* AutoUpdate Code goes here. */
        if(EncryptedRuleReader.get("autoUpdateUpdateInProgress")!=null)
        {                       
            if(EncryptedRuleReader.get("autoUpdateUpdateInProgress").equalsIgnoreCase("true")==true)
            {
                /* TODO: Add a checking update status dialog if loading takes more than 1 second - or use a user definable value in the Rules file */
                int vfdc = AutoUpdateManager.getUpdateDownloadsComplete();
                if(vfdc==0)
                {      
                    if(EncryptedRuleReader.get("autoUpdateLoadInstallUIAction")!=null)
                    {      
                        try
                        {
                                Class.forName(EncryptedRuleReader.get("autoUpdateLoadInstallUIAction")).newInstance();
                        }
                        catch(InstantiationException e)
                        {
                            System.out.println(e);
                        }   
                        catch(IllegalAccessException e)
                        {
                            System.out.println(e);
                        }                      
                        catch(ClassNotFoundException e)
                        {
                            System.out.println(e);
                        }                                               
                    }
                    else
                    {
                        getLaunchAppIsReady();
                    }
                }
                else if(vfdc==1)
                {
                    //System.out.println("File Downloads Incomplete");  
                    launchApp();
                }
                else if(vfdc==2)
                {
                     //System.out.println("File Downloads Corrupted Update File");
                     AutoUpdateManager.getDownloadedFilesReset();
                     EncryptedRuleReader.updateInProgress(false);
                     EncryptedRuleReader.updateNeeded(false);
                     launchApp();
                }
                else if(vfdc==3)
                {
                      //System.out.println("File Downloads Corrupted File Downloads Array String");  
                      AutoUpdateManager.getDownloadedFilesReset();
                      EncryptedRuleReader.updateInProgress(false);
                      EncryptedRuleReader.updateNeeded(false);                   
                      launchApp();
                }
                else
                {
                      //System.out.println("File Downloads Unknown error return code: " + vfdc);  
                      launchApp();
                }                                

            }
            else
            {
                new AutoUpdateManager();
                getLaunchAppIsReady();
            }
        }
        else
        {
            getLaunchAppIsReady();
        }
         
    }
    private void getMessage()
    {
   
        try
        {
             if(EncryptedRuleReader.get("msgEnabled")!=null)
            {
                if(EncryptedRuleReader.get("msgEnabled").equalsIgnoreCase("true")==true)
                {           
                    new com.trinity.ea.messaging.MessageManager();
                }
             }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void getLaunchAppIsReady()
    {
        if(EncryptedRuleReader.get("autoUpdateRunDirUpdateNeeded")!=null)
        {
            if(EncryptedRuleReader.get("autoUpdateRunDirUpdateNeeded").equalsIgnoreCase("true")==true)
            {
                initUpdateSupport();
            }
            else
            {
                launchApp();
            }
        }
        else
        {
            launchApp();
        }
    }
 
   private synchronized Object launch(Method mainMethod1)
   {
       try
       {
            mainMethod1.invoke(null,new Object[]{new String[]{}});   
        }
        catch(InvocationTargetException e)
        {
            System.out.println(e);                
        }            
        catch(IllegalAccessException e)
        {
            System.out.println(e);
        }  
    
       return "";
   }    

   private void launchApp()
    {
        if(EncryptedRuleReader.get("applicationClass")!=null)
        {
            try
            {
                AUThreadLauncher getInvokeApp = new AUThreadLauncher();
                SwingUtilities.invokeAndWait(getInvokeApp);
                getMessage();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            //Problem in Properties File
        }        

    }   
    
    public static void setSkipUpdate(boolean skipEnabled)
    {
        boolSkipEnabled = skipEnabled;
    }
    
    ///////////////////////////////////////////////////

    
    private static URL[] getURLArrayFromString(String preDir, String textArrayString)
    {
        String runDir = preDir;        
        ArrayList aryList = new ArrayList();
        URL[] tempURLArray = null;
        String tempString = "";
        try
        {
            while(textArrayString.indexOf(",")!=-1)
            {
                tempString = textArrayString.substring(0,textArrayString.indexOf(","));
                textArrayString = textArrayString.substring(textArrayString.indexOf(",") + 1);
                //System.out.println("New URL: " + new File(runDir + "/" + tempString).toURL().toString());
                aryList.add(new File(runDir + "/" + tempString).toURL());
            }
            //System.out.println("New URL: " + new File(runDir + "/" + tempString).toURL().toString());           
            aryList.add(new File(runDir + "/" + textArrayString).toURL());
            aryList.trimToSize();
            Object[] tempArray3 = aryList.toArray();
            tempURLArray = new URL[tempArray3.length];
            for(int i = 0;i<tempArray3.length;i++)
            {
                tempURLArray[i] = (URL)tempArray3[i];
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return tempURLArray;
    }      

    private static File[] getFileArrayFromString(String preDir, String textArrayString)
    {
        String runDir = preDir;        
        ArrayList aryList = new ArrayList();
        File[] tempFileArray = null;
        String tempString = "";
        try
        {
            while(textArrayString.indexOf(",")!=-1)
            {
                tempString = textArrayString.substring(0,textArrayString.indexOf(","));
                textArrayString = textArrayString.substring(textArrayString.indexOf(",") + 1);
                aryList.add(new File(runDir + "/" + tempString));
            }
            aryList.add(new File(runDir + "/" + textArrayString));
            aryList.trimToSize();
            Object[] tempArray3 = aryList.toArray();
            tempFileArray = new File[tempArray3.length];
            for(int i = 0;i<tempArray3.length;i++)
            {
                tempFileArray[i] = (File)tempArray3[i];
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return tempFileArray;
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
    
   private static String getRunDirectory()
   {
	try
	{
		String systemDir = "";
            if(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRunDirSystemPropertyEnabled",EncryptedRuleReader.getOperatingSystemID()).equalsIgnoreCase("true")==true)
            {
                String unparsedString = null;
                String systemPropertyType = null;
                if(EncryptedRuleReader.get("autoUpdateRunDir")!=null)
                {
                    if(EncryptedRuleReader.get("autoUpdateTempFileName")!=null)
                    {
                    	systemPropertyType = EncryptedRuleReader.getSystemPropertyDefine(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRunDir",EncryptedRuleReader.getOperatingSystemID()));
                    	if(systemPropertyType.equalsIgnoreCase("/$USER_HOME_DIR/$")==true)
                    	{    
		   			String tempRootDir = System.getProperty(EncryptedRuleReader.get("/$USER_HOME_DIR/$"));
					if(tempRootDir.equalsIgnoreCase("")==false)
					{
		   				if(tempRootDir.endsWith("/")==false)
		   				{
							systemDir = tempRootDir  + "/" +  EncryptedRuleReader.getSystemPropertyExtendedValue(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRunDir",EncryptedRuleReader.getOperatingSystemID()));
						}
						else
						{
							systemDir = tempRootDir  + EncryptedRuleReader.getSystemPropertyExtendedValue(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRunDir",EncryptedRuleReader.getOperatingSystemID()));
						}
					}
					else
					{
						systemDir = EncryptedRuleReader.getSystemPropertyExtendedValue(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRunDir",EncryptedRuleReader.getOperatingSystemID()));
					}
                   	}
                    	else if(systemPropertyType.equalsIgnoreCase("/$RUN_DIR/$")==true)
                    	{    
                        	unparsedString = EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRunDir",EncryptedRuleReader.getOperatingSystemID());
 		    			String part1 = "";
		    			String part2 = "";
					try
					{
                        		if(EncryptedRuleReader.getSystemPropertyExtendedValue(unparsedString)!=null)
                        		{
                        	    		part1 = EncryptedRuleReader.getSystemPropertyExtendedValue(unparsedString);
                        		}
                        		if(EncryptedRuleReader.get("/$RUN_DIR/$")!=null)
                        		{
                           			part2 = EncryptedRuleReader.getSystemPropertyPlatformValue("/$RUN_DIR/$",EncryptedRuleReader.getOperatingSystemID());
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
                if(EncryptedRuleReader.get("autoUpdateRunDir")!=null)
                {
			   String tempRootDir = getRootDirectory();
			   if(tempRootDir.equalsIgnoreCase("")==false)
			   {
			   	if(tempRootDir.endsWith("/")==false)
			   	{
                     		systemDir = tempRootDir  + "/" +  EncryptedRuleReader.getSystemPropertyExtendedValue(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRunDir",EncryptedRuleReader.getOperatingSystemID()));
			   	}
			   	else
			   	{
                     		systemDir = tempRootDir + EncryptedRuleReader.getSystemPropertyExtendedValue(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRunDir",EncryptedRuleReader.getOperatingSystemID()));
 			   	}
			   }
			   else
			   {
                     		systemDir =  EncryptedRuleReader.getSystemPropertyExtendedValue(EncryptedRuleReader.getSystemPropertyPlatformValue("autoUpdateRunDir",EncryptedRuleReader.getOperatingSystemID()));
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
    private int copyFile(String sourceFile, String destinationFile, boolean boolOverwriteFile)
    {  
         return copyFile(new File(sourceFile), new File(destinationFile), boolOverwriteFile);
    }
    
    private int copyFile(File theSourceFile, File theDestinationFile, boolean boolOverwriteFile)
    {
        try
        {
            if(theSourceFile.isDirectory()==true)
            {
                try
                {
                    //System.out.println("THe source file is a directory: " + theSourceFile.getPath());
                    // Move file to new directory
                    copyDirectory(theSourceFile, theDestinationFile);
                    return 0;
                }
                catch(Exception e)
                {
                    return 1;
                }    
            }
            else
            {
                // Destination directory
                if(theSourceFile.exists()==true)
                {
                        // if the source file exists, then continue.
                        if(theDestinationFile.exists()==true)
                        {
                            // 1. Check if the file can be overwriten. If not then return 0;
                            if(boolOverwriteFile==true)
                            {
                                // TODO 2/11/2004: Implement Rollback feature for manual Rollback on failed upgrades.
                                // The Destination File exists. Must overwrite. Backup may be necessary.
                                try
                                {
         //                           System.out.println("Deleting old update file to replace with new file.");
                                    theDestinationFile.delete();
         //                            System.out.println("Deleted Successfully");
                                    try
                                    {
                                        // Move file to new directory
                                        copy(theSourceFile, theDestinationFile);
                                        return 0;
                                    }
                                    catch(Exception e)
                                    {
                                        return 1;
                                    }    
                                }
                                catch(Exception e)
                                {

                                    e.printStackTrace();
                                    return 8;
                                }                           
                            }
                            else
                            {
                                return 0;
                            }
                        }
                        else 
                        {
                            // The destination file does not exist. Proceed by verifying directory exists. If not create the directory, and then attemp to create the file.
                              try
                              {
                                File theCopyToDirectory = new File(getDownloadDirFromFileString(theDestinationFile.toURL().getPath()));
                                if(theCopyToDirectory.exists()==true)
                                {
                                    //if the directory exists for the destination file, copy the file.
                                    try
                                    {
                                        // Move file to new directory
                                        copy(theSourceFile, theDestinationFile);
                                        return 0;
                                    }
                                    catch(Exception e)
                                    {
                                        return 1;
                                    }    
                                }
                                else
                                {
                                      //if the directory does not exist for the destination file, create the directory and then copy the file.                               
        //                              System.out.println("Making directory: " + theCopyToDirectory.getAbsolutePath());
                                      boolean isCreated = theCopyToDirectory.mkdirs();
        //                              System.out.println("Created Directory: " + isCreated);    
                                    try
                                    {
                                        // Move file to new directory
                                        copy(theSourceFile, theDestinationFile);
                                        return 0;
                                    }
                                    catch(Exception e)
                                    {
                                        return 1;
                                    }                                        
                                }
                              }
                              catch(Exception e)
                              {
                                  e.printStackTrace();
                                  return 8;
                              }

                        }

                }
                else
                {
                    // return code 9 is source file does not exist.
                    return 9;
                }

            }
        }
        catch(Exception e)
        {
            return 8;
        }       
    }        
    
    /* returns the install file path minus file and last slash for directory path */
    private String getDownloadDirFromFileString(String strFilePath)
    {
        try
        {
            if(strFilePath.indexOf("/")!=-1)
            {
                if(strFilePath.indexOf("/")==0)
                {
                    if(strFilePath.lastIndexOf("/")==0)
                    {
                        return "/";
                    }
                    else
                    {
                        return strFilePath.substring(0,strFilePath.lastIndexOf("/"));
                    }
                }
                else
                {
                    /* If / is not the first character assume the first part of the dir path is the directory name followed by a / */
                    try
                    {
                        strFilePath=strFilePath.trim();
                        if(strFilePath.indexOf("/")==0)
                        {
                            if(strFilePath.lastIndexOf("/")==0)
                            {
                                return "/";
                            }
                            else
                            {
                                return strFilePath.substring(0,strFilePath.lastIndexOf("/"));
                            }
                        }
                        else
                        {
                            strFilePath = "/" + strFilePath;
                            return strFilePath.substring(0,strFilePath.lastIndexOf("/"));
                        }
                    }
                    catch(NullPointerException e)
                    {
                        return "/";
                    }
                    catch(Exception e)
                    {
                        return "/";                
                    }
                }
            }
            else
            {
                    return "/";                
            }
        }
        catch(NullPointerException e)
        {
            return "/";
        }
        catch(Exception e)
        {
            return "/";                
        }      
    }
    
    
    
    // Copies src file to dst file.
    // If the dst file does not exist, it is created
    private void copy(File src, File dst) throws IOException 
    {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst);
    
        // Transfer bytes from in to out
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) 
        {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
        dst.setLastModified(src.lastModified());
    }   
    
     // Copies all files under srcDir to dstDir.
    // If dstDir does not exist, it will be created.
    public void copyDirectory(File srcDir, File dstDir) throws IOException 
    {
        if (srcDir.isDirectory()) 
        {
            if (!dstDir.exists()) 
            {
                dstDir.mkdir();
            }
    
            String[] children = srcDir.list();
            for (int i=0; i<children.length; i++) 
            {
                copyDirectory(new File(srcDir, children[i]),new File(dstDir, children[i]));
            }
        } 
        else 
        {
            // This method is implemented in e1071 Copying a File
            copy(srcDir, dstDir);
        }
    }  
    
    private void initUpdateSupport()
   {
	try
        {
            String rootDir = getRootDirectory();
            String runDir = getRunDirectory();
            EncryptedRuleReader.readPropertiesFile();
            //getURLArrayFromString(String preDir, String textArrayString)
            
            File[] fileRootList1 = getFileArrayFromString(rootDir, EncryptedRuleReader.get("autoUpdateCP"));
            File[] fileRunList1 = getFileArrayFromString(runDir, EncryptedRuleReader.get("autoUpdateCP"));            
            for(int i = 0;i<fileRunList1.length;i++)
            {
                if(fileRunList1[i].exists()==false)
                {
                    //System.out.println("Root File: " + fileRootList1[i].getPath() + ", Run File: " + fileRunList1[i].getPath());
                    int result = copyFile(fileRootList1[i], fileRunList1[i], true);
                    //System.out.println("Result: " + result);
                }
                if(fileRunList1[i].lastModified()!=fileRootList1[i].lastModified() || fileRunList1[i].length()!=fileRootList1[i].length())
                {
                    //System.out.println("Root File: " + fileRootList1[i].getPath() + ", Run File: " + fileRunList1[i].getPath());
                    int result = copyFile(fileRootList1[i], fileRunList1[i], true);
                    //System.out.println("Result: " + result);                                  
                }              
            }
            EncryptedRuleReader.updateNeeded(false);
            launchApp();
        } 
        catch(Exception e)
        {
            e.printStackTrace();
        }
   }       
}
