/*
 * AutoUpdateFoldersPanel.java
 *
 * Created on December 31, 2003, 6:21 PM
 */

package com.trinity.ea.design.autoupdate.folders;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.autoupdate.folders.RootFolderPanel;
import com.trinity.ea.design.autoupdate.folders.WorkFolderPanel;
import com.trinity.ea.design.autoupdate.folders.DownloadFolderPanel;
import com.trinity.ea.design.autoupdate.folders.RunFolderPanel;
//import com.trinity.ea.design.autoupdate.folders.CustomDefinedFolder;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2005 Trinity Software. All rights reserved.
 */
public class AutoUpdateFoldersPanel extends EAPanel {
    private Color backgroundColor = new java.awt.Color(176, 191, 240);
    private Color borderColor1 = new java.awt.Color(176, 191, 240);
    private Color borderColor2 = new java.awt.Color(176, 191, 240);

    private int osDefine = 0;
    public final static int WINDOWS = 0;
    public final static int UNIX = 1;
    public final static int JAVA = 2;
    public final static int OSX = 3;
    public void setOperatingEnvironment(int operatingEnvironment)
    {
	  osDefine = operatingEnvironment;
	  TheRootFoldersPanel.setOperatingEnvironment(operatingEnvironment);
	  TheWorkFoldersPanel.setOperatingEnvironment(operatingEnvironment);
	  TheDownloadFoldersPanel.setOperatingEnvironment(operatingEnvironment);
        TheRunFoldersPanel.setOperatingEnvironment(operatingEnvironment);
    }    
    public int getOperatingEnvironment()
    {
	  return osDefine;
    }   

    /** Creates new form AutoUpdateFoldersPanel */
    public AutoUpdateFoldersPanel() {
        initComponents();
	  setProjectData();
	  //theEAProperties.setSelectedIndex(0);
    }
  
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        AutoUpdateContentPanel = new javax.swing.JPanel();
        DynamicHTMLFormInputSettingsPanel1 = new javax.swing.JPanel();
        OptinHTMLFormInputElementsPanelItem14 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        TheRootFoldersPanel = new RootFolderPanel();
        TheDownloadFoldersPanel = new DownloadFolderPanel();
        TheWorkFoldersPanel = new WorkFolderPanel();
        TheRunFoldersPanel = new RunFolderPanel();
        foldersScrollPane = new javax.swing.JScrollPane();
	  //TheCustomDefinedFolder = new CustomDefinedFolder();
        setLayout(new java.awt.BorderLayout());

        foldersScrollPane.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setBackground(new java.awt.Color(176, 191, 240));
        //setMinimumSize(new java.awt.Dimension(570, 343));
        //setPreferredSize(new java.awt.Dimension(570, 343));
        setMinimumSize(new java.awt.Dimension(260, 480));
        setPreferredSize(new java.awt.Dimension(560, 480));
        setMaximumSize(new java.awt.Dimension(560, 480));

        AutoUpdateContentPanel.setLayout(new java.awt.BorderLayout());

        AutoUpdateContentPanel.setBackground(new java.awt.Color(176, 191, 240));
        AutoUpdateContentPanel.setPreferredSize(new java.awt.Dimension(448, 1000));
        DynamicHTMLFormInputSettingsPanel1.setLayout(new java.awt.BorderLayout());

        DynamicHTMLFormInputSettingsPanel1.setBackground(new java.awt.Color(176, 191, 240));
        DynamicHTMLFormInputSettingsPanel1.setMaximumSize(new java.awt.Dimension(32767, 480));
        DynamicHTMLFormInputSettingsPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        DynamicHTMLFormInputSettingsPanel1.setPreferredSize(new java.awt.Dimension(0, 480));
        OptinHTMLFormInputElementsPanelItem14.setLayout(new java.awt.BorderLayout(10, 10));

        OptinHTMLFormInputElementsPanelItem14.setBackground(new java.awt.Color(176, 191, 240));
        OptinHTMLFormInputElementsPanelItem14.setMaximumSize(new java.awt.Dimension(32767, 480));
        OptinHTMLFormInputElementsPanelItem14.setMinimumSize(new java.awt.Dimension(242, 260));
        OptinHTMLFormInputElementsPanelItem14.setPreferredSize(new java.awt.Dimension(497, 480));
        jPanel19.setLayout(new javax.swing.BoxLayout(jPanel19, javax.swing.BoxLayout.Y_AXIS));

        jPanel19.setBackground(new java.awt.Color(176, 191, 240));
        jPanel19.setMaximumSize(new java.awt.Dimension(2147483647, 620));
        jPanel19.setMinimumSize(new java.awt.Dimension(260, 0));
        jPanel19.setPreferredSize(new java.awt.Dimension(560, 620));

        TheRootFoldersPanel.setLayout(new javax.swing.BoxLayout(TheRootFoldersPanel, javax.swing.BoxLayout.X_AXIS));

