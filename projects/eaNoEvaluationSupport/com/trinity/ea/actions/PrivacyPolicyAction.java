/*
 * PrivacyPolicyAction.java
 *
 * Created on December 3, 2003, 12:00 PM
 */

package com.trinity.ea.actions;
import com.trinity.ea.forms.PrivacyPolicy;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2003-2004 Trinity Software. All rights reserved.
 */
public class PrivacyPolicyAction 
{
    /** Creates a new instance of PrivacyPolicyAction. This class launches the Swing UI Privacy Policy Window). */
    public PrivacyPolicyAction() 
    {
        new PrivacyPolicy(null, true).show();
    }
    
}
