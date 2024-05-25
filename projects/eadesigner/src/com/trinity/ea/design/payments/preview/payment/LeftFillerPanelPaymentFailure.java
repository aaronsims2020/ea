/*
 * LeftFillerPanelPaymentFailure.java
 *
 * Created on July 9, 2004, 7:33 PM
 */

package com.trinity.ea.design.payments.preview.payment;
import com.trinity.ea.design.common.file.ProjectManager;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel;
import java.util.ArrayList;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class LeftFillerPanelPaymentFailure extends javax.swing.JPanel {
    
    /** Creates new form LeftFillerPanelPaymentFailure */
    public LeftFillerPanelPaymentFailure() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents

        setLayout(null);

        setMaximumSize(new java.awt.Dimension(13, 168));
        setMinimumSize(new java.awt.Dimension(13, 168));
        setPreferredSize(new java.awt.Dimension(13, 168));
	  if(ProjectManager.get("paymentBackgroundColor")!=null)
	  {
		if(ProjectManager.get("paymentBackgroundColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentBackgroundColor"));
			setBackground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }
    }//GEN-END:initComponents
    
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
    // End of variables declaration//GEN-END:variables
    
}
