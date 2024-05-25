/*
 * BuildFeatureSettings.java
 *
 * Created on May 24, 2004, 2:23 AM
 */ 

package com.trinity.ea.design.common.project;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.common.project.NewProject;
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
                EvaluationCheckbox.setSelected(true);              
            }
            else
            {
                EvaluationCheckbox.setSelected(false);               
            }
            if(ProjectManager.get("project_optin_is_enabled").equalsIgnoreCase("true")==true)
            {
                OptinCheckbox.setSelected(true);              
            }
            else
            {
                OptinCheckbox.setSelected(false);               
            }
            if(ProjectManager.get("project_registration_code_support_is_enabled").equalsIgnoreCase("true")==true)
            {
                RegistrationCheckbox.setSelected(true);              
            }
            else
            { 
                RegistrationCheckbox.setSelected(false);               
            }
             if(ProjectManager.get("project_payment_processing_support_is_enabled").equalsIgnoreCase("true")==true)
            {
                PaymentCheckbox.setSelected(true);              
            }
            else
            {
                PaymentCheckbox.setSelected(false);               
            }
            if(ProjectManager.get("project_auto_update_support_is_enabled").equalsIgnoreCase("true")==true)
            {
                AutoUpdateCheckbox.setSelected(true);              
            }
            else
            {
                AutoUpdateCheckbox.setSelected(false);               
            }     
            if(ProjectManager.get("project_messaging_support_is_enabled").equalsIgnoreCase("true")==true)
            {
                MessagingCheckbox.setSelected(true);              
            }
            else
            {
                MessagingCheckbox.setSelected(false);               
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
            if(EvaluationCheckbox.isSelected()==true)
            {
		    ProjectManager.putTempNoFileWrite("project_expiration_support_is_enabled", "true");
            }
            else
            {
		    ProjectManager.putTempNoFileWrite("project_expiration_support_is_enabled", "false");
            }  
            if(OptinCheckbox.isSelected()==true)
            {
		    ProjectManager.putTempNoFileWrite("project_optin_is_enabled", "true");
            }
            else
            {
		    ProjectManager.putTempNoFileWrite("project_optin_is_enabled", "false");
            }
            if(RegistrationCheckbox.isSelected()==true)
            {
		    ProjectManager.putTempNoFileWrite("project_registration_code_support_is_enabled", "true");
            }
            else
            {
		    ProjectManager.putTempNoFileWrite("project_registration_code_support_is_enabled", "false");
            }
            if(PaymentCheckbox.isSelected()==true)
            {
		    ProjectManager.putTempNoFileWrite("project_payment_processing_support_is_enabled", "true");
            }
            else
            {
		    ProjectManager.putTempNoFileWrite("project_payment_processing_support_is_enabled", "false");
            }
            if(AutoUpdateCheckbox.isSelected()==true)
            {
		    ProjectManager.putTempNoFileWrite("project_auto_update_support_is_enabled", "true");
		    ProjectManager.putTempNoFileWrite("autoUpdateEnabled", "true");
            }
            else
            {
		    ProjectManager.putTempNoFileWrite("project_auto_update_support_is_enabled", "false");
		    ProjectManager.putTempNoFileWrite("autoUpdateEnabled", "false");
            }  
            if(MessagingCheckbox.isSelected()==true)
            {
		    ProjectManager.putTempNoFileWrite("project_messaging_support_is_enabled", "true");
		    ProjectManager.putTempNoFileWrite("msgEnabled", "true");
            }
            else
            {
		    ProjectManager.putTempNoFileWrite("project_messaging_support_is_enabled", "false");
		    ProjectManager.putTempNoFileWrite("msgEnabled", "false");
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
        Filler1 = new javax.swing.JLabel();
        Filler2 = new javax.swing.JLabel();
        Filler3 = new javax.swing.JLabel();
        Filler4 = new javax.swing.JLabel();
        Filler5 = new javax.swing.JLabel();
        Filler6 = new javax.swing.JLabel();
        EvaluationCheckbox = new javax.swing.JCheckBox();
        FillerPanel = new javax.swing.JPanel();
        Feature1Panel1 = new javax.swing.JPanel();
        OptinSupportLabel = new javax.swing.JLabel();
        OptinCheckbox = new javax.swing.JCheckBox();
        FillerPanel1 = new javax.swing.JPanel();
        Feature1Panel2 = new javax.swing.JPanel();
        RegistrationCodeLabel = new javax.swing.JLabel();
        RegistrationCheckbox = new javax.swing.JCheckBox();
        FillerPanel2 = new javax.swing.JPanel();
        Feature1Panel3 = new javax.swing.JPanel();
        PaymentProcessingLabel = new javax.swing.JLabel();
        PaymentCheckbox = new javax.swing.JCheckBox();
        FillerPanel3 = new javax.swing.JPanel();
        Feature1Panel4 = new javax.swing.JPanel();
        AutoUpdateSupportLabel = new javax.swing.JLabel();
        AutoUpdateCheckbox = new javax.swing.JCheckBox();
        FillerPanel4 = new javax.swing.JPanel();
        Feature1Panel5 = new javax.swing.JPanel();
        MessagingSupportLabel = new javax.swing.JLabel();
        MessagingCheckbox = new javax.swing.JCheckBox();
        FillerPanel5 = new javax.swing.JPanel();
        FillerPanel6 = new javax.swing.JPanel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        Filler1.setMaximumSize(new java.awt.Dimension(20, 10));
        Filler1.setMinimumSize(new java.awt.Dimension(20, 10));
        Filler1.setPreferredSize(new java.awt.Dimension(20, 10));
        Filler2.setMaximumSize(new java.awt.Dimension(20, 10));
        Filler2.setMinimumSize(new java.awt.Dimension(20, 10));
        Filler2.setPreferredSize(new java.awt.Dimension(20, 10));
        Filler3.setMaximumSize(new java.awt.Dimension(20, 10));
        Filler3.setMinimumSize(new java.awt.Dimension(20, 10));
        Filler3.setPreferredSize(new java.awt.Dimension(20, 10));
        Filler4.setMaximumSize(new java.awt.Dimension(20, 10));
        Filler4.setMinimumSize(new java.awt.Dimension(20, 10));
        Filler4.setPreferredSize(new java.awt.Dimension(20, 10));
        Filler5.setMaximumSize(new java.awt.Dimension(20, 10));
        Filler5.setMinimumSize(new java.awt.Dimension(20, 10));
        Filler5.setPreferredSize(new java.awt.Dimension(20, 10));
        Filler6.setMaximumSize(new java.awt.Dimension(20, 10));
        Filler6.setMinimumSize(new java.awt.Dimension(20, 10));
        Filler6.setPreferredSize(new java.awt.Dimension(20, 10));

        Feature1Panel.setLayout(new javax.swing.BoxLayout(Feature1Panel, javax.swing.BoxLayout.X_AXIS));

        Feature1Panel.setMaximumSize(new java.awt.Dimension(32767, 15));
        Feature1Panel.setMinimumSize(new java.awt.Dimension(10, 15));
        Feature1Panel.setPreferredSize(new java.awt.Dimension(10, 15));
        EvaluationSupportLabel.setFont(new java.awt.Font("Arial", 0, 12));
        EvaluationSupportLabel.setText("Enable Timed Evaluation Support");
        EvaluationSupportLabel.setMaximumSize(new java.awt.Dimension(330, 15));
        EvaluationSupportLabel.setMinimumSize(new java.awt.Dimension(330, 15));
        EvaluationSupportLabel.setPreferredSize(new java.awt.Dimension(330, 15));
        EvaluationSupportLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EvaluationSupportLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EvaluationSupportLabelMouseExited(evt);
            }
        });
        FillerPanel6.setLayout(new javax.swing.BoxLayout(FillerPanel6, javax.swing.BoxLayout.X_AXIS));

        FillerPanel6.setMaximumSize(new java.awt.Dimension(10, 5));
        add(FillerPanel6);

        Feature1Panel.add(Filler1);
        Feature1Panel.add(EvaluationSupportLabel);

        EvaluationCheckbox.setFont(new java.awt.Font("Arial", 0, 12));
        EvaluationCheckbox.setSelected(true);
        EvaluationCheckbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EvaluationCheckboxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EvaluationCheckboxMouseExited(evt);
            }
        });

        Feature1Panel.add(EvaluationCheckbox);

        add(Feature1Panel);

        FillerPanel.setLayout(new javax.swing.BoxLayout(FillerPanel, javax.swing.BoxLayout.X_AXIS));

        FillerPanel.setMaximumSize(new java.awt.Dimension(10, 10));
        add(FillerPanel);

        Feature1Panel1.setLayout(new javax.swing.BoxLayout(Feature1Panel1, javax.swing.BoxLayout.X_AXIS));

        Feature1Panel1.setMaximumSize(new java.awt.Dimension(32767, 15));
        Feature1Panel1.setMinimumSize(new java.awt.Dimension(10, 15));
        Feature1Panel1.setPreferredSize(new java.awt.Dimension(10, 15));
        OptinSupportLabel.setFont(new java.awt.Font("Arial", 0, 12));
        OptinSupportLabel.setText("Enable E-mail Opt-In Support");
        OptinSupportLabel.setMaximumSize(new java.awt.Dimension(330, 15));
        OptinSupportLabel.setMinimumSize(new java.awt.Dimension(330, 15));
        OptinSupportLabel.setPreferredSize(new java.awt.Dimension(330, 15));
        OptinSupportLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OptinSupportLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OptinSupportLabelMouseExited(evt);
            }
        });
        Feature1Panel1.add(Filler2);

        Feature1Panel1.add(OptinSupportLabel);

        OptinCheckbox.setFont(new java.awt.Font("Arial", 0, 12));
        OptinCheckbox.setSelected(true);
        OptinCheckbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OptinCheckboxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OptinCheckboxMouseExited(evt);
            }
        });

        Feature1Panel1.add(OptinCheckbox);

        add(Feature1Panel1);

        FillerPanel1.setLayout(new javax.swing.BoxLayout(FillerPanel1, javax.swing.BoxLayout.X_AXIS));

        FillerPanel1.setMaximumSize(new java.awt.Dimension(10, 10));
        add(FillerPanel1);

        Feature1Panel2.setLayout(new javax.swing.BoxLayout(Feature1Panel2, javax.swing.BoxLayout.X_AXIS));

        Feature1Panel2.setMaximumSize(new java.awt.Dimension(32767, 15));
        Feature1Panel2.setMinimumSize(new java.awt.Dimension(10, 15));
        Feature1Panel2.setPreferredSize(new java.awt.Dimension(10, 15));
        RegistrationCodeLabel.setFont(new java.awt.Font("Arial", 0, 12));
        RegistrationCodeLabel.setText("Enable Registration Code Support");
        RegistrationCodeLabel.setMaximumSize(new java.awt.Dimension(330, 15));
        RegistrationCodeLabel.setMinimumSize(new java.awt.Dimension(330, 15));
        RegistrationCodeLabel.setPreferredSize(new java.awt.Dimension(330, 15));
        RegistrationCodeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RegistrationCodeLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RegistrationCodeLabelMouseExited(evt);
            }
        });
        Feature1Panel2.add(Filler3);
        Feature1Panel2.add(RegistrationCodeLabel);

        RegistrationCheckbox.setFont(new java.awt.Font("Arial", 0, 12));
        RegistrationCheckbox.setSelected(true);
        RegistrationCheckbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RegistrationCheckboxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RegistrationCheckboxMouseExited(evt);
            }
        });

        Feature1Panel2.add(RegistrationCheckbox);

        add(Feature1Panel2);

        FillerPanel2.setLayout(new javax.swing.BoxLayout(FillerPanel2, javax.swing.BoxLayout.X_AXIS));

        FillerPanel2.setMaximumSize(new java.awt.Dimension(10, 10));
        add(FillerPanel2);

        Feature1Panel3.setLayout(new javax.swing.BoxLayout(Feature1Panel3, javax.swing.BoxLayout.X_AXIS));

        Feature1Panel3.setMaximumSize(new java.awt.Dimension(32767, 15));
        Feature1Panel3.setMinimumSize(new java.awt.Dimension(10, 15));
        Feature1Panel3.setPreferredSize(new java.awt.Dimension(10, 15));
        PaymentProcessingLabel.setFont(new java.awt.Font("Arial", 0, 12));
        PaymentProcessingLabel.setText("Enable Payment Processing Support");
        PaymentProcessingLabel.setMaximumSize(new java.awt.Dimension(330, 15));
        PaymentProcessingLabel.setMinimumSize(new java.awt.Dimension(330, 15));
        PaymentProcessingLabel.setPreferredSize(new java.awt.Dimension(330, 15));
        PaymentProcessingLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PaymentProcessingLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PaymentProcessingLabelMouseExited(evt);
            }
        });
        Feature1Panel3.add(Filler4);
        Feature1Panel3.add(PaymentProcessingLabel);

        PaymentCheckbox.setFont(new java.awt.Font("Arial", 0, 12));
        PaymentCheckbox.setSelected(true);
        PaymentCheckbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PaymentCheckboxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PaymentCheckboxMouseExited(evt);
            }
        });

        Feature1Panel3.add(PaymentCheckbox);

        add(Feature1Panel3);

        FillerPanel3.setLayout(new javax.swing.BoxLayout(FillerPanel3, javax.swing.BoxLayout.X_AXIS));
        FillerPanel3.setMaximumSize(new java.awt.Dimension(10, 10));
        add(FillerPanel3);

        Feature1Panel4.setLayout(new javax.swing.BoxLayout(Feature1Panel4, javax.swing.BoxLayout.X_AXIS));

        Feature1Panel4.setMaximumSize(new java.awt.Dimension(32767, 15));
        Feature1Panel4.setMinimumSize(new java.awt.Dimension(10, 15));
        Feature1Panel4.setPreferredSize(new java.awt.Dimension(10, 15));
        AutoUpdateSupportLabel.setFont(new java.awt.Font("Arial", 0, 12));
        AutoUpdateSupportLabel.setText("Enable Automatic Software Update Support");
        AutoUpdateSupportLabel.setMaximumSize(new java.awt.Dimension(330, 15));
        AutoUpdateSupportLabel.setMinimumSize(new java.awt.Dimension(330, 15));
        AutoUpdateSupportLabel.setPreferredSize(new java.awt.Dimension(330, 15));
        AutoUpdateSupportLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AutoUpdateSupportLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AutoUpdateSupportLabelMouseExited(evt);
            }
        });
        Feature1Panel4.add(Filler5);
        Feature1Panel4.add(AutoUpdateSupportLabel);

        AutoUpdateCheckbox.setFont(new java.awt.Font("Arial", 0, 12));
        AutoUpdateCheckbox.setSelected(true);
        AutoUpdateCheckbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AutoUpdateCheckboxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AutoUpdateCheckboxMouseExited(evt);
            }
        });

        Feature1Panel4.add(AutoUpdateCheckbox);

        add(Feature1Panel4);

        FillerPanel4.setLayout(new javax.swing.BoxLayout(FillerPanel4, javax.swing.BoxLayout.X_AXIS));

        FillerPanel4.setMaximumSize(new java.awt.Dimension(10, 10));
        add(FillerPanel4);

        Feature1Panel5.setLayout(new javax.swing.BoxLayout(Feature1Panel5, javax.swing.BoxLayout.X_AXIS));

        Feature1Panel5.setMaximumSize(new java.awt.Dimension(32767, 15));
        Feature1Panel5.setMinimumSize(new java.awt.Dimension(10, 15));
        Feature1Panel5.setPreferredSize(new java.awt.Dimension(10, 15));
        MessagingSupportLabel.setFont(new java.awt.Font("Arial", 0, 12));
        MessagingSupportLabel.setText("Enable Messaging Support");
        MessagingSupportLabel.setMaximumSize(new java.awt.Dimension(330, 15));
        MessagingSupportLabel.setMinimumSize(new java.awt.Dimension(330, 15));
        MessagingSupportLabel.setPreferredSize(new java.awt.Dimension(330, 15));
        MessagingSupportLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MessagingSupportLabelMouseEntered(evt);
            }
        });
        Feature1Panel5.add(Filler6);
        Feature1Panel5.add(MessagingSupportLabel);

        MessagingCheckbox.setFont(new java.awt.Font("Arial", 0, 12));
        MessagingCheckbox.setSelected(true);
        MessagingCheckbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MessagingCheckboxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MessagingCheckboxMouseExited(evt);
            }
        });

        Feature1Panel5.add(MessagingCheckbox);

        add(Feature1Panel5);

        FillerPanel5.setLayout(new javax.swing.BoxLayout(FillerPanel5, javax.swing.BoxLayout.X_AXIS));

        FillerPanel5.setMaximumSize(new java.awt.Dimension(10, 10));
        add(FillerPanel5);

    }//GEN-END:initComponents

    private void MessagingCheckboxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagingCheckboxMouseExited
        ((NewProject)getParentComponent()).setStatus("");
    }//GEN-LAST:event_MessagingCheckboxMouseExited

    private void MessagingCheckboxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagingCheckboxMouseEntered
        ((NewProject)getParentComponent()).setStatus("Support sending messages to application users worldwide in multiple languages.");
    }//GEN-LAST:event_MessagingCheckboxMouseEntered

    private void AutoUpdateCheckboxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AutoUpdateCheckboxMouseExited
        ((NewProject)getParentComponent()).setStatus("");
    }//GEN-LAST:event_AutoUpdateCheckboxMouseExited

    private void AutoUpdateCheckboxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AutoUpdateCheckboxMouseEntered
        ((NewProject)getParentComponent()).setStatus("Send product enhancements, and bug fixes automatically to product users worldwide.");
    }//GEN-LAST:event_AutoUpdateCheckboxMouseEntered

    private void PaymentCheckboxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaymentCheckboxMouseExited
        ((NewProject)getParentComponent()).setStatus("");
    }//GEN-LAST:event_PaymentCheckboxMouseExited

    private void PaymentCheckboxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaymentCheckboxMouseEntered
        ((NewProject)getParentComponent()).setStatus("Integrate payment processing forms directly into your software product.");
    }//GEN-LAST:event_PaymentCheckboxMouseEntered

    private void RegistrationCheckboxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrationCheckboxMouseExited
        ((NewProject)getParentComponent()).setStatus("");
    }//GEN-LAST:event_RegistrationCheckboxMouseExited

    private void RegistrationCheckboxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrationCheckboxMouseEntered
        ((NewProject)getParentComponent()).setStatus("Integrate software evaluation with unlock registration/activation code support.");
    }//GEN-LAST:event_RegistrationCheckboxMouseEntered

    private void OptinCheckboxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptinCheckboxMouseExited
        ((NewProject)getParentComponent()).setStatus("");
    }//GEN-LAST:event_OptinCheckboxMouseExited

    private void OptinCheckboxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptinCheckboxMouseEntered
        ((NewProject)getParentComponent()).setStatus("Integrate web based e-mail opt-in support, for automated e-mail marketing.");
    }//GEN-LAST:event_OptinCheckboxMouseEntered

    private void EvaluationCheckboxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvaluationCheckboxMouseExited
        ((NewProject)getParentComponent()).setStatus("");
    }//GEN-LAST:event_EvaluationCheckboxMouseExited

    private void EvaluationCheckboxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvaluationCheckboxMouseEntered
        ((NewProject)getParentComponent()).setStatus("Timed Software Evaluation, try the product, before you buy functionality.");
    }//GEN-LAST:event_EvaluationCheckboxMouseEntered

    private void MessagingSupportLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagingSupportLabelMouseEntered
        ((NewProject)getParentComponent()).setStatus("Support sending messages to application users worldwide in multiple languages.");
    }//GEN-LAST:event_MessagingSupportLabelMouseEntered

    private void AutoUpdateSupportLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AutoUpdateSupportLabelMouseExited
        ((NewProject)getParentComponent()).setStatus("");
    }//GEN-LAST:event_AutoUpdateSupportLabelMouseExited

    private void AutoUpdateSupportLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AutoUpdateSupportLabelMouseEntered
        ((NewProject)getParentComponent()).setStatus("Send product enhancements, and bug fixes automatically to product users worldwide.");
    }//GEN-LAST:event_AutoUpdateSupportLabelMouseEntered

    private void PaymentProcessingLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaymentProcessingLabelMouseExited
        ((NewProject)getParentComponent()).setStatus("");
    }//GEN-LAST:event_PaymentProcessingLabelMouseExited

    private void PaymentProcessingLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaymentProcessingLabelMouseEntered
        ((NewProject)getParentComponent()).setStatus("Integrate payment processing forms directly into your software product.");
    }//GEN-LAST:event_PaymentProcessingLabelMouseEntered

    private void RegistrationCodeLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrationCodeLabelMouseExited
        ((NewProject)getParentComponent()).setStatus("");
    }//GEN-LAST:event_RegistrationCodeLabelMouseExited

    private void RegistrationCodeLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrationCodeLabelMouseEntered
        ((NewProject)getParentComponent()).setStatus("Integrate software evaluation with unlock registration/activation code support.");
    }//GEN-LAST:event_RegistrationCodeLabelMouseEntered

    private void OptinSupportLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptinSupportLabelMouseExited
        ((NewProject)getParentComponent()).setStatus("");
    }//GEN-LAST:event_OptinSupportLabelMouseExited

    private void OptinSupportLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptinSupportLabelMouseEntered
        ((NewProject)getParentComponent()).setStatus("Integrate web based e-mail opt-in support, for automated e-mail marketing.");
    }//GEN-LAST:event_OptinSupportLabelMouseEntered

    private void EvaluationSupportLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvaluationSupportLabelMouseExited
        ((NewProject)getParentComponent()).setStatus("");
    }//GEN-LAST:event_EvaluationSupportLabelMouseExited

    private void EvaluationSupportLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvaluationSupportLabelMouseEntered
        ((NewProject)getParentComponent()).setStatus("Timed Software Evaluation, try the product, before you buy functionality.");
    }//GEN-LAST:event_EvaluationSupportLabelMouseEntered

    private void EvaluationCheckboxActionPerformed(java.awt.event.ActionEvent evt) {
        getDataUpdate();
    }
    private void OptinCheckboxActionPerformed(java.awt.event.ActionEvent evt) {
        getDataUpdate();
    }
    private void RegistrationCheckboxActionPerformed(java.awt.event.ActionEvent evt) {
        getDataUpdate();
    }
    private void PaymentCheckboxActionPerformed(java.awt.event.ActionEvent evt) {
        getDataUpdate();
    }    
    private void AutoUpdateCheckboxActionPerformed(java.awt.event.ActionEvent evt) {
	try
	{
        getDataUpdate();
	  EAPanel thePanel = (EAPanel)getParentComponent();
        ((EAPanel)thePanel.getParentComponent()).setProjectData(); 
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}  
    }
    private void MessagingCheckboxActionPerformed(java.awt.event.ActionEvent evt) {
        getDataUpdate();
    }  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox AutoUpdateCheckbox;
    private javax.swing.JLabel AutoUpdateSupportLabel;
    private javax.swing.JLabel Filler1;
    private javax.swing.JLabel Filler2;
    private javax.swing.JLabel Filler3;
    private javax.swing.JLabel Filler4;
    private javax.swing.JLabel Filler5;
    private javax.swing.JLabel Filler6;
    private javax.swing.JCheckBox EvaluationCheckbox;
    private javax.swing.JLabel EvaluationSupportLabel;
    private javax.swing.JPanel Feature1Panel;
    private javax.swing.JPanel Feature1Panel1;
    private javax.swing.JPanel Feature1Panel2;
    private javax.swing.JPanel Feature1Panel3;
    private javax.swing.JPanel Feature1Panel4;
    private javax.swing.JPanel Feature1Panel5;
    private javax.swing.JPanel FillerPanel;
    private javax.swing.JPanel FillerPanel1;
    private javax.swing.JPanel FillerPanel2;
    private javax.swing.JPanel FillerPanel3;
    private javax.swing.JPanel FillerPanel4;
    private javax.swing.JPanel FillerPanel5;
    private javax.swing.JPanel FillerPanel6;
    private javax.swing.JCheckBox MessagingCheckbox;
    private javax.swing.JLabel MessagingSupportLabel;
    private javax.swing.JCheckBox OptinCheckbox;
    private javax.swing.JLabel OptinSupportLabel;
    private javax.swing.JCheckBox PaymentCheckbox;
    private javax.swing.JLabel PaymentProcessingLabel;
    private javax.swing.JCheckBox RegistrationCheckbox;
    private javax.swing.JLabel RegistrationCodeLabel;
    // End of variables declaration//GEN-END:variables
    
}

