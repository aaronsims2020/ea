/*
 * dlgStartupWindowVerticalButtonBar.java
 *
 * Created on June 4, 2004, 12:44 AM
 */

package com.trinity.ea.design.project.lookandfeel.preview.startupui.swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.metal.*;
import com.trinity.ea.design.common.file.ProjectManager;
import java.util.ArrayList;
import com.trinity.ea.design.project.lookandfeel.preview.startupui.swing.StartupWindowPanelVerticalButtonBar;

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

	  if(ProjectManager.get("isProgressBarEnabled").equalsIgnoreCase("true")==true)
	  {
	  	if(ProjectManager.get("project_expiration_support_is_enabled").equalsIgnoreCase("true")==true)
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
		updateUIExpressionDefines();
            setTitle(replaceUIExpressions(ProjectManager.get("startWindowTitle")));
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

    private void closeDialog(java.awt.event.WindowEvent evt) 
    {
	try
	{
		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

    private static synchronized Object[] getStringArraysFromString(String textArrayString)
    {
        ArrayList aryList = new ArrayList();
        String tempString = "";
        try
        {
            while(textArrayString.indexOf(",")!=-1)
            {
                tempString = textArrayString.substring(0,textArrayString.indexOf(","));
                textArrayString = textArrayString.substring(textArrayString.indexOf(",") + 1);
                aryList.add(tempString);
            }
            aryList.add(textArrayString);
            aryList.trimToSize();
        }
        catch(NullPointerException e)
        {
         
        }

        return aryList.toArray();
    }  

    public void setComponentOrientation(ComponentOrientation theOrientation)
    {
        this.setComponentOrientation(theOrientation);
	  StartupPanelTarget.setComponentOrientation(theOrientation);
    }     
  
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
