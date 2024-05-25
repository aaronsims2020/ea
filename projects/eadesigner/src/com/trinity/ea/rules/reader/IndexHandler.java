/*
 * IndexHandler.java
 *
 * Created on October 31, 2003, 2:11 PM
 */

package com.trinity.ea.rules.reader;
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
public class IndexHandler 
{
    private static char[] _pwd_seed = {'w','B','h','c','e','h','3','8','7','8','i','t','5','5','2','v','e','n','b','v','2','y','a','m'};
    private static Cipher cenc1;
    private static Provider sunJce;
    private static PBEKeySpec pbeKeySpec;
    private static PBEParameterSpec pbeParamSpec;
    private static SecretKeyFactory keyFac;
    private static SecretKey pbeKey;
    private static boolean cryptIsEnabled = false;
    private static byte[] salt = {(byte)0xc7, (byte)0x73, (byte)0x21, (byte)0x8c,(byte)0x7e, (byte)0xc8, (byte)0xee, (byte)0x99};
    private static int count = 546;
    
    protected char[] getSeed()
    {
        return _pwd_seed;
    }
    
    /** Creates a new instance of IndexHandler */
    protected IndexHandler() 
    {
    }    
}
