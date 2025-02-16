/*
 * MainBottomPanel.java
 *
 * Created on May 24, 2004, 11:43 PM
 */

package com.trinity.ea.design.build.config;
import com.trinity.ea.design.build.config.BottomFillerPanel;
import com.trinity.ea.design.build.config.BuildOutputLocationPanel;
import com.trinity.ea.design.common.panel.DataContentPanelSecondTier;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.EADesigner;
//import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class MainBottomPanel extends EAPanel
{
    
    /** Creates new form MainBottomPanel */
    public MainBottomPanel() {
        initComponents();
	  ButtonBarPanel.setMainBottomPanel(this);
    }

    public void setProjectData()
    {
        try
        {
		LocationBarPanel.setProjectData();
		ButtonBarPanel.setProjectData();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void getDataUpdate()
    {
        try
        {
		LocationBarPanel.getDataUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        LocationBarPanel = new BuildOutputLocationPanel();
        ButtonBarPanel = new BottomFillerPanel();
	  dcpst = new DataContentPanelSecondTier("Build Output Location");

        setLayout(new java.awt.BorderLayout());

        setBackground(new java.awt.Color(100, 120, 170));
        setMaximumSize(new java.awt.Dimension(2147483647, 193));
        setMinimumSize(new java.awt.Dimension(0, 193));
        setPreferredSize(new java.awt.Dimension(500, 193));
        
        LocationBarPanel.setBackground(new java.awt.Color(100, 120, 170));
        dcpst.setMaximumSize(new java.awt.Dimension(2147483647, 123));
        dcpst.setMinimumSize(new java.awt.Dimension(12, 123));
        dcpst.setPreferredSize(new java.awt.Dimension(500, 123));
	  dcpst.setContentPanel(LocationBarPanel);
        add(dcpst, java.awt.BorderLayout.NORTH);

        ButtonBarPanel.setBackground(new java.awt.Color(100, 120, 170));
        ButtonBarPanel.setMaximumSize(new java.awt.Dimension(2147483647, 65));
        ButtonBarPanel.setMinimumSize(new java.awt.Dimension(12, 65));
        ButtonBarPanel.setPreferredSize(new java.awt.Dimension(500, 65));
        add(ButtonBarPanel, java.awt.BorderLayout.CENTER);

    }//GEN-END:initComponents

//public static void main(String[] args)
//{
//	JFrame frame = new JFrame("Testing");
//	frame.getContentPane().setLayout(new java.awt.BorderLayout());
//	frame.getContentPane().add(new MainBottomPanel(),java.awt.BorderLayout.CENTER);
//	frame.setSize(600,175);
//	frame.show();
//}    

    public EAPanel setParentComp(EADesigner eades)
    {
	ButtonBarPanel.setParentComp(eades);
	return this;
    }   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private BottomFillerPanel ButtonBarPanel;
    private BuildOutputLocationPanel LocationBarPanel;
    private DataContentPanelSecondTier dcpst;
    // End of variables declaration//GEN-END:variables
    
}
