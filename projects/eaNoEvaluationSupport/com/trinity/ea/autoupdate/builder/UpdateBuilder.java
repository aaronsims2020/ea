/*
 * RuleBuilder.java
 *
 * Created on October 24, 2003, 7:58 PM
 */

package com.trinity.ea.autoupdate.builder;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.trinity.ea.util.EAProperties;
import java.security.*;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2003-2004 Trinity Software. All rights reserved.
 */
public class UpdateBuilder 
{
    private static EAProperties props = new EAProperties();
    private static String strRulesFileName = "update.eau"; 
    /** Creates a new instance of RuleBuilder */
    public UpdateBuilder(){}
    
    /** Write the Properties File.
     * @return
     */
    public static boolean writeFile()
    {
        try
        {
            File propFile = new File(getFileName());
            if(propFile.exists()==true)
            {
                    try
                    {
                        FileOutputStream fos = new FileOutputStream(propFile,false);
                        if(props.store(fos)==0)
                        {
                            return true;
                        }
                        else
                        {
                            return false;
                        }
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
                        if(props.store(fos)==0)
                        {
                            return true;
                        }
                        else
                        {
                            return false;
                        }
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
        catch(IOException e)
        {
            return false;
        }
    }

    /** Read the Properties File
     * @return
     */
    public static boolean readPropertiesFile()
    {
       try
        {
            File propFile = new File(getFileName());
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
    
    /** Set the rules filename.
     * @param strFileName
     */
    public static void setFileName(String strFileName)
    {
        strRulesFileName = strFileName;
    }
    
    /** Return the Rules File filename. Default Rules filename is rules.eax
     * @return
     */
    public static String getFileName()
    {
        return strRulesFileName;
    }
    
    public static boolean put(String key, String value)
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
    
    public static String get(String key)
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
    
    public static boolean remove(String key)
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
    
    public static EAProperties getProperties()
    {
        return props;
    }
    
 }
