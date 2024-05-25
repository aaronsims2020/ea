/*
 * EADesignerPaymentsPanel.java
 *
 * Created on December 13, 2003, 1:17 AM
 */

package com.trinity.ea.design.payments;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.common.panel.EAMasterControlPanel;
import com.trinity.ea.design.common.panel.EAPropertiesPanel;
import com.trinity.ea.design.common.panel.EAListItem;
import com.trinity.ea.design.common.panel.EAListItemContent;
import com.trinity.ea.design.common.panel.DataContentPanelFourthTier;
import com.trinity.ea.design.common.panel.TextFieldPanelFourthTier;
import com.trinity.ea.design.common.panel.TextPanePanelFourthTier;
import com.trinity.ea.design.common.panel.DataContentPanel;
import com.trinity.ea.design.common.panel.TextFieldPanel;
import com.trinity.ea.design.common.panel.TextPanePanel;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.common.borderline.ContentAreaHeaderPanel;
//import com.trinity.ea.design.common.status.ProgressWindow;
import com.trinity.ea.design.payments.options.PaymentOptionsPanel;
import com.trinity.ea.design.payments.inputs.PaymentsHTMLFormInputsPanel;
import com.trinity.ea.design.payments.inputs.PaymentHTMLFormInputsConfigurationPanel;
import com.trinity.ea.design.payments.uistrings.PaymentsUserInterfacePanel;
import com.trinity.ea.design.payments.actions.PaymentsActionsPanel;
import com.trinity.ea.design.payments.provider.PaymentsWizard;
import com.trinity.ea.design.common.sidebar.SBTab;
import com.trinity.ea.design.common.sidebar.SBSpacer;
import com.trinity.ea.design.rules.builder.DesignerRuleBuilder;
import java.util.HashMap;
import java.util.Collections;
import java.util.Map;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.net.MalformedURLException;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class EADesignerPaymentsPanel extends EAMasterControlPanel {
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
    public EADesignerPaymentsPanel() {
   
     	//ProgressWindow progWindow = new ProgressWindow();
	//try
	//{
	//  progWindow.showStatus("Launching Payments Designer", 1);
        initComponents();
	  initSidebar();
        setSelectedMenuItem(lPaymentsPropertiesMenuItem);
	  setConfigurationPropertyPanel();
	//  progWindow.close();
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
       PaymentsSelectionContentPanel.remove(TheContentPanelReference);        
       TheContentPanelReference = theContentPanel;
	 PaymentsSelectionContentPanel.setPreferredSize(new java.awt.Dimension(620, 275));
       PaymentsSelectionContentPanel.add(TheContentPanelReference);     
       TheContentPanelReference.setVisible(true);

    }
    catch(Exception e)
    {
        System.out.println(e);
    }
  }     

public void setProjectData()
{
        try
        {
		if(eaPropPanel==0)
		{
			//setConfigurationPropertyPanel();
	  		theEAProperties.setListDefaults(getPropertiesEAListItems());

			//Properties Panel Selected
			//strPropertiesArray
			try
			{
				DataContentPanel tempPanel = new DataContentPanel("The Payment Property is defined below");
				tempPanel.setContentPanel(new TextFieldPanel(PropertiesEAListItemArray[0].getRowDataPanel().getLabelText(), ProjectManager.get(strPropertiesArray[0]), strPropertiesArray[0], true));
       TheContentPanelReference.setVisible(false);
       PaymentsSelectionContentPanel.remove(TheContentPanelReference);        
       TheContentPanelReference = tempPanel;
	 PaymentsSelectionContentPanel.setPreferredSize(new java.awt.Dimension(620, 275));
       PaymentsSelectionContentPanel.add(TheContentPanelReference);     
       TheContentPanelReference.setVisible(true);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			//setDataContentPanelProjectData();
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
		// Payment Support Functionality Checkbox Enabled/Disabled
		registrationEnabledPanel.getDataUpdate();
		if(eaPropPanel == 5)
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
								ProjectManager.putTempNoFileWrite("inputNameFirstName", theStrArray[0]);
							}
							else if(i==1)
							{
								ProjectManager.putTempNoFileWrite("inputNameLastName", theStrArray[0]);
							}
							else if(i==2)
							{
								ProjectManager.putTempNoFileWrite("inputNameAddress", theStrArray[0]);
							}
							else if(i==3)
							{
								ProjectManager.putTempNoFileWrite("inputNameCity", theStrArray[0]);
							}
							else if(i==4)
							{
								ProjectManager.putTempNoFileWrite("inputNameState", theStrArray[0]);
							}
							else if(i==5)
							{
								ProjectManager.putTempNoFileWrite("inputNameZip", theStrArray[0]);
							}
							else if(i==6)
							{
								ProjectManager.putTempNoFileWrite("inputNameCountry", theStrArray[0]);
							}
							else if(i==7)
							{
								ProjectManager.putTempNoFileWrite("inputNameEMail", theStrArray[0]);
							}
							else if(i==8)
							{
								ProjectManager.putTempNoFileWrite("inputNamePaymentMethod", theStrArray[0]);
							}
							else if(i==9)
							{
								ProjectManager.putTempNoFileWrite("inputNameCC1", theStrArray[0]);
							}
							else if(i==10)
							{
								ProjectManager.putTempNoFileWrite("inputNameCC2", theStrArray[0]);
							}
							else if(i==11)
							{
								ProjectManager.putTempNoFileWrite("inputNameCC3", theStrArray[0]);
							}
							else if(i==12)
							{
								ProjectManager.putTempNoFileWrite("inputNameCC4", theStrArray[0]);
							}
							else if(i==13)
							{
								ProjectManager.putTempNoFileWrite("inputNameVerificationCode", theStrArray[0]);
							}
							else if(i==14)
							{
								ProjectManager.putTempNoFileWrite("inputNameExpirationMonth", theStrArray[0]);
							}
							else if(i==15)
							{
								ProjectManager.putTempNoFileWrite("inputNameExpirationYear", theStrArray[0]);
							}
							else if(i==16)
							{
								ProjectManager.putTempNoFileWrite("inputNameMerchant", theStrArray[0]);
							}
							else if(i==17)
							{
								ProjectManager.putTempNoFileWrite("inputNameOrderID", theStrArray[0]);
							}
							else if(i==18)
							{
								ProjectManager.putTempNoFileWrite("inputNameNameOnCard", theStrArray[0]);
							}
							else if(i==19)
							{
								ProjectManager.putTempNoFileWrite("inputNameResponseURL", theStrArray[0]);
							}
							else if(i==20)
							{
								ProjectManager.putTempNoFileWrite("inputNameTotal", theStrArray[0]);
							}
							else if(i==21)
							{
								ProjectManager.putTempNoFileWrite("inputNamePhone", theStrArray[0]);
							}
							else if(i==22)
							{
								ProjectManager.putTempNoFileWrite("paymentPhoneInputEnabled", theStrArray[0]);
							}
							else if(i==23)
							{
								ProjectManager.putTempNoFileWrite("paymentCCIsSingleInputEnabled", theStrArray[0]);
							}
							else if(i==24)
							{
								ProjectManager.putTempNoFileWrite("paymentSeparateFirstAndLastNameInputsEnabled", theStrArray[0]);
							}
							else if(i==25)
							{
								ProjectManager.putTempNoFileWrite("paymentFullNameInputEnabled", theStrArray[0]);
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
				ProjectManager.putTempNoFileWrite("paymentInputHiddenNames",getStringFromArray(theNamesList.toArray()));
				ProjectManager.putTempNoFileWrite("paymentInputHiddenValues",getStringFromArray(theValuesList.toArray()));
			}
		}
		}
		else if(eaPropPanel == 6)
		{
		EAListItem[] theItems = theEAProperties.getEAListItems();
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
								ProjectManager.putTempNoFileWrite("respInputAuthResponse", theStrArray[0]);
							}
							else if(i==1)
							{
								ProjectManager.putTempNoFileWrite("respInputEmail", theStrArray[0]);
							}
							else if(i==2)
							{
								ProjectManager.putTempNoFileWrite("respInputTotal", theStrArray[0]);
							}
							else if(i==3)
							{
								ProjectManager.putTempNoFileWrite("respInputOrderID", theStrArray[0]);
							}
							else if(i==4)
							{
								ProjectManager.putTempNoFileWrite("respInputNameonCard", theStrArray[0]);
							}
							else if(i==5)
							{
								ProjectManager.putTempNoFileWrite("respInputCardStreet", theStrArray[0]);
							}
							else if(i==6)
							{
								ProjectManager.putTempNoFileWrite("respInputCardCity", theStrArray[0]);
							}
							else if(i==7)
							{
								ProjectManager.putTempNoFileWrite("respInputCardState", theStrArray[0]);
							}
							else if(i==8)
							{
								ProjectManager.putTempNoFileWrite("respInputCardZip", theStrArray[0]);
							}
							else if(i==9)
							{
								ProjectManager.putTempNoFileWrite("respInputCardCountry", theStrArray[0]);
							}
							else if(i==10)
							{
								ProjectManager.putTempNoFileWrite("respInputCardnumber", theStrArray[0]);
							}
							else if(i==11)
							{
								ProjectManager.putTempNoFileWrite("respInputCardName", theStrArray[0]);
							}
							else if(i==12)
							{
								ProjectManager.putTempNoFileWrite("paymentResponseInputStatusSuccess", theStrArray[0]);
							}
						}
				}
				int prevTotalMessages = 0;
				if(ProjectManager.get("paymentResponseStatTotalMessages")!=null)
				{
					if(ProjectManager.get("paymentResponseStatTotalMessages").equalsIgnoreCase("")==false)
					{
						prevTotalMessages = Integer.valueOf(ProjectManager.get("paymentResponseStatTotalMessages")).intValue();						
					}
				}
				int totalMessages = theItems.length - 13;
				if(prevTotalMessages!=totalMessages)
				{
					for(int i = 0;i<prevTotalMessages;i++)
					{
						ProjectManager.remove("paymentResponseStatDeclined" + String.valueOf(i + 1));
						ProjectManager.remove("paymentResponseMsgDeclined" + String.valueOf(i + 1));
					}
				}
				ProjectManager.putTempNoFileWrite("paymentResponseStatTotalMessages", String.valueOf(totalMessages));
				if(totalMessages!=0)
				{
					for(int j = 13;j<theItems.length;j++)
					{
						String[] theStrArray = theItems[j].getDataArray();
						if(1<theStrArray.length)
						{
							ProjectManager.putTempNoFileWrite("paymentResponseStatDeclined" + String.valueOf((j - 13) + 1), theStrArray[0]);
							if(ProjectManager.get("paymentResponseMsgDeclined" + String.valueOf((j - 13) + 1))!=null)
							{
							}
							else
							{
								ProjectManager.putTempNoFileWrite("paymentResponseMsgDeclined" + String.valueOf((j - 13) + 1), "");
							}
						}
						else
						{
							ProjectManager.putTempNoFileWrite("paymentResponseStatDeclined" + String.valueOf((j - 13) + 1), "");
							if(ProjectManager.get("paymentResponseMsgDeclined" + String.valueOf((j - 13) + 1))!=null)
							{
							}
							else
							{
								ProjectManager.putTempNoFileWrite("paymentResponseMsgDeclined" + String.valueOf((j - 13) + 1), "");
							}
						}
					}
				}
			}
		}

		}

		TheContentPanelReference.getDataUpdate();		
		ProjectManager.saveTempNow();
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


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        PaymentsContentTopPanel = new javax.swing.JPanel();
        PaymentsCentralContentPanel = new javax.swing.JPanel();
        PaymentsContentPanel = new javax.swing.JPanel();
        PaymentsContentPanelItem3 = new javax.swing.JPanel();
        PaymentsSettingsPanelItem2 = new javax.swing.JPanel();
        PaymentsEnabledPanel1 = new javax.swing.JPanel();
        cbPaymentsEnabled = new javax.swing.JCheckBox();
        PaymentsPanelMainContainer1 = new javax.swing.JPanel();
        btnPaymentsFormPreview = new javax.swing.JButton();
        PaymentsSettingsPanelItem8 = new javax.swing.JPanel();
        PaymentsContentPanelItem4 = new javax.swing.JPanel();
        PaymentsSettingsPanelItem1 = new javax.swing.JPanel();
        PaymentsTitlePanel = new javax.swing.JPanel();
        lEvaluationUnlockCode = new javax.swing.JLabel();
	  PaymentsMenuPanelBottomPanel = new javax.swing.JPanel();
        tfEvaluationUnlockCode = new javax.swing.JTextField();
        PaymentsTitleRightPanel = new javax.swing.JPanel();
        btnGenerateEvaluationUnlockCode = new javax.swing.JButton();
        MaxPaymentsAttemptsSettingsPanel = new javax.swing.JPanel();
        MaxPaymentsAttemptsLeftContentPanel = new javax.swing.JPanel();
        lMaxPaymentsAttempts = new javax.swing.JLabel();
        tfMaxPaymentsAttempts = new javax.swing.JTextField();
        MaxPaymentsAttemptsRightFillerPanel = new javax.swing.JPanel();
        PaymentsCentralContentLeftMarginPanel = new javax.swing.JPanel();
        PaymentsCentralContentRightMarginPanel = new javax.swing.JPanel();
        PaymentsContentBottomPanel = new javax.swing.JPanel();
        PaymentsMenuPanel = new javax.swing.JPanel();
        PaymentsMenuButtonPanel = new javax.swing.JPanel();
 	  lPaymentsPropertiesMenuItem = new SBTab("Properties",sbTabWidth, sbTabHeight, sbTabLeftMargin, theCurrentMenuColor, theTextMenuColor, arrowIcon, iconTextGap, sbTabTopBorderColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor, sbTabIsOpaque);
        lPaymentsHTMLFormMenuItem = new SBTab("HTML Form",sbTabWidth, sbTabHeight, sbTabLeftMargin, theCurrentMenuColor, theTextMenuColor, arrowIcon, iconTextGap, sbTabTopBorderColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor, sbTabIsOpaque);
        lPaymentsUserInterfaceMenuItem = new SBTab("User Interface",sbTabWidth, sbTabHeight, sbTabLeftMargin, theCurrentMenuColor, theTextMenuColor, arrowIcon, iconTextGap, sbTabTopBorderColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor, sbTabIsOpaque);
        lPaymentsActionsMenuItem = new SBTab("Actions",sbTabWidth, sbTabHeight, sbTabLeftMargin, theCurrentMenuColor, theTextMenuColor, arrowIcon, iconTextGap, sbTabTopBorderColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor, sbTabIsOpaque);
        PaymentsMenuButtonPanelTop = new SBTab(null,sbTabWidth, sbTabMenuTopSpaceFiller, sbTabLeftMargin, theCurrentMenuColor, theTextMenuColor, null, iconTextGap, theCurrentMenuColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor, sbTabIsOpaque);
        PaymentsMenuButtonPanelBottom = new SBSpacer(theCurrentMenuColor,sbTabTopBorderColor,theCurrentMenuColor,sbTabRightInnerBorderColor,sbTabRightOuterBorderColor,sbTabIsOpaque);
        PaymentsMenuLeftSpaceFiller = new javax.swing.JPanel();
        PaymentsSelectionContentPanel = new javax.swing.JPanel();
PaymentsMenuContentPanel = new javax.swing.JPanel();

	  registrationEnabledPanel = new PaymentsEnabledControl();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

