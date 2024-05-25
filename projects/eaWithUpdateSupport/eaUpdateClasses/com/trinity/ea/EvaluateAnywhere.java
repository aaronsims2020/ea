/*
 * EvaluateAnywhere.java
 *
 * Created on October 24, 2003, 6:23 PM
 */

package com.trinity.ea;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.File;
import java.io.IOException;
import java.net.URLClassLoader;
import java.lang.ClassLoader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.InputStream;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2003 Trinity Software. All rights reserved.
 */
public class EvaluateAnywhere 
{
    private static Object ea = null;
    //Trial eat = new Trial();/** Creates a new instance of EvaluateAnywhere */
    public EvaluateAnywhere() 
    {
        initUpdateSupport();   
    }
    
    private static synchronized void loadClasses(URL[] classes)
    {
        // Get the directory (URL) of the reloadable class
        URL[] urls = classes;
        try 
        {
            // Create a new class loader with the directory
            ClassLoader cl = new URLClassLoader(urls);
        // Load in the class
        Class cls = cl.loadClass("com.trinity.ea.rules.reader.EAUpdater");
    
        // Create a new instance of the new class
            ea = cls.newInstance();            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
    }    
    
    private static synchronized String getRootDirectory()
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
    
   private static synchronized String getRunDirectory()
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
   
    private static synchronized int copyFile(String sourceFile, String destinationFile, boolean boolOverwriteFile)
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
                        File theCopyToDirectory = new File(getDownloadDirFromFileString(destinationFile));
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
        catch(Exception e)
        {
            return 8;
        }       
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
    
    
    
    // Copies src file to dst file.
    // If the dst file does not exist, it is created
    private static void copy(File src, File dst) throws IOException 
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
    
    private static void initUpdateSupport()
   {
	try
        {
            EncryptedRuleReader.readPropertiesFile();
            String runDir = "";
            String rootDir = "";
             if(EncryptedRuleReader.get("autoUpdateEnabled").equalsIgnoreCase("true")==true)
             {
                 runDir = getRunDirectory();
                 rootDir = getRootDirectory();
                 File tempFile = new File(runDir + "/" + EncryptedRuleReader.get("rootJar"));
                 //System.out.println(rootDir + EncryptedRuleReader.get("rootJar"));
                 //System.out.println(runDir + "/" + EncryptedRuleReader.get("rootJar"));  
                 if(tempFile.exists()==false)
                 {
                    int result = copyFile(rootDir + EncryptedRuleReader.get("rootJar"), runDir + "/" + EncryptedRuleReader.get("rootJar"), true);
                    //System.out.println("Result: " + result);
                    try
                    {
                        URL[] theLoadArray = {new File(runDir + "/" + EncryptedRuleReader.get("rootJar")).toURL()};
                        loadClasses(theLoadArray);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                 }
                 else
                 {
                    try
                    {
                        File srcFile = new File(rootDir + EncryptedRuleReader.get("rootJar"));
			File dstFile = new File(runDir + "/" + EncryptedRuleReader.get("rootJar"));
                        if(srcFile.lastModified()!=dstFile.lastModified() || srcFile.length()!=dstFile.length())
                        {
                             int result = copyFile(rootDir + EncryptedRuleReader.get("rootJar"), runDir + "/" + EncryptedRuleReader.get("rootJar"), true);
                             //System.out.println("Result: " + result);                                  
                        }
                        try
                        {
                            URL[] theLoadArray = {new File(runDir + "/" + EncryptedRuleReader.get("rootJar")).toURL()};
                            loadClasses(theLoadArray);
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                        /////

                        //EvaluateAnywhere ea = new EvaluateAnywhere();
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                 }

             }
        } 
        catch(Exception e)
        {
            e.printStackTrace();
        }
   }
    public static void main(String[] args)
    {
        new EvaluateAnywhere();
    }
}
