/*
 * TriplePixelVerticalLine.java
 *
 * Created on March 15, 2004, 4:43 PM
 */

package com.trinity.ea.design.common.corners.upperleft;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.BoxLayout;   

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class TriplePixelVerticalLine extends javax.swing.JPanel {
 
/** Creates new form TriplePixelVerticalLine */
    public TriplePixelVerticalLine(Color topColor, Color middleColor, Color bottomColor) {
        initComponents(topColor, middleColor, bottomColor);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents(Color topColor, Color middleColor, Color bottomColor) {//GEN-BEGIN:initComponents
        InnerBorderColorTopPanel = new javax.swing.JPanel();
        OuterBorderColorMiddlePanel = new javax.swing.JPanel();
        OuterBorderColorBottomPanel = new javax.swing.JPanel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        setMaximumSize(new java.awt.Dimension(1, 3));
        setMinimumSize(new java.awt.Dimension(1, 3));
        setPreferredSize(new java.awt.Dimension(1, 3));
        setOpaque(false);
        InnerBorderColorTopPanel.setMaximumSize(new java.awt.Dimension(1, 1));
        InnerBorderColorTopPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        InnerBorderColorTopPanel.setPreferredSize(new java.awt.Dimension(1, 1));

        OuterBorderColorMiddlePanel.setMaximumSize(new java.awt.Dimension(1, 1));
        OuterBorderColorMiddlePanel.setMinimumSize(new java.awt.Dimension(1, 1));
        OuterBorderColorMiddlePanel.setPreferredSize(new java.awt.Dimension(1, 1));


        OuterBorderColorBottomPanel.setMaximumSize(new java.awt.Dimension(1, 1));
        OuterBorderColorBottomPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        OuterBorderColorBottomPanel.setPreferredSize(new java.awt.Dimension(1, 1));

        setBackground(topColor);
        InnerBorderColorTopPanel.setBackground(topColor);
        OuterBorderColorMiddlePanel.setBackground(middleColor);
        OuterBorderColorBottomPanel.setBackground(bottomColor);

        add(InnerBorderColorTopPanel);
        add(OuterBorderColorMiddlePanel);
        add(OuterBorderColorBottomPanel);
    }//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel InnerBorderColorTopPanel;
    private javax.swing.JPanel OuterBorderColorBottomPanel;
    private javax.swing.JPanel OuterBorderColorMiddlePanel;
    // End of variables declaration//GEN-END:variables
}
