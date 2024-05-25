/*
 * ButtonPanel.java
 *
 * Created on June 13, 2004, 3:24 PM
 */

package com.trinity.ea.design.project.lookandfeel.buttons;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.project.lookandfeel.preview.actions.StartVerticalButtonBarThemeAction;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import java.awt.*;
import javax.swing.*; 

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class ButtonPanel extends EAPanel {

    /** Creates new form ButtonPanel */
    public ButtonPanel() 
    {
        initComponents();
        setProjectData();
    }

    public synchronized void getDataUpdate()
    {
	  try
	  {
		// Use Evaluation Button Enabled/Disabled
		if(cbUseEvaluationButtonEnabled.isSelected()==true)
		{
                    ProjectManager.putTempNoFileWrite("btnBarUseEvalButtonEnabled","true");
		}
		else
		{
                    ProjectManager.putTempNoFileWrite("btnBarUseEvalButtonEnabled","false");                    
		}
 		// Buy Button Enabled/Disabled
		if(cbBuyButtonEnabled.isSelected()==true)
		{
                    ProjectManager.putTempNoFileWrite("btnBarBuyNowButtonEnabled","true");
		}
		else
		{
                    ProjectManager.putTempNoFileWrite("btnBarBuyNowButtonEnabled","false");                    
		}              
 		// Registration Code Button Enabled/Disabled
		if(cbRegistrationCodeButtonEnabled.isSelected()==true)
		{
                    ProjectManager.putTempNoFileWrite("btnBarRegButtonEnabled","true");
		}
		else
		{
                    ProjectManager.putTempNoFileWrite("btnBarRegButtonEnabled","false");                    
		}                  
 		// Information Button Enabled/Disabled
		if(cbInformationButtonEnabled.isSelected()==true)
		{
                    ProjectManager.putTempNoFileWrite("btnBarInfoButtonEnabled","true");
		}
		else
		{
                    ProjectManager.putTempNoFileWrite("btnBarInfoButtonEnabled","false");                    
		}                     
 		// Exit Button Enabled/Disabled
		if(cbExitButtonEnabled.isSelected()==true)
		{
                    ProjectManager.putTempNoFileWrite("btnBarExitButtonEnabled","true");
		}
		else
		{
                    ProjectManager.putTempNoFileWrite("btnBarExitButtonEnabled","false");                    
		}      
// Buttons Actions                
		if(cbUseEvaluationButtonActionType.getSelectedIndex()==0)
		{
			ProjectManager.putTempNoFileWrite("useEvaluationActionType", "-1"); 
		}
		else if(cbUseEvaluationButtonActionType.getSelectedIndex()==1)
		{
			ProjectManager.putTempNoFileWrite("useEvaluationActionType", "0"); 
		}	
		else if(cbUseEvaluationButtonActionType.getSelectedIndex()==2)
		{
			ProjectManager.putTempNoFileWrite("useEvaluationActionType", "1"); 
		}	
                if(ProjectManager.get("useEvaluationActionType").equalsIgnoreCase("1")==false)
                {                
                    ProjectManager.putTempNoFileWrite("useEvaluationAction", tfUseEvaluationButtonAction.getText()); 
                }
                
 		if(cbBuyButtonActionType.getSelectedIndex()==0)
		{
			ProjectManager.putTempNoFileWrite("buyNowActionType", "-1"); 
		}
		else if(cbBuyButtonActionType.getSelectedIndex()==1)
		{
			ProjectManager.putTempNoFileWrite("buyNowActionType", "0"); 
		}	
		else if(cbBuyButtonActionType.getSelectedIndex()==2)
		{
			ProjectManager.putTempNoFileWrite("buyNowActionType", "1"); 
		}	
                if(ProjectManager.get("buyNowActionType").equalsIgnoreCase("1")==false)
                {                         
                    ProjectManager.putTempNoFileWrite("buyNowAction", tfBuyButtonAction.getText());                
                }
                
 		if(cbRegistrationCodeButtonActionType.getSelectedIndex()==0)
		{
			ProjectManager.putTempNoFileWrite("enterRegistrationCodeActionType", "-1"); 
		}
		else if(cbRegistrationCodeButtonActionType.getSelectedIndex()==1)
		{
			ProjectManager.putTempNoFileWrite("enterRegistrationCodeActionType", "0"); 
		}	
		else if(cbRegistrationCodeButtonActionType.getSelectedIndex()==2)
		{
			ProjectManager.putTempNoFileWrite("enterRegistrationCodeActionType", "1"); 
		}	
                if(ProjectManager.get("enterRegistrationCodeActionType").equalsIgnoreCase("1")==false)
                {                
                    ProjectManager.putTempNoFileWrite("enterRegistrationCodeAction", tfRegistrationCodeButtonAction.getText());                  
                }
                
                if(cbInformationButtonActionType.getSelectedIndex()==0)
		{
			ProjectManager.putTempNoFileWrite("infoActionType", "-1"); 
		}
		else if(cbInformationButtonActionType.getSelectedIndex()==1)
		{
			ProjectManager.putTempNoFileWrite("infoActionType", "0"); 
		}	
		else if(cbInformationButtonActionType.getSelectedIndex()==2)
		{
			ProjectManager.putTempNoFileWrite("infoActionType", "1"); 
		}	
                if(ProjectManager.get("infoActionType").equalsIgnoreCase("1")==false)
                {
                    ProjectManager.putTempNoFileWrite("infoAction", tfInformationButtonAction.getText());                  
                }
// Button Text Strings
                ProjectManager.putTempNoFileWrite("btnBarUseEvalButtonText", tfUseEvaluationButtonText.getText());
                ProjectManager.putTempNoFileWrite("btnBarBuyNowButtonText", tfBuyButtonText.getText());
                ProjectManager.putTempNoFileWrite("btnBarRegButtonText", tfRegistrationCodeButtonText.getText());
                ProjectManager.putTempNoFileWrite("btnBarInfoButtonText", tfInformationButtonText.getText());                
                ProjectManager.putTempNoFileWrite("btnBarExitButtonText", tfExitButtonText.getText());                
                ProjectManager.putTempNoFileWrite("btnBarUseEvalButtonMnemonic", tfUseEvaluationButtonMnemonic.getText());
                ProjectManager.putTempNoFileWrite("btnBarBuyNowButtonMnemonic", tfBuyButtonMnemonic.getText());
                ProjectManager.putTempNoFileWrite("btnBarRegButtonMnemonic", tfRegistrationCodeButtonMnemonic.getText());
                ProjectManager.putTempNoFileWrite("btnBarInfoButtonMnemonic", tfInformationButtonMnemonic.getText());                
                ProjectManager.putTempNoFileWrite("btnBarExitButtonMnemonic", tfExitButtonMnemonic.getText());                
                
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
		// Use Evaluation Button Enabled/Disabled
 		if(ProjectManager.get("btnBarUseEvalButtonEnabled")!=null)
		{
			if(ProjectManager.get("btnBarUseEvalButtonEnabled").equalsIgnoreCase("true")==true)
			{
				cbUseEvaluationButtonEnabled.setSelected(true);
			}
			else
			{
				cbUseEvaluationButtonEnabled.setSelected(false);
			}
		}
		else
		{
			cbUseEvaluationButtonEnabled.setSelected(false);
		}           
 		// Buy Button Enabled/Disabled
 		if(ProjectManager.get("btnBarBuyNowButtonEnabled")!=null)
		{
			if(ProjectManager.get("btnBarBuyNowButtonEnabled").equalsIgnoreCase("true")==true)
			{
				cbBuyButtonEnabled.setSelected(true);
			}
			else
			{
				cbBuyButtonEnabled.setSelected(false);
			}
		}
		else
		{
			cbBuyButtonEnabled.setSelected(false);
		}                       
       
 		// Registration Code Button Enabled/Disabled
 		if(ProjectManager.get("btnBarRegButtonEnabled")!=null)
		{
			if(ProjectManager.get("btnBarRegButtonEnabled").equalsIgnoreCase("true")==true)
			{
				cbRegistrationCodeButtonEnabled.setSelected(true);
			}
			else
			{
				cbRegistrationCodeButtonEnabled.setSelected(false);
			}
		}
		else
		{
			cbRegistrationCodeButtonEnabled.setSelected(false);
		}                       
             
 		// Information Button Enabled/Disabled
 		if(ProjectManager.get("btnBarInfoButtonEnabled")!=null)
		{
			if(ProjectManager.get("btnBarInfoButtonEnabled").equalsIgnoreCase("true")==true)
			{
				cbInformationButtonEnabled.setSelected(true);
			}
			else
			{
				cbInformationButtonEnabled.setSelected(false);
			}
		}
		else
		{
			cbInformationButtonEnabled.setSelected(false);
		}                       
             
 		// Exit Button Enabled/Disabled
 		if(ProjectManager.get("btnBarExitButtonEnabled")!=null)
		{
			if(ProjectManager.get("btnBarExitButtonEnabled").equalsIgnoreCase("true")==true)
			{
				cbExitButtonEnabled.setSelected(true);
			}
			else
			{
				cbExitButtonEnabled.setSelected(false);
			}
		}
		else
		{
			cbExitButtonEnabled.setSelected(false);
		}                            
    
// Buttons Actions     
		if(ProjectManager.get("useEvaluationActionType")!=null)
		{
			if(ProjectManager.get("useEvaluationActionType").equalsIgnoreCase("-1")==true)
			{
				cbUseEvaluationButtonActionType.setSelectedIndex(0);
			}
			else if(ProjectManager.get("useEvaluationActionType").equalsIgnoreCase("0")==true)
			{
				cbUseEvaluationButtonActionType.setSelectedIndex(1);
                                if(ProjectManager.get("useEvaluationAction")!=null)
                                {
                                    tfUseEvaluationButtonAction.setText(ProjectManager.get("useEvaluationAction"));
                                }                               
			}
			else if(ProjectManager.get("useEvaluationActionType").equalsIgnoreCase("1")==true)
			{
				cbUseEvaluationButtonActionType.setSelectedIndex(2);
                                tfUseEvaluationButtonAction.setText("Launch Software Action");
			}
			else
			{
				cbUseEvaluationButtonActionType.setSelectedIndex(0);
			}
		}
		else
		{
			cbUseEvaluationButtonActionType.setSelectedIndex(0);
		}                    
	try
	{
		if(cbUseEvaluationButtonActionType.getSelectedIndex()==0)
		{
                    tfUseEvaluationButtonAction.setEnabled(false);
                }
                else if(cbUseEvaluationButtonActionType.getSelectedIndex()==1)
		{
                    tfUseEvaluationButtonAction.setEnabled(true);                    
			if(tfUseEvaluationButtonAction.getText().equalsIgnoreCase("")==true)
			{
                            if(ProjectManager.get("product_url")!=null)
                            {
                                if(ProjectManager.get("product_url").equalsIgnoreCase("")==true)
                                {
                                    tfUseEvaluationButtonAction.setText("http://www.evaluateanywhere.com");
                                }
                                else
                                {
                                    tfUseEvaluationButtonAction.setText(ProjectManager.get("product_url"));
                                }
                            }
                            else
                            {
                                    tfUseEvaluationButtonAction.setText("http://www.evaluateanywhere.com");
                            }
                        }
                        else
                        {
                            try
                            {
                                new URL(ProjectManager.get("product_url"));
                                tfUseEvaluationButtonAction.setText(ProjectManager.get("product_url"));
                                
                            }
                            catch(MalformedURLException e)
                            {
                                if(ProjectManager.get("product_url")!=null)
                                {
                                    if(ProjectManager.get("product_url").equalsIgnoreCase("")==true)
                                    {
                                        tfUseEvaluationButtonAction.setText("http://www.evaluateanywhere.com");
                                    }
                                    else
                                    {
                                        tfUseEvaluationButtonAction.setText(ProjectManager.get("product_url"));
                                    }
                                }
                                else
                                {
                                        tfUseEvaluationButtonAction.setText("http://www.evaluateanywhere.com");
                                }                                
                            }
                        } 	
                }
                else if(cbUseEvaluationButtonActionType.getSelectedIndex()==2)
                {
                     tfUseEvaluationButtonAction.setEnabled(false);
                     tfUseEvaluationButtonAction.setText("Launch Software Action");                   
                }
        }
	catch(Exception e)
	{
		e.printStackTrace();
	}

                
		if(ProjectManager.get("buyNowActionType")!=null)
		{
			if(ProjectManager.get("buyNowActionType").equalsIgnoreCase("-1")==true)
			{
				cbBuyButtonActionType.setSelectedIndex(0);
			}
			else if(ProjectManager.get("buyNowActionType").equalsIgnoreCase("0")==true)
			{
				cbBuyButtonActionType.setSelectedIndex(1);
                                if(ProjectManager.get("buyNowAction")!=null)
                                {
                                    tfBuyButtonAction.setText(ProjectManager.get("buyNowAction"));
                                }                               
			}
			else if(ProjectManager.get("buyNowActionType").equalsIgnoreCase("1")==true)
			{
				cbBuyButtonActionType.setSelectedIndex(2);
                                tfBuyButtonAction.setText("Buy Software Action");
			}
			else
			{
				cbBuyButtonActionType.setSelectedIndex(0);
			}
		}
		else
		{
			cbBuyButtonActionType.setSelectedIndex(0);
		}                    
	try
	{
		if(cbBuyButtonActionType.getSelectedIndex()==0)
		{
                    tfBuyButtonAction.setEnabled(false);
                }
                else if(cbBuyButtonActionType.getSelectedIndex()==1)
		{
                    tfBuyButtonAction.setEnabled(true);                    
			if(tfBuyButtonAction.getText().equalsIgnoreCase("")==true)
			{
                            if(ProjectManager.get("product_url")!=null)
                            {
                                if(ProjectManager.get("product_url").equalsIgnoreCase("")==true)
                                {
                                    tfBuyButtonAction.setText("http://www.evaluateanywhere.com");
                                }
                                else
                                {
                                    tfBuyButtonAction.setText(ProjectManager.get("product_url"));
                                }
                            }
                            else
                            {
                                    tfBuyButtonAction.setText("http://www.evaluateanywhere.com");
                            }
                        }
                        else
                        {
                            try
                            {
                                new URL(ProjectManager.get("product_url"));
                                tfBuyButtonAction.setText(ProjectManager.get("product_url"));
                            }
                            catch(MalformedURLException e)
                            {
                                if(ProjectManager.get("product_url")!=null)
                                {
                                    if(ProjectManager.get("product_url").equalsIgnoreCase("")==true)
                                    {
                                        tfBuyButtonAction.setText("http://www.evaluateanywhere.com");
                                    }
                                    else
                                    {
                                        tfBuyButtonAction.setText(ProjectManager.get("product_url"));
                                    }
                                }
                                else
                                {
                                        tfBuyButtonAction.setText("http://www.evaluateanywhere.com");
                                }                                
                            }
                        } 	
                }
                else if(cbBuyButtonActionType.getSelectedIndex()==2)
                {
                    tfBuyButtonAction.setEnabled(false);                    
                    tfBuyButtonAction.setText("Buy Software Action");                
                }                
        }
	catch(Exception e)
	{
		e.printStackTrace();
	}
 
                
		if(ProjectManager.get("enterRegistrationCodeActionType")!=null)
		{
			if(ProjectManager.get("enterRegistrationCodeActionType").equalsIgnoreCase("-1")==true)
			{
				cbRegistrationCodeButtonActionType.setSelectedIndex(0);
			}
			else if(ProjectManager.get("enterRegistrationCodeActionType").equalsIgnoreCase("0")==true)
			{
				cbRegistrationCodeButtonActionType.setSelectedIndex(1);
                                if(ProjectManager.get("enterRegistrationCodeAction")!=null)
                                {
                                    tfRegistrationCodeButtonAction.setText(ProjectManager.get("enterRegistrationCodeAction"));
                                }                               
			}
			else if(ProjectManager.get("enterRegistrationCodeActionType").equalsIgnoreCase("1")==true)
			{
				cbRegistrationCodeButtonActionType.setSelectedIndex(2);
                                tfRegistrationCodeButtonAction.setText("Enter Registration Code Action");
			}
			else
			{
				cbRegistrationCodeButtonActionType.setSelectedIndex(0);
			}
		}
		else
		{
			cbRegistrationCodeButtonActionType.setSelectedIndex(0);
		}   
	try
	{
		if(cbRegistrationCodeButtonActionType.getSelectedIndex()==0)
		{            
                    tfRegistrationCodeButtonAction.setEnabled(false);
                }
		if(cbRegistrationCodeButtonActionType.getSelectedIndex()==1)
		{
                        tfRegistrationCodeButtonAction.setEnabled(true);
			if(tfRegistrationCodeButtonAction.getText().equalsIgnoreCase("")==true)
			{
                            if(ProjectManager.get("product_url")!=null)
                            {
                                if(ProjectManager.get("product_url").equalsIgnoreCase("")==true)
                                {
                                    tfRegistrationCodeButtonAction.setText("http://www.evaluateanywhere.com");
                                }
                                else
                                {
                                    tfRegistrationCodeButtonAction.setText(ProjectManager.get("product_url"));
                                }
                            }
                            else
                            {
                                    tfRegistrationCodeButtonAction.setText("http://www.evaluateanywhere.com");
                            }
                        }
                        else
                        {
                            try
                            {
                                new URL(ProjectManager.get("product_url"));
                                tfRegistrationCodeButtonAction.setText(ProjectManager.get("product_url"));
                            }
                            catch(MalformedURLException e)
                            {
                                if(ProjectManager.get("product_url")!=null)
                                {
                                    if(ProjectManager.get("product_url").equalsIgnoreCase("")==true)
                                    {
                                        tfRegistrationCodeButtonAction.setText("http://www.evaluateanywhere.com");
                                    }
                                    else
                                    {
                                        tfRegistrationCodeButtonAction.setText(ProjectManager.get("product_url"));
                                    }
                                }
                                else
                                {
                                        tfRegistrationCodeButtonAction.setText("http://www.evaluateanywhere.com");
                                }                                
                            }
                        }                       
	
                }
                else if(cbRegistrationCodeButtonActionType.getSelectedIndex()==2)
                {
                     tfRegistrationCodeButtonAction.setEnabled(false);                    
                     tfRegistrationCodeButtonAction.setText("Enter Registration Code Action");               
                }                  
        }
	catch(Exception e)
	{
		e.printStackTrace();
	}


		if(ProjectManager.get("infoActionType")!=null)
		{
			if(ProjectManager.get("infoActionType").equalsIgnoreCase("-1")==true)
			{
				cbInformationButtonActionType.setSelectedIndex(0);
			}
			else if(ProjectManager.get("infoActionType").equalsIgnoreCase("0")==true)
			{
				cbInformationButtonActionType.setSelectedIndex(1);
                                if(ProjectManager.get("infoAction")!=null)
                                {
                                    tfInformationButtonAction.setText(ProjectManager.get("infoAction"));
                                }                               
			}
			else if(ProjectManager.get("infoActionType").equalsIgnoreCase("1")==true)
			{
				cbInformationButtonActionType.setSelectedIndex(2);
                                tfInformationButtonAction.setText("Display Information Dialog Action");
			}
			else
			{
				cbInformationButtonActionType.setSelectedIndex(0);
			}
		}
		else
		{
			cbInformationButtonActionType.setSelectedIndex(0);
		}                   
	try
	{
            	if(cbInformationButtonActionType.getSelectedIndex()==0)
		{
                    tfInformationButtonAction.setEnabled(false);
                }
                else if(cbInformationButtonActionType.getSelectedIndex()==1)
		{
                    tfInformationButtonAction.setEnabled(true);
			if(tfInformationButtonAction.getText().equalsIgnoreCase("")==true)
			{
                            if(ProjectManager.get("product_info_url")!=null)
                            {
                                if(ProjectManager.get("product_info_url").equalsIgnoreCase("")==true)
                                {
                                    tfInformationButtonAction.setText("http://www.evaluateanywhere.com");
                                }
                                else
                                {
                                    tfInformationButtonAction.setText(ProjectManager.get("product_info_url"));
                                }
                            }
                            else
                            {
                                    tfInformationButtonAction.setText("http://www.evaluateanywhere.com");
                            }
                        }
                        else
                        {
                            try
                            {
                                new URL(ProjectManager.get("product_info_url"));
                                tfInformationButtonAction.setText(ProjectManager.get("product_info_url"));
                            }
                            catch(MalformedURLException e)
                            {
                                if(ProjectManager.get("product_info_url")!=null)
                                {
                                    if(ProjectManager.get("product_info_url").equalsIgnoreCase("")==true)
                                    {
                                        tfInformationButtonAction.setText("http://www.evaluateanywhere.com");
                                    }
                                    else
                                    {
                                        tfInformationButtonAction.setText(ProjectManager.get("product_info_url"));
                                    }
                                }
                                else
                                {
                                        tfInformationButtonAction.setText("http://www.evaluateanywhere.com");
                                }                                
                            }
                        }
	
                }
                else if(cbInformationButtonActionType.getSelectedIndex()==2)
                {
                     tfInformationButtonAction.setEnabled(false);
                     tfInformationButtonAction.setText("Display Information Dialog Action");              
                }                    
        }
	catch(Exception ee)
	{
		ee.printStackTrace();
	}
                
// Button Text Strings
                if(ProjectManager.get("btnBarUseEvalButtonText")!=null)
                {
                    tfUseEvaluationButtonText.setText(ProjectManager.get("btnBarUseEvalButtonText"));
                }
                else
                {
                    tfUseEvaluationButtonText.setText("");
                }
                if(ProjectManager.get("btnBarBuyNowButtonText")!=null)
                {
                    tfBuyButtonText.setText(ProjectManager.get("btnBarBuyNowButtonText"));
                }
                else
                {
                    tfBuyButtonText.setText("");
                }
                if(ProjectManager.get("btnBarRegButtonText")!=null)
                {
                    tfRegistrationCodeButtonText.setText(ProjectManager.get("btnBarRegButtonText"));
                }
                else
                {
                    tfRegistrationCodeButtonText.setText("");
                }                
                if(ProjectManager.get("btnBarInfoButtonText")!=null)
                {
                    tfInformationButtonText.setText(ProjectManager.get("btnBarInfoButtonText"));
                }
                else
                {
                    tfInformationButtonText.setText("");
                }  
                if(ProjectManager.get("btnBarExitButtonText")!=null)
                {
                    tfExitButtonText.setText(ProjectManager.get("btnBarExitButtonText"));
                }
                else
                {
                    tfExitButtonText.setText("");
                }  
                if(ProjectManager.get("btnBarUseEvalButtonMnemonic")!=null)
                {
                    tfUseEvaluationButtonMnemonic.setText(ProjectManager.get("btnBarUseEvalButtonMnemonic"));
                }
                else
                {
                    tfUseEvaluationButtonMnemonic.setText("");
                }  
                if(ProjectManager.get("btnBarBuyNowButtonMnemonic")!=null)
                {
                    tfBuyButtonMnemonic.setText(ProjectManager.get("btnBarBuyNowButtonMnemonic"));
                }
                else
                {
                    tfBuyButtonMnemonic.setText("");
                }  
                if(ProjectManager.get("btnBarRegButtonMnemonic")!=null)
                {
                    tfRegistrationCodeButtonMnemonic.setText(ProjectManager.get("btnBarRegButtonMnemonic"));
                }
                else
                {
                    tfRegistrationCodeButtonMnemonic.setText("");
                }  
                if(ProjectManager.get("btnBarInfoButtonMnemonic")!=null)
                {
                    tfInformationButtonMnemonic.setText(ProjectManager.get("btnBarInfoButtonMnemonic"));
                }
                else
                {
                    tfInformationButtonMnemonic.setText("");
                }  
                if(ProjectManager.get("btnBarExitButtonMnemonic")!=null)
                {
                    tfExitButtonMnemonic.setText(ProjectManager.get("btnBarExitButtonMnemonic"));
                }
                else
                {
                    tfExitButtonMnemonic.setText("");
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
        TryButtonPanel = new javax.swing.JPanel();
        ProjectLocationsCenterPanel1 = new javax.swing.JPanel();
        lFiller24 = new javax.swing.JLabel();
        lTryButtonText = new javax.swing.JLabel();
        tfUseEvaluationButtonText = new javax.swing.JTextField();
        lFiller27 = new javax.swing.JLabel();
        lTryButtonMnemonic = new javax.swing.JLabel();
        tfUseEvaluationButtonMnemonic = new javax.swing.JTextField();
        lFiller52 = new javax.swing.JLabel();
        cbUseEvaluationButtonEnabled = new javax.swing.JCheckBox();
        UIChoicesBottomPanel11 = new javax.swing.JPanel();
        lFiller64 = new javax.swing.JLabel();
        lVerticalButtonBarButtonActionType = new javax.swing.JLabel();
        cbUseEvaluationButtonActionType = new javax.swing.JComboBox();
        lFiller65 = new javax.swing.JLabel();
        lVerticalButtonBarButtonAction = new javax.swing.JLabel();
        tfUseEvaluationButtonAction = new javax.swing.JTextField();
        lFiller67 = new javax.swing.JLabel();
        BuyButtonPanel = new javax.swing.JPanel();
        ProjectLocationsCenterPanel7 = new javax.swing.JPanel();
        lFiller34 = new javax.swing.JLabel();
        lTryButtonText1 = new javax.swing.JLabel();
        tfBuyButtonText = new javax.swing.JTextField();
        lFiller35 = new javax.swing.JLabel();
        lTryButtonMnemonic1 = new javax.swing.JLabel();
        tfBuyButtonMnemonic = new javax.swing.JTextField();
        lFiller43 = new javax.swing.JLabel();
        lFiller51 = new javax.swing.JLabel();
        cbBuyButtonEnabled = new javax.swing.JCheckBox();
        UIChoicesBottomPanel12 = new javax.swing.JPanel();
        lFiller103 = new javax.swing.JLabel();
        lVerticalButtonBarButtonActionType4 = new javax.swing.JLabel();
        cbBuyButtonActionType = new javax.swing.JComboBox();
        lFiller104 = new javax.swing.JLabel();
        lVerticalButtonBarButtonAction4 = new javax.swing.JLabel();
        tfBuyButtonAction = new javax.swing.JTextField();
        lFiller105 = new javax.swing.JLabel();
        RegistrationCodeButtonPanel = new javax.swing.JPanel();
        ProjectLocationsCenterPanel2 = new javax.swing.JPanel();
        lFiller25 = new javax.swing.JLabel();
        lTryButtonText2 = new javax.swing.JLabel();
        tfRegistrationCodeButtonText = new javax.swing.JTextField();
        lFiller30 = new javax.swing.JLabel();
        lTryButtonMnemonic2 = new javax.swing.JLabel();
        tfRegistrationCodeButtonMnemonic = new javax.swing.JTextField();
        lFiller50 = new javax.swing.JLabel();
        cbRegistrationCodeButtonEnabled = new javax.swing.JCheckBox();
        UIChoicesBottomPanel13 = new javax.swing.JPanel();
        lFiller66 = new javax.swing.JLabel();
        lVerticalButtonBarButtonActionType1 = new javax.swing.JLabel();
        cbRegistrationCodeButtonActionType = new javax.swing.JComboBox();
        lFiller68 = new javax.swing.JLabel();
        lVerticalButtonBarButtonAction1 = new javax.swing.JLabel();
        tfRegistrationCodeButtonAction = new javax.swing.JTextField();
        lFiller69 = new javax.swing.JLabel();
        InformationButtonPanel = new javax.swing.JPanel();
        ProjectLocationsCenterPanel3 = new javax.swing.JPanel();
        lFiller36 = new javax.swing.JLabel();
        lTryButtonText3 = new javax.swing.JLabel();
        tfInformationButtonText = new javax.swing.JTextField();
        lFiller37 = new javax.swing.JLabel();
        lTryButtonMnemonic3 = new javax.swing.JLabel();
        tfInformationButtonMnemonic = new javax.swing.JTextField();
        lFiller46 = new javax.swing.JLabel();
        cbInformationButtonEnabled = new javax.swing.JCheckBox();
        UIChoicesBottomPanel14 = new javax.swing.JPanel();
        lFiller70 = new javax.swing.JLabel();
        lVerticalButtonBarButtonActionType2 = new javax.swing.JLabel();
        cbInformationButtonActionType = new javax.swing.JComboBox();
        lFiller71 = new javax.swing.JLabel();
        lVerticalButtonBarButtonAction2 = new javax.swing.JLabel();
        tfInformationButtonAction = new javax.swing.JTextField();
        lFiller72 = new javax.swing.JLabel();
        ExitButtonPanel = new javax.swing.JPanel();
        ProjectLocationsCenterPanel5 = new javax.swing.JPanel();
        lFiller41 = new javax.swing.JLabel();
        lTryButtonText4 = new javax.swing.JLabel();
        tfExitButtonText = new javax.swing.JTextField();
        lFiller42 = new javax.swing.JLabel();
        lTryButtonMnemonic4 = new javax.swing.JLabel();
        tfExitButtonMnemonic = new javax.swing.JTextField();
        lFiller40 = new javax.swing.JLabel();
        cbExitButtonEnabled = new javax.swing.JCheckBox();
        SouthButtonPanelFiller = new javax.swing.JPanel();
        ImageDescriptionLabel3 = new javax.swing.JPanel();
        LeftUIFiller5 = new javax.swing.JLabel();
        ProjectLocationsCenterPanel4 = new javax.swing.JPanel();
        lFiller48 = new javax.swing.JLabel();
        PreviewButton = new javax.swing.JButton();
        lFiller45 = new javax.swing.JLabel();
        lFiller47 = new javax.swing.JLabel();
        UIChoicesBottomPanel4 = new javax.swing.JPanel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        setBackground(new java.awt.Color(140, 160, 210));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });

        TryButtonPanel.setLayout(new javax.swing.BoxLayout(TryButtonPanel, javax.swing.BoxLayout.Y_AXIS));

        TryButtonPanel.setBackground(new java.awt.Color(140, 160, 210));
        TryButtonPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Try Button", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        TryButtonPanel.setMaximumSize(new java.awt.Dimension(32767, 90));
        TryButtonPanel.setMinimumSize(new java.awt.Dimension(10, 90));
        TryButtonPanel.setPreferredSize(new java.awt.Dimension(10, 90));
        ProjectLocationsCenterPanel1.setLayout(new javax.swing.BoxLayout(ProjectLocationsCenterPanel1, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsCenterPanel1.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsCenterPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectLocationsCenterPanel1.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectLocationsCenterPanel1.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller24.setBackground(new java.awt.Color(140, 160, 210));
        lFiller24.setText("   ");
        lFiller24.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller24.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller24.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel1.add(lFiller24);

        lTryButtonText.setBackground(new java.awt.Color(140, 160, 210));
        lTryButtonText.setFont(new java.awt.Font("Arial", 0, 12));
        lTryButtonText.setText("Button Text:");
        lTryButtonText.setMaximumSize(new java.awt.Dimension(80, 15));
        lTryButtonText.setMinimumSize(new java.awt.Dimension(80, 15));
        lTryButtonText.setPreferredSize(new java.awt.Dimension(80, 15));
        lTryButtonText.setRequestFocusEnabled(false);
        ProjectLocationsCenterPanel1.add(lTryButtonText);

        tfUseEvaluationButtonText.setFont(new java.awt.Font("Arial", 0, 12));
        tfUseEvaluationButtonText.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfUseEvaluationButtonText.setText("Try");
        tfUseEvaluationButtonText.setMaximumSize(new java.awt.Dimension(120, 20));
        tfUseEvaluationButtonText.setMinimumSize(new java.awt.Dimension(120, 20));
        tfUseEvaluationButtonText.setPreferredSize(new java.awt.Dimension(120, 20));
        ProjectLocationsCenterPanel1.add(tfUseEvaluationButtonText);

        lFiller27.setBackground(new java.awt.Color(140, 160, 210));
        lFiller27.setText("   ");
        lFiller27.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller27.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller27.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel1.add(lFiller27);

        lTryButtonMnemonic.setBackground(new java.awt.Color(140, 160, 210));
        lTryButtonMnemonic.setFont(new java.awt.Font("Arial", 0, 12));
        lTryButtonMnemonic.setText("Button Mnemonic:");
        lTryButtonMnemonic.setMaximumSize(new java.awt.Dimension(110, 15));
        lTryButtonMnemonic.setMinimumSize(new java.awt.Dimension(110, 15));
        lTryButtonMnemonic.setPreferredSize(new java.awt.Dimension(110, 15));
        lTryButtonMnemonic.setRequestFocusEnabled(false);
        ProjectLocationsCenterPanel1.add(lTryButtonMnemonic);

        tfUseEvaluationButtonMnemonic.setFont(new java.awt.Font("Arial", 0, 12));
        tfUseEvaluationButtonMnemonic.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfUseEvaluationButtonMnemonic.setText("T");
        tfUseEvaluationButtonMnemonic.setMaximumSize(new java.awt.Dimension(15, 20));
        tfUseEvaluationButtonMnemonic.setMinimumSize(new java.awt.Dimension(15, 20));
        tfUseEvaluationButtonMnemonic.setPreferredSize(new java.awt.Dimension(15, 20));
        ProjectLocationsCenterPanel1.add(tfUseEvaluationButtonMnemonic);

        lFiller52.setBackground(new java.awt.Color(140, 160, 210));
        lFiller52.setText("   ");
        lFiller52.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller52.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller52.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel1.add(lFiller52);

        cbUseEvaluationButtonEnabled.setBackground(new java.awt.Color(140, 160, 210));
        cbUseEvaluationButtonEnabled.setFont(new java.awt.Font("Arial", 0, 12));
        cbUseEvaluationButtonEnabled.setSelected(true);
        cbUseEvaluationButtonEnabled.setText("Enabled");
        cbUseEvaluationButtonEnabled.setMaximumSize(new java.awt.Dimension(100, 23));
        cbUseEvaluationButtonEnabled.setMinimumSize(new java.awt.Dimension(100, 23));
        cbUseEvaluationButtonEnabled.setPreferredSize(new java.awt.Dimension(100, 23));
        cbUseEvaluationButtonEnabled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUseEvaluationButtonEnabledActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel1.add(cbUseEvaluationButtonEnabled);

        TryButtonPanel.add(ProjectLocationsCenterPanel1);

        UIChoicesBottomPanel11.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel11, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel11.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel11.setMaximumSize(new java.awt.Dimension(32767, 25));
        UIChoicesBottomPanel11.setMinimumSize(new java.awt.Dimension(5, 25));
        UIChoicesBottomPanel11.setPreferredSize(new java.awt.Dimension(200, 25));
        lFiller64.setBackground(new java.awt.Color(140, 160, 210));
        lFiller64.setText("   ");
        lFiller64.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller64.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller64.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel11.add(lFiller64);

        lVerticalButtonBarButtonActionType.setBackground(new java.awt.Color(140, 160, 210));
        lVerticalButtonBarButtonActionType.setFont(new java.awt.Font("Arial", 0, 12));
        lVerticalButtonBarButtonActionType.setText("Action Type:");
        lVerticalButtonBarButtonActionType.setMaximumSize(new java.awt.Dimension(80, 15));
        lVerticalButtonBarButtonActionType.setMinimumSize(new java.awt.Dimension(80, 15));
        lVerticalButtonBarButtonActionType.setPreferredSize(new java.awt.Dimension(80, 15));
        lVerticalButtonBarButtonActionType.setRequestFocusEnabled(false);
        UIChoicesBottomPanel11.add(lVerticalButtonBarButtonActionType);

        cbUseEvaluationButtonActionType.setBackground(new java.awt.Color(140, 160, 210));
        cbUseEvaluationButtonActionType.setFont(new java.awt.Font("Arial", 0, 11));
        cbUseEvaluationButtonActionType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Disabled", "Load Web Page", "Java Action" }));
        cbUseEvaluationButtonActionType.setMaximumSize(new java.awt.Dimension(120, 20));
        cbUseEvaluationButtonActionType.setMinimumSize(new java.awt.Dimension(120, 20));
        cbUseEvaluationButtonActionType.setPreferredSize(new java.awt.Dimension(120, 20));
        cbUseEvaluationButtonActionType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUseEvaluationButtonActionTypeActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel11.add(cbUseEvaluationButtonActionType);

        lFiller65.setBackground(new java.awt.Color(140, 160, 210));
        lFiller65.setText("   ");
        lFiller65.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller65.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller65.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel11.add(lFiller65);

        lVerticalButtonBarButtonAction.setBackground(new java.awt.Color(140, 160, 210));
        lVerticalButtonBarButtonAction.setFont(new java.awt.Font("Arial", 0, 12));
        lVerticalButtonBarButtonAction.setText("Action:");
        lVerticalButtonBarButtonAction.setMaximumSize(new java.awt.Dimension(50, 15));
        lVerticalButtonBarButtonAction.setMinimumSize(new java.awt.Dimension(50, 15));
        lVerticalButtonBarButtonAction.setPreferredSize(new java.awt.Dimension(50, 15));
        lVerticalButtonBarButtonAction.setRequestFocusEnabled(false);
        UIChoicesBottomPanel11.add(lVerticalButtonBarButtonAction);

        tfUseEvaluationButtonAction.setBackground(new java.awt.Color(204, 204, 204));
        tfUseEvaluationButtonAction.setFont(new java.awt.Font("Arial", 0, 12));
        tfUseEvaluationButtonAction.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfUseEvaluationButtonAction.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfUseEvaluationButtonAction.setMinimumSize(new java.awt.Dimension(200, 20));
        tfUseEvaluationButtonAction.setPreferredSize(new java.awt.Dimension(450, 20));
        UIChoicesBottomPanel11.add(tfUseEvaluationButtonAction);

        lFiller67.setBackground(new java.awt.Color(140, 160, 210));
        lFiller67.setText("   ");
        lFiller67.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller67.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller67.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel11.add(lFiller67);

        TryButtonPanel.add(UIChoicesBottomPanel11);

        add(TryButtonPanel);

        BuyButtonPanel.setLayout(new javax.swing.BoxLayout(BuyButtonPanel, javax.swing.BoxLayout.Y_AXIS));

        BuyButtonPanel.setBackground(new java.awt.Color(140, 160, 210));
        BuyButtonPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Buy Button", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        BuyButtonPanel.setMaximumSize(new java.awt.Dimension(32767, 90));
        BuyButtonPanel.setMinimumSize(new java.awt.Dimension(10, 90));
        BuyButtonPanel.setPreferredSize(new java.awt.Dimension(10, 90));
        ProjectLocationsCenterPanel7.setLayout(new javax.swing.BoxLayout(ProjectLocationsCenterPanel7, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsCenterPanel7.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsCenterPanel7.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectLocationsCenterPanel7.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectLocationsCenterPanel7.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller34.setBackground(new java.awt.Color(140, 160, 210));
        lFiller34.setText("   ");
        lFiller34.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller34.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller34.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel7.add(lFiller34);

        lTryButtonText1.setBackground(new java.awt.Color(140, 160, 210));
        lTryButtonText1.setFont(new java.awt.Font("Arial", 0, 12));
        lTryButtonText1.setText("Button Text:");
        lTryButtonText1.setMaximumSize(new java.awt.Dimension(80, 15));
        lTryButtonText1.setMinimumSize(new java.awt.Dimension(80, 15));
        lTryButtonText1.setPreferredSize(new java.awt.Dimension(80, 15));
        lTryButtonText1.setRequestFocusEnabled(false);
        ProjectLocationsCenterPanel7.add(lTryButtonText1);

        tfBuyButtonText.setFont(new java.awt.Font("Arial", 0, 12));
        tfBuyButtonText.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfBuyButtonText.setText("Buy Now");
        tfBuyButtonText.setMaximumSize(new java.awt.Dimension(120, 20));
        tfBuyButtonText.setMinimumSize(new java.awt.Dimension(120, 20));
        tfBuyButtonText.setPreferredSize(new java.awt.Dimension(120, 20));
        ProjectLocationsCenterPanel7.add(tfBuyButtonText);

        lFiller35.setBackground(new java.awt.Color(140, 160, 210));
        lFiller35.setText("   ");
        lFiller35.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller35.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller35.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel7.add(lFiller35);

        lTryButtonMnemonic1.setBackground(new java.awt.Color(140, 160, 210));
        lTryButtonMnemonic1.setFont(new java.awt.Font("Arial", 0, 12));
        lTryButtonMnemonic1.setText("Button Mnemonic:");
        lTryButtonMnemonic1.setMaximumSize(new java.awt.Dimension(110, 15));
        lTryButtonMnemonic1.setMinimumSize(new java.awt.Dimension(110, 15));
        lTryButtonMnemonic1.setPreferredSize(new java.awt.Dimension(110, 15));
        lTryButtonMnemonic1.setRequestFocusEnabled(false);
        ProjectLocationsCenterPanel7.add(lTryButtonMnemonic1);

        tfBuyButtonMnemonic.setFont(new java.awt.Font("Arial", 0, 12));
        tfBuyButtonMnemonic.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfBuyButtonMnemonic.setText("B");
        tfBuyButtonMnemonic.setMaximumSize(new java.awt.Dimension(15, 20));
        tfBuyButtonMnemonic.setMinimumSize(new java.awt.Dimension(15, 20));
        tfBuyButtonMnemonic.setPreferredSize(new java.awt.Dimension(15, 20));
        ProjectLocationsCenterPanel7.add(tfBuyButtonMnemonic);

        lFiller43.setBackground(new java.awt.Color(140, 160, 210));
        lFiller43.setText("   ");
        lFiller43.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller43.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller43.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel7.add(lFiller43);

        lFiller51.setBackground(new java.awt.Color(140, 160, 210));
        lFiller51.setText("   ");
        lFiller51.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller51.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller51.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel7.add(lFiller51);

        cbBuyButtonEnabled.setBackground(new java.awt.Color(140, 160, 210));
        cbBuyButtonEnabled.setFont(new java.awt.Font("Arial", 0, 12));
        cbBuyButtonEnabled.setSelected(true);
        cbBuyButtonEnabled.setText("Enabled");
        cbBuyButtonEnabled.setMaximumSize(new java.awt.Dimension(100, 23));
        cbBuyButtonEnabled.setMinimumSize(new java.awt.Dimension(100, 23));
        cbBuyButtonEnabled.setPreferredSize(new java.awt.Dimension(100, 23));
        cbBuyButtonEnabled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBuyButtonEnabledActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel7.add(cbBuyButtonEnabled);

        BuyButtonPanel.add(ProjectLocationsCenterPanel7);

        UIChoicesBottomPanel12.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel12, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel12.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel12.setMaximumSize(new java.awt.Dimension(32767, 25));
        UIChoicesBottomPanel12.setMinimumSize(new java.awt.Dimension(5, 25));
        UIChoicesBottomPanel12.setPreferredSize(new java.awt.Dimension(200, 25));
        lFiller103.setBackground(new java.awt.Color(140, 160, 210));
        lFiller103.setText("   ");
        lFiller103.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller103.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller103.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel12.add(lFiller103);

        lVerticalButtonBarButtonActionType4.setBackground(new java.awt.Color(140, 160, 210));
        lVerticalButtonBarButtonActionType4.setFont(new java.awt.Font("Arial", 0, 12));
        lVerticalButtonBarButtonActionType4.setText("Action Type:");
        lVerticalButtonBarButtonActionType4.setMaximumSize(new java.awt.Dimension(80, 15));
        lVerticalButtonBarButtonActionType4.setMinimumSize(new java.awt.Dimension(80, 15));
        lVerticalButtonBarButtonActionType4.setPreferredSize(new java.awt.Dimension(80, 15));
        lVerticalButtonBarButtonActionType4.setRequestFocusEnabled(false);
        UIChoicesBottomPanel12.add(lVerticalButtonBarButtonActionType4);

        cbBuyButtonActionType.setBackground(new java.awt.Color(140, 160, 210));
        cbBuyButtonActionType.setFont(new java.awt.Font("Arial", 0, 11));
        cbBuyButtonActionType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Disabled", "Load Web Page", "Java Action" }));
        cbBuyButtonActionType.setMaximumSize(new java.awt.Dimension(120, 20));
        cbBuyButtonActionType.setMinimumSize(new java.awt.Dimension(120, 20));
        cbBuyButtonActionType.setPreferredSize(new java.awt.Dimension(120, 20));
        cbBuyButtonActionType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBuyButtonActionTypeActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel12.add(cbBuyButtonActionType);

        lFiller104.setBackground(new java.awt.Color(140, 160, 210));
        lFiller104.setText("   ");
        lFiller104.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller104.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller104.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel12.add(lFiller104);

        lVerticalButtonBarButtonAction4.setBackground(new java.awt.Color(140, 160, 210));
        lVerticalButtonBarButtonAction4.setFont(new java.awt.Font("Arial", 0, 12));
        lVerticalButtonBarButtonAction4.setText("Action:");
        lVerticalButtonBarButtonAction4.setMaximumSize(new java.awt.Dimension(50, 15));
        lVerticalButtonBarButtonAction4.setMinimumSize(new java.awt.Dimension(50, 15));
        lVerticalButtonBarButtonAction4.setPreferredSize(new java.awt.Dimension(50, 15));
        lVerticalButtonBarButtonAction4.setRequestFocusEnabled(false);
        UIChoicesBottomPanel12.add(lVerticalButtonBarButtonAction4);

        tfBuyButtonAction.setBackground(new java.awt.Color(204, 204, 204));
        tfBuyButtonAction.setFont(new java.awt.Font("Arial", 0, 12));
        tfBuyButtonAction.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfBuyButtonAction.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfBuyButtonAction.setMinimumSize(new java.awt.Dimension(200, 20));
        tfBuyButtonAction.setPreferredSize(new java.awt.Dimension(450, 20));
        tfBuyButtonAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBuyButtonActionActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel12.add(tfBuyButtonAction);

        lFiller105.setBackground(new java.awt.Color(140, 160, 210));
        lFiller105.setText("   ");
        lFiller105.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller105.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller105.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel12.add(lFiller105);

        BuyButtonPanel.add(UIChoicesBottomPanel12);

        add(BuyButtonPanel);

        RegistrationCodeButtonPanel.setLayout(new javax.swing.BoxLayout(RegistrationCodeButtonPanel, javax.swing.BoxLayout.Y_AXIS));

        RegistrationCodeButtonPanel.setBackground(new java.awt.Color(140, 160, 210));
        RegistrationCodeButtonPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Registration Code Button", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        RegistrationCodeButtonPanel.setMaximumSize(new java.awt.Dimension(32767, 90));
        RegistrationCodeButtonPanel.setMinimumSize(new java.awt.Dimension(10, 90));
        RegistrationCodeButtonPanel.setPreferredSize(new java.awt.Dimension(10, 90));
        ProjectLocationsCenterPanel2.setLayout(new javax.swing.BoxLayout(ProjectLocationsCenterPanel2, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsCenterPanel2.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsCenterPanel2.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectLocationsCenterPanel2.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectLocationsCenterPanel2.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller25.setBackground(new java.awt.Color(140, 160, 210));
        lFiller25.setText("   ");
        lFiller25.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller25.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller25.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel2.add(lFiller25);

        lTryButtonText2.setBackground(new java.awt.Color(140, 160, 210));
        lTryButtonText2.setFont(new java.awt.Font("Arial", 0, 12));
        lTryButtonText2.setText("Button Text:");
        lTryButtonText2.setMaximumSize(new java.awt.Dimension(80, 15));
        lTryButtonText2.setMinimumSize(new java.awt.Dimension(80, 15));
        lTryButtonText2.setPreferredSize(new java.awt.Dimension(80, 15));
        lTryButtonText2.setRequestFocusEnabled(false);
        ProjectLocationsCenterPanel2.add(lTryButtonText2);

        tfRegistrationCodeButtonText.setFont(new java.awt.Font("Arial", 0, 12));
        tfRegistrationCodeButtonText.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfRegistrationCodeButtonText.setText("Activate");
        tfRegistrationCodeButtonText.setMaximumSize(new java.awt.Dimension(120, 20));
        tfRegistrationCodeButtonText.setMinimumSize(new java.awt.Dimension(120, 20));
        tfRegistrationCodeButtonText.setPreferredSize(new java.awt.Dimension(120, 20));
        ProjectLocationsCenterPanel2.add(tfRegistrationCodeButtonText);

        lFiller30.setBackground(new java.awt.Color(140, 160, 210));
        lFiller30.setText("   ");
        lFiller30.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller30.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller30.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel2.add(lFiller30);

        lTryButtonMnemonic2.setBackground(new java.awt.Color(140, 160, 210));
        lTryButtonMnemonic2.setFont(new java.awt.Font("Arial", 0, 12));
        lTryButtonMnemonic2.setText("Button Mnemonic:");
        lTryButtonMnemonic2.setMaximumSize(new java.awt.Dimension(110, 15));
        lTryButtonMnemonic2.setMinimumSize(new java.awt.Dimension(110, 15));
        lTryButtonMnemonic2.setPreferredSize(new java.awt.Dimension(110, 15));
        lTryButtonMnemonic2.setRequestFocusEnabled(false);
        ProjectLocationsCenterPanel2.add(lTryButtonMnemonic2);

        tfRegistrationCodeButtonMnemonic.setFont(new java.awt.Font("Arial", 0, 12));
        tfRegistrationCodeButtonMnemonic.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfRegistrationCodeButtonMnemonic.setText("A");
        tfRegistrationCodeButtonMnemonic.setMaximumSize(new java.awt.Dimension(15, 20));
        tfRegistrationCodeButtonMnemonic.setMinimumSize(new java.awt.Dimension(15, 20));
        tfRegistrationCodeButtonMnemonic.setPreferredSize(new java.awt.Dimension(15, 20));
        ProjectLocationsCenterPanel2.add(tfRegistrationCodeButtonMnemonic);

        lFiller50.setBackground(new java.awt.Color(140, 160, 210));
        lFiller50.setText("   ");
        lFiller50.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller50.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller50.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel2.add(lFiller50);

        cbRegistrationCodeButtonEnabled.setBackground(new java.awt.Color(140, 160, 210));
        cbRegistrationCodeButtonEnabled.setFont(new java.awt.Font("Arial", 0, 12));
        cbRegistrationCodeButtonEnabled.setSelected(true);
        cbRegistrationCodeButtonEnabled.setText("Enabled");
        cbRegistrationCodeButtonEnabled.setMaximumSize(new java.awt.Dimension(100, 23));
        cbRegistrationCodeButtonEnabled.setMinimumSize(new java.awt.Dimension(100, 23));
        cbRegistrationCodeButtonEnabled.setPreferredSize(new java.awt.Dimension(100, 23));
        cbRegistrationCodeButtonEnabled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRegistrationCodeButtonEnabledActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel2.add(cbRegistrationCodeButtonEnabled);

        RegistrationCodeButtonPanel.add(ProjectLocationsCenterPanel2);

        UIChoicesBottomPanel13.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel13, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel13.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel13.setMaximumSize(new java.awt.Dimension(32767, 25));
        UIChoicesBottomPanel13.setMinimumSize(new java.awt.Dimension(5, 25));
        UIChoicesBottomPanel13.setPreferredSize(new java.awt.Dimension(200, 25));
        lFiller66.setBackground(new java.awt.Color(140, 160, 210));
        lFiller66.setText("   ");
        lFiller66.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller66.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller66.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel13.add(lFiller66);

        lVerticalButtonBarButtonActionType1.setBackground(new java.awt.Color(140, 160, 210));
        lVerticalButtonBarButtonActionType1.setFont(new java.awt.Font("Arial", 0, 12));
        lVerticalButtonBarButtonActionType1.setText("Action Type:");
        lVerticalButtonBarButtonActionType1.setMaximumSize(new java.awt.Dimension(80, 15));
        lVerticalButtonBarButtonActionType1.setMinimumSize(new java.awt.Dimension(80, 15));
        lVerticalButtonBarButtonActionType1.setPreferredSize(new java.awt.Dimension(80, 15));
        lVerticalButtonBarButtonActionType1.setRequestFocusEnabled(false);
        UIChoicesBottomPanel13.add(lVerticalButtonBarButtonActionType1);

        cbRegistrationCodeButtonActionType.setBackground(new java.awt.Color(140, 160, 210));
        cbRegistrationCodeButtonActionType.setFont(new java.awt.Font("Arial", 0, 11));
        cbRegistrationCodeButtonActionType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Disabled", "Load Web Page", "Java Action" }));
        cbRegistrationCodeButtonActionType.setMaximumSize(new java.awt.Dimension(120, 20));
        cbRegistrationCodeButtonActionType.setMinimumSize(new java.awt.Dimension(120, 20));
        cbRegistrationCodeButtonActionType.setPreferredSize(new java.awt.Dimension(120, 20));
        cbRegistrationCodeButtonActionType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRegistrationCodeButtonActionTypeActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel13.add(cbRegistrationCodeButtonActionType);

        lFiller68.setBackground(new java.awt.Color(140, 160, 210));
        lFiller68.setText("   ");
        lFiller68.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller68.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller68.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel13.add(lFiller68);

        lVerticalButtonBarButtonAction1.setBackground(new java.awt.Color(140, 160, 210));
        lVerticalButtonBarButtonAction1.setFont(new java.awt.Font("Arial", 0, 12));
        lVerticalButtonBarButtonAction1.setText("Action:");
        lVerticalButtonBarButtonAction1.setMaximumSize(new java.awt.Dimension(50, 15));
        lVerticalButtonBarButtonAction1.setMinimumSize(new java.awt.Dimension(50, 15));
        lVerticalButtonBarButtonAction1.setPreferredSize(new java.awt.Dimension(50, 15));
        lVerticalButtonBarButtonAction1.setRequestFocusEnabled(false);
        UIChoicesBottomPanel13.add(lVerticalButtonBarButtonAction1);

        tfRegistrationCodeButtonAction.setBackground(new java.awt.Color(204, 204, 204));
        tfRegistrationCodeButtonAction.setFont(new java.awt.Font("Arial", 0, 12));
        tfRegistrationCodeButtonAction.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfRegistrationCodeButtonAction.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfRegistrationCodeButtonAction.setMinimumSize(new java.awt.Dimension(200, 20));
        tfRegistrationCodeButtonAction.setPreferredSize(new java.awt.Dimension(450, 20));
        UIChoicesBottomPanel13.add(tfRegistrationCodeButtonAction);

        lFiller69.setBackground(new java.awt.Color(140, 160, 210));
        lFiller69.setText("   ");
        lFiller69.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller69.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller69.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel13.add(lFiller69);

        RegistrationCodeButtonPanel.add(UIChoicesBottomPanel13);

        add(RegistrationCodeButtonPanel);

        InformationButtonPanel.setLayout(new javax.swing.BoxLayout(InformationButtonPanel, javax.swing.BoxLayout.Y_AXIS));

        InformationButtonPanel.setBackground(new java.awt.Color(140, 160, 210));
        InformationButtonPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Information Button", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        InformationButtonPanel.setMaximumSize(new java.awt.Dimension(32767, 90));
        InformationButtonPanel.setMinimumSize(new java.awt.Dimension(10, 90));
        InformationButtonPanel.setPreferredSize(new java.awt.Dimension(10, 90));
        ProjectLocationsCenterPanel3.setLayout(new javax.swing.BoxLayout(ProjectLocationsCenterPanel3, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsCenterPanel3.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsCenterPanel3.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectLocationsCenterPanel3.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectLocationsCenterPanel3.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller36.setBackground(new java.awt.Color(140, 160, 210));
        lFiller36.setText("   ");
        lFiller36.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller36.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller36.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel3.add(lFiller36);

        lTryButtonText3.setBackground(new java.awt.Color(140, 160, 210));
        lTryButtonText3.setFont(new java.awt.Font("Arial", 0, 12));
        lTryButtonText3.setText("Button Text:");
        lTryButtonText3.setMaximumSize(new java.awt.Dimension(80, 15));
        lTryButtonText3.setMinimumSize(new java.awt.Dimension(80, 15));
        lTryButtonText3.setPreferredSize(new java.awt.Dimension(80, 15));
        lTryButtonText3.setRequestFocusEnabled(false);
        ProjectLocationsCenterPanel3.add(lTryButtonText3);

        tfInformationButtonText.setFont(new java.awt.Font("Arial", 0, 12));
        tfInformationButtonText.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfInformationButtonText.setText("Information");
        tfInformationButtonText.setMaximumSize(new java.awt.Dimension(120, 20));
        tfInformationButtonText.setMinimumSize(new java.awt.Dimension(120, 20));
        tfInformationButtonText.setPreferredSize(new java.awt.Dimension(120, 20));
        ProjectLocationsCenterPanel3.add(tfInformationButtonText);

        lFiller37.setBackground(new java.awt.Color(140, 160, 210));
        lFiller37.setText("   ");
        lFiller37.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller37.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller37.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel3.add(lFiller37);

        lTryButtonMnemonic3.setBackground(new java.awt.Color(140, 160, 210));
        lTryButtonMnemonic3.setFont(new java.awt.Font("Arial", 0, 12));
        lTryButtonMnemonic3.setText("Button Mnemonic:");
        lTryButtonMnemonic3.setMaximumSize(new java.awt.Dimension(110, 15));
        lTryButtonMnemonic3.setMinimumSize(new java.awt.Dimension(110, 15));
        lTryButtonMnemonic3.setPreferredSize(new java.awt.Dimension(110, 15));
        lTryButtonMnemonic3.setRequestFocusEnabled(false);
        ProjectLocationsCenterPanel3.add(lTryButtonMnemonic3);

        tfInformationButtonMnemonic.setFont(new java.awt.Font("Arial", 0, 12));
        tfInformationButtonMnemonic.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfInformationButtonMnemonic.setText("I");
        tfInformationButtonMnemonic.setMaximumSize(new java.awt.Dimension(15, 20));
        tfInformationButtonMnemonic.setMinimumSize(new java.awt.Dimension(15, 20));
        tfInformationButtonMnemonic.setPreferredSize(new java.awt.Dimension(15, 20));
        ProjectLocationsCenterPanel3.add(tfInformationButtonMnemonic);

        lFiller46.setBackground(new java.awt.Color(140, 160, 210));
        lFiller46.setText("   ");
        lFiller46.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller46.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller46.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel3.add(lFiller46);

        cbInformationButtonEnabled.setBackground(new java.awt.Color(140, 160, 210));
        cbInformationButtonEnabled.setFont(new java.awt.Font("Arial", 0, 12));
        cbInformationButtonEnabled.setSelected(true);
        cbInformationButtonEnabled.setText("Enabled");
        cbInformationButtonEnabled.setMaximumSize(new java.awt.Dimension(100, 23));
        cbInformationButtonEnabled.setMinimumSize(new java.awt.Dimension(100, 23));
        cbInformationButtonEnabled.setPreferredSize(new java.awt.Dimension(100, 23));
        cbInformationButtonEnabled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbInformationButtonEnabledActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel3.add(cbInformationButtonEnabled);

        InformationButtonPanel.add(ProjectLocationsCenterPanel3);

        UIChoicesBottomPanel14.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel14, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel14.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel14.setMaximumSize(new java.awt.Dimension(32767, 25));
        UIChoicesBottomPanel14.setMinimumSize(new java.awt.Dimension(5, 25));
        UIChoicesBottomPanel14.setPreferredSize(new java.awt.Dimension(200, 25));
        lFiller70.setBackground(new java.awt.Color(140, 160, 210));
        lFiller70.setText("   ");
        lFiller70.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller70.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller70.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel14.add(lFiller70);

        lVerticalButtonBarButtonActionType2.setBackground(new java.awt.Color(140, 160, 210));
        lVerticalButtonBarButtonActionType2.setFont(new java.awt.Font("Arial", 0, 12));
        lVerticalButtonBarButtonActionType2.setText("Action Type:");
        lVerticalButtonBarButtonActionType2.setMaximumSize(new java.awt.Dimension(80, 15));
        lVerticalButtonBarButtonActionType2.setMinimumSize(new java.awt.Dimension(80, 15));
        lVerticalButtonBarButtonActionType2.setPreferredSize(new java.awt.Dimension(80, 15));
        lVerticalButtonBarButtonActionType2.setRequestFocusEnabled(false);
        UIChoicesBottomPanel14.add(lVerticalButtonBarButtonActionType2);

        cbInformationButtonActionType.setBackground(new java.awt.Color(140, 160, 210));
        cbInformationButtonActionType.setFont(new java.awt.Font("Arial", 0, 11));
        cbInformationButtonActionType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Disabled", "Load Web Page", "Java Action" }));
        cbInformationButtonActionType.setMaximumSize(new java.awt.Dimension(120, 20));
        cbInformationButtonActionType.setMinimumSize(new java.awt.Dimension(120, 20));
        cbInformationButtonActionType.setPreferredSize(new java.awt.Dimension(120, 20));
        cbInformationButtonActionType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbInformationButtonActionTypeActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel14.add(cbInformationButtonActionType);

        lFiller71.setBackground(new java.awt.Color(140, 160, 210));
        lFiller71.setText("   ");
        lFiller71.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller71.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller71.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel14.add(lFiller71);

        lVerticalButtonBarButtonAction2.setBackground(new java.awt.Color(140, 160, 210));
        lVerticalButtonBarButtonAction2.setFont(new java.awt.Font("Arial", 0, 12));
        lVerticalButtonBarButtonAction2.setText("Action:");
        lVerticalButtonBarButtonAction2.setMaximumSize(new java.awt.Dimension(50, 15));
        lVerticalButtonBarButtonAction2.setMinimumSize(new java.awt.Dimension(50, 15));
        lVerticalButtonBarButtonAction2.setPreferredSize(new java.awt.Dimension(50, 15));
        lVerticalButtonBarButtonAction2.setRequestFocusEnabled(false);
        UIChoicesBottomPanel14.add(lVerticalButtonBarButtonAction2);

        tfInformationButtonAction.setBackground(new java.awt.Color(204, 204, 204));
        tfInformationButtonAction.setFont(new java.awt.Font("Arial", 0, 12));
        tfInformationButtonAction.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfInformationButtonAction.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfInformationButtonAction.setMinimumSize(new java.awt.Dimension(200, 20));
        tfInformationButtonAction.setPreferredSize(new java.awt.Dimension(450, 20));
        tfInformationButtonAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfInformationButtonActionActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel14.add(tfInformationButtonAction);

        lFiller72.setBackground(new java.awt.Color(140, 160, 210));
        lFiller72.setText("   ");
        lFiller72.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller72.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller72.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel14.add(lFiller72);

        InformationButtonPanel.add(UIChoicesBottomPanel14);

        add(InformationButtonPanel);

        ExitButtonPanel.setLayout(new javax.swing.BoxLayout(ExitButtonPanel, javax.swing.BoxLayout.Y_AXIS));

        ExitButtonPanel.setBackground(new java.awt.Color(140, 160, 210));
        ExitButtonPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Exit Button", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ExitButtonPanel.setMaximumSize(new java.awt.Dimension(32767, 60));
        ExitButtonPanel.setMinimumSize(new java.awt.Dimension(10, 60));
        ExitButtonPanel.setPreferredSize(new java.awt.Dimension(10, 60));
        ProjectLocationsCenterPanel5.setLayout(new javax.swing.BoxLayout(ProjectLocationsCenterPanel5, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsCenterPanel5.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsCenterPanel5.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectLocationsCenterPanel5.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectLocationsCenterPanel5.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller41.setBackground(new java.awt.Color(140, 160, 210));
        lFiller41.setText("   ");
        lFiller41.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller41.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller41.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel5.add(lFiller41);

        lTryButtonText4.setBackground(new java.awt.Color(140, 160, 210));
        lTryButtonText4.setFont(new java.awt.Font("Arial", 0, 12));
        lTryButtonText4.setText("Button Text:");
        lTryButtonText4.setMaximumSize(new java.awt.Dimension(80, 15));
        lTryButtonText4.setMinimumSize(new java.awt.Dimension(80, 15));
        lTryButtonText4.setPreferredSize(new java.awt.Dimension(80, 15));
        lTryButtonText4.setRequestFocusEnabled(false);
        ProjectLocationsCenterPanel5.add(lTryButtonText4);

        tfExitButtonText.setFont(new java.awt.Font("Arial", 0, 12));
        tfExitButtonText.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfExitButtonText.setText("Quit");
        tfExitButtonText.setMaximumSize(new java.awt.Dimension(120, 20));
        tfExitButtonText.setMinimumSize(new java.awt.Dimension(120, 20));
        tfExitButtonText.setPreferredSize(new java.awt.Dimension(120, 20));
        ProjectLocationsCenterPanel5.add(tfExitButtonText);

        lFiller42.setBackground(new java.awt.Color(140, 160, 210));
        lFiller42.setText("   ");
        lFiller42.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller42.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller42.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel5.add(lFiller42);

        lTryButtonMnemonic4.setBackground(new java.awt.Color(140, 160, 210));
        lTryButtonMnemonic4.setFont(new java.awt.Font("Arial", 0, 12));
        lTryButtonMnemonic4.setText("Button Mnemonic:");
        lTryButtonMnemonic4.setMaximumSize(new java.awt.Dimension(110, 15));
        lTryButtonMnemonic4.setMinimumSize(new java.awt.Dimension(110, 15));
        lTryButtonMnemonic4.setPreferredSize(new java.awt.Dimension(110, 15));
        lTryButtonMnemonic4.setRequestFocusEnabled(false);
        ProjectLocationsCenterPanel5.add(lTryButtonMnemonic4);

        tfExitButtonMnemonic.setFont(new java.awt.Font("Arial", 0, 12));
        tfExitButtonMnemonic.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfExitButtonMnemonic.setText("Q");
        tfExitButtonMnemonic.setMaximumSize(new java.awt.Dimension(15, 20));
        tfExitButtonMnemonic.setMinimumSize(new java.awt.Dimension(15, 20));
        tfExitButtonMnemonic.setPreferredSize(new java.awt.Dimension(15, 20));
        ProjectLocationsCenterPanel5.add(tfExitButtonMnemonic);

        lFiller40.setBackground(new java.awt.Color(140, 160, 210));
        lFiller40.setText("   ");
        lFiller40.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller40.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller40.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel5.add(lFiller40);

        cbExitButtonEnabled.setBackground(new java.awt.Color(140, 160, 210));
        cbExitButtonEnabled.setFont(new java.awt.Font("Arial", 0, 12));
        cbExitButtonEnabled.setSelected(true);
        cbExitButtonEnabled.setText("Enabled");
        cbExitButtonEnabled.setMaximumSize(new java.awt.Dimension(100, 23));
        cbExitButtonEnabled.setMinimumSize(new java.awt.Dimension(100, 23));
        cbExitButtonEnabled.setPreferredSize(new java.awt.Dimension(100, 23));
        cbExitButtonEnabled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbExitButtonEnabledActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel5.add(cbExitButtonEnabled);

        ExitButtonPanel.add(ProjectLocationsCenterPanel5);

        add(ExitButtonPanel);

        SouthButtonPanelFiller.setLayout(new javax.swing.BoxLayout(SouthButtonPanelFiller, javax.swing.BoxLayout.Y_AXIS));

        SouthButtonPanelFiller.setBackground(new java.awt.Color(140, 160, 210));
        SouthButtonPanelFiller.setMaximumSize(new java.awt.Dimension(32767, 75));
        SouthButtonPanelFiller.setMinimumSize(new java.awt.Dimension(10, 50));
        SouthButtonPanelFiller.setPreferredSize(new java.awt.Dimension(10, 60));
        ImageDescriptionLabel3.setLayout(new javax.swing.BoxLayout(ImageDescriptionLabel3, javax.swing.BoxLayout.X_AXIS));

        ImageDescriptionLabel3.setBackground(new java.awt.Color(140, 160, 210));
        LeftUIFiller5.setMaximumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller5.setMinimumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller5.setPreferredSize(new java.awt.Dimension(10, 10));
        ImageDescriptionLabel3.add(LeftUIFiller5);

        SouthButtonPanelFiller.add(ImageDescriptionLabel3);

        ProjectLocationsCenterPanel4.setLayout(new javax.swing.BoxLayout(ProjectLocationsCenterPanel4, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsCenterPanel4.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsCenterPanel4.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectLocationsCenterPanel4.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectLocationsCenterPanel4.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller48.setBackground(new java.awt.Color(140, 160, 210));
        lFiller48.setText("   ");
        lFiller48.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller48.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller48.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel4.add(lFiller48);

        PreviewButton.setFont(new java.awt.Font("Arial", 0, 12));
        PreviewButton.setLabel("Preview");
        PreviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviewButtonActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel4.add(PreviewButton);

        lFiller45.setBackground(new java.awt.Color(140, 160, 210));
        lFiller45.setText("   ");
        lFiller45.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller45.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller45.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel4.add(lFiller45);

        lFiller47.setBackground(new java.awt.Color(140, 160, 210));
        lFiller47.setText("   ");
        lFiller47.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller47.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller47.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel4.add(lFiller47);

        SouthButtonPanelFiller.add(ProjectLocationsCenterPanel4);

        UIChoicesBottomPanel4.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel4.setMinimumSize(new java.awt.Dimension(5, 5));
        UIChoicesBottomPanel4.setPreferredSize(new java.awt.Dimension(5, 5));
        SouthButtonPanelFiller.add(UIChoicesBottomPanel4);

        add(SouthButtonPanelFiller);

    }//GEN-END:initComponents

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost

    }//GEN-LAST:event_formFocusLost

    private void tfInformationButtonActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfInformationButtonActionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfInformationButtonActionActionPerformed

    private void tfBuyButtonActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBuyButtonActionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBuyButtonActionActionPerformed

    private void cbExitButtonEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbExitButtonEnabledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbExitButtonEnabledActionPerformed

    private void cbInformationButtonEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbInformationButtonEnabledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbInformationButtonEnabledActionPerformed

    private void cbInformationButtonActionTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbInformationButtonActionTypeActionPerformed
	try
	{
            	if(cbInformationButtonActionType.getSelectedIndex()==0)
		{
                    tfInformationButtonAction.setEnabled(false);
                }
                else if(cbInformationButtonActionType.getSelectedIndex()==1)
		{
                    tfInformationButtonAction.setEnabled(true);
			if(tfInformationButtonAction.getText().equalsIgnoreCase("")==true)
			{
                            if(ProjectManager.get("product_info_url")!=null)
                            {
                                if(ProjectManager.get("product_info_url").equalsIgnoreCase("")==true)
                                {
                                    tfInformationButtonAction.setText("http://www.evaluateanywhere.com");
                                }
                                else
                                {
                                    tfInformationButtonAction.setText(ProjectManager.get("product_info_url"));
                                }
                            }
                            else
                            {
                                    tfInformationButtonAction.setText("http://www.evaluateanywhere.com");
                            }
                        }
                        else
                        {
                            try
                            {
                                new URL(ProjectManager.get("product_info_url"));
                                tfInformationButtonAction.setText(ProjectManager.get("product_info_url"));
                            }
                            catch(MalformedURLException e)
                            {
                                if(ProjectManager.get("product_info_url")!=null)
                                {
                                    if(ProjectManager.get("product_info_url").equalsIgnoreCase("")==true)
                                    {
                                        tfInformationButtonAction.setText("http://www.evaluateanywhere.com");
                                    }
                                    else
                                    {
                                        tfInformationButtonAction.setText(ProjectManager.get("product_info_url"));
                                    }
                                }
                                else
                                {
                                        tfInformationButtonAction.setText("http://www.evaluateanywhere.com");
                                }                                
                            }
                        }
	
                }
                else if(cbInformationButtonActionType.getSelectedIndex()==2)
                {
                     tfInformationButtonAction.setEnabled(false);
                     tfInformationButtonAction.setText("Display Information Dialog Action");              
                }                    
        }
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_cbInformationButtonActionTypeActionPerformed

    private void cbRegistrationCodeButtonEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRegistrationCodeButtonEnabledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbRegistrationCodeButtonEnabledActionPerformed

    private void cbRegistrationCodeButtonActionTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRegistrationCodeButtonActionTypeActionPerformed
	try
	{
		if(cbRegistrationCodeButtonActionType.getSelectedIndex()==0)
		{            
                    tfRegistrationCodeButtonAction.setEnabled(false);
                }
		if(cbRegistrationCodeButtonActionType.getSelectedIndex()==1)
		{
                        tfRegistrationCodeButtonAction.setEnabled(true);
			if(tfRegistrationCodeButtonAction.getText().equalsIgnoreCase("")==true)
			{
                            if(ProjectManager.get("product_url")!=null)
                            {
                                if(ProjectManager.get("product_url").equalsIgnoreCase("")==true)
                                {
                                    tfRegistrationCodeButtonAction.setText("http://www.evaluateanywhere.com");
                                }
                                else
                                {
                                    tfRegistrationCodeButtonAction.setText(ProjectManager.get("product_url"));
                                }
                            }
                            else
                            {
                                    tfRegistrationCodeButtonAction.setText("http://www.evaluateanywhere.com");
                            }
                        }
                        else
                        {
                            try
                            {
                                new URL(ProjectManager.get("product_url"));
                                tfRegistrationCodeButtonAction.setText(ProjectManager.get("product_url"));
                            }
                            catch(MalformedURLException e)
                            {
                                if(ProjectManager.get("product_url")!=null)
                                {
                                    if(ProjectManager.get("product_url").equalsIgnoreCase("")==true)
                                    {
                                        tfRegistrationCodeButtonAction.setText("http://www.evaluateanywhere.com");
                                    }
                                    else
                                    {
                                        tfRegistrationCodeButtonAction.setText(ProjectManager.get("product_url"));
                                    }
                                }
                                else
                                {
                                        tfRegistrationCodeButtonAction.setText("http://www.evaluateanywhere.com");
                                }                                
                            }
                        }                       
	
                }
                else if(cbRegistrationCodeButtonActionType.getSelectedIndex()==2)
                {
                     tfRegistrationCodeButtonAction.setEnabled(false);                    
                     tfRegistrationCodeButtonAction.setText("Enter Registration Code Action");               
                }                  
        }
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_cbRegistrationCodeButtonActionTypeActionPerformed

    private void cbBuyButtonEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBuyButtonEnabledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBuyButtonEnabledActionPerformed

    private void cbBuyButtonActionTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBuyButtonActionTypeActionPerformed
	try
	{
		if(cbBuyButtonActionType.getSelectedIndex()==0)
		{
                    tfBuyButtonAction.setEnabled(false);
                }
                else if(cbBuyButtonActionType.getSelectedIndex()==1)
		{
                    tfBuyButtonAction.setEnabled(true);                    
			if(tfBuyButtonAction.getText().equalsIgnoreCase("")==true)
			{
                            if(ProjectManager.get("product_url")!=null)
                            {
                                if(ProjectManager.get("product_url").equalsIgnoreCase("")==true)
                                {
                                    tfBuyButtonAction.setText("http://www.evaluateanywhere.com");
                                }
                                else
                                {
                                    tfBuyButtonAction.setText(ProjectManager.get("product_url"));
                                }
                            }
                            else
                            {
                                    tfBuyButtonAction.setText("http://www.evaluateanywhere.com");
                            }
                        }
                        else
                        {
                            try
                            {
                                new URL(ProjectManager.get("product_url"));
                                tfBuyButtonAction.setText(ProjectManager.get("product_url"));
                            }
                            catch(MalformedURLException e)
                            {
                                if(ProjectManager.get("product_url")!=null)
                                {
                                    if(ProjectManager.get("product_url").equalsIgnoreCase("")==true)
                                    {
                                        tfBuyButtonAction.setText("http://www.evaluateanywhere.com");
                                    }
                                    else
                                    {
                                        tfBuyButtonAction.setText(ProjectManager.get("product_url"));
                                    }
                                }
                                else
                                {
                                        tfBuyButtonAction.setText("http://www.evaluateanywhere.com");
                                }                                
                            }
                        } 	
                }
                else if(cbBuyButtonActionType.getSelectedIndex()==2)
                {
                    tfBuyButtonAction.setEnabled(false);                    
                    tfBuyButtonAction.setText("Buy Software Action");                
                }                
        }
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_cbBuyButtonActionTypeActionPerformed

    private void cbUseEvaluationButtonEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUseEvaluationButtonEnabledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbUseEvaluationButtonEnabledActionPerformed

    private void PreviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviewButtonActionPerformed
	try
	{
		((EAPanel)getParentComponent()).getDataUpdate();
		new StartVerticalButtonBarThemeAction();	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_PreviewButtonActionPerformed

    private void cbUseEvaluationButtonActionTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUseEvaluationButtonActionTypeActionPerformed
	try
	{
		if(cbUseEvaluationButtonActionType.getSelectedIndex()==0)
		{
                    tfUseEvaluationButtonAction.setEnabled(false);
                }
                else if(cbUseEvaluationButtonActionType.getSelectedIndex()==1)
		{
                    tfUseEvaluationButtonAction.setEnabled(true);                    
			if(tfUseEvaluationButtonAction.getText().equalsIgnoreCase("")==true)
			{
                            if(ProjectManager.get("product_url")!=null)
                            {
                                if(ProjectManager.get("product_url").equalsIgnoreCase("")==true)
                                {
                                    tfUseEvaluationButtonAction.setText("http://www.evaluateanywhere.com");
                                }
                                else
                                {
                                    tfUseEvaluationButtonAction.setText(ProjectManager.get("product_url"));
                                }
                            }
                            else
                            {
                                    tfUseEvaluationButtonAction.setText("http://www.evaluateanywhere.com");
                            }
                        }
                        else
                        {
                            try
                            {
                                new URL(ProjectManager.get("product_url"));
                                tfUseEvaluationButtonAction.setText(ProjectManager.get("product_url"));
                                
                            }
                            catch(MalformedURLException e)
                            {
                                if(ProjectManager.get("product_url")!=null)
                                {
                                    if(ProjectManager.get("product_url").equalsIgnoreCase("")==true)
                                    {
                                        tfUseEvaluationButtonAction.setText("http://www.evaluateanywhere.com");
                                    }
                                    else
                                    {
                                        tfUseEvaluationButtonAction.setText(ProjectManager.get("product_url"));
                                    }
                                }
                                else
                                {
                                        tfUseEvaluationButtonAction.setText("http://www.evaluateanywhere.com");
                                }                                
                            }
                        } 	
                }
                else if(cbUseEvaluationButtonActionType.getSelectedIndex()==2)
                {
                     tfUseEvaluationButtonAction.setEnabled(false);
                     tfUseEvaluationButtonAction.setText("Launch Software Action");                   
                }
        }
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_cbUseEvaluationButtonActionTypeActionPerformed
 
    private static Object[] getStringArraysFromString(String textArrayString)
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
    private javax.swing.JPanel BuyButtonPanel;
    private javax.swing.JPanel ExitButtonPanel;
    private javax.swing.JPanel ImageDescriptionLabel3;
    private javax.swing.JPanel InformationButtonPanel;
    private javax.swing.JLabel LeftUIFiller5;
    private javax.swing.JButton PreviewButton;
    private javax.swing.JPanel ProjectLocationsCenterPanel1;
    private javax.swing.JPanel ProjectLocationsCenterPanel2;
    private javax.swing.JPanel ProjectLocationsCenterPanel3;
    private javax.swing.JPanel ProjectLocationsCenterPanel4;
    private javax.swing.JPanel ProjectLocationsCenterPanel5;
    private javax.swing.JPanel ProjectLocationsCenterPanel7;
    private javax.swing.JPanel RegistrationCodeButtonPanel;
    private javax.swing.JPanel SouthButtonPanelFiller;
    private javax.swing.JPanel TryButtonPanel;
    private javax.swing.JPanel UIChoicesBottomPanel11;
    private javax.swing.JPanel UIChoicesBottomPanel12;
    private javax.swing.JPanel UIChoicesBottomPanel13;
    private javax.swing.JPanel UIChoicesBottomPanel14;
    private javax.swing.JPanel UIChoicesBottomPanel4;
    private javax.swing.JComboBox cbBuyButtonActionType;
    private javax.swing.JCheckBox cbBuyButtonEnabled;
    private javax.swing.JCheckBox cbExitButtonEnabled;
    private javax.swing.JComboBox cbInformationButtonActionType;
    private javax.swing.JCheckBox cbInformationButtonEnabled;
    private javax.swing.JComboBox cbRegistrationCodeButtonActionType;
    private javax.swing.JCheckBox cbRegistrationCodeButtonEnabled;
    private javax.swing.JComboBox cbUseEvaluationButtonActionType;
    private javax.swing.JCheckBox cbUseEvaluationButtonEnabled;
    private javax.swing.JLabel lFiller103;
    private javax.swing.JLabel lFiller104;
    private javax.swing.JLabel lFiller105;
    private javax.swing.JLabel lFiller24;
    private javax.swing.JLabel lFiller25;
    private javax.swing.JLabel lFiller27;
    private javax.swing.JLabel lFiller30;
    private javax.swing.JLabel lFiller34;
    private javax.swing.JLabel lFiller35;
    private javax.swing.JLabel lFiller36;
    private javax.swing.JLabel lFiller37;
    private javax.swing.JLabel lFiller40;
    private javax.swing.JLabel lFiller41;
    private javax.swing.JLabel lFiller42;
    private javax.swing.JLabel lFiller43;
    private javax.swing.JLabel lFiller45;
    private javax.swing.JLabel lFiller46;
    private javax.swing.JLabel lFiller47;
    private javax.swing.JLabel lFiller48;
    private javax.swing.JLabel lFiller50;
    private javax.swing.JLabel lFiller51;
    private javax.swing.JLabel lFiller52;
    private javax.swing.JLabel lFiller64;
    private javax.swing.JLabel lFiller65;
    private javax.swing.JLabel lFiller66;
    private javax.swing.JLabel lFiller67;
    private javax.swing.JLabel lFiller68;
    private javax.swing.JLabel lFiller69;
    private javax.swing.JLabel lFiller70;
    private javax.swing.JLabel lFiller71;
    private javax.swing.JLabel lFiller72;
    private javax.swing.JLabel lTryButtonMnemonic;
    private javax.swing.JLabel lTryButtonMnemonic1;
    private javax.swing.JLabel lTryButtonMnemonic2;
    private javax.swing.JLabel lTryButtonMnemonic3;
    private javax.swing.JLabel lTryButtonMnemonic4;
    private javax.swing.JLabel lTryButtonText;
    private javax.swing.JLabel lTryButtonText1;
    private javax.swing.JLabel lTryButtonText2;
    private javax.swing.JLabel lTryButtonText3;
    private javax.swing.JLabel lTryButtonText4;
    private javax.swing.JLabel lVerticalButtonBarButtonAction;
    private javax.swing.JLabel lVerticalButtonBarButtonAction1;
    private javax.swing.JLabel lVerticalButtonBarButtonAction2;
    private javax.swing.JLabel lVerticalButtonBarButtonAction4;
    private javax.swing.JLabel lVerticalButtonBarButtonActionType;
    private javax.swing.JLabel lVerticalButtonBarButtonActionType1;
    private javax.swing.JLabel lVerticalButtonBarButtonActionType2;
    private javax.swing.JLabel lVerticalButtonBarButtonActionType4;
    private javax.swing.JTextField tfBuyButtonAction;
    private javax.swing.JTextField tfBuyButtonMnemonic;
    private javax.swing.JTextField tfBuyButtonText;
    private javax.swing.JTextField tfExitButtonMnemonic;
    private javax.swing.JTextField tfExitButtonText;
    private javax.swing.JTextField tfInformationButtonAction;
    private javax.swing.JTextField tfInformationButtonMnemonic;
    private javax.swing.JTextField tfInformationButtonText;
    private javax.swing.JTextField tfRegistrationCodeButtonAction;
    private javax.swing.JTextField tfRegistrationCodeButtonMnemonic;
    private javax.swing.JTextField tfRegistrationCodeButtonText;
    private javax.swing.JTextField tfUseEvaluationButtonAction;
    private javax.swing.JTextField tfUseEvaluationButtonMnemonic;
    private javax.swing.JTextField tfUseEvaluationButtonText;
    // End of variables declaration//GEN-END:variables
    
}
