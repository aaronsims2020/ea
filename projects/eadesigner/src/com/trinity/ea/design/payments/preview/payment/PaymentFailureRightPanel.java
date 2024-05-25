/*
 * LeftFillerPanelPaymentFailure.java
 *
 * Created on July 9, 2004, 7:33 PM
 */

package com.trinity.ea.design.payments.preview.payment;
import com.trinity.ea.design.common.file.ProjectManager;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import com.trinity.ea.design.payments.preview.gui.swing.ImageButton;
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
public class PaymentFailureRightPanel extends javax.swing.JPanel {
    private ImageIcon btnFace = null;
    private ImageIcon btnFaceOnClick = null;
    private ImageIcon btnFaceInFocus = null;
    private boolean isImageButton = false;
    private int btnWidth = 94;
    private int btnHeight = 31; 
    private Color btnBGColor = new Color(119,151,172);
    private boolean isFailurePreview = false;
    /** Creates new form LeftFillerPanelPaymentFailure */
    public PaymentFailureRightPanel() {
	try
	{
	updateUIExpressionDefines();
	  if(ProjectManager.get("btnBarImgButtonsEnabled")!=null)
	  {
	  	if(ProjectManager.get("btnBarImgButtonsEnabled").equalsIgnoreCase("true")==true)
	  	{
			isImageButton=true;
	  		if(ProjectManager.get("paymentValidateBtnBGColor")!=null)
	  		{
				if(ProjectManager.get("paymentValidateBtnBGColor").equalsIgnoreCase("")==false)
				{
					Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentValidateBtnBGColor"));
					btnBGColor = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
				}
	  		}
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


	  if(ProjectManager.get("paymentImgCancelButtonWidth")!=null)
	  {
	  	if(ProjectManager.get("paymentImgCancelButtonWidth").equalsIgnoreCase("")==false)
	  	{
			try
			{
				btnWidth = new Integer(ProjectManager.get("paymentImgCancelButtonWidth")).intValue();
			}
			catch(Exception eee)
			{
				//eee.printStackTrace();
				btnWidth = 94;
			}
		}
		else
		{
			btnWidth = 94;
		}
	  }
	  else
	  {
		btnWidth = 94;
	  }	  
	  if(ProjectManager.get("paymentImgCancelButtonHeight")!=null)
	  {
	  	if(ProjectManager.get("paymentImgCancelButtonHeight").equalsIgnoreCase("")==false)
	  	{
			try
			{
				btnHeight = new Integer(ProjectManager.get("paymentImgCancelButtonHeight")).intValue();
			}
			catch(Exception eee)
			{
				//eee.printStackTrace();
				btnHeight = 31;
			}
		}
		else
		{
			btnHeight = 31;
		}
	  }
	  else
	  {
		btnHeight = 31;
	  }	  

	if(isImageButton==true)
	{
		if(ProjectManager.get("paymentImgCancelButtonFace")!=null)
		{
			if(ProjectManager.get("paymentImgCancelButtonFace").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFace = new javax.swing.ImageIcon(new URL(ProjectManager.get("paymentImgCancelButtonFace")));
				}
				catch(Exception e)
				{
					//e.printStackTrace();

				}
			}
		}
		if(ProjectManager.get("paymentImgCancelButtonFaceOnClick")!=null)
		{
			if(ProjectManager.get("paymentImgCancelButtonFaceOnClick").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceOnClick = new javax.swing.ImageIcon(new URL(ProjectManager.get("paymentImgCancelButtonFaceOnClick")));

				}
				catch(Exception e)
				{
					//e.printStackTrace();

				}
			}
		}
		if(ProjectManager.get("paymentImgCancelButtonFaceInFocus")!=null)
		{
			if(ProjectManager.get("paymentImgCancelButtonFaceInFocus").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceInFocus = new javax.swing.ImageIcon(new URL(ProjectManager.get("paymentImgCancelButtonFaceInFocus")));
				}
				catch(Exception e)
				{
					//e.printStackTrace();

				}
			}
		}
	  }
	  }
	  catch(Exception e)
	  {
		e.printStackTrace();
	  }
	if(isImageButton==true)
	{
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
	}
	else
	{
        	initComponents(false);
	}
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents(boolean isImgButton) {//GEN-BEGIN:initComponents

        setLayout(null);
	  isImageButton = isImgButton;
        setMaximumSize(new java.awt.Dimension(113, 168));
        setPreferredSize(new java.awt.Dimension(113, 168));
        setMinimumSize(new java.awt.Dimension(113, 168));
	  if(ProjectManager.get("paymentBackgroundColor")!=null)
	  {
		if(ProjectManager.get("paymentBackgroundColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentBackgroundColor"));
			setBackground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }
	  try
	  {

	  if(isImageButton==true)
	  {
        	btnImageRetry = new ImageButton(btnFace,btnFaceOnClick,btnFaceInFocus,btnWidth,btnHeight);	  }
	  else
	  {
        	btnRetry = new javax.swing.JButton();
	  }


	  if(isImageButton==true)
	  {
	  	if(ProjectManager.get("paymentFailureRetryButtonText")!=null)
	  	{
      		btnImageRetry.setText(replaceUIExpressions(ProjectManager.get("paymentFailureRetryButtonText")));
	 	}
	  	if(ProjectManager.get("paymentFailureRetryButtonMnemonic")!=null)
	  	{
	  		if(ProjectManager.get("paymentFailureRetryButtonMnemonic").equalsIgnoreCase("")==false)
	  		{
				btnImageRetry.setMnemonic(ProjectManager.get("paymentFailureRetryButtonMnemonic").charAt(0));
			}
	  	}
	  	 if(ProjectManager.get("paymentButtonFont")!=null)
	  	 {
	  		if(ProjectManager.get("paymentButtonFont").equalsIgnoreCase("")==false)
			{
				Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentButtonFont"));
      			btnImageRetry.setFont(new java.awt.Font((String)tmpArray[0], new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
	  	  }
        	  btnImageRetry.setMaximumSize(new java.awt.Dimension(btnWidth, btnHeight));
       	  btnImageRetry.setMinimumSize(new java.awt.Dimension(btnWidth, btnHeight));
       	  btnImageRetry.setPreferredSize(new java.awt.Dimension(btnWidth, btnHeight));
      	  btnImageRetry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImageRetryMouseClicked(evt);
            }
        });

        add(btnImageRetry);
        btnImageRetry.setBounds(10, 129, btnWidth, btnHeight);
	  }
	  else
	  {
	  	if(ProjectManager.get("paymentFailureRetryButtonText")!=null)
	  	{
      		btnRetry.setText(replaceUIExpressions(ProjectManager.get("paymentFailureRetryButtonText")));
	 	}
	  	if(ProjectManager.get("paymentFailureRetryButtonMnemonic")!=null)
	  	{
	  		if(ProjectManager.get("paymentFailureRetryButtonMnemonic").equalsIgnoreCase("")==false)
	  		{
				btnRetry.setMnemonic(ProjectManager.get("paymentFailureRetryButtonMnemonic").charAt(0));
			}
	  	}
	  	 if(ProjectManager.get("paymentButtonFont")!=null)
	  	 {
	  		if(ProjectManager.get("paymentButtonFont").equalsIgnoreCase("")==false)
			{
				Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentButtonFont"));
      			btnRetry.setFont(new java.awt.Font((String)tmpArray[0], new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
	  	  }

        	  btnRetry.setMaximumSize(new java.awt.Dimension(btnWidth, btnHeight));
       	  btnRetry.setMinimumSize(new java.awt.Dimension(btnWidth, btnHeight));
       	  btnRetry.setPreferredSize(new java.awt.Dimension(btnWidth, btnHeight));
      	  btnRetry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetryActionPerformed(evt);
            }
        });

        add(btnRetry);
        btnRetry.setBounds(10, 129, btnWidth, 23);
	  }
	  if(ProjectManager.get("paymentBackgroundColor")!=null)
	  {
		if(ProjectManager.get("paymentBackgroundColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentBackgroundColor"));
			setBackgroundColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }
	  if(ProjectManager.get("paymentButtonTextColor")!=null)
	  {
		if(ProjectManager.get("paymentButtonTextColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentButtonTextColor"));
			setButtonTextColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	  	if(isImageButton==true)
	  	{
	  		setKeyManager();
		}
    }//GEN-END:initComponents

private void getRetryAction()
{
            // TODO: Command Line implementation
            // TODO: MIDP implementation
	try
	{ 
           if(ProjectManager.get("paymentReceiptFailedRetryAction")!=null)
            {
                try
                {
                   JDialog theDialog=(JDialog)this.getTopLevelAncestor();
                   theDialog.dispose();
			  if(isFailurePreview==false)
		        { 
                    	Class.forName(ProjectManager.get("paymentReceiptFailedRetryAction")).newInstance();
			  }
			  else
			  {
				try
				{
					UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
				}
				catch(Exception e)
				{

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
            else
            {
                //Problem in Properties File
            }
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

      private void btnRetryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetryActionPerformed
	getRetryAction();
    }//GEN-LAST:event_btnRetryActionPerformed

    private void btnImageRetryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImageRetryMouseClicked
	getRetryAction();
    }//GEN-LAST:event_btnImageRetryMouseClicked

    private void setButtonTextColor(Color FGColor)
    {
	try
	{
		if(isImageButton==true)
		{
			btnImageRetry.setForeground(FGColor);
		}
		else
		{
			btnRetry.setForeground(FGColor);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	} 
   }   

    private void setButtonTextFont(Font LFont)
    {
	try
	{
		if(isImageButton==true)
		{
			btnImageRetry.setFont(LFont);
		}
		else
		{
			btnRetry.setFont(LFont);
		}
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
			if(isImageButton==true)
			{
				btnImageRetry.setBackground(btnBGColor);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		} 
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
	g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT);
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
                        if(e.getComponent().equals(btnImageRetry)==true)
                        {
				    if(e.getKeyCode()==btnImageRetry.getDisplayedMnemonic())
                            {
					   getRetryAction();
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

    public void setIsFailurePreview(boolean isFailurePrev)
    {
	isFailurePreview=isFailurePrev;
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
    private ImageButton btnImageRetry;    
    private javax.swing.JButton btnRetry;    
}
