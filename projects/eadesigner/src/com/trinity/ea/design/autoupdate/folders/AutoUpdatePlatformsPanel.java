/*
 * AutoUpdatePlatformsPanel.java
 *
 * Created on March 7, 2004, 5:33 PM
 */

package com.trinity.ea.design.autoupdate.folders;

import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.common.panel.MarginContentPanelFourthTier;
import com.trinity.ea.design.common.sidebar.SBTab;
import com.trinity.ea.design.common.sidebar.SBSpacer;
import com.trinity.ea.design.rules.builder.DesignerRuleBuilder;
import com.trinity.ea.design.autoupdate.folders.AutoUpdatePlatformsPanel;
import com.trinity.ea.design.autoupdate.folders.AutoUpdateFoldersPanel;
import java.awt.Font;
import java.util.HashMap;
import java.util.Collections;
import java.util.Map;
import java.util.ArrayList;
import com.trinity.ea.design.common.borderline.ContentAreaHeaderPanel3;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.InsetsUIResource;
import javax.swing.plaf.BorderUIResource;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class AutoUpdatePlatformsPanel extends EAPanel {
    Map sbMap = Collections.synchronizedMap(new HashMap());  
    AutoUpdateFoldersPanel aufp = new AutoUpdateFoldersPanel();
    MarginContentPanelFourthTier mcpft = new MarginContentPanelFourthTier();
    private int osDefine = 0;
    public final static int WINDOWS = 0;
    public final static int UNIX = 1;
    public final static int JAVA = 2;
    public final static int OSX = 3;
    public void setOperatingEnvironment(int operatingEnvironment)
    {
	  try
	  {
	  	osDefine = operatingEnvironment;
	  	aufp.setOperatingEnvironment(operatingEnvironment);
	  	mcpft.setContentPanel(aufp);
	  	setContentPanel(mcpft);
	  }
	  catch(Exception e)
	  {
		e.printStackTrace();
	  }  
    }    
    public int getOperatingEnvironment()
    {
	  return osDefine;
    }    
  
    /** Creates new form AutoUpdatePlatformsPanel */
    public AutoUpdatePlatformsPanel() 
    {
	  try
	  {
        	initComponents();
	  	initSidebar();
        	setSelectedMenuItem(lJavaMenuItem);
	  	setOperatingEnvironment(2);
  	  	setProjectData();
	  }
	  catch(Exception e)
	  {
		e.printStackTrace();
	  }   
    }

   private EAPanel TheContentPanelReference = new EAPanel();
   public void setContentPanel(EAPanel theContentPanel)
  {
    try
    {
	 getDataUpdate();
       TheContentPanelReference.setVisible(false);
       PaymentsSelectionContentPanel.remove(TheContentPanelReference);        
       TheContentPanelReference = theContentPanel;
       PaymentsSelectionContentPanel.add(TheContentPanelReference);     
       TheContentPanelReference.setVisible(true);

    }
    catch(Exception e)
    {
        System.out.println(e);
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
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents

        setLayout(new java.awt.BorderLayout());
        setBackground(new java.awt.Color(140, 160, 210));
 	  PaymentsMenuPanel = new javax.swing.JPanel();
	  PaymentsContentBottomPanel = new javax.swing.JPanel();
        LeftMenuPanelBottomPanel = new javax.swing.JPanel();
	  PaymentsUIMenuButtonPanel = new javax.swing.JPanel();
        PaymentsUIMenuButtonPanelTop = new SBTab(null,sbTabWidth, sbTabMenuTopSpaceFiller, sbTabLeftMargin, theCurrentMenuColor, theTextMenuColor, null, iconTextGap, theCurrentMenuColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor, sbTabIsOpaque);
        PaymentsUIMenuButtonPanelBottom = new SBSpacer(theCurrentMenuColor,sbTabTopBorderColor,theCurrentMenuColor,sbTabRightInnerBorderColor,sbTabRightOuterBorderColor,sbTabIsOpaque);
        PaymentsMenuLeftSpaceFiller = new javax.swing.JPanel();
	  PaymentsMenuContentPanel = new javax.swing.JPanel();
	  PaymentsSelectionContentPanel = new javax.swing.JPanel();

        PaymentsMenuPanel.setLayout(new java.awt.BorderLayout());
        PaymentsMenuPanel.setBackground(new java.awt.Color(140, 160, 210));
        PaymentsMenuPanel.setForeground(new java.awt.Color(255, 255, 255));
        PaymentsMenuPanel.setMaximumSize(new java.awt.Dimension(sbTabWidth, 32767));
        PaymentsMenuPanel.setMinimumSize(new java.awt.Dimension(sbTabWidth, 0));
        PaymentsMenuPanel.setPreferredSize(new java.awt.Dimension(sbTabWidth, 200));
        PaymentsUIMenuButtonPanel.setLayout(new javax.swing.BoxLayout(PaymentsUIMenuButtonPanel, javax.swing.BoxLayout.Y_AXIS));
        PaymentsUIMenuButtonPanel.setBackground(theCurrentMenuColor);
        PaymentsUIMenuButtonPanel.setForeground(theTextMenuColor);
        PaymentsUIMenuButtonPanel.setMaximumSize(new java.awt.Dimension(sbTabWidth, sbTabGroupHeight));
        PaymentsUIMenuButtonPanel.setMinimumSize(new java.awt.Dimension(sbTabWidth, sbTabGroupHeight));
        PaymentsUIMenuButtonPanel.setPreferredSize(new java.awt.Dimension(sbTabWidth, sbTabGroupHeight));

        LeftMenuPanelBottomPanel.setLayout(new java.awt.BorderLayout());
        LeftMenuPanelBottomPanel.setBackground(new java.awt.Color(140, 160, 210));
        LeftMenuPanelBottomPanel.setForeground(new java.awt.Color(255, 255, 255));
        LeftMenuPanelBottomPanel.setMaximumSize(new java.awt.Dimension(sbTabWidth, 100));
        LeftMenuPanelBottomPanel.setMinimumSize(new java.awt.Dimension(sbTabWidth, 100));
        LeftMenuPanelBottomPanel.setPreferredSize(new java.awt.Dimension(sbTabWidth, 100));

        PaymentsContentBottomPanel.setLayout(new java.awt.BorderLayout());
        PaymentsContentBottomPanel.setMaximumSize(new java.awt.Dimension(32767, 200));
        PaymentsContentBottomPanel.setMinimumSize(new java.awt.Dimension(0, 200));
        PaymentsContentBottomPanel.setPreferredSize(new java.awt.Dimension(500, 200));
        PaymentsContentBottomPanel.setBackground(new java.awt.Color(140, 160, 210));

        PaymentsSelectionContentPanel.setLayout(new java.awt.BorderLayout());
        PaymentsSelectionContentPanel.setBackground(new java.awt.Color(140, 160, 210));
        PaymentsSelectionContentPanel.setForeground(new java.awt.Color(255, 255, 255));

	  lJavaMenuItem = new SBTab("Java",sbTabWidth, sbTabHeight, sbTabLeftMargin, theCurrentMenuColor, theTextMenuColor, arrowIcon, iconTextGap, sbTabTopBorderColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor, sbTabIsOpaque);
    	  lOSXMenuItem = new SBTab("Mac OS X",sbTabWidth, sbTabHeight, sbTabLeftMargin, theCurrentMenuColor, theTextMenuColor, arrowIcon, iconTextGap, sbTabTopBorderColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor, sbTabIsOpaque);
	  lUNIXMenuItem = new SBTab("UNIX",sbTabWidth, sbTabHeight, sbTabLeftMargin, theCurrentMenuColor, theTextMenuColor, arrowIcon, iconTextGap, sbTabTopBorderColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor, sbTabIsOpaque);
    	  lWindowsMenuItem = new SBTab("Windows",sbTabWidth, sbTabHeight, sbTabLeftMargin, theCurrentMenuColor, theTextMenuColor, arrowIcon, iconTextGap, sbTabTopBorderColor, sbTabBottomBorderColor, sbTabRightInnerBorderColor, sbTabRightOuterBorderColor, sbTabIsOpaque);

	  lJavaMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lJavaMenuItemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lJavaMenuItemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lJavaMenuItemMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lJavaMenuItemMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lJavaMenuItemMouseReleased(evt);
            }
        });

        PaymentsUIMenuButtonPanel.add(lJavaMenuItem);

	  lOSXMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lOSXMenuItemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lOSXMenuItemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lOSXMenuItemMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lOSXMenuItemMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lOSXMenuItemMouseReleased(evt);
            }
        });

        PaymentsUIMenuButtonPanel.add(lOSXMenuItem);


	  lWindowsMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lWindowsMenuItemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lWindowsMenuItemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lWindowsMenuItemMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lWindowsMenuItemMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lWindowsMenuItemMouseReleased(evt);
            }
        });

        PaymentsUIMenuButtonPanel.add(lWindowsMenuItem);

	  lUNIXMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lUNIXMenuItemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lUNIXMenuItemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lUNIXMenuItemMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lUNIXMenuItemMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lUNIXMenuItemMouseReleased(evt);
            }
        });

        PaymentsUIMenuButtonPanel.add(lUNIXMenuItem);

