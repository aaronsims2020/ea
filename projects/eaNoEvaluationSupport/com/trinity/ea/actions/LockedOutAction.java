/*
 * LockedOutAction.java
 *
 * Created on November 4, 2003, 2:08 AM
 */

package com.trinity.ea.actions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2003-2004 Trinity Software. All rights reserved.
 */
public class LockedOutAction 
{
    
    /** Creates a new instance of LockedOutAction */
    public LockedOutAction() 
    {
        JOptionPane.showMessageDialog(new JDialog(),"This software was locked down due to multiple invalid registration code entries.Purchase now to register");
    }
    
}
