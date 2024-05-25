/*
 * EAPropertiesPanel.java
 *
 * Created on April 4, 2004, 12:46 PM
 */

package com.trinity.ea.design.common.panel;

import com.trinity.ea.design.common.panel.EAListItem;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.common.panel.EAMasterControlPanel;
import com.trinity.ea.design.common.corners.upperleft.UpperLeftCorner;
import com.trinity.ea.design.common.corners.upperright.UpperRightCorner;
import com.trinity.ea.design.common.corners.lowerright.LowerRightCorner;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.border.MatteBorder;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2005 Trinity Software. All rights reserved.
 */
public class EAPropertiesPanel extends EAPanel 
{
    private EAListItem[] theJPanelListItemsArray = new EAListItem[0];
    private EAListItem[] theJPanelListDataItemsArray = new EAListItem[0];
    private Color backgroundColor =  new java.awt.Color(100, 120, 170);
    private Color theTabColor = new java.awt.Color(255, 255, 255);
    private Color theTabBorderColor = new java.awt.Color(0, 0, 0);
    private Color theRowBackgroundColor = new java.awt.Color(220, 225, 240);
    private Color theRowBorderColor = new java.awt.Color(255, 255, 255);
    private Color theDescriptorTextColor = new java.awt.Color(0, 0, 0);
    private Color theHeaderTextColor = new java.awt.Color(0, 0, 0);
    private int theRowHeight = 25;
    private int theSelectedListItem = -1;
    private String theDescriptorText = "";
    private String theColumnHeaderText = "";
    private UpperLeftCorner upperLeftCorner = new UpperLeftCorner(backgroundColor, theTabBorderColor, theTabBorderColor, theTabColor);
    private UpperLeftCorner upperLeftCorner2 = new UpperLeftCorner(backgroundColor, theTabBorderColor, theTabBorderColor, theTabColor);
    private UpperRightCorner upperRightCorner = new UpperRightCorner(theTabBorderColor, theTabColor, backgroundColor,theTabBorderColor);
    private LowerRightCorner lowerRightCorner = new LowerRightCorner(theTabBorderColor, theRowBorderColor);
    private Icon[] theTreeIcon = {new javax.swing.ImageIcon(getClass().getResource("/images/tree/topleftbranch.png")), new javax.swing.ImageIcon(getClass().getResource("/images/tree/leftcenterbranch.png")), new javax.swing.ImageIcon(getClass().getResource("/images/tree/bottomleftbranch.png")), new javax.swing.ImageIcon(getClass().getResource("/images/tree/singlerightbranch.png"))};
    private Icon theRowIcon = new javax.swing.ImageIcon(getClass().getResource("/images/tree/arrow.png"));
    private String defaultLabelText = "Input Name Attribute: ";
    private EAMasterControlPanel masterControlPanel;
    private boolean masterControlPanelIsEnabled = false;
    private JLabel secondHeaderLabel = new JLabel();
    private JLabel thirdHeaderLabel = new JLabel();

    public EAPropertiesPanel()
    {
        initComp();
        setListDefaults(new EAListItem[0]);        
    }

    /** Creates new form tempProperties */
    public EAPropertiesPanel(Color BGListColor, Color RowBorderColor, Color BGColor, int rowHeight) 
    {
        backgroundColor = BGColor;
        theRowBackgroundColor = BGListColor;
        theRowBorderColor = RowBorderColor;
        theRowHeight=rowHeight;
         initComp();       
        setListDefaults(new EAListItem[0]);
    }

    /** Creates new form tempProperties */
    public EAPropertiesPanel(EAListItem[] theEAListItemsArray, Color BGListColor, Color RowBorderColor, Color BGColor, int rowHeight) 
    {
        backgroundColor = BGColor;
        theRowBackgroundColor = BGListColor;
        theRowBorderColor = RowBorderColor;
        theRowHeight=rowHeight;
        initComp();       
        setListDefaults(theEAListItemsArray);
    }
	/** Used to retrieve data via the instanciating class */
	public EAListItem[] getEAListItems()
	{
		return theJPanelListDataItemsArray;
	}

	public int getEAListItemsArrayLength()
	{
		return theJPanelListDataItemsArray.length;
	}
	
