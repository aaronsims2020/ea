/*
 * OptinFontsPanel.java
 *
 * Created on June 13, 2004, 3:24 PM
 */

package com.trinity.ea.design.project.lookandfeel.fonts;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.EADesigner;
import com.trinity.ea.design.common.fontchooser.FontChooser;
import com.trinity.ea.design.optin.actions.OptinAction;
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
public class OptinFontsPanel extends EAPanel {

    /** Creates new form ImagesPanel */
    public OptinFontsPanel() 
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
            if(ProjectManager.get("optinNameEMailFont")!=null)
            {
                if(ProjectManager.get("optinNameEMailFont").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("optinNameEMailFont"));
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
            
            
            if(ProjectManager.get("optinDescriptionFont")!=null)
            {
                if(ProjectManager.get("optinDescriptionFont").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("optinDescriptionFont"));
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
            
            if(ProjectManager.get("optinPrivacyPolicyFont")!=null)
            {
                if(ProjectManager.get("optinPrivacyPolicyFont").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("optinPrivacyPolicyFont"));
                    demoTextLinkFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoTextLinkFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
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
            
            if(ProjectManager.get("optinTextFieldFont")!=null)
            {
                if(ProjectManager.get("optinTextFieldFont").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("optinTextFieldFont"));
                    demoTextFieldFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoTextFieldFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
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
        UIChoicesBottomPanel9 = new javax.swing.JPanel();
        UIChoicesBottomPanel10 = new javax.swing.JPanel();
        lFiller49 = new javax.swing.JLabel();
        useDefaultButtonBarTextColor1 = new javax.swing.JCheckBox();
        buttonBarTextColorChooserButton1 = new javax.swing.JButton();
        lFiller51 = new javax.swing.JLabel();
        lFiller59 = new javax.swing.JLabel();
        demoTextLinkFont = new javax.swing.JLabel();
        ProjectLookAndFeelImages4 = new javax.swing.JPanel();
        UIChoicesBottomPanel11 = new javax.swing.JPanel();
        UIChoicesBottomPanel12 = new javax.swing.JPanel();
        lFiller52 = new javax.swing.JLabel();
        useDefaultButtonBarBackgroundColor1 = new javax.swing.JCheckBox();
        ButtonBarBackgroundColorChooserButton1 = new javax.swing.JButton();
        lFiller60 = new javax.swing.JLabel();
        lFiller53 = new javax.swing.JLabel();
        demoTextFieldFont = new javax.swing.JLabel();
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
        ProjectLookAndFeelImages.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Name/E-mail Label Font", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
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
        useDefaultButtonBarTextColor.setText("Use default Name/E-mail label font");
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
        ProjectLookAndFeelImages1.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Description Font", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
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
        useDefaultButtonBarBackgroundColor.setText("Use default description font");
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
        ProjectLookAndFeelImages2.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Privacy Policy Text Link Font", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
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
        lFiller49.setBackground(new java.awt.Color(140, 160, 210));
        lFiller49.setText("   ");
        lFiller49.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller49.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller49.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel10.add(lFiller49);

        useDefaultButtonBarTextColor1.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultButtonBarTextColor1.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultButtonBarTextColor1.setSelected(true);
        useDefaultButtonBarTextColor1.setText("Use default text link font");
        useDefaultButtonBarTextColor1.setMaximumSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarTextColor1.setMinimumSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarTextColor1.setPreferredSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarTextColor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultButtonBarTextColor1ActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel10.add(useDefaultButtonBarTextColor1);

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

        UIChoicesBottomPanel10.add(buttonBarTextColorChooserButton1);

        lFiller51.setBackground(new java.awt.Color(140, 160, 210));
        lFiller51.setText("   ");
        lFiller51.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller51.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller51.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel10.add(lFiller51);

        lFiller59.setBackground(new java.awt.Color(140, 160, 210));
        lFiller59.setText("   ");
        lFiller59.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller59.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller59.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel10.add(lFiller59);

        demoTextLinkFont.setBackground(new java.awt.Color(140, 160, 210));
        demoTextLinkFont.setText("   ");
        demoTextLinkFont.setMaximumSize(new java.awt.Dimension(32767, 15));
        demoTextLinkFont.setMinimumSize(new java.awt.Dimension(10, 15));
        demoTextLinkFont.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel10.add(demoTextLinkFont);

        ProjectLookAndFeelImages2.add(UIChoicesBottomPanel10);

        add(ProjectLookAndFeelImages2);

        ProjectLookAndFeelImages4.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages4, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages4.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages4.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Text Field (Data Input) Font", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
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
        lFiller52.setBackground(new java.awt.Color(140, 160, 210));
        lFiller52.setText("   ");
        lFiller52.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller52.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller52.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel12.add(lFiller52);

        useDefaultButtonBarBackgroundColor1.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultButtonBarBackgroundColor1.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultButtonBarBackgroundColor1.setSelected(true);
        useDefaultButtonBarBackgroundColor1.setText("Use default text field font");
        useDefaultButtonBarBackgroundColor1.setMaximumSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarBackgroundColor1.setMinimumSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarBackgroundColor1.setPreferredSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarBackgroundColor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultButtonBarBackgroundColor1ActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel12.add(useDefaultButtonBarBackgroundColor1);

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

        UIChoicesBottomPanel12.add(ButtonBarBackgroundColorChooserButton1);

        lFiller60.setBackground(new java.awt.Color(140, 160, 210));
        lFiller60.setText("   ");
        lFiller60.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller60.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller60.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel12.add(lFiller60);

        lFiller53.setBackground(new java.awt.Color(140, 160, 210));
        lFiller53.setText("   ");
        lFiller53.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller53.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller53.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel12.add(lFiller53);

        demoTextFieldFont.setBackground(new java.awt.Color(140, 160, 210));
        demoTextFieldFont.setText("   ");
        demoTextFieldFont.setMaximumSize(new java.awt.Dimension(32767, 15));
        demoTextFieldFont.setMinimumSize(new java.awt.Dimension(10, 15));
        demoTextFieldFont.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel12.add(demoTextFieldFont);

        ProjectLookAndFeelImages4.add(UIChoicesBottomPanel12);

        add(ProjectLookAndFeelImages4);

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

    private void useDefaultButtonBarTextColor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultButtonBarTextColor1ActionPerformed
try
{
    if(useDefaultButtonBarTextColor1.isSelected() == true)
    {
        demoTextLinkFont.setVisible(false);
        buttonBarTextColorChooserButton1.setVisible(false);
    }
    else
    {
        demoTextLinkFont.setVisible(true);
        buttonBarTextColorChooserButton1.setVisible(true);
    }
}
catch(Exception e)
{
    e.printStackTrace();
}
    }//GEN-LAST:event_useDefaultButtonBarTextColor1ActionPerformed

    private void useDefaultButtonBarBackgroundColor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultButtonBarBackgroundColor1ActionPerformed
try
{
    if(useDefaultButtonBarBackgroundColor1.isSelected() == true)
    {
        demoTextFieldFont.setVisible(false);
        ButtonBarBackgroundColorChooserButton1.setVisible(false);
    }
    else
    {
        demoTextFieldFont.setVisible(true);
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
 if(ProjectManager.get("optinTextFieldFont")!=null)
        {
            if(ProjectManager.get("optinTextFieldFont").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("optinTextFieldFont"));
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("optinTextFieldFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                }
                tmpArray = getStringArraysFromString(ProjectManager.get("optinTextFieldFont"));
                demoTextFieldFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                demoTextFieldFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
            }
            else
            {
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font("Arial", 0, 12));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("optinTextFieldFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("optinTextFieldFont"));
                    demoTextFieldFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoTextFieldFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
                }
            }
        }
        else
        {
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font("Arial", 0, 12));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("optinTextFieldFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("optinTextFieldFont"));
                    demoTextFieldFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoTextFieldFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
                }
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ButtonBarBackgroundColorChooserButton1ActionPerformed

    private void buttonBarTextColorChooserButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBarTextColorChooserButton1ActionPerformed
         try
        {
 if(ProjectManager.get("optinPrivacyPolicyFont")!=null)
        {
            if(ProjectManager.get("optinPrivacyPolicyFont").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("optinPrivacyPolicyFont"));
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("optinPrivacyPolicyFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                }
                tmpArray = getStringArraysFromString(ProjectManager.get("optinPrivacyPolicyFont"));
                demoTextLinkFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                demoTextLinkFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
            }
            else
            {
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font("Arial", 0, 12));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("optinPrivacyPolicyFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("optinPrivacyPolicyFont"));
                    demoTextLinkFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoTextLinkFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
                }
            }
        }
        else
        {
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font("Arial", 0, 12));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("optinPrivacyPolicyFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("optinPrivacyPolicyFont"));
                    demoTextLinkFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoTextLinkFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
                }
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_buttonBarTextColorChooserButton1ActionPerformed

    private void ButtonBarBackgroundColorChooserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBarBackgroundColorChooserButtonActionPerformed
         try
        {
 if(ProjectManager.get("optinDescriptionFont")!=null)
        {
            if(ProjectManager.get("optinDescriptionFont").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("optinDescriptionFont"));
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("optinDescriptionFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                }
                tmpArray = getStringArraysFromString(ProjectManager.get("optinDescriptionFont"));
                demoProgressPanelTextFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                demoProgressPanelTextFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
            }
            else
            {
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font("Arial", 0, 12));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("optinDescriptionFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("optinDescriptionFont"));
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
                    ProjectManager.putTempNoFileWrite("optinDescriptionFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("optinDescriptionFont"));
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
			EAPanel thePanel = (EAPanel)getParentComponent();
                ((EAPanel)thePanel.getParentComponent()).getDataUpdate(); 
                new OptinAction();	
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
 if(ProjectManager.get("optinNameEMailFont")!=null)
        {
            if(ProjectManager.get("optinNameEMailFont").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("optinNameEMailFont"));
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("optinNameEMailFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                }
                tmpArray = getStringArraysFromString(ProjectManager.get("optinNameEMailFont"));
                demoButtonBarFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                demoButtonBarFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
            }
            else
            {
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font("Arial", 0, 12));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("optinNameEMailFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("optinNameEMailFont"));
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
                    ProjectManager.putTempNoFileWrite("optinNameEMailFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("optinNameEMailFont"));
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
    private javax.swing.JPanel ImageDescriptionLabel3;
    private javax.swing.JLabel LeftUIFiller5;
    private javax.swing.JButton PreviewButton;
    private javax.swing.JPanel ProjectLocationsCenterPanel4;
    private javax.swing.JPanel ProjectLookAndFeelImages;
    private javax.swing.JPanel ProjectLookAndFeelImages1;
    private javax.swing.JPanel ProjectLookAndFeelImages2;
    private javax.swing.JPanel ProjectLookAndFeelImages3;
    private javax.swing.JPanel ProjectLookAndFeelImages4;
    private javax.swing.JPanel UIChoicesBottomPanel10;
    private javax.swing.JPanel UIChoicesBottomPanel11;
    private javax.swing.JPanel UIChoicesBottomPanel12;
    private javax.swing.JPanel UIChoicesBottomPanel4;
    private javax.swing.JPanel UIChoicesBottomPanel5;
    private javax.swing.JPanel UIChoicesBottomPanel6;
    private javax.swing.JPanel UIChoicesBottomPanel7;
    private javax.swing.JPanel UIChoicesBottomPanel8;
    private javax.swing.JPanel UIChoicesBottomPanel9;
    private javax.swing.JButton buttonBarTextColorChooserButton;
    private javax.swing.JButton buttonBarTextColorChooserButton1;
    private javax.swing.JLabel demoButtonBarFont;
    private javax.swing.JLabel demoProgressPanelTextFont;
    private javax.swing.JLabel demoTextFieldFont;
    private javax.swing.JLabel demoTextLinkFont;
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
    private javax.swing.JLabel lFiller57;
    private javax.swing.JLabel lFiller58;
    private javax.swing.JLabel lFiller59;
    private javax.swing.JLabel lFiller60;
    private javax.swing.JCheckBox useDefaultButtonBarBackgroundColor;
    private javax.swing.JCheckBox useDefaultButtonBarBackgroundColor1;
    private javax.swing.JCheckBox useDefaultButtonBarTextColor;
    private javax.swing.JCheckBox useDefaultButtonBarTextColor1;
    // End of variables declaration//GEN-END:variables
    
}
