/*
 * WorkFolderPanel.java
 *
 * Created on May 18, 2004, 5:02 PM
 */

package com.trinity.ea.design.autoupdate.folders;
import com.trinity.ea.design.autoupdate.folders.AutoUpdateFoldersPanel;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.common.file.ProjectManager;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea; 
import javax.swing.JLabel;
import javax.swing.JPanel;

/** 
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2004 Trinity Software. All rights reserved.
 */
public class WorkFolderPanel extends EAPanel {
    private int osDefine = 0;
    public final static int WINDOWS = 0;
    public final static int UNIX = 1;
    public final static int JAVA = 2;
    public final static int OSX = 3;
    public void setOperatingEnvironment(int operatingEnvironment)
    {
	  osDefine = operatingEnvironment;
	  if(operatingEnvironment==2)
	  {
	        AutoUpdateApplicationRootPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(122, 133, 168)), "Java Work Folder", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
	  }
	  else if(operatingEnvironment==0)
	  {
	        AutoUpdateApplicationRootPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(122, 133, 168)), "Windows Work Folder", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
	  }
	  else if(operatingEnvironment==1)
	  {
	        AutoUpdateApplicationRootPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(122, 133, 168)), "UNIX Work Folder", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
	  }
	  else if(operatingEnvironment==3)
	  {
	        AutoUpdateApplicationRootPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(122, 133, 168)), "Macintosh OS X Work Folder", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
	  }
	  setProjectData();
    }    
    public int getOperatingEnvironment()
    {
	  return osDefine;
    }      
    /** Creates new form WorkFolderPanel */
    public WorkFolderPanel() {
        initComponents();
        setProjectData();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        AutoUpdateApplicationRootPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        OptinHTMLFormInputElementsPanelItem21 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        SystemPropertyOrFileSystemPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        rbButtonPanel = new javax.swing.JPanel();
        rbButtonPanelDescription = new javax.swing.JPanel();
        taRootFolderDescription = new javax.swing.JTextArea();
        RootFolderSelectionPanels = new javax.swing.JPanel();
        LabelHeaderPanel = new javax.swing.JPanel();
        lComboHeaderLabel = new javax.swing.JLabel();
        lPropertyHeaderLabel = new javax.swing.JLabel();
        RootFolderSelectionPanel = new javax.swing.JPanel();
        comboRootFolder1 = new javax.swing.JComboBox();
        lFiller2 = new javax.swing.JLabel();
        taRootFolder1 = new javax.swing.JTextField();
        LabelHeaderPanel1 = new javax.swing.JPanel();
        lComboHeaderLabel2 = new javax.swing.JLabel();
        lDirectoryHeaderLabel2 = new javax.swing.JLabel();
        RootFolderDirectoryPanel = new javax.swing.JPanel();
        lFiller5 = new javax.swing.JLabel();
        lFiller6 = new javax.swing.JLabel();
        taRootFolder2 = new javax.swing.JTextField();
        BottomFillerPanel = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        setBackground(new java.awt.Color(176, 191, 240));
        AutoUpdateApplicationRootPanel.setLayout(new javax.swing.BoxLayout(AutoUpdateApplicationRootPanel, javax.swing.BoxLayout.X_AXIS));

        AutoUpdateApplicationRootPanel.setBackground(new java.awt.Color(176, 191, 240));
        AutoUpdateApplicationRootPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(122, 133, 168)), "Work Folder", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        AutoUpdateApplicationRootPanel.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        AutoUpdateApplicationRootPanel.setMinimumSize(new java.awt.Dimension(370, 0));
        AutoUpdateApplicationRootPanel.setPreferredSize(new java.awt.Dimension(560, 155));
        jPanel5.setBackground(new java.awt.Color(176, 191, 240));
        jPanel5.setMaximumSize(new java.awt.Dimension(10, 10));
        AutoUpdateApplicationRootPanel.add(jPanel5);

        OptinHTMLFormInputElementsPanelItem21.setLayout(new java.awt.BorderLayout());

        OptinHTMLFormInputElementsPanelItem21.setBackground(new java.awt.Color(176, 191, 240));
        OptinHTMLFormInputElementsPanelItem21.setMaximumSize(new java.awt.Dimension(2147483647, 116));
        OptinHTMLFormInputElementsPanelItem21.setMinimumSize(new java.awt.Dimension(370, 116));
        OptinHTMLFormInputElementsPanelItem21.setPreferredSize(new java.awt.Dimension(715, 116));
        jPanel7.setBackground(new java.awt.Color(176, 191, 240));
        jPanel7.setMaximumSize(new java.awt.Dimension(10, 1));
        jPanel7.setMinimumSize(new java.awt.Dimension(10, 1));
        OptinHTMLFormInputElementsPanelItem21.add(jPanel7, java.awt.BorderLayout.EAST);

        SystemPropertyOrFileSystemPanel.setLayout(new java.awt.BorderLayout());

        SystemPropertyOrFileSystemPanel.setBackground(new java.awt.Color(176, 191, 240));
        SystemPropertyOrFileSystemPanel.setMinimumSize(new java.awt.Dimension(505, 125));
        SystemPropertyOrFileSystemPanel.setPreferredSize(new java.awt.Dimension(400, 125));
        jLabel3.setBackground(new java.awt.Color(176, 191, 240));
        jLabel3.setText("Download Directory:");
        SystemPropertyOrFileSystemPanel.add(jLabel3, java.awt.BorderLayout.NORTH);

        rbButtonPanel.setLayout(new javax.swing.BoxLayout(rbButtonPanel, javax.swing.BoxLayout.X_AXIS));

        rbButtonPanel.setBackground(new java.awt.Color(176, 191, 240));
        rbButtonPanelDescription.setLayout(new java.awt.BorderLayout());

        rbButtonPanelDescription.setBackground(new java.awt.Color(176, 191, 240));
        rbButtonPanelDescription.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        rbButtonPanelDescription.setMinimumSize(new java.awt.Dimension(370, 45));
        rbButtonPanelDescription.setPreferredSize(new java.awt.Dimension(370, 45));
        taRootFolderDescription.setBackground(new java.awt.Color(176, 191, 240));
        taRootFolderDescription.setEditable(false);
        taRootFolderDescription.setFont(new java.awt.Font("Arial", 0, 12));
        taRootFolderDescription.setLineWrap(true);
        taRootFolderDescription.setText("The \"Work Folder\" is the location new software updates are moved to, and installed from, after the software update download is completed. The \"Work Folder\" location must be different, than the \"Download Folder\" location. ");
        taRootFolderDescription.setWrapStyleWord(true);
        taRootFolderDescription.setBorder(null);
        rbButtonPanelDescription.add(taRootFolderDescription, java.awt.BorderLayout.CENTER);

        rbButtonPanel.add(rbButtonPanelDescription);

        SystemPropertyOrFileSystemPanel.add(rbButtonPanel, java.awt.BorderLayout.NORTH);

        RootFolderSelectionPanels.setLayout(new javax.swing.BoxLayout(RootFolderSelectionPanels, javax.swing.BoxLayout.Y_AXIS));

        RootFolderSelectionPanels.setBackground(new java.awt.Color(176, 191, 240));
        RootFolderSelectionPanels.setMaximumSize(new java.awt.Dimension(2147483647, 70));
        RootFolderSelectionPanels.setMinimumSize(new java.awt.Dimension(505, 70));
        RootFolderSelectionPanels.setPreferredSize(new java.awt.Dimension(400, 70));
        LabelHeaderPanel.setLayout(new javax.swing.BoxLayout(LabelHeaderPanel, javax.swing.BoxLayout.X_AXIS));

        LabelHeaderPanel.setBackground(new java.awt.Color(176, 191, 240));
        LabelHeaderPanel.setMaximumSize(new java.awt.Dimension(2147483647, 15));
        LabelHeaderPanel.setMinimumSize(new java.awt.Dimension(520, 15));
        LabelHeaderPanel.setPreferredSize(new java.awt.Dimension(400, 15));
        lComboHeaderLabel.setBackground(new java.awt.Color(176, 191, 240));
        lComboHeaderLabel.setFont(new java.awt.Font("Arial", 1, 12));
        lComboHeaderLabel.setText("Define Work Folder:");
        lComboHeaderLabel.setMaximumSize(new java.awt.Dimension(210, 15));
        lComboHeaderLabel.setMinimumSize(new java.awt.Dimension(210, 15));
        lComboHeaderLabel.setPreferredSize(new java.awt.Dimension(210, 15));
        LabelHeaderPanel.add(lComboHeaderLabel);

        lPropertyHeaderLabel.setBackground(new java.awt.Color(176, 191, 240));
        lPropertyHeaderLabel.setFont(new java.awt.Font("Arial", 1, 12));
        lPropertyHeaderLabel.setText("Sub-Folder (if applicable):");
        lPropertyHeaderLabel.setMaximumSize(new java.awt.Dimension(2147483647, 15));
        lPropertyHeaderLabel.setMinimumSize(new java.awt.Dimension(10, 15));
        lPropertyHeaderLabel.setPreferredSize(new java.awt.Dimension(10, 15));
        LabelHeaderPanel.add(lPropertyHeaderLabel);

        RootFolderSelectionPanels.add(LabelHeaderPanel);

        RootFolderSelectionPanel.setLayout(new javax.swing.BoxLayout(RootFolderSelectionPanel, javax.swing.BoxLayout.X_AXIS));

        RootFolderSelectionPanel.setBackground(new java.awt.Color(176, 191, 240));
        RootFolderSelectionPanel.setPreferredSize(new java.awt.Dimension(400, 20));
        comboRootFolder1.setBackground(new java.awt.Color(176, 191, 240));
        comboRootFolder1.setFont(new java.awt.Font("Dialog", 0, 12));
        comboRootFolder1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Application Root Folder", "System Property", "User's Home Folder" }));
        comboRootFolder1.setMaximumSize(new java.awt.Dimension(32767, 20));
        comboRootFolder1.setMinimumSize(new java.awt.Dimension(200, 20));
        comboRootFolder1.setPreferredSize(new java.awt.Dimension(200, 20));
        comboRootFolder1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRootFolder1ActionPerformed(evt);
            }
        });

        RootFolderSelectionPanel.add(comboRootFolder1);

        lFiller2.setBackground(new java.awt.Color(176, 191, 240));
        lFiller2.setMaximumSize(new java.awt.Dimension(10, 20));
        lFiller2.setMinimumSize(new java.awt.Dimension(10, 20));
        lFiller2.setPreferredSize(new java.awt.Dimension(10, 20));
	  lFiller2.setText(" /");
        RootFolderSelectionPanel.add(lFiller2);

        taRootFolder1.setFont(new java.awt.Font("Arial", 0, 12));
        taRootFolder1.setText("/..");
        taRootFolder1.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        taRootFolder1.setMinimumSize(new java.awt.Dimension(150, 20));
        taRootFolder1.setPreferredSize(new java.awt.Dimension(150, 20));
        RootFolderSelectionPanel.add(taRootFolder1);

        RootFolderSelectionPanels.add(RootFolderSelectionPanel);

        LabelHeaderPanel1.setLayout(new javax.swing.BoxLayout(LabelHeaderPanel1, javax.swing.BoxLayout.X_AXIS));

        LabelHeaderPanel1.setBackground(new java.awt.Color(176, 191, 240));
        LabelHeaderPanel1.setMinimumSize(new java.awt.Dimension(520, 15));
        LabelHeaderPanel1.setPreferredSize(new java.awt.Dimension(400, 15));
        lComboHeaderLabel2.setBackground(new java.awt.Color(176, 191, 240));
        lComboHeaderLabel2.setFont(new java.awt.Font("Arial", 1, 12));
        lComboHeaderLabel2.setMaximumSize(new java.awt.Dimension(210, 15));
        lComboHeaderLabel2.setMinimumSize(new java.awt.Dimension(210, 15));
        lComboHeaderLabel2.setPreferredSize(new java.awt.Dimension(210, 15));
        LabelHeaderPanel1.add(lComboHeaderLabel2);

        lDirectoryHeaderLabel2.setBackground(new java.awt.Color(176, 191, 240));
        lDirectoryHeaderLabel2.setFont(new java.awt.Font("Arial", 1, 12));
        lDirectoryHeaderLabel2.setText("Sub-Folder (if applicable):");
        lDirectoryHeaderLabel2.setMaximumSize(new java.awt.Dimension(2147483647, 15));
        lDirectoryHeaderLabel2.setMinimumSize(new java.awt.Dimension(10, 15));
        lDirectoryHeaderLabel2.setPreferredSize(new java.awt.Dimension(10, 15));
        LabelHeaderPanel1.add(lDirectoryHeaderLabel2);

        RootFolderSelectionPanels.add(LabelHeaderPanel1);

        RootFolderDirectoryPanel.setLayout(new javax.swing.BoxLayout(RootFolderDirectoryPanel, javax.swing.BoxLayout.X_AXIS));

        RootFolderDirectoryPanel.setBackground(new java.awt.Color(176, 191, 240));
        RootFolderDirectoryPanel.setPreferredSize(new java.awt.Dimension(400, 20));
        lFiller5.setBackground(new java.awt.Color(176, 191, 240));
        lFiller5.setMaximumSize(new java.awt.Dimension(200, 20));
        lFiller5.setMinimumSize(new java.awt.Dimension(200, 20));
        lFiller5.setPreferredSize(new java.awt.Dimension(200, 20));
        RootFolderDirectoryPanel.add(lFiller5);

        lFiller6.setBackground(new java.awt.Color(176, 191, 240));
        lFiller6.setMaximumSize(new java.awt.Dimension(10, 20));
        lFiller6.setMinimumSize(new java.awt.Dimension(10, 20));
        lFiller6.setPreferredSize(new java.awt.Dimension(10, 20));
        RootFolderDirectoryPanel.add(lFiller6);

        taRootFolder2.setFont(new java.awt.Font("Arial", 0, 12));
        taRootFolder2.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        taRootFolder2.setMinimumSize(new java.awt.Dimension(150, 20));
        taRootFolder2.setPreferredSize(new java.awt.Dimension(200, 20));
        RootFolderDirectoryPanel.add(taRootFolder2);

        RootFolderSelectionPanels.add(RootFolderDirectoryPanel);

        SystemPropertyOrFileSystemPanel.add(RootFolderSelectionPanels, java.awt.BorderLayout.CENTER);

        BottomFillerPanel.setBackground(new java.awt.Color(176, 191, 240));
        BottomFillerPanel.setMaximumSize(new java.awt.Dimension(10, 10));
        SystemPropertyOrFileSystemPanel.add(BottomFillerPanel, java.awt.BorderLayout.SOUTH);

        OptinHTMLFormInputElementsPanelItem21.add(SystemPropertyOrFileSystemPanel, java.awt.BorderLayout.NORTH);

        jPanel18.setLayout(new java.awt.BorderLayout());

        jPanel18.setBackground(new java.awt.Color(176, 191, 240));
        OptinHTMLFormInputElementsPanelItem21.add(jPanel18, java.awt.BorderLayout.SOUTH);

        jPanel2.setBackground(new java.awt.Color(176, 191, 240));
        jPanel2.setMaximumSize(new java.awt.Dimension(10, 10));
        OptinHTMLFormInputElementsPanelItem21.add(jPanel2, java.awt.BorderLayout.EAST);

        AutoUpdateApplicationRootPanel.add(OptinHTMLFormInputElementsPanelItem21);

        jPanel4.setBackground(new java.awt.Color(176, 191, 240));
        jPanel4.setMaximumSize(new java.awt.Dimension(10, 10));
        AutoUpdateApplicationRootPanel.add(jPanel4);

        add(AutoUpdateApplicationRootPanel, java.awt.BorderLayout.NORTH);

    }//GEN-END:initComponents

    private void comboRootFolder1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRootFolder1ActionPerformed
        if(comboRootFolder1.getSelectedIndex()!=-1)
        {
            if(comboRootFolder1.getSelectedIndex()==0)
            {
                setEAJarFolderSelected();
            }
            else if(comboRootFolder1.getSelectedIndex()==1)
            {
                setSystemPropertySelected();
            }
            else if(comboRootFolder1.getSelectedIndex()==2)
            {
                setUsersHomeFolderSelected();                
            }
        }
    }//GEN-LAST:event_comboRootFolder1ActionPerformed

    private void setEAJarFolderSelected()
    {
        try
        {
		if(((AutoUpdateFoldersPanel)getParentComponent())!=null)
		{
			((AutoUpdateFoldersPanel)getParentComponent()).setWorkFolderNormal();
		}
            ProjectManager.putSystemPropertyPlatformValue("autoUpdateWorkDirSystemPropertyEnabled", "false", getOperatingEnvironment());
            lPropertyHeaderLabel.setText("Sub-Folder (if applicable):");
            lDirectoryHeaderLabel2.setVisible(false);
            taRootFolder2.setEnabled(false);
		lFiller2.setText(" /");
		lFiller6.setText("");
            if(ProjectManager.get("autoUpdateWorkDir")!=null)
            {

                 taRootFolder1.setText(trimUnusedFirstForwardSlash(ProjectManager.getSystemPropertyExtendedValue(ProjectManager.getSystemPropertyPlatformValue("autoUpdateWorkDir",getOperatingEnvironment()))));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
 
    private void setSystemPropertySelected()
    {
        try
        {
		if(((AutoUpdateFoldersPanel)getParentComponent())!=null)
		{
			((AutoUpdateFoldersPanel)getParentComponent()).setWorkFolderIsSystemProperty();
		}
            ProjectManager.putSystemPropertyPlatformValue("autoUpdateWorkDirSystemPropertyEnabled", "true", getOperatingEnvironment());
            lPropertyHeaderLabel.setText("System Property:");
            lDirectoryHeaderLabel2.setVisible(true);
            lDirectoryHeaderLabel2.setText("Sub-Folder (if applicable):"); 
  		taRootFolder2.setEnabled(true);
		lFiller2.setText("");
		lFiller6.setText(" /");
            String unparsedString = null;
            if(ProjectManager.get("autoUpdateWorkDir")!=null)
            {
                unparsedString = ProjectManager.getSystemPropertyPlatformValue("autoUpdateWorkDir",getOperatingEnvironment());
                if(ProjectManager.getSystemPropertyExtendedValue(unparsedString)!=null)
                {
                    taRootFolder2.setText(trimUnusedFirstForwardSlash(ProjectManager.getSystemPropertyExtendedValue(unparsedString)));
                }
            }
            if(ProjectManager.get("/$WORK_DIR/$")!=null)
            {
                taRootFolder1.setText(ProjectManager.getSystemPropertyPlatformValue("/$WORK_DIR/$",getOperatingEnvironment()));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }        
    }

    private void setUsersHomeFolderSelected()
    {
        try
        {
		if(((AutoUpdateFoldersPanel)getParentComponent())!=null)
		{
			((AutoUpdateFoldersPanel)getParentComponent()).setWorkFolderNormal();
		}
            ProjectManager.putSystemPropertyPlatformValue("autoUpdateWorkDirSystemPropertyEnabled", "true", getOperatingEnvironment());
            lPropertyHeaderLabel.setText("Sub-Folder (if applicable):");
            lDirectoryHeaderLabel2.setVisible(false);
            taRootFolder2.setEnabled(false);
		lFiller2.setText(" /");
		lFiller6.setText("");
            if(ProjectManager.get("autoUpdateWorkDir")!=null)
            {
                 taRootFolder1.setText(trimUnusedFirstForwardSlash(ProjectManager.getSystemPropertyExtendedValue(ProjectManager.getSystemPropertyPlatformValue("autoUpdateWorkDir",getOperatingEnvironment()))));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }    

    private String trimUnusedFirstForwardSlash(String theTrimString)
    {
		try
		{
			if(theTrimString.startsWith("/")==true)
			{
				return theTrimString.substring(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return theTrimString;
    }

    public synchronized void getDataUpdate()
    {
	String strRootFolder1;
	String strRootFolder2;
	try
	{
		strRootFolder1 = taRootFolder1.getText();
            if(ProjectManager.getSystemPropertyPlatformValue("autoUpdateWorkDirSystemPropertyEnabled",getOperatingEnvironment()).equalsIgnoreCase("true")==true)
            {
                if(comboRootFolder1.getSelectedIndex()==1)
                {
			strRootFolder2 = taRootFolder2.getText();
			if(strRootFolder2.equalsIgnoreCase("")==false && strRootFolder2.startsWith("/")==false)
			{
				strRootFolder2 = "/" + strRootFolder2;
			}
	            ProjectManager.putSystemPropertyPlatformValue("/$WORK_DIR/$", strRootFolder1, getOperatingEnvironment());
      	      ProjectManager.putSystemPropertyPlatformValue("autoUpdateWorkDir", "/$WORK_DIR/$" + strRootFolder2, getOperatingEnvironment());
                }
                else if(comboRootFolder1.getSelectedIndex()==2)
                {
			if(strRootFolder1.equalsIgnoreCase("")==false && strRootFolder1.startsWith("/")==false)
			{
				strRootFolder1 = "/" + strRootFolder1;
			}
            	ProjectManager.putSystemPropertyPlatformValue("autoUpdateWorkDir", "/$USER_HOME_DIR/$" + strRootFolder1, getOperatingEnvironment());
                }
            }
            else
            {
			if(strRootFolder1.equalsIgnoreCase("")==false && strRootFolder1.startsWith("/")==false)
			{
				strRootFolder1 = "/" + strRootFolder1;
			}
	            ProjectManager.putSystemPropertyPlatformValue("autoUpdateWorkDir", strRootFolder1, getOperatingEnvironment());
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
		// Auto Update Support Functionality Checkbox Enabled/Disabled   
            if(ProjectManager.getSystemPropertyPlatformValue("autoUpdateWorkDirSystemPropertyEnabled",getOperatingEnvironment()).equalsIgnoreCase("true")==true)
            {
                String unparsedString = null;
                String systemPropertyType = null;
                if(ProjectManager.get("autoUpdateWorkDir")!=null)
                {
                    systemPropertyType = ProjectManager.getSystemPropertyDefine(ProjectManager.getSystemPropertyPlatformValue("autoUpdateWorkDir",getOperatingEnvironment()));
                    if(systemPropertyType.equalsIgnoreCase("/$USER_HOME_DIR/$")==true)
                    {    
                        taRootFolder1.setText(trimUnusedFirstForwardSlash(ProjectManager.getSystemPropertyExtendedValue(ProjectManager.getSystemPropertyPlatformValue("autoUpdateWorkDir",getOperatingEnvironment()))));
                        comboRootFolder1.setSelectedIndex(2);
                        setUsersHomeFolderSelected();
                    }
                    else if(systemPropertyType.equalsIgnoreCase("/$WORK_DIR/$")==true)
                    {    
                        unparsedString = ProjectManager.getSystemPropertyPlatformValue("autoUpdateWorkDir",getOperatingEnvironment());
                        if(ProjectManager.getSystemPropertyExtendedValue(unparsedString)!=null)
                        {
                            taRootFolder2.setText(trimUnusedFirstForwardSlash(ProjectManager.getSystemPropertyExtendedValue(unparsedString)));
                        }
                        if(ProjectManager.get("/$WORK_DIR/$")!=null)
                        {
                            taRootFolder1.setText(ProjectManager.getSystemPropertyPlatformValue("/$WORK_DIR/$",getOperatingEnvironment()));
                        }
                        comboRootFolder1.setSelectedIndex(1);
                        setSystemPropertySelected();
                    }
                }
            }
            else
            {
                if(ProjectManager.get("autoUpdateWorkDir")!=null)
                {
                     taRootFolder1.setText(trimUnusedFirstForwardSlash(ProjectManager.getSystemPropertyExtendedValue(ProjectManager.getSystemPropertyPlatformValue("autoUpdateWorkDir",getOperatingEnvironment()))));
                }       
                comboRootFolder1.setSelectedIndex(0);
                setEAJarFolderSelected();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AutoUpdateApplicationRootPanel;
    private javax.swing.JPanel BottomFillerPanel;
    private javax.swing.JPanel LabelHeaderPanel;
    private javax.swing.JPanel LabelHeaderPanel1;
    private javax.swing.JPanel OptinHTMLFormInputElementsPanelItem21;
    private javax.swing.JPanel RootFolderDirectoryPanel;
    private javax.swing.JPanel RootFolderSelectionPanel;
    private javax.swing.JPanel RootFolderSelectionPanels;
    private javax.swing.JPanel SystemPropertyOrFileSystemPanel;
    private javax.swing.JComboBox comboRootFolder1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lComboHeaderLabel;
    private javax.swing.JLabel lComboHeaderLabel2;
    private javax.swing.JLabel lDirectoryHeaderLabel2;
    private javax.swing.JLabel lFiller2;
    private javax.swing.JLabel lFiller5;
    private javax.swing.JLabel lFiller6;
    private javax.swing.JLabel lPropertyHeaderLabel;
    private javax.swing.JPanel rbButtonPanel;
    private javax.swing.JPanel rbButtonPanelDescription;
    private javax.swing.JTextField taRootFolder1;
    private javax.swing.JTextField taRootFolder2;
    private javax.swing.JTextArea taRootFolderDescription;
    // End of variables declaration//GEN-END:variables
    
}
