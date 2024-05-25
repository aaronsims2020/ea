/*
 * CustomerBillingInformationPanel.java
 *
 * Created on October 19, 2003, 9:36 PM
 */

package com.trinity.ea.design.payments.preview;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.payments.preview.data.RandomNumberGenerator;
import com.trinity.ea.design.payments.preview.gui.swing.ErrorDialog;
import com.trinity.ea.design.payments.preview.data.CCStates;
import com.trinity.ea.design.payments.preview.data.CCCountries;
import com.trinity.ea.design.common.preview.net.WebConnectionRequest;
import com.trinity.ea.design.common.preview.actions.UnknownHostExceptionAction;
import com.trinity.ea.parser.HTTPGETRequestParser;
import com.trinity.ea.design.payments.preview.dlgCustomerBillingResponsePanelFailure;
import com.trinity.ea.design.payments.preview.dlgCustomerBillingResponsePanelSuccess;
import com.trinity.ea.design.payments.preview.RefundPolicy;
import com.trinity.ea.util.BrowserLauncher;
import com.trinity.ea.actions.ConfigurationErrorAction;
import com.trinity.ea.idef.IOrderIDGenerator;
import com.trinity.ea.design.payments.preview.gui.swing.ImageButton;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class CustomerBillingInformationPanel extends javax.swing.JPanel {
    private ImageIcon btnFaceCancel = null;
    private ImageIcon btnFaceOnClickCancel = null;
    private ImageIcon btnFaceInFocusCancel = null;
    private ImageIcon btnFaceContinue = null;
    private ImageIcon btnFaceOnClickContinue = null;
    private ImageIcon btnFaceInFocusContinue = null;
    private int btnWidthCancel = -1;
    private int btnHeightCancel = -1;    
    private int btnWidthContinue = -1;
    private int btnHeightContinue = -1;    
    private Color btnBGColor = new Color(233,235,234);
    private boolean isImageButton = false;
    private Color extBorderColor = new Color(162,186,202);
    private Color highlightBorderColor1 = new Color(38,54,69);
    private Color highlightBorderColor2 = new Color(100,132,154);
    private Color shadowBorderColor1 = new Color(162,182,202);
    private Color shadowBorderColor2 = new Color(215,226,233);

    /** Creates new form CustomerBillingInformationPanel */
    public CustomerBillingInformationPanel() {
	updateUIExpressionDefines();
	  if(ProjectManager.get("refundPolicyActionType")!=null)
	  {
	  	if(ProjectManager.get("refundPolicyActionType").equalsIgnoreCase("")==false)
	  	{		
	  		if(ProjectManager.get("refundPolicyAction")!=null)
	  		{
	  			if(ProjectManager.get("refundPolicyAction").equalsIgnoreCase("")==false)
	  			{	
	  	if(ProjectManager.get("refundPolicyActionType").equalsIgnoreCase("1")==true)
	  	{	
					setRefundPolicyAction(new Integer(ProjectManager.get("refundPolicyActionType")).intValue(), "com.trinity.ea.design.payments.actions.RefundPolicyAction");
		}
		else
		{
					setRefundPolicyAction(new Integer(ProjectManager.get("refundPolicyActionType")).intValue(), ProjectManager.get("refundPolicyAction"));
		}
				}
				else
				{
					setRefundPolicyAction(-1,"");
				}
			}
			else
			{
				setRefundPolicyAction(-1,"");
			}
		}
		else
		{
			setRefundPolicyAction(-1,"");
		}
	  }
	  else
	  {
		setRefundPolicyAction(-1,"");
	  }

	  if(ProjectManager.get("btnBarImgButtonsEnabled")!=null)
	  {
	  	if(ProjectManager.get("btnBarImgButtonsEnabled").equalsIgnoreCase("true")==true)
	  	{
			isImageButton=true;
	  		if(ProjectManager.get("paymentImgBackgroundColor")!=null)
	  		{
				if(ProjectManager.get("paymentImgBackgroundColor").equalsIgnoreCase("")==false)
				{
					Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentImgBackgroundColor"));
					btnBGColor = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
				}
	  		}
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

	  if(ProjectManager.get("paymentImgCancelButtonWidth")!=null)
	  {
	  	if(ProjectManager.get("paymentImgCancelButtonWidth").equalsIgnoreCase("")==false)
	  	{
			try
			{
				btnWidthCancel = new Integer(ProjectManager.get("paymentImgCancelButtonWidth")).intValue();
			}
			catch(Exception eee)
			{
				//eee.printStackTrace();
				btnWidthCancel = 94;
			}
		}
		else
		{
			btnWidthCancel = 94;
		}
	  }
	  else
	  {
		btnWidthCancel = 94;
	  }	  
	  if(ProjectManager.get("paymentImgCancelButtonHeight")!=null)
	  {
	  	if(ProjectManager.get("paymentImgCancelButtonHeight").equalsIgnoreCase("")==false)
	  	{
			try
			{
				btnHeightCancel = new Integer(ProjectManager.get("paymentImgCancelButtonHeight")).intValue();
			}
			catch(Exception eee)
			{
				//eee.printStackTrace();
				btnHeightCancel = 31;
			}
		}
		else
		{
			btnHeightCancel = 31;
		}
	  }
	  else
	  {
		btnHeightCancel = 31;
	  }

if(isImageButton==true)
{	  
		if(ProjectManager.get("paymentImgCancelButtonFace")!=null)
		{
			if(ProjectManager.get("paymentImgCancelButtonFace").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceCancel = new javax.swing.ImageIcon(new URL(ProjectManager.get("paymentImgCancelButtonFace")));
				}
				catch(Exception e)
				{
					//e.printStackTrace();
					isImageButton=false;
				}
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
		if(ProjectManager.get("paymentImgCancelButtonFaceOnClick")!=null)
		{
			if(ProjectManager.get("paymentImgCancelButtonFaceOnClick").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceOnClickCancel = new javax.swing.ImageIcon(new URL(ProjectManager.get("paymentImgCancelButtonFaceOnClick")));

				}
				catch(Exception e)
				{
					//e.printStackTrace();
				}
			}
		}
		if(ProjectManager.get("paymentImgCancelButtonFaceInFocus")!=null)
		{
			if(ProjectManager.get("paymentImgCancelButtonFaceInFocus").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceInFocusCancel = new javax.swing.ImageIcon(new URL(ProjectManager.get("paymentImgCancelButtonFaceInFocus")));
				}
				catch(Exception e)
				{
					//e.printStackTrace();
				}
			}
		}
}

	  if(ProjectManager.get("paymentImgContinueButtonWidth")!=null)
	  {
	  	if(ProjectManager.get("paymentImgContinueButtonWidth").equalsIgnoreCase("")==false)
	  	{
			try
			{
				btnWidthContinue = new Integer(ProjectManager.get("paymentImgContinueButtonWidth")).intValue();
			}
			catch(Exception eee)
			{
				//eee.printStackTrace();
				btnWidthContinue = 123;
			}
		}
		else
		{
			btnWidthContinue = 123;
		}
	  }
	  else
	  {
		btnWidthContinue = 123;
	  }	  
	  if(ProjectManager.get("paymentImgContinueButtonHeight")!=null)
	  {
	  	if(ProjectManager.get("paymentImgContinueButtonHeight").equalsIgnoreCase("")==false)
	  	{
			try
			{
				btnHeightContinue = new Integer(ProjectManager.get("paymentImgContinueButtonHeight")).intValue();
			}
			catch(Exception eee)
			{
				//eee.printStackTrace();
				btnHeightContinue = 31;
			}
		}
		else
		{
			btnHeightContinue = 31;
		}
	  }
	  else
	  {
		btnHeightContinue = 31;
	  }	  

if(isImageButton==true)
{
		if(ProjectManager.get("paymentImgContinueButtonFace")!=null)
		{
			if(ProjectManager.get("paymentImgContinueButtonFace").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceContinue = new javax.swing.ImageIcon(new URL(ProjectManager.get("paymentImgContinueButtonFace")));
				}
				catch(Exception e)
				{
					//e.printStackTrace();
					isImageButton=false;
				}
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
		if(ProjectManager.get("paymentImgContinueButtonFaceOnClick")!=null)
		{
			if(ProjectManager.get("paymentImgContinueButtonFaceOnClick").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceOnClickContinue = new javax.swing.ImageIcon(new URL(ProjectManager.get("paymentImgContinueButtonFaceOnClick")));

				}
				catch(Exception e)
				{
					//e.printStackTrace();
				}
			}
		}
		if(ProjectManager.get("paymentImgContinueButtonFaceInFocus")!=null)
		{
			if(ProjectManager.get("paymentImgContinueButtonFaceInFocus").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceInFocusContinue = new javax.swing.ImageIcon(new URL(ProjectManager.get("paymentImgContinueButtonFaceInFocus")));
				}
				catch(Exception e)
				{
					//e.printStackTrace();
				}
			}
		}
}

	  if(btnFaceCancel!=null && btnFaceContinue!=null)
	  {
		if(btnFaceOnClickCancel!=null && btnFaceOnClickContinue!=null)
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
        //lblVerificationCode.setVisible(false);
        //tfVerificationCode.setVisible(false);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents(boolean isImgButton) {//GEN-BEGIN:initComponents
        tfFirstName = new javax.swing.JTextField();
        tfLastName = new javax.swing.JTextField();
        tfEMail = new javax.swing.JTextField();
        tfPhone = new javax.swing.JTextField();
        tfAddress = new javax.swing.JTextField();
        tfCity = new javax.swing.JTextField();
        tfZipCode = new javax.swing.JTextField();
        tfCC1 = new javax.swing.JTextField();
        tfCC2 = new javax.swing.JTextField();
        tfCC3 = new javax.swing.JTextField();
        tfCC4 = new javax.swing.JTextField();
        cbState = new javax.swing.JComboBox();
        cbCountry = new javax.swing.JComboBox();
        PaymentMethod = new javax.swing.JComboBox();
        ExpirationMonth = new javax.swing.JComboBox();
        ExpirationYear = new javax.swing.JComboBox();
        lblFirstName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblEMailAddress = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();
        lblCountry = new javax.swing.JLabel();
        lblZip = new javax.swing.JLabel();
        lblPaymentMethod = new javax.swing.JLabel();
        lblCardNumber = new javax.swing.JLabel();
        lblINTNote = new javax.swing.JLabel();
        lblState = new javax.swing.JLabel();
        lblExpirationMMYY = new javax.swing.JLabel();
        lPaymentInstructions = new javax.swing.JTextArea();
        lblVerificationCode = new javax.swing.JLabel();
        tfVerificationCode = new javax.swing.JTextField();
	  if(isImageButton==true)
	  {
        	btnImageContinue = new ImageButton(btnFaceContinue,btnFaceOnClickContinue,btnFaceInFocusContinue,btnWidthContinue,btnHeightContinue);
        	btnImageCancel = new ImageButton(btnFaceCancel,btnFaceOnClickCancel,btnFaceInFocusCancel,btnWidthCancel,btnHeightCancel);

	  }
	  else
	  {
        	btnContinue = new javax.swing.JButton();
        	btnCancel = new javax.swing.JButton();
	  }

        lblINTNote1 = new javax.swing.JLabel();

        setLayout(null);

	  int compStartHeight = 53;
        setMinimumSize(new java.awt.Dimension(550, 550));
        tfFirstName.setFont(new java.awt.Font("Arial", 0, 14));
        add(tfFirstName);
        tfFirstName.setBounds(163, compStartHeight, 180, 25);

        lblFirstName.setBackground(new java.awt.Color(255, 255, 255));
        lblFirstName.setForeground(new java.awt.Color(38, 54, 69));
        lblFirstName.setFont(new java.awt.Font("Helvetica", 0, 12));
        lblFirstName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFirstName.setLabelFor(tfFirstName);
        lblFirstName.setText(replaceUIExpressions(ProjectManager.get("paymentFirstNameLabel")));
        lblFirstName.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblFirstName.setMaximumSize(new java.awt.Dimension(299, 100));
        lblFirstName.setMinimumSize(new java.awt.Dimension(299, 100));
        lblFirstName.setPreferredSize(new java.awt.Dimension(299, 100));
        add(lblFirstName);
        lblFirstName.setBounds(33, compStartHeight, 100, 25);

        tfLastName.setFont(new java.awt.Font("Arial", 0, 14));
        add(tfLastName);
        tfLastName.setBounds(163, compStartHeight = (compStartHeight + 30), 180, 25);

        lblLastName.setBackground(new java.awt.Color(255, 255, 255));
        lblLastName.setForeground(new java.awt.Color(38, 54, 69));
        lblLastName.setFont(new java.awt.Font("Helvetica", 0, 12));
        lblLastName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLastName.setLabelFor(tfLastName);
        lblLastName.setText(replaceUIExpressions(ProjectManager.get("paymentLastNameLabel")));
        lblLastName.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblLastName.setMaximumSize(new java.awt.Dimension(299, 100));
        lblLastName.setMinimumSize(new java.awt.Dimension(299, 100));
        lblLastName.setPreferredSize(new java.awt.Dimension(299, 100));
        add(lblLastName);
        lblLastName.setBounds(33, compStartHeight, 100, 25);

        tfEMail.setFont(new java.awt.Font("Arial", 0, 14));
        add(tfEMail);
        tfEMail.setBounds(163, compStartHeight = (compStartHeight + 30), 240, 25);

        lblEMailAddress.setBackground(new java.awt.Color(255, 255, 255));
        lblEMailAddress.setFont(new java.awt.Font("Arial", 0, 14));
        lblEMailAddress.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEMailAddress.setLabelFor(tfEMail);
        lblEMailAddress.setText(replaceUIExpressions(ProjectManager.get("paymentEMailLabel")));
        lblEMailAddress.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblEMailAddress.setMaximumSize(new java.awt.Dimension(299, 100));
        lblEMailAddress.setMinimumSize(new java.awt.Dimension(299, 100));
        lblEMailAddress.setPreferredSize(new java.awt.Dimension(299, 100));
        add(lblEMailAddress);
        lblEMailAddress.setBounds(33, compStartHeight, 100, 25);

        tfAddress.setFont(new java.awt.Font("Arial", 0, 14));
        add(tfAddress);
        tfAddress.setBounds(163, compStartHeight = (compStartHeight + 30), 240, 25);

        lblAddress.setBackground(new java.awt.Color(255, 255, 255));
        lblAddress.setFont(new java.awt.Font("Arial", 0, 14));
        lblAddress.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAddress.setLabelFor(tfAddress);
        lblAddress.setText(replaceUIExpressions(ProjectManager.get("paymentStreetLabel")));
        lblAddress.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblAddress.setMaximumSize(new java.awt.Dimension(299, 100));
        lblAddress.setMinimumSize(new java.awt.Dimension(299, 100));
        lblAddress.setPreferredSize(new java.awt.Dimension(299, 100));
        add(lblAddress);
        lblAddress.setBounds(33, compStartHeight, 100, 25);


        tfCity.setFont(new java.awt.Font("Arial", 0, 14));
        add(tfCity);
        tfCity.setBounds(163, compStartHeight = (compStartHeight + 30), 240, 25);

        lblCity.setBackground(new java.awt.Color(255, 255, 255));
        lblCity.setFont(new java.awt.Font("Arial", 0, 14));
        lblCity.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCity.setLabelFor(tfCity);
        lblCity.setText(replaceUIExpressions(ProjectManager.get("paymentCityLabel")));
        lblCity.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblCity.setMaximumSize(new java.awt.Dimension(299, 100));
        lblCity.setMinimumSize(new java.awt.Dimension(299, 100));
        lblCity.setPreferredSize(new java.awt.Dimension(299, 100));
        add(lblCity);
        lblCity.setBounds(33, compStartHeight, 100, 25);

        cbState.setBackground(new java.awt.Color(255, 255, 255));
        cbState.setFont(new java.awt.Font("Arial", 0, 14));
        cbState.setMaximumRowCount(12);
        cbState.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "INT", "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "DC", "Florida", "Georgia", "Hawaii", "Iowa", "Idaho", "Illinois", "Indiana", "Kansas", "Kentucky", "Louisiana", "Massachusetts", "Maryland", "Maine", "Michigan", "Mississippi", "Missouri", "Montana", "North Carolina", "North Dakota", "Nebraska", "New Hampshire", "New Jersey", "New Mexico", "Nevada", "New York", "Oklahoma", "Oregon", "Ohio", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Virginia", "Vermont", "Washington", "Wisconsin", "West Virginia", "Wyoming" }));
        cbState.setSelectedIndex(1);
        add(cbState);
        cbState.setBounds(163, compStartHeight = (compStartHeight + 30), 180, 25);

        lblState.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblState.setLabelFor(cbState);
        lblState.setFont(new java.awt.Font("Arial", 0, 14));
        lblState.setText(replaceUIExpressions(ProjectManager.get("paymentStateLabel")));
        lblState.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblState.setMaximumSize(new java.awt.Dimension(299, 100));
        lblState.setMinimumSize(new java.awt.Dimension(299, 100));
        lblState.setPreferredSize(new java.awt.Dimension(299, 100));
        add(lblState);
        lblState.setBounds(33, compStartHeight, 100, 25);

        lblINTNote.setBackground(new java.awt.Color(255, 255, 255));
        lblINTNote.setFont(new java.awt.Font("Arial", 0, 14));
        lblINTNote.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblINTNote.setText(replaceUIExpressions(ProjectManager.get("paymentOrdersOutsideUSLabel")));
        lblINTNote.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblINTNote.setMaximumSize(new java.awt.Dimension(299, 100));
        lblINTNote.setMinimumSize(new java.awt.Dimension(299, 100));
        lblINTNote.setPreferredSize(new java.awt.Dimension(299, 100));
        add(lblINTNote);
        lblINTNote.setBounds(353, compStartHeight, 180, 25);

        tfZipCode.setFont(new java.awt.Font("Arial", 0, 14));
        add(tfZipCode);
        tfZipCode.setBounds(163, compStartHeight = (compStartHeight + 30), 180, 25);

        lblZip.setBackground(new java.awt.Color(255, 255, 255));
        lblZip.setFont(new java.awt.Font("Arial", 0, 14));
        lblZip.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblZip.setLabelFor(tfZipCode);
        lblZip.setText(replaceUIExpressions(ProjectManager.get("paymentZipCodeLabel")));
        lblZip.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblZip.setMaximumSize(new java.awt.Dimension(299, 100));
        lblZip.setMinimumSize(new java.awt.Dimension(299, 100));
        lblZip.setPreferredSize(new java.awt.Dimension(299, 100));
        add(lblZip);
        lblZip.setBounds(33, compStartHeight, 100, 25);

        cbCountry.setBackground(new java.awt.Color(255, 255, 255));
        cbCountry.setFont(new java.awt.Font("Arial", 0, 14));
        cbCountry.setMaximumRowCount(12);
        cbCountry.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaidjan", "Bahamas", "Bahrain", "Banglades", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bolivia", "Bosnia-Herzegovina", "Botswana", "Bouvet Island", "Brazil", "British Indian O. Terr.", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Buthan", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Rep.", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Isl.", "Columbia", "Comoros", "Congo", "Cook Islands", "Costa Rica", "Croatia", "Cyprus", "Czech Republic", "Czechoslovakia", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Estonia", "Ethiopia", "Falkland Isl.(Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France (European Ter.)", "French Southern Terr.", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Great Britain (UK)", "Greece", "Greenland", "Grenada", "Guadeloupe (Fr.)", "Guam (US)", "Guatemala", "Guinea", "Guinea Bissau", "Guyana", "Guyana (Fr.)", "Haiti", "Heard & McDonald Isl.", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iraq", "Ireland", "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazachstan", "Kenya", "Kirgistan", "Kiribati", "Korea (North)", "Korea (South)", "Kuwait", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique (Fr.)", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldavia", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherland Antilles", "Netherlands", "Neutral Zone", "New Caledonia (Fr.)", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Isl.", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Polynesia (Fr.)", "Portugal", "Puerto Rico (US)", "Qatar", "Reunion (Fr.)", "Romania", "Russian Federation", "Rwanda", "Saint Lucia", "Samoa", "San Marino", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovak Republic", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "Soviet Union", "Spain", "Sri Lanka", "St. Helena", "St. Pierre & Miquelon", "St. Tome and Principe", "St.Kitts Nevis Anguilla", "St.Vincent & Grenadines", "Sudan", "Suriname", "Svalbard & Jan Mayen Is", "Swaziland", "Sweden", "Switzerland", "Syria", "Tadjikistan", "Taiwan", "Tanzania", "Thailand", "Togo", "Tokelau", "Tonga", "Tonga", "Trinidad & Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks & Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Unknown Country", "Uruguay", "US Minor outlying Isl.", "Uzbekistan", "Vanuatu", "Vatican City State", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (US)", "Wallis & Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zaire", "Zambia", "Zimbabwe" }));
        cbCountry.setSelectedIndex(220);
        cbCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCountryActionPerformed(evt);
            }
        });

        add(cbCountry);
        cbCountry.setBounds(163, compStartHeight = (compStartHeight + 30), 180, 25);

        lblCountry.setBackground(new java.awt.Color(255, 255, 255));
        lblCountry.setFont(new java.awt.Font("Arial", 0, 14));
        lblCountry.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCountry.setLabelFor(cbCountry);
        lblCountry.setText(replaceUIExpressions(ProjectManager.get("paymentCountryLabel")));
        lblCountry.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblCountry.setMaximumSize(new java.awt.Dimension(299, 100));
        lblCountry.setMinimumSize(new java.awt.Dimension(299, 100));
        lblCountry.setPreferredSize(new java.awt.Dimension(299, 100));
        add(lblCountry);
        lblCountry.setBounds(33, compStartHeight, 100, 25);


