/*
 * MessagingActionsPanel.java
 *
 * Created on December 30, 2003, 2:43 PM
 */

package com.trinity.ea.design.messaging.actions;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.common.panel.EAMasterControlPanel;
import com.trinity.ea.design.common.panel.EAPropertiesPanel;
import com.trinity.ea.design.common.panel.EAListItem;
import com.trinity.ea.design.common.panel.EAListItemContent;
import com.trinity.ea.design.common.panel.DataContentPanel;
import com.trinity.ea.design.common.panel.TextFieldPanel;
import com.trinity.ea.design.common.file.ProjectManager;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class MessagingActionsPanel extends EAMasterControlPanel {
    private Color backgroundColor = new java.awt.Color(140, 160, 210);
    private Color borderColor1 = new java.awt.Color(198, 226, 253);
    private Color borderColor2 = new java.awt.Color(96, 110, 145);
    private Color rowColor = new java.awt.Color(220, 225, 240);
    private Color rowBorderColor = new java.awt.Color(255, 255, 255);
    private Icon theActionRowIcon = new javax.swing.ImageIcon(getClass().getResource("/images/lgpl/action.png"));
    private int rowHeight = 25;

    /** Creates new form MessagingActionsPanel */
    public MessagingActionsPanel() {
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
		EAListItemContent msgDisplayMessageUIAction = new EAListItemContent(rowColor, defActionLabelWidth, defActionDataWidth);
		msgDisplayMessageUIAction.setLabelText("Display Message User Interface Action:");
		if(ProjectManager.get("msgDisplayMessageUIAction")!=null)
		{
			msgDisplayMessageUIAction.setInputText(ProjectManager.get("msgDisplayMessageUIAction"));
			strActionsArray[0] = "msgDisplayMessageUIAction";
		}
            eai.setRowDataPanel(msgDisplayMessageUIAction);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai.setListItemIsRemovable(false);
		eai.setValueBoxEnabled(false);
		eaItems[0] = eai;
//
            EAListItem eai2 = new EAListItem(theActionRowIcon,rowColor);
		EAListItemContent msgCustomMessageUIAction = new EAListItemContent(rowColor, defActionLabelWidth, defActionDataWidth);
		msgCustomMessageUIAction.setLabelText("Custom Message User Interface Action:");
		if(ProjectManager.get("msgCustomMessageUIAction")!=null)
		{
			msgCustomMessageUIAction.setInputText(ProjectManager.get("msgCustomMessageUIAction"));
			strActionsArray[1] = "msgCustomMessageUIAction";
		}
            eai2.setRowDataPanel(msgCustomMessageUIAction);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai2.setListItemIsRemovable(false);
		eai2.setValueBoxEnabled(false);
		eaItems[1] = eai2;
//
            EAListItem eai3 = new EAListItem(theActionRowIcon,rowColor);
		EAListItemContent msgFinishedUIAction = new EAListItemContent(rowColor, defActionLabelWidth, defActionDataWidth);
		msgFinishedUIAction.setLabelText("Message Finished User Interface Action:");
		if(ProjectManager.get("msgFinishedUIAction")!=null)
		{
			msgFinishedUIAction.setInputText(ProjectManager.get("msgFinishedUIAction"));
			strActionsArray[2] = "msgFinishedUIAction";
		}
            eai3.setRowDataPanel(msgFinishedUIAction);
		// Always call setListItemIsRemovable(false) after the ContentPanel is added, like in setRowDataPanel(...)
		eai3.setListItemIsRemovable(false);
		eai3.setValueBoxEnabled(false);
		eaItems[2] = eai3;

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
