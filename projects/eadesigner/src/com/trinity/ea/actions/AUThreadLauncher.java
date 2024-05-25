/*
 * AUThreadLauncher.java
 *
 * Created on December 16, 2004, 12:41 PM
 */

package com.trinity.ea.actions;
import java.net.URL;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import com.trinity.ea.util.SwingWorker;
import java.io.File;
import java.util.ArrayList;
import javax.swing.UIManager;
import java.lang.reflect.Method; 
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URLClassLoader;
 
/**
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class AUThreadLauncher implements Runnable
{
    private Method mainMethod = null;
    /** Creates a new instance of AUThreadLauncher */
    public AUThreadLauncher() 
    {
    }
    
        public void run() 
        {
            // Get the directory (URL) of the reloadable class
            URL[] urls = null;  
            boolean autoUpdateEnabled = false;
            if(EncryptedRuleReader.get("autoUpdateEnabled").equalsIgnoreCase("true")==true)
            {
                autoUpdateEnabled = true;
                try
                {
                    if(EncryptedRuleReader.get("autoUpdateCP")!=null)
                    {
                        if(EncryptedRuleReader.get("autoUpdateCP").equalsIgnoreCase("")==false)
                        {
                            urls = getURLArrayFromString(getRunDirectory(),EncryptedRuleReader.get("autoUpdateCP"));
                        }
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            try
            {
                try
                {
                    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                    System.gc();
                }
                catch(Exception e)
                {
			e.printStackTrace();
		    }
                if(autoUpdateEnabled==true)
                {
                    if(urls!=null)
                    {

                    }
                    else
                    {
                        urls = new URL[0];
                    }
                    // Create a new class loader with the directory
                    ClassLoader cl = new URLClassLoader(urls);
                    // Load in the class
                    Class mainClass = cl.loadClass(EncryptedRuleReader.get("applicationClass"));
                    this.mainMethod=mainClass.getMethod("main",new Class[]{String[].class});
                    mainMethod=this.mainMethod;
        SwingWorker worker2 = new SwingWorker() 
        {
                public Object construct() 
                {

                    return launch(mainMethod);
                }
                public void finished() 
                {
                    //worker.stop();
                }
         };
        worker2.start();

                    //mainMethod.invoke(null,new Object[]{new String[]{}});
                }
                else
                {
                    Class mainClass=Class.forName(EncryptedRuleReader.get("applicationClass"));
                    this.mainMethod=mainClass.getMethod("main",new Class[]{String[].class});
                    mainMethod=this.mainMethod;
                }
                //mainMethod.invoke(null,new Object[]{new String[]{}});
                
            }
        catch(NoSuchMethodException e)
        {
            System.out.println(e);                
        }       
        catch(ClassNotFoundException e)
        {
            System.out.println(e);
        }                 
   }

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
}
