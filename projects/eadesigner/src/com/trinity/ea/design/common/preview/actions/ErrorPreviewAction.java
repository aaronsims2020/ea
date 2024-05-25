/*
 * ErrorPreviewAction.java
 *
 * Created on October 25, 2003, 4:49 PM
 */

package com.trinity.ea.design.common.preview.actions;
import com.trinity.ea.design.common.preview.gui.swing.ErrorDialog;
import com.trinity.ea.design.common.file.ProjectManager;
import javax.swing.UIManager;
import java.awt.Frame;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class ErrorPreviewAction 
{
     
    /** Creates a new instance of EnterRegistrationCodeAction */
    public ErrorPreviewAction() 
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
        new ErrorDialog(new Frame(), true, "Error", "Error Dialog English Localization Preview.").show();
    }
    
}
