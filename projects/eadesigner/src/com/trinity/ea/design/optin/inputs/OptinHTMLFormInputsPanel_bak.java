/* 
 * OptinHTMLFormInputsPanel.java
 *
 * Created on December 30, 2003, 2:28 PM
 */

package com.trinity.ea.design.optin.inputs;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.common.panel.EAPropertiesPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class OptinHTMLFormInputsPanel_bak extends EAPanel {
    
    private Color backgroundColor = new java.awt.Color(140, 160, 210);
    private Color borderColor1 = new java.awt.Color(198, 226, 253);
    private Color borderColor2 = new java.awt.Color(96, 110, 145);
    private Color rowColor = new java.awt.Color(220, 225, 240);
    private Color rowBorderColor = new java.awt.Color(255, 255, 255);
    private int rowHeight = 25;

    /** Creates new form PaymentHTMLFormInputs */
    public OptinHTMLFormInputsPanel_bak() {
        initComponents();
	  setProjectData();
    }

 
    public void getDataUpdate()
    {
        try
        {
		ProjectManager.putTempNoFileWrite("optinInputFullName", tfEMailOptinHTMLFormInputPersonName.getText());
		ProjectManager.putTempNoFileWrite("optinInputEMailAddress", tfEMailOptinHTMLFormInputEMailAddress.getText());
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
		tfEMailOptinHTMLFormInputPersonName.setText(ProjectManager.get("optinInputFullName"));
		tfEMailOptinHTMLFormInputEMailAddress.setText(ProjectManager.get("optinInputEMailAddress"));
		tfEMailOptinHTMLFormInputPersonName.setCaretPosition(0);
		tfEMailOptinHTMLFormInputEMailAddress.setCaretPosition(0);
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
        tabHTMLFormInputs = new javax.swing.JPanel();
        OptinSettingsPanelItem5 = new javax.swing.JPanel();
        OptinHTMLFormInputElementsPanel = new javax.swing.JPanel();
        taUIStringsOptinDescription1 = new javax.swing.JTextArea();
        OptinHTMLFormInputElementsPanelItem1 = new javax.swing.JPanel();
        OptinTitlePanel6 = new javax.swing.JPanel();
        lEMailOptinHTMLFormInputPersonName = new javax.swing.JLabel();
        tfEMailOptinHTMLFormInputPersonName = new javax.swing.JTextField();
        OptinTitleRightPanel6 = new javax.swing.JPanel();
        OptinHTMLFormInputElementsPanelItem2 = new javax.swing.JPanel();
        OptinHTMLFormInputElementsEMailContentPanel = new javax.swing.JPanel();
        lEMailOptinHTMLFormInputEMailAddress = new javax.swing.JLabel();
        tfEMailOptinHTMLFormInputEMailAddress = new javax.swing.JTextField();
        OptinHTMLFormInputElementsEMailRightFillerPanel = new javax.swing.JPanel();
        OptinSettingsPanelItem6 = new javax.swing.JPanel();
        OptinHTMLFormInputElementsPanelItem3 = new javax.swing.JPanel();
        OptinTitlePanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        OptinHTMLFormInputElementsPanelItem4 = new javax.swing.JPanel();
        OptinHTMLFormInputElementsEMailContentPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        OptinHTMLFormInputElementsEMailRightFillerPanel1 = new javax.swing.JPanel();
//theEAProperties = new EAPropertiesPanel();
theEAProperties = new EAPropertiesPanel(rowColor, rowBorderColor, backgroundColor, rowHeight);


        setLayout(new java.awt.BorderLayout());

        setBackground(backgroundColor);
        setMaximumSize(new java.awt.Dimension(2147483647, 371));
        setMinimumSize(new java.awt.Dimension(22, 350));
        setPreferredSize(new java.awt.Dimension(456, 344));
        tabHTMLFormInputs.setLayout(new java.awt.BorderLayout());

        tabHTMLFormInputs.setBackground(backgroundColor);
        tabHTMLFormInputs.setPreferredSize(new java.awt.Dimension(448, 400));
        OptinSettingsPanelItem5.setLayout(new javax.swing.BoxLayout(OptinSettingsPanelItem5, javax.swing.BoxLayout.Y_AXIS));

        OptinSettingsPanelItem5.setBackground(backgroundColor);
        OptinSettingsPanelItem5.setMaximumSize(new java.awt.Dimension(0, 200));
        OptinSettingsPanelItem5.setMinimumSize(new java.awt.Dimension(0, 20));
        OptinSettingsPanelItem5.setPreferredSize(new java.awt.Dimension(0, 110));
        OptinHTMLFormInputElementsPanel.setLayout(new java.awt.BorderLayout());

        OptinHTMLFormInputElementsPanel.setBackground(backgroundColor);
        OptinHTMLFormInputElementsPanel.setMaximumSize(new java.awt.Dimension(32767, 33));
        taUIStringsOptinDescription1.setBackground(backgroundColor);
        taUIStringsOptinDescription1.setEditable(false);
        taUIStringsOptinDescription1.setFont(new java.awt.Font("Arial", 0, 12));
        taUIStringsOptinDescription1.setLineWrap(true);
        taUIStringsOptinDescription1.setText("The E-mail Opt-In HTML Form Input Element Names are defined below.");
//
	  theEAProperties.setDescriptorText("Define HTML Form Input Names.");
	  theEAProperties.setHeaderText("Input Name Attributes");
//
        taUIStringsOptinDescription1.setWrapStyleWord(true);
        taUIStringsOptinDescription1.setMargin(new java.awt.Insets(10, 10, 10, 10));
        taUIStringsOptinDescription1.setSelectionColor(new java.awt.Color(100, 120, 170));
        OptinHTMLFormInputElementsPanel.add(taUIStringsOptinDescription1, java.awt.BorderLayout.CENTER);

        OptinSettingsPanelItem5.add(OptinHTMLFormInputElementsPanel);

        OptinHTMLFormInputElementsPanelItem1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        OptinHTMLFormInputElementsPanelItem1.setBackground(backgroundColor);
        OptinHTMLFormInputElementsPanelItem1.setMaximumSize(new java.awt.Dimension(32767, 33));
        OptinTitlePanel6.setBackground(backgroundColor);
        OptinTitlePanel6.setMaximumSize(new java.awt.Dimension(100, 2147483647));
        lEMailOptinHTMLFormInputPersonName.setBackground(backgroundColor);
        lEMailOptinHTMLFormInputPersonName.setFont(new java.awt.Font("Arial", 0, 12));
        lEMailOptinHTMLFormInputPersonName.setText("Person's Name Input Name Attribute:");
        OptinTitlePanel6.add(lEMailOptinHTMLFormInputPersonName);

        tfEMailOptinHTMLFormInputPersonName.setPreferredSize(new java.awt.Dimension(220, 19));
        OptinTitlePanel6.add(tfEMailOptinHTMLFormInputPersonName);

        OptinHTMLFormInputElementsPanelItem1.add(OptinTitlePanel6);

        OptinTitleRightPanel6.setLayout(new javax.swing.BoxLayout(OptinTitleRightPanel6, javax.swing.BoxLayout.Y_AXIS));

        OptinTitleRightPanel6.setBackground(backgroundColor);
        OptinHTMLFormInputElementsPanelItem1.add(OptinTitleRightPanel6);

        OptinSettingsPanelItem5.add(OptinHTMLFormInputElementsPanelItem1);

        OptinHTMLFormInputElementsPanelItem2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        OptinHTMLFormInputElementsPanelItem2.setBackground(backgroundColor);
        OptinHTMLFormInputElementsPanelItem2.setMaximumSize(new java.awt.Dimension(32767, 33));
        OptinHTMLFormInputElementsEMailContentPanel.setBackground(backgroundColor);
        OptinHTMLFormInputElementsEMailContentPanel.setMaximumSize(new java.awt.Dimension(100, 2147483647));
        lEMailOptinHTMLFormInputEMailAddress.setBackground(backgroundColor);
        lEMailOptinHTMLFormInputEMailAddress.setFont(new java.awt.Font("Arial", 0, 12));
        lEMailOptinHTMLFormInputEMailAddress.setText("E-mail Address Input Name Attribute:");
        OptinHTMLFormInputElementsEMailContentPanel.add(lEMailOptinHTMLFormInputEMailAddress);

        tfEMailOptinHTMLFormInputEMailAddress.setPreferredSize(new java.awt.Dimension(220, 19));
        OptinHTMLFormInputElementsEMailContentPanel.add(tfEMailOptinHTMLFormInputEMailAddress);

        OptinHTMLFormInputElementsPanelItem2.add(OptinHTMLFormInputElementsEMailContentPanel);

        OptinHTMLFormInputElementsEMailRightFillerPanel.setLayout(new javax.swing.BoxLayout(OptinHTMLFormInputElementsEMailRightFillerPanel, javax.swing.BoxLayout.Y_AXIS));

        OptinHTMLFormInputElementsEMailRightFillerPanel.setBackground(backgroundColor);
        OptinHTMLFormInputElementsPanelItem2.add(OptinHTMLFormInputElementsEMailRightFillerPanel);

        OptinSettingsPanelItem5.add(OptinHTMLFormInputElementsPanelItem2);

        tabHTMLFormInputs.add(OptinSettingsPanelItem5, java.awt.BorderLayout.NORTH);

        OptinSettingsPanelItem6.setLayout(new javax.swing.BoxLayout(OptinSettingsPanelItem6, javax.swing.BoxLayout.Y_AXIS));

        OptinSettingsPanelItem6.setBackground(backgroundColor);
        OptinSettingsPanelItem6.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(borderColor1, borderColor2), "Additional HTML Form Input Elements", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12)));
        OptinSettingsPanelItem6.setMaximumSize(new java.awt.Dimension(32767, 150));
        OptinSettingsPanelItem6.setMinimumSize(new java.awt.Dimension(232, 100));
        OptinSettingsPanelItem6.setPreferredSize(new java.awt.Dimension(448, 100));
        OptinHTMLFormInputElementsPanelItem3.setBackground(backgroundColor);
        OptinHTMLFormInputElementsPanelItem3.setMaximumSize(new java.awt.Dimension(32767, 120));
        OptinTitlePanel7.setBackground(backgroundColor);
        OptinTitlePanel7.setMaximumSize(new java.awt.Dimension(400, 150));
        OptinTitlePanel7.setMinimumSize(new java.awt.Dimension(210, 80));
        OptinTitlePanel7.setPreferredSize(new java.awt.Dimension(310, 120));
        jScrollPane1.setBackground(backgroundColor);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setMinimumSize(new java.awt.Dimension(200, 100));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(300, 100));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        OptinTitlePanel7.add(jScrollPane1);

        OptinHTMLFormInputElementsPanelItem3.add(OptinTitlePanel7);

        OptinSettingsPanelItem6.add(OptinHTMLFormInputElementsPanelItem3);

        OptinHTMLFormInputElementsPanelItem4.setBackground(backgroundColor);
        OptinHTMLFormInputElementsPanelItem4.setMaximumSize(new java.awt.Dimension(32767, 33));
        OptinHTMLFormInputElementsEMailContentPanel1.setBackground(backgroundColor);
        OptinHTMLFormInputElementsEMailContentPanel1.setMaximumSize(new java.awt.Dimension(100, 2147483647));
        jButton1.setText("Add Input Element");
        OptinHTMLFormInputElementsEMailContentPanel1.add(jButton1);

        jButton2.setText("Remove Input Element");
        OptinHTMLFormInputElementsEMailContentPanel1.add(jButton2);

        OptinHTMLFormInputElementsPanelItem4.add(OptinHTMLFormInputElementsEMailContentPanel1);

        OptinHTMLFormInputElementsEMailRightFillerPanel1.setLayout(new javax.swing.BoxLayout(OptinHTMLFormInputElementsEMailRightFillerPanel1, javax.swing.BoxLayout.Y_AXIS));

        OptinHTMLFormInputElementsEMailRightFillerPanel1.setBackground(backgroundColor);
        OptinHTMLFormInputElementsPanelItem4.add(OptinHTMLFormInputElementsEMailRightFillerPanel1);

        OptinSettingsPanelItem6.add(OptinHTMLFormInputElementsPanelItem4);

        tabHTMLFormInputs.add(OptinSettingsPanelItem6, java.awt.BorderLayout.CENTER);

