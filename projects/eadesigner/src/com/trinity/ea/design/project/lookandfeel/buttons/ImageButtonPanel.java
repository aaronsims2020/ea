/*
 * ImageButtonPanel.java
 *
 * Created on June 13, 2004, 3:24 PM
 */

package com.trinity.ea.design.project.lookandfeel.buttons;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.project.lookandfeel.preview.actions.StartVerticalButtonBarThemeAction;
import com.trinity.ea.design.payments.actions.BuyNowAction;
import com.trinity.ea.design.common.fontchooser.FontChooser;
import com.trinity.ea.design.common.filechooser.ImageFileFilter;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import java.awt.*;
import javax.swing.*; 
import com.trinity.ea.design.common.colorchooser.JLocalColorChooser;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class ImageButtonPanel extends EAPanel {
    ImageFileFilter filter = new ImageFileFilter(new String[] {"gif", "jpg", "jpeg", "png"}, "Select an image file");   
    JFileChooser imageFileChooser = new JFileChooser();
    private ImageIcon noColorIcon = new ImageIcon(getClass().getResource("/images/nocolor.png"));
    /** Creates new form ButtonPanel */
    public ImageButtonPanel() 
    {
        initComponents();
        updateButtonBarTextColorSwatch();
        updateButtonBarBackgroundColorSwatch();
        setProjectData();
    }

    public synchronized void getDataUpdate()
    {
	try
        {
		// Button Image Width
            SpinnerNumberModel btnBarImgButtonWidthSpinModel = (SpinnerNumberModel)spinButtonImageWidth.getModel();
            ProjectManager.putTempNoFileWrite("btnBarImgButtonWidth", String.valueOf(btnBarImgButtonWidthSpinModel.getNumber().intValue()));            
            ProjectManager.putTempNoFileWrite("paymentImgCancelButtonWidth", String.valueOf(btnBarImgButtonWidthSpinModel.getNumber().intValue()));            
            ProjectManager.putTempNoFileWrite("registrationImgButtonWidth", String.valueOf(btnBarImgButtonWidthSpinModel.getNumber().intValue()));            
            
            SpinnerNumberModel btnBarImgButtonWidthSpinModel1 = (SpinnerNumberModel)spinButtonImageWidth1.getModel();
            ProjectManager.putTempNoFileWrite("paymentImgContinueButtonWidth", String.valueOf(btnBarImgButtonWidthSpinModel1.getNumber().intValue())); 

            SpinnerNumberModel btnBarImgButtonWidthSpinModel2 = (SpinnerNumberModel)spinButtonImageWidth2.getModel();
            ProjectManager.putTempNoFileWrite("paymentImgSecondaryButtonWidth", String.valueOf(btnBarImgButtonWidthSpinModel2.getNumber().intValue()));             
            
            // Button Image Height
            SpinnerNumberModel btnBarImgButtonHeightSpinModel = (SpinnerNumberModel)spinButtonImageHeight.getModel();
            ProjectManager.putTempNoFileWrite("btnBarImgButtonHeight", String.valueOf(btnBarImgButtonHeightSpinModel.getNumber().intValue()));            
            ProjectManager.putTempNoFileWrite("paymentImgCancelButtonHeight", String.valueOf(btnBarImgButtonHeightSpinModel.getNumber().intValue()));            
            ProjectManager.putTempNoFileWrite("registrationImgButtonHeight", String.valueOf(btnBarImgButtonHeightSpinModel.getNumber().intValue()+1));            

            SpinnerNumberModel btnBarImgButtonHeightSpinModel1 = (SpinnerNumberModel)spinButtonImageHeight1.getModel();
            ProjectManager.putTempNoFileWrite("paymentImgContinueButtonHeight", String.valueOf(btnBarImgButtonHeightSpinModel1.getNumber().intValue()));            
 
            SpinnerNumberModel btnBarImgButtonHeightSpinModel2 = (SpinnerNumberModel)spinButtonImageHeight2.getModel();
            ProjectManager.putTempNoFileWrite("paymentImgSecondaryButtonHeight", String.valueOf(btnBarImgButtonHeightSpinModel2.getNumber().intValue()));            

            
// File Locations
	try
	{
		if(tfImageButtonPath.getText().equalsIgnoreCase("")==false)
		{
			ProjectManager.putTempNoFileWrite("btnBarImgButtonFace", new File(tfImageButtonPath.getText()).toURL().toString());
			ProjectManager.putTempNoFileWrite("registrationImgButtonFace", new File(tfImageButtonPath.getText()).toURL().toString());
			ProjectManager.putTempNoFileWrite("paymentImgCancelButtonFace", new File(tfImageButtonPath.getText()).toURL().toString());

                }
		if(tfImageButtonOnClickPath.getText().equalsIgnoreCase("")==false)
		{
			ProjectManager.putTempNoFileWrite("btnBarImgButtonFaceOnClick", new File(tfImageButtonOnClickPath.getText()).toURL().toString());
			ProjectManager.putTempNoFileWrite("registrationImgButtonFaceOnClick", new File(tfImageButtonOnClickPath.getText()).toURL().toString());
			ProjectManager.putTempNoFileWrite("paymentImgCancelButtonFaceOnClick", new File(tfImageButtonOnClickPath.getText()).toURL().toString());

                }
		if(tfImageButtonInFocusPath.getText().equalsIgnoreCase("")==false)
		{
			ProjectManager.putTempNoFileWrite("buttonFaceImageInFocus", new File(tfImageButtonInFocusPath.getText()).toURL().toString());
			ProjectManager.putTempNoFileWrite("registrationButtonFaceInFocus", new File(tfImageButtonInFocusPath.getText()).toURL().toString());
			ProjectManager.putTempNoFileWrite("paymentImgCancelButtonFaceInFocus", new File(tfImageButtonInFocusPath.getText()).toURL().toString());

                }

		if(tfImageButtonPath1.getText().equalsIgnoreCase("")==false)
		{
			ProjectManager.putTempNoFileWrite("paymentImgContinueButtonFace", new File(tfImageButtonPath1.getText()).toURL().toString());
                }
		if(tfImageButtonOnClickPath1.getText().equalsIgnoreCase("")==false)
		{
			ProjectManager.putTempNoFileWrite("paymentImgContinueButtonFaceOnClick", new File(tfImageButtonOnClickPath1.getText()).toURL().toString());
                }
		if(tfImageButtonInFocusPath1.getText().equalsIgnoreCase("")==false)
		{
			ProjectManager.putTempNoFileWrite("paymentImgContinueButtonFaceInFocus", new File(tfImageButtonInFocusPath1.getText()).toURL().toString());
                }                

 		if(tfImageButtonPath2.getText().equalsIgnoreCase("")==false)
		{
			ProjectManager.putTempNoFileWrite("paymentImgSecondaryButtonFace", new File(tfImageButtonPath2.getText()).toURL().toString());
                }
		if(tfImageButtonOnClickPath2.getText().equalsIgnoreCase("")==false)
		{
			ProjectManager.putTempNoFileWrite("paymentImgSecondaryButtonFaceOnClick", new File(tfImageButtonOnClickPath2.getText()).toURL().toString());
                }
		if(tfImageButtonInFocusPath2.getText().equalsIgnoreCase("")==false)
		{
			ProjectManager.putTempNoFileWrite("paymentImgSecondaryButtonFaceInFocus", new File(tfImageButtonInFocusPath2.getText()).toURL().toString());
                }                     
                
		if(cbUseEvaluationButtonActionType.getSelectedIndex()==0)
		{
			ProjectManager.putTempNoFileWrite("secondaryPaymentMethodType", "-1"); 
		}
		else if(cbUseEvaluationButtonActionType.getSelectedIndex()==1)
		{
			ProjectManager.putTempNoFileWrite("secondaryPaymentMethodType", "0"); 
		}	
		else if(cbUseEvaluationButtonActionType.getSelectedIndex()==2)
		{
			ProjectManager.putTempNoFileWrite("secondaryPaymentMethodType", "1"); 
		}	
                if(ProjectManager.get("secondaryPaymentMethodType").equalsIgnoreCase("1")==false)
                {                
                    ProjectManager.putTempNoFileWrite("secondaryPaymentMethod", tfUseEvaluationButtonAction.getText()); 
                }    
	}
	catch(Exception ee)
	{
		ee.printStackTrace();
	}
// End File Locations


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
            
 		// Image Buttons Enabled
            if(ProjectManager.get("btnBarImgButtonsEnabled")!=null)
            {
            	if(ProjectManager.get("btnBarImgButtonsEnabled").equalsIgnoreCase("true")==true)
            	{
                		useImageButtonsEnabled.setSelected(true);
			}
			else
			{
				useImageButtonsEnabled.setSelected(false);
			}
            }
            else
            {
			useImageButtonsEnabled.setSelected(false);      
            }

            if(ProjectManager.get("secondaryPaymentMethodEnabled")!=null)
            {
            	if(ProjectManager.get("secondaryPaymentMethodEnabled").equalsIgnoreCase("true")==true)
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
            
		// Button Image Width		
            if(ProjectManager.get("btnBarImgButtonWidth")!=null)
            {
			if(ProjectManager.get("btnBarImgButtonWidth").equalsIgnoreCase("")==false)
			{
	    		      spinButtonImageWidth.setModel(new SpinnerNumberModel(Integer.valueOf(ProjectManager.get("btnBarImgButtonWidth")),new Integer(0),new Integer(9999),new Integer(1)));
			}
			else
			{
	    		      spinButtonImageWidth.setModel(new SpinnerNumberModel(new Integer(94),new Integer(0),new Integer(9999),new Integer(1)));
			}
            }
		else
		{
	    		spinButtonImageWidth.setModel(new SpinnerNumberModel(new Integer(94),new Integer(0),new Integer(9999),new Integer(1)));
		}  
		JComponent editor = spinButtonImageWidth.getEditor();
		JSpinner.NumberEditor field = (JSpinner.NumberEditor)editor;
		field.getTextField().setEditable(false);
                
            if(ProjectManager.get("paymentImgContinueButtonWidth")!=null)
            {
			if(ProjectManager.get("paymentImgContinueButtonWidth").equalsIgnoreCase("")==false)
			{
	    		      spinButtonImageWidth1.setModel(new SpinnerNumberModel(Integer.valueOf(ProjectManager.get("paymentImgContinueButtonWidth")),new Integer(0),new Integer(9999),new Integer(1)));
			}
			else
			{
	    		      spinButtonImageWidth1.setModel(new SpinnerNumberModel(new Integer(123),new Integer(0),new Integer(9999),new Integer(1)));
			}
            }
		else
		{
	    		spinButtonImageWidth1.setModel(new SpinnerNumberModel(new Integer(123),new Integer(0),new Integer(9999),new Integer(1)));
		}  
		editor = spinButtonImageWidth1.getEditor();
		field = (JSpinner.NumberEditor)editor;
		field.getTextField().setEditable(false);                
 
            if(ProjectManager.get("paymentImgSecondaryButtonWidth")!=null)
            {
			if(ProjectManager.get("paymentImgSecondaryButtonWidth").equalsIgnoreCase("")==false)
			{
	    		      spinButtonImageWidth2.setModel(new SpinnerNumberModel(Integer.valueOf(ProjectManager.get("paymentImgSecondaryButtonWidth")),new Integer(0),new Integer(9999),new Integer(1)));
			}
			else
			{
	    		      spinButtonImageWidth2.setModel(new SpinnerNumberModel(new Integer(536),new Integer(0),new Integer(9999),new Integer(1)));
			}
            }
		else
		{
	    		spinButtonImageWidth2.setModel(new SpinnerNumberModel(new Integer(536),new Integer(0),new Integer(9999),new Integer(1)));
		}  
		editor = spinButtonImageWidth2.getEditor();
		field = (JSpinner.NumberEditor)editor;
		field.getTextField().setEditable(false);                  
                
		// Button Image Height
            if(ProjectManager.get("btnBarImgButtonHeight")!=null)
            {
			if(ProjectManager.get("btnBarImgButtonHeight").equalsIgnoreCase("")==false)
			{
	    		      spinButtonImageHeight.setModel(new SpinnerNumberModel(Integer.valueOf(ProjectManager.get("btnBarImgButtonHeight")),new Integer(0),new Integer(9999),new Integer(1)));
			}
			else
			{
	    		      spinButtonImageHeight.setModel(new SpinnerNumberModel(new Integer(23),new Integer(0),new Integer(9999),new Integer(1)));
			}
            }
		else
		{
	    		spinButtonImageHeight.setModel(new SpinnerNumberModel(new Integer(23),new Integer(0),new Integer(9999),new Integer(1)));
		}  
		editor = spinButtonImageHeight.getEditor();
		field = (JSpinner.NumberEditor)editor;
		field.getTextField().setEditable(false);
                
                
            if(ProjectManager.get("paymentImgContinueButtonHeight")!=null)
            {
			if(ProjectManager.get("paymentImgContinueButtonHeight").equalsIgnoreCase("")==false)
			{
	    		      spinButtonImageHeight1.setModel(new SpinnerNumberModel(Integer.valueOf(ProjectManager.get("paymentImgContinueButtonHeight")),new Integer(0),new Integer(9999),new Integer(1)));
			}
			else
			{
	    		      spinButtonImageHeight1.setModel(new SpinnerNumberModel(new Integer(31),new Integer(0),new Integer(9999),new Integer(1)));
			}
            }
		else
		{
	    		spinButtonImageHeight1.setModel(new SpinnerNumberModel(new Integer(31),new Integer(0),new Integer(9999),new Integer(1)));
		}  
		editor = spinButtonImageHeight1.getEditor();
		field = (JSpinner.NumberEditor)editor;
		field.getTextField().setEditable(false);      
                
             if(ProjectManager.get("paymentImgSecondaryButtonHeight")!=null)
            {
			if(ProjectManager.get("paymentImgSecondaryButtonHeight").equalsIgnoreCase("")==false)
			{
	    		      spinButtonImageHeight2.setModel(new SpinnerNumberModel(Integer.valueOf(ProjectManager.get("paymentImgSecondaryButtonHeight")),new Integer(0),new Integer(9999),new Integer(1)));
			}
			else
			{
	    		      spinButtonImageHeight2.setModel(new SpinnerNumberModel(new Integer(34),new Integer(0),new Integer(9999),new Integer(1)));
			}
            }
		else
		{
	    		spinButtonImageHeight2.setModel(new SpinnerNumberModel(new Integer(34),new Integer(0),new Integer(9999),new Integer(1)));
		}  
		editor = spinButtonImageHeight2.getEditor();
		field = (JSpinner.NumberEditor)editor;
		field.getTextField().setEditable(false);                 
                
            // File Locations
                    try
                    {
            if(ProjectManager.get("btnBarImgButtonFace")!=null)
            {
                    if(ProjectManager.get("btnBarImgButtonFace").equalsIgnoreCase("")==false)
                    {
                            tfImageButtonPath.setText(new File(new URL(ProjectManager.get("btnBarImgButtonFace")).getFile()).getCanonicalPath());
                            tfImageButtonPath.setCaretPosition(0);
                    }
                    else
                    {
                            tfImageButtonPath.setText("");
                    }
            }
            else
            {
                    tfImageButtonPath.setText("");
            }
            if(ProjectManager.get("btnBarImgButtonFaceOnClick")!=null)
            {
                    if(ProjectManager.get("btnBarImgButtonFaceOnClick").equalsIgnoreCase("")==false)
                    {
                            tfImageButtonOnClickPath.setText(new File(new URL(ProjectManager.get("btnBarImgButtonFaceOnClick")).getFile()).getCanonicalPath());
                            tfImageButtonOnClickPath.setCaretPosition(0);
                    }
                    else
                    {
                            tfImageButtonOnClickPath.setText("");
                    }
            }
            else
            {
                    tfImageButtonOnClickPath.setText("");
            }
            if(ProjectManager.get("buttonFaceImageInFocus")!=null)
            {
                    if(ProjectManager.get("buttonFaceImageInFocus").equalsIgnoreCase("")==false)
                    {
                            tfImageButtonInFocusPath.setText(new File(new URL(ProjectManager.get("buttonFaceImageInFocus")).getFile()).getCanonicalPath());
                            tfImageButtonInFocusPath.setCaretPosition(0);
                    }
                    else
                    {
                            tfImageButtonInFocusPath.setText("");
                    }
            }
            else
            {
                    tfImageButtonInFocusPath.setText("");
            }
            
             if(ProjectManager.get("paymentImgContinueButtonFace")!=null)
            {
                    if(ProjectManager.get("paymentImgContinueButtonFace").equalsIgnoreCase("")==false)
                    {
                            tfImageButtonPath1.setText(new File(new URL(ProjectManager.get("paymentImgContinueButtonFace")).getFile()).getCanonicalPath());
                            tfImageButtonPath1.setCaretPosition(0);
                    }
                    else
                    {
                            tfImageButtonPath1.setText("");
                    }
            }
            else
            {
                    tfImageButtonPath1.setText("");
            }
            if(ProjectManager.get("paymentImgContinueButtonFaceOnClick")!=null)
            {
                    if(ProjectManager.get("paymentImgContinueButtonFaceOnClick").equalsIgnoreCase("")==false)
                    {
                            tfImageButtonOnClickPath1.setText(new File(new URL(ProjectManager.get("paymentImgContinueButtonFaceOnClick")).getFile()).getCanonicalPath());
                            tfImageButtonOnClickPath1.setCaretPosition(0);
                    }
                    else
                    {
                            tfImageButtonOnClickPath1.setText("");
                    }
            }
            else
            {
                    tfImageButtonOnClickPath1.setText("");
            }
            if(ProjectManager.get("paymentImgContinueButtonFaceInFocus")!=null)
            {
                    if(ProjectManager.get("paymentImgContinueButtonFaceInFocus").equalsIgnoreCase("")==false)
                    {
                            tfImageButtonInFocusPath1.setText(new File(new URL(ProjectManager.get("paymentImgContinueButtonFaceInFocus")).getFile()).getCanonicalPath());
                            tfImageButtonInFocusPath1.setCaretPosition(0);
                    }
                    else
                    {
                            tfImageButtonInFocusPath1.setText("");
                    }
            }
            else
            {
                    tfImageButtonInFocusPath1.setText("");
            }           
            
              if(ProjectManager.get("paymentImgSecondaryButtonFace")!=null)
            {
                    if(ProjectManager.get("paymentImgSecondaryButtonFace").equalsIgnoreCase("")==false)
                    {
                            tfImageButtonPath2.setText(new File(new URL(ProjectManager.get("paymentImgSecondaryButtonFace")).getFile()).getCanonicalPath());
                            tfImageButtonPath2.setCaretPosition(0);
                    }
                    else
                    {
                            tfImageButtonPath2.setText("");
                    }
            }
            else
            {
                    tfImageButtonPath2.setText(""); 
            }
            if(ProjectManager.get("paymentImgSecondaryButtonFaceOnClick")!=null)
            {
                    if(ProjectManager.get("paymentImgSecondaryButtonFaceOnClick").equalsIgnoreCase("")==false)
                    {
                            tfImageButtonOnClickPath2.setText(new File(new URL(ProjectManager.get("paymentImgSecondaryButtonFaceOnClick")).getFile()).getCanonicalPath());
                            tfImageButtonOnClickPath2.setCaretPosition(0);
                    }
                    else
                    {
                            tfImageButtonOnClickPath2.setText("");
                    }
            }
            else
            {
                    tfImageButtonOnClickPath2.setText("");
            }
            if(ProjectManager.get("paymentImgSecondaryButtonFaceInFocus")!=null)
            {
                    if(ProjectManager.get("paymentImgSecondaryButtonFaceInFocus").equalsIgnoreCase("")==false)
                    {
                            tfImageButtonInFocusPath2.setText(new File(new URL(ProjectManager.get("paymentImgSecondaryButtonFaceInFocus")).getFile()).getCanonicalPath());
                            tfImageButtonInFocusPath2.setCaretPosition(0);
                    }
                    else
                    {
                            tfImageButtonInFocusPath2.setText("");
                    }
            }
            else
            {
                    tfImageButtonInFocusPath2.setText("");
            }               
            
 		if(ProjectManager.get("secondaryPaymentMethodType")!=null)
		{
			if(ProjectManager.get("secondaryPaymentMethodType").equalsIgnoreCase("-1")==true)
			{
				cbUseEvaluationButtonActionType.setSelectedIndex(0);
			}
			else if(ProjectManager.get("secondaryPaymentMethodType").equalsIgnoreCase("0")==true)
			{
				cbUseEvaluationButtonActionType.setSelectedIndex(1);
                                if(ProjectManager.get("secondaryPaymentMethod")!=null)
                                {
                                    tfUseEvaluationButtonAction.setText(ProjectManager.get("secondaryPaymentMethod"));
                                }                               
			}
			else if(ProjectManager.get("secondaryPaymentMethodType").equalsIgnoreCase("1")==true)
			{
				cbUseEvaluationButtonActionType.setSelectedIndex(2);
                                tfUseEvaluationButtonAction.setText("Secondary Payment Processing Action");
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
            }
            catch(Exception e)
            {
                    e.printStackTrace();
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
                            if(ProjectManager.get("secondaryPaymentMethod")!=null)
                            {
                                if(ProjectManager.get("secondaryPaymentMethod").equalsIgnoreCase("")==true)
                                {
                                    tfUseEvaluationButtonAction.setText("http://www.evaluateanywhere.com");
                                }
                                else
                                {
                                    tfUseEvaluationButtonAction.setText(ProjectManager.get("secondaryPaymentMethod"));
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
                                new URL(ProjectManager.get("secondaryPaymentMethod"));
                                tfUseEvaluationButtonAction.setText(ProjectManager.get("secondaryPaymentMethod"));
                                
                            }
                            catch(MalformedURLException e)
                            {
                                if(ProjectManager.get("secondaryPaymentMethod")!=null)
                                {
                                    if(ProjectManager.get("secondaryPaymentMethod").equalsIgnoreCase("")==true)
                                    {
                                        tfUseEvaluationButtonAction.setText("http://www.evaluateanywhere.com");
                                    }
                                    else
                                    {
                                        tfUseEvaluationButtonAction.setText(ProjectManager.get("secondaryPaymentMethod"));
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
                     tfUseEvaluationButtonAction.setEnabled(true);
                     tfUseEvaluationButtonAction.setText("Secondary Payment Processing Action");                   
                }
        }
	catch(Exception e)
	{
		e.printStackTrace();
	}                
            if(ProjectManager.get("paymentImgSecondaryButtonBackgroundColor")!=null)
            {
                if(ProjectManager.get("paymentImgSecondaryButtonBackgroundColor").equalsIgnoreCase("")==false)
                {
                    useDefaultButtonBarTextColor.setSelected(false);
                    buttonBarTextColorChooserButton.setVisible(true); 
                }
                else
                {
                    useDefaultButtonBarTextColor.setSelected(true);
                    buttonBarTextColorChooserButton.setVisible(false);                    
                }
            }
            else
            {
                useDefaultButtonBarTextColor.setSelected(true);
                buttonBarTextColorChooserButton.setVisible(false);                
            }
            
            
            if(ProjectManager.get("autoUpdateImgBackgroundColor")!=null)
            {
                if(ProjectManager.get("autoUpdateImgBackgroundColor").equalsIgnoreCase("")==false)
                {
                    useDefaultButtonBarBackgroundColor.setSelected(false);
                    ButtonBarBackgroundColorChooserButton.setVisible(true); 
                }
                else
                {
                    useDefaultButtonBarBackgroundColor.setSelected(true);
                    ButtonBarBackgroundColorChooserButton.setVisible(false);                    
                }
            }
            else
            {
                useDefaultButtonBarBackgroundColor.setSelected(true);
                ButtonBarBackgroundColorChooserButton.setVisible(false);                
            }                 
        }
	catch(Exception ee)
	{
		ee.printStackTrace();
	}
    }    

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        ProjectLookAndFeelImages4 = new javax.swing.JPanel();
        ImageDescriptionLabel = new javax.swing.JPanel();
        LeftUIFiller2 = new javax.swing.JLabel();
        useImageButtonsEnabled = new javax.swing.JCheckBox();
        lOverrideDefaultSplashImageWidth2 = new javax.swing.JLabel();
        spinButtonImageWidth = new javax.swing.JSpinner();
        lFiller56 = new javax.swing.JLabel();
        lOverrideDefaultSplashImageHeight2 = new javax.swing.JLabel();
        spinButtonImageHeight = new javax.swing.JSpinner();
        lFiller61 = new javax.swing.JLabel();
        lFiller30 = new javax.swing.JLabel();
        UIChoicesBottomPanel13 = new javax.swing.JPanel();
        ProjectLocationsCenterPanel2 = new javax.swing.JPanel();
        lFiller25 = new javax.swing.JLabel();
        lBuildLocation2 = new javax.swing.JLabel();
        tfImageButtonPath = new javax.swing.JTextField();
        lFiller32 = new javax.swing.JLabel();
        ImageButtonPathChooseButton = new javax.swing.JButton();
        lFiller31 = new javax.swing.JLabel();
        ImageButtonPathDefaultButton = new javax.swing.JButton();
        lFiller33 = new javax.swing.JLabel();
        lFiller34 = new javax.swing.JLabel();
        ProjectLocationsCenterPanel3 = new javax.swing.JPanel();
        lFiller35 = new javax.swing.JLabel();
        lBuildLocation3 = new javax.swing.JLabel();
        tfImageButtonOnClickPath = new javax.swing.JTextField();
        lFiller36 = new javax.swing.JLabel();
        ImageButtonOnClickPathChooseButton = new javax.swing.JButton();
        lFiller37 = new javax.swing.JLabel();
        ImageButtonOnClickPathDefaultButton = new javax.swing.JButton();
        lFiller38 = new javax.swing.JLabel();
        lFiller39 = new javax.swing.JLabel();
        ProjectLocationsCenterPanel5 = new javax.swing.JPanel();
        lFiller40 = new javax.swing.JLabel();
        lBuildLocation4 = new javax.swing.JLabel();
        tfImageButtonInFocusPath = new javax.swing.JTextField();
        lFiller41 = new javax.swing.JLabel();
        ImageButtonInFocusPathChooseButton = new javax.swing.JButton();
        lFiller42 = new javax.swing.JLabel();
        ImageButtonInFocusPathDefaultButton = new javax.swing.JButton();
        lFiller62 = new javax.swing.JLabel();
        lFiller63 = new javax.swing.JLabel();
        ProjectLookAndFeelImages5 = new javax.swing.JPanel();
        ImageDescriptionLabel1 = new javax.swing.JPanel();
        LeftUIFiller5 = new javax.swing.JLabel();
        lOverrideDefaultSplashImageWidth4 = new javax.swing.JLabel();
        spinButtonImageWidth1 = new javax.swing.JSpinner();
        lFiller57 = new javax.swing.JLabel();
        lOverrideDefaultSplashImageHeight3 = new javax.swing.JLabel();
        spinButtonImageHeight1 = new javax.swing.JSpinner();
        lFiller64 = new javax.swing.JLabel();
        lFiller43 = new javax.swing.JLabel();
        UIChoicesBottomPanel14 = new javax.swing.JPanel();
        ProjectLocationsCenterPanel6 = new javax.swing.JPanel();
        lFiller26 = new javax.swing.JLabel();
        lBuildLocation5 = new javax.swing.JLabel();
        tfImageButtonPath1 = new javax.swing.JTextField();
        lFiller44 = new javax.swing.JLabel();
        ImageButtonPathChooseButton1 = new javax.swing.JButton();
        lFiller46 = new javax.swing.JLabel();
        ImageButtonPathDefaultButton1 = new javax.swing.JButton();
        lFiller49 = new javax.swing.JLabel();
        lFiller50 = new javax.swing.JLabel();
        ProjectLocationsCenterPanel7 = new javax.swing.JPanel();
        lFiller51 = new javax.swing.JLabel();
        lBuildLocation6 = new javax.swing.JLabel();
        tfImageButtonOnClickPath1 = new javax.swing.JTextField();
        lFiller52 = new javax.swing.JLabel();
        ImageButtonOnClickPathChooseButton1 = new javax.swing.JButton();
        lFiller53 = new javax.swing.JLabel();
        ImageButtonOnClickPathDefaultButton1 = new javax.swing.JButton();
        lFiller54 = new javax.swing.JLabel();
        lFiller55 = new javax.swing.JLabel();
        ProjectLocationsCenterPanel8 = new javax.swing.JPanel();
        lFiller58 = new javax.swing.JLabel();
        lBuildLocation7 = new javax.swing.JLabel();
        tfImageButtonInFocusPath1 = new javax.swing.JTextField();
        lFiller59 = new javax.swing.JLabel();
        ImageButtonInFocusPathChooseButton1 = new javax.swing.JButton();
        lFiller60 = new javax.swing.JLabel();
        ImageButtonInFocusPathDefaultButton1 = new javax.swing.JButton();
        lFiller65 = new javax.swing.JLabel();
        lFiller66 = new javax.swing.JLabel();
        ProjectLookAndFeelImages6 = new javax.swing.JPanel();
        ImageDescriptionLabel2 = new javax.swing.JPanel();
        LeftUIFiller7 = new javax.swing.JLabel();
        useDefaultButtonBarTextColor = new javax.swing.JCheckBox();
        buttonBarTextColorChooserButton = new javax.swing.JButton();
        LeftUIFiller4 = new javax.swing.JLabel();
        lOverrideDefaultSplashImageWidth5 = new javax.swing.JLabel();
        spinButtonImageWidth2 = new javax.swing.JSpinner();
        lFiller67 = new javax.swing.JLabel();
        lOverrideDefaultSplashImageHeight4 = new javax.swing.JLabel();
        spinButtonImageHeight2 = new javax.swing.JSpinner();
        lFiller68 = new javax.swing.JLabel();
        cbUseEvaluationButtonEnabled = new javax.swing.JCheckBox();
        lFiller69 = new javax.swing.JLabel();
        UIChoicesBottomPanel15 = new javax.swing.JPanel();
        ProjectLocationsCenterPanel9 = new javax.swing.JPanel();
        lFiller27 = new javax.swing.JLabel();
        lBuildLocation8 = new javax.swing.JLabel();
        tfImageButtonPath2 = new javax.swing.JTextField();
        lFiller70 = new javax.swing.JLabel();
        ImageButtonPathChooseButton2 = new javax.swing.JButton();
        lFiller71 = new javax.swing.JLabel();
        ImageButtonPathDefaultButton2 = new javax.swing.JButton();
        lFiller72 = new javax.swing.JLabel();
        lFiller73 = new javax.swing.JLabel();
        ProjectLocationsCenterPanel10 = new javax.swing.JPanel();
        lFiller74 = new javax.swing.JLabel();
        lBuildLocation9 = new javax.swing.JLabel();
        tfImageButtonOnClickPath2 = new javax.swing.JTextField();
        lFiller75 = new javax.swing.JLabel();
        ImageButtonOnClickPathChooseButton2 = new javax.swing.JButton();
        lFiller76 = new javax.swing.JLabel();
        ImageButtonOnClickPathDefaultButton2 = new javax.swing.JButton();
        lFiller77 = new javax.swing.JLabel();
        lFiller78 = new javax.swing.JLabel();
        ProjectLocationsCenterPanel11 = new javax.swing.JPanel();
        lFiller79 = new javax.swing.JLabel();
        lBuildLocation10 = new javax.swing.JLabel();
        tfImageButtonInFocusPath2 = new javax.swing.JTextField();
        lFiller80 = new javax.swing.JLabel();
        ImageButtonInFocusPathChooseButton2 = new javax.swing.JButton();
        lFiller81 = new javax.swing.JLabel();
        ImageButtonInFocusPathDefaultButton2 = new javax.swing.JButton();
        lFiller82 = new javax.swing.JLabel();
        lFiller83 = new javax.swing.JLabel();
        UIChoicesBottomPanel11 = new javax.swing.JPanel();
        lFiller88 = new javax.swing.JLabel();
        lVerticalButtonBarButtonActionType = new javax.swing.JLabel();
        cbUseEvaluationButtonActionType = new javax.swing.JComboBox();
        lFiller89 = new javax.swing.JLabel();
        lVerticalButtonBarButtonAction = new javax.swing.JLabel();
        tfUseEvaluationButtonAction = new javax.swing.JTextField();
        lFiller90 = new javax.swing.JLabel();
        ProjectLookAndFeelImages3 = new javax.swing.JPanel();
        ProjectLocationsCenterPanel13 = new javax.swing.JPanel();
        ProjectLookAndFeelImages7 = new javax.swing.JPanel();
        ImageDescriptionLabel3 = new javax.swing.JPanel();
        LeftUIFiller8 = new javax.swing.JLabel();
        useDefaultButtonBarBackgroundColor = new javax.swing.JCheckBox();
        ButtonBarBackgroundColorChooserButton = new javax.swing.JButton();
        lFiller45 = new javax.swing.JLabel();
        lFiller87 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rbPaymentPreview = new javax.swing.JRadioButton();
        rbPaymentSuccessPreview = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        PreviewButton = new javax.swing.JButton();
        lFiller47 = new javax.swing.JLabel();
        lFiller48 = new javax.swing.JLabel();
        lFiller91 = new javax.swing.JLabel();
        UIChoicesBottomPanel6 = new javax.swing.JPanel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        setBackground(new java.awt.Color(140, 160, 210));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });

        ProjectLookAndFeelImages4.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages4, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages4.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages4.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Image Buttons Configuration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages4.setMaximumSize(new java.awt.Dimension(32767, 141));
        ProjectLookAndFeelImages4.setMinimumSize(new java.awt.Dimension(10, 141));
        ProjectLookAndFeelImages4.setPreferredSize(new java.awt.Dimension(10, 141));
        ImageDescriptionLabel.setLayout(new javax.swing.BoxLayout(ImageDescriptionLabel, javax.swing.BoxLayout.X_AXIS));

        ImageDescriptionLabel.setBackground(new java.awt.Color(140, 160, 210));
        LeftUIFiller2.setMaximumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller2.setMinimumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller2.setPreferredSize(new java.awt.Dimension(10, 10));
        ImageDescriptionLabel.add(LeftUIFiller2);

        useImageButtonsEnabled.setBackground(new java.awt.Color(140, 160, 210));
        useImageButtonsEnabled.setFont(new java.awt.Font("Arial", 0, 12));
        useImageButtonsEnabled.setSelected(true);
        useImageButtonsEnabled.setText("Image Buttons Enabled");
        useImageButtonsEnabled.setMaximumSize(new java.awt.Dimension(165, 15));
        useImageButtonsEnabled.setMinimumSize(new java.awt.Dimension(165, 15));
        useImageButtonsEnabled.setPreferredSize(new java.awt.Dimension(165, 15));
        useImageButtonsEnabled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useImageButtonsEnabledActionPerformed(evt);
            }
        });

        ImageDescriptionLabel.add(useImageButtonsEnabled);

        lOverrideDefaultSplashImageWidth2.setBackground(new java.awt.Color(140, 160, 210));
        lOverrideDefaultSplashImageWidth2.setFont(new java.awt.Font("Arial", 0, 12));
        lOverrideDefaultSplashImageWidth2.setText("Images pixel width:");
        lOverrideDefaultSplashImageWidth2.setMaximumSize(new java.awt.Dimension(115, 15));
        lOverrideDefaultSplashImageWidth2.setMinimumSize(new java.awt.Dimension(115, 15));
        lOverrideDefaultSplashImageWidth2.setPreferredSize(new java.awt.Dimension(115, 15));
        ImageDescriptionLabel.add(lOverrideDefaultSplashImageWidth2);

        spinButtonImageWidth.setMaximumSize(new java.awt.Dimension(40, 20));
        spinButtonImageWidth.setMinimumSize(new java.awt.Dimension(40, 20));
        spinButtonImageWidth.setPreferredSize(new java.awt.Dimension(40, 20));
        ImageDescriptionLabel.add(spinButtonImageWidth);

        lFiller56.setBackground(new java.awt.Color(140, 160, 210));
        lFiller56.setText("   ");
        lFiller56.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller56.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller56.setPreferredSize(new java.awt.Dimension(10, 16));
        ImageDescriptionLabel.add(lFiller56);

        lOverrideDefaultSplashImageHeight2.setBackground(new java.awt.Color(140, 160, 210));
        lOverrideDefaultSplashImageHeight2.setFont(new java.awt.Font("Arial", 0, 12));
        lOverrideDefaultSplashImageHeight2.setText("height:");
        lOverrideDefaultSplashImageHeight2.setMaximumSize(new java.awt.Dimension(45, 15));
        lOverrideDefaultSplashImageHeight2.setMinimumSize(new java.awt.Dimension(45, 15));
        lOverrideDefaultSplashImageHeight2.setPreferredSize(new java.awt.Dimension(45, 15));
        ImageDescriptionLabel.add(lOverrideDefaultSplashImageHeight2);

        spinButtonImageHeight.setMaximumSize(new java.awt.Dimension(40, 20));
        spinButtonImageHeight.setMinimumSize(new java.awt.Dimension(40, 20));
        spinButtonImageHeight.setPreferredSize(new java.awt.Dimension(40, 20));
        ImageDescriptionLabel.add(spinButtonImageHeight);

        lFiller61.setBackground(new java.awt.Color(140, 160, 210));
        lFiller61.setText("   ");
        lFiller61.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller61.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller61.setPreferredSize(new java.awt.Dimension(10, 16));
        ImageDescriptionLabel.add(lFiller61);

        lFiller30.setBackground(new java.awt.Color(140, 160, 210));
        lFiller30.setText("   ");
        lFiller30.setMaximumSize(new java.awt.Dimension(32767, 16));
        lFiller30.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller30.setPreferredSize(new java.awt.Dimension(10, 16));
        ImageDescriptionLabel.add(lFiller30);

        ProjectLookAndFeelImages4.add(ImageDescriptionLabel);

        UIChoicesBottomPanel13.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel13, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel13.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel13.setMaximumSize(new java.awt.Dimension(32767, 4));
        UIChoicesBottomPanel13.setMinimumSize(new java.awt.Dimension(5, 4));
        UIChoicesBottomPanel13.setPreferredSize(new java.awt.Dimension(200, 4));
        ProjectLookAndFeelImages4.add(UIChoicesBottomPanel13);

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

        lBuildLocation2.setBackground(new java.awt.Color(140, 160, 210));
        lBuildLocation2.setFont(new java.awt.Font("Arial", 0, 12));
        lBuildLocation2.setText("Image Button File:");
        lBuildLocation2.setMaximumSize(new java.awt.Dimension(160, 15));
        lBuildLocation2.setMinimumSize(new java.awt.Dimension(160, 15));
        lBuildLocation2.setPreferredSize(new java.awt.Dimension(160, 15));
        ProjectLocationsCenterPanel2.add(lBuildLocation2);

        tfImageButtonPath.setBackground(new java.awt.Color(204, 204, 204));
        tfImageButtonPath.setFont(new java.awt.Font("Arial", 0, 12));
        tfImageButtonPath.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfImageButtonPath.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfImageButtonPath.setMinimumSize(new java.awt.Dimension(250, 20));
        tfImageButtonPath.setPreferredSize(new java.awt.Dimension(350, 20));
        ProjectLocationsCenterPanel2.add(tfImageButtonPath);

        lFiller32.setBackground(new java.awt.Color(140, 160, 210));
        lFiller32.setText("   ");
        lFiller32.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller32.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller32.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel2.add(lFiller32);

        ImageButtonPathChooseButton.setFont(new java.awt.Font("Arial", 0, 12));
        ImageButtonPathChooseButton.setText("Choose...");
        ImageButtonPathChooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageButtonPathChooseButtonActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel2.add(ImageButtonPathChooseButton);

        lFiller31.setBackground(new java.awt.Color(140, 160, 210));
        lFiller31.setText("   ");
        lFiller31.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller31.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller31.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel2.add(lFiller31);

        ImageButtonPathDefaultButton.setFont(new java.awt.Font("Arial", 0, 12));
        ImageButtonPathDefaultButton.setText("Default");
        ImageButtonPathDefaultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageButtonPathDefaultButtonActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel2.add(ImageButtonPathDefaultButton);

        lFiller33.setBackground(new java.awt.Color(140, 160, 210));
        lFiller33.setText("   ");
        lFiller33.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller33.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller33.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel2.add(lFiller33);

        lFiller34.setBackground(new java.awt.Color(140, 160, 210));
        lFiller34.setText("   ");
        lFiller34.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller34.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller34.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel2.add(lFiller34);

        ProjectLookAndFeelImages4.add(ProjectLocationsCenterPanel2);

        ProjectLocationsCenterPanel3.setLayout(new javax.swing.BoxLayout(ProjectLocationsCenterPanel3, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsCenterPanel3.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsCenterPanel3.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectLocationsCenterPanel3.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectLocationsCenterPanel3.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller35.setBackground(new java.awt.Color(140, 160, 210));
        lFiller35.setText("   ");
        lFiller35.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller35.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller35.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel3.add(lFiller35);

        lBuildLocation3.setBackground(new java.awt.Color(140, 160, 210));
        lBuildLocation3.setFont(new java.awt.Font("Arial", 0, 12));
        lBuildLocation3.setText("Image Button On Click File:");
        lBuildLocation3.setMaximumSize(new java.awt.Dimension(160, 15));
        lBuildLocation3.setMinimumSize(new java.awt.Dimension(160, 15));
        lBuildLocation3.setPreferredSize(new java.awt.Dimension(160, 15));
        ProjectLocationsCenterPanel3.add(lBuildLocation3);

        tfImageButtonOnClickPath.setBackground(new java.awt.Color(204, 204, 204));
        tfImageButtonOnClickPath.setFont(new java.awt.Font("Arial", 0, 12));
        tfImageButtonOnClickPath.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfImageButtonOnClickPath.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfImageButtonOnClickPath.setMinimumSize(new java.awt.Dimension(250, 20));
        tfImageButtonOnClickPath.setPreferredSize(new java.awt.Dimension(350, 20));
        ProjectLocationsCenterPanel3.add(tfImageButtonOnClickPath);

        lFiller36.setBackground(new java.awt.Color(140, 160, 210));
        lFiller36.setText("   ");
        lFiller36.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller36.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller36.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel3.add(lFiller36);

        ImageButtonOnClickPathChooseButton.setFont(new java.awt.Font("Arial", 0, 12));
        ImageButtonOnClickPathChooseButton.setText("Choose...");
        ImageButtonOnClickPathChooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageButtonOnClickPathChooseButtonActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel3.add(ImageButtonOnClickPathChooseButton);

        lFiller37.setBackground(new java.awt.Color(140, 160, 210));
        lFiller37.setText("   ");
        lFiller37.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller37.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller37.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel3.add(lFiller37);

        ImageButtonOnClickPathDefaultButton.setFont(new java.awt.Font("Arial", 0, 12));
        ImageButtonOnClickPathDefaultButton.setText("Default");
        ImageButtonOnClickPathDefaultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageButtonOnClickPathDefaultButtonActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel3.add(ImageButtonOnClickPathDefaultButton);

        lFiller38.setBackground(new java.awt.Color(140, 160, 210));
        lFiller38.setText("   ");
        lFiller38.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller38.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller38.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel3.add(lFiller38);

        lFiller39.setBackground(new java.awt.Color(140, 160, 210));
        lFiller39.setText("   ");
        lFiller39.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller39.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller39.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel3.add(lFiller39);

        ProjectLookAndFeelImages4.add(ProjectLocationsCenterPanel3);

        ProjectLocationsCenterPanel5.setLayout(new javax.swing.BoxLayout(ProjectLocationsCenterPanel5, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsCenterPanel5.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsCenterPanel5.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectLocationsCenterPanel5.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectLocationsCenterPanel5.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller40.setBackground(new java.awt.Color(140, 160, 210));
        lFiller40.setText("   ");
        lFiller40.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller40.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller40.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel5.add(lFiller40);

        lBuildLocation4.setBackground(new java.awt.Color(140, 160, 210));
        lBuildLocation4.setFont(new java.awt.Font("Arial", 0, 12));
        lBuildLocation4.setText("Image Button In Focus File:");
        lBuildLocation4.setMaximumSize(new java.awt.Dimension(160, 15));
        lBuildLocation4.setMinimumSize(new java.awt.Dimension(160, 15));
        lBuildLocation4.setPreferredSize(new java.awt.Dimension(160, 15));
        ProjectLocationsCenterPanel5.add(lBuildLocation4);

        tfImageButtonInFocusPath.setBackground(new java.awt.Color(204, 204, 204));
        tfImageButtonInFocusPath.setFont(new java.awt.Font("Arial", 0, 12));
        tfImageButtonInFocusPath.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfImageButtonInFocusPath.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfImageButtonInFocusPath.setMinimumSize(new java.awt.Dimension(250, 20));
        tfImageButtonInFocusPath.setPreferredSize(new java.awt.Dimension(450, 20));
        tfImageButtonInFocusPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfImageButtonInFocusPathActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel5.add(tfImageButtonInFocusPath);

        lFiller41.setBackground(new java.awt.Color(140, 160, 210));
        lFiller41.setText("   ");
        lFiller41.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller41.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller41.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel5.add(lFiller41);

        ImageButtonInFocusPathChooseButton.setFont(new java.awt.Font("Arial", 0, 12));
        ImageButtonInFocusPathChooseButton.setText("Choose...");
        ImageButtonInFocusPathChooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageButtonInFocusPathChooseButtonActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel5.add(ImageButtonInFocusPathChooseButton);

        lFiller42.setBackground(new java.awt.Color(140, 160, 210));
        lFiller42.setText("   ");
        lFiller42.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller42.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller42.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel5.add(lFiller42);

        ImageButtonInFocusPathDefaultButton.setFont(new java.awt.Font("Arial", 0, 12));
        ImageButtonInFocusPathDefaultButton.setText("Default");
        ImageButtonInFocusPathDefaultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageButtonInFocusPathDefaultButtonActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel5.add(ImageButtonInFocusPathDefaultButton);

        lFiller62.setBackground(new java.awt.Color(140, 160, 210));
        lFiller62.setText("   ");
        lFiller62.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller62.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller62.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel5.add(lFiller62);

        lFiller63.setBackground(new java.awt.Color(140, 160, 210));
        lFiller63.setText("   ");
        lFiller63.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller63.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller63.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel5.add(lFiller63);

        ProjectLookAndFeelImages4.add(ProjectLocationsCenterPanel5);

        add(ProjectLookAndFeelImages4);

        ProjectLookAndFeelImages5.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages5, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages5.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages5.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Payment Processing Continue Image Button Configuration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages5.setMaximumSize(new java.awt.Dimension(32767, 143));
        ProjectLookAndFeelImages5.setMinimumSize(new java.awt.Dimension(10, 143));
        ProjectLookAndFeelImages5.setPreferredSize(new java.awt.Dimension(10, 143));
        ProjectLookAndFeelImages5.setRequestFocusEnabled(false);
        ImageDescriptionLabel1.setLayout(new javax.swing.BoxLayout(ImageDescriptionLabel1, javax.swing.BoxLayout.X_AXIS));

        ImageDescriptionLabel1.setBackground(new java.awt.Color(140, 160, 210));
        LeftUIFiller5.setMaximumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller5.setMinimumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller5.setPreferredSize(new java.awt.Dimension(10, 10));
        ImageDescriptionLabel1.add(LeftUIFiller5);

        lOverrideDefaultSplashImageWidth4.setBackground(new java.awt.Color(140, 160, 210));
        lOverrideDefaultSplashImageWidth4.setFont(new java.awt.Font("Arial", 0, 12));
        lOverrideDefaultSplashImageWidth4.setText("Images pixel width:");
        lOverrideDefaultSplashImageWidth4.setMaximumSize(new java.awt.Dimension(115, 15));
        lOverrideDefaultSplashImageWidth4.setMinimumSize(new java.awt.Dimension(115, 15));
        lOverrideDefaultSplashImageWidth4.setPreferredSize(new java.awt.Dimension(115, 15));
        ImageDescriptionLabel1.add(lOverrideDefaultSplashImageWidth4);

        spinButtonImageWidth1.setMaximumSize(new java.awt.Dimension(40, 20));
        spinButtonImageWidth1.setMinimumSize(new java.awt.Dimension(40, 20));
        spinButtonImageWidth1.setPreferredSize(new java.awt.Dimension(40, 20));
        ImageDescriptionLabel1.add(spinButtonImageWidth1);

        lFiller57.setBackground(new java.awt.Color(140, 160, 210));
        lFiller57.setText("   ");
        lFiller57.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller57.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller57.setPreferredSize(new java.awt.Dimension(10, 16));
        ImageDescriptionLabel1.add(lFiller57);

        lOverrideDefaultSplashImageHeight3.setBackground(new java.awt.Color(140, 160, 210));
        lOverrideDefaultSplashImageHeight3.setFont(new java.awt.Font("Arial", 0, 12));
        lOverrideDefaultSplashImageHeight3.setText("height:");
        lOverrideDefaultSplashImageHeight3.setMaximumSize(new java.awt.Dimension(45, 15));
        lOverrideDefaultSplashImageHeight3.setMinimumSize(new java.awt.Dimension(45, 15));
        lOverrideDefaultSplashImageHeight3.setPreferredSize(new java.awt.Dimension(45, 15));
        ImageDescriptionLabel1.add(lOverrideDefaultSplashImageHeight3);

        spinButtonImageHeight1.setMaximumSize(new java.awt.Dimension(40, 20));
        spinButtonImageHeight1.setMinimumSize(new java.awt.Dimension(40, 20));
        spinButtonImageHeight1.setPreferredSize(new java.awt.Dimension(40, 20));
        ImageDescriptionLabel1.add(spinButtonImageHeight1);

        lFiller64.setBackground(new java.awt.Color(140, 160, 210));
        lFiller64.setText("   ");
        lFiller64.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller64.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller64.setPreferredSize(new java.awt.Dimension(10, 16));
        ImageDescriptionLabel1.add(lFiller64);

        lFiller43.setBackground(new java.awt.Color(140, 160, 210));
        lFiller43.setText("   ");
        lFiller43.setMaximumSize(new java.awt.Dimension(32767, 16));
        lFiller43.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller43.setPreferredSize(new java.awt.Dimension(10, 16));
        ImageDescriptionLabel1.add(lFiller43);

        ProjectLookAndFeelImages5.add(ImageDescriptionLabel1);

        UIChoicesBottomPanel14.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel14, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel14.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel14.setMaximumSize(new java.awt.Dimension(32767, 4));
        UIChoicesBottomPanel14.setMinimumSize(new java.awt.Dimension(5, 4));
        UIChoicesBottomPanel14.setPreferredSize(new java.awt.Dimension(200, 4));
        ProjectLookAndFeelImages5.add(UIChoicesBottomPanel14);

        ProjectLocationsCenterPanel6.setLayout(new javax.swing.BoxLayout(ProjectLocationsCenterPanel6, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsCenterPanel6.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsCenterPanel6.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectLocationsCenterPanel6.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectLocationsCenterPanel6.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller26.setBackground(new java.awt.Color(140, 160, 210));
        lFiller26.setText("   ");
        lFiller26.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller26.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller26.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel6.add(lFiller26);

        lBuildLocation5.setBackground(new java.awt.Color(140, 160, 210));
        lBuildLocation5.setFont(new java.awt.Font("Arial", 0, 12));
        lBuildLocation5.setText("Image Button File:");
        lBuildLocation5.setMaximumSize(new java.awt.Dimension(160, 15));
        lBuildLocation5.setMinimumSize(new java.awt.Dimension(160, 15));
        lBuildLocation5.setPreferredSize(new java.awt.Dimension(160, 15));
        ProjectLocationsCenterPanel6.add(lBuildLocation5);

        tfImageButtonPath1.setBackground(new java.awt.Color(204, 204, 204));
        tfImageButtonPath1.setFont(new java.awt.Font("Arial", 0, 12));
        tfImageButtonPath1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfImageButtonPath1.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfImageButtonPath1.setMinimumSize(new java.awt.Dimension(250, 20));
        tfImageButtonPath1.setPreferredSize(new java.awt.Dimension(350, 20));
        ProjectLocationsCenterPanel6.add(tfImageButtonPath1);

        lFiller44.setBackground(new java.awt.Color(140, 160, 210));
        lFiller44.setText("   ");
        lFiller44.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller44.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller44.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel6.add(lFiller44);

        ImageButtonPathChooseButton1.setFont(new java.awt.Font("Arial", 0, 12));
        ImageButtonPathChooseButton1.setText("Choose...");
        ImageButtonPathChooseButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageButtonPathChooseButton1ActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel6.add(ImageButtonPathChooseButton1);

        lFiller46.setBackground(new java.awt.Color(140, 160, 210));
        lFiller46.setText("   ");
        lFiller46.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller46.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller46.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel6.add(lFiller46);

        ImageButtonPathDefaultButton1.setFont(new java.awt.Font("Arial", 0, 12));
        ImageButtonPathDefaultButton1.setText("Default");
        ImageButtonPathDefaultButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageButtonPathDefaultButton1ActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel6.add(ImageButtonPathDefaultButton1);

        lFiller49.setBackground(new java.awt.Color(140, 160, 210));
        lFiller49.setText("   ");
        lFiller49.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller49.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller49.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel6.add(lFiller49);

        lFiller50.setBackground(new java.awt.Color(140, 160, 210));
        lFiller50.setText("   ");
        lFiller50.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller50.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller50.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel6.add(lFiller50);

        ProjectLookAndFeelImages5.add(ProjectLocationsCenterPanel6);

        ProjectLocationsCenterPanel7.setLayout(new javax.swing.BoxLayout(ProjectLocationsCenterPanel7, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsCenterPanel7.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsCenterPanel7.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectLocationsCenterPanel7.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectLocationsCenterPanel7.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller51.setBackground(new java.awt.Color(140, 160, 210));
        lFiller51.setText("   ");
        lFiller51.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller51.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller51.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel7.add(lFiller51);

        lBuildLocation6.setBackground(new java.awt.Color(140, 160, 210));
        lBuildLocation6.setFont(new java.awt.Font("Arial", 0, 12));
        lBuildLocation6.setText("Image Button On Click File:");
        lBuildLocation6.setMaximumSize(new java.awt.Dimension(160, 15));
        lBuildLocation6.setMinimumSize(new java.awt.Dimension(160, 15));
        lBuildLocation6.setPreferredSize(new java.awt.Dimension(160, 15));
        ProjectLocationsCenterPanel7.add(lBuildLocation6);

        tfImageButtonOnClickPath1.setBackground(new java.awt.Color(204, 204, 204));
        tfImageButtonOnClickPath1.setFont(new java.awt.Font("Arial", 0, 12));
        tfImageButtonOnClickPath1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfImageButtonOnClickPath1.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfImageButtonOnClickPath1.setMinimumSize(new java.awt.Dimension(250, 20));
        tfImageButtonOnClickPath1.setPreferredSize(new java.awt.Dimension(350, 20));
        ProjectLocationsCenterPanel7.add(tfImageButtonOnClickPath1);

        lFiller52.setBackground(new java.awt.Color(140, 160, 210));
        lFiller52.setText("   ");
        lFiller52.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller52.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller52.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel7.add(lFiller52);

        ImageButtonOnClickPathChooseButton1.setFont(new java.awt.Font("Arial", 0, 12));
        ImageButtonOnClickPathChooseButton1.setText("Choose...");
        ImageButtonOnClickPathChooseButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageButtonOnClickPathChooseButton1ActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel7.add(ImageButtonOnClickPathChooseButton1);

        lFiller53.setBackground(new java.awt.Color(140, 160, 210));
        lFiller53.setText("   ");
        lFiller53.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller53.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller53.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel7.add(lFiller53);

        ImageButtonOnClickPathDefaultButton1.setFont(new java.awt.Font("Arial", 0, 12));
        ImageButtonOnClickPathDefaultButton1.setText("Default");
        ImageButtonOnClickPathDefaultButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageButtonOnClickPathDefaultButton1ActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel7.add(ImageButtonOnClickPathDefaultButton1);

        lFiller54.setBackground(new java.awt.Color(140, 160, 210));
        lFiller54.setText("   ");
        lFiller54.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller54.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller54.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel7.add(lFiller54);

        lFiller55.setBackground(new java.awt.Color(140, 160, 210));
        lFiller55.setText("   ");
        lFiller55.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller55.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller55.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel7.add(lFiller55);

        ProjectLookAndFeelImages5.add(ProjectLocationsCenterPanel7);

        ProjectLocationsCenterPanel8.setLayout(new javax.swing.BoxLayout(ProjectLocationsCenterPanel8, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsCenterPanel8.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsCenterPanel8.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectLocationsCenterPanel8.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectLocationsCenterPanel8.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller58.setBackground(new java.awt.Color(140, 160, 210));
        lFiller58.setText("   ");
        lFiller58.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller58.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller58.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel8.add(lFiller58);

        lBuildLocation7.setBackground(new java.awt.Color(140, 160, 210));
        lBuildLocation7.setFont(new java.awt.Font("Arial", 0, 12));
        lBuildLocation7.setText("Image Button In Focus File:");
        lBuildLocation7.setMaximumSize(new java.awt.Dimension(160, 15));
        lBuildLocation7.setMinimumSize(new java.awt.Dimension(160, 15));
        lBuildLocation7.setPreferredSize(new java.awt.Dimension(160, 15));
        ProjectLocationsCenterPanel8.add(lBuildLocation7);

        tfImageButtonInFocusPath1.setBackground(new java.awt.Color(204, 204, 204));
        tfImageButtonInFocusPath1.setFont(new java.awt.Font("Arial", 0, 12));
        tfImageButtonInFocusPath1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfImageButtonInFocusPath1.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfImageButtonInFocusPath1.setMinimumSize(new java.awt.Dimension(250, 20));
        tfImageButtonInFocusPath1.setPreferredSize(new java.awt.Dimension(450, 20));
        ProjectLocationsCenterPanel8.add(tfImageButtonInFocusPath1);

        lFiller59.setBackground(new java.awt.Color(140, 160, 210));
        lFiller59.setText("   ");
        lFiller59.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller59.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller59.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel8.add(lFiller59);

        ImageButtonInFocusPathChooseButton1.setFont(new java.awt.Font("Arial", 0, 12));
        ImageButtonInFocusPathChooseButton1.setText("Choose...");
        ImageButtonInFocusPathChooseButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageButtonInFocusPathChooseButton1ActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel8.add(ImageButtonInFocusPathChooseButton1);

        lFiller60.setBackground(new java.awt.Color(140, 160, 210));
        lFiller60.setText("   ");
        lFiller60.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller60.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller60.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel8.add(lFiller60);

        ImageButtonInFocusPathDefaultButton1.setFont(new java.awt.Font("Arial", 0, 12));
        ImageButtonInFocusPathDefaultButton1.setText("Default");
        ImageButtonInFocusPathDefaultButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageButtonInFocusPathDefaultButton1ActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel8.add(ImageButtonInFocusPathDefaultButton1);

        lFiller65.setBackground(new java.awt.Color(140, 160, 210));
        lFiller65.setText("   ");
        lFiller65.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller65.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller65.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel8.add(lFiller65);

        lFiller66.setBackground(new java.awt.Color(140, 160, 210));
        lFiller66.setText("   ");
        lFiller66.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller66.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller66.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel8.add(lFiller66);

        ProjectLookAndFeelImages5.add(ProjectLocationsCenterPanel8);

        add(ProjectLookAndFeelImages5);

        ProjectLookAndFeelImages6.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages6, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages6.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages6.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Secondary Payment Processing Option Image Button (Optional - only on enabled)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages6.setMaximumSize(new java.awt.Dimension(32767, 173));
        ProjectLookAndFeelImages6.setMinimumSize(new java.awt.Dimension(10, 173));
        ProjectLookAndFeelImages6.setPreferredSize(new java.awt.Dimension(10, 173));
        ImageDescriptionLabel2.setLayout(new javax.swing.BoxLayout(ImageDescriptionLabel2, javax.swing.BoxLayout.X_AXIS));

        ImageDescriptionLabel2.setBackground(new java.awt.Color(140, 160, 210));
        LeftUIFiller7.setMaximumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller7.setMinimumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller7.setPreferredSize(new java.awt.Dimension(10, 10));
        ImageDescriptionLabel2.add(LeftUIFiller7);

        useDefaultButtonBarTextColor.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultButtonBarTextColor.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultButtonBarTextColor.setSelected(true);
        useDefaultButtonBarTextColor.setText("Use default text background color");
        useDefaultButtonBarTextColor.setMaximumSize(new java.awt.Dimension(215, 23));
        useDefaultButtonBarTextColor.setMinimumSize(new java.awt.Dimension(215, 23));
        useDefaultButtonBarTextColor.setPreferredSize(new java.awt.Dimension(215, 23));
        useDefaultButtonBarTextColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultButtonBarTextColorActionPerformed(evt);
            }
        });

        ImageDescriptionLabel2.add(useDefaultButtonBarTextColor);

        buttonBarTextColorChooserButton.setBackground(new java.awt.Color(140, 160, 210));
        buttonBarTextColorChooserButton.setMaximumSize(new java.awt.Dimension(35, 20));
        buttonBarTextColorChooserButton.setMinimumSize(new java.awt.Dimension(35, 20));
        buttonBarTextColorChooserButton.setPreferredSize(new java.awt.Dimension(35, 20));
        buttonBarTextColorChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBarTextColorChooserButtonActionPerformed(evt);
            }
        });

        ImageDescriptionLabel2.add(buttonBarTextColorChooserButton);

        LeftUIFiller4.setMaximumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller4.setMinimumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller4.setPreferredSize(new java.awt.Dimension(10, 10));
        ImageDescriptionLabel2.add(LeftUIFiller4);

        lOverrideDefaultSplashImageWidth5.setBackground(new java.awt.Color(140, 160, 210));
        lOverrideDefaultSplashImageWidth5.setFont(new java.awt.Font("Arial", 0, 12));
        lOverrideDefaultSplashImageWidth5.setText("Images pixel width:");
        lOverrideDefaultSplashImageWidth5.setMaximumSize(new java.awt.Dimension(115, 15));
        lOverrideDefaultSplashImageWidth5.setMinimumSize(new java.awt.Dimension(115, 15));
        lOverrideDefaultSplashImageWidth5.setPreferredSize(new java.awt.Dimension(115, 15));
        ImageDescriptionLabel2.add(lOverrideDefaultSplashImageWidth5);

        spinButtonImageWidth2.setMaximumSize(new java.awt.Dimension(40, 20));
        spinButtonImageWidth2.setMinimumSize(new java.awt.Dimension(40, 20));
        spinButtonImageWidth2.setPreferredSize(new java.awt.Dimension(40, 20));
        ImageDescriptionLabel2.add(spinButtonImageWidth2);

        lFiller67.setBackground(new java.awt.Color(140, 160, 210));
        lFiller67.setText("   ");
        lFiller67.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller67.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller67.setPreferredSize(new java.awt.Dimension(10, 16));
        ImageDescriptionLabel2.add(lFiller67);

        lOverrideDefaultSplashImageHeight4.setBackground(new java.awt.Color(140, 160, 210));
        lOverrideDefaultSplashImageHeight4.setFont(new java.awt.Font("Arial", 0, 12));
        lOverrideDefaultSplashImageHeight4.setText("height:");
        lOverrideDefaultSplashImageHeight4.setMaximumSize(new java.awt.Dimension(45, 15));
        lOverrideDefaultSplashImageHeight4.setMinimumSize(new java.awt.Dimension(45, 15));
        lOverrideDefaultSplashImageHeight4.setPreferredSize(new java.awt.Dimension(45, 15));
        ImageDescriptionLabel2.add(lOverrideDefaultSplashImageHeight4);

        spinButtonImageHeight2.setMaximumSize(new java.awt.Dimension(40, 20));
        spinButtonImageHeight2.setMinimumSize(new java.awt.Dimension(40, 20));
        spinButtonImageHeight2.setPreferredSize(new java.awt.Dimension(40, 20));
        ImageDescriptionLabel2.add(spinButtonImageHeight2);

        lFiller68.setBackground(new java.awt.Color(140, 160, 210));
        lFiller68.setText("   ");
        lFiller68.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller68.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller68.setPreferredSize(new java.awt.Dimension(10, 16));
        ImageDescriptionLabel2.add(lFiller68);

        cbUseEvaluationButtonEnabled.setBackground(new java.awt.Color(140, 160, 210));
        cbUseEvaluationButtonEnabled.setFont(new java.awt.Font("Arial", 0, 12));
        cbUseEvaluationButtonEnabled.setSelected(true);
        cbUseEvaluationButtonEnabled.setText("Enabled");
        cbUseEvaluationButtonEnabled.setMaximumSize(new java.awt.Dimension(75, 23));
        cbUseEvaluationButtonEnabled.setMinimumSize(new java.awt.Dimension(75, 23));
        cbUseEvaluationButtonEnabled.setPreferredSize(new java.awt.Dimension(165, 23));
        cbUseEvaluationButtonEnabled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUseEvaluationButtonEnabledActionPerformed(evt);
            }
        });

        ImageDescriptionLabel2.add(cbUseEvaluationButtonEnabled);

        lFiller69.setBackground(new java.awt.Color(140, 160, 210));
        lFiller69.setText("   ");
        lFiller69.setMaximumSize(new java.awt.Dimension(32767, 16));
        lFiller69.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller69.setPreferredSize(new java.awt.Dimension(10, 16));
        ImageDescriptionLabel2.add(lFiller69);

        ProjectLookAndFeelImages6.add(ImageDescriptionLabel2);

        UIChoicesBottomPanel15.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel15, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel15.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel15.setMaximumSize(new java.awt.Dimension(32767, 4));
        UIChoicesBottomPanel15.setMinimumSize(new java.awt.Dimension(5, 4));
        UIChoicesBottomPanel15.setPreferredSize(new java.awt.Dimension(200, 4));
        ProjectLookAndFeelImages6.add(UIChoicesBottomPanel15);

        ProjectLocationsCenterPanel9.setLayout(new javax.swing.BoxLayout(ProjectLocationsCenterPanel9, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsCenterPanel9.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsCenterPanel9.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectLocationsCenterPanel9.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectLocationsCenterPanel9.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller27.setBackground(new java.awt.Color(140, 160, 210));
        lFiller27.setText("   ");
        lFiller27.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller27.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller27.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel9.add(lFiller27);

        lBuildLocation8.setBackground(new java.awt.Color(140, 160, 210));
        lBuildLocation8.setFont(new java.awt.Font("Arial", 0, 12));
        lBuildLocation8.setText("Image Button File:");
        lBuildLocation8.setMaximumSize(new java.awt.Dimension(160, 15));
        lBuildLocation8.setMinimumSize(new java.awt.Dimension(160, 15));
        lBuildLocation8.setPreferredSize(new java.awt.Dimension(160, 15));
        ProjectLocationsCenterPanel9.add(lBuildLocation8);

        tfImageButtonPath2.setBackground(new java.awt.Color(204, 204, 204));
        tfImageButtonPath2.setFont(new java.awt.Font("Arial", 0, 12));
        tfImageButtonPath2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfImageButtonPath2.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfImageButtonPath2.setMinimumSize(new java.awt.Dimension(250, 20));
        tfImageButtonPath2.setPreferredSize(new java.awt.Dimension(350, 20));
        ProjectLocationsCenterPanel9.add(tfImageButtonPath2);

        lFiller70.setBackground(new java.awt.Color(140, 160, 210));
        lFiller70.setText("   ");
        lFiller70.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller70.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller70.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel9.add(lFiller70);

        ImageButtonPathChooseButton2.setFont(new java.awt.Font("Arial", 0, 12));
        ImageButtonPathChooseButton2.setText("Choose...");
        ImageButtonPathChooseButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageButtonPathChooseButton2ActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel9.add(ImageButtonPathChooseButton2);

        lFiller71.setBackground(new java.awt.Color(140, 160, 210));
        lFiller71.setText("   ");
        lFiller71.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller71.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller71.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel9.add(lFiller71);

        ImageButtonPathDefaultButton2.setFont(new java.awt.Font("Arial", 0, 12));
        ImageButtonPathDefaultButton2.setText("Default");
        ImageButtonPathDefaultButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageButtonPathDefaultButton2ActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel9.add(ImageButtonPathDefaultButton2);

        lFiller72.setBackground(new java.awt.Color(140, 160, 210));
        lFiller72.setText("   ");
        lFiller72.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller72.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller72.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel9.add(lFiller72);

        lFiller73.setBackground(new java.awt.Color(140, 160, 210));
        lFiller73.setText("   ");
        lFiller73.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller73.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller73.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel9.add(lFiller73);

        ProjectLookAndFeelImages6.add(ProjectLocationsCenterPanel9);

        ProjectLocationsCenterPanel10.setLayout(new javax.swing.BoxLayout(ProjectLocationsCenterPanel10, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsCenterPanel10.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsCenterPanel10.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectLocationsCenterPanel10.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectLocationsCenterPanel10.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller74.setBackground(new java.awt.Color(140, 160, 210));
        lFiller74.setText("   ");
        lFiller74.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller74.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller74.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel10.add(lFiller74);

        lBuildLocation9.setBackground(new java.awt.Color(140, 160, 210));
        lBuildLocation9.setFont(new java.awt.Font("Arial", 0, 12));
        lBuildLocation9.setText("Image Button On Click File:");
        lBuildLocation9.setMaximumSize(new java.awt.Dimension(160, 15));
        lBuildLocation9.setMinimumSize(new java.awt.Dimension(160, 15));
        lBuildLocation9.setPreferredSize(new java.awt.Dimension(160, 15));
        ProjectLocationsCenterPanel10.add(lBuildLocation9);

        tfImageButtonOnClickPath2.setBackground(new java.awt.Color(204, 204, 204));
        tfImageButtonOnClickPath2.setFont(new java.awt.Font("Arial", 0, 12));
        tfImageButtonOnClickPath2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfImageButtonOnClickPath2.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfImageButtonOnClickPath2.setMinimumSize(new java.awt.Dimension(250, 20));
        tfImageButtonOnClickPath2.setPreferredSize(new java.awt.Dimension(350, 20));
        ProjectLocationsCenterPanel10.add(tfImageButtonOnClickPath2);

        lFiller75.setBackground(new java.awt.Color(140, 160, 210));
        lFiller75.setText("   ");
        lFiller75.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller75.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller75.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel10.add(lFiller75);

        ImageButtonOnClickPathChooseButton2.setFont(new java.awt.Font("Arial", 0, 12));
        ImageButtonOnClickPathChooseButton2.setText("Choose...");
        ImageButtonOnClickPathChooseButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageButtonOnClickPathChooseButton2ActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel10.add(ImageButtonOnClickPathChooseButton2);

        lFiller76.setBackground(new java.awt.Color(140, 160, 210));
        lFiller76.setText("   ");
        lFiller76.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller76.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller76.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel10.add(lFiller76);

        ImageButtonOnClickPathDefaultButton2.setFont(new java.awt.Font("Arial", 0, 12));
        ImageButtonOnClickPathDefaultButton2.setText("Default");
        ImageButtonOnClickPathDefaultButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageButtonOnClickPathDefaultButton2ActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel10.add(ImageButtonOnClickPathDefaultButton2);

        lFiller77.setBackground(new java.awt.Color(140, 160, 210));
        lFiller77.setText("   ");
        lFiller77.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller77.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller77.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel10.add(lFiller77);

        lFiller78.setBackground(new java.awt.Color(140, 160, 210));
        lFiller78.setText("   ");
        lFiller78.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller78.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller78.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel10.add(lFiller78);

        ProjectLookAndFeelImages6.add(ProjectLocationsCenterPanel10);

        ProjectLocationsCenterPanel11.setLayout(new javax.swing.BoxLayout(ProjectLocationsCenterPanel11, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsCenterPanel11.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsCenterPanel11.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectLocationsCenterPanel11.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectLocationsCenterPanel11.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller79.setBackground(new java.awt.Color(140, 160, 210));
        lFiller79.setText("   ");
        lFiller79.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller79.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller79.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel11.add(lFiller79);

        lBuildLocation10.setBackground(new java.awt.Color(140, 160, 210));
        lBuildLocation10.setFont(new java.awt.Font("Arial", 0, 12));
        lBuildLocation10.setText("Image Button In Focus File:");
        lBuildLocation10.setMaximumSize(new java.awt.Dimension(160, 15));
        lBuildLocation10.setMinimumSize(new java.awt.Dimension(160, 15));
        lBuildLocation10.setPreferredSize(new java.awt.Dimension(160, 15));
        ProjectLocationsCenterPanel11.add(lBuildLocation10);

        tfImageButtonInFocusPath2.setBackground(new java.awt.Color(204, 204, 204));
        tfImageButtonInFocusPath2.setFont(new java.awt.Font("Arial", 0, 12));
        tfImageButtonInFocusPath2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfImageButtonInFocusPath2.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfImageButtonInFocusPath2.setMinimumSize(new java.awt.Dimension(250, 20));
        tfImageButtonInFocusPath2.setPreferredSize(new java.awt.Dimension(450, 20));
        ProjectLocationsCenterPanel11.add(tfImageButtonInFocusPath2);

        lFiller80.setBackground(new java.awt.Color(140, 160, 210));
        lFiller80.setText("   ");
        lFiller80.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller80.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller80.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel11.add(lFiller80);

        ImageButtonInFocusPathChooseButton2.setFont(new java.awt.Font("Arial", 0, 12));
        ImageButtonInFocusPathChooseButton2.setText("Choose...");
        ImageButtonInFocusPathChooseButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageButtonInFocusPathChooseButton2ActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel11.add(ImageButtonInFocusPathChooseButton2);

        lFiller81.setBackground(new java.awt.Color(140, 160, 210));
        lFiller81.setText("   ");
        lFiller81.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller81.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller81.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel11.add(lFiller81);

        ImageButtonInFocusPathDefaultButton2.setFont(new java.awt.Font("Arial", 0, 12));
        ImageButtonInFocusPathDefaultButton2.setText("Default");
        ImageButtonInFocusPathDefaultButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageButtonInFocusPathDefaultButton2ActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel11.add(ImageButtonInFocusPathDefaultButton2);

        lFiller82.setBackground(new java.awt.Color(140, 160, 210));
        lFiller82.setText("   ");
        lFiller82.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller82.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller82.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel11.add(lFiller82);

        lFiller83.setBackground(new java.awt.Color(140, 160, 210));
        lFiller83.setText("   ");
        lFiller83.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller83.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller83.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel11.add(lFiller83);

        ProjectLookAndFeelImages6.add(ProjectLocationsCenterPanel11);

        UIChoicesBottomPanel11.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel11, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel11.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel11.setMaximumSize(new java.awt.Dimension(32767, 25));
        UIChoicesBottomPanel11.setMinimumSize(new java.awt.Dimension(5, 25));
        UIChoicesBottomPanel11.setPreferredSize(new java.awt.Dimension(200, 25));
        lFiller88.setBackground(new java.awt.Color(140, 160, 210));
        lFiller88.setText("   ");
        lFiller88.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller88.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller88.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel11.add(lFiller88);

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

        lFiller89.setBackground(new java.awt.Color(140, 160, 210));
        lFiller89.setText("   ");
        lFiller89.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller89.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller89.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel11.add(lFiller89);

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

        lFiller90.setBackground(new java.awt.Color(140, 160, 210));
        lFiller90.setText("   ");
        lFiller90.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller90.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller90.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel11.add(lFiller90);

        ProjectLookAndFeelImages6.add(UIChoicesBottomPanel11);

        add(ProjectLookAndFeelImages6);

        ProjectLookAndFeelImages3.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages3, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages3.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages3.setMaximumSize(new java.awt.Dimension(32767, 90));
        ProjectLookAndFeelImages3.setMinimumSize(new java.awt.Dimension(10, 90));
        ProjectLookAndFeelImages3.setPreferredSize(new java.awt.Dimension(10, 90));
        ProjectLocationsCenterPanel13.setLayout(new javax.swing.BoxLayout(ProjectLocationsCenterPanel13, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsCenterPanel13.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsCenterPanel13.setMaximumSize(new java.awt.Dimension(2147483647, 56));
        ProjectLocationsCenterPanel13.setMinimumSize(new java.awt.Dimension(600, 56));
        ProjectLocationsCenterPanel13.setPreferredSize(new java.awt.Dimension(800, 56));
        ProjectLookAndFeelImages7.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages7, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages7.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages7.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Messaging & Auto Update Image Button Background Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages7.setMaximumSize(new java.awt.Dimension(360, 150));
        ProjectLookAndFeelImages7.setMinimumSize(new java.awt.Dimension(360, 145));
        ProjectLookAndFeelImages7.setPreferredSize(new java.awt.Dimension(360, 145));
        ProjectLookAndFeelImages7.setRequestFocusEnabled(false);
        ImageDescriptionLabel3.setLayout(new javax.swing.BoxLayout(ImageDescriptionLabel3, javax.swing.BoxLayout.X_AXIS));

        ImageDescriptionLabel3.setBackground(new java.awt.Color(140, 160, 210));
        LeftUIFiller8.setMaximumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller8.setMinimumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller8.setPreferredSize(new java.awt.Dimension(10, 10));
        ImageDescriptionLabel3.add(LeftUIFiller8);

        useDefaultButtonBarBackgroundColor.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultButtonBarBackgroundColor.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultButtonBarBackgroundColor.setSelected(true);
        useDefaultButtonBarBackgroundColor.setLabel("Use default text background color");
        useDefaultButtonBarBackgroundColor.setMaximumSize(new java.awt.Dimension(215, 23));
        useDefaultButtonBarBackgroundColor.setMinimumSize(new java.awt.Dimension(215, 23));
        useDefaultButtonBarBackgroundColor.setPreferredSize(new java.awt.Dimension(215, 23));
        useDefaultButtonBarBackgroundColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultButtonBarBackgroundColorActionPerformed(evt);
            }
        });

        ImageDescriptionLabel3.add(useDefaultButtonBarBackgroundColor);

        ButtonBarBackgroundColorChooserButton.setBackground(new java.awt.Color(140, 160, 210));
        ButtonBarBackgroundColorChooserButton.setMaximumSize(new java.awt.Dimension(35, 20));
        ButtonBarBackgroundColorChooserButton.setMinimumSize(new java.awt.Dimension(35, 20));
        ButtonBarBackgroundColorChooserButton.setPreferredSize(new java.awt.Dimension(35, 20));
        ButtonBarBackgroundColorChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBarBackgroundColorChooserButtonActionPerformed(evt);
            }
        });

        ImageDescriptionLabel3.add(ButtonBarBackgroundColorChooserButton);

        lFiller45.setBackground(new java.awt.Color(140, 160, 210));
        lFiller45.setText("   ");
        lFiller45.setMaximumSize(new java.awt.Dimension(32767, 16));
        lFiller45.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller45.setPreferredSize(new java.awt.Dimension(10, 16));
        ImageDescriptionLabel3.add(lFiller45);

        ProjectLookAndFeelImages7.add(ImageDescriptionLabel3);

        ProjectLocationsCenterPanel13.add(ProjectLookAndFeelImages7);

        lFiller87.setBackground(new java.awt.Color(140, 160, 210));
        lFiller87.setText("   ");
        lFiller87.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller87.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller87.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel13.add(lFiller87);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.X_AXIS));

        jPanel1.setBackground(new java.awt.Color(140, 160, 210));
        jPanel1.setMaximumSize(new java.awt.Dimension(232, 46));
        jPanel1.setMinimumSize(new java.awt.Dimension(232, 46));
        jPanel1.setPreferredSize(new java.awt.Dimension(232, 46));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setBackground(new java.awt.Color(140, 160, 210));
        rbPaymentPreview.setBackground(new java.awt.Color(140, 160, 210));
        rbPaymentPreview.setFont(new java.awt.Font("Arial", 0, 12));
        rbPaymentPreview.setSelected(true);
        rbPaymentPreview.setText("Payment Window");
        rbPaymentPreview.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rbPaymentPreview.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        rbPaymentPreview.setMaximumSize(new java.awt.Dimension(125, 23));
        rbPaymentPreview.setMinimumSize(new java.awt.Dimension(125, 23));
        rbPaymentPreview.setPreferredSize(new java.awt.Dimension(125, 23));
        rbPaymentPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPaymentPreviewActionPerformed(evt);
            }
        });

        jPanel2.add(rbPaymentPreview);

        rbPaymentSuccessPreview.setBackground(new java.awt.Color(140, 160, 210));
        rbPaymentSuccessPreview.setFont(new java.awt.Font("Arial", 0, 12));
        rbPaymentSuccessPreview.setText("Startup Window");
        rbPaymentSuccessPreview.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rbPaymentSuccessPreview.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        rbPaymentSuccessPreview.setMaximumSize(new java.awt.Dimension(125, 23));
        rbPaymentSuccessPreview.setMinimumSize(new java.awt.Dimension(125, 23));
        rbPaymentSuccessPreview.setPreferredSize(new java.awt.Dimension(125, 23));
        rbPaymentSuccessPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPaymentSuccessPreviewActionPerformed(evt);
            }
        });

        jPanel2.add(rbPaymentSuccessPreview);

        jPanel1.add(jPanel2);

        jPanel4.setBackground(new java.awt.Color(140, 160, 210));
        jPanel1.add(jPanel4);

        jPanel3.setBackground(new java.awt.Color(140, 160, 210));
        jPanel3.setMaximumSize(new java.awt.Dimension(77, 69));
        jPanel3.setMinimumSize(new java.awt.Dimension(77, 69));
        jPanel3.setPreferredSize(new java.awt.Dimension(77, 69));
        PreviewButton.setFont(new java.awt.Font("Arial", 0, 12));
        PreviewButton.setLabel("Preview");
        PreviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviewButtonActionPerformed(evt);
            }
        });

        jPanel3.add(PreviewButton);

        lFiller47.setBackground(new java.awt.Color(140, 160, 210));
        lFiller47.setText("   ");
        lFiller47.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller47.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller47.setPreferredSize(new java.awt.Dimension(15, 16));
        jPanel3.add(lFiller47);

        lFiller48.setBackground(new java.awt.Color(140, 160, 210));
        lFiller48.setText("   ");
        lFiller48.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller48.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller48.setPreferredSize(new java.awt.Dimension(15, 16));
        jPanel3.add(lFiller48);

        jPanel1.add(jPanel3);

        ProjectLocationsCenterPanel13.add(jPanel1);

        lFiller91.setBackground(new java.awt.Color(140, 160, 210));
        lFiller91.setText("   ");
        lFiller91.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller91.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller91.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel13.add(lFiller91);

        ProjectLookAndFeelImages3.add(ProjectLocationsCenterPanel13);

        UIChoicesBottomPanel6.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel6.setMinimumSize(new java.awt.Dimension(5, 5));
        UIChoicesBottomPanel6.setPreferredSize(new java.awt.Dimension(5, 5));
        ProjectLookAndFeelImages3.add(UIChoicesBottomPanel6);

        add(ProjectLookAndFeelImages3);

    }//GEN-END:initComponents

    private void cbUseEvaluationButtonEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUseEvaluationButtonEnabledActionPerformed
	try
        {
		// Image Buttons Enabled
            if(cbUseEvaluationButtonEnabled.isSelected()==true)
            {
                ProjectManager.putTempNoFileWrite("secondaryPaymentMethodEnabled", "true");
            }
            else
            {
                ProjectManager.putTempNoFileWrite("secondaryPaymentMethodEnabled", "false");         
            }
        }
        catch(Exception e)
        {
            
        }
    }//GEN-LAST:event_cbUseEvaluationButtonEnabledActionPerformed

    private void useDefaultButtonBarBackgroundColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultButtonBarBackgroundColorActionPerformed
        try
        {
            if(useDefaultButtonBarBackgroundColor.isSelected()==true)
            {
                ProjectManager.put("autoUpdateImgBackgroundColor", "");
                ButtonBarBackgroundColorChooserButton.setVisible(false);                      
            }
            else
            {
                ButtonBarBackgroundColorChooserButton.setVisible(true);  
                updateButtonBarBackgroundColorSwatch();            
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_useDefaultButtonBarBackgroundColorActionPerformed

    private void ButtonBarBackgroundColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBarBackgroundColorChooserButtonActionPerformed
 	// Bring up a color chooser 
        if(ProjectManager.get("autoUpdateImgBackgroundColor")!=null)
        {
            if(ProjectManager.get("autoUpdateImgBackgroundColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("autoUpdateImgBackgroundColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("autoUpdateImgBackgroundColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ButtonBarBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("autoUpdateImgBackgroundColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                ButtonBarBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("autoUpdateImgBackgroundColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                ButtonBarBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_ButtonBarBackgroundColorChooserButtonActionPerformed

    private void useDefaultButtonBarTextColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultButtonBarTextColorActionPerformed
        try
        {
            if(useDefaultButtonBarTextColor.isSelected()==true)
            {
                ProjectManager.put("paymentImgSecondaryButtonBackgroundColor", "");
                buttonBarTextColorChooserButton.setVisible(false);                      
            }
            else
            {
                buttonBarTextColorChooserButton.setVisible(true);  
                updateButtonBarTextColorSwatch();            
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_useDefaultButtonBarTextColorActionPerformed

    private void buttonBarTextColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBarTextColorChooserButtonActionPerformed
 	// Bring up a color chooser 
        if(ProjectManager.get("paymentImgSecondaryButtonBackgroundColor")!=null)
        {
            if(ProjectManager.get("paymentImgSecondaryButtonBackgroundColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentImgSecondaryButtonBackgroundColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("paymentImgSecondaryButtonBackgroundColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                buttonBarTextColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("paymentImgSecondaryButtonBackgroundColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                buttonBarTextColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("paymentImgSecondaryButtonBackgroundColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                buttonBarTextColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_buttonBarTextColorChooserButtonActionPerformed

    private void rbPaymentSuccessPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPaymentSuccessPreviewActionPerformed
        if(rbPaymentSuccessPreview.isSelected()==true)
        {
           rbPaymentPreview.setSelected(false);
           rbPaymentSuccessPreview.setSelected(true);
        } 
    }//GEN-LAST:event_rbPaymentSuccessPreviewActionPerformed

    private void rbPaymentPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPaymentPreviewActionPerformed
        if(rbPaymentPreview.isSelected()==true)
        {
           rbPaymentPreview.setSelected(true);
           rbPaymentSuccessPreview.setSelected(false);
        } 
    }//GEN-LAST:event_rbPaymentPreviewActionPerformed

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
                            if(ProjectManager.get("secondaryPaymentMethod")!=null)
                            {
                                if(ProjectManager.get("secondaryPaymentMethod").equalsIgnoreCase("")==true)
                                {
                                    tfUseEvaluationButtonAction.setText("http://www.evaluateanywhere.com");
                                }
                                else
                                {
                                    tfUseEvaluationButtonAction.setText(ProjectManager.get("secondaryPaymentMethod"));
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
                                new URL(ProjectManager.get("secondaryPaymentMethod"));
                                tfUseEvaluationButtonAction.setText(ProjectManager.get("secondaryPaymentMethod"));
                                
                            }
                            catch(MalformedURLException e)
                            {
                                if(ProjectManager.get("secondaryPaymentMethod")!=null)
                                {
                                    if(ProjectManager.get("secondaryPaymentMethod").equalsIgnoreCase("")==true)
                                    {
                                        tfUseEvaluationButtonAction.setText("http://www.evaluateanywhere.com");
                                    }
                                    else
                                    {
                                        tfUseEvaluationButtonAction.setText(ProjectManager.get("secondaryPaymentMethod"));
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
                     tfUseEvaluationButtonAction.setEnabled(true);
                     tfUseEvaluationButtonAction.setText("Secondary Payment Processing Action");                   
                }
        }
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_cbUseEvaluationButtonActionTypeActionPerformed

    private void ImageButtonOnClickPathChooseButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonOnClickPathChooseButton2ActionPerformed
	try
	{
		int result = imageFileChooser.showOpenDialog(this); 
        	if(result == JFileChooser.APPROVE_OPTION) 
        	{ 
                    ProjectManager.putTempNoFileWrite("paymentImgSecondaryButtonFaceOnClick", imageFileChooser.getSelectedFile().toURL().toString());
                    tfImageButtonOnClickPath2.setText(new File(new URL(ProjectManager.get("paymentImgSecondaryButtonFaceOnClick")).getFile()).getCanonicalPath());
			tfImageButtonOnClickPath2.setCaretPosition(0);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_ImageButtonOnClickPathChooseButton2ActionPerformed

    private void ImageButtonPathChooseButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonPathChooseButton2ActionPerformed
	try
	{
		int result = imageFileChooser.showOpenDialog(this); 
        	if(result == JFileChooser.APPROVE_OPTION) 
        	{ 
                    ProjectManager.putTempNoFileWrite("paymentImgSecondaryButtonFace", imageFileChooser.getSelectedFile().toURL().toString());
                    tfImageButtonPath2.setText(new File(new URL(ProjectManager.get("paymentImgSecondaryButtonFace")).getFile()).getCanonicalPath());
                    tfImageButtonPath2.setCaretPosition(0);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_ImageButtonPathChooseButton2ActionPerformed

    private void ImageButtonInFocusPathDefaultButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonInFocusPathDefaultButton2ActionPerformed
		try
		{
                    ProjectManager.put("paymentImgSecondaryButtonFaceInFocus", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/images/paysecondmethodpanelbtn.png").toString());
                    tfImageButtonInFocusPath2.setText(new File(new URL(ProjectManager.get("paymentImgSecondaryButtonFaceInFocus")).getFile()).getCanonicalPath());
                    tfImageButtonInFocusPath2.setCaretPosition(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }//GEN-LAST:event_ImageButtonInFocusPathDefaultButton2ActionPerformed

    private void ImageButtonInFocusPathChooseButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonInFocusPathChooseButton2ActionPerformed
	try
	{
		int result = imageFileChooser.showOpenDialog(this); 
        	if(result == JFileChooser.APPROVE_OPTION) 
        	{ 
                    ProjectManager.putTempNoFileWrite("paymentImgSecondaryButtonFaceInFocus", imageFileChooser.getSelectedFile().toURL().toString());
                    tfImageButtonInFocusPath2.setText(new File(new URL(ProjectManager.get("paymentImgSecondaryButtonFaceInFocus")).getFile()).getCanonicalPath());
                    tfImageButtonInFocusPath2.setCaretPosition(0);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_ImageButtonInFocusPathChooseButton2ActionPerformed

    private void ImageButtonOnClickPathDefaultButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonOnClickPathDefaultButton2ActionPerformed
		try
		{
                    ProjectManager.put("paymentImgSecondaryButtonFaceOnClick", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/images/paysecondmethodpanelbtn.png").toString());
                    tfImageButtonOnClickPath2.setText(new File(new URL(ProjectManager.get("paymentImgSecondaryButtonFaceOnClick")).getFile()).getCanonicalPath());
                    tfImageButtonOnClickPath2.setCaretPosition(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }//GEN-LAST:event_ImageButtonOnClickPathDefaultButton2ActionPerformed

    private void ImageButtonPathDefaultButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonPathDefaultButton2ActionPerformed
		try
		{
                    ProjectManager.put("paymentImgSecondaryButtonFace", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/images/paysecondmethodpanelbtn.png").toString());
                    tfImageButtonPath2.setText(new File(new URL(ProjectManager.get("paymentImgSecondaryButtonFace")).getFile()).getCanonicalPath());
                    tfImageButtonPath2.setCaretPosition(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }//GEN-LAST:event_ImageButtonPathDefaultButton2ActionPerformed

    private void ImageButtonInFocusPathChooseButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonInFocusPathChooseButton1ActionPerformed
	try
	{
		int result = imageFileChooser.showOpenDialog(this); 
        	if(result == JFileChooser.APPROVE_OPTION) 
        	{ 
                    ProjectManager.putTempNoFileWrite("paymentImgContinueButtonFaceInFocus", imageFileChooser.getSelectedFile().toURL().toString());
                    tfImageButtonInFocusPath1.setText(new File(new URL(ProjectManager.get("paymentImgContinueButtonFaceInFocus")).getFile()).getCanonicalPath());
                    tfImageButtonInFocusPath1.setCaretPosition(0);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_ImageButtonInFocusPathChooseButton1ActionPerformed

    private void ImageButtonOnClickPathChooseButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonOnClickPathChooseButton1ActionPerformed
	try
	{
		int result = imageFileChooser.showOpenDialog(this); 
        	if(result == JFileChooser.APPROVE_OPTION) 
        	{ 
                    ProjectManager.putTempNoFileWrite("paymentImgContinueButtonFaceOnClick", imageFileChooser.getSelectedFile().toURL().toString());
                    tfImageButtonOnClickPath1.setText(new File(new URL(ProjectManager.get("paymentImgContinueButtonFaceOnClick")).getFile()).getCanonicalPath());
			tfImageButtonOnClickPath1.setCaretPosition(0);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_ImageButtonOnClickPathChooseButton1ActionPerformed

    private void ImageButtonPathChooseButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonPathChooseButton1ActionPerformed
	try
	{
		int result = imageFileChooser.showOpenDialog(this); 
        	if(result == JFileChooser.APPROVE_OPTION) 
        	{ 
                    ProjectManager.putTempNoFileWrite("paymentImgContinueButtonFace", imageFileChooser.getSelectedFile().toURL().toString());
                    tfImageButtonPath1.setText(new File(new URL(ProjectManager.get("paymentImgContinueButtonFace")).getFile()).getCanonicalPath());
                    tfImageButtonPath1.setCaretPosition(0);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_ImageButtonPathChooseButton1ActionPerformed

    private void useImageButtonsEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useImageButtonsEnabledActionPerformed
	try
        {
		// Image Buttons Enabled
            if(useImageButtonsEnabled.isSelected()==true)
            {
                ProjectManager.putTempNoFileWrite("btnBarImgButtonsEnabled", "true");
            }
            else
            {
                ProjectManager.putTempNoFileWrite("btnBarImgButtonsEnabled", "false");         
            }
        }
        catch(Exception e)
        {
            
        }
    }//GEN-LAST:event_useImageButtonsEnabledActionPerformed

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
     getDataUpdate(); 
    }//GEN-LAST:event_formFocusLost

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void ImageButtonInFocusPathDefaultButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonInFocusPathDefaultButton1ActionPerformed
        try
        {
            ProjectManager.put("paymentImgContinueButtonFaceInFocus", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/images/paybtncontinue.png").toString());
            tfImageButtonInFocusPath1.setText(new File(new URL(ProjectManager.get("paymentImgContinueButtonFaceInFocus")).getFile()).getCanonicalPath());
            tfImageButtonInFocusPath1.setCaretPosition(0);
        }
        catch(Exception e)
        {
                e.printStackTrace();
        } 
    }//GEN-LAST:event_ImageButtonInFocusPathDefaultButton1ActionPerformed

    private void ImageButtonOnClickPathDefaultButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonOnClickPathDefaultButton1ActionPerformed
	try
        {
            ProjectManager.put("paymentImgContinueButtonFaceOnClick", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/images/paybtncontinueclick.png").toString());
            tfImageButtonOnClickPath1.setText(new File(new URL(ProjectManager.get("paymentImgContinueButtonFaceOnClick")).getFile()).getCanonicalPath());
            tfImageButtonOnClickPath1.setCaretPosition(0);
        }
        catch(Exception e)
        {
                e.printStackTrace();
        }
    }//GEN-LAST:event_ImageButtonOnClickPathDefaultButton1ActionPerformed

    private void ImageButtonPathDefaultButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonPathDefaultButton1ActionPerformed
		try
		{
                    ProjectManager.put("paymentImgContinueButtonFace", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/images/paybtncontinue.png").toString());
                    tfImageButtonPath1.setText(new File(new URL(ProjectManager.get("paymentImgContinueButtonFace")).getFile()).getCanonicalPath());
                    tfImageButtonPath1.setCaretPosition(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }//GEN-LAST:event_ImageButtonPathDefaultButton1ActionPerformed

    private void ImageButtonInFocusPathDefaultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonInFocusPathDefaultButtonActionPerformed
		try
		{
                    ProjectManager.putTempNoFileWrite("buttonFaceImageInFocus", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/images/btnfocus.png").toString());
                    ProjectManager.putTempNoFileWrite("registrationButtonFaceInFocus", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/images/btnfocus.png").toString());
                    ProjectManager.putTempNoFileWrite("paymentImgCancelButtonFaceInFocus", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/images/btnfocus.png").toString());

                    tfImageButtonInFocusPath.setText(new File(new URL(ProjectManager.get("buttonFaceImageInFocus")).getFile()).getCanonicalPath());
			tfImageButtonInFocusPath.setCaretPosition(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }//GEN-LAST:event_ImageButtonInFocusPathDefaultButtonActionPerformed

    private void ImageButtonInFocusPathChooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonInFocusPathChooseButtonActionPerformed
	try
	{
		int result = imageFileChooser.showOpenDialog(this); 
        	if(result == JFileChooser.APPROVE_OPTION) 
        	{ 
                    ProjectManager.putTempNoFileWrite("buttonFaceImageInFocus", imageFileChooser.getSelectedFile().toURL().toString());
                    ProjectManager.putTempNoFileWrite("registrationButtonFaceInFocus", imageFileChooser.getSelectedFile().toURL().toString());
                    ProjectManager.putTempNoFileWrite("paymentImgCancelButtonFaceInFocus", imageFileChooser.getSelectedFile().toURL().toString());
                
                    tfImageButtonInFocusPath.setText(new File(new URL(ProjectManager.get("buttonFaceImageInFocus")).getFile()).getCanonicalPath());
                    tfImageButtonInFocusPath.setCaretPosition(0);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_ImageButtonInFocusPathChooseButtonActionPerformed

    private void ImageButtonOnClickPathDefaultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonOnClickPathDefaultButtonActionPerformed
		try
		{
                        ProjectManager.putTempNoFileWrite("btnBarImgButtonFaceOnClick", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/images/btnclick.png").toString());
			ProjectManager.putTempNoFileWrite("registrationImgButtonFaceOnClick", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/images/btnclick.png").toString());
			ProjectManager.putTempNoFileWrite("paymentImgCancelButtonFaceOnClick", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/images/btnclick.png").toString());
                
                    tfImageButtonOnClickPath.setText(new File(new URL(ProjectManager.get("btnBarImgButtonFaceOnClick")).getFile()).getCanonicalPath());
			tfImageButtonOnClickPath.setCaretPosition(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }//GEN-LAST:event_ImageButtonOnClickPathDefaultButtonActionPerformed

    private void ImageButtonOnClickPathChooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonOnClickPathChooseButtonActionPerformed
	try
	{
		int result = imageFileChooser.showOpenDialog(this); 
        	if(result == JFileChooser.APPROVE_OPTION) 
        	{ 
                    ProjectManager.putTempNoFileWrite("btnBarImgButtonFaceOnClick", imageFileChooser.getSelectedFile().toURL().toString());
                    ProjectManager.putTempNoFileWrite("registrationImgButtonFaceOnClick", imageFileChooser.getSelectedFile().toURL().toString());
                    ProjectManager.putTempNoFileWrite("paymentImgCancelButtonFaceOnClick", imageFileChooser.getSelectedFile().toURL().toString());

                    tfImageButtonOnClickPath.setText(new File(new URL(ProjectManager.get("btnBarImgButtonFaceOnClick")).getFile()).getCanonicalPath());
			tfImageButtonOnClickPath.setCaretPosition(0);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_ImageButtonOnClickPathChooseButtonActionPerformed

    private void ImageButtonPathDefaultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonPathDefaultButtonActionPerformed
		try
		{
                    ProjectManager.putTempNoFileWrite("btnBarImgButtonFace", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/images/btn.png").toString());
                    ProjectManager.putTempNoFileWrite("registrationImgButtonFace", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/images/btn.png").toString());
                    ProjectManager.putTempNoFileWrite("paymentImgCancelButtonFace", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/images/btn.png").toString());

                    tfImageButtonPath.setText(new File(new URL(ProjectManager.get("btnBarImgButtonFace")).getFile()).getCanonicalPath());
                    tfImageButtonPath.setCaretPosition(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }//GEN-LAST:event_ImageButtonPathDefaultButtonActionPerformed

    private void ImageButtonPathChooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonPathChooseButtonActionPerformed
	try
	{
		int result = imageFileChooser.showOpenDialog(this); 
        	if(result == JFileChooser.APPROVE_OPTION) 
        	{ 
                    ProjectManager.putTempNoFileWrite("btnBarImgButtonFace", imageFileChooser.getSelectedFile().toURL().toString());
                    ProjectManager.putTempNoFileWrite("registrationImgButtonFace", imageFileChooser.getSelectedFile().toURL().toString());
                    ProjectManager.putTempNoFileWrite("paymentImgCancelButtonFace", imageFileChooser.getSelectedFile().toURL().toString());

                    tfImageButtonPath.setText(new File(new URL(ProjectManager.get("btnBarImgButtonFace")).getFile()).getCanonicalPath());
                    tfImageButtonPath.setCaretPosition(0);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_ImageButtonPathChooseButtonActionPerformed

    private void tfImageButtonInFocusPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfImageButtonInFocusPathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfImageButtonInFocusPathActionPerformed

    private void PreviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviewButtonActionPerformed
        try
        {
            if(rbPaymentPreview.isSelected()==true)
            {
		EAPanel thePanel = (EAPanel)getParentComponent();
                ((EAPanel)thePanel.getParentComponent()).getDataUpdate(); 
                new BuyNowAction();	
            }
            else if(rbPaymentSuccessPreview.isSelected()==true)
            {
		EAPanel thePanel = (EAPanel)getParentComponent();
                ((EAPanel)thePanel.getParentComponent()).getDataUpdate(); 
		new StartVerticalButtonBarThemeAction();	      
            } 
        }
        catch(Exception e)
        {
                e.printStackTrace();
        }
    }//GEN-LAST:event_PreviewButtonActionPerformed

    private void updateButtonBarBackgroundColorSwatch() 
    {
        try
        { 
            Color c = new java.awt.Color(255,255,255); 
            // Bring up a color chooser 
            if(ProjectManager.get("autoUpdateImgBackgroundColor")!=null)
            {
                if(ProjectManager.get("autoUpdateImgBackgroundColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("autoUpdateImgBackgroundColor"));
                    c = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()); 
                    ButtonBarBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
                }
                else
                {
                    ButtonBarBackgroundColorChooserButton.setIcon(noColorIcon);
                }
            }
            else
            {
                ButtonBarBackgroundColorChooserButton.setIcon(noColorIcon);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }        
    
    private void updateButtonBarTextColorSwatch()
    {
        try
        {
            Color c = new java.awt.Color(255,255,255); 
            // Bring up a color chooser 
            if(ProjectManager.get("paymentImgSecondaryButtonBackgroundColor")!=null)
            {
                if(ProjectManager.get("paymentImgSecondaryButtonBackgroundColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentImgSecondaryButtonBackgroundColor"));
                    c = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()); 
                    buttonBarTextColorChooserButton.setIcon(new ColorSwatch(c));
                }
                else
                {
                    buttonBarTextColorChooserButton.setIcon(noColorIcon);
                }
            }
            else
            {
                buttonBarTextColorChooserButton.setIcon(noColorIcon);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }        
    
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

     class ColorSwatch implements Icon 
     { 
        Color bez;
 	public ColorSwatch(Color theColor) 
        { 
 	    bez = theColor;
 	} 
  
 	public int getIconWidth() 
        { 
 	    return 11; 
 	}  
  
 	public int getIconHeight() 
        { 
 	    return 11; 
 	}  
  
 	public void paintIcon(Component c, Graphics g, int x, int y)
        { 
 	    g.setColor(Color.black); 
 	    g.fillRect(x, y, getIconWidth(), getIconHeight()); 
   	    g.setColor(bez); 
 	    g.fillRect(x+1, y+1, getIconWidth()-2, getIconHeight()-2); 
 	} 
     }         
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBarBackgroundColorChooserButton;
    private javax.swing.JButton ImageButtonInFocusPathChooseButton;
    private javax.swing.JButton ImageButtonInFocusPathChooseButton1;
    private javax.swing.JButton ImageButtonInFocusPathChooseButton2;
    private javax.swing.JButton ImageButtonInFocusPathDefaultButton;
    private javax.swing.JButton ImageButtonInFocusPathDefaultButton1;
    private javax.swing.JButton ImageButtonInFocusPathDefaultButton2;
    private javax.swing.JButton ImageButtonOnClickPathChooseButton;
    private javax.swing.JButton ImageButtonOnClickPathChooseButton1;
    private javax.swing.JButton ImageButtonOnClickPathChooseButton2;
    private javax.swing.JButton ImageButtonOnClickPathDefaultButton;
    private javax.swing.JButton ImageButtonOnClickPathDefaultButton1;
    private javax.swing.JButton ImageButtonOnClickPathDefaultButton2;
    private javax.swing.JButton ImageButtonPathChooseButton;
    private javax.swing.JButton ImageButtonPathChooseButton1;
    private javax.swing.JButton ImageButtonPathChooseButton2;
    private javax.swing.JButton ImageButtonPathDefaultButton;
    private javax.swing.JButton ImageButtonPathDefaultButton1;
    private javax.swing.JButton ImageButtonPathDefaultButton2;
    private javax.swing.JPanel ImageDescriptionLabel;
    private javax.swing.JPanel ImageDescriptionLabel1;
    private javax.swing.JPanel ImageDescriptionLabel2;
    private javax.swing.JPanel ImageDescriptionLabel3;
    private javax.swing.JLabel LeftUIFiller2;
    private javax.swing.JLabel LeftUIFiller4;
    private javax.swing.JLabel LeftUIFiller5;
    private javax.swing.JLabel LeftUIFiller7;
    private javax.swing.JLabel LeftUIFiller8;
    private javax.swing.JButton PreviewButton;
    private javax.swing.JPanel ProjectLocationsCenterPanel10;
    private javax.swing.JPanel ProjectLocationsCenterPanel11;
    private javax.swing.JPanel ProjectLocationsCenterPanel13;
    private javax.swing.JPanel ProjectLocationsCenterPanel2;
    private javax.swing.JPanel ProjectLocationsCenterPanel3;
    private javax.swing.JPanel ProjectLocationsCenterPanel5;
    private javax.swing.JPanel ProjectLocationsCenterPanel6;
    private javax.swing.JPanel ProjectLocationsCenterPanel7;
    private javax.swing.JPanel ProjectLocationsCenterPanel8;
    private javax.swing.JPanel ProjectLocationsCenterPanel9;
    private javax.swing.JPanel ProjectLookAndFeelImages3;
    private javax.swing.JPanel ProjectLookAndFeelImages4;
    private javax.swing.JPanel ProjectLookAndFeelImages5;
    private javax.swing.JPanel ProjectLookAndFeelImages6;
    private javax.swing.JPanel ProjectLookAndFeelImages7;
    private javax.swing.JPanel UIChoicesBottomPanel11;
    private javax.swing.JPanel UIChoicesBottomPanel13;
    private javax.swing.JPanel UIChoicesBottomPanel14;
    private javax.swing.JPanel UIChoicesBottomPanel15;
    private javax.swing.JPanel UIChoicesBottomPanel6;
    private javax.swing.JButton buttonBarTextColorChooserButton;
    private javax.swing.JComboBox cbUseEvaluationButtonActionType;
    private javax.swing.JCheckBox cbUseEvaluationButtonEnabled;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lBuildLocation10;
    private javax.swing.JLabel lBuildLocation2;
    private javax.swing.JLabel lBuildLocation3;
    private javax.swing.JLabel lBuildLocation4;
    private javax.swing.JLabel lBuildLocation5;
    private javax.swing.JLabel lBuildLocation6;
    private javax.swing.JLabel lBuildLocation7;
    private javax.swing.JLabel lBuildLocation8;
    private javax.swing.JLabel lBuildLocation9;
    private javax.swing.JLabel lFiller25;
    private javax.swing.JLabel lFiller26;
    private javax.swing.JLabel lFiller27;
    private javax.swing.JLabel lFiller30;
    private javax.swing.JLabel lFiller31;
    private javax.swing.JLabel lFiller32;
    private javax.swing.JLabel lFiller33;
    private javax.swing.JLabel lFiller34;
    private javax.swing.JLabel lFiller35;
    private javax.swing.JLabel lFiller36;
    private javax.swing.JLabel lFiller37;
    private javax.swing.JLabel lFiller38;
    private javax.swing.JLabel lFiller39;
    private javax.swing.JLabel lFiller40;
    private javax.swing.JLabel lFiller41;
    private javax.swing.JLabel lFiller42;
    private javax.swing.JLabel lFiller43;
    private javax.swing.JLabel lFiller44;
    private javax.swing.JLabel lFiller45;
    private javax.swing.JLabel lFiller46;
    private javax.swing.JLabel lFiller47;
    private javax.swing.JLabel lFiller48;
    private javax.swing.JLabel lFiller49;
    private javax.swing.JLabel lFiller50;
    private javax.swing.JLabel lFiller51;
    private javax.swing.JLabel lFiller52;
    private javax.swing.JLabel lFiller53;
    private javax.swing.JLabel lFiller54;
    private javax.swing.JLabel lFiller55;
    private javax.swing.JLabel lFiller56;
    private javax.swing.JLabel lFiller57;
    private javax.swing.JLabel lFiller58;
    private javax.swing.JLabel lFiller59;
    private javax.swing.JLabel lFiller60;
    private javax.swing.JLabel lFiller61;
    private javax.swing.JLabel lFiller62;
    private javax.swing.JLabel lFiller63;
    private javax.swing.JLabel lFiller64;
    private javax.swing.JLabel lFiller65;
    private javax.swing.JLabel lFiller66;
    private javax.swing.JLabel lFiller67;
    private javax.swing.JLabel lFiller68;
    private javax.swing.JLabel lFiller69;
    private javax.swing.JLabel lFiller70;
    private javax.swing.JLabel lFiller71;
    private javax.swing.JLabel lFiller72;
    private javax.swing.JLabel lFiller73;
    private javax.swing.JLabel lFiller74;
    private javax.swing.JLabel lFiller75;
    private javax.swing.JLabel lFiller76;
    private javax.swing.JLabel lFiller77;
    private javax.swing.JLabel lFiller78;
    private javax.swing.JLabel lFiller79;
    private javax.swing.JLabel lFiller80;
    private javax.swing.JLabel lFiller81;
    private javax.swing.JLabel lFiller82;
    private javax.swing.JLabel lFiller83;
    private javax.swing.JLabel lFiller87;
    private javax.swing.JLabel lFiller88;
    private javax.swing.JLabel lFiller89;
    private javax.swing.JLabel lFiller90;
    private javax.swing.JLabel lFiller91;
    private javax.swing.JLabel lOverrideDefaultSplashImageHeight2;
    private javax.swing.JLabel lOverrideDefaultSplashImageHeight3;
    private javax.swing.JLabel lOverrideDefaultSplashImageHeight4;
    private javax.swing.JLabel lOverrideDefaultSplashImageWidth2;
    private javax.swing.JLabel lOverrideDefaultSplashImageWidth4;
    private javax.swing.JLabel lOverrideDefaultSplashImageWidth5;
    private javax.swing.JLabel lVerticalButtonBarButtonAction;
    private javax.swing.JLabel lVerticalButtonBarButtonActionType;
    private javax.swing.JRadioButton rbPaymentPreview;
    private javax.swing.JRadioButton rbPaymentSuccessPreview;
    private javax.swing.JSpinner spinButtonImageHeight;
    private javax.swing.JSpinner spinButtonImageHeight1;
    private javax.swing.JSpinner spinButtonImageHeight2;
    private javax.swing.JSpinner spinButtonImageWidth;
    private javax.swing.JSpinner spinButtonImageWidth1;
    private javax.swing.JSpinner spinButtonImageWidth2;
    private javax.swing.JTextField tfImageButtonInFocusPath;
    private javax.swing.JTextField tfImageButtonInFocusPath1;
    private javax.swing.JTextField tfImageButtonInFocusPath2;
    private javax.swing.JTextField tfImageButtonOnClickPath;
    private javax.swing.JTextField tfImageButtonOnClickPath1;
    private javax.swing.JTextField tfImageButtonOnClickPath2;
    private javax.swing.JTextField tfImageButtonPath;
    private javax.swing.JTextField tfImageButtonPath1;
    private javax.swing.JTextField tfImageButtonPath2;
    private javax.swing.JTextField tfUseEvaluationButtonAction;
    private javax.swing.JCheckBox useDefaultButtonBarBackgroundColor;
    private javax.swing.JCheckBox useDefaultButtonBarTextColor;
    private javax.swing.JCheckBox useImageButtonsEnabled;
    // End of variables declaration//GEN-END:variables
    
}