if(ProjectManager.get("paymentPhoneInputEnabled")!=null)
{
	if(ProjectManager.get("paymentPhoneInputEnabled").equalsIgnoreCase("true")==true)
	{
        tfPhone.setFont(new java.awt.Font("Arial", 0, 14));
        add(tfPhone);
        tfPhone.setBounds(163, compStartHeight = (compStartHeight + 30), 240, 25);

        lblPhone.setBackground(new java.awt.Color(255, 255, 255));
        lblPhone.setFont(new java.awt.Font("Arial", 0, 14));
        lblPhone.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPhone.setLabelFor(tfPhone);
        lblPhone.setText(replaceUIExpressions(ProjectManager.get("paymentPhoneLabel")));
        lblPhone.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblPhone.setMaximumSize(new java.awt.Dimension(299, 100));
        lblPhone.setMinimumSize(new java.awt.Dimension(299, 100));
        lblPhone.setPreferredSize(new java.awt.Dimension(299, 100));
        add(lblPhone);
        lblPhone.setBounds(33, compStartHeight, 100, 25);
	}
}


        PaymentMethod.setBackground(new java.awt.Color(255, 255, 255));
        PaymentMethod.setFont(new java.awt.Font("Arial", 0, 14));
        PaymentMethod.setMaximumRowCount(12);
	  if(ProjectManager.get("paymentMethods")!=null)
	  {
		Object[] theObjArray = getStringArraysFromString(ProjectManager.get("paymentMethods"));
		String[] theStrArray = new String[theObjArray.length];
		for(int i = 0;i<theObjArray.length;i++)
		{
			theStrArray[i] = (String)theObjArray[i];
		}
		PaymentMethod.setModel(new javax.swing.DefaultComboBoxModel(theStrArray));
	  }
	  else
	  {
        	PaymentMethod.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Visa", "Mastercard", "Discovery", "American Express" }));
 	  }
        add(PaymentMethod);
        PaymentMethod.setBounds(163, compStartHeight = (compStartHeight + 30), 140, 25);

        lblPaymentMethod.setBackground(new java.awt.Color(255, 255, 255));
        lblPaymentMethod.setFont(new java.awt.Font("Arial", 0, 14));
        lblPaymentMethod.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPaymentMethod.setLabelFor(PaymentMethod);
        lblPaymentMethod.setText(replaceUIExpressions(ProjectManager.get("paymentPaymentMethodLabel")));
        lblPaymentMethod.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblPaymentMethod.setMaximumSize(new java.awt.Dimension(299, 100));
        lblPaymentMethod.setMinimumSize(new java.awt.Dimension(299, 100));
        lblPaymentMethod.setPreferredSize(new java.awt.Dimension(299, 100));
        add(lblPaymentMethod);
        lblPaymentMethod.setBounds(33, compStartHeight, 120, 25);
        lblVerificationCode.setBackground(new java.awt.Color(255, 255, 255));
        lblVerificationCode.setFont(new java.awt.Font("Arial", 0, 14));
        lblVerificationCode.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVerificationCode.setLabelFor(tfVerificationCode);
        lblVerificationCode.setText(replaceUIExpressions(ProjectManager.get("paymentVerificationCodeLabel")));
        lblVerificationCode.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblVerificationCode.setMaximumSize(new java.awt.Dimension(299, 100));
        lblVerificationCode.setMinimumSize(new java.awt.Dimension(299, 100));
        lblVerificationCode.setPreferredSize(new java.awt.Dimension(299, 100));
        add(lblVerificationCode);
        lblVerificationCode.setBounds(323, compStartHeight, 120, 25);

        tfVerificationCode.setFont(new java.awt.Font("Arial", 0, 14));
        add(tfVerificationCode);
        tfVerificationCode.setBounds(443, compStartHeight, 50, 25);


	if(ProjectManager.get("paymentCCVerificationCodeEnabled")!=null)
	{
		if(ProjectManager.get("paymentCCVerificationCodeEnabled").equalsIgnoreCase("true")==true)
		{
			setVerificationCodeObjectIsVisible(true);
		}
		else
		{
			setVerificationCodeObjectIsVisible(false);
		}
	}
	else
	{
		setVerificationCodeObjectIsVisible(false);
    	}
        lPaymentInstructions.setText(replaceUIExpressions(ProjectManager.get("paymentInstructionsLine1")));
        lPaymentInstructions.setEditable(false);
	  lPaymentInstructions.setWrapStyleWord(true);
	  lPaymentInstructions.setLineWrap(true);	  
	  lPaymentInstructions.setOpaque(false);
        add(lPaymentInstructions);
        lPaymentInstructions.setBounds(33, 8, 490, 35);

        lblCardNumber.setBackground(new java.awt.Color(255, 255, 255));
        lblCardNumber.setFont(new java.awt.Font("Arial", 0, 14));
        lblCardNumber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCardNumber.setLabelFor(tfCC1);
        lblCardNumber.setText(replaceUIExpressions(ProjectManager.get("paymentCCLabel")));
        lblCardNumber.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblCardNumber.setMaximumSize(new java.awt.Dimension(299, 100));
        lblCardNumber.setMinimumSize(new java.awt.Dimension(299, 100));
        lblCardNumber.setPreferredSize(new java.awt.Dimension(299, 100));
        add(lblCardNumber);
        lblCardNumber.setBounds(33, compStartHeight = (compStartHeight + 30), 100, 25);

        tfCC1.setFont(new java.awt.Font("Arial", 0, 14));
        add(tfCC1);
        tfCC1.setBounds(163, compStartHeight, 50, 25);

        tfCC2.setFont(new java.awt.Font("Arial", 0, 14));
        add(tfCC2);
        tfCC2.setBounds(223, compStartHeight, 50, 25);

        tfCC3.setFont(new java.awt.Font("Arial", 0, 14));
        add(tfCC3);
        tfCC3.setBounds(283, compStartHeight, 50, 25);

        tfCC4.setFont(new java.awt.Font("Arial", 0, 14));
        add(tfCC4);
        tfCC4.setBounds(343, compStartHeight, 50, 25);

