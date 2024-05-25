/*
 * MessageDownloaderManager.java
 *
 * Created on February 27, 2004, 9:23 PM
 */

package com.trinity.ea.messaging.net;
import java.net.*;
import java.io.*;
import java.util.*;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import com.trinity.ea.messaging.reader.EncryptedMessageReader;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2004 Trinity Software. All rights reserved.
 */
public class MessageDownloaderManager implements Runnable 
{
    /** Creates a new instance of MessageDownloaderManager */
    String strUrl;
    String directory;
    Map overwriteHM;
    private static int updateStatus = 1;    
    
    public MessageDownloaderManager(String strUrl) 
    {
        this.strUrl   = strUrl;
    }
    public void run() 
    {
        int updateFileRetCode = 1;
        try 
        {
            String dlDirectory = null;
            String wrkDirectory = null;
            String tmpUpdateID = null;
            String origUpdateID = null;
            OutputStream os = null;
            updateFileRetCode = EncryptedMessageReader.readMessage(this.strUrl);
            /* if the update file returns a value not successful try downloading from another URL if permitted by the max EncryptedRuleReader msgMaxBaseURLs Property value. */
            if(updateFileRetCode!=0)
            {
                //System.out.println("Failed to download primary message file, attempting alternate download locations.");
                try
                {
                    if(EncryptedRuleReader.get("msgMaxBaseURLs")!=null)
                    {
                        int theMaxURLList = Integer.valueOf(EncryptedRuleReader.get("msgMaxBaseURLs")).intValue();
                        if(theMaxURLList>1)
                        {
                            //System.out.println("The maximum update file URLs that will be used to attempt to download the message file is: " + theMaxURLList);
                            /* if the Maximum number of URLs is greater than one then Try Alternate URLs. */
                            for(int i = 0;i<theMaxURLList;i++)
                            {
                                if(getAlternateURL(i)!=null)
                                {
                                    //System.out.println("Attempting Connection to Alternate URL " + i + ": " + getAlternateURL(i));
                                    updateFileRetCode = EncryptedMessageReader.readMessage(getAlternateURL(i));
                                    if(updateFileRetCode == 0)
                                    {
                                        /* if return code is 0, end loop */
                                        i=theMaxURLList;
                                        //System.out.println("Successfully Downloaded Message from Alternate URL " + i + ": " + getAlternateURL(i));
                                    }
                                }
                                else
                                {
                                   // System.out.println("Attempted Alternate URL " + i + " was null.");  
                                }
                            }
                        }
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
               // System.out.println("Successfully downloaded primary message file.");
            }
            
            if(updateFileRetCode==0)
            {
                /* Check the downloaded update file for the updateid. */
                if(EncryptedMessageReader.get("updateid")!=null)
                {
                    tmpUpdateID = EncryptedMessageReader.get("updateid");
                    try
                    {
                    //System.out.println("Attempting to perform a Base URL Update check. Entering UpdateID Check...");

                        if(EncryptedRuleReader.get("msgUpdateID")!=null)
                        {
                            if(EncryptedRuleReader.get("msgUpdateID").equals(EncryptedMessageReader.get("updateid"))==false)
                            {   
                                //System.out.println("********************Calling getBaseURLCheck()*************************");
                                getBaseURLCheck();
                                //System.out.println("*********************Successfully Called getBaseURLCheck()********************************");                           
                            }
                        }
                    }
                    catch(Exception eeeee)
                    {
                        eeeee.printStackTrace();
                    }
                }
               // System.out.println("Message Download Return Code: " + updateFileRetCode);

                /* If update id is not equal to current, perform update. */
                //System.out.println("Checking last read version of message and message ID..."); 
               // System.out.println("msgUpdateID in EncryptedRuleReader: " + EncryptedRuleReader.get("msgUpdateID"));
                //System.out.println("updateid in EncryptedMessageReader: " + EncryptedMessageReader.get("updateid"));
                if(EncryptedRuleReader.get("msgUpdateID").equals(EncryptedMessageReader.get("updateid"))==false)
                {
                    //System.out.println("Message ID is not the same, displaying new message...");
                    try
                    {
                         if(EncryptedRuleReader.get("msgDisplayMessageUIAction")!=null)
                        {      
                            try
                            {
                                Class.forName(EncryptedRuleReader.get("msgDisplayMessageUIAction")).newInstance();
                                EncryptedRuleReader.lastMessageUpdate(); 
                            }
                            catch(InstantiationException e)
                            {
                                e.printStackTrace(); 
                            }   
                            catch(IllegalAccessException e)
                            {
                                e.printStackTrace(); 
                            }                      
                            catch(ClassNotFoundException e)
                            {
                                e.printStackTrace(); 
                            }                                               
                        }
                    }
                    catch(Exception e)
                    {
                     e.printStackTrace();   
                    }
                }
                else
                {
                    //System.out.println("Message ID same. No message display is necessary...");
                    // Set last update to current.
                    EncryptedRuleReader.lastMessageUpdate();               
                }
            }
            else
            {
                //System.out.println("No messages available.");
                EncryptedRuleReader.lastMessageUpdate();                   
            }           
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private static synchronized Object[] getStringArraysFromString(String textArrayString)
    {
        ArrayList aryList = new ArrayList();
        String tempString = "";
        
        while(textArrayString.indexOf(",")!=-1)
        {
            tempString = textArrayString.substring(0,textArrayString.indexOf(","));
            textArrayString = textArrayString.substring(textArrayString.indexOf(",") + 1);
            aryList.add(tempString);
        }
        aryList.add(textArrayString);
        return aryList.toArray();
    }
   
    private synchronized String getAlternateURL(int alternateURLRef)
    {
        try
        {
            
            return EncryptedRuleReader.get("msgAlternateURL" + String.valueOf(alternateURLRef));
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    private synchronized void getBaseURLCheck()
    {
        //System.out.println("Performing Base URL Message Check...");
            try
            {
                /* Check the downloaded update file for a baseurlchange */
                if(EncryptedMessageReader.get("baseurlchange")!=null)
                {
                    if(EncryptedMessageReader.get("baseurlchange").equalsIgnoreCase("true")==true)
                    {
                        //System.out.println("The Base URL changed");
                        //baseurl, and alternateurl#
                        if(EncryptedMessageReader.get("baseurlupdates")!=null)
                        {                        
                            if(EncryptedMessageReader.get("validationCode")!=null)
                            {
                                //System.out.println("Updating URL Values, validationCode is good. Validation Code: " + EncryptedMessageReader.get("validationCode"));
                                Object[] theURLChangeArray = getStringArraysFromString(EncryptedMessageReader.get("baseurlupdates"));
                                //System.out.println("The number of URL values is: " + theURLChangeArray.length);
                                for(int i = 0;i<theURLChangeArray.length;i++)
                                {
                                    try
                                    {
                                        if(theURLChangeArray[i]!=null)
                                        {
                                            if(((String)theURLChangeArray[i]).trim().equalsIgnoreCase("")==false)
                                            {
                                               // System.out.println("Validation Code: " + EncryptedMessageReader.get("validationCode") + ", The URL: " + (String)theURLChangeArray[i] + " The Address Position is: " + i);
                                                EncryptedRuleReader.setURLMessageUpdate(EncryptedMessageReader.get("validationCode"), (String)theURLChangeArray[i], i);
                                            }
                                        }
                                    }
                                    catch(Exception e)
                                    {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }

                    }
                    else
                    {
                        
                    }
                }
          
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
    }
}
