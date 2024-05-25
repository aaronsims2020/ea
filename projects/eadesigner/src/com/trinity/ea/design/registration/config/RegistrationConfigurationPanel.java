/*
 * RegistrationConfigurationPanel.java
 *
 * Created on April 22, 2004, 4:18 PM
 */

package com.trinity.ea.design.registration.config;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.common.panel.DataContentPanel;
import com.trinity.ea.design.registration.EADesignerRegistrationPanel;
import com.trinity.ea.forms.data.RandomNumberGenerator;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2005 Trinity Software. All rights reserved.
 */
public class RegistrationConfigurationPanel extends EAPanel {

    private Color backgroundColor = new java.awt.Color(140, 160, 210);   
    private int currentIndex = -1;
    /** Creates new form RegistrationConfigurationPanel */
    public RegistrationConfigurationPanel(int currentEAListItemIndex) {
	currentIndex = currentEAListItemIndex;
        initComponents();
 	setProjectData();       
    }

   public void addNewRegistrationCode(String regCode)
   {
        try
        {
	tfSoftwareTitle1.setText(regCode);
		if(ProjectManager.get("registeredCode")!=null)
		{
			Object[] theObjArray = getStringArraysFromString(ProjectManager.get("registeredCode"));
			ArrayList theEAItemList = new ArrayList();
			if(theObjArray.length!=0)
			{
				for(int i = 0;i<theObjArray.length;i++)
				{	
					if(i != currentIndex)
					{
						theEAItemList.add(theObjArray[i]);
					}
					else
					{
						theEAItemList.add(tfSoftwareTitle1.getText());						
					}
				}
				theEAItemList.add(regCode);
				theEAItemList.trimToSize();
				theObjArray = theEAItemList.toArray();
				ProjectManager.putTempNoFileWrite("registeredCode", getStringFromArray(theObjArray));
			}
			else
			{
				ProjectManager.putTempNoFileWrite("registeredCode", tfSoftwareTitle1.getText());
			}
		}
		else
		{
			ProjectManager.putTempNoFileWrite("registeredCode", tfSoftwareTitle1.getText());
		}	
		ProjectManager.saveTempNow();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
   }

   public void removeRegistrationCode(int regCodeIndex)
   {
        try
        {
		if(ProjectManager.get("registeredCode")!=null)
		{
			StringBuffer sb = new StringBuffer();
			Object[] theObjArray = getStringArraysFromString(ProjectManager.get("registeredCode"));
			if(theObjArray.length!=0)
			{
					sb.append((String)theObjArray[0]);
					for(int i = 1;i<theObjArray.length;i++)
					{	
						if(i != regCodeIndex)
						{
							sb.append("," + (String)theObjArray[i]);
						}
					}
				ProjectManager.putTempNoFileWrite("registeredCode", sb.toString());
			}
		}
		ProjectManager.saveTempNow();
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
		// Registration Code Serial Number TextField  

		if(ProjectManager.get("registeredCode")!=null)
		{
			Object[] theObjArray = getStringArraysFromString(ProjectManager.get("registeredCode"));
			ArrayList theEAItemList = new ArrayList();
			if(theObjArray.length!=0)
			{
				for(int i = 0;i<theObjArray.length;i++)
				{	
					if(i != currentIndex)
					{
						theEAItemList.add(theObjArray[i]);
					}
					else
					{
						theEAItemList.add(tfSoftwareTitle1.getText());						
					}
				}
				theEAItemList.trimToSize();
				theObjArray = theEAItemList.toArray();
				ProjectManager.put("registeredCode", getStringFromArray(theObjArray));
			}
			else
			{
				ProjectManager.put("registeredCode", tfSoftwareTitle1.getText());
			}
		}
		else
		{
			ProjectManager.put("registeredCode", tfSoftwareTitle1.getText());
		}		
		SpinnerNumberModel sm = (SpinnerNumberModel)spinMaxRegistrationAttempts.getModel();
		ProjectManager.put("maxRegisterAttempts", String.valueOf(sm.getNumber().intValue()));
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
		// Registration Code Serial Number TextField  
            if(ProjectManager.get("registeredCode")!=null)
            {
		    tfSoftwareTitle1.setOpaque(true);
                Object[] theObjArray = getStringArraysFromString(ProjectManager.get("registeredCode"));
			if(theObjArray.length!=0)
			{
				for(int i = 0;i<theObjArray.length;i++)
				{	
					if(i == currentIndex)
					{
						tfSoftwareTitle1.setText((String)theObjArray[i]);
						break;
					}
				}
			}
			else
			{
				tfSoftwareTitle1.setText("");
			}
		}
		else
		{
				tfSoftwareTitle1.setText("");
		}	
	      tfSoftwareTitle1.setCaretPosition(0);
            if(ProjectManager.get("maxRegisterAttempts")!=null)
            {
		    spinMaxRegistrationAttempts.setOpaque(true);
   		    spinMaxRegistrationAttempts.setModel(new SpinnerNumberModel(Integer.valueOf(ProjectManager.get("maxRegisterAttempts")),new Integer(1),new Integer(1000000),new Integer(1)));
		}
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

 
    private String getStringFromArray(Object[] theArray)
    {
        String currentString = null;
        try
        {
            if(theArray.length!=0)
            {
                currentString = (String)theArray[0];
                for(int i = 1;i<theArray.length;i++)
                {
                    try
                    {
                        currentString = currentString + "," + (String)theArray[i];
                    }
                    catch(NullPointerException e)
                    {
                        if(currentString.endsWith(",")==true)
                        {
                            System.out.println("NullPointerException thrown CurrentString is: " + currentString.substring(0,currentString.lastIndexOf(",")));
                            currentString = currentString.substring(0,currentString.lastIndexOf(","));
                        }
                    }
                }
                return currentString;
            }
        }
        catch(Exception e)
        {
            if(currentString!=null)
            {
                if(currentString.endsWith(",")==false)
                {
                    return currentString;
                }
                else
                {
                    System.out.println("Exception thrown CurrentString is: " + currentString.substring(0,currentString.lastIndexOf(",")));
                    return currentString.substring(0,currentString.lastIndexOf(","));
                }
            }
        }
        return "";
    }   

    private Object[] getStringArraysFromString(String textArrayString)
    {
        ArrayList aryList = new ArrayList();
        String tempString = "";
        while(textArrayString.indexOf(",")!=-1)
        {
            tempString = textArrayString.substring(0,textArrayString.indexOf(","));
            textArrayString = textArrayString.substring(textArrayString.indexOf(",") + 1);
            aryList.add(tempString);
        }
        aryList.add(textArrayString);
        return aryList.toArray();
    }    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        RegistrationSettingsPanelItem = new javax.swing.JPanel();
        lFiller12 = new javax.swing.JLabel();
        lSoftwareTitle1 = new javax.swing.JLabel();
        lFiller20 = new javax.swing.JLabel();
        btnApplyEvaluationUnlockCode = new javax.swing.JButton();
        lFiller13 = new javax.swing.JLabel();
        tfSoftwareTitle1 = new javax.swing.JTextField();
        lFiller18 = new javax.swing.JLabel();
        btnGenerateEvaluationUnlockCode = new javax.swing.JButton();
        lFiller14 = new javax.swing.JLabel();
        ProjectInformationTopPanel4 = new javax.swing.JPanel();
        lFiller15 = new javax.swing.JLabel();
        lSoftwareTitle2 = new javax.swing.JLabel();
        lFiller16 = new javax.swing.JLabel();
        lFiller17 = new javax.swing.JLabel();
        spinMaxRegistrationAttempts = new JSpinner(new SpinnerNumberModel(new Integer(10),new Integer(1),new Integer(1000000),new Integer(1)));

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        setBackground(new java.awt.Color(140, 160, 210));
        RegistrationSettingsPanelItem.setLayout(new javax.swing.BoxLayout(RegistrationSettingsPanelItem, javax.swing.BoxLayout.X_AXIS));

        RegistrationSettingsPanelItem.setBackground(new java.awt.Color(140, 160, 210));
        RegistrationSettingsPanelItem.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        RegistrationSettingsPanelItem.setMinimumSize(new java.awt.Dimension(300, 30));
        RegistrationSettingsPanelItem.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller12.setBackground(new java.awt.Color(140, 160, 210));
        lFiller12.setText("   ");
        lFiller12.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller12.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller12.setPreferredSize(new java.awt.Dimension(10, 16));
        RegistrationSettingsPanelItem.add(lFiller12);

        lSoftwareTitle1.setBackground(new java.awt.Color(140, 160, 210));
        lSoftwareTitle1.setFont(new java.awt.Font("Arial", 0, 12));
        lSoftwareTitle1.setText("Software Evaluation Unlock Code:");
        lSoftwareTitle1.setMaximumSize(new java.awt.Dimension(225, 15));
        lSoftwareTitle1.setMinimumSize(new java.awt.Dimension(225, 15));
        lSoftwareTitle1.setPreferredSize(new java.awt.Dimension(225, 15));
        RegistrationSettingsPanelItem.add(lSoftwareTitle1);

        lFiller13.setBackground(new java.awt.Color(140, 160, 210));
        lFiller13.setText("   ");
        lFiller13.setMaximumSize(new java.awt.Dimension(300, 15));
        lFiller13.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller13.setPreferredSize(new java.awt.Dimension(10, 16));
        RegistrationSettingsPanelItem.add(lFiller13);

        tfSoftwareTitle1.setFont(new java.awt.Font("Arial", 0, 12));
        tfSoftwareTitle1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfSoftwareTitle1.setText("<Undefined Serial Number>");
        tfSoftwareTitle1.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfSoftwareTitle1.setMinimumSize(new java.awt.Dimension(150, 20));
        tfSoftwareTitle1.setPreferredSize(new java.awt.Dimension(450, 20));
        RegistrationSettingsPanelItem.add(tfSoftwareTitle1);

        lFiller18.setBackground(new java.awt.Color(140, 160, 210));
        lFiller18.setMaximumSize(new java.awt.Dimension(5, 15));
        lFiller18.setMinimumSize(new java.awt.Dimension(5, 16));
        lFiller18.setPreferredSize(new java.awt.Dimension(5, 16));
        RegistrationSettingsPanelItem.add(lFiller18);

        btnGenerateEvaluationUnlockCode.setMaximumSize(new java.awt.Dimension(85, 25));
        btnGenerateEvaluationUnlockCode.setMinimumSize(new java.awt.Dimension(85, 25));
        btnGenerateEvaluationUnlockCode.setPreferredSize(new java.awt.Dimension(85, 25));
        btnGenerateEvaluationUnlockCode.setFont(new java.awt.Font("Arial", 0, 12));
        btnGenerateEvaluationUnlockCode.setText("Generate");
        btnGenerateEvaluationUnlockCode.setMnemonic('G');
        btnGenerateEvaluationUnlockCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateEvaluationUnlockCodeActionPerformed(evt);
            }
        });

