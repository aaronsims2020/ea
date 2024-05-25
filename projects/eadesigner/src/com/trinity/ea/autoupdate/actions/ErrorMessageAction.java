/*
 * ErrorMessageAction.java
 *
 * Created on July 19, 2004, 1:15 AM
 */

package com.trinity.ea.autoupdate.actions;
import com.trinity.ea.autoupdate.reader.EncryptedUpdateReader;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import com.trinity.ea.forms.gui.swing.ErrorDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class ErrorMessageAction 
{
    /** Creates a new instance of ErrorMessageAction */
    public ErrorMessageAction() 
    {
        try
        { 
            if(EncryptedUpdateReader.get("msgerror")!=null)
            {
                if(EncryptedUpdateReader.get("msgerror").equalsIgnoreCase("")==false)
                {  
                    getMessage(EncryptedUpdateReader.get("msgtitle"),EncryptedUpdateReader.get("msgerror"));
                }
                else
                {
                    if(EncryptedRuleReader.getLocaleString("autoUpdateErrorMessage")!=null)
                    {
                        if(EncryptedRuleReader.getLocaleString("autoUpdateErrorMessage").equalsIgnoreCase("")==false)
                        {
                           getMessage(EncryptedUpdateReader.get("msgtitle"),EncryptedUpdateReader.get("msgerror"));
                        }
                        else
                        {
                           getMessage("-1","-1");
                        }
                    }
                    else
                    {                          
                        getMessage("-1","-1");                        
                    }
                }
            }
            else
            {
                    if(EncryptedRuleReader.getLocaleString("autoUpdateErrorMessage")!=null)
                    {
                        if(EncryptedRuleReader.getLocaleString("autoUpdateErrorMessage").equalsIgnoreCase("")==false)
                        {
                            getMessage(EncryptedUpdateReader.get("msgtitle"),EncryptedUpdateReader.get("msgerror"));
                        }
                        else
                        {
                            getMessage("-1","-1");
                        }
                    }
                    else
                    {
                        getMessage("-1","-1");                    
                    }
            }
        }
        catch(Exception e)
        {
            if(EncryptedRuleReader.getLocaleString("autoUpdateErrorMessage")!=null)
            {
                if(EncryptedRuleReader.getLocaleString("autoUpdateErrorMessage").equalsIgnoreCase("")==false)
                {
                   getMessage(EncryptedUpdateReader.get("msgtitle"),EncryptedUpdateReader.get("msgerror"));
                }
                else
                {
                     getMessage("-1","-1");
                }
            }
            else
            {
                 getMessage("-1","-1");                        
            }            
        }
    }
    
    private void getMessage(String title, String error)
    {
        boolean isOptionPane = true;
	  if(EncryptedRuleReader.get("btnBarImgButtonsEnabled")!=null)
	  {
	  	if(EncryptedRuleReader.get("btnBarImgButtonsEnabled").equalsIgnoreCase("true")==true)
	  	{
                    isOptionPane = false;
                }
                else
                {
                    isOptionPane = true;
                }
          }
          else
          {
              isOptionPane = true;
          }
        if(isOptionPane==false)
        {
            new ErrorDialog(title,error);
        }
        else
        {
            JOptionPane.showMessageDialog(null,error,title,JOptionPane.ERROR_MESSAGE);
        }
    }
}
