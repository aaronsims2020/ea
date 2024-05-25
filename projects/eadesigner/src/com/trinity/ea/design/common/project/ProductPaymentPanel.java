/*
 * ProductOptinPanel.java
 *
 * Created on November 20, 2004, 12:05 PM
 */

package com.trinity.ea.design.common.project;

import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.rules.builder.DesignerRuleBuilder;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.common.project.NewProject;
import java.io.File;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author  aaronsc Trinity Software, LLC
 * Copyright ©2004 Trinity Software, LLC. All rights reserved.
 */
public class ProductPaymentPanel extends EAPanel {
    
    /** Creates new ProductOptinPanel */
    public ProductPaymentPanel() 
    {
        initComponents();
        try
        {
            setProjectData();    
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }        
    }
 
    /** Returns an int for the selected provider index id. Returns -1 on no item selected. */
    public int getSelectedOptinProviderIndex()
    {
        try
        {
             return ProjectList.getSelectedIndex();
        }
        catch(Exception e)
        {
            e.printStackTrace();
		return -1;
        }
    }    
    
    public synchronized void setProjectData()
    {
        try
        {
            if(ProjectManager.get("product_purchase_support_email")!=null)
            {
                if(ProjectManager.get("product_purchase_support_email").equalsIgnoreCase("")==false)
                {
                    PrivacyPolicyTextField.setText(ProjectManager.get("product_purchase_support_email"));
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    } 

    /* Updates the project data properties changes */
    public void getDataUpdate()
    {
        try
        {
	    ProjectManager.putTempNoFileWrite("product_purchase_support_email", PrivacyPolicyTextField.getText());
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
        ContentPanel = new javax.swing.JPanel();
        NewProjectPanelFileBox = new javax.swing.JPanel();
        SouthNewProjectPanelTopPanel1 = new javax.swing.JPanel();
        SouthNewProjectPanelTopPanel3 = new javax.swing.JPanel();
        OpenProjectPanelFileBox = new javax.swing.JPanel();
        SouthOpenProjectPanelLeftPanel = new javax.swing.JPanel();
        InnerProjectListPanel = new javax.swing.JPanel();
        ProjectListScrollPane = new javax.swing.JScrollPane();
        ProjectList = new javax.swing.JList();
        Filler12 = new javax.swing.JLabel();
        privacyPolicyEMailPanel = new javax.swing.JPanel();
        Filler11 = new javax.swing.JLabel();
        PrivacyPolicyEMailLabel = new javax.swing.JLabel();
        PrivacyPolicyTextField = new javax.swing.JTextField();
        Filler009 = new javax.swing.JLabel();
        GRAdPanel = new javax.swing.JPanel();
        Filler13 = new javax.swing.JLabel();
        taGROffer = new javax.swing.JTextArea();
        Filler10 = new javax.swing.JLabel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));

        ContentPanel.setLayout(new java.awt.BorderLayout());

        NewProjectPanelFileBox.setLayout(new javax.swing.BoxLayout(NewProjectPanelFileBox, javax.swing.BoxLayout.Y_AXIS));

        SouthNewProjectPanelTopPanel1.setMaximumSize(new java.awt.Dimension(32767, 50));
        SouthNewProjectPanelTopPanel1.setMinimumSize(new java.awt.Dimension(10, 50));
        SouthNewProjectPanelTopPanel1.setPreferredSize(new java.awt.Dimension(10, 50));
        NewProjectPanelFileBox.add(SouthNewProjectPanelTopPanel1);

        SouthNewProjectPanelTopPanel3.setMaximumSize(new java.awt.Dimension(32767, 50));
        SouthNewProjectPanelTopPanel3.setMinimumSize(new java.awt.Dimension(10, 50));
        SouthNewProjectPanelTopPanel3.setPreferredSize(new java.awt.Dimension(10, 50));
        NewProjectPanelFileBox.add(SouthNewProjectPanelTopPanel3);

        ContentPanel.add(NewProjectPanelFileBox, java.awt.BorderLayout.EAST);

        OpenProjectPanelFileBox.setLayout(new java.awt.BorderLayout());

        SouthOpenProjectPanelLeftPanel.setLayout(new java.awt.BorderLayout());

        SouthOpenProjectPanelLeftPanel.setMaximumSize(new java.awt.Dimension(32767, 30));
        SouthOpenProjectPanelLeftPanel.setMinimumSize(new java.awt.Dimension(368, 30));
        SouthOpenProjectPanelLeftPanel.setPreferredSize(new java.awt.Dimension(368, 30));
        InnerProjectListPanel.setLayout(new java.awt.BorderLayout());

        InnerProjectListPanel.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(10, 10, 10, 10)));
        ProjectListScrollPane.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        ProjectListScrollPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProjectListScrollPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProjectListScrollPaneMouseExited(evt);
            }
        });

        ProjectList.setFont(new java.awt.Font("Arial", 0, 12));
        ProjectList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "<html><b>&nbsp;1. Skipjack Transaction Network</b> - http://www.skipjack.com/</html>", "<html>&nbsp;<b>2.</b> Specify Payment Processing Web Page </html>","<html>&nbsp;<b>3.</b> Unlisted Provider - Configure an unlisted provider.</html>" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        ProjectList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ProjectList.setFixedCellHeight(20);
        ProjectList.setSelectedIndex(0);
        ProjectList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProjectListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProjectListMouseExited(evt);
            }
        });

        ProjectListScrollPane.setViewportView(ProjectList);

        InnerProjectListPanel.add(ProjectListScrollPane, java.awt.BorderLayout.CENTER);

        SouthOpenProjectPanelLeftPanel.add(InnerProjectListPanel, java.awt.BorderLayout.CENTER);

        Filler12.setMaximumSize(new java.awt.Dimension(10, 10));
        Filler12.setMinimumSize(new java.awt.Dimension(10, 10));
        Filler12.setPreferredSize(new java.awt.Dimension(10, 10));
        SouthOpenProjectPanelLeftPanel.add(Filler12, java.awt.BorderLayout.WEST);

        OpenProjectPanelFileBox.add(SouthOpenProjectPanelLeftPanel, java.awt.BorderLayout.CENTER);

        privacyPolicyEMailPanel.setMaximumSize(new java.awt.Dimension(32767, 27));
        privacyPolicyEMailPanel.setMinimumSize(new java.awt.Dimension(330, 27));
        privacyPolicyEMailPanel.setPreferredSize(new java.awt.Dimension(400, 27));
        Filler11.setMaximumSize(new java.awt.Dimension(10, 10));
        Filler11.setMinimumSize(new java.awt.Dimension(10, 10));
        Filler11.setPreferredSize(new java.awt.Dimension(10, 10));
        privacyPolicyEMailPanel.add(Filler11);

        PrivacyPolicyEMailLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        PrivacyPolicyEMailLabel.setText("Purchase Support E-Mail:");
        PrivacyPolicyEMailLabel.setMaximumSize(new java.awt.Dimension(145, 16));
        PrivacyPolicyEMailLabel.setMinimumSize(new java.awt.Dimension(145, 16));
        PrivacyPolicyEMailLabel.setPreferredSize(new java.awt.Dimension(145, 16));
        PrivacyPolicyEMailLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PrivacyPolicyEMailLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PrivacyPolicyEMailLabelMouseExited(evt);
            }
        });

        privacyPolicyEMailPanel.add(PrivacyPolicyEMailLabel);

        PrivacyPolicyTextField.setText("support@supportemailaddress.com");
        PrivacyPolicyTextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        PrivacyPolicyTextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        PrivacyPolicyTextField.setMargin(new java.awt.Insets(0, 10, 0, 5));
        PrivacyPolicyTextField.setMaximumSize(new java.awt.Dimension(2147483647, 22));
        PrivacyPolicyTextField.setMinimumSize(new java.awt.Dimension(140, 22));
        PrivacyPolicyTextField.setPreferredSize(new java.awt.Dimension(210, 22));
        PrivacyPolicyTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PrivacyPolicyTextFieldMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PrivacyPolicyTextFieldMouseExited(evt);
            }
        });

        privacyPolicyEMailPanel.add(PrivacyPolicyTextField);

        Filler009.setMaximumSize(new java.awt.Dimension(10, 10));
        Filler009.setMinimumSize(new java.awt.Dimension(10, 10));
        Filler009.setPreferredSize(new java.awt.Dimension(10, 10));
        privacyPolicyEMailPanel.add(Filler009);

        OpenProjectPanelFileBox.add(privacyPolicyEMailPanel, java.awt.BorderLayout.NORTH);

        GRAdPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        GRAdPanel.setMaximumSize(new java.awt.Dimension(32767, 30));
        GRAdPanel.setMinimumSize(new java.awt.Dimension(315, 30));
        GRAdPanel.setPreferredSize(new java.awt.Dimension(385, 30));
        Filler13.setMaximumSize(new java.awt.Dimension(20, 10));
        Filler13.setMinimumSize(new java.awt.Dimension(20, 10));
        Filler13.setPreferredSize(new java.awt.Dimension(20, 10));
        GRAdPanel.add(Filler13);

        Filler10.setMaximumSize(new java.awt.Dimension(10, 10));
        Filler10.setMinimumSize(new java.awt.Dimension(10, 10));
        Filler10.setPreferredSize(new java.awt.Dimension(10, 10));
        GRAdPanel.add(Filler10);

        OpenProjectPanelFileBox.add(GRAdPanel, java.awt.BorderLayout.SOUTH);

        ContentPanel.add(OpenProjectPanelFileBox, java.awt.BorderLayout.CENTER);

        add(ContentPanel);

    }//GEN-END:initComponents

    private void PrivacyPolicyEMailLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrivacyPolicyEMailLabelMouseExited
        ((NewProject)getParentComponent()).setStatus("");
    }//GEN-LAST:event_PrivacyPolicyEMailLabelMouseExited

    private void PrivacyPolicyEMailLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrivacyPolicyEMailLabelMouseEntered
        ((NewProject)getParentComponent()).setStatus("The e-mail address product users can contact you for product support inquiries."); 
    }//GEN-LAST:event_PrivacyPolicyEMailLabelMouseEntered
  
    private void PrivacyPolicyTextFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrivacyPolicyTextFieldMouseExited
        ((NewProject)getParentComponent()).setStatus("");
    }//GEN-LAST:event_PrivacyPolicyTextFieldMouseExited

    private void PrivacyPolicyTextFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrivacyPolicyTextFieldMouseEntered
        ((NewProject)getParentComponent()).setStatus("The e-mail address product users can contact you for product support inquiries."); 
    }//GEN-LAST:event_PrivacyPolicyTextFieldMouseEntered

    private void ProjectListScrollPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProjectListScrollPaneMouseExited
        ((NewProject)getParentComponent()).setStatus("");
    }//GEN-LAST:event_ProjectListScrollPaneMouseExited

    private void ProjectListScrollPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProjectListScrollPaneMouseEntered
        ((NewProject)getParentComponent()).setStatus("Select your Payment Processing provider, and click \"Next\" to continue."); 
    }//GEN-LAST:event_ProjectListScrollPaneMouseEntered

    private void ProjectListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProjectListMouseExited
        ((NewProject)getParentComponent()).setStatus("");
    }//GEN-LAST:event_ProjectListMouseExited

    private void ProjectListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProjectListMouseEntered
        ((NewProject)getParentComponent()).setStatus("Select your Payment Processing provider, and click \"Next\" to continue."); 
    }//GEN-LAST:event_ProjectListMouseEntered
      
    private static synchronized Object[] getStringArraysFromString(String textArrayString)
    {
        ArrayList aryList = new ArrayList();
        String tempString = "";
        while(textArrayString.indexOf(",")!=-1)
        {
            tempString = textArrayString.substring(0,textArrayString.indexOf(","));
            textArrayString = textArrayString.substring(textArrayString.indexOf(",") + 1);
            aryList.add(tempString);
        }
        aryList.add(textArrayString);
        return aryList.toArray();
    }        
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JLabel Filler009;
    private javax.swing.JLabel Filler10;
    private javax.swing.JLabel Filler11;
    private javax.swing.JLabel Filler12;
    private javax.swing.JLabel Filler13;
    private javax.swing.JPanel GRAdPanel;
    private javax.swing.JPanel InnerProjectListPanel;
    private javax.swing.JPanel NewProjectPanelFileBox;
    private javax.swing.JPanel OpenProjectPanelFileBox;
    private javax.swing.JLabel PrivacyPolicyEMailLabel;
    private javax.swing.JTextField PrivacyPolicyTextField;
    private javax.swing.JList ProjectList;
    private javax.swing.JScrollPane ProjectListScrollPane;
    private javax.swing.JPanel SouthNewProjectPanelTopPanel1;
    private javax.swing.JPanel SouthNewProjectPanelTopPanel3;
    private javax.swing.JPanel SouthOpenProjectPanelLeftPanel;
    private javax.swing.JPanel privacyPolicyEMailPanel;
    private javax.swing.JTextArea taGROffer;
    // End of variables declaration//GEN-END:variables
    
}
