/*
 * dlgCustomerBillingResponsePanelSuccess.java
 *
 * Created on October 30, 2003, 2:31 AM
 */

package com.trinity.ea.forms.payment;
import com.trinity.ea.forms.payment.PaymentValidationHeaderPanel;
import com.trinity.ea.forms.payment.PaymentSuccessCenterPanel;
import com.trinity.ea.forms.payment.PaymentSuccessFooterPanel;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import com.trinity.ea.forms.gui.swing.ImageBackgroundBorder;
import javax.swing.border.Border;
import java.io.ByteArrayInputStream;
import javax.imageio.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2005 Trinity Software. All rights reserved.
 */
public class dlgCustomerBillingResponsePanelSuccess extends javax.swing.JDialog {
    private Map respMap = null;      
    /** Creates new form dlgCustomerBillingResponsePanelSuccess */
    public dlgCustomerBillingResponsePanelSuccess(Map responseMap, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        respMap=responseMap;
        initComponents();
        //setSize(528,458);
        setResizable(false);
                // Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        int w = getSize().width;
        int h = getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;

        // Move the window
        setLocation(x, y);
   	try
	{
	  	  applyComponentOrientation(ComponentOrientation.getOrientation(EncryptedRuleReader.getLocale()));
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
        RootPanel = new javax.swing.JPanel();
        PaymentSuccessCenterPanel1 = new com.trinity.ea.forms.payment.PaymentSuccessCenterPanel(respMap);
        PaymentValidationHeaderPanel1 = new com.trinity.ea.forms.payment.PaymentValidationHeaderPanel();
        PaymentSuccessFooterPanel1 = new com.trinity.ea.forms.payment.PaymentSuccessFooterPanel();
	  RootPanel.setLayout(new javax.swing.BoxLayout(RootPanel, javax.swing.BoxLayout.Y_AXIS));
	  PaymentSuccessCenterPanel1.setLayout(null);
        PaymentSuccessCenterPanel1.setPreferredSize(new java.awt.Dimension(519, 294));
        PaymentValidationHeaderPanel1.setPreferredSize(new java.awt.Dimension(519, 102));
        PaymentSuccessFooterPanel1.setPreferredSize(new java.awt.Dimension(519, 42));
	try
	{ 
if(EncryptedRuleReader.getLocaleString("paymentRespSuccessBackgroundImagePath")!=null)
{
 	if(EncryptedRuleReader.getLocaleString("paymentRespSuccessBackgroundImagePath").equalsIgnoreCase("")==false)
	{
        final Border bkgrnd = new ImageBackgroundBorder(ImageIO.read(new ByteArrayInputStream(EncryptedRuleReader.getImage(getClass().getResource(EncryptedRuleReader.getLocaleString("paymentRespSuccessBackgroundImagePath"))))));
	  if(bkgrnd!=null)
	  {
        Runnable r = new Runnable() {
            public void run() {
			try
			{
                		PaymentSuccessCenterPanel1.setBorder(bkgrnd);
                		PaymentSuccessCenterPanel1.repaint();
			}
			catch(Exception e)
			{

			}
            }
        };
        SwingUtilities.invokeLater(r);
	  }
	}
}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}


        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	  if(EncryptedRuleReader.getLocaleString("paymentSuccessResponsePanelTitle")!=null)
	  {
	        setTitle(EncryptedRuleReader.getLocaleString("paymentSuccessResponsePanelTitle"));
	  }

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

	  if(EncryptedRuleReader.get("paymentBackgroundColor")!=null)
	  {
		if(EncryptedRuleReader.get("paymentBackgroundColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("paymentBackgroundColor"));
			getContentPane().setBackground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			RootPanel.setBackground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }
        RootPanel.add(PaymentValidationHeaderPanel1);
        RootPanel.add(PaymentSuccessCenterPanel1);
        RootPanel.add(PaymentSuccessFooterPanel1);
        getContentPane().add(RootPanel, java.awt.BorderLayout.CENTER);

        pack();
    }//GEN-END:initComponents
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog
    
    /**
     * @param args the command line arguments
     */
   // public static void main(String args[]) {
   //     new dlgCustomerBillingResponsePanelSuccess(null,new javax.swing.JFrame(), true).show();
   // }

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

    public void paint(Graphics g)
    {
	Graphics2D g2 = (Graphics2D) g;
	g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	super.paint(g);
    } 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.trinity.ea.forms.payment.PaymentSuccessCenterPanel PaymentSuccessCenterPanel1;
    private com.trinity.ea.forms.payment.PaymentValidationHeaderPanel PaymentValidationHeaderPanel1;
    private com.trinity.ea.forms.payment.PaymentSuccessFooterPanel PaymentSuccessFooterPanel1;
    private javax.swing.JPanel RootPanel;
// End of variables declaration//GEN-END:variables
    
}
