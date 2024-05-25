/*
 * ImagesPanel.java
 *
 * Created on June 13, 2004, 3:24 PM
 */

package com.trinity.ea.design.project.lookandfeel.error;
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
public class ErrorPanel extends EAPanel {
    ImageFileFilter filter = new ImageFileFilter(new String[] {"gif", "jpg", "jpeg", "png"}, "Select an image file");   
    JFileChooser imageFileChooser = new JFileChooser();
    private ImageIcon noColorIcon = new ImageIcon(getClass().getResource("/images/nocolor.png"));
    /** Creates new form ImagesPanel */
    public ErrorPanel() 
    {
	  
        initComponents();
        updateHighlightBorderColorSwatch();
        updateShadowBorderColorSwatch();
	  updateButtonBarButtonBackgroundColorSwatch();
        setProjectData();
    }

    public synchronized void getDataUpdate()
    {
	try
        {
		// Progress Bar Spacing Width in Pixels
            SpinnerNumberModel progressBarSpacingWidth = (SpinnerNumberModel)spinProgressBarCellSpacing.getModel();
            ProjectManager.putTempNoFileWrite("progressBarCellSpacing", String.valueOf(progressBarSpacingWidth.getNumber().intValue()));            
		// Image Buttons Enabled
            if(useImageButtonsEnabled.isSelected()==true)
            {
                ProjectManager.putTempNoFileWrite("btnBarImgButtonsEnabled", "true");
            }
            else
            {
                ProjectManager.putTempNoFileWrite("btnBarImgButtonsEnabled", "false");         
            }
		// Button Image Width
            SpinnerNumberModel btnBarImgButtonWidthSpinModel = (SpinnerNumberModel)spinButtonImageWidth.getModel();
            ProjectManager.putTempNoFileWrite("btnBarImgButtonWidth", String.valueOf(btnBarImgButtonWidthSpinModel.getNumber().intValue()));            
		// Button Image Height
            SpinnerNumberModel btnBarImgButtonHeightSpinModel = (SpinnerNumberModel)spinButtonImageHeight.getModel();
            ProjectManager.putTempNoFileWrite("btnBarImgButtonHeight", String.valueOf(btnBarImgButtonHeightSpinModel.getNumber().intValue()));            
		// Button Bar Height Padding
            SpinnerNumberModel btnBarHeightPaddingSpinModel = (SpinnerNumberModel)spinButtonBarHeightPadding.getModel();
            ProjectManager.putTempNoFileWrite("btnBarHeightPadding", String.valueOf(btnBarHeightPaddingSpinModel.getNumber().intValue()));            
// File Locations
	try
	{
		if(tfImageButtonPath.getText().equalsIgnoreCase("")==false)
		{
			ProjectManager.putTempNoFileWrite("btnBarImgButtonFace", new File(tfImageButtonPath.getText()).toURL().toString());
			ProjectManager.putTempNoFileWrite("registrationImgButtonFace", new File(tfImageButtonPath.getText()).toURL().toString());
		}
		if(tfImageButtonOnClickPath.getText().equalsIgnoreCase("")==false)
		{
			ProjectManager.putTempNoFileWrite("btnBarImgButtonFaceOnClick", new File(tfImageButtonOnClickPath.getText()).toURL().toString());
			ProjectManager.putTempNoFileWrite("registrationImgButtonFaceOnClick", new File(tfImageButtonOnClickPath.getText()).toURL().toString());
		}
		if(tfImageButtonInFocusPath.getText().equalsIgnoreCase("")==false)
		{
			ProjectManager.putTempNoFileWrite("buttonFaceImageInFocus", new File(tfImageButtonInFocusPath.getText()).toURL().toString());
			ProjectManager.putTempNoFileWrite("registrationButtonFaceInFocus", new File(tfImageButtonInFocusPath.getText()).toURL().toString());
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
		// Progress Bar Spacing Width in Pixels		
            if(ProjectManager.get("progressBarCellSpacing")!=null)
            {
			if(ProjectManager.get("progressBarCellSpacing").equalsIgnoreCase("")==false)
			{
	    		      spinProgressBarCellSpacing.setModel(new SpinnerNumberModel(Integer.valueOf(ProjectManager.get("progressBarCellSpacing")),new Integer(0),new Integer(9999),new Integer(1)));
			}
			else
			{
	    		      spinProgressBarCellSpacing.setModel(new SpinnerNumberModel(new Integer(0),new Integer(0),new Integer(9999),new Integer(1)));
			}
            }
		else
		{
	    		spinProgressBarCellSpacing.setModel(new SpinnerNumberModel(new Integer(0),new Integer(0),new Integer(9999),new Integer(1)));
		}  
		JComponent editor = spinProgressBarCellSpacing.getEditor();
		JSpinner.NumberEditor field = (JSpinner.NumberEditor)editor;
		field.getTextField().setEditable(false);
		
		// Set Start Window Panel Separator Highlight Border
            if(ProjectManager.get("startWindowPanelSeparatorHighlightBorderColor")!=null)
            {
                if(ProjectManager.get("startWindowPanelSeparatorHighlightBorderColor").equalsIgnoreCase("")==false)
                {
                    startWindowPanelHighlightBorderColorChooserButton.setVisible(true);
			  useDefaultStartWindowPanelHighlightBorderColor.setSelected(false);

                }
                else
                {
                    startWindowPanelHighlightBorderColorChooserButton.setVisible(false);
			  useDefaultStartWindowPanelHighlightBorderColor.setSelected(true);
                }
            }
            else
            {
                startWindowPanelHighlightBorderColorChooserButton.setVisible(false);
		    useDefaultStartWindowPanelHighlightBorderColor.setSelected(true);
            }
		// Set Start Window Panel Separator Shadow Border
            if(ProjectManager.get("startWindowPanelSeparatorShadowBorderColor")!=null)
            {
                if(ProjectManager.get("startWindowPanelSeparatorShadowBorderColor").equalsIgnoreCase("")==false)
                {
                    startWindowPanelShadowBorderColorChooserButton.setVisible(true);
			  useDefaultStartWindowPanelShadowBorderColor.setSelected(false);
                }
                else
                {
                    startWindowPanelShadowBorderColorChooserButton.setVisible(false);
			  useDefaultStartWindowPanelShadowBorderColor.setSelected(true);
                }
            }
            else
            {
                startWindowPanelShadowBorderColorChooserButton.setVisible(false);
		    useDefaultStartWindowPanelShadowBorderColor.setSelected(true);
            } 
		// Set Button Bar Button Background Color
            if(ProjectManager.get("btnBarButtonBGColor")!=null)
            {
                if(ProjectManager.get("btnBarButtonBGColor").equalsIgnoreCase("")==false)
                {
                    buttonBarButtonBackgroundColorChooserButton.setVisible(true);
			  useDefaultButtonBarButtonBackgroundColor.setSelected(false);

                }
                else
                {
                    buttonBarButtonBackgroundColorChooserButton.setVisible(false);
			  useDefaultButtonBarButtonBackgroundColor.setSelected(true);
                }
            }
            else
            {
                buttonBarButtonBackgroundColorChooserButton.setVisible(false);
		    useDefaultButtonBarButtonBackgroundColor.setSelected(true);
            }

		// Image Buttons Enabled
            if(ProjectManager.get("btnBarImgButtonsEnabled")!=null)
            {
            	if(ProjectManager.get("btnBarImgButtonsEnabled").equalsIgnoreCase("true")==true)
            	{
                		useImageButtonsEnabled.setSelected(true);
			}
			else
			{
				useImageButtonsEnabled.setSelected(false);
			}
            }
            else
            {
			useImageButtonsEnabled.setSelected(false);      
            }

		// Button Image Width		
            if(ProjectManager.get("btnBarImgButtonWidth")!=null)
            {
			if(ProjectManager.get("btnBarImgButtonWidth").equalsIgnoreCase("")==false)
			{
	    		      spinButtonImageWidth.setModel(new SpinnerNumberModel(Integer.valueOf(ProjectManager.get("btnBarImgButtonWidth")),new Integer(0),new Integer(9999),new Integer(1)));
			}
			else
			{
	    		      spinButtonImageWidth.setModel(new SpinnerNumberModel(new Integer(105),new Integer(0),new Integer(9999),new Integer(1)));
			}
            }
		else
		{
	    		spinButtonImageWidth.setModel(new SpinnerNumberModel(new Integer(105),new Integer(0),new Integer(9999),new Integer(1)));
		}  
		editor = spinButtonImageWidth.getEditor();
		field = (JSpinner.NumberEditor)editor;
		field.getTextField().setEditable(false);
		// Button Image Height
            if(ProjectManager.get("btnBarImgButtonHeight")!=null)
            {
			if(ProjectManager.get("btnBarImgButtonHeight").equalsIgnoreCase("")==false)
			{
	    		      spinButtonImageHeight.setModel(new SpinnerNumberModel(Integer.valueOf(ProjectManager.get("btnBarImgButtonHeight")),new Integer(0),new Integer(9999),new Integer(1)));
			}
			else
			{
	    		      spinButtonImageHeight.setModel(new SpinnerNumberModel(new Integer(23),new Integer(0),new Integer(9999),new Integer(1)));
			}
            }
		else
		{
	    		spinButtonImageHeight.setModel(new SpinnerNumberModel(new Integer(23),new Integer(0),new Integer(9999),new Integer(1)));
		}  
		editor = spinButtonImageHeight.getEditor();
		field = (JSpinner.NumberEditor)editor;
		field.getTextField().setEditable(false);
		// Button Bar Height Padding
            if(ProjectManager.get("btnBarHeightPadding")!=null)
            {
			if(ProjectManager.get("btnBarHeightPadding").equalsIgnoreCase("")==false)
			{
	    		      spinButtonBarHeightPadding.setModel(new SpinnerNumberModel(Integer.valueOf(ProjectManager.get("btnBarHeightPadding")),new Integer(0),new Integer(9999),new Integer(1)));
			}
			else
			{
	    		      spinButtonBarHeightPadding.setModel(new SpinnerNumberModel(new Integer(0),new Integer(0),new Integer(9999),new Integer(1)));
			}
            }
		else
		{
	    		spinButtonBarHeightPadding.setModel(new SpinnerNumberModel(new Integer(0),new Integer(0),new Integer(9999),new Integer(1)));
		}  
		editor = spinButtonBarHeightPadding.getEditor();
		field = (JSpinner.NumberEditor)editor;
		field.getTextField().setEditable(false);
// File Locations
	try
	{
if(ProjectManager.get("btnBarImgButtonFace")!=null)
{
	if(ProjectManager.get("btnBarImgButtonFace").equalsIgnoreCase("")==false)
	{
		tfImageButtonPath.setText(new File(new URL(ProjectManager.get("btnBarImgButtonFace")).getFile()).getCanonicalPath());
		tfImageButtonPath.setCaretPosition(0);
	}
	else
	{
		tfImageButtonPath.setText("");
	}
}
else
{
	tfImageButtonPath.setText("");
}
if(ProjectManager.get("btnBarImgButtonFaceOnClick")!=null)
{
	if(ProjectManager.get("btnBarImgButtonFaceOnClick").equalsIgnoreCase("")==false)
	{
		tfImageButtonOnClickPath.setText(new File(new URL(ProjectManager.get("btnBarImgButtonFaceOnClick")).getFile()).getCanonicalPath());
		tfImageButtonOnClickPath.setCaretPosition(0);
	}
	else
	{
		tfImageButtonOnClickPath.setText("");
	}
}
else
{
	tfImageButtonOnClickPath.setText("");
}
if(ProjectManager.get("buttonFaceImageInFocus")!=null)
{
	if(ProjectManager.get("buttonFaceImageInFocus").equalsIgnoreCase("")==false)
	{
		tfImageButtonInFocusPath.setText(new File(new URL(ProjectManager.get("buttonFaceImageInFocus")).getFile()).getCanonicalPath());
		tfImageButtonInFocusPath.setCaretPosition(0);
	}
	else
	{
		tfImageButtonInFocusPath.setText("");
	}
}
else
{
	tfImageButtonInFocusPath.setText("");
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
        ProjectLookAndFeelImages1 = new javax.swing.JPanel();
        ProjectLocationsCenterPanel1 = new javax.swing.JPanel();
        lFiller24 = new javax.swing.JLabel();
        lBuildLocation1 = new javax.swing.JLabel();
        spinProgressBarCellSpacing  = new JSpinner(new SpinnerNumberModel(new Integer(0),new Integer(0),new Integer(9999),new Integer(1)));
        lFiller29 = new javax.swing.JLabel();
        lFiller27 = new javax.swing.JLabel();
        lFiller28 = new javax.swing.JLabel();
        lFiller26 = new javax.swing.JLabel();
        ProjectLookAndFeelImages7 = new javax.swing.JPanel();
        UIChoicesBottomPanel17 = new javax.swing.JPanel();
        UIChoicesBottomPanel18 = new javax.swing.JPanel();
        lFiller70 = new javax.swing.JLabel();
        useDefaultStartWindowPanelHighlightBorderColor = new javax.swing.JCheckBox();
        startWindowPanelHighlightBorderColorChooserButton = new javax.swing.JButton();
        lFiller71 = new javax.swing.JLabel();
        lFiller72 = new javax.swing.JLabel();
        lFiller73 = new javax.swing.JLabel();
        ProjectLookAndFeelImages8 = new javax.swing.JPanel();
        UIChoicesBottomPanel19 = new javax.swing.JPanel();
        UIChoicesBottomPanel20 = new javax.swing.JPanel();
        lFiller74 = new javax.swing.JLabel();
        useDefaultStartWindowPanelShadowBorderColor = new javax.swing.JCheckBox();
        startWindowPanelShadowBorderColorChooserButton = new javax.swing.JButton();
        lFiller75 = new javax.swing.JLabel();
        lFiller76 = new javax.swing.JLabel();
        lFiller77 = new javax.swing.JLabel();
        ProjectLookAndFeelImages = new javax.swing.JPanel();
        ImageDescriptionLabel = new javax.swing.JPanel();
        LeftUIFiller2 = new javax.swing.JLabel();
        useImageButtonsEnabled = new javax.swing.JCheckBox();
        lOverrideDefaultSplashImageWidth2 = new javax.swing.JLabel();
        spinButtonImageWidth = new JSpinner(new SpinnerNumberModel(new Integer(105),new Integer(1),new Integer(9999),new Integer(1)));
        lFiller46 = new javax.swing.JLabel();
        lOverrideDefaultSplashImageHeight2 = new javax.swing.JLabel();
        spinButtonImageHeight = new JSpinner(new SpinnerNumberModel(new Integer(23),new Integer(1),new Integer(9999),new Integer(1)));
        lFiller49 = new javax.swing.JLabel();
        lOverrideDefaultSplashImageWidth3 = new javax.swing.JLabel();
        spinButtonBarHeightPadding = new JSpinner(new SpinnerNumberModel(new Integer(0),new Integer(0),new Integer(9999),new Integer(1)));
        lFiller30 = new javax.swing.JLabel();
        UIChoicesBottomPanel9 = new javax.swing.JPanel();
        ProjectLocationsCenterPanel2 = new javax.swing.JPanel();
        lFiller25 = new javax.swing.JLabel();
        lBuildLocation2 = new javax.swing.JLabel();
        tfImageButtonPath = new javax.swing.JTextField();
        lFiller32 = new javax.swing.JLabel();
        ImageButtonPathChooseButton = new javax.swing.JButton();
        lFiller31 = new javax.swing.JLabel();
        ImageButtonPathDefaultButton = new javax.swing.JButton();
        lFiller33 = new javax.swing.JLabel();
        lFiller34 = new javax.swing.JLabel();
        ProjectLocationsCenterPanel3 = new javax.swing.JPanel();
        lFiller35 = new javax.swing.JLabel();
        lBuildLocation3 = new javax.swing.JLabel();
        tfImageButtonOnClickPath = new javax.swing.JTextField();
        lFiller36 = new javax.swing.JLabel();
        ImageButtonOnClickPathChooseButton = new javax.swing.JButton();
        lFiller37 = new javax.swing.JLabel();
        ImageButtonOnClickPathDefaultButton = new javax.swing.JButton();
        lFiller38 = new javax.swing.JLabel();
        lFiller39 = new javax.swing.JLabel();
        ProjectLocationsCenterPanel5 = new javax.swing.JPanel();
        lFiller40 = new javax.swing.JLabel();
        lBuildLocation4 = new javax.swing.JLabel();
        tfImageButtonInFocusPath = new javax.swing.JTextField();
        lFiller41 = new javax.swing.JLabel();
        ImageButtonInFocusPathChooseButton = new javax.swing.JButton();
        lFiller42 = new javax.swing.JLabel();
        ImageButtonInFocusPathDefaultButton = new javax.swing.JButton();
        lFiller43 = new javax.swing.JLabel();
        lFiller44 = new javax.swing.JLabel();
        ProjectLookAndFeelImages3 = new javax.swing.JPanel();
        ImageDescriptionLabel3 = new javax.swing.JPanel();
        LeftUIFiller5 = new javax.swing.JLabel();
        ProjectLocationsCenterPanel4 = new javax.swing.JPanel();
        lFiller48 = new javax.swing.JLabel();
        PreviewButton = new javax.swing.JButton();
        lFiller45 = new javax.swing.JLabel();
        lFiller47 = new javax.swing.JLabel();
        UIChoicesBottomPanel4 = new javax.swing.JPanel();
        ProjectLookAndFeelOtherButtonBarButtonBackgroundColor = new javax.swing.JPanel();
        ButtonBarButtonBGFiller = new javax.swing.JPanel();
        ButtonBarButtonControls = new javax.swing.JPanel();
        lFiller100 = new javax.swing.JLabel();
        useDefaultButtonBarButtonBackgroundColor = new javax.swing.JCheckBox();
        buttonBarButtonBackgroundColorChooserButton = new javax.swing.JButton();
        lFiller101 = new javax.swing.JLabel();
        lFiller102 = new javax.swing.JLabel();
        lFiller103 = new javax.swing.JLabel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages1.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages1, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages1.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages1.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Progress Bar Cell Spacing", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages1.setMaximumSize(new java.awt.Dimension(32767, 60));
        ProjectLookAndFeelImages1.setMinimumSize(new java.awt.Dimension(10, 60));
        ProjectLookAndFeelImages1.setPreferredSize(new java.awt.Dimension(10, 60));
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
        lBuildLocation1.setText("Progress Bar Cell Spacing:");
        lBuildLocation1.setMaximumSize(new java.awt.Dimension(160, 15));
        lBuildLocation1.setMinimumSize(new java.awt.Dimension(160, 15));
        lBuildLocation1.setPreferredSize(new java.awt.Dimension(160, 15));
        ProjectLocationsCenterPanel1.add(lBuildLocation1);

        spinProgressBarCellSpacing.setMaximumSize(new java.awt.Dimension(45, 20));
        spinProgressBarCellSpacing.setMinimumSize(new java.awt.Dimension(45, 20));
        spinProgressBarCellSpacing.setPreferredSize(new java.awt.Dimension(45, 20));
        ProjectLocationsCenterPanel1.add(spinProgressBarCellSpacing);

        lFiller29.setBackground(new java.awt.Color(140, 160, 210));
        lFiller29.setText("   ");
        lFiller29.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller29.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller29.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel1.add(lFiller29);

        lFiller27.setBackground(new java.awt.Color(140, 160, 210));
        lFiller27.setText("   ");
        lFiller27.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller27.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller27.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel1.add(lFiller27);

        lFiller28.setBackground(new java.awt.Color(140, 160, 210));
        lFiller28.setText("   ");
        lFiller28.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller28.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller28.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel1.add(lFiller28);

        lFiller26.setBackground(new java.awt.Color(140, 160, 210));
        lFiller26.setText("   ");
        lFiller26.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller26.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller26.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel1.add(lFiller26);

        ProjectLookAndFeelImages1.add(ProjectLocationsCenterPanel1);

        add(ProjectLookAndFeelImages1);
        ProjectLookAndFeelOtherButtonBarButtonBackgroundColor.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelOtherButtonBarButtonBackgroundColor, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelOtherButtonBarButtonBackgroundColor.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelOtherButtonBarButtonBackgroundColor.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Button Bar Button Background Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelOtherButtonBarButtonBackgroundColor.setMaximumSize(new java.awt.Dimension(32767, 60));
        ProjectLookAndFeelOtherButtonBarButtonBackgroundColor.setMinimumSize(new java.awt.Dimension(10, 60));
        ProjectLookAndFeelOtherButtonBarButtonBackgroundColor.setPreferredSize(new java.awt.Dimension(10, 60));
        ButtonBarButtonBGFiller.setLayout(new javax.swing.BoxLayout(ButtonBarButtonBGFiller, javax.swing.BoxLayout.X_AXIS));

        ButtonBarButtonBGFiller.setBackground(new java.awt.Color(140, 160, 210));
        ButtonBarButtonBGFiller.setMaximumSize(new java.awt.Dimension(32767, 4));
        ButtonBarButtonBGFiller.setMinimumSize(new java.awt.Dimension(5, 4));
        ButtonBarButtonBGFiller.setPreferredSize(new java.awt.Dimension(200, 4));
        ProjectLookAndFeelOtherButtonBarButtonBackgroundColor.add(ButtonBarButtonBGFiller);

        ButtonBarButtonControls.setLayout(new javax.swing.BoxLayout(ButtonBarButtonControls, javax.swing.BoxLayout.X_AXIS));

        ButtonBarButtonControls.setBackground(new java.awt.Color(140, 160, 210));
        ButtonBarButtonControls.setMaximumSize(new java.awt.Dimension(32767, 20));
        ButtonBarButtonControls.setMinimumSize(new java.awt.Dimension(5, 20));
        ButtonBarButtonControls.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller100.setBackground(new java.awt.Color(140, 160, 210));
        lFiller100.setText("   ");
        lFiller100.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller100.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller100.setPreferredSize(new java.awt.Dimension(10, 16));
        ButtonBarButtonControls.add(lFiller100);

        useDefaultButtonBarButtonBackgroundColor.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultButtonBarButtonBackgroundColor.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultButtonBarButtonBackgroundColor.setSelected(true);
        useDefaultButtonBarButtonBackgroundColor.setText("Use default button bar button background color");
        useDefaultButtonBarButtonBackgroundColor.setMaximumSize(new java.awt.Dimension(380, 23));
        useDefaultButtonBarButtonBackgroundColor.setMinimumSize(new java.awt.Dimension(380, 23));
        useDefaultButtonBarButtonBackgroundColor.setPreferredSize(new java.awt.Dimension(380, 23));
        useDefaultButtonBarButtonBackgroundColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultButtonBarButtonBackgroundColorActionPerformed(evt);
            }
        });

        ButtonBarButtonControls.add(useDefaultButtonBarButtonBackgroundColor);

        buttonBarButtonBackgroundColorChooserButton.setBackground(new java.awt.Color(140, 160, 210));
        buttonBarButtonBackgroundColorChooserButton.setMaximumSize(new java.awt.Dimension(35, 20));
        buttonBarButtonBackgroundColorChooserButton.setMinimumSize(new java.awt.Dimension(35, 20));
        buttonBarButtonBackgroundColorChooserButton.setPreferredSize(new java.awt.Dimension(35, 20));
        buttonBarButtonBackgroundColorChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBarButtonBackgroundColorChooserButtonActionPerformed(evt);
            }
        });

