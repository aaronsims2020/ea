/*
 * FileListPanel.java
 *
 * Created on November 11, 2004, 8:58 PM
 */
package com.trinity.ea.design.autoupdate.config;

import com.trinity.ea.design.autoupdate.config.AddFileDialog;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.common.panel.EAPanel;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import java.awt.*;
import javax.swing.*; 
import javax.swing.border.*;
import java.util.ArrayList;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004-2005 Trinity Software. All rights reserved.
 */
public class FileListPanel extends EAPanel 
{
    private Color bgcolor = new java.awt.Color(140, 160, 210);
    /** Creates new form FileListPanel */
    public FileListPanel() {
        initComponents();
        setProjectData();
    }
    
    public synchronized void getDataUpdate()
    {
        try
        {
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
           if(ProjectManager.get("autoUpdateCP")!=null)
           {
                FileList.setListData(getStringArrayFromString(ProjectManager.get("autoUpdateCP")));
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
        TheFileListPanel = new javax.swing.JPanel();
        FileListScrollPane = new javax.swing.JScrollPane();
        FileList = new javax.swing.JList();
        ButtonPanel = new javax.swing.JPanel();
        AddFile = new javax.swing.JButton();
        RemoveFile = new javax.swing.JButton();
        leftPaddingLabel = new javax.swing.JLabel();
        rightPaddingLabel = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());
        setMaximumSize(new java.awt.Dimension(32767, 32767));
        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(242, 150));
	  setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(new java.awt.Color(198, 226, 253), new java.awt.Color(96, 110, 145)), "Application Files (Classpath):", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 12)));
	  setBackground(bgcolor);

	  AddFile.setFont(new java.awt.Font("Arial", 0, 12));
	  RemoveFile.setFont(new java.awt.Font("Arial", 0, 12));
	  FileList.setFont(new java.awt.Font("Arial", 0, 12));

	  TheFileListPanel.setBackground(bgcolor);
        FileListScrollPane.setBackground(bgcolor);
        ButtonPanel.setBackground(bgcolor);
        leftPaddingLabel.setBackground(bgcolor);
        rightPaddingLabel.setBackground(bgcolor);

        TheFileListPanel.setLayout(new java.awt.BorderLayout());

        FileListScrollPane.setViewportView(FileList);

        TheFileListPanel.add(FileListScrollPane, java.awt.BorderLayout.CENTER);
        leftPaddingLabel.setMaximumSize(new java.awt.Dimension(8, 8));
        leftPaddingLabel.setMinimumSize(new java.awt.Dimension(8, 8));
        leftPaddingLabel.setPreferredSize(new java.awt.Dimension(8, 8));
        TheFileListPanel.add(leftPaddingLabel, java.awt.BorderLayout.WEST);

        rightPaddingLabel.setMaximumSize(new java.awt.Dimension(8, 8));
        rightPaddingLabel.setMinimumSize(new java.awt.Dimension(8, 8));
        rightPaddingLabel.setPreferredSize(new java.awt.Dimension(8, 8));
        TheFileListPanel.add(rightPaddingLabel, java.awt.BorderLayout.EAST);
        add(TheFileListPanel, java.awt.BorderLayout.CENTER);

        AddFile.setMnemonic('A');
        AddFile.setLabel("Add File");
        AddFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddFileActionPerformed(evt);
            }
        });

        ButtonPanel.add(AddFile);

        RemoveFile.setMnemonic('R');
        RemoveFile.setLabel("Remove File");
        RemoveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveFileActionPerformed(evt);
            }
        });

        ButtonPanel.add(RemoveFile);

        add(ButtonPanel, java.awt.BorderLayout.SOUTH);

    }//GEN-END:initComponents

    private void RemoveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveFileActionPerformed
        try
        {
            int selIndex = FileList.getSelectedIndex();
            if(selIndex!=-1)
            {
               if(ProjectManager.get("autoUpdateCP")!=null)
               {
                    if(ProjectManager.get("autoUpdateCP").equalsIgnoreCase("")==false)
                    {    
                        Object[] cpArray = getStringArrayFromString(ProjectManager.get("autoUpdateCP"));
                        ArrayList theList = new ArrayList(cpArray.length - 1);
                        String newCPString = "";
                        for(int i = 0;i<cpArray.length;i++)
                        {
                            if(selIndex!=i)
                            {
                                theList.add((String)cpArray[i]);
                            }
                        }
                        theList.trimToSize();
                        Object[] cpArray2 = theList.toArray();
                        if(0<cpArray2.length)
                        {
                            newCPString = (String)cpArray2[0];
                        }
                        for(int i = 1;i<cpArray2.length;i++)
                        {
                            newCPString = newCPString + "," + ((String)cpArray2[i]);
                        }
                        ProjectManager.put("autoUpdateCP", newCPString);
                    }
                }                
            }
            setProjectData();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_RemoveFileActionPerformed

    private void AddFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddFileActionPerformed
    try
    {
        String strCPFile = AddFileDialog.showDialog(new Frame(),"Choose File");
	 if(strCPFile.equalsIgnoreCase("")==false)
	 {
       if(ProjectManager.get("autoUpdateCP")!=null)
                {
                    if(ProjectManager.get("autoUpdateCP").equalsIgnoreCase("")==false)
                    {    
                        ProjectManager.put("autoUpdateCP", ProjectManager.get("autoUpdateCP") + "," + strCPFile);
                    }
                    else
                    {
                        ProjectManager.put("autoUpdateCP", strCPFile);
                    }
                }
                else
                {
                    ProjectManager.put("autoUpdateCP", strCPFile);
                }
        setProjectData();
	}
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    }//GEN-LAST:event_AddFileActionPerformed
    
    private Object[] getStringArrayFromString(String theString)
    {
        ArrayList al = new ArrayList();
        String parseString = theString;
        if(parseString.indexOf(",") !=-1)
        {
            while(parseString.indexOf(",") !=-1)
            {
                al.add(parseString.substring(0,parseString.indexOf(",")));
                parseString = parseString.substring(parseString.indexOf(",") + 1);
            }
            al.add(parseString);
            al.trimToSize();
            //Parse key/pair values
            return al.toArray();
        }  
        al.add(parseString);
        al.trimToSize();
        //Parse key/pair values
        return al.toArray();        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddFile;
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JList FileList;
    private javax.swing.JScrollPane FileListScrollPane;
    private javax.swing.JButton RemoveFile;
    private javax.swing.JPanel TheFileListPanel;
    private javax.swing.JLabel leftPaddingLabel;
    private javax.swing.JLabel rightPaddingLabel;
    // End of variables declaration//GEN-END:variables
    
}
