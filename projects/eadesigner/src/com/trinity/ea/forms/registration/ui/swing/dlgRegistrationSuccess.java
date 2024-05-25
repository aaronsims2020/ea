/*
 * RegistrationComplete.java
 *
 * Created on October 24, 2003, 3:39 AM
 */

package com.trinity.ea.forms.registration.ui.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
public class dlgRegistrationSuccess extends javax.swing.JDialog {
        private ImageIcon btnFace = null;
    	  private ImageIcon btnFaceOnClick = null;
   	  private ImageIcon btnFaceInFocus = null;
    	  private int btnWidth = -1;
    	  private int btnHeight = -1;    
    	  private boolean isImageButton = false;
    
    /** Creates new form RegistrationComplete */
    public dlgRegistrationSuccess(java.awt.Frame parent, boolean modal) {
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

        setSize(253 + getHorizontalInsetAdjustment(this.getInsets().left, this.getInsets().right), 141  + getVerticalInsetAdjustment(this.getInsets().top, this.getInsets().bottom));

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
            setTitle(EncryptedRuleReader.getLocaleString("registrationSuccessWindowTitle"));
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

	  setButtonTextColor();
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
        lHeaderDescription = new javax.swing.JLabel();
        lDescription = new javax.swing.JTextArea();
	  if(isImageButton==true)
	  {
        	btnImageOK = new ImageButton(btnFace,btnFaceOnClick,btnFaceInFocus,btnWidth,btnHeight);
	  }
	  else
	  {
        	btnOK = new javax.swing.JButton();
	  }

        getContentPane().setLayout(null);

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
      		lDescription.setFont(new java.awt.Font((String)tmpArray[0], new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }
	  else
	  {
		lHeaderDescription.setFont(new java.awt.Font("SansSerif", 0, 12));
		lDescription.setFont(new java.awt.Font("SansSerif", 0, 12));
	  }
lDescription.setBackground(getBackground());
lDescription.setSelectionColor(getBackground());
	  if(EncryptedRuleReader.getLocaleString("registrationSuccessHeader")!=null)
	  {
	        lHeaderDescription.setText(EncryptedRuleReader.getLocaleString("registrationSuccessHeader"));
	  }
	  else
	  {
        	lHeaderDescription.setText("Registration Success!");
	  }
        getContentPane().add(lHeaderDescription);
        lHeaderDescription.setBounds(20, 12, 200, 23);

        lDescription.setLineWrap(true);
	  lDescription.setEditable(false);
	  if(EncryptedRuleReader.getLocaleString("registrationSuccessDesc")!=null)
	  {
	        lDescription.setText(EncryptedRuleReader.getLocaleString("registrationSuccessDesc"));
	  }
	  else
	  {
        	lDescription.setText("Thank You for registering this software.");
	  }
        lDescription.setWrapStyleWord(true);
        getContentPane().add(lDescription);
        lDescription.setBounds(20, 42, 225, 32);


	  if(EncryptedRuleReader.getLocaleString("registrationSuccessOK")!=null)
	  {

        
	  if(isImageButton==true)
	  {
        	btnImageOK.setText(EncryptedRuleReader.getLocaleString("registrationSuccessOK"));
	  }
	  else
	  {
        	btnOK.setText(EncryptedRuleReader.getLocaleString("registrationSuccessOK"));
	  }
	  }
	  else
	  {
	  if(isImageButton==true)
	  {
        	btnImageOK.setText("Done");
	  }
	  else
	  {
                	btnOK.setText("Done");
	  }
	  }
	  if(isImageButton==true)
	  {
	  if(EncryptedRuleReader.getLocaleString("registrationSuccessOKMnemonic")!=null)
	  {
	  	if(EncryptedRuleReader.getLocaleString("registrationSuccessOKMnemonic").equalsIgnoreCase("")==false)
	  	{
	      	btnImageOK.setMnemonic(EncryptedRuleReader.getLocaleString("registrationSuccessOKMnemonic").charAt(0));
		}
	  }
	  }
	  else
	  {
	  if(EncryptedRuleReader.getLocaleString("registrationSuccessOKMnemonic")!=null)
	  {
	  	if(EncryptedRuleReader.getLocaleString("registrationSuccessOKMnemonic").equalsIgnoreCase("")==false)
	  	{
	      	btnOK.setMnemonic(EncryptedRuleReader.getLocaleString("registrationSuccessOKMnemonic").charAt(0));
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
        btnImageOK.setBounds(79, 75, btnWidth, btnHeight);
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
        btnOK.setBounds(86, 75, 81, 26);
}
	  	if(isImageButton==true)
	  	{
	  		setKeyManager();
		}
        pack();
    }//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
		getRegistrationSuccess();
    }//GEN-LAST:event_btnOKActionPerformed
    private void btnImageCancelMouseClicked(java.awt.event.MouseEvent evt) 
	{
		getRegistrationSuccess();
	}    

private void getRegistrationSuccess()
{
        // TODO: Command Line implementation
        // TODO: MIDP implementation
        // Registration Successful
        if(EncryptedRuleReader.get("registrationSucceededAction")!=null)
        {
            try
            {
			dispose();
			
                Class.forName(EncryptedRuleReader.get("registrationSucceededAction")).newInstance();
            }
            catch(InstantiationException e)
            {
                System.out.println(e);
            }   
            catch(IllegalAccessException e)
            {
                System.out.println(e);
            }                      
            catch(ClassNotFoundException e)
            {
                System.out.println(e);
            }       
        }
        else
        {
            //Problem in Properties File
        }
}

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog
    
    /**
     * @param args the command line arguments
     */
  //  public static void main(String args[]) {
  //      new dlgRegistrationSuccess(new javax.swing.JFrame(), true).show();
  //  }

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

   public void setFontColor(Color fontColor)
   {
	try
	{
		lHeaderDescription.setForeground(fontColor);
		lDescription.setForeground(fontColor);
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

    public void paint(Graphics g)
    {
	Graphics2D g2 = (Graphics2D) g;
	g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	super.paint(g);
    } 

   public void setBackgroundColor(Color BGColor)
   {
	try
	{
		getContentPane().setBackground(BGColor);
		lHeaderDescription.setBackground(BGColor);
		lDescription.setBackground(BGColor);
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
					getRegistrationSuccess();
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
    private javax.swing.JTextArea lDescription;
    private javax.swing.JLabel lHeaderDescription;
    private ImageButton btnImageOK;
    // End of variables declaration//GEN-END:variables
    
}
