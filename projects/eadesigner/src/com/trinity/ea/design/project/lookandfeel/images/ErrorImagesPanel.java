/*
 * ErrorImagesPanel.java
 *
 * Created on June 13, 2004, 3:24 PM
 */

package com.trinity.ea.design.project.lookandfeel.images;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.common.filechooser.ImageFileFilter;
import com.trinity.ea.design.common.preview.actions.ErrorPreviewAction;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import java.awt.*;
import javax.swing.*; 

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class ErrorImagesPanel extends EAPanel {
    ImageFileFilter filter = new ImageFileFilter(new String[] {"gif", "jpg", "jpeg", "png"}, "Select an image file");   
    JFileChooser imageFileChooser = new JFileChooser();
    private ImageIcon noColorIcon = new ImageIcon(getClass().getResource("/images/nocolor.png"));
    /** Creates new form ImagesPanel */
    public ErrorImagesPanel() 
    {
        initComponents();
	  imageFileChooser.addChoosableFileFilter(filter);
	  imageFileChooser.setFileFilter(filter);
        setProjectData();
    }

    public synchronized void getDataUpdate()
    {
    try
    {
        // File Locations
	try
	{
		if(tfSplashImage.getText().equalsIgnoreCase("")==false)
		{
			ProjectManager.putTempNoFileWrite("errHeaderImgPath", new File(tfSplashImage.getText()).toURL().toString());
		}
		else
		{
			ProjectManager.putTempNoFileWrite("errHeaderImgPath", "");
		}
	}
	catch(Exception ee)
	{
		ee.printStackTrace();
	}
// End File Locations

            ProjectManager.saveTempNow(); 
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
 
    public synchronized void setProjectData()
    {
        try
        {
// File Locations
	try
	{
            if(ProjectManager.get("errHeaderImgPath")!=null)
            {
                    if(ProjectManager.get("errHeaderImgPath").equalsIgnoreCase("")==false)
                    {
                        try
                        {
                            tfSplashImage.setText(new File(new URL(ProjectManager.get("errHeaderImgPath")).getFile()).getCanonicalPath());
                        }
                        catch(Exception e)
                        {
                            
                        }
                            tfSplashImage.setCaretPosition(0);
                    }
                    else
                    {
                            tfSplashImage.setText("");
                    }
            }
            else
            {
                    tfSplashImage.setText("");
            }
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
// End File Locations


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
        ProjectLookAndFeelImages = new javax.swing.JPanel();
        ImageDescriptionLabel = new javax.swing.JPanel();
        LeftUIFiller2 = new javax.swing.JLabel();
        ImageDescription = new javax.swing.JLabel();
        ProjectLocationsCenterPanel1 = new javax.swing.JPanel();
        lFiller24 = new javax.swing.JLabel();
        lBuildLocation1 = new javax.swing.JLabel();
        tfSplashImage = new javax.swing.JTextField();
        lFiller27 = new javax.swing.JLabel();
        SplashImageChooseButton = new javax.swing.JButton();
        lFiller28 = new javax.swing.JLabel();
        SplashImageDefaultButton = new javax.swing.JButton();
        lFiller29 = new javax.swing.JLabel();
        lFiller26 = new javax.swing.JLabel();
        UIChoicesBottomPanel7 = new javax.swing.JPanel();
        ProjectLookAndFeelImages3 = new javax.swing.JPanel();
        ImageDescriptionLabel3 = new javax.swing.JPanel();
        LeftUIFiller5 = new javax.swing.JLabel();
        ProjectLocationsCenterPanel4 = new javax.swing.JPanel();
        lFiller48 = new javax.swing.JLabel();
        PreviewButton = new javax.swing.JButton();
        lFiller45 = new javax.swing.JLabel();
        lFiller47 = new javax.swing.JLabel();
        UIChoicesBottomPanel4 = new javax.swing.JPanel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Error Dialog Header Image", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages.setMaximumSize(new java.awt.Dimension(32767, 78));
        ProjectLookAndFeelImages.setMinimumSize(new java.awt.Dimension(10, 78));
        ProjectLookAndFeelImages.setPreferredSize(new java.awt.Dimension(10, 78));
        ImageDescriptionLabel.setLayout(new javax.swing.BoxLayout(ImageDescriptionLabel, javax.swing.BoxLayout.X_AXIS));

        ImageDescriptionLabel.setBackground(new java.awt.Color(140, 160, 210));
        LeftUIFiller2.setMaximumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller2.setMinimumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller2.setPreferredSize(new java.awt.Dimension(10, 10));
        ImageDescriptionLabel.add(LeftUIFiller2);

        ImageDescription.setFont(new java.awt.Font("Arial", 0, 12));
        ImageDescription.setText("The maximum error dialog header image size is 330 pixels wide by 30 pixels high (default 205wx21h).");
        ImageDescription.setMaximumSize(new java.awt.Dimension(32767, 15));
        ImageDescriptionLabel.add(ImageDescription);

        ProjectLookAndFeelImages.add(ImageDescriptionLabel);

        ProjectLocationsCenterPanel1.setLayout(new javax.swing.BoxLayout(ProjectLocationsCenterPanel1, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsCenterPanel1.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsCenterPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectLocationsCenterPanel1.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectLocationsCenterPanel1.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller24.setBackground(new java.awt.Color(140, 160, 210));
        lFiller24.setText("   ");
        lFiller24.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller24.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller24.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel1.add(lFiller24);

        lBuildLocation1.setBackground(new java.awt.Color(140, 160, 210));
        lBuildLocation1.setFont(new java.awt.Font("Arial", 0, 12));
        lBuildLocation1.setText("File:");
        lBuildLocation1.setMaximumSize(new java.awt.Dimension(120, 15));
        lBuildLocation1.setMinimumSize(new java.awt.Dimension(30, 15));
        lBuildLocation1.setPreferredSize(new java.awt.Dimension(50, 15));
        ProjectLocationsCenterPanel1.add(lBuildLocation1);

        tfSplashImage.setBackground(new java.awt.Color(204, 204, 204));
        tfSplashImage.setFont(new java.awt.Font("Arial", 0, 12));
        tfSplashImage.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfSplashImage.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfSplashImage.setMinimumSize(new java.awt.Dimension(300, 20));
        tfSplashImage.setPreferredSize(new java.awt.Dimension(450, 20));
        ProjectLocationsCenterPanel1.add(tfSplashImage);

        lFiller27.setBackground(new java.awt.Color(140, 160, 210));
        lFiller27.setText("   ");
        lFiller27.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller27.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller27.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel1.add(lFiller27);

        SplashImageChooseButton.setFont(new java.awt.Font("Arial", 0, 12));
        SplashImageChooseButton.setText("Choose...");
        SplashImageChooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SplashImageChooseButtonActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel1.add(SplashImageChooseButton);

        lFiller28.setBackground(new java.awt.Color(140, 160, 210));
        lFiller28.setText("   ");
        lFiller28.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller28.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller28.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel1.add(lFiller28);

        SplashImageDefaultButton.setFont(new java.awt.Font("Arial", 0, 12));
        SplashImageDefaultButton.setText("Default");
        SplashImageDefaultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SplashImageDefaultButtonActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel1.add(SplashImageDefaultButton);

        lFiller29.setBackground(new java.awt.Color(140, 160, 210));
        lFiller29.setText("   ");
        lFiller29.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller29.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller29.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel1.add(lFiller29);

        lFiller26.setBackground(new java.awt.Color(140, 160, 210));
        lFiller26.setText("   ");
        lFiller26.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller26.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller26.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel1.add(lFiller26);

        ProjectLookAndFeelImages.add(ProjectLocationsCenterPanel1);

        UIChoicesBottomPanel7.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel7, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel7.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel7.setMaximumSize(new java.awt.Dimension(32767, 4));
        UIChoicesBottomPanel7.setMinimumSize(new java.awt.Dimension(5, 4));
        UIChoicesBottomPanel7.setPreferredSize(new java.awt.Dimension(200, 4));
        ProjectLookAndFeelImages.add(UIChoicesBottomPanel7);

        add(ProjectLookAndFeelImages);

        ProjectLookAndFeelImages3.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages3, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages3.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages3.setMaximumSize(new java.awt.Dimension(32767, 75));
        ProjectLookAndFeelImages3.setMinimumSize(new java.awt.Dimension(10, 50));
        ProjectLookAndFeelImages3.setPreferredSize(new java.awt.Dimension(10, 60));
        ImageDescriptionLabel3.setLayout(new javax.swing.BoxLayout(ImageDescriptionLabel3, javax.swing.BoxLayout.X_AXIS));

        ImageDescriptionLabel3.setBackground(new java.awt.Color(140, 160, 210));
        LeftUIFiller5.setMaximumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller5.setMinimumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller5.setPreferredSize(new java.awt.Dimension(10, 10));
        ImageDescriptionLabel3.add(LeftUIFiller5);

        ProjectLookAndFeelImages3.add(ImageDescriptionLabel3);

        ProjectLocationsCenterPanel4.setLayout(new javax.swing.BoxLayout(ProjectLocationsCenterPanel4, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsCenterPanel4.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsCenterPanel4.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectLocationsCenterPanel4.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectLocationsCenterPanel4.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller48.setBackground(new java.awt.Color(140, 160, 210));
        lFiller48.setText("   ");
        lFiller48.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller48.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller48.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel4.add(lFiller48);

        PreviewButton.setFont(new java.awt.Font("Arial", 0, 12));
        PreviewButton.setLabel("Preview");
        PreviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviewButtonActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel4.add(PreviewButton);

        lFiller45.setBackground(new java.awt.Color(140, 160, 210));
        lFiller45.setText("   ");
        lFiller45.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller45.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller45.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel4.add(lFiller45);

        lFiller47.setBackground(new java.awt.Color(140, 160, 210));
        lFiller47.setText("   ");
        lFiller47.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller47.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller47.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel4.add(lFiller47);

        ProjectLookAndFeelImages3.add(ProjectLocationsCenterPanel4);

        UIChoicesBottomPanel4.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel4.setMinimumSize(new java.awt.Dimension(5, 5));
        UIChoicesBottomPanel4.setPreferredSize(new java.awt.Dimension(5, 5));
        ProjectLookAndFeelImages3.add(UIChoicesBottomPanel4);

        add(ProjectLookAndFeelImages3);

    }//GEN-END:initComponents

    private void progressPanelImgStretchToFitEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progressPanelImgStretchToFitEnabledActionPerformed

    }//GEN-LAST:event_progressPanelImgStretchToFitEnabledActionPerformed

    private void btnBarImageStretchToFitEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarImageStretchToFitEnabledActionPerformed
//TODO Code goes here.
    }//GEN-LAST:event_btnBarImageStretchToFitEnabledActionPerformed

    private void btnBarImageAlignToTopEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarImageAlignToTopEnabledActionPerformed
//TODO Code goes here.
    }//GEN-LAST:event_btnBarImageAlignToTopEnabledActionPerformed

    private void PreviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviewButtonActionPerformed
        try
        {
			EAPanel thePanel = (EAPanel)getParentComponent();
                ((EAPanel)thePanel.getParentComponent()).getDataUpdate(); 
                new ErrorPreviewAction();	
        }
        catch(Exception e)
        {
                e.printStackTrace();
        }
    }//GEN-LAST:event_PreviewButtonActionPerformed

    private void SplashImageDefaultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SplashImageDefaultButtonActionPerformed
		try
		{
             	ProjectManager.put("errHeaderImgPath", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/images/eatm.png").toString());
			tfSplashImage.setText(new File(new URL(ProjectManager.get("errHeaderImgPath")).getFile()).getCanonicalPath());
			tfSplashImage.setCaretPosition(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }//GEN-LAST:event_SplashImageDefaultButtonActionPerformed

    private void SplashImageChooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SplashImageChooseButtonActionPerformed
	try
	{
		int result = imageFileChooser.showOpenDialog(this); 
        	if(result == JFileChooser.APPROVE_OPTION) 
        	{ 
             	ProjectManager.put("errHeaderImgPath", imageFileChooser.getSelectedFile().toURL().toString());
			tfSplashImage.setText(new File(new URL(ProjectManager.get("errHeaderImgPath")).getFile()).getCanonicalPath());
			tfSplashImage.setCaretPosition(0);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_SplashImageChooseButtonActionPerformed
 
    
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
     
     class ColorSwatch implements Icon 
     { 
        Color bez;
 	public ColorSwatch(Color theColor) 
        { 
 	    bez = theColor;
 	} 
  
 	public int getIconWidth() 
        { 
 	    return 11; 
 	}  
  
 	public int getIconHeight() 
        { 
 	    return 11; 
 	}  
  
 	public void paintIcon(Component c, Graphics g, int x, int y)
        { 
 	    g.setColor(Color.black); 
 	    g.fillRect(x, y, getIconWidth(), getIconHeight()); 
   	    g.setColor(bez); 
 	    g.fillRect(x+1, y+1, getIconWidth()-2, getIconHeight()-2); 
 	} 
     }      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImageDescription;
    private javax.swing.JPanel ImageDescriptionLabel;
    private javax.swing.JPanel ImageDescriptionLabel3;
    private javax.swing.JLabel LeftUIFiller2;
    private javax.swing.JLabel LeftUIFiller5;
    private javax.swing.JButton PreviewButton;
    private javax.swing.JPanel ProjectLocationsCenterPanel1;
    private javax.swing.JPanel ProjectLocationsCenterPanel4;
    private javax.swing.JPanel ProjectLookAndFeelImages;
    private javax.swing.JPanel ProjectLookAndFeelImages3;
    private javax.swing.JButton SplashImageChooseButton;
    private javax.swing.JButton SplashImageDefaultButton;
    private javax.swing.JPanel UIChoicesBottomPanel4;
    private javax.swing.JPanel UIChoicesBottomPanel7;
    private javax.swing.JLabel lBuildLocation1;
    private javax.swing.JLabel lFiller24;
    private javax.swing.JLabel lFiller26;
    private javax.swing.JLabel lFiller27;
    private javax.swing.JLabel lFiller28;
    private javax.swing.JLabel lFiller29;
    private javax.swing.JLabel lFiller45;
    private javax.swing.JLabel lFiller47;
    private javax.swing.JLabel lFiller48;
    private javax.swing.JTextField tfSplashImage;
    // End of variables declaration//GEN-END:variables
    
}
