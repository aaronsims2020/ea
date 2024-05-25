/*
 * RegistrationFailedUIAction.java
 *
 * Created on November 4, 2003, 2:31 AM
 */

package com.trinity.ea.actions;

import com.trinity.ea.forms.registration.ui.swing.dlgRegistrationFailure;
import javax.swing.JFrame; 

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class RegistrationFailedUIAction 
{
    
    /** Creates a new instance of RegistrationFailedUIAction */
    public RegistrationFailedUIAction() 
    {
            new dlgRegistrationFailure(new javax.swing.JFrame(), true).show();    
    }
    
}
