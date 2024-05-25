/*
 * EncryptRulesFile.java
 *
 * Created on October 24, 2003, 6:23 PM
 */

package com.trinity.ea;
import java.util.Properties;
import com.trinity.ea.rules.builder.EncryptedRuleBuilder;
import com.trinity.ea.rules.reader.RuleReader;
/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003 Trinity Software. All rights reserved.
 */
public class EncryptRulesFile 
{
    /** Creates a new instance of EncryptRulesFile */
    public EncryptRulesFile() 
    {
        try
        {
            // remove before release
            EncryptedRuleBuilder.encryptAndWriteRulesFile();
        }
        catch(Exception e)
        {
            e.printStackTrace();   
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        new EncryptRulesFile();
    }
    
}
