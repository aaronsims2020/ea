/*
 * PaymentFailedUIAction.java
 *
 * Created on November 4, 2003, 2:31 AM
 */

package com.trinity.ea.design.payments.actions;
import com.trinity.ea.design.payments.preview.dlgCustomerBillingResponsePanelFailure;
import com.trinity.ea.design.common.file.ProjectManager;
import java.util.Map;
import java.util.HashMap;
import javax.swing.*;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class PaymentFailedUIAction 
{
    
    /** Creates a new instance of PaymentFailedUIAction */
    public PaymentFailedUIAction() 
    {
	Map tempMap = new HashMap();
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
            if(ProjectManager.get("paymentGenericAuthResponseFailureMsg")!=null)
            {                        
                tempMap.put("respInputAuthResponse",ProjectManager.get("paymentGenericAuthResponseFailureMsg"));
            }
            tempMap.put("respInputOrderID","77787337827881");
            tempMap.put("respInputCardName","Preview User");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	new dlgCustomerBillingResponsePanelFailure(tempMap,new javax.swing.JFrame(), true).setIsFailurePreview(true).show();
    }
    
}
