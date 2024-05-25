/*
 * EADesignerProjectPanel.java
 *
 * Created on December 13, 2003, 1:17 AM
 */

package com.trinity.ea.design.evaluation;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.evaluation.timed.EADesignerTimedEvaluationPanel;
import com.trinity.ea.design.common.sidebar.SBTab;
import com.trinity.ea.design.project.EADesignerProjectPanel;
import com.trinity.ea.design.common.sidebar.SBSpacer;
import com.trinity.ea.design.rules.builder.DesignerRuleBuilder;
//import com.trinity.ea.design.common.status.ProgressWindow;
import java.awt.Font;
import java.util.HashMap;
import java.util.Collections;
import java.util.Map;
import java.util.ArrayList;
import com.trinity.ea.design.common.borderline.ContentAreaHeaderPanel;
import javax.swing.JCheckBox;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class EADesignerEvaluationPanel extends EAPanel {
Map sbMap = Collections.synchronizedMap(new HashMap()); 
 
    /** Creates new form EADesignerProjectPanel */
    public EADesignerEvaluationPanel() {
   
	//ProgressWindow progWindow = new ProgressWindow();
	//try
	//{
	  //progWindow.showStatus("Launching Evaluation Designer", 1);
        initComponents();
	  initSidebar();
        setSelectedMenuItem(EvaluationMenuLabelTimedButton);   
	  setProjectData();
	  //progWindow.close();
	//}
	//catch(Exception e)
	//{
	//	e.printStackTrace();
	//	progWindow.close();
	//}    
    }
    
    private EAPanel TheContentPanelReference = new EAPanel();
    private void setContentPanel(EAPanel theContentPanel)
    {
        try
        {
	     getDataUpdate();
           TheContentPanelReference.setVisible(false);
           EvaluationSelectionContentPanel.remove(TheContentPanelReference);        
           TheContentPanelReference = theContentPanel;
           EvaluationSelectionContentPanel.add(TheContentPanelReference);     
           TheContentPanelReference.setVisible(true);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }     


  public void getDataUpdate()
  {
	try
	{
		TheContentPanelReference.getDataUpdate();
            if(cbEvaluationExpirationEnabled.isSelected()==true)
            {
		    ProjectManager.putTempNoFileWrite("expirationIsEnabled", "true");
 		    ProjectManager.putTempNoFileWrite("project_expiration_support_is_enabled", "true");                            
            }
            else
            {
		    ProjectManager.putTempNoFileWrite("expirationIsEnabled", "false");
		    ProjectManager.putTempNoFileWrite("project_expiration_support_is_enabled", "false");               
            }
		ProjectManager.saveTempNow();
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
		// Evaluation Expiration Support Functionality Checkbox Enabled/Disabled   
            if(ProjectManager.get("project_expiration_support_is_enabled").equalsIgnoreCase("true")==true)
            {
                cbEvaluationExpirationEnabled.setSelected(true);              
            }
            else
            {
                cbEvaluationExpirationEnabled.setSelected(false);               
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
 private Color theCurrentMenuColor = new Color(100, 120, 170);
 private Color theSelectedMenuColor = new Color(140,160,210);
 private Color theTextMenuColor = new Color(255, 255, 255);
 private boolean pressedSelected = false;
 private Icon arrowIcon = new javax.swing.ImageIcon(getClass().getResource("/images/arrow.gif"));
 private Icon arrowSelectedIcon = new javax.swing.ImageIcon(getClass().getResource("/images/arrow_selected.gif"));
 private Icon arrowMouseOverIcon = new javax.swing.ImageIcon(getClass().getResource("/images/arrow_mouseover.gif"));  
 private int iconTextGap = 5;
 private int sbTabMenuTopSpaceFiller = 15;
 private int sbTabLeftMargin = 5;
 private int sbTabWidth = 100;
 private int sbTabHeight = 25;
 private int sbTabGroupHeight = 25;
 private boolean sbTabIsOpaque=true;
 private Color sbTabTopBorderColor = new Color(140, 171, 240);
 private Color sbTabBottomBorderColor = new Color(70, 82, 116);
 private Color sbTabTopSelectedBorderColor = new Color(96, 110, 145);
 private Color sbTabBottomSelectedBorderColor = new Color(198, 226, 253);
 private Color sbTabRightInnerBorderColor = new java.awt.Color(68, 76, 100);
 private Color sbTabRightOuterBorderColor = new java.awt.Color(100, 114, 149);
 private Font sbTabFont = new java.awt.Font("Arial", 1, 12);
 private SBTab TheMenuLabelReference = new SBTab(null,sbTabWidth, sbTabHeight, sbTabLeftMargin, theCurrentMenuColor, theTextMenuColor, arrowIcon, iconTextGap, sbTabTopBorderColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor, sbTabIsOpaque);
 private SBTab thePressedLabelReference = null;
 private SBTab theEnteredLabelReference = null;

 private void setSelectedMenuItem(SBTab theMenuLabel)
  {
    try
    {
        TheMenuLabelReference.setBackgroundColor(theCurrentMenuColor);
	  TheMenuLabelReference.setTheTopBottomBorderColors(sbTabTopBorderColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor);
        TheMenuLabelReference.setTheIcon(arrowIcon);
        theMenuLabel.setBackgroundColor(theSelectedMenuColor);
        theMenuLabel.setTheIcon(arrowSelectedIcon);
	  theMenuLabel.setTheTopBottomBorderColors(sbTabTopSelectedBorderColor, sbTabBottomSelectedBorderColor, theSelectedMenuColor, theSelectedMenuColor);
        TheMenuLabelReference = theMenuLabel;

                        try
                        {
                            setContentPanel((EAPanel)Class.forName(getSidebarComponentID(theMenuLabel.getComponentLocalizationID())).newInstance());
                        }
                        catch(InstantiationException e)
                        {
                            e.printStackTrace();
                        }   
                        catch(IllegalAccessException e)
                        {
                            e.printStackTrace();
                        }                      
                        catch(ClassNotFoundException e)
                        {
                            e.printStackTrace();
                        }   
    }
    catch(Exception e)
    {
	e.printStackTrace();
    }
  }    
 
 boolean isEntered = false;
 private void setMouseEnteredMenuLabel(SBTab theEnteredLabel)
 {
    isEntered = true;
    try
    {
        theEnteredLabelReference = theEnteredLabel;
        if(theEnteredLabel.equals(TheMenuLabelReference)==false)
        {
            theEnteredLabel.setTheIcon(arrowMouseOverIcon);
            if(pressedSelected==true)
            {
                
                TheMenuLabelReference.setForegroundColor(theTextMenuColor);
            }
        }
        else
        {
            if(pressedSelected==true)
            {
                TheMenuLabelReference.setForegroundColor(theSelectedMenuColor);    
            }
        }
    }
    catch(Exception e)
    {
        System.out.println(e);
    }     
 }
 private void setMouseExitedMenuLabel(SBTab theExitedLabel)
 {
    isEntered = false;
    try
    {
        if(theExitedLabel.equals(TheMenuLabelReference)==false)
        {
            theExitedLabel.setTheIcon(arrowIcon);   
        }
        else
        {
            theEnteredLabelReference.setForegroundColor(theTextMenuColor);           
        }
    }
    catch(Exception e)
    {
        System.out.println(e);
    }  
 }

  private void setMousePressedMenuLabel(SBTab thePressedLabel)
 {
    try
    {
        thePressedLabelReference = thePressedLabel;
        if(thePressedLabel.equals(TheMenuLabelReference)==false)
        {
            thePressedLabel.setBackgroundColor(theSelectedMenuColor); 
	  	thePressedLabel.setTheTopBottomBorderColors(sbTabTopSelectedBorderColor, sbTabBottomSelectedBorderColor, theSelectedMenuColor, theSelectedMenuColor);
        }
        else
        {
            pressedSelected=true; 
            thePressedLabel.setForegroundColor(theSelectedMenuColor);
        }
    }
    catch(Exception e)
    {
        System.out.println(e);
    }  
 }
 
  private void setMouseReleasedMenuLabel(SBTab theReleasedLabel)
 {
    try
    {
        pressedSelected = false;
        if(theEnteredLabelReference.equals(thePressedLabelReference)==false || isEntered == false)
        {
            if(thePressedLabelReference.equals(TheMenuLabelReference)==false)
            {
                thePressedLabelReference.setBackgroundColor(theCurrentMenuColor);
		    thePressedLabelReference.setTheTopBottomBorderColors(sbTabTopBorderColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor);
            }
            if(thePressedLabelReference.equals(TheMenuLabelReference)==true)
            {           
                thePressedLabelReference.setForegroundColor(theTextMenuColor);
            }           
        }
        else
        {
            if(thePressedLabelReference.equals(TheMenuLabelReference)==true)
            {           
                thePressedLabelReference.setForegroundColor(theTextMenuColor);
            }
		else
		{
		    try
		    {
 		        TheMenuLabelReference.setBackgroundColor(theCurrentMenuColor);
			  TheMenuLabelReference.setTheTopBottomBorderColors(sbTabTopBorderColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor);
 		        TheMenuLabelReference.setTheIcon(arrowIcon);
 		        thePressedLabelReference.setTheIcon(arrowSelectedIcon);
 		        TheMenuLabelReference = thePressedLabelReference;
                        try
                        {
                            setContentPanel((EAPanel)Class.forName(getSidebarComponentID(theReleasedLabel.getComponentLocalizationID())).newInstance());
                        }
                        catch(InstantiationException e)
                        {
                            e.printStackTrace();
                        }   
                        catch(IllegalAccessException e)
                        {
                            e.printStackTrace();
                        }                      
                        catch(ClassNotFoundException e)
                        {
                            e.printStackTrace();
                        }   
 		    }
		    catch(Exception e)
		    {
		        System.out.println(e);
		    }
		}
        }
        
    }
    catch(Exception e)
    {
        System.out.println(e);
    }  
 } 
    private static synchronized Object[] getStringArraysFromString(String textArrayString)
    {
        ArrayList aryList = new ArrayList();
        String tempString = "";
        try
        {
            while(textArrayString.indexOf(",")!=-1)
            {
                tempString = textArrayString.substring(0,textArrayString.indexOf(","));
                textArrayString = textArrayString.substring(textArrayString.indexOf(",") + 1);
                aryList.add(tempString);
            }
            aryList.add(textArrayString);
            aryList.trimToSize();
        }
        catch(NullPointerException e)
        {
         
        }

        return aryList.toArray();
    }  

private synchronized String getSidebarComponentID(String compRefID)
{
	try
	{
		return (String)sbMap.get(compRefID);
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
	return "";
}

private synchronized void initSidebar()
{
try
{
	Object[] sbUIStrings = getStringArraysFromString(DesignerRuleBuilder.get("sbEvaluationStrings"));
	Object[] sbUIActions = getStringArraysFromString(DesignerRuleBuilder.get("sbEvaluationActionPanels"));
//sbMap

                    for(int i = 0;i<sbUIStrings.length;i++)
                    {
                        try
				{
					sbMap.put((String)sbUIStrings[i],(String)sbUIActions[i]);
					//LeftMenuButtonPanel.add(new SBTab((String)sbUIStrings[i],sbTabWidth, sbTabHeight, sbTabLeftMargin, theCurrentMenuColor, theTextMenuColor, arrowIcon, iconTextGap, sbTabTopBorderColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor, sbTabIsOpaque));
				}
				catch(Exception e)
				{
					sbMap.put((String)sbUIStrings[i],"");
				} 
                    }
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
        EvaluationTypeButtonGroup = new javax.swing.ButtonGroup();
        EvaluationContentTopPanel = new javax.swing.JPanel();
        EvaluationCentralContentPanel = new javax.swing.JPanel();
        EvaluationContentPanel = new javax.swing.JPanel();
        EvaluationContentPanelItem1 = new javax.swing.JPanel();
        EvaluationSettingsPanelItem1 = new javax.swing.JPanel();
        EvaluationEnabledPanel = new javax.swing.JPanel();
        rbTimeEvaluation = new javax.swing.JRadioButton();
        EvaluationPanelMainContainer = new javax.swing.JPanel();
        EvaluationSettingsPanelItem7 = new javax.swing.JPanel();
        EvaluationCentralContentLeftMarginPanel = new javax.swing.JPanel();
        EvaluationCentralContentRightMarginPanel = new javax.swing.JPanel();
        EvaluationContentBottomPanel = new javax.swing.JPanel();
        EvaluationMenuPanel = new javax.swing.JPanel();
        LeftMenuPanelBottomPanel = new javax.swing.JPanel();
        EvaluationMenuButtonPanel = new javax.swing.JPanel();
        EvaluationMenuLabelConfigButton = new javax.swing.JLabel();
        EvaluationMenuLeftSpaceFiller = new javax.swing.JPanel();
        EvaluationSelectionContentPanel = new javax.swing.JPanel();
        EvaluationMenuLabelTimedButton = new SBTab("Timed",sbTabWidth, sbTabHeight, sbTabLeftMargin, theCurrentMenuColor, theTextMenuColor, arrowIcon, iconTextGap, sbTabTopBorderColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor, sbTabIsOpaque);
        EvaluationMenuButtonPanelTop = new SBTab(null,sbTabWidth, sbTabMenuTopSpaceFiller, sbTabLeftMargin, theCurrentMenuColor, theTextMenuColor, null, iconTextGap, theCurrentMenuColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor, sbTabIsOpaque);
        EvaluationMenuButtonPanelBottom = new SBSpacer(theCurrentMenuColor,sbTabTopBorderColor,theCurrentMenuColor,sbTabRightInnerBorderColor,sbTabRightOuterBorderColor,sbTabIsOpaque);
        EvaluationMenuLeftSpaceFiller = new javax.swing.JPanel();
        EvaluationSelectionContentPanel = new javax.swing.JPanel();
        cbEvaluationExpirationEnabled = new javax.swing.JCheckBox();
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        setBackground(new java.awt.Color(100, 120, 170));
        EvaluationContentTopPanel.setLayout(new java.awt.BorderLayout());


        EvaluationContentTopPanel.setBackground(new java.awt.Color(100, 120, 170));
        EvaluationContentTopPanel.setMaximumSize(new java.awt.Dimension(2147483647, 60));
        EvaluationCentralContentPanel.setLayout(new java.awt.BorderLayout());

        EvaluationCentralContentPanel.setBackground(new java.awt.Color(100, 120, 170));
        EvaluationCentralContentPanel.setMaximumSize(new java.awt.Dimension(2147483647, 60));
        EvaluationContentPanel.setLayout(new javax.swing.BoxLayout(EvaluationContentPanel, javax.swing.BoxLayout.Y_AXIS));

        EvaluationContentPanel.setBackground(new java.awt.Color(100, 120, 170));
        EvaluationContentPanel.setMinimumSize(new java.awt.Dimension(448, 0));
        EvaluationContentPanel.setPreferredSize(new java.awt.Dimension(600, 60));
        EvaluationContentPanelItem1.setLayout(new javax.swing.BoxLayout(EvaluationContentPanelItem1, javax.swing.BoxLayout.Y_AXIS));

        EvaluationContentPanelItem1.setBackground(new java.awt.Color(100, 120, 170));
        EvaluationContentPanelItem1.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(140, 171, 240), new java.awt.Color(27, 44, 76)), "Evaluation Type", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12)));
        EvaluationContentPanelItem1.setMaximumSize(new java.awt.Dimension(2147483647, 60));
        EvaluationSettingsPanelItem1.setLayout(new java.awt.BorderLayout());

        EvaluationSettingsPanelItem1.setBackground(new java.awt.Color(100, 120, 170));
        EvaluationEnabledPanel.setLayout(new java.awt.BorderLayout());

        EvaluationEnabledPanel.setBackground(new java.awt.Color(100, 120, 170));
        EvaluationEnabledPanel.setMaximumSize(new java.awt.Dimension(100, 2147483647));


        cbEvaluationExpirationEnabled.setBackground(new java.awt.Color(100, 120, 170));
        cbEvaluationExpirationEnabled.setFont(new java.awt.Font("Arial", 0, 12));
        try
        {
		// Evaluation Expiration Support Functionality Checkbox Enabled/Disabled   
            if(ProjectManager.get("project_expiration_support_is_enabled").equalsIgnoreCase("true")==true)
            {
                cbEvaluationExpirationEnabled.setSelected(true);              
            }
            else
            {
                cbEvaluationExpirationEnabled.setSelected(false);               
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        cbEvaluationExpirationEnabled.setText("Enable Evaluation Expiration Support");
        cbEvaluationExpirationEnabled.setMaximumSize(new java.awt.Dimension(250, 15));
        cbEvaluationExpirationEnabled.setMinimumSize(new java.awt.Dimension(250, 15));
        cbEvaluationExpirationEnabled.setPreferredSize(new java.awt.Dimension(250, 15));

        EvaluationEnabledPanel.add(cbEvaluationExpirationEnabled, java.awt.BorderLayout.WEST);

        rbTimeEvaluation.setBackground(new java.awt.Color(100, 120, 170));
        rbTimeEvaluation.setFont(new java.awt.Font("Arial", 0, 12));
        rbTimeEvaluation.setSelected(true);
        rbTimeEvaluation.setText("Timed Evaluation");
        rbTimeEvaluation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTimeEvaluationActionPerformed(evt);
            }
        });

        EvaluationEnabledPanel.add(rbTimeEvaluation, java.awt.BorderLayout.CENTER);

        EvaluationSettingsPanelItem1.add(EvaluationEnabledPanel, java.awt.BorderLayout.WEST);

        EvaluationPanelMainContainer.setLayout(new java.awt.FlowLayout());

        EvaluationPanelMainContainer.setBackground(new java.awt.Color(100, 120, 170));
        EvaluationSettingsPanelItem1.add(EvaluationPanelMainContainer, java.awt.BorderLayout.CENTER);

        EvaluationContentPanelItem1.add(EvaluationSettingsPanelItem1);

        EvaluationSettingsPanelItem7.setLayout(new java.awt.FlowLayout());

        EvaluationSettingsPanelItem7.setBackground(new java.awt.Color(100, 120, 170));
        EvaluationContentPanelItem1.add(EvaluationSettingsPanelItem7);

        EvaluationContentPanel.add(EvaluationContentPanelItem1);

        EvaluationCentralContentPanel.add(EvaluationContentPanel, java.awt.BorderLayout.CENTER);

        EvaluationCentralContentLeftMarginPanel.setBackground(new java.awt.Color(100, 120, 170));
        EvaluationCentralContentLeftMarginPanel.setMaximumSize(new java.awt.Dimension(32767, 60));
        EvaluationCentralContentPanel.add(EvaluationCentralContentLeftMarginPanel, java.awt.BorderLayout.WEST);

        EvaluationCentralContentRightMarginPanel.setBackground(new java.awt.Color(100, 120, 170));
        EvaluationCentralContentRightMarginPanel.setMaximumSize(new java.awt.Dimension(32767, 60));
        EvaluationCentralContentPanel.add(EvaluationCentralContentRightMarginPanel, java.awt.BorderLayout.EAST);

        EvaluationContentTopPanel.add(EvaluationCentralContentPanel, java.awt.BorderLayout.CENTER);

        add(EvaluationContentTopPanel);

        EvaluationContentBottomPanel.setLayout(new java.awt.BorderLayout());

        EvaluationContentBottomPanel.setBackground(new java.awt.Color(100, 120, 170));
        EvaluationMenuPanel.setLayout(new java.awt.BorderLayout());

        EvaluationMenuPanel.setBackground(new java.awt.Color(100, 120, 170));
        EvaluationMenuPanel.setForeground(new java.awt.Color(255, 255, 255));
        EvaluationMenuPanel.setMaximumSize(new java.awt.Dimension(130, 32767));
        EvaluationMenuPanel.setMinimumSize(new java.awt.Dimension(130, 10));
        EvaluationMenuPanel.setPreferredSize(new java.awt.Dimension(130, 10));
        EvaluationMenuButtonPanel.setLayout(new javax.swing.BoxLayout(EvaluationMenuButtonPanel, javax.swing.BoxLayout.Y_AXIS));

        EvaluationMenuButtonPanel.setBackground(new java.awt.Color(100, 120, 170));
        EvaluationMenuButtonPanel.setForeground(new java.awt.Color(255, 255, 255));
        EvaluationMenuPanel.add(EvaluationMenuButtonPanel, java.awt.BorderLayout.CENTER);

        EvaluationMenuLeftSpaceFiller.setBackground(new java.awt.Color(100, 120, 170));
        EvaluationMenuLeftSpaceFiller.setMinimumSize(new java.awt.Dimension(5, 10));
        EvaluationMenuLeftSpaceFiller.setPreferredSize(new java.awt.Dimension(5, 10));
        EvaluationMenuPanel.add(EvaluationMenuLeftSpaceFiller, java.awt.BorderLayout.WEST);

        EvaluationContentBottomPanel.add(EvaluationMenuPanel, java.awt.BorderLayout.WEST);

        EvaluationSelectionContentPanel.setLayout(new java.awt.BorderLayout());

        EvaluationSelectionContentPanel.setBackground(new java.awt.Color(140, 160, 210));
        EvaluationSelectionContentPanel.setForeground(new java.awt.Color(255, 255, 255));
        EvaluationContentBottomPanel.add(EvaluationSelectionContentPanel, java.awt.BorderLayout.CENTER);

        add(EvaluationContentBottomPanel);

        EvaluationMenuPanel.setLayout(new java.awt.BorderLayout());

        EvaluationMenuPanel.setBackground(new java.awt.Color(100, 120, 170));
        EvaluationMenuPanel.setForeground(new java.awt.Color(255, 255, 255));
        EvaluationMenuPanel.setMaximumSize(new java.awt.Dimension(sbTabWidth, 32767));
        EvaluationMenuPanel.setMinimumSize(new java.awt.Dimension(sbTabWidth, 10));
        EvaluationMenuPanel.setPreferredSize(new java.awt.Dimension(sbTabWidth, 10));
        EvaluationMenuButtonPanel.setLayout(new javax.swing.BoxLayout(EvaluationMenuButtonPanel, javax.swing.BoxLayout.Y_AXIS));

        EvaluationMenuButtonPanel.setBackground(new java.awt.Color(100, 120, 170));
        EvaluationMenuButtonPanel.setForeground(new java.awt.Color(255, 255, 255));
        EvaluationMenuButtonPanel.setMaximumSize(new java.awt.Dimension(sbTabWidth, sbTabGroupHeight));
        EvaluationMenuButtonPanel.setMinimumSize(new java.awt.Dimension(sbTabWidth, sbTabGroupHeight));
        EvaluationMenuButtonPanel.setPreferredSize(new java.awt.Dimension(sbTabWidth, sbTabGroupHeight));
        LeftMenuPanelBottomPanel.setLayout(new java.awt.BorderLayout());

        LeftMenuPanelBottomPanel.setBackground(new java.awt.Color(39, 63, 109));
        LeftMenuPanelBottomPanel.setForeground(new java.awt.Color(255, 255, 255));
        LeftMenuPanelBottomPanel.setMaximumSize(new java.awt.Dimension(sbTabWidth, sbTabGroupHeight));
        LeftMenuPanelBottomPanel.setMinimumSize(new java.awt.Dimension(sbTabWidth, sbTabGroupHeight));
        LeftMenuPanelBottomPanel.setPreferredSize(new java.awt.Dimension(sbTabWidth, sbTabGroupHeight));

         EvaluationMenuLabelTimedButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EvaluationMenuLabelTimedButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EvaluationMenuLabelTimedButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EvaluationMenuLabelTimedButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EvaluationMenuLabelTimedButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                EvaluationMenuLabelTimedButtonMouseReleased(evt);
            }
        });

        EvaluationMenuButtonPanel.add(EvaluationMenuLabelTimedButton);
