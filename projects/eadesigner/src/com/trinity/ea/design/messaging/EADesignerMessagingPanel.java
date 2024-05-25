/*
 * EADesignerMessagingPanel.java
 *
 * Created on December 13, 2003, 1:17 AM
 */

package com.trinity.ea.design.messaging;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.common.panel.EAMasterControlPanel;
import com.trinity.ea.design.common.panel.EAPropertiesPanel;
import com.trinity.ea.design.common.panel.EAListItem;
import com.trinity.ea.design.common.panel.EAListItemContent;
import com.trinity.ea.design.common.panel.DataContentPanel;
import com.trinity.ea.design.common.panel.MarginContentPanel;
import com.trinity.ea.design.common.panel.TextFieldPanel;
import com.trinity.ea.design.messaging.config.MessagingConfigPanel;
import com.trinity.ea.design.messaging.actions.MessagingActionsPanel;
import com.trinity.ea.design.messaging.encrypt.MessagingEncryptionPanel;
import com.trinity.ea.design.common.sidebar.SBTab;
import com.trinity.ea.design.common.sidebar.SBSpacer;
import com.trinity.ea.design.rules.builder.DesignerRuleBuilder;
import com.trinity.ea.design.common.borderline.ContentAreaHeaderPanel;
import com.trinity.ea.design.common.file.ProjectManager;
//import com.trinity.ea.design.common.status.ProgressWindow;
import java.awt.Font;
import java.util.HashMap;
import java.util.Collections;
import java.util.Map;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class EADesignerMessagingPanel extends EAMasterControlPanel {
Map sbMap = Collections.synchronizedMap(new HashMap());    
    private Color backgroundColor = new java.awt.Color(100, 120, 170);
    private Color borderColor1 = new java.awt.Color(198, 226, 253);
    private Color borderColor2 = new java.awt.Color(96, 110, 145);
    private Color rowColor = new java.awt.Color(220, 225, 240);
    private Color rowBorderColor = new java.awt.Color(255, 255, 255);
    private Icon theActionRowIcon = new javax.swing.ImageIcon(getClass().getResource("/images/lgpl/action.png"));
    private int rowHeight = 25;

    /** Creates new form EADesignerProjectPanel */
    public EADesignerMessagingPanel() {
    
//	ProgressWindow progWindow = new ProgressWindow();
//	try
////	{
//	  progWindow.showStatus("Launching Messaging Designer", 1);
        initComponents();
	  initSidebar();
        setSelectedMenuItem(MessagingMenuLabelConfigButton);   
  	  setPropertiesPanel();
//	  progWindow.close();
//	}
//	catch(Exception e)
//	{
//		e.printStackTrace();
//		progWindow.close();
//	}
    }
    
    private EAPanel TheContentPanelReference = new EAPanel();
    private void setContentPanel(EAPanel theContentPanel)
    {
        try
        {
	     getDataUpdate();
           TheContentPanelReference.setVisible(false);
           ProjectSelectionContentPanel.remove(TheContentPanelReference);        
           TheContentPanelReference = theContentPanel;
           ProjectSelectionContentPanel.add(TheContentPanelReference);     
           TheContentPanelReference.setVisible(true);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }     

    public synchronized void getDataUpdate()
    {
	try
	{
		autoUpdateConfigPanel.getDataUpdate();
		// Auto Update Support Functionality Checkbox Enabled/Disabled
            if(cbMessagingEnabled.isSelected()==true)
            {
		    ProjectManager.putTempNoFileWrite("msgEnabled", "true");
 		    ProjectManager.putTempNoFileWrite("project_messaging_support_is_enabled", "true");                            
            }
            else
            {
		    ProjectManager.putTempNoFileWrite("msgEnabled", "false");
		    ProjectManager.putTempNoFileWrite("project_messaging_support_is_enabled", "false");               
            }
            ProjectManager.saveTempNow();
		TheContentPanelReference.getDataUpdate();
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
		// Auto Update Support Functionality Checkbox Enabled/Disabled   
            if(ProjectManager.get("project_auto_update_support_is_enabled").equalsIgnoreCase("true")==true)
            {
                cbMessagingEnabled.setSelected(true);              
            }
            else
            {
                cbMessagingEnabled.setSelected(false);               
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
        MessagingContentTopPanel = new javax.swing.JPanel();
        MessagingCentralContentPanel = new javax.swing.JPanel();
        MessagingContentPanel = new EAPanel();
        MessagingContentPanelItem1 = new EAPanel();
        MessagingSettingsPanelItem1 = new javax.swing.JPanel();
        MessagingEnabledPanel = new EAPanel();
        cbMessagingEnabled = new javax.swing.JCheckBox();
        MessagingPanelMainContainer = new javax.swing.JPanel();
        MessagingSettingsPanelItem7 = new javax.swing.JPanel();
        MessagingCentralContentLeftMarginPanel = new javax.swing.JPanel();
        MessagingCentralContentRightMarginPanel = new javax.swing.JPanel();
        MessagingContentBottomPanel = new javax.swing.JPanel();
        ProjectMenuPanel = new javax.swing.JPanel();
        LeftMenuPanelBottomPanel = new javax.swing.JPanel();
        ProjectMenuButtonPanel = new javax.swing.JPanel();
        MessagingMenuLabelConfigButton = new SBTab("Properties",sbTabWidth, sbTabHeight, sbTabLeftMargin, theCurrentMenuColor, theTextMenuColor, arrowIcon, iconTextGap, sbTabTopBorderColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor, sbTabIsOpaque);
        MessagingMenuLabelActionsButton = new SBTab("Actions",sbTabWidth, sbTabHeight, sbTabLeftMargin, theCurrentMenuColor, theTextMenuColor, arrowIcon, iconTextGap, sbTabTopBorderColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor, sbTabIsOpaque);
        MessagingMenuLabelHTMLFormInputsButton = new SBTab("Security",sbTabWidth, sbTabHeight, sbTabLeftMargin, theCurrentMenuColor, theTextMenuColor, arrowIcon, iconTextGap, sbTabTopBorderColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor, sbTabIsOpaque);
        ProjectMenuButtonPanelTop = new SBTab(null,sbTabWidth, sbTabMenuTopSpaceFiller, sbTabLeftMargin, theCurrentMenuColor, theTextMenuColor, null, iconTextGap, theCurrentMenuColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor, sbTabIsOpaque);
        ProjectMenuButtonPanelBottom = new SBSpacer(theCurrentMenuColor,sbTabTopBorderColor,theCurrentMenuColor,sbTabRightInnerBorderColor,sbTabRightOuterBorderColor,sbTabIsOpaque);
        PaymentsMenuLeftSpaceFiller = new javax.swing.JPanel();
        ProjectSelectionContentPanel = new javax.swing.JPanel();
	  marginContentPanel = new MarginContentPanel();
	  autoUpdateConfigPanel = new MessagingConfigPanel();
	  autoUpdateEncryptionPanel = new MessagingEncryptionPanel();
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        setBackground(new java.awt.Color(100, 120, 170));
        MessagingContentTopPanel.setLayout(new java.awt.BorderLayout());

        MessagingContentTopPanel.setBackground(new java.awt.Color(100, 120, 170));
        MessagingContentTopPanel.setMaximumSize(new java.awt.Dimension(2147483647, 60));
        MessagingContentTopPanel.setPreferredSize(new java.awt.Dimension(620, 60));
        MessagingCentralContentPanel.setLayout(new java.awt.BorderLayout());

        MessagingCentralContentPanel.setBackground(new java.awt.Color(100, 120, 170));
        MessagingCentralContentPanel.setMaximumSize(new java.awt.Dimension(2147483647, 60));
        MessagingContentPanel.setLayout(new javax.swing.BoxLayout(MessagingContentPanel, javax.swing.BoxLayout.Y_AXIS));

        MessagingContentPanel.setBackground(new java.awt.Color(100, 120, 170));
        MessagingContentPanel.setMaximumSize(new java.awt.Dimension(2147483647, 60));
        MessagingContentPanel.setMinimumSize(new java.awt.Dimension(448, 0));
        MessagingContentPanel.setPreferredSize(new java.awt.Dimension(600, 60));
        MessagingContentPanelItem1.setLayout(new javax.swing.BoxLayout(MessagingContentPanelItem1, javax.swing.BoxLayout.Y_AXIS));

        MessagingContentPanelItem1.setBackground(new java.awt.Color(100, 120, 170));
        MessagingContentPanelItem1.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(140, 171, 240), new java.awt.Color(27, 44, 76)), "Messaging", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12)));
        MessagingContentPanelItem1.setMaximumSize(new java.awt.Dimension(2147483647, 60));
        MessagingSettingsPanelItem1.setLayout(new java.awt.BorderLayout());

        MessagingSettingsPanelItem1.setBackground(new java.awt.Color(100, 120, 170));
        MessagingEnabledPanel.setLayout(new java.awt.BorderLayout(15, 5));

        MessagingEnabledPanel.setBackground(new java.awt.Color(100, 120, 170));
        MessagingEnabledPanel.setMaximumSize(new java.awt.Dimension(100, 2147483647));
        cbMessagingEnabled.setBackground(new java.awt.Color(100, 120, 170));
        cbMessagingEnabled.setFont(new java.awt.Font("Arial", 0, 12));
        try
        {
		// Auto Update Support Functionality Checkbox Enabled/Disabled   
            if(ProjectManager.get("project_auto_update_support_is_enabled").equalsIgnoreCase("true")==true)
            {
                cbMessagingEnabled.setSelected(true);              
            }
            else
            {
                cbMessagingEnabled.setSelected(false);               
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        cbMessagingEnabled.setText("Enable Messaging Support");
        MessagingEnabledPanel.add(cbMessagingEnabled, java.awt.BorderLayout.CENTER);

        MessagingSettingsPanelItem1.add(MessagingEnabledPanel, java.awt.BorderLayout.WEST);

        MessagingPanelMainContainer.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));

        MessagingPanelMainContainer.setBackground(new java.awt.Color(100, 120, 170));
        MessagingSettingsPanelItem1.add(MessagingPanelMainContainer, java.awt.BorderLayout.CENTER);

        MessagingContentPanelItem1.add(MessagingSettingsPanelItem1);

        MessagingSettingsPanelItem7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        MessagingSettingsPanelItem7.setBackground(new java.awt.Color(100, 120, 170));
        MessagingContentPanelItem1.add(MessagingSettingsPanelItem7);

        MessagingContentPanel.add(MessagingContentPanelItem1);

        MessagingCentralContentPanel.add(MessagingContentPanel, java.awt.BorderLayout.CENTER);

        MessagingCentralContentLeftMarginPanel.setBackground(new java.awt.Color(100, 120, 170));
        MessagingCentralContentLeftMarginPanel.setMaximumSize(new java.awt.Dimension(1, 200));
        MessagingCentralContentPanel.add(MessagingCentralContentLeftMarginPanel, java.awt.BorderLayout.WEST);

        MessagingCentralContentRightMarginPanel.setBackground(new java.awt.Color(100, 120, 170));
        MessagingCentralContentRightMarginPanel.setMaximumSize(new java.awt.Dimension(32767, 200));
        MessagingCentralContentPanel.add(MessagingCentralContentRightMarginPanel, java.awt.BorderLayout.EAST);

        MessagingContentTopPanel.add(MessagingCentralContentPanel, java.awt.BorderLayout.CENTER);

        add(MessagingContentTopPanel);

        MessagingContentBottomPanel.setLayout(new java.awt.BorderLayout());

        MessagingContentBottomPanel.setBackground(new java.awt.Color(100, 120, 170));
        ProjectMenuPanel.setLayout(new java.awt.BorderLayout());

        ProjectMenuPanel.setBackground(new java.awt.Color(100, 120, 170));
        ProjectMenuPanel.setForeground(new java.awt.Color(255, 255, 255));
        ProjectMenuPanel.setMaximumSize(new java.awt.Dimension(sbTabWidth, 32767));
        ProjectMenuPanel.setMinimumSize(new java.awt.Dimension(sbTabWidth, 10));
        ProjectMenuPanel.setPreferredSize(new java.awt.Dimension(sbTabWidth, 10));
        ProjectMenuButtonPanel.setLayout(new javax.swing.BoxLayout(ProjectMenuButtonPanel, javax.swing.BoxLayout.Y_AXIS));

        ProjectMenuButtonPanel.setBackground(new java.awt.Color(100, 120, 170));
        ProjectMenuButtonPanel.setForeground(new java.awt.Color(255, 255, 255));
        ProjectMenuButtonPanel.setMaximumSize(new java.awt.Dimension(sbTabWidth, sbTabGroupHeight));
        ProjectMenuButtonPanel.setMinimumSize(new java.awt.Dimension(sbTabWidth, sbTabGroupHeight));
        ProjectMenuButtonPanel.setPreferredSize(new java.awt.Dimension(sbTabWidth, sbTabGroupHeight));
        LeftMenuPanelBottomPanel.setLayout(new java.awt.BorderLayout());

        LeftMenuPanelBottomPanel.setBackground(new java.awt.Color(39, 63, 109));
        LeftMenuPanelBottomPanel.setForeground(new java.awt.Color(255, 255, 255));
        LeftMenuPanelBottomPanel.setMaximumSize(new java.awt.Dimension(sbTabWidth, sbTabGroupHeight));
        LeftMenuPanelBottomPanel.setMinimumSize(new java.awt.Dimension(sbTabWidth, sbTabGroupHeight));
        LeftMenuPanelBottomPanel.setPreferredSize(new java.awt.Dimension(sbTabWidth, sbTabGroupHeight));
 
        MessagingMenuLabelConfigButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MessagingMenuLabelConfigButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MessagingMenuLabelConfigButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MessagingMenuLabelConfigButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MessagingMenuLabelConfigButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MessagingMenuLabelConfigButtonMouseReleased(evt);
            }
        });

        ProjectMenuButtonPanel.add(MessagingMenuLabelConfigButton);

        MessagingMenuLabelActionsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MessagingMenuLabelActionsButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MessagingMenuLabelActionsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MessagingMenuLabelActionsButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MessagingMenuLabelActionsButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MessagingMenuLabelActionsButtonMouseReleased(evt);
            }
        });

        ProjectMenuButtonPanel.add(MessagingMenuLabelActionsButton);

         MessagingMenuLabelHTMLFormInputsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MessagingMenuLabelHTMLFormInputsButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MessagingMenuLabelHTMLFormInputsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MessagingMenuLabelHTMLFormInputsButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MessagingMenuLabelHTMLFormInputsButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MessagingMenuLabelHTMLFormInputsButtonMouseReleased(evt);
            }
        });

        ProjectMenuButtonPanel.add(MessagingMenuLabelHTMLFormInputsButton);
