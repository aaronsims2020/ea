/*
 * EAMFileFilter.java
 *
 * Created on January 2, 2005, 2:29 PM
 */

package com.trinity.ea.design.messaging.builder;
import java.io.FileFilter;
import java.io.File;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class EAMFileFilter implements FileFilter
{
    public boolean accept(java.io.File pathname) 
    {
        if(pathname.isDirectory()==true)
        {
            return true;
        }
        String ext = pathname.getName();
        ext = ext.substring(ext.lastIndexOf(".") + 1, ext.length());
        if(ext.equals("eam")==true) 
        {
                return true;
        }
        return false;
    }
}
