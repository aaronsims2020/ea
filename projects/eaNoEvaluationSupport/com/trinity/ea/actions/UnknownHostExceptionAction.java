/*
 * UnknownHostExceptionAction.java
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
public class UnknownHostExceptionAction 
{
    
    /** Creates a new instance of AttemptPaymentTransactionAction */
    public UnknownHostExceptionAction() 
    {
        try
        {
            JOptionPane.showMessageDialog(null,"Could not connect to the internet.");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
