/*
 * ProjectHandler.java
 *
 * Created on October 31, 2003, 2:11 PM
 */

package com.trinity.ea.design.common.file;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2005 Trinity Software. All rights reserved.
 */
public class ProjectHandler 
{
 
    private static char[] _pwd_seed = {'f','7','G','T','r','i','4','3','n','7','i','u','t','Y','7','7','a','h','v','f','i','h','u','9'};
    private static Cipher cenc1;
    private static Provider sunJce;
    private static PBEKeySpec pbeKeySpec;
    private static PBEParameterSpec pbeParamSpec;
    private static SecretKeyFactory keyFac;
    private static SecretKey pbeKey;
    private static boolean cryptIsEnabled = false;
    private static byte[] salt = {(byte)0xc7, (byte)0x73, (byte)0x21, (byte)0x8c,(byte)0x7e, (byte)0xc8, (byte)0xee, (byte)0x99};
    private static int count = 876;
    
    protected ProjectHandler() 
    {
    }
    
    protected char[] getSeed()
    {
        return _pwd_seed;
    }
  }
