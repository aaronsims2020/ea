/*
 * PaymentImagesPanel.java
 *
 * Created on June 13, 2004, 3:24 PM
 */

package com.trinity.ea.design.project.lookandfeel.images;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.common.filechooser.ImageFileFilter;
import com.trinity.ea.design.payments.actions.BuyNowAction;
import com.trinity.ea.design.payments.actions.PaymentFailedUIAction;
import com.trinity.ea.design.payments.actions.PaymentSuccessUIAction;
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
public class PaymentImagesPanel extends EAPanel {
    ImageFileFilter filter = new ImageFileFilter(new String[] {"gif", "jpg", "jpeg", "png"}, "Select an image file");   
    JFileChooser imageFileChooser = new JFileChooser();
    private ImageIcon noColorIcon = new ImageIcon(getClass().getResource("/images/nocolor.png"));
    /** Creates new form ImagesPanel */
    public PaymentImagesPanel() 
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
		// Splash Image Size
            SpinnerNumberModel splashImageSMWidth = (SpinnerNumberModel)spinSplashImagePixelWidth.getModel();
            ProjectManager.putTempNoFileWrite("paymentFormLeftTopImageWidth", String.valueOf(splashImageSMWidth.getNumber().intValue()));            

// File Locations
	try
	{
            if(ProjectManager.get("paymentFormProductLabelImageEnabled")!=null)
            {            
                if(ProjectManager.get("paymentFormProductLabelImageEnabled").equalsIgnoreCase("true")==true)
                {
                    if(tfVerticalButtonBarImage.getText().equalsIgnoreCase("")==false)
                    {
                            ProjectManager.putTempNoFileWrite("paymentFormProductLabel", new File(tfVerticalButtonBarImage.getText()).toURL().toString());
                    }
                }
            }

		if(tfSplashImage.getText().equalsIgnoreCase("")==false)
		{
			ProjectManager.putTempNoFileWrite("paymentFormLeftTopImagePath", new File(tfSplashImage.getText()).toURL().toString());
		}
		else
		{
			ProjectManager.putTempNoFileWrite("paymentFormLeftTopImagePath", "");
		}
		if(tfProgressBarImage.getText().equalsIgnoreCase("")==false)
		{
			ProjectManager.putTempNoFileWrite("paymentFormRightTopImagePath", new File(tfProgressBarImage.getText()).toURL().toString());
		}
		else
		{
			ProjectManager.putTempNoFileWrite("paymentFormRightTopImagePath", "");
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
            if(ProjectManager.get("paymentFormLeftTopImageWidth")!=null)
            {
			if(ProjectManager.get("paymentFormLeftTopImageWidth").equalsIgnoreCase("")==false)
			{
	           		Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentFormLeftTopImageWidth"));
	    		      spinSplashImagePixelWidth.setModel(new SpinnerNumberModel(Integer.valueOf((String)tmpArray[0]),new Integer(1),new Integer(9999),new Integer(1)));
			}
			else
			{
	    		      spinSplashImagePixelWidth.setModel(new SpinnerNumberModel(new Integer(500),new Integer(1),new Integer(9999),new Integer(1)));
			}
            }
		else
		{
	    		spinSplashImagePixelWidth.setModel(new SpinnerNumberModel(new Integer(500),new Integer(1),new Integer(9999),new Integer(1)));
		}  
JComponent editor = spinSplashImagePixelWidth.getEditor();
JSpinner.NumberEditor field = (JSpinner.NumberEditor)editor;
field.getTextField().setEditable(false);

// Image Enabled Components  
		if(ProjectManager.get("paymentFormProductLabelImageEnabled")!=null)
		{
			if(ProjectManager.get("paymentFormProductLabelImageEnabled").equalsIgnoreCase("true")==true)
			{
				VerticalButtonBarImageButtonEnabled1.setSelected(true);
                                try
                                {
                                if(ProjectManager.get("paymentFormProductLabel")!=null)
                                {
                                        if(ProjectManager.get("paymentFormProductLabel").equalsIgnoreCase("")==false)
                                        {
                                                tfVerticalButtonBarImage.setText(new File(new URL(ProjectManager.get("paymentFormProductLabel")).getFile()).getCanonicalPath());
                                                tfVerticalButtonBarImage.setCaretPosition(0);
                                        }
                                        else
                                        {
                                                tfVerticalButtonBarImage.setText("");
                                        }
                                }
                                else
                                {
                                        tfVerticalButtonBarImage.setText("");
                                }
                                }
                                catch(Exception e)
                                {
                                    
                                }
			}
			else
			{
				VerticalButtonBarImageButtonEnabled1.setSelected(false);
			}
		}
		else
		{
			VerticalButtonBarImageButtonEnabled1.setSelected(false);
		}	
// File Locations
	try
	{
 
if(ProjectManager.get("paymentFormLeftTopImagePath")!=null)
{
	if(ProjectManager.get("paymentFormLeftTopImagePath").equalsIgnoreCase("")==false)
	{
            try
            {
		tfSplashImage.setText(new File(new URL(ProjectManager.get("paymentFormLeftTopImagePath")).getFile()).getCanonicalPath());
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
if(ProjectManager.get("paymentFormRightTopImagePath")!=null)
{
	if(ProjectManager.get("paymentFormRightTopImagePath").equalsIgnoreCase("")==false)
	{
            try
            {
		tfProgressBarImage.setText(new File(new URL(ProjectManager.get("paymentFormRightTopImagePath")).getFile()).getCanonicalPath());
            }
            catch(Exception e)
            {
                
            }
                tfProgressBarImage.setCaretPosition(0);
	}
	else
	{
		tfProgressBarImage.setText("");
	}
}
else
{
	tfProgressBarImage.setText("");
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
        UIChoicesBottomPanel5 = new javax.swing.JPanel();
        lFiller43 = new javax.swing.JLabel();
        lOverrideDefaultSplashImageWidth2 = new javax.swing.JLabel();
        spinSplashImagePixelWidth = new javax.swing.JSpinner();
        lFiller57 = new javax.swing.JLabel();
        lFiller49 = new javax.swing.JLabel();
        UIChoicesBottomPanel7 = new javax.swing.JPanel();
        ProjectLookAndFeelImages1 = new javax.swing.JPanel();
        VerticalButtonBarImageDescriptionLabel = new javax.swing.JPanel();
        LeftUIFiller3 = new javax.swing.JLabel();
        ImageDescription1 = new javax.swing.JLabel();
        VerticalButtonBarImageButtonEnabled1 = new javax.swing.JCheckBox();
        ProjectLocationsCenterPanel2 = new javax.swing.JPanel();
        lFiller25 = new javax.swing.JLabel();
        lBuildLocation2 = new javax.swing.JLabel();
        tfVerticalButtonBarImage = new javax.swing.JTextField();
        lFiller30 = new javax.swing.JLabel();
        VerticalButtonBarImageChooseButton = new javax.swing.JButton();
        lFiller31 = new javax.swing.JLabel();
        VerticalButtonBarImageDefaultButton = new javax.swing.JButton();
        lFiller32 = new javax.swing.JLabel();
        lFiller33 = new javax.swing.JLabel();
        UIChoicesBottomPanel9 = new javax.swing.JPanel();
        ProjectLookAndFeelImages2 = new javax.swing.JPanel();
        ImageDescriptionLabel2 = new javax.swing.JPanel();
        LeftUIFiller4 = new javax.swing.JLabel();
        ImageDescription2 = new javax.swing.JLabel();
        ProjectLocationsCenterPanel3 = new javax.swing.JPanel();
        lFiller36 = new javax.swing.JLabel();
        lBuildLocation3 = new javax.swing.JLabel();
        tfProgressBarImage = new javax.swing.JTextField();
        lFiller37 = new javax.swing.JLabel();
        ProgressBarImageChooseButton = new javax.swing.JButton();
        lFiller38 = new javax.swing.JLabel();
        ProgressBarImageDefaultButton = new javax.swing.JButton();
        lFiller39 = new javax.swing.JLabel();
        lFiller40 = new javax.swing.JLabel();
        UIChoicesBottomPanel17 = new javax.swing.JPanel();
        ProjectLookAndFeelImages4 = new javax.swing.JPanel();
        ProjectLocationsCenterPanel5 = new javax.swing.JPanel();
        lFiller75 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rbPaymentPreview = new javax.swing.JRadioButton();
        rbPaymentSuccessPreview = new javax.swing.JRadioButton();
        rbPaymentFailurePreview = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        PreviewButton = new javax.swing.JButton();
        lFiller76 = new javax.swing.JLabel();
        UIChoicesBottomPanel18 = new javax.swing.JPanel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Upper Left Logo Image", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages.setMaximumSize(new java.awt.Dimension(32767, 98));
        ProjectLookAndFeelImages.setMinimumSize(new java.awt.Dimension(10, 98));
        ProjectLookAndFeelImages.setPreferredSize(new java.awt.Dimension(10, 98));
        ImageDescriptionLabel.setLayout(new javax.swing.BoxLayout(ImageDescriptionLabel, javax.swing.BoxLayout.X_AXIS));

        ImageDescriptionLabel.setBackground(new java.awt.Color(140, 160, 210));
        LeftUIFiller2.setMaximumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller2.setMinimumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller2.setPreferredSize(new java.awt.Dimension(10, 10));
        ImageDescriptionLabel.add(LeftUIFiller2);

        ImageDescription.setFont(new java.awt.Font("Arial", 0, 12));
        ImageDescription.setText("The maximum upper left logo image size is 188 pixels wide by 94 pixels high (default 94wx94h):");
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

        UIChoicesBottomPanel5.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel5, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel5.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel5.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel5.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel5.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller43.setBackground(new java.awt.Color(140, 160, 210));
        lFiller43.setText("   ");
        lFiller43.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller43.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller43.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel5.add(lFiller43);

        lOverrideDefaultSplashImageWidth2.setBackground(new java.awt.Color(140, 160, 210));
        lOverrideDefaultSplashImageWidth2.setFont(new java.awt.Font("Arial", 0, 12));
        lOverrideDefaultSplashImageWidth2.setText("Image pixel size  width:");
        lOverrideDefaultSplashImageWidth2.setMaximumSize(new java.awt.Dimension(135, 15));
        lOverrideDefaultSplashImageWidth2.setMinimumSize(new java.awt.Dimension(135, 15));
        lOverrideDefaultSplashImageWidth2.setPreferredSize(new java.awt.Dimension(135, 15));
        UIChoicesBottomPanel5.add(lOverrideDefaultSplashImageWidth2);
        lOverrideDefaultSplashImageWidth2.getAccessibleContext().setAccessibleName("Image size in pixels - Width:");

        spinSplashImagePixelWidth.setMaximumSize(new java.awt.Dimension(45, 20));
        spinSplashImagePixelWidth.setMinimumSize(new java.awt.Dimension(45, 20));
        spinSplashImagePixelWidth.setPreferredSize(new java.awt.Dimension(45, 20));
        UIChoicesBottomPanel5.add(spinSplashImagePixelWidth);

        lFiller57.setBackground(new java.awt.Color(140, 160, 210));
        lFiller57.setText("   ");
        lFiller57.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller57.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller57.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel5.add(lFiller57);

        lFiller49.setBackground(new java.awt.Color(140, 160, 210));
        lFiller49.setText("   ");
        lFiller49.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller49.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller49.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel5.add(lFiller49);

        ProjectLookAndFeelImages.add(UIChoicesBottomPanel5);

        UIChoicesBottomPanel7.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel7, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel7.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel7.setMaximumSize(new java.awt.Dimension(32767, 4));
        UIChoicesBottomPanel7.setMinimumSize(new java.awt.Dimension(5, 4));
        UIChoicesBottomPanel7.setPreferredSize(new java.awt.Dimension(200, 4));
        ProjectLookAndFeelImages.add(UIChoicesBottomPanel7);

        add(ProjectLookAndFeelImages);

        ProjectLookAndFeelImages1.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages1, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages1.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages1.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Product Label Image (Optional - defaults to text if this image is not enabled)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages1.setMaximumSize(new java.awt.Dimension(32767, 78));
        ProjectLookAndFeelImages1.setMinimumSize(new java.awt.Dimension(10, 78));
        ProjectLookAndFeelImages1.setPreferredSize(new java.awt.Dimension(10, 78));
        VerticalButtonBarImageDescriptionLabel.setLayout(new javax.swing.BoxLayout(VerticalButtonBarImageDescriptionLabel, javax.swing.BoxLayout.X_AXIS));

        VerticalButtonBarImageDescriptionLabel.setBackground(new java.awt.Color(140, 160, 210));
        VerticalButtonBarImageDescriptionLabel.setMaximumSize(new java.awt.Dimension(32858, 15));
        VerticalButtonBarImageDescriptionLabel.setMinimumSize(new java.awt.Dimension(487, 15));
        VerticalButtonBarImageDescriptionLabel.setPreferredSize(new java.awt.Dimension(487, 15));
        LeftUIFiller3.setMaximumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller3.setMinimumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller3.setPreferredSize(new java.awt.Dimension(10, 10));
        VerticalButtonBarImageDescriptionLabel.add(LeftUIFiller3);

        ImageDescription1.setFont(new java.awt.Font("Arial", 0, 12));
        ImageDescription1.setText("The maximum size of this image is 360 pixels width by 21 pixels height (default 205wx21h):");
        ImageDescription1.setMaximumSize(new java.awt.Dimension(32767, 15));
        VerticalButtonBarImageDescriptionLabel.add(ImageDescription1);

        VerticalButtonBarImageButtonEnabled1.setBackground(new java.awt.Color(140, 160, 210));
        VerticalButtonBarImageButtonEnabled1.setFont(new java.awt.Font("Arial", 0, 12));
        VerticalButtonBarImageButtonEnabled1.setSelected(true);
        VerticalButtonBarImageButtonEnabled1.setText("Enabled");
        VerticalButtonBarImageButtonEnabled1.setMaximumSize(new java.awt.Dimension(81, 23));
        VerticalButtonBarImageButtonEnabled1.setMinimumSize(new java.awt.Dimension(81, 23));
        VerticalButtonBarImageButtonEnabled1.setPreferredSize(new java.awt.Dimension(81, 23));
        VerticalButtonBarImageButtonEnabled1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerticalButtonBarImageButtonEnabled1ActionPerformed(evt);
            }
        });

        VerticalButtonBarImageDescriptionLabel.add(VerticalButtonBarImageButtonEnabled1);

        ProjectLookAndFeelImages1.add(VerticalButtonBarImageDescriptionLabel);

        ProjectLocationsCenterPanel2.setLayout(new javax.swing.BoxLayout(ProjectLocationsCenterPanel2, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsCenterPanel2.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsCenterPanel2.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectLocationsCenterPanel2.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectLocationsCenterPanel2.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller25.setBackground(new java.awt.Color(140, 160, 210));
        lFiller25.setText("   ");
        lFiller25.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller25.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller25.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel2.add(lFiller25);

        lBuildLocation2.setBackground(new java.awt.Color(140, 160, 210));
        lBuildLocation2.setFont(new java.awt.Font("Arial", 0, 12));
        lBuildLocation2.setText("File:");
        lBuildLocation2.setMaximumSize(new java.awt.Dimension(120, 15));
        lBuildLocation2.setMinimumSize(new java.awt.Dimension(30, 15));
        lBuildLocation2.setPreferredSize(new java.awt.Dimension(50, 15));
        ProjectLocationsCenterPanel2.add(lBuildLocation2);

        tfVerticalButtonBarImage.setBackground(new java.awt.Color(204, 204, 204));
        tfVerticalButtonBarImage.setFont(new java.awt.Font("Arial", 0, 12));
        tfVerticalButtonBarImage.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfVerticalButtonBarImage.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfVerticalButtonBarImage.setMinimumSize(new java.awt.Dimension(300, 20));
        tfVerticalButtonBarImage.setPreferredSize(new java.awt.Dimension(450, 20));
        ProjectLocationsCenterPanel2.add(tfVerticalButtonBarImage);

        lFiller30.setBackground(new java.awt.Color(140, 160, 210));
        lFiller30.setText("   ");
        lFiller30.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller30.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller30.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel2.add(lFiller30);

        VerticalButtonBarImageChooseButton.setFont(new java.awt.Font("Arial", 0, 12));
        VerticalButtonBarImageChooseButton.setText("Choose...");
        VerticalButtonBarImageChooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerticalButtonBarImageChooseButtonActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel2.add(VerticalButtonBarImageChooseButton);

        lFiller31.setBackground(new java.awt.Color(140, 160, 210));
        lFiller31.setText("   ");
        lFiller31.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller31.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller31.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel2.add(lFiller31);

        VerticalButtonBarImageDefaultButton.setFont(new java.awt.Font("Arial", 0, 12));
        VerticalButtonBarImageDefaultButton.setText("Default");
        VerticalButtonBarImageDefaultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerticalButtonBarImageDefaultButtonActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel2.add(VerticalButtonBarImageDefaultButton);

        lFiller32.setBackground(new java.awt.Color(140, 160, 210));
        lFiller32.setText("   ");
        lFiller32.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller32.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller32.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel2.add(lFiller32);

        lFiller33.setBackground(new java.awt.Color(140, 160, 210));
        lFiller33.setText("   ");
        lFiller33.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller33.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller33.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel2.add(lFiller33);

        ProjectLookAndFeelImages1.add(ProjectLocationsCenterPanel2);

        UIChoicesBottomPanel9.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel9, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel9.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel9.setMaximumSize(new java.awt.Dimension(32767, 4));
        UIChoicesBottomPanel9.setMinimumSize(new java.awt.Dimension(5, 4));
        UIChoicesBottomPanel9.setPreferredSize(new java.awt.Dimension(200, 4));
        ProjectLookAndFeelImages1.add(UIChoicesBottomPanel9);

        add(ProjectLookAndFeelImages1);

        ProjectLookAndFeelImages2.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages2, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages2.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages2.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Upper Right SSL Image", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages2.setMaximumSize(new java.awt.Dimension(32767, 78));
        ProjectLookAndFeelImages2.setMinimumSize(new java.awt.Dimension(10, 78));
        ProjectLookAndFeelImages2.setPreferredSize(new java.awt.Dimension(10, 78));
        ProjectLookAndFeelImages2.setRequestFocusEnabled(false);
        ImageDescriptionLabel2.setLayout(new javax.swing.BoxLayout(ImageDescriptionLabel2, javax.swing.BoxLayout.X_AXIS));

        ImageDescriptionLabel2.setBackground(new java.awt.Color(140, 160, 210));
        LeftUIFiller4.setMaximumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller4.setMinimumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller4.setPreferredSize(new java.awt.Dimension(10, 10));
        ImageDescriptionLabel2.add(LeftUIFiller4);

        ImageDescription2.setFont(new java.awt.Font("Arial", 0, 12));
        ImageDescription2.setText("The maximum size of this image is 68 pixels width by 74 pixels height (default 68wx74h):");
        ImageDescription2.setMaximumSize(new java.awt.Dimension(32767, 15));
        ImageDescriptionLabel2.add(ImageDescription2);

        ProjectLookAndFeelImages2.add(ImageDescriptionLabel2);

        ProjectLocationsCenterPanel3.setLayout(new javax.swing.BoxLayout(ProjectLocationsCenterPanel3, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsCenterPanel3.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsCenterPanel3.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectLocationsCenterPanel3.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectLocationsCenterPanel3.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller36.setBackground(new java.awt.Color(140, 160, 210));
        lFiller36.setText("   ");
        lFiller36.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller36.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller36.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel3.add(lFiller36);

        lBuildLocation3.setBackground(new java.awt.Color(140, 160, 210));
        lBuildLocation3.setFont(new java.awt.Font("Arial", 0, 12));
        lBuildLocation3.setText("File:");
        lBuildLocation3.setMaximumSize(new java.awt.Dimension(120, 15));
        lBuildLocation3.setMinimumSize(new java.awt.Dimension(30, 15));
        lBuildLocation3.setPreferredSize(new java.awt.Dimension(50, 15));
        ProjectLocationsCenterPanel3.add(lBuildLocation3);

        tfProgressBarImage.setBackground(new java.awt.Color(204, 204, 204));
        tfProgressBarImage.setFont(new java.awt.Font("Arial", 0, 12));
        tfProgressBarImage.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfProgressBarImage.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfProgressBarImage.setMinimumSize(new java.awt.Dimension(300, 20));
        tfProgressBarImage.setPreferredSize(new java.awt.Dimension(450, 20));
        ProjectLocationsCenterPanel3.add(tfProgressBarImage);

        lFiller37.setBackground(new java.awt.Color(140, 160, 210));
        lFiller37.setText("   ");
        lFiller37.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller37.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller37.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel3.add(lFiller37);

        ProgressBarImageChooseButton.setFont(new java.awt.Font("Arial", 0, 12));
        ProgressBarImageChooseButton.setText("Choose...");
        ProgressBarImageChooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProgressBarImageChooseButtonActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel3.add(ProgressBarImageChooseButton);

        lFiller38.setBackground(new java.awt.Color(140, 160, 210));
        lFiller38.setText("   ");
        lFiller38.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller38.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller38.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel3.add(lFiller38);

        ProgressBarImageDefaultButton.setFont(new java.awt.Font("Arial", 0, 12));
        ProgressBarImageDefaultButton.setText("Default");
        ProgressBarImageDefaultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProgressBarImageDefaultButtonActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel3.add(ProgressBarImageDefaultButton);

        lFiller39.setBackground(new java.awt.Color(140, 160, 210));
        lFiller39.setText("   ");
        lFiller39.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller39.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller39.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel3.add(lFiller39);

        lFiller40.setBackground(new java.awt.Color(140, 160, 210));
        lFiller40.setText("   ");
        lFiller40.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller40.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller40.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel3.add(lFiller40);

        ProjectLookAndFeelImages2.add(ProjectLocationsCenterPanel3);

        UIChoicesBottomPanel17.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel17, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel17.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel17.setMaximumSize(new java.awt.Dimension(32767, 4));
        UIChoicesBottomPanel17.setMinimumSize(new java.awt.Dimension(5, 4));
        UIChoicesBottomPanel17.setPreferredSize(new java.awt.Dimension(200, 4));
        ProjectLookAndFeelImages2.add(UIChoicesBottomPanel17);

        add(ProjectLookAndFeelImages2);

        ProjectLookAndFeelImages4.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages4, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages4.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages4.setMaximumSize(new java.awt.Dimension(32767, 90));
        ProjectLookAndFeelImages4.setMinimumSize(new java.awt.Dimension(10, 90));
        ProjectLookAndFeelImages4.setPreferredSize(new java.awt.Dimension(10, 90));
        ProjectLocationsCenterPanel5.setLayout(new javax.swing.BoxLayout(ProjectLocationsCenterPanel5, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsCenterPanel5.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsCenterPanel5.setMaximumSize(new java.awt.Dimension(2147483647, 69));
        ProjectLocationsCenterPanel5.setMinimumSize(new java.awt.Dimension(600, 69));
        ProjectLocationsCenterPanel5.setPreferredSize(new java.awt.Dimension(800, 69));
        lFiller75.setBackground(new java.awt.Color(140, 160, 210));
        lFiller75.setText("   ");
        lFiller75.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller75.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller75.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel5.add(lFiller75);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.X_AXIS));

        jPanel1.setBackground(new java.awt.Color(140, 160, 210));
        jPanel1.setMaximumSize(new java.awt.Dimension(255, 69));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setBackground(new java.awt.Color(140, 160, 210));
        rbPaymentPreview.setBackground(new java.awt.Color(140, 160, 210));
        rbPaymentPreview.setFont(new java.awt.Font("Arial", 0, 12));
        rbPaymentPreview.setSelected(true);
        rbPaymentPreview.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rbPaymentPreview.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        rbPaymentPreview.setLabel("Payment Form");
        rbPaymentPreview.setMaximumSize(new java.awt.Dimension(168, 23));
        rbPaymentPreview.setMinimumSize(new java.awt.Dimension(168, 23));
        rbPaymentPreview.setPreferredSize(new java.awt.Dimension(168, 23));
        rbPaymentPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPaymentPreviewActionPerformed(evt);
            }
        });

        jPanel2.add(rbPaymentPreview);

        rbPaymentSuccessPreview.setBackground(new java.awt.Color(140, 160, 210));
        rbPaymentSuccessPreview.setFont(new java.awt.Font("Arial", 0, 12));
        rbPaymentSuccessPreview.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rbPaymentSuccessPreview.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        rbPaymentSuccessPreview.setLabel("Payment Success Form");
        rbPaymentSuccessPreview.setMaximumSize(new java.awt.Dimension(168, 23));
        rbPaymentSuccessPreview.setMinimumSize(new java.awt.Dimension(168, 23));
        rbPaymentSuccessPreview.setPreferredSize(new java.awt.Dimension(168, 23));
        rbPaymentSuccessPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPaymentSuccessPreviewActionPerformed(evt);
            }
        });

        jPanel2.add(rbPaymentSuccessPreview);

        rbPaymentFailurePreview.setBackground(new java.awt.Color(140, 160, 210));
        rbPaymentFailurePreview.setFont(new java.awt.Font("Arial", 0, 12));
        rbPaymentFailurePreview.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rbPaymentFailurePreview.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        rbPaymentFailurePreview.setLabel("Payment Failure Form");
        rbPaymentFailurePreview.setMaximumSize(new java.awt.Dimension(168, 23));
        rbPaymentFailurePreview.setMinimumSize(new java.awt.Dimension(168, 23));
        rbPaymentFailurePreview.setPreferredSize(new java.awt.Dimension(168, 23));
        rbPaymentFailurePreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPaymentFailurePreviewActionPerformed(evt);
            }
        });

        jPanel2.add(rbPaymentFailurePreview);

        jPanel1.add(jPanel2);

        jPanel4.setBackground(new java.awt.Color(140, 160, 210));
        jPanel1.add(jPanel4);

        jPanel3.setBackground(new java.awt.Color(140, 160, 210));
        jPanel3.setMaximumSize(new java.awt.Dimension(77, 69));
        jPanel3.setMinimumSize(new java.awt.Dimension(77, 69));
        jPanel3.setPreferredSize(new java.awt.Dimension(77, 69));
        PreviewButton.setFont(new java.awt.Font("Arial", 0, 12));
        PreviewButton.setLabel("Preview");
        PreviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviewButtonActionPerformed(evt);
            }
        });

        jPanel3.add(PreviewButton);

        jPanel1.add(jPanel3);

        ProjectLocationsCenterPanel5.add(jPanel1);

        lFiller76.setBackground(new java.awt.Color(140, 160, 210));
        lFiller76.setText("   ");
        lFiller76.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller76.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller76.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel5.add(lFiller76);

        ProjectLookAndFeelImages4.add(ProjectLocationsCenterPanel5);

        UIChoicesBottomPanel18.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel18.setMinimumSize(new java.awt.Dimension(5, 5));
        UIChoicesBottomPanel18.setPreferredSize(new java.awt.Dimension(5, 5));
        ProjectLookAndFeelImages4.add(UIChoicesBottomPanel18);

        add(ProjectLookAndFeelImages4);

    }//GEN-END:initComponents

    private void rbPaymentFailurePreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPaymentFailurePreviewActionPerformed
        if(rbPaymentFailurePreview.isSelected()==true)
        {
           rbPaymentPreview.setSelected(false);
           rbPaymentFailurePreview.setSelected(true);
           rbPaymentSuccessPreview.setSelected(false);
        } 
    }//GEN-LAST:event_rbPaymentFailurePreviewActionPerformed

    private void rbPaymentSuccessPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPaymentSuccessPreviewActionPerformed
        if(rbPaymentSuccessPreview.isSelected()==true)
        {
           rbPaymentPreview.setSelected(false);
           rbPaymentFailurePreview.setSelected(false);
           rbPaymentSuccessPreview.setSelected(true);
        } 
    }//GEN-LAST:event_rbPaymentSuccessPreviewActionPerformed

    private void rbPaymentPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPaymentPreviewActionPerformed
        if(rbPaymentPreview.isSelected()==true)
        {
           rbPaymentPreview.setSelected(true);
           rbPaymentFailurePreview.setSelected(false);
           rbPaymentSuccessPreview.setSelected(false);
        } 
    }//GEN-LAST:event_rbPaymentPreviewActionPerformed

    private void progressPanelImgStretchToFitEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progressPanelImgStretchToFitEnabledActionPerformed

    }//GEN-LAST:event_progressPanelImgStretchToFitEnabledActionPerformed

    private void btnBarImageStretchToFitEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarImageStretchToFitEnabledActionPerformed
