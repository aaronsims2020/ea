/*
 * RuleHandler.java
 *
 * Created on October 31, 2003, 2:11 PM
 */

package com.trinity.ea.rules.builder;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.*;
import java.io.*;
import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;
/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2003 Trinity Software. All rights reserved.
 */
public class RuleHandler 
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
    
    /** Creates a new instance of RuleHandler */
    protected RuleHandler() 
    {
    }
    
    protected char[] getSeed()
    {
        return _pwd_seed;
    }
 /*   
    protected void setConstructCryptFunction(char[] passwd)
    {
        cryptIsEnabled=true;
        sunJce = new com.sun.crypto.provider.SunJCE();
        Security.addProvider(sunJce);    
        try
        {
            // Create PBE parameter set
            pbeParamSpec = new PBEParameterSpec(salt, count);

            pbeKeySpec = new PBEKeySpec(passwd,salt,count);
            keyFac = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            pbeKey = keyFac.generateSecret(pbeKeySpec);
            cenc1=Cipher.getInstance("PBEWithMD5AndDES");
        }
        catch(NullPointerException e)
        {
            //System.out.println(e);
            //e.printStackTrace();        
        }        
        catch(Exception e)
        {
            //System.out.println(e);
            //e.printStackTrace();        
        }
    }
    protected boolean getCryptIsEnabled()
    {
        return cryptIsEnabled;
    }
     
    protected String encrypt(String str) 
    {
        try 
        {

            cenc1.init(Cipher.ENCRYPT_MODE, pbeKey, pbeParamSpec);
            // Encrypt
            byte[] enc = cenc1.doFinal(str.getBytes("UTF-8"));

            // Encode bytes to base64 to get a string
            return new String(new sun.misc.BASE64Encoder().encode(enc));
        } 
        catch(InvalidAlgorithmParameterException e)
        {
           // System.out.println(e);
           /// e.printStackTrace();
        }
        catch(InvalidKeyException e)
        {
           // System.out.println(e);
            //e.printStackTrace();
        }        
        catch (javax.crypto.BadPaddingException e) 
        {
         //System.out.println(e);
        //e.printStackTrace();           
        } 
        catch (IllegalBlockSizeException e) 
        {
        // System.out.println(e);
        //e.printStackTrace();           
        } 
        catch (UnsupportedEncodingException e) 
        {
           // System.out.println(e);
           // e.printStackTrace();           
        } 
        catch (java.io.IOException e) 
        {
           // System.out.println(e);
           // e.printStackTrace();           
        }
        return null;
    }

    protected String decrypt(String str) 
    {
        try 
        {
            cenc1.init(Cipher.ENCRYPT_MODE,pbeKey, pbeParamSpec);           
            // Decode base64 to get bytes
            byte[] cleartext1 = cenc1.doFinal(new sun.misc.BASE64Decoder().decodeBuffer(str));
    
            // Decode using utf-8
            return new String(cleartext1, "UTF8");
        } 
        catch(InvalidAlgorithmParameterException e)
        {
           // System.out.println(e);
           // e.printStackTrace();            
        }       
        catch(InvalidKeyException e)
        {
            //System.out.println(e);
           // e.printStackTrace();
        }         
        catch (javax.crypto.BadPaddingException e) 
        {
            //System.out.println(e);
            //e.printStackTrace();           
        } 
        catch (IllegalBlockSizeException e) 
        {
           // System.out.println(e);
           // e.printStackTrace();            
        } 
        catch (UnsupportedEncodingException e) 
        {
           // System.out.println(e);
           // e.printStackTrace();            
        }
        catch (java.io.IOException e) 
        {
          ///  System.out.println(e);
          //  e.printStackTrace();            
        }
        return null;
    }
*/
  }
