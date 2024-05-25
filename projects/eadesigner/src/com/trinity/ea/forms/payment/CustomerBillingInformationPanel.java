/*
 * CustomerBillingInformationPanel.java
 *
 * Created on October 19, 2003, 9:36 PM
 */

package com.trinity.ea.forms.payment;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import com.trinity.ea.forms.data.RandomNumberGenerator;
import com.trinity.ea.forms.gui.swing.ErrorDialog;
import com.trinity.ea.forms.data.CCStates;
import com.trinity.ea.forms.data.CCCountries;
import com.trinity.ea.net.WebConnectionRequest;
import com.trinity.ea.parser.HTTPGETRequestParser;
import com.trinity.ea.forms.payment.dlgCustomerBillingResponsePanelFailure;
import com.trinity.ea.forms.payment.dlgCustomerBillingResponsePanelSuccess;
import com.trinity.ea.forms.payment.RefundPolicy;
import com.trinity.ea.util.BrowserLauncher;
import com.trinity.ea.actions.ConfigurationErrorAction;
import com.trinity.ea.idef.IOrderIDGenerator;
import com.trinity.ea.forms.gui.swing.ImageButton;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2005 Trinity Software. All rights reserved.
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
	  if(EncryptedRuleReader.get("refundPolicyActionType")!=null)
	  {
	  	if(EncryptedRuleReader.get("refundPolicyActionType").equalsIgnoreCase("")==false)
	  	{		
	  		if(EncryptedRuleReader.get("refundPolicyAction")!=null)
	  		{
	  			if(EncryptedRuleReader.get("refundPolicyAction").equalsIgnoreCase("")==false)
	  			{	
					setRefundPolicyAction(new Integer(EncryptedRuleReader.get("refundPolicyActionType")).intValue(), EncryptedRuleReader.get("refundPolicyAction"));
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

	  if(EncryptedRuleReader.get("btnBarImgButtonsEnabled")!=null)
	  {
	  	if(EncryptedRuleReader.get("btnBarImgButtonsEnabled").equalsIgnoreCase("true")==true)
	  	{
			isImageButton=true;
	  		if(EncryptedRuleReader.get("paymentImgBackgroundColor")!=null)
	  		{
				if(EncryptedRuleReader.get("paymentImgBackgroundColor").equalsIgnoreCase("")==false)
				{
					Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("paymentImgBackgroundColor"));
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

	  if(EncryptedRuleReader.get("paymentImgCancelButtonWidth")!=null)
	  {
	  	if(EncryptedRuleReader.get("paymentImgCancelButtonWidth").equalsIgnoreCase("")==false)
	  	{
			try
			{
				btnWidthCancel = new Integer(EncryptedRuleReader.get("paymentImgCancelButtonWidth")).intValue();
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
	  if(EncryptedRuleReader.get("paymentImgCancelButtonHeight")!=null)
	  {
	  	if(EncryptedRuleReader.get("paymentImgCancelButtonHeight").equalsIgnoreCase("")==false)
	  	{
			try
			{
				btnHeightCancel = new Integer(EncryptedRuleReader.get("paymentImgCancelButtonHeight")).intValue();
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
		if(EncryptedRuleReader.get("paymentImgCancelButtonFace")!=null)
		{
			if(EncryptedRuleReader.get("paymentImgCancelButtonFace").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceCancel = new javax.swing.ImageIcon(getClass().getResource(EncryptedRuleReader.get("paymentImgCancelButtonFace")));
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
		if(EncryptedRuleReader.get("paymentImgCancelButtonFaceOnClick")!=null)
		{
			if(EncryptedRuleReader.get("paymentImgCancelButtonFaceOnClick").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceOnClickCancel = new javax.swing.ImageIcon(getClass().getResource(EncryptedRuleReader.get("paymentImgCancelButtonFaceOnClick")));

				}
				catch(Exception e)
				{
					//e.printStackTrace();
				}
			}
		}
		if(EncryptedRuleReader.get("paymentImgCancelButtonFaceInFocus")!=null)
		{
			if(EncryptedRuleReader.get("paymentImgCancelButtonFaceInFocus").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceInFocusCancel = new javax.swing.ImageIcon(getClass().getResource(EncryptedRuleReader.get("paymentImgCancelButtonFaceInFocus")));
				}
				catch(Exception e)
				{
					//e.printStackTrace();
				}
			}
		}
}
	  if(EncryptedRuleReader.get("paymentImgContinueButtonWidth")!=null)
	  {
	  	if(EncryptedRuleReader.get("paymentImgContinueButtonWidth").equalsIgnoreCase("")==false)
	  	{
			try
			{
				btnWidthContinue = new Integer(EncryptedRuleReader.get("paymentImgContinueButtonWidth")).intValue();
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
	  if(EncryptedRuleReader.get("paymentImgContinueButtonHeight")!=null)
	  {
	  	if(EncryptedRuleReader.get("paymentImgContinueButtonHeight").equalsIgnoreCase("")==false)
	  	{
			try
			{
				btnHeightContinue = new Integer(EncryptedRuleReader.get("paymentImgContinueButtonHeight")).intValue();
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
		if(EncryptedRuleReader.get("paymentImgContinueButtonFace")!=null)
		{
			if(EncryptedRuleReader.get("paymentImgContinueButtonFace").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceContinue = new javax.swing.ImageIcon(getClass().getResource(EncryptedRuleReader.get("paymentImgContinueButtonFace")));
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
		if(EncryptedRuleReader.get("paymentImgContinueButtonFaceOnClick")!=null)
		{
			if(EncryptedRuleReader.get("paymentImgContinueButtonFaceOnClick").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceOnClickContinue = new javax.swing.ImageIcon(getClass().getResource(EncryptedRuleReader.get("paymentImgContinueButtonFaceOnClick")));

				}
				catch(Exception e)
				{
					//e.printStackTrace();
				}
			}
		}
		if(EncryptedRuleReader.get("paymentImgContinueButtonFaceInFocus")!=null)
		{
			if(EncryptedRuleReader.get("paymentImgContinueButtonFaceInFocus").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceInFocusContinue = new javax.swing.ImageIcon(getClass().getResource(EncryptedRuleReader.get("paymentImgContinueButtonFaceInFocus")));
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
        lblFirstName.setText(EncryptedRuleReader.getLocaleString("paymentFirstNameLabel"));
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
        lblLastName.setText(EncryptedRuleReader.getLocaleString("paymentLastNameLabel"));
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
        lblEMailAddress.setText(EncryptedRuleReader.getLocaleString("paymentEMailLabel"));
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
        lblAddress.setText(EncryptedRuleReader.getLocaleString("paymentStreetLabel"));
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
        lblCity.setText(EncryptedRuleReader.getLocaleString("paymentCityLabel"));
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
        lblState.setText(EncryptedRuleReader.getLocaleString("paymentStateLabel"));
        lblState.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblState.setMaximumSize(new java.awt.Dimension(299, 100));
        lblState.setMinimumSize(new java.awt.Dimension(299, 100));
        lblState.setPreferredSize(new java.awt.Dimension(299, 100));
        add(lblState);
        lblState.setBounds(33, compStartHeight, 100, 25);

        lblINTNote.setBackground(new java.awt.Color(255, 255, 255));
        lblINTNote.setFont(new java.awt.Font("Arial", 0, 14));
        lblINTNote.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblINTNote.setText(EncryptedRuleReader.getLocaleString("paymentOrdersOutsideUSLabel"));
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
        lblZip.setText(EncryptedRuleReader.getLocaleString("paymentZipCodeLabel"));
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
        lblCountry.setText(EncryptedRuleReader.getLocaleString("paymentCountryLabel"));
        lblCountry.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblCountry.setMaximumSize(new java.awt.Dimension(299, 100));
        lblCountry.setMinimumSize(new java.awt.Dimension(299, 100));
        lblCountry.setPreferredSize(new java.awt.Dimension(299, 100));
        add(lblCountry);
        lblCountry.setBounds(33, compStartHeight, 100, 25);


if(EncryptedRuleReader.get("paymentPhoneInputEnabled")!=null)
{
	if(EncryptedRuleReader.get("paymentPhoneInputEnabled").equalsIgnoreCase("true")==true)
	{
        tfPhone.setFont(new java.awt.Font("Arial", 0, 14));
        add(tfPhone);
        tfPhone.setBounds(163, compStartHeight = (compStartHeight + 30), 240, 25);

        lblPhone.setBackground(new java.awt.Color(255, 255, 255));
        lblPhone.setFont(new java.awt.Font("Arial", 0, 14));
        lblPhone.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPhone.setLabelFor(tfPhone);
        lblPhone.setText(EncryptedRuleReader.getLocaleString("paymentPhoneLabel"));
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
	  if(EncryptedRuleReader.get("paymentMethods")!=null)
	  {
		Object[] theObjArray = getStringArraysFromString(EncryptedRuleReader.get("paymentMethods"));
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
        lblPaymentMethod.setText(EncryptedRuleReader.getLocaleString("paymentPaymentMethodLabel"));
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
        lblVerificationCode.setText(EncryptedRuleReader.getLocaleString("paymentVerificationCodeLabel"));
        lblVerificationCode.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblVerificationCode.setMaximumSize(new java.awt.Dimension(299, 100));
        lblVerificationCode.setMinimumSize(new java.awt.Dimension(299, 100));
        lblVerificationCode.setPreferredSize(new java.awt.Dimension(299, 100));
        add(lblVerificationCode);
        lblVerificationCode.setBounds(323, compStartHeight, 120, 25);

        tfVerificationCode.setFont(new java.awt.Font("Arial", 0, 14));
        add(tfVerificationCode);
        tfVerificationCode.setBounds(443, compStartHeight, 50, 25);


	if(EncryptedRuleReader.get("paymentCCVerificationCodeEnabled")!=null)
	{
		if(EncryptedRuleReader.get("paymentCCVerificationCodeEnabled").equalsIgnoreCase("true")==true)
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
        lPaymentInstructions.setText(EncryptedRuleReader.getLocaleString("paymentInstructionsLine1"));
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
        lblCardNumber.setText(EncryptedRuleReader.getLocaleString("paymentCCLabel"));
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

if(EncryptedRuleReader.get("refundPolicyEnabled")!=null)
{
   if(EncryptedRuleReader.get("refundPolicyEnabled").equalsIgnoreCase("true")==true)
   {  
	  if(EncryptedRuleReader.get("refundPolicyLinkTextColor")!=null)
	  {
		if(EncryptedRuleReader.get("refundPolicyLinkTextColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("refundPolicyLinkTextColor"));
			lblINTNote1.setForeground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }
        lblINTNote1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT); 
        lblINTNote1.setText(EncryptedRuleReader.getLocaleString("paymentRefundPolicyLabel"));
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
//TODO 8/17/2004: Localize Numbers 
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
        lblExpirationMMYY.setText(EncryptedRuleReader.getLocaleString("paymentExpMMYYLabel"));
        lblExpirationMMYY.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblExpirationMMYY.setMaximumSize(new java.awt.Dimension(299, 100));
        lblExpirationMMYY.setMinimumSize(new java.awt.Dimension(299, 100));
        lblExpirationMMYY.setPreferredSize(new java.awt.Dimension(299, 100));
        add(lblExpirationMMYY);
        lblExpirationMMYY.setBounds(33, compStartHeight, 120, 25);

	  if(isImageButton==true)
	  {
	  	 if(EncryptedRuleReader.get("paymentButtonFont")!=null)
	  	 {
	  		if(EncryptedRuleReader.get("paymentButtonFont").equalsIgnoreCase("")==false)
			{
				Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("paymentButtonFont"));
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

	  	  if(EncryptedRuleReader.getLocaleString("paymentCancelButtonText")!=null)
	  	  {
     			btnImageCancel.setText(EncryptedRuleReader.getLocaleString("paymentCancelButtonText"));
	  	  }
	  	  if(EncryptedRuleReader.getLocaleString("paymentCancelButtonMnemonic")!=null)
	  	  {
	  	  	if(EncryptedRuleReader.getLocaleString("paymentCancelButtonMnemonic").equalsIgnoreCase("")==false)
	  	  	{
	 			btnImageCancel.setMnemonic(EncryptedRuleReader.getLocaleString("paymentCancelButtonMnemonic").charAt(0));
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
	  	if(EncryptedRuleReader.getLocaleString("paymentContinueButtonText")!=null)
	  	{
      		btnImageContinue.setText(EncryptedRuleReader.getLocaleString("paymentContinueButtonText"));
	 	}
	  	if(EncryptedRuleReader.getLocaleString("paymentContinueButtonMnemonic")!=null)
	  	{
	  	  	if(EncryptedRuleReader.getLocaleString("paymentContinueButtonMnemonic").equalsIgnoreCase("")==false)
	  	  	{
				btnImageContinue.setMnemonic(EncryptedRuleReader.getLocaleString("paymentContinueButtonMnemonic").charAt(0));
			}
	  	}

        	add(btnImageContinue);
        	btnImageContinue.setBounds(283, compStartHeight, btnWidthContinue, btnHeightContinue);
	  }
	  else
	  {
	  if(EncryptedRuleReader.get("paymentButtonFont")!=null)
	  {
	  	if(EncryptedRuleReader.get("paymentButtonFont").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("paymentButtonFont"));
      		btnCancel.setFont(new java.awt.Font((String)tmpArray[0], new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			btnContinue.setFont(new java.awt.Font((String)tmpArray[0], new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }

	  	if(EncryptedRuleReader.getLocaleString("paymentContinueButtonText")!=null)
	  	{
      		btnContinue.setText(EncryptedRuleReader.getLocaleString("paymentContinueButtonText"));
	 	}
	  	if(EncryptedRuleReader.getLocaleString("paymentContinueButtonMnemonic")!=null)
	  	{
	  	  	if(EncryptedRuleReader.getLocaleString("paymentContinueButtonMnemonic").equalsIgnoreCase("")==false)
	  	  	{
				btnContinue.setMnemonic(EncryptedRuleReader.getLocaleString("paymentContinueButtonMnemonic").charAt(0));
			}
	  	}
        btnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinueActionPerformed(evt);
            }
        });

        add(btnContinue);
        btnContinue.setBounds(283, compStartHeight, 120, 26);

	  	  if(EncryptedRuleReader.getLocaleString("paymentCancelButtonText")!=null)
	  	  {
     			btnCancel.setText(EncryptedRuleReader.getLocaleString("paymentCancelButtonText"));
	  	  }
	  	  if(EncryptedRuleReader.getLocaleString("paymentCancelButtonMnemonic")!=null)
	  	  {
	  	  	if(EncryptedRuleReader.getLocaleString("paymentCancelButtonMnemonic").equalsIgnoreCase("")==false)
	  	  	{
	 			btnCancel.setMnemonic(EncryptedRuleReader.getLocaleString("paymentCancelButtonMnemonic").charAt(0));
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

	  if(EncryptedRuleReader.get("paymentLabelTextFont")!=null)
	  {
		if(EncryptedRuleReader.get("paymentLabelTextFont").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("paymentLabelTextFont"));
			setLabelTextFont(new java.awt.Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }
	  if(EncryptedRuleReader.get("paymentLabelTextColor")!=null)
	  {
		if(EncryptedRuleReader.get("paymentLabelTextColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("paymentLabelTextColor"));
			setLabelTextColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }
	  if(EncryptedRuleReader.get("paymentBackgroundColor")!=null)
	  {
		if(EncryptedRuleReader.get("paymentBackgroundColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("paymentBackgroundColor"));
			setBackgroundColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }
	  if(EncryptedRuleReader.get("paymentButtonTextColor")!=null)
	  {
		if(EncryptedRuleReader.get("paymentButtonTextColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("paymentButtonTextColor"));
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
	  if(EncryptedRuleReader.get("registrationCustomBorderEnabled")!=null)
	  {
		if(EncryptedRuleReader.get("registrationCustomBorderEnabled").equalsIgnoreCase("true")==true)
		{

	  if(EncryptedRuleReader.get("registrationTFExtBorderColor")!=null)
	  {
		if(EncryptedRuleReader.get("registrationTFExtBorderColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("registrationTFExtBorderColor"));
			extBorderColor = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
	  }
	  if(EncryptedRuleReader.get("registrationTFHighlightBorderColor1")!=null)
	  {
		if(EncryptedRuleReader.get("registrationTFHighlightBorderColor1").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("registrationTFHighlightBorderColor1"));
			highlightBorderColor1 = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
	  }
	  if(EncryptedRuleReader.get("registrationTFHighlightBorderColor2")!=null)
	  {
		if(EncryptedRuleReader.get("registrationTFHighlightBorderColor2").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("registrationTFHighlightBorderColor2"));
			highlightBorderColor2 = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
	  }
	  if(EncryptedRuleReader.get("registrationTFShadowBorderColor1")!=null)
	  {
		if(EncryptedRuleReader.get("registrationTFShadowBorderColor1").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("registrationTFShadowBorderColor1"));
			shadowBorderColor1 = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
	  }
	  if(EncryptedRuleReader.get("registrationTFShadowBorderColor2")!=null)
	  {
		if(EncryptedRuleReader.get("registrationTFShadowBorderColor2").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("registrationTFShadowBorderColor2"));
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
            if(EncryptedRuleReader.get("formRequestMethod") != null)
            {
                formRequestMethod = EncryptedRuleReader.get("formRequestMethod");
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
                       //System.out.println("supportMetaRefreshEnabled=" + EncryptedRuleReader.get("supportMetaRefreshEnabled"));

                    if(EncryptedRuleReader.get("supportMetaRefreshEnabled") != null)
                    {
                        //System.out.println("supportMetaRefreshEnabled=" + EncryptedRuleReader.get("supportMetaRefreshEnabled"));
                        /* if the GET Request return HTML returns a Meta Refresh tag follow through with Refresh timeout, and connection. */
 if(Boolean.valueOf(EncryptedRuleReader.get("supportMetaRefreshEnabled")).booleanValue()==true)
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
                                        if(valueMap.get(EncryptedRuleReader.get("respInputStatus"))!=null)
                                        {   //1 = Success

                                            if(((String)valueMap.get(EncryptedRuleReader.get("respInputStatus"))).equalsIgnoreCase("1")==true)
                                            {

                                               JDialog theDialog=(JDialog)this.getTopLevelAncestor();
                                                theDialog.dispose();
                                                new dlgCustomerBillingResponsePanelSuccess(valueMap,new javax.swing.JFrame(), true).show(); 

                                                //TODO: Create a method in object and pass in Map data then fill in labels.
                                            }//0 = Failure
                                            else if(((String)valueMap.get(EncryptedRuleReader.get("respInputStatus"))).equalsIgnoreCase("0")==true)
                                            {

                                                //Count the Failure Attempts for Lockdown on max attempts exceeded.
                                                EncryptedRuleReader.attemptPayment();

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
                    if(EncryptedRuleReader.get("unknownHostExceptionAction")!=null)
                    {
                        try
                        {
                            Class.forName(EncryptedRuleReader.get("unknownHostExceptionAction")).newInstance();
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
                    if(EncryptedRuleReader.get("formActionURL")!=null)
                    {
                        theURL1 = new URL(EncryptedRuleReader.get("formActionURL"));
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
					//System.out.println(" " + HTMLDoc);
					if(EncryptedRuleReader.get("paymentResponseInputStatusSuccess")!=null)
					{
						if(EncryptedRuleReader.get("paymentResponseInputStatusSuccess").equalsIgnoreCase("")==false)
						{
							if(HTMLDoc.indexOf(EncryptedRuleReader.get("paymentResponseInputStatusSuccess"))!=-1)
							{
								boolRespInputStatusSuccess = true;
								try
								{
									authRes = EncryptedRuleReader.getLocaleString("paymentGenericAuthResponseSuccessMsg");
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
			  	valueMap.put(EncryptedRuleReader.get("respInputOrderID"), (String)valueMap.get(EncryptedRuleReader.get("inputNameOrderID")));
			  }
			  catch(Exception e)
			  {
				e.printStackTrace();
			  }
			  try
			  {
			  	valueMap.put(EncryptedRuleReader.get("respInputTotal"), getTotalPrice());
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
						authRes = EncryptedRuleReader.getLocaleString("paymentGenericAuthResponseSuccessMsg");
					}
					catch(Exception e)
					{}
				}
			  	valueMap.put(EncryptedRuleReader.get("respInputAuthResponse"),authRes);
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
							authRes = EncryptedRuleReader.getLocaleString("paymentGenericAuthResponseFailureMsg");
						}
						catch(Exception e)
						{}
					}
				}
				else
				{
					try
					{
						authRes = EncryptedRuleReader.getLocaleString("paymentGenericAuthResponseFailureMsg");
					}
					catch(Exception e)
					{}
				}
				try
				{
			  	  valueMap.put(EncryptedRuleReader.get("respInputAuthResponse"),authRes);
				}
				catch(Exception e)
				{
				}
                          //Count the Failure Attempts for Lockdown on max attempts exceeded.
                          EncryptedRuleReader.attemptPayment();
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
                    if(EncryptedRuleReader.get("unknownHostExceptionAction")!=null)
                    {
                        try
                        {
                            Class.forName(EncryptedRuleReader.get("unknownHostExceptionAction")).newInstance();
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
	              if(EncryptedRuleReader.get("paymentResponseStatTotalMessages")!=null)
                    {
                        int theTotalDeclinedMessages = Integer.valueOf(EncryptedRuleReader.get("paymentResponseStatTotalMessages")).intValue();
                        if(theTotalDeclinedMessages>1)
                        {
					msgMap = new HashMap(theTotalDeclinedMessages);
                            for(int i = 0;i<theTotalDeclinedMessages;i++)
                            {
					try
					{
						msgMap.put(EncryptedRuleReader.get("paymentResponseStatDeclined" + String.valueOf(i + 1)), EncryptedRuleReader.getLocaleString("paymentResponseMsgDeclined" + String.valueOf(i + 1)));
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
	              if(EncryptedRuleReader.get("paymentResponseStatTotalMessages")!=null)
                    {
                        int theTotalDeclinedMessages = Integer.valueOf(EncryptedRuleReader.get("paymentResponseStatTotalMessages")).intValue();
                        if(theTotalDeclinedMessages>1)
                        {
				    ArrayList theList = new ArrayList();
                            for(int i = 0;i<theTotalDeclinedMessages;i++)
                            {
					try
					{
						theList.add(EncryptedRuleReader.get("paymentResponseStatDeclined" + String.valueOf(i + 1)));
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
	              if(EncryptedRuleReader.get("paymentResponseStatTotalMessages")!=null)
                    {
                        int theTotalDeclinedMessages = Integer.valueOf(EncryptedRuleReader.get("paymentResponseStatTotalMessages")).intValue();
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
		return EncryptedRuleReader.getLocaleString("paymentGenericAuthResponseFailureMsg");
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
                getMessage(EncryptedRuleReader.getLocaleString("msgMsgTitle"), EncryptedRuleReader.getLocaleString("paymentFirstNameDataFieldEmptyMessage"));
                tfFirstName.grabFocus();       
                return false;
            }
        }
        catch(NullPointerException e)
        {
            getMessage(EncryptedRuleReader.getLocaleString("msgMsgTitle"),EncryptedRuleReader.getLocaleString("paymentFirstNameDataFieldEmptyMessage"));
            tfFirstName.grabFocus();
            return false;           
        }
        try
        {
            lastNameID=getLastName();
            if(lastNameID.equals(""))
            {
                getMessage(EncryptedRuleReader.getLocaleString("msgMsgTitle"),EncryptedRuleReader.getLocaleString("paymentLastNameDataFieldEmptyMessage"));
                tfLastName.grabFocus();         
                return false;                
            }
        }
        catch(NullPointerException e)
        {
            getMessage(EncryptedRuleReader.getLocaleString("msgMsgTitle"),EncryptedRuleReader.getLocaleString("paymentLastNameDataFieldEmptyMessage"));
            tfLastName.grabFocus();
            return false;            
        }    
        try
        {
            phone=getPhone();
		if(EncryptedRuleReader.get("paymentPhoneInputEnabled")!=null)
		{
			if(EncryptedRuleReader.get("paymentPhoneInputEnabled").equalsIgnoreCase("true")==true)
			{
            		if(phone.equals(""))
            		{
                			getMessage(EncryptedRuleReader.getLocaleString("msgMsgTitle"),EncryptedRuleReader.getLocaleString("paymentPhoneDataFieldEmptyMessage"));
                			tfPhone.grabFocus();         
                			return false;                
            		}
			}
		}
        }
        catch(NullPointerException e)
        {
            getMessage(EncryptedRuleReader.getLocaleString("msgMsgTitle"),EncryptedRuleReader.getLocaleString("paymentPhoneDataFieldEmptyMessage"));
            tfPhone.grabFocus();
            return false;            
        }  
        try
        {
            emailAddress = getEMailName();
            if(emailAddress.indexOf("@") == -1)
            {
                getMessage(EncryptedRuleReader.getLocaleString("msgMsgTitle"),EncryptedRuleReader.getLocaleString("paymentValidEMailDataFieldEmptyMessage"));
                tfEMail.grabFocus();
                return false;                
            }
            else if(emailAddress.indexOf(".") == -1)
            {
                getMessage(EncryptedRuleReader.getLocaleString("msgMsgTitle"),EncryptedRuleReader.getLocaleString("paymentValidEMailDataFieldEmptyMessage"));
                tfEMail.grabFocus();
                return false;                
            }
        }
        catch(NullPointerException e)
        {
            getMessage(EncryptedRuleReader.getLocaleString("msgMsgTitle"),EncryptedRuleReader.getLocaleString("paymentEMailDataFieldEmptyMessage"));
            tfEMail.grabFocus();
            return false;            
        }
        try
        {
            streetAddr=getAddress();
            if(streetAddr.equals(""))
            {
                getMessage(EncryptedRuleReader.getLocaleString("msgMsgTitle"),EncryptedRuleReader.getLocaleString("paymentStreetDataFieldEmptyMessage"));
                tfAddress.grabFocus();  
                return false;                
            }            
        }
        catch(NullPointerException e)
        {
            getMessage(EncryptedRuleReader.getLocaleString("msgMsgTitle"),EncryptedRuleReader.getLocaleString("paymentStreetDataFieldEmptyMessage"));
            tfAddress.grabFocus();
            return false;            
        }
        try
        {
            cityAddr=getCity();
            if(cityAddr.equals(""))
            {
                getMessage(EncryptedRuleReader.getLocaleString("msgMsgTitle"),EncryptedRuleReader.getLocaleString("paymentCityDataFieldEmptyMessage"));
                tfCity.grabFocus();
                return false;                
            }                
        }
        catch(NullPointerException e)
        {
            getMessage(EncryptedRuleReader.getLocaleString("msgMsgTitle"),EncryptedRuleReader.getLocaleString("paymentCityDataFieldEmptyMessage"));
            tfCity.grabFocus();
            return false;            
        }
        try
        {
            zipAddr=getZip();
            if(zipAddr.equals(""))
            {
                getMessage(EncryptedRuleReader.getLocaleString("msgMsgTitle"),EncryptedRuleReader.getLocaleString("paymentZipDataFieldEmptyMessage"));
                tfZipCode.grabFocus();  
                return false;                
            }                  
        }
        catch(NullPointerException e)
        {
            getMessage(EncryptedRuleReader.getLocaleString("msgMsgTitle"),EncryptedRuleReader.getLocaleString("paymentZipDataFieldEmptyMessage"));
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
                getMessage(EncryptedRuleReader.getLocaleString("msgMsgTitle"),EncryptedRuleReader.getLocaleString("paymentCCDataFieldEmptyMessage"));
                tfCC1.grabFocus();   
                return false;                
            }                    
        }
        catch(NullPointerException e)
        {
            getMessage(EncryptedRuleReader.getLocaleString("msgMsgTitle"),EncryptedRuleReader.getLocaleString("paymentCCDataFieldEmptyMessage"));
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
                    getMessage(EncryptedRuleReader.getLocaleString("msgMsgTitle"),EncryptedRuleReader.getLocaleString("paymentCCVerificationCodeFieldEmptyMessage"));
                    tfVerificationCode.grabFocus();  
                    return false;                    
                }                  
            }
        }
        catch(NullPointerException e)
        {
            getMessage(EncryptedRuleReader.getLocaleString("msgMsgTitle"),EncryptedRuleReader.getLocaleString("paymentCCVerificationCodeFieldEmptyMessage"));
            tfVerificationCode.grabFocus();
            return false;           
        }        
        String formRequestMethod = null;
        if(EncryptedRuleReader.get("formRequestMethod") != null)
        {
            formRequestMethod = EncryptedRuleReader.get("formRequestMethod");
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
            if(EncryptedRuleReader.get("product_price")!=null)
            {
                    return EncryptedRuleReader.get("product_price");
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
		return verificationCodeObjectIsVisible;
    }	   
    
    public static String[] getPaymentMethodsToDisplay()
    {
        try
        {
            if(EncryptedRuleReader.get("paymentMethods")!=null)
            {
                String paymentMethodsList=EncryptedRuleReader.get("paymentMethods");
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
        
        if(EncryptedRuleReader.get("formActionURL")!=null)
        {
            formActionURL=EncryptedRuleReader.get("formActionURL");
        }
        if(EncryptedRuleReader.get("formRequestMethod")!=null)
        {        
            theRequestType=EncryptedRuleReader.get("formRequestMethod");
        }
        if(EncryptedRuleReader.get("inputNameFirstName")!=null)
        {        
            inputNameFirstName=EncryptedRuleReader.get("inputNameFirstName");
        }
        if(EncryptedRuleReader.get("inputNameLastName")!=null)
        {        
            inputNameLastName=EncryptedRuleReader.get("inputNameLastName");
        }
if(EncryptedRuleReader.get("paymentPhoneInputEnabled")!=null)
{
	if(EncryptedRuleReader.get("paymentPhoneInputEnabled").equalsIgnoreCase("true")==true)
	{
        if(EncryptedRuleReader.get("inputNamePhone")!=null)
        {        
            inputNamePhone=EncryptedRuleReader.get("inputNamePhone");
        }
	}
}
        if(EncryptedRuleReader.get("inputNameEMail")!=null)
        {       
            inputNameEMail=EncryptedRuleReader.get("inputNameEMail");
        }
        if(EncryptedRuleReader.get("inputNameAddress")!=null)
        {        
            inputNameAddress=EncryptedRuleReader.get("inputNameAddress");
        }
        if(EncryptedRuleReader.get("inputNameCity")!=null)
        {        
            inputNameCity=EncryptedRuleReader.get("inputNameCity");
        }
        if(EncryptedRuleReader.get("inputNameState")!=null)
        {        
            inputNameState=EncryptedRuleReader.get("inputNameState");
        }
        if(EncryptedRuleReader.get("inputNameZip")!=null)
        {        
            inputNameZip=EncryptedRuleReader.get("inputNameZip");
        }
        if(EncryptedRuleReader.get("inputNameCountry")!=null)
        {        
            inputNameCountry=EncryptedRuleReader.get("inputNameCountry");
        }
        if(EncryptedRuleReader.get("inputNamePaymentMethod")!=null)
        {       
            inputNamePaymentMethod=EncryptedRuleReader.get("inputNamePaymentMethod");
        }
        if(EncryptedRuleReader.get("inputNameCC1")!=null)
        {        
            inputNameCC1=EncryptedRuleReader.get("inputNameCC1");
        }
        if(EncryptedRuleReader.get("inputNameCC2")!=null)
        {        
            inputNameCC2=EncryptedRuleReader.get("inputNameCC2");
        }
        if(EncryptedRuleReader.get("inputNameCC3")!=null)
        {        
            inputNameCC3=EncryptedRuleReader.get("inputNameCC3");
        }
        if(EncryptedRuleReader.get("inputNameCC4")!=null)
        {        
            inputNameCC4=EncryptedRuleReader.get("inputNameCC4");
        }
        if(EncryptedRuleReader.get("inputNameVerificationCode")!=null)
        {        
            inputNameVerificationCode=EncryptedRuleReader.get("inputNameVerificationCode");
        }
        if(EncryptedRuleReader.get("inputNameExpirationMonth")!=null)
        {        
            inputNameExpirationMonth=EncryptedRuleReader.get("inputNameExpirationMonth");
        }
        if(EncryptedRuleReader.get("inputNameExpirationYear")!=null)
        {       
            inputNameExpirationYear=EncryptedRuleReader.get("inputNameExpirationYear");
        }
        if(EncryptedRuleReader.get("inputNameMerchant")!=null)
        {       
            inputNameMerchant=EncryptedRuleReader.get("inputNameMerchant");
        }
        if(EncryptedRuleReader.get("inputNameOrderID")!=null)
        {        
            inputNameOrderID=EncryptedRuleReader.get("inputNameOrderID");
        }
        if(EncryptedRuleReader.get("inputNameNameOnCard")!=null)
        {        
            inputNameNameOnCard=EncryptedRuleReader.get("inputNameNameOnCard");
        }
        if(EncryptedRuleReader.get("inputNameResponseURL")!=null)
        {        
            inputNameResponseURL=EncryptedRuleReader.get("inputNameResponseURL");
        }
        if(EncryptedRuleReader.get("inputNameTotal")!=null)
        {        
            inputNameTotal=EncryptedRuleReader.get("inputNameTotal");
        }
        if(EncryptedRuleReader.get("orderIDLeadingID")!=null)
        {        
            orderIDLeadingID=EncryptedRuleReader.get("orderIDLeadingID");
        }
        if(EncryptedRuleReader.get("product_price")!=null)
        {        
            totalPrice=EncryptedRuleReader.get("product_price");     
        }
        if(EncryptedRuleReader.get("merchantValue")!=null)
        {        
            merchantValue=EncryptedRuleReader.get("merchantValue");         
        }
         if(EncryptedRuleReader.get("responseURLValue")!=null)
        {        
            responseURLValue=EncryptedRuleReader.get("responseURLValue");         
        }
        if(EncryptedRuleReader.get("paymentInputHiddenNames")!=null)
        {       
            inputNames=EncryptedRuleReader.get("paymentInputHiddenNames");
            if(EncryptedRuleReader.get("paymentInputHiddenValues")!=null)
            {        
                inputValues=EncryptedRuleReader.get("paymentInputHiddenValues");
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
			if(EncryptedRuleReader.get("paymentCCIsSingleInputEnabled")!=null)
			{
				if(EncryptedRuleReader.get("paymentCCIsSingleInputEnabled").equalsIgnoreCase("true")==true)
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
			if(EncryptedRuleReader.get("paymentSeparateFirstAndLastNameInputsEnabled")!=null)
			{
				if(EncryptedRuleReader.get("paymentSeparateFirstAndLastNameInputsEnabled").equalsIgnoreCase("true")==true)
				{
					nameInputsComplete = inputNameFirstName + "=" + URLEncoder.encode(getFirstName()) + "&" + inputNameLastName + "=" + URLEncoder.encode(getLastName());
				}
			}
			if(EncryptedRuleReader.get("paymentFullNameInputEnabled")!=null)
			{
				if(EncryptedRuleReader.get("paymentFullNameInputEnabled").equalsIgnoreCase("true")==true)
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
                sb.append(inputNameMerchant + "=" + URLEncoder.encode(merchantValue) + "&" + inputNameOrderID + "=" + URLEncoder.encode(orderIDLeadingID + ((com.trinity.ea.idef.IOrderIDGenerator)Class.forName(EncryptedRuleReader.get("orderIDGeneratorAction")).newInstance()).getOrderID()) + "&" + nameInputsComplete + "&" + inputNameResponseURL + "=" + responseURLValue + "&" + inputNameEMail + "=" + URLEncoder.encode(getEMailName()) + phoneInputsComplete + "&" + inputNameAddress + "=" + URLEncoder.encode(getAddress()) + "&" + inputNameCity + "=" + URLEncoder.encode(getCity()) + "&" + inputNameTotal + "=" + URLEncoder.encode(totalPrice) + "&" + inputNameState + "=" + URLEncoder.encode(state1.getStateID(getState())) + "&" + inputNameZip + "=" + URLEncoder.encode(getZip()) + "&" + inputNameCountry + "=" + URLEncoder.encode(country1.getCountryID(getCountry())) + "&" + inputNamePaymentMethod + "=" + URLEncoder.encode(getPaymentMethod()) + "&" + ccInputsComplete + "&" + inputNameExpirationMonth + "=" + URLEncoder.encode(getExpirationMonth()) + "&" + inputNameExpirationYear + "=" + URLEncoder.encode(getExpirationYear()));
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

 public void paint(Graphics g)
{
Graphics2D g2 = (Graphics2D) g;

g2.setRenderingHint(
RenderingHints.KEY_TEXT_ANTIALIASING,
RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

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
	  if(EncryptedRuleReader.get("btnBarImgButtonsEnabled")!=null)
	  {
	  	if(EncryptedRuleReader.get("btnBarImgButtonsEnabled").equalsIgnoreCase("true")==true)
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
}
