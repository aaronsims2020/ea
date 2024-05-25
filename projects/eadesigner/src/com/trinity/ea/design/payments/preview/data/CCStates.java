/*
 * CCStates.java
 *
 * Created on October 28, 2003, 5:57 PM
 */

package com.trinity.ea.design.payments.preview.data;
import java.util.*;
import java.io.*;
/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class CCStates 
{
 Map stateMap = new HashMap();
       
    /** Creates a new instance of CCStates */
    public CCStates() 
    {
        try
        {
            stateMap.put("INT","INT");
            stateMap.put("Alabama","AL");
            stateMap.put("Alaska","AK");
            stateMap.put("Arizona","AZ");
            stateMap.put("Arkansas","AR");
            stateMap.put("California","CA");
            stateMap.put("Colorado","CO");
            stateMap.put("Connecticut","CT");
            stateMap.put("Delaware","DE");
            stateMap.put("DC","DC");
            stateMap.put("Florida","FL");
            stateMap.put("Georgia","GA");
            stateMap.put("Hawaii","HI");
            stateMap.put("Iowa","IA");
            stateMap.put("Idaho","ID");
            stateMap.put("Illinois","IL");
            stateMap.put("Indiana","IN");
            stateMap.put("Kansas","KS");
            stateMap.put("Kentucky","KY");
            stateMap.put("Louisiana","LA");
            stateMap.put("Massachusetts","MA");
            stateMap.put("Maryland","MD");
            stateMap.put("Maine","ME");
            stateMap.put("Michigan","MN");
            stateMap.put("Mississippi","MI");
            stateMap.put("Missouri","MO");
            stateMap.put("Montana","MT");
            stateMap.put("North Carolina","NC");
            stateMap.put("North Dakota","ND");
            stateMap.put("Nebraska","NE");
            stateMap.put("New Hampshire","NH");
            stateMap.put("New Jersey","NJ");
            stateMap.put("New Mexico","NM");
            stateMap.put("Nevada","NV");
            stateMap.put("New York","NY");
            stateMap.put("Oklahoma","OK");
            stateMap.put("Oregon","OR");
            stateMap.put("Ohio","OH");
            stateMap.put("Pennsylvania","PA");
            stateMap.put("Rhode Island","RI");
            stateMap.put("South Carolina","SC");
            stateMap.put("South Dakota","SD");
            stateMap.put("Tennessee","TN");
            stateMap.put("Texas","TX");
            stateMap.put("Utah","UT");
            stateMap.put("Virginia","VA");
            stateMap.put("Vermont","VT");
            stateMap.put("Washington","WA");
            stateMap.put("Wisconsin","WI");
            stateMap.put("West Virginia","WV");
            stateMap.put("Wyoming","WY");
        }
        catch(Exception e)
        {
            
        }
    }
    /** Return the State Abbreviation for Credit Card Processing.
     * @return
     * @param State
     */
    public String getStateID(String State)
    {
        try
        {
            return (String)stateMap.get(State);
        }
        catch(Exception e)
        {
            return null;
        }
    }
}
