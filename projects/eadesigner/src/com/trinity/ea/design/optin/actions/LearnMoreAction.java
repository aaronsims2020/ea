/*
 * LearnMoreAction.java
 *
 * Created on November 7, 2003, 4:58 PM
 */

package com.trinity.ea.design.optin.actions;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.trinity.ea.design.rules.builder.DesignerRuleBuilder;
import com.trinity.ea.util.BrowserLauncher;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class LearnMoreAction 
{
    /** Creates a new instance of LearnMoreAction. */
    public LearnMoreAction() 
    {
        try
        {
        	if(DesignerRuleBuilder.get("optinLearnMoreURL")!=null)
        	{         
            	BrowserLauncher.openURL(DesignerRuleBuilder.get("optinLearnMoreURL"));
        	}
        }
	  catch(Exception e)
        {
		JOptionPane.showMessageDialog(new JFrame(), "No Information available.");
	  }
    }
    
}
