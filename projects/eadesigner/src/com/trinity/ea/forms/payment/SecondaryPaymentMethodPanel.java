/*
 * SecondaryPaymentMethodPanel.java
 *
 * Created on June 29, 2004, 1:38 PM
 */

package com.trinity.ea.forms.payment;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import com.trinity.ea.forms.gui.swing.ImageButton;
import com.trinity.ea.util.BrowserLauncher;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class SecondaryPaymentMethodPanel extends javax.swing.JPanel {
    private ImageIcon btnFace = null;
    private ImageIcon btnFaceOnClick = null;
    private ImageIcon btnFaceInFocus = null;
    private int btnWidth = -1;
    private int btnHeight = -1; 
    private Color btnBGColor = new Color(119,151,172);

    /** Creates new form SecondaryPaymentMethodPanel */
    public SecondaryPaymentMethodPanel() {
	try
	{
	  if(EncryptedRuleReader.get("secondaryPaymentMethodType")!=null)
	  {
	  	if(EncryptedRuleReader.get("secondaryPaymentMethodType").equalsIgnoreCase("")==false)
	  	{		
	  		if(EncryptedRuleReader.get("secondaryPaymentMethod")!=null)
	  		{
	  			if(EncryptedRuleReader.get("secondaryPaymentMethod").equalsIgnoreCase("")==false)
	  			{	
					setSecondaryPaymentMethodAction(new Integer(EncryptedRuleReader.get("secondaryPaymentMethodType")).intValue(), EncryptedRuleReader.get("secondaryPaymentMethod"));
				}
				else
				{
					setSecondaryPaymentMethodAction(-1,"");
				}
			}
			else
			{
				setSecondaryPaymentMethodAction(-1,"");
			}
		}
		else
		{
			setSecondaryPaymentMethodAction(-1,"");
		}
	  }
	  else
	  {
		setSecondaryPaymentMethodAction(-1,"");
	  }
btnBGColor = getBackground();

	  		if(EncryptedRuleReader.get("paymentImgSecondaryBackgroundColor")!=null)
	  		{
				if(EncryptedRuleReader.get("paymentImgSecondaryBackgroundColor").equalsIgnoreCase("")==false)
				{
					Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("paymentImgSecondaryBackgroundColor"));
					setBackgroundColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
				}
	  		}
	  		if(EncryptedRuleReader.get("paymentImgSecondaryButtonBackgroundColor")!=null)
	  		{
				if(EncryptedRuleReader.get("paymentImgSecondaryButtonBackgroundColor").equalsIgnoreCase("")==false)
				{
					Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("paymentImgSecondaryButtonBackgroundColor"));
					btnBGColor = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
				}
	  		}
	  if(EncryptedRuleReader.get("paymentImgSecondaryButtonWidth")!=null)
	  {
	  	if(EncryptedRuleReader.get("paymentImgSecondaryButtonWidth").equalsIgnoreCase("")==false)
	  	{
			try
			{
				btnWidth = new Integer(EncryptedRuleReader.get("paymentImgSecondaryButtonWidth")).intValue();
			}
			catch(Exception eee)
			{
				//eee.printStackTrace();
				btnWidth = 536;
			}
		}
		else
		{
			btnWidth = 536;
		}
	  }
	  else
	  {
		btnWidth = 536;
	  }	  
	  if(EncryptedRuleReader.get("paymentImgSecondaryButtonHeight")!=null)
	  {
	  	if(EncryptedRuleReader.get("paymentImgSecondaryButtonHeight").equalsIgnoreCase("")==false)
	  	{
			try
			{
				btnHeight = new Integer(EncryptedRuleReader.get("paymentImgSecondaryButtonHeight")).intValue();
			}
			catch(Exception eee)
			{
				//eee.printStackTrace();
				btnHeight = 34;
			}
		}
		else
		{
			btnHeight = 34;
		}
	  }
	  else
	  {
		btnHeight = 34;
	  }	  
		if(EncryptedRuleReader.get("paymentImgSecondaryButtonFace")!=null)
		{
			if(EncryptedRuleReader.get("paymentImgSecondaryButtonFace").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFace = new javax.swing.ImageIcon(getClass().getResource(EncryptedRuleReader.get("paymentImgSecondaryButtonFace")));
				}
				catch(Exception e)
				{
					//e.printStackTrace();
				}
			}
		}
		if(EncryptedRuleReader.get("paymentImgSecondaryButtonFaceOnClick")!=null)
		{
			if(EncryptedRuleReader.get("paymentImgSecondaryButtonFaceOnClick").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceOnClick = new javax.swing.ImageIcon(getClass().getResource(EncryptedRuleReader.get("paymentImgSecondaryButtonFaceOnClick")));

				}
				catch(Exception e)
				{
					//e.printStackTrace();
				}
			}
		}
		if(EncryptedRuleReader.get("paymentImgSecondaryButtonFaceInFocus")!=null)
		{
			if(EncryptedRuleReader.get("paymentImgSecondaryButtonFaceInFocus").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceInFocus = new javax.swing.ImageIcon(getClass().getResource(EncryptedRuleReader.get("paymentImgSecondaryButtonFaceInFocus")));
				}
				catch(Exception e)
				{
					//e.printStackTrace();
				}
			}
		}

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        setLayout(null);
	  try
	  {
        	btnImageSecondaryPaymentMethod = new ImageButton(btnFace,btnFaceOnClick,btnFaceInFocus,btnWidth,btnHeight);

	  if(EncryptedRuleReader.get("secondaryPaymentMethodTextColor")!=null)
	  {
		if(EncryptedRuleReader.get("secondaryPaymentMethodTextColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("secondaryPaymentMethodTextColor"));
			setButtonTextColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }  
	  	 if(EncryptedRuleReader.get("secondaryPaymentMethodButtonFont")!=null)
	  	 {
	  		if(EncryptedRuleReader.get("secondaryPaymentMethodButtonFont").equalsIgnoreCase("")==false)
			{
				Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("secondaryPaymentMethodButtonFont"));
      			setButtonTextFont(new java.awt.Font((String)tmpArray[0], new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
	  	  }
        	  btnImageSecondaryPaymentMethod.setMaximumSize(new java.awt.Dimension(btnWidth, btnHeight));
       	  btnImageSecondaryPaymentMethod.setMinimumSize(new java.awt.Dimension(btnWidth, btnHeight));
       	  btnImageSecondaryPaymentMethod.setPreferredSize(new java.awt.Dimension(btnWidth, btnHeight));
      	  btnImageSecondaryPaymentMethod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImageSecondaryPaymentMethodMouseClicked(evt);
            }
        });

	  	  if(EncryptedRuleReader.getLocaleString("secondaryPaymentMethodButtonText")!=null)
	  	  {
     			btnImageSecondaryPaymentMethod.setText(EncryptedRuleReader.getLocaleString("secondaryPaymentMethodButtonText"));
	  	  }
	  	  if(EncryptedRuleReader.getLocaleString("secondaryPaymentMethodButtonMnemonic")!=null)
	  	  {
	  	  	if(EncryptedRuleReader.getLocaleString("secondaryPaymentMethodButtonMnemonic").equalsIgnoreCase("")==false)
	  	  	{
	 			btnImageSecondaryPaymentMethod.setMnemonic(EncryptedRuleReader.getLocaleString("secondaryPaymentMethodButtonMnemonic").charAt(0));
			}
  	  	  }
		setButtonBackgroundColor(btnBGColor);
        add(btnImageSecondaryPaymentMethod);
        btnImageSecondaryPaymentMethod.setBounds(9, 0, btnWidth, btnHeight);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	setKeyManager();
    }//GEN-END:initComponents
 
private void getSecondaryPaymentMethodAction()
{
       if(intActionType == 0)
        {
            try
            {
                 BrowserLauncher.openURL(actionPackage);
			if(EncryptedRuleReader.get("secondaryPaymentMethodClosePaymentWindowOnClick")!=null)
			{
				if(EncryptedRuleReader.get("secondaryPaymentMethodClosePaymentWindowOnClick").equalsIgnoreCase("true")==true)
				{
			       	JDialog theDialog=(JDialog)this.getTopLevelAncestor();
        				theDialog.dispose();
				}
			}
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(intActionType == 1)
        {
            try
            {
                Class.forName(actionPackage).newInstance();
			if(EncryptedRuleReader.get("secondaryPaymentMethodClosePaymentWindowOnClick")!=null)
			{
				if(EncryptedRuleReader.get("secondaryPaymentMethodClosePaymentWindowOnClick").equalsIgnoreCase("true")==true)
				{
			       	JDialog theDialog=(JDialog)this.getTopLevelAncestor();
        				theDialog.dispose();
				}
			}
            }
            catch(InstantiationException e)
            {
                e.printStackTrace();
            }   
            catch(IllegalAccessException e)
            {
                e.printStackTrace();
            }                      
            catch(ClassNotFoundException e)
            {
                e.printStackTrace();
            }                        
        }
}

    private void btnImageSecondaryPaymentMethodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImageSecondaryPaymentMethodMouseClicked
	getSecondaryPaymentMethodAction();
    }//GEN-LAST:event_btnImageSecondaryPaymentMethodMouseClicked
   

    private void setButtonBackgroundColor(Color BGColor)
    {
	try
	{
		btnImageSecondaryPaymentMethod.setBackground(BGColor);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	} 
   }  

    private void setButtonTextColor(Color FGColor)
    {
	try
	{
		btnImageSecondaryPaymentMethod.setForeground(FGColor);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	} 
   }   

    private void setBackgroundColor(Color BGColor)
    {
	try
	{
		setBackground(BGColor);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	} 
   }
    private int intActionType = -1;
    private String actionPackage = null;
    public void setSecondaryPaymentMethodAction(int actionType, String strActionLink)
    {
        intActionType = actionType;
        actionPackage = strActionLink;
    }   

    private void setButtonTextFont(Font LFont)
    {
		btnImageSecondaryPaymentMethod.setFont(LFont);
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
 public void paint(Graphics g)
{
Graphics2D g2 = (Graphics2D) g;

g2.setRenderingHint(
RenderingHints.KEY_TEXT_ANTIALIASING,
RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT);

super.paint(g);
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
                        if(e.getComponent().equals(btnImageSecondaryPaymentMethod)==true)
                        {
				    if(e.getKeyCode()==btnImageSecondaryPaymentMethod.getDisplayedMnemonic())
                            {
					   getSecondaryPaymentMethodAction();
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
    // End of variables declaration//GEN-END:variables
    private ImageButton btnImageSecondaryPaymentMethod;    
}