 	/** Icon[0] = Top, Icon[1] = Center, Icon[2] = Bottom, Icon[3] = SingleListItem */
	public void setTreeBranchIcons(Icon[] treeIcons)
	{
		try
		{
			theTreeIcon = treeIcons;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void setDefaultRowIcon(Icon rowIcon)
	{
		try
		{
    			theRowIcon = rowIcon;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void setRowDataPanel(int index, EAPanel RowPanel)
	{
	    try
	    {

    	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	}
   
    private int getDataItemsQuantity()
    {
        return theJPanelListDataItemsArray.length;
    }
    
    private boolean getListIsEmpty()
    {
        if(theJPanelListDataItemsArray.length==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public int getSelectedIndex()
    { 
        return theSelectedListItem;
    }

    public EAListItem getIndex(int index)
    { 
	try
	{
        return theJPanelListDataItemsArray[index];
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return null;
	}
    }

    public EAListItem getSelectedEAListItem()
    {
	  return TheContentPanelReference;
    }
 
    private EAListItem TheContentPanelReference = new EAListItem(theRowIcon,theRowBackgroundColor);   
    public boolean setSelectedIndex(int index)
    {
	  int theTempListItem = theSelectedListItem;
        try
        {
            if(getListIsEmpty()== true || index == -1)
            {
                return false;
            }
            else
            {
                if(index <= getDataItemsQuantity() - 1)
                {
			  theSelectedListItem = index; 
			  if(getMasterControlPanelEnabled()==true)
			  {
				masterControlPanel.setSelectedListItemEvent(theTempListItem);
			  }

                    //setSelectedItem Properties
			  TheContentPanelReference.getInputText();
                    TheContentPanelReference.setNormalMode();
                    theJPanelListDataItemsArray[index].setSelectedMode();
                    TheContentPanelReference = theJPanelListDataItemsArray[index];
			  if(TheContentPanelReference.getListItemIsRemovable()==true)
		  	  {
                 		RemoveButton.setEnabled(true);
            	  }
             	  else
            	  {
                 		RemoveButton.setEnabled(false);
            	  }

		    }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
	return true;
    }
    
    /** Add a new EAListItem to the EAPropertiesPanel. Returns the int index of the new EAListItem. */
    public int addListItem(EAListItemContent theNewItem)
    {
        try
        {
            //Needed objects include the EAListItem Array, and the other array of EAList Items, all other methods should be implemented.
            EAListItem[] theTempJPanelListDataItemsArray = new EAListItem[theJPanelListDataItemsArray.length + 1];
		EAListItem theItem = new EAListItem(theRowIcon,theRowBackgroundColor);
		theItem.setRowDataPanel(theNewItem);
		int marker = theTempJPanelListDataItemsArray.length - 1;
            theTempJPanelListDataItemsArray[marker] = theItem;
            for(int i = 0;i<marker;i++)
            {
                theTempJPanelListDataItemsArray[i] = theJPanelListDataItemsArray[i];
            }
		if(UITextEnabled == true)
		{
			theTempJPanelListDataItemsArray = updateEAPropertiesPanelUI(theTempJPanelListDataItemsArray);
		}
            theJPanelListDataItemsArray=theTempJPanelListDataItemsArray;
            setListDefaults(theTempJPanelListDataItemsArray);
		return marker;
        }
        catch(Exception e)
        {
            e.printStackTrace();
		return -1;
        }        
    }

    public void editListItem(int index)
    {
        try
        {
            if(0<theJPanelListDataItemsArray.length)
            {
                for(int i = 0;i<theJPanelListDataItemsArray.length;i++)
                {
                    try
                    {
                        if(i == index)
                        {
					theJPanelListDataItemsArray[i].setEditMode();
					i = theJPanelListDataItemsArray.length;
				}
                    }
                    catch(ArrayIndexOutOfBoundsException e)
                    {
                        // Do nothing cause the selected index is not a Data Item.
                        return;
                    }
                }       
                setListDefaults(theJPanelListDataItemsArray);
            }
            else
            {
                //System.out.println("WARNING, FAILURE TO REMOVE...");
            }
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
	theSelectedListItem = index;
    }
    
    public void removeListItem(int index)
    {
        try
        {
		if(TheContentPanelReference.getListItemIsRemovable()==true)
		{
	            if(0<theJPanelListDataItemsArray.length)
      	      {		
				if(getMasterControlPanelEnabled()==true)
				{
		    			masterControlPanel.removeListItem(index);
				}
                		EAListItem[] theTempJPanelListDataItemsArray = new EAListItem[theJPanelListDataItemsArray.length];
                		int j = 0;
                		for(int i = 0;i<theTempJPanelListDataItemsArray.length;i++)
                		{
                    		try
                    		{
                        		if(i != index)
                        		{
                            			theTempJPanelListDataItemsArray[j] = theJPanelListDataItemsArray[i];
	                       			j++;
                        		}
                    		}
                    		catch(ArrayIndexOutOfBoundsException e)
                    		{
                        		// Do nothing cause the selected index is not a Data Item.
                        		return;
                    		}
                		}       
				if(UITextEnabled == true)
				{
					theTempJPanelListDataItemsArray = updateEAPropertiesPanelUI(theTempJPanelListDataItemsArray);
				}
                		theJPanelListDataItemsArray=theTempJPanelListDataItemsArray;  
     				setListDefaults(theJPanelListDataItemsArray);
            }
            else
            {
                //System.out.println("WARNING, FAILURE TO REMOVE...");
            }
		}

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }

    }
    
    private EAListItem[] validateEAListItemArrayData(EAListItem[] theDataArrayInfo)
    {
        try
        {
            ArrayList theArrayList = new ArrayList();
            for(int i = 0;i<theDataArrayInfo.length;i++) 
            {
                if(theDataArrayInfo[i]!=null)
                {
                    theArrayList.add(theDataArrayInfo[i]);
                }
                else
                {
                   // System.out.println("Found null: " + i);
                }
            }
            theArrayList.trimToSize();
            Object[] theNextAList = theArrayList.toArray();
            EAListItem[] theLArray = new EAListItem[theNextAList.length];
            for(int i = 0;i<theLArray.length;i++)
            {
                theLArray[i] = (EAListItem)theNextAList[i];
            }
            return theLArray;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return new EAListItem[0];
    }
    
    /* For use with extending or using this class as a template for customized Data. 
    public void replaceListItem(int index, EAListItem theNewItem)
    {
        
    }
    */
    
    public void clearList()
    {
        try
        {
            theJPanelListItemsArray = new EAListItem[0];
            theJPanelListDataItemsArray = new EAListItem[0];  
            PropertiesTree.removeAll();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void setListDefaults(EAListItem[] theEAListArray)
    {
        theSelectedListItem = -1;
        PropertiesTree.removeAll();  
        theEAListArray = validateEAListItemArrayData(theEAListArray);
        theJPanelListDataItemsArray = theEAListArray;
        theJPanelListItemsArray = theEAListArray;
        Dimension panelSize = PropertyListScrollPane.getSize();
        int panelHeight = panelSize.height;
        int panelWidth = panelSize.width;            
        if(panelHeight==0 && 0<theEAListArray.length)
        {
            panelHeight = 800; 
        }
        else if(panelHeight==0)
        {
            panelHeight = 100;
        }
        int rows = 0;
        try
        {
            rows = panelHeight / theRowHeight;
        }
        catch(ArithmeticException e)
        {
            rows = 0;
        }
        int visibleRows = rows;
/*
        int leftOver = panelHeight % theRowHeight;
        if(leftOver>=0)
        {
            //rows = rows + 1;
        }
*/
        if(panelHeight==0 && theJPanelListDataItemsArray.length == 0)
        {
            rows=20;
        }
        if(theJPanelListDataItemsArray.length<rows)
        {
            rows = rows - theJPanelListDataItemsArray.length;
            PropertyListScrollPane.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_NEVER); 
            PropertyListScrollPane.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);            
        }
        else
        {
            rows = 1;
            PropertyListScrollPane.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
            PropertyListScrollPane.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
        }
        // rows = displayed rows
        // visibleRows = rows before end of visible list, once actual data filled rows is greater than visible rows set scrollbars enabled.
        
        for(int i = 0;i<rows;i++)
        {
            EAListItem thePanel = new EAListItem(theRowBackgroundColor);
            thePanel.setComponentLocalizationID(-1);
            thePanel.setBackground(theRowBackgroundColor);
            thePanel.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 1, 0), theRowBorderColor));
            thePanel.setMaximumSize(new java.awt.Dimension(32767, theRowHeight));
            thePanel.setMinimumSize(new java.awt.Dimension(10, theRowHeight));
            thePanel.setPreferredSize(new java.awt.Dimension(10, theRowHeight));
            thePanel.setOpaque(true);
            thePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                thePanelMouseClicked(evt);
            }
        });
            PropertiesTree.add(thePanel);            
        }
        
        // Data Processing
	  if(theEAListArray.length==1)
	  {
		for(int i = 0;i<theEAListArray.length;i++)
        	{
            	EAListItem thePanel = theEAListArray[i];
			thePanel.setTreeBranchIcon(theTreeIcon[3]);
            	if(panelWidth<thePanel.getMinimumWidth())
            	{
                		PropertyListScrollPane.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);           
            	}
            	thePanel.setComponentLocalizationID(i);
            	thePanel.setBackground(theRowBackgroundColor);
            	thePanel.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 1, 0), theRowBorderColor));
            	thePanel.setMaximumSize(new java.awt.Dimension(32767, theRowHeight));
            	thePanel.setMinimumSize(new java.awt.Dimension(10, theRowHeight));
            	thePanel.setPreferredSize(new java.awt.Dimension(10, theRowHeight));
            	thePanel.setOpaque(true);
            	theJPanelListItemsArray[i] = thePanel;  
            	thePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            	public void mouseClicked(java.awt.event.MouseEvent evt) {
                		thePanelMouseClicked(evt);
            	}
        		});
            	PropertiesTree.add(thePanel,i);            
        	}       
	  }
	  else
	  {
		int firstVal = 0;
		int lastVal = theEAListArray.length - 1;
        	for(int i = 0;i<theEAListArray.length;i++)
        	{
            	EAListItem thePanel = theEAListArray[i];
			if(i==firstVal)
			{
				thePanel.setTreeBranchIcon(theTreeIcon[0]);
			}
			else if(i==lastVal)
			{
				thePanel.setTreeBranchIcon(theTreeIcon[2]);
			}
			else
			{
				thePanel.setTreeBranchIcon(theTreeIcon[1]);
			}

            	if(panelWidth<thePanel.getMinimumWidth())
            	{
                		PropertyListScrollPane.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);           
            	}
            	thePanel.setComponentLocalizationID(i);
            	thePanel.setBackgroundColor(theRowBackgroundColor);
            	thePanel.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 1, 0), theRowBorderColor));
            	thePanel.setMaximumSize(new java.awt.Dimension(32767, theRowHeight));
            	thePanel.setMinimumSize(new java.awt.Dimension(10, theRowHeight));
            	thePanel.setPreferredSize(new java.awt.Dimension(10, theRowHeight));
            	thePanel.setOpaque(true);
            	theJPanelListItemsArray[i] = thePanel;  
            	thePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            	public void mouseClicked(java.awt.event.MouseEvent evt) {
                		thePanelMouseClicked(evt);
            	}
        		});
            	PropertiesTree.add(thePanel,i);            
        	}       

        }
        int intStartArray = 0;
        if(theEAListArray.length<=0)
        {
            intStartArray = 0;
        }
        else
        {
             intStartArray = theEAListArray.length - 1;
        }

    PropertyListScrollPane.setViewportView(PropertiesTree);
  }
    
    
    public void initComp()
    {
        PropertyList = new javax.swing.JPanel();
        PropertyListScrollPane = new javax.swing.JScrollPane();
        PropertiesTree = new javax.swing.JPanel();
        ButtonControlPanel = new javax.swing.JPanel();
        AddButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        RemoveButton = new javax.swing.JButton();
        TitlePanel = new javax.swing.JPanel();
        WestHeaderPanel = new javax.swing.JPanel();
        WestHeaderTopPanel = new javax.swing.JPanel();
        WestHeaderMiddlePanel = new javax.swing.JPanel();
        WestHeaderMiddleTopPanel = new javax.swing.JPanel();
	  WestHeaderCenterFillerPanel = new javax.swing.JPanel();
	  WestHeaderCenterFillerPanelSpacer = new javax.swing.JPanel();
        UpperLeftHandCornerPanel = new javax.swing.JPanel();
        WestHeaderBottomPanel = new javax.swing.JPanel();
        CenterHeaderPanel = new javax.swing.JPanel();
        CenterHeaderTopPanel = new javax.swing.JPanel();
        CenterHeaderMiddleLeftPanel = new javax.swing.JPanel();
        CenterHeaderMiddleCenterPanel = new javax.swing.JPanel();
        CenterHeaderMiddleBottomLeftPanel1 = new javax.swing.JPanel();
        TheHeaderDescriptionAreaPanel = new javax.swing.JPanel();
        DescriptionPanel = new javax.swing.JLabel();
        CenterHeaderMiddleBottomCenterPanel3 = new javax.swing.JPanel();
        CenterHeaderMiddleBottomCenterPanel4 = new javax.swing.JPanel();
        LeftUpperCornerPanel2 = new javax.swing.JPanel();
        CenterHeaderMiddleBottomCenterPanel6 = new javax.swing.JPanel();
        CenterHeaderMiddleBottomCenterPanel1 = new javax.swing.JPanel();
        CenterHeaderMiddleRightPanel = new javax.swing.JPanel();
        CenterHeaderMiddleBottomPanel8 = new javax.swing.JPanel();
        CenterHeaderMiddleBottomPanel9 = new javax.swing.JPanel();
        CenterHeaderMiddleBottomPanel10 = new javax.swing.JPanel();
        CenterHeaderMiddlePanel = new javax.swing.JPanel();
        CenterHeaderMiddleTopPanel = new javax.swing.JPanel();
        CenterHeaderMiddleBottomLeftPanel2 = new javax.swing.JPanel();
        CenterHeaderMiddleBottomCenterPanel2 = new javax.swing.JPanel();
        CenterHeaderMiddleBottomPanel4 = new javax.swing.JPanel();
        LowerRightHandCornerPanel = new javax.swing.JPanel();
        CenterHeaderMiddleBottomPanel15 = new javax.swing.JPanel();
        CenterHeaderMiddleBottomRightPanel1 = new javax.swing.JPanel();
        CenterHeaderMiddleBottomPanel11 = new javax.swing.JPanel();
        CenterHeaderMiddleBottomPanel12 = new javax.swing.JPanel();
        CenterHeaderMiddleBottomPanel13 = new javax.swing.JPanel();
        CenterHeaderMiddleBottomPanel = new javax.swing.JPanel();
        CenterHeaderMiddleBottomLeftPanel = new javax.swing.JPanel();
        CenterHeaderMiddleBottomCenterPanel = new javax.swing.JPanel();
        CenterHeaderMiddleBottomPanel3 = new javax.swing.JPanel();
        CenterHeaderMiddleBottomRightPanel = new javax.swing.JPanel();
        CenterHeaderMiddleBottomPanel5 = new javax.swing.JPanel();
        CenterHeaderMiddleBottomPanel6 = new javax.swing.JPanel();
        CenterHeaderMiddleBottomPanel7 = new javax.swing.JPanel();
        CenterHeaderBottomPanel = new javax.swing.JPanel();
        LeftListHeaderPanel = new javax.swing.JPanel();
        lLeftListHeader = new javax.swing.JLabel();
        RightListHeaderPanel = new javax.swing.JPanel();
        lRightListHeader = new javax.swing.JLabel();
        EastHeaderPanel = new javax.swing.JPanel();
        EastHeaderTopPanel = new javax.swing.JPanel();
        EastHeaderTopNorth = new javax.swing.JPanel();
        EastHeaderTopWestLeft = new javax.swing.JPanel();
        UpperRightHandCornerPanel = new javax.swing.JPanel();
        EastHeaderTopSouth = new javax.swing.JPanel();
        EastHeaderTopPanel3 = new javax.swing.JPanel();
        EastHeaderMiddlePanel = new javax.swing.JPanel();
        EastHeaderBottomPanel = new javax.swing.JPanel();
	  DescriptionContentPanel = new javax.swing.JPanel();
        setLayout(new java.awt.BorderLayout());
    	  buttonPanelSpacer = new javax.swing.JPanel();
        buttonPanelTopSpacer = new javax.swing.JPanel();
	  buttonPanelContent = new javax.swing.JPanel();
    	  PreviewButton = new javax.swing.JButton();
    	  ConfigurationWizardButton = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                formComponentMoved(evt);
            }
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                formAncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                formAncestorResized(evt);
            }
        });

        PropertyList.setLayout(new java.awt.BorderLayout());

        PropertyListScrollPane.setBackground(backgroundColor);
        PropertyListScrollPane.setBorder(null);
        PropertyListScrollPane.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        PropertyListScrollPane.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        PropertiesTree.setLayout(new javax.swing.BoxLayout(PropertiesTree, javax.swing.BoxLayout.Y_AXIS));

        PropertiesTree.setBackground(theRowBackgroundColor);
        PropertyListScrollPane.setViewportView(PropertiesTree);

        PropertyList.add(PropertyListScrollPane, java.awt.BorderLayout.CENTER);

        add(PropertyList, java.awt.BorderLayout.CENTER);

        buttonPanelTopSpacer.setPreferredSize(new java.awt.Dimension(5, 10));
	  buttonPanelTopSpacer.setBackground(backgroundColor);
	  buttonPanelContent.setBackground(backgroundColor);
        buttonPanelContent.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));
