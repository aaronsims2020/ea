/*
 * HTTPGETRequestParser.java
 *
 * Created on October 29, 2003, 8:30 PM
 */

package com.trinity.ea.parser;
import java.util.*;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003 Trinity Software. All rights reserved.
 */
public class HTTPGETRequestParser 
{
    Map hmap;
    String reqURL = "";
    
    /** Creates a new instance of HTTPGETRequestParser.Parses HTTP GET Requests, and makes data available through get methods. */
    public HTTPGETRequestParser(String requestURL) 
    {
        hmap=new HashMap();
        ArrayList al = new ArrayList();
        String parseString = requestURL;
        if(parseString.indexOf("?") !=-1)
        {
            reqURL = parseString.substring(parseString.indexOf("?"));
            //System.out.println("Request URL:" + reqURL);
            parseString = parseString.substring(parseString.indexOf("?") + 1);               
        }
        if(parseString.indexOf("&") !=-1)
        {
            while(parseString.indexOf("&") !=-1)
            {
                al.add(parseString.substring(0,parseString.indexOf("&")));
                parseString = parseString.substring(parseString.indexOf("&") + 1);
            }
            al.add(parseString);
            al.trimToSize();
            //Parse key/pair values
            Object[] sa = al.toArray();
            for(int i = 0;i<sa.length;i++)
            {
                if(((String)sa[i]).indexOf("=") !=-1)
                {
                    try
                    {
                        hmap.put(((String)sa[i]).substring(0,((String)sa[i]).indexOf("=")),((String)sa[i]).substring(((String)sa[i]).indexOf("=") +1));
                    }
                    catch(Exception e)
                    {
                        hmap.put(((String)sa[i]).substring(0,((String)sa[i]).indexOf("=")),"");
                    }
                }               
            }
        }
    }
 
  
    /** Return a String of the GET Requests initial URL (all data preceding ?). SetParseRequest must be called first, otherwise returns null. */  
    public String getRequestURL()
    {
        if(reqURL!=null)
        {
            return reqURL;
        }
        return null;
    }
    
    /** Return a Map of the String key/pair GET Request Values. SetParseRequest must be called first, otherwise returns null. */
    public Map getRequestMap()
    {
        if(hmap!=null)
        {
            return hmap;
        }
        return null;
    }
}
