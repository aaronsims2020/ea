/*
 * PaymentSuccessUIAction.java
 *
 * Created on November 4, 2003, 2:31 AM
 */

package com.trinity.ea.design.payments.actions;
import com.trinity.ea.design.payments.preview.dlgCustomerBillingResponsePanelSuccess;
import com.trinity.ea.design.common.file.ProjectManager;
import javax.swing.*;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class PaymentSuccessUIAction {
    Map tempMap = new HashMap();

    /** Creates a new instance of PaymentSuccessUIAction */
    public PaymentSuccessUIAction() 
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
	try
	{
           tempMap.put("respInputNameonCard","Preview User");
           tempMap.put("respInputEmail","previewuser@evaluateanywhere.com");
        
            if(ProjectManager.get("product_price")!=null)
            {               
           		tempMap.put("respInputTotal",ProjectManager.get("product_price"));
            }
            if(ProjectManager.get("paymentGenericAuthResponseSuccessMsg")!=null)
            {                        
                tempMap.put("respInputAuthResponse",ProjectManager.get("paymentGenericAuthResponseSuccessMsg"));
            }
            tempMap.put("respInputOrderID","77787337827881");
            tempMap.put("respInputCardName","Preview User");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
        new dlgCustomerBillingResponsePanelSuccess(tempMap,new javax.swing.JFrame(), true).show();
    }
    
}
