/*
 * LoadAutoUpdateInstallDialogAction.java
 *
 * Created on February 16, 2004, 2:24 AM
 */

package com.trinity.ea.actions;
import com.trinity.ea.autoupdate.messaging.MessageDialog;
import com.trinity.ea.util.SwingWorker;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import javax.swing.SwingUtilities;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2004 Trinity Software. All rights reserved.
 */
public class LoadAutoUpdateInstallDialogAction 
{
    /** Creates a new instance of LoadAutoUpdateInstallDialogAction */
    public LoadAutoUpdateInstallDialogAction() 
    {
        //System.out.println("Instanciated LoadAutoUpdateInstallDialogAction Action.");
       // TODO: Command Line implementation
        // TODO: MIDP implementation
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
    }
        private Object launch()
        {
               // ex1.getStartButton().requestFocus();  //XXX: can't do this until now
               if(EncryptedRuleReader.get("autoUpdateLoadInstallUIAction")!=null)
                {
                    try
                    {
                        Class mainClass=Class.forName(EncryptedRuleReader.get("autoUpdateLoadInstallUIAction"));
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
               return "";
        }   
}
