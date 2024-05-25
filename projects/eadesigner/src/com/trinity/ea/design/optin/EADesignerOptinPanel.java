/*
 * EADesignerOptinPanel.java
 *
 * Created on December 13, 2003, 1:17 AM
 */

package com.trinity.ea.design.optin;
import javax.swing.*;
import java.awt.*;
import com.trinity.ea.design.optin.provider.OptinWizard;
//import com.trinity.ea.design.common.status.ProgressWindow;
import com.trinity.ea.design.EADesigner;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.common.panel.EAMasterControlPanel;
import com.trinity.ea.design.common.panel.EAPropertiesPanel;
import com.trinity.ea.design.common.panel.EAListItem;
import com.trinity.ea.design.common.panel.EAListItemContent;
import com.trinity.ea.design.common.panel.DataContentPanel;
import com.trinity.ea.design.common.panel.TextFieldPanel;
import com.trinity.ea.design.common.panel.TextPanePanel;
import com.trinity.ea.design.optin.inputs.OptinHTMLFormInputsPanel;
import com.trinity.ea.design.optin.OptinEnabledControl;
import com.trinity.ea.design.common.sidebar.SBTab;
import com.trinity.ea.design.project.EADesignerProjectPanel;
import com.trinity.ea.design.common.sidebar.SBSpacer;
import com.trinity.ea.design.rules.builder.DesignerRuleBuilder;
import com.trinity.ea.design.common.file.ProjectManager;
import java.awt.Font;
import java.util.HashMap;
import java.util.Collections;
import java.util.Map;
import java.util.ArrayList;
import com.trinity.ea.design.common.borderline.ContentAreaHeaderPanel;
import java.net.URL;
import java.net.MalformedURLException;

