/*
 * AboutAction.java
 *
 * Created on March 17, 2004, 2:28 PM
 */

package com.trinity.ea.design.common.actions;
import com.trinity.ea.design.AboutBoxDialog;
import javax.swing.JFrame;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003 Trinity Software. All rights reserved.
 */
public class AboutAction 
{
    
    /** Creates a new instance of ExitAction */
    public AboutAction() 
    {
        try
        {
           new AboutBoxDialog(new JFrame(), true).show();
           
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }       
    }
    
}
