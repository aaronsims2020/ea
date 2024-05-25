/*
 * RuleEvaluater.java
 *
 * Created on July 13, 2004, 5:14 PM
 */

package com.trinity.ea.rules.reader;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import java.util.ArrayList;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class RuleEvaluator 
{
    private final static char ZERO = '0';
    private final static char ONE = '1';  
    private final static char TWO = '2';  
    private final static char THREE = '3';
    private final static char FOUR = '4';  
    private final static char FIVE = '5';   
    private final static char SIX = '6';  
    private final static char SEVEN = '7';  
    private final static char EIGHT = '8';
    private final static char NINE = '9';  
    private final static char DECIMAL = '.';  
    private final static char UNDERSCORE = '_';       
    private final static char LESS_THAN = '<';
    private final static char GREATER_THAN = '>';  
    private final static char EQUALS = '=';  
    
    /** Creates a new instance of RulesEvaluater */
    public RuleEvaluator() 
    {
    }
    public final static synchronized boolean currentJavaVersionIsEqual(String javaVersion)
    {   
        try
        {
            if(getVersionResult(javaVersion)==EQUALS)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(Exception e)
        {
            return false;
        }
    }
    public final static synchronized boolean currentJavaVersionIsGreater(String javaVersion)
    {   
        try
        {
            if(getVersionResult(javaVersion)==LESS_THAN)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(Exception e)
        {
            return false;
        }      
    }
    public final static synchronized boolean currentJavaVersionIsLess(String javaVersion)
    {   
        try
        {
            if(getVersionResult(javaVersion)==GREATER_THAN)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(Exception e)
        {
            return false;
        }     
    }  
    public final static synchronized boolean currentJavaVersionIsLessOrEqual(String javaVersion)
    {   
        try
        {
            char comparatorChar = getVersionResult(javaVersion);
            if(comparatorChar==GREATER_THAN || comparatorChar==EQUALS)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(Exception e)
        {
            return false;
        }       
    }   
    
    public final static synchronized boolean currentJavaVersionIsGreaterOrEqual(String javaVersion)
    {   
        try
        {
            char comparatorChar = getVersionResult(javaVersion);
            if(comparatorChar==LESS_THAN || comparatorChar==EQUALS)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(Exception e)
        {
            return false;
        }       
    }     
        
    private final static synchronized char getVersionResult(String ver)
    {
        Object[] currentVersion = getVersionArray(EncryptedRuleReader.getJavaVersion());
        Object[] comparatorVersion = getVersionArray(ver);       
        if(currentVersion.length<comparatorVersion.length)
        {
            for(int i = 0;i<currentVersion.length;i++)
            {
                if(((Integer)currentVersion[i]).intValue()<((Integer)comparatorVersion[i]).intValue())
                {
                    return GREATER_THAN;
                }
                else if(((Integer)currentVersion[i]).intValue()>((Integer)comparatorVersion[i]).intValue())
                {
                    return LESS_THAN;
                }                
            }
            return GREATER_THAN;
        }
        else if(currentVersion.length>comparatorVersion.length)
        {
            for(int i = 0;i<comparatorVersion.length;i++)
            {
                if(((Integer)currentVersion[i]).intValue()<((Integer)comparatorVersion[i]).intValue())
                {
                    return GREATER_THAN;
                }
                else if(((Integer)currentVersion[i]).intValue()>((Integer)comparatorVersion[i]).intValue())
                {
                    return LESS_THAN;
                }               
            }     
            return LESS_THAN;            
        }
        else
        {
            //equal length arrays
            for(int i = 0;i<comparatorVersion.length;i++)
            {
                 if(((Integer)currentVersion[i]).intValue()<((Integer)comparatorVersion[i]).intValue())
                {
                    return GREATER_THAN;
                }
                else if(((Integer)currentVersion[i]).intValue()>((Integer)comparatorVersion[i]).intValue())
                {
                    return LESS_THAN;
                }                
            }         
            return EQUALS;
        }                
    }
    
    private final static Object[] getVersionArray(String ver)
    {
        char[] charArray = ver.toCharArray();
        String sum = "";
        ArrayList tempList = new ArrayList();
        for(int i = 0;i<charArray.length;i++)
        {  
             if(ZERO<=((int)charArray[i]) && NINE>=((int)charArray[i]))
             {
                 sum = sum + String.valueOf(charArray[i]);
             }
             else
             {
                 if(sum.equalsIgnoreCase("")==false)
                 {
                     try
                     {
                        tempList.add(new Integer(sum));
                     }
                     catch(Exception e)
                     {
                         e.printStackTrace();
                     }
                     sum = "";
                 }
             }
        }    
        tempList.trimToSize();
        return tempList.toArray();
    }
        
}
