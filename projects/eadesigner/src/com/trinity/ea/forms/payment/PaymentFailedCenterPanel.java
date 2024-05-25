/*
 * PaymentFailedCenterPanel.java
 *
 * Created on July 9, 2004, 5:37 PM
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
public class PaymentFailedCenterPanel extends javax.swing.JPanel {
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

    /** Creates new form PaymentFailedCenterPanel */
    public PaymentFailedCenterPanel(Map responseMap) {
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
			setBackground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
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
	  if(EncryptedRuleReader.get("paymentFailureLabelBGColor")!=null)
	  {
		if(EncryptedRuleReader.get("paymentFailureLabelBGColor").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("paymentFailureLabelBGColor"));
				setLabelBackgroundColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
			catch(Exception e)
			{
        			e.printStackTrace();
			}
		}
	  } 
	  if(EncryptedRuleReader.get("paymentFailureLabelFont")!=null)
	  {
		if(EncryptedRuleReader.get("paymentFailureLabelFont").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("paymentFailureLabelFont"));
				setLabelFont(new java.awt.Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
			catch(Exception e)
			{
        			e.printStackTrace();
			}
		}
	  }
	  if(EncryptedRuleReader.get("paymentFailureHeaderLabelFont")!=null)
	  {
		if(EncryptedRuleReader.get("paymentFailureHeaderLabelFont").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("paymentFailureHeaderLabelFont"));
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
        AccountNumber = new javax.swing.JLabel();
        lblOrderID = new javax.swing.JLabel();
        OrderID = new javax.swing.JLabel();
        lblNameonCard = new javax.swing.JLabel();
        NameonCard = new javax.swing.JLabel();
        lblEMailAddress = new javax.swing.JLabel();
        EMailAddress = new javax.swing.JLabel();
        lblAmountBilled = new javax.swing.JLabel();
        AmountBilled = new javax.swing.JLabel();
        lblFooterRetryDesc = new javax.swing.JLabel();

        setLayout(null);

        AccountNumber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        AccountNumber.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        AccountNumber.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        add(AccountNumber);
        AccountNumber.setBounds(9, 12, 330, 35);

        lblOrderID.setText(EncryptedRuleReader.getLocaleString("paymentFailureResponsePanelOrderID"));
        lblOrderID.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(lblOrderID);
        lblOrderID.setBounds(10, 47, 70, 21);

        OrderID.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(OrderID);
        OrderID.setBounds(80, 47, 260, 21);

        lblNameonCard.setText(EncryptedRuleReader.getLocaleString("paymentFailureResponsePanelNameOnCard"));
        lblNameonCard.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(lblNameonCard);
        lblNameonCard.setBounds(10, 68, 110, 21);

        NameonCard.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(NameonCard);
        NameonCard.setBounds(120, 68, 320, 21);

        lblEMailAddress.setText(EncryptedRuleReader.getLocaleString("paymentFailureResponsePanelEMailAddress"));
        lblEMailAddress.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(lblEMailAddress);
        lblEMailAddress.setBounds(10, 89, 100, 21);

        EMailAddress.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(EMailAddress);
        EMailAddress.setBounds(110, 89, 230, 21);

        lblAmountBilled.setText(EncryptedRuleReader.getLocaleString("paymentFailureResponsePanelAmountBilled"));
        lblAmountBilled.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(lblAmountBilled);
        lblAmountBilled.setBounds(10, 110, 100, 21);

        AmountBilled.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(AmountBilled);
        AmountBilled.setBounds(110, 110, 230, 21);

        lblFooterRetryDesc.setText(EncryptedRuleReader.getLocaleString("paymentFailureResponsePanelMessage"));
        lblFooterRetryDesc.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(lblFooterRetryDesc);
        lblFooterRetryDesc.setBounds(9, 131, 330, 21);

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
		lblFooterRetryDesc.setForeground(LColor);
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
		lblFooterRetryDesc.setFont(labelFont);
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
		lblFooterRetryDesc.setBackground(BGColor);
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
    private javax.swing.JLabel lblFooterRetryDesc;
    private javax.swing.JLabel lblEMailAddress;
    private javax.swing.JLabel lblNameonCard;
    private javax.swing.JLabel lblOrderID;
    // End of variables declaration//GEN-END:variables
    
}
