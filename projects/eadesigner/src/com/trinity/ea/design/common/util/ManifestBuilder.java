/*
 * ManifestBuilder.java
 *
 * Created on December 3, 2004, 2:20 PM
 */

package com.trinity.ea.design.common.util;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.design.rules.builder.DesignerRuleBuilder;
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

/**
 *
 * @author  aaronsc Trinity Software, LLC - with the help of referencing code found on http://forums.java.sun.com by user Massje
 * Copyright ©2004 Trinity Software, LLC. All rights reserved.
 */
public class ManifestBuilder 
{
    
    /** Creates a new instance of ManifestBuilder */
    public ManifestBuilder() 
    {
        
    }
    
    public static File getMakeExecutableManifest(String mainClass, File jarFile)
    {
        File tempManifest = null;
        if(jarFile!=null)
        {
            try
            {
                tempManifest = new File(new URL(DesignerRuleBuilder.getTempProject().substring(0, DesignerRuleBuilder.getTempProject().lastIndexOf("/")) + "/.eaproject.tmp/MANIFEST.MF").getFile());
                if(tempManifest.exists()==true)
                {
                    try
                    {
                        tempManifest.delete();
                        tempManifest.createTempFile("MF",null);
                    }
                    catch(Exception e)
                    {

                    }
                }
                else
                {
                    try
                    {
                        tempManifest.createTempFile("MF",null);       
                    }
                    catch(Exception e)
                    {

                    }             
                }
    // Create Manifest,and add to file
                try 
                {
                    JarInputStream in = new JarInputStream(new FileInputStream(jarFile));
                    JarOutputStream out = new JarOutputStream(new FileOutputStream(tempManifest));

                    JarEntry ent;
                    String manifeststr = "Manifest-Version: 1.0\nMain-Class: " + mainClass + "\n";

                    while ((ent = in.getNextJarEntry()) != null) {
                            if (!ent.getName().toUpperCase().equals("META-INF/MANIFEST.MF")
                                    && !ent.getName().toUpperCase().equals("META-INF\\MANIFEST.MF")) {
                                    out.putNextEntry(new ZipEntry(ent.getName()));
                                    out.setLevel(9);

                                    int l = 0;
                                    byte[] b = new byte[1];
                                    while ((l = in.read(b, 0, 1)) > 0)
                                            out.write(b, 0, 1);
                                    out.closeEntry();
                            }
                    }

                    byte[] b = new byte[manifeststr.length()];

                    for (int i = 0; i < manifeststr.length(); i++) {
                            b[i] = (byte) manifeststr.charAt(i);
                    }
                    out.putNextEntry(new ZipEntry("META-INF/MANIFEST.MF"));
                    out.setLevel(9);
                    out.write(b, 0, manifeststr.length());
                    out.closeEntry();

                    out.finish();
                    out.close();
                    in.close();

                    FileInputStream fis = new FileInputStream(tempManifest);
                    FileOutputStream fos = new FileOutputStream(jarFile);

                    int fb;

                    while ((fb = fis.read()) != -1)
                            fos.write(fb);

                    fis.close();
                    fos.close();

                    tempManifest.delete();
                    //JOptionPane.showMessageDialog(null, "Done! " + mainClass + ".class has been made the default executable class.", "Done!", JOptionPane.INFORMATION_MESSAGE);
                } 
                catch (Exception e) 
                {
                        //JOptionPane.showMessageDialog(null, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
                }            
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            return null;
        }
        return null;
    }
    
    public static File getMakeDefaultManifest(File jarFile)
    {
        File tempManifest = null;
        if(jarFile!=null)
        {
            try
            {
                tempManifest = new File(new URL(DesignerRuleBuilder.getTempProject().substring(0, DesignerRuleBuilder.getTempProject().lastIndexOf("/")) + "/.eaproject.tmp/MANIFEST.MF").getFile());
                if(tempManifest.exists()==true)
                {
                    try
                    {
                        tempManifest.delete();
                        tempManifest.createTempFile("MF",null);
                    }
                    catch(Exception e)
                    {

                    }
                }
                else
                {
                    try
                    {
                        tempManifest.createTempFile("MF",null);       
                    }
                    catch(Exception e)
                    {

                    }             
                }
    // Create Manifest,and add to file
                try 
                {
                    JarInputStream in = new JarInputStream(new FileInputStream(jarFile));
                    JarOutputStream out = new JarOutputStream(new FileOutputStream(tempManifest));

                    JarEntry ent;
                    String manifeststr = "Manifest-Version: 1.0\n";

                    while ((ent = in.getNextJarEntry()) != null) {
                            if (!ent.getName().toUpperCase().equals("META-INF/MANIFEST.MF")
                                    && !ent.getName().toUpperCase().equals("META-INF\\MANIFEST.MF")) {
                                    out.putNextEntry(new ZipEntry(ent.getName()));
                                    out.setLevel(9);

                                    int l = 0;
                                    byte[] b = new byte[1];
                                    while ((l = in.read(b, 0, 1)) > 0)
                                            out.write(b, 0, 1);
                                    out.closeEntry();
                            }
                    }

                    byte[] b = new byte[manifeststr.length()];

                    for (int i = 0; i < manifeststr.length(); i++) {
                            b[i] = (byte) manifeststr.charAt(i);
                    }
                    out.putNextEntry(new ZipEntry("META-INF/MANIFEST.MF"));
                    out.setLevel(9);
                    out.write(b, 0, manifeststr.length());
                    out.closeEntry();

                    out.finish();
                    out.close();
                    in.close();

                    FileInputStream fis = new FileInputStream(tempManifest);
                    FileOutputStream fos = new FileOutputStream(jarFile);

                    int fb;

                    while ((fb = fis.read()) != -1)
                            fos.write(fb);

                    fis.close();
                    fos.close();

                    tempManifest.delete();
                    //JOptionPane.showMessageDialog(null, "Done! " + mainClass + ".class has been made the default executable class.", "Done!", JOptionPane.INFORMATION_MESSAGE);
                } 
                catch (Exception e) 
                {
                        //JOptionPane.showMessageDialog(null, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
                }            
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            return null;
        }
        return null;
    }    
}
