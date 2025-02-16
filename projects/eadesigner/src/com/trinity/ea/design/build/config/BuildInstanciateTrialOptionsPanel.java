/*
 * BuildInstanciateTrialOptionsPanel.java
 *
 * Created on January 14, 2004, 4:50 PM
 *
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
 * Copyright ©2005 Trinity Software. All rights reserved.
 */
public class BuildInstanciateTrialOptionsPanel extends EAPanel {
    
    /** Creates new form BuildInstanciateTrialOptionsPanel */
    public BuildInstanciateTrialOptionsPanel() {
        initComponents();
        setProjectData();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        StartTrialOptions = new javax.swing.JPanel();
        DescriptionPanel = new javax.swing.JPanel();
        MessageDeliveryPanel = new javax.swing.JPanel();
        rbDefaultOptionPanel = new javax.swing.JPanel();
        SpacerPanel2 = new javax.swing.JPanel();
        taUseDefaultLocale = new javax.swing.JTextArea();
        FillerLabel1 = new javax.swing.JLabel();
        rbAutoStartEval = new javax.swing.JRadioButton();
        Separator22 = new javax.swing.JLabel();
        rbOnlySelectedLanguagesPanel = new javax.swing.JPanel();
        SpacerPanel = new javax.swing.JPanel();
        taOnlySelectedLanguages = new javax.swing.JTextArea();
        FillerLabel = new javax.swing.JLabel();
        rbProgrammaticStartEval = new javax.swing.JRadioButton();

        setLayout(new java.awt.BorderLayout());

        setBackground(new java.awt.Color(100, 120, 170));
        StartTrialOptions.setLayout(new javax.swing.BoxLayout(StartTrialOptions, javax.swing.BoxLayout.Y_AXIS));

        StartTrialOptions.setBackground(new java.awt.Color(100, 120, 170));
        StartTrialOptions.setMaximumSize(new java.awt.Dimension(32767, 150));
        StartTrialOptions.setMinimumSize(new java.awt.Dimension(10, 150));
        StartTrialOptions.setPreferredSize(new java.awt.Dimension(10, 150));
        StartTrialOptions.setRequestFocusEnabled(false);
        DescriptionPanel.setLayout(new javax.swing.BoxLayout(DescriptionPanel, javax.swing.BoxLayout.X_AXIS));

        DescriptionPanel.setBackground(new java.awt.Color(100, 120, 170));
        DescriptionPanel.setMaximumSize(new java.awt.Dimension(32767, 150));
        DescriptionPanel.setMinimumSize(new java.awt.Dimension(10, 150));
        DescriptionPanel.setPreferredSize(new java.awt.Dimension(10, 150));
        MessageDeliveryPanel.setLayout(new javax.swing.BoxLayout(MessageDeliveryPanel, javax.swing.BoxLayout.Y_AXIS));

        MessageDeliveryPanel.setBackground(new java.awt.Color(100, 120, 170));
        MessageDeliveryPanel.setMaximumSize(new java.awt.Dimension(520, 150));
        MessageDeliveryPanel.setMinimumSize(new java.awt.Dimension(66, 150));
        MessageDeliveryPanel.setPreferredSize(new java.awt.Dimension(42, 150));
        rbDefaultOptionPanel.setLayout(new javax.swing.BoxLayout(rbDefaultOptionPanel, javax.swing.BoxLayout.X_AXIS));

        rbDefaultOptionPanel.setBackground(new java.awt.Color(100, 120, 170));
        rbDefaultOptionPanel.setMaximumSize(new java.awt.Dimension(300, 30));
        rbDefaultOptionPanel.setMinimumSize(new java.awt.Dimension(45, 30));
        rbDefaultOptionPanel.setPreferredSize(new java.awt.Dimension(21, 30));
        SpacerPanel2.setLayout(new javax.swing.BoxLayout(SpacerPanel2, javax.swing.BoxLayout.X_AXIS));

        SpacerPanel2.setBackground(new java.awt.Color(100, 120, 170));
        SpacerPanel2.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        taUseDefaultLocale.setBackground(new java.awt.Color(100, 120, 170));
        taUseDefaultLocale.setEditable(false);
        taUseDefaultLocale.setFont(new java.awt.Font("Arial", 0, 12));
        taUseDefaultLocale.setLineWrap(true);
        taUseDefaultLocale.setText("Automatically start evaluation the first time the application is run.");
        taUseDefaultLocale.setWrapStyleWord(true);
        taUseDefaultLocale.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        taUseDefaultLocale.setMinimumSize(new java.awt.Dimension(50, 15));
        SpacerPanel2.add(taUseDefaultLocale);

        FillerLabel1.setBackground(new java.awt.Color(100, 120, 170));
        FillerLabel1.setMaximumSize(new java.awt.Dimension(10, 10));
        FillerLabel1.setMinimumSize(new java.awt.Dimension(10, 10));
        FillerLabel1.setPreferredSize(new java.awt.Dimension(10, 10));
        SpacerPanel2.add(FillerLabel1);

        rbDefaultOptionPanel.add(SpacerPanel2);

        rbAutoStartEval.setBackground(new java.awt.Color(100, 120, 170));
        rbAutoStartEval.setFont(new java.awt.Font("Arial", 0, 11));
        rbAutoStartEval.setSelected(true);
        rbAutoStartEval.setMaximumSize(new java.awt.Dimension(21, 80));
        rbAutoStartEval.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        rbAutoStartEval.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        rbAutoStartEval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAutoStartEvalActionPerformed(evt);
            }
        });

        rbDefaultOptionPanel.add(rbAutoStartEval);

        MessageDeliveryPanel.add(rbDefaultOptionPanel);

        Separator22.setBackground(new java.awt.Color(100, 120, 170));
        Separator22.setMaximumSize(new java.awt.Dimension(10, 10));
        Separator22.setMinimumSize(new java.awt.Dimension(10, 10));
        Separator22.setPreferredSize(new java.awt.Dimension(10, 10));
        MessageDeliveryPanel.add(Separator22);

        rbOnlySelectedLanguagesPanel.setLayout(new javax.swing.BoxLayout(rbOnlySelectedLanguagesPanel, javax.swing.BoxLayout.X_AXIS));

        rbOnlySelectedLanguagesPanel.setBackground(new java.awt.Color(100, 120, 170));
        rbOnlySelectedLanguagesPanel.setMaximumSize(new java.awt.Dimension(300, 110));
        rbOnlySelectedLanguagesPanel.setMinimumSize(new java.awt.Dimension(21, 110));
        rbOnlySelectedLanguagesPanel.setPreferredSize(new java.awt.Dimension(21, 110));
        SpacerPanel.setLayout(new javax.swing.BoxLayout(SpacerPanel, javax.swing.BoxLayout.X_AXIS));

        SpacerPanel.setBackground(new java.awt.Color(100, 120, 170));
        SpacerPanel.setMaximumSize(new java.awt.Dimension(2147483647, 110));
        SpacerPanel.setMinimumSize(new java.awt.Dimension(60, 110));
        SpacerPanel.setPreferredSize(new java.awt.Dimension(110, 110));
        taOnlySelectedLanguages.setBackground(new java.awt.Color(100, 120, 170));
        taOnlySelectedLanguages.setEditable(false);
        taOnlySelectedLanguages.setFont(new java.awt.Font("Arial", 0, 12));
        taOnlySelectedLanguages.setLineWrap(true);
        taOnlySelectedLanguages.setText("Programmatically sign the evaluation with the application installation program. The StartTrial.class implementation instructions will be generated at build time. The application is disabled until the StartTrial.class instanciation method is executed. ");
        taOnlySelectedLanguages.setWrapStyleWord(true);
        taOnlySelectedLanguages.setMaximumSize(new java.awt.Dimension(2147483647, 110));
        taOnlySelectedLanguages.setMinimumSize(new java.awt.Dimension(50, 110));
        taOnlySelectedLanguages.setPreferredSize(new java.awt.Dimension(100, 110));
        SpacerPanel.add(taOnlySelectedLanguages);

        FillerLabel.setBackground(new java.awt.Color(100, 120, 170));
        FillerLabel.setMaximumSize(new java.awt.Dimension(10, 10));
        FillerLabel.setMinimumSize(new java.awt.Dimension(10, 10));
        FillerLabel.setPreferredSize(new java.awt.Dimension(10, 10));
        SpacerPanel.add(FillerLabel);

        rbOnlySelectedLanguagesPanel.add(SpacerPanel);

        rbProgrammaticStartEval.setBackground(new java.awt.Color(100, 120, 170));
        rbProgrammaticStartEval.setFont(new java.awt.Font("Arial", 0, 11));
        rbProgrammaticStartEval.setMaximumSize(new java.awt.Dimension(21, 110));
        rbProgrammaticStartEval.setMinimumSize(new java.awt.Dimension(21, 110));
        rbProgrammaticStartEval.setPreferredSize(new java.awt.Dimension(21, 110));
        rbProgrammaticStartEval.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        rbProgrammaticStartEval.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        rbProgrammaticStartEval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbProgrammaticStartEvalActionPerformed(evt);
            }
        });

        rbOnlySelectedLanguagesPanel.add(rbProgrammaticStartEval);

        MessageDeliveryPanel.add(rbOnlySelectedLanguagesPanel);

        DescriptionPanel.add(MessageDeliveryPanel);

        StartTrialOptions.add(DescriptionPanel);

        add(StartTrialOptions, java.awt.BorderLayout.CENTER);

    }//GEN-END:initComponents

    private void rbProgrammaticStartEvalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbProgrammaticStartEvalActionPerformed
        rbAutoStartEval.setSelected(false);     
        rbProgrammaticStartEval.setSelected(true);    
        getDataUpdate();
    }//GEN-LAST:event_rbProgrammaticStartEvalActionPerformed

    private void rbAutoStartEvalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAutoStartEvalActionPerformed
        rbAutoStartEval.setSelected(true);     
        rbProgrammaticStartEval.setSelected(false);    
        getDataUpdate();
    }//GEN-LAST:event_rbAutoStartEvalActionPerformed
    
    public synchronized void setProjectData()
    {
        try
        {
            if(ProjectManager.get("allowInternalStartTrialInstanciation").equalsIgnoreCase("true")==true)
            {
                rbAutoStartEval.setSelected(true);     
                rbProgrammaticStartEval.setSelected(false);                   
            }
            else
            {
                rbAutoStartEval.setSelected(false);     
                rbProgrammaticStartEval.setSelected(true);                
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
            if(rbAutoStartEval.isSelected()==true)
            {
		    ProjectManager.putTempNoFileWrite("allowInternalStartTrialInstanciation", "true");
            }
            else
            {
		    ProjectManager.putTempNoFileWrite("allowInternalStartTrialInstanciation", "false");
            }
            ProjectManager.saveTempNow();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
  }          
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DescriptionPanel;
    private javax.swing.JLabel FillerLabel;
    private javax.swing.JLabel FillerLabel1;
    private javax.swing.JPanel MessageDeliveryPanel;
    private javax.swing.JLabel Separator22;
    private javax.swing.JPanel SpacerPanel;
    private javax.swing.JPanel SpacerPanel2;
    private javax.swing.JPanel StartTrialOptions;
    private javax.swing.JRadioButton rbAutoStartEval;
    private javax.swing.JPanel rbDefaultOptionPanel;
    private javax.swing.JPanel rbOnlySelectedLanguagesPanel;
    private javax.swing.JRadioButton rbProgrammaticStartEval;
    private javax.swing.JTextArea taOnlySelectedLanguages;
    private javax.swing.JTextArea taUseDefaultLocale;
    // End of variables declaration//GEN-END:variables
    
}