        TheRootFoldersPanel.setBackground(new java.awt.Color(176, 191, 240));
        TheRootFoldersPanel.setMaximumSize(new java.awt.Dimension(2147483647, 155));
        TheRootFoldersPanel.setMinimumSize(new java.awt.Dimension(260, 155));
        TheRootFoldersPanel.setPreferredSize(new java.awt.Dimension(560, 155));
	  TheRootFoldersPanel.setParentComponent(this);
        jPanel19.add(TheRootFoldersPanel);

        TheDownloadFoldersPanel.setLayout(new javax.swing.BoxLayout(TheDownloadFoldersPanel, javax.swing.BoxLayout.X_AXIS));

        TheDownloadFoldersPanel.setBackground(new java.awt.Color(176, 191, 240));
        TheDownloadFoldersPanel.setMaximumSize(new java.awt.Dimension(2147483647, 155));
        TheDownloadFoldersPanel.setMinimumSize(new java.awt.Dimension(260, 155));
        TheDownloadFoldersPanel.setPreferredSize(new java.awt.Dimension(560, 155));
	  TheDownloadFoldersPanel.setParentComponent(this);
        jPanel19.add(TheDownloadFoldersPanel);

        TheWorkFoldersPanel.setLayout(new javax.swing.BoxLayout(TheWorkFoldersPanel, javax.swing.BoxLayout.X_AXIS));

        TheWorkFoldersPanel.setBackground(new java.awt.Color(176, 191, 240));
        TheWorkFoldersPanel.setMaximumSize(new java.awt.Dimension(2147483647, 155));
        TheWorkFoldersPanel.setMinimumSize(new java.awt.Dimension(260, 155));
        TheWorkFoldersPanel.setPreferredSize(new java.awt.Dimension(560, 155));
	  TheWorkFoldersPanel.setParentComponent(this);
        jPanel19.add(TheWorkFoldersPanel);

        //TheCustomDefinedFolder.setLayout(new javax.swing.BoxLayout(TheCustomDefinedFolder, javax.swing.BoxLayout.X_AXIS));

        //TheCustomDefinedFolder.setBackground(new java.awt.Color(176, 191, 240));
        //TheCustomDefinedFolder.setMaximumSize(new java.awt.Dimension(2147483647, 155));
        //TheCustomDefinedFolder.setMinimumSize(new java.awt.Dimension(260, 155));
        //TheCustomDefinedFolder.setPreferredSize(new java.awt.Dimension(560, 155));
        //jPanel19.add(TheCustomDefinedFolder);

        TheRunFoldersPanel.setLayout(new javax.swing.BoxLayout(TheRunFoldersPanel, javax.swing.BoxLayout.X_AXIS));

        TheRunFoldersPanel.setBackground(new java.awt.Color(176, 191, 240));
        TheRunFoldersPanel.setMaximumSize(new java.awt.Dimension(2147483647, 155));
        TheRunFoldersPanel.setMinimumSize(new java.awt.Dimension(260, 155));
        TheRunFoldersPanel.setPreferredSize(new java.awt.Dimension(560, 155));
	  TheRunFoldersPanel.setParentComponent(this);
        jPanel19.add(TheRunFoldersPanel);

        foldersScrollPane.setBorder(null);
        foldersScrollPane.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        foldersScrollPane.setViewportView(jPanel19);
        OptinHTMLFormInputElementsPanelItem14.add(foldersScrollPane, java.awt.BorderLayout.CENTER);

        DynamicHTMLFormInputSettingsPanel1.add(OptinHTMLFormInputElementsPanelItem14, java.awt.BorderLayout.CENTER);

        AutoUpdateContentPanel.add(DynamicHTMLFormInputSettingsPanel1, java.awt.BorderLayout.CENTER);

