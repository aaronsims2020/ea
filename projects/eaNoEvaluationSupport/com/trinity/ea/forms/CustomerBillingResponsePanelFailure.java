/*
 * CustomerBillingResponsePanelFailure.java
 *
 * Created on October 29, 2003, 11:28 PM
 */

package com.trinity.ea.forms;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.net.URLDecoder;
/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2003 Trinity Software. All rights reserved.
 */
public class CustomerBillingResponsePanelFailure extends javax.swing.JPanel 
{
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
    /** Creates new form CustomerBillingResponsePanel */
    public CustomerBillingResponsePanelFailure(Map responseMap) 
    {
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
        CreditCardName.setText(respInputCardName);
        AmountBilled.setText(respInputTotal);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        lblKazaamLogo = new javax.swing.JLabel();
        tpTitle = new javax.swing.JTextPane();
        lblOrderID = new javax.swing.JLabel();
        lblNameonCard = new javax.swing.JLabel();
        lblEMailAddress = new javax.swing.JLabel();
        lblCreditCardName = new javax.swing.JLabel();
        lblAmountBilled = new javax.swing.JLabel();
        AccountNumber = new javax.swing.JLabel();
        OrderID = new javax.swing.JLabel();
        NameonCard = new javax.swing.JLabel();
        EMailAddress = new javax.swing.JLabel();
        CreditCardName = new javax.swing.JLabel();
        AmountBilled = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        taDescription = new javax.swing.JTextArea();

        setLayout(null);

        setBackground(new java.awt.Color(255, 255, 255));
        lblKazaamLogo.setBackground(new java.awt.Color(255, 255, 255));
        lblKazaamLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/kazaam_120px.jpg")));
        if(EncryptedRuleReader.get("paymentFailureResponsePanelImagePath")!=null)
        {
             lblKazaamLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource(EncryptedRuleReader.get("paymentFailureResponsePanelImagePath"))));
        }
        add(lblKazaamLogo);
        if(EncryptedRuleReader.get("paymentFailureResponsePanelImagePath")!=null)
        {
	try
	{		
             lblKazaamLogo.setBounds(10, 10, new Integer(EncryptedRuleReader.get("paymentFailureResponsePanelImageWidth")).intValue(), new Integer(EncryptedRuleReader.get("paymentFailureResponsePanelImageHeight")).intValue());
	}
	catch(NullPointerException e)
	{
		lblKazaamLogo.setBounds(10, 10, 120, 68);
	}
	  }


        tpTitle.setFont(new java.awt.Font("Tahoma", 0, 14));
        tpTitle.setText(EncryptedRuleReader.get("paymentFailureResponsePanelHeaderDescription"));
        add(tpTitle);
        tpTitle.setBounds(140, 10, 340, 70);

        lblOrderID.setBackground(new java.awt.Color(255, 255, 255));
        lblOrderID.setFont(new java.awt.Font("Tahoma", 0, 14));
        lblOrderID.setText(EncryptedRuleReader.get("paymentFailureResponsePanelOrderID"));
        add(lblOrderID);
        lblOrderID.setBounds(20, 120, 80, 25);

        lblNameonCard.setBackground(new java.awt.Color(255, 255, 255));
        lblNameonCard.setFont(new java.awt.Font("Tahoma", 0, 14));
        lblNameonCard.setText(EncryptedRuleReader.get("paymentFailureResponsePanelNameOnCard"));
        add(lblNameonCard);
        lblNameonCard.setBounds(20, 140, 126, 25);

        lblEMailAddress.setBackground(new java.awt.Color(255, 255, 255));
        lblEMailAddress.setFont(new java.awt.Font("Tahoma", 0, 14));
        lblEMailAddress.setText(EncryptedRuleReader.get("paymentFailureResponsePanelEMailAddress"));
        add(lblEMailAddress);
        lblEMailAddress.setBounds(20, 160, 120, 25);

        lblCreditCardName.setBackground(new java.awt.Color(255, 255, 255));
        lblCreditCardName.setFont(new java.awt.Font("Tahoma", 0, 14));
        lblCreditCardName.setText(EncryptedRuleReader.get("paymentFailureResponsePanelCCType"));
        add(lblCreditCardName);
        lblCreditCardName.setBounds(20, 180, 142, 25);

        lblAmountBilled.setBackground(new java.awt.Color(255, 255, 255));
        lblAmountBilled.setFont(new java.awt.Font("Tahoma", 0, 14));        
	  lblAmountBilled.setText(EncryptedRuleReader.get("paymentFailureResponsePanelAmountBilled"));

        add(lblAmountBilled);
        lblAmountBilled.setBounds(20, 200, 120, 25);

        AccountNumber.setBackground(new java.awt.Color(255, 255, 255));
        AccountNumber.setFont(new java.awt.Font("Tahoma", 0, 14));
        add(AccountNumber);
        AccountNumber.setBounds(20, 90, 450, 25);

        OrderID.setBackground(new java.awt.Color(255, 255, 255));
        OrderID.setFont(new java.awt.Font("Tahoma", 1, 14));
        add(OrderID);
        OrderID.setBounds(90, 120, 400, 25);

        NameonCard.setBackground(new java.awt.Color(255, 255, 255));
        NameonCard.setFont(new java.awt.Font("Tahoma", 1, 14));
        add(NameonCard);
        NameonCard.setBounds(130, 140, 400, 25);

        EMailAddress.setBackground(new java.awt.Color(255, 255, 255));
        EMailAddress.setFont(new java.awt.Font("Tahoma", 1, 14));
        add(EMailAddress);
        EMailAddress.setBounds(120, 160, 400, 25);

        CreditCardName.setBackground(new java.awt.Color(255, 255, 255));
        CreditCardName.setFont(new java.awt.Font("Tahoma", 1, 14));
        add(CreditCardName);
        CreditCardName.setBounds(140, 180, 400, 25);

        AmountBilled.setBackground(new java.awt.Color(255, 255, 255));
        AmountBilled.setFont(new java.awt.Font("Tahoma", 1, 14));
        add(AmountBilled);
        AmountBilled.setBounds(120, 200, 400, 25);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton1.setText("Retry");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        add(jButton1);
        jButton1.setBounds(380, 230, 81, 26);

        taDescription.setFont(new java.awt.Font("Tahoma", 0, 14));
        taDescription.setLineWrap(true);
        taDescription.setText(EncryptedRuleReader.get("paymentFailureResponsePanelMessage"));
        taDescription.setWrapStyleWord(true);
        add(taDescription);
        taDescription.setBounds(20, 240, 370, 20);

    }//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            // TODO: Command Line implementation
            // TODO: MIDP implementation
            // Trial Expired
            //System.out.println("Attempting to read property expired action. ");
            if(EncryptedRuleReader.get("paymentReceiptFailedRetryAction")!=null)
            {
                try
                {
                   JDialog theDialog=(JDialog)this.getTopLevelAncestor();
                   theDialog.dispose();
                    Class.forName(EncryptedRuleReader.get("paymentReceiptFailedRetryAction")).newInstance();
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
e.printStackTrace();
                }       
            }
            else
            {
                //Problem in Properties File
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AccountNumber;
    private javax.swing.JLabel AmountBilled;
    private javax.swing.JLabel CreditCardName;
    private javax.swing.JLabel EMailAddress;
    private javax.swing.JLabel NameonCard;
    private javax.swing.JLabel OrderID;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblAmountBilled;
    private javax.swing.JLabel lblCreditCardName;
    private javax.swing.JLabel lblEMailAddress;
    private javax.swing.JLabel lblKazaamLogo;
    private javax.swing.JLabel lblNameonCard;
    private javax.swing.JLabel lblOrderID;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTextPane tpTitle;
    // End of variables declaration//GEN-END:variables
    
}
