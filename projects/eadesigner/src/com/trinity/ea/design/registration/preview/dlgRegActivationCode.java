/*
 * dlgRegActivationCode.java
 *
 * Created on October 24, 2003, 2:38 AM
 */
package com.trinity.ea.design.registration.preview;

import java.awt.*;
import javax.swing.*;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.registration.preview.gui.swing.ImageButton;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.net.URL;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2005 Trinity Software. All rights reserved.
 */
public class dlgRegActivationCode extends javax.swing.JDialog {
    private ImageIcon btnFace = null;
    private ImageIcon btnFaceOnClick = null;
    private ImageIcon btnFaceInFocus = null;
    private int btnWidth = -1;
    private int btnHeight = -1;    
    private boolean isImageButton = false;
    private Color extBorderColor = new Color(162,186,202);
    private Color highlightBorderColor1 = new Color(38,54,69);
    private Color highlightBorderColor2 = new Color(100,132,154);
    private Color shadowBorderColor1 = new Color(162,182,202);
    private Color shadowBorderColor2 = new Color(215,226,233);

    /** Creates new form tempDialogTest */
    public dlgRegActivationCode(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
	  updateUIExpressionDefines();
	  if(ProjectManager.get("btnBarImgButtonsEnabled")!=null)
	  {
	  	if(ProjectManager.get("btnBarImgButtonsEnabled").equalsIgnoreCase("true")==true)
	  	{
			isImageButton=true;
		}
		else
		{
			isImageButton=false;
		}
	  }
	  else
	  {
		isImageButton=false;
	  }
	  if(ProjectManager.get("registrationImgButtonWidth")!=null)
	  {
	  	if(ProjectManager.get("registrationImgButtonWidth").equalsIgnoreCase("")==false)
	  	{
			try
			{
				btnWidth = new Integer(ProjectManager.get("registrationImgButtonWidth")).intValue();
			}
			catch(Exception eee)
			{
				//eee.printStackTrace();
				btnWidth = 95;
			}
		}
		else
		{
			btnWidth = 95;
		}
	  }
	  else
	  {
		btnWidth = 95;
	  }	  
	  if(ProjectManager.get("registrationImgButtonHeight")!=null)
	  {
	  	if(ProjectManager.get("registrationImgButtonHeight").equalsIgnoreCase("")==false)
	  	{
			try
			{
				btnHeight = new Integer(ProjectManager.get("registrationImgButtonHeight")).intValue();
			}
			catch(Exception eee)
			{
				//eee.printStackTrace();
				btnHeight = 24;
			}
		}
		else
		{
			btnHeight = 24;
		}
	  }
	  else
	  {
		btnHeight = 24;
	  }	 
if(isImageButton==true)
{

		if(ProjectManager.get("registrationImgButtonFace")!=null)
		{
			if(ProjectManager.get("registrationImgButtonFace").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFace = new javax.swing.ImageIcon(new URL(ProjectManager.get("registrationImgButtonFace")));
				}
				catch(Exception e)
				{
					//e.printStackTrace();
					isImageButton=false;
				}
			}
		}
		if(ProjectManager.get("registrationImgButtonFaceOnClick")!=null)
		{
			if(ProjectManager.get("registrationImgButtonFaceOnClick").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceOnClick = new javax.swing.ImageIcon(new URL(ProjectManager.get("registrationImgButtonFaceOnClick")));

				}
				catch(Exception e)
				{
					//e.printStackTrace();
				}
			}
		}
		if(ProjectManager.get("registrationButtonFaceInFocus")!=null)
		{
			if(ProjectManager.get("registrationButtonFaceInFocus").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceInFocus = new javax.swing.ImageIcon(new URL(ProjectManager.get("registrationButtonFaceInFocus")));
				}
				catch(Exception e)
				{
					//e.printStackTrace();
				}
			}
		}
}
	  if(btnFace!=null)
	  {
		if(btnFaceOnClick!=null)
		{
			initComponents(true);
		}
		else
		{
			initComponents(false);
		}
	  }
	  else
	  {
        	initComponents(false);
	  }

        setSize(430 + getHorizontalInsetAdjustment(this.getInsets().left, this.getInsets().right), 194  + getVerticalInsetAdjustment(this.getInsets().top, this.getInsets().bottom));
        // Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        int w = getSize().width;
        int h = getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        try
        {
            setTitle(replaceUIExpressions(ProjectManager.get("registerSoftwareWindowTitle")));
        }
        catch(Exception e){}
	try
	{
	  	  //applyComponentOrientation(ComponentOrientation.getOrientation(ProjectManager.getLocale()));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
        // Move the window
        setLocation(x, y);        
    }

