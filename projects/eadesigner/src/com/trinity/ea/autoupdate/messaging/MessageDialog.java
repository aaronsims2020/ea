/*
 * MessageDialog.java
 *
 * Created on February 26, 2004, 2:55 PM
 */

package com.trinity.ea.autoupdate.messaging;
import com.trinity.ea.autoupdate.messaging.MessagePane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.text.*;
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
import com.trinity.ea.autoupdate.messaging.EAMessageScrollBarUI;
import javax.swing.border.Border;
import com.trinity.ea.forms.gui.swing.ImageButton;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import com.trinity.ea.autoupdate.reader.EncryptedUpdateReader;
import java.util.ArrayList;
import javax.swing.UIManager;
import java.net.*;
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
public class MessageDialog extends javax.swing.JDialog {
    private int btnWidthCancel = 94;
    private int btnHeightCancel = 31;   
    private ImageIcon btnFaceCancel = null;
    private ImageIcon btnFaceOnClickCancel = null;
    private ImageIcon btnFaceInFocusCancel = null;
    private Color btnBGColor = new Color(240,240,240);
    private Color bgColor = new Color(240,240,240);
    private Color tpBGColor = new Color(240,240,240);
    private Color extBorderColor = new Color(162,186,202);
    private Color highlightBorderColor1 = new Color(38,54,69);
    private Color highlightBorderColor2 = new Color(100,132,154);
    private Color shadowBorderColor1 = new Color(162,182,202);
    private Color shadowBorderColor2 = new Color(215,226,233);
    private boolean isImageButton = false;

    public MessageDialog() 
    {
    		new MessageDialog(new javax.swing.JFrame(), true).show();
    }