        RegistrationSettingsPanelItem.add(btnGenerateEvaluationUnlockCode);
        lFiller14.setBackground(new java.awt.Color(175, 190, 241));
        lFiller14.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller14.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller14.setPreferredSize(new java.awt.Dimension(10, 16));
        RegistrationSettingsPanelItem.add(lFiller14);

      
        add(RegistrationSettingsPanelItem);

        ProjectInformationTopPanel4.setLayout(new javax.swing.BoxLayout(ProjectInformationTopPanel4, javax.swing.BoxLayout.X_AXIS));

        ProjectInformationTopPanel4.setBackground(new java.awt.Color(140, 160, 210));
        ProjectInformationTopPanel4.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectInformationTopPanel4.setMinimumSize(new java.awt.Dimension(300, 30));
        ProjectInformationTopPanel4.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller15.setBackground(new java.awt.Color(140, 160, 210));
        lFiller15.setText("   ");
        lFiller15.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller15.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller15.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectInformationTopPanel4.add(lFiller15);

        lSoftwareTitle2.setBackground(new java.awt.Color(140, 160, 210));
        lSoftwareTitle2.setFont(new java.awt.Font("Arial", 0, 12));
        lSoftwareTitle2.setText("Maximum Registration Attempts Lockout:");
        lSoftwareTitle2.setMaximumSize(new java.awt.Dimension(235, 15));
        lSoftwareTitle2.setMinimumSize(new java.awt.Dimension(235, 15));
        lSoftwareTitle2.setPreferredSize(new java.awt.Dimension(235, 15));
        ProjectInformationTopPanel4.add(lSoftwareTitle2);

