/*
 * InstallUpdateSkipAction.java
 *
 * Created on February 16, 2004, 7:17 PM
 */

package com.trinity.ea.autoupdate.actions;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import com.trinity.ea.actions.ConfigurationErrorAction;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2004 Trinity Software. All rights reserved.
 */
public class InstallUpdateSkipAction 
{
    /** Creates a new instance of SkipAction */
    public InstallUpdateSkipAction() 
    {
         if(EncryptedRuleReader.get("launchApplicationNoUpdateAction")!=null)
        {                    
            try
            {
                Class.forName(EncryptedRuleReader.get("launchApplicationNoUpdateAction")).newInstance();
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
    public static void main(String[] args) 
    {
        new InstallUpdateSkipAction();
    }
    
}
