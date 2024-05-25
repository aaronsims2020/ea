/*
 * ImagesPanel.java
 *
 * Created on June 13, 2004, 3:24 PM
 */

package com.trinity.ea.design.project.lookandfeel.images;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.common.filechooser.ImageFileFilter;
import com.trinity.ea.design.project.lookandfeel.preview.actions.StartVerticalButtonBarThemeAction;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import java.awt.*;
import javax.swing.*; 
import com.trinity.ea.design.common.colorchooser.JLocalColorChooser;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class ImagesPanel extends EAPanel {
    ImageFileFilter filter = new ImageFileFilter(new String[] {"gif", "jpg", "jpeg", "png"}, "Select an image file");   
    JFileChooser imageFileChooser = new JFileChooser();
    private ImageIcon noColorIcon = new ImageIcon(getClass().getResource("/images/nocolor.png"));
    /** Creates new form ImagesPanel */
    public ImagesPanel() 
    {
        initComponents();
        updateSplashButtonColorSwatch();
        updateVerticalButtonBarImageButtonColorSwatch();
        updateProgressBarImageButtonColorSwatch();
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
            SpinnerNumberModel splashImageSMHeight = (SpinnerNumberModel)spinSplashImagePixelHeight.getModel();
            ProjectManager.putTempNoFileWrite("splashImageSize", String.valueOf(splashImageSMWidth.getNumber().intValue()) + "," + String.valueOf(splashImageSMHeight.getNumber().intValue()));            
		// Stretch to fit ImageSize
		if(btnBarImageStretchToFitEnabled.isSelected()==true)
		{
            	ProjectManager.putTempNoFileWrite("btnBarImgStretchToFitEnabled", "true"); 
		}
		else
		{
            	ProjectManager.putTempNoFileWrite("btnBarImgStretchToFitEnabled", "false"); 
		}
		// Align Button Bar Image to Top
		if(btnBarImageAlignToTopEnabled.isSelected()==true)
		{
            	ProjectManager.putTempNoFileWrite("btnBarImgAlignTopEnabled", "true"); 
		}
		else
		{
            	ProjectManager.putTempNoFileWrite("btnBarImgAlignTopEnabled", "false"); 
		}

		if(progressPanelImgStretchToFitEnabled.isSelected()==true)
		{
            	ProjectManager.putTempNoFileWrite("progressPanelImgStretchToFitEnabled", "true"); 
		}
		else
		{
            	ProjectManager.putTempNoFileWrite("progressPanelImgStretchToFitEnabled", "false"); 
		}

		if(cbActionType.getSelectedIndex()==0)
		{
			ProjectManager.putTempNoFileWrite("btnBarImgActionType", "-1"); 
		}
		else if(cbActionType.getSelectedIndex()==1)
		{
			ProjectManager.putTempNoFileWrite("btnBarImgActionType", "0"); 
		}	
		else if(cbActionType.getSelectedIndex()==2)
		{
			ProjectManager.putTempNoFileWrite("btnBarImgActionType", "1"); 
		}	
		ProjectManager.putTempNoFileWrite("btnBarImgAction", tfVerticalButtonBarImage1.getText()); 
		if(cbProgressBarImageActionType.getSelectedIndex()==0)
		{
			ProjectManager.putTempNoFileWrite("progressPanelImgActionType", "-1"); 
		}
		else if(cbProgressBarImageActionType.getSelectedIndex()==1)
		{
			ProjectManager.putTempNoFileWrite("progressPanelImgActionType", "0"); 
		}	
		else if(cbProgressBarImageActionType.getSelectedIndex()==2)
		{
			ProjectManager.putTempNoFileWrite("progressPanelImgActionType", "1"); 
		}	
		ProjectManager.putTempNoFileWrite("progressPanelImgAction", tfProgressBarImageAction.getText()); 
// File Locations
	try
	{
		if(tfVerticalButtonBarImage.getText().equalsIgnoreCase("")==false)
		{
			ProjectManager.putTempNoFileWrite("btnBarImgPath", new File(tfVerticalButtonBarImage.getText()).toURL().toString());
		}
		else
		{
			ProjectManager.putTempNoFileWrite("btnBarImgPath", "");
		}
		if(tfSplashImage.getText().equalsIgnoreCase("")==false)
		{
			ProjectManager.putTempNoFileWrite("splashImgPath", new File(tfSplashImage.getText()).toURL().toString());
		}
		else
		{
			ProjectManager.putTempNoFileWrite("splashImgPath", "");
		}
		if(tfProgressBarImage.getText().equalsIgnoreCase("")==false)
		{
			ProjectManager.putTempNoFileWrite("progressPanelImgPath", new File(tfProgressBarImage.getText()).toURL().toString());
		}
		else
		{
			ProjectManager.putTempNoFileWrite("progressPanelImgPath", "");
		}
	}
	catch(Exception ee)
	{
		//ee.printStackTrace();
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
            if(ProjectManager.get("progressPanelImgBGColor")!=null)
            {
                if(ProjectManager.get("progressPanelImgBGColor").equalsIgnoreCase("")==false)
                {
                    progressBarImagePanelBackgroundColorEnabled.setSelected(false);
                    ProgressBarImagePanelColorChooserButton.setVisible(true); 
                }
                else
                {
                    progressBarImagePanelBackgroundColorEnabled.setSelected(true);
                    ProgressBarImagePanelColorChooserButton.setVisible(false);                    
                }
            }
            else
            {
                progressBarImagePanelBackgroundColorEnabled.setSelected(true);
                ProgressBarImagePanelColorChooserButton.setVisible(false);                
            }
            if(ProjectManager.get("splashImgBGColor")!=null)
            {
                if(ProjectManager.get("splashImgBGColor").equalsIgnoreCase("")==false)
                {
                    defaultImagePanelBackgroundColorEnabled.setSelected(false);
                    ColorChooserButton.setVisible(true);                      
                }
                else
                {
                    defaultImagePanelBackgroundColorEnabled.setSelected(true);
                    ColorChooserButton.setVisible(false);                  
                }
            }
            else
            {
                    defaultImagePanelBackgroundColorEnabled.setSelected(true);
                    ColorChooserButton.setVisible(false);            
            }
            if(ProjectManager.get("btnBarImgBGColor")!=null)
            {
                if(ProjectManager.get("btnBarImgBGColor").equalsIgnoreCase("")==false)
                {
                    verticalButtonBarDefaultImagePanelBackgroundColorEnabled.setSelected(false);
                    VerticalButtonBarColorChooserButton.setVisible(true);                      
                }
                else
                {
                    verticalButtonBarDefaultImagePanelBackgroundColorEnabled.setSelected(true);
                    VerticalButtonBarColorChooserButton.setVisible(false);                  
                }
            }
            else
            {
                verticalButtonBarDefaultImagePanelBackgroundColorEnabled.setSelected(true);
                VerticalButtonBarColorChooserButton.setVisible(false);            
            }     
            if(ProjectManager.get("splashImageSize")!=null)
            {
			if(ProjectManager.get("splashImageSize").equalsIgnoreCase("")==false)
			{
	           		Object[] tmpArray = getStringArraysFromString(ProjectManager.get("splashImageSize"));
	    		      spinSplashImagePixelWidth.setModel(new SpinnerNumberModel(Integer.valueOf((String)tmpArray[0]),new Integer(1),new Integer(9999),new Integer(1)));
	   		      spinSplashImagePixelHeight.setModel(new SpinnerNumberModel(Integer.valueOf((String)tmpArray[1]),new Integer(1),new Integer(9999),new Integer(1)));
			}
			else
			{
	    		      spinSplashImagePixelWidth.setModel(new SpinnerNumberModel(new Integer(500),new Integer(1),new Integer(9999),new Integer(1)));
	   		      spinSplashImagePixelHeight.setModel(new SpinnerNumberModel(new Integer(300),new Integer(1),new Integer(9999),new Integer(1)));
			}
            }
		else
		{
	    		spinSplashImagePixelWidth.setModel(new SpinnerNumberModel(new Integer(500),new Integer(1),new Integer(9999),new Integer(1)));
	   		spinSplashImagePixelHeight.setModel(new SpinnerNumberModel(new Integer(300),new Integer(1),new Integer(9999),new Integer(1)));
		}  
JComponent editor = spinSplashImagePixelWidth.getEditor();
JSpinner.NumberEditor field = (JSpinner.NumberEditor)editor;
field.getTextField().setEditable(false);
editor = spinSplashImagePixelHeight.getEditor();
field = (JSpinner.NumberEditor)editor;
field.getTextField().setEditable(false);

// Stretch to fit Image Size
  	      if(ProjectManager.get("btnBarImgStretchToFitEnabled")!=null)
        	{
        		if(ProjectManager.get("btnBarImgStretchToFitEnabled").equalsIgnoreCase("false")==true)
        		{
				btnBarImageStretchToFitEnabled.setSelected(false);
        		}
        		else
        		{
				btnBarImageStretchToFitEnabled.setSelected(true);
        		}     
	  	}

  	      if(ProjectManager.get("btnBarImgAlignTopEnabled")!=null)
        	{
        		if(ProjectManager.get("btnBarImgAlignTopEnabled").equalsIgnoreCase("false")==true)
        		{
				btnBarImageAlignToTopEnabled.setSelected(false);
        		}
        		else
        		{
				btnBarImageAlignToTopEnabled.setSelected(true);
        		}     
	  	}
// End Stretch to fit Image
// Override Progress Bar Image Default Panel Size
  	      if(ProjectManager.get("progressPanelImgStretchToFitEnabled")!=null)
        	{
        		if(ProjectManager.get("progressPanelImgStretchToFitEnabled").equalsIgnoreCase("false")==true)
        		{
				progressPanelImgStretchToFitEnabled.setSelected(false);
        		}
        		else
        		{
				progressPanelImgStretchToFitEnabled.setSelected(true);
			}
	  	}

// End Override Progress Bar Image Default Panel Size
// Image Enabled Components  
		if(ProjectManager.get("btnBarImgBtnEnabled")!=null)
		{
			if(ProjectManager.get("btnBarImgBtnEnabled").equalsIgnoreCase("true")==true)
			{
				VerticalButtonBarImageButtonEnabled1.setSelected(true);
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
		if(ProjectManager.get("progressPanelImgEnabled")!=null)
		{
			if(ProjectManager.get("progressPanelImgEnabled").equalsIgnoreCase("true")==true)
			{
				ProgressBarImageEnabled.setSelected(true);
			}
			else
			{
				ProgressBarImageEnabled.setSelected(false);
			}
		}
		else
		{
			ProgressBarImageEnabled.setSelected(false);
		}	
// End Image Enabled Components             
		if(ProjectManager.get("btnBarImgActionType")!=null)
		{
			if(ProjectManager.get("btnBarImgActionType").equalsIgnoreCase("-1")==true)
			{
				cbActionType.setSelectedIndex(0);
			}
			else if(ProjectManager.get("btnBarImgActionType").equalsIgnoreCase("0")==true)
			{
				cbActionType.setSelectedIndex(1);
			}
			else if(ProjectManager.get("btnBarImgActionType").equalsIgnoreCase("1")==true)
			{
				cbActionType.setSelectedIndex(2);
			}
			else
			{
				cbActionType.setSelectedIndex(0);
			}
		}
		else
		{
			cbActionType.setSelectedIndex(0);
		}
		if(ProjectManager.get("btnBarImgAction")!=null)
		{
			if(ProjectManager.get("btnBarImgAction").equalsIgnoreCase("")==false)
			{
				tfVerticalButtonBarImage1.setText(ProjectManager.get("btnBarImgAction"));
			}
			else
			{
				tfVerticalButtonBarImage1.setText("");
			}
		}
		else
		{
			tfVerticalButtonBarImage1.setText("");
		}
		if(ProjectManager.get("progressPanelImgActionType")!=null)
		{
			if(ProjectManager.get("progressPanelImgActionType").equalsIgnoreCase("-1")==true)
			{
				cbProgressBarImageActionType.setSelectedIndex(0);
			}
			else if(ProjectManager.get("progressPanelImgActionType").equalsIgnoreCase("0")==true)
			{
				cbProgressBarImageActionType.setSelectedIndex(1);
			}
			else if(ProjectManager.get("progressPanelImgActionType").equalsIgnoreCase("1")==true)
			{
				cbProgressBarImageActionType.setSelectedIndex(2);
			}
			else
			{
				cbProgressBarImageActionType.setSelectedIndex(0);
			}
		}
		else
		{
			cbProgressBarImageActionType.setSelectedIndex(0);
		}
		if(ProjectManager.get("progressPanelImgAction")!=null)
		{
			if(ProjectManager.get("progressPanelImgAction").equalsIgnoreCase("")==false)
			{
				tfProgressBarImageAction.setText(ProjectManager.get("progressPanelImgAction"));
			}
			else
			{
				tfProgressBarImageAction.setText("");
			}
		}
		else
		{
			tfProgressBarImageAction.setText("");
		}
// File Locations
	try
	{
if(ProjectManager.get("btnBarImgPath")!=null)
{
	if(ProjectManager.get("btnBarImgPath").equalsIgnoreCase("")==false)
	{
		tfVerticalButtonBarImage.setText(new File(new URL(ProjectManager.get("btnBarImgPath")).getFile()).getCanonicalPath());
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
if(ProjectManager.get("splashImgPath")!=null)
{
	if(ProjectManager.get("splashImgPath").equalsIgnoreCase("")==false)
	{
		tfSplashImage.setText(new File(new URL(ProjectManager.get("splashImgPath")).getFile()).getCanonicalPath());
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
if(ProjectManager.get("progressPanelImgPath")!=null)
{
	if(ProjectManager.get("progressPanelImgPath").equalsIgnoreCase("")==false)
	{
		tfProgressBarImage.setText(new File(new URL(ProjectManager.get("progressPanelImgPath")).getFile()).getCanonicalPath());
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
        defaultImagePanelBackgroundColorEnabled = new javax.swing.JCheckBox();
        lFiller44 = new javax.swing.JLabel();
        ColorChooserButton = new javax.swing.JButton();
        lFiller56 = new javax.swing.JLabel();
        lOverrideDefaultSplashImageWidth2 = new javax.swing.JLabel();
        spinSplashImagePixelWidth = new javax.swing.JSpinner();
        lFiller57 = new javax.swing.JLabel();
        lOverrideDefaultSplashImageHeight2 = new javax.swing.JLabel();
        spinSplashImagePixelHeight = new JSpinner(new SpinnerNumberModel(new Integer(300),new Integer(1),new Integer(9999),new Integer(1)));
        lFiller49 = new javax.swing.JLabel();
        UIChoicesBottomPanel7 = new javax.swing.JPanel();
        UIChoicesBottomPanel6 = new javax.swing.JPanel();
        lFiller51 = new javax.swing.JLabel();
        lFiller53 = new javax.swing.JLabel();
        lFiller54 = new javax.swing.JLabel();
        lFiller55 = new javax.swing.JLabel();
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
        UIChoicesBottomPanel8 = new javax.swing.JPanel();
        lFiller46 = new javax.swing.JLabel();
        verticalButtonBarDefaultImagePanelBackgroundColorEnabled = new javax.swing.JCheckBox();
        lFiller50 = new javax.swing.JLabel();
        VerticalButtonBarColorChooserButton = new javax.swing.JButton();
        lFiller52 = new javax.swing.JLabel();
        UIChoicesBottomPanel9 = new javax.swing.JPanel();
        UIChoicesBottomPanel10 = new javax.swing.JPanel();
        lFiller60 = new javax.swing.JLabel();
        btnBarImageStretchToFitEnabled = new javax.swing.JCheckBox();
	  btnBarImageAlignToTopEnabled = new javax.swing.JCheckBox();
        lFiller61 = new javax.swing.JLabel();
        lFiller62 = new javax.swing.JLabel();
        lFiller63 = new javax.swing.JLabel();
        UIChoicesBottomPanel12 = new javax.swing.JPanel();
        UIChoicesBottomPanel11 = new javax.swing.JPanel();
        lFiller64 = new javax.swing.JLabel();
        lVerticalButtonBarButtonActionType = new javax.swing.JLabel();
        cbActionType = new javax.swing.JComboBox();
        lFiller65 = new javax.swing.JLabel();
        lVerticalButtonBarButtonAction = new javax.swing.JLabel();
        tfVerticalButtonBarImage1 = new javax.swing.JTextField();
        lFiller67 = new javax.swing.JLabel();
        ProjectLookAndFeelImages2 = new javax.swing.JPanel();
        ImageDescriptionLabel2 = new javax.swing.JPanel();
        LeftUIFiller4 = new javax.swing.JLabel();
        ImageDescription2 = new javax.swing.JLabel();
        ProgressBarImageEnabled = new javax.swing.JCheckBox();
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
        UIChoicesBottomPanel13 = new javax.swing.JPanel();
        lFiller58 = new javax.swing.JLabel();
        progressBarImagePanelBackgroundColorEnabled = new javax.swing.JCheckBox();
        lFiller59 = new javax.swing.JLabel();
        ProgressBarImagePanelColorChooserButton = new javax.swing.JButton();
        lFiller66 = new javax.swing.JLabel();
        UIChoicesBottomPanel14 = new javax.swing.JPanel();
        UIChoicesBottomPanel15 = new javax.swing.JPanel();
        lFiller68 = new javax.swing.JLabel();
        progressPanelImgStretchToFitEnabled = new javax.swing.JCheckBox();
        lFiller69 = new javax.swing.JLabel();
        lFiller70 = new javax.swing.JLabel();
        lFiller71 = new javax.swing.JLabel();
        UIChoicesBottomPanel16 = new javax.swing.JPanel();
        lFiller72 = new javax.swing.JLabel();
        lVerticalButtonBarButtonActionType1 = new javax.swing.JLabel();
        cbProgressBarImageActionType = new javax.swing.JComboBox();
        lFiller73 = new javax.swing.JLabel();
        lVerticalButtonBarButtonAction1 = new javax.swing.JLabel();
        tfProgressBarImageAction = new javax.swing.JTextField();
        lFiller74 = new javax.swing.JLabel();
        UIChoicesBottomPanel17 = new javax.swing.JPanel();
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
        ProjectLookAndFeelImages.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Startup Window Splash Image", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages.setMaximumSize(new java.awt.Dimension(32767, 103));
        ProjectLookAndFeelImages.setMinimumSize(new java.awt.Dimension(10, 103));
        ProjectLookAndFeelImages.setPreferredSize(new java.awt.Dimension(10, 103));
        ImageDescriptionLabel.setLayout(new javax.swing.BoxLayout(ImageDescriptionLabel, javax.swing.BoxLayout.X_AXIS));

        ImageDescriptionLabel.setBackground(new java.awt.Color(140, 160, 210));
        LeftUIFiller2.setMaximumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller2.setMinimumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller2.setPreferredSize(new java.awt.Dimension(10, 10));
        ImageDescriptionLabel.add(LeftUIFiller2);

        ImageDescription.setFont(new java.awt.Font("Arial", 0, 12));
        ImageDescription.setText("The optimal startup window splash image size is 500 pixels wide by 300 pixels high.");
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
        tfSplashImage.setText("");
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

        defaultImagePanelBackgroundColorEnabled.setBackground(new java.awt.Color(140, 160, 210));
        defaultImagePanelBackgroundColorEnabled.setFont(new java.awt.Font("Arial", 0, 12));
        defaultImagePanelBackgroundColorEnabled.setSelected(true);
        defaultImagePanelBackgroundColorEnabled.setText("Use default image canvas background color");
        defaultImagePanelBackgroundColorEnabled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defaultImagePanelBackgroundColorEnabledActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel5.add(defaultImagePanelBackgroundColorEnabled);

        lFiller44.setBackground(new java.awt.Color(140, 160, 210));
        lFiller44.setText("   ");
        lFiller44.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller44.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller44.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel5.add(lFiller44);

        ColorChooserButton.setBackground(new java.awt.Color(140, 160, 210));
        ColorChooserButton.setMaximumSize(new java.awt.Dimension(35, 20));
        ColorChooserButton.setMinimumSize(new java.awt.Dimension(35, 20));
        ColorChooserButton.setPreferredSize(new java.awt.Dimension(35, 20));
        ColorChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColorChooserButtonActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel5.add(ColorChooserButton);

        lFiller56.setBackground(new java.awt.Color(140, 160, 210));
        lFiller56.setText("   ");
        lFiller56.setMaximumSize(new java.awt.Dimension(20, 15));
        lFiller56.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller56.setPreferredSize(new java.awt.Dimension(20, 15));
        UIChoicesBottomPanel5.add(lFiller56);

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

        lOverrideDefaultSplashImageHeight2.setBackground(new java.awt.Color(140, 160, 210));
        lOverrideDefaultSplashImageHeight2.setFont(new java.awt.Font("Arial", 0, 12));
        lOverrideDefaultSplashImageHeight2.setText("height:");
        lOverrideDefaultSplashImageHeight2.setMaximumSize(new java.awt.Dimension(45, 15));
        lOverrideDefaultSplashImageHeight2.setMinimumSize(new java.awt.Dimension(10, 15));
        lOverrideDefaultSplashImageHeight2.setPreferredSize(new java.awt.Dimension(45, 15));
        UIChoicesBottomPanel5.add(lOverrideDefaultSplashImageHeight2);

        spinSplashImagePixelHeight.setMaximumSize(new java.awt.Dimension(45, 20));
        spinSplashImagePixelHeight.setMinimumSize(new java.awt.Dimension(45, 20));
        spinSplashImagePixelHeight.setPreferredSize(new java.awt.Dimension(45, 20));
        UIChoicesBottomPanel5.add(spinSplashImagePixelHeight);

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
        //ProjectLookAndFeelImages.add(UIChoicesBottomPanel7);

        UIChoicesBottomPanel6.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel6, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel6.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel6.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel6.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel6.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller51.setBackground(new java.awt.Color(140, 160, 210));
        lFiller51.setText("   ");
        lFiller51.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller51.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller51.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel6.add(lFiller51);

        lFiller53.setBackground(new java.awt.Color(140, 160, 210));
        lFiller53.setText("");
        lFiller53.setMaximumSize(new java.awt.Dimension(20, 15));
        lFiller53.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller53.setPreferredSize(new java.awt.Dimension(20, 15));
        UIChoicesBottomPanel6.add(lFiller53);

        lFiller54.setBackground(new java.awt.Color(140, 160, 210));
        lFiller54.setText("");
        lFiller54.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller54.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller54.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel6.add(lFiller54);

        lFiller55.setBackground(new java.awt.Color(140, 160, 210));
        lFiller55.setText("");
        lFiller55.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller55.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller55.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel6.add(lFiller55);

        //ProjectLookAndFeelImages.add(UIChoicesBottomPanel6);

        add(ProjectLookAndFeelImages);

        ProjectLookAndFeelImages1.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages1, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages1.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages1.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Button Bar Image Button", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages1.setMaximumSize(new java.awt.Dimension(32767, 155));
        ProjectLookAndFeelImages1.setMinimumSize(new java.awt.Dimension(10, 155));
        ProjectLookAndFeelImages1.setPreferredSize(new java.awt.Dimension(10, 155));
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
        ImageDescription1.setText("The maximum size of this image is 105 pixels width by 105 pixels height:");
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
        tfVerticalButtonBarImage.setText("");
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

        UIChoicesBottomPanel8.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel8, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel8.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel8.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel8.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel8.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller46.setBackground(new java.awt.Color(140, 160, 210));
        lFiller46.setText("   ");
        lFiller46.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller46.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller46.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel8.add(lFiller46);

        verticalButtonBarDefaultImagePanelBackgroundColorEnabled.setBackground(new java.awt.Color(140, 160, 210));
        verticalButtonBarDefaultImagePanelBackgroundColorEnabled.setFont(new java.awt.Font("Arial", 0, 12));
        verticalButtonBarDefaultImagePanelBackgroundColorEnabled.setSelected(true);
        verticalButtonBarDefaultImagePanelBackgroundColorEnabled.setText("Use default image canvas background color");
        verticalButtonBarDefaultImagePanelBackgroundColorEnabled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verticalButtonBarDefaultImagePanelBackgroundColorEnabledActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel8.add(verticalButtonBarDefaultImagePanelBackgroundColorEnabled);

        lFiller50.setBackground(new java.awt.Color(140, 160, 210));
        lFiller50.setText("   ");
        lFiller50.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller50.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller50.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel8.add(lFiller50);

        VerticalButtonBarColorChooserButton.setBackground(new java.awt.Color(140, 160, 210));
        VerticalButtonBarColorChooserButton.setMaximumSize(new java.awt.Dimension(35, 20));
        VerticalButtonBarColorChooserButton.setMinimumSize(new java.awt.Dimension(35, 20));
        VerticalButtonBarColorChooserButton.setPreferredSize(new java.awt.Dimension(35, 20));
        VerticalButtonBarColorChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerticalButtonBarColorChooserButtonActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel8.add(VerticalButtonBarColorChooserButton);

        lFiller52.setBackground(new java.awt.Color(140, 160, 210));
        lFiller52.setText("   ");
        lFiller52.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller52.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller52.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel8.add(lFiller52);

        ProjectLookAndFeelImages1.add(UIChoicesBottomPanel8);

        UIChoicesBottomPanel9.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel9, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel9.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel9.setMaximumSize(new java.awt.Dimension(32767, 4));
        UIChoicesBottomPanel9.setMinimumSize(new java.awt.Dimension(5, 4));
        UIChoicesBottomPanel9.setPreferredSize(new java.awt.Dimension(200, 4));
        ProjectLookAndFeelImages1.add(UIChoicesBottomPanel9);

        UIChoicesBottomPanel10.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel10, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel10.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel10.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel10.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel10.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller60.setBackground(new java.awt.Color(140, 160, 210));
        lFiller60.setText("   ");
        lFiller60.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller60.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller60.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel10.add(lFiller60);

        btnBarImageStretchToFitEnabled.setBackground(new java.awt.Color(140, 160, 210));
        btnBarImageStretchToFitEnabled.setFont(new java.awt.Font("Arial", 0, 12));
        btnBarImageStretchToFitEnabled.setText("Stretch image to fit");
        btnBarImageStretchToFitEnabled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarImageStretchToFitEnabledActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel10.add(btnBarImageStretchToFitEnabled);

        btnBarImageAlignToTopEnabled.setBackground(new java.awt.Color(140, 160, 210));
        btnBarImageAlignToTopEnabled.setFont(new java.awt.Font("Arial", 0, 12));
        btnBarImageAlignToTopEnabled.setText("Align image to top");
        btnBarImageAlignToTopEnabled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarImageAlignToTopEnabledActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel10.add(btnBarImageAlignToTopEnabled);

        lFiller61.setBackground(new java.awt.Color(140, 160, 210));
        lFiller61.setText("   ");
        lFiller61.setMaximumSize(new java.awt.Dimension(20, 15));
        lFiller61.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller61.setPreferredSize(new java.awt.Dimension(20, 15));
        UIChoicesBottomPanel10.add(lFiller61);

        lFiller62.setBackground(new java.awt.Color(140, 160, 210));
        lFiller62.setText("   ");
        lFiller62.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller62.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller62.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel10.add(lFiller62);

        lFiller63.setBackground(new java.awt.Color(140, 160, 210));
        lFiller63.setText("   ");
        lFiller63.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller63.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller63.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel10.add(lFiller63);

        ProjectLookAndFeelImages1.add(UIChoicesBottomPanel10);

        UIChoicesBottomPanel12.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel12, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel12.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel12.setMaximumSize(new java.awt.Dimension(32767, 4));
        UIChoicesBottomPanel12.setMinimumSize(new java.awt.Dimension(5, 4));
        UIChoicesBottomPanel12.setPreferredSize(new java.awt.Dimension(200, 4));
        ProjectLookAndFeelImages1.add(UIChoicesBottomPanel12);

        UIChoicesBottomPanel11.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel11, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel11.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel11.setMaximumSize(new java.awt.Dimension(32767, 25));
        UIChoicesBottomPanel11.setMinimumSize(new java.awt.Dimension(5, 25));
        UIChoicesBottomPanel11.setPreferredSize(new java.awt.Dimension(200, 25));
        lFiller64.setBackground(new java.awt.Color(140, 160, 210));
        lFiller64.setText("   ");
        lFiller64.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller64.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller64.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel11.add(lFiller64);

        lVerticalButtonBarButtonActionType.setBackground(new java.awt.Color(140, 160, 210));
        lVerticalButtonBarButtonActionType.setFont(new java.awt.Font("Arial", 0, 12));
        lVerticalButtonBarButtonActionType.setText("Action Type:");
        lVerticalButtonBarButtonActionType.setMaximumSize(new java.awt.Dimension(80, 15));
        lVerticalButtonBarButtonActionType.setMinimumSize(new java.awt.Dimension(80, 15));
        lVerticalButtonBarButtonActionType.setPreferredSize(new java.awt.Dimension(80, 15));
        UIChoicesBottomPanel11.add(lVerticalButtonBarButtonActionType);

        cbActionType.setFont(new java.awt.Font("Arial", 0, 11));
        cbActionType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Disabled", "Load Web Page", "Java Action" }));
        cbActionType.setMaximumSize(new java.awt.Dimension(120, 20));
        cbActionType.setMinimumSize(new java.awt.Dimension(120, 20));
        cbActionType.setPreferredSize(new java.awt.Dimension(120, 20));
        cbActionType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbActionTypeActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel11.add(cbActionType);

        lFiller65.setBackground(new java.awt.Color(140, 160, 210));
        lFiller65.setText("   ");
        lFiller65.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller65.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller65.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel11.add(lFiller65);

        lVerticalButtonBarButtonAction.setBackground(new java.awt.Color(140, 160, 210));
        lVerticalButtonBarButtonAction.setFont(new java.awt.Font("Arial", 0, 12));
        lVerticalButtonBarButtonAction.setText("Action:");
        lVerticalButtonBarButtonAction.setMaximumSize(new java.awt.Dimension(50, 15));
        lVerticalButtonBarButtonAction.setMinimumSize(new java.awt.Dimension(50, 15));
        lVerticalButtonBarButtonAction.setPreferredSize(new java.awt.Dimension(50, 15));
        UIChoicesBottomPanel11.add(lVerticalButtonBarButtonAction);

        tfVerticalButtonBarImage1.setFont(new java.awt.Font("Arial", 0, 12));
        tfVerticalButtonBarImage1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfVerticalButtonBarImage1.setText("http://www.evaluateanywhere.com");
        tfVerticalButtonBarImage1.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfVerticalButtonBarImage1.setMinimumSize(new java.awt.Dimension(200, 20));
        tfVerticalButtonBarImage1.setPreferredSize(new java.awt.Dimension(450, 20));
        UIChoicesBottomPanel11.add(tfVerticalButtonBarImage1);

        lFiller67.setBackground(new java.awt.Color(140, 160, 210));
        lFiller67.setText("   ");
        lFiller67.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller67.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller67.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel11.add(lFiller67);

        ProjectLookAndFeelImages1.add(UIChoicesBottomPanel11);

        add(ProjectLookAndFeelImages1);

        ProjectLookAndFeelImages2.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages2, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages2.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages2.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Progress Bar Image Button", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages2.setMaximumSize(new java.awt.Dimension(32767, 155));
        ProjectLookAndFeelImages2.setMinimumSize(new java.awt.Dimension(10, 155));
        ProjectLookAndFeelImages2.setPreferredSize(new java.awt.Dimension(10, 155));
        ProjectLookAndFeelImages2.setRequestFocusEnabled(false);
        ImageDescriptionLabel2.setLayout(new javax.swing.BoxLayout(ImageDescriptionLabel2, javax.swing.BoxLayout.X_AXIS));

        ImageDescriptionLabel2.setBackground(new java.awt.Color(140, 160, 210));
        LeftUIFiller4.setMaximumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller4.setMinimumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller4.setPreferredSize(new java.awt.Dimension(10, 10));
        ImageDescriptionLabel2.add(LeftUIFiller4);

        ImageDescription2.setFont(new java.awt.Font("Arial", 0, 12));
        ImageDescription2.setText("The maximum size of this image is 44 pixels width by 44 pixels height:");
        ImageDescription2.setMaximumSize(new java.awt.Dimension(32767, 15));
        ImageDescriptionLabel2.add(ImageDescription2);

        ProgressBarImageEnabled.setBackground(new java.awt.Color(140, 160, 210));
        ProgressBarImageEnabled.setFont(new java.awt.Font("Arial", 0, 12));
        ProgressBarImageEnabled.setSelected(true);
        ProgressBarImageEnabled.setText("Enabled");
        ProgressBarImageEnabled.setMaximumSize(new java.awt.Dimension(81, 23));
        ProgressBarImageEnabled.setMinimumSize(new java.awt.Dimension(81, 23));
        ProgressBarImageEnabled.setPreferredSize(new java.awt.Dimension(81, 23));
        ProgressBarImageEnabled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProgressBarImageEnabledActionPerformed(evt);
            }
        });

        ImageDescriptionLabel2.add(ProgressBarImageEnabled);

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
        tfProgressBarImage.setText("");
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

        UIChoicesBottomPanel13.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel13, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel13.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel13.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel13.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel13.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller58.setBackground(new java.awt.Color(140, 160, 210));
        lFiller58.setText("   ");
        lFiller58.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller58.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller58.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel13.add(lFiller58);

        progressBarImagePanelBackgroundColorEnabled.setBackground(new java.awt.Color(140, 160, 210));
        progressBarImagePanelBackgroundColorEnabled.setFont(new java.awt.Font("Arial", 0, 12));
        progressBarImagePanelBackgroundColorEnabled.setSelected(true);
        progressBarImagePanelBackgroundColorEnabled.setText("Use default image canvas background color");
        progressBarImagePanelBackgroundColorEnabled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progressBarImagePanelBackgroundColorEnabledActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel13.add(progressBarImagePanelBackgroundColorEnabled);

        lFiller59.setBackground(new java.awt.Color(140, 160, 210));
        lFiller59.setText("   ");
        lFiller59.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller59.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller59.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel13.add(lFiller59);

        ProgressBarImagePanelColorChooserButton.setBackground(new java.awt.Color(140, 160, 210));
        ProgressBarImagePanelColorChooserButton.setMaximumSize(new java.awt.Dimension(35, 20));
        ProgressBarImagePanelColorChooserButton.setMinimumSize(new java.awt.Dimension(35, 20));
        ProgressBarImagePanelColorChooserButton.setPreferredSize(new java.awt.Dimension(35, 20));
        ProgressBarImagePanelColorChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProgressBarImagePanelColorChooserButtonActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel13.add(ProgressBarImagePanelColorChooserButton);

        lFiller66.setBackground(new java.awt.Color(140, 160, 210));
        lFiller66.setText("   ");
        lFiller66.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller66.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller66.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel13.add(lFiller66);

        ProjectLookAndFeelImages2.add(UIChoicesBottomPanel13);

        UIChoicesBottomPanel14.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel14, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel14.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel14.setMaximumSize(new java.awt.Dimension(32767, 4));
        UIChoicesBottomPanel14.setMinimumSize(new java.awt.Dimension(5, 4));
        UIChoicesBottomPanel14.setPreferredSize(new java.awt.Dimension(200, 4));
        ProjectLookAndFeelImages2.add(UIChoicesBottomPanel14);

        UIChoicesBottomPanel15.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel15, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel15.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel15.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel15.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel15.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller68.setBackground(new java.awt.Color(140, 160, 210));
        lFiller68.setText("   ");
        lFiller68.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller68.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller68.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel15.add(lFiller68);

        progressPanelImgStretchToFitEnabled.setBackground(new java.awt.Color(140, 160, 210));
        progressPanelImgStretchToFitEnabled.setFont(new java.awt.Font("Arial", 0, 12));
        progressPanelImgStretchToFitEnabled.setText("Stretch image to fit");
        progressPanelImgStretchToFitEnabled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progressPanelImgStretchToFitEnabledActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel15.add(progressPanelImgStretchToFitEnabled);

        lFiller69.setBackground(new java.awt.Color(140, 160, 210));
        lFiller69.setText("   ");
        lFiller69.setMaximumSize(new java.awt.Dimension(20, 15));
        lFiller69.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller69.setPreferredSize(new java.awt.Dimension(20, 15));
        UIChoicesBottomPanel15.add(lFiller69);

        lFiller70.setBackground(new java.awt.Color(140, 160, 210));
        lFiller70.setText("   ");
        lFiller70.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller70.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller70.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel15.add(lFiller70);

        lFiller71.setBackground(new java.awt.Color(140, 160, 210));
        lFiller71.setText("   ");
        lFiller71.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller71.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller71.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel15.add(lFiller71);

        ProjectLookAndFeelImages2.add(UIChoicesBottomPanel15);

        UIChoicesBottomPanel16.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel16, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel16.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel16.setMaximumSize(new java.awt.Dimension(32767, 25));
        UIChoicesBottomPanel16.setMinimumSize(new java.awt.Dimension(5, 25));
        UIChoicesBottomPanel16.setPreferredSize(new java.awt.Dimension(200, 25));
        lFiller72.setBackground(new java.awt.Color(140, 160, 210));
        lFiller72.setText("   ");
        lFiller72.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller72.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller72.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel16.add(lFiller72);

        lVerticalButtonBarButtonActionType1.setBackground(new java.awt.Color(140, 160, 210));
        lVerticalButtonBarButtonActionType1.setFont(new java.awt.Font("Arial", 0, 12));
        lVerticalButtonBarButtonActionType1.setText("Action Type:");
        lVerticalButtonBarButtonActionType1.setMaximumSize(new java.awt.Dimension(80, 15));
        lVerticalButtonBarButtonActionType1.setMinimumSize(new java.awt.Dimension(80, 15));
        lVerticalButtonBarButtonActionType1.setPreferredSize(new java.awt.Dimension(80, 15));
        UIChoicesBottomPanel16.add(lVerticalButtonBarButtonActionType1);

        cbProgressBarImageActionType.setFont(new java.awt.Font("Arial", 0, 11));
        cbProgressBarImageActionType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Disabled", "Load Web Page", "Java Action" }));
        cbProgressBarImageActionType.setMaximumSize(new java.awt.Dimension(120, 20));
        cbProgressBarImageActionType.setMinimumSize(new java.awt.Dimension(120, 20));
        cbProgressBarImageActionType.setPreferredSize(new java.awt.Dimension(120, 20));
        cbProgressBarImageActionType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProgressBarImageActionTypeActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel16.add(cbProgressBarImageActionType);

        lFiller73.setBackground(new java.awt.Color(140, 160, 210));
        lFiller73.setText("   ");
        lFiller73.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller73.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller73.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel16.add(lFiller73);

        lVerticalButtonBarButtonAction1.setBackground(new java.awt.Color(140, 160, 210));
        lVerticalButtonBarButtonAction1.setFont(new java.awt.Font("Arial", 0, 12));
        lVerticalButtonBarButtonAction1.setText("Action:");
        lVerticalButtonBarButtonAction1.setMaximumSize(new java.awt.Dimension(50, 15));
        lVerticalButtonBarButtonAction1.setMinimumSize(new java.awt.Dimension(50, 15));
        lVerticalButtonBarButtonAction1.setPreferredSize(new java.awt.Dimension(50, 15));
        UIChoicesBottomPanel16.add(lVerticalButtonBarButtonAction1);

        tfProgressBarImageAction.setFont(new java.awt.Font("Arial", 0, 12));
        tfProgressBarImageAction.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfProgressBarImageAction.setText("http://www.evaluateanywhere.com");
        tfProgressBarImageAction.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfProgressBarImageAction.setMinimumSize(new java.awt.Dimension(200, 20));
        tfProgressBarImageAction.setPreferredSize(new java.awt.Dimension(450, 20));
        UIChoicesBottomPanel16.add(tfProgressBarImageAction);

        lFiller74.setBackground(new java.awt.Color(140, 160, 210));
        lFiller74.setText("   ");
        lFiller74.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller74.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller74.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel16.add(lFiller74);

        ProjectLookAndFeelImages2.add(UIChoicesBottomPanel16);

        UIChoicesBottomPanel17.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel17, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel17.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel17.setMaximumSize(new java.awt.Dimension(32767, 4));
        UIChoicesBottomPanel17.setMinimumSize(new java.awt.Dimension(5, 4));
        UIChoicesBottomPanel17.setPreferredSize(new java.awt.Dimension(200, 4));
        ProjectLookAndFeelImages2.add(UIChoicesBottomPanel17);

        add(ProjectLookAndFeelImages2);

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

    private void progressBarImagePanelBackgroundColorEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progressBarImagePanelBackgroundColorEnabledActionPerformed
        try
        {
            if(progressBarImagePanelBackgroundColorEnabled.isSelected()==true)
            {
                ProjectManager.put("progressPanelImgBGColor", "");
                ProjectManager.remove("progressPanelImgBGColor");                
                ProgressBarImagePanelColorChooserButton.setVisible(false);                      
            }
            else
            {
                ProgressBarImagePanelColorChooserButton.setVisible(true);  
                updateProgressBarImageButtonColorSwatch();            
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_progressBarImagePanelBackgroundColorEnabledActionPerformed

    private void btnBarImageStretchToFitEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarImageStretchToFitEnabledActionPerformed
//TODO Code goes here.
    }//GEN-LAST:event_btnBarImageStretchToFitEnabledActionPerformed

    private void btnBarImageAlignToTopEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarImageAlignToTopEnabledActionPerformed
//TODO Code goes here.
    }//GEN-LAST:event_btnBarImageAlignToTopEnabledActionPerformed

    private void verticalButtonBarDefaultImagePanelBackgroundColorEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verticalButtonBarDefaultImagePanelBackgroundColorEnabledActionPerformed
        try
        {
            if(verticalButtonBarDefaultImagePanelBackgroundColorEnabled.isSelected()==true)
            {
                ProjectManager.put("btnBarImgBGColor", "");
                ProjectManager.remove("btnBarImgBGColor");                
                VerticalButtonBarColorChooserButton.setVisible(false);                      
            }
            else
            {
                VerticalButtonBarColorChooserButton.setVisible(true);  
                updateVerticalButtonBarImageButtonColorSwatch();            
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_verticalButtonBarDefaultImagePanelBackgroundColorEnabledActionPerformed

    private void ProgressBarImageDefaultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProgressBarImageDefaultButtonActionPerformed
		try
		{
             	ProjectManager.put("progressPanelImgPath", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/images/pbar.png").toString());
			tfProgressBarImage.setText(new File(new URL(ProjectManager.get("progressPanelImgPath")).getFile()).getCanonicalPath());
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
             	ProjectManager.put("progressPanelImgPath", imageFileChooser.getSelectedFile().toURL().toString());
			tfProgressBarImage.setText(new File(new URL(ProjectManager.get("progressPanelImgPath")).getFile()).getCanonicalPath());
			tfProgressBarImage.setCaretPosition(0);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_ProgressBarImageChooseButtonActionPerformed

    private void ProgressBarImageEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProgressBarImageEnabledActionPerformed
//TODO: Disable all GUI components on Image disabled.
        try
        {
            if(ProgressBarImageEnabled.isSelected()==true)
            {
                ProjectManager.put("progressPanelImgEnabled", "true");
                   
            }
            else
            {
                ProjectManager.put("progressPanelImgEnabled", "false");

            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ProgressBarImageEnabledActionPerformed

    private void VerticalButtonBarImageButtonEnabled1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerticalButtonBarImageButtonEnabled1ActionPerformed
//TODO: Disable all GUI components on Image disabled.
        try
        {
            if(VerticalButtonBarImageButtonEnabled1.isSelected()==true)
            {
                ProjectManager.put("btnBarImgBtnEnabled", "true");
                   
            }
            else
            {
                ProjectManager.put("btnBarImgBtnEnabled", "false");

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
             	ProjectManager.put("btnBarImgPath", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/images/logo.png").toString());
			tfVerticalButtonBarImage.setText(new File(new URL(ProjectManager.get("btnBarImgPath")).getFile()).getCanonicalPath());
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
		((EAPanel)getParentComponent()).getDataUpdate();
		new StartVerticalButtonBarThemeAction();	
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
             	ProjectManager.put("btnBarImgPath", imageFileChooser.getSelectedFile().toURL().toString());
			tfVerticalButtonBarImage.setText(new File(new URL(ProjectManager.get("btnBarImgPath")).getFile()).getCanonicalPath());
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
             	ProjectManager.put("splashImgPath", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/images/eafree_splash.png").toString());
			tfSplashImage.setText(new File(new URL(ProjectManager.get("splashImgPath")).getFile()).getCanonicalPath());
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
             	ProjectManager.put("splashImgPath", imageFileChooser.getSelectedFile().toURL().toString());
			tfSplashImage.setText(new File(new URL(ProjectManager.get("splashImgPath")).getFile()).getCanonicalPath());
			tfSplashImage.setCaretPosition(0);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_SplashImageChooseButtonActionPerformed

    private void cbProgressBarImageActionTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProgressBarImageActionTypeActionPerformed


	try
	{
		if(cbProgressBarImageActionType.getSelectedIndex()==1)
		{
			if(tfProgressBarImageAction.getText().equalsIgnoreCase("")==true)
			{
				tfProgressBarImageAction.setText("http://www.evaluateanywhere.com");
			}
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_cbProgressBarImageActionTypeActionPerformed

    private void cbActionTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActionTypeActionPerformed
	try
	{
		if(cbActionType.getSelectedIndex()==1)
		{
			if(tfVerticalButtonBarImage1.getText().equalsIgnoreCase("")==true)
			{
				tfVerticalButtonBarImage1.setText("http://www.evaluateanywhere.com");
			}
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_cbActionTypeActionPerformed

    private void ProgressBarImagePanelColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProgressBarImagePanelColorChooserButtonActionPerformed
 	// Bring up a color chooser 
        if(ProjectManager.get("progressPanelImgBGColor")!=null)
        {
            if(ProjectManager.get("progressPanelImgBGColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("progressPanelImgBGColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("progressPanelImgBGColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ProgressBarImagePanelColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("progressPanelImgBGColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                ProgressBarImagePanelColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("progressPanelImgBGColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                ProgressBarImagePanelColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_ProgressBarImagePanelColorChooserButtonActionPerformed

    private void VerticalButtonBarColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerticalButtonBarColorChooserButtonActionPerformed
 	// Bring up a color chooser 
        if(ProjectManager.get("btnBarImgBGColor")!=null)
        {
            if(ProjectManager.get("btnBarImgBGColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("btnBarImgBGColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("btnBarImgBGColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                VerticalButtonBarColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("btnBarImgBGColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                VerticalButtonBarColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("btnBarImgBGColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                VerticalButtonBarColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_VerticalButtonBarColorChooserButtonActionPerformed
 
    private void defaultImagePanelBackgroundColorEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaultImagePanelBackgroundColorEnabledActionPerformed
        try
        {
            if(defaultImagePanelBackgroundColorEnabled.isSelected()==true)
            {
                ProjectManager.put("splashImgBGColor", "");
                ProjectManager.remove("splashImgBGColor");                
                ColorChooserButton.setVisible(false);                      
            }
            else
            {
                ColorChooserButton.setVisible(true);  
                updateSplashButtonColorSwatch();            
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_defaultImagePanelBackgroundColorEnabledActionPerformed

    private void ColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColorChooserButtonActionPerformed
 	// Bring up a color chooser 
        if(ProjectManager.get("splashImgBGColor")!=null)
        {
            if(ProjectManager.get("splashImgBGColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("splashImgBGColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("splashImgBGColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("splashImgBGColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                ColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("splashImgBGColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                ColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_ColorChooserButtonActionPerformed

    private void updateVerticalButtonBarImageButtonColorSwatch()
    {
        try
        {
            Color c = new java.awt.Color(255,255,255); 
            // Bring up a color chooser 
            if(ProjectManager.get("btnBarImgBGColor")!=null)
            {
                if(ProjectManager.get("btnBarImgBGColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("btnBarImgBGColor"));
                    c = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()); 
                    VerticalButtonBarColorChooserButton.setIcon(new ColorSwatch(c));
                }
                else
                {
                    VerticalButtonBarColorChooserButton.setIcon(noColorIcon);
                }
            }
            else
            {
                VerticalButtonBarColorChooserButton.setIcon(noColorIcon);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }        
    
    private void updateProgressBarImageButtonColorSwatch()
    {
        try
        {
            Color c = new java.awt.Color(255,255,255); 
            // Bring up a color chooser 
            if(ProjectManager.get("progressPanelImgBGColor")!=null)
            {
                if(ProjectManager.get("progressPanelImgBGColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("progressPanelImgBGColor"));
                    c = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()); 
                    ProgressBarImagePanelColorChooserButton.setIcon(new ColorSwatch(c));
                }
                else
                {
                    ProgressBarImagePanelColorChooserButton.setIcon(noColorIcon);
                }
            }
            else
            {
                ProgressBarImagePanelColorChooserButton.setIcon(noColorIcon);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }    
    
    private void updateSplashButtonColorSwatch()
    {
        try
        {
            Color c = new java.awt.Color(255,255,255); 
            // Bring up a color chooser 
            if(ProjectManager.get("splashImgBGColor")!=null)
            {
                if(ProjectManager.get("splashImgBGColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("splashImgBGColor"));
                    c = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()); 
                    ColorChooserButton.setIcon(new ColorSwatch(c));
                }
                else
                {
                    ColorChooserButton.setIcon(noColorIcon);
                }
            }
            else
            {
                    ColorChooserButton.setIcon(noColorIcon);
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
    private javax.swing.JButton ColorChooserButton;
    private javax.swing.JLabel ImageDescription;
    private javax.swing.JLabel ImageDescription1;
    private javax.swing.JLabel ImageDescription2;
    private javax.swing.JPanel ImageDescriptionLabel;
    private javax.swing.JPanel ImageDescriptionLabel2;
    private javax.swing.JPanel ImageDescriptionLabel3;
    private javax.swing.JLabel LeftUIFiller2;
    private javax.swing.JLabel LeftUIFiller3;
    private javax.swing.JLabel LeftUIFiller4;
    private javax.swing.JLabel LeftUIFiller5;
    private javax.swing.JButton PreviewButton;
    private javax.swing.JButton ProgressBarImageChooseButton;
    private javax.swing.JButton ProgressBarImageDefaultButton;
    private javax.swing.JCheckBox ProgressBarImageEnabled;
    private javax.swing.JButton ProgressBarImagePanelColorChooserButton;
    private javax.swing.JPanel ProjectLocationsCenterPanel1;
    private javax.swing.JPanel ProjectLocationsCenterPanel2;
    private javax.swing.JPanel ProjectLocationsCenterPanel3;
    private javax.swing.JPanel ProjectLocationsCenterPanel4;
    private javax.swing.JPanel ProjectLookAndFeelImages;
    private javax.swing.JPanel ProjectLookAndFeelImages1;
    private javax.swing.JPanel ProjectLookAndFeelImages2;
    private javax.swing.JPanel ProjectLookAndFeelImages3;
    private javax.swing.JButton SplashImageChooseButton;
    private javax.swing.JButton SplashImageDefaultButton;
    private javax.swing.JPanel UIChoicesBottomPanel10;
    private javax.swing.JPanel UIChoicesBottomPanel11;
    private javax.swing.JPanel UIChoicesBottomPanel12;
    private javax.swing.JPanel UIChoicesBottomPanel13;
    private javax.swing.JPanel UIChoicesBottomPanel14;
    private javax.swing.JPanel UIChoicesBottomPanel15;
    private javax.swing.JPanel UIChoicesBottomPanel16;
    private javax.swing.JPanel UIChoicesBottomPanel17;
    private javax.swing.JPanel UIChoicesBottomPanel4;
    private javax.swing.JPanel UIChoicesBottomPanel5;
    private javax.swing.JPanel UIChoicesBottomPanel6;
    private javax.swing.JPanel UIChoicesBottomPanel7;
    private javax.swing.JPanel UIChoicesBottomPanel8;
    private javax.swing.JPanel UIChoicesBottomPanel9;
    private javax.swing.JButton VerticalButtonBarColorChooserButton;
    private javax.swing.JCheckBox VerticalButtonBarImageButtonEnabled1;
    private javax.swing.JButton VerticalButtonBarImageChooseButton;
    private javax.swing.JButton VerticalButtonBarImageDefaultButton;
    private javax.swing.JPanel VerticalButtonBarImageDescriptionLabel;
    private javax.swing.JComboBox cbActionType;
    private javax.swing.JComboBox cbProgressBarImageActionType;
    private javax.swing.JCheckBox defaultImagePanelBackgroundColorEnabled;
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
    private javax.swing.JLabel lFiller44;
    private javax.swing.JLabel lFiller45;
    private javax.swing.JLabel lFiller46;
    private javax.swing.JLabel lFiller47;
    private javax.swing.JLabel lFiller48;
    private javax.swing.JLabel lFiller49;
    private javax.swing.JLabel lFiller50;
    private javax.swing.JLabel lFiller51;
    private javax.swing.JLabel lFiller52;
    private javax.swing.JLabel lFiller53;
    private javax.swing.JLabel lFiller54;
    private javax.swing.JLabel lFiller55;
    private javax.swing.JLabel lFiller56;
    private javax.swing.JLabel lFiller57;
    private javax.swing.JLabel lFiller58;
    private javax.swing.JLabel lFiller59;
    private javax.swing.JLabel lFiller60;
    private javax.swing.JLabel lFiller61;
    private javax.swing.JLabel lFiller62;
    private javax.swing.JLabel lFiller63;
    private javax.swing.JLabel lFiller64;
    private javax.swing.JLabel lFiller65;
    private javax.swing.JLabel lFiller66;
    private javax.swing.JLabel lFiller67;
    private javax.swing.JLabel lFiller68;
    private javax.swing.JLabel lFiller69;
    private javax.swing.JLabel lFiller70;
    private javax.swing.JLabel lFiller71;
    private javax.swing.JLabel lFiller72;
    private javax.swing.JLabel lFiller73;
    private javax.swing.JLabel lFiller74;
    private javax.swing.JLabel lOverrideDefaultSplashImageHeight2;
    private javax.swing.JLabel lOverrideDefaultSplashImageWidth2;
    private javax.swing.JLabel lVerticalButtonBarButtonAction;
    private javax.swing.JLabel lVerticalButtonBarButtonAction1;
    private javax.swing.JLabel lVerticalButtonBarButtonActionType;
    private javax.swing.JLabel lVerticalButtonBarButtonActionType1;
    private javax.swing.JCheckBox progressPanelImgStretchToFitEnabled;
    private javax.swing.JCheckBox progressBarImagePanelBackgroundColorEnabled;
    private javax.swing.JSpinner spinSplashImagePixelHeight;
    private javax.swing.JSpinner spinSplashImagePixelWidth;
    private javax.swing.JTextField tfProgressBarImage;
    private javax.swing.JTextField tfProgressBarImageAction;
    private javax.swing.JTextField tfSplashImage;
    private javax.swing.JTextField tfVerticalButtonBarImage;
    private javax.swing.JTextField tfVerticalButtonBarImage1;
    private javax.swing.JCheckBox verticalButtonBarDefaultImagePanelBackgroundColorEnabled;
    private javax.swing.JCheckBox btnBarImageStretchToFitEnabled;
    private javax.swing.JCheckBox btnBarImageAlignToTopEnabled;
    // End of variables declaration//GEN-END:variables
    
}
