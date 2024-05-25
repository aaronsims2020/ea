/*
 * ImagesPanel.java
 *
 * Created on June 13, 2004, 3:24 PM
 */

package com.trinity.ea.design.project.lookandfeel.colors;
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
public class ColorsPanel extends EAPanel {
    private ImageIcon noColorIcon = new ImageIcon(getClass().getResource("/images/nocolor.png"));
    /** Creates new form ImagesPanel */
    public ColorsPanel() 
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
            //ProjectManager.saveTempNow(); 
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
            if(ProjectManager.get("btnBarTextColor")!=null)
            {
                if(ProjectManager.get("btnBarTextColor").equalsIgnoreCase("")==false)
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
            
            
            if(ProjectManager.get("btnBarBGColor")!=null)
            {
                if(ProjectManager.get("btnBarBGColor").equalsIgnoreCase("")==false)
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
            
            
            if(ProjectManager.get("progressPanelTextColor")!=null)
            {
                if(ProjectManager.get("progressPanelTextColor").equalsIgnoreCase("")==false)
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
            
            
             if(ProjectManager.get("progressPanelLeftBorderColor")!=null)
            {
                if(ProjectManager.get("progressPanelLeftBorderColor").equalsIgnoreCase("")==false)
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
            
            
            if(ProjectManager.get("progressBarColor")!=null)
            {
                if(ProjectManager.get("progressBarColor").equalsIgnoreCase("")==false)
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
            
            
            if(ProjectManager.get("progressBarBGColor")!=null)
            {
                if(ProjectManager.get("progressBarBGColor").equalsIgnoreCase("")==false)
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
            
            
            if(ProjectManager.get("progressBarHighlightBorderColor")!=null)
            {
                if(ProjectManager.get("progressBarHighlightBorderColor").equalsIgnoreCase("")==false)
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
            
            
             if(ProjectManager.get("progressBarShadowBorderColor")!=null)
            {
                if(ProjectManager.get("progressBarShadowBorderColor").equalsIgnoreCase("")==false)
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
        UIChoicesBottomPanel7 = new javax.swing.JPanel();
        UIChoicesBottomPanel5 = new javax.swing.JPanel();
        lFiller43 = new javax.swing.JLabel();
        useDefaultButtonBarTextColor = new javax.swing.JCheckBox();
        buttonBarTextColorChooserButton = new javax.swing.JButton();
        lFiller44 = new javax.swing.JLabel();
        lFiller57 = new javax.swing.JLabel();
        lFiller49 = new javax.swing.JLabel();
        ProjectLookAndFeelImages1 = new javax.swing.JPanel();
        UIChoicesBottomPanel8 = new javax.swing.JPanel();
        UIChoicesBottomPanel6 = new javax.swing.JPanel();
        lFiller46 = new javax.swing.JLabel();
        useDefaultButtonBarBackgroundColor = new javax.swing.JCheckBox();
        ButtonBarBackgroundColorChooserButton = new javax.swing.JButton();
        lFiller58 = new javax.swing.JLabel();
        lFiller50 = new javax.swing.JLabel();
        lFiller51 = new javax.swing.JLabel();
        ProjectLookAndFeelImages2 = new javax.swing.JPanel();
        UIChoicesBottomPanel9 = new javax.swing.JPanel();
        UIChoicesBottomPanel10 = new javax.swing.JPanel();
        lFiller52 = new javax.swing.JLabel();
        useDefaultProgressPanelTextColor = new javax.swing.JCheckBox();
        progressPanelTextColorChooserButton = new javax.swing.JButton();
        lFiller53 = new javax.swing.JLabel();
        lFiller59 = new javax.swing.JLabel();
        lFiller54 = new javax.swing.JLabel();
        ProjectLookAndFeelImages4 = new javax.swing.JPanel();
        UIChoicesBottomPanel11 = new javax.swing.JPanel();
        UIChoicesBottomPanel12 = new javax.swing.JPanel();
        lFiller55 = new javax.swing.JLabel();
        useDefaultProgressPanelLeftBorderColor = new javax.swing.JCheckBox();
        progressPanelLeftBorderColorChooserButton = new javax.swing.JButton();
        lFiller56 = new javax.swing.JLabel();
        lFiller60 = new javax.swing.JLabel();
        lFiller61 = new javax.swing.JLabel();
        ProjectLookAndFeelImages5 = new javax.swing.JPanel();
        UIChoicesBottomPanel13 = new javax.swing.JPanel();
        UIChoicesBottomPanel14 = new javax.swing.JPanel();
        lFiller62 = new javax.swing.JLabel();
        useDefaultProgressBarFillColor = new javax.swing.JCheckBox();
        progressBarFillColorChooserButton = new javax.swing.JButton();
        lFiller63 = new javax.swing.JLabel();
        lFiller64 = new javax.swing.JLabel();
        lFiller65 = new javax.swing.JLabel();
        ProjectLookAndFeelImages6 = new javax.swing.JPanel();
        UIChoicesBottomPanel15 = new javax.swing.JPanel();
        UIChoicesBottomPanel16 = new javax.swing.JPanel();
        lFiller66 = new javax.swing.JLabel();
        useDefaultProgressBarBackgroundColor = new javax.swing.JCheckBox();
        progressBarBackgroundColorChooserButton = new javax.swing.JButton();
        lFiller67 = new javax.swing.JLabel();
        lFiller68 = new javax.swing.JLabel();
        lFiller69 = new javax.swing.JLabel();
        ProjectLookAndFeelImages7 = new javax.swing.JPanel();
        UIChoicesBottomPanel17 = new javax.swing.JPanel();
        UIChoicesBottomPanel18 = new javax.swing.JPanel();
        lFiller70 = new javax.swing.JLabel();
        useDefaultProgressBarHighlightBorderColor = new javax.swing.JCheckBox();
        progressBarHighlightBorderColorChooserButton = new javax.swing.JButton();
        lFiller71 = new javax.swing.JLabel();
        lFiller72 = new javax.swing.JLabel();
        lFiller73 = new javax.swing.JLabel();
        ProjectLookAndFeelImages8 = new javax.swing.JPanel();
        UIChoicesBottomPanel19 = new javax.swing.JPanel();
        UIChoicesBottomPanel20 = new javax.swing.JPanel();
        lFiller74 = new javax.swing.JLabel();
        useDefaultProgressBarShadowBorderColor = new javax.swing.JCheckBox();
        progressBarShadowBorderColorChooserButton = new javax.swing.JButton();
        lFiller75 = new javax.swing.JLabel();
        lFiller76 = new javax.swing.JLabel();
        lFiller77 = new javax.swing.JLabel();
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
        ProjectLookAndFeelImages.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Button Bar Text Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages.setMaximumSize(new java.awt.Dimension(32767, 58));
        ProjectLookAndFeelImages.setMinimumSize(new java.awt.Dimension(10, 58));
        ProjectLookAndFeelImages.setPreferredSize(new java.awt.Dimension(10, 58));
        UIChoicesBottomPanel7.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel7, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel7.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel7.setMaximumSize(new java.awt.Dimension(32767, 3));
        UIChoicesBottomPanel7.setMinimumSize(new java.awt.Dimension(5, 3));
        UIChoicesBottomPanel7.setPreferredSize(new java.awt.Dimension(200, 3));
        ProjectLookAndFeelImages.add(UIChoicesBottomPanel7);

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

        useDefaultButtonBarTextColor.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultButtonBarTextColor.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultButtonBarTextColor.setSelected(true);
        useDefaultButtonBarTextColor.setText("Use default button bar text color");
        useDefaultButtonBarTextColor.setMaximumSize(new java.awt.Dimension(300, 23));
        useDefaultButtonBarTextColor.setMinimumSize(new java.awt.Dimension(300, 23));
        useDefaultButtonBarTextColor.setPreferredSize(new java.awt.Dimension(300, 23));
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

        add(ProjectLookAndFeelImages);

        ProjectLookAndFeelImages1.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages1, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages1.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages1.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Button Bar Background Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages1.setMaximumSize(new java.awt.Dimension(32767, 58));
        ProjectLookAndFeelImages1.setMinimumSize(new java.awt.Dimension(10, 58));
        ProjectLookAndFeelImages1.setPreferredSize(new java.awt.Dimension(10, 58));
        UIChoicesBottomPanel8.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel8, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel8.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel8.setMaximumSize(new java.awt.Dimension(32767, 3));
        UIChoicesBottomPanel8.setMinimumSize(new java.awt.Dimension(5, 3));
        UIChoicesBottomPanel8.setPreferredSize(new java.awt.Dimension(200, 3));
        ProjectLookAndFeelImages1.add(UIChoicesBottomPanel8);

        UIChoicesBottomPanel6.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel6, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel6.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel6.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel6.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel6.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller46.setBackground(new java.awt.Color(140, 160, 210));
        lFiller46.setText("   ");
        lFiller46.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller46.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller46.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel6.add(lFiller46);

        useDefaultButtonBarBackgroundColor.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultButtonBarBackgroundColor.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultButtonBarBackgroundColor.setSelected(true);
        useDefaultButtonBarBackgroundColor.setText("Use default button bar background color");
        useDefaultButtonBarBackgroundColor.setMaximumSize(new java.awt.Dimension(300, 23));
        useDefaultButtonBarBackgroundColor.setMinimumSize(new java.awt.Dimension(300, 23));
        useDefaultButtonBarBackgroundColor.setPreferredSize(new java.awt.Dimension(300, 23));
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

        ProjectLookAndFeelImages1.add(UIChoicesBottomPanel6);

        add(ProjectLookAndFeelImages1);

        ProjectLookAndFeelImages2.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages2, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages2.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages2.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Progress Panel Text Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages2.setMaximumSize(new java.awt.Dimension(32767, 58));
        ProjectLookAndFeelImages2.setMinimumSize(new java.awt.Dimension(10, 58));
        ProjectLookAndFeelImages2.setPreferredSize(new java.awt.Dimension(10, 58));
        UIChoicesBottomPanel9.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel9, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel9.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel9.setMaximumSize(new java.awt.Dimension(32767, 3));
        UIChoicesBottomPanel9.setMinimumSize(new java.awt.Dimension(5, 3));
        UIChoicesBottomPanel9.setPreferredSize(new java.awt.Dimension(200, 3));
        ProjectLookAndFeelImages2.add(UIChoicesBottomPanel9);

        UIChoicesBottomPanel10.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel10, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel10.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel10.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel10.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel10.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller52.setBackground(new java.awt.Color(140, 160, 210));
        lFiller52.setText("   ");
        lFiller52.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller52.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller52.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel10.add(lFiller52);

        useDefaultProgressPanelTextColor.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultProgressPanelTextColor.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultProgressPanelTextColor.setSelected(true);
        useDefaultProgressPanelTextColor.setText("Use default progress panel text color");
        useDefaultProgressPanelTextColor.setMaximumSize(new java.awt.Dimension(300, 23));
        useDefaultProgressPanelTextColor.setMinimumSize(new java.awt.Dimension(300, 23));
        useDefaultProgressPanelTextColor.setPreferredSize(new java.awt.Dimension(300, 23));
        useDefaultProgressPanelTextColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultProgressPanelTextColorActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel10.add(useDefaultProgressPanelTextColor);

        progressPanelTextColorChooserButton.setBackground(new java.awt.Color(140, 160, 210));
        progressPanelTextColorChooserButton.setMaximumSize(new java.awt.Dimension(35, 20));
        progressPanelTextColorChooserButton.setMinimumSize(new java.awt.Dimension(35, 20));
        progressPanelTextColorChooserButton.setPreferredSize(new java.awt.Dimension(35, 20));
        progressPanelTextColorChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progressPanelTextColorChooserButtonActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel10.add(progressPanelTextColorChooserButton);

        lFiller53.setBackground(new java.awt.Color(140, 160, 210));
        lFiller53.setText("   ");
        lFiller53.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller53.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller53.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel10.add(lFiller53);

        lFiller59.setBackground(new java.awt.Color(140, 160, 210));
        lFiller59.setText("   ");
        lFiller59.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller59.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller59.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel10.add(lFiller59);

        lFiller54.setBackground(new java.awt.Color(140, 160, 210));
        lFiller54.setText("   ");
        lFiller54.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller54.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller54.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel10.add(lFiller54);

        ProjectLookAndFeelImages2.add(UIChoicesBottomPanel10);

        add(ProjectLookAndFeelImages2);

        ProjectLookAndFeelImages4.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages4, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages4.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages4.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Progress Panel Left Border Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages4.setMaximumSize(new java.awt.Dimension(32767, 58));
        ProjectLookAndFeelImages4.setMinimumSize(new java.awt.Dimension(10, 58));
        ProjectLookAndFeelImages4.setPreferredSize(new java.awt.Dimension(10, 58));
        UIChoicesBottomPanel11.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel11, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel11.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel11.setMaximumSize(new java.awt.Dimension(32767, 3));
        UIChoicesBottomPanel11.setMinimumSize(new java.awt.Dimension(5, 3));
        UIChoicesBottomPanel11.setPreferredSize(new java.awt.Dimension(200, 3));
        ProjectLookAndFeelImages4.add(UIChoicesBottomPanel11);

        UIChoicesBottomPanel12.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel12, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel12.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel12.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel12.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel12.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller55.setBackground(new java.awt.Color(140, 160, 210));
        lFiller55.setText("   ");
        lFiller55.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller55.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller55.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel12.add(lFiller55);

        useDefaultProgressPanelLeftBorderColor.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultProgressPanelLeftBorderColor.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultProgressPanelLeftBorderColor.setSelected(true);
        useDefaultProgressPanelLeftBorderColor.setText("Use default progress panel left border color");
        useDefaultProgressPanelLeftBorderColor.setMaximumSize(new java.awt.Dimension(300, 23));
        useDefaultProgressPanelLeftBorderColor.setPreferredSize(new java.awt.Dimension(300, 23));
        useDefaultProgressPanelLeftBorderColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultProgressPanelLeftBorderColorActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel12.add(useDefaultProgressPanelLeftBorderColor);

        progressPanelLeftBorderColorChooserButton.setBackground(new java.awt.Color(140, 160, 210));
        progressPanelLeftBorderColorChooserButton.setMaximumSize(new java.awt.Dimension(35, 20));
        progressPanelLeftBorderColorChooserButton.setMinimumSize(new java.awt.Dimension(35, 20));
        progressPanelLeftBorderColorChooserButton.setPreferredSize(new java.awt.Dimension(35, 20));
        progressPanelLeftBorderColorChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progressPanelLeftBorderColorChooserButtonActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel12.add(progressPanelLeftBorderColorChooserButton);

        lFiller56.setBackground(new java.awt.Color(140, 160, 210));
        lFiller56.setText("   ");
        lFiller56.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller56.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller56.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel12.add(lFiller56);

        lFiller60.setBackground(new java.awt.Color(140, 160, 210));
        lFiller60.setText("   ");
        lFiller60.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller60.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller60.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel12.add(lFiller60);

        lFiller61.setBackground(new java.awt.Color(140, 160, 210));
        lFiller61.setText("   ");
        lFiller61.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller61.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller61.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel12.add(lFiller61);

        ProjectLookAndFeelImages4.add(UIChoicesBottomPanel12);

        add(ProjectLookAndFeelImages4);

        ProjectLookAndFeelImages5.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages5, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages5.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages5.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Progress Bar Fill Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages5.setMaximumSize(new java.awt.Dimension(32767, 58));
        ProjectLookAndFeelImages5.setMinimumSize(new java.awt.Dimension(10, 58));
        ProjectLookAndFeelImages5.setPreferredSize(new java.awt.Dimension(10, 58));
        UIChoicesBottomPanel13.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel13, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel13.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel13.setMaximumSize(new java.awt.Dimension(32767, 3));
        UIChoicesBottomPanel13.setMinimumSize(new java.awt.Dimension(5, 3));
        UIChoicesBottomPanel13.setPreferredSize(new java.awt.Dimension(200, 3));
        ProjectLookAndFeelImages5.add(UIChoicesBottomPanel13);

        UIChoicesBottomPanel14.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel14, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel14.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel14.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel14.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel14.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller62.setBackground(new java.awt.Color(140, 160, 210));
        lFiller62.setText("   ");
        lFiller62.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller62.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller62.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel14.add(lFiller62);

        useDefaultProgressBarFillColor.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultProgressBarFillColor.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultProgressBarFillColor.setSelected(true);
        useDefaultProgressBarFillColor.setText("Use default progress bar fill color");
        useDefaultProgressBarFillColor.setMaximumSize(new java.awt.Dimension(300, 23));
        useDefaultProgressBarFillColor.setMinimumSize(new java.awt.Dimension(300, 23));
        useDefaultProgressBarFillColor.setPreferredSize(new java.awt.Dimension(300, 23));
        useDefaultProgressBarFillColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultProgressBarFillColorActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel14.add(useDefaultProgressBarFillColor);

        progressBarFillColorChooserButton.setBackground(new java.awt.Color(140, 160, 210));
        progressBarFillColorChooserButton.setMaximumSize(new java.awt.Dimension(35, 20));
        progressBarFillColorChooserButton.setMinimumSize(new java.awt.Dimension(35, 20));
        progressBarFillColorChooserButton.setPreferredSize(new java.awt.Dimension(35, 20));
        progressBarFillColorChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progressBarFillColorChooserButtonActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel14.add(progressBarFillColorChooserButton);

        lFiller63.setBackground(new java.awt.Color(140, 160, 210));
        lFiller63.setText("   ");
        lFiller63.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller63.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller63.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel14.add(lFiller63);

        lFiller64.setBackground(new java.awt.Color(140, 160, 210));
        lFiller64.setText("   ");
        lFiller64.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller64.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller64.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel14.add(lFiller64);

        lFiller65.setBackground(new java.awt.Color(140, 160, 210));
        lFiller65.setText("   ");
        lFiller65.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller65.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller65.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel14.add(lFiller65);

        ProjectLookAndFeelImages5.add(UIChoicesBottomPanel14);

        add(ProjectLookAndFeelImages5);

        ProjectLookAndFeelImages6.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages6, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages6.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages6.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Progress Bar Background Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages6.setMaximumSize(new java.awt.Dimension(32767, 58));
        ProjectLookAndFeelImages6.setMinimumSize(new java.awt.Dimension(10, 58));
        ProjectLookAndFeelImages6.setPreferredSize(new java.awt.Dimension(10, 58));
        UIChoicesBottomPanel15.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel15, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel15.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel15.setMaximumSize(new java.awt.Dimension(32767, 3));
        UIChoicesBottomPanel15.setMinimumSize(new java.awt.Dimension(5, 3));
        UIChoicesBottomPanel15.setPreferredSize(new java.awt.Dimension(200, 3));
        ProjectLookAndFeelImages6.add(UIChoicesBottomPanel15);

        UIChoicesBottomPanel16.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel16, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel16.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel16.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel16.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel16.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller66.setBackground(new java.awt.Color(140, 160, 210));
        lFiller66.setText("   ");
        lFiller66.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller66.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller66.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel16.add(lFiller66);

        useDefaultProgressBarBackgroundColor.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultProgressBarBackgroundColor.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultProgressBarBackgroundColor.setSelected(true);
        useDefaultProgressBarBackgroundColor.setText("Use default progress bar background color");
        useDefaultProgressBarBackgroundColor.setMaximumSize(new java.awt.Dimension(300, 23));
        useDefaultProgressBarBackgroundColor.setMinimumSize(new java.awt.Dimension(300, 23));
        useDefaultProgressBarBackgroundColor.setPreferredSize(new java.awt.Dimension(300, 23));
        useDefaultProgressBarBackgroundColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultProgressBarBackgroundColorActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel16.add(useDefaultProgressBarBackgroundColor);

        progressBarBackgroundColorChooserButton.setBackground(new java.awt.Color(140, 160, 210));
        progressBarBackgroundColorChooserButton.setMaximumSize(new java.awt.Dimension(35, 20));
        progressBarBackgroundColorChooserButton.setMinimumSize(new java.awt.Dimension(35, 20));
        progressBarBackgroundColorChooserButton.setPreferredSize(new java.awt.Dimension(35, 20));
        progressBarBackgroundColorChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progressBarBackgroundColorChooserButtonActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel16.add(progressBarBackgroundColorChooserButton);

        lFiller67.setBackground(new java.awt.Color(140, 160, 210));
        lFiller67.setText("   ");
        lFiller67.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller67.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller67.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel16.add(lFiller67);

        lFiller68.setBackground(new java.awt.Color(140, 160, 210));
        lFiller68.setText("   ");
        lFiller68.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller68.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller68.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel16.add(lFiller68);

        lFiller69.setBackground(new java.awt.Color(140, 160, 210));
        lFiller69.setText("   ");
        lFiller69.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller69.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller69.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel16.add(lFiller69);

        ProjectLookAndFeelImages6.add(UIChoicesBottomPanel16);

        add(ProjectLookAndFeelImages6);

        ProjectLookAndFeelImages7.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages7, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages7.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages7.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Progress Bar Highlight Border Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages7.setMaximumSize(new java.awt.Dimension(32767, 58));
        ProjectLookAndFeelImages7.setMinimumSize(new java.awt.Dimension(10, 58));
        ProjectLookAndFeelImages7.setPreferredSize(new java.awt.Dimension(10, 58));
        UIChoicesBottomPanel17.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel17, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel17.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel17.setMaximumSize(new java.awt.Dimension(32767, 3));
        UIChoicesBottomPanel17.setMinimumSize(new java.awt.Dimension(5, 3));
        UIChoicesBottomPanel17.setPreferredSize(new java.awt.Dimension(200, 3));
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

        useDefaultProgressBarHighlightBorderColor.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultProgressBarHighlightBorderColor.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultProgressBarHighlightBorderColor.setSelected(true);
        useDefaultProgressBarHighlightBorderColor.setText("Use default progress bar highlight border color");
        useDefaultProgressBarHighlightBorderColor.setMaximumSize(new java.awt.Dimension(300, 23));
        useDefaultProgressBarHighlightBorderColor.setMinimumSize(new java.awt.Dimension(300, 23));
        useDefaultProgressBarHighlightBorderColor.setPreferredSize(new java.awt.Dimension(300, 23));
        useDefaultProgressBarHighlightBorderColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultProgressBarHighlightBorderColorActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel18.add(useDefaultProgressBarHighlightBorderColor);

        progressBarHighlightBorderColorChooserButton.setBackground(new java.awt.Color(140, 160, 210));
        progressBarHighlightBorderColorChooserButton.setMaximumSize(new java.awt.Dimension(35, 20));
        progressBarHighlightBorderColorChooserButton.setMinimumSize(new java.awt.Dimension(35, 20));
        progressBarHighlightBorderColorChooserButton.setPreferredSize(new java.awt.Dimension(35, 20));
        progressBarHighlightBorderColorChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progressBarHighlightBorderColorChooserButtonActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel18.add(progressBarHighlightBorderColorChooserButton);

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
        ProjectLookAndFeelImages8.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Progress Bar Shadow Border Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages8.setMaximumSize(new java.awt.Dimension(32767, 58));
        ProjectLookAndFeelImages8.setMinimumSize(new java.awt.Dimension(10, 58));
        ProjectLookAndFeelImages8.setPreferredSize(new java.awt.Dimension(10, 58));
        UIChoicesBottomPanel19.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel19, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel19.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel19.setMaximumSize(new java.awt.Dimension(32767, 3));
        UIChoicesBottomPanel19.setMinimumSize(new java.awt.Dimension(5, 3));
        UIChoicesBottomPanel19.setPreferredSize(new java.awt.Dimension(200, 3));
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

        useDefaultProgressBarShadowBorderColor.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultProgressBarShadowBorderColor.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultProgressBarShadowBorderColor.setSelected(true);
        useDefaultProgressBarShadowBorderColor.setText("Use default progress bar shadow border color");
        useDefaultProgressBarShadowBorderColor.setMaximumSize(new java.awt.Dimension(300, 23));
        useDefaultProgressBarShadowBorderColor.setMinimumSize(new java.awt.Dimension(300, 23));
        useDefaultProgressBarShadowBorderColor.setPreferredSize(new java.awt.Dimension(300, 23));
        useDefaultProgressBarShadowBorderColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultProgressBarShadowBorderColorActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel20.add(useDefaultProgressBarShadowBorderColor);

        progressBarShadowBorderColorChooserButton.setBackground(new java.awt.Color(140, 160, 210));
        progressBarShadowBorderColorChooserButton.setMaximumSize(new java.awt.Dimension(35, 20));
        progressBarShadowBorderColorChooserButton.setMinimumSize(new java.awt.Dimension(35, 20));
        progressBarShadowBorderColorChooserButton.setPreferredSize(new java.awt.Dimension(35, 20));
        progressBarShadowBorderColorChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progressBarShadowBorderColorChooserButtonActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel20.add(progressBarShadowBorderColorChooserButton);

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

    private void progressBarShadowBorderColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progressBarShadowBorderColorChooserButtonActionPerformed
 	// Bring up a color chooser 
        if(ProjectManager.get("progressBarShadowBorderColor")!=null)
        {
            if(ProjectManager.get("progressBarShadowBorderColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("progressBarShadowBorderColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("progressBarShadowBorderColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                progressBarShadowBorderColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("progressBarShadowBorderColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressBarShadowBorderColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("progressBarShadowBorderColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressBarShadowBorderColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_progressBarShadowBorderColorChooserButtonActionPerformed

    private void progressBarHighlightBorderColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progressBarHighlightBorderColorChooserButtonActionPerformed
 	// Bring up a color chooser 
        if(ProjectManager.get("progressBarHighlightBorderColor")!=null)
        {
            if(ProjectManager.get("progressBarHighlightBorderColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("progressBarHighlightBorderColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("progressBarHighlightBorderColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                progressBarHighlightBorderColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("progressBarHighlightBorderColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressBarHighlightBorderColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("progressBarHighlightBorderColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressBarHighlightBorderColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_progressBarHighlightBorderColorChooserButtonActionPerformed

    private void progressBarBackgroundColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progressBarBackgroundColorChooserButtonActionPerformed
 	// Bring up a color chooser 
        if(ProjectManager.get("progressBarBGColor")!=null)
        {
            if(ProjectManager.get("progressBarBGColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("progressBarBGColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("progressBarBGColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                progressBarBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("progressBarBGColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressBarBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("progressBarBGColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressBarBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_progressBarBackgroundColorChooserButtonActionPerformed

    private void progressBarFillColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progressBarFillColorChooserButtonActionPerformed
 	// Bring up a color chooser 
        if(ProjectManager.get("progressBarColor")!=null)
        {
            if(ProjectManager.get("progressBarColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("progressBarColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("progressBarColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                progressBarFillColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("progressBarColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressBarFillColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("progressBarColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressBarFillColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_progressBarFillColorChooserButtonActionPerformed

    private void progressPanelLeftBorderColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progressPanelLeftBorderColorChooserButtonActionPerformed
 	// Bring up a color chooser 
        if(ProjectManager.get("progressPanelLeftBorderColor")!=null)
        {
            if(ProjectManager.get("progressPanelLeftBorderColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("progressPanelLeftBorderColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("progressPanelLeftBorderColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                progressPanelLeftBorderColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("progressPanelLeftBorderColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressPanelLeftBorderColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("progressPanelLeftBorderColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressPanelLeftBorderColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_progressPanelLeftBorderColorChooserButtonActionPerformed

    private void progressPanelTextColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progressPanelTextColorChooserButtonActionPerformed
 	// Bring up a color chooser 
        if(ProjectManager.get("progressPanelTextColor")!=null)
        {
            if(ProjectManager.get("progressPanelTextColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("progressPanelTextColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("progressPanelTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                progressPanelTextColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("progressPanelTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressPanelTextColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("progressPanelTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressPanelTextColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_progressPanelTextColorChooserButtonActionPerformed

    private void ButtonBarBackgroundColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBarBackgroundColorChooserButtonActionPerformed
 	// Bring up a color chooser 
        if(ProjectManager.get("btnBarBGColor")!=null)
        {
            if(ProjectManager.get("btnBarBGColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("btnBarBGColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("btnBarBGColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ButtonBarBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("btnBarBGColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                ButtonBarBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("btnBarBGColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                ButtonBarBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
        }

    }//GEN-LAST:event_ButtonBarBackgroundColorChooserButtonActionPerformed

    private void useDefaultProgressBarShadowBorderColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultProgressBarShadowBorderColorActionPerformed
        try
        {
            if(useDefaultProgressBarShadowBorderColor.isSelected()==true)
            {
                ProjectManager.put("progressBarShadowBorderColor", "");
                ProjectManager.remove("progressBarShadowBorderColor");                
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

    private void useDefaultProgressBarHighlightBorderColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultProgressBarHighlightBorderColorActionPerformed
        try
        {
            if(useDefaultProgressBarHighlightBorderColor.isSelected()==true)
            {
                ProjectManager.put("progressBarHighlightBorderColor", "");
                ProjectManager.remove("progressBarHighlightBorderColor");                
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

    private void useDefaultProgressBarBackgroundColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultProgressBarBackgroundColorActionPerformed

        try
        {
            if(useDefaultProgressBarBackgroundColor.isSelected()==true)
            {
                ProjectManager.put("progressBarBGColor", "");
                ProjectManager.remove("progressBarBGColor");                
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

    private void useDefaultProgressBarFillColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultProgressBarFillColorActionPerformed
        try
        {
            if(useDefaultProgressBarFillColor.isSelected()==true)
            {
                ProjectManager.put("progressBarColor", "");
                ProjectManager.remove("progressBarColor");                
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

    private void useDefaultProgressPanelLeftBorderColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultProgressPanelLeftBorderColorActionPerformed
        try
        {
            if(useDefaultProgressPanelLeftBorderColor.isSelected()==true)
            {
                ProjectManager.put("progressPanelLeftBorderColor", "");
                ProjectManager.remove("progressPanelLeftBorderColor");                
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

    private void useDefaultProgressPanelTextColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultProgressPanelTextColorActionPerformed
        try
        {
            if(useDefaultProgressPanelTextColor.isSelected()==true)
            {
                ProjectManager.put("progressPanelTextColor", "");
                ProjectManager.remove("progressPanelTextColor");                
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

    private void useDefaultButtonBarBackgroundColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultButtonBarBackgroundColorActionPerformed
        try
        {
            if(useDefaultButtonBarBackgroundColor.isSelected()==true)
            {
                ProjectManager.put("btnBarBGColor", "");
                ProjectManager.remove("btnBarBGColor");                
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
 
    private void useDefaultButtonBarTextColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultButtonBarTextColorActionPerformed
        try
        {
            if(useDefaultButtonBarTextColor.isSelected()==true)
            {
                ProjectManager.put("btnBarTextColor", "");
                ProjectManager.remove("btnBarTextColor");                
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
        if(ProjectManager.get("btnBarTextColor")!=null)
        {
            if(ProjectManager.get("btnBarTextColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("btnBarTextColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("btnBarTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                buttonBarTextColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("btnBarTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                buttonBarTextColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("btnBarTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                buttonBarTextColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_buttonBarTextColorChooserButtonActionPerformed

    private void updateButtonBarTextColorSwatch()
    {
        try
        {
            Color c = new java.awt.Color(255,255,255); 
            // Bring up a color chooser 
            if(ProjectManager.get("btnBarTextColor")!=null)
            {
                if(ProjectManager.get("btnBarTextColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("btnBarTextColor"));
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
            if(ProjectManager.get("btnBarBGColor")!=null)
            {
                if(ProjectManager.get("btnBarBGColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("btnBarBGColor"));
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
            if(ProjectManager.get("progressPanelTextColor")!=null)
            {
                if(ProjectManager.get("progressPanelTextColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("progressPanelTextColor"));
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
            if(ProjectManager.get("progressPanelLeftBorderColor")!=null)
            {
                if(ProjectManager.get("progressPanelLeftBorderColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("progressPanelLeftBorderColor"));
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
            if(ProjectManager.get("progressBarBGColor")!=null)
            {
                if(ProjectManager.get("progressBarBGColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("progressBarBGColor"));
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
            if(ProjectManager.get("progressBarColor")!=null)
            {
                if(ProjectManager.get("progressBarColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("progressBarColor"));
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
            Color c = new java.awt.Color(255,255,255); 
            // Bring up a color chooser 
            if(ProjectManager.get("progressBarHighlightBorderColor")!=null)
            {
                if(ProjectManager.get("progressBarHighlightBorderColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("progressBarHighlightBorderColor"));
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
            if(ProjectManager.get("progressBarShadowBorderColor")!=null)
            {
                if(ProjectManager.get("progressBarShadowBorderColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("progressBarShadowBorderColor"));
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
    private javax.swing.JPanel ImageDescriptionLabel3;
    private javax.swing.JLabel LeftUIFiller5;
    private javax.swing.JButton PreviewButton;
    private javax.swing.JPanel ProjectLocationsCenterPanel4;
    private javax.swing.JPanel ProjectLookAndFeelImages;
    private javax.swing.JPanel ProjectLookAndFeelImages1;
    private javax.swing.JPanel ProjectLookAndFeelImages2;
    private javax.swing.JPanel ProjectLookAndFeelImages3;
    private javax.swing.JPanel ProjectLookAndFeelImages4;
    private javax.swing.JPanel ProjectLookAndFeelImages5;
    private javax.swing.JPanel ProjectLookAndFeelImages6;
    private javax.swing.JPanel ProjectLookAndFeelImages7;
    private javax.swing.JPanel ProjectLookAndFeelImages8;
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
    private javax.swing.JPanel UIChoicesBottomPanel4;
    private javax.swing.JPanel UIChoicesBottomPanel5;
    private javax.swing.JPanel UIChoicesBottomPanel6;
    private javax.swing.JPanel UIChoicesBottomPanel7;
    private javax.swing.JPanel UIChoicesBottomPanel8;
    private javax.swing.JPanel UIChoicesBottomPanel9;
    private javax.swing.JButton buttonBarTextColorChooserButton;
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
    private javax.swing.JLabel lFiller75;
    private javax.swing.JLabel lFiller76;
    private javax.swing.JLabel lFiller77;
    private javax.swing.JButton progressBarBackgroundColorChooserButton;
    private javax.swing.JButton progressBarFillColorChooserButton;
    private javax.swing.JButton progressBarHighlightBorderColorChooserButton;
    private javax.swing.JButton progressBarShadowBorderColorChooserButton;
    private javax.swing.JButton progressPanelLeftBorderColorChooserButton;
    private javax.swing.JButton progressPanelTextColorChooserButton;
    private javax.swing.JCheckBox useDefaultButtonBarBackgroundColor;
    private javax.swing.JCheckBox useDefaultButtonBarTextColor;
    private javax.swing.JCheckBox useDefaultProgressBarBackgroundColor;
    private javax.swing.JCheckBox useDefaultProgressBarFillColor;
    private javax.swing.JCheckBox useDefaultProgressBarHighlightBorderColor;
    private javax.swing.JCheckBox useDefaultProgressBarShadowBorderColor;
    private javax.swing.JCheckBox useDefaultProgressPanelLeftBorderColor;
    private javax.swing.JCheckBox useDefaultProgressPanelTextColor;
    // End of variables declaration//GEN-END:variables
    
}
