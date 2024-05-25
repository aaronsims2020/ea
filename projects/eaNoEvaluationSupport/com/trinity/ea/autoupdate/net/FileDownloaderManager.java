/*
 * FileDownloaderManager.java
 *
 * Created on January 2, 2004, 5:29 PM
 */

package com.trinity.ea.autoupdate.net;
import java.net.*;
import java.io.*;
import java.util.*;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import com.trinity.ea.autoupdate.reader.EncryptedUpdateReader;
import com.trinity.ea.net.FileDownloader;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2004 Trinity Software. All rights reserved.
 */
public class FileDownloaderManager implements Runnable 
{
    /** Creates a new instance of FileDownloaderManager */
    String strUrl;
    String directory;
    Map overwriteHM;
    private static int updateStatus = 1;    
    
    public FileDownloaderManager(String strUrl, String directory) 
    {
        //EncryptedRuleReader.readPropertiesFile();
        this.strUrl   = strUrl;
        this.directory = directory;
    }
    public void run() 
    {
        int updateFileRetCode = 1;
        try 
        {
            String dlDirectory = null;
            String wrkDirectory = null;
            String tmpUpdateID = null;
            String origUpdateID = null;
            updateFileRetCode = FileDownloader.downloadFile(this.strUrl, this.directory);
            /* if the update file returns a value not successful try downloading from another URL if permitted by the max EncryptedRuleReader autoUpdateMaxBaseURLs Property value. */
            if(updateFileRetCode!=0)
            {
                //System.out.println("Failed to download primary update file, attempting alternate download locations.");
                try
                {
                    if(EncryptedRuleReader.get("autoUpdateMaxBaseURLs")!=null)
                    {
                        int theMaxURLList = Integer.valueOf(EncryptedRuleReader.get("autoUpdateMaxBaseURLs")).intValue();
                        if(theMaxURLList>1)
                        {
                            //System.out.println("The maximum update file URLs that will be used to attempt to download the update file is: " + theMaxURLList);
                            /* if the Maximum number of URLs is greater than one then Try Alternate URLs. */
                            for(int i = 0;i<theMaxURLList;i++)
                            {
                                if(getAlternateURL(i)!=null)
                                {
                                    //System.out.println("Attempting Connection to Alternate URL " + i + ": " + getAlternateURL(i));
                                    updateFileRetCode = FileDownloader.downloadFile(getAlternateURL(i), this.directory);
                                    if(updateFileRetCode == 0)
                                    {
                                        /* if return code is 0, end loop */
                                        i=theMaxURLList;
                                        //System.out.println("Successfully Downloaded from Alternate URL " + i + ": " + getAlternateURL(i));
                                    }
                                }
                                else
                                {
                                   // System.out.println("Attempted Alternate URL " + i + " was null.");  
                                }
                            }
                        }
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                //System.out.println("Successfully downloaded primary update file.");
                //System.out.println("Instance 1.");
            }
            
            if(updateFileRetCode==0)
            {         
                //System.out.println("Inside update file return code = 0, reading temp update file");
                 
                boolean tempUpdateFileBool = EncryptedUpdateReader.readTempUpdateFile();
                //System.out.println("Successfully read Temporary Update File equals: " + tempUpdateFileBool); 
                /* Check the downloaded update file for the updateid. */
                if(EncryptedUpdateReader.get("updateid")!=null)
                {
                    tmpUpdateID = EncryptedUpdateReader.get("updateid");
                    try
                    {
                    //System.out.println("Attempting to perform a Base URL Update check. Entering UpdateID Check...");

                        if(EncryptedRuleReader.get("autoUpdateUpdateID")!=null)
                        {
                            if(EncryptedRuleReader.get("autoUpdateUpdateID").equals(EncryptedUpdateReader.get("updateid"))==false)
                            {   
                                //System.out.println("********************Calling getBaseURLCheck()*************************");
                                getBaseURLCheck();
                                //System.out.println("*********************Successfully Called getBaseURLCheck()********************************");                           
                            }
                        }
                    }
                    catch(Exception eeeee)
                    {
                        eeeee.printStackTrace();
                    }
                }
                //System.out.println("Update File Return Code: " + updateFileRetCode);
                if(EncryptedRuleReader.get("autoUpdateDownloadDir")!=null)
                {
                    if(EncryptedRuleReader.get("autoUpdateTempFileName")!=null)
                    {
                        dlDirectory = EncryptedRuleReader.get("autoUpdateDownloadDir") + "/" + EncryptedRuleReader.get("autoUpdateTempFileName");
                        try
                        {
                          File theDirect2 = new File(EncryptedRuleReader.get("autoUpdateDownloadDir"));   
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
                if(EncryptedRuleReader.get("autoUpdateWorkDir")!=null)
                {        
                    if(EncryptedRuleReader.get("autoUpdateFileName")!=null)
                    {
                        wrkDirectory = EncryptedRuleReader.get("autoUpdateWorkDir") + "/" + EncryptedRuleReader.get("autoUpdateFileName");
                        try
                        {
                          File theDirect = new File(EncryptedRuleReader.get("autoUpdateWorkDir"));   
                          if(theDirect.exists()==false)
                          {
                              //System.out.println("Making directory: " + theDirect.getAbsolutePath());
                              boolean isCreated = theDirect.mkdirs();
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
                //System.out.println("Set Download Directory Update File: " + dlDirectory);
                //System.out.println("Set Work Directory Update File: " + wrkDirectory);            
                File wrkFileTemp = new File(wrkDirectory);
                if(wrkFileTemp.exists()==true)
                {
                    //System.out.println("Work Directory Update File Exists is true.");   
                    EncryptedUpdateReader.readUpdateFile();
                    if(EncryptedUpdateReader.get("updateid")!=null)
                    {
                        origUpdateID = EncryptedUpdateReader.get("updateid");
                        if(origUpdateID.equalsIgnoreCase(tmpUpdateID)==true)
                        {
                            // Nothing needs to be done Work directory is already loaded.
                        }
                        else
                        {
                            try
                            {
                                //System.out.println("Deleting old update file to replace with new file.");
                                wrkFileTemp.delete();
                                //System.out.println("Deleted Successfully");
                                if(updateFileRetCode==0)
                                {
                                    int sttus = copyFile(new File(dlDirectory),wrkFileTemp);
                                    if (sttus==0) 
                                    {
                                        // File was successfully moved
                                        //System.out.println("Successfully Downloaded, and copied update file.");
                                        EncryptedUpdateReader.readUpdateFile();
                                    }
                                    else
                                    {
                                         //System.out.println("Failed to copy update file. Ret code: " + sttus);                   
                                        EncryptedUpdateReader.readUpdateFile();
                                    }
                                }

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
                        //System.out.println("Work Directory Update File Exists is false."); 
                        try
                        {
                            if(updateFileRetCode==0)
                            {
                                int sttus = copyFile(new File(dlDirectory),wrkFileTemp);
                                if (sttus==0) 
                                {
                                    // File was successfully moved
                                    //System.out.println("Successfully Downloaded, and copied update file.");
                                    EncryptedUpdateReader.readUpdateFile();
                                }
                                else
                                {
                                    EncryptedUpdateReader.readUpdateFile();
                                    //System.out.println("Failed to copy update file. Ret code: " + sttus);                   
                                }
                            }

                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }                
                    }
                }
                else
                {
                    //System.out.println("Did not download update file.");
                //System.out.println("Instance 2.");                    
                }
            } 
            catch(Exception e)
            {
                e.printStackTrace();
            }
        
            if(updateFileRetCode==0)
            {   
                //System.out.println("Made it through default directory checking, now doing work.");
                try
                {
                    if(EncryptedRuleReader.get("autoUpdateUpdateInProgress").equalsIgnoreCase("true")==true)
                    {
                              //temp
                        //System.out.println("Update in Progress from last load.");
                                int vfdc = verifyFileDownloadsComplete();
                                if(vfdc==0)
                                {
                                    getFileDownloadsVerifiedSuccess();
                                }
                                else if(vfdc==1)
                                {
                                    //System.out.println("File Downloads Incomplete");                            
                                }
                                else if(vfdc==2)
                                {
                                    // EncryptedUpdateReader.get("dldFiles")
                                    EncryptedUpdateReader.getDownloadedFilesReset();
                                    //System.out.println("Reset File Downloads In Update File.");                                                         
                                    getNewUpdate();
                                    if(verifyFileDownloadsComplete()==0)
                                    {
                                      getFileDownloadsVerifiedSuccess();  
                                      //System.out.println("File Downloads Verified Complete Success");                              
                                    }
                                    else
                                    {
                                        EncryptedUpdateReader.getDownloadedFilesReset();
                                      //System.out.println("File Downloads Verified Complete Success");                              
                                    }                         
                                }
                                else if(vfdc==3)
                                {
                                      //System.out.println("File Downloads Corrupted File Downloads Array String");                            
                                }
                                else
                                {
                                      //System.out.println("File Downloads Unknown error return code: " + vfdc);  
                                }

                    }
                    else
                    {
                       // System.out.println("Updating current product...");               
                        EncryptedUpdateReader.readUpdateFile();
                        /* If update id is not equal to current, perform update. */
                        //System.out.println("Checking current version of product and update ID..."); 
                        if(EncryptedRuleReader.get("autoUpdateUpdateID").equals(EncryptedUpdateReader.get("updateid"))==false)
                        {
                            //System.out.println("Update ID is not the same, starting product update...");
                            try
                            {
                                getNewUpdate();
        // Temporarily added verifyFileDownloadsComplete() file downloads added for tests.
                                int vfdc = verifyFileDownloadsComplete();
                                if(vfdc==0)
                                {
                                    // TODO: Copy Files to locations
                                    //System.out.println("File Downloads Verified Complete Success");
                                    //EncryptedRuleReader.updateID(EncryptedUpdateReader.get("updateid"));    
                                    //EncryptedRuleReader.updateInProgress(false);
                                }
                                else if(vfdc==1)
                                {
                                   // System.out.println("File Downloads Incomplete");                            
                                }
                                else if(vfdc==2)
                                {
                                    // EncryptedUpdateReader.get("dldFiles")
                                    EncryptedUpdateReader.getDownloadedFilesReset();
                                    //System.out.println("Reset File Downloads In Update File.");                                                         
                                    getNewUpdate();
                                    if(verifyFileDownloadsComplete()==0)
                                    {
                                      //System.out.println("File Downloads Verified Complete Success");                              
                                    }
                                    else
                                    {
                                        EncryptedUpdateReader.getDownloadedFilesReset();
                                      //System.out.println("File Downloads Verified Complete Success");                              
                                    }
                                }
                                else if(vfdc==3)
                                {
                                      //System.out.println("File Downloads Corrupted File Downloads Array String");                            
                                }
                                else
                                {
                                      //System.out.println("File Downloads Unknown error return code: " + vfdc);  
                                }
                            }
                            catch(Exception e)
                            {
                             e.printStackTrace();   
                            }
                        }
                        else
                        {
        //System.out.println("Update ID same. No update is necessary...");
                            // Set last update to current.
                             EncryptedRuleReader.lastUpdate();               
                        }
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
    }
    
    private synchronized void getNewUpdate()
    {
        try
        {
            EncryptedRuleReader.updateInProgress(true);
            //Specify the update time of the server check.
            EncryptedRuleReader.lastUpdate();
            if(EncryptedUpdateReader.readUpdateFile()==true)
            {
                //System.out.println("Read Update File: true");
                //System.out.println("EncryptedUpdateReader Files: " + EncryptedUpdateReader.get("files"));
                //System.out.println("EncryptedUpdateReader Copy Files to: " + EncryptedUpdateReader.get("copyfilesto"));
                //Perform the update by starting file downloads
                if(EncryptedUpdateReader.get("files")!=null)
                {
                    if(EncryptedUpdateReader.get("copyfilesto")!=null)
                    {                          
                        String strFiles = EncryptedUpdateReader.get("files");
                        Object[] theStrArray = getStringArraysFromString(strFiles);
                        Object[] theCopyToArray = getStringArraysFromString(EncryptedUpdateReader.get("copyfilesto"));
                        //System.out.println("theStrArray.length: " + theStrArray.length + " theCopyToArray.length: " + theCopyToArray.length);
                        for(int i = 0;i < theStrArray.length;i++)
                        {
                            int retCode = FileDownloader.downloadFile((String)theStrArray[i], EncryptedRuleReader.get("autoUpdateDownloadDir") + getDownloadDirFromFileString((String)theCopyToArray[i]));
                            //System.out.println("File Return Code: " + retCode);
                            if(retCode==0)
                            {
                                EncryptedUpdateReader.downloadedFileList((String)theStrArray[i]);
                            }
                            else
                            {
                                // error handling code for download files goes here.
                            }
                        }
                    }
                }
            }
            else
            {
                //System.out.println("Read Update File: false");                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private synchronized void getFileDownloadsVerifiedSuccess()
    {
          // TODO: Check if each file exists, and verify if it is permissions allow overwriting existing files.
        //System.out.println("File Downloads Verified Complete Success");
        int overwriteRetCodeValue = getInitializeOverwriteFileMap();
        if(overwriteRetCodeValue!=3||overwriteRetCodeValue!=4)
        {
           //Get Files to Copy, and their destination. Then finish up routine.
           Object[] fileCopyUpdateObjectArray = getStringArraysFromString(EncryptedUpdateReader.get("copyfilesto"));
           //System.out.println("Copying Downloaded Files to permanent location.");
           boolean isSuccess = true;
           for(int i = 0;i<fileCopyUpdateObjectArray.length;i++)
           {
               File sourceFile = new File(EncryptedRuleReader.get("autoUpdateDownloadDir") + (String)fileCopyUpdateObjectArray[i]);
               File destinationFile = new File(EncryptedRuleReader.get("autoUpdateRootDir") + (String)fileCopyUpdateObjectArray[i]);
               boolean isOverwritable = false;
               // beginning
               int fileCopyReturnCode=1;
              try
              {
                   if(overwriteHM.get((String)fileCopyUpdateObjectArray[i])!=null)
                   {
                        if(((String)overwriteHM.get((String)fileCopyUpdateObjectArray[i])).equalsIgnoreCase("true")==true)
                        {
                            //System.out.println("File copy overwrite = true");
                            fileCopyReturnCode = copyFile(EncryptedRuleReader.get("autoUpdateDownloadDir") + (String)fileCopyUpdateObjectArray[i], EncryptedRuleReader.get("autoUpdateRootDir") + (String)fileCopyUpdateObjectArray[i], true);
                        }
                        else
                        {
                             //System.out.println("File copy overwrite = false");
                            fileCopyReturnCode = copyFile(EncryptedRuleReader.get("autoUpdateDownloadDir") + (String)fileCopyUpdateObjectArray[i], EncryptedRuleReader.get("autoUpdateRootDir") + (String)fileCopyUpdateObjectArray[i], false);                                                
                        }
                   }
                   else
                   {
                       //System.out.println("File copy overwrite = false");
                       fileCopyReturnCode = copyFile(EncryptedRuleReader.get("autoUpdateDownloadDir") + (String)fileCopyUpdateObjectArray[i], EncryptedRuleReader.get("autoUpdateRootDir") + (String)fileCopyUpdateObjectArray[i], false);                                                 
                   }
              }
              catch(Exception e)
              {
                  //System.out.println("File copy overwrite = false");
                  fileCopyReturnCode = copyFile(EncryptedRuleReader.get("autoUpdateDownloadDir") + (String)fileCopyUpdateObjectArray[i], EncryptedRuleReader.get("autoUpdateRootDir") + (String)fileCopyUpdateObjectArray[i], false);                                          
              }
               // end
               //int fileCopyReturnCode = copyFile(EncryptedRuleReader.get("autoUpdateDownloadDir") + (String)fileCopyUpdateObjectArray[i], EncryptedRuleReader.get("autoUpdateRootDir") + (String)fileCopyUpdateObjectArray[i], isOverwritable);
               //System.out.println("File copy of " + EncryptedRuleReader.get("autoUpdateRootDir") + (String)fileCopyUpdateObjectArray[i] + ". Return Code = " + fileCopyReturnCode);
               if(fileCopyReturnCode!=0)
               {
                   isSuccess=false;
               }
           }
           if(isSuccess==true)
           {
            EncryptedRuleReader.updateID(EncryptedUpdateReader.get("updateid"));    
            EncryptedRuleReader.updateInProgress(false);
           }
           else
           {
               // TODO: Create Handling Code for this problem.
               System.out.println("************* 3. Warning: Unable to finish update. *************");

           }
        }
        else
        {
            // Problem in Overwrite Data, 3 = error, 4 = no files
            System.out.println("Problem in Overwrite Data, 3 = error, 4 = no files");
        }
    }

    private synchronized int copyFile(File sourceFile, File destinationFile)
    {
            try
            {
                // Destination directory


                // Move file to new directory
                boolean success = sourceFile.renameTo(destinationFile);
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
 
    private synchronized int copyFile(String sourceFile, String destinationFile, boolean boolOverwriteFile)
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
                                //System.out.println("Deleting old update file to replace with new file.");
                                theDestinationFile.delete();
                                //System.out.println("Deleted Successfully");
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
                                  //System.out.println("Making directory: " + theCopyToDirectory.getAbsolutePath());
                                  boolean isCreated = theCopyToDirectory.mkdirs();
                                  //System.out.println("Created Directory: " + isCreated);    
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
    
    private static synchronized Object[] getStringArraysFromString(String textArrayString)
    {
        ArrayList aryList = new ArrayList();
        String tempString = "";
        
        while(textArrayString.indexOf(",")!=-1)
        {
            tempString = textArrayString.substring(0,textArrayString.indexOf(","));
            textArrayString = textArrayString.substring(textArrayString.indexOf(",") + 1);
            aryList.add(tempString);
        }
        aryList.add(textArrayString);
        return aryList.toArray();
    }
   
    /* returns the install file path minus file and last slash for directory path */
    private static synchronized String getDownloadDirFromFileString(String strFilePath)
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
    private static synchronized int verifyFileDownloadsComplete()
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
                return 2;
            }    
            else
            {
                return 0;
            }  
        }
    }    
    /* Initializes File Overwrite Map for File Overwrite Mappings... Return code for success is 0, 1 is number of overwrite elements is greater than file elements,2 is number of overwrite elements is less than file elements, 3 error in routine, 4 is no files to check for values to overwrite. // additional notes are for other method ///, and returns 0 is overwrite file, 1  is do not overwrite existing file, 2 no files specified to update, 3 is Update File is corrupted, 4 Overwrite File List is corrupted - Repair List is necessary, please clean up data. If unspecified append or overwrite value the default value is do not overwrite. */
    private synchronized int getInitializeOverwriteFileMap()
    {
        this.overwriteHM = Collections.synchronizedMap(new HashMap());
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
    
    private synchronized String getAlternateURL(int alternateURLRef)
    {
        try
        {
            
            return EncryptedRuleReader.get("autoUpdateAlternateURL" + String.valueOf(alternateURLRef));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    private synchronized void getBaseURLCheck()
    {
        //System.out.println("Performing Base URL Update Check...");
            try
            {
                /* Check the downloaded update file for a baseurlchange */
                if(EncryptedUpdateReader.get("baseurlchange")!=null)
                {
                    if(EncryptedUpdateReader.get("baseurlchange").equalsIgnoreCase("true")==true)
                    {
                        //System.out.println("The Base URL changed");
                        //baseurl, and alternateurl#
                        if(EncryptedUpdateReader.get("baseurlupdates")!=null)
                        {                        
                            if(EncryptedUpdateReader.get("validationCode")!=null)
                            {
                                //System.out.println("Updating URL Values, validationCode is good. Validation Code: " + EncryptedUpdateReader.get("validationCode"));
                                Object[] theURLChangeArray = getStringArraysFromString(EncryptedUpdateReader.get("baseurlupdates"));
                                //System.out.println("The number of URL values is: " + theURLChangeArray.length);
                                for(int i = 0;i<theURLChangeArray.length;i++)
                                {
                                    try
                                    {
                                        if(theURLChangeArray[i]!=null)
                                        {
                                            if(((String)theURLChangeArray[i]).trim().equalsIgnoreCase("")==false)
                                            {
                                                //System.out.println("Validation Code: " + EncryptedUpdateReader.get("validationCode") + ", The URL: " + (String)theURLChangeArray[i] + " The Address Position is: " + i);
                                                EncryptedRuleReader.setURLUpdate(EncryptedUpdateReader.get("validationCode"), (String)theURLChangeArray[i], i);
                                            }
                                        }
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
                        
                    }
                }
          
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            try
            {
                /* Check the downloaded update file for a baseurlchange */
                if(EncryptedUpdateReader.get("baseurlchange")!=null)
                {
                    if(EncryptedUpdateReader.get("baseurlchange").equalsIgnoreCase("true")==true)
                    {
                        /* Remove all evidence of a Base URL Update Validation Code */
                        EncryptedUpdateReader.setUpdateVC();
                    }
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }        
    }
}
