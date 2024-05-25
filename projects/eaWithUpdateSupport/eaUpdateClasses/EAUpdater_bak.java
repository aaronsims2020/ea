/*
 * EvaluateAnywhere.java
 *
 * Renamed to EAUpdater July 19th 2004
 *
 * Created on October 24, 2003, 6:23 PM
 */
package com.trinity.ea.rules.reader;
import com.trinity.ea.util.Trial;
import com.trinity.ea.actions.*;
import com.trinity.ea.rules.reader.EncryptedRuleReader;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class EAUpdater_bak 
{
    //Trial eat = new Trial();/** Creates a new instance of EAUpdater */
    public EAUpdater_bak() 
    {
        try
        {
            if(EncryptedRuleReader.get("isRegistered").equalsIgnoreCase("true")==true)
            {
                launchApp();
            }
            else
            {
                // Time left to evaluate in milliseconds.
                long timeLeftToEvaluate = Trial.getRunTimeBeforeExpiration();
                if (Trial.isExpired()==true)
                {
                    // TODO: Command Line implementation
                    // TODO: MIDP implementation
                    // Trial Expired
                    if(EncryptedRuleReader.get("expiredAction")!=null)
                    {
                        try
                        {
                            Class.forName(EncryptedRuleReader.get("expiredAction")).newInstance();
                        }
                        catch(InstantiationException e)
                        {
                            //System.out.println(e);
                        }   
                        catch(IllegalAccessException e)
                        {
                            //System.out.println(e);
                        }                      
                        catch(ClassNotFoundException e)
                        {
                            //System.out.println(e);
                        }       
                    }
                    else
                    {
                        //System.out.println("The value is null. You lose...");
                        //Problem in Properties File
                        new ConfigurationErrorAction();
                    }
                }
 
                
                
                else
                {
                    // TODO: Command Line implementation
                    // TODO: MIDP implementation
                    // Trial not expired
                    if(EncryptedRuleReader.get("notExpiredAction")!=null)
                    {
                        try
                        {
                            Class.forName(EncryptedRuleReader.get("notExpiredAction")).newInstance();
                        }
                        catch(InstantiationException e)
                        {
                            //System.out.println(e);
                            new ConfigurationErrorAction();
                        }   
                        catch(IllegalAccessException e)
                        {
                            //System.out.println(e);
                             new ConfigurationErrorAction();
                        }                      
                        catch(ClassNotFoundException e)
                        {
                            //System.out.println(e);
                            new ConfigurationErrorAction();   
                        }                    
                    }
              
                }
   
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();   
            new ConfigurationErrorAction();
        }
    }
    
    private void launchApp()
    {
         if(EncryptedRuleReader.get("launchApplicationAction")!=null)
        {                    
            try
            {
                Class.forName(EncryptedRuleReader.get("launchApplicationAction")).newInstance();
            }
            catch(InstantiationException e)
            {
                System.out.println(e);
            }   
            catch(IllegalAccessException e)
            {
                System.out.println(e);
            }                      
            catch(ClassNotFoundException e)
            {
                System.out.println(e);
            }       
        }
        else
        {
            new ConfigurationErrorAction();
        }       
    }
    /**
     * @param args the command line arguments
     */
   // public static void main(String[] args) 
   // {
   //     new EAUpdater();
   // }
    
}
