/*
 * OptinAction.java
 *
 * Created on November 16, 2003, 12:00 AM
 */

package com.trinity.ea.actions;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import javax.swing.*;
import java.awt.*;
import com.trinity.ea.forms.optin.*;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2003-2004 Trinity Software. All rights reserved.
 */
public class OptinAction {
    
    /** Creates a new instance of OptinAction */
    public OptinAction() 
    {
        // TODO: Command Line implementation
        // TODO: MIDP implementation
        // Trial Expired
        //System.out.println("Attempting to read property expired action. ");
        if(EncryptedRuleReader.get("optinIsEnabled")!=null)
        {
            if(EncryptedRuleReader.get("optinIsEnabled").equalsIgnoreCase("true")==true)
            {
                if(EncryptedRuleReader.get("optinIsOptedIn")!=null)
                {
                    if(EncryptedRuleReader.get("optinIsOptedIn").equalsIgnoreCase("false")==true)
                    {
                        try
                        {

                            dlgEMailOptin theEMail = new dlgEMailOptin(new JFrame(),true);
					theEMail.show();

                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }     
                    }
                }
            }
            else
            {
                try
                {

                    Class.forName(EncryptedRuleReader.get("optinContinueAction")).newInstance();

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
        }
    }
    
}
