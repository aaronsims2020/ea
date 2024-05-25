/*
 * WillNotCompleteAction.java
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
                    new MessageDialog(EncryptedUpdateReader.get("msgsupport")).show();                    
                }
                else
                {
                    if(EncryptedRuleReader.getLocaleString("autoUpdateNotAbleToComplete")!=null)
                    {
                        if(EncryptedRuleReader.getLocaleString("autoUpdateNotAbleToComplete").equalsIgnoreCase("")==false)
                        {
                            new MessageDialog(EncryptedRuleReader.getLocaleString("autoUpdateNotAbleToComplete")).show(); 
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
                    if(EncryptedRuleReader.getLocaleString("autoUpdateNotAbleToComplete")!=null)
                    {
                        if(EncryptedRuleReader.getLocaleString("autoUpdateNotAbleToComplete").equalsIgnoreCase("")==false)
                        {
                            new MessageDialog(EncryptedRuleReader.getLocaleString("autoUpdateNotAbleToComplete")).show(); 
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
            if(EncryptedRuleReader.getLocaleString("autoUpdateNotAbleToComplete")!=null)
            {
                if(EncryptedRuleReader.getLocaleString("autoUpdateNotAbleToComplete").equalsIgnoreCase("")==false)
                {
                    new MessageDialog(EncryptedRuleReader.getLocaleString("autoUpdateNotAbleToComplete")).show(); 
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
