/*
 * LaunchApplicationAction.java
 *
 * Created on October 25, 2003, 4:49 PM
 */

package com.trinity.ea.actions;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import com.trinity.ea.util.SwingWorker;
import javax.swing.SwingUtilities;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import com.trinity.ea.actions.*;
import com.trinity.ea.autoupdate.AutoUpdateManager;
import com.trinity.ea.messaging.MessageManager;
/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2003 Trinity Software. All rights reserved.
 */
public class LaunchApplicationAction 
{
    SwingWorker worker;   
    private static boolean boolSkipEnabled = false;
    /** Creates a new instance of LaunchApplicationAction */
    public LaunchApplicationAction() 
    {
        // TODO: Command Line implementation
        // TODO: MIDP implementation
        // Trial Expired
        SwingWorker worker = new SwingWorker() 
        {
                public Object construct() 
                {
                   /* try
                    {
                        getAvailableUpdate();
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }*/
                    return launch();
                }
                public void finished() 
                {
                    //worker.stop();
                }
         };
        worker.start();
        // rtn = (RtnObject)worker.get();
        //worker = null;     
    }
   /*
    public static void main(String[] args)
    {
        EncryptedRuleReader.readPropertiesFile();
        new LaunchApplicationAction();
    }
    */
        private Object launch()
        {
            getMessage();
            
            if(EncryptedRuleReader.get("autoUpdateEnabled")!=null)
            {
                if(EncryptedRuleReader.get("autoUpdateEnabled").equalsIgnoreCase("true")==true)
                {
            // ex1.getStartButton().requestFocus();  //XXX: can't do this until now
                    if(boolSkipEnabled==false)
                    {
                        getAvailableUpdate();
                    }
                    else
                    {
                        launchApp();
                    }
                }
                else
                {
                    launchApp();                    
                }
            }
            else
            {
                launchApp();
            }                 
               return "";
        }
        
        private void getAvailableUpdate()
        {

        /* AutoUpdate Code goes here. */
        if(EncryptedRuleReader.get("autoUpdateUpdateInProgress")!=null)
        {                       
            if(EncryptedRuleReader.get("autoUpdateUpdateInProgress").equalsIgnoreCase("true")==true)
            {
                /* TODO: Add a checking update status dialog if loading takes more than 1 second - or use a user definable value in the Rules file */
                int vfdc = AutoUpdateManager.getUpdateDownloadsComplete();
                if(vfdc==0)
                {      
                    if(EncryptedRuleReader.get("autoUpdateLoadInstallUIAction")!=null)
                    {      
                        try
                        {
                            Class.forName(EncryptedRuleReader.get("autoUpdateLoadInstallUIAction")).newInstance();
                        }
                        catch(InstantiationException e)
                        {
                            System.out.println(e);
                        }   
                        catch(IllegalAccessException e)
                        {
                            System.out.println(e);
                        }                      
                        catch(ClassNotFoundException e)
                        {
                            System.out.println(e);
                        }                                               
                    }
                    else
                    {
                        launchApp();
                    }
                }
                else if(vfdc==1)
                {
                    System.out.println("File Downloads Incomplete");  
                    launchApp();
                }
                else if(vfdc==2)
                {
                     System.out.println("File Downloads Corrupted Update File");
                     AutoUpdateManager.getDownloadedFilesReset();
                     EncryptedRuleReader.updateInProgress(false);
                     launchApp();
                }
                else if(vfdc==3)
                {
                      System.out.println("File Downloads Corrupted File Downloads Array String");  
                      launchApp();
                }
                else
                {
                      System.out.println("File Downloads Unknown error return code: " + vfdc);  
                      launchApp();
                }                                

            }
            else
            {
                new AutoUpdateManager();
                launchApp();
            }
        }
        else
        {
            launchApp();
        }
         
    }
    private void getMessage()
    {
   
        try
        {
             if(EncryptedRuleReader.get("msgEnabled")!=null)
            {
                if(EncryptedRuleReader.get("msgEnabled").equalsIgnoreCase("true")==true)
                {           
                    new com.trinity.ea.messaging.MessageManager();
                }
             }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
        
    private void launchApp()
    {
        if(EncryptedRuleReader.get("applicationClass")!=null)
        {
            try
            {
                Class mainClass=Class.forName(EncryptedRuleReader.get("applicationClass"));
                Method mainMethod=mainClass.getMethod("main",new Class[]{String[].class});
                mainMethod.invoke(null,new Object[]{new String[]{}});
            }
            catch(InvocationTargetException e)
            {
                System.out.println(e);                
            }            
            catch(NoSuchMethodException e)
            {
                System.out.println(e);                
            }
            catch(IllegalAccessException e)
            {
                System.out.println(e);
            }                      
            catch(ClassNotFoundException e)
            {
                System.out.println(e);
            }       
        }
        else
        {
            //Problem in Properties File
        }         
    }   

    public static void setSkipUpdate(boolean skipEnabled)
    {
        boolSkipEnabled = skipEnabled;
    }
}
