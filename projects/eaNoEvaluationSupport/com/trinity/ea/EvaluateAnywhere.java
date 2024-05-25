/*
 * EvaluateAnywhere.java - with no expiration processing support.
 *
 * Created on October 24, 2003, 6:23 PM
 */

package com.trinity.ea;
import com.trinity.ea.actions.*;
import com.trinity.ea.rules.reader.EncryptedRuleReader;

/** 
 *
 * @author  aaronsc Trinity Software
 * Copyright �2003-2004 Trinity Software. All rights reserved.
 */
public class EvaluateAnywhere 
{
    //Trial eat = new Trial();/** Creates a new instance of EvaluateAnywhere */
    public EvaluateAnywhere() 
    {
        try
        {
            EncryptedRuleReader.readPropertiesFile();
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
        catch(Exception e)
        {
            //e.printStackTrace();   
            new ConfigurationErrorAction();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        new EvaluateAnywhere();
    }
    
}