//
theEAProperties = new EAPropertiesPanel(getHTMLFormPaymentEAListItems(),rowColor, rowBorderColor, backgroundColor, rowHeight);
//
theEAProperties.setMasterControlPanel(this);
theEAProperties.setGetConfigurationWizardActionFromParent(true);
//
	  registrationEnabledPanel.setBackgroundColor(backgroundColor);
	  registrationEnabledPanel.setText("Enable Payment Processing Support");
	  theEAProperties.setHeaderTextAndWidth("Payments Code Configuration", 300, "Value", 175, "", 0);
	  theEAProperties.setAddButtonText("Add Input");
	  theEAProperties.setRemoveButtonText("Remove Input");
	  theEAProperties.setEditButtonText("Edit Input");
	  theEAProperties.setAddButtonVisible(false);
	  theEAProperties.setRemoveButtonVisible(false);
	  theEAProperties.setEditButtonVisible(false);
	  theEAProperties.setConfigurationWizardButtonVisible(true);
	  theEAProperties.setPreviewButtonText("Preview");
	  theEAProperties.setConfigurationWizardButtonText("Configuration Wizard");
	  theEAProperties.setDescriptorPanelWidth(241);
	  try
	  {
	  	theEAProperties.setConfigurationWizardButtonAction(DesignerRuleBuilder.get("paymentConfigurationWizardAction"));
	  	theEAProperties.setPreviewButtonAction(DesignerRuleBuilder.get("paymentDialogPreviewAction"));
	  }
	  catch(Exception ee)
	  {
		ee.printStackTrace();
	  }

        setBackground(new java.awt.Color(100, 120, 170));
        PaymentsContentTopPanel.setLayout(new java.awt.BorderLayout());

        PaymentsContentTopPanel.setBackground(new java.awt.Color(100, 120, 170));
        PaymentsContentTopPanel.setMaximumSize(new java.awt.Dimension(2147483647, 150));
        PaymentsContentTopPanel.setPreferredSize(new java.awt.Dimension(620, 150));
        PaymentsCentralContentPanel.setLayout(new java.awt.BorderLayout());

        PaymentsMenuContentPanel.setBackground(new java.awt.Color(100, 120, 170));
        PaymentsMenuContentPanel.setMaximumSize(new java.awt.Dimension(2147483647, 150));
        PaymentsMenuContentPanel.setPreferredSize(new java.awt.Dimension(sbTabWidth, 3000));

        PaymentsCentralContentPanel.setBackground(new java.awt.Color(100, 120, 170));
        PaymentsCentralContentPanel.setMaximumSize(new java.awt.Dimension(2147483647, 110));
        PaymentsCentralContentPanel.setPreferredSize(new java.awt.Dimension(620, 115));
        PaymentsContentPanel.setLayout(new java.awt.BorderLayout());

        PaymentsContentPanel.setBackground(new java.awt.Color(100, 120, 170));
        PaymentsContentPanel.setMaximumSize(new java.awt.Dimension(2147483647, 115));
        PaymentsContentPanel.setMinimumSize(new java.awt.Dimension(448, 0));
        PaymentsContentPanel.setPreferredSize(new java.awt.Dimension(600, 115));
        PaymentsContentPanelItem3.setLayout(new javax.swing.BoxLayout(PaymentsContentPanelItem3, javax.swing.BoxLayout.Y_AXIS));

        PaymentsContentPanelItem3.setBackground(new java.awt.Color(100, 120, 170));
        PaymentsContentPanelItem3.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(140, 171, 240), new java.awt.Color(27, 44, 76)), "Payments Code", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12)));
        PaymentsSettingsPanelItem2.setLayout(new java.awt.BorderLayout());

        PaymentsSettingsPanelItem2.setBackground(new java.awt.Color(100, 120, 170));
        PaymentsEnabledPanel1.setLayout(new java.awt.BorderLayout(15, 5));

        PaymentsEnabledPanel1.setBackground(new java.awt.Color(100, 120, 170));
        PaymentsEnabledPanel1.setMaximumSize(new java.awt.Dimension(300, 2147483647));
        cbPaymentsEnabled.setBackground(new java.awt.Color(100, 120, 170));
        cbPaymentsEnabled.setFont(new java.awt.Font("Arial", 0, 12));
        cbPaymentsEnabled.setSelected(true);
        cbPaymentsEnabled.setText("Enable Payment Processing Support");
        PaymentsEnabledPanel1.add(cbPaymentsEnabled, java.awt.BorderLayout.CENTER);

        PaymentsSettingsPanelItem2.add(PaymentsEnabledPanel1, java.awt.BorderLayout.WEST);

        PaymentsPanelMainContainer1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 0));

        PaymentsPanelMainContainer1.setBackground(new java.awt.Color(100, 120, 170));
        btnPaymentsFormPreview.setFont(new java.awt.Font("Arial", 0, 12));
        btnPaymentsFormPreview.setText("Preview");
        PaymentsPanelMainContainer1.add(btnPaymentsFormPreview);

        PaymentsSettingsPanelItem2.add(PaymentsPanelMainContainer1, java.awt.BorderLayout.CENTER);

        PaymentsContentPanelItem3.add(PaymentsSettingsPanelItem2);

        PaymentsSettingsPanelItem8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        PaymentsSettingsPanelItem8.setBackground(new java.awt.Color(100, 120, 170));
        PaymentsContentPanelItem3.add(PaymentsSettingsPanelItem8);

	  theEAProperties.setDescriptorPanel(registrationEnabledPanel);
	  PaymentsContentPanel.add(theEAProperties);

        //PaymentsContentPanel.add(PaymentsContentPanelItem3, java.awt.BorderLayout.NORTH);

        PaymentsContentPanelItem4.setLayout(new javax.swing.BoxLayout(PaymentsContentPanelItem4, javax.swing.BoxLayout.Y_AXIS));

        PaymentsContentPanelItem4.setBackground(new java.awt.Color(100, 120, 170));
        PaymentsContentPanelItem4.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(140, 171, 240), new java.awt.Color(27, 44, 76)), "Configuration", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12)));
        PaymentsContentPanelItem4.setMaximumSize(new java.awt.Dimension(1400, 50));
        PaymentsContentPanelItem4.setMinimumSize(new java.awt.Dimension(60, 50));
        PaymentsContentPanelItem4.setPreferredSize(new java.awt.Dimension(600, 50));
        PaymentsSettingsPanelItem1.setLayout(new java.awt.BorderLayout());

        PaymentsSettingsPanelItem1.setBackground(new java.awt.Color(100, 120, 170));
        PaymentsSettingsPanelItem1.setMaximumSize(new java.awt.Dimension(32767, 33));
        PaymentsTitlePanel.setBackground(new java.awt.Color(100, 120, 170));
        PaymentsTitlePanel.setMaximumSize(new java.awt.Dimension(100, 2147483647));
        lEvaluationUnlockCode.setBackground(new java.awt.Color(100, 120, 170));
        lEvaluationUnlockCode.setFont(new java.awt.Font("Arial", 0, 12));
        lEvaluationUnlockCode.setText("Software Evaluation Unlock Code:");
        PaymentsTitlePanel.add(lEvaluationUnlockCode);

        tfEvaluationUnlockCode.setPreferredSize(new java.awt.Dimension(220, 19));
        PaymentsTitlePanel.add(tfEvaluationUnlockCode);

        PaymentsSettingsPanelItem1.add(PaymentsTitlePanel, java.awt.BorderLayout.WEST);

        PaymentsTitleRightPanel.setLayout(new javax.swing.BoxLayout(PaymentsTitleRightPanel, javax.swing.BoxLayout.Y_AXIS));

        PaymentsTitleRightPanel.setBackground(new java.awt.Color(100, 120, 170));
        btnGenerateEvaluationUnlockCode.setText("Generate");
        PaymentsTitleRightPanel.add(btnGenerateEvaluationUnlockCode);

        PaymentsSettingsPanelItem1.add(PaymentsTitleRightPanel, java.awt.BorderLayout.CENTER);

        PaymentsContentPanelItem4.add(PaymentsSettingsPanelItem1);

        MaxPaymentsAttemptsSettingsPanel.setLayout(new java.awt.BorderLayout());

        MaxPaymentsAttemptsSettingsPanel.setBackground(new java.awt.Color(100, 120, 170));
        MaxPaymentsAttemptsSettingsPanel.setMaximumSize(new java.awt.Dimension(32767, 33));
        MaxPaymentsAttemptsLeftContentPanel.setBackground(new java.awt.Color(100, 120, 170));
        MaxPaymentsAttemptsLeftContentPanel.setMaximumSize(new java.awt.Dimension(100, 2147483647));
        lMaxPaymentsAttempts.setBackground(new java.awt.Color(100, 120, 170));
        lMaxPaymentsAttempts.setFont(new java.awt.Font("Arial", 0, 12));
        lMaxPaymentsAttempts.setText("Maximum Payments Attempts to Lockout:");
        MaxPaymentsAttemptsLeftContentPanel.add(lMaxPaymentsAttempts);

        tfMaxPaymentsAttempts.setPreferredSize(new java.awt.Dimension(220, 19));
        MaxPaymentsAttemptsLeftContentPanel.add(tfMaxPaymentsAttempts);

        MaxPaymentsAttemptsSettingsPanel.add(MaxPaymentsAttemptsLeftContentPanel, java.awt.BorderLayout.WEST);

        MaxPaymentsAttemptsRightFillerPanel.setLayout(new javax.swing.BoxLayout(MaxPaymentsAttemptsRightFillerPanel, javax.swing.BoxLayout.Y_AXIS));

        MaxPaymentsAttemptsRightFillerPanel.setBackground(new java.awt.Color(100, 120, 170));
        MaxPaymentsAttemptsSettingsPanel.add(MaxPaymentsAttemptsRightFillerPanel, java.awt.BorderLayout.CENTER);

        PaymentsContentPanelItem4.add(MaxPaymentsAttemptsSettingsPanel);

        //PaymentsContentPanel.add(PaymentsContentPanelItem4, java.awt.BorderLayout.CENTER);

        PaymentsCentralContentPanel.add(PaymentsContentPanel, java.awt.BorderLayout.CENTER);

        PaymentsCentralContentLeftMarginPanel.setBackground(new java.awt.Color(100, 120, 170));
        PaymentsCentralContentPanel.add(PaymentsCentralContentLeftMarginPanel, java.awt.BorderLayout.WEST);

        PaymentsCentralContentRightMarginPanel.setBackground(new java.awt.Color(100, 120, 170));
        PaymentsCentralContentPanel.add(PaymentsCentralContentRightMarginPanel, java.awt.BorderLayout.EAST);

        PaymentsContentTopPanel.add(PaymentsCentralContentPanel, java.awt.BorderLayout.CENTER);
PaymentsContentTopPanel.setPreferredSize(new java.awt.Dimension(620, 2000));
        add(PaymentsContentTopPanel);

        PaymentsContentBottomPanel.setLayout(new java.awt.BorderLayout());

        PaymentsContentBottomPanel.setBackground(new java.awt.Color(100, 120, 170));
        PaymentsContentBottomPanel.setMinimumSize(new java.awt.Dimension(180, 275));
        PaymentsContentBottomPanel.setPreferredSize(new java.awt.Dimension(180, 275));
        PaymentsContentBottomPanel.setMaximumSize(new java.awt.Dimension(180, 275));
        PaymentsMenuPanel.setLayout(new java.awt.BorderLayout());

        PaymentsMenuPanel.setBackground(new java.awt.Color(100, 120, 170));
        PaymentsMenuPanel.setForeground(new java.awt.Color(255, 255, 255));
        PaymentsMenuPanel.setMaximumSize(new java.awt.Dimension(sbTabWidth, 32767));
        PaymentsMenuPanel.setMinimumSize(new java.awt.Dimension(sbTabWidth, 10));
        PaymentsMenuPanel.setPreferredSize(new java.awt.Dimension(sbTabWidth, 10));
        PaymentsMenuButtonPanel.setLayout(new javax.swing.BoxLayout(PaymentsMenuButtonPanel, javax.swing.BoxLayout.Y_AXIS));

        PaymentsMenuButtonPanel.setBackground(new java.awt.Color(100, 120, 170));
        PaymentsMenuButtonPanel.setForeground(new java.awt.Color(255, 255, 255));
        PaymentsMenuButtonPanel.setMaximumSize(new java.awt.Dimension(sbTabWidth, sbTabGroupHeight));
        PaymentsMenuButtonPanel.setMinimumSize(new java.awt.Dimension(sbTabWidth, sbTabGroupHeight));
        PaymentsMenuButtonPanel.setPreferredSize(new java.awt.Dimension(sbTabWidth, sbTabGroupHeight));

        PaymentsMenuPanelBottomPanel.setLayout(new java.awt.BorderLayout());

        PaymentsMenuPanelBottomPanel.setBackground(new java.awt.Color(39, 63, 109));
        PaymentsMenuPanelBottomPanel.setForeground(new java.awt.Color(255, 255, 255));
        PaymentsMenuPanelBottomPanel.setMaximumSize(new java.awt.Dimension(sbTabWidth, 100));
        PaymentsMenuPanelBottomPanel.setMinimumSize(new java.awt.Dimension(sbTabWidth, 100));
        PaymentsMenuPanelBottomPanel.setPreferredSize(new java.awt.Dimension(sbTabWidth, 100));

	  lPaymentsPropertiesMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lPaymentsPropertiesMenuItemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lPaymentsPropertiesMenuItemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lPaymentsPropertiesMenuItemMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lPaymentsPropertiesMenuItemMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lPaymentsPropertiesMenuItemMouseReleased(evt);
            }
        });

        PaymentsMenuButtonPanel.add(lPaymentsPropertiesMenuItem);


        lPaymentsHTMLFormMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lPaymentsHTMLFormMenuItemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lPaymentsHTMLFormMenuItemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lPaymentsHTMLFormMenuItemMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lPaymentsHTMLFormMenuItemMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lPaymentsHTMLFormMenuItemMouseReleased(evt);
            }
        });

        PaymentsMenuButtonPanel.add(lPaymentsHTMLFormMenuItem);

        lPaymentsUserInterfaceMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lPaymentsUserInterfaceMenuItemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lPaymentsUserInterfaceMenuItemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lPaymentsUserInterfaceMenuItemMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lPaymentsUserInterfaceMenuItemMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lPaymentsUserInterfaceMenuItemMouseReleased(evt);
            }
        });

        PaymentsMenuButtonPanel.add(lPaymentsUserInterfaceMenuItem);

        lPaymentsActionsMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lPaymentsActionsMenuItemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lPaymentsActionsMenuItemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lPaymentsActionsMenuItemMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lPaymentsActionsMenuItemMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lPaymentsActionsMenuItemMouseReleased(evt);
            }
        });

        PaymentsMenuButtonPanel.add(lPaymentsActionsMenuItem);

/**********************/
        PaymentsMenuPanelBottomPanel.add(PaymentsMenuButtonPanel, java.awt.BorderLayout.NORTH);
        PaymentsMenuPanelBottomPanel.add(PaymentsMenuButtonPanelBottom, java.awt.BorderLayout.CENTER);
        PaymentsMenuPanel.add(PaymentsMenuPanelBottomPanel, java.awt.BorderLayout.CENTER);
        PaymentsMenuPanel.add(PaymentsMenuButtonPanelTop, java.awt.BorderLayout.NORTH);
        PaymentsMenuButtonPanelBottom.setBackground(new java.awt.Color(100, 120, 170));
        PaymentsMenuButtonPanelBottom.setForeground(new java.awt.Color(255, 255, 255));
        PaymentsMenuLeftSpaceFiller.setBackground(new java.awt.Color(100, 120, 170));
        PaymentsMenuLeftSpaceFiller.setMinimumSize(new java.awt.Dimension(1, 10));
        PaymentsMenuLeftSpaceFiller.setPreferredSize(new java.awt.Dimension(1, 10));
        PaymentsMenuPanel.add(PaymentsMenuLeftSpaceFiller, java.awt.BorderLayout.WEST);
        PaymentsContentBottomPanel.add(PaymentsMenuPanel, java.awt.BorderLayout.WEST);
/**********************/
        PaymentsSelectionContentPanel.setLayout(new java.awt.BorderLayout());

        PaymentsSelectionContentPanel.setBackground(new java.awt.Color(140, 160, 210));
        PaymentsSelectionContentPanel.setForeground(new java.awt.Color(255, 255, 255));
        PaymentsContentBottomPanel.add(PaymentsSelectionContentPanel, java.awt.BorderLayout.CENTER);

        //add(PaymentsContentBottomPanel);
// add header here
	  contentPanel = new JPanel();
        contentPanel.setLayout(new java.awt.BorderLayout());
        contentPanel.add(PaymentsMenuPanel, java.awt.BorderLayout.WEST);
        contentPanel.add(PaymentsContentBottomPanel, java.awt.BorderLayout.CENTER);
	  contentProjectPanel = new ContentAreaHeaderPanel(contentPanel, sbTabWidth, theCurrentMenuColor, sbTabRightInnerBorderColor,sbTabRightOuterBorderColor,theSelectedMenuColor);
	  add(contentProjectPanel, java.awt.BorderLayout.CENTER);
    }//GEN-END:initComponents

    private void lPaymentsPropertiesMenuItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPaymentsPropertiesMenuItemMouseReleased
	 setMouseReleasedMenuLabel(lPaymentsPropertiesMenuItem);
    }//GEN-LAST:event_lPaymentsPropertiesMenuItemMouseReleased

    private void lPaymentsActionsMenuItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPaymentsActionsMenuItemMouseReleased
	 setMouseReleasedMenuLabel(lPaymentsActionsMenuItem);
    }//GEN-LAST:event_lPaymentsActionsMenuItemMouseReleased

    private void lPaymentsUserInterfaceMenuItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPaymentsUserInterfaceMenuItemMouseReleased
	 setMouseReleasedMenuLabel(lPaymentsUserInterfaceMenuItem);
    }//GEN-LAST:event_lPaymentsUserInterfaceMenuItemMouseReleased

    private void lPaymentsHTMLFormMenuItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPaymentsHTMLFormMenuItemMouseReleased
	 setMouseReleasedMenuLabel(lPaymentsHTMLFormMenuItem);
    }//GEN-LAST:event_lPaymentsHTMLFormMenuItemMouseReleased

    private void lPaymentsPropertiesMenuItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPaymentsPropertiesMenuItemMousePressed
        setMousePressedMenuLabel(lPaymentsPropertiesMenuItem);
    }//GEN-LAST:event_lPaymentsPropertiesMenuItemMousePressed

    private void lPaymentsActionsMenuItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPaymentsActionsMenuItemMousePressed
        setMousePressedMenuLabel(lPaymentsActionsMenuItem);
    }//GEN-LAST:event_lPaymentsActionsMenuItemMousePressed

    private void lPaymentsUserInterfaceMenuItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPaymentsUserInterfaceMenuItemMousePressed
        setMousePressedMenuLabel(lPaymentsUserInterfaceMenuItem);
    }//GEN-LAST:event_lPaymentsUserInterfaceMenuItemMousePressed

    private void lPaymentsHTMLFormMenuItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPaymentsHTMLFormMenuItemMousePressed
        setMousePressedMenuLabel(lPaymentsHTMLFormMenuItem);
    }//GEN-LAST:event_lPaymentsHTMLFormMenuItemMousePressed

    private void lPaymentsPropertiesMenuItemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPaymentsPropertiesMenuItemMouseExited
        setMouseExitedMenuLabel(lPaymentsPropertiesMenuItem);
    }//GEN-LAST:event_lPaymentsPropertiesMenuItemMouseExited

    private void lPaymentsActionsMenuItemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPaymentsActionsMenuItemMouseExited
        setMouseExitedMenuLabel(lPaymentsActionsMenuItem);
    }//GEN-LAST:event_lPaymentsActionsMenuItemMouseExited

    private void lPaymentsUserInterfaceMenuItemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPaymentsUserInterfaceMenuItemMouseExited
        setMouseExitedMenuLabel(lPaymentsUserInterfaceMenuItem);
    }//GEN-LAST:event_lPaymentsUserInterfaceMenuItemMouseExited

    private void lPaymentsHTMLFormMenuItemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPaymentsHTMLFormMenuItemMouseExited
        setMouseExitedMenuLabel(lPaymentsHTMLFormMenuItem);
    }//GEN-LAST:event_lPaymentsHTMLFormMenuItemMouseExited

    private void lPaymentsPropertiesMenuItemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPaymentsPropertiesMenuItemMouseEntered
        setMouseEnteredMenuLabel(lPaymentsPropertiesMenuItem);
    }//GEN-LAST:event_lPaymentsPropertiesMenuItemMouseEntered

    private void lPaymentsActionsMenuItemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPaymentsActionsMenuItemMouseEntered
        setMouseEnteredMenuLabel(lPaymentsActionsMenuItem);
    }//GEN-LAST:event_lPaymentsActionsMenuItemMouseEntered

    private void lPaymentsUserInterfaceMenuItemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPaymentsUserInterfaceMenuItemMouseEntered
        setMouseEnteredMenuLabel(lPaymentsUserInterfaceMenuItem);
    }//GEN-LAST:event_lPaymentsUserInterfaceMenuItemMouseEntered

    private void lPaymentsHTMLFormMenuItemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPaymentsHTMLFormMenuItemMouseEntered
        setMouseEnteredMenuLabel(lPaymentsHTMLFormMenuItem);
    }//GEN-LAST:event_lPaymentsHTMLFormMenuItemMouseEntered

    private void lPaymentsPropertiesMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPaymentsPropertiesMenuItemMouseClicked
 	setSelectedMenuItem(lPaymentsPropertiesMenuItem);
	setConfigurationPropertyPanel();
    }//GEN-LAST:event_lPaymentsPropertiesMenuItemMouseClicked

    private void lPaymentsActionsMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPaymentsActionsMenuItemMouseClicked
 	setSelectedMenuItem(lPaymentsActionsMenuItem);
	setPaymentsActionsPropertyPanel();
    }//GEN-LAST:event_lPaymentsActionsMenuItemMouseClicked

    private void lPaymentsUserInterfaceMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPaymentsUserInterfaceMenuItemMouseClicked
 	setSelectedMenuItem(lPaymentsUserInterfaceMenuItem);
	setPaymentsUserInterfacePropertyPanel();
    }//GEN-LAST:event_lPaymentsUserInterfaceMenuItemMouseClicked

    private void lPaymentsHTMLFormMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPaymentsHTMLFormMenuItemMouseClicked
 	setSelectedMenuItem(lPaymentsHTMLFormMenuItem);
	setPaymentsHTMLFormInputsPropertyPanel();
    }//GEN-LAST:event_lPaymentsHTMLFormMenuItemMouseClicked

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
 private int sbTabWidth = 120;
 private int sbTabHeight = 25;
 private int sbTabGroupHeight = 100;
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
	Object[] sbUIStrings = getStringArraysFromString(DesignerRuleBuilder.get("sbPaymentsStrings"));
	Object[] sbUIActions = getStringArraysFromString(DesignerRuleBuilder.get("sbPaymentsActionPanels"));
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

