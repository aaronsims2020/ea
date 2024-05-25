/*
 * EAMasterControlPanelPanel.java
 *
 * Created on April 1, 2004, 3:34 PM
 */

package com.trinity.ea.design.common.panel;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.common.panel.EAListItem;
import com.trinity.ea.design.common.panel.EAListItemContent;
import java.awt.Color;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class EAMasterControlPanel extends EAPanel {
	/* The method to be extended by each EADesigner Panel */
	public void setSelectedListItemEvent(int theSelectedIndex){}
      public void getFireConfigurationWizardAction(){}
	public void addListItem(EAListItem theNewEAListItem){}
	public EAListItemContent addEAListItem(){return new EAListItemContent(Color.white);}
	public void removeListItem(int theSelectedIndex){}
	public EAListItem[] getEAListItemURLArray(){return new EAListItem[0];}
}