/**********************/
        LeftMenuPanelBottomPanel.add(ProjectMenuButtonPanel, java.awt.BorderLayout.NORTH);
        LeftMenuPanelBottomPanel.add(ProjectMenuButtonPanelBottom, java.awt.BorderLayout.CENTER);
        ProjectMenuPanel.add(LeftMenuPanelBottomPanel, java.awt.BorderLayout.CENTER);
        ProjectMenuPanel.add(ProjectMenuButtonPanelTop, java.awt.BorderLayout.NORTH);
        ProjectMenuButtonPanelBottom.setBackground(new java.awt.Color(100, 120, 170));
        ProjectMenuButtonPanelBottom.setForeground(new java.awt.Color(255, 255, 255));
        PaymentsMenuLeftSpaceFiller.setBackground(new java.awt.Color(100, 120, 170));
        PaymentsMenuLeftSpaceFiller.setMinimumSize(new java.awt.Dimension(1, 10));
        PaymentsMenuLeftSpaceFiller.setPreferredSize(new java.awt.Dimension(1, 10));
        ProjectMenuPanel.add(PaymentsMenuLeftSpaceFiller, java.awt.BorderLayout.WEST);
        MessagingContentBottomPanel.add(ProjectMenuPanel, java.awt.BorderLayout.WEST);