    /** Creates new form MessageDialog */
    public MessageDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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
	  		if(EncryptedRuleReader.get("autoUpdateImgBackgroundColor")!=null)
	  		{
				if(EncryptedRuleReader.get("autoUpdateImgBackgroundColor").equalsIgnoreCase("")==false)
				{
					Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("autoUpdateImgBackgroundColor"));
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
				//eee.printStackTrace();
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
				//eee.printStackTrace();
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
if(isImageButton==true)
{
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
					//e.printStackTrace();
					isImageButton=false;
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
					//e.printStackTrace();
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
					//e.printStackTrace();
				}
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
        // Move the window
        setLocation(x, y);
        try
        {
	  	if(EncryptedUpdateReader.get("msgtitle")!=null)
	  	{            
			setTitle(EncryptedUpdateReader.get("msgtitle"));
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
        jScrollPane1 = new javax.swing.JScrollPane();

	  try
	  {
	  	if(EncryptedUpdateReader.get("msgtextalgn")!=null)
	  	{
	  		if(EncryptedUpdateReader.get("msgtextalgn").startsWith("0")==true)
	  		{
        			jTextPane1 = new MessagePane(0);
			}
	  		else if(EncryptedUpdateReader.get("msgtextalgn").startsWith("1")==true)
	  		{
        			jTextPane1 = new MessagePane(1);
			}
	  		else if(EncryptedUpdateReader.get("msgtextalgn").startsWith("2")==true)
	  		{
        			jTextPane1 = new MessagePane(2);
			}			
	  	}
	 	else
	  	{
        		jTextPane1 = new MessagePane(1);
	  	}
	  }
	  catch(Exception e)
	  {
        	jTextPane1 = new MessagePane(1);
	  }

	  if(isImageButton==true)
	  {
        	btnImageOK = new ImageButton(btnFaceCancel,btnFaceOnClickCancel,btnFaceInFocusCancel,btnWidthCancel,btnHeightCancel);
        	btnImageSkip = new ImageButton(btnFaceCancel,btnFaceOnClickCancel,btnFaceInFocusCancel,btnWidthCancel,btnHeightCancel);

	  }
	  else
	  {
        	btnOK = new javax.swing.JButton();
        	btnSkip = new javax.swing.JButton();
	  }
	  if(EncryptedRuleReader.get("msgbgclr")!=null)
	  {
		if(EncryptedRuleReader.get("msgbgclr").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("msgbgclr"));
			setBackgroundColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }

	  if(EncryptedRuleReader.get("msgtextbgclr")!=null)
	  {
		if(EncryptedRuleReader.get("msgtextbgclr").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("msgtextbgclr"));
			tpBGColor = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
	  }
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        NorthPanel.setLayout(null);

        Logo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
	if(EncryptedRuleReader.get("msgHeaderImgPath")!=null)
	{
 		if(EncryptedRuleReader.get("msgHeaderImgPath").equalsIgnoreCase("")==false)
		{
        		NorthPanel.setMaximumSize(new java.awt.Dimension(330, 30));
        		NorthPanel.setMinimumSize(new java.awt.Dimension(330, 30));
       		NorthPanel.setPreferredSize(new java.awt.Dimension(330, 30));
			try
			{
        		Logo.setIcon(new javax.swing.ImageIcon(EncryptedRuleReader.getImage(getClass().getResource(EncryptedRuleReader.get("msgHeaderImgPath")))));
        		NorthPanel.add(Logo, java.awt.BorderLayout.CENTER);
			Logo.setBounds(5, 2, 330, 30);
			}
			catch(Exception e)
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
	  if(EncryptedUpdateReader.get("type")!=null)
	  {
		if(EncryptedUpdateReader.get("type").equalsIgnoreCase("0")==true)
		{
			jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
			try
			{
			if(EncryptedRuleReader.get("msgBGImgPath")!=null)
			{
 				if(EncryptedRuleReader.get("msgBGImgPath").equalsIgnoreCase("")==false)
				{
        				final Border bkgrnd = new ImageBackgroundBorder(ImageIO.read(new ByteArrayInputStream(EncryptedRuleReader.getImage(getClass().getResource(EncryptedRuleReader.get("msgBGImgPath"))))));
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

			}
		}
	}
}
catch(Exception e)
{
	//e.printStackTrace();
}


	if(isImageButton==true)
	{
		if(EncryptedUpdateReader.get("msgokbtn")!=null)
		{
	  		if(EncryptedUpdateReader.get("msgokbtn").equalsIgnoreCase("")==false)
	  		{
        			btnImageOK.setText(EncryptedUpdateReader.get("msgokbtn"));
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
		if(EncryptedUpdateReader.get("msgokbtnmnem")!=null)
		{
	  		if(EncryptedUpdateReader.get("msgokbtnmnem").equalsIgnoreCase("")==false)
	  		{
     				btnImageOK.setMnemonic(EncryptedUpdateReader.get("msgokbtnmnem").charAt(0));
	  		}
		}
///////////
		if(EncryptedUpdateReader.get("msgskipbtn")!=null)
		{
	  		if(EncryptedUpdateReader.get("msgskipbtn").equalsIgnoreCase("")==false)
	  		{
        			btnImageSkip.setText(EncryptedUpdateReader.get("msgskipbtn"));
	  		}
	  		else
	  		{	
          			btnImageSkip.setText("Skip");
	  		}
		}
		else
		{	
        		btnImageSkip.setText("Skip");
		}
		if(EncryptedUpdateReader.get("msgskipbtnmnem")!=null)
		{
	  		if(EncryptedUpdateReader.get("msgskipbtnmnem").equalsIgnoreCase("")==false)
	  		{
       			btnImageSkip.setMnemonic(EncryptedUpdateReader.get("msgskipbtnmnem").charAt(0));
	  		}
		}


	  	if(EncryptedUpdateReader.get("type")!=null)
	  	{
			if(EncryptedUpdateReader.get("type").equalsIgnoreCase("0")==true)
			{
				btnImageOK.setBackground(btnBGColor);
				btnImageSkip.setBackground(btnBGColor);
			}
		}
	  if(EncryptedUpdateReader.get("msgbtnfontclr")!=null)
	  {
		if(EncryptedUpdateReader.get("msgbtnfontclr").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(EncryptedUpdateReader.get("msgbtnfontclr"));
				btnImageOK.setForeground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
				btnImageSkip.setForeground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
			catch(Exception e)
			{
        			e.printStackTrace();
			}
		}
	  }

	  if(EncryptedUpdateReader.get("msgbtnfont")!=null)
	  {
		if(EncryptedUpdateReader.get("msgbtnfont").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(EncryptedUpdateReader.get("msgbtnfont"));
				btnImageOK.setFont(new java.awt.Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
				btnImageSkip.setFont(new java.awt.Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
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
        	btnImageOK.setBounds(64, 108, btnWidthCancel, btnHeightCancel);

		btnImageSkip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImageSkipMouseClicked(evt);
            }
        });
        	CenterPanel.add(btnImageSkip);
        	btnImageSkip.setBounds(164, 108, btnWidthCancel, btnHeightCancel);

	}
	else
	{
		if(EncryptedUpdateReader.get("msgokbtn")!=null)
		{
	  		if(EncryptedUpdateReader.get("msgokbtn").equalsIgnoreCase("")==false)
	  		{
       			btnOK.setText(EncryptedUpdateReader.get("msgokbtn"));
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
		if(EncryptedUpdateReader.get("msgokbtnmnem")!=null)
		{
	  		if(EncryptedUpdateReader.get("msgokbtnmnem").equalsIgnoreCase("")==false)
	  		{
       			btnOK.setMnemonic(EncryptedUpdateReader.get("msgokbtnmnem").charAt(0));
	  		}
		}
		if(EncryptedUpdateReader.get("msgskipbtn")!=null)
		{
	  		if(EncryptedUpdateReader.get("msgskipbtn").equalsIgnoreCase("")==false)
	  		{
       			btnSkip.setText(EncryptedUpdateReader.get("msgskipbtn"));
	  		}
	  		else
	  		{	
          			btnSkip.setText("Skip");
	  		}
		}
		else
		{	
        		btnSkip.setText("Skip");
		}
		if(EncryptedUpdateReader.get("msgskipbtnmnem")!=null)
		{
	  		if(EncryptedUpdateReader.get("msgskipbtnmnem").equalsIgnoreCase("")==false)
	  		{
       			btnSkip.setMnemonic(EncryptedUpdateReader.get("msgskipbtnmnem").charAt(0));
	  		}
		}
        CenterPanel.add(btnOK);
        btnOK.setBounds(64, 108, btnWidthCancel, 23);
        CenterPanel.add(btnSkip);
        btnSkip.setBounds(164, 108, btnWidthCancel, 23);

	  if(EncryptedUpdateReader.get("msgbtnfontclr")!=null)
	  {
		if(EncryptedUpdateReader.get("msgbtnfontclr").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(EncryptedUpdateReader.get("msgbtnfontclr"));
				btnOK.setForeground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
				btnSkip.setForeground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
			catch(Exception e)
			{
        			e.printStackTrace();
			}
		}
	  }

	  if(EncryptedUpdateReader.get("msgbtnfont")!=null)
	  {
		if(EncryptedUpdateReader.get("msgbtnfont").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(EncryptedUpdateReader.get("msgbtnfont"));
				btnOK.setFont(new java.awt.Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
				btnSkip.setFont(new java.awt.Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
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
        btnSkip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkipActionPerformed(evt);
            }
        });
	}

        jScrollPane1.setBackground(tpBGColor);
        jScrollPane1.setBorder(null);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(310, 92));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(310, 92));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(310, 92));
        jTextPane1.setBackground(tpBGColor);
        jTextPane1.setEditable(false);
	  if(EncryptedUpdateReader.get("msgfontclr")!=null)
	  {
		if(EncryptedUpdateReader.get("msgfontclr").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(EncryptedUpdateReader.get("msgfontclr"));
				jTextPane1.setForeground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
			catch(Exception e)
			{
        			e.printStackTrace();
			}
		}
	  }

	  if(EncryptedUpdateReader.get("msgfont")!=null)
	  {
		if(EncryptedUpdateReader.get("msgfont").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(EncryptedUpdateReader.get("msgfont"));
				jTextPane1.setFont(new java.awt.Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
			catch(Exception e)
			{
        			e.printStackTrace();
			}
		}
	  }
	if(EncryptedUpdateReader.get("msgtext")!=null)
	{
	  if(EncryptedUpdateReader.get("msgtext").equalsIgnoreCase("")==false)
	  {
        	jTextPane1.setText(EncryptedUpdateReader.get("msgtext").replaceAll("\\\\r\\\\n", System.getProperty("line.separator")));
	  }
	  else
	  {
           jTextPane1.setText("System Message: Message goes here.");
	  }
	}
	else
	{
        jTextPane1.setText("System Message: Message goes here.");
	}
        jTextPane1.setSelectedTextColor(jTextPane1.getForeground());
        jTextPane1.setSelectionColor(tpBGColor);
 jTextPane1.getStyledDocument().putProperty(DefaultEditorKit.EndOfLineStringProperty, "\n");
        jScrollPane1.setViewportView(jTextPane1);
	  setResizable(false);
        CenterPanel.add(jScrollPane1);
        jScrollPane1.setBounds(15, 12, 305, 86);

	  if(EncryptedRuleReader.get("customScrollBarsEnabled")!=null)
	  {
	  	if(EncryptedRuleReader.get("customScrollBarsEnabled").equalsIgnoreCase("true")==true)
	  	{ 
JScrollBar spvBar = jScrollPane1.getVerticalScrollBar();
EAMessageScrollBarUI sbUI = new EAMessageScrollBarUI();
		if(EncryptedRuleReader.get("sbBackgroundColor")!=null)
		{
			if(EncryptedRuleReader.get("sbBackgroundColor").equalsIgnoreCase("")==false)
			{
				Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("sbBackgroundColor"));
				spvBar.setBackground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
		}
		if(EncryptedRuleReader.get("sbForegroundColor")!=null)
		{
			if(EncryptedRuleReader.get("sbForegroundColor").equalsIgnoreCase("")==false)
			{
				Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("sbForegroundColor"));
				spvBar.setForeground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
		}

		if(EncryptedRuleReader.get("sbBGArrowBtnColor")!=null)
		{
			if(EncryptedRuleReader.get("sbBGArrowBtnColor").equalsIgnoreCase("")==false)
			{
				Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("sbBGArrowBtnColor"));
				spvBar.getComponent(0).setBackground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
				spvBar.getComponent(1).setBackground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
		}
spvBar.setUI(sbUI); // no try/catch needed here...
jScrollPane1.setVerticalScrollBar(spvBar);
//
//
		}
	}
if(EncryptedUpdateReader.get("type")!=null)
{
	if(EncryptedUpdateReader.get("type").equalsIgnoreCase("0")==false)
	{
	  if(EncryptedRuleReader.get("registrationTFExtBorderColor")!=null)
	  {
		if(EncryptedRuleReader.get("registrationTFExtBorderColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("registrationTFExtBorderColor"));
			extBorderColor = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
	  }
	  if(EncryptedRuleReader.get("registrationTFHighlightBorderColor1")!=null)
	  {
		if(EncryptedRuleReader.get("registrationTFHighlightBorderColor1").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("registrationTFHighlightBorderColor1"));
			highlightBorderColor1 = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
	  }
	  if(EncryptedRuleReader.get("registrationTFHighlightBorderColor2")!=null)
	  {
		if(EncryptedRuleReader.get("registrationTFHighlightBorderColor2").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("registrationTFHighlightBorderColor2"));
			highlightBorderColor2 = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
	  }
	  if(EncryptedRuleReader.get("registrationTFShadowBorderColor1")!=null)
	  {
		if(EncryptedRuleReader.get("registrationTFShadowBorderColor1").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("registrationTFShadowBorderColor1"));
			shadowBorderColor1 = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
	  }
	  if(EncryptedRuleReader.get("registrationTFShadowBorderColor2")!=null)
	  {
		if(EncryptedRuleReader.get("registrationTFShadowBorderColor2").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(EncryptedRuleReader.get("registrationTFShadowBorderColor2"));
			shadowBorderColor2 = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
	  }
//
	  if(EncryptedRuleReader.get("registrationCustomBorderEnabled")!=null)
	  {
		if(EncryptedRuleReader.get("registrationCustomBorderEnabled").equalsIgnoreCase("true")==true)
		{
		     jScrollPane1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(1, 0, 1, 1), extBorderColor), new javax.swing.border.CompoundBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 1, 1), shadowBorderColor2), new javax.swing.border.MatteBorder(new java.awt.Insets(1, 1, 0, 0), highlightBorderColor2))), new javax.swing.border.CompoundBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 1, 1), shadowBorderColor1), new javax.swing.border.MatteBorder(new java.awt.Insets(1, 1, 0, 0), highlightBorderColor1))));
			jTextPane1.setBorder(null);
		}
	  }
	}
}
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
////////////////////////
    private void btnSkipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkipActionPerformed
	getSkipAction();
    }//GEN-LAST:event_btnSkipActionPerformed

   private void btnImageSkipMouseClicked(java.awt.event.MouseEvent evt)
   {
	getSkipAction();
   }

private void getOKAction()
{
                if(EncryptedRuleReader.get("autoUpdateInstallAction")!=null)
                {
                    try
                    {
        			setVisible(false);
                        dispose();
                        Class.forName(EncryptedRuleReader.get("autoUpdateInstallAction")).newInstance();

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

private void getSkipAction()
{
                if(EncryptedRuleReader.get("autoUpdateSkipAction")!=null)
                {
                    try
                    {
			      setVisible(false);
                        dispose();
                        Class.forName(EncryptedRuleReader.get("autoUpdateSkipAction")).newInstance();
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

    /**
     * @param args the command line arguments
     */
  //  public static void main(String args[]) {
  //      MessageDialog td2 = new MessageDialog(new javax.swing.JFrame(), true);
	  //td2.setSize(335,205);
  //	  td2.show();
  //  }

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
	  if(isImageButton==true)
	  {
	  	if(EncryptedUpdateReader.get("type")!=null)
	  	{
			if(EncryptedUpdateReader.get("type").equalsIgnoreCase("0")==false)
			{
				btnImageOK.setBackground(BGColor);
			}
	  	}
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
				armed = false;
                        if(e.getComponent().equals(btnImageSkip)==true)
                        {
				    if(e.getKeyCode()==btnImageSkip.getDisplayedMnemonic())
                            {
					getSkipAction();
				    }
                        }
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton btnOK;
    private ImageButton btnImageOK;
    private javax.swing.JButton btnSkip;
    private ImageButton btnImageSkip;
    // End of variables declaration//GEN-END:variables
    private MessagePane jTextPane1;
}
