/*
 * LockedOutAction.java
 *
 * Created on November 4, 2003, 2:08 AM
 */

package com.trinity.ea.actions;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import com.trinity.ea.forms.gui.swing.ErrorDialog;
import javax.swing.JOptionPane;
import javax.swing.JDialog;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class LockedOutAction 
{
    
    /** Creates a new instance of LockedOutAction */
    public LockedOutAction() 
    {
        try
        {
            getMessage(EncryptedRuleReader.getLocaleString("msgMsgTitle"),EncryptedRuleReader.getLocaleString("evalLockdown"));
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
            JOptionPane.showMessageDialog(new JDialog(),error,title,JOptionPane.INFORMATION_MESSAGE);
        }
    }        
}
