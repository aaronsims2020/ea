/*
 * RegistrationFailedAction.java
 *
 * Created on October 26, 2003, 12:24 PM
 */

package com.trinity.ea.actions;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2003-2004 Trinity Software. All rights reserved.
 */
public class RegistrationFailedAction 
{
    
    /** Creates a new instance of RegistrationFailedAction */
    public RegistrationFailedAction() 
    {
        // TODO: Command Line implementation
        // TODO: MIDP implementation
        // Trial Expired
        //System.out.println("Attempting to read property expired action. ");
        if(EncryptedRuleReader.get("enterRegistrationCodeAction")!=null)
        {
            try
            {
                JOptionPane.showMessageDialog(new JFrame(),EncryptedRuleReader.get("registrationFailedActionMessage"));
               
                Class.forName(EncryptedRuleReader.get("enterRegistrationCodeAction")).newInstance();
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
