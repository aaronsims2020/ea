/*
 * AutoUpdateActionsPanel.java
 *
 * Created on December 30, 2003, 2:43 PM
 */

package com.trinity.ea.design.autoupdate.actions;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.common.panel.EAMasterControlPanel;
import com.trinity.ea.design.common.panel.EAPropertiesPanel;
import com.trinity.ea.design.common.panel.EAListItem;
import com.trinity.ea.design.common.panel.EAListItemContent;
import com.trinity.ea.design.common.panel.DataContentPanel;
import com.trinity.ea.design.common.panel.TextFieldPanel;
import com.trinity.ea.design.common.file.ProjectManager;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class AutoUpdateActionsPanel extends EAMasterControlPanel {
    private Color backgroundColor = new java.awt.Color(140, 160, 210);
    private Color borderColor1 = new java.awt.Color(198, 226, 253);
    private Color borderColor2 = new java.awt.Color(96, 110, 145);
    private Color rowColor = new java.awt.Color(220, 225, 240);
    private Color rowBorderColor = new java.awt.Color(255, 255, 255);
    private Icon theActionRowIcon = new javax.swing.ImageIcon(getClass().getResource("/images/lgpl/action.png"));
    private int rowHeight = 25;

    /** Creates new form PaymentActionsPanel */
    public AutoUpdateActionsPanel() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        ContentPanel = new javax.swing.JPanel();
        BottomContentPanel = new javax.swing.JPanel();
        setLayout(new java.awt.BorderLayout());


        setBackground(new java.awt.Color(140, 160, 210));
//
theEAProperties = new EAPropertiesPanel(getActionsEAListItems(),rowColor, rowBorderColor, backgroundColor, rowHeight);
//
theEAProperties.setMasterControlPanel(this);
//	  
	  //theEAProperties.setDescriptorPanelWidth(226);
	try
	{
	  theEAProperties.setHeaderText("Action Mappings");
	  theEAProperties.setDescriptorText("");
	  theEAProperties.setHeaderTextAndWidth("Action Mappings", 225, "Class Name", 120, "", 0);
	  theEAProperties.setAddButtonVisible(false);
	  theEAProperties.setEditButtonVisible(false);
	  theEAProperties.setRemoveButtonVisible(false);
	  theEAProperties.setPreviewButtonVisible(false);
	  theEAProperties.setConfigurationWizardButtonVisible(false);
	  //theEAProperties.setListDefaults(getActionsEAListItems());
	  theEAProperties.setSelectedIndex(0);
	  EAListItem eaListItemObj = theEAProperties.getSelectedEAListItem();
	  eaListItemObj.setSelectedMode();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
        //add(ActionsContentPanel, java.awt.BorderLayout.CENTER);
	  ContentPanel.add(BottomContentPanel,java.awt.BorderLayout.SOUTH);
	  ContentPanel.setBackground(new Color(140, 160, 210));
	  BottomContentPanel.setBackground(new Color(140, 160, 210));
        BottomContentPanel.setMaximumSize(new java.awt.Dimension(32767, 275));
        BottomContentPanel.setMinimumSize(new java.awt.Dimension(10, 0));
        BottomContentPanel.setPreferredSize(new java.awt.Dimension(800, 275));
        ContentPanel.setLayout(new java.awt.BorderLayout(5,5));
	  ContentPanel.add(theEAProperties,java.awt.BorderLayout.CENTER);
	  add(ContentPanel, java.awt.BorderLayout.CENTER);


    }//GEN-END:initComponents

    private void btnSkipInstallActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkipInstallActionActionPerformed
        // Add your handling code here:
    }//GEN-LAST:event_btnSkipInstallActionActionPerformed

    private void btnInstallActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstallActionActionPerformed
        // Add your handling code here:
    }//GEN-LAST:event_btnInstallActionActionPerformed

    private void btnStartInstallUIActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartInstallUIActionActionPerformed
        // Add your handling code here:
    }//GEN-LAST:event_btnStartInstallUIActionActionPerformed

    private void btnUpdatesUIActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatesUIActionActionPerformed
        // Add your handling code here:
    }//GEN-LAST:event_btnUpdatesUIActionActionPerformed


