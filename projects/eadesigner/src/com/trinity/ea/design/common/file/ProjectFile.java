/*
 * ProjectFile.java
 *
 * Created on March 19th, 2004 2:21PM
 */

package com.trinity.ea.design.common.file;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import com.trinity.ea.util.EAProperties;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class ProjectFile 
{
    private EAProperties props = new EAProperties();
    private String strRulesFileName = "My_Product.eax"; 
    File propFile = null;
    /** Creates a new instance of ProjectFile */
    public ProjectFile(String strFileURL)
    {
        strRulesFileName=strFileURL;
        try
        {
            propFile = new File(new URL(getFileName()).getFile());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
   
    /** Write the Properties File. */
    public boolean saveProject()
    {
        try
        {
            if(propFile.exists()==true)
            {
                    try
                    {
                        FileOutputStream fos = new FileOutputStream(propFile,false);
                        props.store(fos);
                        return true;
                    }
                    catch(FileNotFoundException ee)
                    {
                        return false;
                    }
            }
            else
            {
                if(propFile.createNewFile()==true)
                {
                    try
                    {
                        FileOutputStream fos = new FileOutputStream(propFile,false);
                        props.store(fos);
                        return true;
                    }
                    catch(FileNotFoundException ee)
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
                
               
            }
        }
        catch(MalformedURLException e)
        {
            return false;
        }
        catch(IOException e)
        {
            return false;
        }
    }

    /** Read the Properties File */
    public boolean openProject()
    {
       try
        {
            if(propFile.exists()==true)
            {
                    try
                    {
                        FileInputStream fis = new FileInputStream(propFile);
                        //propFile);
                        props.load(fis);
                        return true;
                    }
                    catch(IOException ee)
                    {
                        return false;
                    }
            }
            else
            {
                 return false;
            }
        }
        catch(Exception e)
        {
            return false;
        }        
    }    
    
    /** Set the rules filename. */
    public void setFileName(String strFileName)
    {
        strRulesFileName = strFileName;
    }
    
    /** Return the Rules File filename. Default Rules filename is rules.eax */
    public String getFileName()
    {
        return strRulesFileName;
    }
    
    public boolean put(String key, String value)
    {
         try
        {
            props.put(key,value);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }       
    }
    
    public String get(String key)
    {
        try
        {
            return (String)props.get(key);
        }
        catch(Exception e)
        {
            return null;
        }
    }   
    
    public boolean remove(String key)
    {
        try
        {
            props.remove(key);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }    
    
    public void setProperties(EAProperties theEAProperties)
    {
        props=theEAProperties;
    }   
    
    public EAProperties getProperties()
    {
        return props;
    }
    
 }
