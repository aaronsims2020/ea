/*
 * AutoUpdateFileListPanel.java
 *
 * Created on December 31, 2003, 6:21 PM
 */

package com.trinity.ea.design.autoupdate.config;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.common.panel.EAMasterControlPanel;
import com.trinity.ea.design.common.panel.EAPropertiesPanel;
import com.trinity.ea.design.common.panel.EAListItem;
import com.trinity.ea.design.common.panel.EAListItemContent;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.autoupdate.config.MaxURLsAllowed;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class AutoUpdateFileListPanel extends EAMasterControlPanel {
    private Color backgroundColor = new java.awt.Color(140, 160, 210);
    private Color borderColor1 = new java.awt.Color(140, 160, 210);
    private Color borderColor2 = new java.awt.Color(140, 160, 210);
    private Color rowColor = new java.awt.Color(220, 225, 240);
    private Color rowBorderColor = new java.awt.Color(255, 255, 255);
    private Color tabColor = new java.awt.Color(255, 255, 255);
    private Color tabBorderColor = new java.awt.Color(0, 0, 0);
    private Icon theActionRowIcon = new javax.swing.ImageIcon(getClass().getResource("/images/lgpl/stock_insert_url-16.png"));
    private int rowHeight = 25;
    private int defActionLabelWidth = 115;
    private int defActionDataWidth = 450;

    /** Creates new form PaymentOptionsPanel */
    public AutoUpdateFileListPanel() {
        initComponents();
	  setProjectData();
	  //theEAPropFileList.setSelectedIndex(0);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        AutoUpdateContentPanel = new javax.swing.JPanel();
        DynamicHTMLFormInputSettingsPanel1 = new javax.swing.JPanel();
        OptinHTMLFormInputElementsPanelItem18 = new javax.swing.JPanel();
        OptinHTMLFormInputElementsEMailContentPanel13 = new javax.swing.JPanel();
        taOptionsDescription = new javax.swing.JTextArea();
        OptinHTMLFormInputElementsEMailRightFillerPanel13 = new javax.swing.JPanel();
        OptinHTMLFormInputElementsPanelItem14 = new javax.swing.JPanel();
        PaymentMethodsAndMoreGroupPanel = new javax.swing.JPanel();
        PaymentMethodsAndMoreContentPanel = new javax.swing.JPanel();
        PaymentMethodsGroupPanel = new javax.swing.JPanel();
        OptinHTMLFormInputElementsPanelItem15 = new javax.swing.JPanel();
        OptinTitlePanel12 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        OptinHTMLFormInputElementsPanelItem16 = new javax.swing.JPanel();
        OptinHTMLFormInputElementsEMailContentPanel6 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        OptinHTMLFormInputElementsEMailRightFillerPanel6 = new javax.swing.JPanel();
        PaymentTotalVerificationCodeEnabledPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        cbAllowURLChanges = new javax.swing.JCheckBox();
        jPanel19 = new javax.swing.JPanel();
        OptinHTMLFormInputElementsPanelItem20 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        OptinHTMLFormInputElementsPanelItem21 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        allowActionExecutionInSoftwareUpdatesEnabled = new javax.swing.JCheckBox();
        allowServerNotificationOfUpdateStatusEnabled = new javax.swing.JCheckBox();
        allowSoftwareUpdateExpirationProcessingEnabled = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
	  MiddleFillerPanel = new JPanel();
	  MiddleFillerSpacePanel = new JPanel();
        OptinHTMLFormInputElementsPanelItem22 = new javax.swing.JPanel();

	  try
	  {
		maxURLsAllowedPanel = new MaxURLsAllowed();
	  }
	  catch(Exception e)
	  {
		e.printStackTrace();
	  }
        setLayout(new java.awt.BorderLayout());

        setBackground(new java.awt.Color(140, 160, 210));
        setMinimumSize(new java.awt.Dimension(570, 343));
        setPreferredSize(new java.awt.Dimension(570, 343));
	  allowURLChangesPanel = new AllowURLChangesControl();
//
theEAPropFileList = new EAPropertiesPanel(getFilesEAListItems(),rowColor, rowBorderColor, backgroundColor, rowHeight);
//
theEAPropFileList.setMasterControlPanel(this);
//	  
	try
	{
	  //theEAPropFileList.setTabColor(tabColor);
	  //theEAPropFileList.setTabBorderColor(tabBorderColor);
	  theEAPropFileList.setDescriptorPanelWidth(246);
	  allowURLChangesPanel.setBackgroundColor(backgroundColor);
	  //allowURLChangesPanel.setText("Allow URL changes via updates");
	  //theEAPropFileList.setHeaderText("Software Update File Download URLs");
	  theEAPropFileList.setDescriptorText("");
	  //theEAPropFileList.setHeaderTextAndWidth("", 220, "", 0, "", 0);
	  theEAPropFileList.setAddButtonVisible(true);
	  theEAPropFileList.setEditButtonVisible(true);
	  theEAPropFileList.setRemoveButtonVisible(true);
	  theEAPropFileList.setAddButtonText("Add File");
	  theEAPropFileList.setEditButtonText("Edit File");
	  theEAPropFileList.setRemoveButtonText("Remove File");
	  theEAPropFileList.setPreviewButtonVisible(false);
	  theEAPropFileList.setConfigurationWizardButtonVisible(false);
	  theEAPropFileList.setSelectedIndex(0);
	  theEAPropFileList.setDescriptorPanel(allowURLChangesPanel);
	  theEAPropFileList.setDefaultLabelText("");
	  theEAPropFileList.setLabelWidth(defActionLabelWidth);
	  theEAPropFileList.setDataWidth(defActionDataWidth);
	  theEAPropFileList.setDefaultRowIcon(theActionRowIcon);
        maxURLsAllowedPanel.setMinimumSize(new java.awt.Dimension(237, 20));
        maxURLsAllowedPanel.setPreferredSize(new java.awt.Dimension(237, 30));
        maxURLsAllowedPanel.setMaximumSize(new java.awt.Dimension(237, 30));
	  theEAPropFileList.setInsertHeaderPanel(maxURLsAllowedPanel);
	  theEAPropFileList.setBackgroundColor(backgroundColor);
	  theEAPropFileList.setTabBorderColor(tabBorderColor);
	  theEAPropFileList.setTabColor(tabColor);
	  theEAPropFileList.setParentComponent(this);
	  theEAPropFileList.setUITextWithStartIndex("Alternate URL ", 0, 1);
	try
	{
	  theEAPropFileList.setMaxEAListItems(Integer.valueOf(ProjectManager.get("autoUpdateMaxBaseURLs")).intValue());
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	  EAListItem eaListItemObj = theEAPropFileList.getSelectedEAListItem();
	  eaListItemObj.setSelectedMode();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
        AutoUpdateContentPanel.setLayout(new java.awt.BorderLayout());

        AutoUpdateContentPanel.setBackground(new java.awt.Color(140, 160, 210));
        AutoUpdateContentPanel.setPreferredSize(new java.awt.Dimension(448, 1000));
        DynamicHTMLFormInputSettingsPanel1.setLayout(new java.awt.BorderLayout());

        DynamicHTMLFormInputSettingsPanel1.setBackground(new java.awt.Color(140, 160, 210));
        DynamicHTMLFormInputSettingsPanel1.setMaximumSize(new java.awt.Dimension(0, 300));
        DynamicHTMLFormInputSettingsPanel1.setMinimumSize(new java.awt.Dimension(0, 600));
        DynamicHTMLFormInputSettingsPanel1.setPreferredSize(new java.awt.Dimension(0, 775));
        OptinHTMLFormInputElementsPanelItem18.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        OptinHTMLFormInputElementsPanelItem18.setBackground(new java.awt.Color(140, 160, 210));
        OptinHTMLFormInputElementsPanelItem18.setMaximumSize(new java.awt.Dimension(32767, 33));
        OptinHTMLFormInputElementsEMailContentPanel13.setLayout(new java.awt.BorderLayout());

        OptinHTMLFormInputElementsEMailContentPanel13.setBackground(new java.awt.Color(140, 160, 210));
        OptinHTMLFormInputElementsEMailContentPanel13.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        OptinHTMLFormInputElementsEMailContentPanel13.setPreferredSize(new java.awt.Dimension(550, 140));
        taOptionsDescription.setBackground(new java.awt.Color(140, 160, 210));
        taOptionsDescription.setFont(new java.awt.Font("Arial", 0, 12));
        taOptionsDescription.setLineWrap(true);
        taOptionsDescription.setText("The Automatic Software Update settings are defined below.");
        taOptionsDescription.setWrapStyleWord(true);
        OptinHTMLFormInputElementsEMailContentPanel13.add(theEAPropFileList, java.awt.BorderLayout.CENTER);

        OptinHTMLFormInputElementsPanelItem18.add(OptinHTMLFormInputElementsEMailContentPanel13);

        OptinHTMLFormInputElementsEMailRightFillerPanel13.setLayout(new javax.swing.BoxLayout(OptinHTMLFormInputElementsEMailRightFillerPanel13, javax.swing.BoxLayout.Y_AXIS));

        OptinHTMLFormInputElementsEMailRightFillerPanel13.setBackground(new java.awt.Color(140, 160, 210));
        OptinHTMLFormInputElementsPanelItem18.add(OptinHTMLFormInputElementsEMailRightFillerPanel13);
	  theEAPropFileList.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        theEAPropFileList.setPreferredSize(new java.awt.Dimension(550, 210));
        DynamicHTMLFormInputSettingsPanel1.add(theEAPropFileList, java.awt.BorderLayout.NORTH);

        OptinHTMLFormInputElementsPanelItem14.setLayout(new java.awt.BorderLayout(10, 10));

        OptinHTMLFormInputElementsPanelItem14.setBackground(new java.awt.Color(140, 160, 210));
        OptinHTMLFormInputElementsPanelItem14.setMaximumSize(new java.awt.Dimension(32767, 210));
        OptinHTMLFormInputElementsPanelItem14.setMinimumSize(new java.awt.Dimension(242, 210));
        OptinHTMLFormInputElementsPanelItem14.setPreferredSize(new java.awt.Dimension(497, 210));
        PaymentMethodsAndMoreGroupPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        PaymentMethodsAndMoreGroupPanel.setBackground(new java.awt.Color(140, 160, 210));
        PaymentMethodsAndMoreGroupPanel.setMaximumSize(new java.awt.Dimension(32767, 210));
        PaymentMethodsAndMoreGroupPanel.setMinimumSize(new java.awt.Dimension(242, 210));
        PaymentMethodsAndMoreGroupPanel.setPreferredSize(new java.awt.Dimension(458, 210));
        PaymentMethodsAndMoreContentPanel.setLayout(new javax.swing.BoxLayout(PaymentMethodsAndMoreContentPanel, javax.swing.BoxLayout.X_AXIS));

        PaymentMethodsAndMoreContentPanel.setBackground(new java.awt.Color(140, 160, 210));
        PaymentMethodsAndMoreContentPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Software Update File Download URLs", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12)));
        PaymentMethodsAndMoreContentPanel.setMaximumSize(new java.awt.Dimension(32767, 200));
        PaymentMethodsAndMoreContentPanel.setMinimumSize(new java.awt.Dimension(232, 200));
        PaymentMethodsAndMoreContentPanel.setPreferredSize(new java.awt.Dimension(560, 200));
        PaymentMethodsGroupPanel.setLayout(new javax.swing.BoxLayout(PaymentMethodsGroupPanel, javax.swing.BoxLayout.Y_AXIS));

        PaymentMethodsGroupPanel.setBackground(new java.awt.Color(140, 160, 210));
        PaymentMethodsGroupPanel.setMaximumSize(new java.awt.Dimension(32767, 216));
        PaymentMethodsGroupPanel.setMinimumSize(new java.awt.Dimension(332, 186));
        PaymentMethodsGroupPanel.setPreferredSize(new java.awt.Dimension(332, 226));
        OptinHTMLFormInputElementsPanelItem15.setBackground(new java.awt.Color(140, 160, 210));
        OptinHTMLFormInputElementsPanelItem15.setMaximumSize(new java.awt.Dimension(32767, 220));
        OptinTitlePanel12.setBackground(new java.awt.Color(140, 160, 210));
        OptinTitlePanel12.setMaximumSize(new java.awt.Dimension(400, 150));
        OptinTitlePanel12.setMinimumSize(new java.awt.Dimension(210, 80));
        OptinTitlePanel12.setPreferredSize(new java.awt.Dimension(310, 120));
        jScrollPane4.setBackground(new java.awt.Color(140, 160, 210));
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane4.setMinimumSize(new java.awt.Dimension(200, 80));
        jScrollPane4.setPreferredSize(new java.awt.Dimension(300, 80));
        jList1.setFont(new java.awt.Font("Arial", 1, 12));
        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "http://yourdomain.com/update.eal", "ftp://mydomain.com/updates/" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setMaximumSize(new java.awt.Dimension(102, 60));
        jList1.setMinimumSize(new java.awt.Dimension(102, 60));
        jList1.setPreferredSize(new java.awt.Dimension(102, 60));
        jScrollPane4.setViewportView(jList1);

        OptinTitlePanel12.add(jScrollPane4);

        OptinHTMLFormInputElementsPanelItem15.add(OptinTitlePanel12);

       // PaymentMethodsGroupPanel.add(OptinHTMLFormInputElementsPanelItem15);
//PaymentMethodsGroupPanel.add(theEAPropFileList);


        OptinHTMLFormInputElementsPanelItem16.setBackground(new java.awt.Color(140, 160, 210));
        OptinHTMLFormInputElementsPanelItem16.setMaximumSize(new java.awt.Dimension(32767, 46));
        OptinHTMLFormInputElementsEMailContentPanel6.setBackground(new java.awt.Color(140, 160, 210));
        OptinHTMLFormInputElementsEMailContentPanel6.setMaximumSize(new java.awt.Dimension(100, 2147483647));
        jButton7.setText("Add URL");
        OptinHTMLFormInputElementsEMailContentPanel6.add(jButton7);

        jButton8.setText("Remove URL");
        OptinHTMLFormInputElementsEMailContentPanel6.add(jButton8);

        OptinHTMLFormInputElementsPanelItem16.add(OptinHTMLFormInputElementsEMailContentPanel6);

        OptinHTMLFormInputElementsEMailRightFillerPanel6.setLayout(new javax.swing.BoxLayout(OptinHTMLFormInputElementsEMailRightFillerPanel6, javax.swing.BoxLayout.Y_AXIS));

        OptinHTMLFormInputElementsEMailRightFillerPanel6.setBackground(new java.awt.Color(140, 160, 210));
        OptinHTMLFormInputElementsPanelItem16.add(OptinHTMLFormInputElementsEMailRightFillerPanel6);

        //PaymentMethodsGroupPanel.add(OptinHTMLFormInputElementsPanelItem16);

        PaymentMethodsAndMoreContentPanel.add(PaymentMethodsGroupPanel);

        PaymentTotalVerificationCodeEnabledPanel.setLayout(new java.awt.BorderLayout());

        PaymentTotalVerificationCodeEnabledPanel.setBackground(new java.awt.Color(140, 160, 210));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        jPanel3.setBackground(new java.awt.Color(140, 160, 210));
        jPanel3.setMinimumSize(new java.awt.Dimension(180, 35));
        jPanel3.setPreferredSize(new java.awt.Dimension(180, 35));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(140, 160, 210));
        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jPanel11.setBackground(new java.awt.Color(140, 160, 210));
        jPanel11.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        jPanel6.add(jPanel11, java.awt.BorderLayout.NORTH);

        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel9.setBackground(new java.awt.Color(140, 160, 210));
        jPanel9.setMaximumSize(new java.awt.Dimension(2147483647, 40));
        jPanel9.setMinimumSize(new java.awt.Dimension(10, 40));
        jPanel9.setPreferredSize(new java.awt.Dimension(10, 40));
        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.Y_AXIS));

        jPanel12.setBackground(new java.awt.Color(140, 160, 210));
        jPanel12.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setBackground(new java.awt.Color(140, 160, 210));
        jPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 100));
        jPanel13.setLayout(new java.awt.BorderLayout());

        jPanel13.setBackground(new java.awt.Color(140, 160, 210));
        jPanel13.setMaximumSize(new java.awt.Dimension(2147483647, 40));
        jTextArea1.setBackground(new java.awt.Color(140, 160, 210));
        jTextArea1.setLineWrap(true);
        jTextArea1.setText("The maximum number of URLs to attempt downloading the software update file:");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setMaximumSize(new java.awt.Dimension(2147483647, 50));
        jTextArea1.setMinimumSize(new java.awt.Dimension(100, 50));
        jTextArea1.setPreferredSize(new java.awt.Dimension(100, 50));
        jPanel13.add(jTextArea1, java.awt.BorderLayout.NORTH);

        jPanel1.add(jPanel13);

        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jPanel14.setBackground(new java.awt.Color(140, 160, 210));
        jPanel14.setMaximumSize(new java.awt.Dimension(2147483647, 30));

        jPanel1.add(jPanel14);

        jPanel15.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jPanel15.setBackground(new java.awt.Color(140, 160, 210));
        jPanel15.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        cbAllowURLChanges.setBackground(new java.awt.Color(140, 160, 210));
        cbAllowURLChanges.setSelected(true);
        cbAllowURLChanges.setText("Allow URL changes via updates");
        cbAllowURLChanges.setMaximumSize(new java.awt.Dimension(202, 26));
        cbAllowURLChanges.setMinimumSize(new java.awt.Dimension(202, 26));
        cbAllowURLChanges.setPreferredSize(new java.awt.Dimension(202, 26));
        jPanel15.add(cbAllowURLChanges);

        jPanel1.add(jPanel15);

        jPanel12.add(jPanel1);

        jPanel9.add(jPanel12, java.awt.BorderLayout.CENTER);

        //jPanel6.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel6);

        PaymentTotalVerificationCodeEnabledPanel.add(jPanel3, java.awt.BorderLayout.CENTER);

        PaymentMethodsAndMoreContentPanel.add(PaymentTotalVerificationCodeEnabledPanel);

        PaymentMethodsAndMoreGroupPanel.add(PaymentMethodsAndMoreContentPanel);

        //OptinHTMLFormInputElementsPanelItem14.add(PaymentMethodsAndMoreGroupPanel, java.awt.BorderLayout.NORTH);

        jPanel19.setLayout(new java.awt.BorderLayout());

        jPanel19.setBackground(new java.awt.Color(140, 160, 210));
        jPanel19.setMaximumSize(new java.awt.Dimension(32767, 25));
        jPanel19.setMinimumSize(new java.awt.Dimension(275, 25));
        jPanel19.setPreferredSize(new java.awt.Dimension(560, 25));
        OptinHTMLFormInputElementsPanelItem20.setLayout(new javax.swing.BoxLayout(OptinHTMLFormInputElementsPanelItem20, javax.swing.BoxLayout.X_AXIS));

        OptinHTMLFormInputElementsPanelItem20.setBackground(new java.awt.Color(140, 160, 210));
        OptinHTMLFormInputElementsPanelItem20.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Automatic Software Update Options", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12)));
        OptinHTMLFormInputElementsPanelItem20.setMaximumSize(new java.awt.Dimension(32767, 100));
        OptinHTMLFormInputElementsPanelItem20.setMinimumSize(new java.awt.Dimension(260, 100));
        OptinHTMLFormInputElementsPanelItem20.setPreferredSize(new java.awt.Dimension(1000, 100));
        jPanel5.setBackground(new java.awt.Color(140, 160, 210));
        jPanel5.setMaximumSize(new java.awt.Dimension(10, 10));
        OptinHTMLFormInputElementsPanelItem20.add(jPanel5);

        OptinHTMLFormInputElementsPanelItem21.setLayout(new java.awt.BorderLayout());

        OptinHTMLFormInputElementsPanelItem21.setBackground(new java.awt.Color(140, 160, 210));
        OptinHTMLFormInputElementsPanelItem21.setMaximumSize(new java.awt.Dimension(2147483647, 350));
        OptinHTMLFormInputElementsPanelItem21.setMinimumSize(new java.awt.Dimension(200, 0));
        OptinHTMLFormInputElementsPanelItem21.setPreferredSize(new java.awt.Dimension(500, 75));
        jPanel7.setBackground(new java.awt.Color(140, 160, 210));
        jPanel7.setMaximumSize(new java.awt.Dimension(10, 1));
        jPanel7.setMinimumSize(new java.awt.Dimension(10, 1));
        OptinHTMLFormInputElementsPanelItem21.add(jPanel7, java.awt.BorderLayout.EAST);

        jPanel18.setLayout(new java.awt.BorderLayout());

        jPanel18.setBackground(new java.awt.Color(140, 160, 210));
        jPanel18.setPreferredSize(new java.awt.Dimension(500, 75));
        allowActionExecutionInSoftwareUpdatesEnabled.setBackground(new java.awt.Color(140, 160, 210));
        allowActionExecutionInSoftwareUpdatesEnabled.setFont(new java.awt.Font("Dialog", 0, 12));
        allowActionExecutionInSoftwareUpdatesEnabled.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        allowActionExecutionInSoftwareUpdatesEnabled.setLabel("Allow action execution in software updates");
        allowActionExecutionInSoftwareUpdatesEnabled.setMaximumSize(new java.awt.Dimension(500, 25));
        allowActionExecutionInSoftwareUpdatesEnabled.setMinimumSize(new java.awt.Dimension(350, 25));
        allowActionExecutionInSoftwareUpdatesEnabled.setPreferredSize(new java.awt.Dimension(500, 25));
        jPanel18.add(allowActionExecutionInSoftwareUpdatesEnabled, java.awt.BorderLayout.CENTER);

        allowServerNotificationOfUpdateStatusEnabled.setBackground(new java.awt.Color(140, 160, 210));
        allowServerNotificationOfUpdateStatusEnabled.setFont(new java.awt.Font("Dialog", 0, 12));
        allowServerNotificationOfUpdateStatusEnabled.setLabel("Allow server notification of update status");
        allowServerNotificationOfUpdateStatusEnabled.setMaximumSize(new java.awt.Dimension(350, 25));
        allowServerNotificationOfUpdateStatusEnabled.setMinimumSize(new java.awt.Dimension(350, 25));
        allowServerNotificationOfUpdateStatusEnabled.setPreferredSize(new java.awt.Dimension(350, 25));
        jPanel18.add(allowServerNotificationOfUpdateStatusEnabled, java.awt.BorderLayout.NORTH);

        allowSoftwareUpdateExpirationProcessingEnabled.setBackground(new java.awt.Color(140, 160, 210));
        allowSoftwareUpdateExpirationProcessingEnabled.setFont(new java.awt.Font("Dialog", 0, 12));
        allowSoftwareUpdateExpirationProcessingEnabled.setLabel("Allow software update expiration processing");
        allowSoftwareUpdateExpirationProcessingEnabled.setMaximumSize(new java.awt.Dimension(500, 25));
        allowSoftwareUpdateExpirationProcessingEnabled.setMinimumSize(new java.awt.Dimension(350, 25));
        allowSoftwareUpdateExpirationProcessingEnabled.setPreferredSize(new java.awt.Dimension(500, 25));
        jPanel18.add(allowSoftwareUpdateExpirationProcessingEnabled, java.awt.BorderLayout.SOUTH);

        OptinHTMLFormInputElementsPanelItem21.add(jPanel18, java.awt.BorderLayout.SOUTH);

        jPanel2.setBackground(new java.awt.Color(140, 160, 210));
        jPanel2.setMaximumSize(new java.awt.Dimension(10, 10));
        OptinHTMLFormInputElementsPanelItem21.add(jPanel2, java.awt.BorderLayout.EAST);

        OptinHTMLFormInputElementsPanelItem20.add(OptinHTMLFormInputElementsPanelItem21);

        jPanel4.setBackground(new java.awt.Color(140, 160, 210));
        jPanel4.setMaximumSize(new java.awt.Dimension(10, 10));
        OptinHTMLFormInputElementsPanelItem20.add(jPanel4);
