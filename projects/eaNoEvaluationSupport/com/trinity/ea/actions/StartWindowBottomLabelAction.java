/*
 * StartWindowBottomLabelAction.java
 *
 * Created on November 8, 2003, 12:50 AM
 */

package com.trinity.ea.actions;
import com.trinity.ea.util.BrowserLauncher;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2003-2004 Trinity Software. All rights reserved.
 */
public class StartWindowBottomLabelAction {
    
    /** Creates a new instance of StartWindowBottomLabelAction */
    public StartWindowBottomLabelAction() 
    {
        try
        {
        if(EncryptedRuleReader.get("product_url")!=null)
        {         
            BrowserLauncher.openURL(EncryptedRuleReader.get("product_url"));
        }
        }catch(Exception e)
        {}
    }
    
}
