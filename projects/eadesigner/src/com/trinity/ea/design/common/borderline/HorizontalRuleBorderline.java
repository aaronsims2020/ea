/*
 * HorizontalRuleBorderline.java
 *
 * Created on March 15, 2004, 7:07 PM
 */

package com.trinity.ea.design.common.borderline;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.BoxLayout;  

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class HorizontalRuleBorderline extends javax.swing.JPanel {
    
 public HorizontalRuleBorderline(Color topColor, Color middleColor, Color bottomColor) {
        initComponents(topColor, middleColor, bottomColor);
}
private void initComponents(Color topColor, Color middleColor, Color bottomColor)
{
        InnerBorderColorTopPanel = new javax.swing.JPanel();
        OuterBorderColorMiddlePanel = new javax.swing.JPanel();
        OuterBorderColorBottomPanel = new javax.swing.JPanel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        setMaximumSize(new java.awt.Dimension(32000, 4));
        setMinimumSize(new java.awt.Dimension(1, 4));
        setPreferredSize(new java.awt.Dimension(200, 4));
        setOpaque(false);

	  InnerBorderColorTopPanel.setOpaque(true);
        InnerBorderColorTopPanel.setMaximumSize(new java.awt.Dimension(32000, 1));
        InnerBorderColorTopPanel.setMinimumSize(new java.awt.Dimension(1, 1));
        InnerBorderColorTopPanel.setPreferredSize(new java.awt.Dimension(200, 1));


	  OuterBorderColorMiddlePanel.setOpaque(true);
        OuterBorderColorMiddlePanel.setMaximumSize(new java.awt.Dimension(32000, 1));
        OuterBorderColorMiddlePanel.setMinimumSize(new java.awt.Dimension(1, 1));
        OuterBorderColorMiddlePanel.setPreferredSize(new java.awt.Dimension(200, 1));


  	  OuterBorderColorBottomPanel.setOpaque(true);
        OuterBorderColorBottomPanel.setMaximumSize(new java.awt.Dimension(32000, 2));
        OuterBorderColorBottomPanel.setMinimumSize(new java.awt.Dimension(1, 2));
        OuterBorderColorBottomPanel.setPreferredSize(new java.awt.Dimension(200, 2));

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
