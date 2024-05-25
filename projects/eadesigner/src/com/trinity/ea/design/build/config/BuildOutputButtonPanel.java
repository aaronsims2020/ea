/*
 * BuildOutputLocationPanel.java
 *
 * Created on May 24, 2004, 4:30 PM
 */

package com.trinity.ea.design.build.config;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.common.compiler.EACompiler;
import com.trinity.ea.design.rules.builder.DesignerRuleBuilder;
import com.trinity.ea.util.BrowserLauncher;
import com.trinity.ea.design.EADesigner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.DateFormat;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Font;
import java.net.URL;
import java.io.File;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class BuildOutputButtonPanel extends EAPanel {
    
    /** Creates new form BuildOutputLocationPanel */
    public BuildOutputButtonPanel() {
        initComponents();
        //JOptionPane.showMessageDialog(this, "The current working directory: " + System.getProperty("user.dir"));
    }
 
   
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        WestButtonPanel = new javax.swing.JPanel();
        btnBuildEAClient = new javax.swing.JButton();
        EastButtonPanel = new javax.swing.JPanel();
        btnWebPageDocument = new javax.swing.JButton();
        btnTryEvaluation = new javax.swing.JButton();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));

        setBackground(new java.awt.Color(100, 120, 170));
        setMaximumSize(new java.awt.Dimension(2147483647, 55));
        setMinimumSize(new java.awt.Dimension(12, 55));
        setPreferredSize(new java.awt.Dimension(12, 55));
        WestButtonPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 15));

        WestButtonPanel.setBackground(new java.awt.Color(100, 120, 170));
        WestButtonPanel.setMinimumSize(new java.awt.Dimension(10, 15));
        WestButtonPanel.setPreferredSize(new java.awt.Dimension(10, 25));
        btnBuildEAClient.setFont(new java.awt.Font("Arial", 0, 12));
        btnBuildEAClient.setMnemonic('B');
        btnBuildEAClient.setText("Build Project");
        //btnBuildEAClient.setMaximumSize(new java.awt.Dimension(100, 25));
        //btnBuildEAClient.setMinimumSize(new java.awt.Dimension(100, 25));
        //btnBuildEAClient.setPreferredSize(new java.awt.Dimension(100, 25));
        btnBuildEAClient.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnBuildEAClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuildEAClientActionPerformed(evt);
            }
        });

        WestButtonPanel.add(btnBuildEAClient);

        add(WestButtonPanel);

        EastButtonPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 15, 15));

        EastButtonPanel.setBackground(new java.awt.Color(100, 120, 170));
        EastButtonPanel.setMinimumSize(new java.awt.Dimension(10, 15));
        EastButtonPanel.setPreferredSize(new java.awt.Dimension(10, 25));
        btnWebPageDocument.setFont(new java.awt.Font("Arial", 0, 12));
        btnWebPageDocument.setMnemonic('V');
        btnWebPageDocument.setText("View Implementation Instructions");
        btnWebPageDocument.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnWebPageDocument.setEnabled(false);
        btnWebPageDocument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWebPageDocumentActionPerformed(evt);
            }
        });

        EastButtonPanel.add(btnWebPageDocument);

        btnTryEvaluation.setFont(new java.awt.Font("Arial", 0, 12));
        btnTryEvaluation.setMnemonic('T');
        btnTryEvaluation.setText("Try Evaluation");
        btnTryEvaluation.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnTryEvaluation.setEnabled(false);
        btnTryEvaluation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTryEvaluationActionPerformed(evt);
            }
        });

        EastButtonPanel.add(btnTryEvaluation);

        add(EastButtonPanel);

    }//GEN-END:initComponents

    private void btnTryEvaluationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTryEvaluationActionPerformed
	try
	{ 
       	getParentComp().getTerminateEAPreview();
       	getParentComp().getEAPreview();
	}
	catch(Exception e)
	{
		
	}
    }//GEN-LAST:event_btnTryEvaluationActionPerformed

    private void btnWebPageDocumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWebPageDocumentActionPerformed
            try
            {
                 BrowserLauncher.openURL(new URL(new File(new URL(ProjectManager.get("project_build_dir")).getFile()).toURL().toString() + "README.html").toString());
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
    }//GEN-LAST:event_btnWebPageDocumentActionPerformed

    private void btnBuildEAClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuildEAClientActionPerformed
        try
        {
       	getParentComp().getTerminateEAPreview();
		getParentComp().setSaveEAProject();
		int retCode = new EACompiler().uiCompile(new File(new URL(ProjectManager.get("project_build_dir")).getFile()));
		int retCodeJarBuild = new EACompiler().buildJar(new File(new URL(ProjectManager.get("project_build_dir")).getFile()));
		if(retCodeJarBuild!=0)
		{
			retCode=10 + retCodeJarBuild;
			btnTryEvaluation.setEnabled(false);
		}
            if(retCode==0)
		{
        	      ProjectManager.saveSinglePut("project_last_built",new Date().toString());
			if(theTempPanel!=null)
			{
				theTempPanel.setProjectData();
			}
            // If no evaluation/registration/payment processing features enabled set product value to registered so features like messaging/auto-update/(possibly opt-in) function
            if(ProjectManager.get("project_expiration_support_is_enabled").equalsIgnoreCase("false") == true)
            {
                if(ProjectManager.get("project_registration_code_support_is_enabled").equalsIgnoreCase("false") == true)
                {
                    if(ProjectManager.get("project_payment_processing_support_is_enabled").equalsIgnoreCase("false") == true)
                    {
				btnTryEvaluation.setEnabled(false);
                    }
			  else
			  {
				btnTryEvaluation.setEnabled(true);
			  }
                }
		  else
		  {
			btnTryEvaluation.setEnabled(true);
		  }
            } 
		else
		{
			btnTryEvaluation.setEnabled(true);
		}
            //
			btnWebPageDocument.setEnabled(true);
        		getParentComp().showMessageDialog("Build Completed Successfully.");
  		}
		else
		{
        		getParentComp().showMessageDialog("Build Failed. Return Code: " + String.valueOf(retCode));
		}
        }
        catch(Exception e)
        {
		e.printStackTrace();
        }
    }//GEN-LAST:event_btnBuildEAClientActionPerformed
    
//public static void main(String[] args)
//{
//	JFrame frame = new JFrame("Testing");
//	frame.getContentPane().setLayout(new java.awt.BorderLayout());
//	frame.getContentPane().add(new BuildOutputButtonPanel(),java.awt.BorderLayout.CENTER);
//	frame.setSize(600,175);
//	frame.show();
//}

 protected MainBottomPanel theTempPanel = null;
 protected void setMainBottomPanel(MainBottomPanel mbp)
 {
	theTempPanel = mbp;
 }   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EastButtonPanel;
    private javax.swing.JPanel WestButtonPanel;
    private javax.swing.JButton btnBuildEAClient;
    private javax.swing.JButton btnTryEvaluation;
    private javax.swing.JButton btnWebPageDocument;
    // End of variables declaration//GEN-END:variables
    
}