        ButtonBarButtonControls.add(buttonBarButtonBackgroundColorChooserButton);

        lFiller101.setBackground(new java.awt.Color(140, 160, 210));
        lFiller101.setText("   ");
        lFiller101.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller101.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller101.setPreferredSize(new java.awt.Dimension(10, 16));
        ButtonBarButtonControls.add(lFiller101);

        lFiller102.setBackground(new java.awt.Color(140, 160, 210));
        lFiller102.setText("   ");
        lFiller102.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller102.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller102.setPreferredSize(new java.awt.Dimension(10, 15));
        ButtonBarButtonControls.add(lFiller102);

        lFiller103.setBackground(new java.awt.Color(140, 160, 210));
        lFiller103.setText("   ");
        lFiller103.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller103.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller103.setPreferredSize(new java.awt.Dimension(10, 15));
        ButtonBarButtonControls.add(lFiller103);

        ProjectLookAndFeelOtherButtonBarButtonBackgroundColor.add(ButtonBarButtonControls);

        add(ProjectLookAndFeelOtherButtonBarButtonBackgroundColor);


        ProjectLookAndFeelImages7.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages7, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages7.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages7.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Start Window Panel Separator Highlight Border Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages7.setMaximumSize(new java.awt.Dimension(32767, 60));
        ProjectLookAndFeelImages7.setMinimumSize(new java.awt.Dimension(10, 60));
        ProjectLookAndFeelImages7.setPreferredSize(new java.awt.Dimension(10, 60));
        UIChoicesBottomPanel17.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel17, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel17.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel17.setMaximumSize(new java.awt.Dimension(32767, 4));
        UIChoicesBottomPanel17.setMinimumSize(new java.awt.Dimension(5, 4));
        UIChoicesBottomPanel17.setPreferredSize(new java.awt.Dimension(200, 4));
        ProjectLookAndFeelImages7.add(UIChoicesBottomPanel17);

