/*
 * PaymentsColorsPanel.java
 *
 * Created on October 10, 2004, 11:15 AM
 */

package com.trinity.ea.design.project.lookandfeel.colors;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.common.filechooser.ImageFileFilter;
import com.trinity.ea.design.project.lookandfeel.preview.actions.StartVerticalButtonBarThemeAction;
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
import com.trinity.ea.design.common.colorchooser.JLocalColorChooser;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class PaymentsColorsPanel extends EAPanel {
    private ImageIcon noColorIcon = new ImageIcon(getClass().getResource("/images/nocolor.png"));    
    /** Creates new form PaymentsColorsPanel */
    public PaymentsColorsPanel() {
        initComponents();
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
            if(ProjectManager.get("paymentLabelTextColor")!=null)
            {
                if(ProjectManager.get("paymentLabelTextColor").equalsIgnoreCase("")==false)
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
            
            
            if(ProjectManager.get("paymentLabelHeaderProductNameTextColor")!=null)
            {
                if(ProjectManager.get("paymentLabelHeaderProductNameTextColor").equalsIgnoreCase("")==false)
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
            
            if(ProjectManager.get("paymentBackgroundColor")!=null)
            {
                if(ProjectManager.get("paymentBackgroundColor").equalsIgnoreCase("")==false)
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
            
            
             if(ProjectManager.get("paymentSuccessLabelBGColor")!=null)
            {
                if(ProjectManager.get("paymentSuccessLabelBGColor").equalsIgnoreCase("")==false)
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
            
            
            if(ProjectManager.get("paymentFailureLabelBGColor")!=null)
            {
                if(ProjectManager.get("paymentFailureLabelBGColor").equalsIgnoreCase("")==false)
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
        previewButtonGroup = new javax.swing.ButtonGroup();
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
        ProjectLookAndFeelImages3 = new javax.swing.JPanel();
        ProjectLocationsCenterPanel4 = new javax.swing.JPanel();
        lFiller48 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rbPaymentPreview = new javax.swing.JRadioButton();
        rbPaymentSuccessPreview = new javax.swing.JRadioButton();
        rbPaymentFailurePreview = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        PreviewButton = new javax.swing.JButton();
        lFiller45 = new javax.swing.JLabel();
        UIChoicesBottomPanel4 = new javax.swing.JPanel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Label Text Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages.setMaximumSize(new java.awt.Dimension(32767, 60));
        ProjectLookAndFeelImages.setMinimumSize(new java.awt.Dimension(10, 60));
        ProjectLookAndFeelImages.setPreferredSize(new java.awt.Dimension(10, 60));
        UIChoicesBottomPanel7.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel7, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel7.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel7.setMaximumSize(new java.awt.Dimension(32767, 4));
        UIChoicesBottomPanel7.setMinimumSize(new java.awt.Dimension(5, 4));
        UIChoicesBottomPanel7.setPreferredSize(new java.awt.Dimension(200, 4));
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
        useDefaultButtonBarTextColor.setText("Use default label text color");
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
        ProjectLookAndFeelImages1.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Payment Header Product Identification Text Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages1.setMaximumSize(new java.awt.Dimension(32767, 60));
        ProjectLookAndFeelImages1.setMinimumSize(new java.awt.Dimension(10, 60));
        ProjectLookAndFeelImages1.setPreferredSize(new java.awt.Dimension(10, 60));
        UIChoicesBottomPanel8.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel8, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel8.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel8.setMaximumSize(new java.awt.Dimension(32767, 4));
        UIChoicesBottomPanel8.setMinimumSize(new java.awt.Dimension(5, 4));
        UIChoicesBottomPanel8.setPreferredSize(new java.awt.Dimension(200, 4));
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
        useDefaultButtonBarBackgroundColor.setText("Use default text color");
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
        ProjectLookAndFeelImages2.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Background Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages2.setMaximumSize(new java.awt.Dimension(32767, 60));
        ProjectLookAndFeelImages2.setMinimumSize(new java.awt.Dimension(10, 60));
        ProjectLookAndFeelImages2.setPreferredSize(new java.awt.Dimension(10, 60));
        UIChoicesBottomPanel9.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel9, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel9.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel9.setMaximumSize(new java.awt.Dimension(32767, 4));
        UIChoicesBottomPanel9.setMinimumSize(new java.awt.Dimension(5, 4));
        UIChoicesBottomPanel9.setPreferredSize(new java.awt.Dimension(200, 4));
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
        useDefaultProgressPanelTextColor.setText("Use default background color");
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
        ProjectLookAndFeelImages4.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Authorization Success Message Background Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages4.setMaximumSize(new java.awt.Dimension(32767, 60));
        ProjectLookAndFeelImages4.setMinimumSize(new java.awt.Dimension(10, 60));
        ProjectLookAndFeelImages4.setPreferredSize(new java.awt.Dimension(10, 60));
        UIChoicesBottomPanel11.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel11, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel11.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel11.setMaximumSize(new java.awt.Dimension(32767, 4));
        UIChoicesBottomPanel11.setMinimumSize(new java.awt.Dimension(5, 4));
        UIChoicesBottomPanel11.setPreferredSize(new java.awt.Dimension(200, 4));
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
        useDefaultProgressPanelLeftBorderColor.setText("Use default success message background color");
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
        ProjectLookAndFeelImages5.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Authorization Failure Message Background Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages5.setMaximumSize(new java.awt.Dimension(32767, 60));
        ProjectLookAndFeelImages5.setMinimumSize(new java.awt.Dimension(10, 60));
        ProjectLookAndFeelImages5.setPreferredSize(new java.awt.Dimension(10, 60));
        UIChoicesBottomPanel13.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel13, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel13.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel13.setMaximumSize(new java.awt.Dimension(32767, 4));
        UIChoicesBottomPanel13.setMinimumSize(new java.awt.Dimension(5, 4));
        UIChoicesBottomPanel13.setPreferredSize(new java.awt.Dimension(200, 4));
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
        useDefaultProgressBarFillColor.setText("Use default failure message background color");
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

        ProjectLookAndFeelImages3.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages3, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages3.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages3.setMaximumSize(new java.awt.Dimension(32767, 90));
        ProjectLookAndFeelImages3.setMinimumSize(new java.awt.Dimension(10, 90));
        ProjectLookAndFeelImages3.setPreferredSize(new java.awt.Dimension(10, 90));
        ProjectLocationsCenterPanel4.setLayout(new javax.swing.BoxLayout(ProjectLocationsCenterPanel4, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsCenterPanel4.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsCenterPanel4.setMaximumSize(new java.awt.Dimension(2147483647, 69));
        ProjectLocationsCenterPanel4.setMinimumSize(new java.awt.Dimension(600, 69));
        ProjectLocationsCenterPanel4.setPreferredSize(new java.awt.Dimension(800, 69));
        lFiller48.setBackground(new java.awt.Color(140, 160, 210));
        lFiller48.setText("   ");
        lFiller48.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller48.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller48.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel4.add(lFiller48);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.X_AXIS));

        jPanel1.setBackground(new java.awt.Color(140, 160, 210));
        jPanel1.setMaximumSize(new java.awt.Dimension(255, 69));
        jPanel1.setMinimumSize(new java.awt.Dimension(255, 69));
        jPanel1.setPreferredSize(new java.awt.Dimension(255, 69));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setBackground(new java.awt.Color(140, 160, 210));
        jPanel2.setMaximumSize(new java.awt.Dimension(168, 69));
        jPanel2.setMinimumSize(new java.awt.Dimension(168, 69));
        jPanel2.setPreferredSize(new java.awt.Dimension(168, 69));
        rbPaymentPreview.setBackground(new java.awt.Color(140, 160, 210));
        rbPaymentPreview.setFont(new java.awt.Font("Arial", 0, 12));
        rbPaymentPreview.setSelected(true);
        previewButtonGroup.add(rbPaymentPreview);
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
        previewButtonGroup.add(rbPaymentSuccessPreview);
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
        previewButtonGroup.add(rbPaymentFailurePreview);
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

        ProjectLocationsCenterPanel4.add(jPanel1);

        lFiller45.setBackground(new java.awt.Color(140, 160, 210));
        lFiller45.setText("   ");
        lFiller45.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller45.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller45.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel4.add(lFiller45);

        ProjectLookAndFeelImages3.add(ProjectLocationsCenterPanel4);

        UIChoicesBottomPanel4.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel4.setMinimumSize(new java.awt.Dimension(5, 5));
        UIChoicesBottomPanel4.setPreferredSize(new java.awt.Dimension(5, 5));
        ProjectLookAndFeelImages3.add(UIChoicesBottomPanel4);

        add(ProjectLookAndFeelImages3);

    }//GEN-END:initComponents

    private void rbPaymentFailurePreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPaymentFailurePreviewActionPerformed
        if(rbPaymentFailurePreview.isSelected()==true)
        {
           rbPaymentPreview.setSelected(false);
           rbPaymentFailurePreview.setSelected(true);
           rbPaymentSuccessPreview.setSelected(false);
        } 
    }//GEN-LAST:event_rbPaymentFailurePreviewActionPerformed

    private void rbPaymentPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPaymentPreviewActionPerformed
        if(rbPaymentPreview.isSelected()==true)
        {
           rbPaymentPreview.setSelected(true);
           rbPaymentFailurePreview.setSelected(false);
           rbPaymentSuccessPreview.setSelected(false);
        } 
    }//GEN-LAST:event_rbPaymentPreviewActionPerformed

    private void rbPaymentSuccessPreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPaymentSuccessPreviewActionPerformed
        if(rbPaymentSuccessPreview.isSelected()==true)
        {
           rbPaymentPreview.setSelected(false);
           rbPaymentFailurePreview.setSelected(false);
           rbPaymentSuccessPreview.setSelected(true);
        } 
    }//GEN-LAST:event_rbPaymentSuccessPreviewActionPerformed

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

    private void useDefaultProgressBarFillColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultProgressBarFillColorActionPerformed
        try
        {
            if(useDefaultProgressBarFillColor.isSelected()==true)
            {
                ProjectManager.put("paymentFailureLabelBGColor", "");
                ProjectManager.remove("paymentFailureLabelBGColor");                
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
        if(ProjectManager.get("paymentFailureLabelBGColor")!=null)
        {
            if(ProjectManager.get("paymentFailureLabelBGColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentFailureLabelBGColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("paymentFailureLabelBGColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                progressBarFillColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("paymentFailureLabelBGColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressBarFillColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("paymentFailureLabelBGColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressBarFillColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_progressBarFillColorChooserButtonActionPerformed

    private void useDefaultProgressPanelTextColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultProgressPanelTextColorActionPerformed
        try
        {
            if(useDefaultProgressPanelTextColor.isSelected()==true)
            {
                ProjectManager.put("paymentBackgroundColor", "");
                ProjectManager.put("paymentImgSecondaryBackgroundColor", "");
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

    private void useDefaultProgressPanelLeftBorderColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultProgressPanelLeftBorderColorActionPerformed
        try
        {
            if(useDefaultProgressPanelLeftBorderColor.isSelected()==true)
            {
                ProjectManager.put("paymentSuccessLabelBGColor", "");
                ProjectManager.remove("paymentSuccessLabelBGColor");                
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
        if(ProjectManager.get("paymentSuccessLabelBGColor")!=null)
        {
            if(ProjectManager.get("paymentSuccessLabelBGColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentSuccessLabelBGColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("paymentSuccessLabelBGColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                progressPanelLeftBorderColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("paymentSuccessLabelBGColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressPanelLeftBorderColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("paymentSuccessLabelBGColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressPanelLeftBorderColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_progressPanelLeftBorderColorChooserButtonActionPerformed

    private void progressPanelTextColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progressPanelTextColorChooserButtonActionPerformed
 	// Bring up a color chooser 
        if(ProjectManager.get("paymentBackgroundColor")!=null)
        {
            if(ProjectManager.get("paymentBackgroundColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentBackgroundColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("paymentBackgroundColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ProjectManager.put("paymentImgSecondaryBackgroundColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                progressPanelTextColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("paymentBackgroundColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                ProjectManager.put("paymentImgSecondaryBackgroundColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                progressPanelTextColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
            Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
            ProjectManager.put("paymentBackgroundColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
            ProjectManager.put("paymentImgSecondaryBackgroundColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
            progressPanelTextColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_progressPanelTextColorChooserButtonActionPerformed

    private void useDefaultButtonBarBackgroundColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultButtonBarBackgroundColorActionPerformed
        try
        {
            if(useDefaultButtonBarBackgroundColor.isSelected()==true)
            {
                ProjectManager.put("paymentLabelHeaderProductNameTextColor", "");
                ProjectManager.remove("paymentLabelHeaderProductNameTextColor");                
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
        if(ProjectManager.get("paymentLabelHeaderProductNameTextColor")!=null)
        {
            if(ProjectManager.get("paymentLabelHeaderProductNameTextColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentLabelHeaderProductNameTextColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("paymentLabelHeaderProductNameTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ButtonBarBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("paymentLabelHeaderProductNameTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                ButtonBarBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("paymentLabelHeaderProductNameTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                ButtonBarBackgroundColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_ButtonBarBackgroundColorChooserButtonActionPerformed

    private void useDefaultButtonBarTextColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultButtonBarTextColorActionPerformed
        try
        {
            if(useDefaultButtonBarTextColor.isSelected()==true)
            {
                ProjectManager.put("paymentLabelTextColor", "");
                ProjectManager.remove("paymentLabelTextColor");     
                ProjectManager.put("paymentLabelHeaderTextColor", "");
                ProjectManager.remove("paymentLabelHeaderTextColor");                
                ProjectManager.put("paymentSuccessLabelHeaderTextColor", "");
                ProjectManager.remove("paymentSuccessLabelHeaderTextColor");    
                ProjectManager.put("paymentFailureLabelHeaderTextColor", "");
                ProjectManager.remove("paymentFailureLabelHeaderTextColor");      
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
        if(ProjectManager.get("paymentLabelTextColor")!=null)
        {
            if(ProjectManager.get("paymentLabelTextColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentLabelTextColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("paymentLabelTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ProjectManager.put("paymentSuccessLabelHeaderTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ProjectManager.put("paymentFailureLabelHeaderTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ProjectManager.put("paymentLabelHeaderTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                buttonBarTextColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("paymentLabelTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ProjectManager.put("paymentSuccessLabelHeaderTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                ProjectManager.put("paymentFailureLabelHeaderTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ProjectManager.put("paymentLabelHeaderTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                buttonBarTextColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
            Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
            ProjectManager.put("paymentLabelTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
            ProjectManager.put("paymentSuccessLabelHeaderTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
            ProjectManager.put("paymentFailureLabelHeaderTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
            ProjectManager.put("paymentLabelHeaderTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
            buttonBarTextColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_buttonBarTextColorChooserButtonActionPerformed
 
    private void updateButtonBarTextColorSwatch()
    {
        try
        {
            Color c = new java.awt.Color(255,255,255); 
            // Bring up a color chooser 
            if(ProjectManager.get("paymentLabelTextColor")!=null)
            {
                if(ProjectManager.get("paymentLabelTextColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentLabelTextColor"));
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
            if(ProjectManager.get("paymentLabelHeaderProductNameTextColor")!=null)
            {
                if(ProjectManager.get("paymentLabelHeaderProductNameTextColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentLabelHeaderProductNameTextColor"));
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
            if(ProjectManager.get("paymentBackgroundColor")!=null)
            {
                if(ProjectManager.get("paymentBackgroundColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentBackgroundColor"));
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
            if(ProjectManager.get("paymentSuccessLabelBGColor")!=null)
            {
                if(ProjectManager.get("paymentSuccessLabelBGColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentSuccessLabelBGColor"));
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
            if(ProjectManager.get("paymentFailureLabelBGColor")!=null)
            {
                if(ProjectManager.get("paymentFailureLabelBGColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentFailureLabelBGColor"));
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
    private javax.swing.JButton PreviewButton;
    private javax.swing.JPanel ProjectLocationsCenterPanel4;
    private javax.swing.JPanel ProjectLookAndFeelImages;
    private javax.swing.JPanel ProjectLookAndFeelImages1;
    private javax.swing.JPanel ProjectLookAndFeelImages2;
    private javax.swing.JPanel ProjectLookAndFeelImages3;
    private javax.swing.JPanel ProjectLookAndFeelImages4;
    private javax.swing.JPanel ProjectLookAndFeelImages5;
    private javax.swing.JPanel UIChoicesBottomPanel10;
    private javax.swing.JPanel UIChoicesBottomPanel11;
    private javax.swing.JPanel UIChoicesBottomPanel12;
    private javax.swing.JPanel UIChoicesBottomPanel13;
    private javax.swing.JPanel UIChoicesBottomPanel14;
    private javax.swing.JPanel UIChoicesBottomPanel4;
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
    private javax.swing.JLabel lFiller43;
    private javax.swing.JLabel lFiller44;
    private javax.swing.JLabel lFiller45;
    private javax.swing.JLabel lFiller46;
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
    private javax.swing.ButtonGroup previewButtonGroup;
    private javax.swing.JButton progressBarFillColorChooserButton;
    private javax.swing.JButton progressPanelLeftBorderColorChooserButton;
    private javax.swing.JButton progressPanelTextColorChooserButton;
    private javax.swing.JRadioButton rbPaymentFailurePreview;
    private javax.swing.JRadioButton rbPaymentPreview;
    private javax.swing.JRadioButton rbPaymentSuccessPreview;
    private javax.swing.JCheckBox useDefaultButtonBarBackgroundColor;
    private javax.swing.JCheckBox useDefaultButtonBarTextColor;
    private javax.swing.JCheckBox useDefaultProgressBarFillColor;
    private javax.swing.JCheckBox useDefaultProgressPanelLeftBorderColor;
    private javax.swing.JCheckBox useDefaultProgressPanelTextColor;
    // End of variables declaration//GEN-END:variables
    
}