////////////////
	  MiddleFillerPanel.setLayout(new javax.swing.BoxLayout(MiddleFillerPanel, javax.swing.BoxLayout.Y_AXIS));
	  MiddleFillerSpacePanel.setBackground(new java.awt.Color(140, 160, 210));
	  MiddleFillerPanel.setBackground(new java.awt.Color(140, 160, 210));
	  MiddleFillerSpacePanel.setMaximumSize(new java.awt.Dimension(32767, 15));
        MiddleFillerSpacePanel.setMinimumSize(new java.awt.Dimension(0, 15));
        MiddleFillerSpacePanel.setPreferredSize(new java.awt.Dimension(1000, 15));

	  MiddleFillerPanel.add(MiddleFillerSpacePanel);
	  MiddleFillerPanel.add(OptinHTMLFormInputElementsPanelItem20);
        jPanel19.add(MiddleFillerPanel, java.awt.BorderLayout.NORTH);
//////////////////////////
        OptinHTMLFormInputElementsPanelItem22.setLayout(new java.awt.BorderLayout());

        OptinHTMLFormInputElementsPanelItem22.setBackground(new java.awt.Color(140, 160, 210));
        OptinHTMLFormInputElementsPanelItem22.setMaximumSize(new java.awt.Dimension(560, 210));
        OptinHTMLFormInputElementsPanelItem22.setMinimumSize(new java.awt.Dimension(260, 210));
        OptinHTMLFormInputElementsPanelItem22.setPreferredSize(new java.awt.Dimension(560, 210));
      
        jPanel19.add(OptinHTMLFormInputElementsPanelItem22, java.awt.BorderLayout.CENTER);

        OptinHTMLFormInputElementsPanelItem14.add(jPanel19, java.awt.BorderLayout.CENTER);
        DynamicHTMLFormInputSettingsPanel1.add(OptinHTMLFormInputElementsPanelItem14, java.awt.BorderLayout.CENTER);

        AutoUpdateContentPanel.add(DynamicHTMLFormInputSettingsPanel1, java.awt.BorderLayout.CENTER);

        add(AutoUpdateContentPanel, java.awt.BorderLayout.CENTER);

    }//GEN-END:initComponents

