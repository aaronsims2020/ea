/*
 * ImageButton2.java
 *
 * Created on July 20, 2004, 7:18 PM
 */

package com.trinity.ea.design.registration.preview.gui.swing;
import javax.swing.JPanel;
import com.trinity.ea.design.registration.preview.gui.swing.ImageButton;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author  aaronsc
 */
public class ImageButtonPanel extends JPanel
{
   ImageButton iButton; 
    /** Creates a new instance of ImageButton2 */
    public ImageButtonPanel(ImageIcon buttonFace, ImageIcon buttonFaceOnClick, ImageIcon buttonFaceInFocus, int width, int height)  
    {
        try
        {
            setLayout(null);
            iButton = new ImageButton(buttonFace, buttonFaceOnClick, buttonFaceInFocus, width, height);
            iButton.setPreferredSize(new java.awt.Dimension(width,height));
            iButton.setMaximumSize(new java.awt.Dimension(width,height));
            iButton.setMinimumSize(new java.awt.Dimension(width,height));
            setSize(new java.awt.Dimension(width,height));
            add(iButton);
            iButton.setBounds(0,0,width,height);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public ImageButton getImageButton()
    {
        return iButton;
    } 
}
