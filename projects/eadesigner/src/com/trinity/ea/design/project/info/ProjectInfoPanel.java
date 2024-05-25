/*
 * ProjectInfoPanel.java
 *
 * Created on December 16, 2003, 4:53 PM
 */

package com.trinity.ea.design.project.info;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.common.project.DefaultBuildDirectoryDialog;
import com.trinity.ea.design.common.filechooser.EAXFileView;
import com.trinity.ea.design.common.mainclasschooser.MainClassChooser;
import javax.swing.*;
import java.awt.*;
import com.trinity.ea.design.rules.builder.DesignerRuleBuilder;
import com.trinity.ea.design.common.file.ProjectManager;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class ProjectInfoPanel extends EAPanel {
    String filename = File.separator+"tmp";
    JFileChooser fc = new JFileChooser(new File(filename)); 
    private EAXFileView fileView = new EAXFileView();
    /** Creates new form ProjectInfoPanel */
    public ProjectInfoPanel() {
        initComponents();
        try
        {
            setProjectData();    
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
            tfSaveLocation1.setText(new File(new URL(DesignerRuleBuilder.getTempProject()).getFile()).getCanonicalPath());
            String tempStr = DesignerRuleBuilder.getTempProject().substring(0,DesignerRuleBuilder.getTempProject().lastIndexOf("."));
            tfBuildLocation1.setText(new File(new URL(ProjectManager.get("project_build_dir")).getFile()).getCanonicalPath());
            File tmpFileCheck = new File(new URL(DesignerRuleBuilder.getTempProject()).getFile());
            if(tmpFileCheck.exists()==true)
            {
                DateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
                tfLastSaved1.setText(new Date(tmpFileCheck.lastModified()).toString());           
            }
            else if(tmpFileCheck.exists()==false)
            {
                tfLastSaved1.setText("This project has not been saved.");
            } 
            tfLastBuilt1.setText(ProjectManager.get("project_last_built"));
            tfCopyright1.setText(ProjectManager.get("product_copyright"));

            // Start Set the Product Version Info...
            Object[] versionArray = getStringArraysFromString(ProjectManager.get("product_version"));
            tfVersion5.setText((String)versionArray[0]);
            tfVersion6.setText((String)versionArray[1]);
            tfVersion7.setText((String)versionArray[2]);
            tfVersion8.setText((String)versionArray[3]);
            // End Set the Product Version Info...          
            tfVendorName1.setText(ProjectManager.get("product_vendor_name"));
            tfSoftwareTitle1.setText(ProjectManager.get("product_name"));    
            tfProductInfoURL.setText(ProjectManager.get("product_info_url"));
            tfProductURL.setText(ProjectManager.get("product_url"));
            tfPrivacyPolicyEMail.setText(ProjectManager.get("product_privacy_policy_email"));                          
            tfPurchaseSupportEMail.setText(ProjectManager.get("product_purchase_support_email"));                          

		tfJavaMainClass.setText(ProjectManager.get("applicationClass"));                          
		tfJavaMainClass.setCaretPosition(0); 
            tfSaveLocation1.setCaretPosition(0); 
            tfBuildLocation1.setCaretPosition(0);
            tfCopyright1.setCaretPosition(0);
            tfLastBuilt1.setCaretPosition(0);
            tfLastSaved1.setCaretPosition(0);
            tfSoftwareTitle1.setCaretPosition(0);
            tfVendorName1.setCaretPosition(0);
            tfVersion5.setCaretPosition(0);
            tfVersion6.setCaretPosition(0);
            tfVersion7.setCaretPosition(0);
            tfVersion8.setCaretPosition(0);
            tfProductInfoURL.setCaretPosition(0);
            tfProductURL.setCaretPosition(0);
            tfPrivacyPolicyEMail.setCaretPosition(0);    
            tfPurchaseSupportEMail.setCaretPosition(0); 
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /* Updates the project data properties changes */
    public void getDataUpdate()
    {
        String tempProjectBuildDir = null;
        try
        {
            ProjectManager.putTempNoFileWrite("product_vendor_name", tfVendorName1.getText());
            ProjectManager.putTempNoFileWrite("product_name", tfSoftwareTitle1.getText());    
            ProjectManager.putTempNoFileWrite("product_version", tfVersion5.getText() + "," + tfVersion6.getText() + "," + tfVersion7.getText() + "," + tfVersion8.getText());
            ProjectManager.putTempNoFileWrite("product_copyright", tfCopyright1.getText());  
            if(ProjectManager.get("project_last_built")!=null)
		{
            	if(ProjectManager.get("project_last_built").equalsIgnoreCase("This project has not been built.")==false)
			{
            		tempProjectBuildDir = ProjectManager.get("project_build_dir");
			}
            }         
            ProjectManager.putTempNoFileWrite("project_build_dir", new File(tfBuildLocation1.getText()).toURL().toString());
            ProjectManager.putTempNoFileWrite("product_info_url", tfProductInfoURL.getText());
            ProjectManager.putTempNoFileWrite("product_url", tfProductURL.getText());
            ProjectManager.putTempNoFileWrite("product_privacy_policy_email", tfPrivacyPolicyEMail.getText());            
            ProjectManager.putTempNoFileWrite("product_purchase_support_email", tfPurchaseSupportEMail.getText());            
		if(tfJavaMainClass.getText().endsWith(".class")==true)
		{
			ProjectManager.putTempNoFileWrite("applicationClass",tfJavaMainClass.getText().substring(0,tfJavaMainClass.getText().lastIndexOf(".class")));
		}
		else
		{
            	ProjectManager.putTempNoFileWrite("applicationClass", tfJavaMainClass.getText());
		}

            ProjectManager.saveTempNow();         
            // project_last_built is set by the Build Panel, once a build is complete.
        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();
            ProjectManager.putTempNoFileWrite("project_build_dir", tempProjectBuildDir);
            ProjectManager.saveTempNow();            

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }    
    
    private static synchronized Object[] getStringArraysFromString(String textArrayString)
    {
        ArrayList aryList = new ArrayList();
        String tempString = "";
        try
        {
            while(textArrayString.indexOf(",")!=-1)
            {
                tempString = textArrayString.substring(0,textArrayString.indexOf(","));
                textArrayString = textArrayString.substring(textArrayString.indexOf(",") + 1);
                aryList.add(tempString);
            }
            aryList.add(textArrayString);
            aryList.trimToSize();
        }
        catch(NullPointerException e)
        {
         
        }

        return aryList.toArray();
    }  
  
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        ProjectInfoPanelNorthPanel = new javax.swing.JPanel();
        ProjectInfoPanelSouthPanel = new javax.swing.JPanel();
        ProjectInfoPanelCenterPanel = new javax.swing.JPanel();
        ProjectInformationLayoutPanel = new javax.swing.JPanel();
        ProjectInformation = new javax.swing.JPanel();
        ProjectInformationTopPanel1 = new javax.swing.JPanel();
        lFiller15 = new javax.swing.JLabel();
        lVendorName1 = new javax.swing.JLabel();
        lFiller16 = new javax.swing.JLabel();
        tfVendorName1 = new javax.swing.JTextField();
        lFiller17 = new javax.swing.JLabel();
        ProjectInformationTopPanel3 = new javax.swing.JPanel();
        lFiller12 = new javax.swing.JLabel();
        lSoftwareTitle1 = new javax.swing.JLabel();
        lFiller13 = new javax.swing.JLabel();
        tfSoftwareTitle1 = new javax.swing.JTextField();
        lFiller14 = new javax.swing.JLabel();
        ProjectIdentificationItem3Panel1 = new javax.swing.JPanel();
        lFiller5 = new javax.swing.JLabel();
        lVersion2 = new javax.swing.JLabel();
        lFiller9 = new javax.swing.JLabel();
        tfVersion5 = new javax.swing.JTextField();
        lFiller6 = new javax.swing.JLabel();
        tfVersion6 = new javax.swing.JTextField();
        lFiller7 = new javax.swing.JLabel();
        tfVersion7 = new javax.swing.JTextField();
        lFiller8 = new javax.swing.JLabel();
        tfVersion8 = new javax.swing.JTextField();
        lFiller11 = new javax.swing.JLabel();
        lCopyright2 = new javax.swing.JLabel();
        lFiller10 = new javax.swing.JLabel();
        tfCopyright1 = new javax.swing.JTextField();
        lSpaceFiller2 = new javax.swing.JLabel();
        ProjectInformationProductInfoURLPanel = new javax.swing.JPanel();
        lFiller3 = new javax.swing.JLabel();
        lProductInfoURL = new javax.swing.JLabel();
        lFiller2 = new javax.swing.JLabel();
        tfProductInfoURL = new javax.swing.JTextField();
        lFiller4 = new javax.swing.JLabel();
        ProjectInformationProductURLPanel = new javax.swing.JPanel();
        lFiller35 = new javax.swing.JLabel();
        lProductURL = new javax.swing.JLabel();
        lFiller36 = new javax.swing.JLabel();
        tfProductURL = new javax.swing.JTextField();
        lFiller37 = new javax.swing.JLabel();
        ProductPrivacyPolicyEMailPanel = new javax.swing.JPanel();
        lFiller18 = new javax.swing.JLabel();
        lPrivacyPolicyEMail = new javax.swing.JLabel();
        lFiller19 = new javax.swing.JLabel();
        tfPrivacyPolicyEMail = new javax.swing.JTextField();
        lFiller20 = new javax.swing.JLabel();
        ProjectLocationsLayoutPanel = new javax.swing.JPanel();
        ProjectLocations = new javax.swing.JPanel();
        ProjectLocationsTopPanel2 = new javax.swing.JPanel();
        lFiller21 = new javax.swing.JLabel();
        lSaveLocation1 = new javax.swing.JLabel();
        lFiller22 = new javax.swing.JLabel();
        tfSaveLocation1 = new javax.swing.JTextField();
        lFiller23 = new javax.swing.JLabel();
        ProjectLocationsCenterPanel1 = new javax.swing.JPanel();
        lFiller24 = new javax.swing.JLabel();
        lBuildLocation1 = new javax.swing.JLabel();
        lFiller25 = new javax.swing.JLabel();
        tfBuildLocation1 = new javax.swing.JTextField();
        lFiller27 = new javax.swing.JLabel();
        ChooseButton1 = new javax.swing.JButton();
        lFiller28 = new javax.swing.JLabel();
        DefaultButton1 = new javax.swing.JButton();
        lFiller26 = new javax.swing.JLabel();
        ProjectLocationsBottomPanel1 = new javax.swing.JPanel();
        lFiller29 = new javax.swing.JLabel();
        lLastSaved1 = new javax.swing.JLabel();
        lFiller30 = new javax.swing.JLabel();
        tfLastSaved1 = new javax.swing.JTextField();
        lFiller31 = new javax.swing.JLabel();
        ProjectLocationsTopPanel3 = new javax.swing.JPanel();
        lFiller32 = new javax.swing.JLabel();
        lLastBuilt1 = new javax.swing.JLabel();
        lFiller33 = new javax.swing.JLabel();
        tfLastBuilt1 = new javax.swing.JTextField();
        lFiller34 = new javax.swing.JLabel();
        ProjectInfoPanelWestPanel = new javax.swing.JPanel();
        ProjectInfoPanelEastPanel = new javax.swing.JPanel();
        ProductJavaMainClassPanel = new javax.swing.JPanel();
        lFiller100 = new javax.swing.JLabel();
        lJavaMainClass = new javax.swing.JLabel();
        lFiller101 = new javax.swing.JLabel();
        tfJavaMainClass = new javax.swing.JTextField();
        lFiller102 = new javax.swing.JLabel();
        ProductPurchaseSupportEMailPanel = new javax.swing.JPanel();
        lFiller38 = new javax.swing.JLabel();
        lPurchaseSupportEMail = new javax.swing.JLabel();
        lFiller39 = new javax.swing.JLabel();
        tfPurchaseSupportEMail = new javax.swing.JTextField();
        lFiller40 = new javax.swing.JLabel();
	  FindClassesButton = new javax.swing.JButton();
	  FindClassesButtonFiller = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        setBackground(new java.awt.Color(140, 160, 210));
        ProjectInfoPanelNorthPanel.setBackground(new java.awt.Color(140, 160, 210));
        add(ProjectInfoPanelNorthPanel, java.awt.BorderLayout.NORTH);

        ProjectInfoPanelSouthPanel.setBackground(new java.awt.Color(140, 160, 210));
        add(ProjectInfoPanelSouthPanel, java.awt.BorderLayout.SOUTH);

        ProjectInfoPanelCenterPanel.setLayout(new javax.swing.BoxLayout(ProjectInfoPanelCenterPanel, javax.swing.BoxLayout.Y_AXIS));

        ProjectInfoPanelCenterPanel.setBackground(new java.awt.Color(140, 160, 210));
        ProjectInformationLayoutPanel.setLayout(new java.awt.BorderLayout());

        ProjectInformationLayoutPanel.setBackground(new java.awt.Color(140, 160, 210));
        ProjectInformationLayoutPanel.setMaximumSize(new java.awt.Dimension(10000, 275));
        ProjectInformationLayoutPanel.setMinimumSize(new java.awt.Dimension(500, 275));
        ProjectInformationLayoutPanel.setPreferredSize(new java.awt.Dimension(500, 275));
        ProjectInformation.setLayout(new javax.swing.BoxLayout(ProjectInformation, javax.swing.BoxLayout.Y_AXIS));

        ProjectInformation.setBackground(new java.awt.Color(140, 160, 210));
        ProjectInformation.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Product Information", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12)));
        ProjectInformation.setMaximumSize(new java.awt.Dimension(10000, 275));
        ProjectInformation.setMinimumSize(new java.awt.Dimension(500, 275));
        ProjectInformation.setPreferredSize(new java.awt.Dimension(600, 275));
        ProjectInformationTopPanel1.setLayout(new javax.swing.BoxLayout(ProjectInformationTopPanel1, javax.swing.BoxLayout.X_AXIS));

        ProjectInformationTopPanel1.setBackground(new java.awt.Color(140, 160, 210));
        ProjectInformationTopPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectInformationTopPanel1.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectInformationTopPanel1.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller15.setBackground(new java.awt.Color(140, 160, 210));
        lFiller15.setText("   ");
        lFiller15.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller15.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller15.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectInformationTopPanel1.add(lFiller15);

        lVendorName1.setBackground(new java.awt.Color(140, 160, 210));
        lVendorName1.setFont(new java.awt.Font("Arial", 0, 12));
        lVendorName1.setText("Vendor Name:");
        lVendorName1.setMaximumSize(new java.awt.Dimension(120, 15));
        lVendorName1.setMinimumSize(new java.awt.Dimension(120, 15));
        lVendorName1.setPreferredSize(new java.awt.Dimension(120, 15));
        ProjectInformationTopPanel1.add(lVendorName1);

        lFiller16.setBackground(new java.awt.Color(140, 160, 210));
        lFiller16.setText("   ");
        lFiller16.setMaximumSize(new java.awt.Dimension(300, 15));
        lFiller16.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller16.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectInformationTopPanel1.add(lFiller16);

        tfVendorName1.setFont(new java.awt.Font("Arial", 0, 12));
        tfVendorName1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfVendorName1.setText("Vendor_Name");
        tfVendorName1.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfVendorName1.setMinimumSize(new java.awt.Dimension(300, 20));
        tfVendorName1.setPreferredSize(new java.awt.Dimension(450, 20));
        ProjectInformationTopPanel1.add(tfVendorName1);

        lFiller17.setBackground(new java.awt.Color(140, 160, 210));
        lFiller17.setText("   ");
        lFiller17.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller17.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller17.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectInformationTopPanel1.add(lFiller17);

        ProjectInformation.add(ProjectInformationTopPanel1);

        ProjectInformationTopPanel3.setLayout(new javax.swing.BoxLayout(ProjectInformationTopPanel3, javax.swing.BoxLayout.X_AXIS));

        ProjectInformationTopPanel3.setBackground(new java.awt.Color(140, 160, 210));
        ProjectInformationTopPanel3.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectInformationTopPanel3.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectInformationTopPanel3.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller12.setBackground(new java.awt.Color(140, 160, 210));
        lFiller12.setText("   ");
        lFiller12.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller12.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller12.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectInformationTopPanel3.add(lFiller12);

        lSoftwareTitle1.setBackground(new java.awt.Color(140, 160, 210));
        lSoftwareTitle1.setFont(new java.awt.Font("Arial", 0, 12));
        lSoftwareTitle1.setText("Product Name:");
        lSoftwareTitle1.setMaximumSize(new java.awt.Dimension(120, 15));
        lSoftwareTitle1.setMinimumSize(new java.awt.Dimension(120, 15));
        lSoftwareTitle1.setPreferredSize(new java.awt.Dimension(120, 15));
        ProjectInformationTopPanel3.add(lSoftwareTitle1);

        lFiller13.setBackground(new java.awt.Color(140, 160, 210));
        lFiller13.setText("   ");
        lFiller13.setMaximumSize(new java.awt.Dimension(300, 15));
        lFiller13.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller13.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectInformationTopPanel3.add(lFiller13);

        tfSoftwareTitle1.setFont(new java.awt.Font("Arial", 0, 12));
        tfSoftwareTitle1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfSoftwareTitle1.setText("My_Product");
        tfSoftwareTitle1.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfSoftwareTitle1.setMinimumSize(new java.awt.Dimension(300, 20));
        tfSoftwareTitle1.setPreferredSize(new java.awt.Dimension(450, 20));
        ProjectInformationTopPanel3.add(tfSoftwareTitle1);

        lFiller14.setBackground(new java.awt.Color(140, 160, 210));
        lFiller14.setText("   ");
        lFiller14.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller14.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller14.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectInformationTopPanel3.add(lFiller14);

        ProjectInformation.add(ProjectInformationTopPanel3);

        ProjectIdentificationItem3Panel1.setLayout(new javax.swing.BoxLayout(ProjectIdentificationItem3Panel1, javax.swing.BoxLayout.X_AXIS));

        ProjectIdentificationItem3Panel1.setBackground(new java.awt.Color(140, 160, 210));
        ProjectIdentificationItem3Panel1.setMaximumSize(new java.awt.Dimension(10450, 30));
        ProjectIdentificationItem3Panel1.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectIdentificationItem3Panel1.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller5.setBackground(new java.awt.Color(140, 160, 210));
        lFiller5.setText("   ");
        lFiller5.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller5.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller5.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectIdentificationItem3Panel1.add(lFiller5);

        lVersion2.setBackground(new java.awt.Color(140, 160, 210));
        lVersion2.setFont(new java.awt.Font("Arial", 0, 12));
        lVersion2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lVersion2.setText("Version:");
        lVersion2.setMaximumSize(new java.awt.Dimension(120, 15));
        lVersion2.setMinimumSize(new java.awt.Dimension(120, 15));
        lVersion2.setPreferredSize(new java.awt.Dimension(120, 15));
        lVersion2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ProjectIdentificationItem3Panel1.add(lVersion2);

        lFiller9.setBackground(new java.awt.Color(140, 160, 210));
        lFiller9.setText("   ");
        lFiller9.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller9.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller9.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectIdentificationItem3Panel1.add(lFiller9);

        tfVersion5.setFont(new java.awt.Font("Arial", 0, 12));
        tfVersion5.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfVersion5.setText("1");
        tfVersion5.setMaximumSize(new java.awt.Dimension(50, 20));
        tfVersion5.setMinimumSize(new java.awt.Dimension(50, 20));
        tfVersion5.setPreferredSize(new java.awt.Dimension(50, 20));
        ProjectIdentificationItem3Panel1.add(tfVersion5);

        lFiller6.setBackground(new java.awt.Color(140, 160, 210));
        lFiller6.setText("   ");
        lFiller6.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller6.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller6.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectIdentificationItem3Panel1.add(lFiller6);

        tfVersion6.setFont(new java.awt.Font("Arial", 0, 12));
        tfVersion6.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfVersion6.setText("0");
        tfVersion6.setMaximumSize(new java.awt.Dimension(50, 20));
        tfVersion6.setMinimumSize(new java.awt.Dimension(50, 20));
        tfVersion6.setPreferredSize(new java.awt.Dimension(50, 20));
        ProjectIdentificationItem3Panel1.add(tfVersion6);

        lFiller7.setBackground(new java.awt.Color(140, 160, 210));
        lFiller7.setText("   ");
        lFiller7.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller7.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller7.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectIdentificationItem3Panel1.add(lFiller7);

        tfVersion7.setFont(new java.awt.Font("Arial", 0, 12));
        tfVersion7.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfVersion7.setText("0");
        tfVersion7.setMaximumSize(new java.awt.Dimension(50, 20));
        tfVersion7.setMinimumSize(new java.awt.Dimension(50, 20));
        tfVersion7.setPreferredSize(new java.awt.Dimension(50, 20));
        ProjectIdentificationItem3Panel1.add(tfVersion7);

        lFiller8.setBackground(new java.awt.Color(140, 160, 210));
        lFiller8.setText("   ");
        lFiller8.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller8.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller8.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectIdentificationItem3Panel1.add(lFiller8);

        tfVersion8.setFont(new java.awt.Font("Arial", 0, 12));
        tfVersion8.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfVersion8.setText("0");
        tfVersion8.setMaximumSize(new java.awt.Dimension(50, 20));
        tfVersion8.setMinimumSize(new java.awt.Dimension(50, 20));
        tfVersion8.setPreferredSize(new java.awt.Dimension(50, 20));
        ProjectIdentificationItem3Panel1.add(tfVersion8);

        lFiller11.setBackground(new java.awt.Color(140, 160, 210));
        lFiller11.setText("   ");
        lFiller11.setMaximumSize(new java.awt.Dimension(20, 15));
        lFiller11.setMinimumSize(new java.awt.Dimension(20, 16));
        lFiller11.setPreferredSize(new java.awt.Dimension(20, 16));
        ProjectIdentificationItem3Panel1.add(lFiller11);

        lCopyright2.setBackground(new java.awt.Color(140, 160, 210));
        lCopyright2.setFont(new java.awt.Font("Arial", 0, 12));
        lCopyright2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lCopyright2.setText("Copyright:");
        lCopyright2.setMaximumSize(new java.awt.Dimension(80, 15));
        lCopyright2.setPreferredSize(new java.awt.Dimension(80, 15));
        ProjectIdentificationItem3Panel1.add(lCopyright2);

        lFiller10.setBackground(new java.awt.Color(140, 160, 210));
        lFiller10.setText("   ");
        lFiller10.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller10.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller10.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectIdentificationItem3Panel1.add(lFiller10);

        tfCopyright1.setFont(new java.awt.Font("Arial", 0, 12));
        tfCopyright1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfCopyright1.setText("2004");
        tfCopyright1.setMaximumSize(new java.awt.Dimension(70, 20));
        tfCopyright1.setMinimumSize(new java.awt.Dimension(70, 20));
        tfCopyright1.setPreferredSize(new java.awt.Dimension(70, 20));
        ProjectIdentificationItem3Panel1.add(tfCopyright1);

        lSpaceFiller2.setBackground(new java.awt.Color(140, 160, 210));
        lSpaceFiller2.setFont(new java.awt.Font("Arial", 0, 12));
        lSpaceFiller2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lSpaceFiller2.setMaximumSize(new java.awt.Dimension(10000, 15));
        lSpaceFiller2.setPreferredSize(new java.awt.Dimension(100, 15));
        lSpaceFiller2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ProjectIdentificationItem3Panel1.add(lSpaceFiller2);

        ProjectInformation.add(ProjectIdentificationItem3Panel1);

       ProductJavaMainClassPanel.setLayout(new javax.swing.BoxLayout(ProductJavaMainClassPanel, javax.swing.BoxLayout.X_AXIS));

        ProductJavaMainClassPanel.setBackground(new java.awt.Color(140, 160, 210));
        ProductJavaMainClassPanel.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProductJavaMainClassPanel.setMinimumSize(new java.awt.Dimension(600, 30));
        ProductJavaMainClassPanel.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller100.setBackground(new java.awt.Color(140, 160, 210));
        lFiller100.setText("   ");
        lFiller100.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller100.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller100.setPreferredSize(new java.awt.Dimension(10, 16));
        ProductJavaMainClassPanel.add(lFiller100);

        lJavaMainClass.setBackground(new java.awt.Color(140, 160, 210));
        lJavaMainClass.setFont(new java.awt.Font("Arial", 0, 12));
        lJavaMainClass.setText("Java Main Class:");
        lJavaMainClass.setMaximumSize(new java.awt.Dimension(120, 15));
        lJavaMainClass.setMinimumSize(new java.awt.Dimension(120, 15));
        lJavaMainClass.setPreferredSize(new java.awt.Dimension(120, 15));
        ProductJavaMainClassPanel.add(lJavaMainClass);

        lFiller101.setBackground(new java.awt.Color(140, 160, 210));
        lFiller101.setText("   ");
        lFiller101.setMaximumSize(new java.awt.Dimension(300, 15));
        lFiller101.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller101.setPreferredSize(new java.awt.Dimension(10, 16));
        ProductJavaMainClassPanel.add(lFiller101);

        tfJavaMainClass.setFont(new java.awt.Font("Arial", 0, 12));
        tfJavaMainClass.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfJavaMainClass.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfJavaMainClass.setMinimumSize(new java.awt.Dimension(300, 20));
        tfJavaMainClass.setPreferredSize(new java.awt.Dimension(450, 20));
        ProductJavaMainClassPanel.add(tfJavaMainClass);

        FindClassesButtonFiller.setBackground(new java.awt.Color(140, 160, 210));
        FindClassesButtonFiller.setText("");
        FindClassesButtonFiller.setMaximumSize(new java.awt.Dimension(10, 10));
        FindClassesButtonFiller.setMinimumSize(new java.awt.Dimension(10, 10));
        FindClassesButtonFiller.setPreferredSize(new java.awt.Dimension(10, 10));
        ProductJavaMainClassPanel.add(FindClassesButtonFiller);

        FindClassesButton.setFont(new java.awt.Font("Arial", 0, 12));
        FindClassesButton.setText("Find Main Class...");
        FindClassesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindClassesButtonActionPerformed(evt);
            }
        });

        ProductJavaMainClassPanel.add(FindClassesButton);

        lFiller102.setBackground(new java.awt.Color(140, 160, 210));
        lFiller102.setText("   ");
        lFiller102.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller102.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller102.setPreferredSize(new java.awt.Dimension(15, 16));
        ProductJavaMainClassPanel.add(lFiller102);

        ProjectInformation.add(ProductJavaMainClassPanel);

        ProjectInformationProductInfoURLPanel.setLayout(new javax.swing.BoxLayout(ProjectInformationProductInfoURLPanel, javax.swing.BoxLayout.X_AXIS));

        ProjectInformationProductInfoURLPanel.setBackground(new java.awt.Color(140, 160, 210));
        ProjectInformationProductInfoURLPanel.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectInformationProductInfoURLPanel.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectInformationProductInfoURLPanel.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller3.setBackground(new java.awt.Color(140, 160, 210));
        lFiller3.setText("   ");
        lFiller3.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller3.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller3.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectInformationProductInfoURLPanel.add(lFiller3);

        lProductInfoURL.setBackground(new java.awt.Color(140, 160, 210));
        lProductInfoURL.setFont(new java.awt.Font("Arial", 0, 12));
        lProductInfoURL.setText("Product Info URL:");
        lProductInfoURL.setMaximumSize(new java.awt.Dimension(120, 15));
        lProductInfoURL.setMinimumSize(new java.awt.Dimension(120, 15));
        lProductInfoURL.setPreferredSize(new java.awt.Dimension(120, 15));
        ProjectInformationProductInfoURLPanel.add(lProductInfoURL);

        lFiller2.setBackground(new java.awt.Color(140, 160, 210));
        lFiller2.setText("   ");
        lFiller2.setMaximumSize(new java.awt.Dimension(300, 15));
        lFiller2.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller2.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectInformationProductInfoURLPanel.add(lFiller2);

        tfProductInfoURL.setFont(new java.awt.Font("Arial", 0, 12));
        tfProductInfoURL.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfProductInfoURL.setText("http://www.my_product_info_url.com/my_product_page");
        tfProductInfoURL.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfProductInfoURL.setMinimumSize(new java.awt.Dimension(300, 20));
        tfProductInfoURL.setPreferredSize(new java.awt.Dimension(450, 20));
        ProjectInformationProductInfoURLPanel.add(tfProductInfoURL);

        lFiller4.setBackground(new java.awt.Color(140, 160, 210));
        lFiller4.setText("   ");
        lFiller4.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller4.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller4.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectInformationProductInfoURLPanel.add(lFiller4);

        ProjectInformation.add(ProjectInformationProductInfoURLPanel);

        ProjectInformationProductURLPanel.setLayout(new javax.swing.BoxLayout(ProjectInformationProductURLPanel, javax.swing.BoxLayout.X_AXIS));

        ProjectInformationProductURLPanel.setBackground(new java.awt.Color(140, 160, 210));
        ProjectInformationProductURLPanel.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectInformationProductURLPanel.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectInformationProductURLPanel.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller35.setBackground(new java.awt.Color(140, 160, 210));
        lFiller35.setText("   ");
        lFiller35.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller35.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller35.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectInformationProductURLPanel.add(lFiller35);

        lProductURL.setBackground(new java.awt.Color(140, 160, 210));
        lProductURL.setFont(new java.awt.Font("Arial", 0, 12));
        lProductURL.setText("Product URL:");
        lProductURL.setMaximumSize(new java.awt.Dimension(120, 15));
        lProductURL.setMinimumSize(new java.awt.Dimension(120, 15));
        lProductURL.setPreferredSize(new java.awt.Dimension(120, 15));
        ProjectInformationProductURLPanel.add(lProductURL);

        lFiller36.setBackground(new java.awt.Color(140, 160, 210));
        lFiller36.setText("   ");
        lFiller36.setMaximumSize(new java.awt.Dimension(300, 15));
        lFiller36.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller36.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectInformationProductURLPanel.add(lFiller36);

        tfProductURL.setFont(new java.awt.Font("Arial", 0, 12));
        tfProductURL.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfProductURL.setText("http://www.my_product_url.com/my_product_page");
        tfProductURL.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfProductURL.setMinimumSize(new java.awt.Dimension(300, 20));
        tfProductURL.setPreferredSize(new java.awt.Dimension(450, 20));
        ProjectInformationProductURLPanel.add(tfProductURL);

        lFiller37.setBackground(new java.awt.Color(140, 160, 210));
        lFiller37.setText("   ");
        lFiller37.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller37.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller37.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectInformationProductURLPanel.add(lFiller37);

        ProjectInformation.add(ProjectInformationProductURLPanel);

        ProductPrivacyPolicyEMailPanel.setLayout(new javax.swing.BoxLayout(ProductPrivacyPolicyEMailPanel, javax.swing.BoxLayout.X_AXIS));

        ProductPrivacyPolicyEMailPanel.setBackground(new java.awt.Color(140, 160, 210));
        ProductPrivacyPolicyEMailPanel.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProductPrivacyPolicyEMailPanel.setMinimumSize(new java.awt.Dimension(600, 30));
        ProductPrivacyPolicyEMailPanel.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller18.setBackground(new java.awt.Color(140, 160, 210));
        lFiller18.setText("   ");
        lFiller18.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller18.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller18.setPreferredSize(new java.awt.Dimension(10, 16));
        ProductPrivacyPolicyEMailPanel.add(lFiller18);

        lPrivacyPolicyEMail.setBackground(new java.awt.Color(140, 160, 210));
        lPrivacyPolicyEMail.setFont(new java.awt.Font("Arial", 0, 12));
        lPrivacyPolicyEMail.setText("Privacy Policy E-mail:");
        lPrivacyPolicyEMail.setMaximumSize(new java.awt.Dimension(120, 15));
        lPrivacyPolicyEMail.setMinimumSize(new java.awt.Dimension(120, 15));
        lPrivacyPolicyEMail.setPreferredSize(new java.awt.Dimension(120, 15));
        ProductPrivacyPolicyEMailPanel.add(lPrivacyPolicyEMail);

        lFiller19.setBackground(new java.awt.Color(140, 160, 210));
        lFiller19.setText("   ");
        lFiller19.setMaximumSize(new java.awt.Dimension(300, 15));
        lFiller19.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller19.setPreferredSize(new java.awt.Dimension(10, 16));
        ProductPrivacyPolicyEMailPanel.add(lFiller19);

        tfPrivacyPolicyEMail.setFont(new java.awt.Font("Arial", 0, 12));
        tfPrivacyPolicyEMail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfPrivacyPolicyEMail.setText("privacy_policy@my_product_info_url.com");
        tfPrivacyPolicyEMail.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfPrivacyPolicyEMail.setMinimumSize(new java.awt.Dimension(300, 20));
        tfPrivacyPolicyEMail.setPreferredSize(new java.awt.Dimension(450, 20));
        ProductPrivacyPolicyEMailPanel.add(tfPrivacyPolicyEMail);

        lFiller20.setBackground(new java.awt.Color(140, 160, 210));
        lFiller20.setText("   ");
        lFiller20.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller20.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller20.setPreferredSize(new java.awt.Dimension(15, 16));
        ProductPrivacyPolicyEMailPanel.add(lFiller20);

        ProjectInformation.add(ProductPrivacyPolicyEMailPanel);

        ProductPurchaseSupportEMailPanel.setLayout(new javax.swing.BoxLayout(ProductPurchaseSupportEMailPanel, javax.swing.BoxLayout.X_AXIS));

        ProductPurchaseSupportEMailPanel.setBackground(new java.awt.Color(140, 160, 210));
        ProductPurchaseSupportEMailPanel.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProductPurchaseSupportEMailPanel.setMinimumSize(new java.awt.Dimension(600, 30));
        ProductPurchaseSupportEMailPanel.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller38.setBackground(new java.awt.Color(140, 160, 210));
        lFiller38.setText("   ");
        lFiller38.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller38.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller38.setPreferredSize(new java.awt.Dimension(10, 16));
        ProductPurchaseSupportEMailPanel.add(lFiller38);

        lPurchaseSupportEMail.setBackground(new java.awt.Color(140, 160, 210));
        lPurchaseSupportEMail.setFont(new java.awt.Font("Arial", 0, 12));
        lPurchaseSupportEMail.setText("Support E-mail:");
        lPurchaseSupportEMail.setMaximumSize(new java.awt.Dimension(120, 15));
        lPurchaseSupportEMail.setMinimumSize(new java.awt.Dimension(120, 15));
        lPurchaseSupportEMail.setPreferredSize(new java.awt.Dimension(120, 15));
        ProductPurchaseSupportEMailPanel.add(lPurchaseSupportEMail);

        lFiller39.setBackground(new java.awt.Color(140, 160, 210));
        lFiller39.setText("   ");
        lFiller39.setMaximumSize(new java.awt.Dimension(300, 15));
        lFiller39.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller39.setPreferredSize(new java.awt.Dimension(10, 16));
        ProductPurchaseSupportEMailPanel.add(lFiller39);

        tfPurchaseSupportEMail.setFont(new java.awt.Font("Arial", 0, 12));
        tfPurchaseSupportEMail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfPurchaseSupportEMail.setText("purchase@my_product_info_url.com");
        tfPurchaseSupportEMail.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfPurchaseSupportEMail.setMinimumSize(new java.awt.Dimension(300, 20));
        tfPurchaseSupportEMail.setPreferredSize(new java.awt.Dimension(450, 20));
        ProductPurchaseSupportEMailPanel.add(tfPurchaseSupportEMail);

        lFiller40.setBackground(new java.awt.Color(140, 160, 210));
        lFiller40.setText("   ");
        lFiller40.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller40.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller40.setPreferredSize(new java.awt.Dimension(15, 16));
        ProductPurchaseSupportEMailPanel.add(lFiller40);

        ProjectInformation.add(ProductPurchaseSupportEMailPanel);

        ProjectInformationLayoutPanel.add(ProjectInformation, java.awt.BorderLayout.CENTER);

        ProjectInfoPanelCenterPanel.add(ProjectInformationLayoutPanel);

        ProjectLocationsLayoutPanel.setLayout(new java.awt.BorderLayout());

        ProjectLocationsLayoutPanel.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsLayoutPanel.setMaximumSize(new java.awt.Dimension(32767, 160));
        ProjectLocationsLayoutPanel.setMinimumSize(new java.awt.Dimension(20, 160));
        ProjectLocationsLayoutPanel.setPreferredSize(new java.awt.Dimension(20, 160));
        ProjectLocations.setLayout(new javax.swing.BoxLayout(ProjectLocations, javax.swing.BoxLayout.Y_AXIS));

        ProjectLocations.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocations.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Project Locations", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12)));
        ProjectLocations.setMaximumSize(new java.awt.Dimension(32767, 180));
        ProjectLocations.setMinimumSize(new java.awt.Dimension(500, 180));
        ProjectLocations.setPreferredSize(new java.awt.Dimension(600, 180));
        ProjectLocationsTopPanel2.setLayout(new javax.swing.BoxLayout(ProjectLocationsTopPanel2, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsTopPanel2.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsTopPanel2.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectLocationsTopPanel2.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectLocationsTopPanel2.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller21.setBackground(new java.awt.Color(140, 160, 210));
        lFiller21.setText("   ");
        lFiller21.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller21.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller21.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsTopPanel2.add(lFiller21);

        lSaveLocation1.setBackground(new java.awt.Color(140, 160, 210));
        lSaveLocation1.setFont(new java.awt.Font("Arial", 0, 12));
        lSaveLocation1.setText("Save Location:");
        lSaveLocation1.setMaximumSize(new java.awt.Dimension(120, 15));
        lSaveLocation1.setMinimumSize(new java.awt.Dimension(120, 15));
        lSaveLocation1.setPreferredSize(new java.awt.Dimension(120, 15));
        ProjectLocationsTopPanel2.add(lSaveLocation1);

        lFiller22.setBackground(new java.awt.Color(140, 160, 210));
        lFiller22.setText("   ");
        lFiller22.setMaximumSize(new java.awt.Dimension(300, 15));
        lFiller22.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller22.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsTopPanel2.add(lFiller22);

        tfSaveLocation1.setBackground(javax.swing.UIManager.getDefaults().getColor("TextField.inactiveBackground"));
        tfSaveLocation1.setFont(new java.awt.Font("Arial", 0, 12));
        tfSaveLocation1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfSaveLocation1.setText("");
        tfSaveLocation1.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfSaveLocation1.setMinimumSize(new java.awt.Dimension(300, 20));
        tfSaveLocation1.setPreferredSize(new java.awt.Dimension(450, 20));
        ProjectLocationsTopPanel2.add(tfSaveLocation1);

        lFiller23.setBackground(new java.awt.Color(140, 160, 210));
        lFiller23.setText("   ");
        lFiller23.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller23.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller23.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsTopPanel2.add(lFiller23);

        ProjectLocations.add(ProjectLocationsTopPanel2);

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
        lBuildLocation1.setText("Build Location:");
        lBuildLocation1.setMaximumSize(new java.awt.Dimension(120, 15));
        lBuildLocation1.setMinimumSize(new java.awt.Dimension(120, 15));
        lBuildLocation1.setPreferredSize(new java.awt.Dimension(120, 15));
        ProjectLocationsCenterPanel1.add(lBuildLocation1);

        lFiller25.setBackground(new java.awt.Color(140, 160, 210));
        lFiller25.setText("   ");
        lFiller25.setMaximumSize(new java.awt.Dimension(300, 15));
        lFiller25.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller25.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel1.add(lFiller25);

        tfBuildLocation1.setBackground(javax.swing.UIManager.getDefaults().getColor("TextField.inactiveBackground"));
        tfBuildLocation1.setFont(new java.awt.Font("Arial", 0, 12));
        tfBuildLocation1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfBuildLocation1.setText("");
        tfBuildLocation1.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfBuildLocation1.setMinimumSize(new java.awt.Dimension(300, 20));
        tfBuildLocation1.setPreferredSize(new java.awt.Dimension(450, 20));
        ProjectLocationsCenterPanel1.add(tfBuildLocation1);

        lFiller27.setBackground(new java.awt.Color(140, 160, 210));
        lFiller27.setText("   ");
        lFiller27.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller27.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller27.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel1.add(lFiller27);

        ChooseButton1.setFont(new java.awt.Font("Arial", 0, 12));
        ChooseButton1.setText("Choose...");
        ChooseButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseButton1ActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel1.add(ChooseButton1);

        lFiller28.setBackground(new java.awt.Color(140, 160, 210));
        lFiller28.setText("   ");
        lFiller28.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller28.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller28.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsCenterPanel1.add(lFiller28);

        DefaultButton1.setFont(new java.awt.Font("Arial", 0, 12));
        DefaultButton1.setText("Default");
        DefaultButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DefaultButton1ActionPerformed(evt);
            }
        });

        ProjectLocationsCenterPanel1.add(DefaultButton1);

        lFiller26.setBackground(new java.awt.Color(140, 160, 210));
        lFiller26.setText("   ");
        lFiller26.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller26.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller26.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsCenterPanel1.add(lFiller26);

        ProjectLocations.add(ProjectLocationsCenterPanel1);

        ProjectLocationsBottomPanel1.setLayout(new javax.swing.BoxLayout(ProjectLocationsBottomPanel1, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsBottomPanel1.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsBottomPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectLocationsBottomPanel1.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectLocationsBottomPanel1.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller29.setBackground(new java.awt.Color(140, 160, 210));
        lFiller29.setText("   ");
        lFiller29.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller29.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller29.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsBottomPanel1.add(lFiller29);

        lLastSaved1.setBackground(new java.awt.Color(140, 160, 210));
        lLastSaved1.setFont(new java.awt.Font("Arial", 0, 12));
        lLastSaved1.setText("Last Saved:");
        lLastSaved1.setMaximumSize(new java.awt.Dimension(120, 15));
        lLastSaved1.setMinimumSize(new java.awt.Dimension(120, 15));
        lLastSaved1.setPreferredSize(new java.awt.Dimension(120, 15));
        ProjectLocationsBottomPanel1.add(lLastSaved1);

        lFiller30.setBackground(new java.awt.Color(140, 160, 210));
        lFiller30.setText("   ");
        lFiller30.setMaximumSize(new java.awt.Dimension(300, 15));
        lFiller30.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller30.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsBottomPanel1.add(lFiller30);

        tfLastSaved1.setBackground(javax.swing.UIManager.getDefaults().getColor("TextField.inactiveBackground"));
        tfLastSaved1.setFont(new java.awt.Font("Arial", 0, 12));
        tfLastSaved1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfLastSaved1.setText("This project has not been saved.");
        tfLastSaved1.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfLastSaved1.setMinimumSize(new java.awt.Dimension(300, 20));
        tfLastSaved1.setPreferredSize(new java.awt.Dimension(450, 20));
        ProjectLocationsBottomPanel1.add(tfLastSaved1);

        lFiller31.setBackground(new java.awt.Color(140, 160, 210));
        lFiller31.setText("   ");
        lFiller31.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller31.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller31.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsBottomPanel1.add(lFiller31);

        ProjectLocations.add(ProjectLocationsBottomPanel1);

        ProjectLocationsTopPanel3.setLayout(new javax.swing.BoxLayout(ProjectLocationsTopPanel3, javax.swing.BoxLayout.X_AXIS));

        ProjectLocationsTopPanel3.setBackground(new java.awt.Color(140, 160, 210));
        ProjectLocationsTopPanel3.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        ProjectLocationsTopPanel3.setMinimumSize(new java.awt.Dimension(600, 30));
        ProjectLocationsTopPanel3.setPreferredSize(new java.awt.Dimension(800, 30));
        lFiller32.setBackground(new java.awt.Color(140, 160, 210));
        lFiller32.setText("   ");
        lFiller32.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller32.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller32.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsTopPanel3.add(lFiller32);

        lLastBuilt1.setBackground(new java.awt.Color(140, 160, 210));
        lLastBuilt1.setFont(new java.awt.Font("Arial", 0, 12));
        lLastBuilt1.setText("Last Built:");
        lLastBuilt1.setMaximumSize(new java.awt.Dimension(120, 15));
        lLastBuilt1.setMinimumSize(new java.awt.Dimension(120, 15));
        lLastBuilt1.setPreferredSize(new java.awt.Dimension(120, 15));
        ProjectLocationsTopPanel3.add(lLastBuilt1);

        lFiller33.setBackground(new java.awt.Color(140, 160, 210));
        lFiller33.setText("   ");
        lFiller33.setMaximumSize(new java.awt.Dimension(300, 15));
        lFiller33.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller33.setPreferredSize(new java.awt.Dimension(10, 16));
        ProjectLocationsTopPanel3.add(lFiller33);

        tfLastBuilt1.setBackground(javax.swing.UIManager.getDefaults().getColor("TextField.inactiveBackground"));
        tfLastBuilt1.setFont(new java.awt.Font("Arial", 0, 12));
        tfLastBuilt1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfLastBuilt1.setText("This project has not been built.");
        tfLastBuilt1.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfLastBuilt1.setMinimumSize(new java.awt.Dimension(300, 20));
        tfLastBuilt1.setPreferredSize(new java.awt.Dimension(450, 20));
        ProjectLocationsTopPanel3.add(tfLastBuilt1);

        lFiller34.setBackground(new java.awt.Color(140, 160, 210));
        lFiller34.setText("   ");
        lFiller34.setMaximumSize(new java.awt.Dimension(15, 15));
        lFiller34.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller34.setPreferredSize(new java.awt.Dimension(15, 16));
        ProjectLocationsTopPanel3.add(lFiller34);

        ProjectLocations.add(ProjectLocationsTopPanel3);

        ProjectLocationsLayoutPanel.add(ProjectLocations, java.awt.BorderLayout.CENTER);

        ProjectInfoPanelCenterPanel.add(ProjectLocationsLayoutPanel);

        add(ProjectInfoPanelCenterPanel, java.awt.BorderLayout.CENTER);

        ProjectInfoPanelWestPanel.setBackground(new java.awt.Color(140, 160, 210));
        add(ProjectInfoPanelWestPanel, java.awt.BorderLayout.WEST);

        ProjectInfoPanelEastPanel.setBackground(new java.awt.Color(140, 160, 210));
        add(ProjectInfoPanelEastPanel, java.awt.BorderLayout.EAST);

    }//GEN-END:initComponents

    private void DefaultButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DefaultButton1ActionPerformed
    try
    {
        DefaultBuildDirectoryDialog ddd = new DefaultBuildDirectoryDialog(null,true);
        if(ddd.getMethod()==0)
        {
            String tempStr = DesignerRuleBuilder.getTempProject().substring(0,DesignerRuleBuilder.getTempProject().lastIndexOf("."));
            ProjectManager.putTempNoFileWrite("project_build_dir", DesignerRuleBuilder.getTempProject().substring(0,DesignerRuleBuilder.getTempProject().lastIndexOf("/")) + tempStr.substring(tempStr.lastIndexOf("/")) + ProjectManager.get("project_build_dir_name") + "/");
            ProjectManager.saveTempNow(); 
            tfBuildLocation1.setText(new File(new URL(ProjectManager.get("project_build_dir")).getFile()).getCanonicalPath());
            tfBuildLocation1.setCaretPosition(0);
        }
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    }//GEN-LAST:event_DefaultButton1ActionPerformed

    private void ChooseButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseButton1ActionPerformed
        try
        {
                fc.setFileView(fileView);
                fc.setDialogTitle("Choose Output Folder");
                fc.setApproveButtonText("Select");
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fc.setCurrentDirectory(new File(new URL(ProjectManager.get("project_build_dir")).getFile()));
                fc.showSaveDialog(this); 
                ProjectManager.put("project_build_dir",fc.getSelectedFile().toURL().toString());
                String tempStr = DesignerRuleBuilder.getTempProject().substring(0,DesignerRuleBuilder.getTempProject().lastIndexOf("."));
                tfBuildLocation1.setText(new File(new URL(ProjectManager.get("project_build_dir")).getFile()).getCanonicalPath());
		    tfBuildLocation1.setCaretPosition(0);
        }
        catch(NullPointerException e)
        {
            //Leave empty for calls to Cancel in the JFileChooser
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ChooseButton1ActionPerformed

    private void FindClassesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FindClassesButtonActionPerformed
        try
        {
            tfJavaMainClass.setText(MainClassChooser.getMainClass(this));
		tfJavaMainClass.setCaretPosition(0); 
        }
        catch(Exception e)
        {}        
    }//GEN-LAST:event_FindClassesButtonActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ChooseButton1;
    private javax.swing.JButton DefaultButton1;
    private javax.swing.JPanel ProductPrivacyPolicyEMailPanel;
    private javax.swing.JPanel ProjectIdentificationItem3Panel1;
    private javax.swing.JPanel ProjectInfoPanelCenterPanel;
    private javax.swing.JPanel ProjectInfoPanelEastPanel;
    private javax.swing.JPanel ProjectInfoPanelNorthPanel;
    private javax.swing.JPanel ProjectInfoPanelSouthPanel;
    private javax.swing.JPanel ProjectInfoPanelWestPanel;
    private javax.swing.JPanel ProjectInformation;
    private javax.swing.JPanel ProjectInformationLayoutPanel;
    private javax.swing.JPanel ProjectInformationProductInfoURLPanel;
    private javax.swing.JPanel ProjectInformationProductURLPanel;
    private javax.swing.JPanel ProjectInformationTopPanel1;
    private javax.swing.JPanel ProjectInformationTopPanel3;
    private javax.swing.JPanel ProjectLocations;
    private javax.swing.JPanel ProjectLocationsBottomPanel1;
    private javax.swing.JPanel ProjectLocationsCenterPanel1;
    private javax.swing.JPanel ProjectLocationsLayoutPanel;
    private javax.swing.JPanel ProjectLocationsTopPanel2;
    private javax.swing.JPanel ProjectLocationsTopPanel3;
    private javax.swing.JLabel lBuildLocation1;
    private javax.swing.JLabel lCopyright2;
    private javax.swing.JLabel lFiller10;
    private javax.swing.JLabel lFiller11;
    private javax.swing.JLabel lFiller12;
    private javax.swing.JLabel lFiller13;
    private javax.swing.JLabel lFiller14;
    private javax.swing.JLabel lFiller15;
    private javax.swing.JLabel lFiller16;
    private javax.swing.JLabel lFiller17;
    private javax.swing.JLabel lFiller18;
    private javax.swing.JLabel lFiller19;
    private javax.swing.JLabel lFiller2;
    private javax.swing.JLabel lFiller20;
    private javax.swing.JLabel lFiller21;
    private javax.swing.JLabel lFiller22;
    private javax.swing.JLabel lFiller23;
    private javax.swing.JLabel lFiller24;
    private javax.swing.JLabel lFiller25;
    private javax.swing.JLabel lFiller26;
    private javax.swing.JLabel lFiller27;
    private javax.swing.JLabel lFiller28;
    private javax.swing.JLabel lFiller29;
    private javax.swing.JLabel lFiller3;
    private javax.swing.JLabel lFiller30;
    private javax.swing.JLabel lFiller31;
    private javax.swing.JLabel lFiller32;
    private javax.swing.JLabel lFiller33;
    private javax.swing.JLabel lFiller34;
    private javax.swing.JLabel lFiller35;
    private javax.swing.JLabel lFiller36;
    private javax.swing.JLabel lFiller37;
    private javax.swing.JLabel lFiller4;
    private javax.swing.JLabel lFiller5;
    private javax.swing.JLabel lFiller6;
    private javax.swing.JLabel lFiller7;
    private javax.swing.JLabel lFiller8;
    private javax.swing.JLabel lFiller9;
    private javax.swing.JLabel lLastBuilt1;
    private javax.swing.JLabel lLastSaved1;
    private javax.swing.JLabel lPrivacyPolicyEMail;
    private javax.swing.JLabel lProductInfoURL;
    private javax.swing.JLabel lProductURL;
    private javax.swing.JLabel lSaveLocation1;
    private javax.swing.JLabel lSoftwareTitle1;
    private javax.swing.JLabel lSpaceFiller2;
    private javax.swing.JLabel lVendorName1;
    private javax.swing.JLabel lVersion2;
    private javax.swing.JTextField tfBuildLocation1;
    private javax.swing.JTextField tfCopyright1;
    private javax.swing.JTextField tfLastBuilt1;
    private javax.swing.JTextField tfLastSaved1;
    private javax.swing.JTextField tfPrivacyPolicyEMail;
    private javax.swing.JTextField tfProductInfoURL;
    private javax.swing.JTextField tfProductURL;
    private javax.swing.JTextField tfSaveLocation1;
    private javax.swing.JTextField tfSoftwareTitle1;
    private javax.swing.JTextField tfVendorName1;
    private javax.swing.JTextField tfVersion5;
    private javax.swing.JTextField tfVersion6;
    private javax.swing.JTextField tfVersion7;
    private javax.swing.JTextField tfVersion8;
    private javax.swing.JPanel ProductJavaMainClassPanel;
    private javax.swing.JLabel lFiller100;
    private javax.swing.JLabel lFiller101;
    private javax.swing.JLabel lFiller102;
    private javax.swing.JLabel lJavaMainClass;
    private javax.swing.JTextField tfJavaMainClass;

    private javax.swing.JTextField tfPurchaseSupportEMail;
    private javax.swing.JLabel lPurchaseSupportEMail;
    private javax.swing.JPanel ProductPurchaseSupportEMailPanel;
    private javax.swing.JLabel lFiller38;
    private javax.swing.JLabel lFiller39;
    private javax.swing.JLabel lFiller40;
    private javax.swing.JButton FindClassesButton;
    private javax.swing.JLabel FindClassesButtonFiller;
    // End of variables declaration//GEN-END:variables
    
}
