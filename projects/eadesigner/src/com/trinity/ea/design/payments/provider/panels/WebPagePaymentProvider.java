/*
 * WebPagePaymentProvider.java
 *
 * Created on April 23, 2004, 10:16 PM
 */
 
package com.trinity.ea.design.payments.provider.panels;
import com.trinity.ea.design.payments.provider.panels.WebPageProviderMainPanel;
import com.trinity.ea.design.common.file.ProjectManager;
import javax.swing.ImageIcon;
import java.util.HashMap;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;

/** 
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class WebPagePaymentProvider extends javax.swing.JPanel 
{

 /** Creates new form WebPagePaymentProvider */
    public WebPagePaymentProvider() {
        initComponents();
        setProjectData();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        adTrackingButtonGroup = new javax.swing.ButtonGroup();
        followUpMessagesButtonGroup = new javax.swing.ButtonGroup();
        ListNamePanel = new javax.swing.JPanel();
        lFiller15 = new javax.swing.JLabel();
        lFiller18 = new javax.swing.JLabel();
        lWebPage = new javax.swing.JLabel();
        lFiller16 = new javax.swing.JLabel();
        lFiller17 = new javax.swing.JLabel();
        ListNamePanel1 = new javax.swing.JPanel();
        lFiller19 = new javax.swing.JLabel();
        lFiller20 = new javax.swing.JLabel();
        tfWebPage = new javax.swing.JTextField();
        lFiller21 = new javax.swing.JLabel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        ListNamePanel.setLayout(new javax.swing.BoxLayout(ListNamePanel, javax.swing.BoxLayout.X_AXIS));

        ListNamePanel.setMaximumSize(new java.awt.Dimension(2147483647, 26));
        ListNamePanel.setMinimumSize(new java.awt.Dimension(600, 26));
        ListNamePanel.setPreferredSize(new java.awt.Dimension(800, 26));
        lFiller15.setText("   ");
        lFiller15.setMaximumSize(new java.awt.Dimension(20, 25));
        lFiller15.setMinimumSize(new java.awt.Dimension(20, 25));
        lFiller15.setPreferredSize(new java.awt.Dimension(20, 25));
        ListNamePanel.add(lFiller15);

        lFiller18.setMaximumSize(new java.awt.Dimension(5, 15));
        lFiller18.setMinimumSize(new java.awt.Dimension(5, 16));
        lFiller18.setPreferredSize(new java.awt.Dimension(5, 16));
        ListNamePanel.add(lFiller18);

        lWebPage.setFont(new java.awt.Font("Arial", 0, 12));
        lWebPage.setText("Payment Processing Web Page URL:");
        lWebPage.setMaximumSize(new java.awt.Dimension(300, 15));
        lWebPage.setMinimumSize(new java.awt.Dimension(300, 15));
        lWebPage.setPreferredSize(new java.awt.Dimension(300, 15));
        lWebPage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lWebPageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lWebPageMouseExited(evt);
            }
        });

        ListNamePanel.add(lWebPage);

        lFiller16.setText("   ");
        lFiller16.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller16.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller16.setPreferredSize(new java.awt.Dimension(10, 16));
        ListNamePanel.add(lFiller16);

        lFiller17.setText("   ");
        lFiller17.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller17.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller17.setPreferredSize(new java.awt.Dimension(15, 16));
        ListNamePanel.add(lFiller17);

        add(ListNamePanel);

        ListNamePanel1.setLayout(new javax.swing.BoxLayout(ListNamePanel1, javax.swing.BoxLayout.X_AXIS));

        ListNamePanel1.setMaximumSize(new java.awt.Dimension(2147483647, 26));
        ListNamePanel1.setMinimumSize(new java.awt.Dimension(600, 26));
        ListNamePanel1.setPreferredSize(new java.awt.Dimension(800, 26));
        lFiller19.setIcon(new javax.swing.ImageIcon(""));
        lFiller19.setText("   ");
        lFiller19.setMaximumSize(new java.awt.Dimension(20, 25));
        lFiller19.setMinimumSize(new java.awt.Dimension(20, 25));
        lFiller19.setPreferredSize(new java.awt.Dimension(20, 25));
        ListNamePanel1.add(lFiller19);

        lFiller20.setMaximumSize(new java.awt.Dimension(5, 15));
        lFiller20.setMinimumSize(new java.awt.Dimension(5, 16));
        lFiller20.setPreferredSize(new java.awt.Dimension(5, 16));
        ListNamePanel1.add(lFiller20);

        tfWebPage.setFont(new java.awt.Font("Arial", 0, 12));
        tfWebPage.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfWebPage.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        tfWebPage.setText("http://");
        tfWebPage.setMaximumSize(new java.awt.Dimension(32767, 20));
        tfWebPage.setMinimumSize(new java.awt.Dimension(160, 20));
        tfWebPage.setPreferredSize(new java.awt.Dimension(160, 20));
        ListNamePanel1.add(tfWebPage);

        lFiller21.setIcon(new javax.swing.ImageIcon(""));
        lFiller21.setText("   ");
        lFiller21.setMaximumSize(new java.awt.Dimension(20, 25));
        lFiller21.setMinimumSize(new java.awt.Dimension(20, 25));
        lFiller21.setPreferredSize(new java.awt.Dimension(20, 25));
        ListNamePanel1.add(lFiller21);

        add(ListNamePanel1);

    }//GEN-END:initComponents

    private void lWebPageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lWebPageMouseExited
        setStatus("");
    }//GEN-LAST:event_lWebPageMouseExited

    private void lWebPageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lWebPageMouseEntered
        setStatus("Specify the Payment Processing Web Page.");
    }//GEN-LAST:event_lWebPageMouseEntered

    private void AutoResponderListNameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AutoResponderListNameMouseExited
        setStatus("");
    }//GEN-LAST:event_AutoResponderListNameMouseExited
 
    private void AutoResponderListNameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AutoResponderListNameMouseEntered
	setStatus("Specify the Payment Processing Web Page.");
    }//GEN-LAST:event_AutoResponderListNameMouseEntered
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ListNamePanel;
    private javax.swing.JPanel ListNamePanel1;
    private javax.swing.ButtonGroup adTrackingButtonGroup;
    private javax.swing.ButtonGroup followUpMessagesButtonGroup;
    private javax.swing.JLabel lFiller15;
    private javax.swing.JLabel lFiller16;
    private javax.swing.JLabel lFiller17;
    private javax.swing.JLabel lFiller18;
    private javax.swing.JLabel lFiller19;
    private javax.swing.JLabel lFiller20;
    private javax.swing.JLabel lFiller21;
    private javax.swing.JLabel lWebPage;
    private javax.swing.JTextField tfWebPage;
    // End of variables declaration//GEN-END:variables

    public void getDataUpdate()
    {
        try
        {
            ProjectManager.putTempNoFileWrite("buyNowAction", tfWebPage.getText());
            ProjectManager.putTempNoFileWrite("buyNowActionType", "0");   
  
            ProjectManager.saveTempNow();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void setProjectData()
    {
        try
        {
		if(ProjectManager.get("buyNowAction")!=null)
		{
			if(ProjectManager.get("buyNowAction").startsWith("http://")==true)
			{
				tfWebPage.setText(ProjectManager.get("buyNowAction"));
			}
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
        try
        {
            while(textArrayString.indexOf(",")!=-1)
            {
                tempString = textArrayString.substring(0,textArrayString.indexOf(","));
                textArrayString = textArrayString.substring(textArrayString.indexOf(",") + 1);
                aryList.add(tempString);
            }
            aryList.add(textArrayString);
            aryList.trimToSize();
        }
        catch(NullPointerException e)
        {
         
        }

        return aryList.toArray();
    }  
    
    private String getCommaSeparatedStringValues(String strToUpdate)
    {
	 return strToUpdate.replaceAll(":::",",");
    }   
    WebPageProviderMainPanel parentObj = null;
    public void setMasterStatusController(Object parentObject)
    {
        parentObj = (WebPageProviderMainPanel)parentObject;
    }
    private void setStatus(String statusMessage)
    {
        try
        {
            parentObj.setStatus(statusMessage);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