private void setConfigurationPropertyPanel()
{
	try
	{
	  theEAProperties.setHeaderText("Payment Processing Properties");
	  theEAProperties.setHeaderTextAndWidth("Payment Processing Properties", 325, "Value", 175, "", 0);
	  theEAProperties.setAddButtonVisible(false);
	  theEAProperties.setEditButtonVisible(false);
	  theEAProperties.setRemoveButtonVisible(false);
	  theEAProperties.setConfigurationWizardButtonVisible(true);
	  try
	  {
	  	theEAProperties.setPreviewButtonAction(DesignerRuleBuilder.get("paymentDialogPreviewAction"));
	  }
	  catch(Exception ee)
	  {
		ee.printStackTrace();
	  }
	  theEAProperties.setListDefaults(getPropertiesEAListItems());
	  theEAProperties.setSelectedIndex(0);
	  EAListItem eaListItemObj = theEAProperties.getSelectedEAListItem();
	  eaListItemObj.setSelectedMode();
	  theEAProperties.setLabelWidth(300);
	  theEAProperties.setDataWidth(175);
	  theEAProperties.setDataValueWidth(175);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

public void setPaymentsActionsPropertyPanel()
{
	try
	{
	  theEAProperties.setHeaderText("Action Mappings");
	  theEAProperties.setHeaderTextAndWidth("Action Mappings", 300, "Class Name", 175, "", 0);
	  theEAProperties.setAddButtonVisible(false);
	  theEAProperties.setEditButtonVisible(false);
	  theEAProperties.setRemoveButtonVisible(false);
	  try
	  {
	  	theEAProperties.setPreviewButtonAction(DesignerRuleBuilder.get("paymentDialogPreviewAction"));
	  }
	  catch(Exception ee)
	  {
		ee.printStackTrace();
	  }
	  theEAProperties.setListDefaults(getActionsEAListItems());
	  theEAProperties.setSelectedIndex(0);
	  EAListItem eaListItemObj = theEAProperties.getSelectedEAListItem();
	  eaListItemObj.setSelectedMode();
	  theEAProperties.setLabelWidth(300);
	  theEAProperties.setDataWidth(175);
	  theEAProperties.setDataValueWidth(175);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

public void setPaymentsUserInterfacePropertyPanel()
{
	try
	{
	  theEAProperties.setHeaderText("User Interface Strings");
	  theEAProperties.setHeaderTextAndWidth("User Interface Strings", 350, "String Value", 175, "", 0);
	  theEAProperties.setAddButtonVisible(false);
	  theEAProperties.setEditButtonVisible(false);
	  theEAProperties.setRemoveButtonVisible(false);
	  try
	  {
	  	theEAProperties.setPreviewButtonAction(DesignerRuleBuilder.get("paymentDialogPreviewAction"));
	  }
	  catch(Exception ee)
	  {
		ee.printStackTrace();
	  }
	  theEAProperties.setListDefaults(getPaymentUIStringEAListItems());
	  theEAProperties.setSelectedIndex(0);
	  EAListItem eaListItemObj = theEAProperties.getSelectedEAListItem();
	  eaListItemObj.setSelectedMode();
	  theEAProperties.setLabelWidth(300);
	  theEAProperties.setDataWidth(175);
	  theEAProperties.setDataValueWidth(175);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

public void setPaymentsSuccessUserInterfacePropertyPanel()
{
	try
	{
	  theEAProperties.setHeaderText("User Interface Strings");
	  theEAProperties.setHeaderTextAndWidth("User Interface Strings", 200, "String Value", 225, "", 0);
	  theEAProperties.setAddButtonVisible(false);
	  theEAProperties.setEditButtonVisible(false);
	  theEAProperties.setRemoveButtonVisible(false);
	  try
	  {
	  	theEAProperties.setPreviewButtonAction(DesignerRuleBuilder.get("paymentSuccessDialogPreviewAction"));
	  }
	  catch(Exception ee)
	  {
		ee.printStackTrace();
	  }
	  theEAProperties.setListDefaults(getUISuccessEAListItems());
	  theEAProperties.setSelectedIndex(0);
	  EAListItem eaListItemObj = theEAProperties.getSelectedEAListItem();
	  eaListItemObj.setSelectedMode();
	  theEAProperties.setLabelWidth(300);
	  theEAProperties.setDataWidth(175);
	  theEAProperties.setDataValueWidth(175);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

public void setPaymentsFailedUserInterfacePropertyPanel()
{
	try
	{
	  theEAProperties.setHeaderText("User Interface Strings");
	  theEAProperties.setHeaderTextAndWidth("User Interface Strings", 200, "String Value", 225, "", 0);
	  theEAProperties.setAddButtonVisible(false);
	  theEAProperties.setEditButtonVisible(false);
	  theEAProperties.setRemoveButtonVisible(false);
	  try
	  {
	  	theEAProperties.setPreviewButtonAction(DesignerRuleBuilder.get("paymentFailedDialogPreviewAction"));
	  }
	  catch(Exception ee)
	  {
		ee.printStackTrace();
	  }
	  theEAProperties.setListDefaults(getUIFailedStringEAListItems());
	  theEAProperties.setSelectedIndex(0);
	  EAListItem eaListItemObj = theEAProperties.getSelectedEAListItem();
	  eaListItemObj.setSelectedMode();
	  theEAProperties.setLabelWidth(300);
	  theEAProperties.setDataWidth(175);
	  theEAProperties.setDataValueWidth(175);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

public void setPaymentsHTMLFormInputsPropertyPanel()
{
	try
	{
	  theEAProperties.setDisableUITextFunction();
	  theEAProperties.setHeaderText("HTML Form Inputs");
	  theEAProperties.setHeaderTextAndWidth("HTML Form Inputs", 325, "Name Attribute", 175, "Name Value", 100);
	  theEAProperties.setDefaultLabelText("Input Name Attribute:");
	  theEAProperties.setAddButtonVisible(true);
	  theEAProperties.setEditButtonVisible(true);
	  theEAProperties.setRemoveButtonVisible(true);
	  theEAProperties.setConfigurationWizardButtonVisible(true);
	  theEAProperties.setAddButtonText("Add Input");
	  theEAProperties.setRemoveButtonText("Remove Input");
	  theEAProperties.setEditButtonText("Edit Input");

	  try
	  {
	  	theEAProperties.setPreviewButtonAction(DesignerRuleBuilder.get("paymentDialogPreviewAction"));
	  }
	  catch(Exception ee)
	  {
		ee.printStackTrace();
	  }
	  theEAProperties.setListDefaults(getHTMLFormPaymentEAListItems());
	  theEAProperties.setSelectedIndex(0);
	  EAListItem eaListItemObj = theEAProperties.getSelectedEAListItem();
	  eaListItemObj.setSelectedMode();
	  theEAProperties.setLabelWidth(300);
	  theEAProperties.setDataWidth(175);
	  theEAProperties.setDataValueWidth(175);

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

public void setPaymentResponseHTMLFormInputsPropertyPanel()
{
	try
	{
	  theEAProperties.setHeaderText("HTML Form Inputs");
	  theEAProperties.setHeaderTextAndWidth("HTML Form Inputs", 325, "Name Attribute", 175, "", 0);
	  theEAProperties.setDefaultLabelText("Response Document Authorization Failure Value ");
	  theEAProperties.setParentComponent(this);
	  theEAProperties.setUITextWithStartIndex("Response Document Authorization Failure Value ", 1, 13);
	  theEAProperties.setAddButtonVisible(true);
	  theEAProperties.setEditButtonVisible(true);
	  theEAProperties.setRemoveButtonVisible(true);
	  theEAProperties.setConfigurationWizardButtonVisible(true);
	  theEAProperties.setAddButtonText("Add Response");
	  theEAProperties.setRemoveButtonText("Remove Response");
	  theEAProperties.setEditButtonText("Edit Input");
	  try
	  {
	  	theEAProperties.setPreviewButtonAction(DesignerRuleBuilder.get("paymentDialogPreviewAction"));
	  }
	  catch(Exception ee)
	  {
		ee.printStackTrace();
	  }
	  theEAProperties.setListDefaults(getHTMLFormResponseEAListItems());
	  theEAProperties.setSelectedIndex(0);
	  EAListItem eaListItemObj = theEAProperties.getSelectedEAListItem();
	  eaListItemObj.setSelectedMode();
	  theEAProperties.setLabelWidth(300);
	  theEAProperties.setDataWidth(350);
	  theEAProperties.setDataValueWidth(0);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

private int eaPropPanel = 0;
private String[] strPropertiesArray = new String[9];
private EAListItem[] PropertiesEAListItemArray = new EAListItem[9];
private EAListItem[] getPropertiesEAListItems()
{
	  eaPropPanel = 0;
        try
        {
		int defUIStringLabelWidth = 300;
		int defUIStringDataWidth = 350;

		EAListItem[] eaItems = new EAListItem[9];
            EAListItem eai = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent merchantValue = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		merchantValue.setLabelText("Merchant ID: ");
		if(ProjectManager.get("merchantValue")!=null)
		{
			merchantValue.setInputText(ProjectManager.get("merchantValue"));
			strPropertiesArray[0] = "merchantValue";
		}
            eai.setRowDataPanel(merchantValue);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai.setListItemIsRemovable(false);
		eai.setValueBoxEnabled(false);
		eaItems[0] = eai;
//
            EAListItem eai2 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent totalPrice = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		totalPrice.setLabelText("Product Price: ");
		if(ProjectManager.get("product_price")!=null)
		{
			totalPrice.setInputText(ProjectManager.get("product_price"));
			strPropertiesArray[1] = "product_price";
		}
            eai2.setRowDataPanel(totalPrice);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai2.setListItemIsRemovable(false);
		eai2.setValueBoxEnabled(false);
		eaItems[1] = eai2;
//
            EAListItem eai3 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent maxPaymentAttempts = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		maxPaymentAttempts.setLabelText("Payment Attempts Before Lockdown: ");
		if(ProjectManager.get("maxPaymentAttempts")!=null)
		{
			maxPaymentAttempts.setInputText(ProjectManager.get("maxPaymentAttempts"));
			strPropertiesArray[2] = "maxPaymentAttempts";
		}
            eai3.setRowDataPanel(maxPaymentAttempts);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai3.setListItemIsRemovable(false);
		eai3.setValueBoxEnabled(false);
		eaItems[2] = eai3;
//
            EAListItem eai4 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent orderIDLeadingID = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		orderIDLeadingID.setLabelText("Order ID Leading ID (Order ID + generated portion):");
		if(ProjectManager.get("orderIDLeadingID")!=null)
		{
			orderIDLeadingID.setInputText(ProjectManager.get("orderIDLeadingID"));
			strPropertiesArray[3] = "orderIDLeadingID";
		}
            eai4.setRowDataPanel(orderIDLeadingID);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai4.setListItemIsRemovable(false);
		eai4.setValueBoxEnabled(false);
		eaItems[3] = eai4;
//
            EAListItem eai5 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentCCVerificationCodeEnabled = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentCCVerificationCodeEnabled.setLabelText("Credit Card Verification Code Enabled: ");
		if(ProjectManager.get("paymentCCVerificationCodeEnabled")!=null)
		{
			paymentCCVerificationCodeEnabled.setInputText(ProjectManager.get("paymentCCVerificationCodeEnabled"));
			strPropertiesArray[4] = "paymentCCVerificationCodeEnabled";
		}
            eai5.setRowDataPanel(paymentCCVerificationCodeEnabled);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai5.setListItemIsRemovable(false);
		eai5.setValueBoxEnabled(false);
		eaItems[4] = eai5;
//
            EAListItem eai6 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentMethods = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentMethods.setLabelText("Payment Methods Accepted:");
		if(ProjectManager.get("paymentMethods")!=null)
		{
			paymentMethods.setInputText(ProjectManager.get("paymentMethods"));
			strPropertiesArray[5] = "paymentMethods";
		}
            eai6.setRowDataPanel(paymentMethods);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai6.setListItemIsRemovable(false);
		eai6.setValueBoxEnabled(false);
		eaItems[5] = eai6;
//
            EAListItem eai7 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent responseURLValue = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		responseURLValue.setLabelText("Payment Response URL:");
		if(ProjectManager.get("responseURLValue")!=null)
		{
			responseURLValue.setInputText(ProjectManager.get("responseURLValue"));
			strPropertiesArray[6] = "responseURLValue";
		}
            eai7.setRowDataPanel(responseURLValue);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai7.setListItemIsRemovable(false);
		eai7.setValueBoxEnabled(false);
		eaItems[6] = eai7;
//
            EAListItem eai8 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent secondaryPaymentMethod = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		secondaryPaymentMethod.setLabelText("Secondary Payment Method Web Page URL:");
		if(ProjectManager.get("secondaryPaymentMethod")!=null)
		{
			secondaryPaymentMethod.setInputText(ProjectManager.get("secondaryPaymentMethod"));
			strPropertiesArray[7] = "secondaryPaymentMethod";
		}
            eai8.setRowDataPanel(secondaryPaymentMethod);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai8.setListItemIsRemovable(false);
		eai8.setValueBoxEnabled(false);
		eaItems[7] = eai8;
//
            EAListItem eai9 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent secondaryPaymentMethodEnabled = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		secondaryPaymentMethodEnabled.setLabelText("Secondary Payment Method Web Page URL Enabled:");
		if(ProjectManager.get("secondaryPaymentMethodEnabled")!=null)
		{
			secondaryPaymentMethodEnabled.setInputText(ProjectManager.get("secondaryPaymentMethodEnabled"));
			strPropertiesArray[8] = "secondaryPaymentMethodEnabled";
		}
            eai9.setRowDataPanel(secondaryPaymentMethodEnabled);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai9.setListItemIsRemovable(false);
		eai9.setValueBoxEnabled(false);
		eaItems[8] = eai9;
		PropertiesEAListItemArray = eaItems;

		return eaItems;
        }
        catch(Exception e)
        {
          e.printStackTrace();   
        }
	EAListItem[] tempLIArray2 = new EAListItem[0];
	return tempLIArray2;
}

private String[] strActionsArray = new String[7];
private EAListItem[] ActionsEAListItemArray = new EAListItem[7];
private EAListItem[] getActionsEAListItems()
{
	  eaPropPanel = 1;
        try
        {
		int defActionLabelWidth = 275;
		int defActionDataWidth = 375;

		EAListItem[] eaItems = new EAListItem[7];

            EAListItem eai9 = new EAListItem(theActionRowIcon,rowColor);
		EAListItemContent refundPolicyActionType = new EAListItemContent(rowColor, defActionLabelWidth, defActionDataWidth, false, true);
		refundPolicyActionType.setLabelText("Load Refund Policy GUI Action Type:");
		if(ProjectManager.get("refundPolicyActionType")!=null)
		{
			try
			{
				refundPolicyActionType.setComboBoxEnabled(true);				
				refundPolicyActionType.setComboBoxIndex(new Integer(ProjectManager.get("refundPolicyActionType")).intValue() + 1);
			}
			catch(Exception e)
			{
				//e.printStackTrace();
				refundPolicyActionType.setComboBoxEnabled(true);
				refundPolicyActionType.setComboBoxIndex(0);
			}
			strActionsArray[0] = "refundPolicyActionType";
		}
            eai9.setRowDataPanel(refundPolicyActionType);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai9.setListItemIsRemovable(false);
		eai9.setValueBoxEnabled(false);
	      eai9.getJComboBoxControl().addItemListener(new java.awt.event.ItemListener() 
		{
            	public void itemStateChanged(java.awt.event.ItemEvent evt) 
			{
                		cbRefundPolicyActionTypeActionPerformed(evt);
            	}
        	});

		eaItems[0] = eai9;
//
            EAListItem eai3 = new EAListItem(theActionRowIcon,rowColor);
		EAListItemContent refundPolicyAction = new EAListItemContent(rowColor, defActionLabelWidth, defActionDataWidth);
		refundPolicyAction.setLabelText("Load Refund Policy GUI Action:");
		if(ProjectManager.get("refundPolicyAction")!=null)
		{
			refundPolicyAction.setInputText(ProjectManager.get("refundPolicyAction"));
			strActionsArray[1] = "refundPolicyAction";
		}
            eai3.setRowDataPanel(refundPolicyAction);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai3.setListItemIsRemovable(false);
		eai3.setValueBoxEnabled(true);
		eaItems[1] = eai3;
//
            EAListItem eai4 = new EAListItem(theActionRowIcon,rowColor);
		EAListItemContent paymentReceiptFinishedAction = new EAListItemContent(rowColor, defActionLabelWidth, defActionDataWidth);
		paymentReceiptFinishedAction.setLabelText("Receipt Finished Action:");
		if(ProjectManager.get("paymentReceiptFinishedAction")!=null)
		{
			paymentReceiptFinishedAction.setInputText(ProjectManager.get("paymentReceiptFinishedAction"));
			strActionsArray[2] = "paymentReceiptFinishedAction";
		}
            eai4.setRowDataPanel(paymentReceiptFinishedAction);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai4.setListItemIsRemovable(false);
		eai4.setValueBoxEnabled(false);
		eaItems[2] = eai4;
//
            EAListItem eai5 = new EAListItem(theActionRowIcon,rowColor);
		EAListItemContent paymentReceiptFailedRetryAction = new EAListItemContent(rowColor, defActionLabelWidth, defActionDataWidth);
		paymentReceiptFailedRetryAction.setLabelText("Receipt Failed Retry Action:");
		if(ProjectManager.get("paymentReceiptFailedRetryAction")!=null)
		{
			paymentReceiptFailedRetryAction.setInputText(ProjectManager.get("paymentReceiptFailedRetryAction"));
			strActionsArray[3] = "paymentReceiptFailedRetryAction";
		}
            eai5.setRowDataPanel(paymentReceiptFailedRetryAction);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai5.setListItemIsRemovable(false);
		eai5.setValueBoxEnabled(false);
		eaItems[3] = eai5;
//
            EAListItem eai6 = new EAListItem(theActionRowIcon,rowColor);
		EAListItemContent orderIDGeneratorAction = new EAListItemContent(rowColor, defActionLabelWidth, defActionDataWidth);
		orderIDGeneratorAction.setLabelText("Order ID Generator Action:");
		if(ProjectManager.get("orderIDGeneratorAction")!=null)
		{
			orderIDGeneratorAction.setInputText(ProjectManager.get("orderIDGeneratorAction"));
			strActionsArray[4] = "orderIDGeneratorAction";
		}
            eai6.setRowDataPanel(orderIDGeneratorAction);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai6.setListItemIsRemovable(false);
		eai6.setValueBoxEnabled(false);
		eaItems[4] = eai6;
//
            EAListItem eai7 = new EAListItem(theActionRowIcon,rowColor);
		EAListItemContent unknownHostExceptionAction = new EAListItemContent(rowColor, defActionLabelWidth, defActionDataWidth);
		unknownHostExceptionAction.setLabelText("Unknown Host Exception Action:");
		if(ProjectManager.get("unknownHostExceptionAction")!=null)
		{
			unknownHostExceptionAction.setInputText(ProjectManager.get("unknownHostExceptionAction"));
			strActionsArray[5] = "unknownHostExceptionAction";
		}
            eai7.setRowDataPanel(unknownHostExceptionAction);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai7.setListItemIsRemovable(false);
		eai7.setValueBoxEnabled(false);
		eaItems[5] = eai7;

            EAListItem eai8 = new EAListItem(theActionRowIcon,rowColor);
		EAListItemContent socketExceptionAction = new EAListItemContent(rowColor, defActionLabelWidth, defActionDataWidth);
		socketExceptionAction.setLabelText("Network Socket Exception Action:");
		if(ProjectManager.get("socketExceptionAction")!=null)
		{
			socketExceptionAction.setInputText(ProjectManager.get("socketExceptionAction"));
			strActionsArray[6] = "socketExceptionAction";
		}
            eai8.setRowDataPanel(socketExceptionAction);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai8.setListItemIsRemovable(false);
		eai8.setValueBoxEnabled(false);
		eaItems[6] = eai8;

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
////////////////////////////////////////
private String[] UIPaymentStringArray = new String[39];
private EAListItem[] UIPaymentEAListItemArray = new EAListItem[39];
private EAListItem[] getPaymentUIStringEAListItems()
{
	  eaPropPanel = 2;
        try
        {
		int defUIStringLabelWidth = 325;
		int defUIStringDataWidth = 325;

		EAListItem[] eaItems = new EAListItem[39];
            EAListItem eai = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentWindowTitle = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentWindowTitle.setLabelText("Title: ");
		if(ProjectManager.get("paymentWindowTitle")!=null)
		{
			paymentWindowTitle.setInputText(ProjectManager.get("paymentWindowTitle"));
			UIPaymentStringArray[0] = "paymentWindowTitle";
		}
            eai.setRowDataPanel(paymentWindowTitle);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai.setListItemIsRemovable(false);
		eai.setValueBoxEnabled(false);
		eaItems[0] = eai;
//

            EAListItem eai105 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentFormProductLabel = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentFormProductLabel.setLabelText("Product Label: ");
		if(ProjectManager.get("paymentFormProductLabel")!=null)
		{
			paymentFormProductLabel.setInputText(ProjectManager.get("paymentFormProductLabel"));
			UIPaymentStringArray[1] = "paymentFormProductLabel";
		}
            eai105.setRowDataPanel(paymentFormProductLabel);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai105.setListItemIsRemovable(false);
		eai105.setValueBoxEnabled(false);
		eaItems[1] = eai105;
//
            EAListItem eai104 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentFormProductLabelImageEnabled = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentFormProductLabelImageEnabled.setLabelText("Product Label Image Enabled: ");
		if(ProjectManager.get("paymentFormProductLabelImageEnabled")!=null)
		{
			paymentFormProductLabelImageEnabled.setInputText(ProjectManager.get("paymentFormProductLabelImageEnabled"));
			UIPaymentStringArray[2] = "paymentFormProductLabelImageEnabled";
		}
            eai104.setRowDataPanel(paymentFormProductLabelImageEnabled);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai104.setListItemIsRemovable(false);
		eai104.setValueBoxEnabled(false);
		eaItems[2] = eai104;
//

            EAListItem eai111 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentPriceLabel = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentPriceLabel.setLabelText("Price Label: ");
		if(ProjectManager.get("paymentPriceLabel")!=null)
		{
			paymentPriceLabel.setInputText(ProjectManager.get("paymentPriceLabel"));
			UIPaymentStringArray[3] = "paymentPriceLabel";
		}
            eai111.setRowDataPanel(paymentPriceLabel);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai111.setListItemIsRemovable(false);
		eai111.setValueBoxEnabled(false);
		eaItems[3] = eai111;
//
            EAListItem eai5 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentContinueButtonTextUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentContinueButtonTextUIStringItem.setLabelText("Continue Button Text:");
		if(ProjectManager.get("paymentContinueButtonText")!=null)
		{
			paymentContinueButtonTextUIStringItem.setInputText(ProjectManager.get("paymentContinueButtonText"));
			UIPaymentStringArray[4] = "paymentContinueButtonText";
		}
            eai5.setRowDataPanel(paymentContinueButtonTextUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai5.setListItemIsRemovable(false);
		eai5.setValueBoxEnabled(false);
		eaItems[4] = eai5;
//
            EAListItem eai103 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentContinueButtonMnemonic = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentContinueButtonMnemonic.setLabelText("Continue Button Mnemonic:");
		if(ProjectManager.get("paymentContinueButtonMnemonic")!=null)
		{
			paymentContinueButtonMnemonic.setInputText(ProjectManager.get("paymentContinueButtonMnemonic"));
			UIPaymentStringArray[5] = "paymentContinueButtonMnemonic";
		}
            eai103.setRowDataPanel(paymentContinueButtonMnemonic);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai103.setListItemIsRemovable(false);
		eai103.setValueBoxEnabled(false);
		eaItems[5] = eai103;

//
            EAListItem eai6 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentCancelButtonTextUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentCancelButtonTextUIStringItem.setLabelText("Cancel Button Text:");
		if(ProjectManager.get("paymentCancelButtonText")!=null)
		{
			paymentCancelButtonTextUIStringItem.setInputText(ProjectManager.get("paymentCancelButtonText"));
			UIPaymentStringArray[6] = "paymentCancelButtonText";
		}
            eai6.setRowDataPanel(paymentCancelButtonTextUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai6.setListItemIsRemovable(false);
		eai6.setValueBoxEnabled(false);
		eaItems[6] = eai6;
//
            EAListItem eai102 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentCancelButtonMnemonic = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentCancelButtonMnemonic.setLabelText("Cancel Button Mnemonic:");
		if(ProjectManager.get("paymentCancelButtonMnemonic")!=null)
		{
			paymentCancelButtonMnemonic.setInputText(ProjectManager.get("paymentCancelButtonMnemonic"));
			UIPaymentStringArray[7] = "paymentCancelButtonMnemonic";
		}
            eai102.setRowDataPanel(paymentCancelButtonMnemonic);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai102.setListItemIsRemovable(false);
		eai102.setValueBoxEnabled(false);
		eaItems[7] = eai102;
//
            EAListItem eai7 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentInstructionsLine1UIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentInstructionsLine1UIStringItem.setLabelText("Payment Instructions Line 1:");
		if(ProjectManager.get("paymentInstructionsLine1")!=null)
		{
			//paymentInstructionsLine1UIStringItem.setInputText(ProjectManager.get("paymentInstructionsLine1"));
			UIPaymentStringArray[8] = "paymentInstructionsLine1";
			paymentInstructionsLine1UIStringItem.setInputTextColor(Color.blue);
			paymentInstructionsLine1UIStringItem.setInputText("(Select the Label item to View, or Edit the Label below.)");
			paymentInstructionsLine1UIStringItem.setInputTextColor(Color.blue);
		}
            eai7.setRowDataPanel(paymentInstructionsLine1UIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai7.setListItemIsRemovable(false);
		eai7.setValueBoxEnabled(false);
		eaItems[8] = eai7;
//
            EAListItem eai13 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentVerificationCodeLabelUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentVerificationCodeLabelUIStringItem.setLabelText("Credit Card Verification Code Label:");
		if(ProjectManager.get("paymentVerificationCodeLabel")!=null)
		{
			paymentVerificationCodeLabelUIStringItem.setInputText(ProjectManager.get("paymentVerificationCodeLabel"));
			UIPaymentStringArray[9] = "paymentVerificationCodeLabel";
		}
            eai13.setRowDataPanel(paymentVerificationCodeLabelUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai13.setListItemIsRemovable(false);
		eai13.setValueBoxEnabled(false);
		eaItems[9] = eai13;
//
            EAListItem eai14 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentRefundPolicyLabelUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentRefundPolicyLabelUIStringItem.setLabelText("Refund Policy Label:");
		if(ProjectManager.get("paymentRefundPolicyLabel")!=null)
		{
			paymentRefundPolicyLabelUIStringItem.setInputText(ProjectManager.get("paymentRefundPolicyLabel"));
			UIPaymentStringArray[10] = "paymentRefundPolicyLabel";
		}
            eai14.setRowDataPanel(paymentRefundPolicyLabelUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai14.setListItemIsRemovable(false);
		eai14.setValueBoxEnabled(false);
		eaItems[10] = eai14;
//
            EAListItem eai15 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentFirstNameDataFieldEmptyMessageUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentFirstNameDataFieldEmptyMessageUIStringItem.setLabelText("First Name Data Field Empty Message:");
		if(ProjectManager.get("paymentFirstNameDataFieldEmptyMessage")!=null)
		{
			paymentFirstNameDataFieldEmptyMessageUIStringItem.setInputText(ProjectManager.get("paymentFirstNameDataFieldEmptyMessage"));
			UIPaymentStringArray[11] = "paymentFirstNameDataFieldEmptyMessage";
		}
            eai15.setRowDataPanel(paymentFirstNameDataFieldEmptyMessageUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai15.setListItemIsRemovable(false);
		eai15.setValueBoxEnabled(false);
		eaItems[11] = eai15;
//
            EAListItem eai16 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentLastNameDataFieldEmptyMessageUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentLastNameDataFieldEmptyMessageUIStringItem.setLabelText("Last Name Data Field Empty Message:");
		if(ProjectManager.get("paymentLastNameDataFieldEmptyMessage")!=null)
		{
			paymentLastNameDataFieldEmptyMessageUIStringItem.setInputText(ProjectManager.get("paymentLastNameDataFieldEmptyMessage"));
			UIPaymentStringArray[12] = "paymentLastNameDataFieldEmptyMessage";
		}
            eai16.setRowDataPanel(paymentLastNameDataFieldEmptyMessageUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai16.setListItemIsRemovable(false);
		eai16.setValueBoxEnabled(false);
		eaItems[12] = eai16;

//
            EAListItem eai17 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentValidEMailDataFieldEmptyMessageUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentValidEMailDataFieldEmptyMessageUIStringItem.setLabelText("Not a valid E-mail Address Message:");
		if(ProjectManager.get("paymentValidEMailDataFieldEmptyMessage")!=null)
		{
			paymentValidEMailDataFieldEmptyMessageUIStringItem.setInputText(ProjectManager.get("paymentValidEMailDataFieldEmptyMessage"));
			UIPaymentStringArray[13] = "paymentValidEMailDataFieldEmptyMessage";
		}
            eai17.setRowDataPanel(paymentValidEMailDataFieldEmptyMessageUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai17.setListItemIsRemovable(false);
		eai17.setValueBoxEnabled(false);
		eaItems[13] = eai17;
//
            EAListItem eai18 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentEMailDataFieldEmptyMessageUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentEMailDataFieldEmptyMessageUIStringItem.setLabelText("E-mail Data Field Empty Message:");
		if(ProjectManager.get("paymentEMailDataFieldEmptyMessage")!=null)
		{
			paymentEMailDataFieldEmptyMessageUIStringItem.setInputText(ProjectManager.get("paymentEMailDataFieldEmptyMessage"));
			UIPaymentStringArray[14] = "paymentEMailDataFieldEmptyMessage";
		}
            eai18.setRowDataPanel(paymentEMailDataFieldEmptyMessageUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai18.setListItemIsRemovable(false);
		eai18.setValueBoxEnabled(false);
		eaItems[14] = eai18;
//
            EAListItem eai19 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentStreetDataFieldEmptyMessageUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentStreetDataFieldEmptyMessageUIStringItem.setLabelText("Street Address Data Field Empty Message:");
		if(ProjectManager.get("paymentStreetDataFieldEmptyMessage")!=null)
		{
			paymentStreetDataFieldEmptyMessageUIStringItem.setInputText(ProjectManager.get("paymentStreetDataFieldEmptyMessage"));
			UIPaymentStringArray[15] = "paymentStreetDataFieldEmptyMessage";
		}
            eai19.setRowDataPanel(paymentStreetDataFieldEmptyMessageUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai19.setListItemIsRemovable(false);
		eai19.setValueBoxEnabled(false);
		eaItems[15] = eai19;
//
            EAListItem eai20 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentCityDataFieldEmptyMessageUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentCityDataFieldEmptyMessageUIStringItem.setLabelText("City Data Field Empty Message:");
		if(ProjectManager.get("paymentCityDataFieldEmptyMessage")!=null)
		{
			paymentCityDataFieldEmptyMessageUIStringItem.setInputText(ProjectManager.get("paymentCityDataFieldEmptyMessage"));
			UIPaymentStringArray[16] = "paymentCityDataFieldEmptyMessage";
		}
            eai20.setRowDataPanel(paymentCityDataFieldEmptyMessageUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai20.setListItemIsRemovable(false);
		eai20.setValueBoxEnabled(false);
		eaItems[16] = eai20;

//
            EAListItem eai21 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentZipDataFieldEmptyMessageUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentZipDataFieldEmptyMessageUIStringItem.setLabelText("Zip Code Data Field Empty Message:");
		if(ProjectManager.get("paymentZipDataFieldEmptyMessage")!=null)
		{
			paymentZipDataFieldEmptyMessageUIStringItem.setInputText(ProjectManager.get("paymentZipDataFieldEmptyMessage"));
			UIPaymentStringArray[17] = "paymentZipDataFieldEmptyMessage";
		}
            eai21.setRowDataPanel(paymentZipDataFieldEmptyMessageUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai21.setListItemIsRemovable(false);
		eai21.setValueBoxEnabled(false);
		eaItems[17] = eai21;
//
            EAListItem eai22 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentCCDataFieldEmptyMessageUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentCCDataFieldEmptyMessageUIStringItem.setLabelText("Incomplete Credit Card Number Message:");
		if(ProjectManager.get("paymentCCDataFieldEmptyMessage")!=null)
		{
			paymentCCDataFieldEmptyMessageUIStringItem.setInputText(ProjectManager.get("paymentCCDataFieldEmptyMessage"));
			UIPaymentStringArray[18] = "paymentCCDataFieldEmptyMessage";
		}
            eai22.setRowDataPanel(paymentCCDataFieldEmptyMessageUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai22.setListItemIsRemovable(false);
		eai22.setValueBoxEnabled(false);
		eaItems[18] = eai22;
//
            EAListItem eai23 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentCCVerificationCodeFieldEmptyMessageUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentCCVerificationCodeFieldEmptyMessageUIStringItem.setLabelText("Credit Card Verification Code Data Field Empty Message:");
		if(ProjectManager.get("paymentCCVerificationCodeFieldEmptyMessage")!=null)
		{
			//paymentCCVerificationCodeFieldEmptyMessageUIStringItem.setInputText(ProjectManager.get("paymentCCVerificationCodeFieldEmptyMessage"));
			UIPaymentStringArray[19] = "paymentCCVerificationCodeFieldEmptyMessage";
			paymentCCVerificationCodeFieldEmptyMessageUIStringItem.setInputTextColor(Color.blue);
			paymentCCVerificationCodeFieldEmptyMessageUIStringItem.setInputText("(Select the Label item to View, or Edit the Label below.)");
			paymentCCVerificationCodeFieldEmptyMessageUIStringItem.setInputTextColor(Color.blue);
		}
            eai23.setRowDataPanel(paymentCCVerificationCodeFieldEmptyMessageUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai23.setListItemIsRemovable(false);
		eai23.setValueBoxEnabled(false);
		eaItems[19] = eai23;
//
            EAListItem eai100 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentPhoneDataFieldEmptyMessage = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentPhoneDataFieldEmptyMessage.setLabelText("Telephone Data Field Empty Message:");
		if(ProjectManager.get("paymentPhoneDataFieldEmptyMessage")!=null)
		{
			paymentPhoneDataFieldEmptyMessage.setInputText(ProjectManager.get("paymentPhoneDataFieldEmptyMessage"));
			UIPaymentStringArray[20] = "paymentPhoneDataFieldEmptyMessage";
		}
            eai100.setRowDataPanel(paymentPhoneDataFieldEmptyMessage);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai100.setListItemIsRemovable(false);
		eai100.setValueBoxEnabled(false);
		eaItems[20] = eai100;
//
            EAListItem eai24 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentFirstNameLabelUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentFirstNameLabelUIStringItem.setLabelText("First Name Label:");
		if(ProjectManager.get("paymentFirstNameLabel")!=null)
		{
			paymentFirstNameLabelUIStringItem.setInputText(ProjectManager.get("paymentFirstNameLabel"));
			UIPaymentStringArray[21] = "paymentFirstNameLabel";
		}
            eai24.setRowDataPanel(paymentFirstNameLabelUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai24.setListItemIsRemovable(false);
		eai24.setValueBoxEnabled(false);
		eaItems[21] = eai24;

//
            EAListItem eai25 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentLastNameLabelUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentLastNameLabelUIStringItem.setLabelText("Last Name Label:");
		if(ProjectManager.get("paymentLastNameLabel")!=null)
		{
			paymentLastNameLabelUIStringItem.setInputText(ProjectManager.get("paymentLastNameLabel"));
			UIPaymentStringArray[22] = "paymentLastNameLabel";
		}
            eai25.setRowDataPanel(paymentLastNameLabelUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai25.setListItemIsRemovable(false);
		eai25.setValueBoxEnabled(false);
		eaItems[22] = eai25;
//
            EAListItem eai26 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentEMailLabelUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentEMailLabelUIStringItem.setLabelText("E-mail Address Label:");
		if(ProjectManager.get("paymentEMailLabel")!=null)
		{
			paymentEMailLabelUIStringItem.setInputText(ProjectManager.get("paymentEMailLabel"));
			UIPaymentStringArray[23] = "paymentEMailLabel";
		}
            eai26.setRowDataPanel(paymentEMailLabelUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai26.setListItemIsRemovable(false);
		eai26.setValueBoxEnabled(false);
		eaItems[23] = eai26;
//
            EAListItem eai27 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentStreetLabelUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentStreetLabelUIStringItem.setLabelText("Street Address Label:");
		if(ProjectManager.get("paymentStreetLabel")!=null)
		{
			paymentStreetLabelUIStringItem.setInputText(ProjectManager.get("paymentStreetLabel"));
			UIPaymentStringArray[24] = "paymentStreetLabel";
		}
            eai27.setRowDataPanel(paymentStreetLabelUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai27.setListItemIsRemovable(false);
		eai27.setValueBoxEnabled(false);
		eaItems[24] = eai27;
//
            EAListItem eai28 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentCityLabelUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentCityLabelUIStringItem.setLabelText("City Label:");
		if(ProjectManager.get("paymentCityLabel")!=null)
		{
			paymentCityLabelUIStringItem.setInputText(ProjectManager.get("paymentCityLabel"));
			UIPaymentStringArray[25] = "paymentCityLabel";
		}
            eai28.setRowDataPanel(paymentCityLabelUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai28.setListItemIsRemovable(false);
		eai28.setValueBoxEnabled(false);
		eaItems[25] = eai28;

//
            EAListItem eai3 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentStateLabelUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentStateLabelUIStringItem.setLabelText("State Label:");
		if(ProjectManager.get("paymentStateLabel")!=null)
		{
			paymentStateLabelUIStringItem.setInputText(ProjectManager.get("paymentStateLabel"));
			UIPaymentStringArray[26] = "paymentStateLabel";
		}
            eai3.setRowDataPanel(paymentStateLabelUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai3.setListItemIsRemovable(false);
		eai3.setValueBoxEnabled(false);
		eaItems[26] = eai3;
//
            EAListItem eai4 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentExpMMYYLabelUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentExpMMYYLabelUIStringItem.setLabelText("Credit Card Expiration Date Label:");
		if(ProjectManager.get("paymentExpMMYYLabel")!=null)
		{
			paymentExpMMYYLabelUIStringItem.setInputText(ProjectManager.get("paymentExpMMYYLabel"));
			UIPaymentStringArray[27] = "paymentExpMMYYLabel";
		}
            eai4.setRowDataPanel(paymentExpMMYYLabelUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai4.setListItemIsRemovable(false);
		eai4.setValueBoxEnabled(false);
		eaItems[27] = eai4;
//
            EAListItem eai29 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentCountryLabelUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentCountryLabelUIStringItem.setLabelText("Country Label:");
		if(ProjectManager.get("paymentCountryLabel")!=null)
		{
			paymentCountryLabelUIStringItem.setInputText(ProjectManager.get("paymentCountryLabel"));
			UIPaymentStringArray[28] = "paymentCountryLabel";
		}
            eai29.setRowDataPanel(paymentCountryLabelUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai29.setListItemIsRemovable(false);
		eai29.setValueBoxEnabled(false);
		eaItems[28] = eai29;
//
            EAListItem eai30 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentZipCodeLabelUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentZipCodeLabelUIStringItem.setLabelText("Zip Code Label:");
		if(ProjectManager.get("paymentZipCodeLabel")!=null)
		{
			paymentZipCodeLabelUIStringItem.setInputText(ProjectManager.get("paymentZipCodeLabel"));
			UIPaymentStringArray[29] = "paymentZipCodeLabel";
		}
            eai30.setRowDataPanel(paymentZipCodeLabelUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai30.setListItemIsRemovable(false);
		eai30.setValueBoxEnabled(false);
		eaItems[29] = eai30;
//
            EAListItem eai31 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentPaymentMethodLabelUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentPaymentMethodLabelUIStringItem.setLabelText("Payment Method Label:");
		if(ProjectManager.get("paymentPaymentMethodLabel")!=null)
		{
			paymentPaymentMethodLabelUIStringItem.setInputText(ProjectManager.get("paymentPaymentMethodLabel"));
			UIPaymentStringArray[30] = "paymentPaymentMethodLabel";
		}
            eai31.setRowDataPanel(paymentPaymentMethodLabelUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai31.setListItemIsRemovable(false);
		eai31.setValueBoxEnabled(false);
		eaItems[30] = eai31;
//
            EAListItem eai32 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentCCLabelUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentCCLabelUIStringItem.setLabelText("Credit Card Number Label:");
		if(ProjectManager.get("paymentCCLabel")!=null)
		{
			paymentCCLabelUIStringItem.setInputText(ProjectManager.get("paymentCCLabel"));
			UIPaymentStringArray[31] = "paymentCCLabel";
		}
            eai32.setRowDataPanel(paymentCCLabelUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai32.setListItemIsRemovable(false);
		eai32.setValueBoxEnabled(false);
		eaItems[31] = eai32;
//


            EAListItem eai101 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentPhoneLabel = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentPhoneLabel.setLabelText("Telephone Label:");
		if(ProjectManager.get("paymentPhoneLabel")!=null)
		{
			paymentPhoneLabel.setInputText(ProjectManager.get("paymentPhoneLabel"));
			UIPaymentStringArray[32] = "paymentPhoneLabel";
		}
            eai101.setRowDataPanel(paymentPhoneLabel);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai101.setListItemIsRemovable(false);
		eai101.setValueBoxEnabled(false);
		eaItems[32] = eai101;
//

            EAListItem eai33 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentOrdersOutsideUSLabelUIStringItem = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentOrdersOutsideUSLabelUIStringItem.setLabelText("INT for Orders Outside US Label:");
		if(ProjectManager.get("paymentOrdersOutsideUSLabel")!=null)
		{
			paymentOrdersOutsideUSLabelUIStringItem.setInputText(ProjectManager.get("paymentOrdersOutsideUSLabel"));
			UIPaymentStringArray[33] = "paymentOrdersOutsideUSLabel";
		}
            eai33.setRowDataPanel(paymentOrdersOutsideUSLabelUIStringItem);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai33.setListItemIsRemovable(false);
		eai33.setValueBoxEnabled(false);
		eaItems[33] = eai33;
//
            EAListItem eai34 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent refundPolicy = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		refundPolicy.setLabelText("Refund Policy:");
		if(ProjectManager.get("refundPolicy")!=null)
		{
			//refundPolicy.setInputText(ProjectManager.get("refundPolicy"));
			UIPaymentStringArray[34] = "refundPolicy";
			refundPolicy.setInputTextColor(Color.blue);
			refundPolicy.setInputText("(Select the Label item to View, or Edit the Label below.)");
			refundPolicy.setInputTextColor(Color.blue);
		}
            eai34.setRowDataPanel(refundPolicy);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai34.setListItemIsRemovable(false);
		eai34.setValueBoxEnabled(false);
		eaItems[34] = eai34;
//
            EAListItem eai35 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent refundPolicyTitle = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		refundPolicyTitle.setLabelText("Refund Policy Title:");
		if(ProjectManager.get("refundPolicyTitle")!=null)
		{
			refundPolicyTitle.setInputText(ProjectManager.get("refundPolicyTitle"));
			UIPaymentStringArray[35] = "refundPolicyTitle";
		}
            eai35.setRowDataPanel(refundPolicyTitle);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai35.setListItemIsRemovable(false);
		eai35.setValueBoxEnabled(false);
		eaItems[35] = eai35;
//
            EAListItem eai109 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentSSLEnabledText = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentSSLEnabledText.setLabelText("SSL Enabled Text:");
		if(ProjectManager.get("paymentSSLEnabledText")!=null)
		{
			paymentSSLEnabledText.setInputText(ProjectManager.get("paymentSSLEnabledText"));
			UIPaymentStringArray[36] = "paymentSSLEnabledText";
		}
            eai109.setRowDataPanel(paymentSSLEnabledText);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai109.setListItemIsRemovable(false);
		eai109.setValueBoxEnabled(false);
		eaItems[36] = eai109;
//
            EAListItem eai107 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent secondaryPaymentMethodButtonText = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		secondaryPaymentMethodButtonText.setLabelText("Secondary Payment Method Button Text:");
		if(ProjectManager.get("secondaryPaymentMethodButtonText")!=null)
		{
			secondaryPaymentMethodButtonText.setInputText(ProjectManager.get("secondaryPaymentMethodButtonText"));
			UIPaymentStringArray[37] = "secondaryPaymentMethodButtonText";
		}
            eai107.setRowDataPanel(secondaryPaymentMethodButtonText);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai107.setListItemIsRemovable(false);
		eai107.setValueBoxEnabled(false);
		eaItems[37] = eai107;
//
            EAListItem eai108 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent secondaryPaymentMethodButtonMnemonic = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		secondaryPaymentMethodButtonMnemonic.setLabelText("Secondary Payment Method Button Mnemonic:");
		if(ProjectManager.get("secondaryPaymentMethodButtonMnemonic")!=null)
		{
			secondaryPaymentMethodButtonMnemonic.setInputText(ProjectManager.get("secondaryPaymentMethodButtonMnemonic"));
			UIPaymentStringArray[38] = "secondaryPaymentMethodButtonMnemonic";
		}
            eai108.setRowDataPanel(secondaryPaymentMethodButtonMnemonic);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai108.setListItemIsRemovable(false);
		eai108.setValueBoxEnabled(false);
		eaItems[38] = eai108;
//

		UIPaymentEAListItemArray = eaItems;

		return eaItems;
        }
        catch(Exception e)
        {
          e.printStackTrace();   
        }
	EAListItem[] tempLIArray2 = new EAListItem[0];
	return tempLIArray2;
}

private String[] strSuccessUserInterfaceArray = new String[10];
private EAListItem[] UISuccessEAListItemArray = new EAListItem[10];
private EAListItem[] getUISuccessEAListItems()
{
	  eaPropPanel = 3;
        try
        {
		int defUIStringLabelWidth = 325;
		int defUIStringDataWidth = 325;

		EAListItem[] eaItems = new EAListItem[10];
            EAListItem eai = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentSuccessResponsePanelTitle = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentSuccessResponsePanelTitle.setLabelText("Title: ");
		if(ProjectManager.get("paymentSuccessResponsePanelTitle")!=null)
		{
			paymentSuccessResponsePanelTitle.setInputText(ProjectManager.get("paymentSuccessResponsePanelTitle"));
			strSuccessUserInterfaceArray[0] = "paymentSuccessResponsePanelTitle";
		}
            eai.setRowDataPanel(paymentSuccessResponsePanelTitle);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai.setListItemIsRemovable(false);
		eai.setValueBoxEnabled(false);
		eaItems[0] = eai;
//
            EAListItem eai2 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentSuccessResponsePanelHeaderDescription = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentSuccessResponsePanelHeaderDescription.setLabelText("Header Description:");
		if(ProjectManager.get("paymentSuccessResponsePanelHeaderDescription")!=null)
		{
			//paymentSuccessResponsePanelHeaderDescription.setInputText(ProjectManager.get("paymentSuccessResponsePanelHeaderDescription"));
			strSuccessUserInterfaceArray[1] = "paymentSuccessResponsePanelHeaderDescription";
			paymentSuccessResponsePanelHeaderDescription.setInputTextColor(Color.blue);
			paymentSuccessResponsePanelHeaderDescription.setInputText("(Select the Label item to View, or Edit the Label below.)");
			paymentSuccessResponsePanelHeaderDescription.setInputTextColor(Color.blue);
		}
            eai2.setRowDataPanel(paymentSuccessResponsePanelHeaderDescription);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai2.setListItemIsRemovable(false);
		eai2.setValueBoxEnabled(false);
		eaItems[1] = eai2;
//
            EAListItem eai3 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentSuccessResponsePanelOrderID = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentSuccessResponsePanelOrderID.setLabelText("Order ID Label:");
		if(ProjectManager.get("paymentSuccessResponsePanelOrderID")!=null)
		{
			paymentSuccessResponsePanelOrderID.setInputText(ProjectManager.get("paymentSuccessResponsePanelOrderID"));
			strSuccessUserInterfaceArray[2] = "paymentSuccessResponsePanelOrderID";
		}
            eai3.setRowDataPanel(paymentSuccessResponsePanelOrderID);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai3.setListItemIsRemovable(false);
		eai3.setValueBoxEnabled(false);
		eaItems[2] = eai3;
//
            EAListItem eai4 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentSuccessResponsePanelNameOnCard = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentSuccessResponsePanelNameOnCard.setLabelText("Full Name Label:");
		if(ProjectManager.get("paymentSuccessResponsePanelNameOnCard")!=null)
		{
			paymentSuccessResponsePanelNameOnCard.setInputText(ProjectManager.get("paymentSuccessResponsePanelNameOnCard"));
			strSuccessUserInterfaceArray[3] = "paymentSuccessResponsePanelNameOnCard";
		}
            eai4.setRowDataPanel(paymentSuccessResponsePanelNameOnCard);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai4.setListItemIsRemovable(false);
		eai4.setValueBoxEnabled(false);
		eaItems[3] = eai4;
//
            EAListItem eai5 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentSuccessResponsePanelEMailAddress = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentSuccessResponsePanelEMailAddress.setLabelText("E-mail Address Label:");
		if(ProjectManager.get("paymentSuccessResponsePanelEMailAddress")!=null)
		{
			paymentSuccessResponsePanelEMailAddress.setInputText(ProjectManager.get("paymentSuccessResponsePanelEMailAddress"));
			strSuccessUserInterfaceArray[4] = "paymentSuccessResponsePanelEMailAddress";
		}
            eai5.setRowDataPanel(paymentSuccessResponsePanelEMailAddress);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai5.setListItemIsRemovable(false);
		eai5.setValueBoxEnabled(false);
		eaItems[4] = eai5;
//
            EAListItem eai7 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentSuccessResponsePanelAmountBilled = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentSuccessResponsePanelAmountBilled.setLabelText("Total Amount Billed Label:");
		if(ProjectManager.get("paymentSuccessResponsePanelAmountBilled")!=null)
		{
			paymentSuccessResponsePanelAmountBilled.setInputText(ProjectManager.get("paymentSuccessResponsePanelAmountBilled"));
			strSuccessUserInterfaceArray[5] = "paymentSuccessResponsePanelAmountBilled";
		}
            eai7.setRowDataPanel(paymentSuccessResponsePanelAmountBilled);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai7.setListItemIsRemovable(false);
		eai7.setValueBoxEnabled(false);
		eaItems[5] = eai7;
//
            EAListItem eai8 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentSuccessResponsePanelMessage = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentSuccessResponsePanelMessage.setLabelText("Payment Success Message:");
		if(ProjectManager.get("paymentSuccessResponsePanelMessage")!=null)
		{
			//paymentSuccessResponsePanelMessage.setInputText(ProjectManager.get("paymentSuccessResponsePanelMessage"));
			strSuccessUserInterfaceArray[6] = "paymentSuccessResponsePanelMessage";
			paymentSuccessResponsePanelMessage.setInputTextColor(Color.blue);
			paymentSuccessResponsePanelMessage.setInputText("(Select the Label item to View, or Edit the Label below.)");
			paymentSuccessResponsePanelMessage.setInputTextColor(Color.blue);
		}
            eai8.setRowDataPanel(paymentSuccessResponsePanelMessage);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai8.setListItemIsRemovable(false);
		eai8.setValueBoxEnabled(false);
		eaItems[6] = eai8;

//
            EAListItem eai9 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentSuccessResponsePanelImagePath = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentSuccessResponsePanelImagePath.setLabelText("Finish Button Text:");
		if(ProjectManager.get("paymentSuccessFinishButtonText")!=null)
		{
			paymentSuccessResponsePanelImagePath.setInputText(ProjectManager.get("paymentSuccessFinishButtonText"));
			strSuccessUserInterfaceArray[7] = "paymentSuccessFinishButtonText";
		}
            eai9.setRowDataPanel(paymentSuccessResponsePanelImagePath);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai9.setListItemIsRemovable(false);
		eai9.setValueBoxEnabled(false);
		eaItems[7] = eai9;
//
            EAListItem eai10 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentSuccessResponsePanelImageHeight = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentSuccessResponsePanelImageHeight.setLabelText("Finish Button Mnemonic:");
		if(ProjectManager.get("paymentSuccessFinishButtonMnemonic")!=null)
		{
			paymentSuccessResponsePanelImageHeight.setInputText(ProjectManager.get("paymentSuccessFinishButtonMnemonic"));
			strSuccessUserInterfaceArray[8] = "paymentSuccessFinishButtonMnemonic";
		}
            eai10.setRowDataPanel(paymentSuccessResponsePanelImageHeight);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai10.setListItemIsRemovable(false);
		eai10.setValueBoxEnabled(false);
		eaItems[8] = eai10;
//
            EAListItem eai13 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentGenericAuthResponseSuccessMsg = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentGenericAuthResponseSuccessMsg.setLabelText("Authorization Success Response Message:");
		if(ProjectManager.get("paymentGenericAuthResponseSuccessMsg")!=null)
		{
			paymentGenericAuthResponseSuccessMsg.setInputText(ProjectManager.get("paymentGenericAuthResponseSuccessMsg"));
			strSuccessUserInterfaceArray[9] = "paymentGenericAuthResponseSuccessMsg";
		}
            eai13.setRowDataPanel(paymentGenericAuthResponseSuccessMsg);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai13.setListItemIsRemovable(false);
		eai13.setValueBoxEnabled(false);
		eaItems[9] = eai13;

		UISuccessEAListItemArray = eaItems;

		return eaItems;
        }
        catch(Exception e)
        {
          e.printStackTrace();   
        }
	EAListItem[] tempLIArray2 = new EAListItem[0];
	return tempLIArray2;
}

private String[] UIFailedStringArray = new String[10];
private EAListItem[] UIFailedEAListItemArray = new EAListItem[10];
private EAListItem[] getUIFailedStringEAListItems()
{
	  eaPropPanel = 4;
        try
        {
		int defUIStringLabelWidth = 325;
		int defUIStringDataWidth = 325;
		int theTotalDeclinedMessages = 0;
	      if(ProjectManager.get("paymentResponseStatTotalMessages")!=null)
            {
		      if(ProjectManager.get("paymentResponseStatTotalMessages").equalsIgnoreCase("")==false)
      	      {
                 		theTotalDeclinedMessages = Integer.valueOf(ProjectManager.get("paymentResponseStatTotalMessages")).intValue();
			}
		}
		UIFailedStringArray = new String[10 + theTotalDeclinedMessages];

            EAListItem eai = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentFailureResponsePanelTitle = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentFailureResponsePanelTitle.setLabelText("Title: ");
		if(ProjectManager.get("paymentFailureResponsePanelTitle")!=null)
		{
			paymentFailureResponsePanelTitle.setInputText(ProjectManager.get("paymentFailureResponsePanelTitle"));
			UIFailedStringArray[0]="paymentFailureResponsePanelTitle";
		}
            eai.setRowDataPanel(paymentFailureResponsePanelTitle);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai.setListItemIsRemovable(false);
		eai.setValueBoxEnabled(false);
//
            EAListItem eai2 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentFailureResponsePanelHeaderDescription = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentFailureResponsePanelHeaderDescription.setLabelText("Header Description:");
		if(ProjectManager.get("paymentFailureResponsePanelHeaderDescription")!=null)
		{
			paymentFailureResponsePanelHeaderDescription.setInputTextColor(Color.blue);
			paymentFailureResponsePanelHeaderDescription.setInputText("(Select the Label item to View, or Edit the Label below.)");
			paymentFailureResponsePanelHeaderDescription.setInputTextColor(Color.blue);
			UIFailedStringArray[1]="paymentFailureResponsePanelHeaderDescription";
		}
            eai2.setRowDataPanel(paymentFailureResponsePanelHeaderDescription);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai2.setListItemIsRemovable(false);
		eai2.setValueBoxEnabled(false);
//
            EAListItem eai3 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentFailureResponsePanelOrderID = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentFailureResponsePanelOrderID.setLabelText("Order ID Label:");
		if(ProjectManager.get("paymentFailureResponsePanelOrderID")!=null)
		{
			paymentFailureResponsePanelOrderID.setInputText(ProjectManager.get("paymentFailureResponsePanelOrderID"));
			UIFailedStringArray[2]="paymentFailureResponsePanelOrderID";
		}
            eai3.setRowDataPanel(paymentFailureResponsePanelOrderID);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai3.setListItemIsRemovable(false);
		eai3.setValueBoxEnabled(false);
//
            EAListItem eai4 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentFailureResponsePanelNameOnCard = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentFailureResponsePanelNameOnCard.setLabelText("Full Name Label:");
		if(ProjectManager.get("paymentFailureResponsePanelNameOnCard")!=null)
		{
			paymentFailureResponsePanelNameOnCard.setInputText(ProjectManager.get("paymentFailureResponsePanelNameOnCard"));
			UIFailedStringArray[3]="paymentFailureResponsePanelNameOnCard";
		}
            eai4.setRowDataPanel(paymentFailureResponsePanelNameOnCard);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai4.setListItemIsRemovable(false);
		eai4.setValueBoxEnabled(false);
//
            EAListItem eai5 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentFailureResponsePanelEMailAddress = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentFailureResponsePanelEMailAddress.setLabelText("E-mail Address Label:");
		if(ProjectManager.get("paymentFailureResponsePanelEMailAddress")!=null)
		{
			paymentFailureResponsePanelEMailAddress.setInputText(ProjectManager.get("paymentFailureResponsePanelEMailAddress"));
			UIFailedStringArray[4]="paymentFailureResponsePanelEMailAddress";
		}
            eai5.setRowDataPanel(paymentFailureResponsePanelEMailAddress);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai5.setListItemIsRemovable(false);
		eai5.setValueBoxEnabled(false);
//
            EAListItem eai6 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentFailureResponsePanelAmountBilled = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentFailureResponsePanelAmountBilled.setLabelText("Total Amount Billed Label:");
		if(ProjectManager.get("paymentFailureResponsePanelAmountBilled")!=null)
		{
			paymentFailureResponsePanelAmountBilled.setInputText(ProjectManager.get("paymentFailureResponsePanelAmountBilled"));
			UIFailedStringArray[5]="paymentFailureResponsePanelAmountBilled";
		}
            eai6.setRowDataPanel(paymentFailureResponsePanelAmountBilled);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai6.setListItemIsRemovable(false);
		eai6.setValueBoxEnabled(false);
//
            EAListItem eai7 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentFailureResponsePanelMessage = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentFailureResponsePanelMessage.setLabelText("Payment Failure Message:");
		if(ProjectManager.get("paymentFailureResponsePanelMessage")!=null)
		{
			paymentFailureResponsePanelMessage.setInputTextColor(Color.blue);
			paymentFailureResponsePanelMessage.setInputText("(Select the Label item to View, or Edit the Label below.)");
			paymentFailureResponsePanelMessage.setInputTextColor(Color.blue);
			UIFailedStringArray[6]="paymentFailureResponsePanelMessage";
		}
            eai7.setRowDataPanel(paymentFailureResponsePanelMessage);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai7.setListItemIsRemovable(false);
		eai7.setValueBoxEnabled(false);
	//
            EAListItem eai8 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentFailureResponsePanelImageHeight = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentFailureResponsePanelImageHeight.setLabelText("Try Again Button Text:");
		if(ProjectManager.get("paymentFailureRetryButtonText")!=null)
		{
			paymentFailureResponsePanelImageHeight.setInputText(ProjectManager.get("paymentFailureRetryButtonText"));
			UIFailedStringArray[7]="paymentFailureRetryButtonText";
		}
            eai8.setRowDataPanel(paymentFailureResponsePanelImageHeight);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai8.setListItemIsRemovable(false);
		eai8.setValueBoxEnabled(false);
//
            EAListItem eai9 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentFailureResponsePanelImageWidth = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentFailureResponsePanelImageWidth.setLabelText("Try Again Button Mnemonic:");
		if(ProjectManager.get("paymentFailureRetryButtonMnemonic")!=null)
		{
			paymentFailureResponsePanelImageWidth.setInputText(ProjectManager.get("paymentFailureRetryButtonMnemonic"));
			UIFailedStringArray[8]="paymentFailureRetryButtonMnemonic";
		}
            eai9.setRowDataPanel(paymentFailureResponsePanelImageWidth);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai9.setListItemIsRemovable(false);
		eai9.setValueBoxEnabled(false);
//
            EAListItem eai10 = new EAListItem(theUIStringRowIcon,rowColor);
		EAListItemContent paymentGenericAuthResponseFailureMsg = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
		paymentGenericAuthResponseFailureMsg.setLabelText("Generic Authorization Failure Response Message:");
		if(ProjectManager.get("paymentGenericAuthResponseFailureMsg")!=null)
		{
			paymentGenericAuthResponseFailureMsg.setInputText(ProjectManager.get("paymentGenericAuthResponseFailureMsg"));
			UIFailedStringArray[9]="paymentGenericAuthResponseFailureMsg";
		}
            eai10.setRowDataPanel(paymentGenericAuthResponseFailureMsg);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai10.setListItemIsRemovable(false);
		eai10.setValueBoxEnabled(false);
////////////////////////////////////////////////////
		Object[] theObjArray = new Object[0];
		theTotalDeclinedMessages = 0;
	      if(ProjectManager.get("paymentResponseStatTotalMessages")!=null)
            {
		      if(ProjectManager.get("paymentResponseStatTotalMessages").equalsIgnoreCase("")==false)
      	      {
                 		theTotalDeclinedMessages = Integer.valueOf(ProjectManager.get("paymentResponseStatTotalMessages")).intValue();
				if(0<theTotalDeclinedMessages)
				{
					theObjArray = new Object[theTotalDeclinedMessages];
				}
			}
		}

		for(int i = 0;i<theTotalDeclinedMessages;i++)
		{
			try
			{
				theObjArray[i] = ProjectManager.get("paymentResponseMsgDeclined" + String.valueOf(i + 1));
				UIFailedStringArray[10 + i]="paymentResponseMsgDeclined" + String.valueOf(i + 1);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			} 
		}

		if(0<theObjArray.length)
		{
			EAListItem[] eaItems = new EAListItem[10 + theObjArray.length];
			eaItems[0] = eai;
			eaItems[1] = eai2;
			eaItems[2] = eai3;
			eaItems[3] = eai4;
			eaItems[4] = eai5;
			eaItems[5] = eai6;
			eaItems[6] = eai7;
			eaItems[7] = eai8;
			eaItems[8] = eai9;
			eaItems[9] = eai10;
			for(int i = 0;i<theObjArray.length;i++)
			{
            		EAListItem eaiNext = new EAListItem(theRowIcon,rowColor);
				EAListItemContent inputNameItem = new EAListItemContent(rowColor, defUIStringLabelWidth, 175,175);
				if(theObjArray[i]!=null)
				{
						inputNameItem.setLabelText("Response Document Authorization Failure Message " + String.valueOf(i + 1) + ":");
						inputNameItem.setInputText((String)theObjArray[i]);
						eaiNext.setRowDataPanel(inputNameItem);
						eaiNext.setValueBoxEnabled(false);
						eaItems[i + 10] = eaiNext;
				}
			}
			UIFailedEAListItemArray = new EAListItem[eaItems.length]; 
			UIFailedEAListItemArray=eaItems;
			return eaItems;
		}
		else
		{
			EAListItem[] tempLIArray = {eai,eai2,eai3,eai4,eai5,eai6,eai7,eai8,eai9,eai10};
			UIFailedEAListItemArray=tempLIArray;
			return tempLIArray;
		}

///////////////////////////////////////////////////

        }
        catch(Exception e)
        {
          e.printStackTrace();   
        }
	EAListItem[] tempLIArray2 = new EAListItem[0];
	return tempLIArray2;
}

//private String[] strHTMLFormPaymentArray = new String[21];
//private EAListItem[] HTMLFormPaymentEAListItemArray = new EAListItem[21];
private EAListItem[] getHTMLFormPaymentEAListItems()
{
	  eaPropPanel = 5;
        try
        {
		int defUIStringLabelWidth = 300;
		int defUIStringDataWidth = 350;

            EAListItem eai = new EAListItem(theRowIcon,rowColor);
            EAListItemContent inputNameFirstName = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            inputNameFirstName.setLabelText("First Name Input Name Attribute: ");
            if(ProjectManager.get("inputNameFirstName")!=null)
            {
                   inputNameFirstName.setInputText(ProjectManager.get("inputNameFirstName"));
                    ////strHTMLFormPaymentArray[0] = "inputNameFirstName";
            }
            eai.setRowDataPanel(inputNameFirstName);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai.setListItemIsRemovable(false);
            eai.setValueBoxEnabled(false);
//
            EAListItem eai2 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent inputNameLastName = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            inputNameLastName.setLabelText("Last Name Input Name Attribute:");
            if(ProjectManager.get("inputNameLastName")!=null)
            {
                    inputNameLastName.setInputText(ProjectManager.get("inputNameLastName"));
                    //strHTMLFormPaymentArray[1] = "inputNameLastName";
            }
            eai2.setRowDataPanel(inputNameLastName);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai2.setListItemIsRemovable(false);
            eai2.setValueBoxEnabled(false);
//
            EAListItem eai3 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent inputNameAddress = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            inputNameAddress.setLabelText("Street Address Input Name Attribute:");
            if(ProjectManager.get("inputNameAddress")!=null)
            {
                    inputNameAddress.setInputText(ProjectManager.get("inputNameAddress"));
                    //strHTMLFormPaymentArray[2] = "inputNameAddress";
            }
            eai3.setRowDataPanel(inputNameAddress);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai3.setListItemIsRemovable(false);
            eai3.setValueBoxEnabled(false);
//
            EAListItem eai4 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent inputNameCity = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            inputNameCity.setLabelText("City Input Name Attribute:");
            if(ProjectManager.get("inputNameCity")!=null)
            {
                    inputNameCity.setInputText(ProjectManager.get("inputNameCity"));
                    //strHTMLFormPaymentArray[3] = "inputNameCity";
            }
            eai4.setRowDataPanel(inputNameCity);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai4.setListItemIsRemovable(false);
            eai4.setValueBoxEnabled(false);
//
            EAListItem eai5 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent inputNameState = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            inputNameState.setLabelText("State Input Name Attribute:");
            if(ProjectManager.get("inputNameState")!=null)
            {
                    inputNameState.setInputText(ProjectManager.get("inputNameState"));
                    //strHTMLFormPaymentArray[4] = "inputNameState";
            }
            eai5.setRowDataPanel(inputNameState);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai5.setListItemIsRemovable(false);
            eai5.setValueBoxEnabled(false);
//
            EAListItem eai6 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent inputNameZip = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            inputNameZip.setLabelText("Zip Code Input Name Attribute:");
            if(ProjectManager.get("inputNameZip")!=null)
            {
                    inputNameZip.setInputText(ProjectManager.get("inputNameZip"));
                    //strHTMLFormPaymentArray[5] = "inputNameZip";
            }
            eai6.setRowDataPanel(inputNameZip);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai6.setListItemIsRemovable(false);
            eai6.setValueBoxEnabled(false);
//
            EAListItem eai7 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent inputNameCountry = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            inputNameCountry.setLabelText("Country Input Name Attribute:");
            if(ProjectManager.get("inputNameCountry")!=null)
            {
                    inputNameCountry.setInputText(ProjectManager.get("inputNameCountry"));
                    //strHTMLFormPaymentArray[5] = "inputNameCountry";
            }
            eai7.setRowDataPanel(inputNameCountry);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai7.setListItemIsRemovable(false);
            eai7.setValueBoxEnabled(false);
//
            EAListItem eai8 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent inputNameEMail = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            inputNameEMail.setLabelText("E-mail Address Input Name Attribute:");
            if(ProjectManager.get("inputNameEMail")!=null)
            {
                    inputNameEMail.setInputText(ProjectManager.get("inputNameEMail"));
                    //strHTMLFormPaymentArray[7] = "inputNameEMail";
            }
            eai8.setRowDataPanel(inputNameEMail);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai8.setListItemIsRemovable(false);
            eai8.setValueBoxEnabled(false);
//
            EAListItem eai9 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent inputNamePaymentMethod = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            inputNamePaymentMethod.setLabelText("Payment Method Input Name Attribute:");
            if(ProjectManager.get("inputNamePaymentMethod")!=null)
            {
                    inputNamePaymentMethod.setInputText(ProjectManager.get("inputNamePaymentMethod"));
                    //strHTMLFormPaymentArray[8] = "inputNamePaymentMethod";
            }
            eai9.setRowDataPanel(inputNamePaymentMethod);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai9.setListItemIsRemovable(false);
            eai9.setValueBoxEnabled(false);
//
            EAListItem eai10 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent inputNameCC1 = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            inputNameCC1.setLabelText("Credit Card Number Block 1 Input Name Attribute:");
            if(ProjectManager.get("inputNameCC1")!=null)
            {
                    inputNameCC1.setInputText(ProjectManager.get("inputNameCC1"));
                    //strHTMLFormPaymentArray[9] = "inputNameCC1";
            }
            eai10.setRowDataPanel(inputNameCC1);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai10.setListItemIsRemovable(false);
            eai10.setValueBoxEnabled(false);
//
            EAListItem eai11 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent inputNameCC2 = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            inputNameCC2.setLabelText("Credit Card Number Block 2 Input Name Attribute:");
            if(ProjectManager.get("inputNameCC2")!=null)
            {
                    inputNameCC2.setInputText(ProjectManager.get("inputNameCC2"));
                    //strHTMLFormPaymentArray[10] = "inputNameCC2";
            }
            eai11.setRowDataPanel(inputNameCC2);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai11.setListItemIsRemovable(false);
            eai11.setValueBoxEnabled(false);
//
            EAListItem eai12 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent inputNameCC3 = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            inputNameCC3.setLabelText("Credit Card Number Block 3 Input Name Attribute:");
            if(ProjectManager.get("inputNameCC3")!=null)
            {
                    inputNameCC3.setInputText(ProjectManager.get("inputNameCC3"));
                    //strHTMLFormPaymentArray[11] = "inputNameCC3";
            }
            eai12.setRowDataPanel(inputNameCC3);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai12.setListItemIsRemovable(false);
		eai12.setValueBoxEnabled(false);
//
            EAListItem eai13 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent inputNameCC4 = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            inputNameCC4.setLabelText("Credit Card Number Block 4 Input Name Attribute:");
            if(ProjectManager.get("inputNameCC4")!=null)
            {
                    inputNameCC4.setInputText(ProjectManager.get("inputNameCC4"));
                    //strHTMLFormPaymentArray[12] = "inputNameCC4";
            }
            eai13.setRowDataPanel(inputNameCC4);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai13.setListItemIsRemovable(false);
            eai13.setValueBoxEnabled(false);
//
            EAListItem eai14 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent inputNameVerificationCode = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            inputNameVerificationCode.setLabelText("Credit Card Verification Code Input Name Attribute:");
            if(ProjectManager.get("inputNameVerificationCode")!=null)
            {
                    inputNameVerificationCode.setInputText(ProjectManager.get("inputNameVerificationCode"));
                    //strHTMLFormPaymentArray[13] = "inputNameVerificationCode";
            }
            eai14.setRowDataPanel(inputNameVerificationCode);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai14.setListItemIsRemovable(false);
            eai14.setValueBoxEnabled(false);
//
            EAListItem eai15 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent inputNameExpirationMonth = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            inputNameExpirationMonth.setLabelText("Expiration Month Input Name Attribute:");
            if(ProjectManager.get("inputNameExpirationMonth")!=null)
            {
                    inputNameExpirationMonth.setInputText(ProjectManager.get("inputNameExpirationMonth"));
                    //strHTMLFormPaymentArray[14] = "inputNameExpirationMonth";
            }
            eai15.setRowDataPanel(inputNameExpirationMonth);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai15.setListItemIsRemovable(false);
            eai15.setValueBoxEnabled(false);
//
            EAListItem eai16 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent inputNameExpirationYear = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            inputNameExpirationYear.setLabelText("Expiration Year Input Name Attribute:");
            if(ProjectManager.get("inputNameExpirationYear")!=null)
            {
                    inputNameExpirationYear.setInputText(ProjectManager.get("inputNameExpirationYear"));
                    //strHTMLFormPaymentArray[15] = "inputNameExpirationYear";
            }
            eai16.setRowDataPanel(inputNameExpirationYear);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai16.setListItemIsRemovable(false);
            eai16.setValueBoxEnabled(false);
//
            EAListItem eai17 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent inputNameMerchant = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            inputNameMerchant.setLabelText("Merchant ID Input Name Attribute:");
            if(ProjectManager.get("inputNameMerchant")!=null)
            {
                    inputNameMerchant.setInputText(ProjectManager.get("inputNameMerchant"));
                    //strHTMLFormPaymentArray[16] = "inputNameMerchant";
            }
            eai17.setRowDataPanel(inputNameMerchant);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai17.setListItemIsRemovable(false);
            eai17.setValueBoxEnabled(false);
 //
            EAListItem eai18 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent inputNameOrderID = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            inputNameOrderID.setLabelText("Order ID Input Name Attribute:");
            if(ProjectManager.get("inputNameOrderID")!=null)
            {
                    inputNameOrderID.setInputText(ProjectManager.get("inputNameOrderID"));
                    //strHTMLFormPaymentArray[17] = "inputNameOrderID";
            }
            eai18.setRowDataPanel(inputNameOrderID);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai18.setListItemIsRemovable(false);
            eai18.setValueBoxEnabled(false);
 //
            EAListItem eai19 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent inputNameNameOnCard = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            inputNameNameOnCard.setLabelText("Name On Card Input Name Attribute:");
            if(ProjectManager.get("inputNameNameOnCard")!=null)
            {
                    inputNameNameOnCard.setInputText(ProjectManager.get("inputNameNameOnCard"));
                    //strHTMLFormPaymentArray[18] = "inputNameNameOnCard";
            }
            eai19.setRowDataPanel(inputNameNameOnCard);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai19.setListItemIsRemovable(false);
            eai19.setValueBoxEnabled(false);
//
            EAListItem eai20 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent inputNameResponseURL = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            inputNameResponseURL.setLabelText("Response URL Input Name Attribute:");
            if(ProjectManager.get("inputNameResponseURL")!=null)
            {
                    inputNameResponseURL.setInputText(ProjectManager.get("inputNameResponseURL"));
                    //strHTMLFormPaymentArray[19] = "inputNameResponseURL";
            }
            eai20.setRowDataPanel(inputNameResponseURL);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai20.setListItemIsRemovable(false);
            eai20.setValueBoxEnabled(false);
 //
            EAListItem eai21 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent inputNameTotal = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            inputNameTotal.setLabelText("Total Price Input Name Attribute:");
            if(ProjectManager.get("inputNameTotal")!=null)
            {
                    inputNameTotal.setInputText(ProjectManager.get("inputNameTotal"));
                    //strHTMLFormPaymentArray[20] = "inputNameTotal";
            }
            eai21.setRowDataPanel(inputNameTotal);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai21.setListItemIsRemovable(false);
            eai21.setValueBoxEnabled(false);
 //
            EAListItem eai22 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent inputNamePhone = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            inputNamePhone.setLabelText("Telephone Input Name Attribute:");
            if(ProjectManager.get("inputNamePhone")!=null)
            {
                    inputNamePhone.setInputText(ProjectManager.get("inputNamePhone"));
            }
            eai22.setRowDataPanel(inputNamePhone);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai22.setListItemIsRemovable(false);
            eai22.setValueBoxEnabled(false);
 //
            EAListItem eai23 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent inputNamePhoneEnabled = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            inputNamePhoneEnabled.setLabelText("Telephone Input Enabled:");
            if(ProjectManager.get("paymentPhoneInputEnabled")!=null)
            {
                    inputNamePhoneEnabled.setInputText(ProjectManager.get("paymentPhoneInputEnabled"));
            }
            eai23.setRowDataPanel(inputNamePhoneEnabled);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai23.setListItemIsRemovable(false);
            eai23.setValueBoxEnabled(false);
 //
            EAListItem eai24 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent inputCCNumberSingleEnabled = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            inputCCNumberSingleEnabled.setLabelText("Credit Card is Single Input (false is 4 inputs):");
            if(ProjectManager.get("paymentCCIsSingleInputEnabled")!=null)
            {
                    inputCCNumberSingleEnabled.setInputText(ProjectManager.get("paymentCCIsSingleInputEnabled"));
            }
            eai24.setRowDataPanel(inputCCNumberSingleEnabled);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai24.setListItemIsRemovable(false);
            eai24.setValueBoxEnabled(false);
 //
            EAListItem eai25 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent inputPaymentSeparateFirstAndLastNamesEnabled = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            inputPaymentSeparateFirstAndLastNamesEnabled.setLabelText("Separate First and Last Name Inputs Enabled:");
            if(ProjectManager.get("paymentSeparateFirstAndLastNameInputsEnabled")!=null)
            {
                    inputPaymentSeparateFirstAndLastNamesEnabled.setInputText(ProjectManager.get("paymentSeparateFirstAndLastNameInputsEnabled"));
            }
            eai25.setRowDataPanel(inputPaymentSeparateFirstAndLastNamesEnabled);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai25.setListItemIsRemovable(false);
            eai25.setValueBoxEnabled(false);
 //
            EAListItem eai26 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent inputFullInputNameEnabled = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            inputFullInputNameEnabled.setLabelText("Full Name Input Enabled:");
            if(ProjectManager.get("paymentFullNameInputEnabled")!=null)
            {
                    inputFullInputNameEnabled.setInputText(ProjectManager.get("paymentFullNameInputEnabled"));
            }
            eai26.setRowDataPanel(inputFullInputNameEnabled);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai26.setListItemIsRemovable(false);
            eai26.setValueBoxEnabled(false);

		Object[] theObjArray = new Object[0];
		Object[] theObjArrayValues = new Object[0];
		if(ProjectManager.get("paymentInputHiddenNames")!=null)
		{
			theObjArray = getStringArraysFromString(ProjectManager.get("paymentInputHiddenNames"));
		}
		if(ProjectManager.get("paymentInputHiddenValues")!=null)
		{
			theObjArrayValues = getStringArraysFromString(ProjectManager.get("paymentInputHiddenValues"));
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
			EAListItem[] eaItems = new EAListItem[26 + theObjArray.length];
			eaItems[0] = eai;
			eaItems[1] = eai2;
			eaItems[2] = eai3;
			eaItems[3] = eai4;
			eaItems[4] = eai5;
			eaItems[5] = eai6;
			eaItems[6] = eai7;
			eaItems[7] = eai8;
			eaItems[8] = eai9;
			eaItems[9] = eai10;
			eaItems[10] = eai11;
			eaItems[11] = eai12;
			eaItems[12] = eai13;
			eaItems[13] = eai14;
			eaItems[14] = eai15;
			eaItems[15] = eai16;
			eaItems[16] = eai17;
			eaItems[17] = eai18;
			eaItems[18] = eai19;
			eaItems[19] = eai20;
			eaItems[20] = eai21;
			eaItems[21] = eai22;
			eaItems[22] = eai23;
			eaItems[23] = eai24;
			eaItems[24] = eai25;
			eaItems[25] = eai26;
			for(int i = 0;i<theObjArray.length;i++)
			{
            		EAListItem eaiNext = new EAListItem(theRowIcon,rowColor);
				EAListItemContent inputNameItem = new EAListItemContent(rowColor, defUIStringLabelWidth, 175,175);
				if(theObjArray[i]!=null)
				{
					if(((String)theObjArray[i]).equalsIgnoreCase("")==false)
					{
						inputNameItem.setInputText((String)theObjArray[i]);
						inputNameItem.setInputValueText((String)theObjArrayValues[i]);
						eaiNext.setRowDataPanel(inputNameItem);
						eaItems[i + 26] = eaiNext;
					}
				}
			}
			//HTMLFormPaymentEAListItemArray=eaItems;
			return eaItems;
		}
		else
		{
			EAListItem[] tempLIArray = {eai,eai2,eai3,eai4,eai5,eai6,eai7,eai8,eai9,eai10,eai11,eai12,eai13,eai14,eai15,eai16,eai17,eai18,eai19,eai20,eai21,eai22,eai23,eai24,eai25,eai26};
			//HTMLFormPaymentEAListItemArray=tempLIArray;
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

// String[] strHTMLFormResponseArray = new String[13];
//private EAListItem[] HTMLFormResponseEAListItemArray = new EAListItem[13];
private EAListItem[] getHTMLFormResponseEAListItems()
{
	  eaPropPanel = 6;
        try
        {
		int defUIStringLabelWidth = 300;
		int defUIStringDataWidth = 350;
            EAListItem eai = new EAListItem(theRowIcon,rowColor);
            EAListItemContent respInputAuthResponse = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            respInputAuthResponse.setLabelText("Authorization Response Input Name Attribute: ");
            if(ProjectManager.get("respInputAuthResponse")!=null)
            {
                   respInputAuthResponse.setInputText(ProjectManager.get("respInputAuthResponse"));
            }
            eai.setRowDataPanel(respInputAuthResponse);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai.setListItemIsRemovable(false);
            eai.setValueBoxEnabled(false);
//
            EAListItem eai2 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent respInputEmail = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            respInputEmail.setLabelText("E-mail Address Input Name Attribute:");
            if(ProjectManager.get("respInputEmail")!=null)
            {
                    respInputEmail.setInputText(ProjectManager.get("respInputEmail"));
            }
            eai2.setRowDataPanel(respInputEmail);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai2.setListItemIsRemovable(false);
            eai2.setValueBoxEnabled(false);
//
            EAListItem eai3 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent respInputTotal = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            respInputTotal.setLabelText("Total Price Input Name Attribute:");
            if(ProjectManager.get("respInputTotal")!=null)
            {
                    respInputTotal.setInputText(ProjectManager.get("respInputTotal"));
            }
            eai3.setRowDataPanel(respInputTotal);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai3.setListItemIsRemovable(false);
            eai3.setValueBoxEnabled(false);
//
            EAListItem eai4 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent respInputOrderID = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            respInputOrderID.setLabelText("Order ID Input Name Attribute:");
            if(ProjectManager.get("respInputOrderID")!=null)
            {
                    respInputOrderID.setInputText(ProjectManager.get("respInputOrderID"));
            }
            eai4.setRowDataPanel(respInputOrderID);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai4.setListItemIsRemovable(false);
            eai4.setValueBoxEnabled(false);
//
            EAListItem eai5 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent respInputNameonCard = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            respInputNameonCard.setLabelText("Name On Card Input Name Attribute:"); 
            if(ProjectManager.get("respInputNameonCard")!=null)
            {
                    respInputNameonCard.setInputText(ProjectManager.get("respInputNameonCard"));
            }
            eai5.setRowDataPanel(respInputNameonCard);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai5.setListItemIsRemovable(false);
            eai5.setValueBoxEnabled(false);
//
            EAListItem eai6 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent respInputCardStreet = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            respInputCardStreet.setLabelText("Street Address Input Name Attribute:");
            if(ProjectManager.get("respInputCardStreet")!=null)
            {
                    respInputCardStreet.setInputText(ProjectManager.get("respInputCardStreet"));
            }
            eai6.setRowDataPanel(respInputCardStreet);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai6.setListItemIsRemovable(false);
            eai6.setValueBoxEnabled(false);
//
            EAListItem eai7 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent respInputCardCity = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            respInputCardCity.setLabelText("City Input Name Attribute:");
            if(ProjectManager.get("respInputCardCity")!=null)
            {
                    respInputCardCity.setInputText(ProjectManager.get("respInputCardCity"));
            }
            eai7.setRowDataPanel(respInputCardCity);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai7.setListItemIsRemovable(false);
            eai7.setValueBoxEnabled(false);
//
            EAListItem eai8 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent respInputCardState = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            respInputCardState.setLabelText("State Input Name Attribute:");
            if(ProjectManager.get("respInputCardState")!=null)
            {
                    respInputCardState.setInputText(ProjectManager.get("respInputCardState"));
            }
            eai8.setRowDataPanel(respInputCardState);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai8.setListItemIsRemovable(false);
            eai8.setValueBoxEnabled(false);
//
            EAListItem eai9 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent respInputCardZip = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            respInputCardZip.setLabelText("Zip Code Input Name Attribute:");
            if(ProjectManager.get("respInputCardZip")!=null)
            {
                    respInputCardZip.setInputText(ProjectManager.get("respInputCardZip"));
            }
            eai9.setRowDataPanel(respInputCardZip);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai9.setListItemIsRemovable(false);
            eai9.setValueBoxEnabled(false);
//
            EAListItem eai10 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent respInputCardCountry = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            respInputCardCountry.setLabelText("Country Input Name Attribute:");
            if(ProjectManager.get("respInputCardCountry")!=null)
            {
                    respInputCardCountry.setInputText(ProjectManager.get("respInputCardCountry"));
            }
            eai10.setRowDataPanel(respInputCardCountry);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai10.setListItemIsRemovable(false);
            eai10.setValueBoxEnabled(false);
//
            EAListItem eai11 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent respInputCardnumber = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            respInputCardnumber.setLabelText("Credit Card Number Input Name Attribute:");
            if(ProjectManager.get("respInputCardnumber")!=null)
            {
                    respInputCardnumber.setInputText(ProjectManager.get("respInputCardnumber"));
            }
            eai11.setRowDataPanel(respInputCardnumber); 
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai11.setListItemIsRemovable(false);
            eai11.setValueBoxEnabled(false);
//
            EAListItem eai12 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent respInputCardName = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            respInputCardName.setLabelText("Credit Card Type Input Name Attribute:");
            if(ProjectManager.get("respInputCardName")!=null)
            {
                    respInputCardName.setInputText(ProjectManager.get("respInputCardName"));
            }
            eai12.setRowDataPanel(respInputCardName);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai12.setListItemIsRemovable(false);
            eai12.setValueBoxEnabled(false);
//
            EAListItem eai13 = new EAListItem(theRowIcon,rowColor);
            EAListItemContent paymentResponseInputStatusSuccess = new EAListItemContent(rowColor, defUIStringLabelWidth, defUIStringDataWidth);
            paymentResponseInputStatusSuccess.setLabelText("Response Document Authorization Success Value:");
            if(ProjectManager.get("paymentResponseInputStatusSuccess")!=null)
            {
                    paymentResponseInputStatusSuccess.setInputText(ProjectManager.get("paymentResponseInputStatusSuccess"));
            }
            eai13.setRowDataPanel(paymentResponseInputStatusSuccess);
            // Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
            eai13.setListItemIsRemovable(false);
            eai13.setValueBoxEnabled(false);

////////////////////////////////////////////////////
		Object[] theObjArray = new Object[0];
		int theTotalDeclinedMessages = 0;
	      if(ProjectManager.get("paymentResponseStatTotalMessages")!=null)
            {
		      if(ProjectManager.get("paymentResponseStatTotalMessages").equalsIgnoreCase("")==false)
      	      {
                 		theTotalDeclinedMessages = Integer.valueOf(ProjectManager.get("paymentResponseStatTotalMessages")).intValue();
				if(0<theTotalDeclinedMessages)
				{
					theObjArray = new Object[theTotalDeclinedMessages];
				}
			}
		}

		for(int i = 0;i<theTotalDeclinedMessages;i++)
		{
			try
			{
				theObjArray[i] = ProjectManager.get("paymentResponseStatDeclined" + String.valueOf(i + 1));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			} 
		}

		if(0<theObjArray.length)
		{
			EAListItem[] eaItems = new EAListItem[13 + theObjArray.length];
			eaItems[0] = eai;
			eaItems[1] = eai2;
			eaItems[2] = eai3;
			eaItems[3] = eai4;
			eaItems[4] = eai5;
			eaItems[5] = eai6;
			eaItems[6] = eai7;
			eaItems[7] = eai8;
			eaItems[8] = eai9;
			eaItems[9] = eai10;
			eaItems[10] = eai11;
			eaItems[11] = eai12;
			eaItems[12] = eai13;
			for(int i = 0;i<theObjArray.length;i++)
			{
            		EAListItem eaiNext = new EAListItem(theRowIcon,rowColor);
				EAListItemContent inputNameItem = new EAListItemContent(rowColor, defUIStringLabelWidth, 175,175);
				if(theObjArray[i]!=null)
				{
						inputNameItem.setLabelText("Response Document Authorization Failure Value " + String.valueOf(i + 1) + ":");
						inputNameItem.setInputText((String)theObjArray[i]);
						eaiNext.setRowDataPanel(inputNameItem);
						eaiNext.setValueBoxEnabled(false);
						eaItems[i + 13] = eaiNext;
				}
			}
			//HTMLFormPaymentEAListItemArray=eaItems;
			return eaItems;
		}
		else
		{
			EAListItem[] tempLIArray = {eai,eai2,eai3,eai4,eai5,eai6,eai7,eai8,eai9,eai10,eai11,eai12,eai13};
			//HTMLFormPaymentEAListItemArray=tempLIArray;
			return tempLIArray;
		}

///////////////////////////////////////////////////
        }
        catch(Exception e)
        {
          e.printStackTrace();   
        }
	EAListItem[] tempLIArray2 = new EAListItem[0];
	return tempLIArray2;
}
/////////////////////////////////////////


    private void cbRefundPolicyActionTypeActionPerformed(java.awt.event.ItemEvent evt)
    {
///////////////////
try
{
	if((ActionsEAListItemArray[0].getJComboBoxControl().getSelectedIndex())==-1)
	{

	}
	else if((ActionsEAListItemArray[0].getJComboBoxControl().getSelectedIndex())==0)
	{
		ProjectManager.put("refundPolicyActionType","-1");
	}
	else if((ActionsEAListItemArray[0].getJComboBoxControl().getSelectedIndex())==1)
	{
		ProjectManager.put("refundPolicyActionType","0");
		if(ProjectManager.get("refundPolicyAction")!=null)
		{
		if(ProjectManager.get("refundPolicyAction").equalsIgnoreCase("")==true)
		{
            	if(ProjectManager.get("product_url")!=null)
                  {
                  	if(ProjectManager.get("product_url").equalsIgnoreCase("")==true)
                        {
                        	ProjectManager.put("refundPolicyAction","http://www.evaluateanywhere.com");
                        }
                        else
                        {
                              ProjectManager.put("refundPolicyAction",ProjectManager.get("product_url"));
                        }
                  }
                  else
                  {
                        ProjectManager.put("refundPolicyAction","http://www.evaluateanywhere.com");
                  }
             }
             else
             {
             	try
                  {
                  	new URL(ProjectManager.get("refundPolicyAction"));
                  }
                  catch(MalformedURLException e)
                  {
            	if(ProjectManager.get("product_url")!=null)
                  {
                  	if(ProjectManager.get("product_url").equalsIgnoreCase("")==true)
                        {
                        	ProjectManager.put("refundPolicyAction","http://www.evaluateanywhere.com");
                        }
                        else
                        {
                              ProjectManager.put("refundPolicyAction",ProjectManager.get("product_url"));
                        }
                  }
                  else
                  {
                        ProjectManager.put("refundPolicyAction","http://www.evaluateanywhere.com");
                  }                   
                  }
            } 
		}

	}
	else if((ActionsEAListItemArray[0].getJComboBoxControl().getSelectedIndex())==2)
	{
		ProjectManager.put("refundPolicyActionType","1");
		ProjectManager.put("refundPolicyAction","com.trinity.ea.actions.RefundPolicyAction");
	}
	if(ProjectManager.get("refundPolicyActionType").equalsIgnoreCase("0")==true)
	{
		DataContentPanel tempPanel = new DataContentPanel("The Refund Policy Web Action Mapping is defined below");
		if(ProjectManager.get("refundPolicyAction")!=null)
		{
			tempPanel.setContentPanel(new TextFieldPanel(ActionsEAListItemArray[1].getRowDataPanel().getLabelText(), ProjectManager.get("refundPolicyAction"), strActionsArray[1], true));
		}
		else
		{		
			tempPanel.setContentPanel(new TextFieldPanel(ActionsEAListItemArray[1].getRowDataPanel().getLabelText(), ProjectManager.get("refundPolicyAction"), strActionsArray[1], true));
		}
		setContentPanel(tempPanel);
	}
	else
	{
		DataContentPanel tempPanel = new DataContentPanel("The Refund Policy Action Mapping is defined below");
		tempPanel.setContentPanel(new TextFieldPanel(ActionsEAListItemArray[1].getRowDataPanel().getLabelText(), ProjectManager.get("refundPolicyAction"), strActionsArray[1], false));
		setContentPanel(tempPanel);
	}

	setPaymentsActionsPropertyPanel();
      }
	catch(Exception e)
	{
		e.printStackTrace();
	}
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
		/*if(eaPropPanel!=0)
		{*/

	 	//Possibly where to fix display updates on the panel
		EAListItem eaListItemObj = theEAProperties.getSelectedEAListItem();
		EAListItemContent theContent = eaListItemObj.getRowDataPanel();
		if(eaPropPanel==0)
		{
			if(theLastSelectedIndex!=-1)
			{
				try
				{
					//if(theLastSelectedIndex!=3 && theLastSelectedIndex!=5)
					//{
						theEAProperties.getSelectedEAListItem().getRowDataPanel().setInputText(ProjectManager.get(strPropertiesArray[theLastSelectedIndex]));
					//}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}

			//Properties Panel Selected
			//strPropertiesArray
			try
			{
				DataContentPanel tempPanel = new DataContentPanel("The Payment Property is defined below");
				tempPanel.setContentPanel(new TextFieldPanel(PropertiesEAListItemArray[theEAProperties.getSelectedIndex()].getRowDataPanel().getLabelText(), ProjectManager.get(strPropertiesArray[theEAProperties.getSelectedIndex()]), strPropertiesArray[theEAProperties.getSelectedIndex()], true));
				setContentPanel(tempPanel);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(eaPropPanel==1)
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
///////////////////////////////////
			//Action Panel Selected
			//strActionsArray
				if(theEAProperties.getSelectedIndex()!=0&&theEAProperties.getSelectedIndex()!=1&&theEAProperties.getSelectedIndex()!=4)
				{
					DataContentPanel tempPanel = new DataContentPanel("The Payment Action is defined below");
					tempPanel.setContentPanel(new TextFieldPanel(ActionsEAListItemArray[theEAProperties.getSelectedIndex()].getRowDataPanel().getLabelText(), ProjectManager.get(strActionsArray[theEAProperties.getSelectedIndex()]), strActionsArray[theEAProperties.getSelectedIndex()], false));
					setContentPanel(tempPanel);
				}
				else if(theEAProperties.getSelectedIndex()==4)
				{
						DataContentPanel tempPanel = new DataContentPanel("The Order ID Action Mapping is defined below");
						tempPanel.setContentPanel(new TextFieldPanel(ActionsEAListItemArray[theEAProperties.getSelectedIndex()].getRowDataPanel().getLabelText(), ProjectManager.get(strActionsArray[theEAProperties.getSelectedIndex()]), strActionsArray[theEAProperties.getSelectedIndex()], true));
						setContentPanel(tempPanel);
				}
				else if(theEAProperties.getSelectedIndex()==1)
				{
					if(ProjectManager.get("refundPolicyActionType").equalsIgnoreCase("0")==true)
					{
						DataContentPanel tempPanel = new DataContentPanel("The Refund Policy Web Action Mapping is defined below");
						tempPanel.setContentPanel(new TextFieldPanel(ActionsEAListItemArray[theEAProperties.getSelectedIndex()].getRowDataPanel().getLabelText(), ProjectManager.get(strActionsArray[theEAProperties.getSelectedIndex()]), strActionsArray[theEAProperties.getSelectedIndex()], true));
						setContentPanel(tempPanel);
					}
					else
					{
						DataContentPanel tempPanel = new DataContentPanel("The Refund Policy Action Mapping is defined below");
						tempPanel.setContentPanel(new TextFieldPanel(ActionsEAListItemArray[theEAProperties.getSelectedIndex()].getRowDataPanel().getLabelText(), ProjectManager.get(strActionsArray[theEAProperties.getSelectedIndex()]), strActionsArray[theEAProperties.getSelectedIndex()], false));
						setContentPanel(tempPanel);
					}
				}
				else if(theEAProperties.getSelectedIndex()==0)
				{
					if(ProjectManager.get("refundPolicyActionType").equalsIgnoreCase("0")==true)
					{
						DataContentPanel tempPanel = new DataContentPanel("The Refund Policy Web Action Mapping is defined below");
						if(ProjectManager.get("refundPolicyAction")!=null)
						{
							tempPanel.setContentPanel(new TextFieldPanel(ActionsEAListItemArray[theEAProperties.getSelectedIndex() + 1].getRowDataPanel().getLabelText(), ProjectManager.get("refundPolicyAction"), strActionsArray[theEAProperties.getSelectedIndex() + 1], true));
						}
						else
						{		
							tempPanel.setContentPanel(new TextFieldPanel(ActionsEAListItemArray[theEAProperties.getSelectedIndex() + 1].getRowDataPanel().getLabelText(), ProjectManager.get(strActionsArray[theEAProperties.getSelectedIndex() + 1]), strActionsArray[theEAProperties.getSelectedIndex() + 1], true));
						}
						setContentPanel(tempPanel);
					}
					else
					{
						DataContentPanel tempPanel = new DataContentPanel("The Refund Policy Action Mapping is defined below");
						tempPanel.setContentPanel(new TextFieldPanel(ActionsEAListItemArray[theEAProperties.getSelectedIndex() + 1].getRowDataPanel().getLabelText(), ProjectManager.get(strActionsArray[theEAProperties.getSelectedIndex() + 1]), strActionsArray[theEAProperties.getSelectedIndex() + 1], false));
						setContentPanel(tempPanel);
					}
				}
		}
		else if(eaPropPanel==2)
		{
			if(theLastSelectedIndex!=-1)
			{
				if(theLastSelectedIndex!=3)
				{
					try
					{
						if(theLastSelectedIndex!=8 && theLastSelectedIndex!=18 && theLastSelectedIndex!=19 && theLastSelectedIndex!=34)
						{
							theEAProperties.getSelectedEAListItem().getRowDataPanel().setInputText(ProjectManager.get(UIPaymentStringArray[theLastSelectedIndex]));
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}
			//UI Strings Success Panel Selected
			//UIPaymentStringArray
			if(theEAProperties.getSelectedIndex()!=8 && theEAProperties.getSelectedIndex()!=18 && theEAProperties.getSelectedIndex()!=19 && theEAProperties.getSelectedIndex()!=34)
			{
				DataContentPanelFourthTier tempPanel = new DataContentPanelFourthTier("The Payment User Interface String is defined below");
				tempPanel.setContentPanel(new TextFieldPanelFourthTier(UIPaymentEAListItemArray[theEAProperties.getSelectedIndex()].getRowDataPanel().getLabelText(), ProjectManager.get(UIPaymentStringArray[theEAProperties.getSelectedIndex()]), UIPaymentStringArray[theEAProperties.getSelectedIndex()], true));
				PaymentsUserInterfacePanel rcsuip = new PaymentsUserInterfacePanel();
				rcsuip.setParentComponent(this);
				rcsuip.setUISelected();
				rcsuip.setContentPanel(tempPanel);
				setContentPanel(rcsuip);
			}
			else
			{
				DataContentPanelFourthTier tempPanel = new DataContentPanelFourthTier("The Payment User Interface String is defined below");
				tempPanel.setContentPanel(new TextPanePanelFourthTier(UIPaymentEAListItemArray[theEAProperties.getSelectedIndex()].getRowDataPanel().getLabelText(), ProjectManager.get(UIPaymentStringArray[theEAProperties.getSelectedIndex()]), UIPaymentStringArray[theEAProperties.getSelectedIndex()], true));
//				setContentPanel(tempPanel);
				PaymentsUserInterfacePanel rcsuip = new PaymentsUserInterfacePanel();
				rcsuip.setParentComponent(this);
				rcsuip.setUISelected();
				rcsuip.setContentPanel(tempPanel);
				setContentPanel(rcsuip);
			}
		}
		else if(eaPropPanel==3)
		{
			if(theLastSelectedIndex!=-1)
			{
				try
				{
					if(theLastSelectedIndex!=1 && theLastSelectedIndex!=6)
					{
						theEAProperties.getSelectedEAListItem().getRowDataPanel().setInputText(ProjectManager.get(strSuccessUserInterfaceArray[theLastSelectedIndex]));
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			//Payments Success User Interface Panel Selected
			//strSuccessUserInterfaceArray
			if(theEAProperties.getSelectedIndex()!=1 && theEAProperties.getSelectedIndex()!=6)
			{
				DataContentPanelFourthTier tempPanel = new DataContentPanelFourthTier("The Payment Success User Interface String is defined below");
				tempPanel.setContentPanel(new TextFieldPanelFourthTier(UISuccessEAListItemArray[theEAProperties.getSelectedIndex()].getRowDataPanel().getLabelText(), ProjectManager.get(strSuccessUserInterfaceArray[theEAProperties.getSelectedIndex()]), strSuccessUserInterfaceArray[theEAProperties.getSelectedIndex()], true));
				PaymentsUserInterfacePanel rcsuip = new PaymentsUserInterfacePanel();
				rcsuip.setParentComponent(this);
				rcsuip.setSuccessUISelected();
				rcsuip.setContentPanel(tempPanel);
				setContentPanel(rcsuip);
			}
			else
			{
				DataContentPanelFourthTier tempPanel = new DataContentPanelFourthTier("The Payment Success User Interface String is defined below");
				tempPanel.setContentPanel(new TextPanePanelFourthTier(UISuccessEAListItemArray[theEAProperties.getSelectedIndex()].getRowDataPanel().getLabelText(), ProjectManager.get(strSuccessUserInterfaceArray[theEAProperties.getSelectedIndex()]), strSuccessUserInterfaceArray[theEAProperties.getSelectedIndex()], true));
				PaymentsUserInterfacePanel rcsuip = new PaymentsUserInterfacePanel();
				rcsuip.setParentComponent(this);
				rcsuip.setSuccessUISelected();
				rcsuip.setContentPanel(tempPanel);
				setContentPanel(rcsuip);
			}
		}
		else if(eaPropPanel==4)
		{
			if(theLastSelectedIndex!=-1)
			{
				try
				{
					if(theLastSelectedIndex!=1 && theLastSelectedIndex!=6)
					{
						theEAProperties.getSelectedEAListItem().getRowDataPanel().setInputText(ProjectManager.get(UIFailedStringArray[theLastSelectedIndex]));
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			//UI Strings Failed Panel Selected
			//UIFailedStringArray
			if(theEAProperties.getSelectedIndex()!=1 && theEAProperties.getSelectedIndex()!=6)
			{
				DataContentPanelFourthTier tempPanel = new DataContentPanelFourthTier("The Payment Failure User Interface String is defined below");
				tempPanel.setContentPanel(new TextFieldPanelFourthTier(UIFailedEAListItemArray[theEAProperties.getSelectedIndex()].getRowDataPanel().getLabelText(), ProjectManager.get(UIFailedStringArray[theEAProperties.getSelectedIndex()]), UIFailedStringArray[theEAProperties.getSelectedIndex()], true));
				PaymentsUserInterfacePanel rcsuip = new PaymentsUserInterfacePanel();
				rcsuip.setParentComponent(this);
				rcsuip.setFailedUISelected();
				rcsuip.setContentPanel(tempPanel);
				setContentPanel(rcsuip);
			}
			else
			{
				DataContentPanelFourthTier tempPanel = new DataContentPanelFourthTier("The Payment Failure User Interface String is defined below");
				tempPanel.setContentPanel(new TextPanePanelFourthTier(UIFailedEAListItemArray[theEAProperties.getSelectedIndex()].getRowDataPanel().getLabelText(), ProjectManager.get(UIFailedStringArray[theEAProperties.getSelectedIndex()]), UIFailedStringArray[theEAProperties.getSelectedIndex()], true));
				PaymentsUserInterfacePanel rcsuip = new PaymentsUserInterfacePanel();
				rcsuip.setParentComponent(this);
				rcsuip.setFailedUISelected();
				rcsuip.setContentPanel(tempPanel);
				setContentPanel(rcsuip);
			}
		}
		else if(eaPropPanel==5)
		{
			/*if(theLastSelectedIndex!=-1)
			{
				try
				{
					if(theLastSelectedIndex!=1 && theLastSelectedIndex!=7)
					{
						theEAProperties.getSelectedEAListItem().getRowDataPanel().setInputText(ProjectManager.get(strHTMLFormPaymentArray[theLastSelectedIndex]));
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}*/
			try
			{
				//Payments HTML Form Inputs Panel Selected
				////strHTMLFormPaymentArray
				DataContentPanelFourthTier tempPanel = new DataContentPanelFourthTier("Configuration");
				PaymentHTMLFormInputsConfigurationPanel configPanel = new PaymentHTMLFormInputsConfigurationPanel();
				configPanel.setMasterStatusController(this);
				PaymentsHTMLFormInputsPanel phfip = new PaymentsHTMLFormInputsPanel();
				phfip.setParentComponent(this);
				phfip.setPaymentSelected();
				tempPanel.setContentPanel(configPanel);
				phfip.setContentPanel(tempPanel);
				setContentPanel(phfip);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(eaPropPanel==6)
		{
			/*
			if(theLastSelectedIndex!=-1)
			{
				try
				{
					//if(theLastSelectedIndex!=1 && theLastSelectedIndex!=7)
					//{
						theEAProperties.getSelectedEAListItem().getRowDataPanel().setInputText(ProjectManager.get(strHTMLFormResponseArray[theLastSelectedIndex]));
					//}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}*/
			try
			{
				//Response HTML Form Inputs Panel Selected
				//strHTMLFormResponseArray
				DataContentPanelFourthTier tempPanel = new DataContentPanelFourthTier("Configuration");
				PaymentHTMLFormInputsConfigurationPanel configPanel = new PaymentHTMLFormInputsConfigurationPanel();
				configPanel.setMasterStatusController(this);
				PaymentsHTMLFormInputsPanel phfip = new PaymentsHTMLFormInputsPanel();
				phfip.setParentComponent(this);
				phfip.setResponseSelected();
				tempPanel.setContentPanel(configPanel);
				phfip.setContentPanel(tempPanel);
				setContentPanel(phfip);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}		
    }

    private String getCommaSeparatedStringValues(String strToUpdate)
    {
	 return strToUpdate.replaceAll(":::",",");
    }

   public void getFireFindProviderWizardAction()
   {
	try
	{        
		PaymentsWizard thePaymentsWizard = new PaymentsWizard(1);
		thePaymentsWizard.setMasterControlPanel(this);
		thePaymentsWizard.hideDesigner();
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
		PaymentsWizard thePaymentsWizard = new PaymentsWizard(0);
		thePaymentsWizard.setMasterControlPanel(this);
		thePaymentsWizard.hideDesigner();
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
		PaymentsWizard thePaymentsWizard = new PaymentsWizard(0);
		thePaymentsWizard.setMasterControlPanel(this);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
   }

   public void setFinishConfigurationAction()
   {
	setProjectData();
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MaxPaymentsAttemptsLeftContentPanel;
    private javax.swing.JPanel MaxPaymentsAttemptsRightFillerPanel;
    private javax.swing.JPanel MaxPaymentsAttemptsSettingsPanel;
    private javax.swing.JPanel PaymentsCentralContentLeftMarginPanel;
    private javax.swing.JPanel PaymentsCentralContentPanel;
    private javax.swing.JPanel PaymentsCentralContentRightMarginPanel;
    private javax.swing.JPanel PaymentsContentBottomPanel;
    private javax.swing.JPanel PaymentsContentPanel;
    private javax.swing.JPanel PaymentsContentPanelItem3;
    private javax.swing.JPanel PaymentsContentPanelItem4;
    private javax.swing.JPanel PaymentsContentTopPanel;
    private javax.swing.JPanel PaymentsEnabledPanel1;
    private javax.swing.JPanel PaymentsMenuButtonPanel;
    private SBSpacer PaymentsMenuButtonPanelBottom;
    private SBTab PaymentsMenuButtonPanelTop;
    private javax.swing.JPanel PaymentsMenuContentPanel;
    private javax.swing.JPanel PaymentsMenuLeftSpaceFiller;
    private javax.swing.JPanel PaymentsMenuPanel;
    private javax.swing.JPanel PaymentsPanelMainContainer1;
    private javax.swing.JPanel PaymentsSelectionContentPanel;
    private javax.swing.JPanel PaymentsSettingsPanelItem1;
    private javax.swing.JPanel PaymentsSettingsPanelItem2;
    private javax.swing.JPanel PaymentsSettingsPanelItem8;
    private javax.swing.JPanel PaymentsTitlePanel;
    private javax.swing.JPanel PaymentsTitleRightPanel;
    private javax.swing.JButton btnGenerateEvaluationUnlockCode;
    private javax.swing.JButton btnPaymentsFormPreview;
    private javax.swing.JCheckBox cbPaymentsEnabled;
    private javax.swing.JLabel lEvaluationUnlockCode;
    private javax.swing.JLabel lMaxPaymentsAttempts;
    private SBTab lPaymentsPropertiesMenuItem;
    private SBTab lPaymentsActionsMenuItem;
    private SBTab lPaymentsUserInterfaceMenuItem;
    private SBTab lPaymentsHTMLFormMenuItem;
    private javax.swing.JTextField tfEvaluationUnlockCode;
    private javax.swing.JTextField tfMaxPaymentsAttempts;
    private javax.swing.JPanel PaymentsMenuPanelBottomPanel;
    private ContentAreaHeaderPanel contentProjectPanel;
    private javax.swing.JPanel contentPanel;
    private EAPropertiesPanel theEAProperties;
    private PaymentsEnabledControl registrationEnabledPanel;
    // End of variables declaration//GEN-END:variables
    
}
