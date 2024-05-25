/*
 * PaymentFailedCenterPanel.java
 *
 * Created on July 9, 2004, 5:37 PM
 */

package com.trinity.ea.design.payments.preview.payment;
import com.trinity.ea.design.common.file.ProjectManager;
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
	updateUIExpressionDefines();
        respMap=responseMap;
        if(respMap!=null)
        {
            if(ProjectManager.get("respInputStatus")!=null)
            {
                if(respMap.get(ProjectManager.get("respInputStatus"))!=null)
                {
                    respInputStatus = URLDecoder.decode((String)respMap.get(ProjectManager.get("respInputStatus")));
                }
            }
            
            if(ProjectManager.get("respInputNameonCard")!=null)
            {
                if(respMap.get(ProjectManager.get("respInputNameonCard"))!=null)
                {
                    respInputNameonCard = URLDecoder.decode((String)respMap.get(ProjectManager.get("respInputNameonCard")));
			  if(respInputNameonCard!=null){}
			  else
			  {
				if(respMap.get("respInputNameonCard")!=null)
				{
			   		respInputNameonCard = (String)respMap.get("respInputNameonCard");
				}
			  }
			  if(respInputNameonCard.equalsIgnoreCase("")==true || ProjectManager.get("respInputNameonCard").equalsIgnoreCase(respInputNameonCard)==true)
			  {
				if(respMap.get("respInputNameonCard")!=null)
				{
			   		respInputNameonCard = (String)respMap.get("respInputNameonCard");
				}
			  } 	
                }
		    else
		    {
            	if(respMap.get("respInputNameonCard")!=null)
            	{              
                    respInputNameonCard = (String)respMap.get("respInputNameonCard");
          		}
		    }  
            }
		else
		{
            	if(respMap.get("respInputNameonCard")!=null)
            	{              
                    respInputNameonCard = (String)respMap.get("respInputNameonCard");
          		}
		}
 
            if(ProjectManager.get("respInputEmail")!=null)
            {           
                if(respMap.get(ProjectManager.get("respInputEmail"))!=null)
                {
                    respInputEmail = URLDecoder.decode((String)respMap.get(ProjectManager.get("respInputEmail")));
			  if(respInputEmail!=null){}
			  else
			  {
				if(respMap.get("respInputEmail")!=null)
				{
			   		respInputEmail = (String)respMap.get("respInputEmail");
				}
			  }
			  if(respInputEmail.equalsIgnoreCase("")==true || ProjectManager.get("respInputEmail").equalsIgnoreCase(respInputEmail)==true)
			  {
				if(respMap.get("respInputEmail")!=null)
				{
			   		respInputEmail = (String)respMap.get("respInputEmail");
				}
			  } 	
                }
		    else
		    {
            	if(respMap.get("respInputEmail")!=null)
            	{              
                    respInputEmail = (String)respMap.get("respInputEmail");
          		}
		    }  
            }
		else
		{
            	if(respMap.get("respInputEmail")!=null)
            	{              
                    respInputEmail = (String)respMap.get("respInputEmail");
          		}
		}
        
            if(ProjectManager.get("respInputTotal")!=null)
            {               
                if(respMap.get(ProjectManager.get("respInputTotal"))!=null)
                {
                    respInputTotal = URLDecoder.decode((String)respMap.get(ProjectManager.get("respInputTotal")));
			  if(respInputTotal!=null){}
			  else
			  {
				if(respMap.get("respInputTotal")!=null)
				{
			   		respInputTotal = (String)respMap.get("respInputTotal");
				}
			  }
			  if(respInputTotal.equalsIgnoreCase("")==true || ProjectManager.get("respInputTotal").equalsIgnoreCase(respInputTotal)==true)
			  {
				if(respMap.get("respInputTotal")!=null)
				{
			   		respInputTotal = (String)respMap.get("respInputTotal");
				}
			  } 	
                }
		    else
		    {
            	if(respMap.get("respInputTotal")!=null)
            	{              
                    respInputTotal = (String)respMap.get("respInputTotal");
          		}
		    }  
            }
		else
		{
            	if(respMap.get("respInputTotal")!=null)
            	{              
                    respInputTotal = (String)respMap.get("respInputTotal");
          		}
		}
            
            if(ProjectManager.get("respInputAuthResponse")!=null)
            {                        
                if(respMap.get(ProjectManager.get("respInputAuthResponse"))!=null)
                {
                    respInputAuthResponse = URLDecoder.decode((String)respMap.get(ProjectManager.get("respInputAuthResponse")));
			  if(respInputAuthResponse!=null){}
			  else
			  {
				if(respMap.get("respInputAuthResponse")!=null)
				{
			   		respInputAuthResponse = (String)respMap.get("respInputAuthResponse");
				}
			  }
			  if(respInputAuthResponse.equalsIgnoreCase("")==true || ProjectManager.get("respInputAuthResponse").equalsIgnoreCase(respInputAuthResponse)==true)
			  {
				if(respMap.get("respInputAuthResponse")!=null)
				{
			   		respInputAuthResponse = (String)respMap.get("respInputAuthResponse");
				}
			  } 	
                }
		    else
		    {
            	if(ProjectManager.get("paymentGenericAuthResponseFailureMsg")!=null)
            	{              
                    respInputAuthResponse = ProjectManager.get("paymentGenericAuthResponseFailureMsg");
          		}
		    }  
            }
		else
		{
            	if(ProjectManager.get("paymentGenericAuthResponseFailureMsg")!=null)
            	{              
                    respInputAuthResponse = ProjectManager.get("paymentGenericAuthResponseFailureMsg");
          		}
		}
            
            if(ProjectManager.get("respInputOrderID")!=null)
            {                                
                if(respMap.get(ProjectManager.get("respInputOrderID"))!=null)
                {
                    respInputOrderID = URLDecoder.decode((String)respMap.get(ProjectManager.get("respInputOrderID")));
			  if(respInputOrderID!=null){}
			  else
			  {
				if(respMap.get("respInputOrderID")!=null)
				{
			   		respInputOrderID = (String)respMap.get("respInputOrderID");
				}
			  }
			  if(respInputOrderID.equalsIgnoreCase("")==true || ProjectManager.get("respInputOrderID").equalsIgnoreCase(respInputOrderID)==true)
			  {
				if(respMap.get("respInputOrderID")!=null)
				{
			   		respInputOrderID = (String)respMap.get("respInputOrderID");
				}
			  } 
                }  
		    else
		    {
			if(respMap.get("respInputOrderID")!=null)
			{
			   respInputOrderID = (String)respMap.get("respInputOrderID");
			}
		    }          
            }
		else
		{
			if(respMap.get("respInputOrderID")!=null)
			{
			   respInputOrderID = (String)respMap.get("respInputOrderID");
			}
		}
            
            if(ProjectManager.get("respInputCardName")!=null)
            {                  
                if(respMap.get(ProjectManager.get("respInputCardName"))!=null)
                {
                    respInputCardName = URLDecoder.decode((String)respMap.get(ProjectManager.get("respInputCardName")));
			  if(respInputCardName!=null){}
			  else
			  {
				if(respMap.get("respInputCardName")!=null)
				{
			   		respInputCardName = (String)respMap.get("respInputCardName");
				}
			  }
			  if(respInputCardName.equalsIgnoreCase("")==true || ProjectManager.get("respInputCardName").equalsIgnoreCase(respInputCardName)==true)
			  {
				if(respMap.get("respInputCardName")!=null)
				{
			   		respInputCardName = (String)respMap.get("respInputCardName");
				}
			  } 
                }
		    else
		    {
			if(respMap.get("respInputCardName")!=null)
			{
			   respInputCardName = (String)respMap.get("respInputCardName");
			}
		    }          
            }
		else
		{
			if(respMap.get("respInputCardName")!=null)
			{
			   respInputCardName = (String)respMap.get("respInputCardName");
			}
		}
            
            if(ProjectManager.get("respInputCardStreet")!=null)
            {                 
                if(respMap.get(ProjectManager.get("respInputCardStreet"))!=null)
                {
                    respInputCardStreet = URLDecoder.decode((String)respMap.get(ProjectManager.get("respInputCardStreet")));
                }     
            }
            
            if(ProjectManager.get("respInputCardCity")!=null)
            {               
                if(respMap.get(ProjectManager.get("respInputCardCity"))!=null)
                {
                    respInputCardCity = URLDecoder.decode((String)respMap.get(ProjectManager.get("respInputCardCity")));
                }        
            }
            
            if(ProjectManager.get("respInputCardState")!=null)
            {                
                if(respMap.get(ProjectManager.get("respInputCardState"))!=null)
                {
                    respInputCardState = URLDecoder.decode((String)respMap.get(ProjectManager.get("respInputCardState")));
                }
            }

            if(ProjectManager.get("respInputCardCountry")!=null)
            {               
                if(respMap.get(ProjectManager.get("respInputCardCountry"))!=null)
                {
                    respInputCardCountry = URLDecoder.decode((String)respMap.get(ProjectManager.get("respInputCardCountry")));
                } 
            }
 
            if(ProjectManager.get("respInputCardZip")!=null)
            {                  
                if(respMap.get(ProjectManager.get("respInputCardZip"))!=null)
                {
                    respInputCardZip = URLDecoder.decode((String)respMap.get(ProjectManager.get("respInputCardZip")));
                }  
            }
            
            if(ProjectManager.get("respInputCardnumber")!=null)
            {                 
                if(respMap.get(ProjectManager.get("respInputCardnumber"))!=null)
                {
                    respInputCardnumber = URLDecoder.decode((String)respMap.get(ProjectManager.get("respInputCardnumber")));
                }
            }
        }
        initComponents();
        AccountNumber.setText(replaceUIExpressions(respInputAuthResponse));
        OrderID.setText(replaceUIExpressions(respInputOrderID));
        NameonCard.setText(replaceUIExpressions(respInputNameonCard));
        EMailAddress.setText(replaceUIExpressions(respInputEmail));
        //CreditCardName.setText(replaceUIExpressions(respInputCardName));
        AmountBilled.setText(replaceUIExpressions(respInputTotal));
	  if(ProjectManager.get("paymentBackgroundColor")!=null)
	  {
		if(ProjectManager.get("paymentBackgroundColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentBackgroundColor"));
			setBackground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }
	  if(ProjectManager.get("paymentLabelTextColor")!=null)
	  {
		if(ProjectManager.get("paymentLabelTextColor").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentLabelTextColor"));
				setLabelTextColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
			catch(Exception e)
			{
        			e.printStackTrace();
			}
		}
	  }    
	  if(ProjectManager.get("paymentFailureLabelBGColor")!=null)
	  {
		if(ProjectManager.get("paymentFailureLabelBGColor").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentFailureLabelBGColor"));
				setLabelBackgroundColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
			catch(Exception e)
			{
        			e.printStackTrace();
			}
		}
	  } 
	  if(ProjectManager.get("paymentFailureLabelFont")!=null)
	  {
		if(ProjectManager.get("paymentFailureLabelFont").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentFailureLabelFont"));
				setLabelFont(new java.awt.Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
			catch(Exception e)
			{
        			e.printStackTrace();
			}
		}
	  }
	  if(ProjectManager.get("paymentFailureHeaderLabelFont")!=null)
	  {
		if(ProjectManager.get("paymentFailureHeaderLabelFont").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentFailureHeaderLabelFont"));
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

        lblOrderID.setText(replaceUIExpressions(ProjectManager.get("paymentFailureResponsePanelOrderID")));
        lblOrderID.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(lblOrderID);
        lblOrderID.setBounds(10, 47, 70, 21);

        OrderID.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(OrderID);
        OrderID.setBounds(80, 47, 260, 21);

        lblNameonCard.setText(replaceUIExpressions(ProjectManager.get("paymentFailureResponsePanelNameOnCard")));
        lblNameonCard.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(lblNameonCard);
        lblNameonCard.setBounds(10, 68, 110, 21);

        NameonCard.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(NameonCard);
        NameonCard.setBounds(120, 68, 320, 21);

        lblEMailAddress.setText(replaceUIExpressions(ProjectManager.get("paymentFailureResponsePanelEMailAddress")));
        lblEMailAddress.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(lblEMailAddress);
        lblEMailAddress.setBounds(10, 89, 100, 21);

        EMailAddress.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(EMailAddress);
        EMailAddress.setBounds(110, 89, 230, 21);

        lblAmountBilled.setText(replaceUIExpressions(ProjectManager.get("paymentFailureResponsePanelAmountBilled")));
        lblAmountBilled.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(lblAmountBilled);
        lblAmountBilled.setBounds(10, 110, 100, 21);

        AmountBilled.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(AmountBilled);
        AmountBilled.setBounds(110, 110, 230, 21);

        lblFooterRetryDesc.setText(replaceUIExpressions(ProjectManager.get("paymentFailureResponsePanelMessage")));
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
