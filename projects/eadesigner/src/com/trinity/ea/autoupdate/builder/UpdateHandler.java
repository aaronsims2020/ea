/*
 * RuleHandler.java
 *
 * Created on October 31, 2003, 2:11 PM
 */

package com.trinity.ea.autoupdate.builder;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.*;
import java.io.*;
import com.trinity.ea.design.common.file.ProjectManager;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class UpdateHandler 
{
 
    private static char[] _pwd_seed = {'y','T','r','d','g','h','3','8','7','8','h','u','9','4','8','7','d','h','u','j','f','h','u','h'};
    private static Cipher cenc1;
    private static Provider sunJce;
    private static PBEKeySpec pbeKeySpec;
    private static PBEParameterSpec pbeParamSpec;
    private static SecretKeyFactory keyFac;
    private static SecretKey pbeKey;
    private static boolean cryptIsEnabled = false;
    private static byte[] salt = {(byte)0xc7, (byte)0x73, (byte)0x21, (byte)0x8c,(byte)0x7e, (byte)0xc8, (byte)0xee, (byte)0x99};
    private static int count = 546;
    private static String pwdSeed1 = null;   
    
    /** Creates a new instance of RuleHandler */
    protected UpdateHandler() 
    {
    }
    
    protected char[] getSeed()
    {
        //EncryptedRuleReader.readPropertiesFile();
            if(ProjectManager.get("autoUpdatePwdSeed")!=null)
            {
                try
                {
                    pwdSeed1 = ProjectManager.get("autoUpdatePwdSeed");
                }
                catch(Exception e)
                {
                    return null;
                }
            }
        return pwdSeed1.toCharArray();
    }
  }
