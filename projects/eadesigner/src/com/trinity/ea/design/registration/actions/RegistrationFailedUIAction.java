/*
 * RegistrationFailedUIAction.java
 *
 * Created on November 4, 2003, 2:31 AM
 */

package com.trinity.ea.design.registration.actions;
import com.trinity.ea.design.registration.preview.dlgRegistrationFailure;
import com.trinity.ea.design.common.file.ProjectManager;
import javax.swing.*;

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
   	try
   	{
		if(ProjectManager.get("LAndFPackage")!=null)
		{
			if(ProjectManager.get("LAndFPackage").equalsIgnoreCase("system")==true)
			{			
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
			else
			{
				UIManager.setLookAndFeel(ProjectManager.get("LAndFPackage"));
			}
		}
   	}
   	catch (Exception e)
   	{
      	System.out.println("Could not set System Look and Feel.");
   	}
            new dlgRegistrationFailure(new javax.swing.JFrame(), true).show();    
    }
    
}