/**********************/
        ProjectSelectionContentPanel.setLayout(new java.awt.BorderLayout());

        ProjectSelectionContentPanel.setBackground(new java.awt.Color(140, 160, 210));
        ProjectSelectionContentPanel.setForeground(new java.awt.Color(255, 255, 255));
        MessagingContentBottomPanel.add(ProjectSelectionContentPanel, java.awt.BorderLayout.CENTER);

        //add(MessagingContentBottomPanel);
// add header here
	  contentPanel = new JPanel();
        contentPanel.setLayout(new java.awt.BorderLayout());
        contentPanel.add(ProjectMenuPanel, java.awt.BorderLayout.WEST);
        contentPanel.add(MessagingContentBottomPanel, java.awt.BorderLayout.CENTER);
	  contentProjectPanel = new ContentAreaHeaderPanel(contentPanel, sbTabWidth, theCurrentMenuColor, sbTabRightInnerBorderColor,sbTabRightOuterBorderColor,theSelectedMenuColor);
	  add(contentProjectPanel, java.awt.BorderLayout.CENTER);
	  autoUpdateEnabledPanel = new MessagingEnabledControl();
//
theEAProperties = new EAPropertiesPanel(getActionsEAListItems(),rowColor, rowBorderColor, backgroundColor, rowHeight);
//
theEAProperties.setMasterControlPanel(this);
//	  
	try
	{
	  theEAProperties.setDescriptorPanelWidth(201);
	  autoUpdateEnabledPanel.setBackgroundColor(backgroundColor);
	  autoUpdateEnabledPanel.setText("Enable Messaging Support");
	  theEAProperties.setHeaderText("Action Mappings");
	  theEAProperties.setDescriptorText("");
	  theEAProperties.setHeaderTextAndWidth("Action Mappings", 275, "Class Name", 120, "", 0);
	  theEAProperties.setAddButtonVisible(false);
	  theEAProperties.setEditButtonVisible(false);
	  theEAProperties.setRemoveButtonVisible(false);
	  theEAProperties.setPreviewButtonVisible(false);
	  theEAProperties.setConfigurationWizardButtonVisible(false);
	  theEAProperties.setSelectedIndex(0);
	  theEAProperties.setDescriptorPanel(autoUpdateEnabledPanel);

	  EAListItem eaListItemObj = theEAProperties.getSelectedEAListItem();
	  eaListItemObj.setSelectedMode();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

    }//GEN-END:initComponents

    private void MessagingMenuLabelHTMLFormInputsButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagingMenuLabelHTMLFormInputsButtonMouseReleased
	 setMouseReleasedMenuLabel(MessagingMenuLabelHTMLFormInputsButton);
    }//GEN-LAST:event_MessagingMenuLabelHTMLFormInputsButtonMouseReleased

    private void MessagingMenuLabelActionsButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagingMenuLabelActionsButtonMouseReleased
	 setMouseReleasedMenuLabel(MessagingMenuLabelActionsButton);
    }//GEN-LAST:event_MessagingMenuLabelActionsButtonMouseReleased

    private void MessagingMenuLabelConfigButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagingMenuLabelConfigButtonMouseReleased
	 setMouseReleasedMenuLabel(MessagingMenuLabelConfigButton);
    }//GEN-LAST:event_MessagingMenuLabelConfigButtonMouseReleased

    private void MessagingMenuLabelHTMLFormInputsButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagingMenuLabelHTMLFormInputsButtonMousePressed
        setMousePressedMenuLabel(MessagingMenuLabelHTMLFormInputsButton);
    }//GEN-LAST:event_MessagingMenuLabelHTMLFormInputsButtonMousePressed

    private void MessagingMenuLabelActionsButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagingMenuLabelActionsButtonMousePressed
        setMousePressedMenuLabel(MessagingMenuLabelActionsButton);
    }//GEN-LAST:event_MessagingMenuLabelActionsButtonMousePressed

    private void MessagingMenuLabelConfigButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagingMenuLabelConfigButtonMousePressed
        setMousePressedMenuLabel(MessagingMenuLabelConfigButton);
    }//GEN-LAST:event_MessagingMenuLabelConfigButtonMousePressed

    private void MessagingMenuLabelHTMLFormInputsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagingMenuLabelHTMLFormInputsButtonMouseExited
        setMouseExitedMenuLabel(MessagingMenuLabelHTMLFormInputsButton);
    }//GEN-LAST:event_MessagingMenuLabelHTMLFormInputsButtonMouseExited

    private void MessagingMenuLabelActionsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagingMenuLabelActionsButtonMouseExited
        setMouseExitedMenuLabel(MessagingMenuLabelActionsButton);
    }//GEN-LAST:event_MessagingMenuLabelActionsButtonMouseExited

    private void MessagingMenuLabelConfigButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagingMenuLabelConfigButtonMouseExited
        setMouseExitedMenuLabel(MessagingMenuLabelConfigButton);
    }//GEN-LAST:event_MessagingMenuLabelConfigButtonMouseExited

    private void MessagingMenuLabelHTMLFormInputsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagingMenuLabelHTMLFormInputsButtonMouseEntered
        setMouseEnteredMenuLabel(MessagingMenuLabelHTMLFormInputsButton);
    }//GEN-LAST:event_MessagingMenuLabelHTMLFormInputsButtonMouseEntered

    private void MessagingMenuLabelActionsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagingMenuLabelActionsButtonMouseEntered
        setMouseEnteredMenuLabel(MessagingMenuLabelActionsButton);
    }//GEN-LAST:event_MessagingMenuLabelActionsButtonMouseEntered

    private void MessagingMenuLabelConfigButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagingMenuLabelConfigButtonMouseEntered
        setMouseEnteredMenuLabel(MessagingMenuLabelConfigButton);
    }//GEN-LAST:event_MessagingMenuLabelConfigButtonMouseEntered

    private void MessagingMenuLabelHTMLFormInputsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagingMenuLabelHTMLFormInputsButtonMouseClicked
 	setSelectedMenuItem(MessagingMenuLabelHTMLFormInputsButton);
	setEncryptionPanel();
    }//GEN-LAST:event_MessagingMenuLabelHTMLFormInputsButtonMouseClicked

    private void MessagingMenuLabelActionsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagingMenuLabelActionsButtonMouseClicked
	setSelectedMenuItem(MessagingMenuLabelActionsButton);
	setActionsPanel();
    }//GEN-LAST:event_MessagingMenuLabelActionsButtonMouseClicked

    private void MessagingMenuLabelConfigButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MessagingMenuLabelConfigButtonMouseClicked
	setSelectedMenuItem(MessagingMenuLabelConfigButton); 
	setPropertiesPanel();
    }//GEN-LAST:event_MessagingMenuLabelConfigButtonMouseClicked

 private Color theCurrentMenuColor = new Color(100, 120, 170);
 private Color theSelectedMenuColor = new Color(140,160,210);
 private Color theTextMenuColor = new Color(255, 255, 255);
 private boolean pressedSelected = false;
 private Icon arrowIcon = new javax.swing.ImageIcon(getClass().getResource("/images/arrow.gif"));
 private Icon arrowSelectedIcon = new javax.swing.ImageIcon(getClass().getResource("/images/arrow_selected.gif"));
 private Icon arrowMouseOverIcon = new javax.swing.ImageIcon(getClass().getResource("/images/arrow_mouseover.gif"));  
 private int iconTextGap = 5;
 private int sbTabMenuTopSpaceFiller = 15;
 private int sbTabLeftMargin = 5;
 private int sbTabWidth = 100;
 private int sbTabHeight = 25;
 private int sbTabGroupHeight = 75;
 private boolean sbTabIsOpaque=true;
 private Color sbTabTopBorderColor = new Color(140, 171, 240);
 private Color sbTabBottomBorderColor = new Color(70, 82, 116);
 private Color sbTabTopSelectedBorderColor = new Color(96, 110, 145);
 private Color sbTabBottomSelectedBorderColor = new Color(198, 226, 253);
 private Color sbTabRightInnerBorderColor = new java.awt.Color(68, 76, 100);
 private Color sbTabRightOuterBorderColor = new java.awt.Color(100, 114, 149);
 private Font sbTabFont = new java.awt.Font("Arial", 1, 12);
 private SBTab TheMenuLabelReference = new SBTab(null,sbTabWidth, sbTabHeight, sbTabLeftMargin, theCurrentMenuColor, theTextMenuColor, arrowIcon, iconTextGap, sbTabTopBorderColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor, sbTabIsOpaque);
 private SBTab thePressedLabelReference = null;
 private SBTab theEnteredLabelReference = null;

 private void setSelectedMenuItem(SBTab theMenuLabel)
  {
    try
    {
        TheMenuLabelReference.setBackgroundColor(theCurrentMenuColor);
	  TheMenuLabelReference.setTheTopBottomBorderColors(sbTabTopBorderColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor);
        TheMenuLabelReference.setTheIcon(arrowIcon);
        theMenuLabel.setBackgroundColor(theSelectedMenuColor);
        theMenuLabel.setTheIcon(arrowSelectedIcon);
	  theMenuLabel.setTheTopBottomBorderColors(sbTabTopSelectedBorderColor, sbTabBottomSelectedBorderColor, theSelectedMenuColor, theSelectedMenuColor);
        TheMenuLabelReference = theMenuLabel;

                       /* try
                        {
                            setContentPanel((EAPanel)Class.forName(getSidebarComponentID(theMenuLabel.getComponentLocalizationID())).newInstance());
                        }
                        catch(InstantiationException e)
                        {
                            e.printStackTrace();
                        }   
                        catch(IllegalAccessException e)
                        {
                            e.printStackTrace();
                        }                      
                        catch(ClassNotFoundException e)
                        {
                            e.printStackTrace();
                        }   */
	  theEAProperties.setSelectedIndex(0);
	  EAListItem eaListItemObj = theEAProperties.getSelectedEAListItem();
	  eaListItemObj.setSelectedMode();
    }
    catch(Exception e)
    {
	e.printStackTrace();
    }
  }    
 boolean isEntered = false;
 private void setMouseEnteredMenuLabel(SBTab theEnteredLabel)
 {
    isEntered = true;
    try
    {
        theEnteredLabelReference = theEnteredLabel;
        if(theEnteredLabel.equals(TheMenuLabelReference)==false)
        {
            theEnteredLabel.setTheIcon(arrowMouseOverIcon);
            if(pressedSelected==true)
            {
                
                TheMenuLabelReference.setForegroundColor(theTextMenuColor);
            }
        }
        else
        {
            if(pressedSelected==true)
            {
                TheMenuLabelReference.setForegroundColor(theSelectedMenuColor);    
            }
        }
    }
    catch(Exception e)
    {
        System.out.println(e);
    }     
 }
 private void setMouseExitedMenuLabel(SBTab theExitedLabel)
 {
    isEntered = false;
    try
    {
        if(theExitedLabel.equals(TheMenuLabelReference)==false)
        {
            theExitedLabel.setTheIcon(arrowIcon);   
        }
        else
        {
            theEnteredLabelReference.setForegroundColor(theTextMenuColor);           
        }
    }
    catch(Exception e)
    {
        System.out.println(e);
    }  
 }

  private void setMousePressedMenuLabel(SBTab thePressedLabel)
 {
    try
    {
        thePressedLabelReference = thePressedLabel;
        if(thePressedLabel.equals(TheMenuLabelReference)==false)
        {
            thePressedLabel.setBackgroundColor(theSelectedMenuColor); 
	  	thePressedLabel.setTheTopBottomBorderColors(sbTabTopSelectedBorderColor, sbTabBottomSelectedBorderColor, theSelectedMenuColor, theSelectedMenuColor);
        }
        else
        {
            pressedSelected=true; 
            thePressedLabel.setForegroundColor(theSelectedMenuColor);
        }
    }
    catch(Exception e)
    {
        System.out.println(e);
    }  
 }
 
  private void setMouseReleasedMenuLabel(SBTab theReleasedLabel)
 {
    try
    {
        pressedSelected = false;
        if(theEnteredLabelReference.equals(thePressedLabelReference)==false || isEntered == false)
        {
            if(thePressedLabelReference.equals(TheMenuLabelReference)==false)
            {
                thePressedLabelReference.setBackgroundColor(theCurrentMenuColor);
		    thePressedLabelReference.setTheTopBottomBorderColors(sbTabTopBorderColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor);
            }
            if(thePressedLabelReference.equals(TheMenuLabelReference)==true)
            {           
                thePressedLabelReference.setForegroundColor(theTextMenuColor);
            }           
        }
        else
        {
            if(thePressedLabelReference.equals(TheMenuLabelReference)==true)
            {           
                thePressedLabelReference.setForegroundColor(theTextMenuColor);
            }
		else
		{
		    try
		    {
 		        TheMenuLabelReference.setBackgroundColor(theCurrentMenuColor);
			  TheMenuLabelReference.setTheTopBottomBorderColors(sbTabTopBorderColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor);
 		        TheMenuLabelReference.setTheIcon(arrowIcon);
 		        thePressedLabelReference.setTheIcon(arrowSelectedIcon);
 		        TheMenuLabelReference = thePressedLabelReference;
                       /* try
                        {
                            setContentPanel((EAPanel)Class.forName(getSidebarComponentID(theReleasedLabel.getComponentLocalizationID())).newInstance());
                        }
                        catch(InstantiationException e)
                        {
                            e.printStackTrace();
                        }   
                        catch(IllegalAccessException e)
                        {
                            e.printStackTrace();
                        }                      
                        catch(ClassNotFoundException e)
                        {
                            e.printStackTrace();
                        }*/
  	  theEAProperties.setSelectedIndex(0);
	  EAListItem eaListItemObj = theEAProperties.getSelectedEAListItem();
	  eaListItemObj.setSelectedMode();   
 		    }
		    catch(Exception e)
		    {
		        System.out.println(e);
		    }
		}
        }
        
    }
    catch(Exception e)
    {
        System.out.println(e);
    }  
 } 
    private static synchronized Object[] getStringArraysFromString(String textArrayString)
    {
        ArrayList aryList = new ArrayList();
        String tempString = "";
        try
        {
            while(textArrayString.indexOf(",")!=-1)
            {
                tempString = textArrayString.substring(0,textArrayString.indexOf(","));
                textArrayString = textArrayString.substring(textArrayString.indexOf(",") + 1);
                aryList.add(tempString);
            }
            aryList.add(textArrayString);
            aryList.trimToSize();
        }
        catch(NullPointerException e)
        {
         
        }

        return aryList.toArray();
    }  