private int getVerticalInsetAdjustment(int actualTopInset, int actualBottomInset)
{
	try
	{
		int sum = actualTopInset + actualBottomInset;
		if(sum!=25)
		{
			if(sum<25)
			{
		    		return 0 - (25 - sum);
			}
			else if(sum>25)
			{
		     		return 0 + (sum - 25);
			}
		}
		else
		{
			return 0;
		}
	}
	catch(Exception e)
	{
		return 0;
	}
	return 0;
}

private int getHorizontalInsetAdjustment(int actualLeftInset, int actualRightInset)
{
	int osFactoredSum = 0;
	try
	{
		String os = System.getProperty("os.name");
		if(os.startsWith("Mac OS")==false && os.startsWith("Windows")==false) 
		{
			osFactoredSum = 46;
		}
		int sum = actualLeftInset + actualRightInset;
		if(sum!=6)
		{
			if(sum<6)
			{
		    		return osFactoredSum - (6 - sum);
			}
			else if(sum>6)
			{
		     		return osFactoredSum + (sum - 6);
			}
		}
		else
		{
			return osFactoredSum;
		}
	}
	catch(Exception e)
	{
		return osFactoredSum;
	}
	return osFactoredSum;
}
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents(boolean isImgButton) {//GEN-BEGIN:initComponents
	  isImageButton = isImgButton;
        RootPanel = new javax.swing.JPanel();
        NorthPanel = new javax.swing.JPanel();
        SouthPanel = new javax.swing.JPanel();
        WestPanel = new javax.swing.JPanel();
        EastPanel = new javax.swing.JPanel();
        ContentPanel = new javax.swing.JPanel();
        taDescription = new javax.swing.JTextArea();
        RegistrationCodePanel = new javax.swing.JPanel();
        lRegistrationCode = new javax.swing.JLabel();
        tfRegistrationCode = new javax.swing.JTextField();
        ButtonPanel = new javax.swing.JPanel();
        ButtonPanelTopFiller = new javax.swing.JPanel();
        ButtonPanelContentPanel = new javax.swing.JPanel();
        PreButtonPadding = new javax.swing.JLabel();
        ButtonPadding = new javax.swing.JLabel();
	  DescriptionPanel = new javax.swing.JPanel();
	  lRegistrationCodeLabelWestFiller = new javax.swing.JLabel();
	  DescriptionPanelWestPadding = new javax.swing.JLabel();
	  DescriptionPanelEastPadding = new javax.swing.JLabel();
	  lRegistrationCodeLabelWestFiller.setMaximumSize(new java.awt.Dimension(3, 3));
	  lRegistrationCodeLabelWestFiller.setMinimumSize(new java.awt.Dimension(3, 3));
	  lRegistrationCodeLabelWestFiller.setPreferredSize(new java.awt.Dimension(3, 3));
        DescriptionPanel.setMaximumSize(new java.awt.Dimension(1000, 75));
        DescriptionPanel.setPreferredSize(new java.awt.Dimension(360, 15));
        DescriptionPanelWestPadding.setMaximumSize(new java.awt.Dimension(13, 13));
        DescriptionPanelWestPadding.setMinimumSize(new java.awt.Dimension(13, 13));
        DescriptionPanelWestPadding.setPreferredSize(new java.awt.Dimension(13, 13));
        DescriptionPanelEastPadding.setMaximumSize(new java.awt.Dimension(30, 13));
        DescriptionPanelEastPadding.setMinimumSize(new java.awt.Dimension(13, 13));
        DescriptionPanelEastPadding.setPreferredSize(new java.awt.Dimension(30, 13));
        DescriptionPanel.setLayout(new javax.swing.BoxLayout(DescriptionPanel, javax.swing.BoxLayout.X_AXIS));

	  if(isImageButton==true)
	  {
        	btnImageCancel = new ImageButton(btnFace,btnFaceOnClick,btnFaceInFocus,btnWidth,btnHeight);

        	btnImageRegister = new ImageButton(btnFace,btnFaceOnClick,btnFaceInFocus,btnWidth,btnHeight);

	  }
	  else
	  {
        	btnCancel = new javax.swing.JButton();
        	btnRegister = new javax.swing.JButton();
	  }

        setModal(true);
        setResizable(false);
        RootPanel.setLayout(new java.awt.BorderLayout());

        NorthPanel.setMaximumSize(new java.awt.Dimension(17,12));
        NorthPanel.setMinimumSize(new java.awt.Dimension(17,12));
        NorthPanel.setPreferredSize(new java.awt.Dimension(17,12));
        RootPanel.add(NorthPanel, java.awt.BorderLayout.NORTH);

        SouthPanel.setMaximumSize(new java.awt.Dimension(10, 10));
        RootPanel.add(SouthPanel, java.awt.BorderLayout.SOUTH);

        WestPanel.setMaximumSize(new java.awt.Dimension(10, 10));
        RootPanel.add(WestPanel, java.awt.BorderLayout.WEST);

        EastPanel.setMaximumSize(new java.awt.Dimension(10, 10));
        RootPanel.add(EastPanel, java.awt.BorderLayout.EAST);

        ContentPanel.setLayout(new javax.swing.BoxLayout(ContentPanel, javax.swing.BoxLayout.Y_AXIS));

        ContentPanel.setFocusable(false);
        ContentPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        ContentPanel.setPreferredSize(new java.awt.Dimension(300, 218));
        ContentPanel.setRequestFocusEnabled(false);
        ContentPanel.setVerifyInputWhenFocusTarget(false);
        taDescription.setBackground(getBackground());
	  taDescription.setEditable(false);
        //taDescription.setFont(lRegistrationCode.getFont());
        if(ProjectManager.get("registrationDescriptionFont")!=null)
	  {
		if(ProjectManager.get("registrationDescriptionFont").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationDescriptionFont"));
      		taDescription.setFont(new java.awt.Font((String)tmpArray[0], new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }
	  else
	  {
		taDescription.setFont(lRegistrationCode.getFont());
	  }
        taDescription.setLineWrap(true);
	  if(ProjectManager.get("registrationPaidLabel")!=null)
	  {
		taDescription.setText(replaceUIExpressions(ProjectManager.get("registrationPaidLabel")));
	  }
	  else
	  {
      	taDescription.setText("If you paid the product activation fee, and received the activation number. Enter it now. If you downloaded an evaluation version of this product, or installed from a CD, and you have not paid the product activation fee, you are only allowed to use this product for evaluation purposes.");
	  }

        taDescription.setWrapStyleWord(true);
        taDescription.setMaximumSize(new java.awt.Dimension(1000, 75));
        taDescription.setPreferredSize(new java.awt.Dimension(275, 15));
	  taDescription.setEditable(false);
	  taDescription.setSelectionColor(getBackground());
	  taDescription.setBackground(getBackground());
        //taDescription.setFont(lRegistrationCode.getFont());
	  DescriptionPanel.add(DescriptionPanelWestPadding);
	  DescriptionPanel.add(taDescription);
	  DescriptionPanel.add(DescriptionPanelEastPadding);

        ContentPanel.add(DescriptionPanel);

        RegistrationCodePanel.setLayout(new java.awt.BorderLayout());

        RegistrationCodePanel.setMaximumSize(new java.awt.Dimension(2147483647, 20));

	  if(ProjectManager.get("registrationCodeLabelFontMnemonic")!=null)
	  {
		lRegistrationCode.setDisplayedMnemonic(ProjectManager.get("registrationCodeLabelFontMnemonic").charAt(0));
	  }

        //lRegistrationCode.setFont(new java.awt.Font("SansSerif", 0, 12));
        if(ProjectManager.get("registrationCodeLabelFont")!=null)
	  {
		if(ProjectManager.get("registrationCodeLabelFont").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationCodeLabelFont"));
      		lRegistrationCode.setFont(new java.awt.Font((String)tmpArray[0], new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			tfRegistrationCode.setFont(new java.awt.Font((String)tmpArray[0], new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }
	  else
	  {
		lRegistrationCode.setFont(new java.awt.Font("SansSerif", 0, 12));
		tfRegistrationCode.setFont(new java.awt.Font("SansSerif", 0, 12));
	  }
        //lRegistrationCode.setText("Activation Code:");
	  if(ProjectManager.get("registrationCodeLabel")!=null)
	  {
		lRegistrationCode.setText(replaceUIExpressions(ProjectManager.get("registrationCodeLabel")));
	  }
        lRegistrationCode.setMaximumSize(new java.awt.Dimension(32767, 20));
        lRegistrationCode.setMinimumSize(new java.awt.Dimension(1000, 15));
        lRegistrationCode.setPreferredSize(new java.awt.Dimension(1000, 20));

        RegistrationCodePanel.add(lRegistrationCodeLabelWestFiller, java.awt.BorderLayout.WEST);
        RegistrationCodePanel.add(lRegistrationCode, java.awt.BorderLayout.CENTER);

        ContentPanel.add(RegistrationCodePanel);

        tfRegistrationCode.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfRegistrationCode.setMinimumSize(new java.awt.Dimension(6, 20));
        tfRegistrationCode.setPreferredSize(new java.awt.Dimension(57, 20));

//

	  if(ProjectManager.get("registrationTFExtBorderColor")!=null)
	  {
		if(ProjectManager.get("registrationTFExtBorderColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationTFExtBorderColor"));
			extBorderColor = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
	  }
	  if(ProjectManager.get("registrationTFHighlightBorderColor1")!=null)
	  {
		if(ProjectManager.get("registrationTFHighlightBorderColor1").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationTFHighlightBorderColor1"));
			highlightBorderColor1 = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
	  }
	  if(ProjectManager.get("registrationTFHighlightBorderColor2")!=null)
	  {
		if(ProjectManager.get("registrationTFHighlightBorderColor2").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationTFHighlightBorderColor2"));
			highlightBorderColor2 = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
	  }
	  if(ProjectManager.get("registrationTFShadowBorderColor1")!=null)
	  {
		if(ProjectManager.get("registrationTFShadowBorderColor1").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationTFShadowBorderColor1"));
			shadowBorderColor1 = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
	  }
	  if(ProjectManager.get("registrationTFShadowBorderColor2")!=null)
	  {
		if(ProjectManager.get("registrationTFShadowBorderColor2").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationTFShadowBorderColor2"));
			shadowBorderColor2 = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
	  }
//
	  if(ProjectManager.get("registrationCustomBorderEnabled")!=null)
	  {
		if(ProjectManager.get("registrationCustomBorderEnabled").equalsIgnoreCase("true")==true)
		{
		     tfRegistrationCode.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(1, 0, 1, 1), extBorderColor), new javax.swing.border.CompoundBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 1, 1), shadowBorderColor2), new javax.swing.border.MatteBorder(new java.awt.Insets(1, 1, 0, 0), highlightBorderColor2))), new javax.swing.border.CompoundBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 1, 1), shadowBorderColor1), new javax.swing.border.MatteBorder(new java.awt.Insets(1, 1, 0, 0), highlightBorderColor1))));
		}
	  }

	  
        ContentPanel.add(tfRegistrationCode);

        ButtonPanel.setLayout(new javax.swing.BoxLayout(ButtonPanel, javax.swing.BoxLayout.Y_AXIS));

        ButtonPanel.setMinimumSize(new java.awt.Dimension(0,  btnHeight + 4));
        ButtonPanel.setPreferredSize(new java.awt.Dimension(1000,  btnHeight + 4));
        ButtonPanelTopFiller.setMaximumSize(new java.awt.Dimension(10, 10));
        ButtonPanel.add(ButtonPanelTopFiller);

        ButtonPanelContentPanel.setLayout(new javax.swing.BoxLayout(ButtonPanelContentPanel, javax.swing.BoxLayout.X_AXIS));

        ButtonPanelContentPanel.setMaximumSize(new java.awt.Dimension(32767,  btnHeight + 4));
        ButtonPanelContentPanel.setMinimumSize(new java.awt.Dimension(10,  btnHeight + 4));
        ButtonPanelContentPanel.setPreferredSize(new java.awt.Dimension(10, btnHeight + 4));
        PreButtonPadding.setText("");
        PreButtonPadding.setMaximumSize(new java.awt.Dimension(32767, 0));
        PreButtonPadding.setPreferredSize(new java.awt.Dimension(1000, 0));
        ButtonPanelContentPanel.add(PreButtonPadding);
	  if(isImageButton==true)
	  {
	  	 if(ProjectManager.get("registrationButtonFont")!=null)
	  	 {
	  		if(ProjectManager.get("registrationButtonFont").equalsIgnoreCase("")==false)
			{
				Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationButtonFont"));
      			btnImageCancel.setFont(new java.awt.Font((String)tmpArray[0], new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
				btnImageRegister.setFont(new java.awt.Font((String)tmpArray[0], new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
	  	  }

        	  btnImageCancel.setMaximumSize(new java.awt.Dimension(btnWidth, btnHeight));
       	  btnImageCancel.setMinimumSize(new java.awt.Dimension(btnWidth, btnHeight));
       	  btnImageCancel.setPreferredSize(new java.awt.Dimension(btnWidth, btnHeight));
      	  btnImageCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImageCancelMouseClicked(evt);
            }
        });

	  	  if(ProjectManager.get("registrationCancelButtonText")!=null)
	  	  {
     			btnImageCancel.setText(replaceUIExpressions(ProjectManager.get("registrationCancelButtonText")));
	  	  }
	  	  if(ProjectManager.get("registrationCancelButtonMnemonic")!=null)
	  	  {
	  	  	if(ProjectManager.get("registrationCancelButtonMnemonic").equalsIgnoreCase("")==false)
	  	  	{
	 			btnImageCancel.setMnemonic(ProjectManager.get("registrationCancelButtonMnemonic").charAt(0));
			}
  	  	  }

        	  ButtonPanelContentPanel.add(btnImageCancel);

        	  ButtonPadding.setText("");
        	  ButtonPadding.setMaximumSize(new java.awt.Dimension(7, 0));
        	  ButtonPadding.setMinimumSize(new java.awt.Dimension(7, 0));
        	  ButtonPadding.setPreferredSize(new java.awt.Dimension(7, 0));

        	  ButtonPanelContentPanel.add(ButtonPadding);

	        //btnImageRegister.setMargin(new java.awt.Insets(0, 0, 0, 0));
      	  btnImageRegister.setMaximumSize(new java.awt.Dimension(btnWidth, btnHeight));
     	   	  btnImageRegister.setMinimumSize(new java.awt.Dimension(btnWidth, btnHeight));
     		  btnImageRegister.setPreferredSize(new java.awt.Dimension(btnWidth, btnHeight));
      	  btnImageRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImageRegisterMouseClicked(evt);
            }
        });
	  	if(ProjectManager.get("registrationFinishButtonText")!=null)
	  	{
      		btnImageRegister.setText(replaceUIExpressions(ProjectManager.get("registrationFinishButtonText")));
	 	}
	  	if(ProjectManager.get("registrationFinishButtonMnemonic")!=null)
	  	{
	  	  	if(ProjectManager.get("registrationFinishButtonMnemonic").equalsIgnoreCase("")==false)
	  	  	{
				btnImageRegister.setMnemonic(ProjectManager.get("registrationFinishButtonMnemonic").charAt(0));
			}
	  	}

        	ButtonPanelContentPanel.add(btnImageRegister);
	  }
	  else
	  {
	  if(ProjectManager.get("registrationButtonFont")!=null)
	  {
	  	if(ProjectManager.get("registrationButtonFont").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationButtonFont"));
      		btnCancel.setFont(new java.awt.Font((String)tmpArray[0], new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			btnRegister.setFont(new java.awt.Font((String)tmpArray[0], new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }

        //btnCancel.setMnemonic('C');
        //btnCancel.setText("Cancel");
        btnCancel.setMaximumSize(new java.awt.Dimension(32767, 23));
        btnCancel.setMinimumSize(new java.awt.Dimension(90, 23));
        btnCancel.setPreferredSize(new java.awt.Dimension(118, 23));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

	  if(ProjectManager.get("registrationCancelButtonText")!=null)
	  {
     		btnCancel.setText(replaceUIExpressions(ProjectManager.get("registrationCancelButtonText")));
	  }
	  if(ProjectManager.get("registrationCancelButtonMnemonic")!=null)
	  {
	  	  	if(ProjectManager.get("registrationCancelButtonMnemonic").equalsIgnoreCase("")==false)
	  	  	{
	 			btnCancel.setMnemonic(ProjectManager.get("registrationCancelButtonMnemonic").charAt(0));
			}
  	  }

        ButtonPanelContentPanel.add(btnCancel);

        ButtonPadding.setText("");
        ButtonPadding.setMaximumSize(new java.awt.Dimension(7, 0));
        ButtonPadding.setMinimumSize(new java.awt.Dimension(7, 0));
        ButtonPadding.setPreferredSize(new java.awt.Dimension(7, 0));

        ButtonPanelContentPanel.add(ButtonPadding);

        btnRegister.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnRegister.setMaximumSize(new java.awt.Dimension(32767, 23));
        btnRegister.setMinimumSize(new java.awt.Dimension(90, 23));
        btnRegister.setPreferredSize(new java.awt.Dimension(105, 23));
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
	  if(ProjectManager.get("registrationFinishButtonText")!=null)
	  {
      	btnRegister.setText(replaceUIExpressions(ProjectManager.get("registrationFinishButtonText")));
	  }
	  if(ProjectManager.get("registrationFinishButtonMnemonic")!=null)
	  {
	  	  	if(ProjectManager.get("registrationFinishButtonMnemonic").equalsIgnoreCase("")==false)
	  	  	{
				btnRegister.setMnemonic(ProjectManager.get("registrationFinishButtonMnemonic").charAt(0));
			}
	  }

        ButtonPanelContentPanel.add(btnRegister);
	  }
        ButtonPanel.add(ButtonPanelContentPanel);

        ContentPanel.add(ButtonPanel);

        RootPanel.add(ContentPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(RootPanel, java.awt.BorderLayout.CENTER);
	  if(ProjectManager.get("registrationTextColor")!=null)
	  {
		if(ProjectManager.get("registrationTextColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationTextColor"));
			setFontColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }

	  setButtonTextColor();

	  if(ProjectManager.get("registrationBackgroundColor")!=null)
	  {
		if(ProjectManager.get("registrationBackgroundColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationBackgroundColor"));
			setBackgroundColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }
	  	if(isImageButton==true)
	  	{
	  		setKeyManager();
		}

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        pack();
    }//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
	getRegisterAction();
    }//GEN-LAST:event_btnRegisterActionPerformed

   private void btnImageRegisterMouseClicked(java.awt.event.MouseEvent evt)
   {
	getRegisterAction();
   }

   private void getRegisterAction()
   {
            if(ProjectManager.get("registeredCode").equalsIgnoreCase(tfRegistrationCode.getText().trim())==true)
            {
                    try
                    {
                        dispose();
                        Class.forName("com.trinity.ea.design.registration.actions.RegistrationSuccessUIAction").newInstance();
                    }
                    catch(InstantiationException e)
                    {
                        System.out.println(e);
                    }   
                    catch(IllegalAccessException e)
                    {
                        System.out.println(e);
                    }                      
                    catch(ClassNotFoundException e)
                    {
                        System.out.println(e);
                    }       
            }
            else
            {
                    try
                    {
                        Class.forName("com.trinity.ea.design.registration.actions.RegistrationFailedUIAction").newInstance();
                    }
                    catch(InstantiationException e)
                    {
                        System.out.println(e);
                    }   
                    catch(IllegalAccessException e)
                    {
                        System.out.println(e);
                    }                      
                    catch(ClassNotFoundException e)
                    {
                        System.out.println(e);
                    }       
            }
   }

   private void btnImageCancelMouseClicked(java.awt.event.MouseEvent evt)
   {
	try
	{
		setVisible(false);
		dispose();
		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
   }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed

	try
	{
		setVisible(false);
		dispose();
		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_btnCancelActionPerformed
    
   private Color btnTextColor = null;
   public void setButtonTextColor()
   {
	try
	{
	  if(ProjectManager.get("msgbtnfontclr")!=null)
	  {
		if(ProjectManager.get("msgbtnfontclr").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("msgbtnfontclr"));
			btnTextColor = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());

	  		if(isImageButton==true)
	  		{
				btnImageRegister.setForeground(btnTextColor);
				btnImageCancel.setForeground(btnTextColor);
	  		}
	  		else
	  		{
				btnRegister.setForeground(btnTextColor);
				btnCancel.setForeground(btnTextColor);
	  		}
	  	}
	  }
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
   }

   public void setFontColor(Color fontColor)
   {
	try
	{
		taDescription.setForeground(fontColor);
		lRegistrationCode.setForeground(fontColor);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
   }

   public void setBackgroundColor(Color BGColor)
   {
	try
	{
		ButtonPadding.setBackground(BGColor);
		ButtonPanel.setBackground(BGColor);
		ButtonPanelContentPanel.setBackground(BGColor);
		ButtonPanelTopFiller.setBackground(BGColor);
		ContentPanel.setBackground(BGColor);
		EastPanel.setBackground(BGColor);
		NorthPanel.setBackground(BGColor);
		PreButtonPadding.setBackground(BGColor);
		RegistrationCodePanel.setBackground(BGColor);
		RootPanel.setBackground(BGColor);
		SouthPanel.setBackground(BGColor);
		WestPanel.setBackground(BGColor);
	  	taDescription.setBackground(BGColor);
	  	lRegistrationCode.setBackground(BGColor);
	  	DescriptionPanel.setBackground(BGColor);
	  	DescriptionPanelWestPadding.setBackground(BGColor);
	  	DescriptionPanelEastPadding.setBackground(BGColor);
		lRegistrationCodeLabelWestFiller.setBackground(BGColor);
	  	if(isImageButton==true)
	  	{
			btnImageRegister.setBackground(BGColor);
			btnImageCancel.setBackground(BGColor);
	  	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
   }

    public void paint(Graphics g)
    {
	Graphics2D g2 = (Graphics2D) g;
	g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	super.paint(g);
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

    public void setKeyManager()
    { 
     KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(
        new KeyEventDispatcher() {
            public boolean dispatchKeyEvent(KeyEvent e) 
            {
               
              if (e.getID() == KeyEvent.KEY_PRESSED) 
              {
                   if (e.isAltDown() == true || e.isMetaDown() == true || e.isControlDown()==true) 
                   {   
				armed = true;
			 }
              }            
                // This example converts all typed keys to upper case
              if (e.getID() == KeyEvent.KEY_RELEASED) 
              {
			if(armed==true)
			{
				armed = false;
                        if(e.getComponent().equals(btnImageRegister)==true)
                        {
				    if(e.getKeyCode()==btnImageRegister.getDisplayedMnemonic())
                            {
					getRegisterAction();
				    }
                        }
                        else if(e.getComponent().equals(btnImageCancel)==true)
                        {
				    if(e.getKeyCode()==btnImageCancel.getDisplayedMnemonic())
                            {
					   dispose();
				    }
                        }
			}
              }
              // If the key should not be dispatched to the
              // focused component, set discardEvent to true
              boolean discardEvent = false;
              return discardEvent;
            }
        });       
    }

    private void closeDialog(java.awt.event.WindowEvent evt) 
    {
	try
	{
		setVisible(false);
		dispose();
		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

    private String replaceUIExpressions(String UIStringToReplaceExpressions)
    {
        try
        {
            for(int i = 0;i<updateUIExpressions.length;i++)
            {
                    UIStringToReplaceExpressions = UIStringToReplaceExpressions.replaceAll((String)updateUIExpressions[i],ProjectManager.get((String)updateUIExpressions[i]));
            }
            return UIStringToReplaceExpressions;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    Object[] updateUIExpressions = new Object[7];
    private void updateUIExpressionDefines()
    {
        try
        {
            ArrayList theExpressionDefinesArrayList = new ArrayList();
            if(ProjectManager.get("product_vendor_name")!=null)
            {
                theExpressionDefinesArrayList.add("product_vendor_name");
            }
            if(ProjectManager.get("product_name")!=null)
            {
                theExpressionDefinesArrayList.add("product_name");
            }
            if(ProjectManager.get("product_version")!=null)
            {
                theExpressionDefinesArrayList.add("product_version");
            }
            if(ProjectManager.get("product_info_url")!=null)
            {
                theExpressionDefinesArrayList.add("product_info_url");
            }
            if(ProjectManager.get("product_url")!=null)
            {
                theExpressionDefinesArrayList.add("product_url");
            }
            if(ProjectManager.get("product_privacy_policy_email")!=null)
            {
                theExpressionDefinesArrayList.add("product_privacy_policy_email");
            }
            if(ProjectManager.get("product_copyright")!=null)
            {
                theExpressionDefinesArrayList.add("product_copyright");
            }      
            theExpressionDefinesArrayList.trimToSize();
            updateUIExpressions = theExpressionDefinesArrayList.toArray();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private boolean armed = false;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ButtonPadding;
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JPanel ButtonPanelContentPanel;
    private javax.swing.JPanel ButtonPanelTopFiller;
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JPanel EastPanel;
    private javax.swing.JPanel NorthPanel;
    private javax.swing.JLabel PreButtonPadding;
    private javax.swing.JPanel RegistrationCodePanel;
    private javax.swing.JPanel RootPanel;
    private javax.swing.JPanel SouthPanel;
    private javax.swing.JPanel WestPanel;
    private javax.swing.JPanel DescriptionPanel;
    private javax.swing.JLabel DescriptionPanelWestPadding;
    private javax.swing.JLabel DescriptionPanelEastPadding;
    private ImageButton btnImageCancel;
    private javax.swing.JButton btnCancel;
    private ImageButton btnImageRegister;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel lRegistrationCode;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTextField tfRegistrationCode;
    private javax.swing.JLabel lRegistrationCodeLabelWestFiller;
    // End of variables declaration//GEN-END:variables
    
}