/**********************/
        LeftMenuPanelBottomPanel.add(EvaluationMenuButtonPanel, java.awt.BorderLayout.NORTH);
        LeftMenuPanelBottomPanel.add(EvaluationMenuButtonPanelBottom, java.awt.BorderLayout.CENTER);
        EvaluationMenuPanel.add(LeftMenuPanelBottomPanel, java.awt.BorderLayout.CENTER);
        EvaluationMenuPanel.add(EvaluationMenuButtonPanelTop, java.awt.BorderLayout.NORTH);
        EvaluationMenuButtonPanelBottom.setBackground(new java.awt.Color(100, 120, 170));
        EvaluationMenuButtonPanelBottom.setForeground(new java.awt.Color(255, 255, 255));
        EvaluationMenuLeftSpaceFiller.setBackground(new java.awt.Color(100, 120, 170));
        EvaluationMenuLeftSpaceFiller.setMinimumSize(new java.awt.Dimension(1, 10));
        EvaluationMenuLeftSpaceFiller.setPreferredSize(new java.awt.Dimension(1, 10));
        EvaluationMenuPanel.add(EvaluationMenuLeftSpaceFiller, java.awt.BorderLayout.WEST);
        EvaluationContentBottomPanel.add(EvaluationMenuPanel, java.awt.BorderLayout.WEST);
