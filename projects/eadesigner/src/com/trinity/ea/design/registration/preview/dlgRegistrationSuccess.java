/*
 * RegistrationComplete.java
 *
 * Created on October 24, 2003, 3:39 AM
 */

package com.trinity.ea.design.registration.preview;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.registration.preview.gui.swing.ImageButton;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.net.URL;

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
	  if(ProjectManager.get("btnBarImgButtonsEnabled")!=null)
	  {
	  	if(ProjectManager.get("btnBarImgButtonsEnabled").equalsIgnoreCase("true")==true)
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

	  if(ProjectManager.get("registrationImgButtonWidth")!=null)
	  {
	  	if(ProjectManager.get("registrationImgButtonWidth").equalsIgnoreCase("")==false)
	  	{
			try
			{
				btnWidth = new Integer(ProjectManager.get("registrationImgButtonWidth")).intValue();
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
	  if(ProjectManager.get("registrationImgButtonHeight")!=null)
	  {
	  	if(ProjectManager.get("registrationImgButtonHeight").equalsIgnoreCase("")==false)
	  	{
			try
			{
				btnHeight = new Integer(ProjectManager.get("registrationImgButtonHeight")).intValue();
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
		if(ProjectManager.get("registrationImgButtonFace")!=null)
		{
			if(ProjectManager.get("registrationImgButtonFace").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFace = new javax.swing.ImageIcon(new URL(ProjectManager.get("registrationImgButtonFace")));
				}
				catch(Exception e)
				{
					//e.printStackTrace();
					isImageButton=false;
				}
			}
		}
		if(ProjectManager.get("registrationImgButtonFaceOnClick")!=null)
		{
			if(ProjectManager.get("registrationImgButtonFaceOnClick").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceOnClick = new javax.swing.ImageIcon(new URL(ProjectManager.get("registrationImgButtonFaceOnClick")));

				}
				catch(Exception e)
				{
					//e.printStackTrace();
				}
			}
		}
		if(ProjectManager.get("registrationButtonFaceInFocus")!=null)
		{
			if(ProjectManager.get("registrationButtonFaceInFocus").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceInFocus = new javax.swing.ImageIcon(new URL(ProjectManager.get("registrationButtonFaceInFocus")));
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
            setTitle(replaceUIExpressions(ProjectManager.get("registrationSuccessWindowTitle")));
        }
        catch(Exception e){}
	  if(ProjectManager.get("registrationTextColor")!=null)
	  {
		if(ProjectManager.get("registrationTextColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationTextColor"));
			setFontColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }

	  setButtonTextColor();
	  if(ProjectManager.get("registrationBackgroundColor")!=null)
	  {
		if(ProjectManager.get("registrationBackgroundColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationBackgroundColor"));
			setBackgroundColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }

	try
	{
	  	  //applyComponentOrientation(ComponentOrientation.getOrientation(ProjectManager.getLocale()));
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
	  updateUIExpressionDefines();
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
        if(ProjectManager.get("registrationCodeLabelFont")!=null)
	  {
		if(ProjectManager.get("registrationCodeLabelFont").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationCodeLabelFont"));
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
	  if(ProjectManager.get("registrationSuccessHeader")!=null)
	  {
	        lHeaderDescription.setText(replaceUIExpressions(ProjectManager.get("registrationSuccessHeader")));
	  }
	  else
	  {
        	lHeaderDescription.setText("Registration Success!");
	  }
        getContentPane().add(lHeaderDescription);
        lHeaderDescription.setBounds(20, 12, 200, 23);

        lDescription.setLineWrap(true);
	  lDescription.setEditable(false);
	  if(ProjectManager.get("registrationSuccessDesc")!=null)
	  {
	        lDescription.setText(replaceUIExpressions(ProjectManager.get("registrationSuccessDesc")));
	  }
	  else
	  {
        	lDescription.setText("Thank You for registering this software.");
	  }
        lDescription.setWrapStyleWord(true);
        getContentPane().add(lDescription);
        lDescription.setBounds(20, 42, 225, 32);


	  if(ProjectManager.get("registrationSuccessOK")!=null)
	  {

        
	  if(isImageButton==true)
	  {
        	btnImageOK.setText(replaceUIExpressions(ProjectManager.get("registrationSuccessOK")));
	  }
	  else
	  {
        	btnOK.setText(ProjectManager.get("registrationSuccessOK"));
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
	  if(ProjectManager.get("registrationSuccessOKMnemonic")!=null)
	  {
	  	if(ProjectManager.get("registrationSuccessOKMnemonic").equalsIgnoreCase("")==false)
	  	{
	      	btnImageOK.setMnemonic(ProjectManager.get("registrationSuccessOKMnemonic").charAt(0));
		}
	  }
	  }
	  else
	  {
	  if(ProjectManager.get("registrationSuccessOKMnemonic")!=null)
	  {
	  	if(ProjectManager.get("registrationSuccessOKMnemonic").equalsIgnoreCase("")==false)
	  	{
	      	btnOK.setMnemonic(ProjectManager.get("registrationSuccessOKMnemonic").charAt(0));
		}
	  }
	  }
if(isImageButton==true)
{
	  	 if(ProjectManager.get("registrationButtonFont")!=null)
	  	 {
	  		if(ProjectManager.get("registrationButtonFont").equalsIgnoreCase("")==false)
			{
				Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationButtonFont"));
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
	  	 if(ProjectManager.get("registrationButtonFont")!=null)
	  	 {
	  		if(ProjectManager.get("registrationButtonFont").equalsIgnoreCase("")==false)
			{
				Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationButtonFont"));
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
        if(ProjectManager.get("registrationSucceededAction")!=null)
        {
	try
	{
		setVisible(false);
		dispose();
		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
        }
        else
        {
            //Problem in Properties File
        }
}

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) 
    {
	try
	{
		setVisible(false);
		dispose();
		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
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
	  if(ProjectManager.get("msgbtnfontclr")!=null)
	  {
		if(ProjectManager.get("msgbtnfontclr").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("msgbtnfontclr"));
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

    private String replaceUIExpressions(String UIStringToReplaceExpressions)
    {
        try
        {
            for(int i = 0;i<updateUIExpressions.length;i++)
            {
                    UIStringToReplaceExpressions = UIStringToReplaceExpressions.replaceAll((String)updateUIExpressions[i],ProjectManager.get((String)updateUIExpressions[i]));
            }
            return UIStringToReplaceExpressions;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    Object[] updateUIExpressions = new Object[7];
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
    private javax.swing.JButton btnOK;
    private javax.swing.JTextArea lDescription;
    private javax.swing.JLabel lHeaderDescription;
    private ImageButton btnImageOK;
    // End of variables declaration//GEN-END:variables
    
}
