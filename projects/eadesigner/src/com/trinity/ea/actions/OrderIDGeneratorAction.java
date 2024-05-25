/*
 * OrderIDGeneratorAction.java
 *
 * Created on May 8, 2004, 5:48 PM
 */

package com.trinity.ea.actions;
import com.trinity.ea.idef.IOrderIDGenerator;
import com.trinity.ea.forms.data.RandomNumberGenerator;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class OrderIDGeneratorAction implements com.trinity.ea.idef.IOrderIDGenerator {
    
    public String getOrderID()
    {
        try
        {
            String theLongString = Long.toString(RandomNumberGenerator.getRandomLong());
            if(theLongString.toCharArray().length<13)
            {
                return theLongString;
            }
            else
            {
                return theLongString.substring(0,12);              
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
