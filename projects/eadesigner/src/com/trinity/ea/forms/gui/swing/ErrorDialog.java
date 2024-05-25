/*
 * ErrorDialog.java
 *
 * Created on February 26, 2004, 2:55 PM
 */

package com.trinity.ea.forms.gui.swing;
import com.trinity.ea.forms.gui.swing.ErrorPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.text.Document;
import javax.swing.text.StyledDocument;
import javax.swing.text.DefaultEditorKit;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.ComponentOrientation;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.RenderingHints;  
import com.trinity.ea.forms.gui.swing.ImageBackgroundBorder;
import javax.swing.border.Border;
import com.trinity.ea.forms.gui.swing.ImageButton;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.io.ByteArrayInputStream;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class ErrorDialog extends javax.swing.JDialog {
    private int btnWidthCancel = 94;
    private int btnHeightCancel = 31;   
    private ImageIcon btnFaceCancel = null;
    private ImageIcon btnFaceOnClickCancel = null;
    private ImageIcon btnFaceInFocusCancel = null;
    private Color btnBGColor = null;
    private Color bgColor = new Color(240,240,240);
    private Color tpBGColor = new Color(240,240,240);
    private boolean isImageButton = false;
    private String errorText = "";
    private String errorTitle = ""; 

    public ErrorDialog(String title, String text) 
    {
    		new ErrorDialog(null, true,title,text).show();
    }

    /** Creates new form ErrorDialog */
    public ErrorDialog(java.awt.Frame parent, boolean modal,String title, String text) {
        //super(parent, modal);
	try
	{
    		btnBGColor = getBackground();
    		bgColor = getBackground();
    		tpBGColor = getBackground();
	}
	catch(Exception e)
	{

	}
	errorText = System.getProperty("line.separator") + System.getProperty("line.separator") + text;
      errorTitle = title;
	try
	{
	  	  applyComponentOrientation(ComponentOrientation.getOrientation(EncryptedRuleReader.getLocale()));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
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

	  if(EncryptedRuleReader.get("paymentImgCancelButtonWidth")!=null)
	  {
	  	if(EncryptedRuleReader.get("paymentImgCancelButtonWidth").equalsIgnoreCase("")==false)
	  	{
			try
			{
				btnWidthCancel = new Integer(EncryptedRuleReader.get("paymentImgCancelButtonWidth")).intValue();
			}
			catch(Exception eee)
			{
				eee.printStackTrace();
				btnWidthCancel = 94;
			}
		}
		else
		{
			btnWidthCancel = 94;
		}
	  }
	  else
	  {
		btnWidthCancel = 94;
	  }	  
	  if(EncryptedRuleReader.get("paymentImgCancelButtonHeight")!=null)
	  {
	  	if(EncryptedRuleReader.get("paymentImgCancelButtonHeight").equalsIgnoreCase("")==false)
	  	{
			try
			{
				btnHeightCancel = new Integer(EncryptedRuleReader.get("paymentImgCancelButtonHeight")).intValue();
			}
			catch(Exception eee)
			{
				eee.printStackTrace();
				btnHeightCancel = 31;
			}
		}
		else
		{
			btnHeightCancel = 31;
		}
	  }
	  else
	  {
		btnHeightCancel = 31;
	  }	  
		if(EncryptedRuleReader.get("paymentImgCancelButtonFace")!=null)
		{
			if(EncryptedRuleReader.get("paymentImgCancelButtonFace").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceCancel = new javax.swing.ImageIcon(getClass().getResource(EncryptedRuleReader.get("paymentImgCancelButtonFace")));
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		if(EncryptedRuleReader.get("paymentImgCancelButtonFaceOnClick")!=null)
		{
			if(EncryptedRuleReader.get("paymentImgCancelButtonFaceOnClick").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceOnClickCancel = new javax.swing.ImageIcon(getClass().getResource(EncryptedRuleReader.get("paymentImgCancelButtonFaceOnClick")));

				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		if(EncryptedRuleReader.get("paymentImgCancelButtonFaceInFocus")!=null)
		{
			if(EncryptedRuleReader.get("paymentImgCancelButtonFaceInFocus").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceInFocusCancel = new javax.swing.ImageIcon(getClass().getResource(EncryptedRuleReader.get("paymentImgCancelButtonFaceInFocus")));
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	  if(btnFaceCancel!=null)
	  {
		if(btnFaceOnClickCancel!=null)
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

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        int w = getSize().width;
        int h = getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        setResizable(false);
	if(isImageButton==true)
	{
	  		if(EncryptedRuleReader.get("errImgBackgroundColor")!=null)
	  		{
				if(EncryptedRuleReader.get("errImgBackgroundColor").equalsIgnoreCase("")==false)
				{
					Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("errImgBackgroundColor"));
					btnBGColor = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
				}
				else
				{
					btnBGColor = getBackground();
				}
	  		}
			else
			{
				btnBGColor = getBackground();				
			}
			btnImageOK.setBackground(btnBGColor);
	}
        // Move the window
        setLocation(x, y);
        try
        {
	  	if(errorTitle!=null)
	  	{            
			setTitle(errorTitle);
	  	}
        }
        catch(Exception e)
	  {
		e.printStackTrace();
	  }   
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents(boolean isImgButton) {//GEN-BEGIN:initComponents
	  isImageButton = isImgButton;
        NorthPanel = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        CenterPanel = new javax.swing.JPanel();

	  try
	  {
	  	//if(EncryptedMessageReader.get("msgtextalgn")!=null)
	  	//{
	  		//if(EncryptedMessageReader.get("msgtextalgn").startsWith("0")==true)
	  		//{
        		//	jTextPane1 = new ErrorPane(0);
			//}
	  		//else if(EncryptedMessageReader.get("msgtextalgn").startsWith("1")==true)
	  		//{
        			jTextPane1 = new ErrorPane(1);
			//}
	  		//else if(EncryptedMessageReader.get("msgtextalgn").startsWith("2")==true)
	  		//{
        		//	jTextPane1 = new ErrorPane(2);
			//}			
	  	//}
	 	//else
	  	//{
        	//	jTextPane1 = new ErrorPane(1);
	  	//}
	  }
	  catch(Exception e)
	  {
        	jTextPane1 = new ErrorPane(1);
	  }

	  if(isImageButton==true)
	  {
        	btnImageOK = new ImageButton(btnFaceCancel,btnFaceOnClickCancel,btnFaceInFocusCancel,btnWidthCancel,btnHeightCancel);
	  }
	  else
	  {
        	btnOK = new javax.swing.JButton();
	  }
	  if(EncryptedRuleReader.get("errbgclr")!=null)
	  {
		if(EncryptedRuleReader.get("errbgclr").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("errbgclr"));
			setBackgroundColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }
	  if(EncryptedRuleReader.get("errtextbgclr")!=null)
	  {
		if(EncryptedRuleReader.get("errtextbgclr").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("errtextbgclr"));
			tpBGColor = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
		else
		{
			tpBGColor = getBackground();
		}
	  }
	  else
	  {
		tpBGColor = getBackground();
	  }
	  		if(EncryptedRuleReader.get("errImgBackgroundColor")!=null)
	  		{
				if(EncryptedRuleReader.get("errImgBackgroundColor").equalsIgnoreCase("")==false)
				{
					Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("errImgBackgroundColor"));
					btnBGColor = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
				}
				else
				{
					btnBGColor = getBackground();
				}
	  		}
			else
			{
				btnBGColor = getBackground();				
			}
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        NorthPanel.setLayout(null);

        Logo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
	if(EncryptedRuleReader.get("errHeaderImgPath")!=null)
	{
 		if(EncryptedRuleReader.get("errHeaderImgPath").equalsIgnoreCase("")==false)
		{
        		NorthPanel.setMaximumSize(new java.awt.Dimension(330, 30));
        		NorthPanel.setMinimumSize(new java.awt.Dimension(330, 30));
       		NorthPanel.setPreferredSize(new java.awt.Dimension(330, 30));
        		Logo.setIcon(new javax.swing.ImageIcon(EncryptedRuleReader.getImage(getClass().getResource(EncryptedRuleReader.get("errHeaderImgPath")))));
        		NorthPanel.add(Logo, java.awt.BorderLayout.CENTER);
			Logo.setBounds(5, 2, 330, 30);
		}
		else
		{
        		NorthPanel.setMaximumSize(new java.awt.Dimension(0, 0));
        		NorthPanel.setMinimumSize(new java.awt.Dimension(0, 0));
       		NorthPanel.setPreferredSize(new java.awt.Dimension(0, 0));
        		NorthPanel.add(Logo, java.awt.BorderLayout.CENTER);
        		Logo.setBounds(0, 0, 0, 0);
		}
	}
	else
	{
        	NorthPanel.setMaximumSize(new java.awt.Dimension(0, 0));
        	NorthPanel.setMinimumSize(new java.awt.Dimension(0, 0));
       	NorthPanel.setPreferredSize(new java.awt.Dimension(0, 0));
        	NorthPanel.add(Logo, java.awt.BorderLayout.CENTER);
        	Logo.setBounds(0, 0, 0, 0);
	}

        getContentPane().add(NorthPanel, java.awt.BorderLayout.NORTH);

        CenterPanel.setLayout(null);
	  CenterPanel.setPreferredSize(new java.awt.Dimension(330,150));
try
{
			try
			{
				EncryptedRuleReader.get("errBGImgPath");
			}
			catch(Exception e){}
			if(EncryptedRuleReader.get("errBGImgPath")!=null)
			{
 				if(EncryptedRuleReader.get("errBGImgPath").equalsIgnoreCase("")==false)
				{
        				final Border bkgrnd = new ImageBackgroundBorder(ImageIO.read(new ByteArrayInputStream(EncryptedRuleReader.getImage(getClass().getResource(EncryptedRuleReader.get("errBGImgPath"))))));
        				Runnable r = new Runnable() {
            				public void run() {
               				 CenterPanel.setBorder(bkgrnd);
               				 CenterPanel.repaint();
           			 }
       			 };
     			   SwingUtilities.invokeLater(r);
				}
			}
}
catch(Exception e)
{
	e.printStackTrace();
}


	if(isImageButton==true)
	{
		if(EncryptedRuleReader.getLocaleString("errokbtn")!=null)
		{
	  		if(EncryptedRuleReader.getLocaleString("errokbtn").equalsIgnoreCase("")==false)
	  		{
        			btnImageOK.setText(EncryptedRuleReader.getLocaleString("errokbtn"));
	  		}
	  		else
	  		{	
          			btnImageOK.setText("OK");
	  		}
		}
		else
		{	
        		btnImageOK.setText("OK");
		}
		if(EncryptedRuleReader.getLocaleString("errokbtnmnem")!=null)
		{
	  		if(EncryptedRuleReader.getLocaleString("errokbtnmnem").equalsIgnoreCase("")==false)
	  		{
       			btnImageOK.setMnemonic(EncryptedRuleReader.getLocaleString("errokbtnmnem").charAt(0));
	  		}
		}
		btnImageOK.setBackground(btnBGColor);

	  if(EncryptedRuleReader.get("errbtnfontclr")!=null)
	  {
		if(EncryptedRuleReader.get("errbtnfontclr").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("errbtnfontclr"));
				btnImageOK.setForeground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
			catch(Exception e)
			{
        			e.printStackTrace();
			}
		}
	  }

	  if(EncryptedRuleReader.get("errbtnfont")!=null)
	  {
		if(EncryptedRuleReader.get("errbtnfont").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("errbtnfont"));
				btnImageOK.setFont(new java.awt.Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
			catch(Exception e)
			{
        			e.printStackTrace();
			}
		}

	  }
		btnImageOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImageOKMouseClicked(evt);
            }
        });
        	CenterPanel.add(btnImageOK);
        	btnImageOK.setBounds(115, 108, btnWidthCancel, btnHeightCancel);
	}
	else
	{
		if(EncryptedRuleReader.getLocaleString("errokbtn")!=null)
		{
	  		if(EncryptedRuleReader.getLocaleString("errokbtn").equalsIgnoreCase("")==false)
	  		{
       			btnOK.setText(EncryptedRuleReader.getLocaleString("errokbtn"));
	  		}
	  		else
	  		{	
          			btnOK.setText("OK");
	  		}
		}
		else
		{	
        		btnOK.setText("OK");
		}
		if(EncryptedRuleReader.getLocaleString("errokbtnmnem")!=null)
		{
	  		if(EncryptedRuleReader.getLocaleString("errokbtnmnem").equalsIgnoreCase("")==false)
	  		{
       			btnOK.setMnemonic(EncryptedRuleReader.getLocaleString("errokbtnmnem").charAt(0));
	  		}
		}
        CenterPanel.add(btnOK);
        btnOK.setBounds(115, 108, btnWidthCancel, btnHeightCancel);
	  if(EncryptedRuleReader.get("errbtnfontclr")!=null)
	  {
		if(EncryptedRuleReader.get("errbtnfontclr").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("errbtnfontclr"));
				btnOK.setForeground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
			catch(Exception e)
			{
        			e.printStackTrace();
			}
		}
	  }
	  if(EncryptedRuleReader.get("errbtnfont")!=null)
	  {
		if(EncryptedRuleReader.get("errbtnfont").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("errbtnfont"));
				btnOK.setFont(new java.awt.Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
			catch(Exception e)
			{
        			e.printStackTrace();
			}
		}
	  }
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
	}

	  if(EncryptedRuleReader.get("errtextbgclr")!=null)
	  {
		if(EncryptedRuleReader.get("errtextbgclr").equalsIgnoreCase("")==false)
		{
        		jTextPane1.setBackground(tpBGColor);
        		jTextPane1.setSelectionColor(tpBGColor);
		}
		else
		{
        		jTextPane1.setBackground(CenterPanel.getBackground());
        		jTextPane1.setSelectionColor(CenterPanel.getBackground());
		}
	  }
	  else
	  {
        	jTextPane1.setBackground(CenterPanel.getBackground());
        	jTextPane1.setSelectionColor(CenterPanel.getBackground());
	  }
        jTextPane1.setEditable(false);
        jTextPane1.setMaximumSize(new java.awt.Dimension(310, 92));
        jTextPane1.setMinimumSize(new java.awt.Dimension(310, 92));
        jTextPane1.setPreferredSize(new java.awt.Dimension(310, 92));

	  if(EncryptedRuleReader.get("errfontclr")!=null)
	  {
		if(EncryptedRuleReader.get("errfontclr").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("errfontclr"));
				jTextPane1.setForeground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
			catch(Exception e)
			{
        			e.printStackTrace();
			}
		}
	  }

	  if(EncryptedRuleReader.get("errfont")!=null)
	  {
		if(EncryptedRuleReader.get("errfont").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("errfont"));
				jTextPane1.setFont(new java.awt.Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
			catch(Exception e)
			{
        			e.printStackTrace();
			}
		}
	  }

	if(errorText!=null)
	{
        	jTextPane1.setText(errorText.replaceAll("\\\\r\\\\n", System.getProperty("line.separator")));
	}
	else
	{
        jTextPane1.setText("\r\n\r\nUnknown Error");
	}
        jTextPane1.setSelectedTextColor(jTextPane1.getForeground());
	  jTextPane1.getStyledDocument().putProperty(DefaultEditorKit.EndOfLineStringProperty, "\n");
	  setResizable(false);
	  setModal(true);
        CenterPanel.add(jTextPane1);
        jTextPane1.setBounds(10, 6, 310, 92);

        getContentPane().add(CenterPanel, java.awt.BorderLayout.SOUTH);
	  	if(isImageButton==true)
	  	{
	  		setKeyManager();
		}
        pack();
    }//GEN-END:initComponents
    
    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
	getOKAction();
    }//GEN-LAST:event_btnOKActionPerformed

   private void btnImageOKMouseClicked(java.awt.event.MouseEvent evt)
   {
     getOKAction();
   }

private void getOKAction()
{
    try
    {
        setVisible(false);
        dispose();
    }
    catch(Exception e)
    {
	  e.printStackTrace();
    }  
}

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//EncryptedRuleReader.readPropertiesFile();
//        ErrorDialog td2 = new ErrorDialog("Test Text","Test Text");
	  //td2.setSize(335,205);
	  //td2.show();
//    }

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
    
    private void setBackgroundColor(Color BGColor)
    {
	CenterPanel.setBackground(BGColor);
	NorthPanel.setBackground(BGColor);
	Logo.setBackground(BGColor);
	 // if(isImageButton==true)
	 // {
	 //	btnImageOK.setBackground(BGColor);
	 // }
    }

protected void processKeyEvent(KeyEvent e)
{
super.processKeyEvent(e);
if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
dispose();
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
				armed = false;
                        if(e.getComponent().equals(btnImageOK)==true)
                        {
				    if(e.getKeyCode()==btnImageOK.getDisplayedMnemonic())
                            {
					getOKAction();
				    }
                        }
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
    private javax.swing.JPanel CenterPanel;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel NorthPanel;
    private javax.swing.JButton btnOK;
    private ImageButton btnImageOK;

    // End of variables declaration//GEN-END:variables
    private ErrorPane jTextPane1;
}
