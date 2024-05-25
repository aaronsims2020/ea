/*
 * GeneralButtonPanel.java
 *
 * Created on June 13, 2004, 3:24 PM
 */ 

package com.trinity.ea.design.project.lookandfeel.buttons;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.project.lookandfeel.preview.actions.StartVerticalButtonBarThemeAction;
import com.trinity.ea.design.common.fontchooser.FontChooser;
import com.trinity.ea.design.common.filechooser.ImageFileFilter;
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
public class GeneralButtonPanel extends EAPanel {
    ImageFileFilter filter = new ImageFileFilter(new String[] {"gif", "jpg", "jpeg", "png"}, "Select an image file");   
    JFileChooser imageFileChooser = new JFileChooser();
    private ImageIcon noColorIcon = new ImageIcon(getClass().getResource("/images/nocolor.png"));
    /** Creates new form ButtonPanel */
    public GeneralButtonPanel() 
    {
        initComponents();
        updateButtonBarTextColorSwatch();
        updateButtonBarTextColorSwatch1(); 
        updateShadowBorderColorSwatch();
        setProjectData();
    }

    public synchronized void getDataUpdate()
    {
	try
        {
            // Button Bar Height Padding
            SpinnerNumberModel btnBarHeightPaddingSpinModel = (SpinnerNumberModel)spinButtonBarHeightPadding.getModel();
            ProjectManager.putTempNoFileWrite("btnBarHeightPadding", String.valueOf(btnBarHeightPaddingSpinModel.getNumber().intValue()));            

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
            if(ProjectManager.get("paymentButtonTextColor")!=null)
            {
                if(ProjectManager.get("paymentButtonTextColor").equalsIgnoreCase("")==false)
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
            
            if(ProjectManager.get("btnBarTextColor")!=null)
            {
                if(ProjectManager.get("btnBarTextColor").equalsIgnoreCase("")==false)
                {
                    useDefaultButtonBarTextColor1.setSelected(false);
                    buttonBarTextColorChooserButton1.setVisible(true); 
                }
                else
                {
                    useDefaultButtonBarTextColor1.setSelected(true);
                    buttonBarTextColorChooserButton1.setVisible(false);                    
                }
            }
            else
            {
                useDefaultButtonBarTextColor1.setSelected(true);
                buttonBarTextColorChooserButton1.setVisible(false);                
            }  
            
            if(ProjectManager.get("errbtnfont")!=null)
            {
                if(ProjectManager.get("errbtnfont").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("errbtnfont"));
                    demoButtonBarFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoButtonBarFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
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
            
            if(ProjectManager.get("btnBarTextFont")!=null)
            {
                if(ProjectManager.get("btnBarTextFont").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("btnBarTextFont"));
                    demoButtonBarFont1.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoButtonBarFont1.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
                    useDefaultButtonBarTextColor3.setSelected(false);
                }
                else
                {
                    useDefaultButtonBarTextColor3.setSelected(true);
                }
            }
            else
            {
                  useDefaultButtonBarTextColor3.setSelected(true);           
            }   
            
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
		JComponent editor = spinButtonBarHeightPadding.getEditor();
		JSpinner.NumberEditor field = (JSpinner.NumberEditor)editor;
		field.getTextField().setEditable(false);
                
             if(ProjectManager.get("secondaryPaymentMethodButtonFont")!=null)
            {
                if(ProjectManager.get("secondaryPaymentMethodButtonFont").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("secondaryPaymentMethodButtonFont"));
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
             
             if(ProjectManager.get("secondaryPaymentMethodTextColor")!=null)
            {
                if(ProjectManager.get("secondaryPaymentMethodTextColor").equalsIgnoreCase("")==false)
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
	catch(Exception ee)
	{
		ee.printStackTrace();
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
        ProjectLookAndFeelImages2 = new javax.swing.JPanel();
        UIChoicesBottomPanel9 = new javax.swing.JPanel();
        UIChoicesBottomPanel10 = new javax.swing.JPanel();
        lFiller52 = new javax.swing.JLabel();
        useDefaultButtonBarTextColor2 = new javax.swing.JCheckBox();
        buttonBarTextColorChooserButton2 = new javax.swing.JButton();
        lFiller53 = new javax.swing.JLabel();
        lFiller59 = new javax.swing.JLabel();
        demoButtonBarFont = new javax.swing.JLabel();
        ProjectLookAndFeelImages7 = new javax.swing.JPanel();
        UIChoicesBottomPanel18 = new javax.swing.JPanel();
        UIChoicesBottomPanel19 = new javax.swing.JPanel();
        lFiller66 = new javax.swing.JLabel();
        useDefaultProgressBarShadowBorderColor = new javax.swing.JCheckBox();
        progressBarShadowBorderColorChooserButton = new javax.swing.JButton();
        lFiller67 = new javax.swing.JLabel();
        lFiller68 = new javax.swing.JLabel();
        ProjectLookAndFeelImages6 = new javax.swing.JPanel();
        UIChoicesBottomPanel16 = new javax.swing.JPanel();
        UIChoicesBottomPanel17 = new javax.swing.JPanel();
        lFiller63 = new javax.swing.JLabel();
        useDefaultButtonBarBackgroundColor2 = new javax.swing.JCheckBox();
        ButtonBarBackgroundColorChooserButton2 = new javax.swing.JButton();
        lFiller64 = new javax.swing.JLabel();
        lFiller65 = new javax.swing.JLabel();
        demoSuccessFailureLabelTextFont = new javax.swing.JLabel();
        ProjectLookAndFeelImages1 = new javax.swing.JPanel();
        UIChoicesBottomPanel8 = new javax.swing.JPanel();
        UIChoicesBottomPanel6 = new javax.swing.JPanel();
        lFiller46 = new javax.swing.JLabel();
        useDefaultButtonBarTextColor1 = new javax.swing.JCheckBox();
        buttonBarTextColorChooserButton1 = new javax.swing.JButton();
        lFiller50 = new javax.swing.JLabel();
        lFiller58 = new javax.swing.JLabel();
        lFiller51 = new javax.swing.JLabel();
        ProjectLookAndFeelImages3 = new javax.swing.JPanel();
        UIChoicesBottomPanel11 = new javax.swing.JPanel();
        UIChoicesBottomPanel12 = new javax.swing.JPanel();
        lFiller54 = new javax.swing.JLabel();
        useDefaultButtonBarTextColor3 = new javax.swing.JCheckBox();
        buttonBarTextColorChooserButton3 = new javax.swing.JButton();
        lFiller55 = new javax.swing.JLabel();
        lFiller60 = new javax.swing.JLabel();
        demoButtonBarFont1 = new javax.swing.JLabel();
        ProjectLookAndFeelImages4 = new javax.swing.JPanel();
        ImageDescriptionLabel = new javax.swing.JPanel();
        LeftUIFiller2 = new javax.swing.JLabel();
        lOverrideDefaultSplashImageWidth3 = new javax.swing.JLabel();
        spinButtonBarHeightPadding = new javax.swing.JSpinner();
        lFiller30 = new javax.swing.JLabel();
        UIChoicesBottomPanel13 = new javax.swing.JPanel();
        SouthButtonPanelFiller = new javax.swing.JPanel();
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
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });

        ProjectLookAndFeelImages.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Common Button Text Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
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
        useDefaultButtonBarTextColor.setText("Use default common button text color");
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

        ProjectLookAndFeelImages2.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages2, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages2.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages2.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Common Button Text Font", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
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

        useDefaultButtonBarTextColor2.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultButtonBarTextColor2.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultButtonBarTextColor2.setSelected(true);
        useDefaultButtonBarTextColor2.setText("Use default common button text font");
        useDefaultButtonBarTextColor2.setMaximumSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarTextColor2.setMinimumSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarTextColor2.setPreferredSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarTextColor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultButtonBarTextColor2ActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel10.add(useDefaultButtonBarTextColor2);

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

        UIChoicesBottomPanel10.add(buttonBarTextColorChooserButton2);

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

        demoButtonBarFont.setBackground(new java.awt.Color(140, 160, 210));
        demoButtonBarFont.setText("   ");
        demoButtonBarFont.setMaximumSize(new java.awt.Dimension(32767, 15));
        demoButtonBarFont.setMinimumSize(new java.awt.Dimension(10, 15));
        demoButtonBarFont.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel10.add(demoButtonBarFont);

        ProjectLookAndFeelImages2.add(UIChoicesBottomPanel10);

        add(ProjectLookAndFeelImages2);

        ProjectLookAndFeelImages7.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages7, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages7.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages7.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Secondary Payment Processing Method Option Button Text Color (Optional - only on enabled)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages7.setMaximumSize(new java.awt.Dimension(32767, 60));
        ProjectLookAndFeelImages7.setMinimumSize(new java.awt.Dimension(10, 60));
        ProjectLookAndFeelImages7.setPreferredSize(new java.awt.Dimension(10, 60));
        UIChoicesBottomPanel18.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel18, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel18.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel18.setMaximumSize(new java.awt.Dimension(32767, 4));
        UIChoicesBottomPanel18.setMinimumSize(new java.awt.Dimension(5, 4));
        UIChoicesBottomPanel18.setPreferredSize(new java.awt.Dimension(200, 4));
        ProjectLookAndFeelImages7.add(UIChoicesBottomPanel18);

        UIChoicesBottomPanel19.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel19, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel19.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel19.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel19.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel19.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller66.setBackground(new java.awt.Color(140, 160, 210));
        lFiller66.setText("   ");
        lFiller66.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller66.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller66.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel19.add(lFiller66);

        useDefaultProgressBarShadowBorderColor.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultProgressBarShadowBorderColor.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultProgressBarShadowBorderColor.setSelected(true);
        useDefaultProgressBarShadowBorderColor.setText("Use default button text color");
        useDefaultProgressBarShadowBorderColor.setMaximumSize(new java.awt.Dimension(300, 23));
        useDefaultProgressBarShadowBorderColor.setMinimumSize(new java.awt.Dimension(300, 23));
        useDefaultProgressBarShadowBorderColor.setPreferredSize(new java.awt.Dimension(300, 23));
        useDefaultProgressBarShadowBorderColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultProgressBarShadowBorderColorActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel19.add(useDefaultProgressBarShadowBorderColor);

        progressBarShadowBorderColorChooserButton.setBackground(new java.awt.Color(140, 160, 210));
        progressBarShadowBorderColorChooserButton.setMaximumSize(new java.awt.Dimension(35, 20));
        progressBarShadowBorderColorChooserButton.setMinimumSize(new java.awt.Dimension(35, 20));
        progressBarShadowBorderColorChooserButton.setPreferredSize(new java.awt.Dimension(35, 20));
        progressBarShadowBorderColorChooserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progressBarShadowBorderColorChooserButtonActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel19.add(progressBarShadowBorderColorChooserButton);

        lFiller67.setBackground(new java.awt.Color(140, 160, 210));
        lFiller67.setText("   ");
        lFiller67.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller67.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller67.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel19.add(lFiller67);

        lFiller68.setBackground(new java.awt.Color(140, 160, 210));
        lFiller68.setText("   ");
        lFiller68.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller68.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller68.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel19.add(lFiller68);

        ProjectLookAndFeelImages7.add(UIChoicesBottomPanel19);

        add(ProjectLookAndFeelImages7);

        ProjectLookAndFeelImages6.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages6, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages6.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages6.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Secondary Payment Processing Method Option Button Text Font (Optional - only on enabled)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
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
        lFiller63.setBackground(new java.awt.Color(140, 160, 210));
        lFiller63.setText("   ");
        lFiller63.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller63.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller63.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel17.add(lFiller63);

        useDefaultButtonBarBackgroundColor2.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultButtonBarBackgroundColor2.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultButtonBarBackgroundColor2.setSelected(true);
        useDefaultButtonBarBackgroundColor2.setText("Use default button text font");
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

        lFiller64.setBackground(new java.awt.Color(140, 160, 210));
        lFiller64.setText("   ");
        lFiller64.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller64.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller64.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel17.add(lFiller64);

        lFiller65.setBackground(new java.awt.Color(140, 160, 210));
        lFiller65.setText("   ");
        lFiller65.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller65.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller65.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel17.add(lFiller65);

        demoSuccessFailureLabelTextFont.setBackground(new java.awt.Color(140, 160, 210));
        demoSuccessFailureLabelTextFont.setText("   ");
        demoSuccessFailureLabelTextFont.setMaximumSize(new java.awt.Dimension(32767, 15));
        demoSuccessFailureLabelTextFont.setMinimumSize(new java.awt.Dimension(10, 15));
        demoSuccessFailureLabelTextFont.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel17.add(demoSuccessFailureLabelTextFont);

        ProjectLookAndFeelImages6.add(UIChoicesBottomPanel17);

        add(ProjectLookAndFeelImages6);

        ProjectLookAndFeelImages1.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages1, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages1.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages1.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Startup Window Button Text Color", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
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

        useDefaultButtonBarTextColor1.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultButtonBarTextColor1.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultButtonBarTextColor1.setSelected(true);
        useDefaultButtonBarTextColor1.setText("Use default startup window button text color");
        useDefaultButtonBarTextColor1.setMaximumSize(new java.awt.Dimension(300, 23));
        useDefaultButtonBarTextColor1.setMinimumSize(new java.awt.Dimension(300, 23));
        useDefaultButtonBarTextColor1.setPreferredSize(new java.awt.Dimension(300, 23));
        useDefaultButtonBarTextColor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultButtonBarTextColor1ActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel6.add(useDefaultButtonBarTextColor1);

        buttonBarTextColorChooserButton1.setBackground(new java.awt.Color(140, 160, 210));
        buttonBarTextColorChooserButton1.setMaximumSize(new java.awt.Dimension(35, 20));
        buttonBarTextColorChooserButton1.setMinimumSize(new java.awt.Dimension(35, 20));
        buttonBarTextColorChooserButton1.setPreferredSize(new java.awt.Dimension(35, 20));
        buttonBarTextColorChooserButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBarTextColorChooserButton1ActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel6.add(buttonBarTextColorChooserButton1);

        lFiller50.setBackground(new java.awt.Color(140, 160, 210));
        lFiller50.setText("   ");
        lFiller50.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller50.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller50.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel6.add(lFiller50);

        lFiller58.setBackground(new java.awt.Color(140, 160, 210));
        lFiller58.setText("   ");
        lFiller58.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller58.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller58.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel6.add(lFiller58);

        lFiller51.setBackground(new java.awt.Color(140, 160, 210));
        lFiller51.setText("   ");
        lFiller51.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller51.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller51.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel6.add(lFiller51);

        ProjectLookAndFeelImages1.add(UIChoicesBottomPanel6);

        add(ProjectLookAndFeelImages1);

        ProjectLookAndFeelImages3.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages3, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages3.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages3.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Startup Window Button Font", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages3.setMaximumSize(new java.awt.Dimension(32767, 60));
        ProjectLookAndFeelImages3.setMinimumSize(new java.awt.Dimension(10, 60));
        ProjectLookAndFeelImages3.setPreferredSize(new java.awt.Dimension(10, 60));
        UIChoicesBottomPanel11.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel11, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel11.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel11.setMaximumSize(new java.awt.Dimension(32767, 4));
        UIChoicesBottomPanel11.setMinimumSize(new java.awt.Dimension(5, 4));
        UIChoicesBottomPanel11.setPreferredSize(new java.awt.Dimension(200, 4));
        ProjectLookAndFeelImages3.add(UIChoicesBottomPanel11);

        UIChoicesBottomPanel12.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel12, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel12.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel12.setMaximumSize(new java.awt.Dimension(32767, 20));
        UIChoicesBottomPanel12.setMinimumSize(new java.awt.Dimension(5, 20));
        UIChoicesBottomPanel12.setPreferredSize(new java.awt.Dimension(200, 20));
        lFiller54.setBackground(new java.awt.Color(140, 160, 210));
        lFiller54.setText("   ");
        lFiller54.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller54.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller54.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel12.add(lFiller54);

        useDefaultButtonBarTextColor3.setBackground(new java.awt.Color(140, 160, 210));
        useDefaultButtonBarTextColor3.setFont(new java.awt.Font("Arial", 0, 12));
        useDefaultButtonBarTextColor3.setSelected(true);
        useDefaultButtonBarTextColor3.setText("Use default startup window button font");
        useDefaultButtonBarTextColor3.setMaximumSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarTextColor3.setMinimumSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarTextColor3.setPreferredSize(new java.awt.Dimension(250, 23));
        useDefaultButtonBarTextColor3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDefaultButtonBarTextColor3ActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel12.add(useDefaultButtonBarTextColor3);

        buttonBarTextColorChooserButton3.setBackground(new java.awt.Color(140, 160, 210));
        buttonBarTextColorChooserButton3.setText("Set Font...");
        buttonBarTextColorChooserButton3.setMaximumSize(new java.awt.Dimension(90, 25));
        buttonBarTextColorChooserButton3.setMinimumSize(new java.awt.Dimension(90, 25));
        buttonBarTextColorChooserButton3.setPreferredSize(new java.awt.Dimension(90, 25));
        buttonBarTextColorChooserButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBarTextColorChooserButton3ActionPerformed(evt);
            }
        });

        UIChoicesBottomPanel12.add(buttonBarTextColorChooserButton3);

        lFiller55.setBackground(new java.awt.Color(140, 160, 210));
        lFiller55.setText("   ");
        lFiller55.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller55.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller55.setPreferredSize(new java.awt.Dimension(10, 16));
        UIChoicesBottomPanel12.add(lFiller55);

        lFiller60.setBackground(new java.awt.Color(140, 160, 210));
        lFiller60.setText("   ");
        lFiller60.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller60.setMinimumSize(new java.awt.Dimension(10, 15));
        lFiller60.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel12.add(lFiller60);

        demoButtonBarFont1.setBackground(new java.awt.Color(140, 160, 210));
        demoButtonBarFont1.setText("   ");
        demoButtonBarFont1.setMaximumSize(new java.awt.Dimension(32767, 15));
        demoButtonBarFont1.setMinimumSize(new java.awt.Dimension(10, 15));
        demoButtonBarFont1.setPreferredSize(new java.awt.Dimension(10, 15));
        UIChoicesBottomPanel12.add(demoButtonBarFont1);

        ProjectLookAndFeelImages3.add(UIChoicesBottomPanel12);

        add(ProjectLookAndFeelImages3);

        ProjectLookAndFeelImages4.setLayout(new javax.swing.BoxLayout(ProjectLookAndFeelImages4, javax.swing.BoxLayout.Y_AXIS));

        ProjectLookAndFeelImages4.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLookAndFeelImages4.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Startup Window Button Bar Height Pad", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        ProjectLookAndFeelImages4.setMaximumSize(new java.awt.Dimension(32767, 60));
        ProjectLookAndFeelImages4.setMinimumSize(new java.awt.Dimension(10, 60));
        ProjectLookAndFeelImages4.setPreferredSize(new java.awt.Dimension(10, 60));
        ImageDescriptionLabel.setLayout(new javax.swing.BoxLayout(ImageDescriptionLabel, javax.swing.BoxLayout.X_AXIS));

        ImageDescriptionLabel.setBackground(new java.awt.Color(140, 160, 210));
        LeftUIFiller2.setMaximumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller2.setMinimumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller2.setPreferredSize(new java.awt.Dimension(10, 10));
        ImageDescriptionLabel.add(LeftUIFiller2);

        lOverrideDefaultSplashImageWidth3.setBackground(new java.awt.Color(140, 160, 210));
        lOverrideDefaultSplashImageWidth3.setFont(new java.awt.Font("Arial", 0, 12));
        lOverrideDefaultSplashImageWidth3.setText("Startup Window Button bar height pad:");
        lOverrideDefaultSplashImageWidth3.setMaximumSize(new java.awt.Dimension(220, 15));
        lOverrideDefaultSplashImageWidth3.setMinimumSize(new java.awt.Dimension(220, 15));
        lOverrideDefaultSplashImageWidth3.setPreferredSize(new java.awt.Dimension(220, 15));
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

        ProjectLookAndFeelImages4.add(ImageDescriptionLabel);

        UIChoicesBottomPanel13.setLayout(new javax.swing.BoxLayout(UIChoicesBottomPanel13, javax.swing.BoxLayout.X_AXIS));

        UIChoicesBottomPanel13.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel13.setMaximumSize(new java.awt.Dimension(32767, 4));
        UIChoicesBottomPanel13.setMinimumSize(new java.awt.Dimension(5, 4));
        UIChoicesBottomPanel13.setPreferredSize(new java.awt.Dimension(200, 4));
        ProjectLookAndFeelImages4.add(UIChoicesBottomPanel13);

        add(ProjectLookAndFeelImages4);

        SouthButtonPanelFiller.setLayout(new javax.swing.BoxLayout(SouthButtonPanelFiller, javax.swing.BoxLayout.Y_AXIS));

        SouthButtonPanelFiller.setBackground(new java.awt.Color(140, 160, 210));
        SouthButtonPanelFiller.setMaximumSize(new java.awt.Dimension(32767, 75));
        SouthButtonPanelFiller.setMinimumSize(new java.awt.Dimension(10, 50));
        SouthButtonPanelFiller.setPreferredSize(new java.awt.Dimension(10, 60));
        ImageDescriptionLabel3.setLayout(new javax.swing.BoxLayout(ImageDescriptionLabel3, javax.swing.BoxLayout.X_AXIS));

        ImageDescriptionLabel3.setBackground(new java.awt.Color(140, 160, 210));
        LeftUIFiller5.setMaximumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller5.setMinimumSize(new java.awt.Dimension(10, 10));
        LeftUIFiller5.setPreferredSize(new java.awt.Dimension(10, 10));
        ImageDescriptionLabel3.add(LeftUIFiller5);

        SouthButtonPanelFiller.add(ImageDescriptionLabel3);

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

        SouthButtonPanelFiller.add(ProjectLocationsCenterPanel4);

        UIChoicesBottomPanel4.setBackground(new java.awt.Color(140, 160, 210));
        UIChoicesBottomPanel4.setMinimumSize(new java.awt.Dimension(5, 5));
        UIChoicesBottomPanel4.setPreferredSize(new java.awt.Dimension(5, 5));
        SouthButtonPanelFiller.add(UIChoicesBottomPanel4);

        add(SouthButtonPanelFiller);

    }//GEN-END:initComponents

    private void useDefaultProgressBarShadowBorderColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultProgressBarShadowBorderColorActionPerformed
        try
        {
            if(useDefaultProgressBarShadowBorderColor.isSelected()==true)
            {
                ProjectManager.put("secondaryPaymentMethodTextColor", "");
                ProjectManager.remove("secondaryPaymentMethodTextColor");                
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
        if(ProjectManager.get("secondaryPaymentMethodTextColor")!=null)
        {
            if(ProjectManager.get("secondaryPaymentMethodTextColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("secondaryPaymentMethodTextColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("secondaryPaymentMethodTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                progressBarShadowBorderColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("secondaryPaymentMethodTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressBarShadowBorderColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("secondaryPaymentMethodTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                progressBarShadowBorderColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_progressBarShadowBorderColorChooserButtonActionPerformed

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
 if(ProjectManager.get("secondaryPaymentMethodButtonFont")!=null)
        {
            if(ProjectManager.get("secondaryPaymentMethodButtonFont").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("secondaryPaymentMethodButtonFont"));
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("secondaryPaymentMethodButtonFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
               }
                tmpArray = getStringArraysFromString(ProjectManager.get("secondaryPaymentMethodButtonFont"));
                demoSuccessFailureLabelTextFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                demoSuccessFailureLabelTextFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
            }
            else
            {
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font("Arial", 0, 12));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("secondaryPaymentMethodButtonFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("secondaryPaymentMethodButtonFont"));
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
                    ProjectManager.putTempNoFileWrite("secondaryPaymentMethodButtonFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("secondaryPaymentMethodButtonFont"));
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

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
getDataUpdate();
    }//GEN-LAST:event_formFocusLost

    private void useDefaultButtonBarTextColor3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultButtonBarTextColor3ActionPerformed
try
{
    if(useDefaultButtonBarTextColor3.isSelected() == true)
    {
        demoButtonBarFont1.setVisible(false);
        buttonBarTextColorChooserButton3.setVisible(false);
    }
    else
    {
        demoButtonBarFont1.setVisible(true);
        buttonBarTextColorChooserButton3.setVisible(true);
    }
}
catch(Exception e)
{
    e.printStackTrace();
}
    }//GEN-LAST:event_useDefaultButtonBarTextColor3ActionPerformed

    private void buttonBarTextColorChooserButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBarTextColorChooserButton3ActionPerformed
        try
        {
 if(ProjectManager.get("btnBarTextFont")!=null)
        {
            if(ProjectManager.get("btnBarTextFont").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("btnBarTextFont"));
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("btnBarTextFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                }
                tmpArray = getStringArraysFromString(ProjectManager.get("btnBarTextFont"));
                demoButtonBarFont1.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                demoButtonBarFont1.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
            }
            else
            {
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font("Arial", 0, 12));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("btnBarTextFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("btnBarTextFont"));
                    demoButtonBarFont1.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoButtonBarFont1.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
                }
            }
        }
        else
        {
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font("Arial", 0, 12));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("btnBarTextFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("btnBarTextFont"));
                    demoButtonBarFont1.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoButtonBarFont1.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
                }
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_buttonBarTextColorChooserButton3ActionPerformed

    private void useDefaultButtonBarTextColor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultButtonBarTextColor2ActionPerformed
try
{
    if(useDefaultButtonBarTextColor2.isSelected() == true)
    {
        demoButtonBarFont.setVisible(false);
        buttonBarTextColorChooserButton2.setVisible(false);
    }
    else
    {
        demoButtonBarFont.setVisible(true);
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
 if(ProjectManager.get("errbtnfont")!=null)
        {
            if(ProjectManager.get("errbtnfont").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("errbtnfont"));
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("errbtnfont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    ProjectManager.putTempNoFileWrite("optinButtonFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    ProjectManager.putTempNoFileWrite("registrationButtonFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    ProjectManager.putTempNoFileWrite("paymentButtonFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                }
                tmpArray = getStringArraysFromString(ProjectManager.get("errbtnfont"));
                demoButtonBarFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                demoButtonBarFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
            }
            else
            {
                Font retFont = FontChooser.showDialog(getParentComp(),"Font Chooser", new Font("Arial", 0, 12));
                if(retFont!=null)
                {
                    ProjectManager.putTempNoFileWrite("errbtnfont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    ProjectManager.putTempNoFileWrite("optinButtonFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    ProjectManager.putTempNoFileWrite("registrationButtonFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    ProjectManager.putTempNoFileWrite("paymentButtonFont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("errbtnfont"));
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
                    ProjectManager.putTempNoFileWrite("errbtnfont",retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize()));
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("errbtnfont"));
                    demoButtonBarFont.setFont(new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                    demoButtonBarFont.setText((String)tmpArray[0] + ", " + (String)tmpArray[1] + ", " + (String)tmpArray[2]);
                }
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_buttonBarTextColorChooserButton2ActionPerformed

    private void useDefaultButtonBarTextColor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultButtonBarTextColor1ActionPerformed
        try
        {
            if(useDefaultButtonBarTextColor1.isSelected()==true)
            {
                ProjectManager.put("btnBarTextColor", "");
                buttonBarTextColorChooserButton1.setVisible(false);                      
            }
            else
            {
                buttonBarTextColorChooserButton1.setVisible(true);  
                updateButtonBarTextColorSwatch1();            
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_useDefaultButtonBarTextColor1ActionPerformed

    private void buttonBarTextColorChooserButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBarTextColorChooserButton1ActionPerformed
 	// Bring up a color chooser 
        if(ProjectManager.get("btnBarTextColor")!=null)
        {
            if(ProjectManager.get("btnBarTextColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("btnBarTextColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("btnBarTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                buttonBarTextColorChooserButton1.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("btnBarTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                buttonBarTextColorChooserButton1.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("btnBarTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                buttonBarTextColorChooserButton1.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_buttonBarTextColorChooserButton1ActionPerformed

    private void useDefaultButtonBarTextColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDefaultButtonBarTextColorActionPerformed
        try
        {
            if(useDefaultButtonBarTextColor.isSelected()==true)
            {
                ProjectManager.put("paymentButtonTextColor", "");
                ProjectManager.put("refundPolicyButtonTextColor", "");
                ProjectManager.put("optinButtonTextColor", "");      
                ProjectManager.put("privacyPolicyButtonTextColor", "");   
                ProjectManager.put("informationButtonTextColor", "");    
                ProjectManager.put("errbtnfontclr", ""); 
                ProjectManager.put("msgbtnfontclr", "");                  
                
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
        if(ProjectManager.get("paymentButtonTextColor")!=null)
        {
            if(ProjectManager.get("paymentButtonTextColor").equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentButtonTextColor"));
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                ProjectManager.put("paymentButtonTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ProjectManager.put("refundPolicyButtonTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ProjectManager.put("optinButtonTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ProjectManager.put("privacyPolicyButtonTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ProjectManager.put("informationButtonTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ProjectManager.put("errbtnfontclr", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ProjectManager.put("msgbtnfontclr", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                buttonBarTextColorChooserButton.setIcon(new ColorSwatch(c));
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("paymentButtonTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                ProjectManager.put("refundPolicyButtonTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ProjectManager.put("optinButtonTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ProjectManager.put("privacyPolicyButtonTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ProjectManager.put("informationButtonTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ProjectManager.put("errbtnfontclr", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ProjectManager.put("msgbtnfontclr", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));

                buttonBarTextColorChooserButton.setIcon(new ColorSwatch(c));
            }
        }
        else
        {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                ProjectManager.put("paymentButtonTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));                
                ProjectManager.put("refundPolicyButtonTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ProjectManager.put("optinButtonTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ProjectManager.put("privacyPolicyButtonTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ProjectManager.put("informationButtonTextColor", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ProjectManager.put("errbtnfontclr", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));
                ProjectManager.put("msgbtnfontclr", String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue()));

                buttonBarTextColorChooserButton.setIcon(new ColorSwatch(c));
        }
    }//GEN-LAST:event_buttonBarTextColorChooserButtonActionPerformed

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

    private void updateButtonBarTextColorSwatch()
    {
        try
        {
            Color c = new java.awt.Color(255,255,255); 
            // Bring up a color chooser 
            if(ProjectManager.get("paymentButtonTextColor")!=null)
            {
                if(ProjectManager.get("paymentButtonTextColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("paymentButtonTextColor"));
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

    private void updateButtonBarTextColorSwatch1()
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
                    buttonBarTextColorChooserButton1.setIcon(new ColorSwatch(c));
                }
                else
                {
                    buttonBarTextColorChooserButton1.setIcon(noColorIcon);
                }
            }
            else
            {
                buttonBarTextColorChooserButton1.setIcon(noColorIcon);
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
            if(ProjectManager.get("secondaryPaymentMethodTextColor")!=null)
            {
                if(ProjectManager.get("secondaryPaymentMethodTextColor").equalsIgnoreCase("")==false)
                {
                    Object[] tmpArray = getStringArraysFromString(ProjectManager.get("secondaryPaymentMethodTextColor"));
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
    private javax.swing.JButton ButtonBarBackgroundColorChooserButton2;
    private javax.swing.JPanel ImageDescriptionLabel;
    private javax.swing.JPanel ImageDescriptionLabel3;
    private javax.swing.JLabel LeftUIFiller2;
    private javax.swing.JLabel LeftUIFiller5;
    private javax.swing.JButton PreviewButton;
    private javax.swing.JPanel ProjectLocationsCenterPanel4;
    private javax.swing.JPanel ProjectLookAndFeelImages;
    private javax.swing.JPanel ProjectLookAndFeelImages1;
    private javax.swing.JPanel ProjectLookAndFeelImages2;
    private javax.swing.JPanel ProjectLookAndFeelImages3;
    private javax.swing.JPanel ProjectLookAndFeelImages4;
    private javax.swing.JPanel ProjectLookAndFeelImages6;
    private javax.swing.JPanel ProjectLookAndFeelImages7;
    private javax.swing.JPanel SouthButtonPanelFiller;
    private javax.swing.JPanel UIChoicesBottomPanel10;
    private javax.swing.JPanel UIChoicesBottomPanel11;
    private javax.swing.JPanel UIChoicesBottomPanel12;
    private javax.swing.JPanel UIChoicesBottomPanel13;
    private javax.swing.JPanel UIChoicesBottomPanel16;
    private javax.swing.JPanel UIChoicesBottomPanel17;
    private javax.swing.JPanel UIChoicesBottomPanel18;
    private javax.swing.JPanel UIChoicesBottomPanel19;
    private javax.swing.JPanel UIChoicesBottomPanel4;
    private javax.swing.JPanel UIChoicesBottomPanel5;
    private javax.swing.JPanel UIChoicesBottomPanel6;
    private javax.swing.JPanel UIChoicesBottomPanel7;
    private javax.swing.JPanel UIChoicesBottomPanel8;
    private javax.swing.JPanel UIChoicesBottomPanel9;
    private javax.swing.JButton buttonBarTextColorChooserButton;
    private javax.swing.JButton buttonBarTextColorChooserButton1;
    private javax.swing.JButton buttonBarTextColorChooserButton2;
    private javax.swing.JButton buttonBarTextColorChooserButton3;
    private javax.swing.JLabel demoButtonBarFont;
    private javax.swing.JLabel demoButtonBarFont1;
    private javax.swing.JLabel demoSuccessFailureLabelTextFont;
    private javax.swing.JLabel lFiller30;
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
    private javax.swing.JLabel lFiller57;
    private javax.swing.JLabel lFiller58;
    private javax.swing.JLabel lFiller59;
    private javax.swing.JLabel lFiller60;
    private javax.swing.JLabel lFiller63;
    private javax.swing.JLabel lFiller64;
    private javax.swing.JLabel lFiller65;
    private javax.swing.JLabel lFiller66;
    private javax.swing.JLabel lFiller67;
    private javax.swing.JLabel lFiller68;
    private javax.swing.JLabel lOverrideDefaultSplashImageWidth3;
    private javax.swing.JButton progressBarShadowBorderColorChooserButton;
    private javax.swing.JSpinner spinButtonBarHeightPadding;
    private javax.swing.JCheckBox useDefaultButtonBarBackgroundColor2;
    private javax.swing.JCheckBox useDefaultButtonBarTextColor;
    private javax.swing.JCheckBox useDefaultButtonBarTextColor1;
    private javax.swing.JCheckBox useDefaultButtonBarTextColor2;
    private javax.swing.JCheckBox useDefaultButtonBarTextColor3;
    private javax.swing.JCheckBox useDefaultProgressBarShadowBorderColor;
    // End of variables declaration//GEN-END:variables
    
}