/** 
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class EADesignerOptinPanel extends EAMasterControlPanel {

    Map sbMap = Collections.synchronizedMap(new HashMap());
    private Color backgroundColor = new java.awt.Color(100, 120, 170);
    private Color borderColor1 = new java.awt.Color(198, 226, 253);
    private Color borderColor2 = new java.awt.Color(96, 110, 145);
    private Color rowColor = new java.awt.Color(220, 225, 240);
    private Color rowBorderColor = new java.awt.Color(255, 255, 255);
    private Icon theRowIcon = new javax.swing.ImageIcon(getClass().getResource("/images/tree/arrow.png"));
    private Icon theUIStringRowIcon = new javax.swing.ImageIcon(getClass().getResource("/images/tree/uistring.png"));
    private Icon theActionRowIcon = new javax.swing.ImageIcon(getClass().getResource("/images/lgpl/action.png"));
    private int rowHeight = 25;

    /** Creates new form EADesignerProjectPanel */
    public EADesignerOptinPanel() {
	//ProgressWindow progWindow = new ProgressWindow();
	//try
	//{
	 // progWindow.showStatus("Launching E-mail Opt-In Designer", 1);
        initComponents();
	  setProjectData();
	  initSidebar();
	  setSelectedMenuItem(OptinMenuLabelHTMLFormInputsButton);
	  //setCheckLoadProjectFirstTime();
	  //progWindow.close();
	//}
	//catch(Exception e)
	//{
	//	e.printStackTrace();
	//	progWindow.close();
	//}
    }

   private EAPanel TheContentPanelReference = new EAPanel();
   private void setContentPanel(EAPanel theContentPanel)
  {
    try
    {
	 getDataUpdate();
       TheContentPanelReference.setVisible(false);
       OptinSelectionContentPanel.remove(TheContentPanelReference);        
       TheContentPanelReference = theContentPanel;
	 OptinSelectionContentPanel.setPreferredSize(new java.awt.Dimension(620, 275));
       OptinSelectionContentPanel.add(TheContentPanelReference);     
       TheContentPanelReference.setVisible(true);

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
		// Optin Support Functionality Checkbox Enabled/Disabled
		optinEnabledPanel.getDataUpdate();
		
		if(eaPropPanel == 0)
		{
		EAListItem[] theItems = theEAProperties.getEAListItems();
		if(theItems!=null)
		{
			if(0<theItems.length)
			{
				ArrayList theNamesList = new ArrayList();
				ArrayList theValuesList = new ArrayList();
				for(int i = 0;i<theItems.length;i++)
				{
						String[] theStrArray = theItems[i].getDataArray();
						if(1<theStrArray.length)
						{
							if(i==0)
							{
								ProjectManager.putTempNoFileWrite("optinInputFullName", theStrArray[0]);
							}
							else if(i==1)
							{
								ProjectManager.putTempNoFileWrite("optinInputEMailAddress", theStrArray[0]);
							}
							else
							{
								theNamesList.add(theStrArray[0]);
								if(1<theStrArray.length)
								{
									theValuesList.add(theStrArray[1].replaceAll(",",":::"));
								}
								else
								{
									theValuesList.add("");								
								}
							}
						}
				}
				theNamesList.trimToSize();
				theValuesList.trimToSize();
				ProjectManager.putTempNoFileWrite("optinInputHiddenNames",getStringFromArray(theNamesList.toArray()));
				ProjectManager.putTempNoFileWrite("optinInputHiddenValues",getStringFromArray(theValuesList.toArray()));
			}
		}
		}
		else if(eaPropPanel == 1)
		{

		}
		else if(eaPropPanel == 2)
		{

		}
		ProjectManager.saveTempNow();
		TheContentPanelReference.getDataUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
  }   

    private void setDataContentPanelProjectData()
    {
        try
        {
   		TheContentPanelReference.setProjectData();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void setProjectData()
    {
        try
        {
		// Privacy Policy Checkbox Enabled/Disabled
            if(ProjectManager.get("optinPrivacyPolicyEnabled").equalsIgnoreCase("true")==true)
            {
		    cbEnablePrivacyPolicy.setSelected(true);
            }
            else
            {
		    cbEnablePrivacyPolicy.setSelected(false);
            }
            if(ProjectManager.get("optinFormRequestMethod").equalsIgnoreCase("POST")==true)
            {
			optinRadioPostRequestMethod.setSelected(true);
			optinRadioGetRequestMethod.setSelected(false);
		}
		else
		{
			optinRadioGetRequestMethod.setSelected(true);
			optinRadioPostRequestMethod.setSelected(false);
		}
		tfEMailOptinFormActionURL.setOpaque(true);
		tfEMailOptinFormActionURL.setText(ProjectManager.get("optinFormActionURL"));
		tfEMailOptinFormActionURL.setCaretPosition(0);

		theEAProperties.setListDefaults(getDefaultEAListItems());
	      theEAProperties.setDefaultLabelText("Input Name Attribute: ");
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
        btnGroupOptinRequestMethod = new javax.swing.ButtonGroup();
        OptinContentBottomPanel = new javax.swing.JPanel();
        OptinMenuPanel = new javax.swing.JPanel();
        OptinMenuButtonPanel = new javax.swing.JPanel();
        OptinMenuLabelHTMLFormInputsButton = new SBTab("HTML Form",sbTabWidth, sbTabHeight, sbTabLeftMargin, theCurrentMenuColor, theTextMenuColor, arrowIcon, iconTextGap, sbTabTopBorderColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor, sbTabIsOpaque);
        OptinMenuLabelUIStringsButton = new SBTab("User Interface",sbTabWidth, sbTabHeight, sbTabLeftMargin, theCurrentMenuColor, theTextMenuColor, arrowIcon, iconTextGap, sbTabTopBorderColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor, sbTabIsOpaque);
        OptinMenuLabelActionsButton = new SBTab("Actions",sbTabWidth, sbTabHeight, sbTabLeftMargin, theCurrentMenuColor, theTextMenuColor, arrowIcon, iconTextGap, sbTabTopBorderColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor, sbTabIsOpaque);
        OptinMenuButtonPanelTop = new SBTab(null,sbTabWidth, sbTabMenuTopSpaceFiller, sbTabLeftMargin, theCurrentMenuColor, theTextMenuColor, null, iconTextGap, theCurrentMenuColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor, sbTabIsOpaque);
        BottomFillerPanel = new JPanel();
        OptinMenuButtonPanelBottom = new javax.swing.JPanel();
        LeftMenuControlAreaPanel = new SBSpacer(theCurrentMenuColor,sbTabTopBorderColor,theCurrentMenuColor,sbTabRightInnerBorderColor,sbTabRightOuterBorderColor,sbTabIsOpaque);
        OptinMenuLeftSpaceFiller = new JPanel();
        OptinSelectionContentPanel = new javax.swing.JPanel();
        OptinContentTopPanel = new javax.swing.JPanel();
        OptinCentralContentPanel = new javax.swing.JPanel();
        OptinContentPanel = new javax.swing.JPanel();
        OptinContentPanelItem1 = new javax.swing.JPanel();
        EMailOptinSettingsPanelItem1 = new javax.swing.JPanel();
        EMailOptinEnabledPanel = new javax.swing.JPanel();
        EMailOptinPanelMainContainer = new javax.swing.JPanel();
        btnEMailOptinFormAutomaticConfiguration = new javax.swing.JButton();
        btnEMailOptinFormPreview = new javax.swing.JButton();
        OptinSettingsPanelItem7 = new javax.swing.JPanel();
        OptinContentPanelItem2 = new javax.swing.JPanel();
        OptinSettingsPanelItem3 = new javax.swing.JPanel();
        OptinTitlePanel2 = new javax.swing.JPanel();
        lEMailOptinFormActionURL = new javax.swing.JLabel();
        tfEMailOptinFormActionURL = new javax.swing.JTextField();
        OptinTitleRightPanel2 = new javax.swing.JPanel();
        OptinSettingsPanelItem4 = new javax.swing.JPanel();
        OptinTitlePanel3 = new javax.swing.JPanel();
        optinRequestMethodLabel = new javax.swing.JLabel();
        optinRadioPostRequestMethod = new javax.swing.JRadioButton();
        optinRadioGetRequestMethod = new javax.swing.JRadioButton();
        OptinPrivacyPolicyPanel = new javax.swing.JPanel();
        cbEnablePrivacyPolicy = new javax.swing.JCheckBox();
        OptinCentralContentLeftMarginPanel = new javax.swing.JPanel();
        OptinCentralContentRightMarginPanel = new javax.swing.JPanel();
        LeftMenuPanelBottomPanel = new javax.swing.JPanel();
	  optinEnabledPanel = new OptinEnabledControl();
        setLayout(new java.awt.BorderLayout());
//
theEAProperties = new EAPropertiesPanel(getDefaultEAListItems(),rowColor, rowBorderColor, backgroundColor, rowHeight);
//
theEAProperties.setMasterControlPanel(this);
theEAProperties.setGetConfigurationWizardActionFromParent(true);
//
	  optinEnabledPanel.setBackgroundColor(backgroundColor);
	  optinEnabledPanel.setText("Enable E-mail Opt-In Support");
	  theEAProperties.setDescriptorText("Define HTML Form Input Names.");
	  theEAProperties.setHeaderText("HTML Form Inputs");
	  theEAProperties.setHeaderTextAndWidth("HTML Form Inputs", 275, "Name Attribute", 175, "Name Value", 150);
	  theEAProperties.setAddButtonText("Add Input");
	  theEAProperties.setRemoveButtonText("Remove Input");
	  theEAProperties.setEditButtonText("Edit Input");
	  theEAProperties.setPreviewButtonText("Preview");
	  theEAProperties.setConfigurationWizardButtonText("Configuration Wizard");
	  try
	  {
	  	theEAProperties.setConfigurationWizardButtonAction(DesignerRuleBuilder.get("optinConfigurationWizardAction"));
	  	theEAProperties.setPreviewButtonAction(DesignerRuleBuilder.get("optinPreviewAction"));
	  }
	  catch(Exception ee)
	  {
		ee.printStackTrace();
	  }
//
//
        setBackground(new java.awt.Color(100, 120, 170));
        OptinContentBottomPanel.setLayout(new java.awt.BorderLayout());
        OptinContentBottomPanel.setMaximumSize(new java.awt.Dimension(32767, 275));
        OptinContentBottomPanel.setMinimumSize(new java.awt.Dimension(0, 275));
        OptinContentBottomPanel.setPreferredSize(new java.awt.Dimension(500, 275));
        OptinContentBottomPanel.setBackground(new java.awt.Color(100, 120, 170));

        OptinMenuPanel.setLayout(new java.awt.BorderLayout());

        OptinMenuPanel.setBackground(new java.awt.Color(100, 120, 170));
        OptinMenuPanel.setForeground(new java.awt.Color(255, 255, 255));
        OptinMenuPanel.setMaximumSize(new java.awt.Dimension(sbTabWidth, 32767));
        OptinMenuPanel.setMinimumSize(new java.awt.Dimension(sbTabWidth, 0));
        OptinMenuPanel.setPreferredSize(new java.awt.Dimension(sbTabWidth, 270));
        OptinMenuButtonPanel.setLayout(new javax.swing.BoxLayout(OptinMenuButtonPanel, javax.swing.BoxLayout.Y_AXIS));

        OptinMenuButtonPanel.setBackground(theCurrentMenuColor);
        OptinMenuButtonPanel.setForeground(theTextMenuColor);
        OptinMenuButtonPanel.setMaximumSize(new java.awt.Dimension(sbTabWidth, sbTabGroupHeight));
        OptinMenuButtonPanel.setMinimumSize(new java.awt.Dimension(sbTabWidth, sbTabGroupHeight));
        OptinMenuButtonPanel.setPreferredSize(new java.awt.Dimension(sbTabWidth, sbTabGroupHeight));

       OptinMenuLabelHTMLFormInputsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OptinMenuLabelHTMLFormInputsButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OptinMenuLabelHTMLFormInputsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OptinMenuLabelHTMLFormInputsButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                OptinMenuLabelHTMLFormInputsButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                OptinMenuLabelHTMLFormInputsButtonMouseReleased(evt);
            }
        });

        OptinMenuButtonPanel.add(OptinMenuLabelHTMLFormInputsButton);

        OptinMenuLabelUIStringsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OptinMenuLabelUIStringsButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OptinMenuLabelUIStringsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OptinMenuLabelUIStringsButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                OptinMenuLabelUIStringsButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                OptinMenuLabelUIStringsButtonMouseReleased(evt);
            }
        });

        OptinMenuButtonPanel.add(OptinMenuLabelUIStringsButton);

        OptinMenuLabelActionsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OptinMenuLabelActionsButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OptinMenuLabelActionsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OptinMenuLabelActionsButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                OptinMenuLabelActionsButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                OptinMenuLabelActionsButtonMouseReleased(evt);
            }
        });

        OptinMenuButtonPanel.add(OptinMenuLabelActionsButton);
        OptinMenuLeftSpaceFiller.setBackground(new java.awt.Color(100, 120, 170));
        OptinMenuLeftSpaceFiller.setMinimumSize(new java.awt.Dimension(1, 0));
        OptinMenuLeftSpaceFiller.setPreferredSize(new java.awt.Dimension(1, 0));

        OptinMenuButtonPanelBottom.setBackground(theCurrentMenuColor);
        OptinMenuButtonPanelBottom.setForeground(theTextMenuColor);
        OptinMenuButtonPanelBottom.setMaximumSize(new java.awt.Dimension(sbTabWidth, 32000));
        OptinMenuButtonPanelBottom.setMinimumSize(new java.awt.Dimension(sbTabWidth, sbTabGroupHeight));
        OptinMenuButtonPanelBottom.setPreferredSize(new java.awt.Dimension(sbTabWidth, sbTabGroupHeight));
  
        LeftMenuPanelBottomPanel.setLayout(new java.awt.BorderLayout());
        LeftMenuPanelBottomPanel.setBackground(new java.awt.Color(39, 63, 109));
        LeftMenuPanelBottomPanel.setForeground(new java.awt.Color(255, 255, 255));
        LeftMenuPanelBottomPanel.setMaximumSize(new java.awt.Dimension(sbTabWidth, 100));
        LeftMenuPanelBottomPanel.setMinimumSize(new java.awt.Dimension(sbTabWidth, 100));
        LeftMenuPanelBottomPanel.setPreferredSize(new java.awt.Dimension(sbTabWidth, 100));


        OptinSelectionContentPanel.setLayout(new java.awt.BorderLayout());

        OptinSelectionContentPanel.setBackground(new java.awt.Color(140, 160, 210));
        OptinSelectionContentPanel.setForeground(new java.awt.Color(255, 255, 255));

        OptinContentTopPanel.setLayout(new java.awt.BorderLayout());

        OptinContentTopPanel.setBackground(new java.awt.Color(100, 120, 170));
        OptinContentTopPanel.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        OptinContentTopPanel.setPreferredSize(new java.awt.Dimension(620, 400));
        OptinContentTopPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OptinContentTopPanelMouseClicked(evt);
            }
        });

        OptinCentralContentPanel.setLayout(new java.awt.BorderLayout());

        OptinCentralContentPanel.setBackground(new java.awt.Color(100, 120, 170));
        OptinCentralContentPanel.setMaximumSize(new java.awt.Dimension(2147483647, 120));
        OptinContentPanel.setLayout(new javax.swing.BoxLayout(OptinContentPanel, javax.swing.BoxLayout.Y_AXIS));

        OptinContentPanel.setBackground(new java.awt.Color(100, 120, 170));
        OptinContentPanel.setMaximumSize(new java.awt.Dimension(2147483647, 120));
        OptinContentPanel.setMinimumSize(new java.awt.Dimension(448, 0));
        OptinContentPanel.setPreferredSize(new java.awt.Dimension(600, 120));
        OptinContentPanelItem1.setLayout(new javax.swing.BoxLayout(OptinContentPanelItem1, javax.swing.BoxLayout.Y_AXIS));

        OptinContentPanelItem1.setBackground(new java.awt.Color(100, 120, 170));
        OptinContentPanelItem1.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(140, 171, 240), new java.awt.Color(27, 44, 76)), "E-mail Opt-ins", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12)));
        OptinContentPanelItem1.setMaximumSize(new java.awt.Dimension(2147483647, 60));
        EMailOptinSettingsPanelItem1.setLayout(new java.awt.BorderLayout());

        EMailOptinSettingsPanelItem1.setBackground(new java.awt.Color(100, 120, 170));
        EMailOptinEnabledPanel.setLayout(new java.awt.BorderLayout());

        EMailOptinEnabledPanel.setBackground(new java.awt.Color(100, 120, 170));
        EMailOptinEnabledPanel.setMaximumSize(new java.awt.Dimension(100, 2147483647));

        EMailOptinSettingsPanelItem1.add(EMailOptinEnabledPanel, java.awt.BorderLayout.WEST);

        EMailOptinPanelMainContainer.setLayout(new java.awt.FlowLayout());

        EMailOptinPanelMainContainer.setBackground(new java.awt.Color(100, 120, 170));
        btnEMailOptinFormAutomaticConfiguration.setFont(new java.awt.Font("Arial", 0, 12));
        btnEMailOptinFormAutomaticConfiguration.setText("Automatic Configuration");
        EMailOptinPanelMainContainer.add(btnEMailOptinFormAutomaticConfiguration);

        btnEMailOptinFormPreview.setFont(new java.awt.Font("Arial", 0, 12));
        btnEMailOptinFormPreview.setText("Preview");

        btnEMailOptinFormPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEMailOptinFormPreviewActionPerformed(evt);
            }
        });

        EMailOptinPanelMainContainer.add(btnEMailOptinFormPreview);

        EMailOptinSettingsPanelItem1.add(EMailOptinPanelMainContainer, java.awt.BorderLayout.CENTER);

        OptinContentPanelItem1.add(EMailOptinSettingsPanelItem1);

        OptinSettingsPanelItem7.setLayout(new java.awt.FlowLayout());

        OptinSettingsPanelItem7.setBackground(new java.awt.Color(100, 120, 170));
        OptinContentPanelItem1.add(OptinSettingsPanelItem7);

