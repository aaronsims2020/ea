/*
 * InformationDialogAction.java
 *
 * Created on December 3, 2003, 12:00 PM
 */

package com.trinity.ea.design.common.preview.actions;
import com.trinity.ea.design.common.preview.info.InformationDialog;
import com.trinity.ea.design.common.file.ProjectManager;
import javax.swing.UIManager;
import java.awt.Frame;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class InformationDialogAction 
{
    /** Creates a new instance of InformationDialogAction. This class launches the Swing UI Information Dialog Window). */
    public InformationDialogAction() 
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
        new InformationDialog(null, true).show();
    }
    
}
