/*
 * MessagingDesignerPreviewAction.java
 *
 * Created on October 25, 2003, 4:49 PM
 */

package com.trinity.ea.design.autoupdate.actions;
import com.trinity.ea.design.autoupdate.preview.messaging.UpdateDialogDesignerPreview;
import com.trinity.ea.design.common.file.ProjectManager;
import javax.swing.UIManager;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class UpdateDesignerPreviewAction 
{
     
    /** Creates a new instance of MessagingDesignerPreviewAction */
    public UpdateDesignerPreviewAction(int msgtype, String msgTitle, String msgText, String msgSupport, String msgError, String msgFont, String textColor, String msgBtnFont, String msgBtnFontColor, String OKBtnText, char OKBtnMnemonic, String msgSkipBtn, char msgSkipBtnMnem, int textAlignJustify) 
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
        new UpdateDialogDesignerPreview(msgtype, msgTitle, msgText, msgSupport, msgError, msgFont, textColor, msgBtnFont, msgBtnFontColor, OKBtnText, OKBtnMnemonic, msgSkipBtn, msgSkipBtnMnem, textAlignJustify); 
    }
    
}