//        OptinContentPanel.add(OptinContentPanelItem1);

        OptinContentPanelItem2.setLayout(new javax.swing.BoxLayout(OptinContentPanelItem2, javax.swing.BoxLayout.Y_AXIS));

        OptinContentPanelItem2.setBackground(new java.awt.Color(100, 120, 170));
        OptinContentPanelItem2.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(140, 171, 240), new java.awt.Color(27, 44, 76)), "Configuration", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12)));
        OptinContentPanelItem2.setMaximumSize(new java.awt.Dimension(1400, 100));
        OptinContentPanelItem2.setMinimumSize(new java.awt.Dimension(60, 100));
        OptinContentPanelItem2.setPreferredSize(new java.awt.Dimension(600, 100));
        OptinSettingsPanelItem3.setLayout(new java.awt.BorderLayout());

        OptinSettingsPanelItem3.setBackground(new java.awt.Color(100, 120, 170));
        OptinSettingsPanelItem3.setMaximumSize(new java.awt.Dimension(32767, 33));
        OptinTitlePanel2.setBackground(new java.awt.Color(100, 120, 170));
        OptinTitlePanel2.setMaximumSize(new java.awt.Dimension(100, 2147483647));
        lEMailOptinFormActionURL.setBackground(new java.awt.Color(100, 120, 170));
        lEMailOptinFormActionURL.setFont(new java.awt.Font("Arial", 0, 12));
        lEMailOptinFormActionURL.setText("HTML Form Action URL:");
        OptinTitlePanel2.add(lEMailOptinFormActionURL);

        tfEMailOptinFormActionURL.setText("http://...");
        tfEMailOptinFormActionURL.setPreferredSize(new java.awt.Dimension(220, 19));
        OptinTitlePanel2.add(tfEMailOptinFormActionURL);

        OptinSettingsPanelItem3.add(OptinTitlePanel2, java.awt.BorderLayout.WEST);

        OptinTitleRightPanel2.setLayout(new javax.swing.BoxLayout(OptinTitleRightPanel2, javax.swing.BoxLayout.Y_AXIS));

        OptinTitleRightPanel2.setBackground(new java.awt.Color(100, 120, 170));
        OptinSettingsPanelItem3.add(OptinTitleRightPanel2, java.awt.BorderLayout.CENTER);

        OptinContentPanelItem2.add(OptinSettingsPanelItem3);

        OptinSettingsPanelItem4.setLayout(new java.awt.BorderLayout());

        OptinSettingsPanelItem4.setBackground(new java.awt.Color(100, 120, 170));
        OptinSettingsPanelItem4.setMaximumSize(new java.awt.Dimension(32767, 33));
        OptinTitlePanel3.setBackground(new java.awt.Color(100, 120, 170));
        OptinTitlePanel3.setMaximumSize(new java.awt.Dimension(100, 2147483647));
        optinRequestMethodLabel.setBackground(new java.awt.Color(100, 120, 170));
        optinRequestMethodLabel.setFont(new java.awt.Font("Arial", 0, 12));
        optinRequestMethodLabel.setText("HTTP Request Method:");
        OptinTitlePanel3.add(optinRequestMethodLabel);

        optinRadioPostRequestMethod.setBackground(new java.awt.Color(100, 120, 170));
        optinRadioPostRequestMethod.setFont(new java.awt.Font("Arial", 1, 12));
        optinRadioPostRequestMethod.setText("POST");
        optinRadioPostRequestMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optinRadioPostRequestMethodActionPerformed(evt);
            }
        });

        optinRadioGetRequestMethod.setBackground(new java.awt.Color(100, 120, 170));
        optinRadioGetRequestMethod.setFont(new java.awt.Font("Arial", 1, 12));
        optinRadioGetRequestMethod.setSelected(true);
        optinRadioGetRequestMethod.setText("GET");
        optinRadioGetRequestMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optinRadioGetRequestMethodActionPerformed(evt);
            }
        });
        OptinTitlePanel3.add(optinRadioGetRequestMethod);
        OptinTitlePanel3.add(optinRadioPostRequestMethod);

        OptinSettingsPanelItem4.add(OptinTitlePanel3, java.awt.BorderLayout.WEST);

        OptinPrivacyPolicyPanel.setBackground(new java.awt.Color(100, 120, 170));
        OptinPrivacyPolicyPanel.setMaximumSize(new java.awt.Dimension(100, 2147483647));
        cbEnablePrivacyPolicy.setBackground(new java.awt.Color(100, 120, 170));
        cbEnablePrivacyPolicy.setFont(new java.awt.Font("Arial", 0, 12));
        cbEnablePrivacyPolicy.setSelected(true);
        cbEnablePrivacyPolicy.setText("Enable Privacy Policy Support ");
        OptinPrivacyPolicyPanel.add(cbEnablePrivacyPolicy);

        OptinSettingsPanelItem4.add(OptinPrivacyPolicyPanel, java.awt.BorderLayout.CENTER);

        OptinContentPanelItem2.add(OptinSettingsPanelItem4);

        //OptinContentPanel.add(OptinContentPanelItem2);
theEAProperties.setDescriptorPanel(optinEnabledPanel);
OptinContentPanel.add(theEAProperties);

        OptinCentralContentPanel.add(OptinContentPanel, java.awt.BorderLayout.CENTER);

        OptinCentralContentLeftMarginPanel.setBackground(new java.awt.Color(100, 120, 170));
        OptinCentralContentPanel.add(OptinCentralContentLeftMarginPanel, java.awt.BorderLayout.WEST);

        OptinCentralContentRightMarginPanel.setBackground(new java.awt.Color(100, 120, 170));
        OptinCentralContentPanel.add(OptinCentralContentRightMarginPanel, java.awt.BorderLayout.EAST);
        OptinContentTopPanel.add(OptinCentralContentPanel, java.awt.BorderLayout.CENTER);

        add(OptinContentTopPanel, java.awt.BorderLayout.CENTER);
