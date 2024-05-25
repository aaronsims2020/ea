/*
 * PaymentReceiptFinishedAction.java
 *
 * Created on October 28, 2003, 05:00 PM
 */
package com.trinity.ea.actions;
import javax.swing.*;
import java.awt.*;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2003-2004 Trinity Software. All rights reserved.
 */
public class PaymentReceiptFinishedAction 
{
    
    /** Creates a new instance of PaymentReceiptFinishedAction */
    public PaymentReceiptFinishedAction() 
    {
        JOptionPane.showMessageDialog(new JFrame(),EncryptedRuleReader.get("paymentSucceededActionMessage"));
        System.exit(0);
        //new PaymentProcessingDialog(new javax.swing.JFrame(), true).show();   
    }
    
}