ButtonControlPanel.setLayout(new javax.swing.BoxLayout(ButtonControlPanel, javax.swing.BoxLayout.Y_AXIS));
ButtonControlPanel.setBackground(backgroundColor);
ButtonControlPanel.add(buttonPanelTopSpacer);
ButtonControlPanel.add(buttonPanelContent);
/////////////////////////////
        AddButton.setFont(new java.awt.Font("Arial", 0, 12));
        AddButton.setText("Add");
        AddButton.setMnemonic('A');
	  AddButton.setOpaque(true);
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        buttonPanelContent.add(AddButton);

        EditButton.setFont(new java.awt.Font("Arial", 0, 12));
        EditButton.setText("Edit");
        EditButton.setMnemonic('d');
	  EditButton.setOpaque(true);
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        buttonPanelContent.add(EditButton);

        RemoveButton.setFont(new java.awt.Font("Arial", 0, 12));
        RemoveButton.setText("Remove");
        RemoveButton.setMnemonic('R');
	  RemoveButton.setOpaque(true);
        RemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveButtonActionPerformed(evt);
            }
        });

        buttonPanelContent.add(RemoveButton);


    	  buttonPanelSpacer.setPreferredSize(new java.awt.Dimension(50, 10));
	  buttonPanelSpacer.setBackground(backgroundColor);
        buttonPanelContent.add(buttonPanelSpacer);
///////////////////////////////////////

        PreviewButton.setFont(new java.awt.Font("Arial", 0, 12));
        PreviewButton.setText("Preview");
        PreviewButton.setMnemonic('P');
	  PreviewButton.setOpaque(true);
        PreviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviewButtonActionPerformed(evt);
            }
        });
	  buttonPanelContent.add(PreviewButton);

        ConfigurationWizardButton.setFont(new java.awt.Font("Arial", 0, 12));
        ConfigurationWizardButton.setText("Configuration Wizard");
        ConfigurationWizardButton.setMnemonic('C');
	  ConfigurationWizardButton.setOpaque(true);
        ConfigurationWizardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfigurationWizardButtonActionPerformed(evt);
            }
        });
	  buttonPanelContent.add(ConfigurationWizardButton);

        add(ButtonControlPanel, java.awt.BorderLayout.SOUTH);

        TitlePanel.setLayout(new java.awt.BorderLayout());

        TitlePanel.setBackground(backgroundColor);
        TitlePanel.setPreferredSize(new java.awt.Dimension(10, 57));
        WestHeaderPanel.setLayout(new java.awt.BorderLayout());

        WestHeaderPanel.setBackground(backgroundColor);
        WestHeaderPanel.setPreferredSize(new java.awt.Dimension(4, 57));
        WestHeaderTopPanel.setLayout(new java.awt.BorderLayout());

        WestHeaderTopPanel.setBackground(backgroundColor);
        WestHeaderTopPanel.setPreferredSize(new java.awt.Dimension(4, 20));
        WestHeaderPanel.add(WestHeaderTopPanel, java.awt.BorderLayout.NORTH);

        WestHeaderMiddlePanel.setLayout(new java.awt.BorderLayout());

        WestHeaderMiddlePanel.setBackground(backgroundColor);
        WestHeaderMiddlePanel.setPreferredSize(new java.awt.Dimension(4, 8));
        WestHeaderMiddleTopPanel.setLayout(new java.awt.BorderLayout());

        WestHeaderMiddleTopPanel.setBackground(backgroundColor);
        WestHeaderMiddleTopPanel.setPreferredSize(new java.awt.Dimension(4, 4));

        UpperLeftHandCornerPanel.setLayout(new java.awt.BorderLayout());

        UpperLeftHandCornerPanel.setBackground(theTabColor);
        UpperLeftHandCornerPanel.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 2, 0, 0), theTabBorderColor));
        UpperLeftHandCornerPanel.setPreferredSize(new java.awt.Dimension(4, 4));


	  WestHeaderCenterFillerPanel.setLayout(new java.awt.BorderLayout());
 	  WestHeaderCenterFillerPanel.setBackground(backgroundColor);
	  WestHeaderCenterFillerPanel.setPreferredSize(new java.awt.Dimension(4, 6));
	  WestHeaderCenterFillerPanelSpacer.setLayout(new java.awt.BorderLayout());
	  WestHeaderCenterFillerPanelSpacer.setBackground(theTabColor);
	  WestHeaderCenterFillerPanelSpacer.setPreferredSize(new java.awt.Dimension(4, 2));
 	  WestHeaderCenterFillerPanelSpacer.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 2, 0, 0), theTabBorderColor));

	  WestHeaderCenterFillerPanel.add(WestHeaderCenterFillerPanelSpacer, java.awt.BorderLayout.SOUTH);
	  WestHeaderCenterFillerPanel.add(upperLeftCorner2, java.awt.BorderLayout.CENTER);
	  WestHeaderMiddlePanel.add(WestHeaderCenterFillerPanel, java.awt.BorderLayout.SOUTH);

        WestHeaderPanel.add(WestHeaderMiddlePanel, java.awt.BorderLayout.CENTER);

        WestHeaderBottomPanel.setLayout(new java.awt.BorderLayout());

        WestHeaderBottomPanel.setBackground(theTabColor);
        WestHeaderBottomPanel.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 2, 1, 0), theTabBorderColor));
        WestHeaderBottomPanel.setPreferredSize(new java.awt.Dimension(4, 30));
        WestHeaderPanel.add(WestHeaderBottomPanel, java.awt.BorderLayout.SOUTH);

        TitlePanel.add(WestHeaderPanel, java.awt.BorderLayout.WEST);

        CenterHeaderPanel.setLayout(new java.awt.BorderLayout());

        CenterHeaderPanel.setBackground(backgroundColor);
        CenterHeaderTopPanel.setLayout(new java.awt.BorderLayout());

        CenterHeaderTopPanel.setBackground(backgroundColor);
        CenterHeaderTopPanel.setPreferredSize(new java.awt.Dimension(10, 20));
        CenterHeaderMiddleLeftPanel.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddleLeftPanel.setBackground(backgroundColor);
        CenterHeaderMiddleLeftPanel.setPreferredSize(new java.awt.Dimension(4, 20));
        CenterHeaderTopPanel.add(CenterHeaderMiddleLeftPanel, java.awt.BorderLayout.WEST);

        CenterHeaderMiddleCenterPanel.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddleCenterPanel.setBackground(backgroundColor);
        CenterHeaderMiddleBottomLeftPanel1.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddleBottomLeftPanel1.setBackground(backgroundColor);
        CenterHeaderMiddleBottomLeftPanel1.setPreferredSize(new java.awt.Dimension(200, 20));
        TheHeaderDescriptionAreaPanel.setLayout(new java.awt.BorderLayout());

        TheHeaderDescriptionAreaPanel.setBackground(backgroundColor);
        DescriptionPanel.setBackground(backgroundColor);
        DescriptionPanel.setFont(new java.awt.Font("Arial", 1, 12));
        DescriptionPanel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DescriptionPanel.setText("The Header Description Area...");
        DescriptionPanel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        DescriptionPanel.setMaximumSize(new java.awt.Dimension(20000, 20));
        DescriptionPanel.setMinimumSize(new java.awt.Dimension(168, 20));
        DescriptionPanel.setPreferredSize(new java.awt.Dimension(196, 20));
        DescriptionPanel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        DescriptionPanel.setOpaque(true);
        DescriptionPanel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        DescriptionContentPanel.setMaximumSize(new java.awt.Dimension(20000, 20));
        DescriptionContentPanel.setMinimumSize(new java.awt.Dimension(168, 20));
        DescriptionContentPanel.setPreferredSize(new java.awt.Dimension(196, 20));
	  DescriptionContentPanel.setLayout(new java.awt.BorderLayout());
	  DescriptionContentPanel.add(DescriptionPanel, java.awt.BorderLayout.CENTER);

        TheHeaderDescriptionAreaPanel.add(DescriptionContentPanel, java.awt.BorderLayout.WEST);

        CenterHeaderMiddleBottomLeftPanel1.add(TheHeaderDescriptionAreaPanel, java.awt.BorderLayout.WEST);

        CenterHeaderMiddleBottomCenterPanel3.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddleBottomCenterPanel3.setBackground(backgroundColor);
        CenterHeaderMiddleBottomCenterPanel3.setMinimumSize(new java.awt.Dimension(4, 20));
        CenterHeaderMiddleBottomCenterPanel3.setPreferredSize(new java.awt.Dimension(4, 20));
        CenterHeaderMiddleBottomCenterPanel4.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddleBottomCenterPanel4.setBackground(theTabColor);
        CenterHeaderMiddleBottomCenterPanel4.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 2, 0, 0), theTabBorderColor));
        CenterHeaderMiddleBottomCenterPanel4.setMinimumSize(new java.awt.Dimension(4, 16));
        CenterHeaderMiddleBottomCenterPanel4.setPreferredSize(new java.awt.Dimension(4, 16));
        CenterHeaderMiddleBottomCenterPanel3.add(CenterHeaderMiddleBottomCenterPanel4, java.awt.BorderLayout.SOUTH);

        LeftUpperCornerPanel2.setLayout(new java.awt.BorderLayout());

        LeftUpperCornerPanel2.setBackground(backgroundColor);
        LeftUpperCornerPanel2.setMinimumSize(new java.awt.Dimension(4, 4));
        LeftUpperCornerPanel2.setPreferredSize(new java.awt.Dimension(4, 4));

	  LeftUpperCornerPanel2.add(upperLeftCorner, java.awt.BorderLayout.WEST);

        CenterHeaderMiddleBottomCenterPanel6.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddleBottomCenterPanel6.setBackground(backgroundColor);
        CenterHeaderMiddleBottomCenterPanel6.setMinimumSize(new java.awt.Dimension(4, 20));
        CenterHeaderMiddleBottomCenterPanel6.setPreferredSize(new java.awt.Dimension(4, 20));

        CenterHeaderMiddleBottomCenterPanel3.add(LeftUpperCornerPanel2, java.awt.BorderLayout.NORTH);

        CenterHeaderMiddleBottomLeftPanel1.add(CenterHeaderMiddleBottomCenterPanel3, java.awt.BorderLayout.EAST);


        CenterHeaderMiddleCenterPanel.add(CenterHeaderMiddleBottomLeftPanel1, java.awt.BorderLayout.WEST);

        CenterHeaderMiddleBottomCenterPanel1.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddleBottomCenterPanel1.setBackground(theTabColor);
        CenterHeaderMiddleBottomCenterPanel1.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(2, 0, 0, 0), theTabBorderColor));
        CenterHeaderMiddleCenterPanel.add(CenterHeaderMiddleBottomCenterPanel1, java.awt.BorderLayout.CENTER);

        CenterHeaderTopPanel.add(CenterHeaderMiddleCenterPanel, java.awt.BorderLayout.CENTER);

        CenterHeaderMiddleRightPanel.setLayout(new java.awt.BorderLayout());
        CenterHeaderMiddleRightPanel.setBackground(theTabColor);
        CenterHeaderMiddleRightPanel.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(2, 0, 0, 0), theTabBorderColor));
        CenterHeaderMiddleRightPanel.setPreferredSize(new java.awt.Dimension(4, 20));
        CenterHeaderMiddleBottomPanel8.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddleBottomPanel8.setBackground(backgroundColor);
        CenterHeaderMiddleBottomPanel8.setPreferredSize(new java.awt.Dimension(4, 4));
        CenterHeaderMiddleRightPanel.add(CenterHeaderMiddleBottomPanel8, java.awt.BorderLayout.SOUTH);

        CenterHeaderMiddleBottomPanel9.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddleBottomPanel9.setBackground(theTabColor);
        CenterHeaderMiddleBottomPanel10.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddleBottomPanel10.setBackground(theTabColor);
        CenterHeaderMiddleBottomPanel10.setPreferredSize(new java.awt.Dimension(4, 4));
        CenterHeaderMiddleBottomPanel9.add(CenterHeaderMiddleBottomPanel10, java.awt.BorderLayout.SOUTH);

        CenterHeaderMiddleRightPanel.add(CenterHeaderMiddleBottomPanel9, java.awt.BorderLayout.SOUTH);

        CenterHeaderTopPanel.add(CenterHeaderMiddleRightPanel, java.awt.BorderLayout.EAST);

        CenterHeaderPanel.add(CenterHeaderTopPanel, java.awt.BorderLayout.NORTH);

        CenterHeaderMiddlePanel.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddlePanel.setBackground(backgroundColor);
        CenterHeaderMiddlePanel.setPreferredSize(new java.awt.Dimension(10, 8));
        CenterHeaderMiddleTopPanel.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddleTopPanel.setBackground(backgroundColor);
        CenterHeaderMiddleTopPanel.setPreferredSize(new java.awt.Dimension(3, 3));
        CenterHeaderMiddleBottomLeftPanel2.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddleBottomLeftPanel2.setBackground(backgroundColor);
        CenterHeaderMiddleBottomLeftPanel2.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 2, 0), theTabBorderColor));
        CenterHeaderMiddleBottomLeftPanel2.setPreferredSize(new java.awt.Dimension(199, 3));
        CenterHeaderMiddleTopPanel.add(CenterHeaderMiddleBottomLeftPanel2, java.awt.BorderLayout.WEST);

        CenterHeaderMiddleBottomCenterPanel2.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddleBottomCenterPanel2.setBackground(backgroundColor);
        CenterHeaderMiddleBottomPanel4.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddleBottomPanel4.setBackground(theTabColor);
        CenterHeaderMiddleBottomPanel4.setPreferredSize(new java.awt.Dimension(4, 4));
        LowerRightHandCornerPanel.setLayout(new java.awt.BorderLayout());

        LowerRightHandCornerPanel.setBackground(theTabColor);
        LowerRightHandCornerPanel.setPreferredSize(new java.awt.Dimension(3, 3));
