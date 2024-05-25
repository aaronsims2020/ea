/*
 * ClientDocBuilder.java
 *
 * Created on December 7, 2004, 12:06 AM
 */

package com.trinity.ea.design.common.doc;
import com.trinity.ea.design.common.file.ProjectManager;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

/**
 *
 * @author  aaronsc Trinity Software, LLC
 * Copyright ©2004-2005 Trinity Software, LLC. All rights reserved.
 */
public class ClientDocBuilder 
{
    /** Creates a new instance of ClientDocBuilder */
    public ClientDocBuilder() 
    {
    }
    
    public static File buildClientAUHTMLFile(File textFile, String earunJarFileName, String eademoJarFileName, String rulesFileName, boolean signerNeeded)
    {
        try
        {
            String easignerString = "<br><span style=\"font-family: helvetica,arial,sans-serif;\">4. easigner.jar - Place the easigner.jar in your install program. Do not install easigner.jar.&nbsp;</span><span style=\"font-family: helvetica,arial,sans-serif;\"></span><span style=\"font-family: helvetica,arial,sans-serif;\">Once, the " + rulesFileName + " file is copied to the application root folder, call either of the following two initialization methods in the</span><span style=\"font-family: helvetica,arial,sans-serif;\"> class \"com.trinity.ea.rules.reader.StartTrial\"</span><span style=\"font-family: helvetica,arial,sans-serif;\">, located in the easigner.jar</span><span style=\"font-family: helvetica,arial,sans-serif;\">, to initialize the software evaluation: <br></span><br><span style=\"font-family: arial;\">public static boolean </span><span style=\"font-family: arial;\">initializeTrialByFile</span><span style=\"font-family: arial;\">(java.lang.String&nbsp;strRulesFile) - </span><span style=\"font-family: arial;\">Starts the evaluation process by signing the " + rulesFileName + " file. Pass in the " + rulesFileName + " file pathname, as a String. Returns true on success, or false on failure.<br><br>public static boolean </span><span style=\"font-family: arial;\">setInitializeTrialByURL</span><span style=\"font-family: arial;\">(java.lang.String&nbsp;strRulesFileURL) - </span><span style=\"font-family: arial;\">Starts the evaluation process by signing the " + rulesFileName + " file. Pass in the " + rulesFileName + " file URL, as a String. Returns true on success, or false on failure.</span><br>";
            String updateJarCP="application root directory";         
            String clientdoc = "";   
            if(signerNeeded == true)
            {
                clientdoc = "<html><head><title>EvaluateAnywhere Distribution Client - Implementation Instructions</title>  <meta content=\"Trinity Software, LLC\" name=\"author\"></head><body alink=\"#000099\" vlink=\"#990099\" link=\"#000099\" style=\"color: rgb(0, 0, 0); background-color: rgb(255, 255, 255);\"><span style=\"font-family: helvetica,arial,sans-serif;\">EvaluateAnywhere Distribution Client - Implementation Instructions</span><br style=\"font-family: helvetica,arial,sans-serif;\"><br style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\">EvaluateAnywhere Distribution Client in a Java application:<br><br style=\"font-family: helvetica,arial,sans-serif;\"></span><span style=\"font-family: helvetica,arial,sans-serif;\">1. " + rulesFileName + " - Place " + rulesFileName + " in the application root folder (The folder the application is launched from). Do not include the " + rulesFileName + " file in the Classpath.<br><br style=\"font-family: helvetica,arial,sans-serif;\"></span><span style=\"font-family: helvetica,arial,sans-serif;\">2. " + earunJarFileName + " - Place " + earunJarFileName + " in the application Classpath. </span><span style=\"font-family: helvetica,arial,sans-serif;\">The EvaluateAnywhere Distribution Client Main Class is \"com.trinity.ea.EvaluateAnywhere\". Launch the application with this Java class. \"" + earunJarFileName + "\" is an executable Jar.</span><br style=\"font-family: helvetica,arial,sans-serif;\"><br><span style=\"font-family: helvetica,arial,sans-serif;\"></span><span style=\"font-family: helvetica,arial,sans-serif;\">3. " + eademoJarFileName + " - Place " + eademoJarFileName + " in the " + updateJarCP + " file path location.  </span><span style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\">Do not include the </span></span><span style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\">" + eademoJarFileName + "</span></span></span><span style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\"> file in the Application/System Classpath.<br><br>Note: </span></span><span style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\">Files added to the System/Application Classpath cannot be updated with the automatic update feature. </span></span></span></span></span></span><span style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\">EvaluateAnywhere Designer Automatic Update feature provides the ability to add items to the Application Classpath, that are updatable. </span></span><span style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\"></span></span><br style=\"font-family: helvetica,arial,sans-serif;\"></span></span>" + easignerString + "<br style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\">Copyright &copy;2003-2005 Trinity Software, LLC. All rights reserved.</span><br></body></html>";
            }
            else
            {
                clientdoc = "<html><head><title>EvaluateAnywhere Distribution Client - Implementation Instructions</title>  <meta content=\"Trinity Software, LLC\" name=\"author\"></head><body alink=\"#000099\" vlink=\"#990099\" link=\"#000099\" style=\"color: rgb(0, 0, 0); background-color: rgb(255, 255, 255);\"><span style=\"font-family: helvetica,arial,sans-serif;\">EvaluateAnywhere Distribution Client - Implementation Instructions</span><br style=\"font-family: helvetica,arial,sans-serif;\"><br style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\">EvaluateAnywhere Distribution Client in a Java application:<br><br style=\"font-family: helvetica,arial,sans-serif;\"></span><span style=\"font-family: helvetica,arial,sans-serif;\">1. " + rulesFileName + " - Place " + rulesFileName + " in the application root folder (The folder the application is launched from). Do not include the " + rulesFileName + " file in the Classpath.<br><br style=\"font-family: helvetica,arial,sans-serif;\"></span><span style=\"font-family: helvetica,arial,sans-serif;\">2. " + earunJarFileName + " - Place " + earunJarFileName + " in the application Classpath. </span><span style=\"font-family: helvetica,arial,sans-serif;\">The EvaluateAnywhere Distribution Client Main Class is \"com.trinity.ea.EvaluateAnywhere\". Launch the application with this Java class. \"" + earunJarFileName + "\" is an executable Jar.</span><br style=\"font-family: helvetica,arial,sans-serif;\"><br><span style=\"font-family: helvetica,arial,sans-serif;\"></span><span style=\"font-family: helvetica,arial,sans-serif;\">3. " + eademoJarFileName + " - Place " + eademoJarFileName + " in the " + updateJarCP + " file path location.  </span><span style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\">Do not include the </span></span><span style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\">" + eademoJarFileName + "</span></span></span><span style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\"> file in the Application/System Classpath.<br><br>Note: </span></span><span style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\">Files added to the System/Application Classpath cannot be updated with the automatic update feature. </span></span></span></span></span></span><span style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\">EvaluateAnywhere Designer Automatic Update feature provides the ability to add items to the Application Classpath, that are updatable. </span></span><span style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\"></span></span><br style=\"font-family: helvetica,arial,sans-serif;\"></span></span><br style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\">Copyright &copy;2003-2005 Trinity Software, LLC. All rights reserved.</span><br></body></html>";
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(textFile));
            out.write(clientdoc);
            out.close();
            return textFile;
        }
        catch(Exception e)
        {
            return textFile;           
        }
    }
    
