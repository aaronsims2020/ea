/*
 * AutoUpdateEnabledControl.java
 *
 * Created on April 9, 2004, 9:24 PM
 */

package com.trinity.ea.design.autoupdate;

import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.common.file.ProjectManager;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

/** 
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class AutoUpdateEnabledControl extends EAPanel {
    private Color backgroundColor = new java.awt.Color(100, 120, 170);
    private Color txtColor = new java.awt.Color(0, 0, 0);    
    
    /** Creates new form AutoUpdateEnabledControl */
    public AutoUpdateEnabledControl() {
        initComponents();
        setProjectData();
    }

    public synchronized void setProjectData()
    {
        try
        {
		// Auto Update Support Functionality Checkbox Enabled/Disabled   
            if(ProjectManager.get("project_auto_update_support_is_enabled").equalsIgnoreCase("true")==true)
            {
                cbAutoUpdateEnabled.setSelected(true);              
            }
            else
            {
                cbAutoUpdateEnabled.setSelected(false);               
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
  
    public synchronized void getDataUpdate()
    {
	try
	{
		// Auto Update Support Functionality Checkbox Enabled/Disabled
            if(cbAutoUpdateEnabled.isSelected()==true)
            {
		    ProjectManager.putTempNoFileWrite("autoUpdateEnabled", "true");
 		    ProjectManager.putTempNoFileWrite("project_auto_update_support_is_enabled", "true");                            
            }
            else
            {
		    ProjectManager.putTempNoFileWrite("autoUpdateEnabled", "false");
		    ProjectManager.putTempNoFileWrite("project_auto_update_support_is_enabled", "false");               
            }
            ProjectManager.saveTempNow();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
 
    public void setText(String cbText)
    {
        try
        {
            cbAutoUpdateEnabled.setText(cbText);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public String getText()
    {
        try
        {
            return cbAutoUpdateEnabled.getText();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public void setBackgroundColor(Color BGColor)
    {
        try
        {
            backgroundColor = BGColor;
            cbAutoUpdateEnabled.setBackground(BGColor);
            DescriptorPanel.setBackground(BGColor);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }      
    }
    
    public Color getBackgroundColor()
    {
        return backgroundColor;
    }
    
    public void setTextColor(Color textColor)
    {
        try
        {
            txtColor = textColor;
            cbAutoUpdateEnabled.setForeground(textColor);  
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public Color getTextColor()
    {
        return cbAutoUpdateEnabled.getForeground(); 
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        DescriptorPanel = new javax.swing.JPanel();
        cbAutoUpdateEnabled = new javax.swing.JCheckBox();

        setLayout(new java.awt.BorderLayout());

        setBackground(new java.awt.Color(100, 120, 170));
        DescriptorPanel.setLayout(new java.awt.BorderLayout());

        DescriptorPanel.setBackground(new java.awt.Color(100, 120, 170));
        cbAutoUpdateEnabled.setBackground(new java.awt.Color(100, 120, 170));
        cbAutoUpdateEnabled.setFont(new java.awt.Font("Arial", 1, 12));
        cbAutoUpdateEnabled.setSelected(true);
        cbAutoUpdateEnabled.setText("Enable Automatic Software Update Support");
        cbAutoUpdateEnabled.setMnemonic('n');
        DescriptorPanel.add(cbAutoUpdateEnabled, java.awt.BorderLayout.CENTER);

        add(DescriptorPanel, java.awt.BorderLayout.CENTER);

    }//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DescriptorPanel;
    private javax.swing.JCheckBox cbAutoUpdateEnabled;
    // End of variables declaration//GEN-END:variables
    
}
