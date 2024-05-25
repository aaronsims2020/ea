/*
 * RuleHandlerShoe.java
 *
 * Created on February 24, 2004, 5:22 PM
 */

package com.trinity.ea.rules.reader;
import com.trinity.ea.messaging.reader.EncryptedMessageReader;
/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2004 Trinity Software. All rights reserved.
 */
public class RuleHandlerMessageShoe 
{
    private static boolean inProcess = false; 
    private static int theValInt = 0;
    /** Creates a new instance of RuleHandlerShoe */
    protected RuleHandlerMessageShoe() 
    {
        checkShoe();
    }
 
    private static void checkShoe()
    {
        inProcess = true;
        try
        {
            if(EncryptedMessageReader.get("validationCode")!=null)
            {
                if(EncryptedMessageReader.get("validationCode").equalsIgnoreCase("")==false&&EncryptedMessageReader.get("validationCode").length()>4)
                {
                    if(EncryptedRuleReader.getMessageValidationCode().equalsIgnoreCase(EncryptedMessageReader.get("validationCode"))==true)
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
    
    protected void setMessageShoeBox(String url, int position)
    {
        inProcess = true;
        try
        {
            if(getReturn()==10777)
            {
                if(EncryptedRuleReader.getMessageShoeBoxIsEnabled()==true)
                {
                    if(position!=0)
                    {
                        EncryptedRuleReader.setMessageShoeBox(url, "msgAlternateURL"  + String.valueOf(position));
                    }
                    else
                    {
                        EncryptedRuleReader.setMessageShoeBox(url, "msgBaseURL");
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
