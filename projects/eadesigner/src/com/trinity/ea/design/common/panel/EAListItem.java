/*
 * EAListItem.java
 *
 * Created on April 1, 2004, 3:34 PM
 */

package com.trinity.ea.design.common.panel;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.common.panel.EAListItemContent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Icon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class EAListItem extends EAPanel
{
	private int componentLocalizationID = 0;
      private int minHeight = 25;
      private int minWidth = 180;
	private boolean editModeEnabled = false;
	private Icon theTreeIcon = new javax.swing.ImageIcon(getClass().getResource("/images/tree/singleleftbranch.png"));
	private Icon theRowIcon = new javax.swing.ImageIcon(getClass().getResource("/images/tree/arrow.png"));
      private javax.swing.JPanel ContentPanelContainer;
      private javax.swing.JPanel RowIconPanel;
      private javax.swing.JPanel TreeIconPanel;
      private javax.swing.JLabel rowIconInPanel;
      private javax.swing.JLabel treeIconInPanel;
      private Color backgroundColor = new java.awt.Color(220, 225, 240);
      private EAListItemContent ContentPanel;

	public EAListItem(Color BGColor)
	{
		super();
		try
		{
			backgroundColor = BGColor;
			initBlank();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public EAListItem(Icon rowIcon, Color BGColor)
	{
		super();
		try
		{
			backgroundColor = BGColor;
			theRowIcon = rowIcon;
			initComponents();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/** return the control data */
	public String[] getDataArray()
	{
		return ContentPanel.getDataArray();
	}	

	public void getDataUpdate()
	{	
		try
		{
			ContentPanel.getDataUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void setLabelText(String labelText)
	{
		ContentPanel.setLabelText(labelText);
	}

	public void setDefaultInput()
	{
	  	ContentPanel.setDefaultInput(); 
	}

	public String getDefaultInput()
	{
		return ContentPanel.getDefaultInput(); 
	}

	public String getInputText()
	{
		return ContentPanel.getInputText();
	}

	
	public boolean getIsDefaultInputText()
	{
		return ContentPanel.getIsDefaultInputText();
	}

	public boolean getIsValidData()
	{
		return ContentPanel.getIsValidData();
	}
//
	public void setDefaultInputValue()
	{
	  	ContentPanel.setDefaultInputValue(); 
	}

	public String getDefaultInputValue()
	{
		return ContentPanel.getDefaultInputValue(); 
	}

	public String getInputValueText()
	{
		return ContentPanel.getInputValueText();
	}

	
	public boolean getIsDefaultInputValueText()
	{
		return ContentPanel.getIsDefaultInputValueText();
	}

	public boolean getIsValidInputValueData()
	{
		return ContentPanel.getIsValidInputValueData();
	}
//
	public void setListItemIsRemovable(boolean isRemovable)
	{
		ContentPanel.setListItemIsRemovable(isRemovable);
	}

	/** Used to Determine if current EAListItem can be removed from the EAPropertiesPanel */
	public boolean getListItemIsRemovable()
	{
		return ContentPanel.getListItemIsRemovable();
	}	
	  public void setValueBoxEnabled(boolean valEnabled)
	  {
		ContentPanel.setValueBoxEnabled(valEnabled);
	  }

	  public boolean getValueBoxEnabled()
	  {
		return  ContentPanel.getValueBoxEnabled();
	  }	
      /* The method to be extended by each EAListItem Panel */

	public void setEditMode()
	{
		editModeEnabled = true;
		ContentPanel.setEditMode();
	}

	public void setNormalMode()
	{
		editModeEnabled = false;
		ContentPanel.setNormalMode();
	} 

	public void setSelectedMode()
	{
		editModeEnabled = false;
		ContentPanel.setSelectedMode();
	} 

	public boolean getEditModeEnabled()
	{
		return editModeEnabled;
	}       

	public void setTreeBranchIcon(Icon treeIcon)
	{
		theTreeIcon = treeIcon;
        	treeIconInPanel.setIcon(treeIcon);		
	}

	public void setRowIcon(Icon rowIcon)
	{
		theRowIcon = rowIcon;
		rowIconInPanel.setIcon(rowIcon);
	}

	public Icon getRowIcon()
	{
		return theRowIcon;
	}
	
	private EAListItemContent theRowContentPanel = null;
	public void setRowDataPanel(EAListItemContent RowPanel)
	{
	    try
	    {
		 theRowContentPanel = RowPanel;
		 getDataUpdate();
 	       ContentPanel.setVisible(false);
 	       ContentPanelContainer.remove(ContentPanel);        
 	       ContentPanel = theRowContentPanel;
 	       ContentPanelContainer.add(ContentPanel);     
  	       ContentPanel.setVisible(true);
    	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	}
	
	public EAListItemContent getRowDataPanel()
	{
		return theRowContentPanel;
	}	

	public JCheckBox getJCheckBoxControl()
	{	try
		{
			return theRowContentPanel.cbInputLabel;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public JComboBox getJComboBoxControl()
	{	try
		{
			return theRowContentPanel.comboInputLabel;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

        public void setComponentLocalizationID(int componentID)
        {
            componentLocalizationID = componentID;
        }
        
        public int getComponentLocalizationID() 
        {
            return componentLocalizationID;
        }
        
        /* The usage methods for configuring parent GUI Layout. */
        public void setMinimumHeight(int theMinimumHeight)
        {
            minHeight = theMinimumHeight;
        }
        
        public void setMinimumWidth(int theMinimumWidth)
        {
            minWidth = theMinimumWidth;
        }
                
        public int getMinimumHeight()
        {
            return minHeight;
        }
        public int getMinimumWidth()
        {
            return minWidth;
        }
	
	  public void setBackgroundColor(Color BGColor)
	  {
		backgroundColor = BGColor;
		setBackground(backgroundColor);
      	ContentPanel.setBackground(backgroundColor);
      	ContentPanelContainer.setBackground(backgroundColor);
      	RowIconPanel.setBackground(backgroundColor);
      	TreeIconPanel.setBackground(backgroundColor);
      	rowIconInPanel.setBackground(backgroundColor);
      	treeIconInPanel.setBackground(backgroundColor);
	  }
	
    	  private void initComponents() 
	  {
        TreeIconPanel = new javax.swing.JPanel();
        treeIconInPanel = new javax.swing.JLabel();
        ContentPanelContainer = new javax.swing.JPanel();
        RowIconPanel = new javax.swing.JPanel();
        rowIconInPanel = new javax.swing.JLabel();
        ContentPanel = new EAListItemContent(backgroundColor);

        setLayout(new java.awt.BorderLayout());

        setMaximumSize(new java.awt.Dimension(2147483647, 25));
        setMinimumSize(new java.awt.Dimension(0, 25));
        setPreferredSize(new java.awt.Dimension(0, 25));
        TreeIconPanel.setLayout(new java.awt.BorderLayout());

        TreeIconPanel.setMaximumSize(new java.awt.Dimension(20, 25));
        TreeIconPanel.setMinimumSize(new java.awt.Dimension(20, 25));
        TreeIconPanel.setPreferredSize(new java.awt.Dimension(20, 25));
        treeIconInPanel.setIcon(theTreeIcon);
        treeIconInPanel.setMaximumSize(new java.awt.Dimension(20, 25));
        treeIconInPanel.setMinimumSize(new java.awt.Dimension(20, 25));
        treeIconInPanel.setPreferredSize(new java.awt.Dimension(20, 25));
        treeIconInPanel.setOpaque(true);
        TreeIconPanel.add(treeIconInPanel, java.awt.BorderLayout.CENTER);

        add(TreeIconPanel, java.awt.BorderLayout.WEST);

        ContentPanelContainer.setLayout(new java.awt.BorderLayout());

        RowIconPanel.setLayout(new java.awt.BorderLayout());

        RowIconPanel.setMaximumSize(new java.awt.Dimension(20, 25));
        RowIconPanel.setMinimumSize(new java.awt.Dimension(20, 25));
        RowIconPanel.setPreferredSize(new java.awt.Dimension(20, 25));
        rowIconInPanel.setIcon(theRowIcon);
        rowIconInPanel.setMaximumSize(new java.awt.Dimension(20, 25));
        rowIconInPanel.setMinimumSize(new java.awt.Dimension(20, 25));
        rowIconInPanel.setPreferredSize(new java.awt.Dimension(20, 25));
        rowIconInPanel.setOpaque(true);
        RowIconPanel.add(rowIconInPanel, java.awt.BorderLayout.CENTER);

        ContentPanelContainer.add(RowIconPanel, java.awt.BorderLayout.WEST);

        ContentPanel.setLayout(new java.awt.BorderLayout());

        ContentPanel.setMaximumSize(new java.awt.Dimension(32767, 25));
        ContentPanel.setMinimumSize(new java.awt.Dimension(10, 25));
        ContentPanel.setPreferredSize(new java.awt.Dimension(10, 25));
        ContentPanelContainer.add(ContentPanel, java.awt.BorderLayout.CENTER);

        add(ContentPanelContainer, java.awt.BorderLayout.CENTER);
	  setBackgroundColor(backgroundColor);  
    }

    private void initBlank() 
    {
        TreeIconPanel = new javax.swing.JPanel();
        treeIconInPanel = new javax.swing.JLabel();
        ContentPanelContainer = new javax.swing.JPanel();
        RowIconPanel = new javax.swing.JPanel();
        rowIconInPanel = new javax.swing.JLabel();
        ContentPanel = new EAListItemContent(backgroundColor);

        setLayout(new java.awt.BorderLayout());
	  setBackgroundColor(backgroundColor);  
    }

}
 
