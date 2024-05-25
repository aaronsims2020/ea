/*
 * RefundPolicyAction.java
 *
 * Created on December 3, 2003, 12:00 PM
 */

package com.trinity.ea.actions;
import com.trinity.ea.forms.payment.RefundPolicy;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class RefundPolicyAction 
{
    /** Creates a new instance of RefundPolicyAction. This class launches the Swing UI Refund Policy Window). */
    public RefundPolicyAction() 
    {
        new RefundPolicy(null, true).show();
    }
    
}