private synchronized String getSidebarComponentID(String compRefID)
{
	try
	{
		return (String)sbMap.get(compRefID);
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
	return "";
}

private synchronized void initSidebar()
{
try
{
	Object[] sbUIStrings = getStringArraysFromString(DesignerRuleBuilder.get("sbMessagingStrings"));
	Object[] sbUIActions = getStringArraysFromString(DesignerRuleBuilder.get("sbMessagingActionPanels"));
//sbMap

                    for(int i = 0;i<sbUIStrings.length;i++)
                    {
                        try
				{
					sbMap.put((String)sbUIStrings[i],(String)sbUIActions[i]);
					//LeftMenuButtonPanel.add(new SBTab((String)sbUIStrings[i],sbTabWidth, sbTabHeight, sbTabLeftMargin, theCurrentMenuColor, theTextMenuColor, arrowIcon, iconTextGap, sbTabTopBorderColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor, sbTabIsOpaque));
				}
				catch(Exception e)
				{
					sbMap.put((String)sbUIStrings[i],"");
				} 
                    }
}
catch(Exception e)
{
	e.printStackTrace();
}
}      

private String[] strActionsArray = new String[3];
private EAListItem[] ActionsEAListItemArray = new EAListItem[3];
private EAListItem[] getActionsEAListItems()
{
        try
        {
		int defActionLabelWidth = 250;
		int defActionDataWidth = 325;

		EAListItem[] eaItems = new EAListItem[3];
            EAListItem eai = new EAListItem(theActionRowIcon,rowColor);
		EAListItemContent msgDisplayMessageUIAction = new EAListItemContent(rowColor, defActionLabelWidth, defActionDataWidth);
		msgDisplayMessageUIAction.setLabelText("Display Message User Interface Action:");
		if(ProjectManager.get("msgDisplayMessageUIAction")!=null)
		{
			msgDisplayMessageUIAction.setInputText(ProjectManager.get("msgDisplayMessageUIAction"));
			strActionsArray[0] = "msgDisplayMessageUIAction";
		}
            eai.setRowDataPanel(msgDisplayMessageUIAction);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai.setListItemIsRemovable(false);
		eai.setValueBoxEnabled(false);
		eaItems[0] = eai;
//
            EAListItem eai2 = new EAListItem(theActionRowIcon,rowColor);
		EAListItemContent msgCustomMessageUIAction = new EAListItemContent(rowColor, defActionLabelWidth, defActionDataWidth);
		msgCustomMessageUIAction.setLabelText("Custom Message User Interface Action:");
		if(ProjectManager.get("msgCustomMessageUIAction")!=null)
		{
			msgCustomMessageUIAction.setInputText(ProjectManager.get("msgCustomMessageUIAction"));
			strActionsArray[1] = "msgCustomMessageUIAction";
		}
            eai2.setRowDataPanel(msgCustomMessageUIAction);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai2.setListItemIsRemovable(false);
		eai2.setValueBoxEnabled(false);
		eaItems[1] = eai2;
//
            EAListItem eai3 = new EAListItem(theActionRowIcon,rowColor);
		EAListItemContent msgFinishedUIAction = new EAListItemContent(rowColor, defActionLabelWidth, defActionDataWidth);
		msgFinishedUIAction.setLabelText("Message Finished User Interface Action:");
		if(ProjectManager.get("msgFinishedUIAction")!=null)
		{
			msgFinishedUIAction.setInputText(ProjectManager.get("msgFinishedUIAction"));
			strActionsArray[2] = "msgFinishedUIAction";
		}
            eai3.setRowDataPanel(msgFinishedUIAction);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai3.setListItemIsRemovable(false);
		eai3.setValueBoxEnabled(false);
		eaItems[2] = eai3;
		ActionsEAListItemArray = eaItems;

		return eaItems;
        }
        catch(Exception e)
        {
          e.printStackTrace();   
        }
	EAListItem[] tempLIArray2 = new EAListItem[0];
	return tempLIArray2;
}

    public void setSelectedListItemEvent(int theLastSelectedIndex)
    {
		try
		{
			TheContentPanelReference.getDataUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		EAListItem eaListItemObj = theEAProperties.getSelectedEAListItem();
		EAListItemContent theContent = eaListItemObj.getRowDataPanel();
		if(theLastSelectedIndex!=-1)
		{
			try
			{
				theEAProperties.getSelectedEAListItem().getRowDataPanel().setInputText(ProjectManager.get(strActionsArray[theLastSelectedIndex]));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		DataContentPanel tempPanel = new DataContentPanel("The Messaging Action can be viewed below.");
		tempPanel.setContentPanel(new TextFieldPanel(ActionsEAListItemArray[theEAProperties.getSelectedIndex()].getRowDataPanel().getLabelText(), ProjectManager.get(strActionsArray[theEAProperties.getSelectedIndex()]), strActionsArray[theEAProperties.getSelectedIndex()], false));
		setContentPanel(tempPanel);
    }

        //MessagingSettingsPanelItem1.add(MessagingEnabledPanel, java.awt.BorderLayout.WEST);
    private EAPanel TheTopContentPanelReference = new EAPanel();
    private void setActionsPanel()
    {
        try
        {
	     getDataUpdate();
           MessagingContentTopPanel.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
           MessagingContentTopPanel.setPreferredSize(new java.awt.Dimension(620, 300));
	     MessagingCentralContentPanel.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
           MessagingCentralContentPanel.setPreferredSize(new java.awt.Dimension(620, 300));
           TheTopContentPanelReference.setVisible(false);
           MessagingCentralContentPanel.remove(TheTopContentPanelReference);        
           TheTopContentPanelReference = theEAProperties;
           MessagingCentralContentPanel.add(theEAProperties, java.awt.BorderLayout.CENTER);     
           TheTopContentPanelReference.setVisible(true);
	     DataContentPanel tempPanel = new DataContentPanel("The Messaging Action can be viewed below.");
	     tempPanel.setContentPanel(new TextFieldPanel(ActionsEAListItemArray[theEAProperties.getSelectedIndex()].getRowDataPanel().getLabelText(), ProjectManager.get(strActionsArray[theEAProperties.getSelectedIndex()]), strActionsArray[theEAProperties.getSelectedIndex()], true));
	     setContentPanel(tempPanel);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }  
    private void setPropertiesPanel()
    {
        try
        {
	     getDataUpdate();
           MessagingContentTopPanel.setMaximumSize(new java.awt.Dimension(2147483647, 60));
           MessagingContentTopPanel.setPreferredSize(new java.awt.Dimension(620, 60));
	     MessagingCentralContentPanel.setMaximumSize(new java.awt.Dimension(2147483647, 60));
           MessagingCentralContentPanel.setPreferredSize(new java.awt.Dimension(620, 60));
           TheTopContentPanelReference.setVisible(false);
           MessagingCentralContentPanel.remove(TheTopContentPanelReference);        
           TheTopContentPanelReference = MessagingContentPanel;
           MessagingCentralContentPanel.add(MessagingContentPanel, java.awt.BorderLayout.CENTER);     
           TheTopContentPanelReference.setVisible(true);
	     marginContentPanel.setContentPanel(autoUpdateConfigPanel);
	     setContentPanel(marginContentPanel);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }   

    private void setEncryptionPanel()
    {
        try
        {
	     getDataUpdate();
           MessagingContentTopPanel.setMaximumSize(new java.awt.Dimension(2147483647, 60));
           MessagingContentTopPanel.setPreferredSize(new java.awt.Dimension(620, 60));
	     MessagingCentralContentPanel.setMaximumSize(new java.awt.Dimension(2147483647, 60));
           MessagingCentralContentPanel.setPreferredSize(new java.awt.Dimension(620, 60));
           TheTopContentPanelReference.setVisible(false);
           MessagingCentralContentPanel.remove(TheTopContentPanelReference);        
           TheTopContentPanelReference = MessagingContentPanel;
           MessagingCentralContentPanel.add(MessagingContentPanel, java.awt.BorderLayout.CENTER);     
           TheTopContentPanelReference.setVisible(true);
	     setContentPanel(autoUpdateEncryptionPanel);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MessagingCentralContentLeftMarginPanel;
    private javax.swing.JPanel MessagingCentralContentPanel;
    private javax.swing.JPanel MessagingCentralContentRightMarginPanel;
    private javax.swing.JPanel MessagingContentBottomPanel;
    private EAPanel MessagingContentPanel;
    private EAPanel MessagingContentPanelItem1;
    private javax.swing.JPanel MessagingContentTopPanel;
    private EAPanel MessagingEnabledPanel;
    private SBTab MessagingMenuLabelActionsButton;
    private SBTab MessagingMenuLabelConfigButton;
    private SBTab MessagingMenuLabelHTMLFormInputsButton;
    private javax.swing.JPanel MessagingPanelMainContainer;
    private javax.swing.JPanel MessagingSettingsPanelItem1;
    private javax.swing.JPanel MessagingSettingsPanelItem7;
    private javax.swing.JPanel PaymentsMenuLeftSpaceFiller;
    private javax.swing.JPanel LeftMenuPanelBottomPanel;
    private javax.swing.JPanel ProjectMenuButtonPanel;
    private SBSpacer ProjectMenuButtonPanelBottom;
    private SBTab ProjectMenuButtonPanelTop;
    private javax.swing.JPanel ProjectMenuPanel;
    private javax.swing.JPanel ProjectSelectionContentPanel;
    private javax.swing.JCheckBox cbMessagingEnabled;
    private ContentAreaHeaderPanel contentProjectPanel;
    private javax.swing.JPanel contentPanel;
    private EAPropertiesPanel theEAProperties;
    private MessagingConfigPanel autoUpdateConfigPanel;
    private MessagingEncryptionPanel autoUpdateEncryptionPanel;
    private MessagingEnabledControl autoUpdateEnabledPanel;
    private MarginContentPanel marginContentPanel;
    // End of variables declaration//GEN-END:variables
    
}
