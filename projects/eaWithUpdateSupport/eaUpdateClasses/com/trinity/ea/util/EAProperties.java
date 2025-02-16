/*
 * EAProperties.java
 *
 * Created on February 12, 2004, 8:44 PM
 */

package com.trinity.ea.util;
import java.util.Hashtable;
import java.io.StringReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.System;
import java.lang.StringBuffer;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2004 Trinity Software. All rights reserved.
 */
public class EAProperties extends Hashtable
{
    private ByteArrayOutputStream baos;
    private ByteArrayInputStream bais;
    private String str;
    private String comment = null;
    private byte[] buf = new byte[1024]; 
    private static String defaultEncoding = "UTF8";
    private static boolean overrideEncoding = false;
    
    /** Creates a new instance of EAProperties */
    public EAProperties() 
    {
        super();
        try
        {
            if(overrideEncoding==false)
            {
                if(System.getProperty("microedition.encoding")!=null)
                {
                    defaultEncoding = System.getProperty("microedition.encoding");
                }
                else
                {
                    try 
                    {
                        Class.forName("java.nio.Buffer");
                        defaultEncoding="UTF8";
                    } 
                    catch(ClassNotFoundException eee) 
                    {
                        defaultEncoding="UTF8";
                    }               
                }    
            }
        }
        catch(NullPointerException e)
        {
            try 
            {
                Class.forName("java.nio.Buffer");
                defaultEncoding="UTF-16";
            } 
            catch(ClassNotFoundException eee) 
            {
                defaultEncoding="UTF8";
            }
        }
        catch(SecurityException e)
        {
            defaultEncoding="default";
        }
    }
    
    public void load(InputStream is)
    {
        clear();
        String readData = "";
        baos = new ByteArrayOutputStream(1024);
        try
        {
            int numRead = 0;
            while ((numRead = is.read(buf)) >= 0) 
            {
                baos.write(buf, 0, numRead);
            }
            readData = baos.toString();
            baos.close();
            BufferedReader in = new BufferedReader(new StringReader(readData));
            str = readData;
            while (str != null) 
            {
                str = in.readLine();
                if(str!=null)
                {
                    if(str.trim().equalsIgnoreCase("")==false)
                    {               
                        if(str.indexOf("=")!=-1)
                        {
                            put(str.substring(0,str.indexOf("=")), str.substring(str.indexOf("=") + 1));
                        }
                        else
                        {
                            if(str.startsWith("#")==true)
                            {
                                put("#",str);
                            }
                        }
                    }
                }
            }
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public int store(OutputStream os)
    {
        StringBuffer sb = new StringBuffer();
        
        /* Check for a EAProperties comment header. */
        comment = null;
        try
        {
            if(get("#")!=null)
            {
                sb.append((String)get("#") + System.getProperty("line.separator"));
                remove("#");
            }
        }
        catch(Exception e){e.printStackTrace();}
        
        /* Always obtain keySet Object[] after comment is handled. */ 
        Object[] theKeys = keySet().toArray();

        // Buffer used to transport the bytes from one stream to another
        for(int i = 0;i<theKeys.length;i++)
        { 
            try
            {
                if(((String)theKeys[i]).trim().equalsIgnoreCase("")==false)
                {
                    sb.append((String)theKeys[i] + "=");
                    if(get(theKeys[i])!=null)
                    {
                        sb.append((String)get(theKeys[i]) + System.getProperty("line.separator")); 
                    }
                    else
                    {
                        sb.append("" + System.getProperty("line.separator"));                    
                    }
                }
               
            }
            catch(NullPointerException e)
            {
                sb.append("" + System.getProperty("line.separator"));
            }
            catch(Exception e)
            {
                sb.append(System.getProperty("line.separator"));
            }
        }
        try
        {
            try
            {
                if(defaultEncoding.equalsIgnoreCase("default")==false)
                {
                    bais = new ByteArrayInputStream(sb.toString().getBytes(defaultEncoding));
                }
                else
                {
                    bais = new ByteArrayInputStream(sb.toString().getBytes());
                }
            }
            catch(SecurityException e)
            {
                try
                {
                    bais = new ByteArrayInputStream(sb.toString().getBytes());
                }
                catch(Exception ee)
                {
                    bais = new ByteArrayInputStream(new String("").getBytes(defaultEncoding));
                }                
            }
            catch(UnsupportedEncodingException e)
            {
                if(overrideEncoding==false)
                {
                    try
                    {
                        bais = new ByteArrayInputStream(sb.toString().getBytes());
                    }
                    catch(Exception ee)
                    {
                        bais = new ByteArrayInputStream(new String("").getBytes());
                    }
                }
                else
                {
                    e.printStackTrace();
                }
            }
            int numRead = 0;
            while ((numRead = bais.read(buf)) >= 0) 
            {
                os.write(buf, 0, numRead);
            } 
            os.close();
            return 0;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 8;
        }
    }     
    /** Sets the Document Encoding. Will only set encoding on a call to store(), and mustbe called preceding the call to store. Must be used for Designer calls to set encoding, otherwise may only function on Java platforms supporting default encoding. */
    public static void setEncoding(String Encoding)
    {
        overrideEncoding = true;
        defaultEncoding = Encoding;
    }
    
    public static String getEncoding()
    {
        return defaultEncoding;
    }
    
    /** Reset the encoding scheme. to the default theme. */
    public static void setDefaultEncoding()
    {
        overrideEncoding = false;
        defaultEncoding = "UTF8";
    }
}
