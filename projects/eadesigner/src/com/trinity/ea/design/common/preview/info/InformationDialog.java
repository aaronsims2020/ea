/*
 * InformationDialog.java
 *
 * Created on November 8, 2003, 1:04 AM
 */

package com.trinity.ea.design.common.preview.info;
import com.trinity.ea.design.common.file.ProjectManager;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import com.trinity.ea.forms.gui.swing.ImageButton;
import java.util.ArrayList;
import java.awt.ComponentOrientation;
import javax.swing.UIManager;
import javax.swing.UIDefaults;
import javax.swing.JScrollBar;
import com.trinity.ea.design.common.preview.info.EAScrollBarUI;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.RenderingHints;  
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import javax.swing.UIManager;
import java.net.URL;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2005 Trinity Software. All rights reserved.
 */
public class InformationDialog extends javax.swing.JDialog {
	private int windowWidth = 425;
	private int windowHeight = 160;
        private ImageIcon btnFace = null;
    	  private ImageIcon btnFaceOnClick = null;
   	  private ImageIcon btnFaceInFocus = null;
    	  private int btnWidth = -1;
    	  private int btnHeight = -1;    
    	  private boolean isImageButton = false;
    	  private Color extBorderColor = new Color(162,186,202);
    	  private Color highlightBorderColor1 = new Color(38,54,69);
    	  private Color highlightBorderColor2 = new Color(100,132,154);
    	  private Color shadowBorderColor1 = new Color(162,182,202);
    	  private Color shadowBorderColor2 = new Color(215,226,233);

