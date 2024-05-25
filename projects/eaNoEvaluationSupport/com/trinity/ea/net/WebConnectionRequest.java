/*
 * secureWebConnectionPayment.java
 *
 * Created on October 20, 2003, 4:48 PM
 */

package com.trinity.ea.net;
import java.net.*;
import javax.net.ssl.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import com.trinity.ea.parser.HTMLParser;
import com.trinity.ea.rules.reader.EncryptedRuleReader;


/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2003 Trinity Software. All rights reserved.
 */
public class WebConnectionRequest 
{
    private static boolean boolTrustedServerConnectionEnabled = false;
    private static String requestMethod = "GET";
    private static String postRequest = null;
    private static String userAgent = "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0)";
    private static String contentLanguage = "en-US";
    private static String contentType = "application/x-www-form-urlencoded";
 
    public static void setRequestMethod(String reqMethod)
    {
        requestMethod = reqMethod;
    }
    
    public static String getRequestMethod()
    {
        return requestMethod;
    }

    public static void setUserAgent(String theUserAgent)
    {
        userAgent = theUserAgent;
    }
    
    public static String getUserAgent()
    {
        return userAgent;
    }    
    
    public static void setRequestData(String reqData)
    {
        postRequest = reqData;
    }
    
    public static String getRequestData()
    {
        return postRequest;
    }    

    public static void setContentLanguage(String theContentLanguage)
    {
        contentLanguage = theContentLanguage;
    }
    
    public static String getContentLanguage()
    {
        return contentLanguage;
    }        

    public static void setContentType(String theContentType)
    {
        contentType = theContentType;
    }
    
    public static String getContentType()
    {
        return contentType;
    }          
    
    
    public static void main(String[] args)
    {
     //new WebConnectionRequest();   
    }

    /** Creates a new instance of submitHttpsHTMLFormGetRequest */
    public WebConnectionRequest(){}
 
    /** Set the Trusted Server Certificate Required Option (Allow Certificate Name mismatch of web address - certificate web address) - Enable=true, Disabled = false. Default setting is false */
    public static void setTrustedServerCertificateRequiredEnabled(boolean isTrusted)
    {
        boolTrustedServerConnectionEnabled = isTrusted;
    }
    
    public static boolean getTrustedServerCertificateRequiredEnabled()
    {
        return boolTrustedServerConnectionEnabled;
    }
    
    /** Do a HTTP, or HTTPS GET Request, and return a Map object. Keys are as follows: String document - the response data, String http-equiv - returns the HTML Head Meta tag http-equiv value if one exists., String refreshwait - returns the number of seconds to wait for loading URL., String refreshurl - the GET request response string (returned data. */ 
    public Map doWebGetRequest(URL theURL)
    {
       try
       {
           return doHTMLFormRequest(theURL, "GET", null,userAgent,contentLanguage,contentType);
       }
       catch(NullPointerException e)
       {
            return null;
       }
       catch(Exception e)
       {
           return null;
       }
    }

