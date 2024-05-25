/*
 * ImagesPanel.java
 *
 * Created on June 13, 2004, 3:24 PM
 */

package com.trinity.ea.design.project.lookandfeel.other;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.common.filechooser.ImageFileFilter;
import com.trinity.ea.design.project.lookandfeel.preview.actions.StartVerticalButtonBarThemeAction;
import com.trinity.ea.design.registration.actions.EnterRegistrationCodeAction;
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
public class OtherPanel extends EAPanel {
    ImageFileFilter filter = new ImageFileFilter(new String[] {"gif", "jpg", "jpeg", "png"}, "Select an image file");   
    JFileChooser imageFileChooser = new JFileChooser();
    private ImageIcon noColorIcon = new ImageIcon(getClass().getResource("/images/nocolor.png"));
    /** Creates new form ImagesPanel */
    public OtherPanel() 
    {
	  
        initComponents();
        updateHighlightBorderColorSwatch();
        updateShadowBorderColorSwatch();
	  updateButtonBarButtonBackgroundColorSwatch();
  
          updateButtonBarTextColorSwatch();
        updateButtonBarBackgroundColorSwatch();
        updateProgressPanelTextColorSwatch();
        updateProgressPanelLeftBorderColorSwatch();
        updateProgressBarFillColorSwatch();
        
        setProjectData();
    }

