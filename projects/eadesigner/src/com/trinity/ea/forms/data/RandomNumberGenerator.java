/*
 * RandomNumberGenerator.java
 *
 * Created on October 29, 2003, 12:51 AM
 */

package com.trinity.ea.forms.data;
import java.util.*;
/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class RandomNumberGenerator 
{
    /** Creates a new instance of RandomNumberGenerator */
    public RandomNumberGenerator() 
    {
     
    }
    public static int getRandomNumber()
    {
        try
        {
            Random random = new Random(); 
            int retInt = random.nextInt();
            if(String.valueOf(retInt).charAt(0)=='-')
            {
                return new Integer(String.valueOf(retInt).substring(1)).intValue();
            }
            return retInt;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return 0;
    }
    public static long getRandomLong()
    {
        try
        {        
            Random random = new Random();
            long retLong = random.nextLong();
            if(String.valueOf(retLong).charAt(0)=='-')
            {
                return new Long(String.valueOf(retLong).substring(1)).intValue();
            }
            return retLong;           
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return 0;       
    }    
}