        UIChoicesBottomPanel18.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel18, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel18.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel18.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel18.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel18.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller70.setBackground(new java.awt.Color(140, 160, 210));
        lFiller70.setText("   ");
        lFiller70.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller70.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller70.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel18.add(lFiller70);

        useDefaultStartWindowPanelHighlightBorderColor.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultStartWindowPanelHighlightBorderColor.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultStartWindowPanelHighlightBorderColor.setSelected(true);
        useDefaultStartWindowPanelHighlightBorderColor.setText("Use default start window panel separator highlight border color");
        useDefaultStartWindowPanelHighlightBorderColor.setMaximumSize(new java.awt.Dimension(380, 23));
        useDefaultStartWindowPanelHighlightBorderColor.setMinimumSize(new java.awt.Dimension(380, 23));
        useDefaultStartWindowPanelHighlightBorderColor.setPreferredSize(new java.awt.Dimension(380, 23));
        useDefaultStartWindowPanelHighlightBorderColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultStartWindowPanelHighlightBorderColorActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel18.add(useDefaultStartWindowPanelHighlightBorderColor);

        startWindowPanelHighlightBorderColorChooserButton.setBackground(new java.awt.Color(140, 160, 210));
        startWindowPanelHighlightBorderColorChooserButton.setMaximumSize(new java.awt.Dimension(35, 20));
        startWindowPanelHighlightBorderColorChooserButton.setMinimumSize(new java.awt.Dimension(35, 20));
        startWindowPanelHighlightBorderColorChooserButton.setPreferredSize(new java.awt.Dimension(35, 20));
        startWindowPanelHighlightBorderColorChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startWindowPanelHighlightBorderColorChooserButtonActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel18.add(startWindowPanelHighlightBorderColorChooserButton);