//
LowerRightHandCornerPanel.add(lowerRightCorner, java.awt.BorderLayout.CENTER);
//
        CenterHeaderMiddleBottomPanel4.add(LowerRightHandCornerPanel, java.awt.BorderLayout.WEST);

        CenterHeaderMiddleBottomPanel15.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddleBottomPanel15.setBackground(theTabColor);
        CenterHeaderMiddleBottomPanel4.add(CenterHeaderMiddleBottomPanel15, java.awt.BorderLayout.CENTER);

        CenterHeaderMiddleBottomCenterPanel2.add(CenterHeaderMiddleBottomPanel4, java.awt.BorderLayout.SOUTH);

        CenterHeaderMiddleTopPanel.add(CenterHeaderMiddleBottomCenterPanel2, java.awt.BorderLayout.CENTER);

        CenterHeaderMiddleBottomRightPanel1.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddleBottomRightPanel1.setBackground(backgroundColor);
        CenterHeaderMiddleBottomPanel11.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddleBottomPanel11.setBackground(backgroundColor);
        CenterHeaderMiddleBottomPanel11.setPreferredSize(new java.awt.Dimension(3, 3));
        CenterHeaderMiddleBottomRightPanel1.add(CenterHeaderMiddleBottomPanel11, java.awt.BorderLayout.SOUTH);

        CenterHeaderMiddleBottomPanel12.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddleBottomPanel12.setBackground(backgroundColor);
        CenterHeaderMiddleBottomPanel13.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddleBottomPanel13.setBackground(theTabColor);
        CenterHeaderMiddleBottomPanel13.setPreferredSize(new java.awt.Dimension(3, 3));
        CenterHeaderMiddleBottomPanel12.add(CenterHeaderMiddleBottomPanel13, java.awt.BorderLayout.SOUTH);

        CenterHeaderMiddleBottomRightPanel1.add(CenterHeaderMiddleBottomPanel12, java.awt.BorderLayout.SOUTH);

        CenterHeaderMiddleTopPanel.add(CenterHeaderMiddleBottomRightPanel1, java.awt.BorderLayout.EAST);

        CenterHeaderMiddlePanel.add(CenterHeaderMiddleTopPanel, java.awt.BorderLayout.NORTH);

        CenterHeaderMiddleBottomPanel.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddleBottomPanel.setBackground(backgroundColor);
        CenterHeaderMiddleBottomPanel.setPreferredSize(new java.awt.Dimension(4, 4));
        CenterHeaderMiddleBottomLeftPanel.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddleBottomLeftPanel.setBackground(theTabColor);
        CenterHeaderMiddleBottomLeftPanel.setPreferredSize(new java.awt.Dimension(200, 4));
        CenterHeaderMiddleBottomPanel.add(CenterHeaderMiddleBottomLeftPanel, java.awt.BorderLayout.WEST);

        CenterHeaderMiddleBottomCenterPanel.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddleBottomCenterPanel.setBackground(backgroundColor);
        CenterHeaderMiddleBottomPanel3.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddleBottomPanel3.setBackground(theTabColor);
        CenterHeaderMiddleBottomPanel3.setPreferredSize(new java.awt.Dimension(4, 4));
        CenterHeaderMiddleBottomCenterPanel.add(CenterHeaderMiddleBottomPanel3, java.awt.BorderLayout.SOUTH);

        CenterHeaderMiddleBottomPanel.add(CenterHeaderMiddleBottomCenterPanel, java.awt.BorderLayout.CENTER);

        CenterHeaderMiddleBottomRightPanel.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddleBottomRightPanel.setBackground(backgroundColor);
        CenterHeaderMiddleBottomPanel5.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddleBottomPanel5.setBackground(backgroundColor);
        CenterHeaderMiddleBottomPanel5.setPreferredSize(new java.awt.Dimension(4, 4));
        CenterHeaderMiddleBottomRightPanel.add(CenterHeaderMiddleBottomPanel5, java.awt.BorderLayout.SOUTH);

        CenterHeaderMiddleBottomPanel6.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddleBottomPanel6.setBackground(backgroundColor);
        CenterHeaderMiddleBottomPanel7.setLayout(new java.awt.BorderLayout());

        CenterHeaderMiddleBottomPanel7.setBackground(theTabColor);
        CenterHeaderMiddleBottomPanel7.setPreferredSize(new java.awt.Dimension(4, 4));
        CenterHeaderMiddleBottomPanel6.add(CenterHeaderMiddleBottomPanel7, java.awt.BorderLayout.SOUTH);

        CenterHeaderMiddleBottomRightPanel.add(CenterHeaderMiddleBottomPanel6, java.awt.BorderLayout.SOUTH);

        CenterHeaderMiddleBottomPanel.add(CenterHeaderMiddleBottomRightPanel, java.awt.BorderLayout.EAST);

        CenterHeaderMiddlePanel.add(CenterHeaderMiddleBottomPanel, java.awt.BorderLayout.SOUTH);

        CenterHeaderPanel.add(CenterHeaderMiddlePanel, java.awt.BorderLayout.CENTER);

        CenterHeaderBottomPanel.setLayout(new javax.swing.BoxLayout(CenterHeaderBottomPanel, javax.swing.BoxLayout.X_AXIS));

        CenterHeaderBottomPanel.setBackground(theTabColor);
        CenterHeaderBottomPanel.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 1, 0), theTabBorderColor));
        CenterHeaderBottomPanel.setPreferredSize(new java.awt.Dimension(10, 30));
        LeftListHeaderPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 10));

        LeftListHeaderPanel.setBackground(theTabColor);
        LeftListHeaderPanel.setMinimumSize(new java.awt.Dimension(105, 15));
        LeftListHeaderPanel.setPreferredSize(new java.awt.Dimension(600, 20));
        lLeftListHeader.setBackground(theTabColor);
        lLeftListHeader.setFont(new java.awt.Font("Arial", 1, 12));
        lLeftListHeader.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lLeftListHeader.setText("List Header Here");
        lLeftListHeader.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lLeftListHeader.setMaximumSize(new java.awt.Dimension(200, 15));
        lLeftListHeader.setPreferredSize(new java.awt.Dimension(200, 15));
        LeftListHeaderPanel.add(lLeftListHeader);
	  
        secondHeaderLabel.setBackground(theTabColor);
        secondHeaderLabel.setFont(new java.awt.Font("Arial", 1, 12));
        secondHeaderLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        secondHeaderLabel.setText("");
        secondHeaderLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        secondHeaderLabel.setMaximumSize(new java.awt.Dimension(200, 15));
        secondHeaderLabel.setPreferredSize(new java.awt.Dimension(200, 15));
        LeftListHeaderPanel.add(secondHeaderLabel);
	  
        thirdHeaderLabel.setBackground(theTabColor);
        thirdHeaderLabel.setFont(new java.awt.Font("Arial", 1, 12));
        thirdHeaderLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        thirdHeaderLabel.setText("");
        thirdHeaderLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        thirdHeaderLabel.setMaximumSize(new java.awt.Dimension(200, 15));
        thirdHeaderLabel.setPreferredSize(new java.awt.Dimension(200, 15));
        LeftListHeaderPanel.add(thirdHeaderLabel);

        CenterHeaderBottomPanel.add(LeftListHeaderPanel);

        RightListHeaderPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 10));

        RightListHeaderPanel.setBackground(theTabColor);
        RightListHeaderPanel.setPreferredSize(new java.awt.Dimension(10, 30));

        lRightListHeader.setBackground(theTabColor);
        lRightListHeader.setFont(new java.awt.Font("Arial", 1, 12));
        lRightListHeader.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lRightListHeader.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lRightListHeader.setMaximumSize(new java.awt.Dimension(10, 15));
        lRightListHeader.setPreferredSize(new java.awt.Dimension(10, 15));

        RightListHeaderPanel.add(lRightListHeader);

        CenterHeaderBottomPanel.add(RightListHeaderPanel);

        CenterHeaderPanel.add(CenterHeaderBottomPanel, java.awt.BorderLayout.SOUTH);

        TitlePanel.add(CenterHeaderPanel, java.awt.BorderLayout.CENTER);

        EastHeaderPanel.setLayout(new java.awt.BorderLayout());

        EastHeaderPanel.setBackground(backgroundColor);
        EastHeaderPanel.setPreferredSize(new java.awt.Dimension(10, 57));
        EastHeaderTopPanel.setLayout(new java.awt.BorderLayout());

        EastHeaderTopPanel.setBackground(backgroundColor);
        EastHeaderTopPanel.setPreferredSize(new java.awt.Dimension(10, 20));
        EastHeaderTopNorth.setLayout(new java.awt.BorderLayout());

        EastHeaderTopNorth.setBackground(backgroundColor);
        EastHeaderTopNorth.setMaximumSize(new java.awt.Dimension(2147483647, 4));
        EastHeaderTopNorth.setMinimumSize(new java.awt.Dimension(0, 4));
        EastHeaderTopNorth.setPreferredSize(new java.awt.Dimension(10, 4));
        EastHeaderTopWestLeft.setLayout(new java.awt.BorderLayout());

        EastHeaderTopWestLeft.setBackground(theTabColor);
        EastHeaderTopWestLeft.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(2, 0, 0, 0), theTabBorderColor));
        EastHeaderTopWestLeft.setMaximumSize(new java.awt.Dimension(2147483647, 4));
        EastHeaderTopWestLeft.setMinimumSize(new java.awt.Dimension(6, 4));
        EastHeaderTopWestLeft.setPreferredSize(new java.awt.Dimension(6, 4));
        EastHeaderTopNorth.add(EastHeaderTopWestLeft, java.awt.BorderLayout.WEST);

        UpperRightHandCornerPanel.setLayout(new java.awt.BorderLayout());

        UpperRightHandCornerPanel.setBackground(backgroundColor);
        UpperRightHandCornerPanel.setMaximumSize(new java.awt.Dimension(2147483647, 4));