/**********************/

        LeftMenuPanelBottomPanel.add(PaymentsUIMenuButtonPanel, java.awt.BorderLayout.NORTH);
        LeftMenuPanelBottomPanel.add(PaymentsUIMenuButtonPanelBottom, java.awt.BorderLayout.CENTER);
        PaymentsMenuPanel.add(LeftMenuPanelBottomPanel, java.awt.BorderLayout.CENTER);
        PaymentsMenuPanel.add(PaymentsUIMenuButtonPanelTop, java.awt.BorderLayout.NORTH);
        PaymentsUIMenuButtonPanelBottom.setBackground(new java.awt.Color(140, 160, 210));
        PaymentsUIMenuButtonPanelBottom.setForeground(new java.awt.Color(255, 255, 255));
        PaymentsMenuLeftSpaceFiller.setBackground(new java.awt.Color(140, 160, 210));
        PaymentsMenuLeftSpaceFiller.setMinimumSize(new java.awt.Dimension(1, 10));
        PaymentsMenuLeftSpaceFiller.setPreferredSize(new java.awt.Dimension(1, 10));
        PaymentsMenuPanel.add(PaymentsMenuLeftSpaceFiller, java.awt.BorderLayout.WEST);
        PaymentsContentBottomPanel.add(PaymentsMenuPanel, java.awt.BorderLayout.WEST);
        PaymentsContentBottomPanel.add(PaymentsMenuPanel, java.awt.BorderLayout.WEST);
        PaymentsContentBottomPanel.add(PaymentsSelectionContentPanel, java.awt.BorderLayout.CENTER);