        lFiller71.setBackground(new java.awt.Color(140, 160, 210));
        lFiller71.setText("   ");
        lFiller71.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller71.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller71.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel18.add(lFiller71);

        lFiller72.setBackground(new java.awt.Color(140, 160, 210));
        lFiller72.setText("   ");
        lFiller72.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller72.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller72.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel18.add(lFiller72);

        lFiller73.setBackground(new java.awt.Color(140, 160, 210));
        lFiller73.setText("   ");
        lFiller73.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller73.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller73.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel18.add(lFiller73);

        ProjectLookAndFeelImages7.add(UIChoicesBottomPanel18);

        add(ProjectLookAndFeelImages7);

        ProjectLookAndFeelImages8.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages8, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages8.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages8.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Start Window Panel Separator Shadow Border Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages8.setMaximumSize(new java.awt.Dimension(32767, 60));
        ProjectLookAndFeelImages8.setMinimumSize(new java.awt.Dimension(10, 60));
        ProjectLookAndFeelImages8.setPreferredSize(new java.awt.Dimension(10, 60));
        UIChoicesBottomPanel19.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel19, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel19.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel19.setMaximumSize(new java.awt.Dimension(32767, 4));
        UIChoicesBottomPanel19.setMinimumSize(new java.awt.Dimension(5, 4));
        UIChoicesBottomPanel19.setPreferredSize(new java.awt.Dimension(200, 4));
        ProjectLookAndFeelImages8.add(UIChoicesBottomPanel19);

        UIChoicesBottomPanel20.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel20, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel20.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel20.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel20.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel20.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller74.setBackground(new java.awt.Color(140, 160, 210));
        lFiller74.setText("   ");
        lFiller74.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller74.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller74.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel20.add(lFiller74);

        useDefaultStartWindowPanelShadowBorderColor.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultStartWindowPanelShadowBorderColor.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultStartWindowPanelShadowBorderColor.setSelected(true);
        useDefaultStartWindowPanelShadowBorderColor.setText("Use default start window panel separator shadow border color");
        useDefaultStartWindowPanelShadowBorderColor.setMaximumSize(new java.awt.Dimension(380, 23));
        useDefaultStartWindowPanelShadowBorderColor.setMinimumSize(new java.awt.Dimension(380, 23));
        useDefaultStartWindowPanelShadowBorderColor.setPreferredSize(new java.awt.Dimension(380, 23));
        useDefaultStartWindowPanelShadowBorderColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultStartWindowPanelShadowBorderColorActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel20.add(useDefaultStartWindowPanelShadowBorderColor);

        startWindowPanelShadowBorderColorChooserButton.setBackground(new java.awt.Color(140, 160, 210));
        startWindowPanelShadowBorderColorChooserButton.setMaximumSize(new java.awt.Dimension(35, 20));
        startWindowPanelShadowBorderColorChooserButton.setMinimumSize(new java.awt.Dimension(35, 20));
        startWindowPanelShadowBorderColorChooserButton.setPreferredSize(new java.awt.Dimension(35, 20));
        startWindowPanelShadowBorderColorChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startWindowPanelShadowBorderColorChooserButtonActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel20.add(startWindowPanelShadowBorderColorChooserButton);

