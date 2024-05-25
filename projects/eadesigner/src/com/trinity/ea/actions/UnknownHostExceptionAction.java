/*
 * UnknownHostExceptionAction.java
 *
 * Created on October 29, 2003, 12:40 AM
 */

package com.trinity.ea.actions;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import com.trinity.ea.forms.gui.swing.ErrorDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class UnknownHostExceptionAction 
{
    
    /** Creates a new instance of AttemptPaymentTransactionAction */
    public UnknownHostExceptionAction() 
    {
        try
        {
            getMessage(EncryptedRuleReader.getLocaleString("msgMsgTitle"),EncryptedRuleReader.getLocaleString("unknownHostException"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
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
            JOptionPane.showMessageDialog(null,error,title,JOptionPane.INFORMATION_MESSAGE);
        }
    }           
}