    public synchronized void getDataUpdate()
    {
	try
        {
		// Progress Bar Spacing Width in Pixels
            SpinnerNumberModel progressBarSpacingWidth = (SpinnerNumberModel)spinProgressBarCellSpacing.getModel();
            ProjectManager.putTempNoFileWrite("progressBarCellSpacing", String.valueOf(progressBarSpacingWidth.getNumber().intValue()));            
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
             if(ProjectManager.get("registrationCustomBorderEnabled")!=null)
             {
                    if(ProjectManager.get("registrationCustomBorderEnabled").equalsIgnoreCase("true")==true)
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

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
          try
        {
            if(ProjectManager.get("registrationTFExtBorderColor")!=null)
            {
                if(ProjectManager.get("registrationTFExtBorderColor").equalsIgnoreCase("")==false)
                {
                    useDefaultButtonBarTextColor.setSelected(false);
                    buttonBarTextColorChooserButton.setVisible(true); 
                }
                else
                {
                    useDefaultButtonBarTextColor.setSelected(true);
                    buttonBarTextColorChooserButton.setVisible(false);                    
                }
            }
            else
            {
                useDefaultButtonBarTextColor.setSelected(true);
                buttonBarTextColorChooserButton.setVisible(false);                
            }
            
            
            if(ProjectManager.get("registrationTFHighlightBorderColor1")!=null)
            {
                if(ProjectManager.get("registrationTFHighlightBorderColor1").equalsIgnoreCase("")==false)
                {
                    useDefaultButtonBarBackgroundColor.setSelected(false);
                    ButtonBarBackgroundColorChooserButton.setVisible(true); 
                }
                else
                {
                    useDefaultButtonBarBackgroundColor.setSelected(true);
                    ButtonBarBackgroundColorChooserButton.setVisible(false);                    
                }
            }
            else
            {
                useDefaultButtonBarBackgroundColor.setSelected(true);
                ButtonBarBackgroundColorChooserButton.setVisible(false);                
            }         
            
            
            if(ProjectManager.get("registrationTFHighlightBorderColor2")!=null)
            {
                if(ProjectManager.get("registrationTFHighlightBorderColor2").equalsIgnoreCase("")==false)
                {
                    useDefaultProgressPanelTextColor.setSelected(false);
                    progressPanelTextColorChooserButton.setVisible(true); 
                }
                else
                {
                    useDefaultProgressPanelTextColor.setSelected(true);
                    progressPanelTextColorChooserButton.setVisible(false);                    
                }
            }
            else
            {
                useDefaultProgressPanelTextColor.setSelected(true);
                progressPanelTextColorChooserButton.setVisible(false);                
            }      
            
            
             if(ProjectManager.get("registrationTFShadowBorderColor1")!=null)
            {
                if(ProjectManager.get("registrationTFShadowBorderColor1").equalsIgnoreCase("")==false)
                {
                    useDefaultProgressPanelLeftBorderColor.setSelected(false);
                    progressPanelLeftBorderColorChooserButton.setVisible(true); 
                }
                else
                {
                    useDefaultProgressPanelLeftBorderColor.setSelected(true);
                    progressPanelLeftBorderColorChooserButton.setVisible(false);                    
                }
            }
            else
            {
                useDefaultProgressPanelLeftBorderColor.setSelected(true);
                progressPanelLeftBorderColorChooserButton.setVisible(false);                
            }             
            
            
            if(ProjectManager.get("registrationTFShadowBorderColor2")!=null)
            {
                if(ProjectManager.get("registrationTFShadowBorderColor2").equalsIgnoreCase("")==false)
                {
                    useDefaultProgressBarFillColor.setSelected(false);
                    progressBarFillColorChooserButton.setVisible(true); 
                }
                else
                {
                    useDefaultProgressBarFillColor.setSelected(true);
                    progressBarFillColorChooserButton.setVisible(false);                    
                }
            }
            else
            {
                useDefaultProgressBarFillColor.setSelected(true);
                progressBarFillColorChooserButton.setVisible(false);                
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
    private void initComponents() {//GEN-BEGIN:initComponents
        ProjectLookAndFeelImages1 = new javax.swing.JPanel();
        ProjectLocationsCenterPanel1 = new javax.swing.JPanel();
        lFiller24 = new javax.swing.JLabel();
        lBuildLocation1 = new javax.swing.JLabel();
        spinProgressBarCellSpacing = new javax.swing.JSpinner();
        lFiller29 = new javax.swing.JLabel();
        lFiller27 = new javax.swing.JLabel();
        lFiller28 = new javax.swing.JLabel();
        lFiller26 = new javax.swing.JLabel();
        ProjectLookAndFeelImages9 = new javax.swing.JPanel();
        UIChoicesBottomPanel21 = new javax.swing.JPanel();
        UIChoicesBottomPanel22 = new javax.swing.JPanel();
        lFiller78 = new javax.swing.JLabel();
        useDefaultButtonBarButtonBackgroundColor = new javax.swing.JCheckBox();
        buttonBarButtonBackgroundColorChooserButton = new javax.swing.JButton();
        lFiller79 = new javax.swing.JLabel();
        lFiller80 = new javax.swing.JLabel();
        lFiller81 = new javax.swing.JLabel();
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
        lFiller30 = new javax.swing.JLabel();
        UIChoicesBottomPanel9 = new javax.swing.JPanel();
        UIChoicesBottomPanel5 = new javax.swing.JPanel();
        lFiller43 = new javax.swing.JLabel();
        useDefaultButtonBarTextColor = new javax.swing.JCheckBox();
        buttonBarTextColorChooserButton = new javax.swing.JButton();
        lFiller44 = new javax.swing.JLabel();
        lFiller57 = new javax.swing.JLabel();
        lFiller49 = new javax.swing.JLabel();
        UIChoicesBottomPanel8 = new javax.swing.JPanel();
        UIChoicesBottomPanel6 = new javax.swing.JPanel();
        lFiller46 = new javax.swing.JLabel();
        useDefaultButtonBarBackgroundColor = new javax.swing.JCheckBox();
        ButtonBarBackgroundColorChooserButton = new javax.swing.JButton();
        lFiller58 = new javax.swing.JLabel();
        lFiller50 = new javax.swing.JLabel();
        lFiller51 = new javax.swing.JLabel();
        UIChoicesBottomPanel10 = new javax.swing.JPanel();
        UIChoicesBottomPanel11 = new javax.swing.JPanel();
        lFiller52 = new javax.swing.JLabel();
        useDefaultProgressPanelTextColor = new javax.swing.JCheckBox();
        progressPanelTextColorChooserButton = new javax.swing.JButton();
        lFiller53 = new javax.swing.JLabel();
        lFiller59 = new javax.swing.JLabel();
        lFiller54 = new javax.swing.JLabel();
        UIChoicesBottomPanel12 = new javax.swing.JPanel();
        UIChoicesBottomPanel13 = new javax.swing.JPanel();
        lFiller55 = new javax.swing.JLabel();
        useDefaultProgressPanelLeftBorderColor = new javax.swing.JCheckBox();
        progressPanelLeftBorderColorChooserButton = new javax.swing.JButton();
        lFiller56 = new javax.swing.JLabel();
        lFiller60 = new javax.swing.JLabel();
        lFiller61 = new javax.swing.JLabel();
        UIChoicesBottomPanel14 = new javax.swing.JPanel();
        UIChoicesBottomPanel15 = new javax.swing.JPanel();
        lFiller62 = new javax.swing.JLabel();
        useDefaultProgressBarFillColor = new javax.swing.JCheckBox();
        progressBarFillColorChooserButton = new javax.swing.JButton();
        lFiller63 = new javax.swing.JLabel();
        lFiller64 = new javax.swing.JLabel();
        lFiller65 = new javax.swing.JLabel();
        UIChoicesBottomPanel16 = new javax.swing.JPanel();
        ProjectLookAndFeelImages4 = new javax.swing.JPanel();
        ProjectLocationsCenterPanel5 = new javax.swing.JPanel();
        lFiller82 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rbPaymentPreview = new javax.swing.JRadioButton();
        rbPaymentSuccessPreview = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        PreviewButton = new javax.swing.JButton();
        lFiller83 = new javax.swing.JLabel();
        UIChoicesBottomPanel7 = new javax.swing.JPanel();

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

        ProjectLookAndFeelImages9.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages9, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages9.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages9.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Startup Window Button Color (does not apply to image buttons)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages9.setMaximumSize(new java.awt.Dimension(32767, 60));
        ProjectLookAndFeelImages9.setMinimumSize(new java.awt.Dimension(10, 60));
        ProjectLookAndFeelImages9.setPreferredSize(new java.awt.Dimension(10, 60));
        UIChoicesBottomPanel21.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel21, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel21.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel21.setMaximumSize(new java.awt.Dimension(32767, 4));
        UIChoicesBottomPanel21.setMinimumSize(new java.awt.Dimension(5, 4));
        UIChoicesBottomPanel21.setPreferredSize(new java.awt.Dimension(200, 4));
        ProjectLookAndFeelImages9.add(UIChoicesBottomPanel21);

        UIChoicesBottomPanel22.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel22, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel22.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel22.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel22.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel22.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller78.setBackground(new java.awt.Color(140, 160, 210));
        lFiller78.setText("   ");
        lFiller78.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller78.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller78.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel22.add(lFiller78);

        useDefaultButtonBarButtonBackgroundColor.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultButtonBarButtonBackgroundColor.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultButtonBarButtonBackgroundColor.setSelected(true);
        useDefaultButtonBarButtonBackgroundColor.setText("Use default startup window button color");
        useDefaultButtonBarButtonBackgroundColor.setMaximumSize(new java.awt.Dimension(390, 23));
        useDefaultButtonBarButtonBackgroundColor.setMinimumSize(new java.awt.Dimension(390, 23));
        useDefaultButtonBarButtonBackgroundColor.setPreferredSize(new java.awt.Dimension(390, 23));
        useDefaultButtonBarButtonBackgroundColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultButtonBarButtonBackgroundColorActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel22.add(useDefaultButtonBarButtonBackgroundColor);

        buttonBarButtonBackgroundColorChooserButton.setBackground(new java.awt.Color(140, 160, 210));
        buttonBarButtonBackgroundColorChooserButton.setMaximumSize(new java.awt.Dimension(35, 20));
        buttonBarButtonBackgroundColorChooserButton.setMinimumSize(new java.awt.Dimension(35, 20));
        buttonBarButtonBackgroundColorChooserButton.setPreferredSize(new java.awt.Dimension(35, 20));
        buttonBarButtonBackgroundColorChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBarButtonBackgroundColorChooserButtonActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel22.add(buttonBarButtonBackgroundColorChooserButton);

        lFiller79.setBackground(new java.awt.Color(140, 160, 210));
        lFiller79.setText("   ");
        lFiller79.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller79.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller79.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel22.add(lFiller79);

        lFiller80.setBackground(new java.awt.Color(140, 160, 210));
        lFiller80.setText("   ");
        lFiller80.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller80.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller80.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel22.add(lFiller80);

        lFiller81.setBackground(new java.awt.Color(140, 160, 210));
        lFiller81.setText("   ");
        lFiller81.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller81.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller81.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel22.add(lFiller81);

        ProjectLookAndFeelImages9.add(UIChoicesBottomPanel22);

        add(ProjectLookAndFeelImages9);

        ProjectLookAndFeelImages7.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages7, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages7.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages7.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Startup Window Panel Separator Highlight Border Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
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
        useDefaultStartWindowPanelHighlightBorderColor.setText("Use default startup window panel separator highlight border color");
        useDefaultStartWindowPanelHighlightBorderColor.setMaximumSize(new java.awt.Dimension(390, 23));
        useDefaultStartWindowPanelHighlightBorderColor.setMinimumSize(new java.awt.Dimension(390, 23));
        useDefaultStartWindowPanelHighlightBorderColor.setPreferredSize(new java.awt.Dimension(390, 23));
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
        ProjectLookAndFeelImages8.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Startup Window Panel Separator Shadow Border Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
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
        useDefaultStartWindowPanelShadowBorderColor.setText("Use default startup window panel separator shadow border color");
        useDefaultStartWindowPanelShadowBorderColor.setMaximumSize(new java.awt.Dimension(390, 23));
        useDefaultStartWindowPanelShadowBorderColor.setMinimumSize(new java.awt.Dimension(390, 23));
        useDefaultStartWindowPanelShadowBorderColor.setPreferredSize(new java.awt.Dimension(390, 23));
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
        ProjectLookAndFeelImages.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Custom Textfield Border Configuration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages.setMaximumSize(new java.awt.Dimension(32767, 170));
        ProjectLookAndFeelImages.setMinimumSize(new java.awt.Dimension(10, 170));
        ProjectLookAndFeelImages.setPreferredSize(new java.awt.Dimension(10, 170));
        ImageDescriptionLabel.setLayout(new javax.swing.BoxLayout(ImageDescriptionLabel, javax.swing.BoxLayout.X_AXIS));

        ImageDescriptionLabel.setBackground(new java.awt.Color(140, 160, 210));
        LeftUIFiller2.setMaximumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller2.setMinimumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller2.setPreferredSize(new java.awt.Dimension(10, 10));
        ImageDescriptionLabel.add(LeftUIFiller2);

        useImageButtonsEnabled.setBackground(new java.awt.Color(140, 160, 210));
        useImageButtonsEnabled.setFont(new java.awt.Font("Arial", 0, 12));
        useImageButtonsEnabled.setSelected(true);
        useImageButtonsEnabled.setText("Custom Textfield Border Enabled");
        useImageButtonsEnabled.setMaximumSize(new java.awt.Dimension(240, 15));
        useImageButtonsEnabled.setMinimumSize(new java.awt.Dimension(240, 15));
        useImageButtonsEnabled.setPreferredSize(new java.awt.Dimension(240, 15));
        useImageButtonsEnabled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useImageButtonsEnabledActionPerformed(evt);
            }
        });

        ImageDescriptionLabel.add(useImageButtonsEnabled);

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

        UIChoicesBottomPanel5.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel5, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel5.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel5.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel5.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel5.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller43.setBackground(new java.awt.Color(140, 160, 210));
        lFiller43.setText("   ");
        lFiller43.setMaximumSize(new java.awt.Dimension(20, 15));
        lFiller43.setMinimumSize(new java.awt.Dimension(20, 16));
        lFiller43.setPreferredSize(new java.awt.Dimension(20, 16));
        UIChoicesBottomPanel5.add(lFiller43);

        useDefaultButtonBarTextColor.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultButtonBarTextColor.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultButtonBarTextColor.setSelected(true);
        useDefaultButtonBarTextColor.setText("Use default textfield exterior border color");
        useDefaultButtonBarTextColor.setMaximumSize(new java.awt.Dimension(360, 23));
        useDefaultButtonBarTextColor.setMinimumSize(new java.awt.Dimension(360, 23));
        useDefaultButtonBarTextColor.setPreferredSize(new java.awt.Dimension(360, 23));
        useDefaultButtonBarTextColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultButtonBarTextColorActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel5.add(useDefaultButtonBarTextColor);

        buttonBarTextColorChooserButton.setBackground(new java.awt.Color(140, 160, 210));
        buttonBarTextColorChooserButton.setMaximumSize(new java.awt.Dimension(35, 20));
        buttonBarTextColorChooserButton.setMinimumSize(new java.awt.Dimension(35, 20));
        buttonBarTextColorChooserButton.setPreferredSize(new java.awt.Dimension(35, 20));
        buttonBarTextColorChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBarTextColorChooserButtonActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel5.add(buttonBarTextColorChooserButton);

        lFiller44.setBackground(new java.awt.Color(140, 160, 210));
        lFiller44.setText("   ");
        lFiller44.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller44.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller44.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel5.add(lFiller44);

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

        UIChoicesBottomPanel8.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel8, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel8.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel8.setMaximumSize(new java.awt.Dimension(32767, 3));
        UIChoicesBottomPanel8.setMinimumSize(new java.awt.Dimension(5, 3));
        UIChoicesBottomPanel8.setPreferredSize(new java.awt.Dimension(200, 3));
        ProjectLookAndFeelImages.add(UIChoicesBottomPanel8);

        UIChoicesBottomPanel6.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel6, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel6.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel6.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel6.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel6.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller46.setBackground(new java.awt.Color(140, 160, 210));
        lFiller46.setText("   ");
        lFiller46.setMaximumSize(new java.awt.Dimension(20, 15));
        lFiller46.setMinimumSize(new java.awt.Dimension(20, 16));
        lFiller46.setPreferredSize(new java.awt.Dimension(20, 16));
        UIChoicesBottomPanel6.add(lFiller46);

        useDefaultButtonBarBackgroundColor.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultButtonBarBackgroundColor.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultButtonBarBackgroundColor.setSelected(true);
        useDefaultButtonBarBackgroundColor.setText("Use default textfield highlight border color 1");
        useDefaultButtonBarBackgroundColor.setMaximumSize(new java.awt.Dimension(360, 23));
        useDefaultButtonBarBackgroundColor.setMinimumSize(new java.awt.Dimension(360, 23));
        useDefaultButtonBarBackgroundColor.setPreferredSize(new java.awt.Dimension(360, 23));
        useDefaultButtonBarBackgroundColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultButtonBarBackgroundColorActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel6.add(useDefaultButtonBarBackgroundColor);

        ButtonBarBackgroundColorChooserButton.setBackground(new java.awt.Color(140, 160, 210));
        ButtonBarBackgroundColorChooserButton.setMaximumSize(new java.awt.Dimension(35, 20));
        ButtonBarBackgroundColorChooserButton.setMinimumSize(new java.awt.Dimension(35, 20));
        ButtonBarBackgroundColorChooserButton.setPreferredSize(new java.awt.Dimension(35, 20));
        ButtonBarBackgroundColorChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBarBackgroundColorChooserButtonActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel6.add(ButtonBarBackgroundColorChooserButton);

        lFiller58.setBackground(new java.awt.Color(140, 160, 210));
        lFiller58.setText("   ");
        lFiller58.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller58.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller58.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel6.add(lFiller58);

        lFiller50.setBackground(new java.awt.Color(140, 160, 210));
        lFiller50.setText("   ");
        lFiller50.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller50.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller50.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel6.add(lFiller50);

        lFiller51.setBackground(new java.awt.Color(140, 160, 210));
        lFiller51.setText("   ");
        lFiller51.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller51.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller51.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel6.add(lFiller51);

        ProjectLookAndFeelImages.add(UIChoicesBottomPanel6);

        UIChoicesBottomPanel10.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel10, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel10.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel10.setMaximumSize(new java.awt.Dimension(32767, 3));
        UIChoicesBottomPanel10.setMinimumSize(new java.awt.Dimension(5, 3));
        UIChoicesBottomPanel10.setPreferredSize(new java.awt.Dimension(200, 3));
        ProjectLookAndFeelImages.add(UIChoicesBottomPanel10);

        UIChoicesBottomPanel11.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel11, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel11.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel11.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel11.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel11.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller52.setBackground(new java.awt.Color(140, 160, 210));
        lFiller52.setText("   ");
        lFiller52.setMaximumSize(new java.awt.Dimension(20, 15));
        lFiller52.setMinimumSize(new java.awt.Dimension(20, 16));
        lFiller52.setPreferredSize(new java.awt.Dimension(20, 16));
        UIChoicesBottomPanel11.add(lFiller52);

        useDefaultProgressPanelTextColor.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultProgressPanelTextColor.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultProgressPanelTextColor.setSelected(true);
        useDefaultProgressPanelTextColor.setText("Use default textfield highlight border color 2");
        useDefaultProgressPanelTextColor.setActionCommand("Use default textfield exterior border color");
        useDefaultProgressPanelTextColor.setMaximumSize(new java.awt.Dimension(360, 23));
        useDefaultProgressPanelTextColor.setMinimumSize(new java.awt.Dimension(360, 23));
        useDefaultProgressPanelTextColor.setPreferredSize(new java.awt.Dimension(360, 23));
        useDefaultProgressPanelTextColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultProgressPanelTextColorActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel11.add(useDefaultProgressPanelTextColor);

        progressPanelTextColorChooserButton.setBackground(new java.awt.Color(140, 160, 210));
        progressPanelTextColorChooserButton.setMaximumSize(new java.awt.Dimension(35, 20));
        progressPanelTextColorChooserButton.setMinimumSize(new java.awt.Dimension(35, 20));
        progressPanelTextColorChooserButton.setPreferredSize(new java.awt.Dimension(35, 20));
        progressPanelTextColorChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progressPanelTextColorChooserButtonActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel11.add(progressPanelTextColorChooserButton);

        lFiller53.setBackground(new java.awt.Color(140, 160, 210));
        lFiller53.setText("   ");
        lFiller53.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller53.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller53.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel11.add(lFiller53);

        lFiller59.setBackground(new java.awt.Color(140, 160, 210));
        lFiller59.setText("   ");
        lFiller59.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller59.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller59.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel11.add(lFiller59);

        lFiller54.setBackground(new java.awt.Color(140, 160, 210));
        lFiller54.setText("   ");
        lFiller54.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller54.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller54.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel11.add(lFiller54);

        ProjectLookAndFeelImages.add(UIChoicesBottomPanel11);

        UIChoicesBottomPanel12.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel12, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel12.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel12.setMaximumSize(new java.awt.Dimension(32767, 3));
        UIChoicesBottomPanel12.setMinimumSize(new java.awt.Dimension(5, 3));
        UIChoicesBottomPanel12.setPreferredSize(new java.awt.Dimension(200, 3));
        ProjectLookAndFeelImages.add(UIChoicesBottomPanel12);

        UIChoicesBottomPanel13.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel13, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel13.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel13.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel13.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel13.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller55.setBackground(new java.awt.Color(140, 160, 210));
        lFiller55.setText("   ");
        lFiller55.setMaximumSize(new java.awt.Dimension(20, 15));
        lFiller55.setMinimumSize(new java.awt.Dimension(20, 16));
        lFiller55.setPreferredSize(new java.awt.Dimension(20, 16));
        UIChoicesBottomPanel13.add(lFiller55);

        useDefaultProgressPanelLeftBorderColor.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultProgressPanelLeftBorderColor.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultProgressPanelLeftBorderColor.setSelected(true);
        useDefaultProgressPanelLeftBorderColor.setText("Use default textfield shadow border color 1");
        useDefaultProgressPanelLeftBorderColor.setMaximumSize(new java.awt.Dimension(360, 23));
        useDefaultProgressPanelLeftBorderColor.setMinimumSize(new java.awt.Dimension(360, 23));
        useDefaultProgressPanelLeftBorderColor.setPreferredSize(new java.awt.Dimension(360, 23));
        useDefaultProgressPanelLeftBorderColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultProgressPanelLeftBorderColorActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel13.add(useDefaultProgressPanelLeftBorderColor);

        progressPanelLeftBorderColorChooserButton.setBackground(new java.awt.Color(140, 160, 210));
        progressPanelLeftBorderColorChooserButton.setMaximumSize(new java.awt.Dimension(35, 20));
        progressPanelLeftBorderColorChooserButton.setMinimumSize(new java.awt.Dimension(35, 20));
        progressPanelLeftBorderColorChooserButton.setPreferredSize(new java.awt.Dimension(35, 20));
        progressPanelLeftBorderColorChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progressPanelLeftBorderColorChooserButtonActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel13.add(progressPanelLeftBorderColorChooserButton);

        lFiller56.setBackground(new java.awt.Color(140, 160, 210));
        lFiller56.setText("   ");
        lFiller56.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller56.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller56.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel13.add(lFiller56);

        lFiller60.setBackground(new java.awt.Color(140, 160, 210));
        lFiller60.setText("   ");
        lFiller60.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller60.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller60.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel13.add(lFiller60);

        lFiller61.setBackground(new java.awt.Color(140, 160, 210));
        lFiller61.setText("   ");
        lFiller61.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller61.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller61.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel13.add(lFiller61);

        ProjectLookAndFeelImages.add(UIChoicesBottomPanel13);

        UIChoicesBottomPanel14.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel14, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel14.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel14.setMaximumSize(new java.awt.Dimension(32767, 3));
        UIChoicesBottomPanel14.setMinimumSize(new java.awt.Dimension(5, 3));
        UIChoicesBottomPanel14.setPreferredSize(new java.awt.Dimension(200, 3));
        ProjectLookAndFeelImages.add(UIChoicesBottomPanel14);

        UIChoicesBottomPanel15.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel15, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel15.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel15.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel15.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel15.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller62.setBackground(new java.awt.Color(140, 160, 210));
        lFiller62.setText("   ");
        lFiller62.setMaximumSize(new java.awt.Dimension(20, 15));
        lFiller62.setMinimumSize(new java.awt.Dimension(20, 16));
        lFiller62.setPreferredSize(new java.awt.Dimension(20, 16));
        UIChoicesBottomPanel15.add(lFiller62);

        useDefaultProgressBarFillColor.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultProgressBarFillColor.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultProgressBarFillColor.setSelected(true);
        useDefaultProgressBarFillColor.setText("Use default textfield shadow border color 2");
        useDefaultProgressBarFillColor.setMaximumSize(new java.awt.Dimension(360, 23));
        useDefaultProgressBarFillColor.setMinimumSize(new java.awt.Dimension(360, 23));
        useDefaultProgressBarFillColor.setPreferredSize(new java.awt.Dimension(360, 23));
        useDefaultProgressBarFillColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultProgressBarFillColorActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel15.add(useDefaultProgressBarFillColor);

        progressBarFillColorChooserButton.setBackground(new java.awt.Color(140, 160, 210));
        progressBarFillColorChooserButton.setMaximumSize(new java.awt.Dimension(35, 20));
        progressBarFillColorChooserButton.setMinimumSize(new java.awt.Dimension(35, 20));
        progressBarFillColorChooserButton.setPreferredSize(new java.awt.Dimension(35, 20));
        progressBarFillColorChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progressBarFillColorChooserButtonActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel15.add(progressBarFillColorChooserButton);

        lFiller63.setBackground(new java.awt.Color(140, 160, 210));
        lFiller63.setText("   ");
        lFiller63.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller63.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller63.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel15.add(lFiller63);

        lFiller64.setBackground(new java.awt.Color(140, 160, 210));
        lFiller64.setText("   ");
        lFiller64.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller64.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller64.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel15.add(lFiller64);

        lFiller65.setBackground(new java.awt.Color(140, 160, 210));
        lFiller65.setText("   ");
        lFiller65.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller65.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller65.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel15.add(lFiller65);

        ProjectLookAndFeelImages.add(UIChoicesBottomPanel15);

        UIChoicesBottomPanel16.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel16, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel16.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel16.setMaximumSize(new java.awt.Dimension(32767, 3));
        UIChoicesBottomPanel16.setMinimumSize(new java.awt.Dimension(5, 3));
        UIChoicesBottomPanel16.setPreferredSize(new java.awt.Dimension(200, 3));
        ProjectLookAndFeelImages.add(UIChoicesBottomPanel16);

        add(ProjectLookAndFeelImages);

        ProjectLookAndFeelImages4.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages4, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages4.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages4.setMaximumSize(new java.awt.Dimension(32767, 90));
        ProjectLookAndFeelImages4.setMinimumSize(new java.awt.Dimension(10, 90));
        ProjectLookAndFeelImages4.setPreferredSize(new java.awt.Dimension(10, 90));
        ProjectLocationsCenterPanel5.setLayout(new javax.swing.BoxLayout(ProjectLocationsCenterPanel5, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsCenterPanel5.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsCenterPanel5.setMaximumSize(new java.awt.Dimension(2147483647, 46));
        ProjectLocationsCenterPanel5.setMinimumSize(new java.awt.Dimension(600, 46));
        ProjectLocationsCenterPanel5.setPreferredSize(new java.awt.Dimension(800, 46));
        lFiller82.setBackground(new java.awt.Color(140, 160, 210));
        lFiller82.setText("   ");
        lFiller82.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller82.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller82.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel5.add(lFiller82);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.X_AXIS));

        jPanel1.setBackground(new java.awt.Color(140, 160, 210));
        jPanel1.setMaximumSize(new java.awt.Dimension(332, 46));
        jPanel1.setMinimumSize(new java.awt.Dimension(332, 46));
        jPanel1.setPreferredSize(new java.awt.Dimension(332, 46));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setBackground(new java.awt.Color(140, 160, 210));
        rbPaymentPreview.setBackground(new java.awt.Color(140, 160, 210));
        rbPaymentPreview.setFont(new java.awt.Font("Arial", 0, 12));
        rbPaymentPreview.setSelected(true);
        rbPaymentPreview.setText("Startup Window");
        rbPaymentPreview.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rbPaymentPreview.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        rbPaymentPreview.setMaximumSize(new java.awt.Dimension(240, 23));
        rbPaymentPreview.setMinimumSize(new java.awt.Dimension(240, 23));
        rbPaymentPreview.setPreferredSize(new java.awt.Dimension(240, 23));
        rbPaymentPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPaymentPreviewActionPerformed(evt);
            }
        });

