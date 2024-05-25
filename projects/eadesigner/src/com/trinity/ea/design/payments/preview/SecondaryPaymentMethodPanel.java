/*
 * SecondaryPaymentMethodPanel.java
 *
 * Created on June 29, 2004, 1:38 PM
 */

package com.trinity.ea.design.payments.preview;
import com.trinity.ea.design.common.file.ProjectManager;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import com.trinity.ea.design.payments.preview.gui.swing.ImageButton;
import com.trinity.ea.util.BrowserLauncher;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.net.URL;

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
	updateUIExpressionDefines();
	  if(ProjectManager.get("secondaryPaymentMethodType")!=null)
	  {
	  	if(ProjectManager.get("secondaryPaymentMethodType").equalsIgnoreCase("")==false)
	  	{		
	  		if(ProjectManager.get("secondaryPaymentMethod")!=null)
	  		{
	  			if(ProjectManager.get("secondaryPaymentMethod").equalsIgnoreCase("")==false)
	  			{	
					setSecondaryPaymentMethodAction(new Integer(ProjectManager.get("secondaryPaymentMethodType")).intValue(), ProjectManager.get("secondaryPaymentMethod"));
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

	  		if(ProjectManager.get("paymentImgSecondaryBackgroundColor")!=null)
	  		{
				if(ProjectManager.get("paymentImgSecondaryBackgroundColor").equalsIgnoreCase("")==false)
				{
					Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentImgSecondaryBackgroundColor"));
					setBackgroundColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
				}
	  		}
	  		if(ProjectManager.get("paymentImgSecondaryButtonBackgroundColor")!=null)
	  		{
				if(ProjectManager.get("paymentImgSecondaryButtonBackgroundColor").equalsIgnoreCase("")==false)
				{
					Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentImgSecondaryButtonBackgroundColor"));
					btnBGColor = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
				}
	  		}
	  if(ProjectManager.get("paymentImgSecondaryButtonWidth")!=null)
	  {
	  	if(ProjectManager.get("paymentImgSecondaryButtonWidth").equalsIgnoreCase("")==false)
	  	{
			try
			{
				btnWidth = new Integer(ProjectManager.get("paymentImgSecondaryButtonWidth")).intValue();
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
	  if(ProjectManager.get("paymentImgSecondaryButtonHeight")!=null)
	  {
	  	if(ProjectManager.get("paymentImgSecondaryButtonHeight").equalsIgnoreCase("")==false)
	  	{
			try
			{
				btnHeight = new Integer(ProjectManager.get("paymentImgSecondaryButtonHeight")).intValue();
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

  
		if(ProjectManager.get("paymentImgSecondaryButtonFace")!=null)
		{
			if(ProjectManager.get("paymentImgSecondaryButtonFace").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFace = new javax.swing.ImageIcon(new URL(ProjectManager.get("paymentImgSecondaryButtonFace")));
				}
				catch(Exception e)
				{
					//e.printStackTrace();
				}
			}
		}
		if(ProjectManager.get("paymentImgSecondaryButtonFaceOnClick")!=null)
		{
			if(ProjectManager.get("paymentImgSecondaryButtonFaceOnClick").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceOnClick = new javax.swing.ImageIcon(new URL(ProjectManager.get("paymentImgSecondaryButtonFaceOnClick")));

				}
				catch(Exception e)
				{
					//e.printStackTrace();
				}
			}
		}
		if(ProjectManager.get("paymentImgSecondaryButtonFaceInFocus")!=null)
		{
			if(ProjectManager.get("paymentImgSecondaryButtonFaceInFocus").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceInFocus = new javax.swing.ImageIcon(new URL(ProjectManager.get("paymentImgSecondaryButtonFaceInFocus")));
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

	  if(ProjectManager.get("secondaryPaymentMethodTextColor")!=null)
	  {
		if(ProjectManager.get("secondaryPaymentMethodTextColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("secondaryPaymentMethodTextColor"));
			setButtonTextColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }  
	  	 if(ProjectManager.get("secondaryPaymentMethodButtonFont")!=null)
	  	 {
	  		if(ProjectManager.get("secondaryPaymentMethodButtonFont").equalsIgnoreCase("")==false)
			{
				Object[] tmpArray = getStringArraysFromString(ProjectManager.get("secondaryPaymentMethodButtonFont"));
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

	  	  if(ProjectManager.get("secondaryPaymentMethodButtonText")!=null)
	  	  {
     			btnImageSecondaryPaymentMethod.setText(replaceUIExpressions(ProjectManager.get("secondaryPaymentMethodButtonText")));
	  	  }
	  	  if(ProjectManager.get("secondaryPaymentMethodButtonMnemonic")!=null)
	  	  {
	  	  	if(ProjectManager.get("secondaryPaymentMethodButtonMnemonic").equalsIgnoreCase("")==false)
	  	  	{
	 			btnImageSecondaryPaymentMethod.setMnemonic(ProjectManager.get("secondaryPaymentMethodButtonMnemonic").charAt(0));
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
			if(ProjectManager.get("secondaryPaymentMethodClosePaymentWindowOnClick")!=null)
			{
				if(ProjectManager.get("secondaryPaymentMethodClosePaymentWindowOnClick").equalsIgnoreCase("true")==true)
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
			if(ProjectManager.get("secondaryPaymentMethodClosePaymentWindowOnClick")!=null)
			{
				if(ProjectManager.get("secondaryPaymentMethodClosePaymentWindowOnClick").equalsIgnoreCase("true")==true)
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

    private String replaceUIExpressions(String UIStringToReplaceExpressions)
    {
        try
        {
            for(int i = 0;i<updateUIExpressions.length;i++)
            {
			if(((String)updateUIExpressions[i]).equalsIgnoreCase("product_version")==false)
			{
                    UIStringToReplaceExpressions = UIStringToReplaceExpressions.replaceAll("(?i)" + (String)updateUIExpressions[i],ProjectManager.get((String)updateUIExpressions[i]));
			}
			else
			{
			  //put replace version string code here.
			  Object[] theVersionArray = getStringArraysFromString(ProjectManager.get((String)updateUIExpressions[i]));
			  int tempInt = 1;
			  String strVersionString = "";
  			  for(int a = 0;a<theVersionArray.length;a++)
			  {
				if(0<a)
				{
					try
					{
						if(Integer.parseInt((String)theVersionArray[a])!=0)
						{
							tempInt = a;
						}
					}
					catch(Exception e)
					{
						//The String likely was not a number and threw an exception
					}
				}
			  }
			  tempInt = tempInt + 1;
  			  for(int a = 0;a<tempInt;a++)
			  {
				if(a!=0)
				{
					strVersionString = strVersionString + "." + (String)theVersionArray[a];
				}
				else
				{
					strVersionString = (String)theVersionArray[a];
				}
			  }
                    UIStringToReplaceExpressions = UIStringToReplaceExpressions.replaceAll("(?i)" + (String)updateUIExpressions[i],strVersionString);
			}
            }
            return UIStringToReplaceExpressions;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    Object[] updateUIExpressions = new Object[9];
    private void updateUIExpressionDefines()
    {
        try
        {
            ArrayList theExpressionDefinesArrayList = new ArrayList();
            if(ProjectManager.get("product_vendor_name")!=null)
            {
                theExpressionDefinesArrayList.add("product_vendor_name");
            }
            if(ProjectManager.get("product_name")!=null)
            {
                theExpressionDefinesArrayList.add("product_name");
            }
            if(ProjectManager.get("product_version")!=null)
            {
                theExpressionDefinesArrayList.add("product_version");
            }
            if(ProjectManager.get("product_info_url")!=null)
            {
                theExpressionDefinesArrayList.add("product_info_url");
            }
            if(ProjectManager.get("product_url")!=null)
            {
                theExpressionDefinesArrayList.add("product_url");
            }
            if(ProjectManager.get("product_privacy_policy_email")!=null)
            {
                theExpressionDefinesArrayList.add("product_privacy_policy_email");
            }
            if(ProjectManager.get("product_copyright")!=null)
            {
                theExpressionDefinesArrayList.add("product_copyright");
            }     
            if(ProjectManager.get("product_price")!=null)
            {
                theExpressionDefinesArrayList.add("product_price");
            }
            if(ProjectManager.get("product_purchase_support_email")!=null)
            {
                theExpressionDefinesArrayList.add("product_purchase_support_email");
            }
            theExpressionDefinesArrayList.trimToSize();
            updateUIExpressions = theExpressionDefinesArrayList.toArray();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }     

    private boolean armed = false;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    private ImageButton btnImageSecondaryPaymentMethod;    
}