    public static File buildClientNoAUHTMLFile(File textFile, String earunJarFileName, String eademoJarFileName, String rulesFileName, boolean signerNeeded)
    {
        try
        {
            String easignerString = "<span style=\"font-family: helvetica,arial,sans-serif;\">3. easigner.jar - Place the easigner.jar in your install program. Do not install easigner.jar.&nbsp;</span><span style=\"font-family: helvetica,arial,sans-serif;\"></span><span style=\"font-family: helvetica,arial,sans-serif;\">Once, the " + rulesFileName + " file is copied to the application root folder, call either of the following two initialization methods in the</span><span style=\"font-family: helvetica,arial,sans-serif;\"> class \"com.trinity.ea.rules.reader.StartTrial\"</span><span style=\"font-family: helvetica,arial,sans-serif;\">, located in the easigner.jar</span><span style=\"font-family: helvetica,arial,sans-serif;\">, to initialize the software evaluation: <br></span><br><span style=\"font-family: arial;\">public static boolean </span><span style=\"font-family: arial;\">initializeTrialByFile</span><span style=\"font-family: arial;\">(java.lang.String&nbsp;strRulesFile) - </span><span style=\"font-family: arial;\">Starts the evaluation process by signing the " + rulesFileName + " file. Pass in the " + rulesFileName + " file pathname, as a String. Returns true on success, or false on failure.<br><br>public static boolean </span><span style=\"font-family: arial;\">setInitializeTrialByURL</span><span style=\"font-family: arial;\">(java.lang.String&nbsp;strRulesFileURL) - </span><span style=\"font-family: arial;\">Starts the evaluation process by signing the " + rulesFileName + " file. Pass in the " + rulesFileName + " file URL, as a String. Returns true on success, or false on failure.</span><br>";
            String clientDoc = "";
            if(signerNeeded == true)
            {
                clientDoc = "<html><head><title>EvaluateAnywhere Distribution Client - Implementation Instructions</title><meta content=\"Trinity Software, LLC\" name=\"author\"></head><body alink=\"#000099\" vlink=\"#990099\" link=\"#000099\" style=\"color: rgb(0, 0, 0); background-color: rgb(255, 255, 255);\"><span style=\"font-family: helvetica,arial,sans-serif;\">EvaluateAnywhere Distribution Client - Implementation Instructions</span><br style=\"font-family: helvetica,arial,sans-serif;\"><br style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\">EvaluateAnywhere Distribution Client in a Java application:<br><br style=\"font-family: helvetica,arial,sans-serif;\"></span><span style=\"font-family: helvetica,arial,sans-serif;\">1. " + rulesFileName + " - Place " + rulesFileName + " in the application root folder (The folder the application is launched from). Do not include the " + rulesFileName + " file in the Classpath.<br><br style=\"font-family: helvetica,arial,sans-serif;\"></span><span style=\"font-family: helvetica,arial,sans-serif;\">2. " + earunJarFileName + " - Place " + earunJarFileName + " in the application Classpath. </span><span style=\"font-family: helvetica,arial,sans-serif;\">The EvaluateAnywhere Distribution Client Main Class is \"com.trinity.ea.EvaluateAnywhere\". Launch the application with this Java class.</span><br style=\"font-family: helvetica,arial,sans-serif;\"><br style=\"font-family: helvetica,arial,sans-serif;\">" + easignerString + "<br style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\">Copyright &copy;2003-2005 Trinity Software, LLC. All rights reserved.</span><br></body></html>";
            }
            else
            {
                clientDoc = "<html><head><title>EvaluateAnywhere Distribution Client - Implementation Instructions</title><meta content=\"Trinity Software, LLC\" name=\"author\"></head><body alink=\"#000099\" vlink=\"#990099\" link=\"#000099\" style=\"color: rgb(0, 0, 0); background-color: rgb(255, 255, 255);\"><span style=\"font-family: helvetica,arial,sans-serif;\">EvaluateAnywhere Distribution Client - Implementation Instructions</span><br style=\"font-family: helvetica,arial,sans-serif;\"><br style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\">EvaluateAnywhere Distribution Client in a Java application:<br><br style=\"font-family: helvetica,arial,sans-serif;\"></span><span style=\"font-family: helvetica,arial,sans-serif;\">1. " + rulesFileName + " - Place " + rulesFileName + " in the application root folder (The folder the application is launched from). Do not include the " + rulesFileName + " file in the Classpath.<br><br style=\"font-family: helvetica,arial,sans-serif;\"></span><span style=\"font-family: helvetica,arial,sans-serif;\">2. " + earunJarFileName + " - Place " + earunJarFileName + " in the application Classpath. </span><span style=\"font-family: helvetica,arial,sans-serif;\">The EvaluateAnywhere Distribution Client Main Class is \"com.trinity.ea.EvaluateAnywhere\". Launch the application with this Java class.</span><br style=\"font-family: helvetica,arial,sans-serif;\"><br style=\"font-family: helvetica,arial,sans-serif;\"><br style=\"font-family: helvetica,arial,sans-serif;\"><span style=\"font-family: helvetica,arial,sans-serif;\">Copyright &copy;2003-2005 Trinity Software, LLC. All rights reserved.</span><br></body></html>";
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(textFile));
            out.write(clientDoc);
            out.close();
            return textFile;
        }
        catch(Exception e)
        {
            return textFile;           
        }
    }     
    