private String[] strActionsArray = new String[4];
private EAListItem[] ActionsEAListItemArray = new EAListItem[4];
private EAListItem[] getActionsEAListItems()
{
        try
        {
		int defActionLabelWidth = 200;
		int defActionDataWidth = 325;

		EAListItem[] eaItems = new EAListItem[4];
            EAListItem eai = new EAListItem(theActionRowIcon,rowColor);
		EAListItemContent autoUpdateLoadCheckForUpdatesUIAction = new EAListItemContent(rowColor, defActionLabelWidth, defActionDataWidth);
		autoUpdateLoadCheckForUpdatesUIAction.setLabelText("Check for Updates UI Action:");
		if(ProjectManager.get("autoUpdateLoadCheckForUpdatesUIAction")!=null)
		{
			autoUpdateLoadCheckForUpdatesUIAction.setInputText(ProjectManager.get("autoUpdateLoadCheckForUpdatesUIAction"));
			strActionsArray[0] = "autoUpdateLoadCheckForUpdatesUIAction";
		}
            eai.setRowDataPanel(autoUpdateLoadCheckForUpdatesUIAction);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai.setListItemIsRemovable(false);
		eai.setValueBoxEnabled(false);
		eaItems[0] = eai;
//
            EAListItem eai2 = new EAListItem(theActionRowIcon,rowColor);
		EAListItemContent autoUpdateLoadInstallUIAction = new EAListItemContent(rowColor, defActionLabelWidth, defActionDataWidth);
		autoUpdateLoadInstallUIAction.setLabelText("Start Install UI Action:");
		if(ProjectManager.get("autoUpdateLoadInstallUIAction")!=null)
		{
			autoUpdateLoadInstallUIAction.setInputText(ProjectManager.get("autoUpdateLoadInstallUIAction"));
			strActionsArray[1] = "autoUpdateLoadInstallUIAction";
		}
            eai2.setRowDataPanel(autoUpdateLoadInstallUIAction);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai2.setListItemIsRemovable(false);
		eai2.setValueBoxEnabled(false);
		eaItems[1] = eai2;
//
            EAListItem eai3 = new EAListItem(theActionRowIcon,rowColor);
		EAListItemContent autoUpdateInstallAction = new EAListItemContent(rowColor, defActionLabelWidth, defActionDataWidth);
		autoUpdateInstallAction.setLabelText("Install Action:");
		if(ProjectManager.get("autoUpdateInstallAction")!=null)
		{
			autoUpdateInstallAction.setInputText(ProjectManager.get("autoUpdateInstallAction"));
			strActionsArray[2] = "autoUpdateInstallAction";
		}
            eai3.setRowDataPanel(autoUpdateInstallAction);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai3.setListItemIsRemovable(false);
		eai3.setValueBoxEnabled(false);
		eaItems[2] = eai3;
//
            EAListItem eai4 = new EAListItem(theActionRowIcon,rowColor);
		EAListItemContent autoUpdateSkipAction = new EAListItemContent(rowColor, defActionLabelWidth, defActionDataWidth);
		autoUpdateSkipAction.setLabelText("Skip Install Action:");
		if(ProjectManager.get("autoUpdateSkipAction")!=null)
		{
			autoUpdateSkipAction.setInputText(ProjectManager.get("autoUpdateSkipAction"));
			strActionsArray[3] = "autoUpdateSkipAction";
		}
            eai4.setRowDataPanel(autoUpdateSkipAction);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai4.setListItemIsRemovable(false);
		eai4.setValueBoxEnabled(false);
		eaItems[3] = eai4;
		ActionsEAListItemArray = eaItems;

		return eaItems;
        }
        catch(Exception e)
        {
          e.printStackTrace();   
        }
	EAListItem[] tempLIArray2 = new EAListItem[0];
	return tempLIArray2;
}

   private EAPanel TheContentPanelReference = new EAPanel();
   private void setContentPanel(EAPanel theContentPanel)
  {
    try
    {
	 getDataUpdate();
       TheContentPanelReference.setVisible(false);
       BottomContentPanel.remove(TheContentPanelReference);        
       TheContentPanelReference = theContentPanel;
	 BottomContentPanel.setPreferredSize(new java.awt.Dimension(620, 275));
       BottomContentPanel.add(TheContentPanelReference);     
       TheContentPanelReference.setVisible(true);

    }
    catch(Exception e)
    {
        System.out.println(e);
    }
  }
    
    public void setSelectedListItemEvent(int theLastSelectedIndex)
    {
		try
		{
			TheContentPanelReference.getDataUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		EAListItem eaListItemObj = theEAProperties.getSelectedEAListItem();
		EAListItemContent theContent = eaListItemObj.getRowDataPanel();
		if(theLastSelectedIndex!=-1)
		{
			try
			{
				theEAProperties.getSelectedEAListItem().getRowDataPanel().setInputText(ProjectManager.get(strActionsArray[theLastSelectedIndex]));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

		DataContentPanel tempPanel = new DataContentPanel("The Automatic Update Action can be viewed below.");
		tempPanel.setFlexibleContentPanel(new TextFieldPanel(ActionsEAListItemArray[theEAProperties.getSelectedIndex()].getRowDataPanel().getLabelText(), ProjectManager.get(strActionsArray[theEAProperties.getSelectedIndex()]), strActionsArray[theEAProperties.getSelectedIndex()], true),620,200);
		setContentPanel(tempPanel);
    }

  public void setProjectData()
  {
	TheContentPanelReference.setProjectData();
  }

  public void getDataUpdate()
  {
	try
	{
		TheContentPanelReference.getDataUpdate();		
		ProjectManager.saveTempNow();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
  }           
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private EAPropertiesPanel theEAProperties;
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JPanel BottomContentPanel;
    // End of variables declaration//GEN-END:variables
    
}
