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
 * Copyright �2003-2004 Trinity Software. All rights reserved.
 */
public class RandomNumberGenerator 
{
    /** Creates a new instance of RandomNumberGenerator */
    public RandomNumberGenerator() 
    {
     
    }
    public static int getRandomNumber()
    {
        Random random = new Random();
        return random.nextInt();
    }
}