//TODO Code goes here.
    }//GEN-LAST:event_btnBarImageStretchToFitEnabledActionPerformed

    private void btnBarImageAlignToTopEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarImageAlignToTopEnabledActionPerformed
//TODO Code goes here.
    }//GEN-LAST:event_btnBarImageAlignToTopEnabledActionPerformed

    private void ProgressBarImageDefaultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProgressBarImageDefaultButtonActionPerformed
		try
		{
             	ProjectManager.put("paymentFormRightTopImagePath", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/images/ssl.png").toString());
			tfProgressBarImage.setText(new File(new URL(ProjectManager.get("paymentFormRightTopImagePath")).getFile()).getCanonicalPath());
			tfProgressBarImage.setCaretPosition(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }//GEN-LAST:event_ProgressBarImageDefaultButtonActionPerformed

    private void ProgressBarImageChooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProgressBarImageChooseButtonActionPerformed
	try
	{
		int result = imageFileChooser.showOpenDialog(this); 
        	if(result == JFileChooser.APPROVE_OPTION) 
        	{ 
             	ProjectManager.put("paymentFormRightTopImagePath", imageFileChooser.getSelectedFile().toURL().toString());
			tfProgressBarImage.setText(new File(new URL(ProjectManager.get("paymentFormRightTopImagePath")).getFile()).getCanonicalPath());
			tfProgressBarImage.setCaretPosition(0);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_ProgressBarImageChooseButtonActionPerformed

    private void VerticalButtonBarImageButtonEnabled1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerticalButtonBarImageButtonEnabled1ActionPerformed
//TODO: Disable all GUI components on Image disabled.
        try
        {
            if(VerticalButtonBarImageButtonEnabled1.isSelected()==true)
            {
                ProjectManager.put("paymentFormProductLabelImageEnabled", "true");
                   
            }
            else
            { 
                ProjectManager.put("paymentFormProductLabelImageEnabled", "false");
                ProjectManager.put("paymentFormProductLabel", "PRODUCT_NAME");                
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_VerticalButtonBarImageButtonEnabled1ActionPerformed

    private void VerticalButtonBarImageDefaultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerticalButtonBarImageDefaultButtonActionPerformed
		try
		{
             	ProjectManager.put("paymentFormProductLabel", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/images/eatm.png").toString());
			tfVerticalButtonBarImage.setText(new File(new URL(ProjectManager.get("paymentFormProductLabel")).getFile()).getCanonicalPath());
			tfVerticalButtonBarImage.setCaretPosition(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }//GEN-LAST:event_VerticalButtonBarImageDefaultButtonActionPerformed

    private void PreviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviewButtonActionPerformed
        try
        {
            if(rbPaymentPreview.isSelected()==true)
            {
			EAPanel thePanel = (EAPanel)getParentComponent();
                ((EAPanel)thePanel.getParentComponent()).getDataUpdate(); 
                new BuyNowAction();	
            }
            else if(rbPaymentFailurePreview.isSelected()==true)
            {
			EAPanel thePanel = (EAPanel)getParentComponent();
                ((EAPanel)thePanel.getParentComponent()).getDataUpdate();            
                new PaymentFailedUIAction();
            }
            else if(rbPaymentSuccessPreview.isSelected()==true)
            {
			EAPanel thePanel = (EAPanel)getParentComponent();
                ((EAPanel)thePanel.getParentComponent()).getDataUpdate(); 
                new PaymentSuccessUIAction();            
            } 
        }
        catch(Exception e)
        {
                e.printStackTrace();
        }
    }//GEN-LAST:event_PreviewButtonActionPerformed

    private void VerticalButtonBarImageChooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerticalButtonBarImageChooseButtonActionPerformed
	try
	{
		int result = imageFileChooser.showOpenDialog(this); 
        	if(result == JFileChooser.APPROVE_OPTION) 
        	{ 
             	ProjectManager.put("paymentFormProductLabel", imageFileChooser.getSelectedFile().toURL().toString());
			tfVerticalButtonBarImage.setText(new File(new URL(ProjectManager.get("paymentFormProductLabel")).getFile()).getCanonicalPath());
			tfVerticalButtonBarImage.setCaretPosition(0);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_VerticalButtonBarImageChooseButtonActionPerformed

    private void SplashImageDefaultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SplashImageDefaultButtonActionPerformed
		try
		{
             	ProjectManager.put("paymentFormLeftTopImagePath", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/images/logomed.png").toString());
			tfSplashImage.setText(new File(new URL(ProjectManager.get("paymentFormLeftTopImagePath")).getFile()).getCanonicalPath());
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
             	ProjectManager.put("paymentFormLeftTopImagePath", imageFileChooser.getSelectedFile().toURL().toString());
			tfSplashImage.setText(new File(new URL(ProjectManager.get("paymentFormLeftTopImagePath")).getFile()).getCanonicalPath());
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
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImageDescription;
    private javax.swing.JLabel ImageDescription1;
    private javax.swing.JLabel ImageDescription2;
    private javax.swing.JPanel ImageDescriptionLabel;
    private javax.swing.JPanel ImageDescriptionLabel2;
    private javax.swing.JLabel LeftUIFiller2;
    private javax.swing.JLabel LeftUIFiller3;
    private javax.swing.JLabel LeftUIFiller4;
    private javax.swing.JButton PreviewButton;
    private javax.swing.JButton ProgressBarImageChooseButton;
    private javax.swing.JButton ProgressBarImageDefaultButton;
    private javax.swing.JPanel ProjectLocationsCenterPanel1;
    private javax.swing.JPanel ProjectLocationsCenterPanel2;
    private javax.swing.JPanel ProjectLocationsCenterPanel3;
    private javax.swing.JPanel ProjectLocationsCenterPanel5;
    private javax.swing.JPanel ProjectLookAndFeelImages;
    private javax.swing.JPanel ProjectLookAndFeelImages1;
    private javax.swing.JPanel ProjectLookAndFeelImages2;
    private javax.swing.JPanel ProjectLookAndFeelImages4;
    private javax.swing.JButton SplashImageChooseButton;
    private javax.swing.JButton SplashImageDefaultButton;
    private javax.swing.JPanel UIChoicesBottomPanel17;
    private javax.swing.JPanel UIChoicesBottomPanel18;
    private javax.swing.JPanel UIChoicesBottomPanel5;
    private javax.swing.JPanel UIChoicesBottomPanel7;
    private javax.swing.JPanel UIChoicesBottomPanel9;
    private javax.swing.JCheckBox VerticalButtonBarImageButtonEnabled1;
    private javax.swing.JButton VerticalButtonBarImageChooseButton;
    private javax.swing.JButton VerticalButtonBarImageDefaultButton;
    private javax.swing.JPanel VerticalButtonBarImageDescriptionLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lBuildLocation1;
    private javax.swing.JLabel lBuildLocation2;
    private javax.swing.JLabel lBuildLocation3;
    private javax.swing.JLabel lFiller24;
    private javax.swing.JLabel lFiller25;
    private javax.swing.JLabel lFiller26;
    private javax.swing.JLabel lFiller27;
    private javax.swing.JLabel lFiller28;
    private javax.swing.JLabel lFiller29;
    private javax.swing.JLabel lFiller30;
    private javax.swing.JLabel lFiller31;
    private javax.swing.JLabel lFiller32;
    private javax.swing.JLabel lFiller33;
    private javax.swing.JLabel lFiller36;
    private javax.swing.JLabel lFiller37;
    private javax.swing.JLabel lFiller38;
    private javax.swing.JLabel lFiller39;
    private javax.swing.JLabel lFiller40;
    private javax.swing.JLabel lFiller43;
    private javax.swing.JLabel lFiller49;
    private javax.swing.JLabel lFiller57;
    private javax.swing.JLabel lFiller75;
    private javax.swing.JLabel lFiller76;
    private javax.swing.JLabel lOverrideDefaultSplashImageWidth2;
    private javax.swing.JRadioButton rbPaymentFailurePreview;
    private javax.swing.JRadioButton rbPaymentPreview;
    private javax.swing.JRadioButton rbPaymentSuccessPreview;
    private javax.swing.JSpinner spinSplashImagePixelWidth;
    private javax.swing.JTextField tfProgressBarImage;
    private javax.swing.JTextField tfSplashImage;
    private javax.swing.JTextField tfVerticalButtonBarImage;
    // End of variables declaration//GEN-END:variables
    
}
