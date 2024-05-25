/*
 * PaymentSuccessAction.java
 *
 * Created on October 25, 2003, 4:49 PM
 */

package com.trinity.ea.actions;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import com.trinity.ea.util.SwingWorker;
import javax.swing.SwingUtilities;
import java.lang.reflect.*; 
/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2003-2004 Trinity Software. All rights reserved.
 */
public class PaymentSuccessAction 
{
    SwingWorker worker;   
    /** Creates a new instance of PaymentSuccessAction */
    public PaymentSuccessAction() 
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
        new PaymentSuccessAction();
    }
    */
        private Object launch()
        {
               // ex1.getStartButton().requestFocus();  //XXX: can't do this until now
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
               return "";
        }
}