/**********************/
        EvaluationSelectionContentPanel.setLayout(new java.awt.BorderLayout());

        EvaluationSelectionContentPanel.setBackground(new java.awt.Color(140, 160, 210));
        EvaluationSelectionContentPanel.setForeground(new java.awt.Color(255, 255, 255));
        EvaluationContentBottomPanel.add(EvaluationSelectionContentPanel, java.awt.BorderLayout.CENTER);

        //add(EvaluationContentBottomPanel);
// add header here
	  contentPanel = new JPanel();
        contentPanel.setLayout(new java.awt.BorderLayout());
        contentPanel.add(EvaluationMenuPanel, java.awt.BorderLayout.WEST);
        contentPanel.add(EvaluationContentBottomPanel, java.awt.BorderLayout.CENTER);
	  contentProjectPanel = new ContentAreaHeaderPanel(contentPanel, sbTabWidth, theCurrentMenuColor, sbTabRightInnerBorderColor,sbTabRightOuterBorderColor,theSelectedMenuColor);
	  add(contentProjectPanel, java.awt.BorderLayout.CENTER);
    }//GEN-END:initComponents

    private void rbTimeEvaluationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTimeEvaluationActionPerformed
        // Add your handling code here:
    }//GEN-LAST:event_rbTimeEvaluationActionPerformed

    private void EvaluationMenuLabelTimedButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvaluationMenuLabelTimedButtonMouseReleased
	 setMouseReleasedMenuLabel(EvaluationMenuLabelTimedButton);
    }//GEN-LAST:event_EvaluationMenuLabelTimedButtonMouseReleased

    private void EvaluationMenuLabelTimedButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvaluationMenuLabelTimedButtonMousePressed
        setMousePressedMenuLabel(EvaluationMenuLabelTimedButton);
    }//GEN-LAST:event_EvaluationMenuLabelTimedButtonMousePressed

    private void EvaluationMenuLabelTimedButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvaluationMenuLabelTimedButtonMouseExited
        setMouseExitedMenuLabel(EvaluationMenuLabelTimedButton);
    }//GEN-LAST:event_EvaluationMenuLabelTimedButtonMouseExited

    private void EvaluationMenuLabelTimedButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvaluationMenuLabelTimedButtonMouseEntered
        setMouseEnteredMenuLabel(EvaluationMenuLabelTimedButton);
    }//GEN-LAST:event_EvaluationMenuLabelTimedButtonMouseEntered

    private void EvaluationMenuLabelTimedButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EvaluationMenuLabelTimedButtonMouseClicked
 	setSelectedMenuItem(EvaluationMenuLabelTimedButton);
    }//GEN-LAST:event_EvaluationMenuLabelTimedButtonMouseClicked
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EvaluationCentralContentLeftMarginPanel;
    private javax.swing.JPanel EvaluationCentralContentPanel;
    private javax.swing.JPanel EvaluationCentralContentRightMarginPanel;
    private javax.swing.JPanel EvaluationContentBottomPanel;
    private javax.swing.JPanel EvaluationContentPanel;
    private javax.swing.JPanel EvaluationContentPanelItem1;
    private javax.swing.JPanel EvaluationContentTopPanel;
    private javax.swing.JPanel EvaluationEnabledPanel;
    private javax.swing.JPanel EvaluationMenuButtonPanel;
    private javax.swing.JLabel EvaluationMenuLabelConfigButton;
    private javax.swing.JPanel EvaluationMenuLeftSpaceFiller;
    private javax.swing.JPanel EvaluationMenuPanel;
    private javax.swing.JPanel EvaluationPanelMainContainer;
    private javax.swing.JPanel EvaluationSelectionContentPanel;
    private javax.swing.JPanel EvaluationSettingsPanelItem1;
    private javax.swing.JPanel EvaluationSettingsPanelItem7;
    private javax.swing.JPanel LeftMenuPanelBottomPanel;
    private javax.swing.ButtonGroup EvaluationTypeButtonGroup;
    private javax.swing.JRadioButton rbTimeEvaluation;
    private SBTab EvaluationMenuLabelTimedButton;
    private SBSpacer EvaluationMenuButtonPanelBottom;
    private SBTab EvaluationMenuButtonPanelTop;
    private ContentAreaHeaderPanel contentProjectPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JCheckBox cbEvaluationExpirationEnabled;
    // End of variables declaration//GEN-END:variables
    
}