if(ProjectManager.get("refundPolicyEnabled")!=null)
{
   if(ProjectManager.get("refundPolicyEnabled").equalsIgnoreCase("true")==true)
   {  
	  if(ProjectManager.get("refundPolicyLinkTextColor")!=null)
	  {
		if(ProjectManager.get("refundPolicyLinkTextColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("refundPolicyLinkTextColor"));
			lblINTNote1.setForeground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }
        lblINTNote1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT); 
        lblINTNote1.setText(replaceUIExpressions(ProjectManager.get("paymentRefundPolicyLabel")));
        try
        {
            if(intActionType!=-1)
            {
                lblINTNote1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        lblINTNote1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblINTNote1.setMaximumSize(new java.awt.Dimension(299, 100));
        lblINTNote1.setMinimumSize(new java.awt.Dimension(299, 100));
        lblINTNote1.setPreferredSize(new java.awt.Dimension(299, 100));
        lblINTNote1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblINTNote1MouseClicked(evt);
            }
        });

        add(lblINTNote1);
        lblINTNote1.setBounds(413, compStartHeight, 100, 25);
   }
} 

        ExpirationMonth.setBackground(new java.awt.Color(255, 255, 255));
        ExpirationMonth.setFont(new java.awt.Font("Arial", 0, 14));
        ExpirationMonth.setMaximumRowCount(12);
        ExpirationMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        add(ExpirationMonth);
        ExpirationMonth.setBounds(163, compStartHeight = (compStartHeight + 30), 50, 25);

        ExpirationYear.setBackground(new java.awt.Color(255, 255, 255));
        ExpirationYear.setFont(new java.awt.Font("Arial", 0, 14));
        ExpirationYear.setMaximumRowCount(12);
        ExpirationYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99" }));
        ExpirationYear.setSelectedIndex(1);
        add(ExpirationYear);
        ExpirationYear.setBounds(223, compStartHeight, 50, 25);

        lblExpirationMMYY.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblExpirationMMYY.setLabelFor(ExpirationMonth);
        lblExpirationMMYY.setFont(new java.awt.Font("Arial", 0, 14));
        lblExpirationMMYY.setText(replaceUIExpressions(ProjectManager.get("paymentExpMMYYLabel")));
        lblExpirationMMYY.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblExpirationMMYY.setMaximumSize(new java.awt.Dimension(299, 100));
        lblExpirationMMYY.setMinimumSize(new java.awt.Dimension(299, 100));
        lblExpirationMMYY.setPreferredSize(new java.awt.Dimension(299, 100));
        add(lblExpirationMMYY);
        lblExpirationMMYY.setBounds(33, compStartHeight, 120, 25);

	  if(isImageButton==true)
	  {
	  	 if(ProjectManager.get("paymentButtonFont")!=null)
	  	 {
	  		if(ProjectManager.get("paymentButtonFont").equalsIgnoreCase("")==false)
			{
				Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentButtonFont"));
      			btnImageCancel.setFont(new java.awt.Font((String)tmpArray[0], new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
				btnImageContinue.setFont(new java.awt.Font((String)tmpArray[0], new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
	  	  }

        	  btnImageCancel.setMaximumSize(new java.awt.Dimension(btnWidthCancel, btnHeightCancel));
       	  btnImageCancel.setMinimumSize(new java.awt.Dimension(btnWidthCancel, btnHeightCancel));
       	  btnImageCancel.setPreferredSize(new java.awt.Dimension(btnWidthCancel, btnHeightCancel));
      	  btnImageCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImageCancelMouseClicked(evt);
            }
        });

	  	  if(ProjectManager.get("paymentCancelButtonText")!=null)
	  	  {
     			btnImageCancel.setText(replaceUIExpressions(ProjectManager.get("paymentCancelButtonText")));
	  	  }
	  	  if(ProjectManager.get("paymentCancelButtonMnemonic")!=null)
	  	  {
	  	  	if(ProjectManager.get("paymentCancelButtonMnemonic").equalsIgnoreCase("")==false)
	  	  	{
	 			btnImageCancel.setMnemonic(ProjectManager.get("paymentCancelButtonMnemonic").charAt(0));
  	  	  	}
		  }

        add(btnImageCancel);
        btnImageCancel.setBounds(413, compStartHeight, btnWidthCancel, btnHeightCancel);

      	  btnImageContinue.setMaximumSize(new java.awt.Dimension(btnWidthContinue, btnHeightContinue));
     	   	  btnImageContinue.setMinimumSize(new java.awt.Dimension(btnWidthContinue, btnHeightContinue));
     		  btnImageContinue.setPreferredSize(new java.awt.Dimension(btnWidthContinue, btnHeightContinue));
      	  btnImageContinue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImageContinueMouseClicked(evt);
            }
        });
	  	if(ProjectManager.get("paymentContinueButtonText")!=null)
	  	{
      		btnImageContinue.setText(replaceUIExpressions(ProjectManager.get("paymentContinueButtonText")));
	 	}
	  	if(ProjectManager.get("paymentContinueButtonMnemonic")!=null)
	  	{
	  	  	if(ProjectManager.get("paymentContinueButtonMnemonic").equalsIgnoreCase("")==false)
	  	  	{
				btnImageContinue.setMnemonic(ProjectManager.get("paymentContinueButtonMnemonic").charAt(0));
			}
	  	}

        	add(btnImageContinue);
        	btnImageContinue.setBounds(283, compStartHeight, btnWidthContinue, btnHeightContinue);
	  }
	  else
	  {
	  if(ProjectManager.get("paymentButtonFont")!=null)
	  {
	  	if(ProjectManager.get("paymentButtonFont").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentButtonFont"));
      		btnCancel.setFont(new java.awt.Font((String)tmpArray[0], new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			btnContinue.setFont(new java.awt.Font((String)tmpArray[0], new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }

	  	if(ProjectManager.get("paymentContinueButtonText")!=null)
	  	{
      		btnContinue.setText(replaceUIExpressions(ProjectManager.get("paymentContinueButtonText")));
	 	}
	  	if(ProjectManager.get("paymentContinueButtonMnemonic")!=null)
	  	{
	  	  	if(ProjectManager.get("paymentContinueButtonMnemonic").equalsIgnoreCase("")==false)
	  	  	{
				btnContinue.setMnemonic(ProjectManager.get("paymentContinueButtonMnemonic").charAt(0));
			}
	  	}
        btnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinueActionPerformed(evt);
            }
        });

        add(btnContinue);
        btnContinue.setBounds(283, compStartHeight, 120, 26);

	  	  if(ProjectManager.get("paymentCancelButtonText")!=null)
	  	  {
     			btnCancel.setText(replaceUIExpressions(ProjectManager.get("paymentCancelButtonText")));
	  	  }
	  	  if(ProjectManager.get("paymentCancelButtonMnemonic")!=null)
	  	  {
	  	  	if(ProjectManager.get("paymentCancelButtonMnemonic").equalsIgnoreCase("")==false)
	  	  	{
	 			btnCancel.setMnemonic(ProjectManager.get("paymentCancelButtonMnemonic").charAt(0));
			}
  	  	  }
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        add(btnCancel);
        btnCancel.setBounds(413, compStartHeight, 90, 26);

	  }


// Added Component Border Method 6/26/2004
	  //setComponentBorders();

	  if(ProjectManager.get("paymentLabelTextFont")!=null)
	  {
		if(ProjectManager.get("paymentLabelTextFont").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentLabelTextFont"));
			setLabelTextFont(new java.awt.Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }
	  if(ProjectManager.get("paymentLabelTextColor")!=null)
	  {
		if(ProjectManager.get("paymentLabelTextColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentLabelTextColor"));
			setLabelTextColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }
	  if(ProjectManager.get("paymentBackgroundColor")!=null)
	  {
		if(ProjectManager.get("paymentBackgroundColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentBackgroundColor"));
			setBackgroundColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }
	  if(ProjectManager.get("paymentButtonTextColor")!=null)
	  {
		if(ProjectManager.get("paymentButtonTextColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentButtonTextColor"));
			setButtonTextColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }
// End Added Code 6/26/2004
	  	if(isImageButton==true)
	  	{
	  		setKeyManager();
		}
    }//GEN-END:initComponents

    private void lblINTNote1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblINTNote1MouseClicked
       if(intActionType == 0)
        {
            try
            {
                 BrowserLauncher.openURL(actionPackage);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(intActionType == 1)
        {
            try
            {
                Class.forName(actionPackage).newInstance();
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
        }

    }//GEN-LAST:event_lblINTNote1MouseClicked

    public void setComponentBorders()
    {
//
	try
	{
	  if(ProjectManager.get("registrationCustomBorderEnabled")!=null)
	  {
		if(ProjectManager.get("registrationCustomBorderEnabled").equalsIgnoreCase("true")==true)
		{

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
    	  final Border border = new javax.swing.border.CompoundBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(1, 0, 1, 1), extBorderColor), new javax.swing.border.CompoundBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 1, 1), shadowBorderColor2), new javax.swing.border.MatteBorder(new java.awt.Insets(1, 1, 0, 0), highlightBorderColor2))), new javax.swing.border.CompoundBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 1, 1), shadowBorderColor1), new javax.swing.border.MatteBorder(new java.awt.Insets(1, 1, 0, 0), highlightBorderColor1)));     
        
