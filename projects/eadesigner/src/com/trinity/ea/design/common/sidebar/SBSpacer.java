/*
 * SBSpacer.java
 *
 * Created on March 10, 2004, 10:59 PM
 */

package com.trinity.ea.design.common.sidebar;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class SBSpacer extends javax.swing.JPanel {
    
    public SBSpacer(Color bgColor, Color topBorderColor, Color bottomBorderColor, Color rightInnerBorderColor, Color rightOuterBorderColor, boolean isOpaque) 
    {
        initComponents(bgColor, topBorderColor, bottomBorderColor, rightInnerBorderColor, rightOuterBorderColor, isOpaque);
    }    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents(Color bgColor, Color topBorderColor, Color bottomBorderColor, Color rightInnerBorderColor, Color rightOuterBorderColor, boolean isOpaque) {//GEN-BEGIN:initComponents
        setLayout(new java.awt.BorderLayout());
	  setTheOpaque(isOpaque);
	  setTheTopBottomBorderColors(topBorderColor, bottomBorderColor, rightInnerBorderColor, rightOuterBorderColor);
	  setBackgroundColor(bgColor);
    }//GEN-END:initComponents

public void setBackgroundColor(Color bgColor)
{
    setBackground(bgColor);
}

public void setTheOpaque(boolean isOpaque)
{
    setOpaque(isOpaque);   
}

public void setTheTopBottomBorderColors(Color topBorderColor, Color bottomBorderColor, Color rightInnerBorderColor, Color rightOuterBorderColor)
{
	setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 0, 1), rightOuterBorderColor), new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 0, 1), rightInnerBorderColor)), new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 1, 0), bottomBorderColor)), new javax.swing.border.MatteBorder(new java.awt.Insets(1, 0, 0, 0), topBorderColor)));
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}
