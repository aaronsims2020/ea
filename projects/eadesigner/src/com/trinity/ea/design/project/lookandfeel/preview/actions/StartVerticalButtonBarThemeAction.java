/*
 * StartVerticalButtonBarThemeAction.java
 *
 * Created on October 24, 2003, 10:51 PM
 */

package com.trinity.ea.design.project.lookandfeel.preview.actions;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.project.lookandfeel.preview.startupui.swing.*;
import javax.swing.*;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class StartVerticalButtonBarThemeAction {
    
    /** Creates a new instance of StartVerticalButtonBarThemeAction */
    public StartVerticalButtonBarThemeAction() 
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
      new dlgStartupWindowVerticalButtonBar(new JFrame(), true).setVisible(true);
    }
    
}
