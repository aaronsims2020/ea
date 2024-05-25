/*
 * ImageButton.java
 *
 * Created on June 20, 2004, 11:00 PM
 */

package com.trinity.ea.forms.gui.swing;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.RenderingHints;  

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004-2005 Trinity Software. All rights reserved.
 */
public class ImageButton extends JLabel
{
    private ImageIcon btnFace = null;
    private ImageIcon btnFaceOnClick = null;
    private ImageIcon btnFaceInFocus = null; 
    private int actionType = -1; 
    private String btnAction = "";
    
    /** Creates a new instance of ImageButton */
    public ImageButton(ImageIcon buttonFace, ImageIcon buttonFaceOnClick,  ImageIcon buttonFaceInFocus, int width, int height) 
    {
        super();
        btnFace = buttonFace;
        btnFaceOnClick = buttonFaceOnClick;
        btnFaceInFocus = buttonFaceInFocus;
        if(btnFace!=null)
        {
          setIcon(btnFace);          
        }

        setMaximumSize(new java.awt.Dimension(width, height));
        setMinimumSize(new java.awt.Dimension(width, height));
        setPreferredSize(new java.awt.Dimension(width, height));
        setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        setOpaque(true);
	setFocusable(true); 
	setLabelFor(this); 
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                buttonFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                buttonFocusLost(evt);
            }
        });       
        addMouseListener(new java.awt.event.MouseAdapter() 
        {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                buttonMouseReleased(evt);
            }           
        });       
    }
    
    public void setMnemonic(char mnemonic)
    {
        setDisplayedMnemonic(mnemonic);
    }
    
     private void buttonMouseReleased(java.awt.event.MouseEvent evt) 
     {
        if(btnFace!=null)
        {         
		requestFocus(); 
            if(btnFaceInFocus!=null)
            {         
            	setIcon(btnFaceInFocus);
        	}      
        }
     }

    private void buttonMousePressed(java.awt.event.MouseEvent evt) {
        if(btnFaceOnClick!=null)
        {
            setIcon(btnFaceOnClick);  
        } 
    }
    private void buttonFocusLost(java.awt.event.FocusEvent evt) {
        if(btnFace!=null)
        {         
            setIcon(btnFace);
        }
    }

    private void buttonFocusGained(java.awt.event.FocusEvent evt) {
         if(btnFaceInFocus!=null)
        {         
            setIcon(btnFaceInFocus);
        }       
    } 
    
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(
        RenderingHints.KEY_TEXT_ANTIALIASING,
        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        super.paint(g);
    } 

}
