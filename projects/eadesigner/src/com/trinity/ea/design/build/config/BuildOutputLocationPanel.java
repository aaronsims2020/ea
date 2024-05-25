/*
 * BuildOutputLocationPanel.java
 *
 * Created on May 24, 2004, 4:30 PM
 */

package com.trinity.ea.design.build.config;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.common.panel.EAPanel;
//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Font;
import java.io.File;
import java.net.URL;
 
/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class BuildOutputLocationPanel extends EAPanel {
    
    /** Creates new form BuildOutputLocationPanel */
    public BuildOutputLocationPanel() {
        initComponents();
        tempButton = new javax.swing.JButton();
        tfJar2OutputName.setBackground(javax.swing.UIManager.getDefaults().getColor("TextField.inactiveBackground"));
        tfJarOutputName.setBackground(javax.swing.UIManager.getDefaults().getColor("TextField.inactiveBackground"));
        BuildOutputLocation.setBackground(javax.swing.UIManager.getDefaults().getColor("TextField.inactiveBackground"));
 
	setProjectData();
    }

    public void setProjectData()
    {
        try
        {
		// Evaluation Expiration Support Functionality Checkbox Enabled/Disabled   
            if(ProjectManager.get("project_build_dir")!=null)
            {
                if(ProjectManager.get("project_last_built").equalsIgnoreCase("This project has not been built.")==true)
                {
                    BuildOutputLocation.setText(ProjectManager.get("project_last_built"));
                }
                else
                {
                    BuildOutputLocation.setText(new File(new URL(ProjectManager.get("project_build_dir")).getFile()).getCanonicalPath());
                }	
            }
            try
            {
                tfJarOutputName.setText(ProjectManager.get("project_jarfile_name"));      
                tfJar2OutputName.setText(ProjectManager.get("project_jarfile2_name")); 
                 if(ProjectManager.get("project_auto_update_support_is_enabled")!=null)
                 {
                     if(ProjectManager.get("project_auto_update_support_is_enabled").equalsIgnoreCase("true")==true)
                     {                     
                        Jar2OutputLabel.setVisible(true);
                        tfJar2OutputName.setVisible(true);
                        taCPLabel.setVisible(true);
                     }
                     else
                     {
                        Jar2OutputLabel.setVisible(false);
                        taCPLabel.setVisible(false);
                        tfJar2OutputName.setVisible(false);
                        
                     }
                 }
                 else
                 {
                    Jar2OutputLabel.setVisible(false);
                    tfJar2OutputName.setVisible(false);
                    taCPLabel.setVisible(false);
                 }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            BuildOutputLocation.setCaretPosition(0);
            tfJar2OutputName.setCaretPosition(0);
            tfJarOutputName.setCaretPosition(0);            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }        
    public void getDataUpdate()
    { 
        try
        {
            if(tfJarOutputName.getText().equalsIgnoreCase("")==false)
            {
                try
                {
                    if(tfJarOutputName.getText().equalsIgnoreCase(ProjectManager.get("project_jarfile_name"))==false)
                    {
                        if(ProjectManager.get("project_build_dir")!=null)
                        {
                            if(ProjectManager.get("project_last_built").equalsIgnoreCase("This project has not been built.")==false)
                            {
                                File tempFile = new File(new URL(ProjectManager.get("project_build_dir") + ProjectManager.get("project_jarfile_name")).getFile());
                                if(tempFile.exists()==true)
                                {
                                        tempFile.delete();
                                }
                            }	
                        }
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                ProjectManager.put("project_jarfile_name",tfJarOutputName.getText());
            }
            if(tfJar2OutputName.getText().equalsIgnoreCase("")==false)
            {
                try
                {
                    if(tfJar2OutputName.getText().equalsIgnoreCase(ProjectManager.get("project_jarfile2_name"))==false)
                    {
                        if(ProjectManager.get("project_build_dir")!=null)
                        {
                            if(ProjectManager.get("project_last_built").equalsIgnoreCase("This project has not been built.")==false)
                            {
                                File tempFile = new File(new URL(ProjectManager.get("project_build_dir") + ProjectManager.get("project_jarfile2_name")).getFile());
                                if(tempFile.exists()==true)
                                {
                                        tempFile.delete();
                                }
                            }	
                        }
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                ProjectManager.put("project_jarfile2_name",tfJar2OutputName.getText());
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
        LabelPanel = new javax.swing.JPanel();
        filler2 = new javax.swing.JLabel();
        BuildOutputLabel = new javax.swing.JLabel();
        filler4 = new javax.swing.JLabel();
        BuildLocationPanel = new javax.swing.JPanel();
        filler = new javax.swing.JLabel();
        BuildOutputLocation = new javax.swing.JTextField();
        filler1 = new javax.swing.JLabel();
        JarPanelMain = new javax.swing.JPanel();
        LeftPanel = new javax.swing.JPanel();
        JarPanel1 = new javax.swing.JPanel();
        filler10 = new javax.swing.JLabel();
        JarPanel = new javax.swing.JPanel();
        filler3 = new javax.swing.JLabel();
        BuildOutputLabel2 = new javax.swing.JLabel();
        filler5 = new javax.swing.JLabel();
        Jar2OutputLabel = new javax.swing.JLabel();
        filler8 = new javax.swing.JLabel();
        BuildLocationPanel1 = new javax.swing.JPanel();
        filler6 = new javax.swing.JLabel();
        tfJarOutputName = new javax.swing.JTextField();
        filler7 = new javax.swing.JLabel();
        tfJar2OutputName = new javax.swing.JTextField();
        filler9 = new javax.swing.JLabel();
        JarPanelMain1 = new javax.swing.JPanel();
        TPanel = new javax.swing.JPanel();
        taCPLabel = new javax.swing.JTextArea();
        fillerNorth = new javax.swing.JLabel();
        fillerEast = new javax.swing.JLabel();
        fillerWest = new javax.swing.JLabel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        setBackground(new java.awt.Color(100, 120, 170));
        setMaximumSize(new java.awt.Dimension(2147483647, 75));
        setMinimumSize(new java.awt.Dimension(12, 75));
        setPreferredSize(new java.awt.Dimension(12, 75));
        LabelPanel.setLayout(new java.awt.BorderLayout());

        LabelPanel.setBackground(new java.awt.Color(100, 120, 170));
        LabelPanel.setMaximumSize(new java.awt.Dimension(32767, 15));
        LabelPanel.setMinimumSize(new java.awt.Dimension(10, 15));
        LabelPanel.setPreferredSize(new java.awt.Dimension(10, 15));
        filler2.setBackground(new java.awt.Color(100, 120, 170));
        filler2.setMaximumSize(new java.awt.Dimension(10, 10));
        filler2.setMinimumSize(new java.awt.Dimension(10, 10));
        filler2.setPreferredSize(new java.awt.Dimension(10, 10));
        LabelPanel.add(filler2, java.awt.BorderLayout.WEST);

        BuildOutputLabel.setBackground(new java.awt.Color(100, 120, 170));
        BuildOutputLabel.setFont(new java.awt.Font("Arial", 0, 12));
        BuildOutputLabel.setText("The Build Products are located at:");
        BuildOutputLabel.setMaximumSize(new java.awt.Dimension(32767, 15));
        BuildOutputLabel.setMinimumSize(new java.awt.Dimension(100, 15));
        BuildOutputLabel.setPreferredSize(new java.awt.Dimension(300, 15));
        LabelPanel.add(BuildOutputLabel, java.awt.BorderLayout.CENTER);

        filler4.setBackground(new java.awt.Color(100, 120, 170));
        filler4.setMaximumSize(new java.awt.Dimension(10, 10));
        filler4.setMinimumSize(new java.awt.Dimension(10, 10));
        filler4.setPreferredSize(new java.awt.Dimension(10, 10));
        LabelPanel.add(filler4, java.awt.BorderLayout.EAST);

        add(LabelPanel);

        BuildLocationPanel.setLayout(new java.awt.BorderLayout());

        BuildLocationPanel.setBackground(new java.awt.Color(100, 120, 170));
        BuildLocationPanel.setMaximumSize(new java.awt.Dimension(32767, 20));
        BuildLocationPanel.setMinimumSize(new java.awt.Dimension(0, 20));
        BuildLocationPanel.setPreferredSize(new java.awt.Dimension(500, 20));
        filler.setBackground(new java.awt.Color(100, 120, 170));
        filler.setMaximumSize(new java.awt.Dimension(10, 10));
        filler.setMinimumSize(new java.awt.Dimension(10, 10));
        filler.setPreferredSize(new java.awt.Dimension(10, 10));
        BuildLocationPanel.add(filler, java.awt.BorderLayout.WEST);

        BuildOutputLocation.setBackground(javax.swing.UIManager.getDefaults().getColor("TextField.inactiveBackground"));
        BuildOutputLocation.setEditable(false);
        BuildOutputLocation.setBorder(new javax.swing.border.EtchedBorder());
        BuildOutputLocation.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        BuildLocationPanel.add(BuildOutputLocation, java.awt.BorderLayout.CENTER);

        filler1.setBackground(new java.awt.Color(100, 120, 170));
        filler1.setMaximumSize(new java.awt.Dimension(10, 10));
        filler1.setMinimumSize(new java.awt.Dimension(10, 10));
        filler1.setPreferredSize(new java.awt.Dimension(10, 10));
        BuildLocationPanel.add(filler1, java.awt.BorderLayout.EAST);

        add(BuildLocationPanel);

        JarPanelMain.setLayout(new javax.swing.BoxLayout(JarPanelMain, javax.swing.BoxLayout.X_AXIS));

        JarPanelMain.setBackground(new java.awt.Color(100, 120, 170));
        JarPanelMain.setMaximumSize(new java.awt.Dimension(32767, 40));
        JarPanelMain.setMinimumSize(new java.awt.Dimension(10, 40));
        JarPanelMain.setPreferredSize(new java.awt.Dimension(10, 40));
        LeftPanel.setLayout(new javax.swing.BoxLayout(LeftPanel, javax.swing.BoxLayout.Y_AXIS));

        LeftPanel.setBackground(new java.awt.Color(100, 120, 170));
        JarPanel1.setLayout(new javax.swing.BoxLayout(JarPanel1, javax.swing.BoxLayout.X_AXIS));

        JarPanel1.setBackground(new java.awt.Color(100, 120, 170));
        JarPanel1.setMaximumSize(new java.awt.Dimension(32767, 5));
        JarPanel1.setMinimumSize(new java.awt.Dimension(10, 5));
        JarPanel1.setPreferredSize(new java.awt.Dimension(10, 5));
        filler10.setBackground(new java.awt.Color(100, 120, 170));
        filler10.setMaximumSize(new java.awt.Dimension(10, 5));
        filler10.setMinimumSize(new java.awt.Dimension(10, 5));
        filler10.setPreferredSize(new java.awt.Dimension(10, 5));
        JarPanel1.add(filler10);

        LeftPanel.add(JarPanel1);

        JarPanel.setLayout(new javax.swing.BoxLayout(JarPanel, javax.swing.BoxLayout.X_AXIS));

        JarPanel.setBackground(new java.awt.Color(100, 120, 170));
        JarPanel.setMaximumSize(new java.awt.Dimension(32767, 15));
        JarPanel.setMinimumSize(new java.awt.Dimension(10, 15));
        JarPanel.setPreferredSize(new java.awt.Dimension(10, 15));
        filler3.setBackground(new java.awt.Color(100, 120, 170));
        filler3.setMaximumSize(new java.awt.Dimension(10, 10));
        filler3.setMinimumSize(new java.awt.Dimension(10, 10));
        filler3.setPreferredSize(new java.awt.Dimension(10, 10));
        JarPanel.add(filler3);

        BuildOutputLabel2.setBackground(new java.awt.Color(100, 120, 170));
        BuildOutputLabel2.setFont(new java.awt.Font("Arial", 0, 12));
        BuildOutputLabel2.setText("Executable Jar file output file name:");
        BuildOutputLabel2.setMaximumSize(new java.awt.Dimension(200, 15));
        BuildOutputLabel2.setMinimumSize(new java.awt.Dimension(100, 15));
        BuildOutputLabel2.setPreferredSize(new java.awt.Dimension(200, 15));
        JarPanel.add(BuildOutputLabel2);

        filler5.setBackground(new java.awt.Color(100, 120, 170));
        filler5.setMaximumSize(new java.awt.Dimension(10, 10));
        filler5.setMinimumSize(new java.awt.Dimension(10, 10));
        filler5.setPreferredSize(new java.awt.Dimension(10, 10));
        JarPanel.add(filler5);

        Jar2OutputLabel.setBackground(new java.awt.Color(100, 120, 170));
        Jar2OutputLabel.setFont(new java.awt.Font("Arial", 0, 12));
        Jar2OutputLabel.setText("Core Jar file output name:");
        Jar2OutputLabel.setMaximumSize(new java.awt.Dimension(32767, 15));
        Jar2OutputLabel.setMinimumSize(new java.awt.Dimension(100, 15));
        Jar2OutputLabel.setPreferredSize(new java.awt.Dimension(200, 15));
        JarPanel.add(Jar2OutputLabel);

        filler8.setBackground(new java.awt.Color(100, 120, 170));
        filler8.setMaximumSize(new java.awt.Dimension(10, 10));
        filler8.setMinimumSize(new java.awt.Dimension(10, 10));
        filler8.setPreferredSize(new java.awt.Dimension(10, 10));
        JarPanel.add(filler8);

        LeftPanel.add(JarPanel);

        BuildLocationPanel1.setLayout(new javax.swing.BoxLayout(BuildLocationPanel1, javax.swing.BoxLayout.X_AXIS));

        BuildLocationPanel1.setBackground(new java.awt.Color(100, 120, 170));
        BuildLocationPanel1.setMaximumSize(new java.awt.Dimension(32767, 20));
        BuildLocationPanel1.setMinimumSize(new java.awt.Dimension(0, 20));
        BuildLocationPanel1.setPreferredSize(new java.awt.Dimension(430, 20));
        filler6.setBackground(new java.awt.Color(100, 120, 170));
        filler6.setMaximumSize(new java.awt.Dimension(10, 10));
        filler6.setMinimumSize(new java.awt.Dimension(10, 10));
        filler6.setPreferredSize(new java.awt.Dimension(10, 10));
        BuildLocationPanel1.add(filler6);

        tfJarOutputName.setBackground(javax.swing.UIManager.getDefaults().getColor("TextField.inactiveBackground"));
        tfJarOutputName.setBorder(new javax.swing.border.EtchedBorder());
        tfJarOutputName.setMaximumSize(new java.awt.Dimension(200, 20));
        tfJarOutputName.setMinimumSize(new java.awt.Dimension(200, 19));
        tfJarOutputName.setPreferredSize(new java.awt.Dimension(200, 19));
        tfJarOutputName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfJarOutputNameActionPerformed(evt);
            }
        });

        BuildLocationPanel1.add(tfJarOutputName);

        filler7.setBackground(new java.awt.Color(100, 120, 170));
        filler7.setMaximumSize(new java.awt.Dimension(10, 10));
        filler7.setMinimumSize(new java.awt.Dimension(10, 10));
        filler7.setPreferredSize(new java.awt.Dimension(10, 10));
        BuildLocationPanel1.add(filler7);

        tfJar2OutputName.setBackground(javax.swing.UIManager.getDefaults().getColor("TextField.inactiveBackground"));
        tfJar2OutputName.setBorder(new javax.swing.border.EtchedBorder());
        tfJar2OutputName.setMaximumSize(new java.awt.Dimension(200, 20));
        tfJar2OutputName.setMinimumSize(new java.awt.Dimension(200, 19));
        tfJar2OutputName.setPreferredSize(new java.awt.Dimension(200, 19));
        BuildLocationPanel1.add(tfJar2OutputName);

        filler9.setBackground(new java.awt.Color(100, 120, 170));
        filler9.setMaximumSize(new java.awt.Dimension(10, 10));
        filler9.setMinimumSize(new java.awt.Dimension(10, 10));
        filler9.setPreferredSize(new java.awt.Dimension(10, 10));
        BuildLocationPanel1.add(filler9);

        LeftPanel.add(BuildLocationPanel1);

        JarPanelMain.add(LeftPanel);

        add(JarPanelMain);

        JarPanelMain1.setLayout(new java.awt.BorderLayout());

        JarPanelMain1.setBackground(new java.awt.Color(100, 120, 170));
        JarPanelMain1.setMaximumSize(new java.awt.Dimension(32767, 35));
        JarPanelMain1.setMinimumSize(new java.awt.Dimension(10, 35));
        JarPanelMain1.setPreferredSize(new java.awt.Dimension(10, 35));
        TPanel.setLayout(new java.awt.BorderLayout());

        TPanel.setBackground(new java.awt.Color(100, 120, 170));
        TPanel.setMaximumSize(new java.awt.Dimension(40, 35));
        TPanel.setMinimumSize(new java.awt.Dimension(20, 35));
        TPanel.setPreferredSize(new java.awt.Dimension(20, 35));
        taCPLabel.setBackground(new java.awt.Color(100, 120, 170));
        taCPLabel.setEditable(false);
        taCPLabel.setFont(new java.awt.Font("Arial", 0, 12));
        taCPLabel.setLineWrap(true);
        taCPLabel.setText("Note: If the Core Jar will be in a location different than the application root directory, it must be added to the Classpath on the Automatic Update tab. ");
        taCPLabel.setWrapStyleWord(true);
        taCPLabel.setBorder(null);
        taCPLabel.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        taCPLabel.setMinimumSize(new java.awt.Dimension(0, 30));
        taCPLabel.setPreferredSize(new java.awt.Dimension(0, 30));
        taCPLabel.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        taCPLabel.setSelectionColor(new java.awt.Color(100, 120, 170));
        TPanel.add(taCPLabel, java.awt.BorderLayout.CENTER);

        fillerNorth.setBackground(new java.awt.Color(100, 120, 170));
        fillerNorth.setMaximumSize(new java.awt.Dimension(5, 5));
        fillerNorth.setMinimumSize(new java.awt.Dimension(5, 5));
        fillerNorth.setPreferredSize(new java.awt.Dimension(5, 5));
        TPanel.add(fillerNorth, java.awt.BorderLayout.NORTH);

        fillerEast.setBackground(new java.awt.Color(100, 120, 170));
        fillerEast.setMaximumSize(new java.awt.Dimension(10, 10));
        fillerEast.setMinimumSize(new java.awt.Dimension(10, 10));
        fillerEast.setPreferredSize(new java.awt.Dimension(10, 10));
        TPanel.add(fillerEast, java.awt.BorderLayout.EAST);

        fillerWest.setBackground(new java.awt.Color(100, 120, 170));
        fillerWest.setMaximumSize(new java.awt.Dimension(10, 10));
        fillerWest.setMinimumSize(new java.awt.Dimension(10, 10));
        fillerWest.setPreferredSize(new java.awt.Dimension(10, 10));
        TPanel.add(fillerWest, java.awt.BorderLayout.WEST);

        JarPanelMain1.add(TPanel, java.awt.BorderLayout.CENTER);

        add(JarPanelMain1);

    }//GEN-END:initComponents

    private void tfJarOutputNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfJarOutputNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfJarOutputNameActionPerformed
    
//public static void main(String[] args)
//{
//	JFrame frame = new JFrame("Testing");
//	frame.getContentPane().setLayout(new java.awt.BorderLayout());
//	frame.getContentPane().add(new BuildOutputLocationPanel(),java.awt.BorderLayout.CENTER);
//	frame.setSize(600,175);
//	frame.show();
//}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BuildLocationPanel;
    private javax.swing.JPanel BuildLocationPanel1;
    private javax.swing.JLabel BuildOutputLabel;
    private javax.swing.JLabel BuildOutputLabel2;
    private javax.swing.JTextField BuildOutputLocation;
    private javax.swing.JLabel Jar2OutputLabel;
    private javax.swing.JPanel JarPanel;
    private javax.swing.JPanel JarPanel1;
    private javax.swing.JPanel JarPanelMain;
    private javax.swing.JPanel JarPanelMain1;
    private javax.swing.JPanel LabelPanel;
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JPanel TPanel;
    private javax.swing.JLabel filler;
    private javax.swing.JLabel filler1;
    private javax.swing.JLabel filler10;
    private javax.swing.JLabel filler2;
    private javax.swing.JLabel filler3;
    private javax.swing.JLabel filler4;
    private javax.swing.JLabel filler5;
    private javax.swing.JLabel filler6;
    private javax.swing.JLabel filler7;
    private javax.swing.JLabel filler8;
    private javax.swing.JLabel filler9;
    private javax.swing.JLabel fillerEast;
    private javax.swing.JLabel fillerNorth;
    private javax.swing.JLabel fillerWest;
    private javax.swing.JTextArea taCPLabel;
    private javax.swing.JTextField tfJar2OutputName;
    private javax.swing.JTextField tfJarOutputName;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JButton tempButton;
}
