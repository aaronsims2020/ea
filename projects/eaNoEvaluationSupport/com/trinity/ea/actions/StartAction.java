/*
 * startAction.java
 *
 * Created on October 24, 2003, 10:51 PM
 */

package com.trinity.ea.actions;
import com.trinity.ea.forms.dlgStartupWindow;
import javax.swing.*;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2003-2004 Trinity Software. All rights reserved.
 */
public class StartAction {
    
    /** Creates a new instance of startAction */
    public StartAction() 
    {
        //System.out.println("Instanciated startAction EvaluateAnywhere Action.");
        new dlgStartupWindow(new JFrame(), true).setVisible(true);
    }
    
}
