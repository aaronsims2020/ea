/*
 * X500PrincipalChooser.java
 *
 * Created on December 4, 2004, 10:44 PM
 */
package com.trinity.ea.design.common.X500PrincipalChooser;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.util.jar.JarFile;
import java.util.Enumeration;
import java.io.File;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Collection;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

/**
 *
 * @author  aaronsc Trinity Software, LLC
 * Copyright ©2004-2005 Trinity Software, LLC. All rights reserved.
 */
public class X500PrincipalChooser extends javax.swing.JDialog {
    private static boolean isOK = false;
    /** Creates new form X500PrincipalChooser */ 
    public X500PrincipalChooser(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setResizable(false);
        setTitle("Choose X500 Principal");
        // Get the size of the screen
        setSize(710,265);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Determine the new location of the window
        int w = getSize().width;
        int h = getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
 
        // Move the window
        setLocation(x, y);       
    }
    
     private static String showX500PrincipalChooser(Component parent, String[] x500PrincipalArray)
     {
         String val = "";
         try
         {
            X500PrincipalChooser chooser = new X500PrincipalChooser(null, true);
            MainClassList.setListData(x500PrincipalArray);
            chooser.show();
            if(MainClassList.getSelectedIndex()!=-1)
            {
                val = x500PrincipalArray[MainClassList.getSelectedIndex()];
            }
            chooser.dispose();
            return val;
         }
         catch(Exception e)
         {
		//e.printStackTrace();
	   }
        return val;
     }
     
    /** Display the X500 Principal Chooser. */
    public static String getX500Principal(Component parent)
    {
        File jarFile = null;
        String mainClass = ""; 
        try
        {
        if (jarFile == null) 
        {
            JFileChooser fc = new JFileChooser();
            fc.setMultiSelectionEnabled(false);
            fc.setAcceptAllFileFilterUsed(false); 
            fc.setFileSelectionMode(fc.FILES_ONLY);
            fc.setFileFilter(new FileFilter() 
            {
                public boolean accept(File file) 
                {
                    String f = file.getName();
                    return f.endsWith(".jar") || f.endsWith(".eal") || f.endsWith(".eam") || file.isDirectory();
                }
                public String getDescription() 
                {
                    return "*.jar, *.eal, *.eam";
                }
            });
            fc.setDialogTitle("Select the Jar File with the Digital Signature");
            fc.showOpenDialog(parent);
            jarFile = fc.getSelectedFile();
            if (jarFile == null) 
            {
                return null;
            }
        }
        if (mainClass.equals("")) 
        {
                ArrayList classes = new ArrayList();
                try 
                {
			try
			{
				JarFile jarFile1 = new JarFile(jarFile,true);
				Enumeration entries = jarFile1.entries();
				JarEntry jarEntry;
				while (entries.hasMoreElements()) 
				{
					InputStream is;
					jarEntry=(JarEntry)entries.nextElement();
					//get the input stream of the entry
					is= jarFile1.getInputStream(jarEntry);
					//read the zip entry so that the entries certs are available
					while (is.read()!=-1);
                        	Certificate[] certs = jarEntry.getCertificates();    
					if(certs!=null)
					{
                            		classes = getX500PrincipalList(certs);
					}
				}
                    }
                    catch(Exception e)
                    {
                        return null;
                    }  
                } 
                catch(Exception e)
                {
                }

                if (classes.size() > 0) 
                {
                    //JComboBox combo = new JComboBox();
                    String[] mainClassStringArray = new String[classes.size()];
                    for (int i = 0; i < classes.size(); i++) 
                    {
                        mainClassStringArray[i] = (String)classes.get(i);
                    }
                    return showX500PrincipalChooser(parent,mainClassStringArray);
                }
            } 
    }   
        catch (Exception e) 
            {

            }
      return null;  
    }       
        
        //return null;
    //}     
     
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        ContentPanel = new javax.swing.JPanel();
        jScrollPaneList = new javax.swing.JScrollPane();
        MainClassList = new javax.swing.JList();
        NorthPanel = new javax.swing.JPanel();
        EastPanel = new javax.swing.JPanel();
        WestPanel = new javax.swing.JPanel();
        ButtonPanel = new javax.swing.JPanel();
        OKButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        ContentPanel.setLayout(new java.awt.BorderLayout());

        MainClassList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPaneList.setViewportView(MainClassList);

        ContentPanel.add(jScrollPaneList, java.awt.BorderLayout.CENTER);

        NorthPanel.setMaximumSize(new java.awt.Dimension(10, 10));
        ContentPanel.add(NorthPanel, java.awt.BorderLayout.NORTH);

        EastPanel.setMaximumSize(new java.awt.Dimension(10, 10));
        ContentPanel.add(EastPanel, java.awt.BorderLayout.EAST);

        WestPanel.setMaximumSize(new java.awt.Dimension(10, 10));
        ContentPanel.add(WestPanel, java.awt.BorderLayout.WEST);

        getContentPane().add(ContentPanel, java.awt.BorderLayout.CENTER);

        ButtonPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 10));

        OKButton.setMnemonic('O');
        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        ButtonPanel.add(OKButton);

        CancelButton.setMnemonic('C');
        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        ButtonPanel.add(CancelButton);

        getContentPane().add(ButtonPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        isOK=false;
        setVisible(false);
    }//GEN-LAST:event_formWindowClosed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        isOK=false;
        setVisible(false);
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        isOK=true;
        setVisible(false);
    }//GEN-LAST:event_OKButtonActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JButton CancelButton;
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JPanel EastPanel;
    private static javax.swing.JList MainClassList;
    private javax.swing.JPanel NorthPanel;
    private javax.swing.JButton OKButton;
    private javax.swing.JPanel WestPanel;
    private javax.swing.JScrollPane jScrollPaneList;
    // End of variables declaration//GEN-END:variables

    private static ArrayList getX500PrincipalList(Certificate[] certs)
    {
       try 
       {
           ArrayList alist = new ArrayList();
          if(certs != null)
          {
             for(int i = 0; i < certs.length; i++)
             {
                alist.add(((X509Certificate)certs[i]).getSubjectX500Principal().toString());
             }
             alist.trimToSize();
             return alist;
          }
          else
          {
             return null;
          }
       } 
       catch (Exception e) 
       {
           return null;
       }     
    }       
}