        jPanel2.add(rbPaymentPreview);

        rbPaymentSuccessPreview.setBackground(new java.awt.Color(140, 160, 210));
        rbPaymentSuccessPreview.setFont(new java.awt.Font("Arial", 0, 12));
        rbPaymentSuccessPreview.setText("Registration Window (Custom Border)");
        rbPaymentSuccessPreview.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rbPaymentSuccessPreview.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        rbPaymentSuccessPreview.setMaximumSize(new java.awt.Dimension(240, 23));
        rbPaymentSuccessPreview.setMinimumSize(new java.awt.Dimension(240, 23));
        rbPaymentSuccessPreview.setPreferredSize(new java.awt.Dimension(240, 23));
        rbPaymentSuccessPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPaymentSuccessPreviewActionPerformed(evt);
            }
        });

        jPanel2.add(rbPaymentSuccessPreview);

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

        lFiller83.setBackground(new java.awt.Color(140, 160, 210));
        lFiller83.setText("   ");
        lFiller83.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller83.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller83.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel5.add(lFiller83);

        ProjectLookAndFeelImages4.add(ProjectLocationsCenterPanel5);

        UIChoicesBottomPanel7.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel7.setMinimumSize(new java.awt.Dimension(5, 5));
        UIChoicesBottomPanel7.setPreferredSize(new java.awt.Dimension(5, 5));
        ProjectLookAndFeelImages4.add(UIChoicesBottomPanel7);

        add(ProjectLookAndFeelImages4);

    }//GEN-END:initComponents

    private void rbPaymentSuccessPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPaymentSuccessPreviewActionPerformed
        if(rbPaymentSuccessPreview.isSelected()==true)
        {
           rbPaymentPreview.setSelected(false);
           rbPaymentSuccessPreview.setSelected(true);
        } 
    }//GEN-LAST:event_rbPaymentSuccessPreviewActionPerformed

    private void rbPaymentPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPaymentPreviewActionPerformed
        if(rbPaymentPreview.isSelected()==true)
        {
           rbPaymentPreview.setSelected(true);
           rbPaymentSuccessPreview.setSelected(false);
        } 
    }//GEN-LAST:event_rbPaymentPreviewActionPerformed

    private void useDefaultButtonBarButtonBackgroundColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultButtonBarButtonBackgroundColorActionPerformed
        try
        {
            if(useDefaultButtonBarButtonBackgroundColor.isSelected()==true)
            {
                ProjectManager.put("btnBarButtonBGColor", "");
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
    }//GEN-LAST:event_useDefaultButtonBarButtonBackgroundColorActionPerformed

    private void buttonBarButtonBackgroundColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBarButtonBackgroundColorChooserButtonActionPerformed
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
    }//GEN-LAST:event_buttonBarButtonBackgroundColorChooserButtonActionPerformed

    private void useDefaultProgressBarFillColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultProgressBarFillColorActionPerformed
        try
        {
            if(useDefaultProgressBarFillColor.isSelected()==true)
            {
                ProjectManager.put("registrationTFShadowBorderColor2", "");
                progressBarFillColorChooserButton.setVisible(false);                      
            }
            else
            {
                progressBarFillColorChooserButton.setVisible(true);  
                updateProgressBarFillColorSwatch();            
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_useDefaultProgressBarFillColorActionPerformed

    private void progressBarFillColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progressBarFillColorChooserButtonActionPerformed
 	// Bring up a color chooser 
        if(ProjectManager.get("registrationTFShadowBorderColor2")!=null)
        {
            if(ProjectManager.get("registrationTFShadowBorderColor2").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationTFShadowBorderColor2"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("registrationTFShadowBorderColor2", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                progressBarFillColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("registrationTFShadowBorderColor2", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressBarFillColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("registrationTFShadowBorderColor2", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressBarFillColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_progressBarFillColorChooserButtonActionPerformed

    private void useDefaultProgressPanelLeftBorderColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultProgressPanelLeftBorderColorActionPerformed
       try
        {
            if(useDefaultProgressPanelLeftBorderColor.isSelected()==true)
            {
                ProjectManager.put("registrationTFShadowBorderColor1", "");
                progressPanelLeftBorderColorChooserButton.setVisible(false);                      
            }
            else
            {
                progressPanelLeftBorderColorChooserButton.setVisible(true);  
                updateProgressPanelLeftBorderColorSwatch();            
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_useDefaultProgressPanelLeftBorderColorActionPerformed

    private void progressPanelLeftBorderColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progressPanelLeftBorderColorChooserButtonActionPerformed
	// Bring up a color chooser 
        if(ProjectManager.get("registrationTFShadowBorderColor1")!=null)
        {
            if(ProjectManager.get("registrationTFShadowBorderColor1").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationTFShadowBorderColor1"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("registrationTFShadowBorderColor1", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                progressPanelLeftBorderColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("registrationTFShadowBorderColor1", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressPanelLeftBorderColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("registrationTFShadowBorderColor1", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressPanelLeftBorderColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_progressPanelLeftBorderColorChooserButtonActionPerformed

    private void useDefaultProgressPanelTextColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultProgressPanelTextColorActionPerformed
        try
        {
            if(useDefaultProgressPanelTextColor.isSelected()==true)
            {
                ProjectManager.put("registrationTFHighlightBorderColor2", "");
                progressPanelTextColorChooserButton.setVisible(false);                      
            }
            else
            {
                progressPanelTextColorChooserButton.setVisible(true);  
                updateProgressPanelTextColorSwatch();            
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_useDefaultProgressPanelTextColorActionPerformed

    private void progressPanelTextColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progressPanelTextColorChooserButtonActionPerformed
 	// Bring up a color chooser 
        if(ProjectManager.get("registrationTFHighlightBorderColor2")!=null)
        {
            if(ProjectManager.get("registrationTFHighlightBorderColor2").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationTFHighlightBorderColor2"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("registrationTFHighlightBorderColor2", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                progressPanelTextColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("registrationTFHighlightBorderColor2", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressPanelTextColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("registrationTFHighlightBorderColor2", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressPanelTextColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_progressPanelTextColorChooserButtonActionPerformed

    private void useDefaultButtonBarBackgroundColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultButtonBarBackgroundColorActionPerformed
        try
        {
            if(useDefaultButtonBarBackgroundColor.isSelected()==true)
            {
                ProjectManager.put("registrationTFHighlightBorderColor1", "");
                ButtonBarBackgroundColorChooserButton.setVisible(false);                      
            }
            else
            {
                ButtonBarBackgroundColorChooserButton.setVisible(true);  
                updateButtonBarBackgroundColorSwatch();            
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_useDefaultButtonBarBackgroundColorActionPerformed

    private void ButtonBarBackgroundColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBarBackgroundColorChooserButtonActionPerformed
	// Bring up a color chooser 
        if(ProjectManager.get("registrationTFHighlightBorderColor1")!=null)
        {
            if(ProjectManager.get("registrationTFHighlightBorderColor1").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationTFHighlightBorderColor1"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("registrationTFHighlightBorderColor1", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ButtonBarBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("registrationTFHighlightBorderColor1", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                ButtonBarBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("registrationTFHighlightBorderColor1", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                ButtonBarBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_ButtonBarBackgroundColorChooserButtonActionPerformed

    private void useDefaultButtonBarTextColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultButtonBarTextColorActionPerformed
        try
        {
            if(useDefaultButtonBarTextColor.isSelected()==true)
            {
                ProjectManager.put("registrationTFExtBorderColor", "");
                buttonBarTextColorChooserButton.setVisible(false);                      
            }
            else
            {
                buttonBarTextColorChooserButton.setVisible(true);  
                updateButtonBarTextColorSwatch();            
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_useDefaultButtonBarTextColorActionPerformed

    private void buttonBarTextColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBarTextColorChooserButtonActionPerformed
	// Bring up a color chooser 
        if(ProjectManager.get("registrationTFExtBorderColor")!=null)
        {
            if(ProjectManager.get("registrationTFExtBorderColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationTFExtBorderColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("registrationTFExtBorderColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                buttonBarTextColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("registrationTFExtBorderColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                buttonBarTextColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("registrationTFExtBorderColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                buttonBarTextColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_buttonBarTextColorChooserButtonActionPerformed


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

    private void useImageButtonsEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useImageButtonsEnabledActionPerformed
        try
        {
            if(useImageButtonsEnabled.isSelected()==true)
            {
                ProjectManager.putTempNoFileWrite("registrationCustomBorderEnabled", "true");
            }
            else
            {
                 ProjectManager.putTempNoFileWrite("registrationCustomBorderEnabled", "false");           
            }
        }
        catch(Exception e)
        {

        }
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
             if(rbPaymentPreview.isSelected()==true)
            {
		((EAPanel)getParentComponent()).getDataUpdate();
		new StartVerticalButtonBarThemeAction();
            }
            else if(rbPaymentSuccessPreview.isSelected()==true)
            {
                ((EAPanel)getParentComponent()).getDataUpdate(); 
                new EnterRegistrationCodeAction();	          
            }                
	}
	catch(Exception e)
	{
		//e.printStackTrace();
	}
    }//GEN-LAST:event_PreviewButtonActionPerformed
 
    private void updateButtonBarTextColorSwatch()
    {
        try
        {
            Color c = new java.awt.Color(255,255,255); 
            // Bring up a color chooser 
            if(ProjectManager.get("registrationTFExtBorderColor")!=null)
            {
                if(ProjectManager.get("registrationTFExtBorderColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationTFExtBorderColor"));
                    c = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()); 
                    buttonBarTextColorChooserButton.setIcon(new ColorSwatch(c));
                }
                else
                {
                    buttonBarTextColorChooserButton.setIcon(noColorIcon);
                }
            }
            else
            {
                buttonBarTextColorChooserButton.setIcon(noColorIcon);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }        
   
    private void updateButtonBarBackgroundColorSwatch() 
    {
        try
        { 
            Color c = new java.awt.Color(255,255,255); 
            // Bring up a color chooser 
            if(ProjectManager.get("registrationTFHighlightBorderColor1")!=null)
            {
                if(ProjectManager.get("registrationTFHighlightBorderColor1").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationTFHighlightBorderColor1"));
                    c = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()); 
                    ButtonBarBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
                }
                else
                {
                    ButtonBarBackgroundColorChooserButton.setIcon(noColorIcon);
                }
            }
            else
            {
                ButtonBarBackgroundColorChooserButton.setIcon(noColorIcon);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }    
  
    private void updateProgressPanelTextColorSwatch()
    {
        try
        { 
            Color c = new java.awt.Color(255,255,255); 
            // Bring up a color chooser 
            if(ProjectManager.get("registrationTFHighlightBorderColor2")!=null)
            {
                if(ProjectManager.get("registrationTFHighlightBorderColor2").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationTFHighlightBorderColor2"));
                    c = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()); 
                    progressPanelTextColorChooserButton.setIcon(new ColorSwatch(c));
                }
                else
                {
                    progressPanelTextColorChooserButton.setIcon(noColorIcon);
                }
            }
            else
            {
                progressPanelTextColorChooserButton.setIcon(noColorIcon);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }        

    private void updateProgressPanelLeftBorderColorSwatch()
    {
        try
        { 
            Color c = new java.awt.Color(255,255,255); 
            // Bring up a color chooser 
            if(ProjectManager.get("registrationTFShadowBorderColor1")!=null)
            {
                if(ProjectManager.get("registrationTFShadowBorderColor1").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationTFShadowBorderColor1"));
                    c = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()); 
                    progressPanelLeftBorderColorChooserButton.setIcon(new ColorSwatch(c));
                }
                else
                {
                    progressPanelLeftBorderColorChooserButton.setIcon(noColorIcon);
                }
            }
            else
            {
                progressPanelLeftBorderColorChooserButton.setIcon(noColorIcon);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }       
    
    private void updateProgressBarFillColorSwatch()
    {
        try
        { 
            Color c = new java.awt.Color(255,255,255); 
            // Bring up a color chooser 
            if(ProjectManager.get("registrationTFShadowBorderColor2")!=null)
            {
                if(ProjectManager.get("registrationTFShadowBorderColor2").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("registrationTFShadowBorderColor2"));
                    c = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()); 
                    progressBarFillColorChooserButton.setIcon(new ColorSwatch(c));
                }
                else
                {
                    progressBarFillColorChooserButton.setIcon(noColorIcon);
                }
            }
            else
            {
                progressBarFillColorChooserButton.setIcon(noColorIcon);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
   
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

    private void formFocusLost(java.awt.event.FocusEvent evt) {
     getDataUpdate(); 
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
    private javax.swing.JButton ButtonBarBackgroundColorChooserButton;
    private javax.swing.JPanel ImageDescriptionLabel;
    private javax.swing.JLabel LeftUIFiller2;
    private javax.swing.JButton PreviewButton;
    private javax.swing.JPanel ProjectLocationsCenterPanel1;
    private javax.swing.JPanel ProjectLocationsCenterPanel5;
    private javax.swing.JPanel ProjectLookAndFeelImages;
    private javax.swing.JPanel ProjectLookAndFeelImages1;
    private javax.swing.JPanel ProjectLookAndFeelImages4;
    private javax.swing.JPanel ProjectLookAndFeelImages7;
    private javax.swing.JPanel ProjectLookAndFeelImages8;
    private javax.swing.JPanel ProjectLookAndFeelImages9;
    private javax.swing.JPanel UIChoicesBottomPanel10;
    private javax.swing.JPanel UIChoicesBottomPanel11;
    private javax.swing.JPanel UIChoicesBottomPanel12;
    private javax.swing.JPanel UIChoicesBottomPanel13;
    private javax.swing.JPanel UIChoicesBottomPanel14;
    private javax.swing.JPanel UIChoicesBottomPanel15;
    private javax.swing.JPanel UIChoicesBottomPanel16;
    private javax.swing.JPanel UIChoicesBottomPanel17;
    private javax.swing.JPanel UIChoicesBottomPanel18;
    private javax.swing.JPanel UIChoicesBottomPanel19;
    private javax.swing.JPanel UIChoicesBottomPanel20;
    private javax.swing.JPanel UIChoicesBottomPanel21;
    private javax.swing.JPanel UIChoicesBottomPanel22;
    private javax.swing.JPanel UIChoicesBottomPanel5;
    private javax.swing.JPanel UIChoicesBottomPanel6;
    private javax.swing.JPanel UIChoicesBottomPanel7;
    private javax.swing.JPanel UIChoicesBottomPanel8;
    private javax.swing.JPanel UIChoicesBottomPanel9;
    private javax.swing.JButton buttonBarButtonBackgroundColorChooserButton;
    private javax.swing.JButton buttonBarTextColorChooserButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lBuildLocation1;
    private javax.swing.JLabel lFiller24;
    private javax.swing.JLabel lFiller26;
    private javax.swing.JLabel lFiller27;
    private javax.swing.JLabel lFiller28;
    private javax.swing.JLabel lFiller29;
    private javax.swing.JLabel lFiller30;
    private javax.swing.JLabel lFiller43;
    private javax.swing.JLabel lFiller44;
    private javax.swing.JLabel lFiller46;
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
    private javax.swing.JLabel lFiller70;
    private javax.swing.JLabel lFiller71;
    private javax.swing.JLabel lFiller72;
    private javax.swing.JLabel lFiller73;
    private javax.swing.JLabel lFiller74;
    private javax.swing.JLabel lFiller75;
    private javax.swing.JLabel lFiller76;
    private javax.swing.JLabel lFiller77;
    private javax.swing.JLabel lFiller78;
    private javax.swing.JLabel lFiller79;
    private javax.swing.JLabel lFiller80;
    private javax.swing.JLabel lFiller81;
    private javax.swing.JLabel lFiller82;
    private javax.swing.JLabel lFiller83;
    private javax.swing.JButton progressBarFillColorChooserButton;
    private javax.swing.JButton progressPanelLeftBorderColorChooserButton;
    private javax.swing.JButton progressPanelTextColorChooserButton;
    private javax.swing.JRadioButton rbPaymentPreview;
    private javax.swing.JRadioButton rbPaymentSuccessPreview;
    private javax.swing.JSpinner spinProgressBarCellSpacing;
    private javax.swing.JButton startWindowPanelHighlightBorderColorChooserButton;
    private javax.swing.JButton startWindowPanelShadowBorderColorChooserButton;
    private javax.swing.JCheckBox useDefaultButtonBarBackgroundColor;
    private javax.swing.JCheckBox useDefaultButtonBarButtonBackgroundColor;
    private javax.swing.JCheckBox useDefaultButtonBarTextColor;
    private javax.swing.JCheckBox useDefaultProgressBarFillColor;
    private javax.swing.JCheckBox useDefaultProgressPanelLeftBorderColor;
    private javax.swing.JCheckBox useDefaultProgressPanelTextColor;
    private javax.swing.JCheckBox useDefaultStartWindowPanelHighlightBorderColor;
    private javax.swing.JCheckBox useDefaultStartWindowPanelShadowBorderColor;
    private javax.swing.JCheckBox useImageButtonsEnabled;
    // End of variables declaration//GEN-END:variables
    
}
