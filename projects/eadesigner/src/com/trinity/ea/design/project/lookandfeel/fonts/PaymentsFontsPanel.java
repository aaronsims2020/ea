/*
 * PaymentsFontsPanel.java
 *
 * Created on June 13, 2004, 3:24 PM
 */

package com.trinity.ea.design.project.lookandfeel.fonts;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.EADesigner;
import com.trinity.ea.design.common.fontchooser.FontChooser;
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
public class PaymentsFontsPanel extends EAPanel {

    /** Creates new form ImagesPanel */
    public PaymentsFontsPanel() 
    {
        initComponents();
      
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
            if(ProjectManager.get("paymentLabelHeaderProductNameTextFont")!=null)
            {
                if(ProjectManager.get("paymentLabelHeaderProductNameTextFont").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentLabelHeaderProductNameTextFont"));
                    demoButtonBarFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoButtonBarFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
                    useDefaultButtonBarTextColor.setSelected(false);
                }
                else
                {
                    useDefaultButtonBarTextColor.setSelected(true);
                }
            }
            else
            {
                  useDefaultButtonBarTextColor.setSelected(true);           
            }
            
            
            if(ProjectManager.get("paymentLabelHeaderTextFont")!=null)
            {
                if(ProjectManager.get("paymentLabelHeaderTextFont").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentLabelHeaderTextFont"));
                    demoProgressPanelTextFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoProgressPanelTextFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
                    useDefaultButtonBarBackgroundColor.setSelected(false);
                }
                else
                {
                    useDefaultButtonBarBackgroundColor.setSelected(true);
                }
            }
            else
            {
                  useDefaultButtonBarBackgroundColor.setSelected(true);           
            }   
            
            if(ProjectManager.get("paymentLabelTextFont")!=null)
            {
                if(ProjectManager.get("paymentLabelTextFont").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentLabelTextFont"));
                    demoLabelTextFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoLabelTextFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
                    useDefaultButtonBarTextColor1.setSelected(false);
                }
                else
                {
                    useDefaultButtonBarTextColor1.setSelected(true);
                }
            }
            else
            {
                  useDefaultButtonBarTextColor1.setSelected(true);           
            }             
      
            
             if(ProjectManager.get("paymentSuccessHeaderLabelFont")!=null)
            {
                if(ProjectManager.get("paymentSuccessHeaderLabelFont").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentSuccessHeaderLabelFont"));
                    demoSuccessHeaderTextFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoSuccessHeaderTextFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
                    useDefaultButtonBarBackgroundColor1.setSelected(false);
                }
                else
                {
                    useDefaultButtonBarBackgroundColor1.setSelected(true);
                }
            }
            else
            {
                  useDefaultButtonBarBackgroundColor1.setSelected(true);           
            }            

            if(ProjectManager.get("paymentSuccessLabelHeaderTextFont")!=null)
            {
                if(ProjectManager.get("paymentSuccessLabelHeaderTextFont").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentSuccessLabelHeaderTextFont"));
                    demoLabelHeaderFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoLabelHeaderFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
                    useDefaultButtonBarTextColor2.setSelected(false);
                }
                else
                {
                    useDefaultButtonBarTextColor2.setSelected(true);
                }
            }
            else
            {
                  useDefaultButtonBarTextColor2.setSelected(true);           
            }              

            if(ProjectManager.get("paymentSuccessLabelFont")!=null)
            {
                if(ProjectManager.get("paymentSuccessLabelFont").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentSuccessLabelFont"));
                    demoSuccessFailureLabelTextFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoSuccessFailureLabelTextFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
                    useDefaultButtonBarBackgroundColor2.setSelected(false);
                }
                else
                {
                    useDefaultButtonBarBackgroundColor2.setSelected(true);
                }
            }
            else
            {
                  useDefaultButtonBarBackgroundColor2.setSelected(true);           
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
        demoButtonBarFont = new javax.swing.JLabel();
        ProjectLookAndFeelImages1 = new javax.swing.JPanel();
        UIChoicesBottomPanel8 = new javax.swing.JPanel();
        UIChoicesBottomPanel6 = new javax.swing.JPanel();
        lFiller46 = new javax.swing.JLabel();
        useDefaultButtonBarBackgroundColor = new javax.swing.JCheckBox();
        ButtonBarBackgroundColorChooserButton = new javax.swing.JButton();
        lFiller58 = new javax.swing.JLabel();
        lFiller50 = new javax.swing.JLabel();
        demoProgressPanelTextFont = new javax.swing.JLabel();
        ProjectLookAndFeelImages2 = new javax.swing.JPanel();
        UIChoicesBottomPanel10 = new javax.swing.JPanel();
        UIChoicesBottomPanel11 = new javax.swing.JPanel();
        lFiller45 = new javax.swing.JLabel();
        useDefaultButtonBarTextColor1 = new javax.swing.JCheckBox();
        buttonBarTextColorChooserButton1 = new javax.swing.JButton();
        lFiller47 = new javax.swing.JLabel();
        lFiller59 = new javax.swing.JLabel();
        demoLabelTextFont = new javax.swing.JLabel();
        ProjectLookAndFeelImages3 = new javax.swing.JPanel();
        UIChoicesBottomPanel12 = new javax.swing.JPanel();
        UIChoicesBottomPanel13 = new javax.swing.JPanel();
        lFiller48 = new javax.swing.JLabel();
        useDefaultButtonBarBackgroundColor1 = new javax.swing.JCheckBox();
        ButtonBarBackgroundColorChooserButton1 = new javax.swing.JButton();
        lFiller60 = new javax.swing.JLabel();
        lFiller52 = new javax.swing.JLabel();
        demoSuccessHeaderTextFont = new javax.swing.JLabel();
        ProjectLookAndFeelImages5 = new javax.swing.JPanel();
        UIChoicesBottomPanel14 = new javax.swing.JPanel();
        UIChoicesBottomPanel15 = new javax.swing.JPanel();
        lFiller53 = new javax.swing.JLabel();
        useDefaultButtonBarTextColor2 = new javax.swing.JCheckBox();
        buttonBarTextColorChooserButton2 = new javax.swing.JButton();
        lFiller54 = new javax.swing.JLabel();
        lFiller61 = new javax.swing.JLabel();
        demoLabelHeaderFont = new javax.swing.JLabel();
        ProjectLookAndFeelImages6 = new javax.swing.JPanel();
        UIChoicesBottomPanel16 = new javax.swing.JPanel();
        UIChoicesBottomPanel17 = new javax.swing.JPanel();
        lFiller55 = new javax.swing.JLabel();
        useDefaultButtonBarBackgroundColor2 = new javax.swing.JCheckBox();
        ButtonBarBackgroundColorChooserButton2 = new javax.swing.JButton();
        lFiller62 = new javax.swing.JLabel();
        lFiller56 = new javax.swing.JLabel();
        demoSuccessFailureLabelTextFont = new javax.swing.JLabel();
        ProjectLookAndFeelImages4 = new javax.swing.JPanel();
        ProjectLocationsCenterPanel5 = new javax.swing.JPanel();
        lFiller49 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rbPaymentPreview = new javax.swing.JRadioButton();
        rbPaymentSuccessPreview = new javax.swing.JRadioButton();
        rbPaymentFailurePreview = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        PreviewButton = new javax.swing.JButton();
        lFiller51 = new javax.swing.JLabel();
        UIChoicesBottomPanel9 = new javax.swing.JPanel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Product Label Text Font", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
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
        useDefaultButtonBarTextColor.setText("Use default product label text font");
        useDefaultButtonBarTextColor.setMaximumSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarTextColor.setMinimumSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarTextColor.setPreferredSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarTextColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultButtonBarTextColorActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel5.add(useDefaultButtonBarTextColor);

        buttonBarTextColorChooserButton.setBackground(new java.awt.Color(140, 160, 210));
        buttonBarTextColorChooserButton.setText("Set Font...");
        buttonBarTextColorChooserButton.setMaximumSize(new java.awt.Dimension(90, 25));
        buttonBarTextColorChooserButton.setMinimumSize(new java.awt.Dimension(90, 25));
        buttonBarTextColorChooserButton.setPreferredSize(new java.awt.Dimension(90, 25));
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

        demoButtonBarFont.setBackground(new java.awt.Color(140, 160, 210));
        demoButtonBarFont.setText("   ");
        demoButtonBarFont.setMaximumSize(new java.awt.Dimension(32767, 15));
        demoButtonBarFont.setMinimumSize(new java.awt.Dimension(10, 15));
        demoButtonBarFont.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel5.add(demoButtonBarFont);

        ProjectLookAndFeelImages.add(UIChoicesBottomPanel5);

        add(ProjectLookAndFeelImages);

        ProjectLookAndFeelImages1.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages1, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages1.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages1.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Header Label Text Font", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
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
        useDefaultButtonBarBackgroundColor.setText("Use default header label text font");
        useDefaultButtonBarBackgroundColor.setActionCommand("Use default header label text font");
        useDefaultButtonBarBackgroundColor.setMaximumSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarBackgroundColor.setMinimumSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarBackgroundColor.setPreferredSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarBackgroundColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultButtonBarBackgroundColorActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel6.add(useDefaultButtonBarBackgroundColor);

        ButtonBarBackgroundColorChooserButton.setBackground(new java.awt.Color(140, 160, 210));
        ButtonBarBackgroundColorChooserButton.setText("Set Font...");
        ButtonBarBackgroundColorChooserButton.setMaximumSize(new java.awt.Dimension(90, 25));
        ButtonBarBackgroundColorChooserButton.setMinimumSize(new java.awt.Dimension(90, 25));
        ButtonBarBackgroundColorChooserButton.setPreferredSize(new java.awt.Dimension(90, 25));
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

        demoProgressPanelTextFont.setBackground(new java.awt.Color(140, 160, 210));
        demoProgressPanelTextFont.setText("   ");
        demoProgressPanelTextFont.setMaximumSize(new java.awt.Dimension(32767, 15));
        demoProgressPanelTextFont.setMinimumSize(new java.awt.Dimension(10, 15));
        demoProgressPanelTextFont.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel6.add(demoProgressPanelTextFont);

        ProjectLookAndFeelImages1.add(UIChoicesBottomPanel6);

        add(ProjectLookAndFeelImages1);

        ProjectLookAndFeelImages2.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages2, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages2.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages2.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Label Text Font", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages2.setMaximumSize(new java.awt.Dimension(32767, 60));
        ProjectLookAndFeelImages2.setMinimumSize(new java.awt.Dimension(10, 60));
        ProjectLookAndFeelImages2.setPreferredSize(new java.awt.Dimension(10, 60));
        UIChoicesBottomPanel10.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel10, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel10.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel10.setMaximumSize(new java.awt.Dimension(32767, 4));
        UIChoicesBottomPanel10.setMinimumSize(new java.awt.Dimension(5, 4));
        UIChoicesBottomPanel10.setPreferredSize(new java.awt.Dimension(200, 4));
        ProjectLookAndFeelImages2.add(UIChoicesBottomPanel10);

        UIChoicesBottomPanel11.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel11, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel11.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel11.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel11.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel11.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller45.setBackground(new java.awt.Color(140, 160, 210));
        lFiller45.setText("   ");
        lFiller45.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller45.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller45.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel11.add(lFiller45);

        useDefaultButtonBarTextColor1.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultButtonBarTextColor1.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultButtonBarTextColor1.setSelected(true);
        useDefaultButtonBarTextColor1.setText("Use default label text font");
        useDefaultButtonBarTextColor1.setMaximumSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarTextColor1.setMinimumSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarTextColor1.setPreferredSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarTextColor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultButtonBarTextColor1ActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel11.add(useDefaultButtonBarTextColor1);

        buttonBarTextColorChooserButton1.setBackground(new java.awt.Color(140, 160, 210));
        buttonBarTextColorChooserButton1.setText("Set Font...");
        buttonBarTextColorChooserButton1.setMaximumSize(new java.awt.Dimension(90, 25));
        buttonBarTextColorChooserButton1.setMinimumSize(new java.awt.Dimension(90, 25));
        buttonBarTextColorChooserButton1.setPreferredSize(new java.awt.Dimension(90, 25));
        buttonBarTextColorChooserButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBarTextColorChooserButton1ActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel11.add(buttonBarTextColorChooserButton1);

        lFiller47.setBackground(new java.awt.Color(140, 160, 210));
        lFiller47.setText("   ");
        lFiller47.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller47.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller47.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel11.add(lFiller47);

        lFiller59.setBackground(new java.awt.Color(140, 160, 210));
        lFiller59.setText("   ");
        lFiller59.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller59.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller59.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel11.add(lFiller59);

        demoLabelTextFont.setBackground(new java.awt.Color(140, 160, 210));
        demoLabelTextFont.setText("   ");
        demoLabelTextFont.setMaximumSize(new java.awt.Dimension(32767, 15));
        demoLabelTextFont.setMinimumSize(new java.awt.Dimension(10, 15));
        demoLabelTextFont.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel11.add(demoLabelTextFont);

        ProjectLookAndFeelImages2.add(UIChoicesBottomPanel11);

        add(ProjectLookAndFeelImages2);

        ProjectLookAndFeelImages3.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages3, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages3.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages3.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Success/Failure Header Label Text Font", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages3.setMaximumSize(new java.awt.Dimension(32767, 60));
        ProjectLookAndFeelImages3.setMinimumSize(new java.awt.Dimension(10, 60));
        ProjectLookAndFeelImages3.setPreferredSize(new java.awt.Dimension(10, 60));
        UIChoicesBottomPanel12.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel12, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel12.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel12.setMaximumSize(new java.awt.Dimension(32767, 4));
        UIChoicesBottomPanel12.setMinimumSize(new java.awt.Dimension(5, 4));
        UIChoicesBottomPanel12.setPreferredSize(new java.awt.Dimension(200, 4));
        ProjectLookAndFeelImages3.add(UIChoicesBottomPanel12);

        UIChoicesBottomPanel13.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel13, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel13.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel13.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel13.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel13.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller48.setBackground(new java.awt.Color(140, 160, 210));
        lFiller48.setText("   ");
        lFiller48.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller48.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller48.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel13.add(lFiller48);

        useDefaultButtonBarBackgroundColor1.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultButtonBarBackgroundColor1.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultButtonBarBackgroundColor1.setSelected(true);
        useDefaultButtonBarBackgroundColor1.setText("Use default header label text font");
        useDefaultButtonBarBackgroundColor1.setMaximumSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarBackgroundColor1.setMinimumSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarBackgroundColor1.setPreferredSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarBackgroundColor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultButtonBarBackgroundColor1ActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel13.add(useDefaultButtonBarBackgroundColor1);

        ButtonBarBackgroundColorChooserButton1.setBackground(new java.awt.Color(140, 160, 210));
        ButtonBarBackgroundColorChooserButton1.setText("Set Font...");
        ButtonBarBackgroundColorChooserButton1.setMaximumSize(new java.awt.Dimension(90, 25));
        ButtonBarBackgroundColorChooserButton1.setMinimumSize(new java.awt.Dimension(90, 25));
        ButtonBarBackgroundColorChooserButton1.setPreferredSize(new java.awt.Dimension(90, 25));
        ButtonBarBackgroundColorChooserButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBarBackgroundColorChooserButton1ActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel13.add(ButtonBarBackgroundColorChooserButton1);

        lFiller60.setBackground(new java.awt.Color(140, 160, 210));
        lFiller60.setText("   ");
        lFiller60.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller60.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller60.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel13.add(lFiller60);

        lFiller52.setBackground(new java.awt.Color(140, 160, 210));
        lFiller52.setText("   ");
        lFiller52.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller52.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller52.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel13.add(lFiller52);

        demoSuccessHeaderTextFont.setBackground(new java.awt.Color(140, 160, 210));
        demoSuccessHeaderTextFont.setText("   ");
        demoSuccessHeaderTextFont.setMaximumSize(new java.awt.Dimension(32767, 15));
        demoSuccessHeaderTextFont.setMinimumSize(new java.awt.Dimension(10, 15));
        demoSuccessHeaderTextFont.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel13.add(demoSuccessHeaderTextFont);

        ProjectLookAndFeelImages3.add(UIChoicesBottomPanel13);

        add(ProjectLookAndFeelImages3);

        ProjectLookAndFeelImages5.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages5, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages5.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages5.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Success/Failure Label Header Text Font", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages5.setMaximumSize(new java.awt.Dimension(32767, 60));
        ProjectLookAndFeelImages5.setMinimumSize(new java.awt.Dimension(10, 60));
        ProjectLookAndFeelImages5.setPreferredSize(new java.awt.Dimension(10, 60));
        UIChoicesBottomPanel14.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel14, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel14.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel14.setMaximumSize(new java.awt.Dimension(32767, 4));
        UIChoicesBottomPanel14.setMinimumSize(new java.awt.Dimension(5, 4));
        UIChoicesBottomPanel14.setPreferredSize(new java.awt.Dimension(200, 4));
        ProjectLookAndFeelImages5.add(UIChoicesBottomPanel14);

        UIChoicesBottomPanel15.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel15, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel15.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel15.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel15.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel15.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller53.setBackground(new java.awt.Color(140, 160, 210));
        lFiller53.setText("   ");
        lFiller53.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller53.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller53.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel15.add(lFiller53);

        useDefaultButtonBarTextColor2.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultButtonBarTextColor2.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultButtonBarTextColor2.setSelected(true);
        useDefaultButtonBarTextColor2.setText("Use default label header text font");
        useDefaultButtonBarTextColor2.setMaximumSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarTextColor2.setMinimumSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarTextColor2.setPreferredSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarTextColor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultButtonBarTextColor2ActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel15.add(useDefaultButtonBarTextColor2);

        buttonBarTextColorChooserButton2.setBackground(new java.awt.Color(140, 160, 210));
        buttonBarTextColorChooserButton2.setText("Set Font...");
        buttonBarTextColorChooserButton2.setMaximumSize(new java.awt.Dimension(90, 25));
        buttonBarTextColorChooserButton2.setMinimumSize(new java.awt.Dimension(90, 25));
        buttonBarTextColorChooserButton2.setPreferredSize(new java.awt.Dimension(90, 25));
        buttonBarTextColorChooserButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBarTextColorChooserButton2ActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel15.add(buttonBarTextColorChooserButton2);

        lFiller54.setBackground(new java.awt.Color(140, 160, 210));
        lFiller54.setText("   ");
        lFiller54.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller54.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller54.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel15.add(lFiller54);

        lFiller61.setBackground(new java.awt.Color(140, 160, 210));
        lFiller61.setText("   ");
        lFiller61.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller61.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller61.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel15.add(lFiller61);

        demoLabelHeaderFont.setBackground(new java.awt.Color(140, 160, 210));
        demoLabelHeaderFont.setText("   ");
        demoLabelHeaderFont.setMaximumSize(new java.awt.Dimension(32767, 15));
        demoLabelHeaderFont.setMinimumSize(new java.awt.Dimension(10, 15));
        demoLabelHeaderFont.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel15.add(demoLabelHeaderFont);

        ProjectLookAndFeelImages5.add(UIChoicesBottomPanel15);

        add(ProjectLookAndFeelImages5);

        ProjectLookAndFeelImages6.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages6, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages6.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages6.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Success/Failure Label Text Font", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages6.setMaximumSize(new java.awt.Dimension(32767, 60));
        ProjectLookAndFeelImages6.setMinimumSize(new java.awt.Dimension(10, 60));
        ProjectLookAndFeelImages6.setPreferredSize(new java.awt.Dimension(10, 60));
        UIChoicesBottomPanel16.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel16, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel16.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel16.setMaximumSize(new java.awt.Dimension(32767, 4));
        UIChoicesBottomPanel16.setMinimumSize(new java.awt.Dimension(5, 4));
        UIChoicesBottomPanel16.setPreferredSize(new java.awt.Dimension(200, 4));
        ProjectLookAndFeelImages6.add(UIChoicesBottomPanel16);

        UIChoicesBottomPanel17.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel17, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel17.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel17.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel17.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel17.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller55.setBackground(new java.awt.Color(140, 160, 210));
        lFiller55.setText("   ");
        lFiller55.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller55.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller55.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel17.add(lFiller55);

        useDefaultButtonBarBackgroundColor2.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultButtonBarBackgroundColor2.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultButtonBarBackgroundColor2.setSelected(true);
        useDefaultButtonBarBackgroundColor2.setText("Use default label text font");
        useDefaultButtonBarBackgroundColor2.setMaximumSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarBackgroundColor2.setMinimumSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarBackgroundColor2.setPreferredSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarBackgroundColor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultButtonBarBackgroundColor2ActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel17.add(useDefaultButtonBarBackgroundColor2);

        ButtonBarBackgroundColorChooserButton2.setBackground(new java.awt.Color(140, 160, 210));
        ButtonBarBackgroundColorChooserButton2.setText("Set Font...");
        ButtonBarBackgroundColorChooserButton2.setMaximumSize(new java.awt.Dimension(90, 25));
        ButtonBarBackgroundColorChooserButton2.setMinimumSize(new java.awt.Dimension(90, 25));
        ButtonBarBackgroundColorChooserButton2.setPreferredSize(new java.awt.Dimension(90, 25));
        ButtonBarBackgroundColorChooserButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBarBackgroundColorChooserButton2ActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel17.add(ButtonBarBackgroundColorChooserButton2);

        lFiller62.setBackground(new java.awt.Color(140, 160, 210));
        lFiller62.setText("   ");
        lFiller62.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller62.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller62.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel17.add(lFiller62);

        lFiller56.setBackground(new java.awt.Color(140, 160, 210));
        lFiller56.setText("   ");
        lFiller56.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller56.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller56.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel17.add(lFiller56);

        demoSuccessFailureLabelTextFont.setBackground(new java.awt.Color(140, 160, 210));
        demoSuccessFailureLabelTextFont.setText("   ");
        demoSuccessFailureLabelTextFont.setMaximumSize(new java.awt.Dimension(32767, 15));
        demoSuccessFailureLabelTextFont.setMinimumSize(new java.awt.Dimension(10, 15));
        demoSuccessFailureLabelTextFont.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel17.add(demoSuccessFailureLabelTextFont);

        ProjectLookAndFeelImages6.add(UIChoicesBottomPanel17);

        add(ProjectLookAndFeelImages6);

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
        lFiller49.setBackground(new java.awt.Color(140, 160, 210));
        lFiller49.setText("   ");
        lFiller49.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller49.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller49.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel5.add(lFiller49);

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

        lFiller51.setBackground(new java.awt.Color(140, 160, 210));
        lFiller51.setText("   ");
        lFiller51.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller51.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller51.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel5.add(lFiller51);

        ProjectLookAndFeelImages4.add(ProjectLocationsCenterPanel5);

        UIChoicesBottomPanel9.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel9.setMinimumSize(new java.awt.Dimension(5, 5));
        UIChoicesBottomPanel9.setPreferredSize(new java.awt.Dimension(5, 5));
        ProjectLookAndFeelImages4.add(UIChoicesBottomPanel9);

        add(ProjectLookAndFeelImages4);

    }//GEN-END:initComponents

    private void useDefaultButtonBarBackgroundColor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultButtonBarBackgroundColor2ActionPerformed
try
{
    if(useDefaultButtonBarBackgroundColor2.isSelected() == true)
    {
        demoSuccessFailureLabelTextFont.setVisible(false);
        ButtonBarBackgroundColorChooserButton2.setVisible(false);
    }
    else
    {
        demoSuccessFailureLabelTextFont.setVisible(true);
        ButtonBarBackgroundColorChooserButton2.setVisible(true);
    }
}
catch(Exception e)
{
    e.printStackTrace();
}
    }//GEN-LAST:event_useDefaultButtonBarBackgroundColor2ActionPerformed

    private void ButtonBarBackgroundColorChooserButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBarBackgroundColorChooserButton2ActionPerformed
         try
        {
 if(ProjectManager.get("paymentSuccessLabelFont")!=null)
        {
            if(ProjectManager.get("paymentSuccessLabelFont").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentSuccessLabelFont"));
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("paymentSuccessLabelFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    ProjectManager.putTempNoFileWrite("paymentFailureLabelFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
               }
                tmpArray = getStringArraysFromString(ProjectManager.get("paymentSuccessLabelFont"));
                demoSuccessFailureLabelTextFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                demoSuccessFailureLabelTextFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
            }
            else
            {
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font("Arial", 0, 12));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("paymentSuccessLabelFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    ProjectManager.putTempNoFileWrite("paymentFailureLabelFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentSuccessLabelFont"));
                    demoSuccessFailureLabelTextFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoSuccessFailureLabelTextFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
                }
            }
        }
        else
        {
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font("Arial", 0, 12));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("paymentSuccessLabelFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    ProjectManager.putTempNoFileWrite("paymentFailureLabelFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentSuccessLabelFont"));
                    demoSuccessFailureLabelTextFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoSuccessFailureLabelTextFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
                }
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ButtonBarBackgroundColorChooserButton2ActionPerformed

    private void useDefaultButtonBarTextColor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultButtonBarTextColor2ActionPerformed
try
{
    if(useDefaultButtonBarTextColor2.isSelected() == true)
    {
        demoLabelHeaderFont.setVisible(false);
        buttonBarTextColorChooserButton2.setVisible(false);
    }
    else
    {
        demoLabelHeaderFont.setVisible(true);
        buttonBarTextColorChooserButton2.setVisible(true);
    }
}
catch(Exception e)
{
    e.printStackTrace();
}
    }//GEN-LAST:event_useDefaultButtonBarTextColor2ActionPerformed

    private void buttonBarTextColorChooserButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBarTextColorChooserButton2ActionPerformed
        try
        {
        if(ProjectManager.get("paymentSuccessLabelHeaderTextFont")!=null)
        {
            if(ProjectManager.get("paymentSuccessLabelHeaderTextFont").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentSuccessLabelHeaderTextFont"));
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("paymentSuccessLabelHeaderTextFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    ProjectManager.putTempNoFileWrite("paymentFailureLabelHeaderTextFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
               }
                tmpArray = getStringArraysFromString(ProjectManager.get("paymentSuccessLabelHeaderTextFont"));
                demoLabelHeaderFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                demoLabelHeaderFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
            }
            else
            {
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font("Arial", 0, 12));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("paymentSuccessLabelHeaderTextFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    ProjectManager.putTempNoFileWrite("paymentFailureLabelHeaderTextFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentSuccessLabelHeaderTextFont"));
                    demoLabelHeaderFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoLabelHeaderFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
                }
            }
        }
        else
        {
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font("Arial", 0, 12));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("paymentSuccessLabelHeaderTextFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    ProjectManager.putTempNoFileWrite("paymentFailureLabelHeaderTextFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentSuccessLabelHeaderTextFont"));
                    demoLabelHeaderFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoLabelHeaderFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
                }
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_buttonBarTextColorChooserButton2ActionPerformed

    private void useDefaultButtonBarBackgroundColor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultButtonBarBackgroundColor1ActionPerformed