public EAListItem[] getEAListItemURLArray()
{
	return getFilesEAListItems();
}

private EAListItem[] getFilesEAListItems()
{
	  EAListItem[] ActionsEAListItemArray = new EAListItem[4];
        try
        {
		ArrayList strArrayList1 = new ArrayList();
		ArrayList eaListItemArrayList1 = new ArrayList();		
            EAListItem eai = new EAListItem(theActionRowIcon,rowColor);
		EAListItemContent autoUpdateBaseURL = new EAListItemContent(rowColor, defActionLabelWidth, defActionDataWidth);
		autoUpdateBaseURL.setLabelText("Application Root Folder");
		if(ProjectManager.get("autoUpdateBaseURL")!=null)
		{
			autoUpdateBaseURL.setInputText("");
			//strArrayList1.add("autoUpdateBaseURL");
		}
            eai.setRowDataPanel(autoUpdateBaseURL);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai.setListItemIsRemovable(false);
		eai.setValueBoxEnabled(false);
		eaListItemArrayList1.add(eai);
//
		try
		{
		Object[] cpArray = getStringArray(ProjectManager.get("autoUpdateCP"));
		int maxURLs = cpArray.length;
		for(int i = 1;i<maxURLs;i++)
		{
			if(cpArray[i]!=null)
			{
            		EAListItem eai2 = new EAListItem(theActionRowIcon,rowColor);
				EAListItemContent autoUpdateAlternateURL1 = new EAListItemContent(rowColor, defActionLabelWidth, defActionDataWidth);
				autoUpdateAlternateURL1.setLabelText(((String)cpArray[i]));
				autoUpdateAlternateURL1.setInputText("");

            		eai2.setRowDataPanel(autoUpdateAlternateURL1);
				// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
				eai2.setListItemIsRemovable(true);
				eai2.setValueBoxEnabled(false);
				eaListItemArrayList1.add(eai2);
			}	
			else
			{
				i=maxURLs;
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		eaListItemArrayList1.trimToSize();
		Object[] theEAListItemObjArray = eaListItemArrayList1.toArray();
		ActionsEAListItemArray = new EAListItem[theEAListItemObjArray.length];
		for(int i = 0;i<theEAListItemObjArray.length;i++)
		{
			ActionsEAListItemArray[i] = (EAListItem)theEAListItemObjArray[i];
		}

		return ActionsEAListItemArray;
        }
        catch(Exception e)
        {
          e.printStackTrace();   
        }
	EAListItem[] tempLIArray2 = new EAListItem[0];
	return tempLIArray2;
}
    

    private Object[] getStringArray(String theString)
    {
        ArrayList al = new ArrayList();
        String parseString = theString;
        if(parseString.indexOf(",") !=-1)
        {
            while(parseString.indexOf(",") !=-1)
            {
                al.add(parseString.substring(0,parseString.indexOf(",")));
                parseString = parseString.substring(parseString.indexOf(",") + 1);
            }
            al.add(parseString);
            al.trimToSize();
            //Parse key/pair values
            return al.toArray();
        }  
        al.add(parseString);
        al.trimToSize();
        //Parse key/pair values
        return al.toArray();        
    }

 /*
    public void addListItem(EAListItem theEAListItemToAdd)
    {
	try
	{
		String[] strTempActionsArray = new String[strActionsArray.length + 1];
		EAListItem[] TempActionsEAListItemArray = new EAListItem[ActionsEAListItemArray.length + 1];
		strTempActionsArray[0]="autoUpdateBaseURL";
		TempActionsEAListItemArray[0]=ActionsEAListItemArray[0];
		for(int i = 1;i<ActionsEAListItemArray.length;i++)
		{
			strTempActionsArray[i]=strActionsArray[i];
			TempActionsEAListItemArray[i]=ActionsEAListItemArray[i];
		}
		strTempActionsArray[ActionsEAListItemArray.length]="autoUpdateAlternateURL" + String.valueOf(ActionsEAListItemArray.length - 1);
		TempActionsEAListItemArray[ActionsEAListItemArray.length]=theEAListItemToAdd;
		strActionsArray = strTempActionsArray;
		ActionsEAListItemArray = TempActionsEAListItemArray;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    } 
*/
/*
    public void removeListItem(int index)
    {
       try
       {

                int j = 0;
		    String[] strTempActionsArray = new String[strActionsArray.length - 1];
		    EAListItem[] TempActionsEAListItemArray = new EAListItem[ActionsEAListItemArray.length - 1];
                for(int i = 0;i<strActionsArray.length;i++)
                {
                    try
                    {
                        if(i != index)
                        {
					strTempActionsArray[j] = strActionsArray[i];
					TempActionsEAListItemArray[j] = ActionsEAListItemArray[i];
					j++;
				}
				if(i == index)

				{
					ProjectManager.remove(strActionsArray[i]);
					ProjectManager.saveTempNow();
				}
			  }
			  catch(Exception e)
			  {
				  e.printStackTrace();
			  }
		    }
		    strActionsArray = strTempActionsArray;
		    ActionsEAListItemArray = TempActionsEAListItemArray;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    } 
*/
    public void setSelectedListItemEvent(int theLastSelectedIndex)
    {
		/*EAListItem eaListItemObj = theEAPropFileList.getSelectedEAListItem();
		EAListItemContent theContent = eaListItemObj.getRowDataPanel();
		if(theLastSelectedIndex!=-1)
		{
			try
			{
				theEAPropFileList.getSelectedEAListItem().getRowDataPanel().setInputText(ProjectManager.get(strActionsArray[theLastSelectedIndex]));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}*/
    }

    public synchronized void setProjectData()
    {
        try
        {
		// Automatic Update Support Functionality Checkbox Enabled/Disabled   
            if(ProjectManager.get("autoUpdateAllowExecuteActions").equalsIgnoreCase("true")==true)
            {
                allowActionExecutionInSoftwareUpdatesEnabled.setSelected(true);              
            }
            else
            {
                allowActionExecutionInSoftwareUpdatesEnabled.setSelected(false);               
            }
            if(ProjectManager.get("autoUpdateAllowNotifyServerOnUpdateSuccess").equalsIgnoreCase("true")==true)
            {
                allowServerNotificationOfUpdateStatusEnabled.setSelected(true);              
            }
            else
            {
                allowServerNotificationOfUpdateStatusEnabled.setSelected(false);               
            }
            if(ProjectManager.get("autoUpdateExpirationEnabled").equalsIgnoreCase("true")==true)
            {
                allowSoftwareUpdateExpirationProcessingEnabled.setSelected(true);              
            }
            else
            {
                allowSoftwareUpdateExpirationProcessingEnabled.setSelected(false);               
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
		EAListItem[] theItems = theEAPropFileList.getEAListItems();
		maxURLsAllowedPanel.getDataUpdate();
		if(theItems!=null)
		{
			if(0<theItems.length)
			{
				for(int i = 0;i<theItems.length;i++)
				{
						String[] theStrArray = theItems[i].getDataArray();
						if(1<theStrArray.length)
						{
							if(i==0)
							{
								ProjectManager.putTempNoFileWrite("autoUpdateBaseURL", theItems[0].getInputText());
							}
							else
							{
								ProjectManager.putTempNoFileWrite("autoUpdateAlternateURL" + String.valueOf(i), theStrArray[0]);
							}
						}
				}
			}
		}
		// Automatic Updates Support Functionality Checkbox Enabled/Disabled
            if(allowActionExecutionInSoftwareUpdatesEnabled.isSelected()==true)
            {
		    ProjectManager.putTempNoFileWrite("autoUpdateAllowExecuteActions", "true");
            }
            else
            {
		    ProjectManager.putTempNoFileWrite("autoUpdateAllowExecuteActions", "false");
            }
            if(allowServerNotificationOfUpdateStatusEnabled.isSelected()==true)
            {
		    ProjectManager.putTempNoFileWrite("autoUpdateAllowNotifyServerOnUpdateSuccess", "true");
            }
            else
            {
		    ProjectManager.putTempNoFileWrite("autoUpdateAllowNotifyServerOnUpdateSuccess", "false");
            }
            if(allowSoftwareUpdateExpirationProcessingEnabled.isSelected()==true)
            {
		    ProjectManager.putTempNoFileWrite("autoUpdateExpirationEnabled", "true");
            }
            else
            {
		    ProjectManager.putTempNoFileWrite("autoUpdateExpirationEnabled", "false");
            }

		ProjectManager.saveTempNow();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
  }       
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AutoUpdateContentPanel;
    private javax.swing.JPanel DynamicHTMLFormInputSettingsPanel1;
    private javax.swing.JPanel OptinHTMLFormInputElementsEMailContentPanel13;
    private javax.swing.JPanel OptinHTMLFormInputElementsEMailContentPanel6;
    private javax.swing.JPanel OptinHTMLFormInputElementsEMailRightFillerPanel13;
    private javax.swing.JPanel OptinHTMLFormInputElementsEMailRightFillerPanel6;
    private javax.swing.JPanel OptinHTMLFormInputElementsPanelItem14;
    private javax.swing.JPanel OptinHTMLFormInputElementsPanelItem15;
    private javax.swing.JPanel OptinHTMLFormInputElementsPanelItem16;
    private javax.swing.JPanel OptinHTMLFormInputElementsPanelItem18;
    private javax.swing.JPanel OptinHTMLFormInputElementsPanelItem20;
    private javax.swing.JPanel OptinHTMLFormInputElementsPanelItem21;
    private javax.swing.JPanel OptinHTMLFormInputElementsPanelItem22;
    private javax.swing.JPanel OptinTitlePanel12;
    private javax.swing.JPanel PaymentMethodsAndMoreContentPanel;
    private javax.swing.JPanel PaymentMethodsAndMoreGroupPanel;
    private javax.swing.JPanel PaymentMethodsGroupPanel;
    private javax.swing.JPanel PaymentTotalVerificationCodeEnabledPanel;
    private javax.swing.JCheckBox cbAllowURLChanges;
    private javax.swing.JCheckBox allowActionExecutionInSoftwareUpdatesEnabled;
    private javax.swing.JCheckBox allowServerNotificationOfUpdateStatusEnabled;
    private javax.swing.JCheckBox allowSoftwareUpdateExpirationProcessingEnabled;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel MiddleFillerPanel;
    private javax.swing.JPanel MiddleFillerSpacePanel;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea taOptionsDescription;
    private EAPropertiesPanel theEAPropFileList;
    private AllowURLChangesControl allowURLChangesPanel;
    private MaxURLsAllowed maxURLsAllowedPanel;
    // End of variables declaration//GEN-END:variables
    
}
