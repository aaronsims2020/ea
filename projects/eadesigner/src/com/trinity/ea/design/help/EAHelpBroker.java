/*
 * EAHelpBroker.java
 *
 * Created on November 15, 2004, 12:35 AM
 */

package com.trinity.ea.design.help;
import javax.help.*;
import java.awt.Window;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author  aaronsc Trinity Software, LLC
 * Copyright ©2004 Trinity Software, LLC. All rights reserved.
 */
public class EAHelpBroker extends javax.help.DefaultHelpBroker {
   
    /** Creates a new instance of EAHelpBroker */
    public EAHelpBroker() 
    {
        super();       
    }
    
    public EAHelpBroker(javax.help.HelpSet hs) 
    {
        super(hs);
        setHelpIcon();
    }

    public void setHelpIcon() 
    {
        initPresentation();
        WindowPresentation pres = getWindowPresentation();
        Window win = pres.getHelpWindow();
        if (win != null) 
        {
            ((JFrame)win).setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/lgpl/eaicon16.png")).getImage());
            // Get the size of the screen
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

            // Determine the new location of the window
            int w = getSize().width;
            int h = getSize().height;
            int x = (dim.width-w)/2;
            int y = (dim.height-h)/2;
            // Move the window
            ((JFrame)win).setLocation(x, y); 
        }        
    }   
}