try
{
    if(useDefaultButtonBarBackgroundColor1.isSelected() == true)
    {
        demoSuccessHeaderTextFont.setVisible(false);
        ButtonBarBackgroundColorChooserButton1.setVisible(false);
    }
    else
    {
        demoSuccessHeaderTextFont.setVisible(true);
        ButtonBarBackgroundColorChooserButton1.setVisible(true);
    }
}
catch(Exception e)
{
    e.printStackTrace();
}
    }//GEN-LAST:event_useDefaultButtonBarBackgroundColor1ActionPerformed

    private void ButtonBarBackgroundColorChooserButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBarBackgroundColorChooserButton1ActionPerformed
        try
        {
        if(ProjectManager.get("paymentSuccessHeaderLabelFont")!=null)
        {
            if(ProjectManager.get("paymentSuccessHeaderLabelFont").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentSuccessHeaderLabelFont"));
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("paymentSuccessHeaderLabelFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    ProjectManager.putTempNoFileWrite("paymentFailureHeaderLabelFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
               }
                tmpArray = getStringArraysFromString(ProjectManager.get("paymentSuccessHeaderLabelFont"));
                demoSuccessHeaderTextFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                demoSuccessHeaderTextFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
            }
            else
            {
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font("Arial", 0, 12));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("paymentSuccessHeaderLabelFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    ProjectManager.putTempNoFileWrite("paymentFailureHeaderLabelFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentSuccessHeaderLabelFont"));
                    demoSuccessHeaderTextFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoSuccessHeaderTextFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
                }
            }
        }
        else
        {
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font("Arial", 0, 12));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("paymentSuccessHeaderLabelFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    ProjectManager.putTempNoFileWrite("paymentFailureHeaderLabelFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentSuccessHeaderLabelFont"));
                    demoSuccessHeaderTextFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoSuccessHeaderTextFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
                }
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ButtonBarBackgroundColorChooserButton1ActionPerformed

    private void useDefaultButtonBarTextColor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultButtonBarTextColor1ActionPerformed