/**********************/
        LeftMenuPanelBottomPanel.add(OptinMenuButtonPanel, java.awt.BorderLayout.NORTH);
        LeftMenuPanelBottomPanel.add(LeftMenuControlAreaPanel, java.awt.BorderLayout.CENTER);
        OptinMenuPanel.add(LeftMenuPanelBottomPanel, java.awt.BorderLayout.CENTER);
        OptinMenuPanel.add(OptinMenuButtonPanelTop, java.awt.BorderLayout.NORTH);
        LeftMenuControlAreaPanel.setBackground(new java.awt.Color(100, 120, 170));
        LeftMenuControlAreaPanel.setForeground(new java.awt.Color(255, 255, 255));
        OptinMenuLeftSpaceFiller.setBackground(new java.awt.Color(100, 120, 170));
        OptinMenuLeftSpaceFiller.setMinimumSize(new java.awt.Dimension(1, 10));
        OptinMenuLeftSpaceFiller.setPreferredSize(new java.awt.Dimension(1, 10));
        OptinMenuPanel.add(OptinMenuLeftSpaceFiller, java.awt.BorderLayout.WEST);
        OptinContentBottomPanel.add(OptinMenuPanel, java.awt.BorderLayout.WEST);
/**********************/
        OptinContentBottomPanel.add(OptinMenuPanel, java.awt.BorderLayout.WEST);
        OptinContentBottomPanel.add(OptinSelectionContentPanel, java.awt.BorderLayout.CENTER);
        //add(OptinContentBottomPanel, java.awt.BorderLayout.SOUTH);

// add header here
	  contentPanel = new JPanel();
        contentPanel.setLayout(new java.awt.BorderLayout());
        contentPanel.add(OptinMenuPanel, java.awt.BorderLayout.WEST);
        contentPanel.add(OptinSelectionContentPanel, java.awt.BorderLayout.CENTER);
	  contentProjectPanel = new ContentAreaHeaderPanel(contentPanel, sbTabWidth, theCurrentMenuColor, sbTabRightInnerBorderColor,sbTabRightOuterBorderColor,theSelectedMenuColor);
	add(contentProjectPanel, java.awt.BorderLayout.SOUTH);

    }//GEN-END:initComponents



    private void btnEMailOptinFormPreviewActionPerformed(java.awt.event.ActionEvent evt) {
	try
	{
                    if(DesignerRuleBuilder.get("optinPreviewAction")!=null)
                    {
                        try
                        {
                            Class.forName(DesignerRuleBuilder.get("optinPreviewAction")).newInstance();
                        }
                        catch(InstantiationException e)
                        {
                            //System.out.println(e);
                        }   
                        catch(IllegalAccessException e)
                        {
                            //System.out.println(e);
                        }                      
                        catch(ClassNotFoundException e)
                        {
                            //System.out.println(e);
                        }       
                    }
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }
    private void optinRadioGetRequestMethodActionPerformed(java.awt.event.ActionEvent evt) {
        optinRadioPostRequestMethod.setSelected(false);
        optinRadioGetRequestMethod.setSelected(true);
    }

    private void optinRadioPostRequestMethodActionPerformed(java.awt.event.ActionEvent evt) {
        optinRadioGetRequestMethod.setSelected(false);
        optinRadioPostRequestMethod.setSelected(true);
    }

    private void OptinMenuLabelActionsButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptinMenuLabelActionsButtonMouseReleased
setMouseReleasedMenuLabel(OptinMenuLabelActionsButton);
    }//GEN-LAST:event_OptinMenuLabelActionsButtonMouseReleased

    private void OptinMenuLabelUIStringsButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptinMenuLabelUIStringsButtonMouseReleased
setMouseReleasedMenuLabel(OptinMenuLabelUIStringsButton);
    }//GEN-LAST:event_OptinMenuLabelUIStringsButtonMouseReleased

    private void OptinMenuLabelHTMLFormInputsButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptinMenuLabelHTMLFormInputsButtonMouseReleased
setMouseReleasedMenuLabel(OptinMenuLabelHTMLFormInputsButton);
    }//GEN-LAST:event_OptinMenuLabelHTMLFormInputsButtonMouseReleased

    private void OptinMenuLabelActionsButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptinMenuLabelActionsButtonMousePressed
setMousePressedMenuLabel(OptinMenuLabelActionsButton);
    }//GEN-LAST:event_OptinMenuLabelActionsButtonMousePressed

    private void OptinMenuLabelUIStringsButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptinMenuLabelUIStringsButtonMousePressed
setMousePressedMenuLabel(OptinMenuLabelUIStringsButton);
    }//GEN-LAST:event_OptinMenuLabelUIStringsButtonMousePressed

    private void OptinMenuLabelHTMLFormInputsButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptinMenuLabelHTMLFormInputsButtonMousePressed
setMousePressedMenuLabel(OptinMenuLabelHTMLFormInputsButton);
    }//GEN-LAST:event_OptinMenuLabelHTMLFormInputsButtonMousePressed

    private void OptinMenuLabelActionsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptinMenuLabelActionsButtonMouseExited
setMouseExitedMenuLabel(OptinMenuLabelActionsButton);
    }//GEN-LAST:event_OptinMenuLabelActionsButtonMouseExited

    private void OptinMenuLabelUIStringsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptinMenuLabelUIStringsButtonMouseExited
setMouseExitedMenuLabel(OptinMenuLabelUIStringsButton);
    }//GEN-LAST:event_OptinMenuLabelUIStringsButtonMouseExited

    private void OptinMenuLabelHTMLFormInputsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptinMenuLabelHTMLFormInputsButtonMouseExited
setMouseExitedMenuLabel(OptinMenuLabelHTMLFormInputsButton);
    }//GEN-LAST:event_OptinMenuLabelHTMLFormInputsButtonMouseExited

    private void OptinMenuLabelActionsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptinMenuLabelActionsButtonMouseEntered
setMouseEnteredMenuLabel(OptinMenuLabelActionsButton);
    }//GEN-LAST:event_OptinMenuLabelActionsButtonMouseEntered

    private void OptinMenuLabelUIStringsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptinMenuLabelUIStringsButtonMouseEntered
setMouseEnteredMenuLabel(OptinMenuLabelUIStringsButton);
    }//GEN-LAST:event_OptinMenuLabelUIStringsButtonMouseEntered

    private void OptinMenuLabelHTMLFormInputsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptinMenuLabelHTMLFormInputsButtonMouseEntered
setMouseEnteredMenuLabel(OptinMenuLabelHTMLFormInputsButton);
    }//GEN-LAST:event_OptinMenuLabelHTMLFormInputsButtonMouseEntered

    private void OptinMenuLabelHTMLFormInputsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptinMenuLabelHTMLFormInputsButtonMouseClicked
        setSelectedMenuItem(OptinMenuLabelHTMLFormInputsButton);
//setContentPanel(new OptinHTMLFormInputsPanel()); 
setHTMLFormInputsPropertyPanel();
    }//GEN-LAST:event_OptinMenuLabelHTMLFormInputsButtonMouseClicked

    private void OptinMenuLabelActionsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptinMenuLabelActionsButtonMouseClicked
        setSelectedMenuItem(OptinMenuLabelActionsButton);        
//setContentPanel(new OptinActionsPanel()); 
	setActionsPropertyPanel();
    }//GEN-LAST:event_OptinMenuLabelActionsButtonMouseClicked

    private void OptinMenuLabelUIStringsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptinMenuLabelUIStringsButtonMouseClicked
        setSelectedMenuItem(OptinMenuLabelUIStringsButton);
       // setContentPanel(new OptinUIStringsPanel()); 
setUserInterfacePropertyPanel();
    }//GEN-LAST:event_OptinMenuLabelUIStringsButtonMouseClicked

    private void OptinContentTopPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptinContentTopPanelMouseClicked
        // Add your handling code here:
    }//GEN-LAST:event_OptinContentTopPanelMouseClicked

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
 private int sbTabWidth = 130;
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

                 /*       try
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
                        }
*/   
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

    private static Object[] getStringArraysFromString(String textArrayString)
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

private String getSidebarComponentID(String compRefID)
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

