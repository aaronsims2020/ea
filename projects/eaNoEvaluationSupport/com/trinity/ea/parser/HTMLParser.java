/*
 * HTMLParser.java
 *
 * Created on October 22, 2003, 5:35 PM
 */

package com.trinity.ea.parser;
import java.io.*;
import java.net.*;
import javax.swing.text.*;
import javax.swing.text.html.*;
import java.util.*;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2003 Trinity Software. All rights reserved.
 */
public class HTMLParser 
{
    private Document doc; 
    private boolean headMetaHTTPEquivExists=false;
    private String headMetaHTTPEquivValue=null;    
    private boolean headMetaContentExists=false;   
    private String headMetaContentValue=null;
    private String refreshValue = null;
    private String contentURL = null;
    private String respCode = null;
    
    /** Creates a new instance of HTMLParser */
    public HTMLParser(InputStream is) 
    {
        EditorKit kit = new HTMLEditorKit();
        doc = kit.createDefaultDocument();
        doc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);

        try 
        {
            InputStreamReader isr = new InputStreamReader(is);
            Reader rd = new BufferedReader(isr);
            kit.read(rd, doc, 0);
            ElementIterator it = new ElementIterator(doc);
            javax.swing.text.Element elem;

            while ((elem = it.next()) != null) 
            {
                //System.out.println(elem.toString());
                if(elem.getName().equalsIgnoreCase("meta")==true)
                {
                    AttributeSet as = elem.getAttributes();
                    Enumeration attributeNames = as.getAttributeNames();
                    if(attributeNames != null)
                    {
                        while(attributeNames.hasMoreElements())
                        {
                            Object el = attributeNames.nextElement();
                
                            if(el.toString().equalsIgnoreCase("http-equiv")==true)
                            {
                                headMetaHTTPEquivExists = true;
                                headMetaHTTPEquivValue = as.getAttribute(el).toString();
                            }
                            else if(el.toString().equalsIgnoreCase("content")==true)
                            {
                                headMetaContentExists = true;
                                headMetaContentValue = as.getAttribute(el).toString();
                            }                            
                        }
                    }
                }
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }        
    }

    /** Parse an HTML GET Request Response HTML Document, and return the HTML Document, and GET Response Data from a HEAD 
      * Element's <META HTTP-EQUIV="Refresh" Content="GET URL with return Data Here">. The Map Keys are as follows:
      * key1 = document, key2 = http-equiv, key3 = content. If content key exists, and http-equiv value=refresh, key4 will equal

     */
 
     public Document getHTMLDocument()
     {
         return doc;
     }
     
     public boolean getHeadMetaHTTPEquivExists()
     {
        return headMetaHTTPEquivExists;   
     }
 
     public String getHeadMetaContentValue()
     {
        return headMetaContentValue;   
     }    

     public String getHeadMetaHTTPEquivValue()
     {
        return headMetaHTTPEquivValue;   
     }
 
     public boolean getHeadMetaContentExists()
     {
        return headMetaContentExists;   
     } 
     
     /** Returns the seconds to wait before loading the URL. */
     public String getRefreshWaitValue()
     {
         if(headMetaHTTPEquivValue.equalsIgnoreCase("refresh")==true)
         {
            if(headMetaContentValue!=null)
            {
                if(headMetaContentValue.indexOf(";")!=-1)
                {
                    return headMetaContentValue.substring(0,headMetaContentValue.indexOf(";")).trim();
                }
                else
                {
                    return headMetaContentValue;
                }
            }
            else
            {
                return null;
            }
         }
         return null;
     }

     /** Returns the URL to load after the wait value expires. */
     public String getRefreshURLValue()
     {
         if(headMetaHTTPEquivValue.equalsIgnoreCase("refresh")==true)
         {
            if(headMetaContentValue!=null)
            {
                String lcContentVal = headMetaContentValue.toLowerCase();
                if(lcContentVal.indexOf("url=")!=-1)
                {
                    return headMetaContentValue.substring(lcContentVal.indexOf("url=") + 4).trim();
                }
                else
                {
                    return headMetaContentValue;
                }
            }
            else
            {
                return null;
            }
         }
         return null;
     }     
}
