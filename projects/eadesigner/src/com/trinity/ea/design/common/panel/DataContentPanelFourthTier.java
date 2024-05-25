/*
 * DataContentPanelFourthTier.java
 *
 * Created on April 15, 2004, 4:36 PM
 */

package com.trinity.ea.design.common.panel;
import com.trinity.ea.design.common.panel.EAPanel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

/** 
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class DataContentPanelFourthTier extends EAPanel {
    
    /** Creates new form UIStringsTitle */
    public DataContentPanelFourthTier(String title) {
        initComponents();
        setTitle(title);       
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        NorthActionPanel = new javax.swing.JPanel();
        SouthActionPanel = new javax.swing.JPanel();
        WestActionPanel = new javax.swing.JPanel();
        EastActionPanel = new javax.swing.JPanel();
        CenterActionPanel = new javax.swing.JPanel();
        CenterContentPanel = new javax.swing.JPanel();
        WestActionPanel1 = new javax.swing.JPanel();
        EastActionPanel1 = new javax.swing.JPanel();
        NorthActionPanel1 = new javax.swing.JPanel();
        SouthActionPanel1 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        NorthActionPanel.setBackground(new java.awt.Color(176, 191, 240));
        NorthActionPanel.setMinimumSize(new java.awt.Dimension(5, 5));
        NorthActionPanel.setPreferredSize(new java.awt.Dimension(5, 5));
        add(NorthActionPanel, java.awt.BorderLayout.NORTH);

        SouthActionPanel.setBackground(new java.awt.Color(176, 191, 240));
        SouthActionPanel.setMinimumSize(new java.awt.Dimension(5, 1));
        SouthActionPanel.setPreferredSize(new java.awt.Dimension(5, 1));
        add(SouthActionPanel, java.awt.BorderLayout.SOUTH);

        WestActionPanel.setBackground(new java.awt.Color(176, 191, 240));
        WestActionPanel.setPreferredSize(new java.awt.Dimension(5, 5));
        add(WestActionPanel, java.awt.BorderLayout.WEST);

        EastActionPanel.setBackground(new java.awt.Color(176, 191, 240));
        EastActionPanel.setMinimumSize(new java.awt.Dimension(1, 5));
        EastActionPanel.setPreferredSize(new java.awt.Dimension(1, 5));
        add(EastActionPanel, java.awt.BorderLayout.EAST);

        CenterActionPanel.setLayout(new java.awt.BorderLayout());

        CenterActionPanel.setBackground(new java.awt.Color(176, 191, 240));
        CenterActionPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(122, 133, 168)), "Testing", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        CenterContentPanel.setLayout(new java.awt.BorderLayout());

        CenterContentPanel.setBackground(new java.awt.Color(176, 191, 240));
        CenterActionPanel.add(CenterContentPanel, java.awt.BorderLayout.CENTER);

        WestActionPanel1.setBackground(new java.awt.Color(176, 191, 240));
        WestActionPanel1.setPreferredSize(new java.awt.Dimension(5, 5));
        CenterActionPanel.add(WestActionPanel1, java.awt.BorderLayout.WEST);

        EastActionPanel1.setBackground(new java.awt.Color(176, 191, 240));
        EastActionPanel1.setMinimumSize(new java.awt.Dimension(5, 5));
        EastActionPanel1.setPreferredSize(new java.awt.Dimension(5, 5));
        CenterActionPanel.add(EastActionPanel1, java.awt.BorderLayout.EAST);

        NorthActionPanel1.setBackground(new java.awt.Color(176, 191, 240));
        NorthActionPanel1.setMaximumSize(new java.awt.Dimension(1, 32767));
        NorthActionPanel1.setMinimumSize(new java.awt.Dimension(1, 1));
        NorthActionPanel1.setPreferredSize(new java.awt.Dimension(1, 1));
        CenterActionPanel.add(NorthActionPanel1, java.awt.BorderLayout.NORTH);

        SouthActionPanel1.setBackground(new java.awt.Color(176, 191, 240));
        SouthActionPanel1.setMinimumSize(new java.awt.Dimension(5, 5));
        SouthActionPanel1.setPreferredSize(new java.awt.Dimension(5, 5));
        CenterActionPanel.add(SouthActionPanel1, java.awt.BorderLayout.SOUTH);

        add(CenterActionPanel, java.awt.BorderLayout.CENTER);

    }//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CenterActionPanel;
    private javax.swing.JPanel CenterContentPanel;
    private javax.swing.JPanel EastActionPanel;
    private javax.swing.JPanel EastActionPanel1;
    private javax.swing.JPanel NorthActionPanel;
    private javax.swing.JPanel NorthActionPanel1;
    private javax.swing.JPanel SouthActionPanel;
    private javax.swing.JPanel SouthActionPanel1;
    private javax.swing.JPanel WestActionPanel;
    private javax.swing.JPanel WestActionPanel1;
    // End of variables declaration//GEN-END:variables

   private EAPanel TheContentPanelReference = new EAPanel();
   public void setContentPanel(EAPanel theContentPanel)
  {
    try
    {
        getDataUpdate();
        TheContentPanelReference.setVisible(false);
        CenterContentPanel.remove(TheContentPanelReference);        
        TheContentPanelReference = theContentPanel;
        CenterContentPanel.setPreferredSize(new java.awt.Dimension(620, 275));
        CenterContentPanel.add(TheContentPanelReference);     
        TheContentPanelReference.setVisible(true);
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
  }  
   
  public synchronized void getDataUpdate()
  {
	try
	{
		TheContentPanelReference.getDataUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
  }   

  public synchronized void setProjectData()
  {
	try
	{
		TheContentPanelReference.setProjectData();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
  }    

  public synchronized void setTitle(String title)
  {
    if(title!=null)
    {
      CenterActionPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(122, 133, 168)), title, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
    }
  }
   
}
