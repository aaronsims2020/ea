/*
 * dlgRegistrationFailure.java
 *
 * Created on October 24, 2003, 3:39 AM
 */

package com.trinity.ea.forms.registration.ui.swing;
import javax.swing.*;
import java.awt.*;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import com.trinity.ea.forms.gui.swing.ImageButton;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2005 Trinity Software. All rights reserved.
 */
public class dlgRegistrationFailure extends javax.swing.JDialog {
        private ImageIcon btnFace = null;
    	  private ImageIcon btnFaceOnClick = null;
   	  private ImageIcon btnFaceInFocus = null;
    	  private int btnWidth = -1;
    	  private int btnHeight = -1;    
    	  private boolean isImageButton = false;

    /** Creates new form RegistrationComplete */
    public dlgRegistrationFailure(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
	  if(EncryptedRuleReader.get("btnBarImgButtonsEnabled")!=null)
	  {
	  	if(EncryptedRuleReader.get("btnBarImgButtonsEnabled").equalsIgnoreCase("true")==true)
	  	{
			isImageButton=true;
		}
		else
		{
			isImageButton=false;
		}
	  }
	  else
	  {
		isImageButton=false;
	  }

	  if(EncryptedRuleReader.get("registrationImgButtonWidth")!=null)
	  {
	  	if(EncryptedRuleReader.get("registrationImgButtonWidth").equalsIgnoreCase("")==false)
	  	{
			try
			{
				btnWidth = new Integer(EncryptedRuleReader.get("registrationImgButtonWidth")).intValue();
			}
			catch(Exception eee)
			{
				//eee.printStackTrace();
				btnWidth = 95;
			}
		}
		else
		{
			btnWidth = 95;
		}
	  }
	  else
	  {
		btnWidth = 95;
	  }	  
	  if(EncryptedRuleReader.get("registrationImgButtonHeight")!=null)
	  {
	  	if(EncryptedRuleReader.get("registrationImgButtonHeight").equalsIgnoreCase("")==false)
	  	{
			try
			{
				btnHeight = new Integer(EncryptedRuleReader.get("registrationImgButtonHeight")).intValue();
			}
			catch(Exception eee)
			{
				//eee.printStackTrace();
				btnHeight = 24;
			}
		}
		else
		{
			btnHeight = 24;
		}
	  }
	  else
	  {
		btnHeight = 24;
	  }	  
if(isImageButton==true)
{
		if(EncryptedRuleReader.get("registrationImgButtonFace")!=null)
		{
			if(EncryptedRuleReader.get("registrationImgButtonFace").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFace = new javax.swing.ImageIcon(getClass().getResource(EncryptedRuleReader.get("registrationImgButtonFace")));
				}
				catch(Exception e)
				{
					//e.printStackTrace();
					isImageButton=false;
				}
			}
		}
		if(EncryptedRuleReader.get("registrationImgButtonFaceOnClick")!=null)
		{
			if(EncryptedRuleReader.get("registrationImgButtonFaceOnClick").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceOnClick = new javax.swing.ImageIcon(getClass().getResource(EncryptedRuleReader.get("registrationImgButtonFaceOnClick")));

				}
				catch(Exception e)
				{
					//e.printStackTrace();
				}
			}
		}
		if(EncryptedRuleReader.get("registrationButtonFaceInFocus")!=null)
		{
			if(EncryptedRuleReader.get("registrationButtonFaceInFocus").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceInFocus = new javax.swing.ImageIcon(getClass().getResource(EncryptedRuleReader.get("registrationButtonFaceInFocus")));
				}
				catch(Exception e)
				{
					//e.printStackTrace();
				}
			}
		}
}

	  if(btnFace!=null)
	  {
		if(btnFaceOnClick!=null)
		{
			initComponents(true);
		}
		else
		{
			initComponents(false);
		}
	  }
	  else
	  {
        	initComponents(false);
	  }

        setSize(190 + getHorizontalInsetAdjustment(this.getInsets().left, this.getInsets().right), 122 + getVerticalInsetAdjustment(this.getInsets().top, this.getInsets().bottom));
        setResizable(false);
        // Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        int w = getSize().width;
        int h = getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        try
        {
            setTitle(EncryptedRuleReader.getLocaleString("registrationFailedWindowTitle"));
        }
        catch(Exception e){}
	  if(EncryptedRuleReader.get("registrationTextColor")!=null)
	  {
		if(EncryptedRuleReader.get("registrationTextColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("registrationTextColor"));
			setFontColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }
	  if(EncryptedRuleReader.get("registrationBackgroundColor")!=null)
	  {
		if(EncryptedRuleReader.get("registrationBackgroundColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("registrationBackgroundColor"));
			setBackgroundColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }
	setButtonTextColor();
	try
	{
	  	  applyComponentOrientation(ComponentOrientation.getOrientation(EncryptedRuleReader.getLocale()));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
        // Move the window
        setLocation(x, y);        
    }

private int getVerticalInsetAdjustment(int actualTopInset, int actualBottomInset)
{
	try
	{
		int sum = actualTopInset + actualBottomInset;
		if(sum!=25)
		{
			if(sum<25)
			{
		    		return 0 - (25 - sum);
			}
			else if(sum>25)
			{
		     		return 0 + (sum - 25);
			}
		}
		else
		{
			return 0;
		}
	}
	catch(Exception e)
	{
		return 0;
	}
	return 0;
}

private int getHorizontalInsetAdjustment(int actualLeftInset, int actualRightInset)
{
	try
	{
		int sum = actualLeftInset + actualRightInset;
		if(sum!=6)
		{
			if(sum<6)
			{
		    		return 0 - (6 - sum);
			}
			else if(sum>6)
			{
		     		return 0 + (sum - 6);
			}
		}
		else
		{
			return 0;
		}
	}
	catch(Exception e)
	{
		return 0;
	}
	return 0;
}
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents(boolean isImgButton) {//GEN-BEGIN:initComponents
	  isImageButton = isImgButton;
        lHeaderDescription = new javax.swing.JLabel();
	  if(isImageButton==true)
	  {
        	btnImageOK = new ImageButton(btnFace,btnFaceOnClick,btnFaceInFocus,btnWidth,btnHeight);
	  }
	  else
	  {
        	btnOK = new javax.swing.JButton();
	  }

        getContentPane().setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Invalid Code");
        //setBackground(new java.awt.Color(204, 204, 204));
        setModal(true);
        setName("dlgInvalidRegistrationCode");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        if(EncryptedRuleReader.get("registrationCodeLabelFont")!=null)
	  {
		if(EncryptedRuleReader.get("registrationCodeLabelFont").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("registrationCodeLabelFont"));
      		lHeaderDescription.setFont(new java.awt.Font((String)tmpArray[0], new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }
	  else
	  {
		lHeaderDescription.setFont(new java.awt.Font("SansSerif", 0, 12));
	  }
	  if(EncryptedRuleReader.getLocaleString("registrationFailedMessage")!=null)
	  {
        	lHeaderDescription.setText(EncryptedRuleReader.getLocaleString("registrationFailedMessage"));
	  }
        getContentPane().add(lHeaderDescription);
        lHeaderDescription.setBounds(20, 20, 200, 23);
	
	  if(EncryptedRuleReader.getLocaleString("registrationFailureOK")!=null)
	  {

        
	  if(isImageButton==true)
	  {
        	btnImageOK.setText(EncryptedRuleReader.getLocaleString("registrationFailureOK"));
	  }
	  else
	  {
        	btnOK.setText(EncryptedRuleReader.getLocaleString("registrationFailureOK"));
	  }
	  }
	  else
	  {
	  if(isImageButton==true)
	  {
        	btnImageOK.setText("OK");
	  }
	  else
	  {
                	btnOK.setText("OK");
	  }
	  }
	  if(isImageButton==true)
	  {
	  if(EncryptedRuleReader.getLocaleString("registrationFailureOKMnemonic")!=null)
	  {
	  	if(EncryptedRuleReader.getLocaleString("registrationFailureOKMnemonic").equalsIgnoreCase("")==false)
	  	{
	      btnImageOK.setMnemonic(EncryptedRuleReader.getLocaleString("registrationFailureOKMnemonic").charAt(0));
		}
	  }
	  }
	  else
	  {
	  if(EncryptedRuleReader.getLocaleString("registrationFailureOKMnemonic")!=null)
	  {
	  	if(EncryptedRuleReader.getLocaleString("registrationFailureOKMnemonic").equalsIgnoreCase("")==false)
	  	{
	      	btnOK.setMnemonic(EncryptedRuleReader.getLocaleString("registrationFailureOKMnemonic").charAt(0));
		}
	  }
	  }
if(isImageButton==true)
{
	  	 if(EncryptedRuleReader.get("registrationButtonFont")!=null)
	  	 {
	  		if(EncryptedRuleReader.get("registrationButtonFont").equalsIgnoreCase("")==false)
			{
				Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("registrationButtonFont"));
      			btnImageOK.setFont(new java.awt.Font((String)tmpArray[0], new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
	  	  }
 btnImageOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImageCancelMouseClicked(evt);
            }
        });

        getContentPane().add(btnImageOK);
        btnImageOK.setBounds(40, 50, btnWidth, btnHeight);
}
else
{
	  	 if(EncryptedRuleReader.get("registrationButtonFont")!=null)
	  	 {
	  		if(EncryptedRuleReader.get("registrationButtonFont").equalsIgnoreCase("")==false)
			{
				Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("registrationButtonFont"));
      			btnOK.setFont(new java.awt.Font((String)tmpArray[0], new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
	  	  }
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        getContentPane().add(btnOK);
        btnOK.setBounds(50, 50, 81, 26);
}
	  	if(isImageButton==true)
	  	{
	  		setKeyManager();
		}
       pack();
    }//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        dispose();// Add your handling code here:
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnImageCancelMouseClicked(java.awt.event.MouseEvent evt) 
	{
		dispose();
	}
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog
    
    /**
     * @param args the command line arguments
     */
   // public static void main(String args[]) {
   //     new dlgRegistrationFailure(new javax.swing.JFrame(), true).show();
   // }

   public void setFontColor(Color fontColor)
   {
	try
	{
		lHeaderDescription.setForeground(fontColor);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
   }
   private Color btnTextColor = null;
   public void setButtonTextColor()
   {
	try
	{
	  if(EncryptedRuleReader.get("msgbtnfontclr")!=null)
	  {
		if(EncryptedRuleReader.get("msgbtnfontclr").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("msgbtnfontclr"));
			btnTextColor = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());

	  	if(isImageButton==true)
	  	{
			btnImageOK.setForeground(btnTextColor);
	  	}
		else
		{
			btnOK.setForeground(btnTextColor);
		}
	  	}
	  }
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
   }

   public void setBackgroundColor(Color BGColor)
   {
	try
	{
		getContentPane().setBackground(BGColor);
		lHeaderDescription.setBackground(BGColor);
	  	if(isImageButton==true)
	  	{
			btnImageOK.setBackground(BGColor);
	  	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
   }  

    public void paint(Graphics g)
    {
	Graphics2D g2 = (Graphics2D) g;
	g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	super.paint(g);
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

    public void setKeyManager()
    { 
     KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(
        new KeyEventDispatcher() {
            public boolean dispatchKeyEvent(KeyEvent e) 
            {
               
              if (e.getID() == KeyEvent.KEY_PRESSED) 
              {
                   if (e.isAltDown() == true || e.isMetaDown() == true || e.isControlDown()==true) 
                   {   
				armed = true;
			 }
              }            
                // This example converts all typed keys to upper case
              if (e.getID() == KeyEvent.KEY_RELEASED) 
              {
			if(armed==true)
			{
                        if(e.getComponent().equals(btnImageOK)==true)
                        {
				    if(e.getKeyCode()==btnImageOK.getDisplayedMnemonic())
                            {
					   dispose();
				    }
                        }
				armed = false;
			}
              }
              // If the key should not be dispatched to the
              // focused component, set discardEvent to true
              boolean discardEvent = false;
              return discardEvent;
            }
        });       
    }

    private boolean armed = false;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private ImageButton btnImageOK;
    private javax.swing.JLabel lHeaderDescription;
    // End of variables declaration//GEN-END:variables
    
}
