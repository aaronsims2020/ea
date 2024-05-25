/*
 * EnterRegistrationCodeAction.java
 *
 * Created on October 25, 2003, 4:49 PM
 */

package com.trinity.ea.design.payments.actions;
import com.trinity.ea.design.payments.preview.RefundPolicy;
/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class RefundPolicyAction 
{
     
    /** Creates a new instance of EnterRegistrationCodeAction */
    public RefundPolicyAction() 
    {
        new com.trinity.ea.design.payments.preview.RefundPolicy(new javax.swing.JFrame(), true).setIsRefundPreview(true).show();
    }
    
}
