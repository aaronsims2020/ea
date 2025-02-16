/*
 * DoubleBorderRoundedCorner.java
 *
 * Created on March 15, 2004, 3:12 PM
 */

package com.trinity.ea.design.common.corners.upperright;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.border.MatteBorder;
import javax.swing.BoxLayout;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class DoubleBorderRoundedCorner extends javax.swing.JPanel {
    
    /** Creates new form DoubleBorderRoundedCorner */
    public DoubleBorderRoundedCorner(Color ContentColor, Color InnerBorderColor, Color OuterBorderColor) {
        initComponents(ContentColor, InnerBorderColor, OuterBorderColor);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents(Color ContentColor, Color InnerBorderColor, Color OuterBorderColor) {//GEN-BEGIN:initComponents
        ContentColorTopPanel = new javax.swing.JPanel();
        InnerBorderColorMiddlePanel = new javax.swing.JPanel();
        ContentColorBottomPanel = new javax.swing.JPanel();
        ContentColorLBottomPanel = new javax.swing.JPanel();
        InnerBorderColorMBottomPanel = new javax.swing.JPanel();
        OuterBorderColorRBottomPanel = new javax.swing.JPanel();
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));
        setMaximumSize(new java.awt.Dimension(3, 3));
        setMinimumSize(new java.awt.Dimension(3, 3));
        setPreferredSize(new java.awt.Dimension(3, 3));
        ContentColorTopPanel.setBackground(ContentColor);
        ContentColorTopPanel.setMaximumSize(new java.awt.Dimension(3, 1));
        ContentColorTopPanel.setMinimumSize(new java.awt.Dimension(3, 1));
        ContentColorTopPanel.setPreferredSize(new java.awt.Dimension(3, 1));
        InnerBorderColorMiddlePanel.setMaximumSize(new java.awt.Dimension(3, 1));
        InnerBorderColorMiddlePanel.setMinimumSize(new java.awt.Dimension(3, 1));
        InnerBorderColorMiddlePanel.setPreferredSize(new java.awt.Dimension(3, 1));
        ContentColorBottomPanel.setLayout(new javax.swing.BoxLayout(ContentColorBottomPanel, javax.swing.BoxLayout.X_AXIS));
        ContentColorBottomPanel.setMaximumSize(new java.awt.Dimension(3, 1));
        ContentColorBottomPanel.setMinimumSize(new java.awt.Dimension(3, 1));
        ContentColorBottomPanel.setPreferredSize(new java.awt.Dimension(3, 1));
        ContentColorBottomPanel.setOpaque(false);
        ContentColorLBottomPanel.setMaximumSize(new java.awt.Dimension(1, 1));
        ContentColorLBottomPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        ContentColorLBottomPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        InnerBorderColorMBottomPanel.setMaximumSize(new java.awt.Dimension(1, 1));
        InnerBorderColorMBottomPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        InnerBorderColorMBottomPanel.setPreferredSize(new java.awt.Dimension(1, 1));
        OuterBorderColorRBottomPanel.setMaximumSize(new java.awt.Dimension(1, 1));
        OuterBorderColorRBottomPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        OuterBorderColorRBottomPanel.setPreferredSize(new java.awt.Dimension(1, 1));

         setBackground(ContentColor);
         ContentColorTopPanel.setBackground(ContentColor);  
         InnerBorderColorMiddlePanel.setBackground(InnerBorderColor);
         InnerBorderColorMiddlePanel.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 0, 1), ContentColor));
         ContentColorBottomPanel.setBackground(ContentColor);
         ContentColorLBottomPanel.setBackground(ContentColor);      
         InnerBorderColorMBottomPanel.setBackground(InnerBorderColor);    
         OuterBorderColorRBottomPanel.setBackground(OuterBorderColor); 

        add(ContentColorTopPanel);
        add(InnerBorderColorMiddlePanel);
        ContentColorBottomPanel.add(OuterBorderColorRBottomPanel);
        ContentColorBottomPanel.add(InnerBorderColorMBottomPanel);
        ContentColorBottomPanel.add(ContentColorLBottomPanel);
        add(ContentColorBottomPanel);

    }//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContentColorBottomPanel;
    private javax.swing.JPanel ContentColorLBottomPanel;
    private javax.swing.JPanel ContentColorTopPanel;
    private javax.swing.JPanel InnerBorderColorMBottomPanel;
    private javax.swing.JPanel InnerBorderColorMiddlePanel;
    private javax.swing.JPanel OuterBorderColorRBottomPanel;
    // End of variables declaration//GEN-END:variables
    
}