        lFiller75.setBackground(new java.awt.Color(140, 160, 210));
        lFiller75.setText("   ");
        lFiller75.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller75.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller75.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel20.add(lFiller75);

        lFiller76.setBackground(new java.awt.Color(140, 160, 210));
        lFiller76.setText("   ");
        lFiller76.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller76.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller76.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel20.add(lFiller76);

        lFiller77.setBackground(new java.awt.Color(140, 160, 210));
        lFiller77.setText("   ");
        lFiller77.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller77.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller77.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel20.add(lFiller77);

        ProjectLookAndFeelImages8.add(UIChoicesBottomPanel20);

        add(ProjectLookAndFeelImages8);

        ProjectLookAndFeelImages.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Image Buttons Configuration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages.setMaximumSize(new java.awt.Dimension(32767, 150));
        ProjectLookAndFeelImages.setMinimumSize(new java.awt.Dimension(10, 145));
        ProjectLookAndFeelImages.setPreferredSize(new java.awt.Dimension(10, 145));
        ImageDescriptionLabel.setLayout(new javax.swing.BoxLayout(ImageDescriptionLabel, javax.swing.BoxLayout.X_AXIS));

        ImageDescriptionLabel.setBackground(new java.awt.Color(140, 160, 210));
        LeftUIFiller2.setMaximumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller2.setMinimumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller2.setPreferredSize(new java.awt.Dimension(10, 10));
        ImageDescriptionLabel.add(LeftUIFiller2);

