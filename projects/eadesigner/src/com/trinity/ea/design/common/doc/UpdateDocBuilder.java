/*
 * UpdateDocBuilder.java
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
public class UpdateDocBuilder 
{
    
    /** Creates a new instance of UpdateDocBuilder */
    public UpdateDocBuilder() 
    {
    }
    
     public static File buildMultiLangMessageREADMEHTMLFile(File textFile, String msgIDNumber, String[] msgFileArray, String[] msgURLArray, Object[] fileDownloadURLS, Object[] installFiles, Object[] overwriteFiles)
    {
        try
        {
            String msgFileList = "";  
            String msgFiles = "";
            for(int i = 0;i<msgFileArray.length;i++)
            {
                msgFileList = msgFileList + "<br style=\"font-family: arial;\"><span style=\"font-family: arial;\">" + msgFileArray[i] + " - " + msgURLArray[i] + "</span>";
            }
            for(int i = 0;i<fileDownloadURLS.length;i++)
            {
                msgFiles = msgFiles + "<br style=\"font-family: arial;\"><span style=\"font-family: arial;\">" + ((String)installFiles[i]) + " (overwrite existing file: " + ((String)overwriteFiles[i]) + ") - " + ((String)fileDownloadURLS[i]) + "</span>";
            }           
            
            String clientdoc = "<html><head><meta content=\"text/html; charset=ISO-8859-1\" http-equiv=\"content-type\"><title>Implementation Instructions for Multi-Language Automatic Software Update ID " + msgIDNumber + ":</title></head><body><span style=\"font-family: arial; font-weight: bold;\">Multi-Language Automatic Software Update ID number " + msgIDNumber + ": </span><br style=\"font-family: arial;\"><span style=\"font-family: arial;\">To deliver this software update, copy the following files to the specified locations:</span><br style=\"font-family: arial;\">" + msgFileList + "<br style=\"font-family: arial;\"><br style=\"font-family: arial;\"><span style=\"font-family: arial;\">This software update must not be installed on alternate address software update URLs. To install this software update on alternate URLs rebuild the software update with the specified Automatic Software Update File Download URL, and Software Update ID number. </span><br><br style=\"font-family: arial;\"><span style=\"font-family: arial;\">The following files are required by this automatic software update:</span><br>" + msgFiles + "<br><br></body></html>";
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
     
    public static File buildUniversalMessageREADMEHTMLFile(File textFile, String msgIDNumber, String message_file, String[] msgURLArray, Object[] fileDownloadURLS, Object[] installFiles, Object[] overwriteFiles)
    {
        try
        {
            String msgFiles = "";           
            String url_list = "<br style=\"font-family: arial;\"><span style=\"font-family: arial;\">Primary Message Download URL: " + msgURLArray[0] + "</span>";          
            for(int i = 1;i<msgURLArray.length;i++)
            {
                url_list = url_list + "<br style=\"font-family: arial;\"><span style=\"font-family: arial;\">Alternate Message Download URL " + String.valueOf(i) + ": " +  msgURLArray[i] + "</span>";
            }
            for(int i = 0;i<fileDownloadURLS.length;i++)
            {
                msgFiles = msgFiles + "<br style=\"font-family: arial;\"><span style=\"font-family: arial;\">" + ((String)installFiles[i]) + " (overwrite existing file: " + ((String)overwriteFiles[i]) + ") - " + ((String)fileDownloadURLS[i]) + "</span>";
            }                 
            String clientdoc = "<html><head><meta content=\"text/html; charset=ISO-8859-1\" http-equiv=\"content-type\"><title>Implementation Instructions for Automatic Software Update ID " + msgIDNumber + ":</title></head><body><span style=\"font-family: arial; font-weight: bold;\"></span><span style=\"font-family: arial;\"></span><span style=\"font-family: arial; font-weight: bold;\">Automatic Software Update ID number " + msgIDNumber + ": </span><br><span style=\"font-family: arial;\">To deliver this software update, copy the " + message_file + " file to this automatic software update file download URL locations.</span><br style=\"font-family: arial;\"><br style=\"font-family: arial;\"><span style=\"font-family: arial;\">The following URLs are pre-defined automatic software update file download URL's:<br><br style=\"font-family: arial;\"></span>" + url_list + "<br><br style=\"font-family: arial;\"><span style=\"font-family: arial;\">The following files are required by this automatic software update:</span><br>" + msgFiles + "<br></body></html>";
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
 
    public static File buildChangeURLMessageREADMEHTMLFile(File textFile, String msgIDNumber, String message_file, String[] msgURLArray)
    {
        try
        {
            String url_list = "<br style=\"font-family: arial;\"><span style=\"font-family: arial;\">Primary Software Update Download URL: " + msgURLArray[0] + "</span>";          
            for(int i = 1;i<msgURLArray.length;i++)
            {
                url_list = url_list + "<br style=\"font-family: arial;\"><span style=\"font-family: arial;\">Alternate Software Update Download URL " + String.valueOf(i) + ": " +  msgURLArray[i] + "</span>";
            }
            String clientdoc = "<html><head><meta content=\"text/html; charset=ISO-8859-1\" http-equiv=\"content-type\"><title>Implementation Instructions for Automatic Software Update Change URL ID " + msgIDNumber + ":</title></head><body><span style=\"font-family: arial; font-weight: bold;\"></span><span style=\"font-family: arial;\"></span><span style=\"font-family: arial; font-weight: bold;\">Automatic Software Update Change URL ID number " + msgIDNumber + ": </span><br><span style=\"font-family: arial;\">To deliver this Automatic Software Update Change URL file, copy the " + message_file + " file to the automatic software update file download URL locations.</span><br style=\"font-family: arial;\"><br style=\"font-family: arial;\"><span style=\"font-family: arial;\">The following URLs are pre-defined automatic software update file download URL's:<br><br style=\"font-family: arial;\"></span>" + url_list + "<br></body></html>";        
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
