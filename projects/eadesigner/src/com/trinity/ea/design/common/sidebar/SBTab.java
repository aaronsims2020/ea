/*
 * SBTab.java
 *
 * Created on March 10, 2004, 2:04 AM
 */

package com.trinity.ea.design.common.sidebar;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class SBTab extends javax.swing.JPanel {
    private String compRefID = "";
    public SBTab(String text, int width, int height, int lMargin, Color bgColor, Color fgColor, Icon theImageIcon, int iconTextGap, Color topBorderColor, Color bottomBorderColor, Color rightInnerBorderColor, Color rightOuterBorderColor, boolean isOpaque) 
    {
        initComponents(text, width, height, lMargin, bgColor, fgColor, theImageIcon, iconTextGap, topBorderColor, bottomBorderColor, rightInnerBorderColor, rightOuterBorderColor, isOpaque);
    }    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents(String text, int width, int height, int lMargin, Color bgColor, Color fgColor, Icon theImageIcon, int iconTextGap, Color topBorderColor, Color bottomBorderColor, Color rightInnerBorderColor, Color rightOuterBorderColor, boolean isOpaque) {//GEN-BEGIN:initComponents
        LeftFiller = new javax.swing.JLabel();
        ContentLabel = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());
	  setTheOpaque(isOpaque);
	  setForegroundColor(fgColor);
	  setTheTopBottomBorderColors(topBorderColor, bottomBorderColor, rightInnerBorderColor, rightOuterBorderColor);
	  setTheSize(width, height, lMargin);
	  setBackgroundColor(bgColor);
    	  ContentLabel.setIcon(theImageIcon);
    	  ContentLabel.setIconTextGap(iconTextGap); 
        //ContentLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        add(ContentLabel, java.awt.BorderLayout.CENTER);
        add(LeftFiller, java.awt.BorderLayout.WEST);
        if(text!=null)
{
	setText(text);
}
    }//GEN-END:initComponents
/*
    private void sbMousePressed(java.awt.event.MouseEvent evt) {
               ((Sidebar)getParent().getParent().getParent()).setMousePressedMenuLabel(this);
    }//
    private void sbMouseReleased(java.awt.event.MouseEvent evt) {
               ((Sidebar)getParent().getParent().getParent()).setMouseReleasedMenuLabel(this);
    }//    
    private void sbMouseClicked(java.awt.event.MouseEvent evt) {
               ((Sidebar)getParent().getParent().getParent()).setSelectedMenuItem(this);
    }//
    private void sbMouseExited(java.awt.event.MouseEvent evt) {
               ((Sidebar)getParent().getParent().getParent()).setMouseExitedMenuLabel(this);
    }//
    private void sbMouseEntered(java.awt.event.MouseEvent evt) {
               ((Sidebar)getParent().getParent().getParent()).setMouseEnteredMenuLabel(this);
    }//
*/
public void setTheSize(int width, int height, int lMargin)
{
    setSize(width, height);
    LeftFiller.setMaximumSize(new java.awt.Dimension(lMargin, height));
    LeftFiller.setMinimumSize(new java.awt.Dimension(lMargin, 0));
    LeftFiller.setPreferredSize(new java.awt.Dimension(lMargin, height));
    ContentLabel.setSize(new java.awt.Dimension((width-lMargin), height));
}

public void setForegroundColor(Color fgColor)
{
    ContentLabel.setForeground(fgColor);
}

public void setBackgroundColor(Color bgColor)
{
    setBackground(bgColor);
    LeftFiller.setBackground(bgColor);
    ContentLabel.setBackground(bgColor);
}

public void setTheIcon(Icon LabelIcon)
{
    ContentLabel.setIcon(LabelIcon);
}

public void setTheIconTextGap(int iconTextGap)
{
    ContentLabel.setIconTextGap(iconTextGap);   
}

public void setTheOpaque(boolean isOpaque)
{
    setOpaque(isOpaque);   
    LeftFiller.setOpaque(isOpaque); 
    ContentLabel.setOpaque(isOpaque); 
}
public String getComponentLocalizationID()
{
	return compRefID;
}

public void setText(String text)
{
	compRefID = text;
	ContentLabel.setText(text);
}

public String getText()
{
	return ContentLabel.getText();
}

public void setTabFont(Font font)
{
	ContentLabel.setFont(font);
}

public void setTheTopBottomBorderColors(Color topBorderColor, Color bottomBorderColor, Color rightInnerBorderColor, Color rightOuterBorderColor)
{
	setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 0, 1), rightOuterBorderColor), new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 0, 1), rightInnerBorderColor)), new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 1, 0), bottomBorderColor)), new javax.swing.border.MatteBorder(new java.awt.Insets(1, 0, 0, 0), topBorderColor)));
}

    // Variables declaration - do not modify
    private javax.swing.JLabel ContentLabel;
    private javax.swing.JLabel LeftFiller;
    // End of variables declaration
}
