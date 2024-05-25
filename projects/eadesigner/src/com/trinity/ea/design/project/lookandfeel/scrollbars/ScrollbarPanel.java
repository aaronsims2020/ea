/*
 * ScrollbarPanel.java
 *
 * Created on June 13, 2004, 3:24 PM
 */

package com.trinity.ea.design.project.lookandfeel.scrollbars;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.common.filechooser.ImageFileFilter;
import com.trinity.ea.design.common.preview.actions.InformationScrollbarDialogAction;
import com.trinity.ea.design.messaging.actions.MessagingScrollbarAction;
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
public class ScrollbarPanel extends EAPanel {
    ImageFileFilter filter = new ImageFileFilter(new String[] {"gif", "jpg", "jpeg", "png"}, "Select an image file");   
    JFileChooser imageFileChooser = new JFileChooser();
    private ImageIcon noColorIcon = new ImageIcon(getClass().getResource("/images/nocolor.png"));
    /** Creates new form ImagesPanel */
    public ScrollbarPanel() 
    {
	  
        initComponents();
        updateButtonBarTextColorSwatch();
        updateButtonBarBackgroundColorSwatch();
        updateProgressPanelTextColorSwatch();
        updateProgressPanelLeftBorderColorSwatch();
        updateProgressBarBackgroundColorSwatch();
        updateProgressBarFillColorSwatch();
        updateHighlightBorderColorSwatch();
        updateShadowBorderColorSwatch();
        
        setProjectData();
    }

