/*
 * DesignerRulesFile.java
 *
 * Created on October 24, 2003, 6:23 PM
 */

package com.trinity.ea;
import com.trinity.ea.design.rules.builder.DesignerRuleBuilder;
import com.trinity.ea.design.rules.reader.DesignerRuleReader;
/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2023 Trinity Software. All rights reserved.
 */
public class EncryptDesignerFile 
{
    /** Creates a new instance of EncryptRulesFile */
    public EncryptDesignerFile() 
    {
        try
        {
            // remove before release
            DesignerRuleBuilder.encryptAndWriteRulesFile();
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
        new EncryptDesignerFile();
    }
    
}
