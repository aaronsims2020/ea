/*
 * dlgStartupWindowVerticalButtonBar.java
 *
 * Created on June 4, 2004, 12:44 AM
 */

package com.trinity.ea.forms.startupui.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import com.trinity.ea.util.Trial;
import com.trinity.ea.forms.startupui.swing.StartupWindowPanelVerticalButtonBar;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2005 Trinity Software. All rights reserved.
 */
public class dlgStartupWindowVerticalButtonBar extends javax.swing.JDialog {
    
    /** Creates new form dlgStartupWindowVerticalButtonBar */
    public dlgStartupWindowVerticalButtonBar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
	  if(EncryptedRuleReader.get("isProgressBarEnabled").equalsIgnoreCase("true")==true)
	  {
	  	if(EncryptedRuleReader.get("project_expiration_support_is_enabled").equalsIgnoreCase("true")==true)
	  	{
	        setSize(StartupPanelTarget.getWidth() + getHorizontalInsetAdjustment(this.getInsets().left, this.getInsets().right),StartupPanelTarget.getHeight() + getVerticalInsetAdjustment(this.getInsets().top, this.getInsets().bottom));
		}
		else
		{
	        setSize(StartupPanelTarget.getWidth() + getHorizontalInsetAdjustment(this.getInsets().left, this.getInsets().right),(StartupPanelTarget.getHeight() + getVerticalInsetAdjustment(this.getInsets().top, this.getInsets().bottom)) - 22);
		}
	  }
	  else
	  {
	        setSize(StartupPanelTarget.getWidth() + getHorizontalInsetAdjustment(this.getInsets().left, this.getInsets().right),(StartupPanelTarget.getHeight() + getVerticalInsetAdjustment(this.getInsets().top, this.getInsets().bottom)) - 44);
	  }
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = getSize().width;
        int h = getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        setLocation(x, y);   
        try
        {
            setTitle(EncryptedRuleReader.getLocaleString("startWindowTitle"));
        }
        catch(Exception e){}
	try
	{
	  	  applyComponentOrientation(ComponentOrientation.getOrientation(EncryptedRuleReader.getLocale()));
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
		    		return 22 - (25 - sum);
			}
			else if(sum>25)
			{
		     		return 22 + (sum - 25);
			}
		}
		else
		{
			return 22;
		}
	}
	catch(Exception e)
	{
		return 22;
	}
	return 22;
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
    private void initComponents() {//GEN-BEGIN:initComponents
        StartupPanelTarget = new StartupWindowPanelVerticalButtonBar();
	  StartupPanelTarget.setMasterControlComp(this);
        getContentPane().add(StartupPanelTarget, java.awt.BorderLayout.CENTER);
        setModal(true);
	  setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        pack();
    }//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
                         System.exit(0);
    }//GEN-LAST:event_closeDialog    

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//   try
//   {
//	UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//   }
//   catch (Exception e)
//   {
//      	System.out.println("Could not set System Look and Feel.");
//   }
//        new dlgStartupWindowVerticalButtonBar(new javax.swing.JFrame(), true).show();
//    }

    public void paint(Graphics g)
    {
	Graphics2D g2 = (Graphics2D) g;
	g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	super.paint(g);
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private StartupWindowPanelVerticalButtonBar StartupPanelTarget;
    // End of variables declaration//GEN-END:variables
    
}
