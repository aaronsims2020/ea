/*
 * StartVerticalButtonBarThemeAction.java
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
public class StartVerticalButtonBarThemeAction {
    
    /** Creates a new instance of StartVerticalButtonBarThemeAction */
    public StartVerticalButtonBarThemeAction() 
    {
    if(EncryptedRuleReader.getLAFSet()==false)
    {     
            try
            {
                    if(EncryptedRuleReader.get("LAndFPackage")!=null)
                    {
                            if(EncryptedRuleReader.get("LAndFPackage").equalsIgnoreCase("system")==true)
                            {			
                                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                                    EncryptedRuleReader.setLAFSet(true);      
                            }
                            else
                            {
                                    UIManager.setLookAndFeel(EncryptedRuleReader.get("LAndFPackage"));
                                    EncryptedRuleReader.setLAFSet(true);                                         
                            }
                    }
            }
            catch (Exception e)
            {
                System.out.println("Could not set System Look and Feel.");
            }
        }
      new dlgStartupWindowVerticalButtonBar(new JFrame(), true).setVisible(true);
    }
    
}
