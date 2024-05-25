/*
 * RegistrationCompleteFinishedAction.java
 *
 * Created on October 28, 2003, 05:00 PM
 */
package com.trinity.ea.actions;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import com.trinity.ea.forms.gui.swing.ErrorDialog;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class RegistrationCompleteFinishedAction 
{
    
    /** Creates a new instance of RegistrationCompleteFinishedAction */
    public RegistrationCompleteFinishedAction() 
    {
	try
	{
		if(EncryptedRuleReader.get("registrationRestartAtReg")!=null)
		{
			if(EncryptedRuleReader.get("registrationRestartAtReg").equalsIgnoreCase("true")==true)
			{
      	  		getMessage(EncryptedRuleReader.getLocaleString("msgMsgTitle"),EncryptedRuleReader.getLocaleString("paymentSucceededActionMessage"));
			}
			else
			{	
				getStartApp();
			}
		}
		else
		{
			getStartApp();
		}
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
            System.exit(0);
        }
        else
        {
            JOptionPane.showMessageDialog(new JFrame(),error,title,JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }    

    private void getStartApp()
    {
        // TODO: Command Line implementation
        // TODO: MIDP implementation
        // Registration Successful
        if(EncryptedRuleReader.get("launchApplicationAction")!=null)
        {
            try
            {
                Class.forName(EncryptedRuleReader.get("launchApplicationAction")).newInstance();
            }
            catch(InstantiationException e)
            {
                System.out.println(e);
            }   
            catch(IllegalAccessException e)
            {
                System.out.println(e);
            }                      
            catch(ClassNotFoundException e)
            {
                System.out.println(e);
            }       
        }
        else
        {
            //Problem in Properties File
        }
	}   
}