        lFiller16.setBackground(new java.awt.Color(140, 160, 210));
        lFiller16.setText("   ");
        lFiller16.setMaximumSize(new java.awt.Dimension(300, 15));
        lFiller16.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller16.setPreferredSize(new java.awt.Dimension(10, 16));

        spinMaxRegistrationAttempts.setMaximumSize(new java.awt.Dimension(40, 20));
        spinMaxRegistrationAttempts.setMinimumSize(new java.awt.Dimension(40, 20));
        spinMaxRegistrationAttempts.setPreferredSize(new java.awt.Dimension(40, 20));
        ProjectInformationTopPanel4.add(spinMaxRegistrationAttempts);

        ProjectInformationTopPanel4.add(lFiller16);

        lFiller17.setBackground(new java.awt.Color(140, 160, 210));
        lFiller17.setText("   ");
        lFiller17.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller17.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller17.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectInformationTopPanel4.add(lFiller17);

        btnApplyEvaluationUnlockCode.setMaximumSize(new java.awt.Dimension(85, 25));
        btnApplyEvaluationUnlockCode.setMinimumSize(new java.awt.Dimension(85, 25));
        btnApplyEvaluationUnlockCode.setPreferredSize(new java.awt.Dimension(85, 25));
        btnApplyEvaluationUnlockCode.setFont(new java.awt.Font("Arial", 0, 12));
        btnApplyEvaluationUnlockCode.setMnemonic('l');
        btnApplyEvaluationUnlockCode.setText("Apply");
        btnApplyEvaluationUnlockCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyEvaluationUnlockCodeActionPerformed(evt);
            }
        });

        ProjectInformationTopPanel4.add(btnApplyEvaluationUnlockCode);

        lFiller20.setBackground(new java.awt.Color(175, 190, 241));
        lFiller20.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller20.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller20.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectInformationTopPanel4.add(lFiller20);

        add(ProjectInformationTopPanel4);

    }//GEN-END:initComponents

    private void btnApplyEvaluationUnlockCodeActionPerformed(java.awt.event.ActionEvent evt) {
	try
	{
	  getDataUpdate();
	  parentObj.getConfigurationPanelUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

    private void btnGenerateEvaluationUnlockCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateEvaluationUnlockCodeActionPerformed
	try
	{
           tfSoftwareTitle1.setText("777" + "-" + String.valueOf(ProjectManager.getRandomInt(999999998)) + "-" + String.valueOf(ProjectManager.getRandomInt(999999999)));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_btnGenerateEvaluationUnlockCodeActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ProjectInformationTopPanel4;
    private javax.swing.JPanel RegistrationSettingsPanelItem;
    private javax.swing.JButton btnApplyEvaluationUnlockCode;
    private javax.swing.JButton btnGenerateEvaluationUnlockCode;
    private javax.swing.JLabel lFiller12;
    private javax.swing.JLabel lFiller13;
    private javax.swing.JLabel lFiller14;
    private javax.swing.JLabel lFiller15;
    private javax.swing.JLabel lFiller16;
    private javax.swing.JLabel lFiller17;
    private javax.swing.JLabel lFiller18;
    private javax.swing.JLabel lFiller20;
    private javax.swing.JLabel lSoftwareTitle1;
    private javax.swing.JLabel lSoftwareTitle2;
    private javax.swing.JTextField tfSoftwareTitle1;
    private javax.swing.JSpinner spinMaxRegistrationAttempts;
    // End of variables declaration//GEN-END:variables

    EADesignerRegistrationPanel parentObj = null;
    public void setMasterStatusController(EADesignerRegistrationPanel parentObject)
    {
        parentObj = parentObject;
    }
}
