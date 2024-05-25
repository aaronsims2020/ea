/*
 * PaymentSuccessCenterPanel.java
 *
 * Created on July 8, 2004, 3:39 PM
 */
package com.trinity.ea.forms.payment;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.net.URLDecoder;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class PaymentSuccessCenterPanel extends javax.swing.JPanel {
    private Map respMap = null; 
    private String respInputStatus="";
    private String respInputNameonCard="";
    private String respInputEmail="";
    private String respInputTotal="";
    private String respInputAuthResponse="";
    private String respInputOrderID="";
    private String respInputCardName="";
    private String respInputCardStreet="";
    private String respInputCardCity="";
    private String respInputCardState="";
    private String respInputCardCountry="";
    private String respInputCardZip="";
    private String respInputCardnumber="";
    
    /** Creates new form PaymentSuccessCenterPanel */
    public PaymentSuccessCenterPanel(Map responseMap) {
	try
	{
        EncryptedRuleReader.register(((String)getStringArraysFromString(EncryptedRuleReader.get("registeredCode").trim())[0]));
      }
	catch(Exception e)
	{
		e.printStackTrace();
	}  
        respMap=responseMap;
        if(respMap!=null)
        {
            if(EncryptedRuleReader.get("respInputStatus")!=null)
            {
                if(respMap.get(EncryptedRuleReader.get("respInputStatus"))!=null)
                {
                    respInputStatus = URLDecoder.decode((String)respMap.get(EncryptedRuleReader.get("respInputStatus")));
                }
            }
            
            if(EncryptedRuleReader.get("respInputNameonCard")!=null)
            {
                if(respMap.get(EncryptedRuleReader.get("respInputNameonCard"))!=null)
                {
                    respInputNameonCard = URLDecoder.decode((String)respMap.get(EncryptedRuleReader.get("respInputNameonCard")));
                }
            }
 
            if(EncryptedRuleReader.get("respInputEmail")!=null)
            {           
                if(respMap.get(EncryptedRuleReader.get("respInputEmail"))!=null)
                {
                    respInputEmail = URLDecoder.decode((String)respMap.get(EncryptedRuleReader.get("respInputEmail")));
                } 
            }
        
            if(EncryptedRuleReader.get("respInputTotal")!=null)
            {               
                if(respMap.get(EncryptedRuleReader.get("respInputTotal"))!=null)
                {
                    respInputTotal = URLDecoder.decode((String)respMap.get(EncryptedRuleReader.get("respInputTotal")));
                }  
            }
            
            if(EncryptedRuleReader.get("respInputAuthResponse")!=null)
            {                        
                if(respMap.get(EncryptedRuleReader.get("respInputAuthResponse"))!=null)
                {
                    respInputAuthResponse = URLDecoder.decode((String)respMap.get(EncryptedRuleReader.get("respInputAuthResponse")));
                }  
            }
            
            if(EncryptedRuleReader.get("respInputOrderID")!=null)
            {                                
                if(respMap.get(EncryptedRuleReader.get("respInputOrderID"))!=null)
                {
                    respInputOrderID = URLDecoder.decode((String)respMap.get(EncryptedRuleReader.get("respInputOrderID")));
                }            
            }
            
            if(EncryptedRuleReader.get("respInputCardName")!=null)
            {                  
                if(respMap.get(EncryptedRuleReader.get("respInputCardName"))!=null)
                {
                    respInputCardName = URLDecoder.decode((String)respMap.get(EncryptedRuleReader.get("respInputCardName")));
                }
            }
            
            if(EncryptedRuleReader.get("respInputCardStreet")!=null)
            {                 
                if(respMap.get(EncryptedRuleReader.get("respInputCardStreet"))!=null)
                {
                    respInputCardStreet = URLDecoder.decode((String)respMap.get(EncryptedRuleReader.get("respInputCardStreet")));
                }     
            }
            
            if(EncryptedRuleReader.get("respInputCardCity")!=null)
            {               
                if(respMap.get(EncryptedRuleReader.get("respInputCardCity"))!=null)
                {
                    respInputCardCity = URLDecoder.decode((String)respMap.get(EncryptedRuleReader.get("respInputCardCity")));
                }        
            }
            
            if(EncryptedRuleReader.get("respInputCardState")!=null)
            {                
                if(respMap.get(EncryptedRuleReader.get("respInputCardState"))!=null)
                {
                    respInputCardState = URLDecoder.decode((String)respMap.get(EncryptedRuleReader.get("respInputCardState")));
                }
            }

            if(EncryptedRuleReader.get("respInputCardCountry")!=null)
            {               
                if(respMap.get(EncryptedRuleReader.get("respInputCardCountry"))!=null)
                {
                    respInputCardCountry = URLDecoder.decode((String)respMap.get(EncryptedRuleReader.get("respInputCardCountry")));
                } 
            }
 
            if(EncryptedRuleReader.get("respInputCardZip")!=null)
            {                  
                if(respMap.get(EncryptedRuleReader.get("respInputCardZip"))!=null)
                {
                    respInputCardZip = URLDecoder.decode((String)respMap.get(EncryptedRuleReader.get("respInputCardZip")));
                }  
            }
            
            if(EncryptedRuleReader.get("respInputCardnumber")!=null)
            {                 
                if(respMap.get(EncryptedRuleReader.get("respInputCardnumber"))!=null)
                {
                    respInputCardnumber = URLDecoder.decode((String)respMap.get(EncryptedRuleReader.get("respInputCardnumber")));
                }
            }
        }
        initComponents();
        AccountNumber.setText(respInputAuthResponse);
        OrderID.setText(respInputOrderID);
        NameonCard.setText(respInputNameonCard);
        EMailAddress.setText(respInputEmail);
        //CreditCardName.setText(respInputCardName);
        AmountBilled.setText(respInputTotal); 
	  if(EncryptedRuleReader.get("paymentBackgroundColor")!=null)
	  {
		if(EncryptedRuleReader.get("paymentBackgroundColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("paymentBackgroundColor"));
			setBackgroundColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
		else
		{
			tpDescription.setBackground(getBackground());
		}
	  }
	  else
	  {
		tpDescription.setBackground(getBackground());
	  }

	  if(EncryptedRuleReader.get("paymentLabelTextColor")!=null)
	  {
		if(EncryptedRuleReader.get("paymentLabelTextColor").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("paymentLabelTextColor"));
				setLabelTextColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
			catch(Exception e)
			{
        			e.printStackTrace();
			}
		}
	  }    
	  if(EncryptedRuleReader.get("paymentSuccessLabelBGColor")!=null)
	  {
		if(EncryptedRuleReader.get("paymentSuccessLabelBGColor").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("paymentSuccessLabelBGColor"));
				setLabelBackgroundColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
			catch(Exception e)
			{
        			e.printStackTrace();
			}
		}
	  } 
	  if(EncryptedRuleReader.get("paymentSuccessLabelFont")!=null)
	  {
		if(EncryptedRuleReader.get("paymentSuccessLabelFont").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("paymentSuccessLabelFont"));
				setLabelFont(new java.awt.Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
			catch(Exception e)
			{
        			e.printStackTrace();
			}
		}
	  }
	  if(EncryptedRuleReader.get("paymentSuccessHeaderLabelFont")!=null)
	  {
		if(EncryptedRuleReader.get("paymentSuccessHeaderLabelFont").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("paymentSuccessHeaderLabelFont"));
				setHeaderFont(new java.awt.Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
			catch(Exception e)
			{
        			e.printStackTrace();
			}
		}
	  }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        lblOrderID = new javax.swing.JLabel();
        lblNameonCard = new javax.swing.JLabel();
        lblEMailAddress = new javax.swing.JLabel();
        lblAmountBilled = new javax.swing.JLabel();
        OrderID = new javax.swing.JLabel();
        NameonCard = new javax.swing.JLabel();
        EMailAddress = new javax.swing.JLabel();
        AmountBilled = new javax.swing.JLabel();
        tpDescription = new javax.swing.JTextPane();
        AccountNumber = new javax.swing.JLabel();

        setLayout(null);

        setMaximumSize(new java.awt.Dimension(519, 294));
        setMinimumSize(new java.awt.Dimension(519, 294));
        setPreferredSize(new java.awt.Dimension(519, 294));
	  if(EncryptedRuleReader.getLocaleString("paymentSuccessResponsePanelOrderID")!=null)
	  {
        	lblOrderID.setText(EncryptedRuleReader.getLocaleString("paymentSuccessResponsePanelOrderID"));
	  }
        lblOrderID.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(lblOrderID);
        lblOrderID.setBounds(28, 45, 70, 22);

	  if(EncryptedRuleReader.getLocaleString("paymentSuccessResponsePanelNameOnCard")!=null)
	  {
        	lblNameonCard.setText(EncryptedRuleReader.getLocaleString("paymentSuccessResponsePanelNameOnCard"));
	  }
        lblNameonCard.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(lblNameonCard);
        lblNameonCard.setBounds(28, 68, 110, 22);

	  if(EncryptedRuleReader.getLocaleString("paymentSuccessResponsePanelEMailAddress")!=null)
	  {
        	lblEMailAddress.setText(EncryptedRuleReader.getLocaleString("paymentSuccessResponsePanelEMailAddress"));
	  }
        lblEMailAddress.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(lblEMailAddress);
        lblEMailAddress.setBounds(28, 91, 100, 22);

	  if(EncryptedRuleReader.getLocaleString("paymentSuccessResponsePanelAmountBilled")!=null)
	  {
        	lblAmountBilled.setText(EncryptedRuleReader.getLocaleString("paymentSuccessResponsePanelAmountBilled"));
	  }
        lblAmountBilled.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(lblAmountBilled);
        lblAmountBilled.setBounds(28, 114, 100, 22);

        OrderID.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(OrderID);
        OrderID.setBounds(98, 45, 400, 22);

        NameonCard.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(NameonCard);
        NameonCard.setBounds(138, 68, 360, 22);

        EMailAddress.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(EMailAddress);
        EMailAddress.setBounds(128, 91, 370, 22);

        AmountBilled.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(AmountBilled);
        AmountBilled.setBounds(128, 114, 370, 22);

        tpDescription.setEditable(false);
	  if(EncryptedRuleReader.getLocaleString("paymentSuccessResponsePanelMessage")!=null)
	  {
        	tpDescription.setText(EncryptedRuleReader.getLocaleString("paymentSuccessResponsePanelMessage").replaceAll("\\\\r\\\\n", System.getProperty("line.separator")));
	  }
        add(tpDescription);
        tpDescription.setBounds(26, 135, 470, 150);

        add(AccountNumber);
        AccountNumber.setBounds(28, 13, 470, 25);

    }//GEN-END:initComponents

    private void setLabelTextColor(Color LColor)
    {
	try
	{
		AccountNumber.setForeground(LColor);
		AmountBilled.setForeground(LColor);
		EMailAddress.setForeground(LColor);
		NameonCard.setForeground(LColor);
		OrderID.setForeground(LColor);
		lblAmountBilled.setForeground(LColor);
		lblEMailAddress.setForeground(LColor);
		lblNameonCard.setForeground(LColor);
		lblOrderID.setForeground(LColor);
		tpDescription.setForeground(LColor);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

    private void setLabelFont(Font labelFont)
    {
	try
	{
		AmountBilled.setFont(labelFont);
		EMailAddress.setFont(labelFont);
		NameonCard.setFont(labelFont);
		OrderID.setFont(labelFont);
		lblAmountBilled.setFont(labelFont);
		lblEMailAddress.setFont(labelFont);
		lblNameonCard.setFont(labelFont);
		lblOrderID.setFont(labelFont);
		tpDescription.setFont(labelFont);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

    private void setHeaderFont(Font HFont)
    {
	try
	{
		AccountNumber.setFont(HFont);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

    private void setLabelBackgroundColor(Color BGColor)
    {
	try
	{
		AccountNumber.setBackground(BGColor);
		AmountBilled.setBackground(BGColor);
		EMailAddress.setBackground(BGColor);
		NameonCard.setBackground(BGColor);
		OrderID.setBackground(BGColor);
		lblAmountBilled.setBackground(BGColor);
		lblEMailAddress.setBackground(BGColor);
		lblNameonCard.setBackground(BGColor);
		lblOrderID.setBackground(BGColor);
		tpDescription.setBackground(BGColor);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AccountNumber;
    private javax.swing.JLabel AmountBilled;
    private javax.swing.JLabel EMailAddress;
    private javax.swing.JLabel NameonCard;
    private javax.swing.JLabel OrderID;
    private javax.swing.JLabel lblAmountBilled;
    private javax.swing.JLabel lblEMailAddress;
    private javax.swing.JLabel lblNameonCard;
    private javax.swing.JLabel lblOrderID;
    private javax.swing.JTextPane tpDescription;
    // End of variables declaration//GEN-END:variables
    
}