    /** Do a HTTP, or HTTPS POST Request, and return a Map object. Keys are as follows: String document - the response data, String http-equiv - returns the HTML Head Meta tag http-equiv value if one exists., String refreshwait - returns the number of seconds to wait for loading URL., String refreshurl - the GET request response string (returned data. */ 
    public Map doWebPostRequest(URL theURL, String strPOSTData)
    {
       try
       {
           return doHTMLFormRequest(theURL,"POST",strPOSTData,userAgent,contentLanguage,contentType);
       }
       catch(NullPointerException e)
       {
            return null;
       }
       catch(Exception e)
       {
           return null;
       }
    }
    /** Do a HTTP, or HTTPS Request, and return a Map object. Keys are as follows: String document - the response data, String "meta http-equiv" - returns the HTML Head Meta tag http-equiv value if one exists., String refreshenabled = meta http-equiv value = String boolean, true or false, String refreshwait - returns the number of seconds to wait for loading URL., String refreshurl - the GET request response string (returned data. */ 
    public Map doHTMLFormRequest(URL url, String strRequestMethod, String strPostRequest,String strUserAgent,String strContentLanguage,String strContentType)
    {
        StringBuffer buffer = new StringBuffer();
        Map theDocumentMap = new HashMap();
        if(url.getProtocol().toString().equalsIgnoreCase("http")==true)
        {
            HttpURLConnection conn;
            OutputStream os;
            try
            {
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod(strRequestMethod);
                if(strRequestMethod.equalsIgnoreCase("GET") == false && strRequestMethod.equalsIgnoreCase("HEAD") == false)
                {
                    byte [] data={};  
                    if(strPostRequest!=null)
                    {
                        data = strPostRequest.getBytes();
                    }
                    conn.setRequestProperty("User-Agent", strUserAgent);
                    conn.setRequestProperty("Content-Language",strContentLanguage);
                    conn.setRequestProperty("Content-Type", strContentType);    
                    if(strPostRequest!=null)
                    {
                        conn.setDoOutput(true);                   
                        os = conn.getOutputStream();
                        os.write(data);
                        os.close();
                    }           
                }
                InputStream istream = conn.getInputStream();
                /*
                int ch;
                while ((ch = istream.read()) != -1) 
                {
                    buffer.append((char) ch);
                }
                **/
                HTMLParser hparser = new HTMLParser(istream);
                if(hparser.getHTMLDocument()!=null)
                {
                    theDocumentMap.put("document", hparser.getHTMLDocument().toString());
                }
                if(hparser.getHeadMetaHTTPEquivExists() == true && hparser.getHeadMetaContentExists() == true)
                {
                  if(hparser.getHeadMetaHTTPEquivValue() != null)
                  {
                    theDocumentMap.put("meta http-equiv", hparser.getHeadMetaHTTPEquivValue());
                    if(hparser.getHeadMetaContentValue()!=null)
                    {
                        theDocumentMap.put("meta content", hparser.getHeadMetaContentValue());
                    }
                    if(hparser.getHeadMetaHTTPEquivValue().equalsIgnoreCase("refresh") == true)
                    {
                        theDocumentMap.put("refreshenabled","true");
                        if(hparser.getRefreshWaitValue()!=null)
                        {
                            theDocumentMap.put("refreshwait", hparser.getRefreshWaitValue());
                            //System.out.println("Refresh Wait time: " + hparser.getRefreshWaitValue() + " seconds.");
                        }
                        if(hparser.getRefreshURLValue()!=null)
                        {
                            theDocumentMap.put("refreshurl", hparser.getRefreshURLValue());
                            //System.out.println("URL to load on Refresh: " + hparser.getRefreshURLValue());                           
                        }
                    }
                  }
                }
                
                theDocumentMap.put("responsecode", new String(Integer.toString(conn.getResponseCode())));
                theDocumentMap.put("responsemessage", conn.getResponseMessage().toString());                
               
                istream.close();
                buffer=null;
                conn = null;

                return theDocumentMap;
                //return f;
                }
                catch(UnknownHostException e)
                {
                    if(EncryptedRuleReader.get("unknownHostExceptionAction")!=null)
                    {
                        try
                        {
                            Class.forName(EncryptedRuleReader.get("unknownHostExceptionAction")).newInstance();
                        }
                        catch(InstantiationException ee)
                        {
                            System.out.println(ee);
                        }   
                        catch(IllegalAccessException eee)
                        {
                            System.out.println(eee);
                        }                      
                        catch(ClassNotFoundException eeee)
                        {
                            System.out.println(eeee);
                        }       
                    }
                    else
                    {
                        //Problem in Properties File
                    }
                }     
                catch(SocketException e)
                {
                    if(EncryptedRuleReader.get("socketExceptionAction")!=null)
                    {
                        try
                        {
                            Class.forName(EncryptedRuleReader.get("socketExceptionAction")).newInstance();
                        }
                        catch(InstantiationException ee)
                        {
                            System.out.println(ee);
                        }   
                        catch(IllegalAccessException eee)
                        {
                            System.out.println(eee);
                        }                      
                        catch(ClassNotFoundException eeee)
                        {
                            System.out.println(eeee);
                        }       
                    }
                    else
                    {
                        //Problem in Properties File
                    }                    
                }
                catch(IOException e)
                {
                    System.out.println(e);
                    e.printStackTrace();
                } 
                /*    
                istream.close();
                String f = buffer.toString();
                buffer=null;
                //System.out.println("Received HTTP Data:\r\n" + f);
                conn = null;       
                return f;
                 **/
             return null;
        }
        else if(url.getProtocol().toString().equalsIgnoreCase("https")==true)
        {
            HttpsURLConnection conn;
            OutputStream os;
            byte [] data={};
            try
            {
                conn = (HttpsURLConnection) url.openConnection();
                conn.setRequestMethod(strRequestMethod);
                if(strRequestMethod.equalsIgnoreCase("GET") == false && strRequestMethod.equalsIgnoreCase("HEAD") == false)
                {
                    if(strPostRequest!=null)
                    {
                        data = strPostRequest.getBytes();
                    }
                    conn.setRequestProperty("User-Agent", strUserAgent);
                    conn.setRequestProperty("Content-Language",strContentLanguage);
                    conn.setRequestProperty("Content-Type", strContentType);  
                }                
                if(getTrustedServerCertificateRequiredEnabled()==false)
                {
                    //Connect even if a certificate address does not match site address
                    conn.setHostnameVerifier(
                    new HostnameVerifier()
                    {
                    public boolean verify( String urlHost, SSLSession ssls ){
                    if( !urlHost.equals( ssls.getPeerHost() ) )
                    {
                        /* System.out.println( "certificate <" + ssls.getPeerHost() +
                        "> does not match host <" + urlHost + "> but " +
                        "continuing anyway" ); */
                    }
                    return true;
                    }} );
                }
                if(strRequestMethod.equalsIgnoreCase("GET") == false && strRequestMethod.equalsIgnoreCase("HEAD") == false)
                {
                    if(strPostRequest!=null)
                    {
                        conn.setDoOutput(true);
                        os = conn.getOutputStream();
                        os.write(data);
                        os.close();
                    }                 
                }

                // Retrieve information from HTTPS: GET
                conn.setDoInput(true);
                InputStream istream = conn.getInputStream();
                
               /* int ch;
                while ((ch = istream.read()) != -1) 
                {
                    buffer.append((char) ch);
                }
                              
                String f = buffer.toString();
               */
                HTMLParser hparser = new HTMLParser(istream);
                
                if(hparser.getHTMLDocument()!=null)
                {
                    theDocumentMap.put("document", hparser.getHTMLDocument().toString());
                }
                if(hparser.getHeadMetaHTTPEquivExists() == true && hparser.getHeadMetaContentExists() == true)
                {
                  if(hparser.getHeadMetaHTTPEquivValue() != null)
                  {
                    theDocumentMap.put("meta http-equiv", hparser.getHeadMetaHTTPEquivValue());
                    if(hparser.getHeadMetaContentValue()!=null)
                    {
                        theDocumentMap.put("meta content", hparser.getHeadMetaContentValue());
                    }
                    if(hparser.getHeadMetaHTTPEquivValue().equalsIgnoreCase("refresh") == true)
                    {
                        theDocumentMap.put("refreshenabled","true");
                        if(hparser.getRefreshWaitValue()!=null)
                        {
                            theDocumentMap.put("refreshwait", hparser.getRefreshWaitValue());
                            //System.out.println("Refresh Wait time: " + hparser.getRefreshWaitValue() + " seconds.");
                        }
                        if(hparser.getRefreshURLValue()!=null)
                        {
                            theDocumentMap.put("refreshurl", hparser.getRefreshURLValue());
                            //System.out.println("URL to load on Refresh: " + hparser.getRefreshURLValue());                           
                        }
                    }
                  }
                }
                theDocumentMap.put("responsecode", new String(Integer.toString(conn.getResponseCode())));
                theDocumentMap.put("responsemessage", conn.getResponseMessage().toString());                
                //.parseHTML(istream);
                istream.close();
                buffer=null;
                conn = null;

                return theDocumentMap;
                //return f;
                }
                catch(UnknownHostException e)
                {
                    if(EncryptedRuleReader.get("unknownHostExceptionAction")!=null)
                    {
                        try
                        {
                            Class.forName(EncryptedRuleReader.get("unknownHostExceptionAction")).newInstance();
                        }
                        catch(InstantiationException ee)
                        {
                            System.out.println(ee);
                        }   
                        catch(IllegalAccessException eee)
                        {
                            System.out.println(eee);
                        }                      
                        catch(ClassNotFoundException eeee)
                        {
                            System.out.println(eeee);
                        }       
                    }
                    else
                    {
                        //Problem in Properties File
                    }
                }
                catch(SocketException e)
                {
                    if(EncryptedRuleReader.get("socketExceptionAction")!=null)
                    {
                        try
                        {
                            Class.forName(EncryptedRuleReader.get("socketExceptionAction")).newInstance();
                        }
                        catch(InstantiationException ee)
                        {
                            System.out.println(ee);
                        }   
                        catch(IllegalAccessException eee)
                        {
                            System.out.println(eee);
                        }                      
                        catch(ClassNotFoundException eeee)
                        {
                            System.out.println(eeee);
                        }       
                    }
                    else
                    {
                        //Problem in Properties File
                    }                    
                }            
                catch(IOException e)
                {
                    System.out.println(e);
                    e.printStackTrace();
                }       
        }
        else
        {
            //Request method is not used by this option, as the protocol is unknown.
           URLConnection conn;
           OutputStream os;
           byte [] data={};
           try
           {
                conn = url.openConnection();
                if(strPostRequest!=null)
                {
                    data = strPostRequest.getBytes();
                }    
                conn.setRequestProperty("User-Agent", strUserAgent);
                conn.setRequestProperty("Content-Language",strContentLanguage);
                conn.setRequestProperty("Content-Type", strContentType);
                if(strPostRequest!=null)
                {
                    conn.setDoOutput(true);                   
                    os = conn.getOutputStream();
                    os.write(data);
                    os.close();
                }
                InputStream istream = conn.getInputStream();
                HTMLParser hparser = new HTMLParser(istream);
                if(hparser.getHTMLDocument()!=null)
                {
                    theDocumentMap.put("document", hparser.getHTMLDocument().toString());
                }
                if(hparser.getHeadMetaHTTPEquivExists() == true && hparser.getHeadMetaContentExists() == true)
                {
                  if(hparser.getHeadMetaHTTPEquivValue() != null)
                  {
                    theDocumentMap.put("meta http-equiv", hparser.getHeadMetaHTTPEquivValue());
                    if(hparser.getHeadMetaContentValue()!=null)
                    {
                        theDocumentMap.put("meta content", hparser.getHeadMetaContentValue());
                    }
                    if(hparser.getHeadMetaHTTPEquivValue().equalsIgnoreCase("refresh") == true)
                    {
                        theDocumentMap.put("refreshenabled","true");
                        if(hparser.getRefreshWaitValue()!=null)
                        {
                            theDocumentMap.put("refreshwait", hparser.getRefreshWaitValue());
                            //System.out.println("Refresh Wait time: " + hparser.getRefreshWaitValue() + " seconds.");
                        }
                        if(hparser.getRefreshURLValue()!=null)
                        {
                            theDocumentMap.put("refreshurl", hparser.getRefreshURLValue());
                            //System.out.println("URL to load on Refresh: " + hparser.getRefreshURLValue());                           
                        }
                    }
                  }
                }
                istream.close();
                buffer=null;
                conn = null;

                return theDocumentMap;
                }
                 catch(UnknownHostException e)
                {
                    if(EncryptedRuleReader.get("unknownHostExceptionAction")!=null)
                    {
                        try
                        {
                            Class.forName(EncryptedRuleReader.get("unknownHostExceptionAction")).newInstance();
                        }
                        catch(InstantiationException ee)
                        {
                            System.out.println(ee);
                        }   
                        catch(IllegalAccessException eee)
                        {
                            System.out.println(eee);
                        }                      
                        catch(ClassNotFoundException eeee)
                        {
                            System.out.println(eeee);
                        }       
                    }
                    else
                    {
                        //Problem in Properties File
                    }
                }      
                 catch(SocketException e)
                {
                    if(EncryptedRuleReader.get("socketExceptionAction")!=null)
                    {
                        try
                        {
                            Class.forName(EncryptedRuleReader.get("socketExceptionAction")).newInstance();
                        }
                        catch(InstantiationException ee)
                        {
                            System.out.println(ee);
                        }   
                        catch(IllegalAccessException eee)
                        {
                            System.out.println(eee);
                        }                      
                        catch(ClassNotFoundException eeee)
                        {
                            System.out.println(eeee);
                        }       
                    }
                    else
                    {
                        //Problem in Properties File
                    }                    
                }          
                catch(IOException e)
                {
                    System.out.println(e);
                    e.printStackTrace();
                } 
                /*
                istream.close();
                String f = buffer.toString();
                buffer=null;
                System.out.println("Received HTTPS Data:\r\n" + f);
                conn = null;     
                return f;
                 
            }
            catch(IOException e)
            {
                System.out.println(e);   
            }
            */
        }
        return null;
    }
    
}
