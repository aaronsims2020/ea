package com.trinity.ea.design.optin.preview.gui.swing;
import javax.swing.plaf.basic.BasicScrollBarUI;
import com.trinity.ea.design.common.file.ProjectManager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.ImageIcon;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.JButton;
import javax.swing.plaf.ComponentUI;
import java.util.ArrayList;
import java.net.URL;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class EAScrollBarUI extends BasicScrollBarUI {
	private Color bgArrowBtnColor = Color.white;
	private Color shadowArrowBtnColor = new java.awt.Color(38,54,69);
	private Color darkShadowArrowBtnColor = Color.white;
	private Color ltHighlightArrowBtnColor = new java.awt.Color(38,54,69);
	private Color trackColor1 = new java.awt.Color(222, 226, 226);
	private Color trackHighlightColor1 = new java.awt.Color(222, 226, 226);
private ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/images/thumb.png"));

public EAScrollBarUI()
{
	super();
try
{
	if(ProjectManager.get("sbBGArrowBtnColor")!=null)
	{
		if(ProjectManager.get("sbBGArrowBtnColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("sbBGArrowBtnColor"));
			bgArrowBtnColor = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
	}
	if(ProjectManager.get("sbShadowArrowBtnColor")!=null)
	{
		if(ProjectManager.get("sbShadowArrowBtnColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("sbShadowArrowBtnColor"));
			shadowArrowBtnColor = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
	}
	if(ProjectManager.get("sbDarkShadowArrowBtnColor")!=null)
	{
		if(ProjectManager.get("sbDarkShadowArrowBtnColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("sbDarkShadowArrowBtnColor"));
			darkShadowArrowBtnColor = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
	}
	if(ProjectManager.get("sbLtHighlightArrowBtnColor")!=null)
	{
		if(ProjectManager.get("sbLtHighlightArrowBtnColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("sbLtHighlightArrowBtnColor"));
			ltHighlightArrowBtnColor = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
	}
	if(ProjectManager.get("sbTrackColor")!=null)
	{
		if(ProjectManager.get("sbTrackColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("sbTrackColor"));
			trackColor1 = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
	}
	if(ProjectManager.get("sbTrackHighlightColor")!=null)
	{
		if(ProjectManager.get("sbTrackHighlightColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("sbTrackHighlightColor"));
			trackHighlightColor1 = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
	}
	try
	{
	if(ProjectManager.get("sbThumbImagePath")!=null)
	{
		if(ProjectManager.get("sbThumbImagePath").equalsIgnoreCase("")==false)
		{
			icon = new javax.swing.ImageIcon(new URL(ProjectManager.get("sbThumbImagePath")));
		}
	}
	}
	catch(Exception e){}
}
catch(Exception e)
{
	e.printStackTrace();
}
}
protected void configureScrollBarColors()
{
	trackColor = trackColor1;
	trackHighlightColor = trackHighlightColor1;
}

public Color getThumbColor() {
return thumbColor;
}
public void setThumbColor(Color c) 
{
    thumbColor = c;
}

public Color getTrackColor() 
{
    return trackColor;
}

public void setTrackColor(Color c) 
{
    trackColor = c;
}
public void setTrackHighlightColor(Color c) 
{
    trackHighlightColor = c;
}

public Color getThumbHighlightColor() 
{
    return thumbHighlightColor;
}

public void setThumbHighlightColor(Color c) 
{
    thumbHighlightColor = c;
}

public Color getLightShadowColor() 
{
    return thumbLightShadowColor;
}

public void setThumbLightShadowColor(Color c) 
{
    thumbLightShadowColor = c;
}

public Color getDarkShadowColor() 
{
    return thumbDarkShadowColor;
}

public void setThumbDarkShadowColor(Color c) 
{
    thumbDarkShadowColor = c;
}
	public static ComponentUI createUI(JComponent c)
	{
		return new EAScrollBarUI();
	}

	protected JButton createDecreaseButton(int orientation)
	{
		JButton button = new BasicArrowButton(orientation, bgArrowBtnColor, shadowArrowBtnColor, darkShadowArrowBtnColor, ltHighlightArrowBtnColor);
		//button.setBackground(new java.awt.Color(38,54,69));
		return button;
	}

	protected JButton createIncreaseButton(int orientation)
	{
		JButton button = new BasicArrowButton(orientation, bgArrowBtnColor, shadowArrowBtnColor, darkShadowArrowBtnColor, ltHighlightArrowBtnColor);
		//button.setBackground(new java.awt.Color(38,54,69));
		return button;
	}

protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) 
{
    if(thumbBounds.isEmpty() || !scrollbar.isEnabled()) return;
    int w = thumbBounds.width;
    int h = thumbBounds.height;	
    //Here's the gif image that gets drawn on the thumb...
    g.translate(thumbBounds.x, thumbBounds.y);
    g.drawImage(icon.getImage(),0,0,thumbBounds.width,thumbBounds.height,c);
}

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
}