try
{
    if(useDefaultButtonBarTextColor1.isSelected() == true)
    {
        demoLabelTextFont.setVisible(false);
        buttonBarTextColorChooserButton1.setVisible(false);
    }
    else
    {
        demoLabelTextFont.setVisible(true);
        buttonBarTextColorChooserButton1.setVisible(true);
    }
}
catch(Exception e)
{
    e.printStackTrace();
}
    }//GEN-LAST:event_useDefaultButtonBarTextColor1ActionPerformed

    private void buttonBarTextColorChooserButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBarTextColorChooserButton1ActionPerformed
         try
        {
 if(ProjectManager.get("paymentLabelTextFont")!=null)
        {
            if(ProjectManager.get("paymentLabelTextFont").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentLabelTextFont"));
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("paymentLabelTextFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                }
                tmpArray = getStringArraysFromString(ProjectManager.get("paymentLabelTextFont"));
                demoLabelTextFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                demoLabelTextFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
            }
            else
            {
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font("Arial", 0, 12));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("paymentLabelTextFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentLabelTextFont"));
                    demoLabelTextFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoLabelTextFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
                }
            }
        }
        else
        {
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font("Arial", 0, 12));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("paymentLabelTextFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentLabelTextFont"));
                    demoLabelTextFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoLabelTextFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
                }
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_buttonBarTextColorChooserButton1ActionPerformed

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

    private void ButtonBarBackgroundColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBarBackgroundColorChooserButtonActionPerformed
         try
        {
 if(ProjectManager.get("paymentLabelHeaderTextFont")!=null)
        {
            if(ProjectManager.get("paymentLabelHeaderTextFont").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentLabelHeaderTextFont"));
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("paymentLabelHeaderTextFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                }
                tmpArray = getStringArraysFromString(ProjectManager.get("paymentLabelHeaderTextFont"));
                demoProgressPanelTextFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                demoProgressPanelTextFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
            }
            else
            {
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font("Arial", 0, 12));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("paymentLabelHeaderTextFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentLabelHeaderTextFont"));
                    demoProgressPanelTextFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoProgressPanelTextFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
                }
            }
        }
        else
        {
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font("Arial", 0, 12));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("paymentLabelHeaderTextFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentLabelHeaderTextFont"));
                    demoProgressPanelTextFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoProgressPanelTextFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
                }
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ButtonBarBackgroundColorChooserButtonActionPerformed

    private void useDefaultButtonBarBackgroundColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultButtonBarBackgroundColorActionPerformed
try
{
    if(useDefaultButtonBarBackgroundColor.isSelected() == true)
    {
        demoProgressPanelTextFont.setVisible(false);
        ButtonBarBackgroundColorChooserButton.setVisible(false);
    }
    else
    {
        demoProgressPanelTextFont.setVisible(true);
        ButtonBarBackgroundColorChooserButton.setVisible(true);
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
 
    private void useDefaultButtonBarTextColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultButtonBarTextColorActionPerformed
try
{
    if(useDefaultButtonBarTextColor.isSelected() == true)
    {
        demoButtonBarFont.setVisible(false);
        buttonBarTextColorChooserButton.setVisible(false);
    }
    else
    {
        demoButtonBarFont.setVisible(true);
        buttonBarTextColorChooserButton.setVisible(true);
    }
}
catch(Exception e)
{
    e.printStackTrace();
}
    }//GEN-LAST:event_useDefaultButtonBarTextColorActionPerformed

    private void buttonBarTextColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBarTextColorChooserButtonActionPerformed
        try
        {
 if(ProjectManager.get("paymentLabelHeaderProductNameTextFont")!=null)
        {
            if(ProjectManager.get("paymentLabelHeaderProductNameTextFont").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentLabelHeaderProductNameTextFont"));
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("paymentLabelHeaderProductNameTextFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                }
                tmpArray = getStringArraysFromString(ProjectManager.get("paymentLabelHeaderProductNameTextFont"));
                demoButtonBarFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                demoButtonBarFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
            }
            else
            {
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font("Arial", 0, 12));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("paymentLabelHeaderProductNameTextFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentLabelHeaderProductNameTextFont"));
                    demoButtonBarFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoButtonBarFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
                }
            }
        }
        else
        {
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font("Arial", 0, 12));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("paymentLabelHeaderProductNameTextFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentLabelHeaderProductNameTextFont"));
                    demoButtonBarFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoButtonBarFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
                }
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
 
    }//GEN-LAST:event_buttonBarTextColorChooserButtonActionPerformed

    private static synchronized Object[] getStringArraysFromString(String textArrayString)
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
    private javax.swing.JButton ButtonBarBackgroundColorChooserButton;
    private javax.swing.JButton ButtonBarBackgroundColorChooserButton1;
    private javax.swing.JButton ButtonBarBackgroundColorChooserButton2;
    private javax.swing.JButton PreviewButton;
    private javax.swing.JPanel ProjectLocationsCenterPanel5;
    private javax.swing.JPanel ProjectLookAndFeelImages;
    private javax.swing.JPanel ProjectLookAndFeelImages1;
    private javax.swing.JPanel ProjectLookAndFeelImages2;
    private javax.swing.JPanel ProjectLookAndFeelImages3;
    private javax.swing.JPanel ProjectLookAndFeelImages4;
    private javax.swing.JPanel ProjectLookAndFeelImages5;
    private javax.swing.JPanel ProjectLookAndFeelImages6;
    private javax.swing.JPanel UIChoicesBottomPanel10;
    private javax.swing.JPanel UIChoicesBottomPanel11;
    private javax.swing.JPanel UIChoicesBottomPanel12;
    private javax.swing.JPanel UIChoicesBottomPanel13;
    private javax.swing.JPanel UIChoicesBottomPanel14;
    private javax.swing.JPanel UIChoicesBottomPanel15;
    private javax.swing.JPanel UIChoicesBottomPanel16;
    private javax.swing.JPanel UIChoicesBottomPanel17;
    private javax.swing.JPanel UIChoicesBottomPanel5;
    private javax.swing.JPanel UIChoicesBottomPanel6;
    private javax.swing.JPanel UIChoicesBottomPanel7;
    private javax.swing.JPanel UIChoicesBottomPanel8;
    private javax.swing.JPanel UIChoicesBottomPanel9;
    private javax.swing.JButton buttonBarTextColorChooserButton;
    private javax.swing.JButton buttonBarTextColorChooserButton1;
    private javax.swing.JButton buttonBarTextColorChooserButton2;
    private javax.swing.JLabel demoButtonBarFont;
    private javax.swing.JLabel demoLabelHeaderFont;
    private javax.swing.JLabel demoLabelTextFont;
    private javax.swing.JLabel demoProgressPanelTextFont;
    private javax.swing.JLabel demoSuccessFailureLabelTextFont;
    private javax.swing.JLabel demoSuccessHeaderTextFont;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
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
    private javax.swing.JRadioButton rbPaymentFailurePreview;
    private javax.swing.JRadioButton rbPaymentPreview;
    private javax.swing.JRadioButton rbPaymentSuccessPreview;
    private javax.swing.JCheckBox useDefaultButtonBarBackgroundColor;
    private javax.swing.JCheckBox useDefaultButtonBarBackgroundColor1;
    private javax.swing.JCheckBox useDefaultButtonBarBackgroundColor2;
    private javax.swing.JCheckBox useDefaultButtonBarTextColor;
    private javax.swing.JCheckBox useDefaultButtonBarTextColor1;
    private javax.swing.JCheckBox useDefaultButtonBarTextColor2;
    // End of variables declaration//GEN-END:variables
    
}
