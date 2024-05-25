/*
 * RuleHandlerShoe.java
 *
 * Created on February 24, 2004, 5:22 PM
 */

package com.trinity.ea.rules.reader;
import com.trinity.ea.autoupdate.reader.EncryptedUpdateReader;
/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2004 Trinity Software. All rights reserved.
 */
public class RuleHandlerShoe 
{
    private static boolean inProcess = false; 
    private static int theValInt = 0;
    /** Creates a new instance of RuleHandlerShoe */
    protected RuleHandlerShoe() 
    {
        checkShoe();
    }
 
    private static void checkShoe()
    {
        inProcess = true;
        try
        {
            if(EncryptedUpdateReader.get("validationCode")!=null)
            {
                if(EncryptedUpdateReader.get("validationCode").equalsIgnoreCase("")==false&&EncryptedUpdateReader.get("validationCode").length()>4)
                {
                    if(EncryptedRuleReader.getValidationCode().equalsIgnoreCase(EncryptedUpdateReader.get("validationCode"))==true)
                    {
                        theValInt=10777;
                    }
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }      
        inProcess = false;
    }
    
    protected void setShoeBox(String url, int position)
    {
        inProcess = true;
        try
        {
            if(getReturn()==10777)
            {
                if(EncryptedRuleReader.getShoeBoxIsEnabled()==true)
                {
                    if(position!=0)
                    {
                        EncryptedRuleReader.setShoeBox(url, "autoUpdateAlternateURL"  + String.valueOf(position));
                    }
                    else
                    {
                        EncryptedRuleReader.setShoeBox(url, "autoUpdateBaseURL");
                    }
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        theValInt=0;
        inProcess = false;
    }
    protected static int getReturn()
    {
        return theValInt;
    }
    
    protected static boolean getProcess()
    {
        return inProcess;
    }
}
