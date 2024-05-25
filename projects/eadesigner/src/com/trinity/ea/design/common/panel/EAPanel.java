/*
 * EAPanel.java
 *
 * Created on April 1, 2004, 3:34 PM
 */

package com.trinity.ea.design.common.panel;
import javax.swing.JPanel;
import com.trinity.ea.design.EADesigner;
import com.trinity.ea.design.common.panel.EAListItem;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class EAPanel extends javax.swing.JPanel {
	EADesigner theParentObj = null;
	Object theParentObj2 = null;
	/* The method to be extended by each EADesigner Panel */
	public void getDataUpdate(){}
	public void setProjectData(){}
	public EAListItem[] getEAListItemArray(int index){return null;}
	public String getAddButtonData(){return null;}
	public void setRemoveButtonData(int index){}
	public EAPanel setParentComp(EADesigner theParent)
	{
		theParentObj = theParent;
		return this;
	}
	public EADesigner getParentComp()
	{
		return theParentObj;
	}

	public void setParentComponent(Object theParent)
	{
		theParentObj2 = theParent;
	}

	public Object getParentComponent()
	{
		return theParentObj2;
	}
}
