/*
 * RegistrationSucceededAction.java
 *
 * Created on October 26, 2003, 12:21 PM
 */

package com.trinity.ea.actions;
import javax.swing.*;
import java.awt.*;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2003-2004 Trinity Software. All rights reserved.
 */
public class RegistrationSucceededAction 
{
    
    /** Creates a new instance of RegistrationSucceededAction */
    public RegistrationSucceededAction() 
    {
        // TODO: Command Line implementation
        // TODO: MIDP implementation
        // Trial Expired
        JOptionPane.showMessageDialog(new JFrame(),EncryptedRuleReader.get("registrationSucceededActionMessage"));
        System.exit(0);
    }    
   
}