        useImageButtonsEnabled.setBackground(new java.awt.Color(140, 160, 210));
        useImageButtonsEnabled.setFont(new java.awt.Font("Arial", 0, 12));
        useImageButtonsEnabled.setSelected(true);
        useImageButtonsEnabled.setText("Image Buttons Enabled");
        useImageButtonsEnabled.setMaximumSize(new java.awt.Dimension(165, 15));
        useImageButtonsEnabled.setMinimumSize(new java.awt.Dimension(165, 15));
        useImageButtonsEnabled.setPreferredSize(new java.awt.Dimension(165, 15));
        useImageButtonsEnabled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useImageButtonsEnabledActionPerformed(evt);
            }
        });
        ImageDescriptionLabel.add(useImageButtonsEnabled);

        lOverrideDefaultSplashImageWidth2.setBackground(new java.awt.Color(140, 160, 210));
        lOverrideDefaultSplashImageWidth2.setFont(new java.awt.Font("Arial", 0, 12));
        lOverrideDefaultSplashImageWidth2.setText("Images pixel width:");
        lOverrideDefaultSplashImageWidth2.setMaximumSize(new java.awt.Dimension(115, 15));
        lOverrideDefaultSplashImageWidth2.setMinimumSize(new java.awt.Dimension(115, 15));
        lOverrideDefaultSplashImageWidth2.setPreferredSize(new java.awt.Dimension(115, 15));
        ImageDescriptionLabel.add(lOverrideDefaultSplashImageWidth2);

        spinButtonImageWidth.setMaximumSize(new java.awt.Dimension(40, 20));
        spinButtonImageWidth.setMinimumSize(new java.awt.Dimension(40, 20));
        spinButtonImageWidth.setPreferredSize(new java.awt.Dimension(40, 20));
        ImageDescriptionLabel.add(spinButtonImageWidth);

        lFiller46.setBackground(new java.awt.Color(140, 160, 210));
        lFiller46.setText("   ");
        lFiller46.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller46.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller46.setPreferredSize(new java.awt.Dimension(10, 16));
        ImageDescriptionLabel.add(lFiller46);

        lOverrideDefaultSplashImageHeight2.setBackground(new java.awt.Color(140, 160, 210));
        lOverrideDefaultSplashImageHeight2.setFont(new java.awt.Font("Arial", 0, 12));
        lOverrideDefaultSplashImageHeight2.setText("height:");
        lOverrideDefaultSplashImageHeight2.setMaximumSize(new java.awt.Dimension(45, 15));
        lOverrideDefaultSplashImageHeight2.setMinimumSize(new java.awt.Dimension(45, 15));
        lOverrideDefaultSplashImageHeight2.setPreferredSize(new java.awt.Dimension(45, 15));
        ImageDescriptionLabel.add(lOverrideDefaultSplashImageHeight2);

        spinButtonImageHeight.setMaximumSize(new java.awt.Dimension(40, 20));
        spinButtonImageHeight.setMinimumSize(new java.awt.Dimension(40, 20));
        spinButtonImageHeight.setPreferredSize(new java.awt.Dimension(40, 20));
        ImageDescriptionLabel.add(spinButtonImageHeight);

        lFiller49.setBackground(new java.awt.Color(140, 160, 210));
        lFiller49.setText("   ");
        lFiller49.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller49.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller49.setPreferredSize(new java.awt.Dimension(10, 16));
        ImageDescriptionLabel.add(lFiller49);

        lOverrideDefaultSplashImageWidth3.setBackground(new java.awt.Color(140, 160, 210));
        lOverrideDefaultSplashImageWidth3.setFont(new java.awt.Font("Arial", 0, 12));
        lOverrideDefaultSplashImageWidth3.setText("Button bar height pad:");
        lOverrideDefaultSplashImageWidth3.setMaximumSize(new java.awt.Dimension(132, 15));
        lOverrideDefaultSplashImageWidth3.setMinimumSize(new java.awt.Dimension(132, 15));
        lOverrideDefaultSplashImageWidth3.setPreferredSize(new java.awt.Dimension(132, 15));
        ImageDescriptionLabel.add(lOverrideDefaultSplashImageWidth3);

        spinButtonBarHeightPadding.setMaximumSize(new java.awt.Dimension(40, 20));
        spinButtonBarHeightPadding.setMinimumSize(new java.awt.Dimension(40, 20));
        spinButtonBarHeightPadding.setPreferredSize(new java.awt.Dimension(40, 20));
        ImageDescriptionLabel.add(spinButtonBarHeightPadding);

        lFiller30.setBackground(new java.awt.Color(140, 160, 210));
        lFiller30.setText("   ");
        lFiller30.setMaximumSize(new java.awt.Dimension(32767, 16));
        lFiller30.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller30.setPreferredSize(new java.awt.Dimension(10, 16));
        ImageDescriptionLabel.add(lFiller30);

        ProjectLookAndFeelImages.add(ImageDescriptionLabel);

        UIChoicesBottomPanel9.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel9, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel9.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel9.setMaximumSize(new java.awt.Dimension(32767, 4));
        UIChoicesBottomPanel9.setMinimumSize(new java.awt.Dimension(5, 4));
        UIChoicesBottomPanel9.setPreferredSize(new java.awt.Dimension(200, 4));
        ProjectLookAndFeelImages.add(UIChoicesBottomPanel9);

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
        lBuildLocation2.setText("Image Button File:");
        lBuildLocation2.setMaximumSize(new java.awt.Dimension(160, 15));
        lBuildLocation2.setMinimumSize(new java.awt.Dimension(160, 15));
        lBuildLocation2.setPreferredSize(new java.awt.Dimension(160, 15));
        ProjectLocationsCenterPanel2.add(lBuildLocation2);

        tfImageButtonPath.setBackground(new java.awt.Color(204, 204, 204));
        tfImageButtonPath.setFont(new java.awt.Font("Arial", 0, 12));
        tfImageButtonPath.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfImageButtonPath.setText("C:\\....");
        tfImageButtonPath.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfImageButtonPath.setMinimumSize(new java.awt.Dimension(250, 20));
        tfImageButtonPath.setPreferredSize(new java.awt.Dimension(350, 20));
        ProjectLocationsCenterPanel2.add(tfImageButtonPath);

        lFiller32.setBackground(new java.awt.Color(140, 160, 210));
        lFiller32.setText("   ");
        lFiller32.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller32.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller32.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel2.add(lFiller32);

        ImageButtonPathChooseButton.setFont(new java.awt.Font("Arial", 0, 12));
        ImageButtonPathChooseButton.setText("Choose...");
        ImageButtonPathChooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageButtonPathChooseButtonActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel2.add(ImageButtonPathChooseButton);

        lFiller31.setBackground(new java.awt.Color(140, 160, 210));
        lFiller31.setText("   ");
        lFiller31.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller31.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller31.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel2.add(lFiller31);

        ImageButtonPathDefaultButton.setFont(new java.awt.Font("Arial", 0, 12));
        ImageButtonPathDefaultButton.setText("Default");
        ImageButtonPathDefaultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageButtonPathDefaultButtonActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel2.add(ImageButtonPathDefaultButton);

        lFiller33.setBackground(new java.awt.Color(140, 160, 210));
        lFiller33.setText("   ");
        lFiller33.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller33.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller33.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel2.add(lFiller33);

        lFiller34.setBackground(new java.awt.Color(140, 160, 210));
        lFiller34.setText("   ");
        lFiller34.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller34.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller34.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel2.add(lFiller34);

        ProjectLookAndFeelImages.add(ProjectLocationsCenterPanel2);

        ProjectLocationsCenterPanel3.setLayout(new javax.swing.BoxLayout(ProjectLocationsCenterPanel3, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsCenterPanel3.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsCenterPanel3.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectLocationsCenterPanel3.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectLocationsCenterPanel3.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller35.setBackground(new java.awt.Color(140, 160, 210));
        lFiller35.setText("   ");
        lFiller35.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller35.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller35.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel3.add(lFiller35);

        lBuildLocation3.setBackground(new java.awt.Color(140, 160, 210));
        lBuildLocation3.setFont(new java.awt.Font("Arial", 0, 12));
        lBuildLocation3.setText("Image Button On Click File:");
        lBuildLocation3.setMaximumSize(new java.awt.Dimension(160, 15));
        lBuildLocation3.setMinimumSize(new java.awt.Dimension(160, 15));
        lBuildLocation3.setPreferredSize(new java.awt.Dimension(160, 15));
        ProjectLocationsCenterPanel3.add(lBuildLocation3);
        lBuildLocation3.getAccessibleContext().setAccessibleName("Image Button On Click File:");

        tfImageButtonOnClickPath.setBackground(new java.awt.Color(204, 204, 204));
        tfImageButtonOnClickPath.setFont(new java.awt.Font("Arial", 0, 12));
        tfImageButtonOnClickPath.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfImageButtonOnClickPath.setText("C:\\....");
        tfImageButtonOnClickPath.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfImageButtonOnClickPath.setMinimumSize(new java.awt.Dimension(250, 20));
        tfImageButtonOnClickPath.setPreferredSize(new java.awt.Dimension(350, 20));
        ProjectLocationsCenterPanel3.add(tfImageButtonOnClickPath);

        lFiller36.setBackground(new java.awt.Color(140, 160, 210));
        lFiller36.setText("   ");
        lFiller36.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller36.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller36.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel3.add(lFiller36);

        ImageButtonOnClickPathChooseButton.setFont(new java.awt.Font("Arial", 0, 12));
        ImageButtonOnClickPathChooseButton.setText("Choose...");
        ImageButtonOnClickPathChooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageButtonOnClickPathChooseButtonActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel3.add(ImageButtonOnClickPathChooseButton);

        lFiller37.setBackground(new java.awt.Color(140, 160, 210));
        lFiller37.setText("   ");
        lFiller37.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller37.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller37.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel3.add(lFiller37);

        ImageButtonOnClickPathDefaultButton.setFont(new java.awt.Font("Arial", 0, 12));
        ImageButtonOnClickPathDefaultButton.setText("Default");
        ImageButtonOnClickPathDefaultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageButtonOnClickPathDefaultButtonActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel3.add(ImageButtonOnClickPathDefaultButton);

        lFiller38.setBackground(new java.awt.Color(140, 160, 210));
        lFiller38.setText("   ");
        lFiller38.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller38.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller38.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel3.add(lFiller38);

        lFiller39.setBackground(new java.awt.Color(140, 160, 210));
        lFiller39.setText("   ");
        lFiller39.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller39.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller39.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel3.add(lFiller39);

        ProjectLookAndFeelImages.add(ProjectLocationsCenterPanel3);

        ProjectLocationsCenterPanel5.setLayout(new javax.swing.BoxLayout(ProjectLocationsCenterPanel5, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsCenterPanel5.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsCenterPanel5.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectLocationsCenterPanel5.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectLocationsCenterPanel5.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller40.setBackground(new java.awt.Color(140, 160, 210));
        lFiller40.setText("   ");
        lFiller40.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller40.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller40.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel5.add(lFiller40);

        lBuildLocation4.setBackground(new java.awt.Color(140, 160, 210));
        lBuildLocation4.setFont(new java.awt.Font("Arial", 0, 12));
        lBuildLocation4.setText("Image Button In Focus File:");
        lBuildLocation4.setMaximumSize(new java.awt.Dimension(160, 15));
        lBuildLocation4.setMinimumSize(new java.awt.Dimension(160, 15));
        lBuildLocation4.setPreferredSize(new java.awt.Dimension(160, 15));
        ProjectLocationsCenterPanel5.add(lBuildLocation4);

        tfImageButtonInFocusPath.setBackground(new java.awt.Color(204, 204, 204));
        tfImageButtonInFocusPath.setFont(new java.awt.Font("Arial", 0, 12));
        tfImageButtonInFocusPath.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfImageButtonInFocusPath.setText("C:\\....");
        tfImageButtonInFocusPath.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfImageButtonInFocusPath.setMinimumSize(new java.awt.Dimension(250, 20));
        tfImageButtonInFocusPath.setPreferredSize(new java.awt.Dimension(450, 20));
        ProjectLocationsCenterPanel5.add(tfImageButtonInFocusPath);

        lFiller41.setBackground(new java.awt.Color(140, 160, 210));
        lFiller41.setText("   ");
        lFiller41.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller41.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller41.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel5.add(lFiller41);

        ImageButtonInFocusPathChooseButton.setFont(new java.awt.Font("Arial", 0, 12));
        ImageButtonInFocusPathChooseButton.setText("Choose...");
        ImageButtonInFocusPathChooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageButtonInFocusPathChooseButtonActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel5.add(ImageButtonInFocusPathChooseButton);

        lFiller42.setBackground(new java.awt.Color(140, 160, 210));
        lFiller42.setText("   ");
        lFiller42.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller42.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller42.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel5.add(lFiller42);

        ImageButtonInFocusPathDefaultButton.setFont(new java.awt.Font("Arial", 0, 12));
        ImageButtonInFocusPathDefaultButton.setText("Default");
        ImageButtonInFocusPathDefaultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageButtonInFocusPathDefaultButtonActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel5.add(ImageButtonInFocusPathDefaultButton);

        lFiller43.setBackground(new java.awt.Color(140, 160, 210));
        lFiller43.setText("   ");
        lFiller43.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller43.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller43.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel5.add(lFiller43);

        lFiller44.setBackground(new java.awt.Color(140, 160, 210));
        lFiller44.setText("   ");
        lFiller44.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller44.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller44.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel5.add(lFiller44);

        ProjectLookAndFeelImages.add(ProjectLocationsCenterPanel5);

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

    private void ImageButtonInFocusPathDefaultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonInFocusPathDefaultButtonActionPerformed
		try
		{
             	ProjectManager.put("buttonFaceImageInFocus", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/images/btnfocus.png").toString());
			tfImageButtonInFocusPath.setText(new File(new URL(ProjectManager.get("buttonFaceImageInFocus")).getFile()).getCanonicalPath());
			tfImageButtonInFocusPath.setCaretPosition(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }//GEN-LAST:event_ImageButtonInFocusPathDefaultButtonActionPerformed

    private void ImageButtonOnClickPathDefaultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonOnClickPathDefaultButtonActionPerformed
		try
		{
             	ProjectManager.put("btnBarImgButtonFaceOnClick", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/images/btnclick.png").toString());
			tfImageButtonOnClickPath.setText(new File(new URL(ProjectManager.get("btnBarImgButtonFaceOnClick")).getFile()).getCanonicalPath());
			tfImageButtonOnClickPath.setCaretPosition(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }//GEN-LAST:event_ImageButtonOnClickPathDefaultButtonActionPerformed

    private void ImageButtonPathDefaultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonPathDefaultButtonActionPerformed
		try
		{
             	ProjectManager.put("btnBarImgButtonFace", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/images/btn.png").toString());
			tfImageButtonPath.setText(new File(new URL(ProjectManager.get("btnBarImgButtonFace")).getFile()).getCanonicalPath());
			tfImageButtonPath.setCaretPosition(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }//GEN-LAST:event_ImageButtonPathDefaultButtonActionPerformed

    private void ImageButtonInFocusPathChooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonInFocusPathChooseButtonActionPerformed
	try
	{
		int result = imageFileChooser.showOpenDialog(this); 
        	if(result == JFileChooser.APPROVE_OPTION) 
        	{ 
             	ProjectManager.put("buttonFaceImageInFocus", imageFileChooser.getSelectedFile().toURL().toString());
			tfImageButtonInFocusPath.setText(new File(new URL(ProjectManager.get("buttonFaceImageInFocus")).getFile()).getCanonicalPath());
			tfImageButtonInFocusPath.setCaretPosition(0);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_ImageButtonInFocusPathChooseButtonActionPerformed

    private void ImageButtonOnClickPathChooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonOnClickPathChooseButtonActionPerformed
	try
	{
		int result = imageFileChooser.showOpenDialog(this); 
        	if(result == JFileChooser.APPROVE_OPTION) 
        	{ 
             	ProjectManager.put("btnBarImgButtonFaceOnClick", imageFileChooser.getSelectedFile().toURL().toString());
			tfImageButtonOnClickPath.setText(new File(new URL(ProjectManager.get("btnBarImgButtonFaceOnClick")).getFile()).getCanonicalPath());
			tfImageButtonOnClickPath.setCaretPosition(0);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_ImageButtonOnClickPathChooseButtonActionPerformed

    private void ImageButtonPathChooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonPathChooseButtonActionPerformed
	try
	{
		int result = imageFileChooser.showOpenDialog(this); 
        	if(result == JFileChooser.APPROVE_OPTION) 
        	{ 
             	ProjectManager.put("btnBarImgButtonFace", imageFileChooser.getSelectedFile().toURL().toString());
			tfImageButtonPath.setText(new File(new URL(ProjectManager.get("btnBarImgButtonFace")).getFile()).getCanonicalPath());
			tfImageButtonPath.setCaretPosition(0);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_ImageButtonPathChooseButtonActionPerformed

    private void startWindowPanelShadowBorderColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startWindowPanelShadowBorderColorChooserButtonActionPerformed
 	// Bring up a color chooser 
        if(ProjectManager.get("startWindowPanelSeparatorShadowBorderColor")!=null)
        {
            if(ProjectManager.get("startWindowPanelSeparatorShadowBorderColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("startWindowPanelSeparatorShadowBorderColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("startWindowPanelSeparatorShadowBorderColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                startWindowPanelShadowBorderColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("startWindowPanelSeparatorShadowBorderColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                startWindowPanelShadowBorderColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("startWindowPanelSeparatorShadowBorderColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                startWindowPanelShadowBorderColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_startWindowPanelShadowBorderColorChooserButtonActionPerformed

    private void useDefaultStartWindowPanelShadowBorderColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultStartWindowPanelShadowBorderColorActionPerformed
        try
        {
            if(useDefaultStartWindowPanelShadowBorderColor.isSelected()==true)
            {
                ProjectManager.put("startWindowPanelSeparatorShadowBorderColor", "");
                ProjectManager.remove("startWindowPanelSeparatorShadowBorderColor");                
                startWindowPanelShadowBorderColorChooserButton.setVisible(false);                      
            }
            else
            {
                startWindowPanelShadowBorderColorChooserButton.setVisible(true);  
                updateShadowBorderColorSwatch();            
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_useDefaultStartWindowPanelShadowBorderColorActionPerformed

    private void startWindowPanelHighlightBorderColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startWindowPanelHighlightBorderColorChooserButtonActionPerformed
 	// Bring up a color chooser 
        if(ProjectManager.get("startWindowPanelSeparatorHighlightBorderColor")!=null)
        {
            if(ProjectManager.get("startWindowPanelSeparatorHighlightBorderColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("startWindowPanelSeparatorHighlightBorderColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("startWindowPanelSeparatorHighlightBorderColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                startWindowPanelHighlightBorderColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("startWindowPanelSeparatorHighlightBorderColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                startWindowPanelHighlightBorderColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("startWindowPanelSeparatorHighlightBorderColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                startWindowPanelHighlightBorderColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_startWindowPanelHighlightBorderColorChooserButtonActionPerformed

    private void useDefaultStartWindowPanelHighlightBorderColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultStartWindowPanelHighlightBorderColorActionPerformed
        try
        {
            if(useDefaultStartWindowPanelHighlightBorderColor.isSelected()==true)
            {
                ProjectManager.put("startWindowPanelSeparatorHighlightBorderColor", "");
                ProjectManager.remove("startWindowPanelSeparatorHighlightBorderColor");                
                startWindowPanelHighlightBorderColorChooserButton.setVisible(false);                      
            }
            else
            {
                startWindowPanelHighlightBorderColorChooserButton.setVisible(true);  
                updateHighlightBorderColorSwatch();            
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_useDefaultStartWindowPanelHighlightBorderColorActionPerformed
///
    private void buttonBarButtonBackgroundColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {
 	// Bring up a color chooser 
        if(ProjectManager.get("btnBarButtonBGColor")!=null)
        {
            if(ProjectManager.get("btnBarButtonBGColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("btnBarButtonBGColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("btnBarButtonBGColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                buttonBarButtonBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("btnBarButtonBGColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                buttonBarButtonBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("btnBarButtonBGColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                buttonBarButtonBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }

    private void useDefaultButtonBarButtonBackgroundColorActionPerformed(java.awt.event.ActionEvent evt) {
        try
        {
            if(useDefaultButtonBarButtonBackgroundColor.isSelected()==true)
            {
                ProjectManager.put("btnBarButtonBGColor", "");
                ProjectManager.remove("btnBarButtonBGColor");                
                buttonBarButtonBackgroundColorChooserButton.setVisible(false);                      
            }
            else
            {
                buttonBarButtonBackgroundColorChooserButton.setVisible(true);  
                updateButtonBarButtonBackgroundColorSwatch();            
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
///

    private void useImageButtonsEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useImageButtonsEnabledActionPerformed
    }//GEN-LAST:event_useImageButtonsEnabledActionPerformed

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
		((EAPanel)getParentComponent()).getDataUpdate();
		new StartVerticalButtonBarThemeAction();	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_PreviewButtonActionPerformed
 
   
    private void updateHighlightBorderColorSwatch()
    {
        try
        { 
            Color c = startWindowPanelHighlightBorderColorChooserButton.getBackground(); 
            // Bring up a color chooser 
            if(ProjectManager.get("startWindowPanelSeparatorHighlightBorderColor")!=null)
            {
                if(ProjectManager.get("startWindowPanelSeparatorHighlightBorderColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("startWindowPanelSeparatorHighlightBorderColor"));
                    c = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()); 
                    startWindowPanelHighlightBorderColorChooserButton.setIcon(new ColorSwatch(c));
                }
                else
                {
                    startWindowPanelHighlightBorderColorChooserButton.setIcon(noColorIcon);
                }
            }
            else
            {
                startWindowPanelHighlightBorderColorChooserButton.setIcon(noColorIcon);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }    
 
    private void updateShadowBorderColorSwatch()
    {
        try
        { 
            Color c = startWindowPanelShadowBorderColorChooserButton.getBackground(); 
            // Bring up a color chooser 
            if(ProjectManager.get("startWindowPanelSeparatorShadowBorderColor")!=null)
            {
                if(ProjectManager.get("startWindowPanelSeparatorShadowBorderColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("startWindowPanelSeparatorShadowBorderColor"));
                    c = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()); 
                    startWindowPanelShadowBorderColorChooserButton.setIcon(new ColorSwatch(c));
                }
                else
                {
                    startWindowPanelShadowBorderColorChooserButton.setIcon(noColorIcon);
                }
            }
            else
            {
                startWindowPanelShadowBorderColorChooserButton.setIcon(noColorIcon);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }    

    private void updateButtonBarButtonBackgroundColorSwatch()
    {
        try
        { 
            Color c = buttonBarButtonBackgroundColorChooserButton.getBackground(); 
            // Bring up a color chooser 
            if(ProjectManager.get("btnBarButtonBGColor")!=null)
            {
                if(ProjectManager.get("btnBarButtonBGColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("btnBarButtonBGColor"));
                    c = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()); 
                    buttonBarButtonBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
                }
                else
                {
                    buttonBarButtonBackgroundColorChooserButton.setIcon(noColorIcon);
                }
            }
            else
            {
                buttonBarButtonBackgroundColorChooserButton.setIcon(noColorIcon);
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
    private javax.swing.JButton ImageButtonInFocusPathChooseButton;
    private javax.swing.JButton ImageButtonInFocusPathDefaultButton;
    private javax.swing.JButton ImageButtonOnClickPathChooseButton;
    private javax.swing.JButton ImageButtonOnClickPathDefaultButton;
    private javax.swing.JButton ImageButtonPathChooseButton;
    private javax.swing.JButton ImageButtonPathDefaultButton;
    private javax.swing.JPanel ImageDescriptionLabel;
    private javax.swing.JPanel ImageDescriptionLabel3;
    private javax.swing.JLabel LeftUIFiller2;
    private javax.swing.JLabel LeftUIFiller5;
    private javax.swing.JButton PreviewButton;
    private javax.swing.JPanel ProjectLocationsCenterPanel1;
    private javax.swing.JPanel ProjectLocationsCenterPanel2;
    private javax.swing.JPanel ProjectLocationsCenterPanel3;
    private javax.swing.JPanel ProjectLocationsCenterPanel4;
    private javax.swing.JPanel ProjectLocationsCenterPanel5;
    private javax.swing.JPanel ProjectLookAndFeelImages;
    private javax.swing.JPanel ProjectLookAndFeelImages1;
    private javax.swing.JPanel ProjectLookAndFeelImages3;
    private javax.swing.JPanel ProjectLookAndFeelImages7;
    private javax.swing.JPanel ProjectLookAndFeelImages8;
    private javax.swing.JPanel UIChoicesBottomPanel17;
    private javax.swing.JPanel UIChoicesBottomPanel18;
    private javax.swing.JPanel UIChoicesBottomPanel19;
    private javax.swing.JPanel UIChoicesBottomPanel20;
    private javax.swing.JPanel UIChoicesBottomPanel4;
    private javax.swing.JPanel UIChoicesBottomPanel9;
    private javax.swing.JLabel lBuildLocation1;
    private javax.swing.JLabel lBuildLocation2;
    private javax.swing.JLabel lBuildLocation3;
    private javax.swing.JLabel lBuildLocation4;
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
    private javax.swing.JLabel lFiller34;
    private javax.swing.JLabel lFiller35;
    private javax.swing.JLabel lFiller36;
    private javax.swing.JLabel lFiller37;
    private javax.swing.JLabel lFiller38;
    private javax.swing.JLabel lFiller39;
    private javax.swing.JLabel lFiller40;
    private javax.swing.JLabel lFiller41;
    private javax.swing.JLabel lFiller42;
    private javax.swing.JLabel lFiller43;
    private javax.swing.JLabel lFiller44;
    private javax.swing.JLabel lFiller45;
    private javax.swing.JLabel lFiller46;
    private javax.swing.JLabel lFiller47;
    private javax.swing.JLabel lFiller48;
    private javax.swing.JLabel lFiller49;
    private javax.swing.JLabel lFiller70;
    private javax.swing.JLabel lFiller71;
    private javax.swing.JLabel lFiller72;
    private javax.swing.JLabel lFiller73;
    private javax.swing.JLabel lFiller74;
    private javax.swing.JLabel lFiller75;
    private javax.swing.JLabel lFiller76;
    private javax.swing.JLabel lFiller77;
    private javax.swing.JLabel lOverrideDefaultSplashImageHeight2;
    private javax.swing.JLabel lOverrideDefaultSplashImageWidth2;
    private javax.swing.JLabel lOverrideDefaultSplashImageWidth3;
    private javax.swing.JSpinner spinButtonBarHeightPadding;
    private javax.swing.JSpinner spinButtonImageHeight;
    private javax.swing.JSpinner spinButtonImageWidth;
    private javax.swing.JSpinner spinProgressBarCellSpacing;
    private javax.swing.JButton startWindowPanelHighlightBorderColorChooserButton;
    private javax.swing.JButton startWindowPanelShadowBorderColorChooserButton;
    private javax.swing.JTextField tfImageButtonInFocusPath;
    private javax.swing.JTextField tfImageButtonOnClickPath;
    private javax.swing.JTextField tfImageButtonPath;
    private javax.swing.JCheckBox useDefaultStartWindowPanelHighlightBorderColor;
    private javax.swing.JCheckBox useDefaultStartWindowPanelShadowBorderColor;
    private javax.swing.JCheckBox useImageButtonsEnabled;
    private javax.swing.JPanel ButtonBarButtonBGFiller;
    private javax.swing.JPanel ButtonBarButtonControls;
    private javax.swing.JPanel ProjectLookAndFeelOtherButtonBarButtonBackgroundColor;
    private javax.swing.JButton buttonBarButtonBackgroundColorChooserButton;
    private javax.swing.JLabel lFiller100;
    private javax.swing.JLabel lFiller101;
    private javax.swing.JLabel lFiller102;
    private javax.swing.JLabel lFiller103;
    private javax.swing.JCheckBox useDefaultButtonBarButtonBackgroundColor;
    // End of variables declaration//GEN-END:variables
    
}
