/*
 * BuyNowAction.java
 *
 * Created on October 28, 2003, 05:00 PM
 */
package com.trinity.ea.actions;
import com.trinity.ea.forms.PaymentProcessingDialog;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2003-2004 Trinity Software. All rights reserved.
 */
public class BuyNowAction 
{
    
    /** Creates a new instance of BuyNowAction */
    public BuyNowAction() 
    {
        new PaymentProcessingDialog(new javax.swing.JFrame(), true).show();   
    }
    
}
