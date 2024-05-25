/*
 * LaunchApplicationAction.java
 *
 * Created on July 21, 2004, 1:34 AM
 */

package com.trinity.ea.actions;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import com.trinity.ea.actions.LaunchApplicationAction;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class LaunchApplicationSkipAction 
{
    /** Creates a new instance of LaunchApplicationAction */
    public LaunchApplicationSkipAction() 
    {
        // TODO: Command Line implementation
        // TODO: MIDP implementation
        // Trial Expired
        LaunchApplicationAction.setSkipUpdate(true);
        new LaunchApplicationAction();
    }
}
