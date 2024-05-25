/*
 * ConfigurationErrorAction.java
 *
 * Created on November 7, 2003, 4:58 PM
 */

package com.trinity.ea.actions;
import javax.swing.*;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2003-2004 Trinity Software. All rights reserved.
 */
public class ConfigurationErrorAction 
{
    /** Creates a new instance of ConfigurationErrorAction. This class is hard coded to be launched whenever an error reading the eae file is encountered (including deletion of the eae file). */
    public ConfigurationErrorAction() 
    {
        JOptionPane.showMessageDialog(new JFrame(), "Trial Expired. Please contact software vendor for assistance.");
    }
    
}