tfAddress.setBorder(border);
tfCC1.setBorder(border);
tfCC2.setBorder(border);
tfCC3.setBorder(border);
tfCC4.setBorder(border);
tfCity.setBorder(border);
tfEMail.setBorder(border);
tfPhone.setBorder(border);
tfFirstName.setBorder(border);
tfLastName.setBorder(border);
tfVerificationCode.setBorder(border);
tfZipCode.setBorder(border);
ExpirationMonth.setBorder(border);
ExpirationYear.setBorder(border);
PaymentMethod.setBorder(border);
cbCountry.setBorder(border);
cbState.setBorder(border);
		}
	  }
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

    private void setBackgroundColor(Color BGColor)
    {
try
{
setOpaque(true);
setBackground(BGColor);
lPaymentInstructions.setBackground(BGColor);
lblAddress.setBackground(BGColor);
lblCardNumber.setBackground(BGColor);
lblCity.setBackground(BGColor);
lblCountry.setBackground(BGColor);
lblPhone.setBackground(BGColor);
lblEMailAddress.setBackground(BGColor);
lblExpirationMMYY.setBackground(BGColor);
lblFirstName.setBackground(BGColor);
lblINTNote.setBackground(BGColor);
lblINTNote1.setBackground(BGColor);
lblLastName.setBackground(BGColor);
lblPaymentMethod.setBackground(BGColor);
lblState.setBackground(BGColor);
lblVerificationCode.setBackground(BGColor);
lblZip.setBackground(BGColor);
		if(isImageButton==true)
		{
	
			btnImageContinue.setBackground(btnBGColor);
			btnImageCancel.setBackground(btnBGColor);
		}
}
catch(Exception e)
{
	e.printStackTrace();
} 
   }
    private void setLabelTextFont(Font LFont)
    {
lPaymentInstructions.setFont(LFont);
lblAddress.setFont(LFont);
lblCardNumber.setFont(LFont);
lblCity.setFont(LFont);
lblCountry.setFont(LFont);
lblPhone.setFont(LFont);
lblEMailAddress.setFont(LFont);
lblExpirationMMYY.setFont(LFont);
lblFirstName.setFont(LFont);
lblINTNote.setFont(LFont);
lblINTNote1.setFont(LFont);
lblLastName.setFont(LFont);
lblPaymentMethod.setFont(LFont);
lblState.setFont(LFont);
lblVerificationCode.setFont(LFont);
lblZip.setFont(LFont);
    }

    private void setLabelTextColor(Color LColor)
    {
lPaymentInstructions.setForeground(LColor);
lblAddress.setForeground(LColor);
lblCardNumber.setForeground(LColor);
lblCity.setForeground(LColor);
lblCountry.setForeground(LColor);
lblPhone.setForeground(LColor);
lblEMailAddress.setForeground(LColor);
lblExpirationMMYY.setForeground(LColor);
lblFirstName.setForeground(LColor);
lblINTNote.setForeground(LColor);
lblINTNote1.setForeground(LColor);
lblLastName.setForeground(LColor);
lblPaymentMethod.setForeground(LColor);
lblState.setForeground(LColor);
lblVerificationCode.setForeground(LColor);
lblZip.setForeground(LColor);
    }

    private void setButtonTextColor(Color FGColor)
    {
	try
	{
		if(isImageButton==true)
		{
	
			btnImageContinue.setForeground(FGColor);
			btnImageCancel.setForeground(FGColor);
		}
		else
		{
			btnContinue.setForeground(FGColor);
			btnCancel.setForeground(FGColor);
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

   private void btnImageCancelMouseClicked(java.awt.event.MouseEvent evt)
   {
	getCancelAction();
   }

private void getCancelAction()
{
        JDialog theDialog=(JDialog)this.getTopLevelAncestor();
        theDialog.dispose();
				try
				{
					UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
				}
				catch(Exception e)
				{

				}
}

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
	getCancelAction();
    }//GEN-LAST:event_btnCancelActionPerformed

   private void btnImageContinueMouseClicked(java.awt.event.MouseEvent evt)
   {
	try
	{	
		getSubmitRequest();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
   }

    private int intActionType = -1;
    private String actionPackage = null;
    public void setRefundPolicyAction(int actionType, String strActionLink)
    {
        intActionType = actionType;
        actionPackage = strActionLink;
    }     


    private void btnContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinueActionPerformed
	try
	{	
		getSubmitRequest();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_btnContinueActionPerformed


   private void getSubmitRequest()
   {
	String authRes = "";
     if(validateData()==true)
        {
            // EMail Validation Code
            String emailAddress = null;
            String phone = null;
            String firstNameID = null;
            String lastNameID = null;
            String streetAddr = null;
            String cityAddr = null;
            String zipAddr = null;
            String cc1ID = null;
            String cc2ID = null;        
            String cc3ID = null;
            String cc4ID = null;  
            String verifCode = null;
            try
            {
                firstNameID=getFirstName();
            }
            catch(NullPointerException e)
            {
			e.printStackTrace();
            }
            try
            {
                lastNameID=getLastName();
            }
            catch(NullPointerException e)
            {
			e.printStackTrace();
            }        
            try
            {
                phone = getPhone();
            }
            catch(NullPointerException e)
            {
			e.printStackTrace();
            }
            try
            {
                emailAddress = getEMailName();
            }
            catch(NullPointerException e)
            {
			e.printStackTrace();
            }
            try
            {
                streetAddr=getAddress();
            }
            catch(NullPointerException e)
            {
			e.printStackTrace();
            }
            try
            {
                cityAddr=getCity();
            }
            catch(NullPointerException e)
            {
			e.printStackTrace();
            }
            try
            {
                zipAddr=getZip();
            }
            catch(NullPointerException e)
            {
			e.printStackTrace();
            }        
            try
            {
                cc1ID=getCC1();
                cc2ID=getCC2();
                cc3ID=getCC3();
                cc4ID=getCC4();
            }
            catch(NullPointerException e)
            {
			e.printStackTrace();
            }        

            try
            {
                if(getVerificationCodeObjectIsVisible()==true)
                {
                    verifCode=getVerificationCode();
                }
            }
            catch(NullPointerException e)
            {
			e.printStackTrace();
            }        
            String formRequestMethod = null;
            if(ProjectManager.get("formRequestMethod") != null)
            {
                formRequestMethod = ProjectManager.get("formRequestMethod");
            }

            /* Handle HTTP Requests now */
            if(formRequestMethod.equalsIgnoreCase("GET")==true)
            {
                //System.out.println("The get request: " + getHTTPRequest());
                try
                {

                    URL theURL1 = new URL(getHTTPRequest());
                    WebConnectionRequest wcr = new WebConnectionRequest();
                    Map responseDataMap = wcr.doWebGetRequest(theURL1);
                    Map refreshResponseDataMap;
                    //System.out.println("MAP DATA: " + responseDataMap);
                       //System.out.println("supportMetaRefreshEnabled=" + ProjectManager.get("supportMetaRefreshEnabled"));

                    if(ProjectManager.get("supportMetaRefreshEnabled") != null)
                    {
                        //System.out.println("supportMetaRefreshEnabled=" + ProjectManager.get("supportMetaRefreshEnabled"));
                        /* if the GET Request return HTML returns a Meta Refresh tag follow through with Refresh timeout, and connection. */
 if(Boolean.valueOf(ProjectManager.get("supportMetaRefreshEnabled")).booleanValue()==true)
                        {

                            if(responseDataMap.get("refreshenabled")!=null)
                            {

                                if(((String)responseDataMap.get("refreshenabled")).equalsIgnoreCase("true")==true)
                                {

                                    /* Wait the elapsed time before refresh follow through */
                                    if(responseDataMap.get("refreshwait")!=null)
                                    {

                                    }
                                     /* load the following URL*/
                                    if(responseDataMap.get("refreshurl")!=null)
                                    {          

                                        refreshResponseDataMap = wcr.doWebGetRequest(new URL(((String)responseDataMap.get("refreshurl"))));
                                        //System.out.println("Refresh Response Map: \r\n" + refreshResponseDataMap);
 HTTPGETRequestParser grp = new HTTPGETRequestParser((String)responseDataMap.get("refreshurl"));

                                        Map valueMap = grp.getRequestMap();

                                        //System.out.println("Parsed Response Value Map: \r\n" + valueMap);  
                                        if(valueMap.get(ProjectManager.get("respInputStatus"))!=null)
                                        {   //1 = Success

                                            if(((String)valueMap.get(ProjectManager.get("respInputStatus"))).equalsIgnoreCase("1")==true)
                                            {

                                               JDialog theDialog=(JDialog)this.getTopLevelAncestor();
                                                theDialog.dispose();
                                                new dlgCustomerBillingResponsePanelSuccess(valueMap,new javax.swing.JFrame(), true).show(); 

                                                //TODO: Create a method in object and pass in Map data then fill in labels.
                                            }//0 = Failure
                                            else if(((String)valueMap.get(ProjectManager.get("respInputStatus"))).equalsIgnoreCase("0")==true)
                                            {

                                                //Count the Failure Attempts for Lockdown on max attempts exceeded.
                                                //ProjectManager.attemptPayment();

                                                JDialog theDialog=(JDialog)this.getTopLevelAncestor();

                                                theDialog.dispose();

                                                new dlgCustomerBillingResponsePanelFailure(valueMap,new javax.swing.JFrame(), true).show();
                                               //TODO: Create a method in object and pass in Map data then fill in labels.
                                            }                                       
                                        }
                                    }
                                }
                            }
                        }
                    } 
                    /* add second call to http connection based on return data.. */ 

                }
                catch(NullPointerException eeeee)
                {
                    //System.out.println(eeeee);
                    eeeee.printStackTrace();
                    //skip this, becuase it is currently thrown by the ResponseMap Objects when not connected to the internet, or server. Fix the logic and error handling later on. 
                }
                catch(MalformedURLException e){
                    if(ProjectManager.get("unknownHostExceptionAction")!=null)
                    {
                        try
                        {
                            Class.forName("com.trinity.ea.design.common.preview.actions.UnknownHostExceptionAction").newInstance();
                        }
                        catch(InstantiationException ee)
                        {
                            System.out.println(ee);
                        }   
                        catch(IllegalAccessException eee)
                        {
                            System.out.println(eee);
                        }                      
                        catch(ClassNotFoundException eeee)
                        {
                            System.out.println(eeee);
                        }       
                    }
                    else
                    {
                        //Problem in Properties File
                    }
}
catch(Exception e)
{
e.printStackTrace();
}
            }
            else if(formRequestMethod.equalsIgnoreCase("POST")==true)
            {
                //System.out.println(getHTTPRequest());
                try
                {
                    URL theURL1 = null;
                    if(ProjectManager.get("formActionURL")!=null)
                    {
                        theURL1 = new URL(ProjectManager.get("formActionURL"));
                    }
                    WebConnectionRequest wcr = new WebConnectionRequest();
                    //System.out.println("The URL: " + theURL1.toString());
                    //System.out.println(getHTTPRequest());
                    Map responseDataMap = wcr.doWebPostRequest(theURL1,getHTTPRequest());
                    //System.out.println("MAP DATA: " + responseDataMap);
			boolean boolRespInputStatusSuccess = false;
			// Extract the Response values...
			  if(responseDataMap.get("source")!=null)
			  {
				if(((String)responseDataMap.get("source")).equalsIgnoreCase("")==false)
				{
			  		String HTMLDoc = (String)responseDataMap.get("source");
					//System.out.println("HTML Document: " + HTMLDoc);
					if(ProjectManager.get("paymentResponseInputStatusSuccess")!=null)
					{
						if(ProjectManager.get("paymentResponseInputStatusSuccess").equalsIgnoreCase("")==false)
						{
							if(HTMLDoc.indexOf(ProjectManager.get("paymentResponseInputStatusSuccess"))!=-1)
							{
								boolRespInputStatusSuccess = true;
								try
								{
									authRes = ProjectManager.get("paymentGenericAuthResponseSuccessMsg");
								}
								catch(Exception e)
								{}
							}
							else
							{
								boolRespInputStatusSuccess = false;
								try
								{
									authRes = getAuthResponseMessage(HTMLDoc);
								}
								catch(Exception e)
								{}
							}
						}
						else
						{
							boolRespInputStatusSuccess = false;
								try
								{
									authRes = getAuthResponseMessage(HTMLDoc);
								}
								catch(Exception e)
								{}
						}
					}
					else
					{
						boolRespInputStatusSuccess = false;
								try
								{
									authRes = getAuthResponseMessage(HTMLDoc);
								}
								catch(Exception e)
								{}
					}

				}
				else
				{		
					// Error response
					boolRespInputStatusSuccess = false;
				}
			  }
			  else
			  {
				// Error Response
				boolRespInputStatusSuccess = false;
			  }



			  // End Extract Response values.
 			  HTTPGETRequestParser grp = new HTTPGETRequestParser(getHTTPRequest());
                    Map valueMap = grp.getRequestMap();
			  try
			  {
			  	valueMap.put(ProjectManager.get("respInputOrderID"), (String)valueMap.get(ProjectManager.get("inputNameOrderID")));
			  }
			  catch(Exception e)
			  {
				e.printStackTrace();
			  }
			  try
			  {
			  	valueMap.put(ProjectManager.get("respInputTotal"), getTotalPrice());
			  }
			  catch(Exception e)
			  {
				e.printStackTrace();
			  }
                    //System.out.println("Parsed Response Value Map: \r\n" + valueMap);  
			  //1 = Success
	              if(boolRespInputStatusSuccess==true)
                    {
				try
				{
				if(authRes.equalsIgnoreCase("")==true)
				{
					try
					{
						authRes = ProjectManager.get("paymentGenericAuthResponseSuccessMsg");
					}
					catch(Exception e)
					{}
				}
			  	valueMap.put(ProjectManager.get("respInputAuthResponse"),authRes);
				}
				catch(Exception e)
				{
				}
                          JDialog theDialog=(JDialog)this.getTopLevelAncestor();
                          theDialog.dispose();
                          new dlgCustomerBillingResponsePanelSuccess(valueMap,new javax.swing.JFrame(), true).show(); 
                          //TODO: Create a method in object and pass in Map data then fill in labels.
                    }//0 = Failure
                    else if(boolRespInputStatusSuccess==false)
                    {
				if(authRes!=null)
				{
					if(authRes.equalsIgnoreCase("")==true)
					{
						try
						{
							authRes = ProjectManager.get("paymentGenericAuthResponseFailureMsg");
						}
						catch(Exception e)
						{}
					}
				}
				else
				{
					try
					{
						authRes = ProjectManager.get("paymentGenericAuthResponseFailureMsg");
					}
					catch(Exception e)
					{}
				}

				try
				{
			  	  valueMap.put(ProjectManager.get("respInputAuthResponse"),authRes);
				}
				catch(Exception e)
				{
				}
                          //Count the Failure Attempts for Lockdown on max attempts exceeded.
                          //ProjectManager.attemptPayment();
                          JDialog theDialog=(JDialog)this.getTopLevelAncestor();
                          theDialog.dispose();
                          new dlgCustomerBillingResponsePanelFailure(valueMap,new javax.swing.JFrame(), true).show();
                          //TODO: Create a method in object and pass in Map data then fill in labels.
                    }                                       
                    /* add second call to http connection based on return data.. */ 

                }
                catch(NullPointerException eeeee)
                {
                    //System.out.println(eeeee);
                    eeeee.printStackTrace();
                    //skip this, becuase it is currently thrown by the ResponseMap Objects when not connected to the internet, or server. Fix the logic and error handling later on. 
                }
                catch(MalformedURLException e)
		    {
                    // System.out.println(e);
                    //e.printStackTrace();
                    if(ProjectManager.get("unknownHostExceptionAction")!=null)
                    {
                        try
                        {
                            Class.forName("com.trinity.ea.design.common.preview.actions.UnknownHostExceptionAction").newInstance();
                        }
                        catch(InstantiationException ee)
                        {
                            System.out.println(ee);
                        }   
                        catch(IllegalAccessException eee)
                        {
                            System.out.println(eee);
                        }                      
                        catch(ClassNotFoundException eeee)
                        {
                            System.out.println(eeee);
                        }       
                    }
                    else
                    {
                        //Problem in Properties File
                    }
		    }
		    catch(Exception e)
		    {
			  e.printStackTrace();
		    }
            }
        }
   }

   /** returns localized versions of Authorization Declined messages. */
   private Map getTransactionDeclinedMessageMap()
   {
	Map msgMap = null;
	try
	{
	              if(ProjectManager.get("paymentResponseStatTotalMessages")!=null)
                    {
                        int theTotalDeclinedMessages = Integer.valueOf(ProjectManager.get("paymentResponseStatTotalMessages")).intValue();
                        if(theTotalDeclinedMessages>1)
                        {
					msgMap = new HashMap(theTotalDeclinedMessages);
                            for(int i = 0;i<theTotalDeclinedMessages;i++)
                            {
					try
					{
						msgMap.put(ProjectManager.get("paymentResponseStatDeclined" + String.valueOf(i + 1)), ProjectManager.get("paymentResponseMsgDeclined" + String.valueOf(i + 1)));
					}
					catch(Exception e){}
                            }
				    return msgMap;
                        }
                    }
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
   }    

   /** returns an Object Array of Strings to search for in the HTML Document. */
   private Object[] getTransactionDeclinedMessageCodes()
   {
	try
	{
	              if(ProjectManager.get("paymentResponseStatTotalMessages")!=null)
                    {
                        int theTotalDeclinedMessages = Integer.valueOf(ProjectManager.get("paymentResponseStatTotalMessages")).intValue();
                        if(theTotalDeclinedMessages>1)
                        {
				    ArrayList theList = new ArrayList();
                            for(int i = 0;i<theTotalDeclinedMessages;i++)
                            {
					try
					{
						theList.add(ProjectManager.get("paymentResponseStatDeclined" + String.valueOf(i + 1)));
					}
					catch(Exception e){}
                            }
				    theList.trimToSize();
				    return theList.toArray();
                        }
                    }
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
   }    
   private String getAuthResponseMessage(String strHTMLDoc)
   {
	try
	{
	              if(ProjectManager.get("paymentResponseStatTotalMessages")!=null)
                    {
                        int theTotalDeclinedMessages = Integer.valueOf(ProjectManager.get("paymentResponseStatTotalMessages")).intValue();
                        if(theTotalDeclinedMessages>1)
                        {
				   try
				   {
				   Object[] theArray = getTransactionDeclinedMessageCodes();
				   
                            for(int i = 0;i<theArray.length;i++)
                            {
					try
					{
						if(strHTMLDoc.indexOf((String)theArray[i])!=-1)
						{
							return (String)getTransactionDeclinedMessageMap().get((String)theArray[i]);
						}
					}
					catch(Exception e){}
                            }

				    }
				   catch(Exception e)
				   {
					
				   }
                        }
                    }
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}	
	try
	{
		return ProjectManager.get("paymentGenericAuthResponseFailureMsg");
	}
	catch(Exception e)
	{
		return "";
	}
   }

    public boolean validateData()
    {
        // EMail Validation Code
        String emailAddress = null;
        String phone = null;
        String firstNameID = null;
        String lastNameID = null;
        String streetAddr = null;
        String cityAddr = null;
        String zipAddr = null;
        String cc1ID = null;
        String cc2ID = null;        
        String cc3ID = null;
        String cc4ID = null;  
        String verifCode = null;
        try
        {
            firstNameID=getFirstName();
            if(firstNameID.equals(""))
            {
                getMessage(ProjectManager.get("msgMsgTitle"), ProjectManager.get("paymentFirstNameDataFieldEmptyMessage"));
                tfFirstName.grabFocus();       
                return false;
            }
        }
        catch(NullPointerException e)
        {
            getMessage(ProjectManager.get("msgMsgTitle"),ProjectManager.get("paymentFirstNameDataFieldEmptyMessage"));
            tfFirstName.grabFocus();
            return false;           
        }
        try
        {
            lastNameID=getLastName();
            if(lastNameID.equals(""))
            {
                getMessage(ProjectManager.get("msgMsgTitle"),ProjectManager.get("paymentLastNameDataFieldEmptyMessage"));
                tfLastName.grabFocus();         
                return false;                
            }
        }
        catch(NullPointerException e)
        {
            getMessage(ProjectManager.get("msgMsgTitle"),ProjectManager.get("paymentLastNameDataFieldEmptyMessage"));
            tfLastName.grabFocus();
            return false;            
        }    
        try
        {
            phone=getPhone();
		if(ProjectManager.get("paymentPhoneInputEnabled")!=null)
		{
			if(ProjectManager.get("paymentPhoneInputEnabled").equalsIgnoreCase("true")==true)
			{
            		if(phone.equals(""))
            		{
                			getMessage(ProjectManager.get("msgMsgTitle"),ProjectManager.get("paymentPhoneDataFieldEmptyMessage"));
                			tfPhone.grabFocus();         
                			return false;                
            		}
			}
		}
        }
        catch(NullPointerException e)
        {
            getMessage(ProjectManager.get("msgMsgTitle"),ProjectManager.get("paymentPhoneDataFieldEmptyMessage"));
            tfPhone.grabFocus();
            return false;            
        }  
        try
        {
            emailAddress = getEMailName();
            if(emailAddress.indexOf("@") == -1)
            {
                getMessage(ProjectManager.get("msgMsgTitle"),ProjectManager.get("paymentValidEMailDataFieldEmptyMessage"));
                tfEMail.grabFocus();
                return false;                
            }
            else if(emailAddress.indexOf(".") == -1)
            {
                getMessage(ProjectManager.get("msgMsgTitle"),ProjectManager.get("paymentValidEMailDataFieldEmptyMessage"));
                tfEMail.grabFocus();
                return false;                
            }
        }
        catch(NullPointerException e)
        {
            getMessage(ProjectManager.get("msgMsgTitle"),ProjectManager.get("paymentEMailDataFieldEmptyMessage"));
            tfEMail.grabFocus();
            return false;            
        }
        try
        {
            streetAddr=getAddress();
            if(streetAddr.equals(""))
            {
                getMessage(ProjectManager.get("msgMsgTitle"),ProjectManager.get("paymentStreetDataFieldEmptyMessage"));
                tfAddress.grabFocus();  
                return false;                
            }            
        }
        catch(NullPointerException e)
        {
            getMessage(ProjectManager.get("msgMsgTitle"),ProjectManager.get("paymentStreetDataFieldEmptyMessage"));
            tfAddress.grabFocus();
            return false;            
        }
        try
        {
            cityAddr=getCity();
            if(cityAddr.equals(""))
            {
                getMessage(ProjectManager.get("msgMsgTitle"),ProjectManager.get("paymentCityDataFieldEmptyMessage"));
                tfCity.grabFocus();
                return false;                
            }                
        }
        catch(NullPointerException e)
        {
            getMessage(ProjectManager.get("msgMsgTitle"),ProjectManager.get("paymentCityDataFieldEmptyMessage"));
            tfCity.grabFocus();
            return false;            
        }
        try
        {
            zipAddr=getZip();
            if(zipAddr.equals(""))
            {
                getMessage(ProjectManager.get("msgMsgTitle"),ProjectManager.get("paymentZipDataFieldEmptyMessage"));
                tfZipCode.grabFocus();  
                return false;                
            }                  
        }
        catch(NullPointerException e)
        {
            getMessage(ProjectManager.get("msgMsgTitle"),ProjectManager.get("paymentZipDataFieldEmptyMessage"));
            tfZipCode.grabFocus();
            return false;            
        }        
        try
        {
            cc1ID=getCC1();
            cc2ID=getCC2();
            cc3ID=getCC3();
            cc4ID=getCC4();
            if(cc1ID.equals("")==true || cc2ID.equals("")==true || cc3ID.equals("")==true || cc4ID.equals("")==true)
            {
                getMessage(ProjectManager.get("msgMsgTitle"),ProjectManager.get("paymentCCDataFieldEmptyMessage"));
                tfCC1.grabFocus();   
                return false;                
            }                    
        }
        catch(NullPointerException e)
        {
            getMessage(ProjectManager.get("msgMsgTitle"),ProjectManager.get("paymentCCDataFieldEmptyMessage"));
            tfCC1.grabFocus();
            return false;            
        }        
        
        try
        {
            if(getVerificationCodeObjectIsVisible()==true)
            {
                verifCode=getVerificationCode();
                if(verifCode.equals(""))
                {
                    getMessage(ProjectManager.get("msgMsgTitle"),ProjectManager.get("paymentCCVerificationCodeFieldEmptyMessage"));
                    tfVerificationCode.grabFocus();  
                    return false;                    
                }                  
            }
        }
        catch(NullPointerException e)
        {
            getMessage(ProjectManager.get("msgMsgTitle"),ProjectManager.get("paymentCCVerificationCodeFieldEmptyMessage"));
            tfVerificationCode.grabFocus();
            return false;           
        }        
        String formRequestMethod = null;
        if(ProjectManager.get("formRequestMethod") != null)
        {
            formRequestMethod = ProjectManager.get("formRequestMethod");
        }      
        else
        {
             return false;
        }
        return true;
    }
    private void cbCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCountryActionPerformed
        // Add your handling code here:
    }//GEN-LAST:event_cbCountryActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ExpirationMonth;
    private javax.swing.JComboBox ExpirationYear;
    private javax.swing.JComboBox PaymentMethod;
    private javax.swing.JComboBox cbCountry;
    private javax.swing.JComboBox cbState;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnContinue;
    private javax.swing.JTextArea lPaymentInstructions;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblCardNumber;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblEMailAddress;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblExpirationMMYY;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblINTNote;
    private javax.swing.JLabel lblINTNote1;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblPaymentMethod;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblVerificationCode;
    private javax.swing.JLabel lblZip;
    private javax.swing.JTextField tfAddress;
    private javax.swing.JTextField tfCC1;
    private javax.swing.JTextField tfCC2;
    private javax.swing.JTextField tfCC3;
    private javax.swing.JTextField tfCC4;
    private javax.swing.JTextField tfCity;
    private javax.swing.JTextField tfEMail;
    private javax.swing.JTextField tfPhone;
    private javax.swing.JTextField tfFirstName;
    private javax.swing.JTextField tfLastName;
    private javax.swing.JTextField tfVerificationCode;
    private javax.swing.JTextField tfZipCode;
    private ImageButton btnImageCancel;
    private ImageButton btnImageContinue;

    // End of variables declaration//GEN-END:variables
    
    public String getTotalPrice()
    {
            // TODO: Command Line implementation
            // TODO: MIDP implementation
            // Total Price
            if(ProjectManager.get("product_price")!=null)
            {
                    return ProjectManager.get("product_price");
            }
            else
            {
                //Problem in Properties File
                return null;
            }
    }
   
    public void setFirstName(String strFirstName)
    {
        tfFirstName.setText(strFirstName);
    }
    public String getFirstName()
    {
        return tfFirstName.getText();
    }
    public void setLastName(String strLastName)
    {
        tfLastName.setText(strLastName);
    }
    public String getLastName()
    {
        return tfLastName.getText();
    }   
    public void setPhone(String strPhone)
    {
	  tfPhone.setText(strPhone);
    }
    public String getPhone()
    {
	  return tfPhone.getText();
    }
    public void setEMail(String strEMail)
    {
        tfEMail.setText(strEMail);
    }
    public String getEMailName()
    {
        return tfEMail.getText();
    }     
    public void setAddress(String strAddress)
    {
        tfAddress.setText(strAddress);
    }
    public String getAddress()
    {
        return tfAddress.getText();
    }   
    public void setCity(String strCity)
    {
        tfCity.setText(strCity);
    }
    public String getCity()
    {
        return tfCity.getText();
    }         
    public void setState(String strState)
    {
        cbState.setSelectedItem(strState);
    }
    public String getState()
    {
        return (String)cbState.getSelectedItem();
    }        
    public void setZip(String strZip)
    {
        tfZipCode.setText(strZip);
    }
    public String getZip()
    {
        return tfZipCode.getText();
    }     
    public void setCountry(String strCountry)
    {
        cbCountry.setSelectedItem(strCountry);
    }
    public String getCountry()
    {
        return (String)cbCountry.getSelectedItem();
    }         
    public void setPaymentMethod(String strPaymentMethod)
    {
        PaymentMethod.setSelectedItem(strPaymentMethod);
    }
    public String getPaymentMethod()
    {
        return (String)PaymentMethod.getSelectedItem();
    }     
    public void setCC1(String strCC1)
    {
        tfCC1.setText(strCC1);
    }
    public String getCC1()
    {
        return tfCC1.getText();
    }  
     public void setCC2(String strCC2)
    {
        tfCC2.setText(strCC2);
    }
    public String getCC2()
    {
        return tfCC2.getText();
    }         
    public void setCC3(String strCC3)
    {
        tfCC3.setText(strCC3);
    }
    public String getCC3()
    {
        return tfCC3.getText();
    }        
    public void setCC4(String strCC4)
    {
        tfCC4.setText(strCC4);
    }
    public String getCC4()
    {
        return tfCC4.getText();
    } 
    public void setExpirationMonth(String strExpirationMonth)
    {
       ExpirationMonth.setSelectedItem(strExpirationMonth);
    }
    public String getExpirationMonth()
    {
        return (String)ExpirationMonth.getSelectedItem();
    }         
    public void setExpirationYear(String strExpirationYear)
    {
        ExpirationYear.setSelectedItem(strExpirationYear);
    }
    public String getExpirationYear()
    {
        return (String)ExpirationYear.getSelectedItem();
    }   

    public void setVerificationCode(String strVerificationCode)
    {
        tfVerificationCode.setText(strVerificationCode);
    }
    public String getVerificationCode()
    {
        return tfVerificationCode.getText();
    }  
    private boolean verificationCodeObjectIsVisible = false;
    public void setVerificationCodeObjectIsVisible(boolean isVisible)
    {
        verificationCodeObjectIsVisible = isVisible;
        lblVerificationCode.setVisible(isVisible);
        tfVerificationCode.setVisible(isVisible);
    }

    public boolean getVerificationCodeObjectIsVisible()
    {
System.out.println("gv " + verificationCodeObjectIsVisible);

		return verificationCodeObjectIsVisible;
    }	   
    
    public static String[] getPaymentMethodsToDisplay()
    {
        try
        {
            if(ProjectManager.get("paymentMethods")!=null)
            {
                String paymentMethodsList=ProjectManager.get("paymentMethods");
                if(paymentMethodsList!=null)
                {
                    ArrayList al = new ArrayList();
                    String parseString = paymentMethodsList;
                    String parseStringSubstring;
                    if(parseString.indexOf(",") !=-1)
                    {
                        while(parseString.indexOf(",") !=-1)
                        {
                            al.add(parseString.substring(0,parseString.indexOf(",")));
                            parseString = parseString.substring(parseString.indexOf(",") + 1);
                        }
                        al.add(parseString);
                        al.trimToSize();
                        return (String[])al.toArray();
                    }
                    else
                    {
                        String[] theStrArray = {paymentMethodsList};
                        return theStrArray;
                    }
                }
                else
                {
                    return null;
                }   

            }
            else
            {
                return null;
                //Problem in Properties File
            }
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    /** returns the HTTP GET Request */
    public String getHTTPRequest()
    {
        String theHTTPRequest = null;
        String formActionURL = null;
        String inputNameFirstName = null;
        String inputNameLastName = null;
        String inputNameEMail = null;
        String inputNamePhone = null;
        String inputNameAddress = null;  
        String inputNameCity = null;
        String inputNameState = null;
        String inputNameZip = null;
        String inputNameCountry = null;
        String inputNamePaymentMethod = null;
        String inputNameCC1 = null;
        String inputNameCC2 = null;
        String inputNameCC3 = null;
        String inputNameCC4 = null;        
        String inputNameVerificationCode = null;
        String inputNameExpirationMonth = null;
        String inputNameExpirationYear = null;
        String inputNameMerchant = null;
        String inputNameOrderID = null;
        String inputNameNameOnCard = null;
        String inputNameResponseURL = null;
        String inputNameTotal = null;
        String orderIDLeadingID = null;
        String totalPrice = null;
        String merchantValue = null;
        String responseURLValue = null;
        String inputNames = null;
        String inputValues = null;
        String theRequestType = null;
	  String ccInputsComplete = null;
	  String nameInputsComplete = "";
	  String phoneInputsComplete = "";
        
        if(ProjectManager.get("formActionURL")!=null)
        {
            formActionURL=ProjectManager.get("formActionURL");
        }
        if(ProjectManager.get("formRequestMethod")!=null)
        {        
            theRequestType=ProjectManager.get("formRequestMethod");
        }
        if(ProjectManager.get("inputNameFirstName")!=null)
        {        
            inputNameFirstName=ProjectManager.get("inputNameFirstName");
        }
        if(ProjectManager.get("inputNameLastName")!=null)
        {        
            inputNameLastName=ProjectManager.get("inputNameLastName");
        }
if(ProjectManager.get("paymentPhoneInputEnabled")!=null)
{
	if(ProjectManager.get("paymentPhoneInputEnabled").equalsIgnoreCase("true")==true)
	{
        if(ProjectManager.get("inputNamePhone")!=null)
        {        
            inputNamePhone=ProjectManager.get("inputNamePhone");
        }
	}
}
        if(ProjectManager.get("inputNameEMail")!=null)
        {       
            inputNameEMail=ProjectManager.get("inputNameEMail");
        }
        if(ProjectManager.get("inputNameAddress")!=null)
        {        
            inputNameAddress=ProjectManager.get("inputNameAddress");
        }
        if(ProjectManager.get("inputNameCity")!=null)
        {        
            inputNameCity=ProjectManager.get("inputNameCity");
        }
        if(ProjectManager.get("inputNameState")!=null)
        {        
            inputNameState=ProjectManager.get("inputNameState");
        }
        if(ProjectManager.get("inputNameZip")!=null)
        {        
            inputNameZip=ProjectManager.get("inputNameZip");
        }
        if(ProjectManager.get("inputNameCountry")!=null)
        {        
            inputNameCountry=ProjectManager.get("inputNameCountry");
        }
        if(ProjectManager.get("inputNamePaymentMethod")!=null)
        {       
            inputNamePaymentMethod=ProjectManager.get("inputNamePaymentMethod");
        }
        if(ProjectManager.get("inputNameCC1")!=null)
        {        
            inputNameCC1=ProjectManager.get("inputNameCC1");
        }
        if(ProjectManager.get("inputNameCC2")!=null)
        {        
            inputNameCC2=ProjectManager.get("inputNameCC2");
        }
        if(ProjectManager.get("inputNameCC3")!=null)
        {        
            inputNameCC3=ProjectManager.get("inputNameCC3");
        }
        if(ProjectManager.get("inputNameCC4")!=null)
        {        
            inputNameCC4=ProjectManager.get("inputNameCC4");
        }
        if(ProjectManager.get("inputNameVerificationCode")!=null)
        {        
            inputNameVerificationCode=ProjectManager.get("inputNameVerificationCode");
        }
        if(ProjectManager.get("inputNameExpirationMonth")!=null)
        {        
            inputNameExpirationMonth=ProjectManager.get("inputNameExpirationMonth");
        }
        if(ProjectManager.get("inputNameExpirationYear")!=null)
        {       
            inputNameExpirationYear=ProjectManager.get("inputNameExpirationYear");
        }
        if(ProjectManager.get("inputNameMerchant")!=null)
        {       
            inputNameMerchant=ProjectManager.get("inputNameMerchant");
        }
        if(ProjectManager.get("inputNameOrderID")!=null)
        {        
            inputNameOrderID=ProjectManager.get("inputNameOrderID");
        }
        if(ProjectManager.get("inputNameNameOnCard")!=null)
        {        
            inputNameNameOnCard=ProjectManager.get("inputNameNameOnCard");
        }
        if(ProjectManager.get("inputNameResponseURL")!=null)
        {        
            inputNameResponseURL=ProjectManager.get("inputNameResponseURL");
        }
        if(ProjectManager.get("inputNameTotal")!=null)
        {        
            inputNameTotal=ProjectManager.get("inputNameTotal");
        }
        if(ProjectManager.get("orderIDLeadingID")!=null)
        {        
            orderIDLeadingID=ProjectManager.get("orderIDLeadingID");
        }
        if(ProjectManager.get("product_price")!=null)
        {        
            totalPrice=ProjectManager.get("product_price");     
        }
        if(ProjectManager.get("merchantValue")!=null)
        {        
            merchantValue=ProjectManager.get("merchantValue");         
        }
         if(ProjectManager.get("responseURLValue")!=null)
        {        
            responseURLValue=ProjectManager.get("responseURLValue");         
        }
        if(ProjectManager.get("paymentInputHiddenNames")!=null)
        {       
            inputNames=ProjectManager.get("paymentInputHiddenNames");
            if(ProjectManager.get("paymentInputHiddenValues")!=null)
            {        
                inputValues=ProjectManager.get("paymentInputHiddenValues");
            } 
         }          
        
        CCStates state1 = new CCStates();
        CCCountries country1 = new CCCountries();
	  try
	  {
            Object[] objArrayNames = getStringArraysFromString(inputNames);
            Object[] objArrayValues = getStringArraysFromString(inputValues);
		try
		{
			Object[] tmpArrayValues = new Object[objArrayValues.length];
			for(int i = 0;i<tmpArrayValues.length;i++)
			{
				 tmpArrayValues[i] = getCommaSeparatedStringValues((String)objArrayValues[i]);
			}
			objArrayValues = tmpArrayValues;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			if(ProjectManager.get("paymentCCIsSingleInputEnabled")!=null)
			{
				if(ProjectManager.get("paymentCCIsSingleInputEnabled").equalsIgnoreCase("true")==true)
				{
					ccInputsComplete = inputNameCC1 + "=" + URLEncoder.encode(getCC1() + getCC2() + getCC3() + getCC4());
				}
				else
				{
					ccInputsComplete = inputNameCC1 + "=" + URLEncoder.encode(getCC1()) + "&" + inputNameCC2 + "=" + URLEncoder.encode(getCC2()) + "&" + inputNameCC3 + "=" + URLEncoder.encode(getCC3()) + "&" + inputNameCC4 + "=" + URLEncoder.encode(getCC4());
				}
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		try
		{
			if(ProjectManager.get("paymentSeparateFirstAndLastNameInputsEnabled")!=null)
			{
				if(ProjectManager.get("paymentSeparateFirstAndLastNameInputsEnabled").equalsIgnoreCase("true")==true)
				{
					nameInputsComplete = inputNameFirstName + "=" + URLEncoder.encode(getFirstName()) + "&" + inputNameLastName + "=" + URLEncoder.encode(getLastName());
				}
			}
			if(ProjectManager.get("paymentFullNameInputEnabled")!=null)
			{
				if(ProjectManager.get("paymentFullNameInputEnabled").equalsIgnoreCase("true")==true)
				{
					if(nameInputsComplete.equalsIgnoreCase("")==true)
					{
						nameInputsComplete = inputNameNameOnCard + "=" + URLEncoder.encode(getFirstName() + " " + getLastName());
					}
					else
					{
						nameInputsComplete = nameInputsComplete + "&" + inputNameNameOnCard + "=" + URLEncoder.encode(getFirstName() + " " + getLastName());
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			if(inputNamePhone!=null)
			{
				phoneInputsComplete = "&" + inputNamePhone + "=" + URLEncoder.encode(getPhone());
			}

		}
		catch(Exception e)
		{
			phoneInputsComplete = "";
		}
                StringBuffer sb = new StringBuffer();
                sb.append(inputNameMerchant + "=" + URLEncoder.encode(merchantValue) + "&" + inputNameOrderID + "=" + URLEncoder.encode(orderIDLeadingID + ((com.trinity.ea.idef.IOrderIDGenerator)Class.forName(ProjectManager.get("orderIDGeneratorAction")).newInstance()).getOrderID()) + "&" + nameInputsComplete + "&" + inputNameResponseURL + "=" + responseURLValue + "&" + inputNameEMail + "=" + URLEncoder.encode(getEMailName()) + phoneInputsComplete + "&" + inputNameAddress + "=" + URLEncoder.encode(getAddress()) + "&" + inputNameCity + "=" + URLEncoder.encode(getCity()) + "&" + inputNameTotal + "=" + URLEncoder.encode(totalPrice) + "&" + inputNameState + "=" + URLEncoder.encode(state1.getStateID(getState())) + "&" + inputNameZip + "=" + URLEncoder.encode(getZip()) + "&" + inputNameCountry + "=" + URLEncoder.encode(country1.getCountryID(getCountry())) + "&" + inputNamePaymentMethod + "=" + URLEncoder.encode(getPaymentMethod()) + "&" + ccInputsComplete + "&" + inputNameExpirationMonth + "=" + URLEncoder.encode(getExpirationMonth()) + "&" + inputNameExpirationYear + "=" + URLEncoder.encode(getExpirationYear()));
                if(objArrayNames.length>=1)
                {
                    for(int i=0;i<objArrayNames.length;i++)
                    {
                        sb.append("&" + (String)objArrayNames[i] + "=" + URLEncoder.encode((String)objArrayValues[i]));
                    }
                }
                sb.append("&" + "Submit=Submit");
                theHTTPRequest = sb.toString();                 
	  }
	  catch(Exception e)
	  {
            return null;		
	  }
        if(theRequestType.equalsIgnoreCase("POST")==true)
        {
            return theHTTPRequest;
        }
        else if(theRequestType.equalsIgnoreCase("GET")==true)
        {
            return formActionURL + "?" + theHTTPRequest;
        }
	return null;
    }

    private String getCommaSeparatedStringValues(String strToUpdate)
    {
	 return strToUpdate.replaceAll(":::",",");
    }

// public void paint(Graphics g)
//{
//        Graphics2D g2 = (Graphics2D) g;
//        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
//        super.paint(g);
//} 
    public void paint(Graphics g)
    {
	Graphics2D g2 = (Graphics2D) g;
	g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT);
	super.paint(g);
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
                        if(e.getComponent().equals(btnImageCancel)==true)
                        {
				    if(e.getKeyCode()==btnImageCancel.getDisplayedMnemonic())
                            {
        				getCancelAction();
				    }
                        }
                        else if(e.getComponent().equals(btnImageContinue)==true)
                        {
				    if(e.getKeyCode()==btnImageContinue.getDisplayedMnemonic())
                            {
					try
					{	
						getSubmitRequest();
					}
					catch(Exception ee)
					{
						ee.printStackTrace();
					}
				    }
                        }
				armed = false;
			}
              }
              // If the key should not be dispatched to the
              // focused component, set discardEvent to true
              boolean discardEvent = false;
              return discardEvent;
            }
        });       
    }

    private boolean armed = false;
    private void getMessage(String title, String error)
    {
        boolean isOptionPane = true;
	  if(ProjectManager.get("btnBarImgButtonsEnabled")!=null)
	  {
	  	if(ProjectManager.get("btnBarImgButtonsEnabled").equalsIgnoreCase("true")==true)
	  	{
                    isOptionPane = false;
                }
                else
                {
                    isOptionPane = true;
                }
          }
          else
          {
              isOptionPane = true;
          }
        if(isOptionPane==false)
        {
            new ErrorDialog(title,error);
        }
        else
        {
            JOptionPane.showMessageDialog(null,error,title,JOptionPane.INFORMATION_MESSAGE);
        }
    }      

    private String replaceUIExpressions(String UIStringToReplaceExpressions)
    {
        try
        {
            for(int i = 0;i<updateUIExpressions.length;i++)
            {
			if(((String)updateUIExpressions[i]).equalsIgnoreCase("product_version")==false)
			{
                    UIStringToReplaceExpressions = UIStringToReplaceExpressions.replaceAll("(?i)" + (String)updateUIExpressions[i],ProjectManager.get((String)updateUIExpressions[i]));
			}
			else
			{
			  //put replace version string code here.
			  Object[] theVersionArray = getStringArraysFromString(ProjectManager.get((String)updateUIExpressions[i]));
			  int tempInt = 1;
			  String strVersionString = "";
  			  for(int a = 0;a<theVersionArray.length;a++)
			  {
				if(0<a)
				{
					try
					{
						if(Integer.parseInt((String)theVersionArray[a])!=0)
						{
							tempInt = a;
						}
					}
					catch(Exception e)
					{
						//The String likely was not a number and threw an exception
					}
				}
			  }
			  tempInt = tempInt + 1;
  			  for(int a = 0;a<tempInt;a++)
			  {
				if(a!=0)
				{
					strVersionString = strVersionString + "." + (String)theVersionArray[a];
				}
				else
				{
					strVersionString = (String)theVersionArray[a];
				}
			  }
                    UIStringToReplaceExpressions = UIStringToReplaceExpressions.replaceAll("(?i)" + (String)updateUIExpressions[i],strVersionString);
			}
            }
            return UIStringToReplaceExpressions;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    Object[] updateUIExpressions = new Object[9];
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
            if(ProjectManager.get("product_price")!=null)
            {
                theExpressionDefinesArrayList.add("product_price");
            }
            if(ProjectManager.get("product_purchase_support_email")!=null)
            {
                theExpressionDefinesArrayList.add("product_purchase_support_email");
            }
            theExpressionDefinesArrayList.trimToSize();
            updateUIExpressions = theExpressionDefinesArrayList.toArray();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }    
}
