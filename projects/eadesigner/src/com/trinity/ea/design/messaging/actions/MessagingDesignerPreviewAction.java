/*
 * MessagingDesignerPreviewAction.java
 *
 * Created on October 25, 2003, 4:49 PM
 */

package com.trinity.ea.design.messaging.actions;
import com.trinity.ea.design.messaging.preview.ui.swing.MessageDialogDesignerPreview;
import com.trinity.ea.design.common.file.ProjectManager;
import javax.swing.UIManager;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class MessagingDesignerPreviewAction 
{
     
    /** Creates a new instance of MessagingDesignerPreviewAction */
    public MessagingDesignerPreviewAction(int msgtype, String msgTitle, String msgText, String msgFont, String textColor, String msgBtnFont, String msgBtnFontColor, String OKBtnText, char OKBtnMnemonic, int textAlignJustify) 
    {
   	try
   	{
            if(ProjectManager.get("LAndFPackage")!=null)
            {
                    if(ProjectManager.get("LAndFPackage").equalsIgnoreCase("system")==true)
                    {			
                            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    }
                    else
                    {
                            UIManager.setLookAndFeel(ProjectManager.get("LAndFPackage"));
                    }
            }
   	}
   	catch (Exception e)
   	{
            System.out.println("Could not set System Look and Feel.");
   	}
        new MessageDialogDesignerPreview(msgtype, msgTitle, msgText, msgFont, textColor, msgBtnFont, msgBtnFontColor, OKBtnText, OKBtnMnemonic, textAlignJustify); 
    }
    
}
