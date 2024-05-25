/*
 * EncryptionConfigurationPanel.java
 *
 * Created on April 22, 2004, 4:18 PM
 */

package com.trinity.ea.design.autoupdate.encrypt;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.common.panel.DataContentPanel;
import com.trinity.ea.design.common.X500PrincipalChooser.X500PrincipalChooser;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2005 Trinity Software. All rights reserved.
 */
public class X500EncryptionConfigurationPanel extends EAPanel {

    private Color backgroundColor = new java.awt.Color(140, 160, 210);   
 
    /** Creates new form EncryptionConfigurationPanel */
    public X500EncryptionConfigurationPanel() {
        initComponents();
 	setProjectData();       
    }

   public synchronized void getDataUpdate()
   {
        try
        {
		// Auto Update Support Password Seed and Password Count Functionality variables
		ProjectManager.putTempNoFileWrite("autoUpdateX500Principal", tfSoftwareTitle1.getText());
		ProjectManager.saveTempNow();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
  }   

    public synchronized void setProjectData()
    {
        try
        {
		// Registration Code Serial Number TextField  
            if(ProjectManager.get("autoUpdateX500Principal")!=null)
            {
		    tfSoftwareTitle1.setOpaque(true);
		    tfSoftwareTitle1.setText(ProjectManager.get("autoUpdateX500Principal"));
		    tfSoftwareTitle1.setCaretPosition(0);
            }
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
        X500PrincipalPanel = new javax.swing.JPanel();
        lFiller19 = new javax.swing.JLabel();
        taX500PrincipalDescription = new javax.swing.JTextArea();
        lFiller22 = new javax.swing.JLabel();
        RegistrationSettingsPanelItem = new javax.swing.JPanel();
        lFiller12 = new javax.swing.JLabel();
        tfSoftwareTitle1 = new javax.swing.JTextField();
        lFiller18 = new javax.swing.JLabel();
        btnGenerateEvaluationUnlockCode = new javax.swing.JButton();
        lFiller14 = new javax.swing.JLabel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        setBackground(new java.awt.Color(140, 160, 210));
        X500PrincipalPanel.setLayout(new javax.swing.BoxLayout(X500PrincipalPanel, javax.swing.BoxLayout.X_AXIS));

        X500PrincipalPanel.setBackground(new java.awt.Color(140, 160, 210));
        X500PrincipalPanel.setMaximumSize(new java.awt.Dimension(2147483647, 79));
        X500PrincipalPanel.setMinimumSize(new java.awt.Dimension(300, 79));
        X500PrincipalPanel.setPreferredSize(new java.awt.Dimension(800, 79));
        lFiller19.setBackground(new java.awt.Color(140, 160, 210));
        lFiller19.setText("   ");
        lFiller19.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller19.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller19.setPreferredSize(new java.awt.Dimension(10, 16));
        X500PrincipalPanel.add(lFiller19);

        taX500PrincipalDescription.setBackground(new java.awt.Color(140, 160, 210));
        taX500PrincipalDescription.setEditable(false);
        taX500PrincipalDescription.setFont(new java.awt.Font("Arial", 0, 12));
        taX500PrincipalDescription.setLineWrap(true);
        taX500PrincipalDescription.setText("Type in the X500 Principal representing the subject distinguished name, or click the \"Find Subject X500 Principal...\" button to select a Jar file that was already signed with the digital signature that will be used for automatic software updates, and select the X500 Principal (Subject Distinguished Name), to be used for identity validation. The X500 Principal is required if Automatic Software Update Java Code Signing is enabled. If the X500 Principal is not specified, software update files will be ignored by the EvaluateAnywhere Distribution Client.");
        taX500PrincipalDescription.setWrapStyleWord(true);
        X500PrincipalPanel.add(taX500PrincipalDescription);

        lFiller22.setBackground(new java.awt.Color(140, 160, 210));
        lFiller22.setText("   ");
        lFiller22.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller22.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller22.setPreferredSize(new java.awt.Dimension(15, 16));
        X500PrincipalPanel.add(lFiller22);

        add(X500PrincipalPanel);

        RegistrationSettingsPanelItem.setLayout(new javax.swing.BoxLayout(RegistrationSettingsPanelItem, javax.swing.BoxLayout.X_AXIS));

        RegistrationSettingsPanelItem.setBackground(new java.awt.Color(140, 160, 210));
        RegistrationSettingsPanelItem.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        RegistrationSettingsPanelItem.setMinimumSize(new java.awt.Dimension(300, 30));
        RegistrationSettingsPanelItem.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller12.setBackground(new java.awt.Color(140, 160, 210));
        lFiller12.setText("   ");
        lFiller12.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller12.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller12.setPreferredSize(new java.awt.Dimension(10, 16));
        RegistrationSettingsPanelItem.add(lFiller12);

        tfSoftwareTitle1.setFont(new java.awt.Font("Arial", 0, 12));
        tfSoftwareTitle1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfSoftwareTitle1.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfSoftwareTitle1.setMinimumSize(new java.awt.Dimension(150, 20));
        tfSoftwareTitle1.setPreferredSize(new java.awt.Dimension(450, 20));
        RegistrationSettingsPanelItem.add(tfSoftwareTitle1);

        lFiller18.setBackground(new java.awt.Color(140, 160, 210));
        lFiller18.setMaximumSize(new java.awt.Dimension(5, 15));
        lFiller18.setMinimumSize(new java.awt.Dimension(5, 16));
        lFiller18.setPreferredSize(new java.awt.Dimension(5, 16));
        RegistrationSettingsPanelItem.add(lFiller18);

        btnGenerateEvaluationUnlockCode.setFont(new java.awt.Font("Arial", 0, 12));
        btnGenerateEvaluationUnlockCode.setText("Find Subject X500 Principal...");
        btnGenerateEvaluationUnlockCode.setMnemonic('i');
        btnGenerateEvaluationUnlockCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateEvaluationUnlockCodeActionPerformed(evt);
            }
        });

