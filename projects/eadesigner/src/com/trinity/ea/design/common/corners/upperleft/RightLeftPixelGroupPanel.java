/*
 * RightLeftPixelGroupPanel.java
 *
 * Created on March 15, 2004, 5:26 PM
 */

package com.trinity.ea.design.common.corners.upperleft;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class RightLeftPixelGroupPanel extends javax.swing.JPanel {
    
    /** Creates new form RightLeftPixelGroupPanel */
    public RightLeftPixelGroupPanel(JPanel LeftPanel, JPanel RightPanel) {
        initComponents(LeftPanel,RightPanel);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents(JPanel LeftPanel, JPanel RightPanel) {//GEN-BEGIN:initComponents

        setLayout(new java.awt.BorderLayout());

        setMaximumSize(new java.awt.Dimension(4, 3));
        setMinimumSize(new java.awt.Dimension(4, 3));
        setPreferredSize(new java.awt.Dimension(4, 3));
        setOpaque(false);
        LeftPanel.setMaximumSize(new java.awt.Dimension(3, 3));
        LeftPanel.setMinimumSize(new java.awt.Dimension(3, 3));
        LeftPanel.setPreferredSize(new java.awt.Dimension(3, 3));

        RightPanel.setMaximumSize(new java.awt.Dimension(1, 3));
        RightPanel.setMinimumSize(new java.awt.Dimension(1, 3));
        RightPanel.setPreferredSize(new java.awt.Dimension(1, 3));


        add(LeftPanel, java.awt.BorderLayout.CENTER);
        add(RightPanel, java.awt.BorderLayout.EAST);

    }//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JPanel RightPanel;
    // End of variables declaration//GEN-END:variables
    
}
