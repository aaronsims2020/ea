/*
 * ProjectManager.java
 *
 * Created on March 24, 2004, 6:26 PM
 */

package com.trinity.ea.design.common.file;
import com.trinity.ea.util.EAProperties;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random; 
import com.trinity.ea.design.common.file.EncryptedProjectFile;
import com.trinity.ea.design.rules.builder.DesignerRuleBuilder;
import com.trinity.ea.forms.data.RandomNumberGenerator;
import com.trinity.ea.design.common.util.PasswordGenerator;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author  aaronsc Trinity Software, LLC
 * Copyright ©2003-2005 Trinity Software, LLC. All rights reserved.
 */
public class ProjectManager 
{
    private static EncryptedProjectFile theTempFile;
    private static EncryptedProjectFile theEncryptedProjectFile;
    
    /** Initializes a new instance of ProjectManager() */
    public static synchronized void initialize(File tempFile, String EncryptedProjectFileStringURL)
    {
        try
        {
            theTempFile = new EncryptedProjectFile(tempFile.toURL().toString());
            theEncryptedProjectFile = new EncryptedProjectFile(EncryptedProjectFileStringURL);
            open();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
 
    public static synchronized void save()
    {
        try
        {
            theEncryptedProjectFile.setProperties(theTempFile.getProperties());
            theEncryptedProjectFile.saveProject();
        }
        catch(Exception e)
        {
            e.printStackTrace();   
        }
    }
    
    public static synchronized void saveSinglePut(String keyValue, String strValue)
    {
        try
        {
            theEncryptedProjectFile.put(keyValue, strValue);
            theEncryptedProjectFile.saveProject();
        }
        catch(Exception e)
        {
            e.printStackTrace();   
        }
    }
    
    public static synchronized boolean saveAs(File tempFile, String EncryptedProjectFileStringURL)
    {
        try
        {
            EncryptedProjectFile theNewFile = new EncryptedProjectFile(EncryptedProjectFileStringURL);       
            theNewFile.setProperties(theEncryptedProjectFile.getProperties());
            theNewFile.saveProject();
            theEncryptedProjectFile = theNewFile;
            theTempFile = new EncryptedProjectFile(tempFile.toURL().toString());
            theTempFile.setProperties(theEncryptedProjectFile.getProperties());
            theTempFile.saveProject();
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
     
    public static synchronized boolean saveCopyAs(String EncryptedProjectFileStringURL)
    {
        try
        {
            EncryptedProjectFile theNewFile = new EncryptedProjectFile(EncryptedProjectFileStringURL);  
            theNewFile.setProperties(theEncryptedProjectFile.getProperties());
            theNewFile.saveProject();
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
     
    public static synchronized void revertToSaved()
    {
        try
        {
            //theTempFile.setProperties(theEncryptedProjectFile.getProperties());
            //theTempFile.saveProject();
            theEncryptedProjectFile.openProject();
        }
        catch(Exception e)
        {
            e.printStackTrace();   
        }        
    }
    
    private static synchronized void open()
    {
        try
        {
            if(theEncryptedProjectFile.openProject()==true)
            {
                theTempFile.setProperties(theEncryptedProjectFile.getProperties());
            }
            else
            {
                setProjectDefaults();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();   
        }       
    }    
    
    public static synchronized void put(String propID, String propValue)
    {
        try
        {
            theTempFile.put(propID,propValue);
            //theTempFile.saveProject();
        }
        catch(Exception e)
        {
            e.printStackTrace();   
        }       
    }
    
    public static synchronized String get(String propID)
    {
        try
        {
            return theTempFile.get(propID);
        }
        catch(Exception e)
        {
            e.printStackTrace();  
            return null;
        }        
    }    
    
     public static synchronized void remove(String propID)
    {
        try
        {
            theTempFile.remove(propID);
        }
        catch(Exception e)
        {
            e.printStackTrace();  
        }        
    }       
     
    public static synchronized void putTempNoFileWrite(String propID, String propValue)
    {
        try
        {
            theTempFile.put(propID,propValue);
        }
        catch(Exception e)
        {
            e.printStackTrace();   
        }        
    }
    
    public static synchronized void saveTempNow()
    {
        try
        {
            //theTempFile.saveProject();   
        }
        catch(Exception e)
        {
            e.printStackTrace();   
        }        
    }
    
    public static synchronized String getSystemPropertyDefine(String strVariable)
    {
        try
        {
          int intVarEnd = strVariable.indexOf("/$",2);
          if(intVarEnd!=-1)
          {
                return strVariable.substring(0,intVarEnd + 2);
          }
          else
          {
                return null;
          }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }   
    
    public static synchronized String getSystemPropertyExtendedValue(String strVariable)
    {
        try
        {
          int intVarEnd = strVariable.indexOf("/$",2);
          if(intVarEnd!=-1)
          {
                return strVariable.substring(intVarEnd + 2);
          }
          else
          {
                return strVariable;
          }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    } 

    /** Set the Platform's Property by the defined platform. This method could bad data if the value read contains commas. This is limited use utility method. */  
    public static synchronized void putSystemPropertyPlatformValue(String propertyName, String propertyValue,int osPlatform)
    {
        Object[] theTempArray2 = new Object[4];
        try
        {
            if(propertyName!=null)
            {}
            else
            {
                 propertyName = "";
            }
            if(propertyValue!=null)
            {}
            else
            {
                 propertyValue = "";
            }            
            if(get(propertyName)!=null)
            {
               Object[] theTempArray = getStringArraysFromString(get(propertyName));
               for(int i = 0;i<theTempArray2.length;i++)
               {
                   if(i==osPlatform)
                   {
                        theTempArray2[i] = propertyValue.replaceAll(",",":::");
                   }
                   else
                   {
                        theTempArray2[i] = (String)theTempArray[i];
                   }
               }
               putTempNoFileWrite(propertyName,getStringFromArray(theTempArray2));                  
               //.replaceAll(":::",",");
            }
            else
            {
               for(int i = 0;i<theTempArray2.length;i++)
               {
                   if(i==osPlatform)
                   {
                        theTempArray2[i] = propertyValue.replaceAll(",",":::");
                   }
                   else
                   {
                        theTempArray2[i] = "";
                   }
               }
               putTempNoFileWrite(propertyName,getStringFromArray(theTempArray2));       
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }      
    
    /** Returns the Platform's Property value for the input variable, by the defined platform. This method could bad data if the value read contains commas. This is limited use utility method. */  
    public static synchronized String getSystemPropertyPlatformValue(String propertyName, int osPlatform)
    {
        try
        {
            if(get(propertyName)!=null)
            {
               return ((String)(getStringArraysFromString(get(propertyName))[osPlatform])).replaceAll(":::",",");
            }
            else
            {
                return null;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }  
    
    private static synchronized Object[] getStringArraysFromString(String textArrayString)
    {
        ArrayList aryList = new ArrayList();
        String tempString = "";
        while(textArrayString.indexOf(",")!=-1)
        {
            tempString = textArrayString.substring(0,textArrayString.indexOf(","));
            textArrayString = textArrayString.substring(textArrayString.indexOf(",") + 1);
            aryList.add(tempString);
        }
        aryList.add(textArrayString);
        return aryList.toArray();
    }       
 
    private synchronized static String getStringFromArray(Object[] theArray)
    {
        String currentString = null;
        try
        {
            if(theArray.length!=0)
            {
                currentString = (String)theArray[0];
                for(int i = 1;i<theArray.length;i++)
                {
                    try
                    {
                        currentString = currentString + "," + (String)theArray[i];
                    }
                    catch(NullPointerException e)
                    {
                        if(currentString.endsWith(",")==true)
                        {
                            System.out.println("NullPointerException thrown CurrentString is: " + currentString.substring(0,currentString.lastIndexOf(",")));
                            currentString = currentString.substring(0,currentString.lastIndexOf(","));
                        }
                    }
                }
                return currentString;
            }
        }
        catch(Exception e)
        {
            if(currentString!=null)
            {
                if(currentString.endsWith(",")==false)
                {
                    return currentString;
                }
                else
                {
                    System.out.println("Exception thrown CurrentString is: " + currentString.substring(0,currentString.lastIndexOf(",")));
                    return currentString.substring(0,currentString.lastIndexOf(","));
                }
            }
        }
        return "";
    }    
    
    public static synchronized int getRandomInt(int maxInt)
    {
        try
        {
        Random theInt = new Random();
        return theInt.nextInt(maxInt);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    }
    
    public static synchronized void setProjectDefaults()
    {
        try 
        {
            // project properties
            putTempNoFileWrite("product_vendor_name", "Vendor_Name");
            putTempNoFileWrite("product_name", "My_Product");
            putTempNoFileWrite("product_version", "1,0,0,0");     
            putTempNoFileWrite("product_info_url", "");
            putTempNoFileWrite("product_url", ""); 
            putTempNoFileWrite("product_privacy_policy_email", "");
            putTempNoFileWrite("product_purchase_support_email", "");
            putTempNoFileWrite("product_copyright", String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));            
            putTempNoFileWrite("project_build_dir_name", "_Build_Output");
            putTempNoFileWrite("project_jarfile_name", "earun.jar");           
            putTempNoFileWrite("project_jarfile2_name", "eademo.jar"); 
            putTempNoFileWrite("message_file_name", "message.eam");      
            putTempNoFileWrite("update_file_name", "update.eal");               
            String tempStr = DesignerRuleBuilder.getTempProject().substring(0,DesignerRuleBuilder.getTempProject().lastIndexOf("."));
            putTempNoFileWrite("project_build_dir", DesignerRuleBuilder.getTempProject().substring(0,DesignerRuleBuilder.getTempProject().lastIndexOf("/")) + tempStr.substring(tempStr.lastIndexOf("/")) + get("project_build_dir_name") + "/");
            putTempNoFileWrite("message_build_dir", DesignerRuleBuilder.getTempProject().substring(0,DesignerRuleBuilder.getTempProject().lastIndexOf("/")) + "/Message" + get("project_build_dir_name") + "/");
            putTempNoFileWrite("update_build_dir", DesignerRuleBuilder.getTempProject().substring(0,DesignerRuleBuilder.getTempProject().lastIndexOf("/")) + "/Update" + get("project_build_dir_name") + "/");

            putTempNoFileWrite("project_last_built", "This project has not been built.");           
            /* The Evaluation Setting for the evaluation checkbox setting. Default should be if enabled set expireAction to notExpiredAction */
            putTempNoFileWrite("evaluation_disable_expired_software_enabled", "true");  
            /* The project setting for expiration support is enabled */             
            putTempNoFileWrite("project_expiration_support_is_enabled", "true");  
            /* The project setting for optin support is enabled */
            putTempNoFileWrite("project_optin_is_enabled", "true");
            /* The project setting for optin project is new. Used to Prompt launch Opt-In Wizard for new projects. */
            putTempNoFileWrite("project_optin_is_new", "true");            
            /* The project setting for registration code support is enabled */            
            putTempNoFileWrite("project_registration_code_support_is_enabled", "true");            
            /* The project setting for payment processing support is enabled */            
            putTempNoFileWrite("project_payment_processing_support_is_enabled", "true"); 
            /* The project setting for payment processing project is new. Used to Prompt launch Payment Processing Wizard for new projects. */
            putTempNoFileWrite("project_payment_processing_is_new", "true");  
            /* The project setting for automatic update support is enabled */             
            putTempNoFileWrite("project_auto_update_support_is_enabled", "true"); 
            /* The project setting for messaging support is enabled */             
            putTempNoFileWrite("project_messaging_support_is_enabled", "true"); 
            /* The project setting for automatic update support code signing is enabled */             
            putTempNoFileWrite("auto_update_code_signing_is_enabled", "true"); 
            /* The project setting for messaging support code signing is enabled */             
            putTempNoFileWrite("messaging_code_signing_is_enabled", "true");              
            /* The project setting for number of translated languages available. */
            putTempNoFileWrite("project_translated_lang_count", "3");             

            /* The project setting for Java platform support is enabled */            
            putTempNoFileWrite("project_java_platform_support_is_enabled", "true");            
            /* The project setting for Mac OS X support is enabled */            
            putTempNoFileWrite("project_osx_platform_support_is_enabled", "false"); 
            /* The project setting for Windows support is enabled */             
            putTempNoFileWrite("project_windows_platform_support_is_enabled", "true"); 
            /* The project setting for UNIX (All) support is enabled */             
            putTempNoFileWrite("project_unix_platform_support_is_enabled", "true");             
            
            
            // rules base evaluation properties
            putTempNoFileWrite("applicationClass", "class.not.specified");  
            putTempNoFileWrite("isRegistered", "false");
            putTempNoFileWrite("registeredCode", "777" + "-" + String.valueOf(ProjectManager.getRandomInt(999999998)) + "-" + String.valueOf(ProjectManager.getRandomInt(999999999)));           
            putTempNoFileWrite("runtimeMillasecondsToExpire", "1296000000");
            putTempNoFileWrite("runtimeMillasecondsStartTrial", "");
            putTempNoFileWrite("allowInternalStartTrialInstanciation", "true");     
            putTempNoFileWrite("expiredAction", "com.trinity.ea.actions.StartVerticalButtonBarThemeAction");            
            putTempNoFileWrite("notExpiredAction", "com.trinity.ea.actions.StartVerticalButtonBarThemeAction");
            putTempNoFileWrite("useEvaluationAction", "com.trinity.ea.actions.OptinAction");
            putTempNoFileWrite("useEvaluationActionType", "1");
            putTempNoFileWrite("launchApplicationAction", "com.trinity.ea.actions.LaunchApplicationAction");
            putTempNoFileWrite("lockDownAction", "com.trinity.ea.actions.LockedOutAction");
            putTempNoFileWrite("paymentLockDownAction", "com.trinity.ea.actions.LockedOutAction");

            
            // expiration rules functionality
            putTempNoFileWrite("expirationIsEnabled", "true");  
            putTempNoFileWrite("expirationModel", "timed");            

            // registration rules functionality
            putTempNoFileWrite("registrationCodeSupportEnabled", "true");    
            putTempNoFileWrite("regAttempts", "0");    
            putTempNoFileWrite("maxRegisterAttempts", "20");                 
             
            // registration GUI Variables
            putTempNoFileWrite("registrationTextColor", ""); 
            putTempNoFileWrite("registrationBackgroundColor", "");   
            putTempNoFileWrite("registrationDescriptionFont","Arial,0,11");              
            putTempNoFileWrite("registrationCodeLabelFont", "Arial,0,13");
            putTempNoFileWrite("registrationButtonFont", "");             
            // registration UI Variables
            putTempNoFileWrite("registerSoftwareWindowTitle", "Product Activation");
            putTempNoFileWrite("registrationCodeLabel", "Activation Code");
            putTempNoFileWrite("registrationPaidLabel", "If you paid the product activation fee, and received the activation number, enter it now. If you downloaded an evaluation version of this product, or installed from a CD, and you have not paid the product activation fee, you are only allowed to use this product for evaluation purposes.");
            putTempNoFileWrite("registrationCodeLabelFontMnemonic", "t");
            putTempNoFileWrite("registrationCancelButtonText","Cancel"); 
            putTempNoFileWrite("registrationFinishButtonText","Activate"); 
            putTempNoFileWrite("registrationCancelButtonMnemonic","C"); 
            putTempNoFileWrite("registrationFinishButtonMnemonic","A");  
            // registration main window actions
            putTempNoFileWrite("enterRegistrationCodeAction", "com.trinity.ea.actions.EnterRegActCodeAction");
            putTempNoFileWrite("enterRegistrationCodeActionType", "1");
            putTempNoFileWrite("registrationSuccessUIAction", "com.trinity.ea.actions.RegistrationSuccessUIAction");
            putTempNoFileWrite("registrationFailedUIAction", "com.trinity.ea.actions.RegistrationFailedUIAction");
            //registration failed window user interface strings
            putTempNoFileWrite("registrationFailedWindowTitle", "Activation Failed");
            putTempNoFileWrite("registrationFailedMessage", "Invalid Activation Code.");
            putTempNoFileWrite("registrationFailureOK", "OK"); 
            putTempNoFileWrite("registrationFailureOKMnemonic", "O");    
            //registration success window user interface strings
            putTempNoFileWrite("registrationSuccessWindowTitle", "Activation Success");
            putTempNoFileWrite("registrationSuccessHeader", "Activation Success!"); 
            putTempNoFileWrite("registrationSuccessDesc", "Thank You for activating this software."); 
            putTempNoFileWrite("registrationSuccessOK", "Done"); 
            putTempNoFileWrite("registrationSuccessOKMnemonic", "D");  
            // registration success window actions
            putTempNoFileWrite("registrationSucceededAction","com.trinity.ea.actions.RegistrationCompleteFinishedAction");            
            // Image Button (Portions used in this code are located in the Startup Window Button Bar variables)
            try
            {
                putTempNoFileWrite("registrationImgButtonFace", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/btn.png").toString());
                putTempNoFileWrite("registrationImgButtonFaceOnClick", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/btnclick.png").toString());
                putTempNoFileWrite("registrationButtonFaceInFocus", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/btnfocus.png").toString());
            }
            catch(Exception e){}            
            putTempNoFileWrite("registrationImgButtonWidth", "94"); 
            putTempNoFileWrite("registrationImgButtonHeight", "32");
            // Custom Border
            putTempNoFileWrite("registrationCustomBorderEnabled","false");
            putTempNoFileWrite("registrationTFExtBorderColor", "162,186,202");  
            putTempNoFileWrite("registrationTFHighlightBorderColor1", "38,54,69");  
            putTempNoFileWrite("registrationTFHighlightBorderColor2", "100,132,154");  
            putTempNoFileWrite("registrationTFShadowBorderColor1", "162,182,202");    
            putTempNoFileWrite("registrationTFShadowBorderColor2", "215,226,233");    

            // optin rules functionality
            putTempNoFileWrite("optinIsEnabled", "true");
            putTempNoFileWrite("optinIsOptedIn", "false");
            putTempNoFileWrite("optinEMail", "");
            putTempNoFileWrite("optinName", "");
            putTempNoFileWrite("optinPrivacyPolicyEnabled", "true");
            putTempNoFileWrite("optinInputFullName","");
            putTempNoFileWrite("optinInputEMailAddress", "");
            putTempNoFileWrite("optinFormRequestMethod", "POST");
            putTempNoFileWrite("optinInputHiddenNames", "");
            putTempNoFileWrite("optinInputHiddenValues","");
            putTempNoFileWrite("optinFormActionURL", "http://www.enter_your_html_optin_form_url_here.com/yourform");
            // optin actions
            putTempNoFileWrite("optinCancelAction", "com.trinity.ea.actions.LaunchApplicationAction");
            putTempNoFileWrite("optinContinueAction", "com.trinity.ea.actions.LaunchApplicationAction");
            putTempNoFileWrite("showOptinUIAction", "com.trinity.ea.forms.optin.dlgEMailOptin");           
            putTempNoFileWrite("privacyPolicyAction", "com.trinity.ea.actions.PrivacyPolicyAction");
            putTempNoFileWrite("privacyPolicyActionType","1");
            
            // optin UI Strings
            putTempNoFileWrite("privacyPolicy", "Privacy Notice\\r\\nPrivacy Notice Effective 03/21/2005\\r\\n\\r\\nPrivacy Notice Table Of Contents:\\r\\n\\r\\n# Our Commitment To Privacy\\r\\n# The Information We Collect\\r\\n# How We Use Information\\r\\n# Our Commitment To Data Security\\r\\n# Our Commitment To Children's Privacy\\r\\n# How To Access Or Correct Your Information\\r\\n# How To Contact Us\\r\\n\\r\\nOur Commitment To Privacy\\r\\n\\r\\nYour privacy is important to us. To better protect your privacy we provide this notice explaining our online information practices and the choices you can make about the way your information is collected and used. To make this notice easy to find, we make it available on our homepage and at every point where personally identifiable information may be requested.\\r\\n\\r\\nThe Information We Collect:\\r\\n\\r\\nThis notice applies to all information collected or submitted via this VENDOR_NAME application, and the VENDOR_NAME website. In some application windows, and/or web pages, you can order products, make requests, and register to receive materials. The types of personal information collected at these pages are:\\r\\n\\r\\n      Name\\r\\n      Address\\r\\n      Email address\\r\\n      Phone number\\r\\n      Credit/Debit Card Information\\r\\n\\r\\nOn some pages, or application windows, you can submit information about other people. For example, if you order a gift online and want it sent directly to the recipient, you will need to submit the recipient's address. In this circumstance, the types of personal information collected are:\\r\\n\\r\\n      Name\\r\\n      Address\\r\\n      E-mail address\\r\\n      Phone Number\\r\\n\\r\\nThe Way We Use Information:\\r\\n\\r\\nWe use the information you provide about yourself when placing an order only to complete that order. We do not share this information with outside parties except to the extent necessary to complete that order.\\r\\n\\r\\nWe use the information you provide about someone else when placing an order only to ship the product and to confirm delivery. We do not share this information with outside parties except to the extent necessary to complete that order.\\r\\n\\r\\nWe use return email addresses to answer the email we receive. Such addresses are not used for any other purpose and are not shared with outside parties.\\r\\n\\r\\nYou can register with our website if you would like to receive our catalog as well as updates on our new products, special offers, and services. Information you submit on our website will not be used for this purpose unless you fill out the login, special offer, opt-in, or registration form.\\r\\n\\r\\nWe use non-identifying and aggregate information to better design our applications, website and to share with advertisers. For example, we may tell an advertiser that X number of individuals visited a certain area on our website, or that Y number of men and Z number of women filled out our registration form, but we would not disclose anything that could be used to identify those individuals.\\r\\n\\r\\nFinally, we never use or share the personally identifiable information provided to us online in ways unrelated to the ones described above without also providing you an opportunity to opt-out or otherwise prohibit such unrelated uses.\\r\\n\\r\\nOur Commitment To Data Security\\r\\n\\r\\nTo prevent unauthorized access, maintain data accuracy, and ensure the correct use of information, we have put in place appropriate physical, electronic, and managerial procedures to safeguard and secure the information we collect online.\\r\\n\\r\\nOur Commitment To Children's Privacy:\\r\\n\\r\\nProtecting the privacy of the very young is especially important. For that reason, we never collect or maintain information at our website from those we actually know are under 13, and no part of our website is structured to attract anyone under 13.\\r\\n\\r\\nHow You Can Access Or Correct Your Information\\r\\n\\r\\nYou can access all your personally identifiable E-mail opt-in information that we collect online and maintain by clicking the link provided with the text \"To stop further mailings or to change your details, click on this link: \". We use this procedure to better safeguard your information.\\r\\n\\r\\nYou can correct factual errors in your personally identifiable information by sending us a request that credibly shows error.\\r\\n\\r\\nTo protect your privacy and security, we will also take reasonable steps to verify your identity before granting access or making corrections.\\r\\n\\r\\nHow To Contact Us\\r\\n\\r\\nShould you have other questions or concerns about these privacy policies, please contact us at the following E-mail address: product_privacy_policy_email");
            putTempNoFileWrite("optinYourNameLabel", "Your Name:");
            putTempNoFileWrite("optinYourEMailLabel", "Your E-mail:");
            putTempNoFileWrite("registerSoftwareTitle", "Register Evaluation Software");
            putTempNoFileWrite("optinPrivacyPolicyLabel", "Privacy Policy");
            putTempNoFileWrite("privacyPolicyTitle", "Privacy Policy");
            putTempNoFileWrite("optinDescription", "Register to receive PRODUCT_VENDOR_NAME update E-mail:");
// Additional Privacy Policy Variables should be appended to the Designer             
             putTempNoFileWrite("privacyPolicyOKBtnText","OK");  
             putTempNoFileWrite("privacyPolicyOKBtnMnemonic","O");
             putTempNoFileWrite("privacyPolicyTextBackgroundColor","255,255,255");             
             putTempNoFileWrite("privacyPolicyTextFont","Arial,0,12");
             putTempNoFileWrite("privacyPolicyDialogSize","485,310");
             putTempNoFileWrite("privacyPolicyBackgroundColor", "");    
             putTempNoFileWrite("privacyPolicyButtonTextColor", ""); 
             putTempNoFileWrite("privacyPolicyTextColor", "");                    
           
// Additional Opt-In Window Variables
             putTempNoFileWrite("optinCancelButtonText","Cancel");
             putTempNoFileWrite("optinCancelButtonMnemonic","a");
             putTempNoFileWrite("optinContinueButtonText","Continue >>");
             putTempNoFileWrite("optinContinueButtonMnemonic","C");
             putTempNoFileWrite("optinDescriptionFont","Arial,0,12");
             putTempNoFileWrite("optinButtonFont","");
             putTempNoFileWrite("optinPrivacyPolicyFont","Arial,0,12");
             putTempNoFileWrite("optinPrivacyPolicyTextColor","0,0,153");
             putTempNoFileWrite("optinNameEMailFont","Arial,0,13");
             putTempNoFileWrite("optinTextFieldFont","Arial,0,13");

// Additional Optin Strings
             putTempNoFileWrite("optinEnterNameMessage", "Please Enter Your Name.");
             putTempNoFileWrite("optinEnterValidEMailMessage","Please Enter a Valid E-mail Address.");   
             putTempNoFileWrite("optinEnterEMailMessage","Please Enter Your E-mail Address.");

             // Additional Optin Processing Variables          
             putTempNoFileWrite("optinBackgroundColor", ""); 
             putTempNoFileWrite("optinButtonTextColor", "");   
             putTempNoFileWrite("optinPrivacyPolicyMnemonic", "P");
             
            // optin network property (is a general setting that applies to all Get Requests both Payments, and EMail. */
//TODO: implement separate property for optin, and payment processing
            putTempNoFileWrite("supportMetaRefreshEnabled", "true");
            putTempNoFileWrite("respInputStatus", "Status");
//END TODO
             // payment processing rules functionality        
             putTempNoFileWrite("paymentProcessingSupportEnabled", "true");         
             putTempNoFileWrite("refundPolicyEnabled", "true");
              
             // payment user interface strings
             putTempNoFileWrite("paymentWindowTitle", "Secure Payment Form by EvaluateAnywhere");
             putTempNoFileWrite("paymentStateLabel", "State"); 
             putTempNoFileWrite("paymentExpMMYYLabel", "Expiration MM/YY");    
             putTempNoFileWrite("paymentContinueButtonText", "Continue >>");
             putTempNoFileWrite("paymentCancelButtonText", "Cancel");
             putTempNoFileWrite("paymentInstructionsLine1", "Enter this order's billing information in the fields below. When you have filled in all of the fields click on the Continue button below. ( All fields required ).");
             putTempNoFileWrite("paymentVerificationCodeLabel", "Verification Code");
             putTempNoFileWrite("paymentRefundPolicyLabel", "Refund Policy");
             putTempNoFileWrite("paymentFirstNameDataFieldEmptyMessage", "Please Enter Your First Name.");
             putTempNoFileWrite("paymentLastNameDataFieldEmptyMessage", "Please Enter Your Last Name.");
             putTempNoFileWrite("paymentValidEMailDataFieldEmptyMessage", "Please Enter a Valid E-mail Address.");
             putTempNoFileWrite("paymentEMailDataFieldEmptyMessage", "Please Enter Your E-mail Address.");
             putTempNoFileWrite("paymentStreetDataFieldEmptyMessage", "Please Enter Your Street Address.");
             putTempNoFileWrite("paymentCityDataFieldEmptyMessage", "Please Enter Your Address City.");
             putTempNoFileWrite("paymentZipDataFieldEmptyMessage", "Please Enter Your Zip Code.");
             putTempNoFileWrite("paymentCCDataFieldEmptyMessage", "Please Enter Your Complete Credit Card Number.");
             putTempNoFileWrite("paymentCCVerificationCodeFieldEmptyMessage", "Please Enter the Credit Card Verification Code (Usually on back of card).");
             putTempNoFileWrite("paymentPhoneDataFieldEmptyMessage", "Please enter your telephone number.");
             putTempNoFileWrite("paymentFirstNameLabel", "First Name"); 
             putTempNoFileWrite("paymentLastNameLabel", "Last Name");
             putTempNoFileWrite("paymentEMailLabel", "E-mail Address");
             putTempNoFileWrite("paymentStreetLabel", "Address");
             putTempNoFileWrite("paymentCityLabel", "City");
             putTempNoFileWrite("paymentCountryLabel", "Country");
             putTempNoFileWrite("paymentZipCodeLabel", "Zip/Post Code");
             putTempNoFileWrite("paymentPaymentMethodLabel", "Payment Method");
             putTempNoFileWrite("paymentCCLabel", "Card Number");
             putTempNoFileWrite("paymentOrdersOutsideUSLabel", "INT for orders outside U.S.");
             putTempNoFileWrite("paymentFormProductLabel", "PRODUCT_NAME");
             // payment success user interface strings
             putTempNoFileWrite("paymentSuccessResponsePanelTitle", "Payment Validation Response");
             putTempNoFileWrite("paymentSuccessResponsePanelHeaderDescription", "Thank You for purchasing PRODUCT_NAME PRODUCT_VERSION Instant Download! Below is the general information for your purchase.");
             putTempNoFileWrite("paymentSuccessResponsePanelOrderID", "Order ID");
             putTempNoFileWrite("paymentSuccessResponsePanelNameOnCard", "Name On Card");
             putTempNoFileWrite("paymentSuccessResponsePanelEMailAddress", "E-mail Address");
             putTempNoFileWrite("paymentSuccessResponsePanelAmountBilled", "Amount Billed");
             putTempNoFileWrite("paymentSucceededActionMessage", "Exiting Application. Please Restart application to use registered version.");
             // payment failed user interface strings
             putTempNoFileWrite("paymentFailureResponsePanelTitle", "Payment Validation Response");
             putTempNoFileWrite("paymentFailureResponsePanelHeaderDescription", "Your Credit Card Transaction has been declined. The following message was returned.");
             putTempNoFileWrite("paymentFailureResponsePanelOrderID", "Order ID");
             putTempNoFileWrite("paymentFailureResponsePanelNameOnCard", "Name On Card");
             putTempNoFileWrite("paymentFailureResponsePanelEMailAddress", "E-mail Address");
             putTempNoFileWrite("paymentFailureResponsePanelAmountBilled", "Amount Billed");
             putTempNoFileWrite("paymentFailureResponsePanelMessage", "To retry your transaction click the Try Again button:");
             // payment actions
             putTempNoFileWrite("refundPolicyAction", "com.trinity.ea.actions.RefundPolicyAction");   
             putTempNoFileWrite("buyNowAction", "com.trinity.ea.actions.BuyNowAction");
             putTempNoFileWrite("buyNowActionType", "1");
             putTempNoFileWrite("paymentReceiptFinishedAction", "com.trinity.ea.actions.RegistrationCompleteFinishedAction");
             putTempNoFileWrite("paymentReceiptFailedRetryAction", "com.trinity.ea.actions.BuyNowAction");
             putTempNoFileWrite("orderIDGeneratorAction", "com.trinity.ea.actions.OrderIDGeneratorAction");
             putTempNoFileWrite("unknownHostExceptionAction", "com.trinity.ea.actions.UnknownHostExceptionAction");
             putTempNoFileWrite("socketExceptionAction", "com.trinity.ea.actions.SocketExceptionAction");
             //payment html form input values
             putTempNoFileWrite("inputNameFirstName", "");
             putTempNoFileWrite("inputNameLastName", "");
             putTempNoFileWrite("inputNameAddress", "");
             putTempNoFileWrite("inputNameCity", "");
             putTempNoFileWrite("inputNameState", "");
             putTempNoFileWrite("inputNameZip", "");
             putTempNoFileWrite("inputNameCountry", "");
             putTempNoFileWrite("inputNameEMail", "");
             putTempNoFileWrite("inputNamePaymentMethod", "");
             putTempNoFileWrite("inputNameCC1", "");
             putTempNoFileWrite("inputNameCC2", "");
             putTempNoFileWrite("inputNameCC3", "");
             putTempNoFileWrite("inputNameCC4", "");
             putTempNoFileWrite("inputNameVerificationCode", "");
             putTempNoFileWrite("inputNameExpirationMonth", "");
             putTempNoFileWrite("inputNameExpirationYear", "");
             putTempNoFileWrite("inputNameMerchant", "");
             putTempNoFileWrite("inputNameOrderID", "");
             putTempNoFileWrite("inputNameNameOnCard", "");
             putTempNoFileWrite("inputNameResponseURL", "");
             putTempNoFileWrite("inputNameTotal", "");
             //payment response html form input values
             putTempNoFileWrite("paymentInputHiddenNames", "");
             putTempNoFileWrite("paymentInputHiddenValues", "");
             putTempNoFileWrite("respInputAuthResponse", "");
             putTempNoFileWrite("respInputEmail", "");
             putTempNoFileWrite("respInputTotal", "");
             putTempNoFileWrite("respInputOrderID", "");
             putTempNoFileWrite("respInputNameonCard", "");
             putTempNoFileWrite("respInputCardStreet", "");
             putTempNoFileWrite("respInputCardCity", "");
             putTempNoFileWrite("respInputCardState", "");
             putTempNoFileWrite("respInputCardZip", "");
             putTempNoFileWrite("respInputCardCountry", "");
             putTempNoFileWrite("respInputCardnumber", "");
             putTempNoFileWrite("respInputCardName", "");
             putTempNoFileWrite("formActionURL", "");
             putTempNoFileWrite("formRequestMethod", "POST");
             //payment processing product configuration
             putTempNoFileWrite("product_price", "0.00"); 
             putTempNoFileWrite("paymentMethods", "Visa,Mastercard,Discover,American Express");
             putTempNoFileWrite("paymentAttempts", "0");
             putTempNoFileWrite("maxPaymentAttempts", "7");
             putTempNoFileWrite("paymentCCVerificationCodeEnabled", "false");            
             putTempNoFileWrite("merchantValue", "");
             putTempNoFileWrite("responseURLValue", "");
             putTempNoFileWrite("orderIDLeadingID", "777");
             putTempNoFileWrite("secondaryPaymentMethod", "");
             putTempNoFileWrite("secondaryPaymentMethodEnabled", "false");
             putTempNoFileWrite("buyNowExpires","-1");   
             //payment processing updated or added later
             putTempNoFileWrite("paymentFailureRetryButtonText", "Try Again");
             putTempNoFileWrite("paymentFailureRetryButtonMnemonic", "T");
             putTempNoFileWrite("paymentSuccessFinishButtonText", "Finish");
             putTempNoFileWrite("paymentSuccessFinishButtonMnemonic", "F");
             putTempNoFileWrite("paymentSuccessResponsePanelMessage", "A copy of your receipt was sent to your E-mail Address.\\r\\nFor any questions concerning your purchase, please E-mail our Customer Support Team at PRODUCT_PURCHASE_SUPPORT_EMAIL.\\r\\n\\r\\nYou should contact PRODUCT_PURCHASE_SUPPORT_EMAIL if you need assistance. Generally we will reply within 24 hours. \\r\\n\\r\\nThank you for supporting PRODUCT_VENDOR_NAME!");
             putTempNoFileWrite("paymentGenericAuthResponseSuccessMsg", "Transaction Authorization Success");
             putTempNoFileWrite("paymentGenericAuthResponseFailureMsg", "Transaction Authorization Failure");
             // Additional Payment Processing variables
             putTempNoFileWrite("paymentBackgroundColor", "");  
             putTempNoFileWrite("paymentButtonFont", ""); 
             putTempNoFileWrite("paymentButtonTextColor", "");
             putTempNoFileWrite("paymentFormLeftTopImagePath", "/images/logomed.png");   
             putTempNoFileWrite("paymentFormRightTopImagePath", "/images/ssl.png");     
             putTempNoFileWrite("paymentFormInputBackgroundImagePath", "/images/frame.png"); 
             putTempNoFileWrite("paymentFormProductLabelImageEnabled", "false");         
             putTempNoFileWrite("paymentPriceLabel", "Price: $PRODUCT_PRICE (Price in USD)");                
             

             putTempNoFileWrite("refundPolicyLinkTextColor","38,54,69");   
             putTempNoFileWrite("paymentLabelTextColor","38,54,69");  
             putTempNoFileWrite("paymentLabelTextFont","Helvetica,0,13");  
             putTempNoFileWrite("refundPolicyActionType","1");  
             try
             {
                putTempNoFileWrite("paymentImgSecondaryButtonFace", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/paysecondmethodpanelbtn.png").toString());
                putTempNoFileWrite("paymentImgSecondaryButtonFaceOnClick", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/paysecondmethodpanelbtn.png").toString());
                putTempNoFileWrite("paymentImgSecondaryButtonFaceInFocus", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/paysecondmethodpanelbtn.png").toString());
             }
             catch(Exception e){}
             putTempNoFileWrite("paymentImgSecondaryButtonWidth","536"); 
             putTempNoFileWrite("paymentImgSecondaryButtonHeight","34");  
             putTempNoFileWrite("paymentImgSecondaryBackgroundColor", ""); 
             putTempNoFileWrite("paymentImgSecondaryButtonBackgroundColor", ""); 
             putTempNoFileWrite("secondaryPaymentMethodType","0");       
             putTempNoFileWrite("secondaryPaymentMethodClosePaymentWindowOnClick","true");               
             putTempNoFileWrite("secondaryPaymentMethodTextColor", ""); 
             putTempNoFileWrite("secondaryPaymentMethodButtonFont", "Helvetica,0,12"); 
             putTempNoFileWrite("secondaryPaymentMethodButtonText","");       
             putTempNoFileWrite("secondaryPaymentMethodButtonMnemonic","");   
             putTempNoFileWrite("paymentFormLeftTopImageWidth","94");       
             putTempNoFileWrite("paymentLabelHeaderTextFont","Helvetica,0,13");   
             putTempNoFileWrite("paymentLabelHeaderProductNameTextFont","Arial,0,20");              
             putTempNoFileWrite("paymentLabelHeaderTextColor","");   
             putTempNoFileWrite("paymentLabelHeaderProductNameTextColor","");     
             // Single Credit Card HTML Form Input is true, 4 is false
             putTempNoFileWrite("paymentCCIsSingleInputEnabled","true");
             // Separate First and Last Name Inputs Enabled
             putTempNoFileWrite("paymentSeparateFirstAndLastNameInputsEnabled","true");
             // Full Name Input Enabled - Both Separate Names, and Full Name inputs can be enabled on a transaction.             
             putTempNoFileWrite("paymentFullNameInputEnabled","true");
             // Payment phone html input enabled 
             putTempNoFileWrite("paymentPhoneInputEnabled","false");
             // Phone HTML Form Input 
             putTempNoFileWrite("inputNamePhone","");         
             // Payment Response Success
             putTempNoFileWrite("paymentResponseInputStatusSuccess","");  
             // Additional Refund Policy Variables should be appended to the Designer  
             putTempNoFileWrite("refundPolicyTitle","Refund Policy");      
             putTempNoFileWrite("refundPolicy", "PRODUCT_VENDOR_NAME provides trial editions of our software, therefore we do not offer a returns policy.");             
             putTempNoFileWrite("refundPolicyOKBtnText","OK");  
             putTempNoFileWrite("refundPolicyOKBtnMnemonic","O");
             putTempNoFileWrite("refundPolicyTextBackgroundColor","255,255,255");             
             putTempNoFileWrite("refundPolicyTextFont","Arial,0,12");
             putTempNoFileWrite("refundPolicyDialogSize","485,197");  
             putTempNoFileWrite("refundPolicyBackgroundColor", "");    
             putTempNoFileWrite("refundPolicyButtonTextColor", ""); 
             putTempNoFileWrite("refundPolicyTextColor", "");               
             putTempNoFileWrite("paymentSSLEnabledText", "SSL Enabled");   

             // automatic update gui actions
             putTempNoFileWrite("autoUpdateInstallAction", "com.trinity.ea.autoupdate.actions.InstallUpdateAction");
             putTempNoFileWrite("autoUpdateSkipAction", "com.trinity.ea.actions.LaunchApplicationSkipAction");
              
             // automatic update client variables
             putTempNoFileWrite("autoUpdateEnabled", "true");
             putTempNoFileWrite("autoUpdateX500Principal", ""); 
             putTempNoFileWrite("autoUpdateX509Certificate", ""); 
             putTempNoFileWrite("autoUpdateX509CertificateEnabled", "false");              
             putTempNoFileWrite("autoUpdatePwdSeed", PasswordGenerator.generate(24));
             putTempNoFileWrite("autoUpdatePwdCount", String.valueOf(getRandomInt(999)));
             putTempNoFileWrite("autoUpdateShoeHandler", "com.trinity.ea.rules.reader.RuleHandlerShoe");
             putTempNoFileWrite("autoUpdateLoadInstallUIAction", "com.trinity.ea.autoupdate.messaging.MessageDialog");
             putTempNoFileWrite("autoUpdateLoadCheckForUpdatesUIAction", "");
             putTempNoFileWrite("autoUpdateBaseURLChangesAllowed", "true");
             putTempNoFileWrite("autoUpdateBaseURL", ""); 
             putTempNoFileWrite("autoUpdateUpdateInProgress", "false");
             putTempNoFileWrite("autoUpdateLastCheckedTimestamp", "0");
             putTempNoFileWrite("autoUpdateUpdateID", "0");
             putTempNoFileWrite("autoUpdateFileName", "update.eal");
             putTempNoFileWrite("autoUpdateTempFileName", "update.eal");
             putTempNoFileWrite("autoUpdateMaxBaseURLs", "3");  
             putTempNoFileWrite("autoUpdateAllowNotifyServerOnUpdateSuccess", "false");
             putTempNoFileWrite("autoUpdateAllowExecuteActions", "false");    
             putTempNoFileWrite("autoUpdateExpirationEnabled", "false");   
             putTempNoFileWrite("autoUpdateAllowSilent", "true");  
             
             // Automatic Update Platform variables
             putTempNoFileWrite("autoUpdateRootDir", ",,,");
             putTempNoFileWrite("autoUpdateRootDirSystemPropertyEnabled", "false,false,false,false");
             putTempNoFileWrite("/$ROOT_DIR/$",",,,");
             putTempNoFileWrite("autoUpdateDownloadDir", "data/downloads,data/downloads,data/downloads,data/downloads");
             putTempNoFileWrite("autoUpdateDownloadDirSystemPropertyEnabled", "false,false,false,false");
             putTempNoFileWrite("/$DOWNLOAD_DIR/$",",,,");
             putTempNoFileWrite("autoUpdateWorkDir", "data/work,data/work,data/work,data/work");
             putTempNoFileWrite("autoUpdateWorkDirSystemPropertyEnabled", "false,false,false,false");
             putTempNoFileWrite("/$WORK_DIR/$",",,,");
             putTempNoFileWrite("autoUpdateMillasecondsToExpire", "648000000");  
  
             // common automatic update and messaging window gui variables 
             putTempNoFileWrite("autoUpdateImgBackgroundColor", "");
             putTempNoFileWrite("msgbgclr", "");
             putTempNoFileWrite("msgtextbgclr", "");
             putTempNoFileWrite("msgbtnfontclr", "");             
             putTempNoFileWrite("msgBGImgPath", "/images/msgbg.png");
             putTempNoFileWrite("msgHeaderImgPath", "/images/eatm.png");             
             
             // System Properties 
             putTempNoFileWrite("/$USER_HOME_DIR/$","user.home");
             /*
             putTempNoFileWrite("winCustomDirs","");     
             putTempNoFileWrite("osxCustomDirs",""); 
             putTempNoFileWrite("unixCustomDirs","");     
             putTempNoFileWrite("javaCustomDirs","");                
             putTempNoFileWrite("CustomDirKeys","");
             putTempNoFileWrite("CustomDirValues","");      
             */
             putTempNoFileWrite("msgEnabled","true"); 
             putTempNoFileWrite("msgX500Principal", ""); 
             putTempNoFileWrite("msgX509Certificate", ""); 
             putTempNoFileWrite("msgX509CertificateEnabled", "false");                   
             putTempNoFileWrite("msgBaseURLChangesAllowed","true");            
             putTempNoFileWrite("msgPwdCount",String.valueOf(getRandomInt(999)));
             putTempNoFileWrite("msgPwdSeed",PasswordGenerator.generate(24));
             putTempNoFileWrite("msgShoeHandler","com.trinity.ea.rules.reader.RuleHandlerMessageShoe");
             putTempNoFileWrite("msgUpdateID","0");
             putTempNoFileWrite("msgDisplayMessageUIAction","com.trinity.ea.messaging.ui.swing.MessageDialog");
             putTempNoFileWrite("msgCustomMessageUIAction","");
             putTempNoFileWrite("msgFinishedUIAction",""); 
             putTempNoFileWrite("msgLastCheckedTimestamp","0");
             putTempNoFileWrite("msgBaseURL","");
             putTempNoFileWrite("msgMaxBaseURLs","3");
             putTempNoFileWrite("msgAllowExecuteActionsOnCustomMessages","false");
             putTempNoFileWrite("msgAllowNotifyServerOnMessageReceivedStatus","false");
             
             // Internationalization Support
             putTempNoFileWrite("i18nEnabled", "false");
             putTempNoFileWrite("i18nBiDiEnabled", "false");                
 
             // Startup User Interface
             putTempNoFileWrite("LAndFPackage", "javax.swing.plaf.metal.MetalLookAndFeel");
             putTempNoFileWrite("startWindowTitle", "PRODUCT_NAME - Software Evaluation");
             putTempNoFileWrite("infoAction", "com.trinity.ea.actions.InformationDialogAction");
             putTempNoFileWrite("infoActionType", "1");
             putTempNoFileWrite("btnBarImgBtnEnabled", "true");
             putTempNoFileWrite("btnBarImgActionType", "-1");
             putTempNoFileWrite("btnBarImgStretchToFitEnabled", "false");    
             putTempNoFileWrite("btnBarImgAlignTopEnabled", "false");             
             putTempNoFileWrite("btnBarImgBGColor", "");
             putTempNoFileWrite("btnBarImgButtonsEnabled", "false"); 
             try
             {
                 putTempNoFileWrite("btnBarImgButtonFace", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/btn.png").toString());
                 putTempNoFileWrite("btnBarImgButtonFaceOnClick", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/btnclick.png").toString());
                 putTempNoFileWrite("buttonFaceImageInFocus", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/btnfocus.png").toString());
             }
             catch(Exception e){}
             putTempNoFileWrite("startWindowPanelSeparatorHighlightBorderColor", "89,151,100"); 
             putTempNoFileWrite("startWindowPanelSeparatorShadowBorderColor", "208,227,211"); 
             putTempNoFileWrite("btnBarImgButtonWidth", "94"); 
             putTempNoFileWrite("btnBarImgButtonHeight", "31");
             putTempNoFileWrite("btnBarHeightPadding", "20");             
             putTempNoFileWrite("btnBarButtonBGColor", "");
             putTempNoFileWrite("btnBarImgOverideDefaultPanelSize", "false");
             putTempNoFileWrite("btnBarImgOveridePanelWidth", "");
             putTempNoFileWrite("btnBarImgOveridePanelHeight", "");
             putTempNoFileWrite("btnBarTextColor", "");
             putTempNoFileWrite("btnBarBGColor", "");
             putTempNoFileWrite("btnBarTextFont", ""); 
             putTempNoFileWrite("btnBarUseEvalButtonEnabled", "true");
             putTempNoFileWrite("btnBarBuyNowButtonEnabled", "true");
             putTempNoFileWrite("btnBarRegButtonEnabled", "true");
             putTempNoFileWrite("btnBarInfoButtonEnabled", "true");
             putTempNoFileWrite("btnBarExitButtonEnabled", "true");
             putTempNoFileWrite("btnBarUseEvalButtonText", "Try");
             putTempNoFileWrite("btnBarBuyNowButtonText", "Buy Now");
             putTempNoFileWrite("btnBarRegButtonText", "Activate");
             putTempNoFileWrite("btnBarInfoButtonText", "Information");
             putTempNoFileWrite("btnBarExitButtonText", "Quit");
             putTempNoFileWrite("btnBarUseEvalButtonMnemonic", "T");
             putTempNoFileWrite("btnBarBuyNowButtonMnemonic", "B");
             putTempNoFileWrite("btnBarRegButtonMnemonic", "A");
             putTempNoFileWrite("btnBarInfoButtonMnemonic", "I");
             putTempNoFileWrite("btnBarExitButtonMnemonic", "Q");
             putTempNoFileWrite("buyNowActionType", "1");
             putTempNoFileWrite("enterRegistrationCodeActionType", "1");
             putTempNoFileWrite("useEvaluationActionType", "1");
             putTempNoFileWrite("imageMissingText", "Image goes here");

             //common image button variables
             try
             {
                 putTempNoFileWrite("paymentImgCancelButtonFace", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/btn.png").toString());
                 putTempNoFileWrite("paymentImgCancelButtonFaceOnClick", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/btnclick.png").toString());
                 putTempNoFileWrite("paymentImgCancelButtonFaceInFocus", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/btnfocus.png").toString());
             }
             catch(Exception e){}             
             putTempNoFileWrite("paymentImgCancelButtonWidth","94");
             putTempNoFileWrite("paymentImgCancelButtonHeight","31");
             try
             {
                 putTempNoFileWrite("paymentImgContinueButtonFace", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/paybtncontinue.png").toString());
                 putTempNoFileWrite("paymentImgContinueButtonFaceOnClick", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/paybtncontinueclick.png").toString());
                 putTempNoFileWrite("paymentImgContinueButtonFaceInFocus", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/paybtncontinue.png").toString());
             }
             catch(Exception e){}             
             putTempNoFileWrite("paymentImgContinueButtonWidth","123"); 
             putTempNoFileWrite("paymentImgContinueButtonHeight","31");   
             
             // common gui scrollbar component variables
             putTempNoFileWrite("customScrollBarsEnabled", "false");      
             putTempNoFileWrite("sbBGArrowBtnColor", "38,54,69");
             putTempNoFileWrite("sbShadowArrowBtnColor", "38,54,69");          
             putTempNoFileWrite("sbDarkShadowArrowBtnColor", "255,255,255");
             putTempNoFileWrite("sbLtHighlightArrowBtnColor", "38,54,69");
             putTempNoFileWrite("sbTrackColor", "222,226,226");
             putTempNoFileWrite("sbTrackHighlightColor", "222,226,226");
             putTempNoFileWrite("sbThumbImagePath", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/thumb.png").toString());             
             putTempNoFileWrite("sbMsgThumbImagePath", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/mthumb.png").toString());
             putTempNoFileWrite("sbBackgroundColor", "119,151,172");
             putTempNoFileWrite("sbForegroundColor", "255,255,255"); 
             
//

             putTempNoFileWrite("splashImgBGColor", "");
             putTempNoFileWrite("splashImgOverideDefaultPanelSize", "false");
             putTempNoFileWrite("splashImgOveridePanelWidth", "");
             putTempNoFileWrite("splashImgOveridePanelHeight", "");
//
             putTempNoFileWrite("splashImageSize", "512,318");
             putTempNoFileWrite("splashImgPath", "");
             putTempNoFileWrite("btnBarImgAction", "");
             putTempNoFileWrite("btnBarImgPath", ""); 
             putTempNoFileWrite("progressPanelImgPath", "");
//
             putTempNoFileWrite("progressPanelImgActionType", "-1");
             putTempNoFileWrite("progressPanelImgAction", "");
             putTempNoFileWrite("progressPanelImgBGColor", "0,0,0");
             putTempNoFileWrite("progressPanelImgOverideDefaultPanelSize", "false");
             putTempNoFileWrite("progressPanelImgOveridePanelWidth", "");
             putTempNoFileWrite("progressPanelImgOveridePanelHeight", "");
             putTempNoFileWrite("progressPanelImgStretchToFitEnabled", "false"); 
//
             putTempNoFileWrite("isProgressBarEnabled", "true");
             putTempNoFileWrite("progressPanelTextColor", "255,255,255");
             putTempNoFileWrite("progressBarBGColor", "0,0,0");
             putTempNoFileWrite("progressBarColor", "");
             putTempNoFileWrite("progressBarHighlightBorderColor", "125,125,125");
             putTempNoFileWrite("progressBarShadowBorderColor", "255,255,255");
             putTempNoFileWrite("progressBarCellSpacing", "0");
             putTempNoFileWrite("progressPanelImgEnabled", "true");
             putTempNoFileWrite("progressPanelLeftBorderColor", "162,200,169");
             putTempNoFileWrite("progressPanelTextFont", "Arial,1,12");
             putTempNoFileWrite("progressBarDaysLeftText", "days_left days remaining");
             putTempNoFileWrite("progressBarExpiredText", "Trial Expired");
              
             // Information Dialog
             putTempNoFileWrite("informationOKBtnText","OK");  
             putTempNoFileWrite("informationOKBtnMnemonic","O");
             putTempNoFileWrite("informationText","Product Information goes here...");
             putTempNoFileWrite("informationTextTitle","About PRODUCT_NAME");
             putTempNoFileWrite("informationTextBackgroundColor","255,255,255");             
             putTempNoFileWrite("informationTextFont","Arial,0,12");
             putTempNoFileWrite("informationDialogSize","500,317");
             
// i18n Messages Bundle name (for internationalization)
             putTempNoFileWrite("i18nBundleName", "MessagesBundle");                
// Project GUI Model Variables       
             //project_gui_model - 0 = Vertical Button Bar Window, 1 = Horizontal Button Bar Window, 2 = Not Assigned Yet
             putTempNoFileWrite("project_gui_model", "0");   

// Additional Registration Strings
             putTempNoFileWrite("informationBackgroundColor", "");    
             putTempNoFileWrite("informationButtonTextColor", ""); 
             putTempNoFileWrite("informationTextColor", "");
             
             // Locale based Vars
             if(DesignerRuleBuilder.get("prjLocalesEnabled")!=null)
             {
                 if(DesignerRuleBuilder.get("prjLocalesEnabled").equalsIgnoreCase("true")==true)
                 {
                     putTempNoFileWrite("prjlocales", "en,ca_ES,es");
                     putTempNoFileWrite("prjlocalesnames", "English,Catalan,Spanish");                     
                     putTempNoFileWrite("prjbuildlocales", "en");
                     putTempNoFileWrite("prjdefaultlocale", "en");
                 }
                 else
                 {
                     putTempNoFileWrite("prjlocales", "en,ca_ES,es");
                     putTempNoFileWrite("prjlocalesnames", "English,Catalan,Spanish");                    
                     putTempNoFileWrite("prjbuildlocales", "en");
                     putTempNoFileWrite("prjdefaultlocale", "en");
                 }
             }
             else
             {
                 putTempNoFileWrite("prjlocales", "en,ca_ES,es");
                 putTempNoFileWrite("prjlocalesnames", "English,Catalan,Spanish");                    
                 putTempNoFileWrite("prjbuildlocales", "en");
                 putTempNoFileWrite("prjdefaultlocale", "en");             
             }
             putTempNoFileWrite("paymentImgBackgroundColor", "233,235,234");
             putTempNoFileWrite("paymentFormLeftTopImageHeight", "94");
             putTempNoFileWrite("paymentResponseStatTotalMessages", "0");
             putTempNoFileWrite("msgokbtnbgclr", "");
             putTempNoFileWrite("paymentValidateBtnBGColor", "");
             putTempNoFileWrite("paymentSuccessLabelBGColor", "");
             putTempNoFileWrite("paymentSuccessLabelFont", "Helvetica,0,12");
             putTempNoFileWrite("paymentSuccessHeaderLabelFont", "Helvetica,0,14"); 
             putTempNoFileWrite("paymentFailureLabelBGColor", "");     
             putTempNoFileWrite("paymentFailureLabelFont", "Helvetica,0,12");
             putTempNoFileWrite("paymentFailureHeaderLabelFont", "Helvetica,0,14");
             putTempNoFileWrite("paymentSuccessLabelHeaderTextFont", "Helvetica,0,12");
             putTempNoFileWrite("paymentFailureLabelHeaderTextFont", "Helvetica,0,12");
             putTempNoFileWrite("paymentSuccessLabelHeaderTextColor", "38,54,69");  
             putTempNoFileWrite("paymentFailureLabelHeaderTextColor", "38,54,69");
             putTempNoFileWrite("launchApplicationNoUpdateAction", "com.trinity.ea.actions.LaunchApplicationNoUpdateAction");
             putTempNoFileWrite("autoUpdateRunDirSystemPropertyEnabled", "false,false,false,false");
             putTempNoFileWrite("autoUpdateRunDir", "data/run,data/run,data/run,data/run");
             putTempNoFileWrite("/$RUN_DIR/$", ",,,");
             putTempNoFileWrite("rootJar", "eademo.jar");
             putTempNoFileWrite("autoUpdateCP", "");        
             // autoUpdateRunDirUpdateNeeded Must be set to true for first time it is run
             putTempNoFileWrite("autoUpdateRunDirUpdateNeeded", "true");
             putTempNoFileWrite("autoUpdateErrorAction", "com.trinity.ea.autoupdate.actions.ErrorMessageAction");
             putTempNoFileWrite("autoUpdateWillNotCompleteAction", "com.trinity.ea.autoupdate.actions.WillNotCompleteAction");
             putTempNoFileWrite("autoUpdateMaxAttempts", "0");
             putTempNoFileWrite("lastUpdateStatus", "0");
 
             putTempNoFileWrite("errImgBackgroundColor", "");
             putTempNoFileWrite("errbgclr", "");      
             putTempNoFileWrite("errtextbgclr", "");  
             putTempNoFileWrite("errHeaderImgPath", "/images/eatm.png");
             putTempNoFileWrite("errBGImgPath", "");
             putTempNoFileWrite("errbtnfontclr", "");
             
             putTempNoFileWrite("errbtnfont", "Helvetica,0,11");
             putTempNoFileWrite("errfontclr", "");      
             putTempNoFileWrite("errfont", "Helvetica,0,13");  
             putTempNoFileWrite("registrationRestartAtReg", "false");
             putTempNoFileWrite("paymentPOSTGETRespEnabled", "false");
             putTempNoFileWrite("paymentCancelButtonMnemonic", "a");
             putTempNoFileWrite("paymentContinueButtonMnemonic", "C");
             putTempNoFileWrite("optinPrivacyPolicyMnemonic", "P");      
             putTempNoFileWrite("paymentPhoneLabel", "Telephone");
             putTempNoFileWrite("autoUpdateErrorMessage", "Please contact a support representative. The Automatic Software Update cannot continue.");                  
             putTempNoFileWrite("autoUpdateNotAbleToComplete", "The automatic software update could not be performed on this computer. Please contact a support representative for other update options.");  
             putTempNoFileWrite("errokbtn", "OK");
             putTempNoFileWrite("errokbtnmnem", "O");
             putTempNoFileWrite("autoUpdateErrorTitle", "Software Update");
             putTempNoFileWrite("errMsgTitle", "Error");
             putTempNoFileWrite("infoMsgTitle", "Information");   
             putTempNoFileWrite("msgMsgTitle", "Message");  
             putTempNoFileWrite("evalLockdown", "This software was locked down due to multiple invalid registration code entries. Purchase now to register.");
             putTempNoFileWrite("socketException", "Internet connection was lost. Please reconnect, and try again.");
             putTempNoFileWrite("unknownHostException", "Could not connect to the internet.");

             // Last Messaging Message ID Number Built
             putTempNoFileWrite("project_lastMessageIDNumber", "1");  
             // Default Messaging Message variables (for Message Builder)
             putTempNoFileWrite("project_default_msgType", "0");         
             putTempNoFileWrite("project_default_baseurlchange", "false");
             putTempNoFileWrite("project_default_msgtitle", "System Message"); 
             putTempNoFileWrite("project_default_msgtext", "\\r\\n\\r\\nMessage for English Localization");
             putTempNoFileWrite("project_default_msgfont", "Helvetica,0,13"); 
             putTempNoFileWrite("project_default_msgbtnfont", "Helvetica,0,11"); 
             putTempNoFileWrite("project_default_msgfontclr", "");
             putTempNoFileWrite("project_default_msgbtnfontclr", "");
             putTempNoFileWrite("project_default_msgokbtn", "OK"); 
             putTempNoFileWrite("project_default_msgokbtnmnem", "O"); 
             putTempNoFileWrite("project_default_msgtextalgn", "1");  
             putTempNoFileWrite("project_default_msg_langs", "");  
              
             // Last Automatic Update ID Number Built
             putTempNoFileWrite("project_lastUpdateIDNumber", "1");  
              // Default Automatic Update Message variables (for Message Builder)
             putTempNoFileWrite("project_default_update_msgType", "0");         
             putTempNoFileWrite("project_default_update_baseurlchange", "false");
             putTempNoFileWrite("project_default_update_msgtitle", "Software Update"); 
             putTempNoFileWrite("project_default_update_msgtext", "Software updates were downloaded, and are ready to install. Click the OK button and automatically upgrade to the newest version of your software. Click the Skip button if you do not want to upgrade this program with the newest, most stable version available at this time.");
             putTempNoFileWrite("project_default_update_msgsupport", "Please contact a support representative. The Automatic Software Update cannot continue.");
             putTempNoFileWrite("project_default_update_msgerror", "Please contact a support representative. The Automatic Software Update cannot continue.");
             putTempNoFileWrite("project_default_update_msgfont", "Helvetica,0,12"); 
             putTempNoFileWrite("project_default_update_msgbtnfont", "Helvetica,0,11"); 
             putTempNoFileWrite("project_default_update_msgfontclr", "");
             putTempNoFileWrite("project_default_update_msgbtnfontclr", "");
             putTempNoFileWrite("project_default_update_msgokbtn", "OK"); 
             putTempNoFileWrite("project_default_update_msgokbtnmnem", "O"); 
             putTempNoFileWrite("project_default_update_msgskipbtn", "Skip"); 
             putTempNoFileWrite("project_default_update_msgskipbtnmnem", "S"); 
             putTempNoFileWrite("project_default_update_msgtextalgn", "0");  
             putTempNoFileWrite("project_default_update_langs", "");

             putTempNoFileWrite("project_default_update_silent", "false");
             putTempNoFileWrite("project_default_update_lazyUpdate", "true");
             putTempNoFileWrite("project_default_update_msgmaxattempts", "1");
             // Automatic Update File Updates
             putTempNoFileWrite("project_default_update_copyfilesto", "");
             putTempNoFileWrite("project_default_update_files", "");
             putTempNoFileWrite("project_default_update_overwriteexistingfiles", "");

             // **             
             saveTempNow();             
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static synchronized void setEAProjectLookAndFeelDefaults()
    {
        try 
        {
            // project look and feel properties
    
            // registration GUI Variables
            putTempNoFileWrite("registrationTextColor", "255,255,255"); 
            putTempNoFileWrite("registrationBackgroundColor", "119,151,172");   
            
   //marker         
             
            putTempNoFileWrite("registrationDescriptionFont","Arial,0,11");              
            putTempNoFileWrite("registrationCodeLabelFont", "Arial,0,13");
            putTempNoFileWrite("registrationButtonFont", "Arial,0,11");             
            // registration UI Variables
            putTempNoFileWrite("registrationCodeLabelFontMnemonic", "t");
            putTempNoFileWrite("registrationCancelButtonMnemonic","C"); 
            putTempNoFileWrite("registrationFinishButtonMnemonic","A");  
            putTempNoFileWrite("registrationFailureOKMnemonic", "O");    
            putTempNoFileWrite("registrationSuccessOKMnemonic", "D");  
            // Image Button (Portions used in this code are located in the Startup Window Button Bar variables)
            try
            {
                putTempNoFileWrite("registrationImgButtonFace", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/btn.png").toString());
                putTempNoFileWrite("registrationImgButtonFaceOnClick", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/btnclick.png").toString());
                putTempNoFileWrite("registrationButtonFaceInFocus", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/btnfocus.png").toString());
            }
            catch(Exception e){}            
            // Custom Border
            putTempNoFileWrite("registrationCustomBorderEnabled","true");
            putTempNoFileWrite("registrationTFExtBorderColor", "162,186,202");  
            putTempNoFileWrite("registrationTFHighlightBorderColor1", "38,54,69");  
            putTempNoFileWrite("registrationTFHighlightBorderColor2", "100,132,154");  
            putTempNoFileWrite("registrationTFShadowBorderColor1", "162,182,202");    
            putTempNoFileWrite("registrationTFShadowBorderColor2", "215,226,233");    

// Additional Privacy Policy Variables should be appended to the Designer             
             putTempNoFileWrite("privacyPolicyOKBtnMnemonic","O");
             putTempNoFileWrite("privacyPolicyTextBackgroundColor","255,255,255");             
             putTempNoFileWrite("privacyPolicyTextFont","Arial,0,11");
             putTempNoFileWrite("privacyPolicyDialogSize","485,310");
             putTempNoFileWrite("privacyPolicyBackgroundColor", "119,151,172");    
             putTempNoFileWrite("privacyPolicyButtonTextColor", "255,255,255"); 
             putTempNoFileWrite("privacyPolicyTextColor", "71,71,71");                    
           
// Additional Opt-In Window Variables
             putTempNoFileWrite("optinCancelButtonMnemonic","a");
             putTempNoFileWrite("optinContinueButtonMnemonic","C");
             putTempNoFileWrite("optinDescriptionFont","Arial,0,11");
             putTempNoFileWrite("optinButtonFont","Helvetica,0,11");
             putTempNoFileWrite("optinPrivacyPolicyFont","Arial,0,12");
             putTempNoFileWrite("optinPrivacyPolicyTextColor","255,255,255");
             putTempNoFileWrite("optinNameEMailFont","Arial,0,13");
             putTempNoFileWrite("optinTextFieldFont","Arial,0,12");

             // Additional Optin Processing Variables          
             putTempNoFileWrite("optinBackgroundColor", "119,151,172"); 
             putTempNoFileWrite("optinButtonTextColor", "255,255,255");   
             putTempNoFileWrite("optinPrivacyPolicyMnemonic", "P");
             
             // payment success user interface strings
             putTempNoFileWrite("paymentFailureRetryButtonMnemonic", "T");
             putTempNoFileWrite("paymentSuccessFinishButtonMnemonic", "F");
             // Additional Payment Processing variables
             putTempNoFileWrite("paymentBackgroundColor", "119,151,172");  
             putTempNoFileWrite("paymentButtonFont", "Arial,0,11"); 
             putTempNoFileWrite("paymentButtonTextColor", "255,255,255");
             putTempNoFileWrite("paymentFormLeftTopImagePath", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/logomed.png").toString()); 
             putTempNoFileWrite("paymentFormRightTopImagePath", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/ssl.png").toString()); 
             putTempNoFileWrite("paymentFormInputBackgroundImagePath", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/frame.png").toString()); 
             putTempNoFileWrite("paymentFormProductLabelImageEnabled", "false");         
             putTempNoFileWrite("paymentPriceLabel", "Price: $PRODUCT_PRICE (Price in USD)");                

             putTempNoFileWrite("refundPolicyLinkTextColor","38,54,69");   
             putTempNoFileWrite("paymentLabelTextColor","38,54,69");  
             putTempNoFileWrite("paymentLabelTextFont","Helvetica,0,13");  
             putTempNoFileWrite("refundPolicyActionType","1");  
             try
             {
                putTempNoFileWrite("paymentImgSecondaryButtonFace", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/paysecondmethodpanelbtn.png").toString());
                putTempNoFileWrite("paymentImgSecondaryButtonFaceOnClick", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/paysecondmethodpanelbtn.png").toString());
                putTempNoFileWrite("paymentImgSecondaryButtonFaceInFocus", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/paysecondmethodpanelbtn.png").toString());
             }
             catch(Exception e){}
             putTempNoFileWrite("paymentLabelHeaderTextFont","Helvetica,0,13");   
             putTempNoFileWrite("paymentLabelHeaderProductNameTextFont","Helvetica,0,20");              
             putTempNoFileWrite("paymentLabelHeaderTextColor","38,54,69");   
             putTempNoFileWrite("paymentLabelHeaderProductNameTextColor","38,54,69");     
             putTempNoFileWrite("refundPolicyOKBtnMnemonic","O");
             putTempNoFileWrite("refundPolicyTextBackgroundColor","255,255,255");             
             putTempNoFileWrite("refundPolicyTextFont","Arial,0,12");
             putTempNoFileWrite("refundPolicyDialogSize","485,197");  
             putTempNoFileWrite("refundPolicyBackgroundColor", "119,151,172");    
             putTempNoFileWrite("refundPolicyButtonTextColor", "255,255,255"); 
             putTempNoFileWrite("refundPolicyTextColor", "71,71,71");               

             // automatic update client variables
 
             // common automatic update and messaging window gui variables 
             putTempNoFileWrite("autoUpdateImgBackgroundColor", "240,240,240");
             putTempNoFileWrite("msgbgclr", "119,151,172");
             putTempNoFileWrite("msgtextbgclr", "240,240,240");
             putTempNoFileWrite("msgbtnfontclr", "255,255,255");             
             putTempNoFileWrite("msgBGImgPath", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/msgbg.png").toString());
             putTempNoFileWrite("msgHeaderImgPath", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/eatm.png").toString());       

             putTempNoFileWrite("btnBarImgBtnEnabled", "true");
             putTempNoFileWrite("btnBarImgActionType", "-1");
             putTempNoFileWrite("btnBarImgAlignTopEnabled", "false");             
             putTempNoFileWrite("btnBarImgBGColor", "119,151,172");
             putTempNoFileWrite("btnBarImgButtonsEnabled", "true"); 
             try
             {
                 putTempNoFileWrite("btnBarImgButtonFace", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/btn.png").toString());
                 putTempNoFileWrite("btnBarImgButtonFaceOnClick", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/btnclick.png").toString());
                 putTempNoFileWrite("buttonFaceImageInFocus", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/btnfocus.png").toString());
             }
             catch(Exception e){}
             putTempNoFileWrite("startWindowPanelSeparatorHighlightBorderColor", "119,151,172"); 
             putTempNoFileWrite("startWindowPanelSeparatorShadowBorderColor", "119,151,172");  
             putTempNoFileWrite("btnBarButtonBGColor", "38,54,69");
             putTempNoFileWrite("btnBarImgOverideDefaultPanelSize", "false");
             putTempNoFileWrite("btnBarImgOveridePanelWidth", "");
             putTempNoFileWrite("btnBarImgOveridePanelHeight", "");
             putTempNoFileWrite("btnBarTextColor", "255,255,255");
             putTempNoFileWrite("btnBarBGColor", "119,151,172");
             putTempNoFileWrite("btnBarTextFont", "Helvetica,0,11"); 
             putTempNoFileWrite("btnBarUseEvalButtonEnabled", "true");
             putTempNoFileWrite("btnBarBuyNowButtonEnabled", "true");
             putTempNoFileWrite("btnBarRegButtonEnabled", "true");
             putTempNoFileWrite("btnBarInfoButtonEnabled", "false");
             putTempNoFileWrite("btnBarExitButtonEnabled", "true");
             putTempNoFileWrite("btnBarUseEvalButtonMnemonic", "T");
             putTempNoFileWrite("btnBarBuyNowButtonMnemonic", "B");
             putTempNoFileWrite("btnBarRegButtonMnemonic", "A");
             putTempNoFileWrite("btnBarInfoButtonMnemonic", "I");
             putTempNoFileWrite("btnBarExitButtonMnemonic", "Q");
             putTempNoFileWrite("buyNowActionType", "1");
             putTempNoFileWrite("enterRegistrationCodeActionType", "1");
             putTempNoFileWrite("useEvaluationActionType", "1");
             putTempNoFileWrite("imageMissingText", "Image goes here");

             //common image button variables
             try
             {
                 putTempNoFileWrite("paymentImgCancelButtonFace", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/btn.png").toString());
                 putTempNoFileWrite("paymentImgCancelButtonFaceOnClick", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/btnclick.png").toString());
                 putTempNoFileWrite("paymentImgCancelButtonFaceInFocus", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/btnfocus.png").toString());
             }
             catch(Exception e){}             
             putTempNoFileWrite("paymentImgCancelButtonWidth","94");
             putTempNoFileWrite("paymentImgCancelButtonHeight","31");
             try
             {
                 putTempNoFileWrite("paymentImgContinueButtonFace", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/paybtncontinue.png").toString());
                 putTempNoFileWrite("paymentImgContinueButtonFaceOnClick", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/paybtncontinueclick.png").toString());
                 putTempNoFileWrite("paymentImgContinueButtonFaceInFocus", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/paybtncontinue.png").toString());
             }
             catch(Exception e){}             
             putTempNoFileWrite("paymentImgContinueButtonWidth","123"); 
             putTempNoFileWrite("paymentImgContinueButtonHeight","31");   
             
             // common gui scrollbar component variables
             putTempNoFileWrite("customScrollBarsEnabled", "true");      
             putTempNoFileWrite("sbBGArrowBtnColor", "38,54,69");
             putTempNoFileWrite("sbShadowArrowBtnColor", "38,54,69");          
             putTempNoFileWrite("sbDarkShadowArrowBtnColor", "255,255,255");
             putTempNoFileWrite("sbLtHighlightArrowBtnColor", "38,54,69");
             putTempNoFileWrite("sbTrackColor", "222,226,226");
             putTempNoFileWrite("sbTrackHighlightColor", "222,226,226");
             putTempNoFileWrite("sbThumbImagePath", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/thumb.png").toString());             
             putTempNoFileWrite("sbMsgThumbImagePath", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/mthumb.png").toString());
             putTempNoFileWrite("sbBackgroundColor", "119,151,172");
             putTempNoFileWrite("sbForegroundColor", "255,255,255"); 
             
//

             putTempNoFileWrite("splashImgBGColor", "119,151,172");
             putTempNoFileWrite("splashImgOverideDefaultPanelSize", "false");
             putTempNoFileWrite("splashImgOveridePanelWidth", "");
             putTempNoFileWrite("splashImgOveridePanelHeight", "");
//
             putTempNoFileWrite("splashImageSize", "512,318");
             putTempNoFileWrite("splashImgPath", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/eafree_splash.png").toString());
             putTempNoFileWrite("btnBarImgAction", "");
             putTempNoFileWrite("btnBarImgPath", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/logo.png").toString());
             putTempNoFileWrite("progressPanelImgPath", "");
//
             putTempNoFileWrite("progressPanelImgActionType", "-1");
             putTempNoFileWrite("progressPanelImgAction", "");
             putTempNoFileWrite("progressPanelImgBGColor", "0,0,0");
             putTempNoFileWrite("progressPanelImgOverideDefaultPanelSize", "false");
             putTempNoFileWrite("progressPanelImgStretchToFitEnabled", "false"); 
//
             putTempNoFileWrite("isProgressBarEnabled", "true");
             putTempNoFileWrite("progressPanelTextColor", "255,255,255");
             putTempNoFileWrite("progressBarBGColor", "38,54,69");
             putTempNoFileWrite("progressBarColor", "119,151,172");
             putTempNoFileWrite("progressBarHighlightBorderColor", "255,255,255");
             putTempNoFileWrite("progressBarShadowBorderColor", "255,255,255");
             putTempNoFileWrite("progressBarCellSpacing", "0");
             putTempNoFileWrite("progressPanelImgEnabled", "false");
             putTempNoFileWrite("progressPanelLeftBorderColor", "255,255,255");
             putTempNoFileWrite("progressPanelTextFont", "Arial,1,12");
              
             // Information Dialog
             putTempNoFileWrite("informationOKBtnMnemonic","O");
             putTempNoFileWrite("informationTextBackgroundColor","255,255,255");             
             putTempNoFileWrite("informationTextFont","Arial,0,12");
             putTempNoFileWrite("informationDialogSize","500,317");
             
// Project GUI Model Variables       
             //project_gui_model - 0 = Vertical Button Bar Window, 1 = Horizontal Button Bar Window, 2 = Not Assigned Yet
             putTempNoFileWrite("project_gui_model", "0");   

// Additional Registration Strings
             putTempNoFileWrite("informationBackgroundColor", "119,151,172");    
             putTempNoFileWrite("informationButtonTextColor", "255,255,255"); 
             putTempNoFileWrite("informationTextColor", "71,71,71");
             
             putTempNoFileWrite("paymentImgBackgroundColor", "233,235,234");
             putTempNoFileWrite("paymentFormLeftTopImageHeight", "94");
             putTempNoFileWrite("msgokbtnbgclr", "240,240,240");
             putTempNoFileWrite("paymentValidateBtnBGColor", "119,151,172");
             putTempNoFileWrite("paymentSuccessLabelBGColor", "210,218,222");
             putTempNoFileWrite("paymentSuccessLabelFont", "Helvetica,0,12");
             putTempNoFileWrite("paymentSuccessHeaderLabelFont", "Helvetica,0,14"); 
             putTempNoFileWrite("paymentFailureLabelBGColor", "210,218,222");     
             putTempNoFileWrite("paymentFailureLabelFont", "Helvetica,0,12");
             putTempNoFileWrite("paymentFailureHeaderLabelFont", "Helvetica,0,14");
             putTempNoFileWrite("paymentSuccessLabelHeaderTextFont", "Helvetica,0,12");
             putTempNoFileWrite("paymentFailureLabelHeaderTextFont", "Helvetica,0,12");
             putTempNoFileWrite("paymentSuccessLabelHeaderTextColor", "38,54,69");  
             putTempNoFileWrite("paymentFailureLabelHeaderTextColor", "38,54,69");
             putTempNoFileWrite("paymentImgSecondaryButtonBackgroundColor", "119,151,172"); 
             putTempNoFileWrite("paymentImgSecondaryBackgroundColor", "119,151,172"); 
             putTempNoFileWrite("secondaryPaymentMethodButtonFont", "Helvetica,0,11"); 
             
             putTempNoFileWrite("errImgBackgroundColor", "240,240,240");
             putTempNoFileWrite("errbgclr", "119,151,172");      
             putTempNoFileWrite("errtextbgclr", "240,240,240");  
             putTempNoFileWrite("errHeaderImgPath", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/eatm.png").toString());
             putTempNoFileWrite("errBGImgPath", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/msgbg.png").toString());
             putTempNoFileWrite("errbtnfontclr", "240,240,240");
             
             putTempNoFileWrite("errbtnfont", "Helvetica,0,11");
             putTempNoFileWrite("errfontclr", "38,54,69");      
             putTempNoFileWrite("errfont", "Helvetica,0,13");  
             putTempNoFileWrite("paymentCancelButtonMnemonic", "a");
             putTempNoFileWrite("paymentContinueButtonMnemonic", "C");
             putTempNoFileWrite("optinPrivacyPolicyMnemonic", "P");      
             putTempNoFileWrite("paymentRespSuccessBackgroundImagePath", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/paysuccessbg.png").toString());
             putTempNoFileWrite("paymentRespFailureBackgroundImagePath", new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/payfailbg.png").toString());
             putTempNoFileWrite("errokbtnmnem", "O");

             putTempNoFileWrite("project_default_msgfont", "Helvetica,0,13"); 
             putTempNoFileWrite("project_default_msgbtnfont", "Helvetica,0,11"); 
             putTempNoFileWrite("project_default_msgfontclr", "38,54,69");
             putTempNoFileWrite("project_default_msgbtnfontclr", "255,255,255");
             putTempNoFileWrite("project_default_update_msgfont", "Helvetica,0,12"); 
             putTempNoFileWrite("project_default_update_msgbtnfont", "Helvetica,0,11"); 
             putTempNoFileWrite("project_default_update_msgfontclr", "38,54,69");
             putTempNoFileWrite("project_default_update_msgbtnfontclr", "255,255,255");

             // **             
             saveTempNow();             
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }    
    
    public static synchronized EAProperties getProjectProperties()
    {
         try
         {
            return theEncryptedProjectFile.getProperties();
         }
        catch(Exception e)
        {
            e.printStackTrace();  
            return null;
        }           
    }

    public static synchronized EAProperties getTemporaryProjectProperties()
    {
        try
        {
            return theTempFile.getProperties();
        }
        catch(Exception e)
        {
            e.printStackTrace();   
            return null;
        }            
    }    
}
