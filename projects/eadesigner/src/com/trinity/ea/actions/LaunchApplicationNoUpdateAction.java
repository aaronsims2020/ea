/*
 * LaunchApplicationNoUpdateAction.java
 *
 * Created on February 17th, 2003, 5:28 PM
 */

package com.trinity.ea.actions;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import com.trinity.ea.util.SwingWorker;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import com.trinity.ea.actions.*;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class LaunchApplicationNoUpdateAction 
{
    SwingWorker worker;   

    /** Creates a new instance of LaunchApplicationAction */
    public LaunchApplicationNoUpdateAction() 
    {
        // TODO: Command Line implementation
        // TODO: MIDP implementation
        // Trial Expired
        SwingWorker worker = new SwingWorker() 
        {
                public Object construct() 
                {
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
               launchApp();
               return "";
        }
        
       
    private void launchApp()
    {
        if(EncryptedRuleReader.get("applicationClass")!=null)
        {
            try
            {
                try
                {
                    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                    System.gc();
                }
                catch(Exception e)
                {}               
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

}
