/*
 * PrivacyPolicyAction.java
 *
 * Created on December 3, 2003, 12:00 PM
 */

package com.trinity.ea.design.optin.actions;
import com.trinity.ea.design.optin.preview.PrivacyPolicy;
import com.trinity.ea.design.common.file.ProjectManager;
import javax.swing.*;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class PrivacyPolicyAction 
{
    /** Creates a new instance of PrivacyPolicyAction. This class launches the Swing UI Privacy Policy Window). */
    public PrivacyPolicyAction() 
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
        try
        {
            new PrivacyPolicy(null, true).show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
