/*
 * GRCreateAccount.java
 *
 * Created on June 9, 2004, 7:22 PM
 */

package com.trinity.ea.design.optin.provider.panels.gr;
import java.net.URL;
import java.net.MalformedURLException;
import com.trinity.ea.net.WebConnectionRequest;
import com.trinity.ea.parser.HTTPGETRequestParser;
import javax.swing.JOptionPane;
import java.net.URLEncoder;
import java.util.Map;
import javax.swing.text.Document;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class GRCreateAccount {
    
    /** Creates a new instance of GRCreateAccount */
    public GRCreateAccount() 
    {
        
    }
    /** Return String[<Return Code>,<Description>,<Result>] */
    public String[] createAccount(String strActionURL, String loginID, String strFirstAndLastName, String strEMail)
    {
        String theRequest = null;
        URL theURL1 = null;
        if(validateData(strActionURL, loginID, strFirstAndLastName, strEMail)==true)
        {
            try
            {
                 theRequest = strActionURL + "/" + URLEncoder.encode(loginID,"UTF-8") + "/" + URLEncoder.encode(strFirstAndLastName,"UTF-8") + "/" + URLEncoder.encode(strEMail,"UTF-8") + "/";
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }    
            try
            {
                theURL1 = new URL(theRequest);
            }
            catch(MalformedURLException e)
            {
                e.printStackTrace();
            }
            try
            {
                WebConnectionRequest wcr = new WebConnectionRequest();
                Map responseDataMap = wcr.doWebGetRequest(theURL1);
                if(responseDataMap!=null)
                {               
                    if(responseDataMap.get("document")!=null)
                    {
                        String doc = (String)responseDataMap.get("document");//doc.getText(0, doc.getLength())
                        //System.out.println("The HTML Document String: " + doc);
                        String retCode = doc.substring(doc.indexOf("[ErrorCode]")+15, doc.indexOf("[ErrorDescription]"));
                        String retCodeDescription = doc.substring(doc.indexOf("[ErrorDescription]")+22, doc.indexOf("[Result]"));                
                        String retResult = doc.substring(doc.indexOf("[Result]") + 12, doc.lastIndexOf(")"));
                        String[] theStrArray2 = {retCode, retCodeDescription, retResult};
                        return theStrArray2;
                    }
                    else
                    {
                       String[] theStrArray2 = {String.valueOf(6), "", ""};
                       return theStrArray2;                   
                    }
                }
                else
                {
                   String[] theStrArray2 = {String.valueOf(6), "", ""};
                   return theStrArray2;                   
                }                
            }
            catch(Exception eeeee)
            {
                //System.out.println(eeeee);
                eeeee.printStackTrace();
                //skip this, becuase it is currently thrown by the ResponseMap Objects when not connected to the internet, or server. Fix the logic and error handling later on. 
            }
        }
        else 
        {
            String[] theStrArray2 = {String.valueOf(4), "", ""};
            return theStrArray2;
        }
        String[] theStrArray2 = {String.valueOf(5), "", ""};
        return theStrArray2;
    }
    
    private boolean validateData(String strActionURL, String loginID, String strFirstAndLastName, String strEMail)
    {
         // EMail Validation Code
        try
        {
            if(strFirstAndLastName.equals("")==true)
            {
                JOptionPane.showMessageDialog(null,"Please Enter Your Name.");
                //tfName.grabFocus();
                return false;                
            }
        }
        catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null,"Please Enter Your Name.");
            //tfName.grabFocus();
            return false;            
        }
        try
        {
            if(strEMail.indexOf("@") == -1)
            {
                System.out.println("@ missing, EMail address is: " + strEMail);
                JOptionPane.showMessageDialog(null,"Please Enter a Valid Email Address.");
                //tfEMail.grabFocus();
                return false;               
            }
            else if(strEMail.indexOf(".") == -1)
            {
                 System.out.println(". missing");               
                JOptionPane.showMessageDialog(null,"Please Enter a Valid Email Address.");
                //tfEMail.grabFocus();
                return false;               
            }
        }
        catch(NullPointerException e)
        {
            System.out.println("Exception thrown.");
            JOptionPane.showMessageDialog(null,"Please Enter Your Email Address.");
            //tfEMail.grabFocus();
            return false;           
        }
        return true;
    }   
}