//
UpperRightHandCornerPanel.add(upperRightCorner, java.awt.BorderLayout.CENTER);
//
        EastHeaderTopNorth.add(UpperRightHandCornerPanel, java.awt.BorderLayout.EAST);

        EastHeaderTopPanel.add(EastHeaderTopNorth, java.awt.BorderLayout.NORTH);

        EastHeaderTopSouth.setLayout(new java.awt.BorderLayout());

        EastHeaderTopSouth.setBackground(backgroundColor);
        EastHeaderTopSouth.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 0, 2), theTabBorderColor));
        EastHeaderTopSouth.setMinimumSize(new java.awt.Dimension(0, 16));
        EastHeaderTopSouth.setPreferredSize(new java.awt.Dimension(10, 16));
        EastHeaderTopPanel3.setLayout(new java.awt.BorderLayout());

        EastHeaderTopPanel3.setBackground(theTabColor);
        EastHeaderTopPanel3.setPreferredSize(new java.awt.Dimension(10, 20));
        EastHeaderTopSouth.add(EastHeaderTopPanel3, java.awt.BorderLayout.NORTH);

        EastHeaderTopPanel.add(EastHeaderTopSouth, java.awt.BorderLayout.SOUTH);

        EastHeaderPanel.add(EastHeaderTopPanel, java.awt.BorderLayout.NORTH);

        EastHeaderMiddlePanel.setLayout(new java.awt.BorderLayout());

        EastHeaderMiddlePanel.setBackground(theTabColor);

        EastHeaderMiddlePanel.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 0, 2), theTabBorderColor));
        EastHeaderMiddlePanel.setPreferredSize(new java.awt.Dimension(10, 8));
        EastHeaderPanel.add(EastHeaderMiddlePanel, java.awt.BorderLayout.CENTER);

        EastHeaderBottomPanel.setLayout(new java.awt.BorderLayout());
        EastHeaderBottomPanel.setBackground(theTabColor);
        EastHeaderBottomPanel.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 1, 2), theTabBorderColor));
        EastHeaderBottomPanel.setPreferredSize(new java.awt.Dimension(10, 30));
        EastHeaderPanel.add(EastHeaderBottomPanel, java.awt.BorderLayout.SOUTH);

        TitlePanel.add(EastHeaderPanel, java.awt.BorderLayout.EAST);

        add(TitlePanel, java.awt.BorderLayout.NORTH);
    }
    
    private void thePanelMouseClicked(java.awt.event.MouseEvent evt) 
    {
        try
        {
            setSelectedIndex(((EAListItem)evt.getComponent()).getComponentLocalizationID());
            //System.out.println("Selected Index: " + ((EAListItem)evt.getComponent()).getComponentLocalizationID());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }   
 
    public void setDefaultLabelText(String defText)
    {
	defaultLabelText = defText;
    }

    private String getDefaultLabelText()
    {
	return defaultLabelText;
    }    

    public void setAddButtonText(String btnText)
    {
	  try
	  {
        	AddButton.setText(btnText);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void setEditButtonText(String btnText)
    {
	  try
	  {
        	EditButton.setText(btnText);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void setRemoveButtonText(String btnText)
    {
	  try
	  {
        	RemoveButton.setText(btnText);   
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }    

    public void setPreviewButtonText(String btnText)
    {
	  try
	  {
        	PreviewButton.setText(btnText);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void setConfigurationWizardButtonText(String btnText)
    {
	  try
	  {
        	ConfigurationWizardButton.setText(btnText);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

     public void setRowHeight(int rowHeight)
    {
	theRowHeight = rowHeight;
    }

    public int getRowHeight()
    {
	return theRowHeight;
    }

    public void setBackgroundColor(Color bgColor)
    {
	  try
	  {
	  backgroundColor = bgColor;
    	  upperLeftCorner = new UpperLeftCorner(backgroundColor, theTabBorderColor, theTabBorderColor, theTabColor);
    	  upperLeftCorner2 = new UpperLeftCorner(backgroundColor, theTabBorderColor, theTabBorderColor, theTabColor);
    	  upperRightCorner = new UpperRightCorner(theTabBorderColor, theTabColor, backgroundColor,theTabBorderColor);
	  PropertyListScrollPane.setBackground(backgroundColor);
	  ButtonControlPanel.setBackground(backgroundColor);
        TitlePanel.setBackground(backgroundColor);
        WestHeaderPanel.setBackground(backgroundColor);
        WestHeaderTopPanel.setBackground(backgroundColor);
        WestHeaderMiddlePanel.setBackground(backgroundColor);
        WestHeaderMiddleTopPanel.setBackground(backgroundColor);
	  WestHeaderCenterFillerPanel.setBackground(backgroundColor);
	  CenterHeaderPanel.setBackground(backgroundColor);
        CenterHeaderMiddleCenterPanel.setBackground(backgroundColor);
        CenterHeaderTopPanel.setBackground(backgroundColor);
        CenterHeaderMiddleLeftPanel.setBackground(backgroundColor);
        CenterHeaderMiddleBottomLeftPanel1.setBackground(backgroundColor);
        TheHeaderDescriptionAreaPanel.setBackground(backgroundColor);
        DescriptionPanel.setBackground(backgroundColor);
        CenterHeaderMiddleBottomCenterPanel3.setBackground(backgroundColor);
        LeftUpperCornerPanel2.setBackground(backgroundColor);
        CenterHeaderMiddleBottomCenterPanel6.setBackground(backgroundColor);
        CenterHeaderMiddleBottomPanel8.setBackground(backgroundColor);
        CenterHeaderMiddlePanel.setBackground(backgroundColor);
	  CenterHeaderMiddleTopPanel.setBackground(backgroundColor);
        CenterHeaderMiddleBottomLeftPanel2.setBackground(backgroundColor);
	  CenterHeaderMiddleBottomCenterPanel2.setBackground(backgroundColor);
        CenterHeaderMiddleBottomRightPanel1.setBackground(backgroundColor);
        CenterHeaderMiddleBottomPanel11.setBackground(backgroundColor);
        CenterHeaderMiddleBottomPanel12.setBackground(backgroundColor);
        CenterHeaderMiddleBottomPanel.setBackground(backgroundColor);
        CenterHeaderMiddleBottomCenterPanel.setBackground(backgroundColor);
        CenterHeaderMiddleBottomRightPanel.setBackground(backgroundColor);
        CenterHeaderMiddleBottomPanel5.setBackground(backgroundColor);
        CenterHeaderMiddleBottomPanel6.setBackground(backgroundColor);
        EastHeaderPanel.setBackground(backgroundColor);
	  EastHeaderTopPanel.setBackground(backgroundColor);
        EastHeaderTopNorth.setBackground(backgroundColor);
        UpperRightHandCornerPanel.setBackground(backgroundColor);
        EastHeaderTopSouth.setBackground(backgroundColor);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public Color getBackgroundColor()
    {
	return backgroundColor;
    }

    public void setTabColor(Color tabColor)
    {
	  try
	  {
	  theTabColor = tabColor;
	  UpperLeftHandCornerPanel.setBackground(theTabColor);
	  WestHeaderCenterFillerPanelSpacer.setBackground(theTabColor);
        WestHeaderBottomPanel.setBackground(theTabColor);
        CenterHeaderMiddleBottomCenterPanel4.setBackground(theTabColor);
        CenterHeaderMiddleBottomCenterPanel1.setBackground(theTabColor);
        CenterHeaderMiddleRightPanel.setBackground(theTabColor);
        CenterHeaderMiddleBottomPanel9.setBackground(theTabColor);
        CenterHeaderMiddleBottomPanel10.setBackground(theTabColor);
        CenterHeaderMiddleBottomPanel4.setBackground(theTabColor);
        LowerRightHandCornerPanel.setBackground(theTabColor);
        CenterHeaderMiddleBottomPanel15.setBackground(theTabColor);
        CenterHeaderMiddleBottomPanel13.setBackground(theTabColor);
        CenterHeaderMiddleBottomLeftPanel.setBackground(theTabColor);
        CenterHeaderMiddleBottomPanel3.setBackground(theTabColor);
        CenterHeaderMiddleBottomPanel7.setBackground(theTabColor);
        CenterHeaderBottomPanel.setBackground(theTabColor);
        LeftListHeaderPanel.setBackground(theTabColor);
        lLeftListHeader.setBackground(theTabColor);
        RightListHeaderPanel.setBackground(theTabColor);
        lRightListHeader.setBackground(theTabColor);
        EastHeaderTopWestLeft.setBackground(theTabColor);
        EastHeaderTopPanel3.setBackground(theTabColor);
        EastHeaderMiddlePanel.setBackground(theTabColor);
        EastHeaderBottomPanel.setBackground(theTabColor);
	  upperLeftCorner = new UpperLeftCorner(backgroundColor, theTabBorderColor, theTabBorderColor, theTabColor);
 	  upperLeftCorner2 = new UpperLeftCorner(backgroundColor, theTabBorderColor, theTabBorderColor, theTabColor);
	  upperRightCorner = new UpperRightCorner(theTabBorderColor, theTabColor, backgroundColor,theTabBorderColor);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public Color getTabColor()
    {
	return theTabColor;
    }

    public void setTabBorderColor(Color tabBorderColor)
    {
	  try
	  {
	  theTabBorderColor = tabBorderColor;
	  LeftUpperCornerPanel2.remove(upperLeftCorner);
	  theTabBorderColor = tabBorderColor;
	  upperLeftCorner = new UpperLeftCorner(backgroundColor, theTabBorderColor, theTabBorderColor, theTabColor);
	  LeftUpperCornerPanel2.add(upperLeftCorner, java.awt.BorderLayout.WEST);
	  WestHeaderCenterFillerPanel.remove(upperLeftCorner2);
	  upperLeftCorner2 = new UpperLeftCorner(backgroundColor, theTabBorderColor, theTabBorderColor, theTabColor);
	  WestHeaderCenterFillerPanel.add(upperLeftCorner2, java.awt.BorderLayout.CENTER);
	  UpperRightHandCornerPanel.remove(upperRightCorner);
	  upperRightCorner = new UpperRightCorner(theTabBorderColor, theTabColor, backgroundColor,theTabBorderColor);
	  UpperRightHandCornerPanel.add(upperRightCorner, java.awt.BorderLayout.CENTER);
	  LowerRightHandCornerPanel.remove(lowerRightCorner);
	  lowerRightCorner = new LowerRightCorner(theTabBorderColor, theTabColor);
	  LowerRightHandCornerPanel.add(lowerRightCorner, java.awt.BorderLayout.CENTER);
	  UpperLeftHandCornerPanel.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 2, 0, 0), theTabBorderColor));
	  WestHeaderCenterFillerPanelSpacer.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 2, 0, 0), theTabBorderColor));
        WestHeaderBottomPanel.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 2, 1, 0), theTabBorderColor));
        CenterHeaderMiddleBottomCenterPanel4.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 2, 0, 0), theTabBorderColor));
        CenterHeaderMiddleBottomCenterPanel1.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(2, 0, 0, 0), theTabBorderColor));
        CenterHeaderMiddleRightPanel.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(2, 0, 0, 0), theTabBorderColor));
        CenterHeaderMiddleBottomLeftPanel2.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 2, 0), theTabBorderColor));
        CenterHeaderBottomPanel.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 1, 0), theTabBorderColor));
        EastHeaderTopWestLeft.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(2, 0, 0, 0), theTabBorderColor));
        EastHeaderTopSouth.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 0, 2), theTabBorderColor));
        EastHeaderMiddlePanel.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 0, 2), theTabBorderColor));
        EastHeaderBottomPanel.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 1, 2), theTabBorderColor));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public Color getTabBorderColor()
    {
	return theTabBorderColor;
    }

    public void setRowBackgroundColor(Color rowBackgroundColor)
    {
	  try
	  {
	  theRowBackgroundColor = rowBackgroundColor;
        PropertiesTree.setBackground(theRowBackgroundColor);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public Color getRowBackgroundColor()
    {
	return theRowBackgroundColor;
    }

    public void setRowBorderColor(Color rowBorderColor)
    {
	  try
	  {
	  theRowBorderColor = rowBorderColor;
	  lowerRightCorner = new LowerRightCorner(theTabBorderColor, theRowBorderColor);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public Color getRowBorderColor()
    {
	  return theRowBorderColor;
    }

    public void setDescriptorTextColor(Color descriptorTextColor)
    {
	  try
	  {
	  theDescriptorTextColor = descriptorTextColor;
	  DescriptionPanel.setForeground(descriptorTextColor);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public Color getDescriptorTextColor()
    {
	return theDescriptorTextColor;
    }

    public void setDescriptorPanelWidth(int descWidth)
    {
        DescriptionPanel.setMinimumSize(new java.awt.Dimension(descWidth, 20));
        DescriptionPanel.setPreferredSize(new java.awt.Dimension(descWidth, 20));
        DescriptionContentPanel.setPreferredSize(new java.awt.Dimension(descWidth, 20));
        CenterHeaderMiddleBottomLeftPanel1.setPreferredSize(new java.awt.Dimension(descWidth + 4, 20));
	    CenterHeaderMiddleBottomLeftPanel2.setPreferredSize(new java.awt.Dimension(descWidth + 3, 3));
    }

    public void setHeaderTextColor(Color headerTextColor)
    {
	  try
	  {
	  	theHeaderTextColor = headerTextColor;
	  	lLeftListHeader.setForeground(headerTextColor);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public Color getHeaderTextColor()
    {
	return theHeaderTextColor;
    }

    public void setDescriptorText(String descriptorText)
    {
	  try
	  {
        DescriptionPanel.setText(descriptorText);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public String getDescriptorText()
    {
	  try
	  {
        	return DescriptionPanel.getText();
        }
        catch(Exception e)
        {
            e.printStackTrace();
	  	return "";
        }

    }
    
    public void setHeaderText(String headerText)
    {
	  try
	  {		
        lLeftListHeader.setText(headerText);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }        
    }    
 
    public String getHeaderText()
    {
	  try
	  {
        	return lLeftListHeader.getText();
        }
        catch(Exception e)
        {
            e.printStackTrace();
		return "";
        }
    }   
    
    private JPanel theDescriptorReferencePanel = new JPanel();
    public void setDescriptorPanel(JPanel descPanel)
    {
	  try
	  {		
		if(descPanel!=null)
		{
			theDescriptorReferencePanel = descPanel;
        		DescriptionContentPanel.removeAll();
			DescriptionContentPanel.add(descPanel, java.awt.BorderLayout.CENTER);
		}
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }        
    }    
 
    public JPanel getDescriptorPanel()
    {
	  return theDescriptorReferencePanel;
    }   

    public void setHeaderTextAndWidth(String strFirstHeaderColumn, int widthFirstHeaderColumn, String strSecondHeaderColumn, int widthSecondHeaderColumn, String strThirdHeaderColumn, int widthThirdHeaderColumn)
    {
        try
        {
		lLeftListHeader.setText(strFirstHeaderColumn);
       	lLeftListHeader.setMaximumSize(new java.awt.Dimension(widthFirstHeaderColumn, 15));
        	lLeftListHeader.setPreferredSize(new java.awt.Dimension(widthFirstHeaderColumn, 15));
            secondHeaderLabel.setText(strSecondHeaderColumn);
        	secondHeaderLabel.setMaximumSize(new java.awt.Dimension(widthSecondHeaderColumn, 15));
        	secondHeaderLabel.setPreferredSize(new java.awt.Dimension(widthSecondHeaderColumn, 15));
		thirdHeaderLabel.setText(strThirdHeaderColumn);
        	thirdHeaderLabel.setMaximumSize(new java.awt.Dimension(widthThirdHeaderColumn, 15));
        	thirdHeaderLabel.setPreferredSize(new java.awt.Dimension(widthThirdHeaderColumn, 15));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void formAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorResized
        try
        {
            setListDefaults(theJPanelListDataItemsArray);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_formAncestorResized

    private void formAncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorMoved
        try
        {
            setListDefaults(theJPanelListDataItemsArray);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_formAncestorMoved

    private void formComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentMoved
        try
        {
            setListDefaults(theJPanelListDataItemsArray);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_formComponentMoved

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try
        {
            setListDefaults(theJPanelListDataItemsArray);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_formComponentShown

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        try
        {
            setListDefaults(theJPanelListDataItemsArray);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_formComponentResized

    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveButtonActionPerformed
		int selIndex = getSelectedIndex();
        try
        {
		//int selIndex = getSelectedIndex();

            removeListItem(selIndex);

		setAddButtonEnabled(true);
		if(0<selIndex)
		{
			setSelectedIndex(selIndex - 1);
		}
		else if(selIndex==0 && 0 < theJPanelListDataItemsArray.length)
		{
			setSelectedIndex(0);			
		}
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }        
		if(getRemoveButtonDataEnabled()==true)
		{
			setRemoveButtonData(selIndex);
		}
    }//GEN-LAST:event_RemoveButtonActionPerformed
	
    public void setLabelWidth(int labelWidth)
    {
	  EAListItemLabelWidth = labelWidth;
    }

    public void setDataWidth(int dataWidth)
    {
	  EAListItemDataWidth = dataWidth;
    }

    public void setDataValueWidth(int dataValueWidth)
    {
	  EAListItemDataValueWidth = dataValueWidth;
    }

    public void setMaxEAListItems(int maxItems)
    {
 	  maxEAListItems = maxItems;
    }

    public int getMaxEAListItems()
    {
 	  return maxEAListItems;
    }
    
    private int maxEAListItems = -1;
    private int EAListItemLabelWidth = 250;
    private int EAListItemDataWidth = 175;
    private int EAListItemDataValueWidth = 225;
    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
	if(getMaxEAListItems()==-1)
	{
        try
        {
		EAListItemContent nextItem;
		if(EALIOnAddEnabled==false)
		{
			nextItem = new EAListItemContent(theRowBackgroundColor,EAListItemLabelWidth,EAListItemDataWidth,EAListItemDataValueWidth);
			nextItem.setLabelText(defaultLabelText);
		}
		else
		{
			nextItem = masterControlPanel.addEAListItem();
		}
		if(nextItem!=null)
		{
		int newItemIndex = addListItem(nextItem);
		if(newItemIndex!=-1)
		{
            	setSelectedIndex(newItemIndex);
			if(getAddButtonDataEnabled()==true)
			{
				nextItem.setInputText(getAddButtonData());
			}
			else
			{
				if(EALIOnAddEnabled==false)
				{
					editListItem(newItemIndex);
				}
			}
			PropertyListScrollPane.updateUI();

		}
		}
        }
        catch(Exception e)
        {
          e.printStackTrace();   
        }
	  PropertyListScrollPane.getVerticalScrollBar().setValue(PropertyListScrollPane.getVerticalScrollBar().getMaximum());
	}
	else
	{

	  if(theJPanelListDataItemsArray.length<getMaxEAListItems())
	  {
        try
        {
		EAListItemContent nextItem;
		if(EALIOnAddEnabled==false)
		{
			nextItem = new EAListItemContent(theRowBackgroundColor,EAListItemLabelWidth,EAListItemDataWidth,EAListItemDataValueWidth);
			nextItem.setLabelText(defaultLabelText);
		}
		else
		{
			nextItem = masterControlPanel.addEAListItem();
		}
		if(nextItem!=null)
		{
		int newItemIndex = addListItem(nextItem);
		if(newItemIndex!=-1)
		{
            	setSelectedIndex(newItemIndex);
			if(getAddButtonDataEnabled()==true)
			{
				nextItem.setInputText(getAddButtonData());
			}
			else
			{
				if(EALIOnAddEnabled==false)
				{
					editListItem(newItemIndex);
				}
			}
			PropertyListScrollPane.updateUI();
		}
		}
        }
        catch(Exception e)
        {
          e.printStackTrace();   
        }
	  PropertyListScrollPane.getVerticalScrollBar().setValue(PropertyListScrollPane.getVerticalScrollBar().getMaximum());
	  if(theJPanelListDataItemsArray.length==getMaxEAListItems())
	  {
		setAddButtonEnabled(false);
	  }
	  }
	  else
	  {
		setAddButtonEnabled(false);
	  }
	}
        //System.out.println("Data Items: " + theJPanelListDataItemsArray.length);
    }//GEN-LAST:event_AddButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        try
        {
            editListItem(getSelectedIndex());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }   
    }//GEN-LAST:event_EditButtonActionPerformed

    private void PreviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviewButtonActionPerformed
        try
        {
	  	if(getPreviewButtonAction()!=null)
		{
                        try
                        {
                            Class.forName(getPreviewButtonAction()).newInstance();
                        }
                        catch(InstantiationException e)
                        {
                            //System.out.println(e);
                        }   
                        catch(IllegalAccessException e)
                        {
                            //System.out.println(e);
                        }                      
                        catch(ClassNotFoundException e)
                        {
                            //System.out.println(e);
                        }       
		}
		else
		{
			System.out.println("Preview not implemented.");
		}
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }   
    }//GEN-LAST:event_PreviewButtonActionPerformed

    boolean boolGetConfigurationWizardActionFromParent = false;
    public void setGetConfigurationWizardActionFromParent(boolean isEnabled)
    {
	if(getMasterControlPanelEnabled()==true)
	{
		boolGetConfigurationWizardActionFromParent = isEnabled;
	}
    }

    public boolean getGetConfigurationWizardActionFromParent()
    {
	return boolGetConfigurationWizardActionFromParent;
    }

    private void ConfigurationWizardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfigurationWizardButtonActionPerformed
        try
        {
		if(getGetConfigurationWizardActionFromParent()==true)
		{
			masterControlPanel.getFireConfigurationWizardAction();
		}
		else
		{
	  		if(getConfigurationWizardButtonAction()!=null)
			{
                        try
                        {
                            Class.forName(getConfigurationWizardButtonAction()).newInstance();
                        }
                        catch(InstantiationException e)
                        {
                            //System.out.println(e);
                        }   
                        catch(IllegalAccessException e)
                        {
                            //System.out.println(e);
                        }                      
                        catch(ClassNotFoundException e)
                        {
                            //System.out.println(e);
                        }       
			}
			else
			{
				System.out.println("Configuration Wizard not implemented.");
			}
		}
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }   
    }//GEN-LAST:event_ConfigurationWizardButtonActionPerformed

    private void Item1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Item1MouseClicked
        // Add your handling code here:
    }//GEN-LAST:event_Item1MouseClicked
    
    public void setAddButtonVisible(boolean isVisible)
    {
	  AddButton.setVisible(isVisible);
    }
	
    public boolean getAddButtonVisible()
    {
	  return AddButton.isVisible();
    }   

    public void setEditButtonVisible(boolean isVisible)
    {
	  EditButton.setVisible(isVisible);
    }
	
    public boolean getEditButtonVisible()
    {
	  return EditButton.isVisible();
    }   

    public void setRemoveButtonVisible(boolean isVisible)
    {
	  RemoveButton.setVisible(isVisible);
    }
	
    public boolean getRemoveButtonVisible()
    {
	  return RemoveButton.isVisible();
    }   

    public void setAddButtonEnabled(boolean isEnabled)
    {
	  AddButton.setEnabled(isEnabled);
    }
	
    public boolean getAddButtonEnabled()
    {
	  return AddButton.isEnabled();
    }   

    public void setEditButtonEnabled(boolean isEnabled)
    {
	  EditButton.setEnabled(isEnabled);
    }
	
    public boolean getEditButtonEnabled()
    {
	  return EditButton.isEnabled();
    }   

    public void setRemoveButtonEnabled(boolean isEnabled)
    {
	  RemoveButton.setEnabled(isEnabled);
    }
	
    public boolean getRemoveButtonEnabled()
    {
	  return RemoveButton.isEnabled();
    }   

    public void setConfigurationWizardButtonVisible(boolean isVisible)
    {
	  ConfigurationWizardButton.setVisible(isVisible);
    }
	
    public boolean getConfigurationWizardButtonVisible()
    {
	  return ConfigurationWizardButton.isVisible();
    }   

    public void setPreviewButtonVisible(boolean isVisible)
    {
	  PreviewButton.setVisible(isVisible);
    }
	
    public boolean getPreviewButtonVisible()
    {
	  return PreviewButton.isVisible();
    }   
    public void setMasterControlPanelEnabled(boolean isEnabled)
    {
	  masterControlPanelIsEnabled = isEnabled;
    }

    public boolean getMasterControlPanelEnabled()
    {
	  return masterControlPanelIsEnabled;
    }
	

    public void setMasterControlPanel(EAMasterControlPanel theMasterControlPanel)
    {
	try
	{
	  if(theMasterControlPanel != null)
	  {
	  	masterControlPanel = theMasterControlPanel;
	  	setMasterControlPanelEnabled(true);
	  }
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }
	
    private boolean addButtonDataEnabled = false;
    public void setAddButtonDataEnabled(boolean isEnabled)
    {
	addButtonDataEnabled = isEnabled;
    }

    public boolean getAddButtonDataEnabled()
    {
	return addButtonDataEnabled;
    }

    private boolean removeButtonDataEnabled = false;
    public void setRemoveButtonDataEnabled(boolean isEnabled)
    {
	removeButtonDataEnabled = isEnabled;
    }

    public boolean getRemoveButtonDataEnabled()
    {
	return removeButtonDataEnabled;
    }

    public String getAddButtonData()
    {
	   return ((EAPanel)getParentComponent()).getAddButtonData();
    }

    public void setRemoveButtonData(int regCodeIndex)
    {
	   ((EAPanel)getParentComponent()).setRemoveButtonData(regCodeIndex);
    }

    String strThePreviewAction = null;
    public void setPreviewButtonAction(String strPreviewAction)
    {
	  strThePreviewAction=strPreviewAction;
    }

    public String getPreviewButtonAction()
    {
	   return strThePreviewAction;
    }

    String strTheConfigurationWizardAction = null;
    public void setConfigurationWizardButtonAction(String strConfigurationWizardAction)
    {
	  strTheConfigurationWizardAction=strConfigurationWizardAction;
    }

    public String getConfigurationWizardButtonAction()
    {
	   return strTheConfigurationWizardAction;
    }


    public void setInsertHeaderPanel(EAPanel headerPanel)
    {
	  headerPanel.setParentComponent(this);
	  CenterHeaderBottomPanel.add(headerPanel,1);
	  CenterHeaderBottomPanel.add(RightListHeaderPanel,2);
    }

    private String UIText1 = "";
    private int UIIndex1 = 1;
    private int UIEndIndexLength1 = -1;
    private boolean UITextEnabled = false;
    private int UIArrayIndex1 = 0;
    public void setUITextWithStartIndex(String UIText, int UIArrayIndex, int index)
    {
	  UIText1 = UIText;
	  UIIndex1 = index;  
	  UITextEnabled = true;	
	  UIArrayIndex1 = UIArrayIndex;
    }

    public void setUITextWithStartAndEndIndex(String UIText, int UIArrayIndex, int index, int UIEndIndexLength)
    {
	  UIText1 = UIText;
	  UIIndex1 = index;  
	  UIEndIndexLength1 = UIEndIndexLength;
	  UITextEnabled = true;	
	  UIArrayIndex1 = UIArrayIndex;
    }
    
    public void setDisableUITextFunction()
    {
	  UITextEnabled = false;
    }

    private boolean EALIOnAddEnabled = false;
    public void setAddEALIOnAddEnabled(boolean isEnabled)
    {
		EALIOnAddEnabled = isEnabled;
    }

    private EAListItem[] updateEAPropertiesPanelUI(EAListItem[] eaItems)
    {
	  try
	  {
		if(UIEndIndexLength1!=-1)
		{
			int startindex = UIArrayIndex1;
			int indexLength = eaItems.length - UIEndIndexLength1;
			for(int i = UIIndex1;i<eaItems.length;i++)
			{
                		if(eaItems[i]!=null)
                		{
					eaItems[i].setLabelText(getDefaultLabelText() + String.valueOf(i) + ":");
 					startindex++;
               		}
			}
		}
		else
		{
			int startindex = UIArrayIndex1;
			for(int i = UIIndex1;i<eaItems.length;i++)
			{
                		if(eaItems[i]!=null)
                		{
					eaItems[i].setLabelText(getDefaultLabelText() + String.valueOf(startindex) + ":");
					startindex++;
                		}
			}
		}
		return eaItems;
	  }
	  catch(Exception e)
	  {
		e.printStackTrace();
	  }
	return new EAListItem[0];
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JPanel ButtonControlPanel;
    private javax.swing.JPanel CenterHeaderBottomPanel;
    private javax.swing.JPanel CenterHeaderMiddleBottomCenterPanel;
    private javax.swing.JPanel CenterHeaderMiddleBottomCenterPanel1;
    private javax.swing.JPanel CenterHeaderMiddleBottomCenterPanel2;
    private javax.swing.JPanel CenterHeaderMiddleBottomCenterPanel3;
    private javax.swing.JPanel CenterHeaderMiddleBottomCenterPanel4;
    private javax.swing.JPanel CenterHeaderMiddleBottomCenterPanel6;
    private javax.swing.JPanel CenterHeaderMiddleBottomLeftPanel;
    private javax.swing.JPanel CenterHeaderMiddleBottomLeftPanel1;
    private javax.swing.JPanel CenterHeaderMiddleBottomLeftPanel2;
    private javax.swing.JPanel CenterHeaderMiddleBottomPanel;
    private javax.swing.JPanel CenterHeaderMiddleBottomPanel10;
    private javax.swing.JPanel CenterHeaderMiddleBottomPanel11;
    private javax.swing.JPanel CenterHeaderMiddleBottomPanel12;
    private javax.swing.JPanel CenterHeaderMiddleBottomPanel13;
    private javax.swing.JPanel CenterHeaderMiddleBottomPanel15;
    private javax.swing.JPanel CenterHeaderMiddleBottomPanel3;
    private javax.swing.JPanel CenterHeaderMiddleBottomPanel4;
    private javax.swing.JPanel CenterHeaderMiddleBottomPanel5;
    private javax.swing.JPanel CenterHeaderMiddleBottomPanel6;
    private javax.swing.JPanel CenterHeaderMiddleBottomPanel7;
    private javax.swing.JPanel CenterHeaderMiddleBottomPanel8;
    private javax.swing.JPanel CenterHeaderMiddleBottomPanel9;
    private javax.swing.JPanel CenterHeaderMiddleBottomRightPanel;
    private javax.swing.JPanel CenterHeaderMiddleBottomRightPanel1;
    private javax.swing.JPanel CenterHeaderMiddleCenterPanel;
    private javax.swing.JPanel CenterHeaderMiddleLeftPanel;
    private javax.swing.JPanel CenterHeaderMiddlePanel;
    private javax.swing.JPanel CenterHeaderMiddleRightPanel;
    private javax.swing.JPanel CenterHeaderMiddleTopPanel;
    private javax.swing.JPanel CenterHeaderPanel;
    private javax.swing.JPanel CenterHeaderTopPanel;
    private javax.swing.JLabel DescriptionPanel;
    private javax.swing.JPanel EastHeaderBottomPanel;
    private javax.swing.JPanel EastHeaderMiddlePanel;
    private javax.swing.JPanel EastHeaderPanel;
    private javax.swing.JPanel EastHeaderTopNorth;
    private javax.swing.JPanel EastHeaderTopPanel;
    private javax.swing.JPanel EastHeaderTopPanel3;
    private javax.swing.JPanel EastHeaderTopSouth;
    private javax.swing.JPanel EastHeaderTopWestLeft;
    private javax.swing.JPanel LeftListHeaderPanel;
    private javax.swing.JPanel LeftUpperCornerPanel2;
    private javax.swing.JPanel LowerRightHandCornerPanel;
    private javax.swing.JPanel PropertiesTree;
    private javax.swing.JPanel PropertyList;
    private javax.swing.JScrollPane PropertyListScrollPane;
    private javax.swing.JButton EditButton;
    private javax.swing.JButton RemoveButton;
    private javax.swing.JPanel RightListHeaderPanel;
    private javax.swing.JPanel TheHeaderDescriptionAreaPanel;
    private javax.swing.JPanel TitlePanel;
    private javax.swing.JPanel UpperLeftHandCornerPanel;
    private javax.swing.JPanel UpperRightHandCornerPanel;
    private javax.swing.JPanel WestHeaderBottomPanel;
    private javax.swing.JPanel WestHeaderMiddlePanel;
    private javax.swing.JPanel WestHeaderMiddleTopPanel;
    private javax.swing.JPanel WestHeaderPanel;
    private javax.swing.JPanel WestHeaderTopPanel;
    private javax.swing.JPanel WestHeaderCenterFillerPanel;
    private javax.swing.JPanel WestHeaderCenterFillerPanelSpacer;
    private javax.swing.JPanel DescriptionContentPanel; 
    private javax.swing.JLabel lLeftListHeader;
    private javax.swing.JLabel lRightListHeader;
    private javax.swing.JPanel buttonPanelSpacer;
    private javax.swing.JPanel buttonPanelTopSpacer;
    private javax.swing.JPanel buttonPanelContent;
    private javax.swing.JButton PreviewButton;
    private javax.swing.JButton ConfigurationWizardButton;

}