    /** Creates new form InformationDialog */
    public InformationDialog(java.awt.Frame parent, boolean modal) {
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
			else
			{
				isImageButton=false;
			}
		}
		else
		{
			isImageButton=false;
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

        if(ProjectManager.get("informationTextTitle")!=null)
        {
        	setTitle(ProjectManager.get("informationTextTitle"));
	  }
      
        setSize(windowWidth + 6 + getHorizontalInsetAdjustment(this.getInsets().left, this.getInsets().right), windowHeight + 73 + getVerticalInsetAdjustment(this.getInsets().top, this.getInsets().bottom));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = getSize().width;
        int h = getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        setLocation(x, y);  
	  Policy.setCaretPosition(0);
		if(ProjectManager.get("informationTextBackgroundColor")!=null)
		{
			if(ProjectManager.get("informationTextBackgroundColor").equalsIgnoreCase("")==false)
			{
				Object[] tmpArray = getStringArraysFromString(ProjectManager.get("informationTextBackgroundColor"));
        			Policy.setBackground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
		}
		else
		{
			Policy.setBackground(getBackground());
		}
		if(ProjectManager.get("informationTextColor")!=null)
		{
			if(ProjectManager.get("informationTextColor").equalsIgnoreCase("")==false)
			{
				Object[] tmpArray = getStringArraysFromString(ProjectManager.get("informationTextColor"));
        			Policy.setForeground(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
		}
		if(ProjectManager.get("informationButtonTextColor")!=null)
		{
			if(ProjectManager.get("informationButtonTextColor").equalsIgnoreCase("")==false)
			{
				Object[] tmpArray = getStringArraysFromString(ProjectManager.get("informationButtonTextColor"));
        			setButtonTextColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
		}

		if(ProjectManager.get("informationBackgroundColor")!=null)
		{
			if(ProjectManager.get("informationBackgroundColor").equalsIgnoreCase("")==false)
			{
				Object[] tmpArray = getStringArraysFromString(ProjectManager.get("informationBackgroundColor"));
        			setBackgroundColor(new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
			}
		}
		else
		{
			Policy.setBackground(getBackground());
		}
	try
	{
	  	  //applyComponentOrientation(ComponentOrientation.getOrientation(ProjectManager.getLocale()));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
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
        NorthPanel = new javax.swing.JPanel();
        WestPanel = new javax.swing.JPanel();
        EastPanel = new javax.swing.JPanel();
        OKPanel = new javax.swing.JPanel();
	  if(isImageButton==true)
	  {
        	btnImageOK = new ImageButton(btnFace,btnFaceOnClick,btnFaceInFocus,btnWidth,btnHeight);
	  }
	  else
	  {
        	btnOK = new javax.swing.JButton();
	  }
        InformationDialogScrollPane = new javax.swing.JScrollPane();
        Policy = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

	  OKPanel.setLayout(new javax.swing.BoxLayout(OKPanel, javax.swing.BoxLayout.X_AXIS));
        NorthPanel.setMaximumSize(new java.awt.Dimension(12, 12));
        NorthPanel.setMinimumSize(new java.awt.Dimension(12, 12));
        NorthPanel.setPreferredSize(new java.awt.Dimension(12, 12));
        WestPanel.setMaximumSize(new java.awt.Dimension(12, 12));
        WestPanel.setMinimumSize(new java.awt.Dimension(12, 12));
        WestPanel.setPreferredSize(new java.awt.Dimension(12, 12));
        EastPanel.setMaximumSize(new java.awt.Dimension(12, 12));
        EastPanel.setMinimumSize(new java.awt.Dimension(12, 12));
        EastPanel.setPreferredSize(new java.awt.Dimension(12, 12));
	  Policy.setWrapStyleWord(true);
	  Policy.setLineWrap(true);
		if(ProjectManager.get("informationText")!=null)
		{

	  		Policy.setText(ProjectManager.get("informationText").replaceAll("\\\\r\\\\n", System.getProperty("line.separator")));         
		} 

        getContentPane().setLayout(new java.awt.BorderLayout());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
		setResizable(false);
		if(ProjectManager.get("informationTextFont")!=null)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("informationTextFont"));
			Policy.setFont(new java.awt.Font((String)tmpArray[0], new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
		}
		if(ProjectManager.get("informationOKBtnText")!=null)
		{
        if(isImageButton==true)
	  {
        	btnImageOK.setText(ProjectManager.get("informationOKBtnText"));
	  }
	  else
	  {
        	btnOK.setText(ProjectManager.get("informationOKBtnText"));
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
		if(ProjectManager.get("errbtnfont")!=null)
		{
			Object[] tmpArray = getStringArraysFromString(ProjectManager.get("errbtnfont"));
        if(isImageButton==true)
	  {
        	btnImageOK.setFont(new java.awt.Font((String)tmpArray[0], new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
	  }
	  else
	  {
        	btnOK.setFont(new java.awt.Font((String)tmpArray[0], new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()));
	  }
	  }
	  if(isImageButton==true)
	  {
	  if(ProjectManager.get("informationOKBtnMnemonic")!=null)
	  {
	  	if(ProjectManager.get("informationOKBtnMnemonic").equalsIgnoreCase("")==false)
	  	{
	      	btnImageOK.setMnemonic(ProjectManager.get("informationOKBtnMnemonic").charAt(0));
		}
	  }
	  }
	  else
	  {
	  if(ProjectManager.get("informationOKBtnMnemonic")!=null)
	  {
	  	if(ProjectManager.get("informationOKBtnMnemonic").equalsIgnoreCase("")==false)
	  	{
	      	btnOK.setMnemonic(ProjectManager.get("informationOKBtnMnemonic").charAt(0));
		}
	  }
	  }
if(isImageButton==true)
{
 btnImageOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImageOKMouseClicked(evt);
            }
        });

}
else
{
            btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
}

if(isImageButton==false)
{
		btnOK.setMinimumSize(new java.awt.Dimension(75,23));
		btnOK.setPreferredSize(new java.awt.Dimension(75,23));
		btnOK.setMaximumSize(new java.awt.Dimension(120,23));
}

        jLabel2.setMaximumSize(new java.awt.Dimension(32767, 12));
	  jLabel2.setMinimumSize(new java.awt.Dimension(12, 12));
        OKPanel.add(jLabel2);
if(isImageButton==true)
{
        OKPanel.add(btnImageOK);
}
else
{
        OKPanel.add(btnOK);
}
        jLabel1.setMaximumSize(new java.awt.Dimension(12, 12));
        jLabel1.setMinimumSize(new java.awt.Dimension(12, 12));
        jLabel1.setPreferredSize(new java.awt.Dimension(12, 12));
        OKPanel.add(jLabel1);

        OKPanel.setMaximumSize(new java.awt.Dimension(32767, 46));
        OKPanel.setMinimumSize(new java.awt.Dimension(12, 46));
        OKPanel.setPreferredSize(new java.awt.Dimension(12, 46));

        getContentPane().add(OKPanel, java.awt.BorderLayout.SOUTH);
        getContentPane().add(NorthPanel, java.awt.BorderLayout.NORTH);
        getContentPane().add(WestPanel, java.awt.BorderLayout.WEST);
        getContentPane().add(EastPanel, java.awt.BorderLayout.EAST);

if(ProjectManager.get("informationDialogSize")!=null)
{
	Object[] tmpArray = getStringArraysFromString(ProjectManager.get("informationDialogSize"));
	windowWidth = new Integer((String)tmpArray[0]).intValue();
	windowHeight = new Integer((String)tmpArray[1]).intValue();
}
        Policy.setEditable(false);
        InformationDialogScrollPane.setViewportView(Policy);

//
	  if(ProjectManager.get("customScrollBarsEnabled")!=null)
	  {
	  	if(ProjectManager.get("customScrollBarsEnabled").equalsIgnoreCase("true")==true)
	  	{ 
JScrollBar spvBar = InformationDialogScrollPane.getVerticalScrollBar();
EAScrollBarUI sbUI = new EAScrollBarUI();
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
InformationDialogScrollPane.setVerticalScrollBar(spvBar);
//
//
		}
	}
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
		     InformationDialogScrollPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(1, 0, 1, 1), extBorderColor), new javax.swing.border.CompoundBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 1, 1), shadowBorderColor2), new javax.swing.border.MatteBorder(new java.awt.Insets(1, 1, 0, 0), highlightBorderColor2))), new javax.swing.border.CompoundBorder(new javax.swing.border.MatteBorder(new java.awt.Insets(0, 0, 1, 1), shadowBorderColor1), new javax.swing.border.MatteBorder(new java.awt.Insets(1, 1, 0, 0), highlightBorderColor1))));
			Policy.setBorder(null);
		}
	  }


        getContentPane().add(InformationDialogScrollPane, java.awt.BorderLayout.CENTER);
	  	if(isImageButton==true)
	  	{
	  		setKeyManager();
		}
        pack();
    }//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
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
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnImageOKMouseClicked(java.awt.event.MouseEvent evt) 
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

   public void setButtonTextColor(Color fontColor)
   {
	try
	{
	  	if(isImageButton==true)
	  	{
			btnImageOK.setForeground(fontColor);
	  	}
		else
		{
			btnOK.setForeground(fontColor);
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
		NorthPanel.setBackground(BGColor);
		WestPanel.setBackground(BGColor);
		EastPanel.setBackground(BGColor);
		OKPanel.setBackground(BGColor);
		InformationDialogScrollPane.setBackground(BGColor);
		jLabel1.setBackground(BGColor);
		jLabel2.setBackground(BGColor);
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
	g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
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
    private javax.swing.JPanel NorthPanel;
    private javax.swing.JPanel WestPanel;
    private javax.swing.JPanel EastPanel;
    private javax.swing.JPanel OKPanel;
    private javax.swing.JTextArea Policy;
    private javax.swing.JScrollPane InformationDialogScrollPane;
    private javax.swing.JButton btnOK;
    private ImageButton btnImageOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
    
}
