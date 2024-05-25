/*
 * RuleReader.java
 *
 * Created on October 24, 2003, 7:59 PM
 */

package com.trinity.ea.rules.reader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.trinity.ea.util.EAProperties;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2003 Trinity Software. All rights reserved.
 */
public class RuleReader 
{
    private static EAProperties props = new EAProperties();
    private static String strRulesFileName = "rules.eax";   
    /** Creates a new instance of RuleReader */
    public RuleReader() 
    {
    
    }

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
    
    /** Set the rules filename. */
    public static void setFileName(String strFileName)
    {
        strRulesFileName = strFileName;
    }
    
    /** Return the Rules File filename. Default Rules filename is rules.eax */
    public static String getFileName()
    {
        return strRulesFileName;
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
    
    public static EAProperties getProperties()
    {
        return props;
    }    
}
