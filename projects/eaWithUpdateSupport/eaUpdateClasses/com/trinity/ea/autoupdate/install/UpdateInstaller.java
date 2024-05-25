/*
 * UpdateInstaller.java
 *
 * Created on February 16, 2004, 6:02 PM
 */

package com.trinity.ea.autoupdate.install;
import java.util.Map; 
import java.util.HashMap;
import java.util.Collections;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import com.trinity.ea.autoupdate.reader.EncryptedUpdateReader;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2004 Trinity Software. All rights reserved.
 */
public class UpdateInstaller 
{
    String strUrl;
    String directory;
    Map overwriteHM;
    private static int updateStatus = 1;
    /** Creates a new instance of UpdateInstaller
     * @param strUpdateUrl
     * @param dir
     */
    public UpdateInstaller(String strUpdateUrl, String dir)  
    {
        strUrl=strUpdateUrl;
        directory=dir;
    }
    
    private int copyFile(String sourceFile, String destinationFile, boolean boolOverwriteFile)
    {
        try
        {
            // Destination directory

            File theSourceFile = new File(sourceFile);
            File theDestinationFile = new File(destinationFile);
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
                                boolean success = theSourceFile.renameTo(theDestinationFile);
                                if (success==true) 
                                {
                                     return 0;
                                }
                                else
                                {
                                    return 1;
                                }
                            }
                            catch(Exception e)
                            {
                                return 8;
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
                        File theCopyToDirectory = new File(getDownloadDirFromFileString(destinationFile));
                        if(theCopyToDirectory.exists()==true)
                        {
                            //if the directory exists for the destination file, copy the file.
                            try
                            {
                                // Move file to new directory
                                boolean success = theSourceFile.renameTo(theDestinationFile);
                                if (success==true) 
                                {
                                     return 0;
                                }
                                else
                                {
                                    return 1;
                                }
                            }
                            catch(Exception e)
                            {
                                return 8;
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
                                boolean success = theSourceFile.renameTo(theDestinationFile);
                                if (success==true) 
                                {
                                     return 0;
                                }
                                else
                                {
                                    return 1;
                                }
                            }
                            catch(Exception e)
                            {
                                return 8;
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
        catch(Exception e)
        {
            return 8;
        }       
    }    
    
    private static Object[] getStringArraysFromString(String textArrayString)
    {
        ArrayList aryList = new ArrayList();
        String tempString = "";
        try
        {
            while(textArrayString.indexOf(",")!=-1)
            {
                tempString = textArrayString.substring(0,textArrayString.indexOf(","));
                textArrayString = textArrayString.substring(textArrayString.indexOf(",") + 1);
                aryList.add(tempString);
            }
            aryList.add(textArrayString);
            aryList.trimToSize();
        }
        catch(NullPointerException e)
        {
         
        }

        return aryList.toArray();
    }
   
    /* returns the install file path minus file and last slash for directory path */
    private static String getDownloadDirFromFileString(String strFilePath)
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
    
    /* returns 0 is true, 1 is false, 2 is Update File is corrupted, 3 Download List is corrupted - Repair List is necessary, please clean up data, and download undownloaded files. */
    private static int verifyFileDownloadsComplete()
    {
        if(EncryptedUpdateReader.get("files")!=null)
        {
            if(EncryptedUpdateReader.get("dldFiles")!=null)
            {
                /* Verification begins here if both files need to be downloaded, and files have been downloaded. */
                Object[] dloadFiles = getStringArraysFromString(EncryptedUpdateReader.get("files"));
                Object[] dloadedFiles = getStringArraysFromString(EncryptedUpdateReader.get("dldFiles"));                
                if(dloadFiles.length==dloadedFiles.length)
                {
                    HashMap hm2 = new HashMap(dloadedFiles.length);                   
                    /* The same number of downloaded files, and all files to download are the same. Next verify the file names are the same. */
                    /* add all the downloaded files to the hashmap for compare of containsKet() method of the HashMap. */
                    for(int i = 0;i<dloadedFiles.length;i++)
                    {
                        hm2.put((String)dloadedFiles[i],null);
                        //System.out.println("Download File " + i + ": " + (String)dloadFiles[i]);
                        //System.out.println("Downloaded Files " + i + ": " + (String)dloadedFiles[i]);
                    }
                    for(int i = 0;i<dloadFiles.length;i++)
                    {
                        if(hm2.containsKey((String)dloadFiles[i])==true)
                        {
                            hm2.put((String)dloadFiles[i], "true");
                        }
                        else
                        {
                            //if key is not in the HashMap then it was not downloaded. and repair update measures must be implemented
                            return 3;
                        }
                        //System.out.println("Download File " + i + ": " + (String)dloadFiles[i]);
                        //System.out.println("Downloaded Files " + i + ": " + (String)dloadedFiles[i]);
                    }
                    for(int i=0;i<dloadFiles.length;i++)
                    {
                        try
                        {
                            if(((String)hm2.get((String)dloadFiles[i])).equalsIgnoreCase("true")==true)
                            {
                                
                            }
                            else
                            {
                                return 1;
                            }
                        }
                        catch(NullPointerException eeeeee)
                        {
                            return 1;
                        }
                    }
                    
                    // Finish up this function by writing it, remove the hard coded return of 0;
                    return 0;
                }
                else
                {
                    if(dloadFiles.length<dloadedFiles.length)
                    {
                        /* The same number of downloaded files, and all files to download are the same. Next verify the file names are the same. */
                        //System.out.println("Downloaded Files is greater than files to download, returning 2 for Corrupted Update file.");
                        EncryptedUpdateReader.getDownloadedFilesReset();    
                        return 2;
                    }        
                    else
                    {
                        /* return false if the number of files downloaded is not the same as the number of files listed. */
                        return 1;
                    }
                }
            }    
            else
            {
                return 1;
            }            
        }
        else 
        {
            /* returns true because the update has no file copies to complete. One rule exception may be if the update file is corrupted. Implement additional handling next release. */
            if(EncryptedUpdateReader.get("dldFiles")!=null)
            {
               /* if dldFiles is not equal to null, and files is equal to null, the update file is likely corrupted. */
               EncryptedUpdateReader.getDownloadedFilesReset();  
                return 2;
            }    
            else
            {
                return 0;
            }  
        }
    }    
    /* Initializes File Overwrite Map for File Overwrite Mappings... Return code for success is 0, 1 is number of overwrite elements is greater than file elements,2 is number of overwrite elements is less than file elements, 3 error in routine, 4 is no files to check for values to overwrite. // additional notes are for other method ///, and returns 0 is overwrite file, 1  is do not overwrite existing file, 2 no files specified to update, 3 is Update File is corrupted, 4 Overwrite File List is corrupted - Repair List is necessary, please clean up data. If unspecified append or overwrite value the default value is do not overwrite. */
    private int getInitializeOverwriteFileMap()
    {
        overwriteHM = new HashMap();
        try
        {
            if(EncryptedUpdateReader.get("copyfilesto")!=null)
            {
                Object[] filesArrayVals = getStringArraysFromString(EncryptedUpdateReader.get("copyfilesto")); 
                if(EncryptedUpdateReader.get("overwriteexistingfiles")!=null)
                {

                    Object[] overwriteArrayVals = getStringArraysFromString(EncryptedUpdateReader.get("overwriteexistingfiles"));

                    //// Begin Code Functionality /////
                    if(filesArrayVals.length==overwriteArrayVals.length)
                    {
                        try
                        {
                            for(int i = 0;i<filesArrayVals.length;i++)
                            {
                                //Put overwrite value here
                                overwriteHM.put((String)filesArrayVals[i], (String)overwriteArrayVals[i]);
                                //System.out.println("Download File " + i + ": " + (String)dloadFiles[i]);
                                //System.out.println("Downloaded Files " + i + ": " + (String)dloadedFiles[i]);
                            }
                        }
                        catch(Exception e)
                        {
                            return 3;
                        }
                        /*
                        for(int i=0;i<filesArrayVals.length;i++)
                        {
                            try
                            {
                                if(((String)hm2.get((String)filesArrayVals[i])).equalsIgnoreCase("true")==true)
                                {

                                }
                                else
                                {
                                    return 1;
                                }
                            }
                            catch(NullPointerException eeeeee)
                            {
                                return 1;
                            }
                        }
                        */
                        // Finish up this function by writing it, remove the hard coded return of 0;
                        return 0;
                    }
                    else
                    {
                        if(filesArrayVals.length<overwriteArrayVals.length)
                        {
                            try
                            {
                                for(int i = 0;i<filesArrayVals.length;i++)
                                {
                                    //Put overwrite value here
                                    overwriteHM.put((String)filesArrayVals[i], (String)overwriteArrayVals[i]);
                                    //System.out.println("Download File " + i + ": " + (String)dloadFiles[i]);
                                    //System.out.println("Downloaded Files " + i + ": " + (String)dloadedFiles[i]);
                                }
                            }
                            catch(Exception e)
                            {
                                return 3;
                            }
                            return 1;
                        }        
                        else
                        {
                            try
                            {
                                for(int i = 0;i<overwriteArrayVals.length;i++)
                                {
                                    //Put overwrite value here
                                    overwriteHM.put((String)filesArrayVals[i], (String)overwriteArrayVals[i]);
                                    //System.out.println("Download File " + i + ": " + (String)dloadFiles[i]);
                                    //System.out.println("Downloaded Files " + i + ": " + (String)dloadedFiles[i]);
                                }
                                int k = overwriteArrayVals.length - 1;
                                for(int i = k;i<filesArrayVals.length;i++)
                                {
                                    overwriteHM.put((String)filesArrayVals[i], "false");
                                }
                            }
                            catch(Exception e)
                            {
                                return 3;
                            }                        
                            return 2;
                        }
                    }               
                    //// End Code Functinality /////
                }
                else
                {
                    try
                    {
                        for(int i = 0;i<filesArrayVals.length;i++)
                        {
                            //Put overwrite value here
                            overwriteHM.put((String)filesArrayVals[i], "false");
                        }
                    }
                    catch(Exception e)
                    {
                        return 3;
                    }                        
                    return 2;
                }
            }
            else
            {
                return 4;
            }
        }
        catch(Exception e)
        {
           return 3;   
        }
    }
    
    public static int getUpdateStatus()
    {
        updateStatus = verifyFileDownloadsComplete();
        return updateStatus;
    }
    
    /* Return Code information code be inaccurate. Return code for success is 0, 1 failure, 2 no files specified to update, 3 is Update File is corrupted, 4 Overwrite File List is corrupted - Repair List is necessary, 8 - Exception thrown. please clean up data. If unspecified append or overwrite value the default value is do not overwrite. */
    public int getInstallUpdate()
    {
        try
        {
            if(updateStatus==0)
            {
                return getInstllUpdate();
            }
            else
            {
                // dummy return value for hackers trying to call this method to install files
                return 0;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 8;
        }
    }
    
    private int getInstllUpdate()
    {
        try
        {
            // TODO: Check if each file exists, and verify if it is permissions allow overwriting existing files.
 //           System.out.println("File Downloads Verified Complete Success");
            int overwriteRetCodeValue = getInitializeOverwriteFileMap();
            if(overwriteRetCodeValue!=3||overwriteRetCodeValue!=4)
            {
               //Get Files to Copy, and their destination. Then finish up routine.
               Object[] fileCopyUpdateObjectArray = getStringArraysFromString(EncryptedUpdateReader.get("copyfilesto"));
//               System.out.println("Copying Downloaded Files to permanent location.");
               boolean isSuccess = true;
               String dlDir = getDownloadDirectory();
               String rootDir = getRootDirectory();
               if(dlDir.endsWith("/")==false)
               {
                   dlDir = dlDir + "/";
               }
               if(rootDir.endsWith("/")==false)
               {
                   rootDir = rootDir + "/";
               }               
               for(int i = 0;i<fileCopyUpdateObjectArray.length;i++)
               {
                   
                   File sourceFile = new File(dlDir + (String)fileCopyUpdateObjectArray[i]);
                   File destinationFile = new File(dlDir + (String)fileCopyUpdateObjectArray[i]);
                   boolean isOverwritable = false;
                   // beginning
                   int fileCopyReturnCode=1;
                  try
                  {
                       if(overwriteHM.get((String)fileCopyUpdateObjectArray[i])!=null)
                       {
                            if(((String)overwriteHM.get((String)fileCopyUpdateObjectArray[i])).equalsIgnoreCase("true")==true)
                            {
//                                System.out.println("File copy overwrite = true");
                                fileCopyReturnCode = copyFile(dlDir + (String)fileCopyUpdateObjectArray[i], rootDir + (String)fileCopyUpdateObjectArray[i], true);
                            }
                            else
                            {
//                                 System.out.println("File copy overwrite = false");
                                fileCopyReturnCode = copyFile(dlDir + (String)fileCopyUpdateObjectArray[i], rootDir + (String)fileCopyUpdateObjectArray[i], false);                                                
                            }
                       }
                       else
                       {
 //                          System.out.println("File copy overwrite = false");
                           fileCopyReturnCode = copyFile(dlDir + (String)fileCopyUpdateObjectArray[i], rootDir + (String)fileCopyUpdateObjectArray[i], false);                                                 
                       }
                  }
                  catch(Exception e)
                  {
//                      System.out.println("File copy overwrite = false");
                      fileCopyReturnCode = copyFile(dlDir + (String)fileCopyUpdateObjectArray[i], rootDir + (String)fileCopyUpdateObjectArray[i], false);                                          
                  }
                   // end
                   //int fileCopyReturnCode = copyFile(dlDir + (String)fileCopyUpdateObjectArray[i], rootDir + (String)fileCopyUpdateObjectArray[i], isOverwritable);
 //                  System.out.println("File copy of " + rootDir + (String)fileCopyUpdateObjectArray[i] + ". Return Code = " + fileCopyReturnCode);
                   if(fileCopyReturnCode!=0)
                   {
                       isSuccess=false;
                   }
               }
               if(isSuccess==true)
               {
                EncryptedRuleReader.updateID(EncryptedUpdateReader.get("updateid"));    
                EncryptedRuleReader.updateInProgress(false);
                EncryptedRuleReader.updateStatus(0);
                return 0;
               }
               else
               {
                  // TODO: Create Handling Code for this problem.
                   //System.out.println("************* 4. Warning: Unable to finish update. *************");
                   if(EncryptedUpdateReader.get("msgmaxattempts")!=null)
                   {
                       try
                       {
                           if(EncryptedRuleReader.allowUpdateAttempt(Integer.parseInt(EncryptedUpdateReader.get("msgmaxattempts")))==false)
                           {
                                EncryptedRuleReader.updateID(EncryptedUpdateReader.get("updateid"));    
                                EncryptedRuleReader.updateInProgress(false);   
                                EncryptedRuleReader.updateNeeded(false);
                                EncryptedRuleReader.updateStatus(1);
                                getUpdateWillNotCompleteMessage();
                                return 1;
                           }
                       }
                       catch(Exception e)
                       {
                           
                       }
                   }
                   EncryptedRuleReader.updateAttempt();
                   return 1;
               }
            }
            else
            {
                // Problem in Overwrite Data, 3 = error, 4 = no files
                //System.out.println("Problem in Overwrite Data, 3 = error, 4 = no files");
               if(EncryptedUpdateReader.get("msgmaxattempts")!=null)
               {
                   try
                   {
                       if(EncryptedRuleReader.allowUpdateAttempt(Integer.parseInt(EncryptedUpdateReader.get("msgmaxattempts")))==false)
                       {
                            EncryptedRuleReader.updateID(EncryptedUpdateReader.get("updateid"));    
                            EncryptedRuleReader.updateInProgress(false);   
                            EncryptedRuleReader.updateNeeded(false);
                            EncryptedRuleReader.updateStatus(overwriteRetCodeValue);
                            getUpdateWillNotCompleteMessage();
                            return overwriteRetCodeValue;
                       }
                   }
                   catch(Exception e)
                   {

                   }
               }
               EncryptedRuleReader.updateAttempt();                
               return overwriteRetCodeValue;
            }        
        }
        catch(Exception eeee)
        {
            eeee.printStackTrace();
           if(EncryptedUpdateReader.get("msgmaxattempts")!=null)
           {
               try
               {
                   if(EncryptedRuleReader.allowUpdateAttempt(Integer.parseInt(EncryptedUpdateReader.get("msgmaxattempts")))==false)
                   {
                        EncryptedRuleReader.updateID(EncryptedUpdateReader.get("updateid"));    
                        EncryptedRuleReader.updateInProgress(false);   
                        EncryptedRuleReader.updateNeeded(false);
                        EncryptedRuleReader.updateStatus(8);
                        getUpdateWillNotCompleteMessage();
                        return 8;
                   }
               }
               catch(Exception e)
               {

               }
           }
           EncryptedRuleReader.updateAttempt();               
            return 8;
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
    
    private void getErrorMessage()
    {
        try
        {
            Class.forName(EncryptedRuleReader.get("autoUpdateErrorAction")).newInstance();
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
    
    private void getUpdateWillNotCompleteMessage()
    {
        try
        {
            Class.forName(EncryptedRuleReader.get("WillNotCompleteAction")).newInstance();
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
}
