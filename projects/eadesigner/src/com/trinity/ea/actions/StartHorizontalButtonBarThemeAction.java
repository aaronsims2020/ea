/*
 * StartHorizontalButtonBarThemeAction.java
 *
 * Created on October 24, 2003, 10:51 PM
 */

package com.trinity.ea.actions;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import com.trinity.ea.forms.startupui.swing.*;
import javax.swing.*;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class StartHorizontalButtonBarThemeAction {
    
    /** Creates a new instance of StartHorizontalButtonBarThemeAction */
    public StartHorizontalButtonBarThemeAction() 
    {
   	try
   	{
		if(EncryptedRuleReader.get("LAndFPackage")!=null)
		{
			if(EncryptedRuleReader.get("LAndFPackage").equalsIgnoreCase("system")==true)
			{			
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
			else
			{
				UIManager.setLookAndFeel(EncryptedRuleReader.get("LAndFPackage"));
			}
		}
   	}
   	catch (Exception e)
   	{
      	System.out.println("Could not set System Look and Feel.");
   	}
      new dlgStartupWindowHorizontalButtonBar(new JFrame(), true).setVisible(true);
    }
    
}
