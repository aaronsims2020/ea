/*
 * StartupWindowPanelVerticalButtonBar.java
 *
 * Created on June 3, 2004, 3:10 PM
 */

package com.trinity.ea.design.project.lookandfeel.preview.startupui.swing;
import com.trinity.ea.design.project.lookandfeel.preview.startupui.swing.ButtonPanel;
import com.trinity.ea.design.project.lookandfeel.preview.startupui.swing.DaysLeftCounter;
import com.trinity.ea.design.project.lookandfeel.preview.startupui.swing.EAAboutButton;
import com.trinity.ea.design.project.lookandfeel.preview.startupui.swing.SplashImagePanel;
import com.trinity.ea.design.common.file.ProjectManager;
import java.awt.ComponentOrientation;
import java.awt.Color;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import java.util.ArrayList;
import java.net.URL;
import java.net.MalformedURLException;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2005 Trinity Software. All rights reserved.
 */
public class StartupWindowPanelVerticalButtonBar extends javax.swing.JPanel {
    final private Date currentDate = new Date();
    /** Creates new form StartupWindowPanelVerticalButtonBar */
    public StartupWindowPanelVerticalButtonBar() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        TopPanel = new javax.swing.JPanel();
        SplashPanel = new javax.swing.JPanel();
        SplashPanelTarget = new SplashImagePanel();
        SplashButtonPanel = new javax.swing.JPanel();
        BottomPanel = new javax.swing.JPanel();
        TrialBarButtonPanel = new javax.swing.JPanel();
        TrialBarButtonPanelTarget = new EAAboutButton();
        TrialBarProgressPanel = new javax.swing.JPanel();
if(ProjectManager.get("btnBarImgButtonsEnabled")!=null)
{
	if(ProjectManager.get("btnBarImgButtonsEnabled").equalsIgnoreCase("true")==true)
	{
		ImageIcon buttonFaceImage = null;
		ImageIcon buttonFaceImageOnClick = null;
		ImageIcon buttonFaceImageInFocus = null;
		int theBtnHeight = 23;
		int theBtnWidth = 105;
		int theBtnBarHeightPadding = 0;
		if(ProjectManager.get("btnBarImgButtonFace")!=null)
		{
			if(ProjectManager.get("btnBarImgButtonFace").equalsIgnoreCase("")==false)
			{
				try
				{
					buttonFaceImage = new javax.swing.ImageIcon(new URL(ProjectManager.get("btnBarImgButtonFace")));
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		if(ProjectManager.get("btnBarImgButtonFaceOnClick")!=null)
		{
			if(ProjectManager.get("btnBarImgButtonFaceOnClick").equalsIgnoreCase("")==false)
			{
				try
				{
					buttonFaceImageOnClick = new javax.swing.ImageIcon(new URL(ProjectManager.get("btnBarImgButtonFaceOnClick")));
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		if(ProjectManager.get("buttonFaceImageInFocus")!=null)
		{
			if(ProjectManager.get("buttonFaceImageInFocus").equalsIgnoreCase("")==false)
			{
				try
				{
					buttonFaceImageInFocus = new javax.swing.ImageIcon(new URL(ProjectManager.get("buttonFaceImageInFocus")));
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		if(ProjectManager.get("btnBarImgButtonWidth")!=null)
		{
			if(ProjectManager.get("btnBarImgButtonWidth").equalsIgnoreCase("")==false)
			{
				try
				{
					theBtnWidth = new Integer(ProjectManager.get("btnBarImgButtonWidth")).intValue();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		if(ProjectManager.get("btnBarImgButtonHeight")!=null)
		{
			if(ProjectManager.get("btnBarImgButtonHeight").equalsIgnoreCase("")==false)
			{
				try
				{
					theBtnHeight = new Integer(ProjectManager.get("btnBarImgButtonHeight")).intValue();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		if(ProjectManager.get("btnBarHeightPadding")!=null)
		{
			if(ProjectManager.get("btnBarHeightPadding").equalsIgnoreCase("")==false)
			{
				try
				{
					theBtnBarHeightPadding = new Integer(ProjectManager.get("btnBarHeightPadding")).intValue();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}


		if(buttonFaceImage!=null)
		{
			SplashButtonPanelTarget = new ButtonPanel(buttonFaceImage, buttonFaceImageOnClick, buttonFaceImageInFocus, theBtnWidth, theBtnHeight, theBtnBarHeightPadding);
		}
		else
		{
			SplashButtonPanelTarget = new ButtonPanel();
		}
	}
	else
	{
		SplashButtonPanelTarget = new ButtonPanel();
	}
}


	  try
	  {
        	TrialBarProgressPanelTarget = new DaysLeftCounter(new Integer(ProjectManager.get("progressBarCellSpacing")).intValue());
	  }
	  catch(Exception e)
	  {
		e.printStackTrace();
        	TrialBarProgressPanelTarget = new DaysLeftCounter();
	  }
	  isExpired = false;
        days = 1296000000 / (1000 * 60 * 60 * 24);

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));
        try
        {
        totaldays  = Long.valueOf(ProjectManager.get("runtimeMillasecondsToExpire")).longValue() / (1000 * 60 * 60 * 24);
        TrialBarProgressPanelTarget.setIsExpired(isExpired);
	  if(isExpired==false)
	  {
        	TrialBarProgressPanelTarget.setDaysLeft(new Long(days).intValue(), new Long(totaldays).intValue());
		TrialBarProgressPanelTarget.setDaysLeftText(ProjectManager.get("progressBarDaysLeftText").replaceAll("days_left",String.valueOf(days)));
	  }
	  else
	  {
		TrialBarProgressPanelTarget.setDaysLeftText(ProjectManager.get("progressBarExpiredText").replaceAll("days_left",String.valueOf(days)));
		if(ProjectManager.get("evaluation_disable_expired_software_enabled").equalsIgnoreCase("true")==true)
		{
			SplashButtonPanelTarget.setUseEvaluationButtonDisabled(true);
		}
	  }
	  if(ProjectManager.get("buyNowExpires")!=null)
	  {
		if(ProjectManager.get("buyNowExpires").equalsIgnoreCase("-1")==false)
		{
        		try
        		{
            		long installDate = Long.valueOf(ProjectManager.get("runtimeMillasecondsStartTrial")).longValue();
            		long timeToExpiration = Long.valueOf(ProjectManager.get("buyNowExpires")).longValue();
            		// Check if time is earlier than date file was created, if so product is expired.
            		long diff = currentDate.getTime() - installDate;
            		//need to read trial period from file
            		timeToExpiration = timeToExpiration-diff;
				if(timeToExpiration<=0)
				{
					SplashButtonPanelTarget.setBuyNowButtonDisabled(true);
				}
        		}
        		catch(Exception e)
        		{
				e.printStackTrace();
        		}
		}
	  }
        }
        catch(Exception eee)
	  {
		eee.printStackTrace();
	  }

// Splash Screen Variables
if(ProjectManager.get("splashImgBGColor")!=null)
{
	if(ProjectManager.get("splashImgBGColor").equalsIgnoreCase("")==false)
	{
		Object[] tmpArray = getStringArraysFromString(ProjectManager.get("splashImgBGColor"));
		SplashPanelTarget.setBackground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
	}
}
if(ProjectManager.get("splashImgOverideDefaultPanelSize")!=null)
{
	if(ProjectManager.get("splashImgOverideDefaultPanelSize").equalsIgnoreCase("true")==true)
	{
		SplashPanelTarget.setOverideDefaultPanelSize(new Integer(ProjectManager.get("splashImgOveridePanelWidth")).intValue(), new Integer(ProjectManager.get("splashImgOveridePanelHeight")).intValue());
	}
}
int splashWidth = 500;
int splashHeight = 300;
if(ProjectManager.get("splashImageSize")!=null)
{
	if(ProjectManager.get("splashImageSize").equalsIgnoreCase("")==false)
	{
		Object[] tmpArray = getStringArraysFromString(ProjectManager.get("splashImageSize"));
		splashWidth = new Integer((String)tmpArray[0]).intValue();
		splashHeight = new Integer((String)tmpArray[1]).intValue();
	}
}


	  if(splashWidth >= 100 && splashHeight >= 250)
	  {
        	setMaximumSize(new java.awt.Dimension(32767, 32767));
        	setMinimumSize(new java.awt.Dimension(216, 299));
        	setPreferredSize(new java.awt.Dimension(splashWidth + 116, splashHeight + 47));
        	SplashButtonPanel.setMaximumSize(new java.awt.Dimension(116, 32767));
        	SplashButtonPanel.setMinimumSize(new java.awt.Dimension(116, splashHeight));
        	SplashButtonPanel.setPreferredSize(new java.awt.Dimension(116, splashHeight + 1));
        	TopPanel.setMaximumSize(new java.awt.Dimension(32767, splashHeight + 1));
        	TopPanel.setMinimumSize(new java.awt.Dimension(216, splashHeight));
        	TopPanel.setPreferredSize(new java.awt.Dimension(splashWidth + 116, splashHeight + 1));
        	SplashPanel.setMaximumSize(new java.awt.Dimension(splashWidth + 1, splashHeight + 1));
        	SplashPanel.setMinimumSize(new java.awt.Dimension(216, 250));
        	SplashPanel.setPreferredSize(new java.awt.Dimension(splashWidth + 1, splashHeight + 1));
	  }
	  else if(splashWidth < 100 && splashHeight < 250 )
	  {
        	setMaximumSize(new java.awt.Dimension(516, 299));
        	setMinimumSize(new java.awt.Dimension(216, 299));
        	setPreferredSize(new java.awt.Dimension(216, 299));
        	SplashButtonPanel.setMaximumSize(new java.awt.Dimension(116, 250));
        	SplashButtonPanel.setMinimumSize(new java.awt.Dimension(116, 250));
        	SplashButtonPanel.setPreferredSize(new java.awt.Dimension(116, 250));
        	TopPanel.setMaximumSize(new java.awt.Dimension(516, 250));
        	TopPanel.setMinimumSize(new java.awt.Dimension(216, 250));
        	TopPanel.setPreferredSize(new java.awt.Dimension(216, 250));
        	SplashPanel.setMaximumSize(new java.awt.Dimension(100, 250));
        	SplashPanel.setMinimumSize(new java.awt.Dimension(100, 250));
        	SplashPanel.setPreferredSize(new java.awt.Dimension(100, 250));

	  }
	  else if(splashWidth < 100)
	  {
        	setMaximumSize(new java.awt.Dimension(516, 32767));
        	setMinimumSize(new java.awt.Dimension(216, splashHeight + 47));
        	setPreferredSize(new java.awt.Dimension(216, splashHeight + 47));
        	SplashButtonPanel.setMaximumSize(new java.awt.Dimension(116, 32767));
        	SplashButtonPanel.setMinimumSize(new java.awt.Dimension(116, splashHeight));
        	SplashButtonPanel.setPreferredSize(new java.awt.Dimension(116, splashHeight + 1));
        	TopPanel.setMaximumSize(new java.awt.Dimension(516, splashHeight + 1));
        	TopPanel.setMinimumSize(new java.awt.Dimension(216, splashHeight));
        	TopPanel.setPreferredSize(new java.awt.Dimension(216, splashHeight + 1));
        	SplashPanel.setMaximumSize(new java.awt.Dimension(100, splashHeight + 1));
        	SplashPanel.setMinimumSize(new java.awt.Dimension(100, 250));
        	SplashPanel.setPreferredSize(new java.awt.Dimension(100, splashHeight + 1));
	  }
	  else if(splashHeight < 250)
	  {
        	setMaximumSize(new java.awt.Dimension(splashWidth + 116, 299));
        	setMinimumSize(new java.awt.Dimension(216, 299));
        	setPreferredSize(new java.awt.Dimension(splashWidth + 116, 299));
        	SplashButtonPanel.setMaximumSize(new java.awt.Dimension(116, 250));
        	SplashButtonPanel.setMinimumSize(new java.awt.Dimension(116, 250));
        	SplashButtonPanel.setPreferredSize(new java.awt.Dimension(116, 250));
        	TopPanel.setMaximumSize(new java.awt.Dimension(32767, 250));
        	TopPanel.setMinimumSize(new java.awt.Dimension(216, 250));
        	TopPanel.setPreferredSize(new java.awt.Dimension(splashWidth + 116, 250));
        	SplashPanel.setMaximumSize(new java.awt.Dimension(splashWidth + 1, 250));
        	SplashPanel.setMinimumSize(new java.awt.Dimension(216, 250));
        	SplashPanel.setPreferredSize(new java.awt.Dimension(splashWidth + 1, 250));
	  }
// End of Splash Screen Variables

// Button Panel Variables
          
   
if(ProjectManager.get("btnBarBGColor")!=null)
{
	if(ProjectManager.get("btnBarBGColor").equalsIgnoreCase("")==false)
	{
		Object[] tmpArray = getStringArraysFromString(ProjectManager.get("btnBarBGColor"));
		SplashButtonPanelTarget.setBackgroundColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
	}
}
if(ProjectManager.get("btnBarButtonBGColor")!=null)
{
	if(ProjectManager.get("btnBarButtonBGColor").equalsIgnoreCase("")==false)
	{
		// setImageBackgroundColor() must be called after setBackground() to be effective 
		Object[] tmpArray = getStringArraysFromString(ProjectManager.get("btnBarButtonBGColor"));
		SplashButtonPanelTarget.setButtonBackgroundColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
	}
}
if(ProjectManager.get("btnBarImgBGColor")!=null)
{
	if(ProjectManager.get("btnBarImgBGColor").equalsIgnoreCase("")==false)
	{
		// setImageBackgroundColor() must be called after setBackground() to be effective 
		Object[] tmpArray = getStringArraysFromString(ProjectManager.get("btnBarImgBGColor"));
		SplashButtonPanelTarget.setImageBackgroundColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
	}
}
if(ProjectManager.get("btnBarTextColor")!=null)
{
	if(ProjectManager.get("btnBarTextColor").equalsIgnoreCase("")==false)
	{
		Object[] tmpArray = getStringArraysFromString(ProjectManager.get("btnBarTextColor"));
		SplashButtonPanelTarget.setTextColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
	}
}

if(ProjectManager.get("btnBarTextFont")!=null)
{
	if(ProjectManager.get("btnBarTextFont").equalsIgnoreCase("")==false)
	{
		Object[] tmpArray = getStringArraysFromString(ProjectManager.get("btnBarTextFont"));
		SplashButtonPanelTarget.setTextFont((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
	}
}

if(ProjectManager.get("btnBarImgOverideDefaultPanelSize")!=null)
{
	if(ProjectManager.get("btnBarImgOverideDefaultPanelSize").equalsIgnoreCase("true")==true)
	{
		SplashButtonPanelTarget.setOverideDefaultPanelSize(new Integer(ProjectManager.get("btnBarImgOveridePanelWidth")).intValue(), new Integer(ProjectManager.get("btnBarImgOveridePanelHeight")).intValue());
	}
}

if(ProjectManager.get("btnBarImgBtnEnabled")!=null)
{
	if(ProjectManager.get("btnBarImgBtnEnabled").equalsIgnoreCase("true")==true)
	{
		SplashButtonPanelTarget.setImageButtonEnabled(true);
		SplashButtonPanelTarget.setImageActionType(new Integer(ProjectManager.get("btnBarImgActionType")).intValue());
		SplashButtonPanelTarget.setImageAction(ProjectManager.get("btnBarImgAction"));
	}
	else
	{
		SplashButtonPanelTarget.setImageButtonEnabled(false);
	}
}

if(ProjectManager.get("btnBarUseEvalButtonEnabled")!=null)
{
	if(ProjectManager.get("btnBarUseEvalButtonEnabled").equalsIgnoreCase("true")==true)
	{
		SplashButtonPanelTarget.setUseEvaluationButtonEnabled(true);
		SplashButtonPanelTarget.setUseEvaluationButtonAction(new Integer(ProjectManager.get("useEvaluationActionType")).intValue(), ProjectManager.get("useEvaluationAction"));
		SplashButtonPanelTarget.setUseEvaluationButtonText(ProjectManager.get("btnBarUseEvalButtonText"));
		if(ProjectManager.get("btnBarUseEvalButtonMnemonic").equalsIgnoreCase("")==false)
		{
			SplashButtonPanelTarget.setUseEvaluationButtonMnemonic(ProjectManager.get("btnBarUseEvalButtonMnemonic").charAt(0));
		}
	}
	else
	{
		SplashButtonPanelTarget.setUseEvaluationButtonEnabled(false);
	}
}
if(ProjectManager.get("btnBarBuyNowButtonEnabled")!=null)
{
	if(ProjectManager.get("btnBarBuyNowButtonEnabled").equalsIgnoreCase("true")==true)
	{
		SplashButtonPanelTarget.setBuyNowButtonEnabled(true);
		SplashButtonPanelTarget.setBuyNowButtonAction(new Integer(ProjectManager.get("buyNowActionType")).intValue(), ProjectManager.get("buyNowAction"));
		SplashButtonPanelTarget.setBuyNowButtonText(ProjectManager.get("btnBarBuyNowButtonText"));
		if(ProjectManager.get("btnBarBuyNowButtonMnemonic").equalsIgnoreCase("")==false)
		{
			SplashButtonPanelTarget.setBuyNowButtonMnemonic(ProjectManager.get("btnBarBuyNowButtonMnemonic").charAt(0));
		}
	}
	else
	{
		SplashButtonPanelTarget.setBuyNowButtonEnabled(false);
	}
}
if(ProjectManager.get("btnBarRegButtonEnabled")!=null)
{
	if(ProjectManager.get("btnBarRegButtonEnabled").equalsIgnoreCase("true")==true)
	{
		SplashButtonPanelTarget.setRegisterButtonEnabled(true);
		SplashButtonPanelTarget.setRegisterButtonAction(new Integer(ProjectManager.get("enterRegistrationCodeActionType")).intValue(), ProjectManager.get("enterRegistrationCodeAction"));
		SplashButtonPanelTarget.setRegisterButtonText(ProjectManager.get("btnBarRegButtonText"));
		if(ProjectManager.get("btnBarRegButtonMnemonic").equalsIgnoreCase("")==false)
		{
			SplashButtonPanelTarget.setRegisterButtonMnemonic(ProjectManager.get("btnBarRegButtonMnemonic").charAt(0));
		}
	}
	else
	{
		SplashButtonPanelTarget.setRegisterButtonEnabled(false);
	}
}
if(ProjectManager.get("btnBarInfoButtonEnabled")!=null)
{
	if(ProjectManager.get("btnBarInfoButtonEnabled").equalsIgnoreCase("true")==true)
	{
		SplashButtonPanelTarget.setInformationButtonEnabled(true);
		SplashButtonPanelTarget.setInformationButtonAction(new Integer(ProjectManager.get("infoActionType")).intValue(), ProjectManager.get("infoAction"));
		SplashButtonPanelTarget.setInformationButtonText(ProjectManager.get("btnBarInfoButtonText"));
		if(ProjectManager.get("btnBarInfoButtonMnemonic").equalsIgnoreCase("")==false)
		{
			SplashButtonPanelTarget.setInformationButtonMnemonic(ProjectManager.get("btnBarInfoButtonMnemonic").charAt(0));
		}
	}
	else
	{
		SplashButtonPanelTarget.setInformationButtonEnabled(false);
	}
}
if(ProjectManager.get("btnBarExitButtonEnabled")!=null)
{
	if(ProjectManager.get("btnBarExitButtonEnabled").equalsIgnoreCase("true")==true)
	{
		SplashButtonPanelTarget.setExitButtonEnabled(true);
		SplashButtonPanelTarget.setExitButtonText(ProjectManager.get("btnBarExitButtonText"));
		if(ProjectManager.get("btnBarExitButtonMnemonic").equalsIgnoreCase("")==false)
		{
			SplashButtonPanelTarget.setExitButtonMnemonic(ProjectManager.get("btnBarExitButtonMnemonic").charAt(0));
		}
	}
	else
	{
		SplashButtonPanelTarget.setExitButtonEnabled(false);
	}

}

// End Button Panel Variables

// Progress Panel Properties
// TODO: isProgressBarEnabled is not a used property in the first release, due to not implementation of a text alternative in the Horizontal Button Bar.
if(ProjectManager.get("isProgressBarEnabled").equalsIgnoreCase("true")==true)
{
	if(ProjectManager.get("progressPanelImgEnabled").equalsIgnoreCase("true")==true)
	{
		// Progress Panel Image Properties
		TrialBarProgressPanelTarget.setComponentLeftBorderEnabled(true);
		if(ProjectManager.get("progressPanelLeftBorderColor")!=null)
		{
			if(ProjectManager.get("progressPanelLeftBorderColor").equalsIgnoreCase("")==false)
			{
				Object[] tmpArray = getStringArraysFromString(ProjectManager.get("progressPanelLeftBorderColor"));
				TrialBarProgressPanelTarget.setComponentLeftBorderColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
		}

		TrialBarButtonPanelTarget.setActionType(new Integer(ProjectManager.get("progressPanelImgActionType")).intValue());
		if(ProjectManager.get("progressPanelImgAction")!=null)
		{
			TrialBarButtonPanelTarget.setAction(ProjectManager.get("progressPanelImgAction"));
		}

		if(ProjectManager.get("progressPanelImgBGColor")!=null)
		{
			if(ProjectManager.get("progressPanelImgBGColor").equalsIgnoreCase("")==false)
			{
				Object[] tmpArray = getStringArraysFromString(ProjectManager.get("progressPanelImgBGColor"));
				TrialBarButtonPanelTarget.setBackgroundColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
		}
		if(ProjectManager.get("progressPanelImgOverideDefaultPanelSize")!=null)
		{
			if(ProjectManager.get("progressPanelImgOverideDefaultPanelSize").equalsIgnoreCase("true")==true)
			{
				TrialBarButtonPanelTarget.setOverideDefaultPanelSize(new Integer(ProjectManager.get("progressPanelImgOveridePanelWidth")).intValue(), new Integer(ProjectManager.get("progressPanelImgOveridePanelHeight")).intValue());
			}
		}
		// End Progress Panel Image Properties
	}
	else
	{
		TrialBarProgressPanelTarget.setComponentLeftBorderEnabled(false);
	}
}
else
{
	//Text Style Vertical Button Bar is not implemented in the first release.
}


if(ProjectManager.get("progressBarBGColor")!=null)
{
	if(ProjectManager.get("progressBarBGColor").equalsIgnoreCase("")==false)
	{
		Object[] tmpArray = getStringArraysFromString(ProjectManager.get("progressBarBGColor"));
		TrialBarProgressPanelTarget.setBackgroundColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
	}
}

if(ProjectManager.get("progressBarColor")!=null)
{
	if(ProjectManager.get("progressBarColor").equalsIgnoreCase("")==false)
	{
		Object[] tmpArray = getStringArraysFromString(ProjectManager.get("progressBarColor"));
		TrialBarProgressPanelTarget.setProgressBarColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
	}
}

if(ProjectManager.get("progressBarHighlightBorderColor")!=null)
{
	if(ProjectManager.get("progressBarShadowBorderColor")!=null)
	{
		if(ProjectManager.get("progressBarHighlightBorderColor").equalsIgnoreCase("")==false || ProjectManager.get("progressBarShadowBorderColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("progressBarHighlightBorderColor"));
			Object[] tmpArray2 = getStringArraysFromString(ProjectManager.get("progressBarShadowBorderColor"));
			TrialBarProgressPanelTarget.setProgressBarBorderColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()),new java.awt.Color(new Integer((String)tmpArray2[0]).intValue(),new Integer((String)tmpArray2[1]).intValue(),new Integer((String)tmpArray2[2]).intValue()) );
		}
	}
}

if(ProjectManager.get("progressPanelTextColor")!=null)
{
	if(ProjectManager.get("progressPanelTextColor").equalsIgnoreCase("")==false)
	{
		Object[] tmpArray = getStringArraysFromString(ProjectManager.get("progressPanelTextColor"));
		TrialBarProgressPanelTarget.setTextColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
	}
}

if(ProjectManager.get("progressPanelTextFont")!=null)
{
	if(ProjectManager.get("progressPanelTextFont").equalsIgnoreCase("")==false)
	{
		Object[] tmpArray = getStringArraysFromString(ProjectManager.get("progressPanelTextFont"));
		TrialBarProgressPanelTarget.setTextFont((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
	}
}

// End Progress Panel Properties


        TopPanel.setLayout(new javax.swing.BoxLayout(TopPanel, javax.swing.BoxLayout.X_AXIS));

        SplashPanel.setLayout(new java.awt.BorderLayout());

if(ProjectManager.get("startWindowPanelSeparatorHighlightBorderColor")!=null)
{
	if(ProjectManager.get("startWindowPanelSeparatorShadowBorderColor")!=null)
	{
		if(ProjectManager.get("startWindowPanelSeparatorHighlightBorderColor").equalsIgnoreCase("")==false || ProjectManager.get("startWindowPanelSeparatorShadowBorderColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("startWindowPanelSeparatorHighlightBorderColor"));
			Object[] tmpArray2 = getStringArraysFromString(ProjectManager.get("startWindowPanelSeparatorShadowBorderColor"));
			Color highlightColor = new Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
			Color shadowColor = new Color(new Integer((String)tmpArray2[0]).intValue(),new Integer((String)tmpArray2[1]).intValue(),new Integer((String)tmpArray2[2]).intValue());
		      TopPanel.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 1, 0), shadowColor));
        		SplashPanel.setBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 1, 1), highlightColor));
		      SplashButtonPanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 1, 0, 0), shadowColor), new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 1, 0), highlightColor)));
		}
	}
}
        SplashPanel.add(SplashPanelTarget, java.awt.BorderLayout.CENTER);



        SplashButtonPanel.setLayout(new java.awt.BorderLayout());
        SplashButtonPanel.add(SplashButtonPanelTarget, java.awt.BorderLayout.CENTER);

        BottomPanel.setLayout(new java.awt.BorderLayout());

        BottomPanel.setMaximumSize(new java.awt.Dimension(32767, 44));
        BottomPanel.setMinimumSize(new java.awt.Dimension(10, 44));
        BottomPanel.setPreferredSize(new java.awt.Dimension(10, 44));
        TrialBarButtonPanel.setLayout(new java.awt.BorderLayout());

        TrialBarButtonPanel.setMaximumSize(new java.awt.Dimension(44, 44));
        TrialBarButtonPanel.setMinimumSize(new java.awt.Dimension(44, 44));
        TrialBarButtonPanel.setPreferredSize(new java.awt.Dimension(44, 44));
        TrialBarButtonPanel.add(TrialBarButtonPanelTarget, java.awt.BorderLayout.CENTER);


        TrialBarProgressPanel.setLayout(new java.awt.BorderLayout());

        TrialBarProgressPanel.setMaximumSize(new java.awt.Dimension(2147483647, 44));
        TrialBarProgressPanel.setMinimumSize(new java.awt.Dimension(10, 44));
        TrialBarProgressPanel.setPreferredSize(new java.awt.Dimension(10, 44));
        TrialBarProgressPanelTarget.setMaximumSize(new java.awt.Dimension(32767, 44));
        TrialBarProgressPanelTarget.setMinimumSize(new java.awt.Dimension(10, 44));
        TrialBarProgressPanelTarget.setPreferredSize(new java.awt.Dimension(10, 44));
        TrialBarProgressPanel.add(TrialBarProgressPanelTarget, java.awt.BorderLayout.CENTER);

	if(ProjectManager.get("i18nBiDiEnabled")!=null)
	{
		if(ProjectManager.get("i18nBiDiEnabled").equalsIgnoreCase("true")==true)
		{
        		TopPanel.add(SplashButtonPanel);
        		TopPanel.add(SplashPanel);
			if(ProjectManager.get("isProgressBarEnabled").equalsIgnoreCase("true")==true)
			{
				if(ProjectManager.get("progressPanelImgEnabled").equalsIgnoreCase("true")==true)
				{
        				BottomPanel.add(TrialBarButtonPanel, java.awt.BorderLayout.EAST);
				}
        			BottomPanel.add(TrialBarProgressPanel, java.awt.BorderLayout.CENTER);
			}
		}
		else
		{
        		TopPanel.add(SplashPanel);
        		TopPanel.add(SplashButtonPanel);
			if(ProjectManager.get("isProgressBarEnabled").equalsIgnoreCase("true")==true)
			{
				if(ProjectManager.get("progressPanelImgEnabled").equalsIgnoreCase("true")==true)
				{
        				BottomPanel.add(TrialBarButtonPanel, java.awt.BorderLayout.WEST);
				}
        			BottomPanel.add(TrialBarProgressPanel, java.awt.BorderLayout.CENTER);
			}
		}
	}
	else
	{
        	TopPanel.add(SplashPanel);
        	TopPanel.add(SplashButtonPanel);
		if(ProjectManager.get("isProgressBarEnabled").equalsIgnoreCase("true")==true)
		{
			if(ProjectManager.get("progressPanelImgEnabled").equalsIgnoreCase("true")==true)
			{
        			BottomPanel.add(TrialBarButtonPanel, java.awt.BorderLayout.WEST);
			}
        		BottomPanel.add(TrialBarProgressPanel, java.awt.BorderLayout.CENTER);
		}
	}

        add(TopPanel);
        add(BottomPanel);
	  if(ProjectManager.get("project_expiration_support_is_enabled").equalsIgnoreCase("false")==true)
	  {
		TrialBarProgressPanelTarget.setTimerIsVisible(false);
	  }
    }//GEN-END:initComponents
    
    private static Object[] getStringArraysFromString(String textArrayString)
    {
        ArrayList aryList = new ArrayList();
        String tempString = "";
        
        while(textArrayString.indexOf(",")!=-1)
        {
            tempString = textArrayString.substring(0,textArrayString.indexOf(","));
            textArrayString = textArrayString.substring(textArrayString.indexOf(",") + 1);
            aryList.add(tempString);
        }
        aryList.add(textArrayString);
        return aryList.toArray();
    }
	protected void setMasterControlComp(dlgStartupWindowVerticalButtonBar theDialog)
	{
		SplashButtonPanelTarget.setMasterControlComp(theDialog);
	}
    public void setComponentOrientation(ComponentOrientation theOrientation)
    {
        this.setComponentOrientation(theOrientation);
        SplashButtonPanelTarget.setComponentOrientation(theOrientation);
        SplashPanelTarget.setComponentOrientation(theOrientation);
        TrialBarButtonPanelTarget.setComponentOrientation(theOrientation);
        TrialBarProgressPanelTarget.setComponentOrientation(theOrientation);
	 // if(theOrientation
    }   
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BottomPanel;
    private javax.swing.JPanel SplashButtonPanel;
    private ButtonPanel SplashButtonPanelTarget;
    private javax.swing.JPanel SplashPanel;
    private SplashImagePanel SplashPanelTarget;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JPanel TrialBarButtonPanel;
    private EAAboutButton TrialBarButtonPanelTarget;
    private javax.swing.JPanel TrialBarProgressPanel;
    private DaysLeftCounter TrialBarProgressPanelTarget;
    private boolean isExpired;
    private long totaldays;
    private long days;
    // End of variables declaration//GEN-END:variables
    
}
