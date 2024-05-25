/*
 * FindProviderAction.java
 *
 * Created on November 7, 2003, 4:58 PM
 */

package com.trinity.ea.design.optin.actions;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import com.trinity.ea.design.optin.provider.OptinWizard;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class FindProviderAction 
{
    /** Creates a new instance of FindProviderAction. */
    public FindProviderAction() 
    {

	  try
	  {
		new OptinWizard(1);
	  }
	  catch(Exception e)
	  {
        	JOptionPane.showMessageDialog(new JFrame(), "No information available at this time.");
	  }
    }
    
}
