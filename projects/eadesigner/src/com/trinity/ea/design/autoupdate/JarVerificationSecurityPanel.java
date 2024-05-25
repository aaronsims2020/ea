/*
 * JarVerificationSecurityPanel.java
 *
 * Created on February 14, 2005, 3:35 PM
 */

package com.trinity.ea.design.autoupdate;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.common.panel.EAPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author  aaronsc Trinity Software, LLC
 * Copyright ©2005 Trinity Software, LLC. All rights reserved.
 */
public class JarVerificationSecurityPanel extends EAPanel {
    
    /** Creates new form JarVerificationSecurityPanel */
    public JarVerificationSecurityPanel() {
        initComponents();
        setProjectData();
    }
    
    public synchronized void setProjectData()
    {
        try
        { 
            if(ProjectManager.get("auto_update_code_signing_is_enabled").equalsIgnoreCase("true")==true)
            {
                         rbUnsecureButton.setSelected(false);  
                         rbSecureButton.setSelected(true);                        
            }
            else
            {
                        rbUnsecureButton.setSelected(true);  
                        rbSecureButton.setSelected(false);                  
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

  public void getDataUpdate()
  {
	try
	{
            if(rbUnsecureButton.isSelected()==true)
            {
		    ProjectManager.putTempNoFileWrite("auto_update_code_signing_is_enabled", "false");
            }
            else
            {
		    ProjectManager.putTempNoFileWrite("auto_update_code_signing_is_enabled", "true");
            }

            ProjectManager.saveTempNow();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
  }       
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        rbUnsecureButton = new javax.swing.JRadioButton();
        rbSecureButton = new javax.swing.JRadioButton();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));

        setBackground(new java.awt.Color(140, 160, 210));
        rbUnsecureButton.setBackground(new java.awt.Color(140, 160, 210));
        rbUnsecureButton.setFont(new java.awt.Font("Arial", 0, 12));
        rbUnsecureButton.setText("Unsecure Mode (Test Mode)");
        rbUnsecureButton.setActionCommand("Unsecure Mode (Test Mode)");
        rbUnsecureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbUnsecureButtonActionPerformed(evt);
            }
        });

        add(rbUnsecureButton);

        rbSecureButton.setBackground(new java.awt.Color(140, 160, 210));
        rbSecureButton.setFont(new java.awt.Font("Arial", 0, 12));
        rbSecureButton.setText("Secure Mode (Requires configuration via the \"Security\" tab) ");
        rbSecureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSecureButtonActionPerformed(evt);
            }
        });

        add(rbSecureButton);

    }//GEN-END:initComponents

    private void rbSecureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSecureButtonActionPerformed
                         rbUnsecureButton.setSelected(false);  
                         rbSecureButton.setSelected(true);                        
    }//GEN-LAST:event_rbSecureButtonActionPerformed

    private void rbUnsecureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbUnsecureButtonActionPerformed
                        rbUnsecureButton.setSelected(true);  
                        rbSecureButton.setSelected(false);                  
    }//GEN-LAST:event_rbUnsecureButtonActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton rbSecureButton;
    private javax.swing.JRadioButton rbUnsecureButton;
    // End of variables declaration//GEN-END:variables
    
}
