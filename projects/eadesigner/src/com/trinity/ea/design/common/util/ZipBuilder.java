/*
 * ZipBuilder.java
 *
 * Created on May 23, 2004, 5:44 PM
 */

package com.trinity.ea.design.common.util;
import java.util.zip.ZipOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;
import java.util.zip.Deflater;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.JarURLConnection;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;
import java.util.ArrayList;
//import com.trinity.ea.design.common.util.JARSigner;

/**
 * Portions of this class are based on an example found at: http://forum.java.sun.com/thread.jsp?forum=4&thread=325256
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class ZipBuilder
{
    private String zipTofilename;   
    public ZipBuilder()
    {
    //File file = compress();
    }

    public static File compress(File ZipFile, String[] zipEntries, ArrayList byteArraysArrayList)
    {
        int BUFFER = 2048;
        try 
        {
            BufferedInputStream origin = null;
            FileOutputStream dest = new FileOutputStream(ZipFile);
            BufferedOutputStream bos = new BufferedOutputStream(dest);            
            ZipOutputStream out = new ZipOutputStream(bos);

            out.setMethod(ZipOutputStream.DEFLATED);
            out.setLevel(Deflater.BEST_COMPRESSION); //use default level

            byte data [ ] = new byte [ BUFFER ];

           // String[] filesToZip = {"Access.java", "tom.java", "Proof.java", "Zip.java"};
//

           
            
//
            for (int i = 0; i < zipEntries.length; i++) 
            {
                ByteArrayInputStream fi = new ByteArrayInputStream((byte[])byteArraysArrayList.get(i));
                //FileInputStream fi = new FileInputStream(zipEntries[i]);
                origin = new BufferedInputStream(fi, BUFFER);
                ZipEntry entry = new ZipEntry(zipEntries[i]);
                out.putNextEntry(entry);
                int count;
                while ((count = origin.read(data, 0, BUFFER)) != -1) 
                {
                    out.write(data, 0, count);
                }
                origin.close();
            }
            out.close();
            bos.close();
            dest.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return ZipFile;
    }    
    
    public static File compress(File ZipFile, String[] filesToArchive)
    {
        int BUFFER = 2048;
        try 
        {
            BufferedInputStream origin = null;
            FileOutputStream dest = new FileOutputStream(ZipFile);
            BufferedOutputStream bos = new BufferedOutputStream(dest);
            ZipOutputStream out = new ZipOutputStream(bos);

            out.setMethod(ZipOutputStream.DEFLATED);
            out.setLevel(Deflater.BEST_COMPRESSION); //use default level

            byte data [ ] = new byte [ BUFFER ];

           // String[] filesToZip = {"Access.java", "tom.java", "Proof.java", "Zip.java"};

            for (int i = 0; i < filesToArchive.length; i++) 
            {
                FileInputStream fi = new FileInputStream(filesToArchive[i]);
                origin = new BufferedInputStream(fi, BUFFER);
                ZipEntry entry = new ZipEntry(filesToArchive[i]);
                out.putNextEntry(entry);
                int count;
                while ((count = origin.read(data, 0, BUFFER)) != -1) 
                {
                    out.write(data, 0, count);
                }
                origin.close();
            }
            out.close();
            bos.close();
            dest.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return ZipFile;
    }
    

    public static byte[] getClassByteArray(File jarFile, String strJarEntry)
    {
        try 
        {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            URL jarURL = new URL("jar:" + jarFile.toURL().toString() + "!" + strJarEntry);
            JarURLConnection conn = (JarURLConnection)jarURL.openConnection();
            JarFile jarfile = conn.getJarFile();   
            JarEntry jarEntry = jarfile.getJarEntry(strJarEntry.substring(1));
            InputStream is = jarfile.getInputStream(jarEntry);
            int c;    
            while((c=is.read())>=0) out.write(c);   
            is.close();
            byte[] theByteArray = out.toByteArray();
            return out.toByteArray();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
            return null;
        }        
    }
    
    /** returns int 0 on success */
    public static int getFileFromZipEntry(File jarFile, String strJarEntry, File outputFile, boolean overwriteFile)
    {
            try 
            {
                int result = createFile(outputFile, overwriteFile);               
                if(overwriteFile == true)
                {
                    if(result==0 || result == 1)
                    {
                        FileOutputStream fos = new FileOutputStream(outputFile);
                        BufferedOutputStream bos = new BufferedOutputStream(fos);            
                        ByteArrayOutputStream out = new ByteArrayOutputStream();
                        URL jarURL = new URL("jar:" + jarFile.toURL().toString() + "!/" + strJarEntry);
                        JarURLConnection conn = (JarURLConnection)jarURL.openConnection();
                        JarFile jarfile = conn.getJarFile();   
                        JarEntry jarEntry = jarfile.getJarEntry(strJarEntry);
                        InputStream is = jarfile.getInputStream(jarEntry);
                        int c;    
                        while((c=is.read())>=0) out.write(c);   
                        is.close();
                        out.writeTo(bos);
                        fos.close();
                        bos.close();
                        return 0;
                    }
                    else
                    {
                        return 1;
                    }
                }
                else
                {
                    if(result==0)
                    {
                        FileOutputStream fos = new FileOutputStream(outputFile);
                        BufferedOutputStream bos = new BufferedOutputStream(fos);            
                        ByteArrayOutputStream out = new ByteArrayOutputStream();
                        URL jarURL = new URL("jar:" + jarFile.toURL().toString() + "!/" + strJarEntry);
                        JarURLConnection conn = (JarURLConnection)jarURL.openConnection();
                        JarFile jarfile = conn.getJarFile();   
                        JarEntry jarEntry = jarfile.getJarEntry(strJarEntry);
                        InputStream is = jarfile.getInputStream(jarEntry);
                        int c;    
                        while((c=is.read())>=0) out.write(c);   
                        is.close();
                        out.writeTo(bos);
                        fos.close();
                        bos.close();
                        return 0;
                    }
                    else if(result==1)
                    {
                        return 0;
                    }
                    else
                    {
                        return 1;
                    }
                }
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
                return 1;
            }       
    }
    
    /** return int 0 = File created, int 1 = File exists, greater or equal to 2 = Problem writing the file */
    private static int createFile(File theDestinationFile, boolean boolOverwriteFile)
    {
        try
        {
            if(theDestinationFile.isDirectory()==true)
            {
                try
                {
                    //System.out.println("THe source file is a directory: " + theSourceFile.getPath());
                    // Move file to new directory
                    if(theDestinationFile.exists()==false)
                    {
                        boolean resp1 = theDestinationFile.mkdirs();
                        if(resp1==true)
                        {
                            return 0;
                        }
                        else
                        {
                            return 2;
                        }
                    }
                    else
                    {
                        return 1;
                    }
                }
                catch(Exception e)
                {
                    return 2;
                }    
            }
            else
            {
                    // if the source file exists, then continue.
                    if(theDestinationFile.exists()==true)
                    {
                        // 1. Check if the file can be overwriten. If not then return 0;
                        if(boolOverwriteFile==true)
                        {
                            // TODO 2/11/2004: Implement Rollback feature for manual Rollback on failed upgrades.
                            // The Destination File exists. Must overwrite. Backup may be necessary.
                            try
                            {
     //                           System.out.println("Deleting old update file to replace with new file.");
                                theDestinationFile.delete();
     //                            System.out.println("Deleted Successfully");
                                try
                                {
                                    // Move file to new directory
                                    boolean resp1 = theDestinationFile.createNewFile();
                                    if(resp1==true)
                                    {
                                        return 0;
                                    }
                                    else
                                    {
                                        return 2;
                                    }
                                }
                                catch(Exception e)
                                {
                                    return 2;
                                }    
                            }
                            catch(Exception e)
                            {

                                e.printStackTrace();
                                return 8;
                            }                           
                        }
                        else
                        {
                            return 1;
                        }
                    }
                    else 
                    {
                        // The destination file does not exist. Proceed by verifying directory exists. If not create the directory, and then attemp to create the file.
                          try
                          {
                            File theCopyToDirectory = new File(getDownloadDirFromFileString(theDestinationFile.toURL().getPath()));
                            if(theCopyToDirectory.exists()==true)
                            {
                                //if the directory exists for the destination file, copy the file.
                                try
                                {
                                    // Move file to new directory
                                    boolean resp1 = theDestinationFile.createNewFile();
                                    if(resp1==true)
                                    {
                                        return 0;
                                    }
                                    else
                                    {
                                        return 2;
                                    }
                                }
                                catch(Exception e)
                                {
                                    return 2;
                                }    
                            }
                            else
                            {
                                  //if the directory does not exist for the destination file, create the directory and then copy the file.                               
    //                              System.out.println("Making directory: " + theCopyToDirectory.getAbsolutePath());
                                  boolean isCreated = theCopyToDirectory.mkdirs();
    //                              System.out.println("Created Directory: " + isCreated);    
                                try
                                {
                                    // Move file to new directory
                                    boolean resp1 = theDestinationFile.createNewFile();
                                    if(resp1==true)
                                    {
                                        return 0;
                                    }
                                    else
                                    {
                                        return 2;
                                    }
                                }
                                catch(Exception e)
                                {
                                    return 2;
                                }                                        
                            }
                          }
                          catch(Exception e)
                          {
                              e.printStackTrace();
                              return 8;
                          }
                    }
                }
            
        }
        catch(Exception e)
        {
            return 8;
        }       
    }    

    /* returns the install file path minus file and last slash for directory path */
    private static synchronized String getDownloadDirFromFileString(String strFilePath)
    {
        try
        {
            if(strFilePath.indexOf("/")!=-1)
            {
                if(strFilePath.indexOf("/")==0)
                {
                    if(strFilePath.lastIndexOf("/")==0)
                    {
                        return "/";
                    }
                    else
                    {
                        return strFilePath.substring(0,strFilePath.lastIndexOf("/"));
                    }
                }
                else
                {
                    /* If / is not the first character assume the first part of the dir path is the directory name followed by a / */
                    try
                    {
                        strFilePath=strFilePath.trim();
                        if(strFilePath.indexOf("/")==0)
                        {
                            if(strFilePath.lastIndexOf("/")==0)
                            {
                                return "/";
                            }
                            else
                            {
                                return strFilePath.substring(0,strFilePath.lastIndexOf("/"));
                            }
                        }
                        else
                        {
                            strFilePath = "/" + strFilePath;
                            return strFilePath.substring(0,strFilePath.lastIndexOf("/"));
                        }
                    }
                    catch(NullPointerException e)
                    {
                        return "/";
                    }
                    catch(Exception e)
                    {
                        return "/";                
                    }
                }
            }
            else
            {
                    return "/";                
            }
        }
        catch(NullPointerException e)
        {
            return "/";
        }
        catch(Exception e)
        {
            return "/";                
        }        
     }    

 //   public static void main(String[] args)
 //   {
        //String[] theArray = {"test1.txt", "test2.txt", "test3.txt", "test4.txt"};
        //ZipBuilder.compress(new File("test.jar"),theArray);
/*        try
        {
            ArrayList theTempList1 = new ArrayList();
            theTempList1.add(0,getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea2.jar").getFile()), "/com/trinity/ea/EvaluateAnywhere.class"));
            theTempList1.add(1,getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/rules/reader/EncryptedRuleReader.class"));
            theTempList1.add(2,getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/rules/reader/RuleHandler.class")); 
            theTempList1.trimToSize();
            String[] theStringList = {"/com/trinity/ea/EvaluateAnywhere.class","/com/trinity/ea/rules/reader/EncryptedRuleReader.class","/com/trinity/ea/rules/reader/RuleHandler.class"};
            ZipBuilder.compress(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/temp/design.jar").getFile()), theStringList, theTempList1);
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
 */
        //JARSigner
  //  }
}
