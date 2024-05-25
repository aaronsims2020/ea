/*
 * SocketExceptionAction.java
 *
 * Created on October 29, 2003, 12:40 AM
 */

package com.trinity.ea.actions;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2003-2004 Trinity Software. All rights reserved.
 */
public class SocketExceptionAction 
{
    
    /** Creates a new instance of ASocketExceptionAction */
    public SocketExceptionAction() 
    {
        try
        {
            JOptionPane.showMessageDialog(null,"Internet connection was lost. Please reconnect, and try again.");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
