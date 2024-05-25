/*
 * TextFieldPanelFourthTier.java
 *
 * Created on April 15, 2004, 4:36 PM
 */

package com.trinity.ea.design.common.panel;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.common.file.ProjectManager;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class TextFieldPanelFourthTier extends EAPanel { 
    
    /** Creates new form TextFieldPanelFourthTier */
    public TextFieldPanelFourthTier(String labelText, String DataEntryText, String projectManagerPropertyKey, boolean isEnabled) {
        initComponents();
        setText(labelText, DataEntryText, projectManagerPropertyKey, isEnabled); 
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        lFiller3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lFiller2 = new javax.swing.JLabel();
        JTextField1 = new javax.swing.JTextField();
        lFiller4 = new javax.swing.JLabel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));

        setBackground(new java.awt.Color(176, 191, 240));
        lFiller3.setText("   ");
        lFiller3.setMaximumSize(new java.awt.Dimension(300, 15));
        add(lFiller3);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12));
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(300, 15));
        add(jLabel1);

        lFiller2.setText("   ");
        lFiller2.setMaximumSize(new java.awt.Dimension(300, 15));
        add(lFiller2);
        lFiller2.getAccessibleContext().setAccessibleName("");

        JTextField1.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(1, 1, 1, 1), new java.awt.Color(39, 63, 109)));
        JTextField1.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        JTextField1.setMinimumSize(new java.awt.Dimension(0, 20));
        JTextField1.setPreferredSize(new java.awt.Dimension(0, 20));
        add(JTextField1);

        lFiller4.setText("   ");
        lFiller4.setMaximumSize(new java.awt.Dimension(300, 15));
        add(lFiller4);

    }//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lFiller2;
    private javax.swing.JLabel lFiller3;
    private javax.swing.JLabel lFiller4;
    // End of variables declaration//GEN-END:variables
    private String theProjectProperty = null;
    public void setText(String labelText, String DataEntryText, String projectManagerPropertyKey, boolean isEnabled)
    {
        try
        {
            theProjectProperty = projectManagerPropertyKey;
            jLabel1.setText(labelText);
            JTextField1.setText(DataEntryText);
            JTextField1.setEnabled(isEnabled);
            JTextField1.setCaretPosition(0);
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public String getText()
    {
        return JTextField1.getText();
    }    
    
  public synchronized void getDataUpdate()
  {
	try
	{
		ProjectManager.put(theProjectProperty, JTextField1.getText());
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
  }       
}
