/*
 * MainClassChooser.java
 *
 * Created on December 4, 2004, 10:44 PM
 */
package com.trinity.ea.design.common.mainclasschooser;

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

/**
 *
 * @author  aaronsc Trinity Software, LLC
 * Copyright ©2004 Trinity Software, LLC. All rights reserved.
 */
public class MainClassChooser extends javax.swing.JDialog {
    private static boolean isOK = false;
    /** Creates new form MainClassChooser */ 
    public MainClassChooser(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setResizable(false);
        setTitle("Choose Main Class");
        // Get the size of the screen
        setSize(355,265);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Determine the new location of the window
        int w = getSize().width;
        int h = getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
 
        // Move the window
        setLocation(x, y);       
    }
    
     private static String showMainClassChooser(Component parent, String[] mainClassArray)
     {
         String val = "";
         try
         {
            MainClassChooser chooser = new MainClassChooser(null, true);
            MainClassList.setListData(mainClassArray);
            chooser.show();
            if(MainClassList.getSelectedIndex()!=-1)
            {
                val = mainClassArray[MainClassList.getSelectedIndex()];
            }
            chooser.dispose();
		val = val.replaceAll("/",".");
            return val;
         }
         catch(Exception e)
         {
		//e.printStackTrace();
	   }
        return val;
     }
     
    /** Display the Main Class Chooser. */
    public static String getMainClass(Component parent)
    {
        File jarFile = null;
        String mainClass = "";       
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
                    return f.endsWith(".jar") || file.isDirectory();
                }
                public String getDescription() 
                {
                    return "*.jar";
                }
            });
            fc.setDialogTitle("Select the Jar File containing the Application Main Class");
            fc.showOpenDialog(parent);
            jarFile = fc.getSelectedFile();
            if (jarFile == null) 
            {
                return null;
            }
        }
        if (mainClass.equals("")) 
        {
            try 
            {
                JarInputStream in = new JarInputStream(new FileInputStream(jarFile));
                JarEntry ent;
                Vector classes = new Vector();
                URL[] loadingURLs = { jarFile.toURL()};
                ClassLoader cl = new URLClassLoader(loadingURLs);
                while((ent = in.getNextJarEntry()) != null) 
                {
                    if (ent.getName().toLowerCase().endsWith(".class")) 
                    {
                        StringTokenizer tok = new StringTokenizer(ent.getName(), "/");
                        String fullpropername = "";
                        while (tok.hasMoreTokens())
                                fullpropername += tok.nextToken() + ".";

                        fullpropername = fullpropername.substring(0, fullpropername.length() - 7);
                        try 
                        {
                            Method[] m = cl.loadClass(fullpropername).getMethods();
                            for (int mi = 0; mi < m.length; mi++) 
                            {
					  try
					  {
                                	if (m[mi].getName().equals("main")) 
                                	{
                                    	classes.add(ent.getName().substring(0, ent.getName().length() - 6));
                                	}
					  }
					  catch(Exception e)
					  {

					  }
                            }
                        } 
                        catch (Exception e) 
                        {
                        }
                    }
                    in.closeEntry();
                }
                in.close();
                if (classes.size() > 0) 
                {
                    //JComboBox combo = new JComboBox();
                    String[] mainClassStringArray = new String[classes.size()];
                    for (int i = 0; i < classes.size(); i++) 
                    {
                        mainClassStringArray[i] = (String)classes.get(i);
                    }
                    return showMainClassChooser(parent,mainClassStringArray);
                }
            } 
            catch (Exception e) 
            {

            }
        }       
        
        return "";
    }     
     
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
    
}
