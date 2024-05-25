/*
 * MessagePane.java
 *
 * Created on July 5, 2004, 11:57 PM
 */

package com.trinity.ea.design.autoupdate.preview.messaging;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.SwingUtilities;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.RenderingHints;  

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class MessagePane extends JTextPane
{
    StyledDocument doc;
    MutableAttributeSet standard;
    /** Creates a new instance of MessagePane */
    public MessagePane(int textalignment)
    {
        setBorder(null);
        doc = getStyledDocument();
        //  Set alignment to be centered for all paragraphs
        standard = new SimpleAttributeSet();
        StyleConstants.setAlignment(standard, textalignment);
        //
   
        doc.setParagraphAttributes(0, 0, standard, false);

        //  Define a keyword attribute
    }
    
    public void setAlignment(int styleConstantsAlignment)
    {
        doc = getStyledDocument();
        //  Set alignment to be centered for all paragraphs
        standard = new SimpleAttributeSet();
        StyleConstants.setAlignment(standard, styleConstantsAlignment);
        //
   
        doc.setParagraphAttributes(0, 0, standard, false); 
    }
    
    public void setText(String message)
    {
        try
        {
            doc.insertString(0, message, null );
        }
        catch(Exception e) {}       
        
    }
     public void paint(Graphics g)
    {
	Graphics2D g2 = (Graphics2D) g;
	g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT);
	super.paint(g);
    }       
}
