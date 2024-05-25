/*
 * EnterRegistrationCodeAction.java
 *
 * Created on October 25, 2003, 4:49 PM
 */

package com.trinity.ea.design.payments.actions;
import com.trinity.ea.design.payments.preview.PaymentProcessingDialog;
import com.trinity.ea.design.common.file.ProjectManager;
import javax.swing.UIManager;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class BuyNowAction 
{
     
    /** Creates a new instance of EnterRegistrationCodeAction */
    public BuyNowAction() 
    {
   	try
   	{
		if(ProjectManager.get("LAndFPackage")!=null)
		{
			if(ProjectManager.get("LAndFPackage").equalsIgnoreCase("system")==true)
			{			
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
			else
			{
				UIManager.setLookAndFeel(ProjectManager.get("LAndFPackage"));
			}
		}
   	}
   	catch (Exception e)
   	{
      	System.out.println("Could not set System Look and Feel.");
   	}
        new PaymentProcessingDialog(new javax.swing.JFrame(), true).show();
    }
    
}
