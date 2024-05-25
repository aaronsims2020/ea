/*
 * MainBottomPanel.java
 *
 * Created on May 24, 2004, 11:43 PM
 */

package com.trinity.ea.design.common.project.build;
import com.trinity.ea.design.common.project.build.BuildOutputLocationPanel;
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
	  LocationBarPanel.setMainBottomPanel(this);
    }

    public void setProjectData()
    {
        try
        {
		LocationBarPanel.setProjectData();
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

        setLayout(new java.awt.BorderLayout());

        setMaximumSize(new java.awt.Dimension(2147483647, 144));
        setMinimumSize(new java.awt.Dimension(0, 144));
        setPreferredSize(new java.awt.Dimension(500, 144));
        
        LocationBarPanel.setMaximumSize(new java.awt.Dimension(2147483647, 144));
        LocationBarPanel.setMinimumSize(new java.awt.Dimension(12, 144));
        LocationBarPanel.setPreferredSize(new java.awt.Dimension(500, 144));
        add(LocationBarPanel, java.awt.BorderLayout.NORTH);

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
	LocationBarPanel.setParentComp(eades);
	return this;
    }   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private BuildOutputLocationPanel LocationBarPanel;
    private EAPanel dcpst;
    // End of variables declaration//GEN-END:variables
    
}
