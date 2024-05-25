/*
 * OptinAction.java
 *
 * Created on November 16, 2003, 12:00 AM
 */

package com.trinity.ea.design.optin.actions;
import com.trinity.ea.design.optin.preview.dlgEMailOptin;
import com.trinity.ea.design.common.file.ProjectManager;
import javax.swing.*;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class OptinAction {
    
    /** Creates a new instance of OptinAction */
    public OptinAction() 
    {
        // TODO: Command Line implementation
        // TODO: MIDP implementation
        // Trial Expired
        //System.out.println("Attempting to read property expired action. ");
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

                            dlgEMailOptin theEMail = new dlgEMailOptin(new JFrame(),true);
					theEMail.show();

                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }     
    }   
}
