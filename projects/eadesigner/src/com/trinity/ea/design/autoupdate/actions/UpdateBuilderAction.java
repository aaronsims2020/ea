/*
 *  UpdateBuilderAction.java
 *
 * Created on March 17, 2004, 2:28 PM
 */

package com.trinity.ea.design.autoupdate.actions;
import com.trinity.ea.design.autoupdate.builder.UpdateBuilder;
import javax.swing.JFrame;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class UpdateBuilderAction 
{
    
    /** Creates a new instance of  new MessageBuilder().show(); */
    public UpdateBuilderAction() 
    {
        try
        {
            new UpdateBuilder().show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }       
    }
    
}