    public synchronized void getDataUpdate()
    {
	try
        {
            // File Locations
            if(tfImageButtonPath.getText().equalsIgnoreCase("")==false)
            {
                    ProjectManager.putTempNoFileWrite("sbThumbImagePath", new File(tfImageButtonPath.getText()).toURL().toString());
            }
            else
            {
                    ProjectManager.putTempNoFileWrite("sbThumbImagePath", "");
            }
            if(tfImageButtonPath1.getText().equalsIgnoreCase("")==false)
            {
                    ProjectManager.putTempNoFileWrite("sbMsgThumbImagePath", new File(tfImageButtonPath1.getText()).toURL().toString());
            }
            else
            {
                    ProjectManager.putTempNoFileWrite("sbMsgThumbImagePath", "");
            }            
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
             if(ProjectManager.get("customScrollBarsEnabled")!=null)
             {
                    if(ProjectManager.get("customScrollBarsEnabled").equalsIgnoreCase("true")==true)
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
            if(ProjectManager.get("sbThumbImagePath")!=null)
            {
                    if(ProjectManager.get("sbThumbImagePath").equalsIgnoreCase("")==false)
                    {
                        try
                        {
                            tfImageButtonPath.setText(new File(new URL(ProjectManager.get("sbThumbImagePath")).getFile()).getCanonicalPath());
                        }
                        catch(Exception e)
                        {
                            
                        }
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
             
            if(ProjectManager.get("sbMsgThumbImagePath")!=null)
            {
                    if(ProjectManager.get("sbMsgThumbImagePath").equalsIgnoreCase("")==false)
                    {
                        try
                        {
                            tfImageButtonPath1.setText(new File(new URL(ProjectManager.get("sbMsgThumbImagePath")).getFile()).getCanonicalPath());
                        }
                        catch(Exception e)
                        {
                            
                        }
                            tfImageButtonPath1.setCaretPosition(0);
                    }
                    else
                    {
                            tfImageButtonPath1.setText("");
                    }
            }
            else
            {
                    tfImageButtonPath1.setText("");
            }             
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
        try
        {
            if(ProjectManager.get("sbBackgroundColor")!=null)
            {
                if(ProjectManager.get("sbBackgroundColor").equalsIgnoreCase("")==false)
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
            
            
            if(ProjectManager.get("sbForegroundColor")!=null)
            {
                if(ProjectManager.get("sbForegroundColor").equalsIgnoreCase("")==false)
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
            
            
            if(ProjectManager.get("sbBGArrowBtnColor")!=null)
            {
                if(ProjectManager.get("sbBGArrowBtnColor").equalsIgnoreCase("")==false)
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
            
            
             if(ProjectManager.get("sbShadowArrowBtnColor")!=null)
            {
                if(ProjectManager.get("sbShadowArrowBtnColor").equalsIgnoreCase("")==false)
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
            
            
            if(ProjectManager.get("sbDarkShadowArrowBtnColor")!=null)
            {
                if(ProjectManager.get("sbDarkShadowArrowBtnColor").equalsIgnoreCase("")==false)
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
            
            
            if(ProjectManager.get("sbLtHighlightArrowBtnColor")!=null)
            {
                if(ProjectManager.get("sbLtHighlightArrowBtnColor").equalsIgnoreCase("")==false)
                {
                    useDefaultProgressBarBackgroundColor.setSelected(false);
                    progressBarBackgroundColorChooserButton.setVisible(true); 
                }
                else
                {
                    useDefaultProgressBarBackgroundColor.setSelected(true);
                    progressBarBackgroundColorChooserButton.setVisible(false);                    
                }
            }
            else
            {
                useDefaultProgressBarBackgroundColor.setSelected(true);
                progressBarBackgroundColorChooserButton.setVisible(false);                
            }            
            
            
            if(ProjectManager.get("sbTrackColor")!=null)
            {
                if(ProjectManager.get("sbTrackColor").equalsIgnoreCase("")==false)
                {
                    useDefaultProgressBarHighlightBorderColor.setSelected(false);
                    progressBarHighlightBorderColorChooserButton.setVisible(true); 
                }
                else
                {
                    useDefaultProgressBarHighlightBorderColor.setSelected(true);
                    progressBarHighlightBorderColorChooserButton.setVisible(false);                    
                }
            }
            else
            {
                useDefaultProgressBarHighlightBorderColor.setSelected(true);
                progressBarHighlightBorderColorChooserButton.setVisible(false);                
            }          
            
            
             if(ProjectManager.get("sbTrackHighlightColor")!=null)
            {
                if(ProjectManager.get("sbTrackHighlightColor").equalsIgnoreCase("")==false)
                {
                    useDefaultProgressBarShadowBorderColor.setSelected(false);
                    progressBarShadowBorderColorChooserButton.setVisible(true); 
                }
                else
                {
                    useDefaultProgressBarShadowBorderColor.setSelected(true);
                    progressBarShadowBorderColorChooserButton.setVisible(false);                    
                }
            }
            else
            {
                useDefaultProgressBarShadowBorderColor.setSelected(true);
                progressBarShadowBorderColorChooserButton.setVisible(false);                
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
        ProjectLookAndFeelImages = new javax.swing.JPanel();
        ImageDescriptionLabel = new javax.swing.JPanel();
        LeftUIFiller2 = new javax.swing.JLabel();
        useImageButtonsEnabled = new javax.swing.JCheckBox();
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
        lFiller26 = new javax.swing.JLabel();
        lBuildLocation3 = new javax.swing.JLabel();
        tfImageButtonPath1 = new javax.swing.JTextField();
        lFiller35 = new javax.swing.JLabel();
        ImageButtonPathChooseButton1 = new javax.swing.JButton();
        lFiller36 = new javax.swing.JLabel();
        ImageButtonPathDefaultButton1 = new javax.swing.JButton();
        lFiller37 = new javax.swing.JLabel();
        lFiller38 = new javax.swing.JLabel();
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
        UIChoicesBottomPanel17 = new javax.swing.JPanel();
        lFiller66 = new javax.swing.JLabel();
        useDefaultProgressBarBackgroundColor = new javax.swing.JCheckBox();
        progressBarBackgroundColorChooserButton = new javax.swing.JButton();
        lFiller67 = new javax.swing.JLabel();
        lFiller68 = new javax.swing.JLabel();
        lFiller69 = new javax.swing.JLabel();
        UIChoicesBottomPanel18 = new javax.swing.JPanel();
        UIChoicesBottomPanel19 = new javax.swing.JPanel();
        lFiller70 = new javax.swing.JLabel();
        useDefaultProgressBarHighlightBorderColor = new javax.swing.JCheckBox();
        progressBarHighlightBorderColorChooserButton = new javax.swing.JButton();
        lFiller71 = new javax.swing.JLabel();
        lFiller72 = new javax.swing.JLabel();
        lFiller73 = new javax.swing.JLabel();
        UIChoicesBottomPanel20 = new javax.swing.JPanel();
        UIChoicesBottomPanel21 = new javax.swing.JPanel();
        lFiller74 = new javax.swing.JLabel();
        useDefaultProgressBarShadowBorderColor = new javax.swing.JCheckBox();
        progressBarShadowBorderColorChooserButton = new javax.swing.JButton();
        lFiller75 = new javax.swing.JLabel();
        lFiller76 = new javax.swing.JLabel();
        lFiller77 = new javax.swing.JLabel();
        UIChoicesBottomPanel22 = new javax.swing.JPanel();
        ProjectLookAndFeelImages4 = new javax.swing.JPanel();
        ProjectLocationsCenterPanel5 = new javax.swing.JPanel();
        lFiller78 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rbPaymentPreview = new javax.swing.JRadioButton();
        rbPaymentSuccessPreview = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        PreviewButton = new javax.swing.JButton();
        lFiller79 = new javax.swing.JLabel();
        UIChoicesBottomPanel7 = new javax.swing.JPanel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Custom Scrollbars Configuration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages.setMaximumSize(new java.awt.Dimension(32767, 300));
        ProjectLookAndFeelImages.setMinimumSize(new java.awt.Dimension(10, 300));
        ProjectLookAndFeelImages.setPreferredSize(new java.awt.Dimension(10, 300));
        ImageDescriptionLabel.setLayout(new javax.swing.BoxLayout(ImageDescriptionLabel, javax.swing.BoxLayout.X_AXIS));

        ImageDescriptionLabel.setBackground(new java.awt.Color(140, 160, 210));
        LeftUIFiller2.setMaximumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller2.setMinimumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller2.setPreferredSize(new java.awt.Dimension(10, 10));
        ImageDescriptionLabel.add(LeftUIFiller2);

        useImageButtonsEnabled.setBackground(new java.awt.Color(140, 160, 210));
        useImageButtonsEnabled.setFont(new java.awt.Font("Arial", 0, 12));
        useImageButtonsEnabled.setSelected(true);
        useImageButtonsEnabled.setText("Custom Scrollbars Enabled");
        useImageButtonsEnabled.setMaximumSize(new java.awt.Dimension(190, 15));
        useImageButtonsEnabled.setMinimumSize(new java.awt.Dimension(190, 15));
        useImageButtonsEnabled.setPreferredSize(new java.awt.Dimension(190, 15));
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
        lBuildLocation2.setText("Scrollbar Thumb Image File:");
        lBuildLocation2.setMaximumSize(new java.awt.Dimension(220, 15));
        lBuildLocation2.setMinimumSize(new java.awt.Dimension(220, 15));
        lBuildLocation2.setPreferredSize(new java.awt.Dimension(220, 15));
        ProjectLocationsCenterPanel2.add(lBuildLocation2);

        tfImageButtonPath.setBackground(new java.awt.Color(204, 204, 204));
        tfImageButtonPath.setFont(new java.awt.Font("Arial", 0, 12));
        tfImageButtonPath.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfImageButtonPath.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfImageButtonPath.setMinimumSize(new java.awt.Dimension(210, 20));
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
        lFiller26.setBackground(new java.awt.Color(140, 160, 210));
        lFiller26.setText("   ");
        lFiller26.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller26.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller26.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel3.add(lFiller26);

        lBuildLocation3.setBackground(new java.awt.Color(140, 160, 210));
        lBuildLocation3.setFont(new java.awt.Font("Arial", 0, 12));
        lBuildLocation3.setText("Message Scrollbar Thumb Image File:");
        lBuildLocation3.setMaximumSize(new java.awt.Dimension(220, 15));
        lBuildLocation3.setMinimumSize(new java.awt.Dimension(220, 15));
        lBuildLocation3.setPreferredSize(new java.awt.Dimension(220, 15));
        ProjectLocationsCenterPanel3.add(lBuildLocation3);

        tfImageButtonPath1.setBackground(new java.awt.Color(204, 204, 204));
        tfImageButtonPath1.setFont(new java.awt.Font("Arial", 0, 12));
        tfImageButtonPath1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfImageButtonPath1.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfImageButtonPath1.setMinimumSize(new java.awt.Dimension(210, 20));
        tfImageButtonPath1.setPreferredSize(new java.awt.Dimension(350, 20));
        ProjectLocationsCenterPanel3.add(tfImageButtonPath1);

        lFiller35.setBackground(new java.awt.Color(140, 160, 210));
        lFiller35.setText("   ");
        lFiller35.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller35.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller35.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel3.add(lFiller35);

        ImageButtonPathChooseButton1.setFont(new java.awt.Font("Arial", 0, 12));
        ImageButtonPathChooseButton1.setText("Choose...");
        ImageButtonPathChooseButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageButtonPathChooseButton1ActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel3.add(ImageButtonPathChooseButton1);

        lFiller36.setBackground(new java.awt.Color(140, 160, 210));
        lFiller36.setText("   ");
        lFiller36.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller36.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller36.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel3.add(lFiller36);

        ImageButtonPathDefaultButton1.setFont(new java.awt.Font("Arial", 0, 12));
        ImageButtonPathDefaultButton1.setText("Default");
        ImageButtonPathDefaultButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageButtonPathDefaultButton1ActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel3.add(ImageButtonPathDefaultButton1);

        lFiller37.setBackground(new java.awt.Color(140, 160, 210));
        lFiller37.setText("   ");
        lFiller37.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller37.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller37.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel3.add(lFiller37);

        lFiller38.setBackground(new java.awt.Color(140, 160, 210));
        lFiller38.setText("   ");
        lFiller38.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller38.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller38.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel3.add(lFiller38);

        ProjectLookAndFeelImages.add(ProjectLocationsCenterPanel3);

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
        useDefaultButtonBarTextColor.setText("Use default scrollbar background color");
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
        useDefaultButtonBarBackgroundColor.setText("Use default scrollbar foreground color");
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
        useDefaultProgressPanelTextColor.setText("Use default scrollbar arrow button background color");
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
        useDefaultProgressPanelLeftBorderColor.setText("Use default scrollbar arrow button shadow color");
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
        useDefaultProgressBarFillColor.setText("Use default scrollbar arrow button dark shadow color");
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

        UIChoicesBottomPanel17.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel17, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel17.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel17.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel17.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel17.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller66.setBackground(new java.awt.Color(140, 160, 210));
        lFiller66.setText("   ");
        lFiller66.setMaximumSize(new java.awt.Dimension(20, 15));
        lFiller66.setMinimumSize(new java.awt.Dimension(20, 16));
        lFiller66.setPreferredSize(new java.awt.Dimension(20, 16));
        UIChoicesBottomPanel17.add(lFiller66);

        useDefaultProgressBarBackgroundColor.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultProgressBarBackgroundColor.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultProgressBarBackgroundColor.setSelected(true);
        useDefaultProgressBarBackgroundColor.setText("Use default scrollbar arrow button light highlight color");
        useDefaultProgressBarBackgroundColor.setMaximumSize(new java.awt.Dimension(360, 23));
        useDefaultProgressBarBackgroundColor.setMinimumSize(new java.awt.Dimension(360, 23));
        useDefaultProgressBarBackgroundColor.setPreferredSize(new java.awt.Dimension(360, 23));
        useDefaultProgressBarBackgroundColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultProgressBarBackgroundColorActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel17.add(useDefaultProgressBarBackgroundColor);

        progressBarBackgroundColorChooserButton.setBackground(new java.awt.Color(140, 160, 210));
        progressBarBackgroundColorChooserButton.setMaximumSize(new java.awt.Dimension(35, 20));
        progressBarBackgroundColorChooserButton.setMinimumSize(new java.awt.Dimension(35, 20));
        progressBarBackgroundColorChooserButton.setPreferredSize(new java.awt.Dimension(35, 20));
        progressBarBackgroundColorChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progressBarBackgroundColorChooserButtonActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel17.add(progressBarBackgroundColorChooserButton);

        lFiller67.setBackground(new java.awt.Color(140, 160, 210));
        lFiller67.setText("   ");
        lFiller67.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller67.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller67.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel17.add(lFiller67);

        lFiller68.setBackground(new java.awt.Color(140, 160, 210));
        lFiller68.setText("   ");
        lFiller68.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller68.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller68.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel17.add(lFiller68);

        lFiller69.setBackground(new java.awt.Color(140, 160, 210));
        lFiller69.setText("   ");
        lFiller69.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller69.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller69.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel17.add(lFiller69);

        ProjectLookAndFeelImages.add(UIChoicesBottomPanel17);

        UIChoicesBottomPanel18.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel18, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel18.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel18.setMaximumSize(new java.awt.Dimension(32767, 3));
        UIChoicesBottomPanel18.setMinimumSize(new java.awt.Dimension(5, 3));
        UIChoicesBottomPanel18.setPreferredSize(new java.awt.Dimension(200, 3));
        ProjectLookAndFeelImages.add(UIChoicesBottomPanel18);

        UIChoicesBottomPanel19.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel19, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel19.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel19.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel19.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel19.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller70.setBackground(new java.awt.Color(140, 160, 210));
        lFiller70.setText("   ");
        lFiller70.setMaximumSize(new java.awt.Dimension(20, 15));
        lFiller70.setMinimumSize(new java.awt.Dimension(20, 16));
        lFiller70.setPreferredSize(new java.awt.Dimension(20, 16));
        UIChoicesBottomPanel19.add(lFiller70);

        useDefaultProgressBarHighlightBorderColor.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultProgressBarHighlightBorderColor.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultProgressBarHighlightBorderColor.setSelected(true);
        useDefaultProgressBarHighlightBorderColor.setText("Use default scrollbar track color");
        useDefaultProgressBarHighlightBorderColor.setMaximumSize(new java.awt.Dimension(360, 23));
        useDefaultProgressBarHighlightBorderColor.setMinimumSize(new java.awt.Dimension(360, 23));
        useDefaultProgressBarHighlightBorderColor.setPreferredSize(new java.awt.Dimension(360, 23));
        useDefaultProgressBarHighlightBorderColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultProgressBarHighlightBorderColorActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel19.add(useDefaultProgressBarHighlightBorderColor);

        progressBarHighlightBorderColorChooserButton.setBackground(new java.awt.Color(140, 160, 210));
        progressBarHighlightBorderColorChooserButton.setMaximumSize(new java.awt.Dimension(35, 20));
        progressBarHighlightBorderColorChooserButton.setMinimumSize(new java.awt.Dimension(35, 20));
        progressBarHighlightBorderColorChooserButton.setPreferredSize(new java.awt.Dimension(35, 20));
        progressBarHighlightBorderColorChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progressBarHighlightBorderColorChooserButtonActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel19.add(progressBarHighlightBorderColorChooserButton);

        lFiller71.setBackground(new java.awt.Color(140, 160, 210));
        lFiller71.setText("   ");
        lFiller71.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller71.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller71.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel19.add(lFiller71);

        lFiller72.setBackground(new java.awt.Color(140, 160, 210));
        lFiller72.setText("   ");
        lFiller72.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller72.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller72.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel19.add(lFiller72);

        lFiller73.setBackground(new java.awt.Color(140, 160, 210));
        lFiller73.setText("   ");
        lFiller73.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller73.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller73.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel19.add(lFiller73);

        ProjectLookAndFeelImages.add(UIChoicesBottomPanel19);

        UIChoicesBottomPanel20.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel20, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel20.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel20.setMaximumSize(new java.awt.Dimension(32767, 3));
        UIChoicesBottomPanel20.setMinimumSize(new java.awt.Dimension(5, 3));
        UIChoicesBottomPanel20.setPreferredSize(new java.awt.Dimension(200, 3));
        ProjectLookAndFeelImages.add(UIChoicesBottomPanel20);

        UIChoicesBottomPanel21.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel21, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel21.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel21.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel21.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel21.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller74.setBackground(new java.awt.Color(140, 160, 210));
        lFiller74.setText("   ");
        lFiller74.setMaximumSize(new java.awt.Dimension(20, 15));
        lFiller74.setMinimumSize(new java.awt.Dimension(20, 16));
        lFiller74.setPreferredSize(new java.awt.Dimension(20, 16));
        UIChoicesBottomPanel21.add(lFiller74);

        useDefaultProgressBarShadowBorderColor.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultProgressBarShadowBorderColor.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultProgressBarShadowBorderColor.setSelected(true);
        useDefaultProgressBarShadowBorderColor.setText("Use default scrollbar track highlight color");
        useDefaultProgressBarShadowBorderColor.setMaximumSize(new java.awt.Dimension(360, 23));
        useDefaultProgressBarShadowBorderColor.setMinimumSize(new java.awt.Dimension(360, 23));
        useDefaultProgressBarShadowBorderColor.setPreferredSize(new java.awt.Dimension(360, 23));
        useDefaultProgressBarShadowBorderColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultProgressBarShadowBorderColorActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel21.add(useDefaultProgressBarShadowBorderColor);

        progressBarShadowBorderColorChooserButton.setBackground(new java.awt.Color(140, 160, 210));
        progressBarShadowBorderColorChooserButton.setMaximumSize(new java.awt.Dimension(35, 20));
        progressBarShadowBorderColorChooserButton.setMinimumSize(new java.awt.Dimension(35, 20));
        progressBarShadowBorderColorChooserButton.setPreferredSize(new java.awt.Dimension(35, 20));
        progressBarShadowBorderColorChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progressBarShadowBorderColorChooserButtonActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel21.add(progressBarShadowBorderColorChooserButton);

        lFiller75.setBackground(new java.awt.Color(140, 160, 210));
        lFiller75.setText("   ");
        lFiller75.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller75.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller75.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel21.add(lFiller75);

        lFiller76.setBackground(new java.awt.Color(140, 160, 210));
        lFiller76.setText("   ");
        lFiller76.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller76.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller76.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel21.add(lFiller76);

        lFiller77.setBackground(new java.awt.Color(140, 160, 210));
        lFiller77.setText("   ");
        lFiller77.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller77.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller77.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel21.add(lFiller77);

        ProjectLookAndFeelImages.add(UIChoicesBottomPanel21);

        UIChoicesBottomPanel22.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel22, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel22.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel22.setMaximumSize(new java.awt.Dimension(32767, 3));
        UIChoicesBottomPanel22.setMinimumSize(new java.awt.Dimension(5, 3));
        UIChoicesBottomPanel22.setPreferredSize(new java.awt.Dimension(200, 3));
        ProjectLookAndFeelImages.add(UIChoicesBottomPanel22);

        add(ProjectLookAndFeelImages);

        ProjectLookAndFeelImages4.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages4, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages4.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages4.setMinimumSize(new java.awt.Dimension(10, 90));
        ProjectLookAndFeelImages4.setPreferredSize(new java.awt.Dimension(10, 90));
        ProjectLocationsCenterPanel5.setLayout(new javax.swing.BoxLayout(ProjectLocationsCenterPanel5, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsCenterPanel5.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsCenterPanel5.setMaximumSize(new java.awt.Dimension(2147483647, 46));
        ProjectLocationsCenterPanel5.setMinimumSize(new java.awt.Dimension(600, 46));
        ProjectLocationsCenterPanel5.setPreferredSize(new java.awt.Dimension(800, 46));
        lFiller78.setBackground(new java.awt.Color(140, 160, 210));
        lFiller78.setText("   ");
        lFiller78.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller78.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller78.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel5.add(lFiller78);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.X_AXIS));

        jPanel1.setBackground(new java.awt.Color(140, 160, 210));
        jPanel1.setMaximumSize(new java.awt.Dimension(255, 46));
        jPanel1.setMinimumSize(new java.awt.Dimension(275, 46));
        jPanel1.setPreferredSize(new java.awt.Dimension(275, 46));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setBackground(new java.awt.Color(140, 160, 210));
        rbPaymentPreview.setBackground(new java.awt.Color(140, 160, 210));
        rbPaymentPreview.setFont(new java.awt.Font("Arial", 0, 12));
        rbPaymentPreview.setSelected(true);
        rbPaymentPreview.setText("Information Window Scrollbar");
        rbPaymentPreview.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rbPaymentPreview.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        rbPaymentPreview.setMaximumSize(new java.awt.Dimension(188, 23));
        rbPaymentPreview.setMinimumSize(new java.awt.Dimension(188, 23));
        rbPaymentPreview.setPreferredSize(new java.awt.Dimension(188, 23));
        rbPaymentPreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPaymentPreviewActionPerformed(evt);
            }
        });

        jPanel2.add(rbPaymentPreview);

        rbPaymentSuccessPreview.setBackground(new java.awt.Color(140, 160, 210));
        rbPaymentSuccessPreview.setFont(new java.awt.Font("Arial", 0, 12));
        rbPaymentSuccessPreview.setText("Message Window Scrollbar");
        rbPaymentSuccessPreview.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rbPaymentSuccessPreview.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        rbPaymentSuccessPreview.setMaximumSize(new java.awt.Dimension(188, 23));
        rbPaymentSuccessPreview.setMinimumSize(new java.awt.Dimension(188, 23));
        rbPaymentSuccessPreview.setPreferredSize(new java.awt.Dimension(188, 23));
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

        lFiller79.setBackground(new java.awt.Color(140, 160, 210));
        lFiller79.setText("   ");
        lFiller79.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller79.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller79.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel5.add(lFiller79);

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

    private void ImageButtonPathChooseButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonPathChooseButton1ActionPerformed
	try
	{
		int result = imageFileChooser.showOpenDialog(this); 
        	if(result == JFileChooser.APPROVE_OPTION) 
        	{ 
                    ProjectManager.put("sbMsgThumbImagePath", imageFileChooser.getSelectedFile().toURL().toString());
                    tfImageButtonPath1.setText(new File(new URL(ProjectManager.get("sbMsgThumbImagePath")).getFile()).getCanonicalPath());
                    tfImageButtonPath1.setCaretPosition(0);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_ImageButtonPathChooseButton1ActionPerformed

    private void ImageButtonPathDefaultButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonPathDefaultButton1ActionPerformed
        try
        {
            ProjectManager.put("sbMsgThumbImagePath", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/images/mthumb.png").toString());
            tfImageButtonPath1.setText(new File(new URL(ProjectManager.get("sbMsgThumbImagePath")).getFile()).getCanonicalPath());
            tfImageButtonPath1.setCaretPosition(0);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ImageButtonPathDefaultButton1ActionPerformed

    private void useDefaultProgressBarShadowBorderColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultProgressBarShadowBorderColorActionPerformed
        try
        {
            if(useDefaultProgressBarShadowBorderColor.isSelected()==true)
            {
                ProjectManager.put("sbTrackHighlightColor", "");
                progressBarShadowBorderColorChooserButton.setVisible(false);                      
            }
            else
            {
                progressBarShadowBorderColorChooserButton.setVisible(true);  
                updateShadowBorderColorSwatch();            
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_useDefaultProgressBarShadowBorderColorActionPerformed

    private void progressBarShadowBorderColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progressBarShadowBorderColorChooserButtonActionPerformed
 	// Bring up a color chooser 
        if(ProjectManager.get("sbTrackHighlightColor")!=null)
        {
            if(ProjectManager.get("sbTrackHighlightColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("sbTrackHighlightColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("sbTrackHighlightColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                progressBarShadowBorderColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("sbTrackHighlightColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressBarShadowBorderColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("sbTrackHighlightColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressBarShadowBorderColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_progressBarShadowBorderColorChooserButtonActionPerformed

    private void useDefaultProgressBarHighlightBorderColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultProgressBarHighlightBorderColorActionPerformed
        try
        {
            if(useDefaultProgressBarHighlightBorderColor.isSelected()==true)
            {
                ProjectManager.put("sbTrackColor", "");
                progressBarHighlightBorderColorChooserButton.setVisible(false);                      
            }
            else
            {
                progressBarHighlightBorderColorChooserButton.setVisible(true);  
                updateHighlightBorderColorSwatch();            
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_useDefaultProgressBarHighlightBorderColorActionPerformed

    private void progressBarHighlightBorderColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progressBarHighlightBorderColorChooserButtonActionPerformed
 	// Bring up a color chooser 
        if(ProjectManager.get("sbTrackColor")!=null)
        {
            if(ProjectManager.get("sbTrackColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("sbTrackColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("sbTrackColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                progressBarHighlightBorderColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("sbTrackColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressBarHighlightBorderColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("sbTrackColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressBarHighlightBorderColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_progressBarHighlightBorderColorChooserButtonActionPerformed

    private void useDefaultProgressBarBackgroundColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultProgressBarBackgroundColorActionPerformed
        try
        {
            if(useDefaultProgressBarBackgroundColor.isSelected()==true)
            {
                ProjectManager.put("sbLtHighlightArrowBtnColor", "");
                progressBarBackgroundColorChooserButton.setVisible(false);                      
            }
            else
            {
                progressBarBackgroundColorChooserButton.setVisible(true);  
                updateProgressBarBackgroundColorSwatch();            
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_useDefaultProgressBarBackgroundColorActionPerformed

    private void progressBarBackgroundColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progressBarBackgroundColorChooserButtonActionPerformed
 	// Bring up a color chooser 
        if(ProjectManager.get("sbLtHighlightArrowBtnColor")!=null)
        {
            if(ProjectManager.get("sbLtHighlightArrowBtnColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("sbLtHighlightArrowBtnColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("sbLtHighlightArrowBtnColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                progressBarBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("sbLtHighlightArrowBtnColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressBarBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("sbLtHighlightArrowBtnColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressBarBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_progressBarBackgroundColorChooserButtonActionPerformed

    private void useDefaultProgressBarFillColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultProgressBarFillColorActionPerformed
        try
        {
            if(useDefaultProgressBarFillColor.isSelected()==true)
            {
                ProjectManager.put("sbDarkShadowArrowBtnColor", "");
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
        if(ProjectManager.get("sbDarkShadowArrowBtnColor")!=null)
        {
            if(ProjectManager.get("sbDarkShadowArrowBtnColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("sbDarkShadowArrowBtnColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("sbDarkShadowArrowBtnColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                progressBarFillColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("sbDarkShadowArrowBtnColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressBarFillColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("sbDarkShadowArrowBtnColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressBarFillColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_progressBarFillColorChooserButtonActionPerformed

    private void useDefaultProgressPanelLeftBorderColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultProgressPanelLeftBorderColorActionPerformed
       try
        {
            if(useDefaultProgressPanelLeftBorderColor.isSelected()==true)
            {
                ProjectManager.put("sbShadowArrowBtnColor", "");
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
        if(ProjectManager.get("sbShadowArrowBtnColor")!=null)
        {
            if(ProjectManager.get("sbShadowArrowBtnColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("sbShadowArrowBtnColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("sbShadowArrowBtnColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                progressPanelLeftBorderColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("sbShadowArrowBtnColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressPanelLeftBorderColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("sbShadowArrowBtnColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressPanelLeftBorderColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_progressPanelLeftBorderColorChooserButtonActionPerformed

    private void useDefaultProgressPanelTextColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultProgressPanelTextColorActionPerformed
        try
        {
            if(useDefaultProgressPanelTextColor.isSelected()==true)
            {
                ProjectManager.put("sbBGArrowBtnColor", "");
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
        if(ProjectManager.get("sbBGArrowBtnColor")!=null)
        {
            if(ProjectManager.get("sbBGArrowBtnColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("sbBGArrowBtnColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("sbBGArrowBtnColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                progressPanelTextColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("sbBGArrowBtnColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressPanelTextColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("sbBGArrowBtnColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressPanelTextColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_progressPanelTextColorChooserButtonActionPerformed

    private void useDefaultButtonBarBackgroundColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultButtonBarBackgroundColorActionPerformed
        try
        {
            if(useDefaultButtonBarBackgroundColor.isSelected()==true)
            {
                ProjectManager.put("sbForegroundColor", "");
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
        if(ProjectManager.get("sbForegroundColor")!=null)
        {
            if(ProjectManager.get("sbForegroundColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("sbForegroundColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("sbForegroundColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ButtonBarBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("sbForegroundColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                ButtonBarBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("sbForegroundColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                ButtonBarBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_ButtonBarBackgroundColorChooserButtonActionPerformed

    private void useDefaultButtonBarTextColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultButtonBarTextColorActionPerformed
        try
        {
            if(useDefaultButtonBarTextColor.isSelected()==true)
            {
                ProjectManager.put("sbBackgroundColor", "");
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
        if(ProjectManager.get("sbBackgroundColor")!=null)
        {
            if(ProjectManager.get("sbBackgroundColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("sbBackgroundColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("sbBackgroundColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                buttonBarTextColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("sbBackgroundColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                buttonBarTextColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("sbBackgroundColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                buttonBarTextColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_buttonBarTextColorChooserButtonActionPerformed

    private void ImageButtonPathChooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonPathChooseButtonActionPerformed
	try
	{
		int result = imageFileChooser.showOpenDialog(this); 
        	if(result == JFileChooser.APPROVE_OPTION) 
        	{ 
                    ProjectManager.put("sbThumbImagePath", imageFileChooser.getSelectedFile().toURL().toString());
                    tfImageButtonPath.setText(new File(new URL(ProjectManager.get("sbThumbImagePath")).getFile()).getCanonicalPath());
                    tfImageButtonPath.setCaretPosition(0);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }//GEN-LAST:event_ImageButtonPathChooseButtonActionPerformed

    private void ImageButtonPathDefaultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageButtonPathDefaultButtonActionPerformed
        try
        {
            ProjectManager.put("sbThumbImagePath", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/images/thumb.png").toString());
            tfImageButtonPath.setText(new File(new URL(ProjectManager.get("sbThumbImagePath")).getFile()).getCanonicalPath());
            tfImageButtonPath.setCaretPosition(0);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ImageButtonPathDefaultButtonActionPerformed

///

    private void useImageButtonsEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useImageButtonsEnabledActionPerformed
        try
        {
            if(useImageButtonsEnabled.isSelected()==true)
            {
                ProjectManager.putTempNoFileWrite("customScrollBarsEnabled", "true");
            }
            else
            {
                 ProjectManager.putTempNoFileWrite("customScrollBarsEnabled", "false");           
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
                new InformationScrollbarDialogAction();	
            }
            else if(rbPaymentSuccessPreview.isSelected()==true)
            {
                ((EAPanel)getParentComponent()).getDataUpdate(); 
                new MessagingScrollbarAction();	          
            }                
        }
        catch(Exception e)
        {
               // e.printStackTrace();
        }
 
    }//GEN-LAST:event_PreviewButtonActionPerformed
 
    private void formFocusLost(java.awt.event.FocusEvent evt) {
    //getDataUpdate(); 
    }

    private void updateButtonBarTextColorSwatch()
    {
        try
        {
            Color c = new java.awt.Color(255,255,255); 
            // Bring up a color chooser 
            if(ProjectManager.get("sbBackgroundColor")!=null)
            {
                if(ProjectManager.get("sbBackgroundColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("sbBackgroundColor"));
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
            if(ProjectManager.get("sbForegroundColor")!=null)
            {
                if(ProjectManager.get("sbForegroundColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("sbForegroundColor"));
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
            if(ProjectManager.get("sbBGArrowBtnColor")!=null)
            {
                if(ProjectManager.get("sbBGArrowBtnColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("sbBGArrowBtnColor"));
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
            if(ProjectManager.get("sbShadowArrowBtnColor")!=null)
            {
                if(ProjectManager.get("sbShadowArrowBtnColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("sbShadowArrowBtnColor"));
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
    
    private void updateProgressBarBackgroundColorSwatch()
    {
        try
        { 
            Color c = new java.awt.Color(255,255,255); 
            // Bring up a color chooser 
            if(ProjectManager.get("sbLtHighlightArrowBtnColor")!=null)
            {
                if(ProjectManager.get("sbLtHighlightArrowBtnColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("sbLtHighlightArrowBtnColor"));
                    c = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()); 
                    progressBarBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
                }
                else
                {
                    progressBarBackgroundColorChooserButton.setIcon(noColorIcon);
                }
            }
            else
            {
                progressBarBackgroundColorChooserButton.setIcon(noColorIcon);
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
            if(ProjectManager.get("sbDarkShadowArrowBtnColor")!=null)
            {
                if(ProjectManager.get("sbDarkShadowArrowBtnColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("sbDarkShadowArrowBtnColor"));
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
//
    private void updateHighlightBorderColorSwatch()
    {
        try
        { 
            Color c = new java.awt.Color(255,255,255); 
            // Bring up a color chooser 
            if(ProjectManager.get("sbTrackColor")!=null)
            {
                if(ProjectManager.get("sbTrackColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("sbTrackColor"));
                    c = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()); 
                    progressBarHighlightBorderColorChooserButton.setIcon(new ColorSwatch(c));
                }
                else
                {
                    progressBarHighlightBorderColorChooserButton.setIcon(noColorIcon);
                }
            }
            else
            {
                progressBarHighlightBorderColorChooserButton.setIcon(noColorIcon);
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
            Color c = new java.awt.Color(255,255,255); 
            // Bring up a color chooser 
            if(ProjectManager.get("sbTrackHighlightColor")!=null)
            {
                if(ProjectManager.get("sbTrackHighlightColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("sbTrackHighlightColor"));
                    c = new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue()); 
                    progressBarShadowBorderColorChooserButton.setIcon(new ColorSwatch(c));
                }
                else
                {
                    progressBarShadowBorderColorChooserButton.setIcon(noColorIcon);
                }
            }
            else
            {
                progressBarShadowBorderColorChooserButton.setIcon(noColorIcon);
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
    private javax.swing.JButton ButtonBarBackgroundColorChooserButton;
    private javax.swing.JButton ImageButtonPathChooseButton;
    private javax.swing.JButton ImageButtonPathChooseButton1;
    private javax.swing.JButton ImageButtonPathDefaultButton;
    private javax.swing.JButton ImageButtonPathDefaultButton1;
    private javax.swing.JPanel ImageDescriptionLabel;
    private javax.swing.JLabel LeftUIFiller2;
    private javax.swing.JButton PreviewButton;
    private javax.swing.JPanel ProjectLocationsCenterPanel2;
    private javax.swing.JPanel ProjectLocationsCenterPanel3;
    private javax.swing.JPanel ProjectLocationsCenterPanel5;
    private javax.swing.JPanel ProjectLookAndFeelImages;
    private javax.swing.JPanel ProjectLookAndFeelImages4;
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
    private javax.swing.JButton buttonBarTextColorChooserButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lBuildLocation2;
    private javax.swing.JLabel lBuildLocation3;
    private javax.swing.JLabel lFiller25;
    private javax.swing.JLabel lFiller26;
    private javax.swing.JLabel lFiller30;
    private javax.swing.JLabel lFiller31;
    private javax.swing.JLabel lFiller32;
    private javax.swing.JLabel lFiller33;
    private javax.swing.JLabel lFiller34;
    private javax.swing.JLabel lFiller35;
    private javax.swing.JLabel lFiller36;
    private javax.swing.JLabel lFiller37;
    private javax.swing.JLabel lFiller38;
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
    private javax.swing.JLabel lFiller66;
    private javax.swing.JLabel lFiller67;
    private javax.swing.JLabel lFiller68;
    private javax.swing.JLabel lFiller69;
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
    private javax.swing.JButton progressBarBackgroundColorChooserButton;
    private javax.swing.JButton progressBarFillColorChooserButton;
    private javax.swing.JButton progressBarHighlightBorderColorChooserButton;
    private javax.swing.JButton progressBarShadowBorderColorChooserButton;
    private javax.swing.JButton progressPanelLeftBorderColorChooserButton;
    private javax.swing.JButton progressPanelTextColorChooserButton;
    private javax.swing.JRadioButton rbPaymentPreview;
    private javax.swing.JRadioButton rbPaymentSuccessPreview;
    private javax.swing.JTextField tfImageButtonPath;
    private javax.swing.JTextField tfImageButtonPath1;
    private javax.swing.JCheckBox useDefaultButtonBarBackgroundColor;
    private javax.swing.JCheckBox useDefaultButtonBarTextColor;
    private javax.swing.JCheckBox useDefaultProgressBarBackgroundColor;
    private javax.swing.JCheckBox useDefaultProgressBarFillColor;
    private javax.swing.JCheckBox useDefaultProgressBarHighlightBorderColor;
    private javax.swing.JCheckBox useDefaultProgressBarShadowBorderColor;
    private javax.swing.JCheckBox useDefaultProgressPanelLeftBorderColor;
    private javax.swing.JCheckBox useDefaultProgressPanelTextColor;
    private javax.swing.JCheckBox useImageButtonsEnabled;
    // End of variables declaration//GEN-END:variables
    
}