add(theEAProperties, java.awt.BorderLayout.CENTER);

        //add(tabHTMLFormInputs, java.awt.BorderLayout.CENTER);

    }//GEN-END:initComponents
 
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel OptinHTMLFormInputElementsEMailContentPanel;
    private javax.swing.JPanel OptinHTMLFormInputElementsEMailContentPanel1;
    private javax.swing.JPanel OptinHTMLFormInputElementsEMailRightFillerPanel;
    private javax.swing.JPanel OptinHTMLFormInputElementsEMailRightFillerPanel1;
    private javax.swing.JPanel OptinHTMLFormInputElementsPanel;
    private javax.swing.JPanel OptinHTMLFormInputElementsPanelItem1;
    private javax.swing.JPanel OptinHTMLFormInputElementsPanelItem2;
    private javax.swing.JPanel OptinHTMLFormInputElementsPanelItem3;
    private javax.swing.JPanel OptinHTMLFormInputElementsPanelItem4;
    private javax.swing.JPanel OptinSettingsPanelItem5;
    private javax.swing.JPanel OptinSettingsPanelItem6;
    private javax.swing.JPanel OptinTitlePanel6;
    private javax.swing.JPanel OptinTitlePanel7;
    private javax.swing.JPanel OptinTitleRightPanel6;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lEMailOptinHTMLFormInputEMailAddress;
    private javax.swing.JLabel lEMailOptinHTMLFormInputPersonName;
    private javax.swing.JTextArea taUIStringsOptinDescription1;
    private javax.swing.JPanel tabHTMLFormInputs;
    private javax.swing.JTextField tfEMailOptinHTMLFormInputEMailAddress;
    private javax.swing.JTextField tfEMailOptinHTMLFormInputPersonName;
    private EAPropertiesPanel theEAProperties;
    // End of variables declaration//GEN-END:variables
    
}
