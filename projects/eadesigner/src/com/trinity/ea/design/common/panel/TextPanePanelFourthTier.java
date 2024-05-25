/*
 * TextPanePanelFourthTier.java
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
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class TextPanePanelFourthTier extends EAPanel {
    
    /** Creates new form TextPanePanelFourthTier */
    public TextPanePanelFourthTier(String labelText, String DataEntryText, String projectManagerPropertyKey, boolean isEnabled) {
        initComponents();
        setText(labelText, DataEntryText, projectManagerPropertyKey, isEnabled); 
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TextPaneScrollPane = new javax.swing.JScrollPane();
        TextPane = new javax.swing.JTextArea();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        setBackground(new java.awt.Color(176, 191, 240));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(176, 191, 240));
        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 20));
        jPanel1.setMinimumSize(new java.awt.Dimension(10, 20));
        jPanel1.setPreferredSize(new java.awt.Dimension(10, 20));
        jLabel1.setBackground(new java.awt.Color(176, 191, 240));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 12));
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(10000, 20));
        jLabel1.setMinimumSize(new java.awt.Dimension(41, 20));
        jLabel1.setPreferredSize(new java.awt.Dimension(400, 20));
        jPanel1.add(jLabel1, java.awt.BorderLayout.WEST);

        add(jPanel1);

        TextPaneScrollPane.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        TextPaneScrollPane.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        TextPaneScrollPane.setFont(new java.awt.Font("Arial", 0, 12));
        TextPane.setFont(new java.awt.Font("Arial", 0, 12));
        TextPaneScrollPane.setViewportView(TextPane);
        TextPane.setLineWrap(true);
        TextPane.setWrapStyleWord(true);
        add(TextPaneScrollPane);

    }//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TextPane;
    private javax.swing.JScrollPane TextPaneScrollPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    private String theProjectProperty = null;
    public void setText(String labelText, String DataEntryText, String projectManagerPropertyKey, boolean isEnabled)
    {
        try
        {
            theProjectProperty = projectManagerPropertyKey;
            jLabel1.setText(labelText);
		DataEntryText = DataEntryText.replaceAll("\\\\r\\\\n", "\n");
            TextPane.setText(DataEntryText);
            TextPane.setEnabled(isEnabled);
            TextPane.setCaretPosition(0);
        } 
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public String getText()
    {
        return TextPane.getText();
    }    
    
  public synchronized void getDataUpdate()
  {
	try
	{
		String theText = TextPane.getText();
		String theText2 = theText.replaceAll("\n", "\\\\r\\\\n");
		ProjectManager.put(theProjectProperty, theText2.replaceAll("\n", "\\\\r\\\\n"));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
  }     
}
