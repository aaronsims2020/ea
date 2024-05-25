/*
 * expiredAction.java
 *
 * Created on October 24, 2003, 10:52 PM
 */
package com.trinity.ea.actions;
import com.trinity.ea.forms.dlgExpiredStartupWindow;
import javax.swing.*;
/**
 *
 *
 * @author  aaronsc Trinity Software
 * Copyright �2003-2004 Trinity Software. All rights reserved.
 */
public class ExpiredAction 
{
    
    /** Creates a new instance of expiredAction */
    public ExpiredAction() 
    {
       // new dlgStartupWindow(new javax.swing.JFrame(), true).show();   
         new dlgExpiredStartupWindow(new JFrame(), true).setVisible(true);
 
    }
    
}
