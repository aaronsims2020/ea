/*
 * SocketExceptionAction.java
 *
 * Created on October 29, 2003, 12:40 AM
 */

package com.trinity.ea.design.common.preview.actions;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.common.preview.gui.swing.ErrorDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class SocketExceptionAction 
{
    
    /** Creates a new instance of ASocketExceptionAction */
    public SocketExceptionAction() 
    {
        try
        {
            getMessage(ProjectManager.get("msgMsgTitle"),ProjectManager.get("socketException"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void getMessage(String title, String error)
    {
        boolean isOptionPane = true;
	  if(ProjectManager.get("btnBarImgButtonsEnabled")!=null)
	  {
	  	if(ProjectManager.get("btnBarImgButtonsEnabled").equalsIgnoreCase("true")==true)
	  	{
                    isOptionPane = false;
                }
                else
                {
                    isOptionPane = true;
                }
          }
          else
          {
              isOptionPane = true;
          }
        if(isOptionPane==false)
        {
            new ErrorDialog(title,error);
        }
        else
        {
            JOptionPane.showMessageDialog(null,error,title,JOptionPane.INFORMATION_MESSAGE);
        }
    }        
}
