/*
 * JLocalColorChooser.java
 *
 * Created on January 4, 2005, 5:21 PM
 */

package com.trinity.ea.design.common.colorchooser;
import javax.swing.JColorChooser;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.InsetsUIResource;
import javax.swing.plaf.BorderUIResource;
import java.awt.Color;
import java.awt.Component;

/** 
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class JLocalColorChooser {
    
    /** Creates a new instance of JLocalColorChooser */
    public JLocalColorChooser() {
    }
    
    public static Color showDialog(Component component, String title, Color initialColor) 
    {
        try
        {
            UIManager uiM = new UIManager();
            UIDefaults uid = uiM.getDefaults();   
            //set to your main Panel bg color
            uid.put("TabbedPane.tabAreaInsets", new InsetsUIResource(1, 1, 1, 1));
            uid.put("TabbedPane.contentBorderInsets", new InsetsUIResource(1, 1, 1, 1));
            uid.put("TabbedPane.selectedTabPadInsets", new InsetsUIResource(2, 2, 2, 2));
            uid.put("TabbedPane.selectHighlight", new ColorUIResource(Color.white));
            UIManager.put("TabbedPane.tabAreaBackground", new java.awt.Color(200, 221, 242));
            UIManager.put("TabbedPane.background", new java.awt.Color(200, 221, 242));
            UIManager.put("TabbedPane.foreground", new ColorUIResource(Color.black));
            UIManager.put("TabbedPane.selected", new java.awt.Color(200, 221, 242));
            UIManager.put("TabbedPane.border", new BorderUIResource(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0)));
            
            return javax.swing.JColorChooser.showDialog(component, title, initialColor);
        }
        catch(Exception e)
        {

        }
        return initialColor;
    }
}