        add(AutoUpdateContentPanel, java.awt.BorderLayout.CENTER);

    }//GEN-END:initComponents

    public synchronized void setProjectData()
    {
        try 
        {
		TheRootFoldersPanel.setProjectData();
		TheWorkFoldersPanel.setProjectData();
		TheRunFoldersPanel.setProjectData();
		TheDownloadFoldersPanel.setProjectData();
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
		TheRootFoldersPanel.getDataUpdate();
		TheWorkFoldersPanel.getDataUpdate();
		TheRunFoldersPanel.getDataUpdate();
		TheDownloadFoldersPanel.getDataUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
  }       

  public void setRootFolderIsSystemProperty()
  {
        TheRootFoldersPanel.setMaximumSize(new java.awt.Dimension(32767, 155));
        TheRootFoldersPanel.setMinimumSize(new java.awt.Dimension(260, 155));
        TheRootFoldersPanel.setPreferredSize(new java.awt.Dimension(560, 155));
        //DynamicHTMLFormInputSettingsPanel1.setPreferredSize(new java.awt.Dimension(0, DynamicHTMLFormInputSettingsPanel1.getPreferredSize().height + 35));
        foldersScrollPane.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
  }
  public void setRootFolderNormal()
  {
        TheRootFoldersPanel.setMaximumSize(new java.awt.Dimension(32767, 120));
        TheRootFoldersPanel.setMinimumSize(new java.awt.Dimension(260, 120));
        TheRootFoldersPanel.setPreferredSize(new java.awt.Dimension(560, 120));
        //DynamicHTMLFormInputSettingsPanel1.setPreferredSize(new java.awt.Dimension(0, DynamicHTMLFormInputSettingsPanel1.getPreferredSize().height - 35));
        //jPanel19.setPreferredSize(new java.awt.Dimension(260, jPanel19.getPreferredSize().height - 35));
        //foldersScrollPane.setViewportView(jPanel19);
  }    
  public void setDownloadFolderIsSystemProperty()
  {
        TheDownloadFoldersPanel.setMaximumSize(new java.awt.Dimension(32767, 155));
        TheDownloadFoldersPanel.setMinimumSize(new java.awt.Dimension(260, 155));
        TheDownloadFoldersPanel.setPreferredSize(new java.awt.Dimension(560, 155));
        //DynamicHTMLFormInputSettingsPanel1.setPreferredSize(new java.awt.Dimension(0, DynamicHTMLFormInputSettingsPanel1.getPreferredSize().height + 35));
        //jPanel19.setPreferredSize(new java.awt.Dimension(260, jPanel19.getPreferredSize().height + 35));
        foldersScrollPane.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
  }
  public void setDownloadFolderNormal()
  {
        TheDownloadFoldersPanel.setMaximumSize(new java.awt.Dimension(32767, 120));
        TheDownloadFoldersPanel.setMinimumSize(new java.awt.Dimension(260, 120));
        TheDownloadFoldersPanel.setPreferredSize(new java.awt.Dimension(560, 120));
        //DynamicHTMLFormInputSettingsPanel1.setPreferredSize(new java.awt.Dimension(0, DynamicHTMLFormInputSettingsPanel1.getPreferredSize().height - 35));
        //jPanel19.setPreferredSize(new java.awt.Dimension(260, jPanel19.getPreferredSize().height - 35));
  }  
  public void setWorkFolderIsSystemProperty()
  {
        TheWorkFoldersPanel.setMaximumSize(new java.awt.Dimension(32767, 155));
        TheWorkFoldersPanel.setMinimumSize(new java.awt.Dimension(260, 155));
        TheWorkFoldersPanel.setPreferredSize(new java.awt.Dimension(560, 155));
        //DynamicHTMLFormInputSettingsPanel1.setPreferredSize(new java.awt.Dimension(0, DynamicHTMLFormInputSettingsPanel1.getPreferredSize().height + 35));
        //jPanel19.setPreferredSize(new java.awt.Dimension(260, jPanel19.getPreferredSize().height + 35));
        foldersScrollPane.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
  }
  public void setWorkFolderNormal()
  {
        TheWorkFoldersPanel.setMaximumSize(new java.awt.Dimension(32767, 120));
        TheWorkFoldersPanel.setMinimumSize(new java.awt.Dimension(260, 120));
        TheWorkFoldersPanel.setPreferredSize(new java.awt.Dimension(560, 120));
        //DynamicHTMLFormInputSettingsPanel1.setPreferredSize(new java.awt.Dimension(0, DynamicHTMLFormInputSettingsPanel1.getPreferredSize().height - 35));
        //jPanel19.setPreferredSize(new java.awt.Dimension(260, jPanel19.getPreferredSize().height - 35));
  }  
  public void setRunFolderIsSystemProperty()
  {
        TheRunFoldersPanel.setMaximumSize(new java.awt.Dimension(32767, 155));
        TheRunFoldersPanel.setMinimumSize(new java.awt.Dimension(260, 155));
        TheRunFoldersPanel.setPreferredSize(new java.awt.Dimension(560, 155));
        //DynamicHTMLFormInputSettingsPanel1.setPreferredSize(new java.awt.Dimension(0, DynamicHTMLFormInputSettingsPanel1.getPreferredSize().height + 35));
        //jPanel19.setPreferredSize(new java.awt.Dimension(260, jPanel19.getPreferredSize().height + 35));
        foldersScrollPane.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
  }
  public void setRunFolderNormal()
  {
        TheRunFoldersPanel.setMaximumSize(new java.awt.Dimension(32767, 120));
        TheRunFoldersPanel.setMinimumSize(new java.awt.Dimension(260, 120));
        TheRunFoldersPanel.setPreferredSize(new java.awt.Dimension(560, 120));
        //DynamicHTMLFormInputSettingsPanel1.setPreferredSize(new java.awt.Dimension(0, DynamicHTMLFormInputSettingsPanel1.getPreferredSize().height - 35));
        //jPanel19.setPreferredSize(new java.awt.Dimension(260, jPanel19.getPreferredSize().height - 35));
        foldersScrollPane.setViewportView(jPanel19);
  }  
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AutoUpdateContentPanel;
    private javax.swing.JPanel DynamicHTMLFormInputSettingsPanel1;
    private javax.swing.JPanel OptinHTMLFormInputElementsPanelItem14;
    private RunFolderPanel TheRunFoldersPanel;
    private DownloadFolderPanel TheDownloadFoldersPanel;
    private WorkFolderPanel TheWorkFoldersPanel;
    private RootFolderPanel TheRootFoldersPanel;
    //private CustomDefinedFolder TheCustomDefinedFolder;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JScrollPane foldersScrollPane;
    // End of variables declaration//GEN-END:variables
    
}
