/*
 * PasswordGenerator.java
 *
 * Created on May 21, 2004, 10:02 PM
 */

package com.trinity.ea.design.common.util;
import java.util.Random;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class PasswordGenerator {
     
    /** Creates a new instance of PasswordGenerator */
    public PasswordGenerator() {
    }
 
  public static String generate(int length)
  {
    StringBuffer s = new StringBuffer();
    Random r = new Random(System.currentTimeMillis());
    for( int i=0; i < length; i++)
    {
        char c;
        int p = r.nextInt(62);//+1;
        if(p<26)
        {
            c = (char)(p + (int)'a');
        }
        else if(p<52)
        {
            c = (char)(p - 26 + (int)'A');
        }
        else
        {
            c = (char)(p-53 +(int)'1');
        }
        s.append(c);
    }
    return s.toString();
  }  
}
