/*
 * EAHelpViewer.java
 *
 * Created on November 14, 2004, 2:36 PM
 */

package com.trinity.ea.design.help;
import com.trinity.ea.design.rules.builder.DesignerRuleBuilder;
import com.trinity.ea.design.common.panel.EAPanel;
import javax.help.*;
import java.net.URL;
import javax.swing.JOptionPane;
import java.awt.Component;
import java.awt.event.ActionListener;
import com.trinity.ea.design.help.EAHelpBroker;

/**
 *
 * @author  aaronsc Trinity Software, LLC
 * Copyright ©2004 Trinity Software, LLC. All rights reserved.
 */
public class EAHelpViewer 
{
    private static String helpHS = null;
    private static HelpSet eaHelpSet = null;  
    private static EAHelpBroker helpBroker;
    /** Creates a new instance of EAHelp */
    public EAHelpViewer() 
    {
    }
 
    public static ActionListener getEAHelpViewer(Component parentComponent)
    {
        try
        {
            // Find the HelpSet file and create the HelpSet object:
            if(helpHS!=null)
            {}
            else
            {
                if(DesignerRuleBuilder.get("eaHelpSet")!=null)
                {
                    if(DesignerRuleBuilder.get("eaHelpSet").equalsIgnoreCase("")==false)
                    {                    
                        helpHS = DesignerRuleBuilder.get("eaHelpSet");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(parentComponent,"Help document not found");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(parentComponent,"Help document not found");
                }
            }
            if(eaHelpSet!=null)
            {}
            else
            {
                URL hsURL = new URL("http://www.evaluateanywhere.com");
                EAPanel eaPan = new EAPanel(); 
                ClassLoader cl = eaPan.getClass().getClassLoader();
                try 
                { 
                    hsURL = HelpSet.findHelpSet(cl, helpHS);
                    eaHelpSet = new HelpSet(null, hsURL);
                } 
                catch (Exception ee) 
                {
                    JOptionPane.showMessageDialog(parentComponent,"Help " + helpHS + " not found");
                }
                 
            }
            if(helpBroker!=null)
            {}
            else
            {           
                helpBroker = new EAHelpBroker(eaHelpSet);
            }
            return new CSH.DisplayHelpFromSource(helpBroker);
        }
        catch(Exception e)
        {
        }
        return null;
    }
}
