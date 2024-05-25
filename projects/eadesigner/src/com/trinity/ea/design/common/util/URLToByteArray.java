/*
 * URLToByteArray.java
 *
 * Created on October 24, 2004, 2:03 PM
 */

package com.trinity.ea.design.common.util;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.io.InputStream;

/**
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class URLToByteArray {
    
    /** Creates a new instance of URLToByteArray */
    public URLToByteArray() {
    }
    
    public synchronized static byte[] getURLByteArray(URL url1)
    {
        try 
        {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream is = url1.openStream();
            int c;    
            while((c=is.read())>=0) out.write(c);   
            is.close();
            byte[] theByteArray = out.toByteArray();
            return out.toByteArray();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return null; 
        }           
    }    
}
