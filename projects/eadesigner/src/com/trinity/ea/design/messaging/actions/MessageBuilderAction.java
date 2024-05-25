/*
 *  new MessageBuilder().show();.java
 *
 * Created on March 17, 2004, 2:28 PM
 */

package com.trinity.ea.design.messaging.actions;
import com.trinity.ea.design.messaging.builder.MessageBuilder;
import javax.swing.JFrame;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class MessageBuilderAction 
{
    
    /** Creates a new instance of  new MessageBuilder().show(); */
    public MessageBuilderAction() 
    {
        try
        {
            new MessageBuilder().show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }       
    }
    
}