private void initSidebar()
{
try
{
	Object[] sbUIStrings = getStringArraysFromString(DesignerRuleBuilder.get("sbOptinStrings"));
	Object[] sbUIActions = getStringArraysFromString(DesignerRuleBuilder.get("sbOptinActionPanels"));
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
  
    private static String getStringFromArray(Object[] theArray)
    {
        String currentString = null;
        try
        {
            if(theArray.length!=0)
            {
                currentString = (String)theArray[0];
                for(int i = 1;i<theArray.length;i++)
                {
                    try
                    {
                        currentString = currentString + "," + (String)theArray[i];
                    }
                    catch(NullPointerException e)
                    {
                        if(currentString.endsWith(",")==true)
                        {
                            System.out.println("NullPointerException thrown CurrentString is: " + currentString.substring(0,currentString.lastIndexOf(",")));
                            currentString = currentString.substring(0,currentString.lastIndexOf(","));
                        }
                    }
                }
                return currentString;
            }
        }
        catch(Exception e)
        {
            if(currentString!=null)
            {
                if(currentString.endsWith(",")==false)
                {
                    return currentString;
                }
                else
                {
                    System.out.println("Exception thrown CurrentString is: " + currentString.substring(0,currentString.lastIndexOf(",")));
                    return currentString.substring(0,currentString.lastIndexOf(","));
                }
            }
        }
        return "";
    }

private void setUserInterfacePropertyPanel()
{
	try
	{
	  theEAProperties.setHeaderText("User Interface Strings");
	  theEAProperties.setHeaderTextAndWidth("User Interface Strings", 275, "String Value", 175, "", 0);
	  theEAProperties.setAddButtonVisible(false);
	  theEAProperties.setEditButtonVisible(false);
	  theEAProperties.setRemoveButtonVisible(false);
	  //theEAProperties.setConfigurationWizardButtonVisible(false);
	  theEAProperties.setListDefaults(getUIStringEAListItems());
	  theEAProperties.setSelectedIndex(0);
	  EAListItem eaListItemObj = theEAProperties.getSelectedEAListItem();
	  eaListItemObj.setSelectedMode();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

private void setActionsPropertyPanel()
{
	try
	{
	  theEAProperties.setHeaderText("Action Mappings");
	  theEAProperties.setHeaderTextAndWidth("Action Mappings", 275, "Class Name", 175, "", 0);
	  theEAProperties.setAddButtonVisible(false);
	  theEAProperties.setEditButtonVisible(false);
	  theEAProperties.setRemoveButtonVisible(false);
	  //theEAProperties.setConfigurationWizardButtonVisible(false);
	  theEAProperties.setListDefaults(getActionsEAListItems());
	  theEAProperties.setSelectedIndex(0);
	  EAListItem eaListItemObj = theEAProperties.getSelectedEAListItem();
	  eaListItemObj.setSelectedMode();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

private void setHTMLFormInputsPropertyPanel()
{
	try
	{
	  theEAProperties.setHeaderText("HTML Form Inputs");
	  theEAProperties.setHeaderTextAndWidth("HTML Form Inputs", 275, "Name Attribute", 175, "Name Value", 150);

	  theEAProperties.setAddButtonVisible(true);
	  theEAProperties.setEditButtonVisible(true);
	  theEAProperties.setRemoveButtonVisible(true);
	  //theEAProperties.setConfigurationWizardButtonVisible(true);
	  theEAProperties.setAddButtonText("Add Input");
	  theEAProperties.setRemoveButtonText("Remove Input");
	  theEAProperties.setEditButtonText("Edit Input");
	  theEAProperties.setListDefaults(getDefaultEAListItems());
	  theEAProperties.setSelectedIndex(0);
	  EAListItem eaListItemObj = theEAProperties.getSelectedEAListItem();
	  eaListItemObj.setSelectedMode();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

private int eaPropPanel = 0;
private EAListItem[] getDefaultEAListItems()
{
	eaPropPanel = 0;
        try
        {
            EAListItem eai = new EAListItem(theRowIcon,rowColor);
		EAListItemContent personNameItem = new EAListItemContent(rowColor);
		personNameItem.setLabelText("Person's Name Input Name Attribute: ");
		if(ProjectManager.get("optinInputFullName")!=null)
		{
			personNameItem.setInputText(ProjectManager.get("optinInputFullName"));
		}
            eai.setRowDataPanel(personNameItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai.setListItemIsRemovable(false);
		eai.setValueBoxEnabled(false);

            EAListItem eai2 = new EAListItem(theRowIcon,rowColor);
		EAListItemContent emailNameItem = new EAListItemContent(rowColor);
		emailNameItem.setLabelText("E-mail Address Input Name Attribute: ");
		if(ProjectManager.get("optinInputFullName")!=null)
		{
			emailNameItem.setInputText(ProjectManager.get("optinInputEMailAddress"));
		}
            eai2.setRowDataPanel(emailNameItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai2.setListItemIsRemovable(false);
		eai2.setValueBoxEnabled(false);

		Object[] theObjArray = new Object[0];
		Object[] theObjArrayValues = new Object[0];
		if(ProjectManager.get("optinInputHiddenNames")!=null)
		{
			theObjArray = getStringArraysFromString(ProjectManager.get("optinInputHiddenNames"));
		}
		if(ProjectManager.get("optinInputHiddenValues")!=null)
		{
			theObjArrayValues = getStringArraysFromString(ProjectManager.get("optinInputHiddenValues"));
		}

		try
		{
			Object[] tmpArrayValues = new Object[theObjArrayValues.length];
			for(int i = 0;i<tmpArrayValues.length;i++)
			{
				 tmpArrayValues[i] = getCommaSeparatedStringValues((String)theObjArrayValues[i]);
			}
			theObjArrayValues = tmpArrayValues;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		if(0<theObjArray.length)
		{
			EAListItem[] eaItems = new EAListItem[2 + theObjArray.length];
			eaItems[0] = eai;
			eaItems[1] = eai2;
			for(int i = 0;i<theObjArray.length;i++)
			{
            		EAListItem eaiNext = new EAListItem(theRowIcon,rowColor);
				EAListItemContent inputNameItem = new EAListItemContent(rowColor);
				if(theObjArray[i]!=null)
				{
					if(((String)theObjArray[i]).equalsIgnoreCase("")==false)
					{
						inputNameItem.setInputText((String)theObjArray[i]);
						inputNameItem.setInputValueText((String)theObjArrayValues[i]);
						eaiNext.setRowDataPanel(inputNameItem);
						eaItems[i + 2] = eaiNext;
					}
				}
			}
			return eaItems;
		}
		else
		{
			EAListItem[] tempLIArray = {eai,eai2};
			return tempLIArray;
		}
        }
        catch(Exception e)
        {
          e.printStackTrace();   
        }
	EAListItem[] tempLIArray2 = new EAListItem[0];
	return tempLIArray2;
}
private String[] UIStringArray = new String[15];
private EAListItem[] UIStringEAListItemArray = new EAListItem[15];
private EAListItem[] getUIStringEAListItems()
{
	  eaPropPanel = 1;
        try
        {
		int defUIStringLabelWidth = 250;
		int defUIStringDataWidth = 400;

		EAListItem[] eaItems = new EAListItem[15];
            EAListItem eai = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent titleUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		titleUIStringItem.setLabelText("Title:");
		if(ProjectManager.get("registerSoftwareTitle")!=null)
		{
			titleUIStringItem.setInputText(ProjectManager.get("registerSoftwareTitle"));
			UIStringArray[0] = "registerSoftwareTitle";
		}
            eai.setRowDataPanel(titleUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai.setListItemIsRemovable(false);
		eai.setValueBoxEnabled(false);
		eaItems[0] = eai;
//
            EAListItem eai2 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent shortDescriptionUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		shortDescriptionUIStringItem.setLabelText("Short Description: ");
		if(ProjectManager.get("optinDescription")!=null)
		{
			shortDescriptionUIStringItem.setInputText(ProjectManager.get("optinDescription"));
			UIStringArray[1] = "optinDescription";
		}
            eai2.setRowDataPanel(shortDescriptionUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai2.setListItemIsRemovable(false);
		eai2.setValueBoxEnabled(false);
		eaItems[1] = eai2;
//
            EAListItem eai3 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent yourNameUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		yourNameUIStringItem.setLabelText("Your Name Label:");
		if(ProjectManager.get("optinYourNameLabel")!=null)
		{
			yourNameUIStringItem.setInputText(ProjectManager.get("optinYourNameLabel"));
			UIStringArray[2] = "optinYourNameLabel";
		}
            eai3.setRowDataPanel(yourNameUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai3.setListItemIsRemovable(false);
		eai3.setValueBoxEnabled(false);
		eaItems[2] = eai3;
//
            EAListItem eai4 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent yourEMailUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		yourEMailUIStringItem.setLabelText("Your E-mail Label:");
		if(ProjectManager.get("optinYourEMailLabel")!=null)
		{
			yourEMailUIStringItem.setInputText(ProjectManager.get("optinYourEMailLabel"));
			UIStringArray[3] = "optinYourEMailLabel";
		}
            eai4.setRowDataPanel(yourEMailUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai4.setListItemIsRemovable(false);
		eai4.setValueBoxEnabled(false);
		eaItems[3] = eai4;
//
            EAListItem eai12 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent optinContinueButtonTextUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		optinContinueButtonTextUIStringItem.setLabelText("Continue Button Text:");
		if(ProjectManager.get("optinContinueButtonText")!=null)
		{
			optinContinueButtonTextUIStringItem.setInputText(ProjectManager.get("optinContinueButtonText"));
			UIStringArray[4] = "optinContinueButtonText";
		}
            eai12.setRowDataPanel(optinContinueButtonTextUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai12.setListItemIsRemovable(false);
		eai12.setValueBoxEnabled(false);
		eaItems[4] = eai12;
//
            EAListItem eai13 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent optinContinueButtonMnemonicUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		optinContinueButtonMnemonicUIStringItem.setLabelText("Continue Button Mnemonic:");
		if(ProjectManager.get("optinContinueButtonMnemonic")!=null)
		{
			optinContinueButtonMnemonicUIStringItem.setInputText(ProjectManager.get("optinContinueButtonMnemonic"));
			UIStringArray[5] = "optinContinueButtonMnemonic";
		}
            eai13.setRowDataPanel(optinContinueButtonMnemonicUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai13.setListItemIsRemovable(false);
		eai13.setValueBoxEnabled(false);
		eaItems[5] = eai13;
//
            EAListItem eai10 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent optinCancelButtonTextUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		optinCancelButtonTextUIStringItem.setLabelText("Cancel Button Text:");
		if(ProjectManager.get("optinCancelButtonText")!=null)
		{
			optinCancelButtonTextUIStringItem.setInputText(ProjectManager.get("optinCancelButtonText"));
			UIStringArray[6] = "optinCancelButtonText";
		}
            eai10.setRowDataPanel(optinCancelButtonTextUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai10.setListItemIsRemovable(false);
		eai10.setValueBoxEnabled(false);
		eaItems[6] = eai10;
//
            EAListItem eai11 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent optinCancelButtonMnemonicUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		optinCancelButtonMnemonicUIStringItem.setLabelText("Cancel Button Mnemonic:");
		if(ProjectManager.get("optinCancelButtonMnemonic")!=null)
		{
			optinCancelButtonMnemonicUIStringItem.setInputText(ProjectManager.get("optinCancelButtonMnemonic"));
			UIStringArray[7] = "optinCancelButtonMnemonic";
		}
            eai11.setRowDataPanel(optinCancelButtonMnemonicUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai11.setListItemIsRemovable(false);
		eai11.setValueBoxEnabled(false);
		eaItems[7] = eai11;
//
            EAListItem eai6 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent privacyPolicyLabelUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		privacyPolicyLabelUIStringItem.setLabelText("Privacy Policy Label: ");
		if(ProjectManager.get("optinPrivacyPolicyLabel")!=null)
		{
			privacyPolicyLabelUIStringItem.setInputText(ProjectManager.get("optinPrivacyPolicyLabel"));
			UIStringArray[8] = "optinPrivacyPolicyLabel";
		}
            eai6.setRowDataPanel(privacyPolicyLabelUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai6.setListItemIsRemovable(false);
		eai6.setValueBoxEnabled(false);
		eaItems[8] = eai6;
//
            EAListItem eai14 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent optinPrivacyPolicyMnemonicUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		optinPrivacyPolicyMnemonicUIStringItem.setLabelText("Privacy Policy Label Mnemonic:");
		if(ProjectManager.get("optinPrivacyPolicyMnemonic")!=null)
		{
			optinPrivacyPolicyMnemonicUIStringItem.setInputText(ProjectManager.get("optinPrivacyPolicyMnemonic"));
			UIStringArray[9] = "optinPrivacyPolicyMnemonic";
		}
            eai14.setRowDataPanel(optinPrivacyPolicyMnemonicUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai14.setListItemIsRemovable(false);
		eai14.setValueBoxEnabled(false);
		eaItems[9] = eai14;
//
            EAListItem eai15 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent optinEnterNameMessageUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		optinEnterNameMessageUIStringItem.setLabelText("Enter Name Message:");
		if(ProjectManager.get("optinEnterNameMessage")!=null)
		{
			optinEnterNameMessageUIStringItem.setInputText(ProjectManager.get("optinEnterNameMessage"));
			UIStringArray[10] = "optinEnterNameMessage";
		}
            eai15.setRowDataPanel(optinEnterNameMessageUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai15.setListItemIsRemovable(false);
		eai15.setValueBoxEnabled(false);
		eaItems[10] = eai15;
//
            EAListItem eai16 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent optinEnterValidEMailMessageUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		optinEnterValidEMailMessageUIStringItem.setLabelText("Enter Valid E-mail Address Message:");
		if(ProjectManager.get("optinEnterValidEMailMessage")!=null)
		{
			optinEnterValidEMailMessageUIStringItem.setInputText(ProjectManager.get("optinEnterValidEMailMessage"));
			UIStringArray[11] = "optinEnterValidEMailMessage";
		}
            eai16.setRowDataPanel(optinEnterValidEMailMessageUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai16.setListItemIsRemovable(false);
		eai16.setValueBoxEnabled(false);
		eaItems[11] = eai16;
//
            EAListItem eai17 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent optinEnterEMailMessageUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		optinEnterEMailMessageUIStringItem.setLabelText("Enter E-mail Address Message:");
		if(ProjectManager.get("optinEnterEMailMessage")!=null)
		{
			optinEnterEMailMessageUIStringItem.setInputText(ProjectManager.get("optinEnterEMailMessage"));
			UIStringArray[12] = "optinEnterEMailMessage";
		}
            eai17.setRowDataPanel(optinEnterEMailMessageUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai17.setListItemIsRemovable(false);
		eai17.setValueBoxEnabled(false);
		eaItems[12] = eai17;
//
            EAListItem eai5 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent privacyPolicyTitleUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		privacyPolicyTitleUIStringItem.setLabelText("Privacy Policy Title: ");
		if(ProjectManager.get("privacyPolicyTitle")!=null)
		{
			privacyPolicyTitleUIStringItem.setInputText(ProjectManager.get("privacyPolicyTitle"));
			UIStringArray[13] = "privacyPolicyTitle";
		}
            eai5.setRowDataPanel(privacyPolicyTitleUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai5.setListItemIsRemovable(false);
		eai5.setValueBoxEnabled(false);
		eaItems[13] = eai5;
//
            EAListItem eai7 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent privacyPolicyUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		privacyPolicyUIStringItem.setLabelText("Privacy Policy: ");
		//if(ProjectManager.get("privacyPolicy")!=null)
		//{
		UIStringArray[14] = "privacyPolicy";
		privacyPolicyUIStringItem.setInputTextColor(Color.blue);
		privacyPolicyUIStringItem.setInputText("(Select the Privacy Policy item to View, or Edit the Privacy Policy below.)");
		privacyPolicyUIStringItem.setInputTextColor(Color.blue);

		//}
            eai7.setRowDataPanel(privacyPolicyUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai7.setListItemIsRemovable(false);
		eai7.setValueBoxEnabled(false);
		eaItems[14] = eai7;

		UIStringEAListItemArray = eaItems;
		return eaItems;
        }
        catch(Exception e)
        {
          e.printStackTrace();   
        }
	EAListItem[] tempLIArray2 = new EAListItem[0];
	UIStringEAListItemArray = tempLIArray2;
	return tempLIArray2;
}

private String[] strActionsArray = new String[5];
private EAListItem[] ActionsEAListItemArray = new EAListItem[5];
private EAListItem[] getActionsEAListItems()
{
	  eaPropPanel = 2;
        try
        {
		int defActionLabelWidth = 250;
		int defActionDataWidth = 400;

		EAListItem[] eaItems = new EAListItem[5];
            EAListItem eai3 = new EAListItem(theActionRowIcon,rowColor);
		EAListItemContent privacyPolicyActionType = new EAListItemContent(rowColor, defActionLabelWidth, defActionDataWidth, false, true);
		privacyPolicyActionType.setLabelText("Load Privacy Policy GUI Action Type:");
		if(ProjectManager.get("privacyPolicyActionType")!=null)
		{
			try
			{
				privacyPolicyActionType.setComboBoxEnabled(true);				
				privacyPolicyActionType.setComboBoxIndex(new Integer(ProjectManager.get("privacyPolicyActionType")).intValue() + 1);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				privacyPolicyActionType.setComboBoxEnabled(true);
				privacyPolicyActionType.setComboBoxIndex(0);
			}
			strActionsArray[0] = "privacyPolicyActionType";
		}
            eai3.setRowDataPanel(privacyPolicyActionType);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai3.setListItemIsRemovable(false);
		eai3.setValueBoxEnabled(false);	
	      eai3.getJComboBoxControl().addItemListener(new java.awt.event.ItemListener() 
		{
            	public void itemStateChanged(java.awt.event.ItemEvent evt) 
			{
                		cbPrivacyPolicyActionTypeActionPerformed(evt);
            	}
        	});

		eaItems[0] = eai3;
//
            EAListItem eai5 = new EAListItem(theActionRowIcon,rowColor);
		EAListItemContent loadPrivacyPolicyGUIActionItem = new EAListItemContent(rowColor, defActionLabelWidth, defActionDataWidth);
		loadPrivacyPolicyGUIActionItem.setLabelText("Load Privacy Policy GUI Action:");
		if(ProjectManager.get("privacyPolicyAction")!=null)
		{
			loadPrivacyPolicyGUIActionItem.setInputText(ProjectManager.get("privacyPolicyAction"));
			strActionsArray[1] = "privacyPolicyAction";
		}
            eai5.setRowDataPanel(loadPrivacyPolicyGUIActionItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai5.setListItemIsRemovable(false);
		eai5.setValueBoxEnabled(true);
		eaItems[1] = eai5;
//
            EAListItem eai = new EAListItem(theActionRowIcon,rowColor);
		EAListItemContent cancelActionItem = new EAListItemContent(rowColor, defActionLabelWidth, defActionDataWidth);
		cancelActionItem.setLabelText("Cancel Action: ");
		if(ProjectManager.get("optinCancelAction")!=null)
		{
			cancelActionItem.setInputText(ProjectManager.get("optinCancelAction"));
			strActionsArray[2] = "optinCancelAction";
		}
            eai.setRowDataPanel(cancelActionItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai.setListItemIsRemovable(false);
		eai.setValueBoxEnabled(false);
		eaItems[2] = eai;
//
            EAListItem eai2 = new EAListItem(theActionRowIcon,rowColor);
		EAListItemContent continueActionItem = new EAListItemContent(rowColor, defActionLabelWidth, defActionDataWidth);
		continueActionItem.setLabelText("Continue Action: ");
		if(ProjectManager.get("optinContinueAction")!=null)
		{
			continueActionItem.setInputText(ProjectManager.get("optinContinueAction"));
			strActionsArray[3] = "optinContinueAction";
		}
            eai2.setRowDataPanel(continueActionItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai2.setListItemIsRemovable(false);
		eai2.setValueBoxEnabled(false);
		eaItems[3] = eai2;
//
            EAListItem eai4 = new EAListItem(theActionRowIcon,rowColor);
		EAListItemContent loadOptinGUIActionItem = new EAListItemContent(rowColor, defActionLabelWidth, defActionDataWidth);
		loadOptinGUIActionItem.setLabelText("Load Opt-In GUI Action: ");
		if(ProjectManager.get("showOptinUIAction")!=null)
		{
			loadOptinGUIActionItem.setInputText(ProjectManager.get("showOptinUIAction"));
			strActionsArray[4] = "showOptinUIAction";
		}
            eai4.setRowDataPanel(loadOptinGUIActionItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai4.setListItemIsRemovable(false);
		eai4.setValueBoxEnabled(false);
		eaItems[4] = eai4;

		ActionsEAListItemArray = eaItems;
		return eaItems;
        }
        catch(Exception e)
        {
          e.printStackTrace();   
        }
	EAListItem[] tempLIArray2 = new EAListItem[0];
	ActionsEAListItemArray = tempLIArray2;
	return tempLIArray2;
}
 
    private void cbPrivacyPolicyActionTypeActionPerformed(java.awt.event.ItemEvent evt)
    {
///////////////////
try
{
	if((ActionsEAListItemArray[0].getJComboBoxControl().getSelectedIndex())==-1)
	{

	}
	else if((ActionsEAListItemArray[0].getJComboBoxControl().getSelectedIndex())==0)
	{
		ProjectManager.put("privacyPolicyActionType","-1");
	}
	else if((ActionsEAListItemArray[0].getJComboBoxControl().getSelectedIndex())==1)
	{
		ProjectManager.put("privacyPolicyActionType","0");
		if(ProjectManager.get("privacyPolicyAction")!=null)
		{
		if(ProjectManager.get("privacyPolicyAction").equalsIgnoreCase("")==true)
		{
            	if(ProjectManager.get("product_url")!=null)
                  {
                  	if(ProjectManager.get("product_url").equalsIgnoreCase("")==true)
                        {
                        	ProjectManager.put("privacyPolicyAction","http://www.evaluateanywhere.com");
                        }
                        else
                        {
                              ProjectManager.put("privacyPolicyAction",ProjectManager.get("product_url"));
                        }
                  }
                  else
                  {
                        ProjectManager.put("privacyPolicyAction","http://www.evaluateanywhere.com");
                  }
             }
             else
             {
             	try
                  {
                  	new URL(ProjectManager.get("privacyPolicyAction"));
                  }
                  catch(MalformedURLException e)
                  {
            	if(ProjectManager.get("product_url")!=null)
                  {
                  	if(ProjectManager.get("product_url").equalsIgnoreCase("")==true)
                        {
                        	ProjectManager.put("privacyPolicyAction","http://www.evaluateanywhere.com");
                        }
                        else
                        {
                              ProjectManager.put("privacyPolicyAction",ProjectManager.get("product_url"));
                        }
                  }
                  else
                  {
                        ProjectManager.put("privacyPolicyAction","http://www.evaluateanywhere.com");
                  }                   
                  }
            } 
		}

	}
	else if((ActionsEAListItemArray[0].getJComboBoxControl().getSelectedIndex())==2)
	{
		ProjectManager.put("privacyPolicyActionType","1");
		ProjectManager.put("privacyPolicyAction","com.trinity.ea.actions.PrivacyPolicyAction");
	}
	if(ProjectManager.get("privacyPolicyActionType").equalsIgnoreCase("0")==true)
	{
		DataContentPanel tempPanel = new DataContentPanel("The Privacy Policy Web Action Mapping is defined below");
		if(ProjectManager.get("privacyPolicyAction")!=null)
		{
			tempPanel.setContentPanel(new TextFieldPanel(ActionsEAListItemArray[1].getRowDataPanel().getLabelText(), ProjectManager.get("privacyPolicyAction"), strActionsArray[1], true));
		}
		else
		{		
			tempPanel.setContentPanel(new TextFieldPanel(ActionsEAListItemArray[1].getRowDataPanel().getLabelText(), ProjectManager.get("privacyPolicyAction"), strActionsArray[1], true));
		}
		setContentPanel(tempPanel);
	}
	else
	{
		DataContentPanel tempPanel = new DataContentPanel("The Privacy Policy Action Mapping is defined below");
		tempPanel.setContentPanel(new TextFieldPanel(ActionsEAListItemArray[1].getRowDataPanel().getLabelText(), ProjectManager.get("privacyPolicyAction"), strActionsArray[1], false));
		setContentPanel(tempPanel);
	}

	setActionsPropertyPanel();
      }
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

   public void getFireConfigurationWizardAction()
   {
	try
	{        
		OptinWizard theOptinWizard = new OptinWizard(0);
		theOptinWizard.setMasterControlPanel(this);
		theOptinWizard.hideDesigner();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
   }

   public void getFireConfigurationWizardActionNoHide()
   {
	try
	{        
		OptinWizard theOptinWizard = new OptinWizard(0);
		theOptinWizard.setMasterControlPanel(this);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
   }

   public void setFinishConfigurationAction()
   {
	setProjectData();
	setDataContentPanelProjectData();
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EMailOptinEnabledPanel;
    private javax.swing.JPanel EMailOptinPanelMainContainer;
    private javax.swing.JPanel EMailOptinSettingsPanelItem1;
    private javax.swing.JPanel OptinCentralContentLeftMarginPanel;
    private javax.swing.JPanel OptinCentralContentPanel;
    private javax.swing.JPanel OptinCentralContentRightMarginPanel;
    private javax.swing.JPanel OptinContentBottomPanel;
    private javax.swing.JPanel OptinContentPanel;
    private javax.swing.JPanel OptinContentPanelItem1;
    private javax.swing.JPanel OptinContentPanelItem2;
    private javax.swing.JPanel OptinContentTopPanel;
    private javax.swing.JPanel OptinMenuButtonPanel;
    private javax.swing.JPanel OptinMenuButtonPanelBottom;
    private SBTab OptinMenuButtonPanelTop;
    private SBTab OptinMenuLabelActionsButton;
    private SBTab OptinMenuLabelHTMLFormInputsButton;
    private SBTab OptinMenuLabelUIStringsButton;
    private javax.swing.JPanel LeftMenuPanelBottomPanel;
    private javax.swing.JPanel OptinMenuLeftSpaceFiller;
    private javax.swing.JPanel OptinMenuPanel;
    private javax.swing.JPanel OptinPrivacyPolicyPanel;
    private javax.swing.JPanel OptinSelectionContentPanel;
    private javax.swing.JPanel OptinSettingsPanelItem3;
    private javax.swing.JPanel OptinSettingsPanelItem4;
    private javax.swing.JPanel OptinSettingsPanelItem7;
    private javax.swing.JPanel OptinTitlePanel2;
    private javax.swing.JPanel OptinTitlePanel3;
    private javax.swing.JPanel OptinTitleRightPanel2;
    private javax.swing.JPanel BottomFillerPanel;
    private SBSpacer LeftMenuControlAreaPanel;
    private javax.swing.JButton btnEMailOptinFormAutomaticConfiguration;
    private javax.swing.JButton btnEMailOptinFormPreview;
    private javax.swing.ButtonGroup btnGroupOptinRequestMethod;
    private javax.swing.JCheckBox cbEnablePrivacyPolicy;
    private javax.swing.JLabel lEMailOptinFormActionURL;
    private javax.swing.JRadioButton optinRadioGetRequestMethod;
    private javax.swing.JRadioButton optinRadioPostRequestMethod;
    private javax.swing.JLabel optinRequestMethodLabel;
    private javax.swing.JTextField tfEMailOptinFormActionURL;
    private ContentAreaHeaderPanel contentProjectPanel;
    private javax.swing.JPanel contentPanel;
    private EAPropertiesPanel theEAProperties;
    private OptinEnabledControl optinEnabledPanel;
    // End of variables declaration//GEN-END:variables
    
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
		if(eaPropPanel!=0)
		{
	 	//Possibly where to fix display updates on the panel
		EAListItem eaListItemObj = theEAProperties.getSelectedEAListItem();
		EAListItemContent theContent = eaListItemObj.getRowDataPanel();
		if(eaPropPanel==1)
		{
			if(theLastSelectedIndex!=-1)
			{
				if(theLastSelectedIndex!=14)
				{
					try
					{
						theEAProperties.getSelectedEAListItem().getRowDataPanel().setInputText(ProjectManager.get(UIStringArray[theLastSelectedIndex]));
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}

			//UI Strings Panel Selected
			//UIStringArray
			if(theEAProperties.getSelectedIndex()!=14)
			{
				//Is not the Privacy Policy
				DataContentPanel tempPanel = new DataContentPanel("The E-mail Opt-In User Interface String is defined below");
				tempPanel.setContentPanel(new TextFieldPanel(UIStringEAListItemArray[theEAProperties.getSelectedIndex()].getRowDataPanel().getLabelText(), ProjectManager.get(UIStringArray[theEAProperties.getSelectedIndex()]), UIStringArray[theEAProperties.getSelectedIndex()], true));
				setContentPanel(tempPanel);
			}
			else
			{
				//Is the Privacy Policy 
				DataContentPanel tempPanel = new DataContentPanel("The E-mail Opt-In User Interface String is defined below");
				tempPanel.setContentPanel(new TextPanePanel(UIStringEAListItemArray[theEAProperties.getSelectedIndex()].getRowDataPanel().getLabelText(), ProjectManager.get(UIStringArray[theEAProperties.getSelectedIndex()]), UIStringArray[theEAProperties.getSelectedIndex()], true));
				setContentPanel(tempPanel);
			}
		}
		else if(eaPropPanel==2)
		{
			if(theLastSelectedIndex!=-1)
			{
				if(theEAProperties.getSelectedIndex()!=0&&theEAProperties.getSelectedIndex()!=1)
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
			}
			//Action Panel Selected
			//strActionsArray
				if(theEAProperties.getSelectedIndex()!=0&&theEAProperties.getSelectedIndex()!=1)
				{
					DataContentPanel tempPanel = new DataContentPanel("The E-mail Opt-In Action Mapping is defined below");
					tempPanel.setContentPanel(new TextFieldPanel(ActionsEAListItemArray[theEAProperties.getSelectedIndex()].getRowDataPanel().getLabelText(), ProjectManager.get(strActionsArray[theEAProperties.getSelectedIndex()]), strActionsArray[theEAProperties.getSelectedIndex()], false));
					setContentPanel(tempPanel);
				}
				else if(theEAProperties.getSelectedIndex()==1)
				{
					if(ProjectManager.get("privacyPolicyActionType").equalsIgnoreCase("0")==true)
					{
						DataContentPanel tempPanel = new DataContentPanel("The Privacy Policy Web Action Mapping is defined below");
						tempPanel.setContentPanel(new TextFieldPanel(ActionsEAListItemArray[theEAProperties.getSelectedIndex()].getRowDataPanel().getLabelText(), ProjectManager.get(strActionsArray[theEAProperties.getSelectedIndex()]), strActionsArray[theEAProperties.getSelectedIndex()], true));
						setContentPanel(tempPanel);
					}
					else
					{
						DataContentPanel tempPanel = new DataContentPanel("The Privacy Policy Action Mapping is defined below");
						tempPanel.setContentPanel(new TextFieldPanel(ActionsEAListItemArray[theEAProperties.getSelectedIndex()].getRowDataPanel().getLabelText(), ProjectManager.get(strActionsArray[theEAProperties.getSelectedIndex()]), strActionsArray[theEAProperties.getSelectedIndex()], false));
						setContentPanel(tempPanel);
					}
				}
				else if(theEAProperties.getSelectedIndex()==0)
				{
					if(ProjectManager.get("privacyPolicyActionType").equalsIgnoreCase("0")==true)
					{
						DataContentPanel tempPanel = new DataContentPanel("The Privacy Policy Web Action Mapping is defined below");
						if(ProjectManager.get("privacyPolicyAction")!=null)
						{
							tempPanel.setContentPanel(new TextFieldPanel(ActionsEAListItemArray[theEAProperties.getSelectedIndex() + 1].getRowDataPanel().getLabelText(), ProjectManager.get("privacyPolicyAction"), strActionsArray[theEAProperties.getSelectedIndex() + 1], true));
						}
						else
						{		
							tempPanel.setContentPanel(new TextFieldPanel(ActionsEAListItemArray[theEAProperties.getSelectedIndex() + 1].getRowDataPanel().getLabelText(), ProjectManager.get(strActionsArray[theEAProperties.getSelectedIndex() + 1]), strActionsArray[theEAProperties.getSelectedIndex() + 1], true));
						}
						setContentPanel(tempPanel);
					}
					else
					{
						DataContentPanel tempPanel = new DataContentPanel("The Privacy Policy Action Mapping is defined below");
						tempPanel.setContentPanel(new TextFieldPanel(ActionsEAListItemArray[theEAProperties.getSelectedIndex() + 1].getRowDataPanel().getLabelText(), ProjectManager.get(strActionsArray[theEAProperties.getSelectedIndex() + 1]), strActionsArray[theEAProperties.getSelectedIndex() + 1], false));
						setContentPanel(tempPanel);
					}
				}
		}
		}
		else
		{
			//HTML Form Panel Selected
			DataContentPanel tempPanel = new DataContentPanel("Configuration");
			OptinHTMLFormInputsPanel oiip = new OptinHTMLFormInputsPanel();
			oiip.setMasterStatusController(this);
			tempPanel.setContentPanel(oiip);
			setContentPanel(tempPanel);
		}
		
    }

    private synchronized void setCheckLoadProjectFirstTime()
    {
	 try
	 {
		if(ProjectManager.get("project_optin_is_new")!=null)
	 	{
			if(ProjectManager.get("project_optin_is_new").equalsIgnoreCase("true")==true)
			{
				getFireConfigurationWizardActionNoHide();
				ProjectManager.put("project_optin_is_new","false");
			}
		}
	  }
	  catch(Exception e)
	  {
		e.printStackTrace();
	  }
    }

    private String getCommaSeparatedStringValues(String strToUpdate)
    {
	 return strToUpdate.replaceAll(":::",",");
    }
}
