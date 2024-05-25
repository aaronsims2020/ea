/*
 * Trial.java
 *
 * Created on October 15, 2003, 4:20 PM
 */

package com.trinity.ea.util;
import java.util.Date;
import com.trinity.ea.rules.reader.EncryptedRuleReader;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2005 Trinity Software. All rights reserved.
 */
public class Trial 
{
    final private static Date currentDate = new Date();
    /** Creates a new instance of Trial */
    public Trial(){} 

    /** Returns the long length of time alotted in millaseconds of the evaluation. */    
    public final static long getRunTime()
    {
        try
        {
            //EncryptedRuleReader.readPropertiesFile();
            if(EncryptedRuleReader.get("runtimeMillasecondsToExpire")!=null)
            {
                return Long.valueOf(EncryptedRuleReader.get("runtimeMillasecondsToExpire")).longValue();
            }
            else
            {
                return 0;
            }
        }
        catch(Exception e)
        {
            return 0;
        }
        
    }       
    
    
    /** Returns the long time left until the trial expires. 0 is expired. */    
    public final static long getRunTimeBeforeExpiration()
    {
        try
        {
            //EncryptedRuleReader.readPropertiesFile();           
            long installDate = getRuntimeMillasecondsStartTrial();
            long timeToExpiration = Long.valueOf(EncryptedRuleReader.get("runtimeMillasecondsToExpire")).longValue();
            // Check if time is earlier than date file was created, if so product is expired.
            long diff = currentDate.getTime() - installDate;
            //need to read trial period from file
            timeToExpiration = timeToExpiration-diff;
            return timeToExpiration;
        }
        catch(NumberFormatException e)
        {
        }      
        catch(Exception e)
        {
        }
        return 0;
    }  
    
    // Returns the Runtime Millaseconds of the time the trial started, and initializes a new trial period if one has not begun yet.
    private final static long getRuntimeMillasecondsStartTrial()
    {
        try
        {
            if(EncryptedRuleReader.get("runtimeMillasecondsStartTrial")!=null)
            {
                if(EncryptedRuleReader.get("runtimeMillasecondsStartTrial").equalsIgnoreCase(""))
                {
                    if(EncryptedRuleReader.get("allowInternalStartTrialInstanciation").equalsIgnoreCase("true"))
                    {
                        EncryptedRuleReader.startTrial();
                        return Long.valueOf(EncryptedRuleReader.get("runtimeMillasecondsStartTrial")).longValue();
                    }
                    else
                    {
                        //if false return expired here
                        return 0;
                    }
                }
                else
                {
                   return Long.valueOf(EncryptedRuleReader.get("runtimeMillasecondsStartTrial")).longValue();
                }
            }
            else
            {
                if(EncryptedRuleReader.get("allowInternalStartTrialInstanciation").equalsIgnoreCase("true"))
                {
                    EncryptedRuleReader.startTrial();
                    return Long.valueOf(EncryptedRuleReader.get("runtimeMillasecondsStartTrial")).longValue();
                }
                else
                {
                    //if false return expired here
                    return 0;
                }
            }
        }
        catch(Exception e)
         {
            System.out.println(e);
            e.printStackTrace();
        }       
        return 0;
    }
    
    /** Returns boolean is expired. */
    public static boolean isExpired()
    {
        try
        {
            //EncryptedRuleReader.readPropertiesFile();
            long installDate = getRuntimeMillasecondsStartTrial();
            // Check if time is earlier than date file was created, if so product is expired.
            if(currentDate.getTime()>(installDate + Long.valueOf(EncryptedRuleReader.get("runtimeMillasecondsToExpire")).longValue()))
            {
                EncryptedRuleReader.expired();
                return true;
            }
            //Check if is expired.
            else
            {
                    long diff = currentDate.getTime() - installDate;
                    try
                    {
                        //need to read trial period from file
                        if(diff<Long.valueOf(EncryptedRuleReader.get("runtimeMillasecondsToExpire")).longValue())
                        {
                            return false;
                        }
                        else
                        {
                            EncryptedRuleReader.expired();                            
                            return true;
                        }
                    }
                    catch(Exception e)
                    {
                        EncryptedRuleReader.expired();                       
                        return true;
                    }
            }
        }
        catch(NumberFormatException e)
        {
            //System.out.println(e);
            //e.printStackTrace();
        }
        catch(Exception e)
        {
            //System.out.println(e);
            //e.printStackTrace();
        }  
        EncryptedRuleReader.expired();
        return true;
     }

    /** Returns boolean is registered. */
    public final static boolean isRegistered()
    {
        try
        {
		return isReg();
	  }
	  catch(Exception e)
	  {
		return false;
	  }
    }

    // Returns the Runtime Millaseconds of the time the trial started, and initializes a new trial period if one has not begun yet.
    private final static boolean isReg()
    {
        try
        {
            if(EncryptedRuleReader.get("isRegistered").equalsIgnoreCase("true")==true)
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
            //System.out.println(e);
            //e.printStackTrace();
        }  	
	  return false;
    }

 }
