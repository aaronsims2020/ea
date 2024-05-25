/*
 * ErrorMessageAction.java
 *
 * Created on July 19, 2004, 1:15 AM
 */

package com.trinity.ea.autoupdate.actions;
import com.trinity.ea.autoupdate.reader.EncryptedUpdateReader;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import com.trinity.ea.autoupdate.messaging.MessageDialog;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2004 Trinity Software. All rights reserved.
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
                    new MessageDialog(EncryptedUpdateReader.get("msgerror")).show();                    
                }
                else
                {
                    if(EncryptedRuleReader.getLocaleString("autoUpdateErrorMessage")!=null)
                    {
                        if(EncryptedRuleReader.getLocaleString("autoUpdateErrorMessage").equalsIgnoreCase("")==false)
                        {
                            new MessageDialog(EncryptedRuleReader.getLocaleString("autoUpdateErrorMessage")).show(); 
                        }
                        else
                        {
                            new MessageDialog("-1").show(); 
                        }
                    }
                    else
                    {
                        new MessageDialog("-1").show();                         
                    }
                }
            }
            else
            {
                    if(EncryptedRuleReader.getLocaleString("autoUpdateErrorMessage")!=null)
                    {
                        if(EncryptedRuleReader.getLocaleString("autoUpdateErrorMessage").equalsIgnoreCase("")==false)
                        {
                            new MessageDialog(EncryptedRuleReader.getLocaleString("autoUpdateErrorMessage")).show(); 
                        }
                        else
                        {
                            new MessageDialog("-1").show(); 
                        }
                    }
                    else
                    {
                        new MessageDialog("-1").show();                         
                    }
            }
        }
        catch(Exception e)
        {
            if(EncryptedRuleReader.getLocaleString("autoUpdateErrorMessage")!=null)
            {
                if(EncryptedRuleReader.getLocaleString("autoUpdateErrorMessage").equalsIgnoreCase("")==false)
                {
                    new MessageDialog(EncryptedRuleReader.getLocaleString("autoUpdateErrorMessage")).show(); 
                }
                else
                {
                    new MessageDialog("-1").show(); 
                }
            }
            else
            {
                new MessageDialog("-1").show();                         
            }            
        }
    }
}