   private static String getJarClasspathString()
   {
       try
        {   
           if(ProjectManager.get("autoUpdateCP")!=null)
           {
                if(ProjectManager.get("autoUpdateCP").equalsIgnoreCase("")==false)
                {    
                    Object[] tempArray = getStringArrayFromString(ProjectManager.get("autoUpdateCP"));
			  for(int i = 0;i<tempArray.length;i++)
			  {
				try
				{
					String currentJarStr = ProjectManager.get("project_jarfile2_name");
					if(currentJarStr.equalsIgnoreCase("")==false)
					{
						String tmpStr = (String)tempArray[i];
						if(tmpStr.indexOf(currentJarStr)!=-1)
						{
							return tmpStr;
						}
					}
				}
				catch(Exception e)
				{

				}
			  }
                }
            }
        }
        catch(Exception e)
        {
            //e.printStackTrace();
        }
	return "application root directory";
    }

    private static Object[] getStringArrayFromString(String theString)
    {
        ArrayList al = new ArrayList();
        String parseString = theString;
        if(parseString.indexOf(",") !=-1)
        {
            while(parseString.indexOf(",") !=-1)
            {
                al.add(parseString.substring(0,parseString.indexOf(",")));
                parseString = parseString.substring(parseString.indexOf(",") + 1);
            }
            al.add(parseString);
            al.trimToSize();
            //Parse key/pair values
            return al.toArray();
        }  
        al.add(parseString);
        al.trimToSize();
        //Parse key/pair values
        return al.toArray();        
    }        
}
