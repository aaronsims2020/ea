/*
 * ProgressPanel.java
 *
 * Created on May 3, 2004, 2:37 PM
 */
package com.trinity.ea.design.common.status;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.BoxLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import java.awt.Insets;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.SwingConstants; 

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class ProgressPanel extends javax.swing.JPanel {
    
    /** Creates new form ProgressTest */
    public ProgressPanel() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        jPanel1 = new javax.swing.JPanel();
        lHeader = new javax.swing.JLabel();
        StatusBarPanel = new javax.swing.JPanel();
        WestFill = new javax.swing.JPanel();
        EastFill = new javax.swing.JPanel();
        NorthFill = new javax.swing.JPanel();
        SouthFill = new javax.swing.JPanel();
        ContentPanel = new javax.swing.JPanel();
        StatusProgressBar = new javax.swing.JProgressBar();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 1, 1), new java.awt.Color(51, 51, 51)), new javax.swing.border.MatteBorder(new java.awt.Insets(1, 1, 0, 0), new java.awt.Color(255, 255, 255))), new javax.swing.border.CompoundBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 1, 1), new java.awt.Color(102, 102, 102)), new javax.swing.border.MatteBorder(new java.awt.Insets(1, 1, 0, 0), new java.awt.Color(255, 255, 255)))), new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102))));
        jPanel1.setLayout(new java.awt.BorderLayout());

        lHeader.setFont(new java.awt.Font("Arial", 0, 12));
        lHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lHeader.setText("Launching E-mail Opt-In Designer");
        lHeader.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lHeader.setOpaque(true);
        jPanel1.add(lHeader, java.awt.BorderLayout.CENTER);

        add(jPanel1);

        StatusBarPanel.setLayout(new java.awt.BorderLayout());

        StatusBarPanel.setMaximumSize(new java.awt.Dimension(2147483647, 36));
        StatusBarPanel.setMinimumSize(new java.awt.Dimension(10, 36));
        StatusBarPanel.setPreferredSize(new java.awt.Dimension(148, 36));
        WestFill.setMinimumSize(new java.awt.Dimension(8, 10));
        WestFill.setPreferredSize(new java.awt.Dimension(8, 10));
        StatusBarPanel.add(WestFill, java.awt.BorderLayout.WEST);

        EastFill.setMinimumSize(new java.awt.Dimension(8, 10));
        EastFill.setPreferredSize(new java.awt.Dimension(8, 10));
        StatusBarPanel.add(EastFill, java.awt.BorderLayout.EAST);

        NorthFill.setMinimumSize(new java.awt.Dimension(10, 8));
        NorthFill.setPreferredSize(new java.awt.Dimension(10, 8));
        StatusBarPanel.add(NorthFill, java.awt.BorderLayout.NORTH);

        SouthFill.setMinimumSize(new java.awt.Dimension(10, 8));
        SouthFill.setPreferredSize(new java.awt.Dimension(10, 8));
        StatusBarPanel.add(SouthFill, java.awt.BorderLayout.SOUTH);

        ContentPanel.setLayout(new java.awt.BorderLayout());

        ContentPanel.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(1, 1, 1, 1), new java.awt.Color(102, 102, 102)));
        StatusProgressBar.setBackground(new java.awt.Color(153, 153, 153));
        StatusProgressBar.setForeground(new java.awt.Color(102, 102, 102));
        StatusProgressBar.setBorder(null);
        StatusProgressBar.setBorderPainted(false);
        StatusProgressBar.setIndeterminate(true);
        StatusProgressBar.setMaximumSize(new java.awt.Dimension(32767, 20));
        StatusProgressBar.setMinimumSize(new java.awt.Dimension(10, 20));
        StatusProgressBar.setPreferredSize(new java.awt.Dimension(148, 20));
        ContentPanel.add(StatusProgressBar, java.awt.BorderLayout.CENTER);

        StatusBarPanel.add(ContentPanel, java.awt.BorderLayout.CENTER);

        add(StatusBarPanel);

    }//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JPanel EastFill;
    private javax.swing.JPanel NorthFill;
    private javax.swing.JPanel SouthFill;
    private javax.swing.JPanel StatusBarPanel;
    private javax.swing.JProgressBar StatusProgressBar;
    private javax.swing.JPanel WestFill;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lHeader;
    // End of variables declaration//GEN-END:variables
    public void setText(String strHeaderText)
    {
        lHeader.setText(strHeaderText);
    }
    
}
