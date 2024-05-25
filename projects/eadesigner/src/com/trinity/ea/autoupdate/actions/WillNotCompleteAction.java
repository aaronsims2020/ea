/*
 * WillNotCompleteAction.java
 *
 * Created on July 19, 2004, 1:15 AM
 */

package com.trinity.ea.autoupdate.actions;
import com.trinity.ea.autoupdate.reader.EncryptedUpdateReader;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import com.trinity.ea.autoupdate.messaging.MessageDialog;
import com.trinity.ea.forms.gui.swing.ErrorDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class WillNotCompleteAction 
{
    /** Creates a new instance of ErrorMessageAction */
    public WillNotCompleteAction() 
    {
        try
        { 
            if(EncryptedUpdateReader.get("msgsupport")!=null)
            {
                if(EncryptedUpdateReader.get("msgsupport").equalsIgnoreCase("")==false)
                {  
                    getMessage(EncryptedUpdateReader.get("msgtitle"), EncryptedUpdateReader.get("msgsupport"));                    
                }
                else
                {
                    if(EncryptedRuleReader.getLocaleString("autoUpdateNotAbleToComplete")!=null)
                    {
                        if(EncryptedRuleReader.getLocaleString("autoUpdateNotAbleToComplete").equalsIgnoreCase("")==false)
                        {
                            getMessage("", EncryptedRuleReader.getLocaleString("autoUpdateNotAbleToComplete")); 
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
                    if(EncryptedRuleReader.getLocaleString("autoUpdateNotAbleToComplete")!=null)
                    {
                        if(EncryptedRuleReader.getLocaleString("autoUpdateNotAbleToComplete").equalsIgnoreCase("")==false)
                        {
                           getMessage(EncryptedUpdateReader.get("msgtitle"), EncryptedRuleReader.getLocaleString("autoUpdateNotAbleToComplete")); 
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
            if(EncryptedRuleReader.getLocaleString("autoUpdateNotAbleToComplete")!=null)
            {
                if(EncryptedRuleReader.getLocaleString("autoUpdateNotAbleToComplete").equalsIgnoreCase("")==false)
                {
                    getMessage(EncryptedUpdateReader.get("msgtitle"),EncryptedRuleReader.getLocaleString("autoUpdateNotAbleToComplete")); 
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
