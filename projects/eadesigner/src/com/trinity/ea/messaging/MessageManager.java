/*
 * MessageManager.java
 *
 * Created on February 27, 2004, 9:00 PM
 */

package com.trinity.ea.messaging;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import com.trinity.ea.messaging.reader.EncryptedMessageReader;
import com.trinity.ea.messaging.net.MessageDownloaderManager;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class MessageManager 
{
    
    /** Creates a new instance of MessageManager */
    public MessageManager() 
    {
        try
        {
           // System.out.println("Starting Auto Update Manager...");
            // EncryptedRuleReader.readPropertiesFile();

            // System.out.println("trying msgEnabled...");
             if(EncryptedRuleReader.get("msgEnabled")!=null)
             {
                if(EncryptedRuleReader.get("msgEnabled").equalsIgnoreCase("true")==true)
                {
                    //System.out.println("msgEnabled is true. Trying msgBaseURL: " + EncryptedRuleReader.get("msgBaseURL"));
                    if(EncryptedRuleReader.get("msgBaseURL")!=null)
                    {
     
                      //System.out.println("Starting Thread.");                              
                            // Create the object with the run() method
                            Runnable runnable = new com.trinity.ea.messaging.net.MessageDownloaderManager(EncryptedRuleReader.get("msgBaseURL"));

                            // Create the thread supplying it with the runnable object
                            Thread thread = new Thread(runnable);

                            // Start the thread
                            thread.start();  
                      //System.out.println("Started Thread.");                                  
                    }
                }
                else
                {
                   // System.out.println("msgEnabled is false.");                    
                }
             }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
//    public static void main(String args[])
//    {
//        new MessageManager();
           // JFrame TestFrame = new JFrame("Test Frame for URL Thread.");
    //TestFrame.setSize(400,400);
    //TestFrame.setVisible(true);
//    }
}
