/*
 * EAListItemContent.java
 *
 * Created on April 1, 2004, 3:34 PM
 */

package com.trinity.ea.design.common.panel;
import com.trinity.ea.design.common.panel.EAPanel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.border.MatteBorder;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class EAListItemContent extends EAPanel
{
	private int componentLocalizationID = 0;
	private boolean editModeEnabled = false;
	private boolean isSelected = false;
      private Color backgroundColor = new java.awt.Color(220, 225, 240);
	private String statusMessage = "";
	private String strUndefinedValue = "<Undefined>"; 
	private Color undefinedTextColor = new java.awt.Color(255, 0, 0);
	private Color textColor = Color.black;
	private Color theInputTextColor = textColor;
	//private Color theSelectionColor = new java.awt.Color(89, 151, 100);
	private Color theSelectionColor = new Color(200, 201, 240);
	private Color theSelectedTextColor = Color.black;
	private Color theEditInputBackgroundColor = Color.white;
      private javax.swing.JLabel InputLabel;
      public javax.swing.JCheckBox cbInputLabel;
      public javax.swing.JComboBox comboInputLabel;
      private javax.swing.JTextField tfData;
      private javax.swing.JTextField tfDataValue;
      private boolean boolInputLabel = false;
	private boolean boolIsListBox = false;

	private String strUndefinedInputValue = "<Undefined Input Value>";

      public EAListItemContent(Color BGColor)
	{
		try
		{
			backgroundColor = BGColor;
			initBlank(250, 175, 225,false);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

      public EAListItemContent(Color BGColor, int labelWidth, int dataWidth)
	{
		try
		{
			backgroundColor = BGColor;
			initBlank(labelWidth, dataWidth, 175,false);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

      public EAListItemContent(Color BGColor, int labelWidth, int dataWidth, boolean isCheckBox)
	{
		try
		{
			backgroundColor = BGColor;
			initBlank(labelWidth, dataWidth, 175,isCheckBox);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}      
      public EAListItemContent(Color BGColor, int labelWidth, int dataWidth, boolean isCheckBox, boolean isComboBox)
	{
		try
		{
			backgroundColor = BGColor;
			initBlank(labelWidth, dataWidth, 175,isCheckBox,isComboBox);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}      
      public EAListItemContent(Color BGColor, int labelWidth, int dataWidth, int dataValueWidth)
	{
		try
		{
			backgroundColor = BGColor;
			initBlank(labelWidth, dataWidth, dataValueWidth,false);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

      public EAListItemContent(Color BGColor, int labelWidth, int dataWidth, int dataValueWidth, boolean isCheckBox)
	{
		try
		{
			backgroundColor = BGColor;
			initBlank(labelWidth, dataWidth, dataValueWidth,isCheckBox);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/** return the control data */
	public String[] getDataArray()
	{
		String[] theStrArray = new String[2]; 
		theStrArray[0] = getInputText();
		if(getValueBoxEnabled()==false)
		{
			theStrArray[1] = "";
		}
		else
		{
			if(strUndefinedInputValue.equalsIgnoreCase(getInputValueText())==false)
			{
				theStrArray[1] = getInputValueText();
			}
			else
			{
				theStrArray[1] = "";
			}
		}
		return theStrArray;
	}	

        public void setComponentLocalizationID(int componentID)
        {
            componentLocalizationID = componentID;
        }
        
        public int getComponentLocalizationID() 
        {
            return componentLocalizationID;
        }
        
	  public void setBackgroundColor(Color BGColor)
	  {
		backgroundColor = BGColor;
		setBackground(backgroundColor);
	  }

	  public void setStatusMessage(String statusMsg)
	  {
		statusMessage = statusMsg;
	  }	

	  public String getStatusMessage()
	  {
		return statusMessage;
	  }

	  public void setLabelText(String labelText)
	  {
		try
		{
		 if(labelText!=null)
		 {
			if(labelText.equalsIgnoreCase("")==false)
			{
        	 		InputLabel.setText(labelText);
                        }
		 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	  }

	  public String getLabelText()
	  {
               return InputLabel.getText();
	  }
	  
	  private boolean isValidData = false;
	  public boolean getIsValidData()
	  {
		return isValidData;
	  }

	  private boolean isValidInputValueData = false;
	  public boolean getIsValidInputValueData()
	  {
		return isValidInputValueData;
	  }

	  public void setValueBoxEnabled(boolean valEnabled)
	  {
		tfDataValue.setVisible(valEnabled);
	  }

	  public boolean getValueBoxEnabled()
	  {
		return  tfDataValue.isVisible();
	  }

	  public void setInputTextColor(Color inputTextColor)
	  {
		try
		{
                    theInputTextColor = inputTextColor;
                    if(boolInputLabel==false&&boolIsListBox==false)
                    {                       
                            tfData.setForeground(inputTextColor);
                    }
        		  else if(boolIsListBox==true)
        		  {
            		comboInputLabel.setForeground(inputTextColor);
        		  }
                    else
                    {
                            cbInputLabel.setForeground(inputTextColor);                        
                    }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	  }

	  public void setInputText(String inputText)
	  {
		try
		{
		 if(inputText!=null)
		 {
                    if(boolInputLabel==false&&boolIsListBox==false)
                    {                        
			if(inputText.equalsIgnoreCase("")==false)
			{
				isValidData = true;
		 		tfData.setText(inputText);
        	 		tfData.setCaretPosition(0);
				if(getIsDefaultInputText()==true)
				{
					tfData.setForeground(undefinedTextColor);
	      			tfData.setDisabledTextColor(undefinedTextColor);
				}
				else
				{
					tfData.setForeground(theInputTextColor);
	      			tfData.setDisabledTextColor(theInputTextColor);
				}
			}
                    }
		 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	  }

	  public String getInputText()
	  {
		try
		{
                    if(boolInputLabel==false&&boolIsListBox==false)
                    {    
                        if(tfData.getText()!=null)
                        {
                                if(tfData.getText().trim().equalsIgnoreCase("")==true)
                                {
                                        tfData.setForeground(undefinedTextColor);
                                        setDefaultInput();
                                        return tfData.getText();
                                }
                                else
                                {
                                        return tfData.getText();
                                }
                        }
                        else
                        {
                                        setDefaultInput();
                                        return tfData.getText();
                        }
                    }
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "";
		}
                return "";
	  }

	  public void setInputValueText(String inputValueText)
	  {
		try
		{
		 if(inputValueText!=null)
		 {
			if(inputValueText.equalsIgnoreCase("")==false)
			{
				isValidInputValueData = true;
		 		tfDataValue.setText(inputValueText);
        	 		tfDataValue.setCaretPosition(0);
				if(getIsDefaultInputValueText()==true)
				{
					tfDataValue.setForeground(undefinedTextColor);
	      			tfDataValue.setDisabledTextColor(undefinedTextColor);
				}
				else
				{
					tfDataValue.setForeground(theInputTextColor);
	      			tfDataValue.setDisabledTextColor(theInputTextColor);
				}
			}
		 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	  }

	  public String getInputValueText()
	  {
		try
		{
		if(tfDataValue.getText()!=null)
		{
			if(tfDataValue.getText().trim().equalsIgnoreCase("")==true)
			{
				setDefaultInputValue();
				tfDataValue.setForeground(undefinedTextColor);
				return tfDataValue.getText();
			}
			else
			{
				return tfDataValue.getText();
			}
		}
		else
		{
				setDefaultInputValue();
				return tfDataValue.getText();
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "";
		}
	  }

	public void setEditMode()
	{
            try
            {
		editModeEnabled = true;
                if(boolInputLabel==false&&boolIsListBox==false)
                {
                    tfData.setEnabled(true);
                    tfData.setFont(new java.awt.Font("Arial", 0, 12));
                    tfData.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(1, 1, 1, 1), new java.awt.Color(100, 120, 170)));
                    tfData.setBackground(theEditInputBackgroundColor);
                    tfData.setCaretColor(theInputTextColor);
                    tfData.setCaretPosition(0);
                    tfData.setSelectionColor(theSelectionColor);
                    tfData.setSelectedTextColor(theSelectedTextColor);                   
                }
        	    else if(boolIsListBox==true)
        	    {
            	comboInputLabel.setFont(new java.awt.Font("Arial", 1, 11));
        	    }
                else
                {
                    cbInputLabel.setFont(new java.awt.Font("Arial", 1, 12));                           
                }                        
                InputLabel.setFont(new java.awt.Font("Arial", 1, 12));
 		tfDataValue.setEnabled(true);               
		tfDataValue.setFont(new java.awt.Font("Arial", 0, 12));
        	tfDataValue.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(1, 1, 1, 1), new java.awt.Color(100, 120, 170)));
		tfDataValue.setBackground(theEditInputBackgroundColor);
        	tfDataValue.setCaretColor(theInputTextColor);
        	tfDataValue.setCaretPosition(0);
		tfDataValue.setSelectionColor(theSelectionColor);
		tfDataValue.setSelectedTextColor(theSelectedTextColor);
                if(boolInputLabel==false&&boolIsListBox==false)
                {               
                    if(getIsDefaultInputText()==true)
                    {
                            tfData.setForeground(theInputTextColor);
                            tfData.setText("");
                    }
                    else
                    {
                            tfData.setForeground(theInputTextColor);
                    }
                    tfData.grabFocus();
                }
		if(getIsDefaultInputValueText()==true)
		{
			tfDataValue.setForeground(textColor);
			//tfDataValue.setText("");
		}
		else
		{
			tfDataValue.setForeground(textColor);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void setNormalMode()
	{
		try
		{
		editModeEnabled = false;
		isSelected = false;
                if(boolInputLabel==false&&boolIsListBox==false)
                {
                    tfData.setEnabled(false);              
                    tfData.setFont(new java.awt.Font("Arial", 0, 12));
                    tfData.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 0, 0), new java.awt.Color(100, 120, 170)));
                    tfData.setBackground(backgroundColor); 
                    tfData.setCaretColor(backgroundColor);
                    tfData.setCaretPosition(0);
                }
		    else if(boolIsListBox==true)
		    {
            	comboInputLabel.setFont(new java.awt.Font("Arial", 0, 11));
		    }
                else
                {
                    cbInputLabel.setFont(new java.awt.Font("Arial", 0, 12));                           
                } 
                InputLabel.setFont(new java.awt.Font("Arial", 0, 12));                
		tfDataValue.setEnabled(false);
		tfDataValue.setFont(new java.awt.Font("Arial", 0, 12));
        	tfDataValue.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 0, 0), new java.awt.Color(100, 120, 170)));
		tfDataValue.setBackground(backgroundColor); 
        	tfDataValue.setCaretColor(backgroundColor);
                tfDataValue.setCaretPosition(0);
                if(boolInputLabel==false&&boolIsListBox==false)
                {
                    if(getIsDefaultInputText()==true)
                    {
                        tfData.setForeground(undefinedTextColor);
                        tfData.setDisabledTextColor(undefinedTextColor);
                    }
                    else
                    {
                        tfData.setForeground(theInputTextColor);
                        tfData.setDisabledTextColor(theInputTextColor);
                    }
                }
		if(getIsDefaultInputValueText()==true)
		{
                    tfDataValue.setForeground(undefinedTextColor);
                    tfDataValue.setDisabledTextColor(undefinedTextColor);
		}
		else
		{
                    tfDataValue.setForeground(theInputTextColor);
                    tfDataValue.setDisabledTextColor(theInputTextColor);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void setSelectedMode()
	{
		try
		{
		isSelected = true;
                if(boolInputLabel==false&&boolIsListBox==false)
                {
                    tfData.setEnabled(false);                
                    tfData.setFont(new java.awt.Font("Arial", 1, 12));
                    tfData.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 0, 0), new java.awt.Color(100, 120, 170)));
                    tfData.setCaretColor(backgroundColor);
                    tfData.setCaretPosition(0);
                }
		    else if(boolIsListBox==true)
		    {
            	comboInputLabel.setFont(new java.awt.Font("Arial", 1, 11));
		    }
                else
                {
                    cbInputLabel.setFont(new java.awt.Font("Arial", 1, 12));                           
                } 

                InputLabel.setFont(new java.awt.Font("Arial", 1, 12));                
		tfDataValue.setEnabled(false);
		tfDataValue.setFont(new java.awt.Font("Arial", 1, 12));
        	tfDataValue.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 0, 0), new java.awt.Color(100, 120, 170)));
        	tfDataValue.setCaretColor(backgroundColor);
        	tfDataValue.setCaretPosition(0);
                if(boolInputLabel==false&&boolIsListBox==false)
                {                
                    if(getIsDefaultInputText()==true)
                    {
                        tfData.setForeground(undefinedTextColor);
                        tfData.setDisabledTextColor(undefinedTextColor);
                    }
                    else
                    {
                        tfData.setForeground(theInputTextColor);
                        tfData.setDisabledTextColor(theInputTextColor);
                    }
                }
		if(getIsDefaultInputValueText()==true)
		{
			tfDataValue.setForeground(undefinedTextColor);
	      	tfDataValue.setDisabledTextColor(undefinedTextColor);
		}
		else
		{
			tfDataValue.setForeground(theInputTextColor);
	      	tfDataValue.setDisabledTextColor(theInputTextColor);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public boolean getEditModeEnabled()
	{
		return editModeEnabled;
	}       

	public boolean getIsSelected()
	{
		return isSelected;
	}
	
	public void setDefaultInput()
	{
            if(boolInputLabel==false&&boolIsListBox==false)
            {    
                tfData.setText(strUndefinedValue);
            }
	}

	public String getDefaultInput()
	{
		return strUndefinedValue; 
	}

	public void setDefaultInputValue()
	{
		tfDataValue.setText(strUndefinedInputValue); 
	}

	public String getDefaultInputValue()
	{
		return strUndefinedInputValue; 
	}
	
	public boolean getIsDefaultInputText()
	{
            if(boolInputLabel==false&&boolIsListBox==false)
            {    
		if(tfData.getText().equalsIgnoreCase(strUndefinedValue)==true)
		{
			return true;
		}
		else
		{
			return false;
		}
            }
            return false;
	}

	
	public boolean getIsDefaultInputValueText()
	{
		if(tfDataValue.getText().equalsIgnoreCase(strUndefinedInputValue)==true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
///////////////////////////

        public void setComboBoxIndex(int indexSelected)
        {
            if(boolIsListBox==true)
            {
			try
			{
                		comboInputLabel.setSelectedIndex(indexSelected);
			}
			catch(Exception e)
			{

			}
            }
        }
        
        public int getComboBoxIndex()
        {
            if(boolIsListBox==true)
            {
 			try
			{
                  	return comboInputLabel.getSelectedIndex();
			}
			catch(Exception e)
			{
				return -1;
			}
            }
            else
            {
			return -1;
            }
        }   
        
        public void setComboBoxEnabled(boolean isEnabled)
        {
            if(boolIsListBox==true)
            {
                comboInputLabel.setEnabled(isEnabled);
            }
        }
        
        public boolean getComboBoxEnabled()
        {
            if(boolIsListBox==true)
            {
                return comboInputLabel.isEnabled();
            }
            else
            {
                return false;
            }
        }    

        public void setComboBoxListArray(String[] listArray)
        {
            if(boolIsListBox==true)
            {
			try
			{
	            	comboInputLabel.setModel(new javax.swing.DefaultComboBoxModel(listArray));
			}
			catch(Exception e)
			{

			}
            }
        }

        public int getComboBoxItemCount()
        {
            if(boolIsListBox==true)
            {
			try
			{
	            	return comboInputLabel.getItemCount();
			}
			catch(Exception e)
			{

			}
            }
		return -1;
        }
///////////////////////////
        public void setCheckBoxSelected(boolean isSelected)
        {
            if(boolInputLabel==true)
            {
                cbInputLabel.setSelected(isSelected);
            }
        }
        
        public boolean getCheckBoxSelected()
        {
            if(boolInputLabel==true)
            {
                return cbInputLabel.isSelected();
            }
            else
            {
                return false;
            }
        }   
        
        public void setCheckBoxEnabled(boolean isEnabled)
        {
            if(boolInputLabel==true)
            {
                cbInputLabel.setEnabled(isEnabled);
            }
        }
        
        public boolean getCheckBoxEnabled()
        {
            if(boolInputLabel==true)
            {
                return cbInputLabel.isEnabled();
            }
            else
            {
                return false;
            }
        }          
	private boolean liIsRemovable = true;
	public void setListItemIsRemovable(boolean isRemovable)
	{
		liIsRemovable = isRemovable;
	}

	/** Used to Determine if current EAListItem can be removed from the EAPropertiesPanel */
	public boolean getListItemIsRemovable()
	{
		return liIsRemovable;
	}	

    private void tfDataFocusGained(java.awt.event.FocusEvent evt) 
    {
        if(boolInputLabel==false&&boolIsListBox==false)
        {   
            tfData.select(0,tfData.getText().length());
        }
    }

    private void tfDataValueFocusGained(java.awt.event.FocusEvent evt) 
    {
       if(boolInputLabel==false)
       {
        tfDataValue.select(0,tfDataValue.getText().length());
	}
    }

    private void initBlank(int labelWidth, int dataWidth, int dataValueWidth, boolean isCheckBox) 
    {
	initBlank(labelWidth, dataWidth, dataValueWidth, isCheckBox, false);
    }

    private void initBlank(int labelWidth, int dataWidth, int dataValueWidth, boolean isCheckBox, boolean isListBox) 
    {
        boolInputLabel = isCheckBox;
	  boolIsListBox = isListBox;
        if(isCheckBox==true)
        {
            cbInputLabel = new javax.swing.JCheckBox(); 
        }
        else if(isListBox==true)
        {
            comboInputLabel = new javax.swing.JComboBox(); 
        }
        else
        {
            tfData = new javax.swing.JTextField();         
        }
  
        InputLabel = new javax.swing.JLabel();         
        tfDataValue = new javax.swing.JTextField();

	  setBackgroundColor(backgroundColor);
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
              InputLabel.setBackground(backgroundColor);
            InputLabel.setMaximumSize(new java.awt.Dimension(labelWidth, 20));
            InputLabel.setMinimumSize(new java.awt.Dimension(labelWidth, 20));
            InputLabel.setPreferredSize(new java.awt.Dimension(labelWidth, 20));
              InputLabel.setText("Input name attribute: ");
            add(InputLabel);       
        if(isCheckBox==true)
        {        
            cbInputLabel.setBackground(backgroundColor);
            cbInputLabel.setMaximumSize(new java.awt.Dimension(dataWidth, 20));
            cbInputLabel.setMinimumSize(new java.awt.Dimension(dataWidth, 20));
            cbInputLabel.setPreferredSize(new java.awt.Dimension(dataWidth, 20));
            add(cbInputLabel);
        }
        else if(isListBox==true)
        {
            comboInputLabel.setFont(new java.awt.Font("Arial", 0, 11));
            comboInputLabel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Disabled", "Load Web Page", "Java Action" }));
            comboInputLabel.setBackground(backgroundColor);
            comboInputLabel.setMaximumSize(new java.awt.Dimension(120, 20));
            comboInputLabel.setMinimumSize(new java.awt.Dimension(120, 20));
            comboInputLabel.setPreferredSize(new java.awt.Dimension(120, 20));
            add(comboInputLabel);
        }
        else
        {
            tfData.setPreferredSize(new java.awt.Dimension(dataWidth, 18));
            tfData.setMargin(new Insets(2, 5, 0, 0)); 
            tfData.setText(strUndefinedValue); 
            tfData.addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusGained(java.awt.event.FocusEvent evt) {
                    tfDataFocusGained(evt);
                }
            });
            add(tfData);         
        }


        tfDataValue.setText(strUndefinedInputValue);
        tfDataValue.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(1, 1, 1, 1), new java.awt.Color(100, 120, 170)));
        tfDataValue.setPreferredSize(new java.awt.Dimension(dataValueWidth, 18));
	  tfDataValue.setMargin(new Insets(2, 5, 0, 0));
        tfDataValue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfDataValueFocusGained(evt);
            }
        });
        add(tfDataValue);
	  setNormalMode();
    }
}
 
