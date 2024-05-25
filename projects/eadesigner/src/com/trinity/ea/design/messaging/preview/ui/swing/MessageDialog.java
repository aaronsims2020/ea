/*
 * MessageDialog.java
 *
 * Created on February 26, 2004, 2:55 PM
 */

package com.trinity.ea.design.messaging.preview.ui.swing;
import com.trinity.ea.messaging.ui.swing.MessagePane;
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
import com.trinity.ea.design.messaging.preview.ui.swing.EAMessageScrollBarUI;
import javax.swing.border.Border;
import com.trinity.ea.forms.gui.swing.ImageButton;
import com.trinity.ea.design.common.file.ProjectManager;
import java.util.ArrayList;
import javax.swing.UIManager;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.io.ByteArrayInputStream;
import java.net.*;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004-2005 Trinity Software. All rights reserved.
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
	  	  //applyComponentOrientation(ComponentOrientation.getOrientation(ProjectManager.getLocale()));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	  if(ProjectManager.get("btnBarImgButtonsEnabled")!=null)
	  {
	  	if(ProjectManager.get("btnBarImgButtonsEnabled").equalsIgnoreCase("true")==true)
	  	{
			isImageButton=true;
	  		if(ProjectManager.get("autoUpdateImgBackgroundColor")!=null)
	  		{
				if(ProjectManager.get("autoUpdateImgBackgroundColor").equalsIgnoreCase("")==false)
				{
					Object[] tmpArray = getStringArraysFromString(ProjectManager.get("autoUpdateImgBackgroundColor"));
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


	  if(ProjectManager.get("paymentImgCancelButtonWidth")!=null)
	  {
	  	if(ProjectManager.get("paymentImgCancelButtonWidth").equalsIgnoreCase("")==false)
	  	{
			try
			{
				btnWidthCancel = new Integer(ProjectManager.get("paymentImgCancelButtonWidth")).intValue();
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
	  if(ProjectManager.get("paymentImgCancelButtonHeight")!=null)
	  {
	  	if(ProjectManager.get("paymentImgCancelButtonHeight").equalsIgnoreCase("")==false)
	  	{
			try
			{
				btnHeightCancel = new Integer(ProjectManager.get("paymentImgCancelButtonHeight")).intValue();
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
		if(ProjectManager.get("paymentImgCancelButtonFace")!=null)
		{
			if(ProjectManager.get("paymentImgCancelButtonFace").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceCancel = new javax.swing.ImageIcon(new URL(ProjectManager.get("paymentImgCancelButtonFace")));
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
		if(ProjectManager.get("paymentImgCancelButtonFaceOnClick")!=null)
		{
			if(ProjectManager.get("paymentImgCancelButtonFaceOnClick").equalsIgnoreCase("")==false)
			{
				try
				{
					btnFaceOnClickCancel = new javax.swing.ImageIcon(new URL(ProjectManager.get("paymentImgCancelButtonFaceOnClick")));

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
					btnFaceInFocusCancel = new javax.swing.ImageIcon(new URL(ProjectManager.get("paymentImgCancelButtonFaceInFocus")));
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
	  	if(ProjectManager.get("project_default_msgtitle")!=null)
	  	{            
			setTitle(ProjectManager.get("project_default_msgtitle"));
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

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

	  try
	  {
	  	if(ProjectManager.get("project_default_msgtextalgn")!=null)
	  	{
	  		if(ProjectManager.get("project_default_msgtextalgn").startsWith("0")==true)
	  		{
        			jTextPane1 = new MessagePane(0);
			}
	  		else if(ProjectManager.get("project_default_msgtextalgn").startsWith("1")==true)
	  		{
        			jTextPane1 = new MessagePane(1);
			}
	  		else if(ProjectManager.get("project_default_msgtextalgn").startsWith("2")==true)
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
	  }
	  else
	  {
        	btnOK = new javax.swing.JButton();
	  }
	  if(ProjectManager.get("msgbgclr")!=null)
	  {
		if(ProjectManager.get("msgbgclr").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("msgbgclr"));
			setBackgroundColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
	  }
	  if(ProjectManager.get("msgtextbgclr")!=null)
	  {
		if(ProjectManager.get("msgtextbgclr").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("msgtextbgclr"));
			tpBGColor = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
	  }
        //setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        NorthPanel.setLayout(null);

        Logo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
	if(ProjectManager.get("msgHeaderImgPath")!=null)
	{
 		if(ProjectManager.get("msgHeaderImgPath").equalsIgnoreCase("")==false)
		{
        		NorthPanel.setMaximumSize(new java.awt.Dimension(330, 30));
        		NorthPanel.setMinimumSize(new java.awt.Dimension(330, 30));
       		NorthPanel.setPreferredSize(new java.awt.Dimension(330, 30));
			try
			{
        			Logo.setIcon(new javax.swing.ImageIcon(new URL(ProjectManager.get("msgHeaderImgPath"))));
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
	  if(ProjectManager.get("project_default_msgType")!=null)
	  {
		if(ProjectManager.get("project_default_msgType").equalsIgnoreCase("0")==true)
		{
			try
			{
			jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
			try
			{
				ProjectManager.get("msgBGImgPath");
			}
			catch(Exception e){}
			if(ProjectManager.get("msgBGImgPath")!=null)
			{
 				if(ProjectManager.get("msgBGImgPath").equalsIgnoreCase("")==false)
				{
        				final Border bkgrnd = new ImageBackgroundBorder(ImageIO.read(new URL(ProjectManager.get("msgBGImgPath"))));
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
		if(ProjectManager.get("project_default_msgokbtn")!=null)
		{
	  		if(ProjectManager.get("project_default_msgokbtn").equalsIgnoreCase("")==false)
	  		{
        			btnImageOK.setText(ProjectManager.get("project_default_msgokbtn"));
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
		if(ProjectManager.get("project_default_msgokbtnmnem")!=null)
		{
	  		if(ProjectManager.get("project_default_msgokbtnmnem").equalsIgnoreCase("")==false)
	  		{
       			btnImageOK.setMnemonic(ProjectManager.get("project_default_msgokbtnmnem").charAt(0));
	  		}
		}
	  	if(ProjectManager.get("project_default_msgType")!=null)
	  	{
			if(ProjectManager.get("project_default_msgType").equalsIgnoreCase("0")==true)
			{
				btnImageOK.setBackground(btnBGColor);
			}
		}
	  if(ProjectManager.get("project_default_msgbtnfontclr")!=null)
	  {
		if(ProjectManager.get("project_default_msgbtnfontclr").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(ProjectManager.get("project_default_msgbtnfontclr"));
				btnImageOK.setForeground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
			catch(Exception e)
			{
        			e.printStackTrace();
			}
		}
	  }

	  if(ProjectManager.get("project_default_msgbtnfont")!=null)
	  {
		if(ProjectManager.get("project_default_msgbtnfont").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(ProjectManager.get("project_default_msgbtnfont"));
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
		if(ProjectManager.get("project_default_msgokbtn")!=null)
		{
	  		if(ProjectManager.get("project_default_msgokbtn").equalsIgnoreCase("")==false)
	  		{
       			btnOK.setText(ProjectManager.get("project_default_msgokbtn"));
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
		if(ProjectManager.get("project_default_msgokbtnmnem")!=null)
		{
	  		if(ProjectManager.get("project_default_msgokbtnmnem").equalsIgnoreCase("")==false)
	  		{
       			btnOK.setMnemonic(ProjectManager.get("project_default_msgokbtnmnem").charAt(0));
	  		}
		}
        CenterPanel.add(btnOK);
        btnOK.setBounds(115, 108, btnWidthCancel, btnHeightCancel);
	  if(ProjectManager.get("project_default_msgbtnfontclr")!=null)
	  {
		if(ProjectManager.get("project_default_msgbtnfontclr").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(ProjectManager.get("project_default_msgbtnfontclr"));
				btnOK.setForeground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
			catch(Exception e)
			{
        			e.printStackTrace();
			}
		}
	  }
	  if(ProjectManager.get("project_default_msgbtnfont")!=null)
	  {
		if(ProjectManager.get("project_default_msgbtnfont").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(ProjectManager.get("project_default_msgbtnfont"));
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

        jScrollPane1.setBackground(tpBGColor);
        jScrollPane1.setBorder(null);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(310, 92));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(310, 92));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(310, 92));
        jTextPane1.setBackground(tpBGColor);
        jTextPane1.setEditable(false);
	  if(ProjectManager.get("project_default_msgfontclr")!=null)
	  {
		if(ProjectManager.get("project_default_msgfontclr").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(ProjectManager.get("project_default_msgfontclr"));
				jTextPane1.setForeground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
			catch(Exception e)
			{
        			e.printStackTrace();
			}
		}
	  }

	  if(ProjectManager.get("project_default_msgfont")!=null)
	  {
		if(ProjectManager.get("project_default_msgfont").equalsIgnoreCase("")==false)
		{
			try
			{
				Object[] tmpArray = getStringArraysFromString(ProjectManager.get("project_default_msgfont"));
				jTextPane1.setFont(new java.awt.Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
			catch(Exception e)
			{
        			e.printStackTrace();
			}
		}
	  }

	if(ProjectManager.get("project_default_msgtext")!=null)
	{
	  if(ProjectManager.get("project_default_msgtext").equalsIgnoreCase("")==false)
	  {
        	jTextPane1.setText(ProjectManager.get("project_default_msgtext").replaceAll("\\\\r\\\\n", System.getProperty("line.separator")));
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
        jScrollPane1.setBounds(10, 6, 310, 92);

	  if(ProjectManager.get("customScrollBarsEnabled")!=null)
	  {
	  	if(ProjectManager.get("customScrollBarsEnabled").equalsIgnoreCase("true")==true)
	  	{ 
JScrollBar spvBar = jScrollPane1.getVerticalScrollBar();
EAMessageScrollBarUI sbUI = new EAMessageScrollBarUI();
		if(ProjectManager.get("sbBackgroundColor")!=null)
		{
			if(ProjectManager.get("sbBackgroundColor").equalsIgnoreCase("")==false)
			{
				Object[] tmpArray = getStringArraysFromString(ProjectManager.get("sbBackgroundColor"));
				spvBar.setBackground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
		}
		if(ProjectManager.get("sbForegroundColor")!=null)
		{
			if(ProjectManager.get("sbForegroundColor").equalsIgnoreCase("")==false)
			{
				Object[] tmpArray = getStringArraysFromString(ProjectManager.get("sbForegroundColor"));
				spvBar.setForeground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
		}

		if(ProjectManager.get("sbBGArrowBtnColor")!=null)
		{
			if(ProjectManager.get("sbBGArrowBtnColor").equalsIgnoreCase("")==false)
			{
				Object[] tmpArray = getStringArraysFromString(ProjectManager.get("sbBGArrowBtnColor"));
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
if(ProjectManager.get("project_default_msgType")!=null)
{
	if(ProjectManager.get("project_default_msgType").equalsIgnoreCase("0")==false)
	{
	  if(ProjectManager.get("registrationTFExtBorderColor")!=null)
	  {
		if(ProjectManager.get("registrationTFExtBorderColor").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationTFExtBorderColor"));
			extBorderColor = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
	  }
	  if(ProjectManager.get("registrationTFHighlightBorderColor1")!=null)
	  {
		if(ProjectManager.get("registrationTFHighlightBorderColor1").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationTFHighlightBorderColor1"));
			highlightBorderColor1 = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
	  }
	  if(ProjectManager.get("registrationTFHighlightBorderColor2")!=null)
	  {
		if(ProjectManager.get("registrationTFHighlightBorderColor2").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationTFHighlightBorderColor2"));
			highlightBorderColor2 = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
	  }
	  if(ProjectManager.get("registrationTFShadowBorderColor1")!=null)
	  {
		if(ProjectManager.get("registrationTFShadowBorderColor1").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationTFShadowBorderColor1"));
			shadowBorderColor1 = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
	  }
	  if(ProjectManager.get("registrationTFShadowBorderColor2")!=null)
	  {
		if(ProjectManager.get("registrationTFShadowBorderColor2").equalsIgnoreCase("")==false)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationTFShadowBorderColor2"));
			shadowBorderColor2 = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(),new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue());
		}
	  }
//
	  if(ProjectManager.get("registrationCustomBorderEnabled")!=null)
	  {
		if(ProjectManager.get("registrationCustomBorderEnabled").equalsIgnoreCase("true")==true)
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

private void getOKAction()
{
                //if(ProjectManager.get("msgOKAction")!=null)
               // {
   try
   {
   	setVisible(false);
      dispose();
	try
	{
		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
	}
	catch(Exception e)
	{

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
    
    private void setBackgroundColor(Color BGColor)
    {
	CenterPanel.setBackground(BGColor);
	NorthPanel.setBackground(BGColor);
	Logo.setBackground(BGColor);
	  if(isImageButton==true)
	  {
	  	if(ProjectManager.get("project_lastMessageIDNumber")!=null)
	  	{
			if(ProjectManager.get("project_lastMessageIDNumber").equalsIgnoreCase("0")==false)
			{
				btnImageOK.setBackground(BGColor);
			}
	  	}
	  }
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

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
				try
				{
					UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
				}
				catch(Exception e)
				{

				}
    }//GEN-LAST:event_closeDialog

    private boolean armed = false;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CenterPanel;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel NorthPanel;
    private javax.swing.JButton btnOK;
    private javax.swing.JScrollPane jScrollPane1;
    private ImageButton btnImageOK;

    // End of variables declaration//GEN-END:variables
    private MessagePane jTextPane1;
}