        RegistrationSettingsPanelItem.add(btnGenerateEvaluationUnlockCode);

        lFiller14.setBackground(new java.awt.Color(140, 160, 210));
        lFiller14.setText("   ");
        lFiller14.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller14.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller14.setPreferredSize(new java.awt.Dimension(15, 16));
        RegistrationSettingsPanelItem.add(lFiller14);

        add(RegistrationSettingsPanelItem);

    }//GEN-END:initComponents

    private void btnGenerateEvaluationUnlockCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateEvaluationUnlockCodeActionPerformed
	try
	{
            String theResult = X500PrincipalChooser.getX500Principal(this);
            if(theResult!=null)
            {
                tfSoftwareTitle1.setText(theResult);                
            }

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_btnGenerateEvaluationUnlockCodeActionPerformed
    
     private void btnGeneratePasswordCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneratePasswordCountActionPerformed

    }//GEN-LAST:event_btnGeneratePasswordCountActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel RegistrationSettingsPanelItem;
    private javax.swing.JPanel X500PrincipalPanel;
    private javax.swing.JButton btnGenerateEvaluationUnlockCode;
    private javax.swing.JLabel lFiller12;
    private javax.swing.JLabel lFiller14;
    private javax.swing.JLabel lFiller18;
    private javax.swing.JLabel lFiller19;
    private javax.swing.JLabel lFiller22;
    private javax.swing.JTextArea taX500PrincipalDescription;
    private javax.swing.JTextField tfSoftwareTitle1;
    // End of variables declaration//GEN-END:variables

   /* EADesignerRegistrationPanel parentObj = null;
    public void setMasterStatusController(EADesignerRegistrationPanel parentObject)
    {
        parentObj = parentObject;
    }
*/
}
