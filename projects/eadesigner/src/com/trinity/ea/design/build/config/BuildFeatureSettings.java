/*
 * BuildFeatureSettings.java
 *
 * Created on May 24, 2004, 2:23 AM
 */

package com.trinity.ea.design.build.config;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.common.panel.EAPanel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.BoxLayout; 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class BuildFeatureSettings extends EAPanel {
    /** Creates new form BuildFeatureSettings */
    public BuildFeatureSettings() 
    {
        initComponents();
        setProjectData();
    }

    public synchronized void setProjectData()
    {
        try
        {
	    // Automatic Update Support Functionality Checkbox Enabled/Disabled   
            if(ProjectManager.get("project_expiration_support_is_enabled").equalsIgnoreCase("true")==true)
            {
                FeatureCheckbox1.setSelected(true);              
            }
            else
            {
                FeatureCheckbox1.setSelected(false);               
            }
            if(ProjectManager.get("project_optin_is_enabled").equalsIgnoreCase("true")==true)
            {
                FeatureCheckbox2.setSelected(true);              
            }
            else
            {
                FeatureCheckbox2.setSelected(false);               
            }
            if(ProjectManager.get("project_registration_code_support_is_enabled").equalsIgnoreCase("true")==true)
            {
                FeatureCheckbox3.setSelected(true);              
            }
            else
            { 
                FeatureCheckbox3.setSelected(false);               
            }
             if(ProjectManager.get("project_payment_processing_support_is_enabled").equalsIgnoreCase("true")==true)
            {
                FeatureCheckbox4.setSelected(true);              
            }
            else
            {
                FeatureCheckbox4.setSelected(false);               
            }
            if(ProjectManager.get("project_auto_update_support_is_enabled").equalsIgnoreCase("true")==true)
            {
                FeatureCheckbox5.setSelected(true);              
            }
            else
            {
                FeatureCheckbox5.setSelected(false);               
            }     
            if(ProjectManager.get("project_messaging_support_is_enabled").equalsIgnoreCase("true")==true)
            {
                FeatureCheckbox6.setSelected(true);              
            }
            else
            {
                FeatureCheckbox6.setSelected(false);               
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
            // Operating Platform Support Functionality Checkbox Enabled/Disabled
            if(FeatureCheckbox1.isSelected()==true)
            {
		    ProjectManager.put("project_expiration_support_is_enabled", "true");
            }
            else
            {
		    ProjectManager.put("project_expiration_support_is_enabled", "false");
            }  
            if(FeatureCheckbox2.isSelected()==true)
            {
		    ProjectManager.put("project_optin_is_enabled", "true");
            }
            else
            {
		    ProjectManager.put("project_optin_is_enabled", "false");
            }
            if(FeatureCheckbox3.isSelected()==true)
            {
		    ProjectManager.put("project_registration_code_support_is_enabled", "true");
            }
            else
            {
		    ProjectManager.put("project_registration_code_support_is_enabled", "false");
            }
            if(FeatureCheckbox4.isSelected()==true)
            {
		    ProjectManager.put("project_payment_processing_support_is_enabled", "true");
            }
            else
            {
		    ProjectManager.put("project_payment_processing_support_is_enabled", "false");
            }
            if(FeatureCheckbox5.isSelected()==true)
            {
		    ProjectManager.put("project_auto_update_support_is_enabled", "true");
		    ProjectManager.put("autoUpdateEnabled", "true");
            }
            else
            {
		    ProjectManager.put("project_auto_update_support_is_enabled", "false");
		    ProjectManager.put("autoUpdateEnabled", "false");
            }  
            if(FeatureCheckbox6.isSelected()==true)
            {
		    ProjectManager.put("project_messaging_support_is_enabled", "true");
		    ProjectManager.put("msgEnabled", "true");
            }
            else
            {
		    ProjectManager.put("project_messaging_support_is_enabled", "false");
		    ProjectManager.put("msgEnabled", "false");
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
        Feature1Panel = new javax.swing.JPanel();
        EvaluationSupportLabel = new javax.swing.JLabel();
        FeatureCheckbox1 = new javax.swing.JCheckBox();
        FillerPanel = new javax.swing.JPanel();
        Feature1Panel1 = new javax.swing.JPanel();
        OptinSupportLabel = new javax.swing.JLabel();
        FeatureCheckbox2 = new javax.swing.JCheckBox();
        FillerPanel1 = new javax.swing.JPanel();
        Feature1Panel2 = new javax.swing.JPanel();
        RegistrationCodeLabel = new javax.swing.JLabel();
        FeatureCheckbox3 = new javax.swing.JCheckBox();
        FillerPanel2 = new javax.swing.JPanel();
        Feature1Panel3 = new javax.swing.JPanel();
        PaymentProcessingLabel = new javax.swing.JLabel();
        FeatureCheckbox4 = new javax.swing.JCheckBox();
        FillerPanel3 = new javax.swing.JPanel();
        Feature1Panel4 = new javax.swing.JPanel();
        AutoUpdateSupportLabel = new javax.swing.JLabel();
        FeatureCheckbox5 = new javax.swing.JCheckBox();
        FillerPanel4 = new javax.swing.JPanel();
        Feature1Panel5 = new javax.swing.JPanel();
        MessagingSupportLabel = new javax.swing.JLabel();
        FeatureCheckbox6 = new javax.swing.JCheckBox();
        FillerPanel5 = new javax.swing.JPanel();
        FillerPanel6 = new javax.swing.JPanel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        setBackground(new java.awt.Color(100, 120, 170));
        Feature1Panel.setLayout(new javax.swing.BoxLayout(Feature1Panel, javax.swing.BoxLayout.X_AXIS));

        Feature1Panel.setBackground(new java.awt.Color(100, 120, 170));
        Feature1Panel.setMaximumSize(new java.awt.Dimension(32767, 15));
        Feature1Panel.setMinimumSize(new java.awt.Dimension(10, 15));
        Feature1Panel.setPreferredSize(new java.awt.Dimension(10, 15));
        EvaluationSupportLabel.setBackground(new java.awt.Color(100, 120, 170));
        EvaluationSupportLabel.setFont(new java.awt.Font("Arial", 0, 12));
        EvaluationSupportLabel.setText("Enable Timed Evaluation Support");
        EvaluationSupportLabel.setMaximumSize(new java.awt.Dimension(250, 15));
        EvaluationSupportLabel.setMinimumSize(new java.awt.Dimension(250, 15));
        EvaluationSupportLabel.setPreferredSize(new java.awt.Dimension(250, 15));
        EvaluationSupportLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EvaluationSupportLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EvaluationSupportLabelMouseExited(evt);
            }
        });

        Feature1Panel.add(EvaluationSupportLabel);

        FeatureCheckbox1.setBackground(new java.awt.Color(100, 120, 170));
        FeatureCheckbox1.setFont(new java.awt.Font("Arial", 0, 12));
        FeatureCheckbox1.setSelected(true);
        FeatureCheckbox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeatureCheckbox1ActionPerformed(evt);
            }
        });
        Feature1Panel.add(FeatureCheckbox1);

        add(Feature1Panel);

        FillerPanel.setLayout(new javax.swing.BoxLayout(FillerPanel, javax.swing.BoxLayout.X_AXIS));

        FillerPanel.setBackground(new java.awt.Color(100, 120, 170));
        FillerPanel.setMaximumSize(new java.awt.Dimension(10, 10));
        add(FillerPanel);

        Feature1Panel1.setLayout(new javax.swing.BoxLayout(Feature1Panel1, javax.swing.BoxLayout.X_AXIS));

        Feature1Panel1.setBackground(new java.awt.Color(100, 120, 170));
        Feature1Panel1.setMaximumSize(new java.awt.Dimension(32767, 15));
        Feature1Panel1.setMinimumSize(new java.awt.Dimension(10, 15));
        Feature1Panel1.setPreferredSize(new java.awt.Dimension(10, 15));
        OptinSupportLabel.setBackground(new java.awt.Color(100, 120, 170));
        OptinSupportLabel.setFont(new java.awt.Font("Arial", 0, 12));
        OptinSupportLabel.setText("Enable E-mail Opt-In Support");
        OptinSupportLabel.setMaximumSize(new java.awt.Dimension(250, 15));
        OptinSupportLabel.setMinimumSize(new java.awt.Dimension(250, 15));
        OptinSupportLabel.setPreferredSize(new java.awt.Dimension(250, 15));
        OptinSupportLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OptinSupportLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OptinSupportLabelMouseExited(evt);
            }
        });

        Feature1Panel1.add(OptinSupportLabel);

        FeatureCheckbox2.setBackground(new java.awt.Color(100, 120, 170));
        FeatureCheckbox2.setFont(new java.awt.Font("Arial", 0, 12));
        FeatureCheckbox2.setSelected(true);
        FeatureCheckbox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeatureCheckbox2ActionPerformed(evt);
            }
        });
        Feature1Panel1.add(FeatureCheckbox2);

        add(Feature1Panel1);

        FillerPanel1.setLayout(new javax.swing.BoxLayout(FillerPanel1, javax.swing.BoxLayout.X_AXIS));

        FillerPanel1.setBackground(new java.awt.Color(100, 120, 170));
        FillerPanel1.setMaximumSize(new java.awt.Dimension(10, 10));
        add(FillerPanel1);

        Feature1Panel2.setLayout(new javax.swing.BoxLayout(Feature1Panel2, javax.swing.BoxLayout.X_AXIS));

        Feature1Panel2.setBackground(new java.awt.Color(100, 120, 170));
        Feature1Panel2.setMaximumSize(new java.awt.Dimension(32767, 15));
        Feature1Panel2.setMinimumSize(new java.awt.Dimension(10, 15));
        Feature1Panel2.setPreferredSize(new java.awt.Dimension(10, 15));
        RegistrationCodeLabel.setBackground(new java.awt.Color(100, 120, 170));
        RegistrationCodeLabel.setFont(new java.awt.Font("Arial", 0, 12));
        RegistrationCodeLabel.setText("Enable Registration Code Support");
        RegistrationCodeLabel.setMaximumSize(new java.awt.Dimension(250, 15));
        RegistrationCodeLabel.setMinimumSize(new java.awt.Dimension(250, 15));
        RegistrationCodeLabel.setPreferredSize(new java.awt.Dimension(250, 15));
        RegistrationCodeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RegistrationCodeLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RegistrationCodeLabelMouseExited(evt);
            }
        });

        Feature1Panel2.add(RegistrationCodeLabel);

        FeatureCheckbox3.setBackground(new java.awt.Color(100, 120, 170));
        FeatureCheckbox3.setFont(new java.awt.Font("Arial", 0, 12));
        FeatureCheckbox3.setSelected(true);
        FeatureCheckbox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeatureCheckbox3ActionPerformed(evt);
            }
        });
        Feature1Panel2.add(FeatureCheckbox3);

        add(Feature1Panel2);

        FillerPanel2.setLayout(new javax.swing.BoxLayout(FillerPanel2, javax.swing.BoxLayout.X_AXIS));

        FillerPanel2.setBackground(new java.awt.Color(100, 120, 170));
        FillerPanel2.setMaximumSize(new java.awt.Dimension(10, 10));
        add(FillerPanel2);

        Feature1Panel3.setLayout(new javax.swing.BoxLayout(Feature1Panel3, javax.swing.BoxLayout.X_AXIS));

        Feature1Panel3.setBackground(new java.awt.Color(100, 120, 170));
        Feature1Panel3.setMaximumSize(new java.awt.Dimension(32767, 15));
        Feature1Panel3.setMinimumSize(new java.awt.Dimension(10, 15));
        Feature1Panel3.setPreferredSize(new java.awt.Dimension(10, 15));
        PaymentProcessingLabel.setBackground(new java.awt.Color(100, 120, 170));
        PaymentProcessingLabel.setFont(new java.awt.Font("Arial", 0, 12));
        PaymentProcessingLabel.setText("Enable Payment Processing Support");
        PaymentProcessingLabel.setMaximumSize(new java.awt.Dimension(250, 15));
        PaymentProcessingLabel.setMinimumSize(new java.awt.Dimension(250, 15));
        PaymentProcessingLabel.setPreferredSize(new java.awt.Dimension(250, 15));
        PaymentProcessingLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PaymentProcessingLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PaymentProcessingLabelMouseExited(evt);
            }
        });

        Feature1Panel3.add(PaymentProcessingLabel);

        FeatureCheckbox4.setBackground(new java.awt.Color(100, 120, 170));
        FeatureCheckbox4.setFont(new java.awt.Font("Arial", 0, 12));
        FeatureCheckbox4.setSelected(true);
        FeatureCheckbox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeatureCheckbox4ActionPerformed(evt);
            }
        });
        Feature1Panel3.add(FeatureCheckbox4);

        add(Feature1Panel3);

        FillerPanel3.setLayout(new javax.swing.BoxLayout(FillerPanel3, javax.swing.BoxLayout.X_AXIS));

        FillerPanel3.setBackground(new java.awt.Color(100, 120, 170));
        FillerPanel3.setMaximumSize(new java.awt.Dimension(10, 10));
        add(FillerPanel3);

        Feature1Panel4.setLayout(new javax.swing.BoxLayout(Feature1Panel4, javax.swing.BoxLayout.X_AXIS));

        Feature1Panel4.setBackground(new java.awt.Color(100, 120, 170));
        Feature1Panel4.setMaximumSize(new java.awt.Dimension(32767, 15));
        Feature1Panel4.setMinimumSize(new java.awt.Dimension(10, 15));
        Feature1Panel4.setPreferredSize(new java.awt.Dimension(10, 15));
        AutoUpdateSupportLabel.setBackground(new java.awt.Color(100, 120, 170));
        AutoUpdateSupportLabel.setFont(new java.awt.Font("Arial", 0, 12));
        AutoUpdateSupportLabel.setText("Enable Automatic Software Update Support");
        AutoUpdateSupportLabel.setMaximumSize(new java.awt.Dimension(250, 15));
        AutoUpdateSupportLabel.setMinimumSize(new java.awt.Dimension(250, 15));
        AutoUpdateSupportLabel.setPreferredSize(new java.awt.Dimension(250, 15));
        AutoUpdateSupportLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AutoUpdateSupportLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AutoUpdateSupportLabelMouseExited(evt);
            }
        });

        Feature1Panel4.add(AutoUpdateSupportLabel);

        FeatureCheckbox5.setBackground(new java.awt.Color(100, 120, 170));
        FeatureCheckbox5.setFont(new java.awt.Font("Arial", 0, 12));
        FeatureCheckbox5.setSelected(true);
        FeatureCheckbox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeatureCheckbox5ActionPerformed(evt);
            }
        });
        Feature1Panel4.add(FeatureCheckbox5);

        add(Feature1Panel4);

        FillerPanel4.setLayout(new javax.swing.BoxLayout(FillerPanel4, javax.swing.BoxLayout.X_AXIS));

        FillerPanel4.setBackground(new java.awt.Color(100, 120, 170));
        FillerPanel4.setMaximumSize(new java.awt.Dimension(10, 10));
        add(FillerPanel4);

        Feature1Panel5.setLayout(new javax.swing.BoxLayout(Feature1Panel5, javax.swing.BoxLayout.X_AXIS));

        Feature1Panel5.setBackground(new java.awt.Color(100, 120, 170));
        Feature1Panel5.setMaximumSize(new java.awt.Dimension(32767, 15));
        Feature1Panel5.setMinimumSize(new java.awt.Dimension(10, 15));
        Feature1Panel5.setPreferredSize(new java.awt.Dimension(10, 15));
        MessagingSupportLabel.setBackground(new java.awt.Color(100, 120, 170));
        MessagingSupportLabel.setFont(new java.awt.Font("Arial", 0, 12));
        MessagingSupportLabel.setText("Enable Messaging Support");
        MessagingSupportLabel.setMaximumSize(new java.awt.Dimension(250, 15));
        MessagingSupportLabel.setMinimumSize(new java.awt.Dimension(250, 15));
        MessagingSupportLabel.setPreferredSize(new java.awt.Dimension(250, 15));
        MessagingSupportLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MessagingSupportLabelMouseEntered(evt);
            }
        });

        Feature1Panel5.add(MessagingSupportLabel);

        FeatureCheckbox6.setBackground(new java.awt.Color(100, 120, 170));
        FeatureCheckbox6.setFont(new java.awt.Font("Arial", 0, 12));
        FeatureCheckbox6.setSelected(true);
        FeatureCheckbox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeatureCheckbox6ActionPerformed(evt);
            }
        });
        Feature1Panel5.add(FeatureCheckbox6);

        add(Feature1Panel5);

        FillerPanel5.setLayout(new javax.swing.BoxLayout(FillerPanel5, javax.swing.BoxLayout.X_AXIS));

        FillerPanel5.setBackground(new java.awt.Color(100, 120, 170));
        FillerPanel5.setMaximumSize(new java.awt.Dimension(10, 10));
        add(FillerPanel5);

        FillerPanel6.setLayout(new javax.swing.BoxLayout(FillerPanel6, javax.swing.BoxLayout.X_AXIS));

        FillerPanel6.setBackground(new java.awt.Color(100, 120, 170));
        FillerPanel6.setMaximumSize(new java.awt.Dimension(10, 10));
        add(FillerPanel6);

    }//GEN-END:initComponents

    private void MessagingSupportLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagingSupportLabelMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_MessagingSupportLabelMouseEntered

    private void AutoUpdateSupportLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AutoUpdateSupportLabelMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_AutoUpdateSupportLabelMouseExited

    private void AutoUpdateSupportLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AutoUpdateSupportLabelMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_AutoUpdateSupportLabelMouseEntered

    private void PaymentProcessingLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaymentProcessingLabelMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_PaymentProcessingLabelMouseExited

    private void PaymentProcessingLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaymentProcessingLabelMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_PaymentProcessingLabelMouseEntered

    private void RegistrationCodeLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrationCodeLabelMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_RegistrationCodeLabelMouseExited

    private void RegistrationCodeLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrationCodeLabelMouseEntered
        // TODO add your handling code here: 
    }//GEN-LAST:event_RegistrationCodeLabelMouseEntered

    private void OptinSupportLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptinSupportLabelMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_OptinSupportLabelMouseExited

    private void OptinSupportLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptinSupportLabelMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_OptinSupportLabelMouseEntered

    private void EvaluationSupportLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvaluationSupportLabelMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_EvaluationSupportLabelMouseExited

    private void EvaluationSupportLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvaluationSupportLabelMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_EvaluationSupportLabelMouseEntered

    private void FeatureCheckbox1ActionPerformed(java.awt.event.ActionEvent evt) {
        getDataUpdate();
    }
    private void FeatureCheckbox2ActionPerformed(java.awt.event.ActionEvent evt) {
        getDataUpdate();
    }
    private void FeatureCheckbox3ActionPerformed(java.awt.event.ActionEvent evt) {
        getDataUpdate();
    }
    private void FeatureCheckbox4ActionPerformed(java.awt.event.ActionEvent evt) {
        getDataUpdate();
    }    
    private void FeatureCheckbox5ActionPerformed(java.awt.event.ActionEvent evt) {
	try
	{
        getDataUpdate();
	  EAPanel thePanel = (EAPanel)getParentComponent();
        ((EAPanel)thePanel.getParentComponent()).getDataUpdate();
        ((EAPanel)thePanel.getParentComponent()).setProjectData(); 
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}  
    }
    private void FeatureCheckbox6ActionPerformed(java.awt.event.ActionEvent evt) {
        getDataUpdate();
    }  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AutoUpdateSupportLabel;
    private javax.swing.JLabel EvaluationSupportLabel;
    private javax.swing.JPanel Feature1Panel;
    private javax.swing.JPanel Feature1Panel1;
    private javax.swing.JPanel Feature1Panel2;
    private javax.swing.JPanel Feature1Panel3;
    private javax.swing.JPanel Feature1Panel4;
    private javax.swing.JPanel Feature1Panel5;
    private javax.swing.JCheckBox FeatureCheckbox1;
    private javax.swing.JCheckBox FeatureCheckbox2;
    private javax.swing.JCheckBox FeatureCheckbox3;
    private javax.swing.JCheckBox FeatureCheckbox4;
    private javax.swing.JCheckBox FeatureCheckbox5;
    private javax.swing.JCheckBox FeatureCheckbox6;
    private javax.swing.JPanel FillerPanel;
    private javax.swing.JPanel FillerPanel1;
    private javax.swing.JPanel FillerPanel2;
    private javax.swing.JPanel FillerPanel3;
    private javax.swing.JPanel FillerPanel4;
    private javax.swing.JPanel FillerPanel5;
    private javax.swing.JPanel FillerPanel6;
    private javax.swing.JLabel MessagingSupportLabel;
    private javax.swing.JLabel OptinSupportLabel;
    private javax.swing.JLabel PaymentProcessingLabel;
    private javax.swing.JLabel RegistrationCodeLabel;
    // End of variables declaration//GEN-END:variables
    
}

