package com.trinity.ea.autoupdate.messaging;

import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.ImageIcon;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.JButton;
import javax.swing.plaf.ComponentUI;

public class EAMessageScrollBarUI extends BasicScrollBarUI {
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
		return new EAMessageScrollBarUI();
	}

	protected JButton createDecreaseButton(int orientation)
	{
		JButton button = new BasicArrowButton(orientation);
		button.setBackground(new java.awt.Color(38,54,69));
                button.setBorder(null);
		return button;
	}

	protected JButton createIncreaseButton(int orientation)
	{
		JButton button = new BasicArrowButton(orientation);
		button.setBackground(new java.awt.Color(38,54,69));
		return button;
	}

protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) 
{
    if(thumbBounds.isEmpty() || !scrollbar.isEnabled()) return;
    int w = thumbBounds.width;
    int h = thumbBounds.height;	
    //Here's the gif image that gets drawn on the thumb...
    ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/images/mthumb.png"));
    g.translate(thumbBounds.x, thumbBounds.y);
    g.drawImage(icon.getImage(),0,0,null);
}
}