/**********************/
///////////////////////////
// add header here
	  contentPanel = new JPanel();
        contentPanel.setLayout(new java.awt.BorderLayout());
        contentPanel.add(PaymentsMenuPanel, java.awt.BorderLayout.WEST);
        contentPanel.add(PaymentsSelectionContentPanel, java.awt.BorderLayout.CENTER);
	  contentProjectPanel = new ContentAreaHeaderPanel3(contentPanel, sbTabWidth, theCurrentMenuColor, sbTabRightInnerBorderColor,sbTabRightOuterBorderColor,theSelectedMenuColor);
	add(contentProjectPanel, java.awt.BorderLayout.CENTER);

    }//GEN-END:initComponents

  public void getDataUpdate()
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
 
    private void lJavaMenuItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lJavaMenuItemMouseReleased
	 setMouseReleasedMenuLabel(lJavaMenuItem);
    }//GEN-LAST:event_lJavaMenuItemMouseReleased

    private void lJavaMenuItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lJavaMenuItemMousePressed
        setMousePressedMenuLabel(lJavaMenuItem);
    }//GEN-LAST:event_lJavaMenuItemMousePressed

    private void lJavaMenuItemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lJavaMenuItemMouseExited
        setMouseExitedMenuLabel(lJavaMenuItem);
    }//GEN-LAST:event_lJavaMenuItemMouseExited

    private void lJavaMenuItemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lJavaMenuItemMouseEntered
        setMouseEnteredMenuLabel(lJavaMenuItem);
    }//GEN-LAST:event_lJavaMenuItemMouseEntered

    private void lJavaMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lJavaMenuItemMouseClicked
	//((EADesignerPaymentsPanel)getParentComponent()).setPaymentsHTMLFormInputsPropertyPanel();
 	setSelectedMenuItem(lJavaMenuItem);
	getDataUpdate();
	setOperatingEnvironment(2);
    }//GEN-LAST:event_lJavaMenuItemMouseClicked

    private void lWindowsMenuItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lWindowsMenuItemMouseReleased
	 setMouseReleasedMenuLabel(lWindowsMenuItem);
    }//GEN-LAST:event_lWindowsMenuItemMouseReleased

    private void lWindowsMenuItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lWindowsMenuItemMousePressed
        setMousePressedMenuLabel(lWindowsMenuItem);
    }//GEN-LAST:event_lWindowsMenuItemMousePressed

    private void lWindowsMenuItemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lWindowsMenuItemMouseExited
        setMouseExitedMenuLabel(lWindowsMenuItem);
    }//GEN-LAST:event_lWindowsMenuItemMouseExited

    private void lWindowsMenuItemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lWindowsMenuItemMouseEntered
        setMouseEnteredMenuLabel(lWindowsMenuItem);
    }//GEN-LAST:event_lWindowsMenuItemMouseEntered

    private void lWindowsMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lWindowsMenuItemMouseClicked
	//((EADesignerPaymentsPanel)getParentComponent()).setPaymentResponseHTMLFormInputsPropertyPanel();
 	setSelectedMenuItem(lWindowsMenuItem);
	getDataUpdate();
	setOperatingEnvironment(0);
    }//GEN-LAST:event_lWindowsMenuItemMouseClicked

    private void lOSXMenuItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lOSXMenuItemMouseReleased
	 setMouseReleasedMenuLabel(lOSXMenuItem);
    }//GEN-LAST:event_lOSXMenuItemMouseReleased

    private void lOSXMenuItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lOSXMenuItemMousePressed
        setMousePressedMenuLabel(lOSXMenuItem);
    }//GEN-LAST:event_lOSXMenuItemMousePressed

    private void lOSXMenuItemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lOSXMenuItemMouseExited
        setMouseExitedMenuLabel(lOSXMenuItem);
    }//GEN-LAST:event_lOSXMenuItemMouseExited

    private void lOSXMenuItemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lOSXMenuItemMouseEntered
        setMouseEnteredMenuLabel(lOSXMenuItem);
    }//GEN-LAST:event_lOSXMenuItemMouseEntered

    private void lOSXMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lOSXMenuItemMouseClicked
	//((EADesignerPaymentsPanel)getParentComponent()).setPaymentResponseHTMLFormInputsPropertyPanel();
 	setSelectedMenuItem(lOSXMenuItem);
	getDataUpdate();
	setOperatingEnvironment(3);
    }//GEN-LAST:event_lOSXMenuItemMouseClicked

    private void lUNIXMenuItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lUNIXMenuItemMouseReleased
	 setMouseReleasedMenuLabel(lUNIXMenuItem);
    }//GEN-LAST:event_lUNIXMenuItemMouseReleased

    private void lUNIXMenuItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lUNIXMenuItemMousePressed
        setMousePressedMenuLabel(lUNIXMenuItem);
    }//GEN-LAST:event_lUNIXMenuItemMousePressed

    private void lUNIXMenuItemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lUNIXMenuItemMouseExited
        setMouseExitedMenuLabel(lUNIXMenuItem);
    }//GEN-LAST:event_lUNIXMenuItemMouseExited

    private void lUNIXMenuItemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lUNIXMenuItemMouseEntered
        setMouseEnteredMenuLabel(lUNIXMenuItem);
    }//GEN-LAST:event_lUNIXMenuItemMouseEntered

    private void lUNIXMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lUNIXMenuItemMouseClicked
	//((EADesignerPaymentsPanel)getParentComponent()).setPaymentResponseHTMLFormInputsPropertyPanel();
 	setSelectedMenuItem(lUNIXMenuItem);
	getDataUpdate();
	setOperatingEnvironment(1);
    }//GEN-LAST:event_lUNIXMenuItemMouseClicked

 private Color theCurrentMenuColor = new Color(140,160,210);
 private Color theSelectedMenuColor = new Color(176, 191, 240);
 private Color theTextMenuColor = new Color(255, 255, 255);
 private boolean pressedSelected = false;
 private Icon arrowIcon = new javax.swing.ImageIcon(getClass().getResource("/images/arrow.gif"));
 private Icon arrowSelectedIcon = new javax.swing.ImageIcon(getClass().getResource("/images/arrow_selected.gif"));
 private Icon arrowMouseOverIcon = new javax.swing.ImageIcon(getClass().getResource("/images/arrow_mouseover.gif"));  
 private int iconTextGap = 5;
 private int sbTabMenuTopSpaceFiller = 15;
 private int sbTabLeftMargin = 5;
 private int sbTabWidth = 90;
 private int sbTabHeight = 25;
 private int sbTabGroupHeight = 100;
 private boolean sbTabIsOpaque=true;
 private Color sbTabTopBorderColor = new Color(198, 226, 253);
 private Color sbTabBottomBorderColor = new Color(100, 114, 149);
 private Color sbTabTopSelectedBorderColor = new Color(123,132,167);
 private Color sbTabBottomSelectedBorderColor = new Color(251, 255, 255);
 private Color sbTabRightInnerBorderColor = new java.awt.Color(84,94,118);
 private Color sbTabRightOuterBorderColor = new java.awt.Color(123,132,167);
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
	Object[] sbUIStrings = getStringArraysFromString(DesignerRuleBuilder.get("sbPaymentsHTMLFormStrings"));
	Object[] sbUIActions = getStringArraysFromString(DesignerRuleBuilder.get("sbPaymentsHTMLFormActionPanels"));
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
   
public void setPaymentSelected()
{
	setSelectedMenuItem(lJavaMenuItem);
}
public void setResponseSelected()
{
	setSelectedMenuItem(lWindowsMenuItem);
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private SBSpacer PaymentsUIMenuButtonPanelBottom;
    private SBTab PaymentsUIMenuButtonPanelTop;
    private SBTab lJavaMenuItem;
    private SBTab lWindowsMenuItem;
    private SBTab lOSXMenuItem;
    private SBTab lUNIXMenuItem;
    private ContentAreaHeaderPanel3 contentProjectPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel PaymentsUIMenuButtonPanel;
    private javax.swing.JPanel PaymentsMenuContentPanel;
    private javax.swing.JPanel PaymentsMenuLeftSpaceFiller;
    private javax.swing.JPanel PaymentsMenuPanel;
    private javax.swing.JPanel PaymentsSelectionContentPanel;
    private javax.swing.JPanel LeftMenuPanelBottomPanel;
    private javax.swing.JPanel PaymentsContentBottomPanel;
/////////////////////////// 
   // End of variables declaration//GEN-END:variables
    
}
