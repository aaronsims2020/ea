/*
 * InformationDialogAction.java
 *
 * Created on December 3, 2003, 12:00 PM
 */

package com.trinity.ea.actions;
import com.trinity.ea.forms.info.InformationDialog;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class InformationDialogAction 
{
    /** Creates a new instance of InformationDialogAction. This class launches the Swing UI Information Dialog Window). */
    public InformationDialogAction() 
    {
        new InformationDialog(null, true).show();
    }
    
}
