/*
 * EACompiler.java
 *
 * Created on May 27, 2004, 1:05 AM
 */

package com.trinity.ea.design.common.compiler;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.rules.builder.EncryptedRuleBuilder;
import com.trinity.ea.design.rules.builder.DesignerRuleBuilder;
import com.trinity.ea.design.common.file.ProjectFile;
import com.trinity.ea.design.common.util.ZipBuilder;
import com.trinity.ea.design.common.util.ManifestBuilder;
import com.trinity.ea.design.common.doc.ClientDocBuilder;
import com.trinity.ea.util.EAProperties;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004-2005 Trinity Software. All rights reserved.
 */
public class EACompiler 
{
    HashMap props;
    
    /** Creates a new instance of EACompiler */
    public EACompiler()  
    {
        try
        {
            try
            {
		EAProperties tempProps = ProjectManager.getTemporaryProjectProperties();
                Set theSet = tempProps.keySet();
                Object[] objArray1 = theSet.toArray();
                ArrayList theArrayList = new ArrayList();
                for(int i = 0;i<objArray1.length;i++)
                {
                    try
                    {
                        if(objArray1[i]!=null)
                        {
                            if(((String)objArray1[i]).equalsIgnoreCase("")==false)
                            {
                                theArrayList.add((String)objArray1[i]);
                            }
                        }
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                theArrayList.trimToSize();
                Object[] objArray2 = theArrayList.toArray();
                props = new HashMap(objArray2.length);
                for(int i = 0;i<objArray2.length;i++)
                {
                    try
                    {
                        if(objArray2[i]!=null)
                        {
                            if(((String)objArray2[i]).equalsIgnoreCase("")==false)
                            {
                                props.put((String)objArray2[i],tempProps.get((String)objArray2[i]));
                            }
                        }
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }               
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public int uiCompile(File BuildOutputDir)
    {
        try 
        {
            try
            {
                if(BuildOutputDir.exists()==false)
                {
                        if(BuildOutputDir.mkdirs()==false)
                        {
                                return 8;
                        }
                }
            }
            catch(Exception e)
            {
                    e.printStackTrace();
                    return 7;
            }
            try
            {
                updateUIExpressionDefines();
            }
            catch(Exception e)
            {
                return 6;
            }
            try
            {
                // project properties
                //props.remove("product_vendor_name");
                //props.remove("product_name");
                //props.remove("product_version");     
                props.remove("product_info_url");
                props.remove("product_url");
                props.remove("product_privacy_policy_email");           
                props.remove("product_copyright");            
                props.remove("project_build_dir_name");
                props.remove("project_build_dir");
                props.remove("message_build_dir");
                props.remove("update_build_dir");                
                props.remove("project_last_built");      
                props.remove("project_jarfile_name");           
                props.remove("project_jarfile2_name");
                props.remove("project_lastMessageIDNumber"); 
                props.remove("project_default_msgType");          
                props.remove("project_default_baseurlchange");
                props.remove("project_default_msgtitle"); 
                props.remove("project_default_msgtext");
                props.remove("project_default_msgfont"); 
                props.remove("project_default_msgbtnfont"); 
                props.remove("project_default_msgfontclr");
                props.remove("project_default_msgbtnfontclr");
                props.remove("project_default_msgokbtn"); 
                props.remove("project_default_msgokbtnmnem"); 
                props.remove("project_default_msgtextalgn");   
                props.remove("project_default_msg_langs");
                
                props.remove("project_lastUpdateIDNumber");                
                props.remove("project_default_update_msgType");         
                props.remove("project_default_update_baseurlchange");
                props.remove("project_default_update_msgtitle"); 
                props.remove("project_default_update_msgtext");
                props.remove("project_default_update_msgsupport");
                props.remove("project_default_update_msgerror");
                props.remove("project_default_update_msgfont"); 
                props.remove("project_default_update_msgbtnfont"); 
                props.remove("project_default_update_msgfontclr");
                props.remove("project_default_update_msgbtnfontclr");
                props.remove("project_default_update_msgokbtn"); 
                props.remove("project_default_update_msgokbtnmnem"); 
                props.remove("project_default_update_msgskipbtn"); 
                props.remove("project_default_update_msgskipbtnmnem"); 
                props.remove("project_default_update_msgtextalgn");  
                props.remove("project_default_update_langs");
                props.remove("project_default_update_silent");
                props.remove("project_default_update_lazyUpdate");
                props.remove("project_default_update_msgmaxattempts");
                props.remove("project_default_update_copyfilesto");
                props.remove("project_default_update_files");
                props.remove("project_default_update_overwriteexistingfiles");
                
                /* The project setting for optin project is new. Used to Prompt launch Opt-In Wizard for new projects. */
                props.remove("project_optin_is_new");                
                /* The project setting for payment processing project is new. Used to Prompt launch Payment Processing Wizard for new projects. */
                props.remove("project_payment_processing_is_new");
                /* The project setting for the number of translated languages available. */
                props.remove("project_translated_lang_count");      
                
// ********************* Platform Support **********************************
                /* The project setting for Java platform support is enabled */            
                props.put("javaPlatformEnabled", ProjectManager.get("project_java_platform_support_is_enabled"));            
                /* The project setting for Mac OS X support is enabled */            
                props.put("osxPlatformEnabled", ProjectManager.get("project_osx_platform_support_is_enabled")); 
                /* The project setting for Windows support is enabled */             
                props.put("windowsPlatformEnabled", ProjectManager.get("project_windows_platform_support_is_enabled")); 
                /* The project setting for UNIX (All) support is enabled */             
                props.put("unixPlatformEnabled", ProjectManager.get("project_unix_platform_support_is_enabled")); 
                /* The project setting for Java platform support is enabled */            
                props.remove("project_java_platform_support_is_enabled");            
                /* The project setting for Mac OS X support is enabled */            
                props.remove("project_osx_platform_support_is_enabled"); 
                /* The project setting for Windows support is enabled */             
                props.remove("project_windows_platform_support_is_enabled"); 
                /* The project setting for UNIX (All) support is enabled */             
                props.remove("project_unix_platform_support_is_enabled");     
// ********************* End Platform Support **********************************                
                
                /* The Evaluation Setting for the evaluation checkbox setting. Default should be if enabled set expireAction to notExpiredAction */
                //putTempNoFileWrite("evaluation_disable_expired_software_enabled", "true");  
                /* The project setting for expiration support is enabled */             
                //putTempNoFileWrite("project_expiration_support_is_enabled", "true");  


                // rules base evaluation properties
                //putTempNoFileWrite("applicationClass", "class.not.specified");  
                //putTempNoFileWrite("isRegistered", "false");
                //putTempNoFileWrite("registeredCode", "777" + "-" + String.valueOf(ProjectManager.getRandomInt(999999998)) + "-" + String.valueOf(ProjectManager.getRandomInt(999999999)));           
                //putTempNoFileWrite("regAttempts", "0");    
                //putTempNoFileWrite("maxRegisterAttempts", "20");  
                //putTempNoFileWrite("runtimeMillasecondsToExpire", "1296000000");
                //putTempNoFileWrite("runtimeMillasecondsStartTrial", "");
                //putTempNoFileWrite("allowInternalStartTrialInstanciation", "true");     
                //putTempNoFileWrite("expiredAction", "com.trinity.ea.actions.ExpiredAction");            
                //putTempNoFileWrite("notExpiredAction", "com.trinity.ea.actions.StartAction");
                //putTempNoFileWrite("useEvaluationAction", "com.trinity.ea.actions.OptinAction");

                // expiration rules functionality
                //putTempNoFileWrite("expirationIsEnabled", "true");  
                //putTempNoFileWrite("expirationModel", "timed");            

// ********************* Global Variables Support **********************************   
                // Image Buttons
                if(((String)props.get("btnBarImgButtonsEnabled")).equalsIgnoreCase("false")==true)
                {
                    props.remove("registrationImgButtonWidth");
                    props.remove("registrationImgButtonHeight"); 
                    props.remove("registrationImgButtonFace");
                    props.remove("registrationImgButtonFaceOnClick"); 
                    props.remove("registrationButtonFaceInFocus");
                    props.remove("paymentImgCancelButtonWidth"); 
                    props.remove("paymentImgCancelButtonHeight"); 
                    props.remove("paymentImgCancelButtonFace"); 
                    props.remove("paymentImgCancelButtonFaceOnClick"); 
                    props.remove("paymentImgCancelButtonFaceInFocus"); 
                    props.remove("paymentImgContinueButtonWidth"); 
                    props.remove("paymentImgContinueButtonHeight"); 
                    props.remove("paymentImgContinueButtonFace"); 
                    props.remove("paymentImgContinueButtonFaceOnClick"); 
                    props.remove("paymentImgContinueButtonFaceInFocus");                    
                }
                // Custom Textfield Border
                if(((String)props.get("registrationCustomBorderEnabled")).equalsIgnoreCase("false")==true)
                {
                    props.remove("registrationTFExtBorderColor");
                    props.remove("registrationTFHighlightBorderColor1"); 
                    props.remove("registrationTFHighlightBorderColor2");
                    props.remove("registrationTFShadowBorderColor1"); 
                    props.remove("registrationTFShadowBorderColor2");
                }  
                // Custom Scrollbars
                if(((String)props.get("customScrollBarsEnabled")).equalsIgnoreCase("false")==true)
                {                
                    props.remove("sbBackgroundColor");
                    props.remove("sbForegroundColor");
                    props.remove("sbBGArrowBtnColor");
                    props.remove("sbBGArrowBtnColor");
                    props.remove("sbShadowArrowBtnColor");
                    props.remove("sbDarkShadowArrowBtnColor");
                    props.remove("sbLtHighlightArrowBtnColor");
                    props.remove("sbTrackColor");
                    props.remove("sbTrackHighlightColor");
                    props.remove("sbMsgThumbImagePath");
                }
 // ********************* End Global Variables Support **********************************                  
                
 // ********************* Optin Support **********************************               
                // optin rules functionality
                /* The project setting for optin support is enabled */
                if(((String)props.get("project_optin_is_enabled")).equalsIgnoreCase("false")==true)
                {
                    props.remove("project_optin_is_enabled");
                    props.remove("optinIsOptedIn");
                    props.remove("optinEMail");
                    props.remove("optinName");
                    props.remove("optinInputFullName");
                    props.remove("optinInputEMailAddress");
                    props.remove("optinFormRequestMethod");
                    props.remove("optinInputHiddenNames");
                    props.remove("optinInputHiddenValues");
                    props.remove("optinFormActionURL");
                // optin actions
                    props.remove("optinCancelAction");
                    props.remove("optinContinueAction");
                    props.remove("showOptinUIAction");           
                    props.remove("privacyPolicyAction");
                    props.remove("privacyPolicyActionType");
                // optin UI Strings
                    props.remove("optinYourNameLabel");
                    props.remove("optinYourEMailLabel");
                    props.remove("registerSoftwareTitle");
                    props.remove("optinDescription");
                    props.remove("optinCancelButtonText");
                    props.remove("optinContinueButtonText");                   
                    props.remove("optinCancelButtonMnemonic");
                    props.remove("optinContinueButtonMnemonic");    
                    props.remove("optinEnterNameMessage");
                    props.remove("optinEnterValidEMailMessage");    
                    props.remove("optinEnterEMailMessage");
                    
                 // optin gui values   
                    props.remove("optinTextFieldFont");
                    props.remove("optinNameEMailFont");
                    props.remove("optinDescriptionFont");

                    props.remove("optinButtonFont");

                    props.remove("optinBackgroundColor");
                    props.remove("optinButtonTextColor");
                    
                    // optin privacy policy
                    props.remove("privacyPolicy");                    
                    props.remove("optinPrivacyPolicyLabel");
                    props.remove("privacyPolicyTitle");                     
                    props.remove("optinPrivacyPolicyMnemonic");                     
                    props.remove("optinPrivacyPolicyFont");  
                    props.remove("optinPrivacyPolicyTextColor");                   
                    props.remove("privacyPolicyTextBackgroundColor");
                    props.remove("privacyPolicyTextColor");
                    props.remove("privacyPolicyButtonTextColor");
                    props.remove("privacyPolicyBackgroundColor");
                    props.remove("privacyPolicyTextFont");
                    props.remove("privacyPolicyDialogSize");
                    props.remove("privacyPolicyOKBtnText");
                    props.remove("privacyPolicyOKBtnMnemonic");
                    props.remove("optinPrivacyPolicyEnabled");                   
                }
                else
                {
                    //props.remove("project_optin_is_enabled");
                    // optin ui string replacements here.
                    if(((String)props.get("optinPrivacyPolicyEnabled")).equalsIgnoreCase("true")==true && ((String)props.get("privacyPolicyActionType")).equalsIgnoreCase("1")==true)
                    {
                        //Optin Privacy Policy Enabled and Action is Java based
                    }
                    else
                    {
                        props.remove("privacyPolicyTextBackgroundColor");
                        props.remove("privacyPolicyTextColor");
                        props.remove("privacyPolicyButtonTextColor");
                        props.remove("privacyPolicyBackgroundColor");
                        props.remove("privacyPolicyTextFont");
                        props.remove("privacyPolicyDialogSize");
                    }
                }

                // optin network property (is a general setting that applies to all Get Requests both Payments, and EMail. */
                //TODO: implement separate property for optin, and payment processing
                //putTempNoFileWrite("supportMetaRefreshEnabled", "true");
                //putTempNoFileWrite("respInputStatus", "Status");
                //END TODO
  // ********************* End Optin Support **********************************      
                
  // ********************* Registration Support **********************************                
                // registration rules functionality
               // putTempNoFileWrite("registrationCodeSupportEnabled", "true");  
                
                /* The project setting for registration code support is enabled */            
                if(((String)props.get("project_registration_code_support_is_enabled")).equalsIgnoreCase("false")==true)
                {
                    props.remove("project_registration_code_support_is_enabled");
                    // registration main window actions
                    //props.remove("enterRegistrationCodeAction");
                    //props.remove("enterRegistrationCodeActionType");
                    props.remove("registrationSuccessUIAction");
                    props.remove("registrationFailedUIAction");
                    // registration success window actions
                    props.remove("registrationSucceededAction");
                    // registration window user interface strings                
                    props.remove("registerSoftwareWindowTitle");
                    props.remove("registrationCodeLabel");
                    props.remove("registrationPaidLabel");
                    props.remove("registrationCodeLabelFontMnemonic");
                    props.remove("registrationCancelButtonText");
                    props.remove("registrationCancelButtonMnemonic");
                    props.remove("registrationFinishButtonText");
                    props.remove("registrationFinishButtonMnemonic");
                    // registration window gui variables
                    props.remove("registrationDescriptionFont");
                    props.remove("registrationCodeLabelFont");
                    props.remove("registrationButtonFont");
                    props.remove("registrationTextColor");
                    props.remove("registrationBackgroundColor");
                    //registration success window user interface strings
                    props.remove("registrationSuccessWindowTitle");
                    props.remove("registrationSuccessHeader");
                    props.remove("registrationSuccessDesc");
                    props.remove("registrationSuccessOK");
                    props.remove("registrationSuccessOKMnemonic");
                    //registration failed window user interface strings
                    props.remove("registrationFailedWindowTitle");
                    props.remove("registrationFailedMessage");
                    props.remove("registrationFailureOK");
                    props.remove("registrationFailureOKMnemonic");                   
                }
                else
                {
                     //props.remove("project_registration_code_support_is_enabled");     
                }
// ********************* End Registration Support **********************************  
                 // payment processing rules functionality        
                 // putTempNoFileWrite("paymentProcessingSupportEnabled", "true");    
                
                /* The project setting for payment processing support is enabled */            
                if(((String)props.get("project_payment_processing_support_is_enabled")).equalsIgnoreCase("false")==true)
                {
                     props.remove("project_payment_processing_support_is_enabled");   
                     props.remove("refundPolicyEnabled");
                     //Buy Now Actions could be used for weblink and Payment processing deleted (do not delete for release 1.0).
                     //props.remove("buyNowActionType");
                     //props.remove("buyNowAction");
                     
                     // payment user interface strings
                     props.remove("paymentWindowTitle");
                     props.remove("paymentStateLabel");
                     props.remove("paymentExpMMYYLabel");    
                     props.remove("paymentContinueButtonText");
                     props.remove("paymentCancelButtonText");
                     props.remove("paymentInstructionsLine1");
                     props.remove("paymentVerificationCodeLabel");
                     props.remove("paymentRefundPolicyLabel");
                     props.remove("paymentFirstNameDataFieldEmptyMessage");
                     props.remove("paymentLastNameDataFieldEmptyMessage");
                     props.remove("paymentValidEMailDataFieldEmptyMessage");
                     props.remove("paymentEMailDataFieldEmptyMessage");
                     props.remove("paymentStreetDataFieldEmptyMessage");
                     props.remove("paymentCityDataFieldEmptyMessage");
                     props.remove("paymentZipDataFieldEmptyMessage");
                     props.remove("paymentCCDataFieldEmptyMessage");
                     props.remove("paymentCCVerificationCodeFieldEmptyMessage");
                     props.remove("paymentPhoneDataFieldEmptyMessage");                    
                     props.remove("paymentFirstNameLabel");
                     props.remove("paymentLastNameLabel");
                     props.remove("paymentEMailLabel");
                     props.remove("paymentPhoneLabel");                     
                     props.remove("paymentStreetLabel");
                     props.remove("paymentCityLabel");
                     props.remove("paymentCountryLabel");
                     props.remove("paymentZipCodeLabel");
                     props.remove("paymentPaymentMethodLabel");
                     props.remove("paymentCCLabel");
                     props.remove("paymentOrdersOutsideUSLabel");
                     props.remove("refundPolicy");   
                     props.remove("refundPolicyTitle");
                     props.remove("refundPolicyOKBtnText");   
                     props.remove("refundPolicyOKBtnMnemonic");
                     
                     // payment success user interface strings
                     props.remove("paymentSuccessResponsePanelTitle");
                     props.remove("paymentSuccessResponsePanelHeaderDescription");
                     props.remove("paymentSuccessResponsePanelOrderID");
                     props.remove("paymentSuccessResponsePanelNameOnCard");
                     props.remove("paymentSuccessResponsePanelEMailAddress");
                     props.remove("paymentSuccessResponsePanelAmountBilled");
                     props.remove("paymentSuccessResponsePanelMessage");
                     props.remove("paymentSucceededActionMessage");
                     // payment failed user interface strings
                     props.remove("paymentFailureResponsePanelTitle");
                     props.remove("paymentFailureResponsePanelHeaderDescription");
                     props.remove("paymentFailureResponsePanelOrderID");
                     props.remove("paymentFailureResponsePanelNameOnCard");
                     props.remove("paymentFailureResponsePanelEMailAddress");
                     props.remove("paymentFailureResponsePanelAmountBilled");
                     props.remove("paymentFailureResponsePanelMessage");
                     props.remove("paymentFailureRetryButtonText");                     
                     props.remove("paymentFailureRetryButtonMnemonic");   
                     props.remove("paymentFormLeftTopImagePath");                      
                     // payment actions
                     props.remove("refundPolicyAction");   
                     props.remove("refundPolicyActionType");                     
                     props.remove("buyNowAction");
                     props.remove("paymentReceiptFinishedAction");
                     props.remove("paymentReceiptFailedRetryAction");
                     props.remove("orderIDGeneratorAction");
                     props.remove("unknownHostExceptionAction");
                     props.remove("socketExceptionAction");
                     //payment html form input values
                     props.remove("inputNameFirstName");
                     props.remove("inputNameLastName");
                     props.remove("inputNameAddress");
                     props.remove("inputNameCity");
                     props.remove("inputNameState");
                     props.remove("inputNameZip");
                     props.remove("inputNameCountry");
                     props.remove("inputNameEMail");
                     props.remove("inputNamePaymentMethod");
                     props.remove("inputNameCC1");
                     props.remove("inputNameCC2");
                     props.remove("inputNameCC3");
                     props.remove("inputNameCC4");
                     props.remove("inputNameVerificationCode");
                     props.remove("inputNameExpirationMonth");
                     props.remove("inputNameExpirationYear");
                     props.remove("inputNameMerchant");
                     props.remove("inputNameOrderID");
                     props.remove("inputNameNameOnCard");
                     props.remove("inputNameResponseURL");
                     props.remove("inputNameTotal");
                     props.remove("inputNamePhone");                  
                     props.remove("paymentPhoneInputEnabled");
                     props.remove("paymentCCIsSingleInputEnabled");
                     props.remove("paymentSeparateFirstAndLastNameInputsEnabled");
                     props.remove("paymentFullNameInputEnabled");
   
                     //payment response html form input values
                     props.remove("paymentInputHiddenNames");
                     props.remove("paymentInputHiddenValues");
                     props.remove("respInputAuthResponse");
                     props.remove("respInputEmail");
                     props.remove("respInputTotal");
                     props.remove("respInputOrderID");
                     props.remove("respInputNameonCard");
                     props.remove("respInputCardStreet");
                     props.remove("respInputCardCity");
                     props.remove("respInputCardState");
                     props.remove("respInputCardZip");
                     props.remove("respInputCardCountry");
                     props.remove("respInputCardnumber");
                     props.remove("respInputCardName");
                     props.remove("formActionURL");
                     props.remove("formRequestMethod");
                     //payment processing product configuration
                     props.remove("product_price");
                     props.remove("paymentMethods");
                     props.remove("paymentAttempts");
                     props.remove("maxPaymentAttempts");
                     props.remove("paymentCCVerificationCodeEnabled");            
                     props.remove("merchantValue"); 
                     props.remove("responseURLValue");
                     props.remove("orderIDLeadingID");
                     props.remove("secondaryPaymentMethod");
                     props.remove("secondaryPaymentMethodEnabled");    
                     props.remove("paymentCancelButtonMnemonic");
                     props.remove("paymentContinueButtonMnemonic");
                     props.remove("paymentFormProductLabelImageEnabled");
                     props.remove("paymentFormProductLabel"); 
                     props.remove("paymentPriceLabel"); 
                     props.remove("secondaryPaymentMethodButtonText"); 
                     props.remove("secondaryPaymentMethodButtonMnemonic");   
                     props.remove("paymentSSLEnabledText");      
                     props.remove("paymentGenericAuthResponseFailureMsg");  
                     props.remove("paymentGenericAuthResponseSuccessMsg");
                     // payment processing result variables to remove need some logic
                     int totalMessages = 0;
                     if(ProjectManager.get("paymentResponseStatTotalMessages")!=null)
                     {
                            if(ProjectManager.get("paymentResponseStatTotalMessages").equalsIgnoreCase("")==false)
                            {
                                    totalMessages = Integer.valueOf(ProjectManager.get("paymentResponseStatTotalMessages")).intValue();						
                            }
                     }                                        
                     if(totalMessages!=0)
                     {
                        for(int j = 0;j<totalMessages;j++)
                        {
                            props.remove("paymentResponseStatDeclined" + String.valueOf(j + 1));
                            props.remove("paymentResponseMsgDeclined" + String.valueOf(j + 1));
                        }
                     }       
                     props.remove("paymentResponseStatTotalMessages");
                     props.remove("paymentBackgroundColor");
                     props.remove("paymentRespFailureBackgroundImagePath");
                     props.remove("paymentLabelTextColor");
                     props.remove("paymentFailureLabelBGColor");
                     props.remove("paymentFailureLabelFont");
                     props.remove("paymentFailureHeaderLabelFont");
                     props.remove("paymentButtonFont");
                     props.remove("paymentButtonTextColor");
                     props.remove("paymentFormLeftTopImagePath");
                     props.remove("paymentFormLeftTopImageWidth");
                     props.remove("paymentFailureLabelHeaderTextFont");
                     props.remove("paymentFailureLabelHeaderTextColor");
                     props.remove("paymentSuccessLabelBGColor");
                     props.remove("paymentSuccessLabelFont");
                     props.remove("paymentSuccessHeaderLabelFont");
                     props.remove("paymentSuccessLabelHeaderTextFont");
                     props.remove("paymentSuccessLabelHeaderTextColor");
                     props.remove("refundPolicyTextBackgroundColor");
                     props.remove("refundPolicyTextColor"); 
                     props.remove("refundPolicyButtonTextColor");
                     props.remove("refundPolicyBackgroundColor");
                     props.remove("refundPolicyTextFont");
                     props.remove("refundPolicyDialogSize");
                     props.remove("paymentImgSecondaryBackgroundColor");
                     props.remove("paymentImgSecondaryButtonBackgroundColor");
                     props.remove("paymentImgSecondaryButtonWidth");
                     props.remove("paymentImgSecondaryButtonHeight");
                     props.remove("paymentImgSecondaryButtonFace");
                     props.remove("paymentImgSecondaryButtonFaceOnClick");
                     props.remove("paymentImgSecondaryButtonFaceInFocus");
                     props.remove("secondaryPaymentMethodTextColor");
                     props.remove("secondaryPaymentMethodButtonFont");   
                     props.remove("paymentFormRightTopImagePath"); 
                     props.remove("paymentLabelHeaderTextFont"); 
                     props.remove("paymentLabelHeaderTextColor"); 
                     props.remove("paymentLabelHeaderProductNameTextColor"); 
                     props.remove("paymentLabelHeaderProductNameTextFont"); 
                     props.remove("paymentImgBackgroundColor"); 
                     props.remove("paymentImgCancelButtonWidth"); 
                     props.remove("paymentImgCancelButtonHeight"); 
                     props.remove("paymentImgCancelButtonFace"); 
                     props.remove("paymentImgCancelButtonFaceOnClick"); 
                     props.remove("paymentImgCancelButtonFaceInFocus"); 
                     props.remove("paymentImgContinueButtonWidth"); 
                     props.remove("paymentImgContinueButtonHeight"); 
                     props.remove("paymentImgContinueButtonFace"); 
                     props.remove("paymentImgContinueButtonFaceOnClick"); 
                     props.remove("paymentImgContinueButtonFaceInFocus");  
                     props.remove("refundPolicyLinkTextColor");
                     props.remove("paymentLabelTextFont");
                     props.remove("paymentFormInputBackgroundImagePath");
                     props.remove("paymentImgSecondaryButtonFace");
                     props.remove("paymentImgSecondaryButtonFaceOnClick");
                     props.remove("paymentImgSecondaryButtonFaceInFocus");                     
                     props.remove("paymentValidateBtnBGColor");
                     props.remove("paymentRespSuccessBackgroundImagePath");
                }
                else 
                {
                     //props.remove("project_payment_processing_support_is_enabled"); 
                    try
                    { 
                        if(ProjectManager.get("paymentFormInputBackgroundImagePath")!=null)
                        {
                            if(ProjectManager.get("paymentFormInputBackgroundImagePath").equalsIgnoreCase("")==false)
                            {
                                if(ProjectManager.get("paymentPhoneInputEnabled").equalsIgnoreCase("true")==true && ProjectManager.get("paymentFormInputBackgroundImagePath").equalsIgnoreCase(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/frame.png").toString())==true)
                                {
                                        try
                                        {
                                            props.put("paymentFormInputBackgroundImagePath",new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/framepho.png").toString());
                                        }
                                        catch(Exception e) 
                                        {

                                        }
                                }
                                else if(ProjectManager.get("paymentPhoneInputEnabled").equalsIgnoreCase("false")==true && ProjectManager.get("paymentFormInputBackgroundImagePath").equalsIgnoreCase(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/framepho.png").toString())==true)
                                {
                                        try
                                        {
                                             props.put("paymentFormInputBackgroundImagePath",new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/frame.png").toString());
                                        }
                                        catch(Exception e)
                                        {

                                        }
                                }
                            }
                        }
                    }
                    catch(Exception e)
                    {
                            //e.printStackTrace();
                    }                    
                } 
                
                //Bugfix workaround for projects created pre 1.04 remove this fix by 2.0 release
                //creates the lockdown variable becuase it was not included in pre 1.04 releases by mistake
                     try
                    { 
                        if(ProjectManager.get("lockDownAction")!=null)
                        {
                            if(ProjectManager.get("lockDownAction").equalsIgnoreCase("")==true)
                            {
                                ProjectManager.put("lockDownAction", "com.trinity.ea.actions.LockedOutAction"); 
                                props.put("lockDownAction", "com.trinity.ea.actions.LockedOutAction"); 
                            }
                        }
                        else
                        {
                            ProjectManager.put("lockDownAction", "com.trinity.ea.actions.LockedOutAction");
                            props.put("lockDownAction", "com.trinity.ea.actions.LockedOutAction");                        
                        }
                        
                        if(ProjectManager.get("paymentLockDownAction")!=null)
                        {
                            if(ProjectManager.get("paymentLockDownAction").equalsIgnoreCase("")==true)
                            {
                                ProjectManager.put("paymentLockDownAction", "com.trinity.ea.actions.LockedOutAction"); 
                                props.put("paymentLockDownAction", "com.trinity.ea.actions.LockedOutAction"); 
                            }
                        }
                        else
                        {
                            ProjectManager.put("paymentLockDownAction", "com.trinity.ea.actions.LockedOutAction");
                            props.put("paymentLockDownAction", "com.trinity.ea.actions.LockedOutAction");                        
                        }
                    }
                    catch(Exception e)
                    {
                            //e.printStackTrace();
                    }                  

                //end bugfix workaround
                
                 //putTempNoFileWrite("autoUpdateEnabled", "true");
                
                 /* The project setting for automatic update support is enabled */             
                 if(((String)props.get("project_auto_update_support_is_enabled")).equalsIgnoreCase("false")==true)
                 {
                     props.remove("project_auto_update_support_is_enabled"); 
                     props.remove("auto_update_code_signing_is_enabled");
                     props.remove("autoUpdateX500Principal");
                     props.remove("autoUpdateX509Certificate"); 
                     props.remove("autoUpdateX509CertificateEnabled");                           
                     props.remove("update_file_name");                      
                     props.remove("autoUpdatePwdSeed"); 
                     props.remove("autoUpdatePwdCount");
                     props.remove("autoUpdateShoeHandler");
                     props.remove("autoUpdateLoadCheckForUpdatesUIAction");
                     props.remove("autoUpdateLoadInstallUIAction");
                     props.remove("autoUpdateInstallAction");
                     props.remove("autoUpdateSkipAction");
                     props.remove("autoUpdateBaseURLChangesAllowed");
                     props.remove("autoUpdateBaseURL"); 
                     props.remove("autoUpdateUpdateInProgress");
                     props.remove("autoUpdateLastCheckedTimestamp");
                     props.remove("autoUpdateUpdateID");
                     props.remove("autoUpdateFileName");
                     props.remove("autoUpdateTempFileName");
                     props.remove("autoUpdateMaxBaseURLs");  
                     props.remove("autoUpdateAllowNotifyServerOnUpdateSuccess");
                     props.remove("autoUpdateAllowExecuteActions");    
                     props.remove("autoUpdateExpirationEnabled");   
                     props.remove("autoUpdateAllowSilent");  
                     props.remove("autoUpdateRootDir");
                     props.remove("autoUpdateRootDirSystemPropertyEnabled");
                     props.remove("/$ROOT_DIR/$");
                     props.remove("autoUpdateDownloadDir");
                     props.remove("autoUpdateDownloadDirSystemPropertyEnabled");
                     props.remove("/$DOWNLOAD_DIR/$");
                     props.remove("autoUpdateWorkDir");
                     props.remove("autoUpdateWorkDirSystemPropertyEnabled");
                     props.remove("/$WORK_DIR/$");
                     props.remove("autoUpdateMillasecondsToExpire");  
                     props.remove("/$USER_HOME_DIR/$");
                     props.remove("msgbgclr");
                     props.remove("msgtextbgclr");
                     props.remove("msgHeaderImgPath");
                     props.remove("msgBGImgPath");
                     props.remove("autoUpdateImgBackgroundColor");
                     
                 } 
                 else
                 {
                     if(ProjectManager.get("autoUpdateX509CertificateEnabled")!=null)
                     {
                        if(ProjectManager.get("autoUpdateX509CertificateEnabled").equalsIgnoreCase("false")==true)
                        {                         
                            props.remove("autoUpdateX509Certificate");
                        }
                     }

                     //props.remove("project_auto_update_support_is_enabled");                      
                     props.put("autoUpdateCP",getVerifyClasspath());                     
                 }
                
                //putTempNoFileWrite("msgEnabled","true"); 
                 /* The project setting for messaging support is enabled */             
                 if(((String)props.get("project_messaging_support_is_enabled")).equalsIgnoreCase("false")==true)
                 {                
                     props.remove("project_messaging_support_is_enabled"); 
                     props.remove("msgX500Principal");         
                     props.remove("msgX509Certificate"); 
                     props.remove("msgX509CertificateEnabled");                       
                     props.remove("messaging_code_signing_is_enabled");   
                     props.remove("message_file_name");                      
                     props.remove("msgBaseURLChangesAllowed");            
                     props.remove("msgPwdCount");
                     props.remove("msgPwdSeed");
                     props.remove("msgShoeHandler");
                     props.remove("msgUpdateID");
                     props.remove("msgDisplayMessageUIAction");
                     props.remove("msgCustomMessageUIAction");
                     props.remove("msgFinishedUIAction"); 
                     props.remove("msgLastCheckedTimestamp");
                     props.remove("msgBaseURL");
                     props.remove("msgMaxBaseURLs");
                     props.remove("msgAllowExecuteActionsOnCustomMessages");
                     props.remove("msgAllowNotifyServerOnMessageReceivedStatus");                     
                 }
                 else
                 {
                      //props.remove("project_messaging_support_is_enabled");  
                     if(ProjectManager.get("msgX509CertificateEnabled")!=null)
                     {
                        if(ProjectManager.get("msgX509CertificateEnabled").equalsIgnoreCase("false")==true)
                        {                         
                            props.remove("msgX509Certificate");
                        }
                     }                       
                 }
                
                 // Rules File Image Files Logic 
                 if(urlExists(ProjectManager.get("splashImgPath"))==true)
                 {
                      props.put("splashImgPath", "/images/" + ProjectManager.get("splashImgPath").substring(ProjectManager.get("splashImgPath").lastIndexOf("/") + 1));                 
                 }  
                 else
                 {
                      props.remove("splashImgPath");
                 }
                 if(ProjectManager.get("btnBarImgBtnEnabled")!=null)
                 {
                     if(ProjectManager.get("btnBarImgBtnEnabled").equalsIgnoreCase("true")==true)
                     {                     
                         if(urlExists(ProjectManager.get("btnBarImgPath"))==true)
                         {
                              props.put("btnBarImgPath", "/images/" + ProjectManager.get("btnBarImgPath").substring(ProjectManager.get("btnBarImgPath").lastIndexOf("/") + 1));                 
                         }  
                         else
                         {
                              props.remove("btnBarImgPath");
                         }
                     }
                     else
                     {
                         props.remove("btnBarImgPath");                     
                     }                     
                 }     
                 else
                 {
                     props.remove("btnBarImgPath");                     
                 }
                 if(ProjectManager.get("progressPanelImgEnabled")!=null)
                 {
                     if(ProjectManager.get("progressPanelImgEnabled").equalsIgnoreCase("true")==true)
                     {                     
                         if(urlExists(ProjectManager.get("progressPanelImgPath"))==true)
                         {
                              props.put("progressPanelImgPath", "/images/" + ProjectManager.get("progressPanelImgPath").substring(ProjectManager.get("progressPanelImgPath").lastIndexOf("/") + 1));                 
                         }  
                         else
                         {
                              props.remove("progressPanelImgPath");
                         }
                     }
                     else
                     {
                         props.remove("progressPanelImgPath");                     
                     }                     
                 }     
                 else
                 {
                     props.remove("progressPanelImgPath");                     
                 }
                 if(ProjectManager.get("secondaryPaymentMethodEnabled")!=null)
                 {
                     if(ProjectManager.get("secondaryPaymentMethodEnabled").equalsIgnoreCase("true")==true)
                     {                     
                         if(urlExists(ProjectManager.get("paymentImgSecondaryButtonFace"))==true)
                         {
                              props.put("paymentImgSecondaryButtonFace", "/images/" + ProjectManager.get("paymentImgSecondaryButtonFace").substring(ProjectManager.get("paymentImgSecondaryButtonFace").lastIndexOf("/") + 1));                 
                         }  
                         else
                         {
                              props.remove("paymentImgSecondaryButtonFace");
                         }
                         if(urlExists(ProjectManager.get("paymentImgSecondaryButtonFaceOnClick"))==true)
                         {
                              props.put("paymentImgSecondaryButtonFaceOnClick", "/images/" + ProjectManager.get("paymentImgSecondaryButtonFaceOnClick").substring(ProjectManager.get("paymentImgSecondaryButtonFaceOnClick").lastIndexOf("/") + 1));                 
                         }  
                         else
                         {
                              props.remove("paymentImgSecondaryButtonFaceOnClick");
                         }
                         if(urlExists(ProjectManager.get("paymentImgSecondaryButtonFaceInFocus"))==true)
                         {
                              props.put("paymentImgSecondaryButtonFaceInFocus", "/images/" + ProjectManager.get("paymentImgSecondaryButtonFaceInFocus").substring(ProjectManager.get("paymentImgSecondaryButtonFaceInFocus").lastIndexOf("/") + 1));                 
                         }  
                         else
                         {
                              props.remove("paymentImgSecondaryButtonFaceInFocus");
                         }  
			}
		}                
                 if(ProjectManager.get("btnBarImgButtonsEnabled")!=null)
                 {
                     if(ProjectManager.get("btnBarImgButtonsEnabled").equalsIgnoreCase("true")==true)
                     {                     
                         if(urlExists(ProjectManager.get("paymentImgCancelButtonFace"))==true)
                         {
                              props.put("paymentImgCancelButtonFace", "/images/" + ProjectManager.get("paymentImgCancelButtonFace").substring(ProjectManager.get("paymentImgCancelButtonFace").lastIndexOf("/") + 1));                 
                         }  
                         else
                         {
                              props.remove("paymentImgCancelButtonFace");
                         }
                         if(urlExists(ProjectManager.get("paymentImgCancelButtonFaceOnClick"))==true)
                         {
                              props.put("paymentImgCancelButtonFaceOnClick", "/images/" + ProjectManager.get("paymentImgCancelButtonFaceOnClick").substring(ProjectManager.get("paymentImgCancelButtonFaceOnClick").lastIndexOf("/") + 1));                 
                         }  
                         else
                         {
                              props.remove("paymentImgCancelButtonFaceOnClick");
                         }
                         if(urlExists(ProjectManager.get("paymentImgCancelButtonFaceInFocus"))==true)
                         {
                              props.put("paymentImgCancelButtonFaceInFocus", "/images/" + ProjectManager.get("paymentImgCancelButtonFaceInFocus").substring(ProjectManager.get("paymentImgCancelButtonFaceInFocus").lastIndexOf("/") + 1));                 
                         }  
                         else
                         {
                              props.remove("paymentImgCancelButtonFaceInFocus");
                         }           
                         if(urlExists(ProjectManager.get("paymentImgContinueButtonFace"))==true)
                         {
                              props.put("paymentImgContinueButtonFace", "/images/" + ProjectManager.get("paymentImgContinueButtonFace").substring(ProjectManager.get("paymentImgContinueButtonFace").lastIndexOf("/") + 1));                 
                         }  
                         else
                         {
                              props.remove("paymentImgContinueButtonFace");
                         }
                         if(urlExists(ProjectManager.get("paymentImgContinueButtonFaceOnClick"))==true)
                         {
                              props.put("paymentImgContinueButtonFaceOnClick", "/images/" + ProjectManager.get("paymentImgContinueButtonFaceOnClick").substring(ProjectManager.get("paymentImgContinueButtonFaceOnClick").lastIndexOf("/") + 1));                 
                         }  
                         else
                         {
                              props.remove("paymentImgContinueButtonFaceOnClick");
                         }
                         if(urlExists(ProjectManager.get("paymentImgContinueButtonFaceInFocus"))==true)
                         {
                              props.put("paymentImgContinueButtonFaceInFocus", "/images/" + ProjectManager.get("paymentImgContinueButtonFaceInFocus").substring(ProjectManager.get("paymentImgContinueButtonFaceInFocus").lastIndexOf("/") + 1));                 
                         }  
                         else
                         {
                              props.remove("paymentImgContinueButtonFaceInFocus");
                         }           
                         if(urlExists(ProjectManager.get("registrationImgButtonFace"))==true)
                         {
                              props.put("registrationImgButtonFace", "/images/" + ProjectManager.get("registrationImgButtonFace").substring(ProjectManager.get("registrationImgButtonFace").lastIndexOf("/") + 1));                 
                         }  
                         else
                         {
                              props.remove("registrationImgButtonFace");
                         }
                         if(urlExists(ProjectManager.get("registrationImgButtonFaceOnClick"))==true)
                         {
                              props.put("registrationImgButtonFaceOnClick", "/images/" + ProjectManager.get("registrationImgButtonFaceOnClick").substring(ProjectManager.get("registrationImgButtonFaceOnClick").lastIndexOf("/") + 1));                 
                         }  
                         else
                         {
                              props.remove("registrationImgButtonFaceOnClick");
                         }
                         if(urlExists(ProjectManager.get("registrationButtonFaceInFocus"))==true)
                         {
                              props.put("registrationButtonFaceInFocus", "/images/" + ProjectManager.get("registrationButtonFaceInFocus").substring(ProjectManager.get("registrationButtonFaceInFocus").lastIndexOf("/") + 1));                 
                         }  
                         else
                         {
                              props.remove("registrationButtonFaceInFocus");
                         }   
                         if(urlExists(ProjectManager.get("btnBarImgButtonFace"))==true)
                         {
                              props.put("btnBarImgButtonFace", "/images/" + ProjectManager.get("btnBarImgButtonFace").substring(ProjectManager.get("btnBarImgButtonFace").lastIndexOf("/") + 1));                 
                         }  
                         else
                         {
                              props.remove("btnBarImgButtonFace");
                         }
                         if(urlExists(ProjectManager.get("btnBarImgButtonFaceOnClick"))==true)
                         {
                              props.put("btnBarImgButtonFaceOnClick", "/images/" + ProjectManager.get("btnBarImgButtonFaceOnClick").substring(ProjectManager.get("btnBarImgButtonFaceOnClick").lastIndexOf("/") + 1));                 
                         }  
                         else
                         {
                              props.remove("btnBarImgButtonFaceOnClick");
                         }
                         if(urlExists(ProjectManager.get("buttonFaceImageInFocus"))==true)
                         {
                              props.put("buttonFaceImageInFocus", "/images/" + ProjectManager.get("buttonFaceImageInFocus").substring(ProjectManager.get("buttonFaceImageInFocus").lastIndexOf("/") + 1));                 
                         }  
                         else
                         {
                              props.remove("buttonFaceImageInFocus");
                         }                      
                     }
                     else
                     {
                         props.remove("paymentImgCancelButtonFace");
                         props.remove("paymentImgCancelButtonFaceOnClick");
                         props.remove("paymentImgCancelButtonFaceInFocus");
                         props.remove("paymentImgContinueButtonFace");
                         props.remove("paymentImgContinueButtonFaceOnClick");
                         props.remove("paymentImgContinueButtonFaceInFocus");
                         props.remove("registrationImgButtonFace");
                         props.remove("registrationImgButtonFaceOnClick");
                         props.remove("registrationButtonFaceInFocus");
                         props.remove("btnBarImgButtonFace");
                         props.remove("btnBarImgButtonFaceOnClick");
                         props.remove("buttonFaceImageInFocus");
                     }                     
                 }      
                 else
                 { 
                     props.remove("paymentImgCancelButtonFace");
                     props.remove("paymentImgCancelButtonFaceOnClick");
                     props.remove("paymentImgCancelButtonFaceInFocus");
                     props.remove("paymentImgContinueButtonFace");
                     props.remove("paymentImgContinueButtonFaceOnClick");
                     props.remove("paymentImgContinueButtonFaceInFocus");
                     props.remove("registrationImgButtonFace");
                     props.remove("registrationImgButtonFaceOnClick");
                     props.remove("registrationButtonFaceInFocus");
                     props.remove("btnBarImgButtonFace");
                     props.remove("btnBarImgButtonFaceOnClick");
                     props.remove("buttonFaceImageInFocus");                   
                 }
                 if(ProjectManager.get("customScrollBarsEnabled")!=null)
                 {
                     if(ProjectManager.get("customScrollBarsEnabled").equalsIgnoreCase("true")==true)
                     {                     
                         if(urlExists(ProjectManager.get("sbMsgThumbImagePath"))==true)
                         {
                              props.put("sbMsgThumbImagePath", "/images/" + ProjectManager.get("sbMsgThumbImagePath").substring(ProjectManager.get("sbMsgThumbImagePath").lastIndexOf("/") + 1));                 
                         }  
                         else
                         {
                              props.remove("sbMsgThumbImagePath");
                         }
                         if(urlExists(ProjectManager.get("sbThumbImagePath"))==true)
                         {
                              props.put("sbThumbImagePath", "/images/" + ProjectManager.get("sbThumbImagePath").substring(ProjectManager.get("sbThumbImagePath").lastIndexOf("/") + 1));                 
                         }  
                         else
                         {
                              props.remove("sbThumbImagePath");
                         }                         
                     }
                     else
                     {
                         props.remove("sbMsgThumbImagePath");
                         props.remove("sbThumbImagePath");
                     }                     
                 }      
                 else
                 {
                     props.remove("sbMsgThumbImagePath"); 
                     props.remove("sbThumbImagePath");                     
                 }                
                 if(urlExists(ProjectManager.get("errHeaderImgPath"))==true)
                 {
                      props.put("errHeaderImgPath", "/images/" + ProjectManager.get("errHeaderImgPath").substring(ProjectManager.get("errHeaderImgPath").lastIndexOf("/") + 1));                 
                 }  
                 else
                 {
                      props.remove("errHeaderImgPath");
                 }
                 if(urlExists(ProjectManager.get("errBGImgPath"))==true)
                 {
                      props.put("errBGImgPath", "/images/" + ProjectManager.get("errBGImgPath").substring(ProjectManager.get("errBGImgPath").lastIndexOf("/") + 1));                 
                 }  
                 else
                 {
                      props.remove("errBGImgPath");
                 }
                 if(ProjectManager.get("project_messaging_support_is_enabled").equalsIgnoreCase("true")==true || ProjectManager.get("project_auto_update_support_is_enabled").equalsIgnoreCase("true")==true)
                 {  
                     if(urlExists(ProjectManager.get("msgHeaderImgPath"))==true)
                     {
                          props.put("msgHeaderImgPath", "/images/" + ProjectManager.get("msgHeaderImgPath").substring(ProjectManager.get("msgHeaderImgPath").lastIndexOf("/") + 1));                 
                     }  
                     else
                     {
                          props.remove("msgHeaderImgPath");
                     }
                     if(urlExists(ProjectManager.get("msgBGImgPath"))==true)
                     {
                          props.put("msgBGImgPath", "/images/" + ProjectManager.get("msgBGImgPath").substring(ProjectManager.get("msgBGImgPath").lastIndexOf("/") + 1));                 
                     }  
                     else
                     {
                          props.remove("msgBGImgPath");
                     }
                }
                else
                {
                      props.remove("msgHeaderImgPath");                    
                      props.remove("msgBGImgPath");
                }
                
                // If no evaluation/registration/payment processing features enabled set product value to registered so features like messaging/auto-update/(possibly opt-in) function
                if(ProjectManager.get("project_expiration_support_is_enabled").equalsIgnoreCase("false") == true)
                {
                    if(ProjectManager.get("project_registration_code_support_is_enabled").equalsIgnoreCase("false") == true)
                    {
                        if(ProjectManager.get("project_payment_processing_support_is_enabled").equalsIgnoreCase("false") == true)
                        {
                            props.put("isRegistered","true");        
                        }
                    }
                } 
                //
          // Begin Update for Optin Support
          if(ProjectManager.get("project_auto_update_support_is_enabled").equalsIgnoreCase("true")==true || ProjectManager.get("project_messaging_support_is_enabled").equalsIgnoreCase("true") == true)
          {                   
              if(ProjectManager.get("project_optin_is_enabled").equalsIgnoreCase("true") == true)
              {
                  if(ProjectManager.get("project_registration_code_support_is_enabled").equalsIgnoreCase("false") == true)
                  {
                      if(ProjectManager.get("project_payment_processing_support_is_enabled").equalsIgnoreCase("false") == true)
                      {
                          if(ProjectManager.get("project_expiration_support_is_enabled").equalsIgnoreCase("false") == true)
                          {    
                              props.put("notExpiredAction","com.trinity.ea.actions.OptinAction");        
                              props.put("launchApplicationAction","com.trinity.ea.actions.OptinAction");        
                              props.put("optinCancelAction","com.trinity.ea.actions.LaunchApplicationAction");    
                              props.put("optinContinueAction","com.trinity.ea.actions.LaunchApplicationAction");     
                              props.put("optinContinueFallThroughAction","com.trinity.ea.actions.LaunchApplicationAction");     
                          }
                          else
                          {
                              props.put("notExpiredAction","com.trinity.ea.actions.StartVerticalButtonBarThemeAction");                          
                              props.put("useEvaluationAction", "com.trinity.ea.actions.OptinAction");    
                              props.put("launchApplicationAction","com.trinity.ea.actions.LaunchApplicationAction");        
                              props.put("optinCancelAction","com.trinity.ea.actions.LaunchApplicationAction");    
                              props.put("optinContinueAction","com.trinity.ea.actions.LaunchApplicationAction");     
                              props.put("optinContinueFallThroughAction","com.trinity.ea.actions.LaunchApplicationAction");      

                          }
                        } 
                        else
                        {
                            props.put("notExpiredAction","com.trinity.ea.actions.StartVerticalButtonBarThemeAction");                          
                            props.put("useEvaluationAction", "com.trinity.ea.actions.OptinAction");    
                            props.put("launchApplicationAction","com.trinity.ea.actions.LaunchApplicationAction");        
                            props.put("optinCancelAction","com.trinity.ea.actions.LaunchApplicationAction");    
                            props.put("optinContinueAction","com.trinity.ea.actions.LaunchApplicationAction");     
                            props.put("optinContinueFallThroughAction","com.trinity.ea.actions.LaunchApplicationAction");     

                        }
                    }
                    else
                    {
                        props.put("notExpiredAction","com.trinity.ea.actions.StartVerticalButtonBarThemeAction");                          
                        props.put("useEvaluationAction", "com.trinity.ea.actions.OptinAction");    
                        props.put("launchApplicationAction","com.trinity.ea.actions.LaunchApplicationAction");        
                        props.put("optinCancelAction","com.trinity.ea.actions.LaunchApplicationAction");    
                        props.put("optinContinueAction","com.trinity.ea.actions.LaunchApplicationAction");     
                        props.put("optinContinueFallThroughAction","com.trinity.ea.actions.LaunchApplicationAction");     
                    } 
               }
               else
               {
                  if(ProjectManager.get("project_registration_code_support_is_enabled").equalsIgnoreCase("false") == true)
                  {
                      if(ProjectManager.get("project_payment_processing_support_is_enabled").equalsIgnoreCase("false") == true)
                      {
                          if(ProjectManager.get("project_expiration_support_is_enabled").equalsIgnoreCase("false") == true)
                          {                          
                              props.put("launchApplicationAction","com.trinity.ea.actions.LaunchApplicationAction");        
                              props.put("notExpiredAction","com.trinity.ea.actions.LaunchApplicationAction");                          
                          }
                          else
                          {
                                props.put("useEvaluationAction", "com.trinity.ea.actions.LaunchApplicationAction");    
                                props.put("launchApplicationAction","com.trinity.ea.actions.LaunchApplicationAction"); 
                                props.put("notExpiredAction","com.trinity.ea.actions.StartVerticalButtonBarThemeAction");                          
                          }
                      }
                      else
                      {
                          props.put("useEvaluationAction", "com.trinity.ea.actions.LaunchApplicationAction");    
                          props.put("launchApplicationAction","com.trinity.ea.actions.LaunchApplicationAction");        
                          props.put("notExpiredAction","com.trinity.ea.actions.StartVerticalButtonBarThemeAction");   
                      }
                    } 
                    else
                    {
                        props.put("useEvaluationAction", "com.trinity.ea.actions.LaunchApplicationAction");    
                        props.put("launchApplicationAction","com.trinity.ea.actions.LaunchApplicationAction");        
                        props.put("notExpiredAction","com.trinity.ea.actions.StartVerticalButtonBarThemeAction");   
                    } 	
               }	
          }
          // No AutoUpdate or Messaging enabled
          else
          {
              if(ProjectManager.get("project_optin_is_enabled").equalsIgnoreCase("true") == true)
              {
                  if(ProjectManager.get("project_registration_code_support_is_enabled").equalsIgnoreCase("false") == true)
                  {
                      if(ProjectManager.get("project_payment_processing_support_is_enabled").equalsIgnoreCase("false") == true)
                      {
                          if(ProjectManager.get("project_expiration_support_is_enabled").equalsIgnoreCase("false") == true)
                          {    
                              props.put("notExpiredAction","com.trinity.ea.actions.OptinAction");        
                              props.put("launchApplicationAction","com.trinity.ea.actions.OptinAction");        
                              props.put("optinCancelAction","com.trinity.ea.actions.LaunchApplicationNoUpdateAction");    
                              props.put("optinContinueAction","com.trinity.ea.actions.LaunchApplicationNoUpdateAction");     
                              props.put("optinContinueFallThroughAction","com.trinity.ea.actions.LaunchApplicationNoUpdateAction");     
                          }
                          else
                          {
                              props.put("notExpiredAction","com.trinity.ea.actions.StartVerticalButtonBarThemeAction");                          
                              props.put("useEvaluationAction", "com.trinity.ea.actions.OptinAction");    
                              props.put("launchApplicationAction","com.trinity.ea.actions.LaunchApplicationNoUpdateAction");        
                              props.put("optinCancelAction","com.trinity.ea.actions.LaunchApplicationNoUpdateAction");    
                              props.put("optinContinueAction","com.trinity.ea.actions.LaunchApplicationNoUpdateAction");     
                              props.put("optinContinueFallThroughAction","com.trinity.ea.actions.LaunchApplicationNoUpdateAction"); 
                          }
                      }
                      else
                      {
                            props.put("notExpiredAction","com.trinity.ea.actions.StartVerticalButtonBarThemeAction");                          
                            props.put("useEvaluationAction", "com.trinity.ea.actions.OptinAction");    
                            props.put("launchApplicationAction","com.trinity.ea.actions.LaunchApplicationNoUpdateAction");        
                            props.put("optinCancelAction","com.trinity.ea.actions.LaunchApplicationNoUpdateAction");    
                            props.put("optinContinueAction","com.trinity.ea.actions.LaunchApplicationNoUpdateAction");     
                            props.put("optinContinueFallThroughAction","com.trinity.ea.actions.LaunchApplicationNoUpdateAction"); 
                      }
                    }
                    else
                    {
                        props.put("notExpiredAction","com.trinity.ea.actions.StartVerticalButtonBarThemeAction");                          
                        props.put("useEvaluationAction", "com.trinity.ea.actions.OptinAction");    
                        props.put("launchApplicationAction","com.trinity.ea.actions.LaunchApplicationNoUpdateAction");    
                        props.put("optinCancelAction","com.trinity.ea.actions.LaunchApplicationNoUpdateAction");    
                        props.put("optinContinueAction","com.trinity.ea.actions.LaunchApplicationNoUpdateAction");     
                        props.put("optinContinueFallThroughAction","com.trinity.ea.actions.LaunchApplicationNoUpdateAction"); 
                    } 
               }
               else
               {
                  if(ProjectManager.get("project_registration_code_support_is_enabled").equalsIgnoreCase("false") == true)
                  {
                      if(ProjectManager.get("project_payment_processing_support_is_enabled").equalsIgnoreCase("false") == true)
                      {
                          if(ProjectManager.get("project_expiration_support_is_enabled").equalsIgnoreCase("false") == true)
                          {                          
                              props.put("launchApplicationAction","com.trinity.ea.actions.LaunchApplicationNoUpdateAction");        
                              props.put("notExpiredAction","com.trinity.ea.actions.LaunchApplicationNoUpdateAction");   
                              
                          }
                          else
                          {
                                props.put("useEvaluationAction", "com.trinity.ea.actions.LaunchApplicationNoUpdateAction");    
                                props.put("launchApplicationAction","com.trinity.ea.actions.LaunchApplicationNoUpdateAction"); 
                                props.put("notExpiredAction","com.trinity.ea.actions.StartVerticalButtonBarThemeAction");                          
                          }
                      }
                      else
                      {
                          props.put("useEvaluationAction", "com.trinity.ea.actions.LaunchApplicationNoUpdateAction");    
                          props.put("launchApplicationAction","com.trinity.ea.actions.LaunchApplicationNoUpdateAction");        
                          props.put("notExpiredAction","com.trinity.ea.actions.StartVerticalButtonBarThemeAction");   
                      }
                    } 
                    else
                    {
                        props.put("useEvaluationAction", "com.trinity.ea.actions.LaunchApplicationNoUpdateAction");    
                        props.put("launchApplicationAction","com.trinity.ea.actions.LaunchApplicationNoUpdateAction");        
                        props.put("notExpiredAction","com.trinity.ea.actions.StartVerticalButtonBarThemeAction");   
                    } 	
               }	          
          }
           // End Optin Support
           //Button Bar minimalist support
            try 
            {
                if(ProjectManager.get("project_registration_code_support_is_enabled")!=null)
                {                
                    if(ProjectManager.get("project_registration_code_support_is_enabled").equalsIgnoreCase("true")==true)
                    {
                                ProjectManager.put("btnBarRegButtonEnabled","true");
                                props.put("btnBarRegButtonEnabled","true");                            
                    }
                    else
                    { 
                                ProjectManager.put("btnBarRegButtonEnabled","false");     
                                props.put("btnBarRegButtonEnabled","false");                                
                    }
                }
                else
                {
                        ProjectManager.put("btnBarRegButtonEnabled","false");     
                        props.put("btnBarRegButtonEnabled","false");   
                }
                if(ProjectManager.get("project_payment_processing_support_is_enabled").equalsIgnoreCase("true")==true)
                {
                            ProjectManager.put("btnBarBuyNowButtonEnabled","true");
                            props.put("btnBarBuyNowButtonEnabled","true");                            
                }
                else
                { 
                            ProjectManager.put("btnBarBuyNowButtonEnabled","false");    
                            props.put("btnBarBuyNowButtonEnabled","false");                             
                }
            }
            catch(Exception e)
            {
                //e.printStackTrace();
            }
            //
                
                removeRulesFileLocaleVariables();
            }
            catch(Exception e)
            {
                e.printStackTrace();
		    
                return 2;
            }
            try
            {
                EncryptedRuleBuilder.encryptAndWriteRulesFile(new File(new URL(BuildOutputDir.toURL().toString() + "/rules.eae").getFile()), props);
                try
                {
                    boolean includeEASignerJar = false;    
                    if(ProjectManager.get("allowInternalStartTrialInstanciation")!=null)
                    {
                        if(ProjectManager.get("allowInternalStartTrialInstanciation").equalsIgnoreCase("false")==true)
                        {                        
                            includeEASignerJar = true;
                        }
                    }
                    if(ProjectManager.get("project_auto_update_support_is_enabled").equalsIgnoreCase("true")==true)
                    {                
                        ClientDocBuilder.buildClientAUHTMLFile(new File(new URL(BuildOutputDir.toURL().toString() + "/README.html").getFile()), ProjectManager.get("project_jarfile_name"), ProjectManager.get("project_jarfile2_name"), "rules.eae", includeEASignerJar);
                    }
                    else
                    {
                        ClientDocBuilder.buildClientNoAUHTMLFile(new File(new URL(BuildOutputDir.toURL().toString() + "/README.html").getFile()), ProjectManager.get("project_jarfile_name"), ProjectManager.get("project_jarfile2_name"), "rules.eae", includeEASignerJar);
                    }
                }
                catch(Exception e){}
                return 0;
            }
            catch(Exception e)
            {
                e.printStackTrace();
		    
                return 4;
            }             
             
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return -1;
    }

    public int buildJar(File BuildOutputDir)
    {
        ArrayList theTempList1 = new ArrayList();
        ArrayList theTempZipEntryList = new ArrayList();  
        ArrayList theTempStartTrialList1 = new ArrayList();
        ArrayList theTempStartTrialZipEntryList = new ArrayList();        
        ArrayList theAUStartJarTempList1 = new ArrayList();
        ArrayList theAUStartJarTempZipEntryList = new ArrayList();  
        try
        {
             updateUIExpressionDefines();
        }
        catch(Exception e)
        {
             return 6;
        }      
        // prjExpirationSupport = 0 if Support is Enabled, and 1 if not enabled.
        int prjExpirationSupport = 0;
        int prjOptinSupport = 0;        
        int prjRegistrationSupport = 0;
        int prjPaymentSupport = 0; 
        int prjAutoUpdateSupport = 0;        
        int prjMessagingSupport = 0;        
        try
        {
            if(ProjectManager.get("project_expiration_support_is_enabled").equalsIgnoreCase("true") == true)
            {
                prjExpirationSupport = 0;
            }
            else
            {
                prjExpirationSupport = 1;
            }
            if(ProjectManager.get("project_optin_is_enabled").equalsIgnoreCase("true") == true)
            {
                prjOptinSupport = 0;
            }
            else
            {
                prjOptinSupport = 1;
            }            
            if(ProjectManager.get("project_registration_code_support_is_enabled").equalsIgnoreCase("true") == true)
            {
                prjRegistrationSupport = 0;
            }
            else
            {
                prjRegistrationSupport = 1;
            }   
            if(ProjectManager.get("project_payment_processing_support_is_enabled").equalsIgnoreCase("true") == true)
            {
                prjPaymentSupport = 0;
            }
            else
            {
                prjPaymentSupport = 1;
            }   
            if(ProjectManager.get("project_auto_update_support_is_enabled").equalsIgnoreCase("true") == true)
            {
                prjAutoUpdateSupport = 0;
            }
            else
            {
                prjAutoUpdateSupport = 1;
            }   
            if(ProjectManager.get("project_messaging_support_is_enabled").equalsIgnoreCase("true") == true)
            {
                prjMessagingSupport = 0;
            }
            else
            {
                prjMessagingSupport = 1;
            }   
            try
            {
                if(prjExpirationSupport==0)
                {
                   // if(ProjectManager.get("project_registration_code_support_is_enabled").equalsIgnoreCase("false") == true)
                    //{
                    //    props.put("isRegistered","true");        
                   // }                    
                    if(prjAutoUpdateSupport == 0 || prjMessagingSupport==0)
                    {
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/rules/reader/RuleEvaluator.class"));
                        theTempZipEntryList.add("com/trinity/ea/rules/reader/RuleEvaluator.class");                    
                    }
                    // if evaluation support is enabled                   
                    if(prjAutoUpdateSupport == 0)
                    {                   
                        //automatic update support enabled
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LockedOutAction.class"));
                        theTempZipEntryList.add("com/trinity/ea/actions/LockedOutAction.class");                                                            
                        theAUStartJarTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea3.jar").getFile()), "/com/trinity/ea/EvaluateAnywhere.class"));
                        theAUStartJarTempZipEntryList.add("com/trinity/ea/EvaluateAnywhere.class");
                        theAUStartJarTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea3.jar").getFile()), "/com/trinity/ea/rules/reader/EncryptedRuleReader.class"));
                        theAUStartJarTempZipEntryList.add("com/trinity/ea/rules/reader/EncryptedRuleReader.class"); 
                        theAUStartJarTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/rules/reader/Indexer.class"));
                        theAUStartJarTempZipEntryList.add("com/trinity/ea/rules/reader/Indexer.class"); 
                        theAUStartJarTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/rules/reader/IndexHandler.class"));
                        theAUStartJarTempZipEntryList.add("com/trinity/ea/rules/reader/IndexHandler.class");                          
                        theAUStartJarTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea3.jar").getFile()), "/com/trinity/ea/util/Trial.class"));
                        theAUStartJarTempZipEntryList.add("com/trinity/ea/util/Trial.class");                    
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/ConfigurationErrorAction.class"));
                        theTempZipEntryList.add("com/trinity/ea/actions/ConfigurationErrorAction.class");                    
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/util/SwingWorker.class"));
                        theTempZipEntryList.add("com/trinity/ea/util/SwingWorker.class");
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/util/SwingWorker$1.class"));
                        theTempZipEntryList.add("com/trinity/ea/util/SwingWorker$1.class");
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/util/SwingWorker$2.class"));
                        theTempZipEntryList.add("com/trinity/ea/util/SwingWorker$2.class");  
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/util/SwingWorker$ThreadVar.class"));
                        theTempZipEntryList.add("com/trinity/ea/util/SwingWorker$ThreadVar.class");                         

                        if(prjAutoUpdateSupport == 0 || prjMessagingSupport==0)
                        {
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LaunchApplicationAction.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/LaunchApplicationAction.class");                    
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LaunchApplicationAction$1.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/LaunchApplicationAction$1.class");     
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/AUThreadLauncher.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/AUThreadLauncher.class");      
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/AUThreadLauncher$1.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/AUThreadLauncher$1.class");                              
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LaunchApplicationNoUpdateAction.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/LaunchApplicationNoUpdateAction.class");                    
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LaunchApplicationNoUpdateAction$1.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/LaunchApplicationNoUpdateAction$1.class"); 
                        } 
                        else
                        {
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LaunchApplicationNoUpdateAction.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/LaunchApplicationNoUpdateAction.class");                    
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LaunchApplicationNoUpdateAction$1.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/LaunchApplicationNoUpdateAction$1.class");      
                        }
                        theAUStartJarTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea3.jar").getFile()), "/com/trinity/ea/util/EAProperties.class"));
                        theAUStartJarTempZipEntryList.add("com/trinity/ea/util/EAProperties.class"); 
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea3.jar").getFile()), "/com/trinity/ea/rules/reader/EAUpdater.class"));
                        theTempZipEntryList.add("com/trinity/ea/rules/reader/EAUpdater.class"); 
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/util/BrowserLauncher.class"));
                        theTempZipEntryList.add("com/trinity/ea/util/BrowserLauncher.class"); 
                        theAUStartJarTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea3.jar").getFile()), "/com/trinity/ea/rules/reader/RuleHandler.class"));
                        theAUStartJarTempZipEntryList.add("com/trinity/ea/rules/reader/RuleHandler.class"); 
                        theAUStartJarTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea3.jar").getFile()), "/com/trinity/ea/rules/reader/RuleHandlerShoe.class"));
                        theAUStartJarTempZipEntryList.add("com/trinity/ea/rules/reader/RuleHandlerShoe.class");                        
                    }
                    else
                    {
                        //automatic update support disabled
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LockedOutAction.class"));
                        theTempZipEntryList.add("com/trinity/ea/actions/LockedOutAction.class");                                                                                    
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/EvaluateAnywhere.class"));
                        theTempZipEntryList.add("com/trinity/ea/EvaluateAnywhere.class");
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/rules/reader/EncryptedRuleReader.class"));
                        theTempZipEntryList.add("com/trinity/ea/rules/reader/EncryptedRuleReader.class");
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/rules/reader/Indexer.class"));
                        theTempZipEntryList.add("com/trinity/ea/rules/reader/Indexer.class"); 
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/rules/reader/IndexHandler.class"));
                        theTempZipEntryList.add("com/trinity/ea/rules/reader/IndexHandler.class");                            
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/util/Trial.class"));
                        theTempZipEntryList.add("com/trinity/ea/util/Trial.class");                    
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/ConfigurationErrorAction.class"));
                        theTempZipEntryList.add("com/trinity/ea/actions/ConfigurationErrorAction.class");                    
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/util/SwingWorker.class"));
                        theTempZipEntryList.add("com/trinity/ea/util/SwingWorker.class");
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/util/SwingWorker$1.class"));
                        theTempZipEntryList.add("com/trinity/ea/util/SwingWorker$1.class");
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/util/SwingWorker$2.class"));
                        theTempZipEntryList.add("com/trinity/ea/util/SwingWorker$2.class");  
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/util/SwingWorker$ThreadVar.class"));
                        theTempZipEntryList.add("com/trinity/ea/util/SwingWorker$ThreadVar.class"); 
                        if(prjAutoUpdateSupport == 0 || prjMessagingSupport==0)
                        {
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LaunchApplicationAction.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/LaunchApplicationAction.class");                    
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LaunchApplicationAction$1.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/LaunchApplicationAction$1.class");     
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/AUThreadLauncher.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/AUThreadLauncher.class");      
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/AUThreadLauncher$1.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/AUThreadLauncher$1.class");                              
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LaunchApplicationNoUpdateAction.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/LaunchApplicationNoUpdateAction.class");                    
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LaunchApplicationNoUpdateAction$1.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/LaunchApplicationNoUpdateAction$1.class"); 
                        }
                        else
                        {
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LaunchApplicationNoUpdateAction.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/LaunchApplicationNoUpdateAction.class");                    
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LaunchApplicationNoUpdateAction$1.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/LaunchApplicationNoUpdateAction$1.class");      
                        }
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/util/BrowserLauncher.class"));
                        theTempZipEntryList.add("com/trinity/ea/util/BrowserLauncher.class"); 
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/util/EAProperties.class"));
                        theTempZipEntryList.add("com/trinity/ea/util/EAProperties.class");                          
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/rules/reader/RuleHandler.class"));
                        theTempZipEntryList.add("com/trinity/ea/rules/reader/RuleHandler.class"); 
                    }
                }
                else
                {
                   // if(ProjectManager.get("project_registration_code_support_is_enabled").equalsIgnoreCase("false") == true)
                    //{
                    //    props.put("isRegistered","true");        
                   // }
                    if(prjAutoUpdateSupport == 0 || prjMessagingSupport==0)
                    {
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/rules/reader/RuleEvaluator.class"));
                        theTempZipEntryList.add("com/trinity/ea/rules/reader/RuleEvaluator.class");                    
                    }                    
                    if(prjAutoUpdateSupport == 0)
                    {                   
                        //automatic update support enabled
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LockedOutAction.class"));
                        theTempZipEntryList.add("com/trinity/ea/actions/LockedOutAction.class");                                 
                        theAUStartJarTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea3.jar").getFile()), "/com/trinity/ea/EvaluateAnywhere.class"));
                        theAUStartJarTempZipEntryList.add("com/trinity/ea/EvaluateAnywhere.class");
                        theAUStartJarTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea3.jar").getFile()), "/com/trinity/ea/rules/reader/EncryptedRuleReader.class"));
                        theAUStartJarTempZipEntryList.add("com/trinity/ea/rules/reader/EncryptedRuleReader.class"); 
                        theAUStartJarTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/rules/reader/Indexer.class"));
                        theAUStartJarTempZipEntryList.add("com/trinity/ea/rules/reader/Indexer.class"); 
                        theAUStartJarTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/rules/reader/IndexHandler.class"));
                        theAUStartJarTempZipEntryList.add("com/trinity/ea/rules/reader/IndexHandler.class");                             
                        theAUStartJarTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea3.jar").getFile()), "/com/trinity/ea/util/Trial.class"));
                        theAUStartJarTempZipEntryList.add("com/trinity/ea/util/Trial.class");                    
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/ConfigurationErrorAction.class"));
                        theTempZipEntryList.add("com/trinity/ea/actions/ConfigurationErrorAction.class");                    
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/util/SwingWorker.class"));
                        theTempZipEntryList.add("com/trinity/ea/util/SwingWorker.class");
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/util/SwingWorker$1.class"));
                        theTempZipEntryList.add("com/trinity/ea/util/SwingWorker$1.class");
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/util/SwingWorker$2.class"));
                        theTempZipEntryList.add("com/trinity/ea/util/SwingWorker$2.class");  
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/util/SwingWorker$ThreadVar.class"));
                        theTempZipEntryList.add("com/trinity/ea/util/SwingWorker$ThreadVar.class"); 
                        if(prjAutoUpdateSupport == 0 || prjMessagingSupport==0)
                        {
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LaunchApplicationAction.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/LaunchApplicationAction.class");                    
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LaunchApplicationAction$1.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/LaunchApplicationAction$1.class");     
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/AUThreadLauncher.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/AUThreadLauncher.class");      
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/AUThreadLauncher$1.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/AUThreadLauncher$1.class");        
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LaunchApplicationNoUpdateAction.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/LaunchApplicationNoUpdateAction.class");                    
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LaunchApplicationNoUpdateAction$1.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/LaunchApplicationNoUpdateAction$1.class"); 
                        } 
                        else
                        { 
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LaunchApplicationNoUpdateAction.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/LaunchApplicationNoUpdateAction.class");                    
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LaunchApplicationNoUpdateAction$1.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/LaunchApplicationNoUpdateAction$1.class");      
                        }
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/util/BrowserLauncher.class"));
                        theTempZipEntryList.add("com/trinity/ea/util/BrowserLauncher.class"); 
                        theAUStartJarTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea3.jar").getFile()), "/com/trinity/ea/util/EAProperties.class"));
                        theAUStartJarTempZipEntryList.add("com/trinity/ea/util/EAProperties.class"); 
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea3.jar").getFile()), "/com/trinity/ea/rules/reader/EAUpdater.class"));
                        theTempZipEntryList.add("com/trinity/ea/rules/reader/EAUpdater.class"); 
                        theAUStartJarTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea3.jar").getFile()), "/com/trinity/ea/rules/reader/RuleHandler.class"));
                        theAUStartJarTempZipEntryList.add("com/trinity/ea/rules/reader/RuleHandler.class"); 
                        theAUStartJarTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea3.jar").getFile()), "/com/trinity/ea/rules/reader/RuleHandlerShoe.class"));
                        theAUStartJarTempZipEntryList.add("com/trinity/ea/rules/reader/RuleHandlerShoe.class");                        
                    }
                    else
                    {                    
                         // if evaluation support is not enabled
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LockedOutAction.class"));
                        theTempZipEntryList.add("com/trinity/ea/actions/LockedOutAction.class");                                                                        
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea2.jar").getFile()), "/com/trinity/ea/EvaluateAnywhere.class"));
                        theTempZipEntryList.add("com/trinity/ea/EvaluateAnywhere.class");                    
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/rules/reader/EncryptedRuleReader.class"));
                        theTempZipEntryList.add("com/trinity/ea/rules/reader/EncryptedRuleReader.class");  
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/rules/reader/Indexer.class"));
                        theTempZipEntryList.add("com/trinity/ea/rules/reader/Indexer.class"); 
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/rules/reader/IndexHandler.class"));
                        theTempZipEntryList.add("com/trinity/ea/rules/reader/IndexHandler.class");                                
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/util/Trial.class"));
                        theTempZipEntryList.add("com/trinity/ea/util/Trial.class");                    
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/ConfigurationErrorAction.class"));
                        theTempZipEntryList.add("com/trinity/ea/actions/ConfigurationErrorAction.class");                    
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/util/SwingWorker.class"));
                        theTempZipEntryList.add("com/trinity/ea/util/SwingWorker.class");
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/util/SwingWorker$1.class"));
                        theTempZipEntryList.add("com/trinity/ea/util/SwingWorker$1.class");
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/util/SwingWorker$2.class"));
                        theTempZipEntryList.add("com/trinity/ea/util/SwingWorker$2.class");  
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/util/SwingWorker$ThreadVar.class"));
                        theTempZipEntryList.add("com/trinity/ea/util/SwingWorker$ThreadVar.class");                    
                        if(prjAutoUpdateSupport == 0 || prjMessagingSupport==0)
                        {
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LaunchApplicationAction.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/LaunchApplicationAction.class");                    
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LaunchApplicationAction$1.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/LaunchApplicationAction$1.class");     
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/AUThreadLauncher.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/AUThreadLauncher.class");      
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/AUThreadLauncher$1.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/AUThreadLauncher$1.class");                             
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LaunchApplicationNoUpdateAction.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/LaunchApplicationNoUpdateAction.class");                    
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LaunchApplicationNoUpdateAction$1.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/LaunchApplicationNoUpdateAction$1.class"); 
                        }
                        else
                        {
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LaunchApplicationNoUpdateAction.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/LaunchApplicationNoUpdateAction.class");                    
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LaunchApplicationNoUpdateAction$1.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/LaunchApplicationNoUpdateAction$1.class");      
                        }
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/util/BrowserLauncher.class"));
                        theTempZipEntryList.add("com/trinity/ea/util/BrowserLauncher.class"); 
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/util/EAProperties.class"));
                        theTempZipEntryList.add("com/trinity/ea/util/EAProperties.class"); 
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/rules/reader/RuleHandler.class"));
                        theTempZipEntryList.add("com/trinity/ea/rules/reader/RuleHandler.class");                       
                    }
                }
                
                // registration code support               
                if(prjRegistrationSupport==0)
                {    
                    // registration code support is enabled
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/registration/ui/swing/dlgRegActivationCode.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/registration/ui/swing/dlgRegActivationCode.class");                    
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/registration/ui/swing/dlgRegActivationCode$1.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/registration/ui/swing/dlgRegActivationCode$1.class");                    
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/registration/ui/swing/dlgRegActivationCode$2.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/registration/ui/swing/dlgRegActivationCode$2.class");                    
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/registration/ui/swing/dlgRegActivationCode$3.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/registration/ui/swing/dlgRegActivationCode$3.class");                    
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/registration/ui/swing/dlgRegActivationCode$4.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/registration/ui/swing/dlgRegActivationCode$4.class");                    
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/registration/ui/swing/dlgRegActivationCode$5.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/registration/ui/swing/dlgRegActivationCode$5.class");                    
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/registration/ui/swing/dlgRegistrationSuccess.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/registration/ui/swing/dlgRegistrationSuccess.class");                        
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/registration/ui/swing/dlgRegistrationSuccess$1.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/registration/ui/swing/dlgRegistrationSuccess$1.class");                        
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/registration/ui/swing/dlgRegistrationSuccess$2.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/registration/ui/swing/dlgRegistrationSuccess$2.class");                        
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/registration/ui/swing/dlgRegistrationSuccess$3.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/registration/ui/swing/dlgRegistrationSuccess$3.class");                        
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/registration/ui/swing/dlgRegistrationSuccess$4.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/registration/ui/swing/dlgRegistrationSuccess$4.class");         
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/registration/ui/swing/dlgRegistrationFailure.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/registration/ui/swing/dlgRegistrationFailure.class");                        
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/registration/ui/swing/dlgRegistrationFailure$1.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/registration/ui/swing/dlgRegistrationFailure$1.class");                        
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/registration/ui/swing/dlgRegistrationFailure$2.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/registration/ui/swing/dlgRegistrationFailure$2.class");                        
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/registration/ui/swing/dlgRegistrationFailure$3.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/registration/ui/swing/dlgRegistrationFailure$3.class");                        
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/registration/ui/swing/dlgRegistrationFailure$4.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/registration/ui/swing/dlgRegistrationFailure$4.class");                        
                    //Registration Code Actions
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/EnterRegActCodeAction.class"));
                    theTempZipEntryList.add("com/trinity/ea/actions/EnterRegActCodeAction.class");                    
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/RegistrationSuccessUIAction.class"));
                    theTempZipEntryList.add("com/trinity/ea/actions/RegistrationSuccessUIAction.class");                    
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/RegistrationFailedUIAction.class"));
                    theTempZipEntryList.add("com/trinity/ea/actions/RegistrationFailedUIAction.class");                    
                    //TODO: Add Additional Action for Restart on Registration (may be a logic block for the registrationSucceededAction.
                }
                else
                {
                    // registration code support is disabled
                }
                if(prjPaymentSupport==0 || prjRegistrationSupport==0)
                {                   
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/RegistrationCompleteFinishedAction.class"));
                    theTempZipEntryList.add("com/trinity/ea/actions/RegistrationCompleteFinishedAction.class");                 
                }
                
  
                 // optin support               
                if(prjOptinSupport==0)
                {   
                    // optin support is enabled  
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/OptinAction.class"));
                    theTempZipEntryList.add("com/trinity/ea/actions/OptinAction.class");                    
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/optin/dlgEMailOptin.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/optin/dlgEMailOptin.class");   
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/optin/dlgEMailOptin$1.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/optin/dlgEMailOptin$1.class");  
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/optin/emailOptin.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/optin/emailOptin.class");   
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/optin/emailOptin$1.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/optin/emailOptin$1.class");      
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/optin/emailOptin$2.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/optin/emailOptin$2.class");                        
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/optin/emailOptin$3.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/optin/emailOptin$3.class");    
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/optin/emailOptin$4.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/optin/emailOptin$4.class");    
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/optin/emailOptin$5.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/optin/emailOptin$5.class");                        
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/optin/emailOptin$6.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/optin/emailOptin$6.class");                       
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/optin/emailOptin$7.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/optin/emailOptin$7.class");                        
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/optin/emailOptin$8.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/optin/emailOptin$8.class");                         
                    if(ProjectManager.get("optinPrivacyPolicyEnabled").equalsIgnoreCase("true")==true && ProjectManager.get("privacyPolicyActionType").equalsIgnoreCase("1")==true)
                    {                
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/optin/PrivacyPolicy.class"));
                        theTempZipEntryList.add("com/trinity/ea/forms/optin/PrivacyPolicy.class");   
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/optin/PrivacyPolicy$1.class"));
                        theTempZipEntryList.add("com/trinity/ea/forms/optin/PrivacyPolicy$1.class");      
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/optin/PrivacyPolicy$2.class"));
                        theTempZipEntryList.add("com/trinity/ea/forms/optin/PrivacyPolicy$2.class");                        
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/optin/PrivacyPolicy$3.class"));
                        theTempZipEntryList.add("com/trinity/ea/forms/optin/PrivacyPolicy$3.class");    
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/optin/PrivacyPolicy$4.class"));
                        theTempZipEntryList.add("com/trinity/ea/forms/optin/PrivacyPolicy$4.class"); 
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/PrivacyPolicyAction.class"));
                        theTempZipEntryList.add("com/trinity/ea/actions/PrivacyPolicyAction.class");                      
                    }
                }
                else
                {
                    // optin support is disabled                       
                }
                
                // payment processing support               
                if(prjPaymentSupport==0)
                {   
                   try
                    { 
                        if(ProjectManager.get("paymentFormInputBackgroundImagePath")!=null)
                        {
                            if(ProjectManager.get("paymentFormInputBackgroundImagePath").equalsIgnoreCase("")==false)
                            {
                                if(ProjectManager.get("paymentPhoneInputEnabled").equalsIgnoreCase("true")==true && ProjectManager.get("paymentFormInputBackgroundImagePath").equalsIgnoreCase(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/frame.png").toString())==true)
                                {
                                        try
                                        {
                                            ProjectManager.put("paymentFormInputBackgroundImagePath",new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/framepho.png").toString());
                                        }
                                        catch(Exception e)
                                        {

                                        }
                                }
                                else if(ProjectManager.get("paymentPhoneInputEnabled").equalsIgnoreCase("false")==true && ProjectManager.get("paymentFormInputBackgroundImagePath").equalsIgnoreCase(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/framepho.png").toString())==true)
                                {
                                        try
                                        {
                                             ProjectManager.put("paymentFormInputBackgroundImagePath",new URL(new File(System.getProperty("user.dir")).toURL().toString() + "lib/images/frame.png").toString());
                                        }
                                        catch(Exception e)
                                        {

                                        }
                                }
                            }
                        }
                    }
                    catch(Exception e)
                    {
                            //e.printStackTrace();
                    }                             
                    // payment processing support is enabled                    
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/BuyNowAction.class"));
                    theTempZipEntryList.add("com/trinity/ea/actions/BuyNowAction.class");                    
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/RefundPolicyAction.class"));
                    theTempZipEntryList.add("com/trinity/ea/actions/RefundPolicyAction.class");                    
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/data/CCCountries.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/data/CCCountries.class");                    
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/data/CCStates.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/data/CCStates.class");                    
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/data/RandomNumberGenerator.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/data/RandomNumberGenerator.class");                    
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/CustomerBillingInformationPanel.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/CustomerBillingInformationPanel.class");     
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/CustomerBillingInformationPanel$1.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/CustomerBillingInformationPanel$1.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/CustomerBillingInformationPanel$2.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/CustomerBillingInformationPanel$2.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/CustomerBillingInformationPanel$3.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/CustomerBillingInformationPanel$3.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/CustomerBillingInformationPanel$4.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/CustomerBillingInformationPanel$4.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/CustomerBillingInformationPanel$5.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/CustomerBillingInformationPanel$5.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/CustomerBillingInformationPanel$6.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/CustomerBillingInformationPanel$6.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/CustomerBillingInformationPanel$7.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/CustomerBillingInformationPanel$7.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/SecondaryPaymentMethodPanel.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/SecondaryPaymentMethodPanel.class");     
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/SecondaryPaymentMethodPanel$1.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/SecondaryPaymentMethodPanel$1.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/SecondaryPaymentMethodPanel$2.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/SecondaryPaymentMethodPanel$2.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/SecureOrderInformationPanel.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/SecureOrderInformationPanel.class");     
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/PaymentProcessingDialog.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/PaymentProcessingDialog.class");     
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/PaymentProcessingDialog$1.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/PaymentProcessingDialog$1.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/PaymentProcessingDialog$2.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/PaymentProcessingDialog$2.class"); 
                    //theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/PaymentProcessingDialog$3.class"));
                    //theTempZipEntryList.add("com/trinity/ea/forms/payment/PaymentProcessingDialog$3.class");                    
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/RefundPolicy.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/RefundPolicy.class");     
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/RefundPolicy$1.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/RefundPolicy$1.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/RefundPolicy$2.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/RefundPolicy$2.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/RefundPolicy$3.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/RefundPolicy$3.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/RefundPolicy$4.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/RefundPolicy$4.class"); 
                   
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/PaymentSuccessCenterPanel.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/PaymentSuccessCenterPanel.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/PaymentSuccessFooterPanel.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/PaymentSuccessFooterPanel.class");     
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/PaymentSuccessFooterPanel$1.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/PaymentSuccessFooterPanel$1.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/PaymentSuccessFooterPanel$2.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/PaymentSuccessFooterPanel$2.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/PaymentSuccessFooterPanel$3.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/PaymentSuccessFooterPanel$3.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/PaymentValidationHeaderPanel.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/PaymentValidationHeaderPanel.class");     
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/dlgCustomerBillingResponsePanelSuccess.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/dlgCustomerBillingResponsePanelSuccess.class");     
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/dlgCustomerBillingResponsePanelSuccess$1.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/dlgCustomerBillingResponsePanelSuccess$1.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/dlgCustomerBillingResponsePanelSuccess$2.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/dlgCustomerBillingResponsePanelSuccess$2.class");  
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/PaymentFailureValidationHeaderPanel.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/PaymentFailureValidationHeaderPanel.class");                    
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/PaymentFailureRightPanel.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/PaymentFailureRightPanel.class");     
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/PaymentFailureRightPanel$1.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/PaymentFailureRightPanel$1.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/PaymentFailureRightPanel$2.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/PaymentFailureRightPanel$2.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/PaymentFailureRightPanel$3.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/PaymentFailureRightPanel$3.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/PaymentFailedCenterPanel.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/PaymentFailedCenterPanel.class");     
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/LeftFillerPanelPaymentFailure.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/LeftFillerPanelPaymentFailure.class");                         
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/BottomFillerPanelPaymentFailure.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/BottomFillerPanelPaymentFailure.class");             
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/dlgCustomerBillingResponsePanelFailure.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/dlgCustomerBillingResponsePanelFailure.class");     
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/dlgCustomerBillingResponsePanelFailure$1.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/dlgCustomerBillingResponsePanelFailure$1.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/payment/dlgCustomerBillingResponsePanelFailure$2.class"));
                    theTempZipEntryList.add("com/trinity/ea/forms/payment/dlgCustomerBillingResponsePanelFailure$2.class");                    
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/UnknownHostExceptionAction.class"));
                    theTempZipEntryList.add("com/trinity/ea/actions/UnknownHostExceptionAction.class");             
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/SocketExceptionAction.class"));
                    theTempZipEntryList.add("com/trinity/ea/actions/SocketExceptionAction.class");            
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/OrderIDGeneratorAction.class"));
                    theTempZipEntryList.add("com/trinity/ea/actions/OrderIDGeneratorAction.class");            
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/idef/IOrderIDGenerator.class"));
                    theTempZipEntryList.add("com/trinity/ea/idef/IOrderIDGenerator.class"); 
                    if(urlExists(ProjectManager.get("paymentFormLeftTopImagePath"))==true)
                    {
                        if(theTempZipEntryList.contains("images/" + ProjectManager.get("paymentFormLeftTopImagePath").substring(ProjectManager.get("paymentFormLeftTopImagePath").lastIndexOf("/") + 1))==false)
                        {
                            theTempList1.add(EncryptedRuleBuilder.encryptByteArray(getURLByteArray(new URL(ProjectManager.get("paymentFormLeftTopImagePath")))));
                            theTempZipEntryList.add("images/" + ProjectManager.get("paymentFormLeftTopImagePath").substring(ProjectManager.get("paymentFormLeftTopImagePath").lastIndexOf("/") + 1));               
                        }
                    }
                    if(urlExists(ProjectManager.get("paymentFormRightTopImagePath"))==true)
                    {
                        if(theTempZipEntryList.contains("images/" + ProjectManager.get("paymentFormRightTopImagePath").substring(ProjectManager.get("paymentFormRightTopImagePath").lastIndexOf("/") + 1))==false)
                        {                        
                            theTempList1.add(EncryptedRuleBuilder.encryptByteArray(getURLByteArray(new URL(ProjectManager.get("paymentFormRightTopImagePath")))));
                            theTempZipEntryList.add("images/" + ProjectManager.get("paymentFormRightTopImagePath").substring(ProjectManager.get("paymentFormRightTopImagePath").lastIndexOf("/") + 1));               
                        }
                    }
                    if(ProjectManager.get("paymentFormProductLabelImageEnabled")!=null)
                    {
                        if(ProjectManager.get("paymentFormProductLabelImageEnabled").equalsIgnoreCase("true")==true)
                        {
                            if(urlExists(ProjectManager.get("paymentFormProductLabel"))==true)
                            {
                                if(theTempZipEntryList.contains("images/" + ProjectManager.get("paymentFormProductLabel").substring(ProjectManager.get("paymentFormProductLabel").lastIndexOf("/") + 1))==false)
                                {
                                        theTempList1.add(EncryptedRuleBuilder.encryptByteArray(getURLByteArray(new URL(ProjectManager.get("paymentFormProductLabel")))));
                                        theTempZipEntryList.add("images/" + ProjectManager.get("paymentFormProductLabel").substring(ProjectManager.get("paymentFormProductLabel").lastIndexOf("/") + 1));               
                                }
                            }
                        }
                    }
                    if(urlExists(ProjectManager.get("paymentFormInputBackgroundImagePath"))==true)
                    {
                        if(theTempZipEntryList.contains("images/" + ProjectManager.get("paymentFormInputBackgroundImagePath").substring(ProjectManager.get("paymentFormInputBackgroundImagePath").lastIndexOf("/") + 1))==false)
                        {
                            theTempList1.add(EncryptedRuleBuilder.encryptByteArray(getURLByteArray(new URL(ProjectManager.get("paymentFormInputBackgroundImagePath")))));
                            theTempZipEntryList.add("images/" + ProjectManager.get("paymentFormInputBackgroundImagePath").substring(ProjectManager.get("paymentFormInputBackgroundImagePath").lastIndexOf("/") + 1));               
                        }
                    }
                    if(ProjectManager.get("secondaryPaymentMethodEnabled")!=null)
                    {
                        if(ProjectManager.get("secondaryPaymentMethodEnabled").equalsIgnoreCase("true")==true)
                        {
                            if(urlExists(ProjectManager.get("paymentImgSecondaryButtonFace"))==true)
                            {
                                if(theTempZipEntryList.contains("images/" + ProjectManager.get("paymentImgSecondaryButtonFace").substring(ProjectManager.get("paymentImgSecondaryButtonFace").lastIndexOf("/") + 1))==false)
                                {
                                        theTempList1.add(getURLByteArray(new URL(ProjectManager.get("paymentImgSecondaryButtonFace"))));
                                        theTempZipEntryList.add("images/" + ProjectManager.get("paymentImgSecondaryButtonFace").substring(ProjectManager.get("paymentImgSecondaryButtonFace").lastIndexOf("/") + 1));               
                                } 
                            } 
                            if(urlExists(ProjectManager.get("paymentImgSecondaryButtonFaceOnClick"))==true)
                            {
                                if(theTempZipEntryList.contains("images/" + ProjectManager.get("paymentImgSecondaryButtonFaceOnClick").substring(ProjectManager.get("paymentImgSecondaryButtonFaceOnClick").lastIndexOf("/") + 1))==false)
                                {
                                        theTempList1.add(getURLByteArray(new URL(ProjectManager.get("paymentImgSecondaryButtonFaceOnClick"))));
                                        theTempZipEntryList.add("images/" + ProjectManager.get("paymentImgSecondaryButtonFaceOnClick").substring(ProjectManager.get("paymentImgSecondaryButtonFaceOnClick").lastIndexOf("/") + 1));               
                                } 
                            } 
                            if(urlExists(ProjectManager.get("paymentImgSecondaryButtonFaceInFocus"))==true)
                            {
                                if(theTempZipEntryList.contains("images/" + ProjectManager.get("paymentImgSecondaryButtonFaceInFocus").substring(ProjectManager.get("paymentImgSecondaryButtonFaceInFocus").lastIndexOf("/") + 1))==false)
                                {
                                        theTempList1.add(getURLByteArray(new URL(ProjectManager.get("paymentImgSecondaryButtonFaceInFocus"))));
                                        theTempZipEntryList.add("images/" + ProjectManager.get("paymentImgSecondaryButtonFaceInFocus").substring(ProjectManager.get("paymentImgSecondaryButtonFaceInFocus").lastIndexOf("/") + 1));               
                                } 
                            }                             
                        }
                    }                   
                    if(urlExists(ProjectManager.get("paymentRespFailureBackgroundImagePath"))==true)
                    {
                        if(theTempZipEntryList.contains("images/" + ProjectManager.get("paymentRespFailureBackgroundImagePath").substring(ProjectManager.get("paymentRespFailureBackgroundImagePath").lastIndexOf("/") + 1))==false)
                        {
                            theTempList1.add(EncryptedRuleBuilder.encryptByteArray(getURLByteArray(new URL(ProjectManager.get("paymentRespFailureBackgroundImagePath")))));
                            theTempZipEntryList.add("images/" + ProjectManager.get("paymentRespFailureBackgroundImagePath").substring(ProjectManager.get("paymentRespFailureBackgroundImagePath").lastIndexOf("/") + 1));               
                        }   
                    }
                    if(urlExists(ProjectManager.get("paymentRespSuccessBackgroundImagePath"))==true)
                    {
                        if(theTempZipEntryList.contains("images/" + ProjectManager.get("paymentRespSuccessBackgroundImagePath").substring(ProjectManager.get("paymentRespSuccessBackgroundImagePath").lastIndexOf("/") + 1))==false)
                        {
                            theTempList1.add(EncryptedRuleBuilder.encryptByteArray(getURLByteArray(new URL(ProjectManager.get("paymentRespSuccessBackgroundImagePath")))));
                            theTempZipEntryList.add("images/" + ProjectManager.get("paymentRespSuccessBackgroundImagePath").substring(ProjectManager.get("paymentRespSuccessBackgroundImagePath").lastIndexOf("/") + 1));               
                        }    
                    }
                    
                } 
                else
                {
                    // payment processing support is disabled                    
                }
                
                // automatic update support
                if(prjAutoUpdateSupport == 0)
                {
                     // automatic update support is enabled
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/autoupdate/AutoUpdateManager.class"));
                    theTempZipEntryList.add("com/trinity/ea/autoupdate/AutoUpdateManager.class");            
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/autoupdate/actions/ErrorMessageAction.class"));
                    theTempZipEntryList.add("com/trinity/ea/autoupdate/actions/ErrorMessageAction.class");            
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/autoupdate/actions/InstallUpdateAction.class"));
                    theTempZipEntryList.add("com/trinity/ea/autoupdate/actions/InstallUpdateAction.class");   
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/autoupdate/actions/InstallUpdateSkipAction.class"));
                    theTempZipEntryList.add("com/trinity/ea/autoupdate/actions/InstallUpdateSkipAction.class");                       
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/autoupdate/actions/WillNotCompleteAction.class"));
                    theTempZipEntryList.add("com/trinity/ea/autoupdate/actions/WillNotCompleteAction.class");                       
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/autoupdate/install/UpdateInstaller.class"));
                    theTempZipEntryList.add("com/trinity/ea/autoupdate/install/UpdateInstaller.class");                       
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/autoupdate/messaging/EAMessageScrollBarUI.class"));
                    theTempZipEntryList.add("com/trinity/ea/autoupdate/messaging/EAMessageScrollBarUI.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/autoupdate/messaging/MessageDialog.class"));
                    theTempZipEntryList.add("com/trinity/ea/autoupdate/messaging/MessageDialog.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/autoupdate/messaging/MessageDialog$1.class"));
                    theTempZipEntryList.add("com/trinity/ea/autoupdate/messaging/MessageDialog$1.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/autoupdate/messaging/MessageDialog$2.class"));
                    theTempZipEntryList.add("com/trinity/ea/autoupdate/messaging/MessageDialog$2.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/autoupdate/messaging/MessageDialog$3.class"));
                    theTempZipEntryList.add("com/trinity/ea/autoupdate/messaging/MessageDialog$3.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/autoupdate/messaging/MessageDialog$4.class"));
                    theTempZipEntryList.add("com/trinity/ea/autoupdate/messaging/MessageDialog$4.class");                 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/autoupdate/messaging/MessageDialog$5.class"));
                    theTempZipEntryList.add("com/trinity/ea/autoupdate/messaging/MessageDialog$5.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/autoupdate/messaging/MessageDialog$6.class"));
                    theTempZipEntryList.add("com/trinity/ea/autoupdate/messaging/MessageDialog$6.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/autoupdate/messaging/MessagePane.class"));
                    theTempZipEntryList.add("com/trinity/ea/autoupdate/messaging/MessagePane.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/autoupdate/net/FileDownloaderManager.class"));
                    theTempZipEntryList.add("com/trinity/ea/autoupdate/net/FileDownloaderManager.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/autoupdate/reader/EncryptedUpdateReader.class"));
                    theTempZipEntryList.add("com/trinity/ea/autoupdate/reader/EncryptedUpdateReader.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/autoupdate/reader/UpdateHandler.class"));
                    theTempZipEntryList.add("com/trinity/ea/autoupdate/reader/UpdateHandler.class");         
                }
                else
                {
                     // automatic update support is disabled   
                }

                // messaging support                
                if(prjMessagingSupport==0)
                {
                     // messaging support is enabled  
                     theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/rules/reader/RuleHandlerMessageShoe.class"));
                     theTempZipEntryList.add("com/trinity/ea/rules/reader/RuleHandlerMessageShoe.class");                   
                     theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/messaging/MessageManager.class"));
                     theTempZipEntryList.add("com/trinity/ea/messaging/MessageManager.class");            
                     theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/messaging/net/MessageDownloaderManager.class"));
                     theTempZipEntryList.add("com/trinity/ea/messaging/net/MessageDownloaderManager.class");            
                     theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/messaging/reader/EncryptedMessageReader.class"));
                     theTempZipEntryList.add("com/trinity/ea/messaging/reader/EncryptedMessageReader.class");            
                     theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/messaging/reader/MessageHandler.class"));
                     theTempZipEntryList.add("com/trinity/ea/messaging/reader/MessageHandler.class");                      
                     theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/messaging/ui/swing/EAMessageScrollBarUI.class"));
                     theTempZipEntryList.add("com/trinity/ea/messaging/ui/swing/EAMessageScrollBarUI.class");                      
                     theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/messaging/ui/swing/MessagePane.class"));
                     theTempZipEntryList.add("com/trinity/ea/messaging/ui/swing/MessagePane.class");                      
                     theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/messaging/ui/swing/MessageDialog.class"));
                     theTempZipEntryList.add("com/trinity/ea/messaging/ui/swing/MessageDialog.class"); 
                     theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/messaging/ui/swing/MessageDialog$1.class"));
                     theTempZipEntryList.add("com/trinity/ea/messaging/ui/swing/MessageDialog$1.class");                      
                     theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/messaging/ui/swing/MessageDialog$2.class"));
                     theTempZipEntryList.add("com/trinity/ea/messaging/ui/swing/MessageDialog$2.class");  
                     theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/messaging/ui/swing/MessageDialog$3.class"));
                     theTempZipEntryList.add("com/trinity/ea/messaging/ui/swing/MessageDialog$3.class");  
                     theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/messaging/ui/swing/MessageDialog$4.class"));
                     theTempZipEntryList.add("com/trinity/ea/messaging/ui/swing/MessageDialog$4.class");                       
                }
                else
                { 
                     // messaging support is disabled    
                }
 
                // common files between autoupdate, messaging support
                if(prjAutoUpdateSupport == 0 || prjMessagingSupport==0)
                {   
                    if(urlExists(ProjectManager.get("msgHeaderImgPath"))==true)
                    {
                        if(theTempZipEntryList.contains("images/" + ProjectManager.get("msgHeaderImgPath").substring(ProjectManager.get("msgHeaderImgPath").lastIndexOf("/") + 1))==false)
                        {
                            theTempList1.add(EncryptedRuleBuilder.encryptByteArray(getURLByteArray(new URL(ProjectManager.get("msgHeaderImgPath")))));
                            theTempZipEntryList.add("images/" + ProjectManager.get("msgHeaderImgPath").substring(ProjectManager.get("msgHeaderImgPath").lastIndexOf("/") + 1));               
                        }
                    }
                    if(urlExists(ProjectManager.get("msgBGImgPath"))==true)
                    {
                        if(theTempZipEntryList.contains("images/" + ProjectManager.get("msgBGImgPath").substring(ProjectManager.get("msgBGImgPath").lastIndexOf("/") + 1))==false)
                        {
                            theTempList1.add(EncryptedRuleBuilder.encryptByteArray(getURLByteArray(new URL(ProjectManager.get("msgBGImgPath")))));
                            theTempZipEntryList.add("images/" + ProjectManager.get("msgBGImgPath").substring(ProjectManager.get("msgBGImgPath").lastIndexOf("/") + 1));               
                        }
                    }           
                }
                
                // common files between optin, autoupdate, messaging support
                if(prjAutoUpdateSupport == 0 || prjMessagingSupport==0 || prjOptinSupport==0)
                {
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/net/FileDownloader.class"));
                    theTempZipEntryList.add("com/trinity/ea/net/FileDownloader.class");   
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/net/WebConnectionRequest.class"));
                    theTempZipEntryList.add("com/trinity/ea/net/WebConnectionRequest.class");                      
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/net/WebConnectionRequest$1.class"));
                    theTempZipEntryList.add("com/trinity/ea/net/WebConnectionRequest$1.class"); 
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/parser/HTMLParser.class"));
                    theTempZipEntryList.add("com/trinity/ea/parser/HTMLParser.class");   
                    theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/parser/HTTPGETRequestParser.class"));
                    theTempZipEntryList.add("com/trinity/ea/parser/HTTPGETRequestParser.class");                        
                    if(prjAutoUpdateSupport == 0 || prjMessagingSupport==0)    
                    {
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LaunchApplicationSkipAction.class"));
                        theTempZipEntryList.add("com/trinity/ea/actions/LaunchApplicationSkipAction.class");  
                    }
                    else
                    {
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LaunchApplicationSkipAction.class"));
                        theTempZipEntryList.add("com/trinity/ea/actions/LaunchApplicationSkipAction.class");  
                    }
                }
                //else if((prjAutoUpdateSupport == 0 || prjMessagingSupport==0) && prjOptinSupport!=0)
                //{
                //    theAUStartJarTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/net/FileDownloader.class"));
                //    theAUStartJarTempZipEntryList.add("com/trinity/ea/net/FileDownloader.class");   
                //    theAUStartJarTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/net/WebConnectionRequest.class"));
                //    theAUStartJarTempZipEntryList.add("com/trinity/ea/net/WebConnectionRequest.class");                      
                //    theAUStartJarTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/net/WebConnectionRequest$1.class"));
                //    theAUStartJarTempZipEntryList.add("com/trinity/ea/net/WebConnectionRequest$1.class");                     
                //    theAUStartJarTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/LaunchApplicationSkipAction.class"));
                //    theAUStartJarTempZipEntryList.add("com/trinity/ea/actions/LaunchApplicationSkipAction.class");     
                //}               
                // startup window
                // classes go here...
                try
                {
                    if(prjPaymentSupport == 0 || prjRegistrationSupport == 0 || prjExpirationSupport == 0)
                    {                    
                        if(ProjectManager.get("project_gui_model")!=null)
                        {
                            if(ProjectManager.get("project_gui_model").equalsIgnoreCase("0")==true)
                            {    
                                theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/StartVerticalButtonBarThemeAction.class"));
                                theTempZipEntryList.add("com/trinity/ea/actions/StartVerticalButtonBarThemeAction.class");     
                                theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/startupui/swing/dlgStartupWindowVerticalButtonBar.class"));
                                theTempZipEntryList.add("com/trinity/ea/forms/startupui/swing/dlgStartupWindowVerticalButtonBar.class");     
                                theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/startupui/swing/dlgStartupWindowVerticalButtonBar$1.class"));
                                theTempZipEntryList.add("com/trinity/ea/forms/startupui/swing/dlgStartupWindowVerticalButtonBar$1.class");                     
                                theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/startupui/swing/StartupWindowPanelVerticalButtonBar.class"));
                                theTempZipEntryList.add("com/trinity/ea/forms/startupui/swing/StartupWindowPanelVerticalButtonBar.class");     
                                theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/startupui/swing/DaysLeftCounter.class"));
                                theTempZipEntryList.add("com/trinity/ea/forms/startupui/swing/DaysLeftCounter.class");     
                                theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/startupui/swing/EAAboutButton.class"));
                                theTempZipEntryList.add("com/trinity/ea/forms/startupui/swing/EAAboutButton.class");     
                                theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/startupui/swing/EAAboutButton$1.class"));
                                theTempZipEntryList.add("com/trinity/ea/forms/startupui/swing/EAAboutButton$1.class");                                                   
                                theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/startupui/swing/SplashImagePanel.class"));
                                theTempZipEntryList.add("com/trinity/ea/forms/startupui/swing/SplashImagePanel.class");      
                                theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/startupui/swing/ButtonPanel.class"));
                                theTempZipEntryList.add("com/trinity/ea/forms/startupui/swing/ButtonPanel.class");    
                                theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/startupui/swing/ButtonPanel$1.class"));
                                theTempZipEntryList.add("com/trinity/ea/forms/startupui/swing/ButtonPanel$1.class");     
                                theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/startupui/swing/ButtonPanel$2.class"));
                                theTempZipEntryList.add("com/trinity/ea/forms/startupui/swing/ButtonPanel$2.class");                 
                                theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/startupui/swing/ButtonPanel$3.class"));
                                theTempZipEntryList.add("com/trinity/ea/forms/startupui/swing/ButtonPanel$3.class");                     
                                theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/startupui/swing/ButtonPanel$4.class"));
                                theTempZipEntryList.add("com/trinity/ea/forms/startupui/swing/ButtonPanel$4.class");                 
                                theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/startupui/swing/ButtonPanel$5.class"));
                                theTempZipEntryList.add("com/trinity/ea/forms/startupui/swing/ButtonPanel$5.class");     
                                theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/startupui/swing/ButtonPanel$6.class"));
                                theTempZipEntryList.add("com/trinity/ea/forms/startupui/swing/ButtonPanel$6.class");                 
                                theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/startupui/swing/ButtonPanel$7.class"));
                                theTempZipEntryList.add("com/trinity/ea/forms/startupui/swing/ButtonPanel$7.class");                        
                                theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/startupui/swing/ButtonPanel$8.class"));
                                theTempZipEntryList.add("com/trinity/ea/forms/startupui/swing/ButtonPanel$8.class");                 
                                theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/startupui/swing/ButtonPanel$9.class"));
                                theTempZipEntryList.add("com/trinity/ea/forms/startupui/swing/ButtonPanel$9.class");     
                                theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/startupui/swing/ButtonPanel$10.class"));
                                theTempZipEntryList.add("com/trinity/ea/forms/startupui/swing/ButtonPanel$10.class");                 
                                theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/startupui/swing/ButtonPanel$11.class"));
                                theTempZipEntryList.add("com/trinity/ea/forms/startupui/swing/ButtonPanel$11.class");                     
                                theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/startupui/swing/ButtonPanel$12.class"));
                                theTempZipEntryList.add("com/trinity/ea/forms/startupui/swing/ButtonPanel$12.class");                 
                                theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/startupui/swing/ButtonPanel$13.class"));
                                theTempZipEntryList.add("com/trinity/ea/forms/startupui/swing/ButtonPanel$13.class");     
                                theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/startupui/swing/ButtonPanel$14.class"));
                                theTempZipEntryList.add("com/trinity/ea/forms/startupui/swing/ButtonPanel$14.class");                 
                                theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/startupui/swing/ButtonPanel$15.class"));
                                theTempZipEntryList.add("com/trinity/ea/forms/startupui/swing/ButtonPanel$15.class");      
                                theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/startupui/swing/ButtonPanel$16.class"));
                                theTempZipEntryList.add("com/trinity/ea/forms/startupui/swing/ButtonPanel$16.class");      
                                theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/startupui/swing/ButtonPanel$17.class"));
                                theTempZipEntryList.add("com/trinity/ea/forms/startupui/swing/ButtonPanel$17.class");  
                                 if(urlExists(ProjectManager.get("splashImgPath"))==true)
                                 {
                                     if(theTempZipEntryList.contains("images/" + ProjectManager.get("splashImgPath").substring(ProjectManager.get("splashImgPath").lastIndexOf("/") + 1))==false)
                                     {
                                        theTempList1.add(EncryptedRuleBuilder.encryptByteArray(getURLByteArray(new URL(ProjectManager.get("splashImgPath")))));
                                        theTempZipEntryList.add("images/" + ProjectManager.get("splashImgPath").substring(ProjectManager.get("splashImgPath").lastIndexOf("/") + 1));               
                                     }
                                 }
                                 if(ProjectManager.get("btnBarImgBtnEnabled")!=null)
                                 {
                                     if(ProjectManager.get("btnBarImgBtnEnabled").equalsIgnoreCase("true")==true)
                                     {                                    
                                         if(urlExists(ProjectManager.get("btnBarImgPath"))==true)
                                         {
                                             if(theTempZipEntryList.contains("images/" + ProjectManager.get("btnBarImgPath").substring(ProjectManager.get("btnBarImgPath").lastIndexOf("/") + 1))==false)
                                             {                                             
                                                theTempList1.add(EncryptedRuleBuilder.encryptByteArray(getURLByteArray(new URL(ProjectManager.get("btnBarImgPath")))));
                                                theTempZipEntryList.add("images/" + ProjectManager.get("btnBarImgPath").substring(ProjectManager.get("btnBarImgPath").lastIndexOf("/") + 1));               
                                             }   
                                         }
                                     }
                                 } 
                                 if(ProjectManager.get("progressPanelImgEnabled")!=null)
                                 {
                                     if(ProjectManager.get("progressPanelImgEnabled").equalsIgnoreCase("true")==true)
                                     {     
                                         if(urlExists(ProjectManager.get("progressPanelImgPath"))==true)
                                         {
                                             if(theTempZipEntryList.contains("images/" + ProjectManager.get("progressPanelImgPath").substring(ProjectManager.get("progressPanelImgPath").lastIndexOf("/") + 1))==false)
                                             {                                               
                                                theTempList1.add(EncryptedRuleBuilder.encryptByteArray(getURLByteArray(new URL(ProjectManager.get("progressPanelImgPath")))));
                                                theTempZipEntryList.add("images/" + ProjectManager.get("progressPanelImgPath").substring(ProjectManager.get("progressPanelImgPath").lastIndexOf("/") + 1));               
                                             }  
                                         }
                                     }
                                 } 
                            }
                        }
                        if(ProjectManager.get("infoActionType").equalsIgnoreCase("1") == true)
                        { 
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/actions/InformationDialogAction.class"));
                            theTempZipEntryList.add("com/trinity/ea/actions/InformationDialogAction.class");      
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/info/InformationDialog.class"));
                            theTempZipEntryList.add("com/trinity/ea/forms/info/InformationDialog.class");                             
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/info/InformationDialog$1.class"));
                            theTempZipEntryList.add("com/trinity/ea/forms/info/InformationDialog$1.class");                             
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/info/InformationDialog$2.class"));
                            theTempZipEntryList.add("com/trinity/ea/forms/info/InformationDialog$2.class");     
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/info/InformationDialog$3.class"));
                            theTempZipEntryList.add("com/trinity/ea/forms/info/InformationDialog$3.class");     
                            theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/info/InformationDialog$4.class"));
                            theTempZipEntryList.add("com/trinity/ea/forms/info/InformationDialog$4.class");                             
                        }
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                // common gui files
                try
                {
                    if(prjPaymentSupport == 0 || prjRegistrationSupport == 0 || prjExpirationSupport == 0 || prjOptinSupport == 0 || prjMessagingSupport==0 || prjAutoUpdateSupport == 0)
                    {                
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/gui/swing/EAScrollBarUI.class"));
                        theTempZipEntryList.add("com/trinity/ea/forms/gui/swing/EAScrollBarUI.class");                    
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/gui/swing/ErrorDialog.class"));
                        theTempZipEntryList.add("com/trinity/ea/forms/gui/swing/ErrorDialog.class");     
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/gui/swing/ErrorDialog$1.class"));
                        theTempZipEntryList.add("com/trinity/ea/forms/gui/swing/ErrorDialog$1.class"); 
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/gui/swing/ErrorDialog$2.class"));
                        theTempZipEntryList.add("com/trinity/ea/forms/gui/swing/ErrorDialog$2.class"); 
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/gui/swing/ErrorDialog$3.class"));
                        theTempZipEntryList.add("com/trinity/ea/forms/gui/swing/ErrorDialog$3.class"); 
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/gui/swing/ErrorDialog$4.class"));
                        theTempZipEntryList.add("com/trinity/ea/forms/gui/swing/ErrorDialog$4.class");
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/gui/swing/ErrorPane.class"));
                        theTempZipEntryList.add("com/trinity/ea/forms/gui/swing/ErrorPane.class");                        
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/gui/swing/ImageBackgroundBorder.class"));
                        theTempZipEntryList.add("com/trinity/ea/forms/gui/swing/ImageBackgroundBorder.class");     
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/gui/swing/ImageButton.class"));
                        theTempZipEntryList.add("com/trinity/ea/forms/gui/swing/ImageButton.class");     
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/gui/swing/ImageButton$1.class"));
                        theTempZipEntryList.add("com/trinity/ea/forms/gui/swing/ImageButton$1.class"); 
                        theTempList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/forms/gui/swing/ImageButton$2.class"));
                        theTempZipEntryList.add("com/trinity/ea/forms/gui/swing/ImageButton$2.class");   
                        if(urlExists(ProjectManager.get("errHeaderImgPath"))==true)
                        {
                            if(theTempZipEntryList.contains("images/" + ProjectManager.get("errHeaderImgPath").substring(ProjectManager.get("errHeaderImgPath").lastIndexOf("/") + 1))==false)
                            {
                                theTempList1.add(EncryptedRuleBuilder.encryptByteArray(getURLByteArray(new URL(ProjectManager.get("errHeaderImgPath")))));
                                theTempZipEntryList.add("images/" + ProjectManager.get("errHeaderImgPath").substring(ProjectManager.get("errHeaderImgPath").lastIndexOf("/") + 1));               
                            } 
                        }
                        if(urlExists(ProjectManager.get("errBGImgPath"))==true)
                        {
                            if(theTempZipEntryList.contains("images/" + ProjectManager.get("errBGImgPath").substring(ProjectManager.get("errBGImgPath").lastIndexOf("/") + 1))==false)
                            {
                                theTempList1.add(EncryptedRuleBuilder.encryptByteArray(getURLByteArray(new URL(ProjectManager.get("errBGImgPath")))));
                                theTempZipEntryList.add("images/" + ProjectManager.get("errBGImgPath").substring(ProjectManager.get("errBGImgPath").lastIndexOf("/") + 1));             
                            }
                        }     
//
                        if(ProjectManager.get("btnBarImgButtonsEnabled")!=null)
                        { 
                            if(ProjectManager.get("btnBarImgButtonsEnabled").equalsIgnoreCase("true") == true)
                            {                             
                                if(urlExists(ProjectManager.get("paymentImgCancelButtonFace"))==true)
                                {
                                    if(theTempZipEntryList.contains("images/" + ProjectManager.get("paymentImgCancelButtonFace").substring(ProjectManager.get("paymentImgCancelButtonFace").lastIndexOf("/") + 1))==false)
                                    {
                                        theTempList1.add(getURLByteArray(new URL(ProjectManager.get("paymentImgCancelButtonFace"))));
                                        theTempZipEntryList.add("images/" + ProjectManager.get("paymentImgCancelButtonFace").substring(ProjectManager.get("paymentImgCancelButtonFace").lastIndexOf("/") + 1));               
                                    }
                                }
                                if(urlExists(ProjectManager.get("paymentImgCancelButtonFaceOnClick"))==true)
                                {
                                    if(theTempZipEntryList.contains("images/" + ProjectManager.get("paymentImgCancelButtonFaceOnClick").substring(ProjectManager.get("paymentImgCancelButtonFaceOnClick").lastIndexOf("/") + 1))==false)
                                    {
                                        theTempList1.add(getURLByteArray(new URL(ProjectManager.get("paymentImgCancelButtonFaceOnClick"))));
                                        theTempZipEntryList.add("images/" + ProjectManager.get("paymentImgCancelButtonFaceOnClick").substring(ProjectManager.get("paymentImgCancelButtonFaceOnClick").lastIndexOf("/") + 1));               
                                    }
                                }     
                                if(urlExists(ProjectManager.get("paymentImgCancelButtonFaceInFocus"))==true)
                                {
                                    if(theTempZipEntryList.contains("images/" + ProjectManager.get("paymentImgCancelButtonFaceInFocus").substring(ProjectManager.get("paymentImgCancelButtonFaceInFocus").lastIndexOf("/") + 1))==false)
                                    {
                                        theTempList1.add(getURLByteArray(new URL(ProjectManager.get("paymentImgCancelButtonFaceInFocus"))));
                                        theTempZipEntryList.add("images/" + ProjectManager.get("paymentImgCancelButtonFaceInFocus").substring(ProjectManager.get("paymentImgCancelButtonFaceInFocus").lastIndexOf("/") + 1));               
                                    }
                                } 
                                if(urlExists(ProjectManager.get("paymentImgContinueButtonFace"))==true)
                                {
                                    if(theTempZipEntryList.contains("images/" + ProjectManager.get("paymentImgContinueButtonFace").substring(ProjectManager.get("paymentImgContinueButtonFace").lastIndexOf("/") + 1))==false)
                                    {
                                        theTempList1.add(getURLByteArray(new URL(ProjectManager.get("paymentImgContinueButtonFace"))));
                                        theTempZipEntryList.add("images/" + ProjectManager.get("paymentImgContinueButtonFace").substring(ProjectManager.get("paymentImgContinueButtonFace").lastIndexOf("/") + 1));               
                                    }
                                }
                                if(urlExists(ProjectManager.get("paymentImgContinueButtonFaceOnClick"))==true)
                                {
                                    if(theTempZipEntryList.contains("images/" + ProjectManager.get("paymentImgContinueButtonFaceOnClick").substring(ProjectManager.get("paymentImgContinueButtonFaceOnClick").lastIndexOf("/") + 1))==false)
                                    {
                                        theTempList1.add(getURLByteArray(new URL(ProjectManager.get("paymentImgContinueButtonFaceOnClick"))));
                                        theTempZipEntryList.add("images/" + ProjectManager.get("paymentImgContinueButtonFaceOnClick").substring(ProjectManager.get("paymentImgContinueButtonFaceOnClick").lastIndexOf("/") + 1));               
                                    }
                                }     
                                if(urlExists(ProjectManager.get("paymentImgContinueButtonFaceInFocus"))==true)
                                {
                                    if(theTempZipEntryList.contains("images/" + ProjectManager.get("paymentImgContinueButtonFaceInFocus").substring(ProjectManager.get("paymentImgContinueButtonFaceInFocus").lastIndexOf("/") + 1))==false)
                                    {
                                        theTempList1.add(getURLByteArray(new URL(ProjectManager.get("paymentImgContinueButtonFaceInFocus"))));
                                        theTempZipEntryList.add("images/" + ProjectManager.get("paymentImgContinueButtonFaceInFocus").substring(ProjectManager.get("paymentImgContinueButtonFaceInFocus").lastIndexOf("/") + 1));               
                                    }
                                } 
                                if(urlExists(ProjectManager.get("registrationImgButtonFace"))==true)
                                {
                                    if(theTempZipEntryList.contains("images/" + ProjectManager.get("registrationImgButtonFace").substring(ProjectManager.get("registrationImgButtonFace").lastIndexOf("/") + 1))==false)
                                    {
                                        theTempList1.add(getURLByteArray(new URL(ProjectManager.get("registrationImgButtonFace"))));
                                        theTempZipEntryList.add("images/" + ProjectManager.get("registrationImgButtonFace").substring(ProjectManager.get("registrationImgButtonFace").lastIndexOf("/") + 1));               
                                    }
                                }
                                if(urlExists(ProjectManager.get("registrationImgButtonFaceOnClick"))==true)
                                {
                                    if(theTempZipEntryList.contains("images/" + ProjectManager.get("registrationImgButtonFaceOnClick").substring(ProjectManager.get("registrationImgButtonFaceOnClick").lastIndexOf("/") + 1))==false)
                                    {
                                        theTempList1.add(getURLByteArray(new URL(ProjectManager.get("registrationImgButtonFaceOnClick"))));
                                        theTempZipEntryList.add("images/" + ProjectManager.get("registrationImgButtonFaceOnClick").substring(ProjectManager.get("registrationImgButtonFaceOnClick").lastIndexOf("/") + 1));               
                                    }
                                }     
                                if(urlExists(ProjectManager.get("registrationButtonFaceInFocus"))==true)
                                {
                                    if(theTempZipEntryList.contains("images/" + ProjectManager.get("registrationButtonFaceInFocus").substring(ProjectManager.get("registrationButtonFaceInFocus").lastIndexOf("/") + 1))==false)
                                    {
                                        theTempList1.add(getURLByteArray(new URL(ProjectManager.get("registrationButtonFaceInFocus"))));
                                        theTempZipEntryList.add("images/" + ProjectManager.get("registrationButtonFaceInFocus").substring(ProjectManager.get("registrationButtonFaceInFocus").lastIndexOf("/") + 1));               
                                    }
                                }    
                                if(urlExists(ProjectManager.get("btnBarImgButtonFace"))==true)
                                {
                                    if(theTempZipEntryList.contains("images/" + ProjectManager.get("btnBarImgButtonFace").substring(ProjectManager.get("btnBarImgButtonFace").lastIndexOf("/") + 1))==false)
                                    {
                                        theTempList1.add(getURLByteArray(new URL(ProjectManager.get("btnBarImgButtonFace"))));
                                        theTempZipEntryList.add("images/" + ProjectManager.get("btnBarImgButtonFace").substring(ProjectManager.get("btnBarImgButtonFace").lastIndexOf("/") + 1));               
                                    }
                                }
                                if(urlExists(ProjectManager.get("btnBarImgButtonFaceOnClick"))==true)
                                {
                                    if(theTempZipEntryList.contains("images/" + ProjectManager.get("btnBarImgButtonFaceOnClick").substring(ProjectManager.get("btnBarImgButtonFaceOnClick").lastIndexOf("/") + 1))==false)
                                    {
                                        theTempList1.add(getURLByteArray(new URL(ProjectManager.get("btnBarImgButtonFaceOnClick"))));
                                        theTempZipEntryList.add("images/" + ProjectManager.get("btnBarImgButtonFaceOnClick").substring(ProjectManager.get("btnBarImgButtonFaceOnClick").lastIndexOf("/") + 1));               
                                    }
                                }     
                                if(urlExists(ProjectManager.get("buttonFaceImageInFocus"))==true)
                                {
                                    if(theTempZipEntryList.contains("images/" + ProjectManager.get("buttonFaceImageInFocus").substring(ProjectManager.get("buttonFaceImageInFocus").lastIndexOf("/") + 1))==false)
                                    {
                                        theTempList1.add(getURLByteArray(new URL(ProjectManager.get("buttonFaceImageInFocus"))));
                                        theTempZipEntryList.add("images/" + ProjectManager.get("buttonFaceImageInFocus").substring(ProjectManager.get("buttonFaceImageInFocus").lastIndexOf("/") + 1));               
                                    }
                                }                                    
                            }
                        } 
                        if(ProjectManager.get("customScrollBarsEnabled")!=null)
                        { 
                            if(ProjectManager.get("customScrollBarsEnabled").equalsIgnoreCase("true") == true)
                            {                             
                                if(urlExists(ProjectManager.get("sbMsgThumbImagePath"))==true)
                                {
                                    if(theTempZipEntryList.contains("images/" + ProjectManager.get("sbMsgThumbImagePath").substring(ProjectManager.get("sbMsgThumbImagePath").lastIndexOf("/") + 1))==false)
                                    {
                                        theTempList1.add(getURLByteArray(new URL(ProjectManager.get("sbMsgThumbImagePath"))));
                                        theTempZipEntryList.add("images/" + ProjectManager.get("sbMsgThumbImagePath").substring(ProjectManager.get("sbMsgThumbImagePath").lastIndexOf("/") + 1));               
                                    }
                                }     
                                if(urlExists(ProjectManager.get("sbThumbImagePath"))==true)
                                {
                                    if(theTempZipEntryList.contains("images/" + ProjectManager.get("sbThumbImagePath").substring(ProjectManager.get("sbThumbImagePath").lastIndexOf("/") + 1))==false)
                                    {
                                        theTempList1.add(getURLByteArray(new URL(ProjectManager.get("sbThumbImagePath"))));
                                        theTempZipEntryList.add("images/" + ProjectManager.get("sbThumbImagePath").substring(ProjectManager.get("sbThumbImagePath").lastIndexOf("/") + 1));               
                                    }
                                }                                   
                            }
                        }
                    }
                } 
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                
                //Locale Files
                // automatic update startup jar
                if(prjAutoUpdateSupport == 0)
                {       
                    if(ProjectManager.get("i18nBundleName")!=null)
                    {
                        if(ProjectManager.get("i18nBundleName").equalsIgnoreCase("")==false)
                        {
                            try
                            {                            
                                File tmpFile1 = getTempLocaleFile();
                                theAUStartJarTempList1.add(getFileByteArray(getDefaultLocaleFile(tmpFile1)));
                                theAUStartJarTempZipEntryList.add(ProjectManager.get("i18nBundleName") + ".properties");
                                tmpFile1.delete();
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                            // Create the locale files for the Jar File                            
                            Object[] localeObjectArray = getStringArraysFromString(ProjectManager.get("prjbuildlocales"));
                            for(int i = 0;i<localeObjectArray.length;i++)
                            {
                                if(((String)localeObjectArray[i]).equalsIgnoreCase(ProjectManager.get("prjdefaultlocale"))==false)
                                {
                                    try
                                    {                                    
                                        File tmpFile2 = getTempLocaleFile();
                                        //New Code
                                        theAUStartJarTempList1.add(getFileByteArray(getOptimizedLocaleFile(new File(new URL(DesignerRuleBuilder.getTempProject()).getPath().substring(0, new URL(DesignerRuleBuilder.getTempProject()).getPath().lastIndexOf("/")) + "/locales/" + ProjectManager.get("i18nBundleName") + "_" + ((String)localeObjectArray[i]) + ".properties"), tmpFile2, ((String)localeObjectArray[i]))));
                                        theAUStartJarTempZipEntryList.add(ProjectManager.get("i18nBundleName") + "_" + ((String)localeObjectArray[i]) + ".properties");                                     
                                        //Old Code
                                        //theAUStartJarTempList1.add(getFileByteArray(new File(new URL(DesignerRuleBuilder.getTempProject()).getPath().substring(0, new URL(DesignerRuleBuilder.getTempProject()).getPath().lastIndexOf("/")) + "/locales/" + ProjectManager.get("i18nBundleName") + "_" + ((String)localeObjectArray[i]) + ".properties")));
                                        //theAUStartJarTempZipEntryList.add(ProjectManager.get("i18nBundleName") + "_" + ((String)localeObjectArray[i]) + ".properties");                                     
                                        tmpFile2.delete();
                                    }
                                    catch(Exception e)
                                    {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                        else
                        {
                            try
                            {                            
                                File tmpFile1 = getTempLocaleFile();                            
                                theAUStartJarTempList1.add(getFileByteArray(getDefaultLocaleFile(tmpFile1)));
                                theAUStartJarTempZipEntryList.add("MessagesBundle.properties");    
                                tmpFile1.delete();
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                            Object[] localeObjectArray = getStringArraysFromString(ProjectManager.get("prjbuildlocales"));
                            for(int i = 0;i<localeObjectArray.length;i++)
                            {
                                if(((String)localeObjectArray[i]).equalsIgnoreCase(ProjectManager.get("prjdefaultlocale"))==false)
                                {
                                    try
                                    {                                    
                                        File tmpFile2 = getTempLocaleFile();
                                        //New Code
                                        theAUStartJarTempList1.add(getFileByteArray(getOptimizedLocaleFile(new File(new URL(DesignerRuleBuilder.getTempProject()).getPath().substring(0, new URL(DesignerRuleBuilder.getTempProject()).getPath().lastIndexOf("/")) + "/locales/" + ProjectManager.get("i18nBundleName") + "_" + ((String)localeObjectArray[i]) + ".properties"), tmpFile2, ((String)localeObjectArray[i]))));
                                        theAUStartJarTempZipEntryList.add("MessagesBundle" + "_" + ((String)localeObjectArray[i]) + ".properties");                                     
                                        //Old Code
                                        //theAUStartJarTempList1.add(getFileByteArray(new File(new URL(DesignerRuleBuilder.getTempProject()).getPath().substring(0, new URL(DesignerRuleBuilder.getTempProject()).getPath().lastIndexOf("/")) + "/locales/" + ProjectManager.get("i18nBundleName") + "_" + ((String)localeObjectArray[i]) + ".properties")));
                                        //theAUStartJarTempZipEntryList.add("MessagesBundle" + "_" + ((String)localeObjectArray[i]) + ".properties");                                     
                                        tmpFile2.delete();
                                    }
                                    catch(Exception e)
                                    {
                                        e.printStackTrace();
                                    }
                                }
                            }                            
                        }
                    }
                    else
                    {
                        try
                        {                            
                            File tmpFile1 = getTempLocaleFile();                            
                            theAUStartJarTempList1.add(getFileByteArray(getDefaultLocaleFile(tmpFile1)));
                            theAUStartJarTempZipEntryList.add("MessagesBundle.properties");                        
                            tmpFile1.delete();
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                        Object[] localeObjectArray = getStringArraysFromString(ProjectManager.get("prjbuildlocales"));
                        for(int i = 0;i<localeObjectArray.length;i++)
                        {
                            if(((String)localeObjectArray[i]).equalsIgnoreCase(ProjectManager.get("prjdefaultlocale"))==false)
                            {
                                    try
                                    {                                    
                                        File tmpFile2 = getTempLocaleFile();
                                        //New Code
                                        theAUStartJarTempList1.add(getFileByteArray(getOptimizedLocaleFile(new File(new URL(DesignerRuleBuilder.getTempProject()).getPath().substring(0, new URL(DesignerRuleBuilder.getTempProject()).getPath().lastIndexOf("/")) + "/locales/" + ProjectManager.get("i18nBundleName") + "_" + ((String)localeObjectArray[i]) + ".properties"), tmpFile2, ((String)localeObjectArray[i]))));
                                        theAUStartJarTempZipEntryList.add("MessagesBundle" + "_" + ((String)localeObjectArray[i]) + ".properties");                                     
                                        //Old Code
                                        //theAUStartJarTempList1.add(getFileByteArray(new File(new URL(DesignerRuleBuilder.getTempProject()).getPath().substring(0, new URL(DesignerRuleBuilder.getTempProject()).getPath().lastIndexOf("/")) + "/locales/" + ProjectManager.get("i18nBundleName") + "_" + ((String)localeObjectArray[i]) + ".properties")));
                                        //theAUStartJarTempZipEntryList.add("MessagesBundle" + "_" + ((String)localeObjectArray[i]) + ".properties");                                     
                                        tmpFile2.delete();
                                    }
                                    catch(Exception e)
                                    {
                                        e.printStackTrace();
                                    }
                            }
                        }   
                    }
                }
                else
                {
                    if(ProjectManager.get("i18nBundleName")!=null)
                    {
                        if(ProjectManager.get("i18nBundleName").equalsIgnoreCase("")==false)
                        {
                            try
                            {                            
                                File tmpFile1 = getTempLocaleFile();                             
                                theTempList1.add(getFileByteArray(getDefaultLocaleFile(tmpFile1)));
                                theTempZipEntryList.add(ProjectManager.get("i18nBundleName") + ".properties"); 
                                tmpFile1.delete();
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                            // Create the locale files for the Jar File                            
                            Object[] localeObjectArray = getStringArraysFromString(ProjectManager.get("prjbuildlocales"));
                            for(int i = 0;i<localeObjectArray.length;i++)
                            {
                                if(((String)localeObjectArray[i]).equalsIgnoreCase(ProjectManager.get("prjdefaultlocale"))==false)
                                {
                                    try
                                    {                                    
                                        File tmpFile2 = getTempLocaleFile();
                                        //New Code
                                        theTempList1.add(getFileByteArray(getOptimizedLocaleFile(new File(new URL(DesignerRuleBuilder.getTempProject()).getPath().substring(0, new URL(DesignerRuleBuilder.getTempProject()).getPath().lastIndexOf("/")) + "/locales/" + ProjectManager.get("i18nBundleName") + "_" + ((String)localeObjectArray[i]) + ".properties"), tmpFile2, ((String)localeObjectArray[i]))));
                                        theTempZipEntryList.add(ProjectManager.get("i18nBundleName") + "_" + ((String)localeObjectArray[i]) + ".properties");                                     
                                        //old code
                                        //theTempList1.add(getFileByteArray(new File(new URL(DesignerRuleBuilder.getTempProject()).getPath().substring(0, new URL(DesignerRuleBuilder.getTempProject()).getPath().lastIndexOf("/")) + "/locales/" + ProjectManager.get("i18nBundleName") + "_" + ((String)localeObjectArray[i]) + ".properties")));
                                        //theTempZipEntryList.add(ProjectManager.get("i18nBundleName") + "_" + ((String)localeObjectArray[i]) + ".properties");                                     
                                        tmpFile2.delete();
                                    }
                                    catch(Exception e)
                                    {
                                        e.printStackTrace();
                                    } 
                                }
                            }                            
                        }
                        else
                        {
                            try
                            {                            
                                File tmpFile1 = getTempLocaleFile();                             
                                theTempList1.add(getFileByteArray(getDefaultLocaleFile(tmpFile1)));
                                theTempZipEntryList.add("MessagesBundle.properties");   
                                tmpFile1.delete();
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                            Object[] localeObjectArray = getStringArraysFromString(ProjectManager.get("prjbuildlocales"));
                            for(int i = 0;i<localeObjectArray.length;i++)
                            {
                                if(((String)localeObjectArray[i]).equalsIgnoreCase(ProjectManager.get("prjdefaultlocale"))==false)
                                {
                                     try
                                    {                                    
                                        File tmpFile2 = getTempLocaleFile();
                                        //New Code
                                        theTempList1.add(getFileByteArray(getOptimizedLocaleFile(new File(new URL(DesignerRuleBuilder.getTempProject()).getPath().substring(0, new URL(DesignerRuleBuilder.getTempProject()).getPath().lastIndexOf("/")) + "/locales/" + ProjectManager.get("i18nBundleName") + "_" + ((String)localeObjectArray[i]) + ".properties"), tmpFile2, ((String)localeObjectArray[i]))));
                                        theTempZipEntryList.add("MessagesBundle" + "_" + ((String)localeObjectArray[i]) + ".properties");                                     
                                        //old code
                                        //theTempList1.add(getFileByteArray(new File(new URL(DesignerRuleBuilder.getTempProject()).getPath().substring(0, new URL(DesignerRuleBuilder.getTempProject()).getPath().lastIndexOf("/")) + "/locales/" + ProjectManager.get("i18nBundleName") + "_" + ((String)localeObjectArray[i]) + ".properties")));
                                        //theTempZipEntryList.add("MessagesBundle" + "_" + ((String)localeObjectArray[i]) + ".properties");                                     
                                        tmpFile2.delete();
                                    }
                                    catch(Exception e)
                                    {
                                        e.printStackTrace();
                                    }
                                }
                            }                              
                        }
                    }
                    else
                    {
                        try
                        {                            
                            File tmpFile1 = getTempLocaleFile();                         
                            theTempList1.add(getFileByteArray(getDefaultLocaleFile(tmpFile1)));
                            theTempZipEntryList.add("MessagesBundle.properties");  
                            tmpFile1.delete();
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }                        
                        Object[] localeObjectArray = getStringArraysFromString(ProjectManager.get("prjbuildlocales"));
                        for(int i = 0;i<localeObjectArray.length;i++)
                        {
                            if(((String)localeObjectArray[i]).equalsIgnoreCase(ProjectManager.get("prjdefaultlocale"))==false)
                            {
                                    try
                                    {                                    
                                        File tmpFile2 = getTempLocaleFile();
                                        //New Code
                                        theTempList1.add(getFileByteArray(getOptimizedLocaleFile(new File(new URL(DesignerRuleBuilder.getTempProject()).getPath().substring(0, new URL(DesignerRuleBuilder.getTempProject()).getPath().lastIndexOf("/")) + "/locales/" + ProjectManager.get("i18nBundleName") + "_" + ((String)localeObjectArray[i]) + ".properties"), tmpFile2, ((String)localeObjectArray[i]))));
                                        theTempZipEntryList.add("MessagesBundle" + "_" + ((String)localeObjectArray[i]) + ".properties");                                     
                                        //old code
                                        //theTempList1.add(getFileByteArray(new File(new URL(DesignerRuleBuilder.getTempProject()).getPath().substring(0, new URL(DesignerRuleBuilder.getTempProject()).getPath().lastIndexOf("/")) + "/locales/" + ProjectManager.get("i18nBundleName") + "_" + ((String)localeObjectArray[i]) + ".properties")));
                                        //theTempZipEntryList.add("MessagesBundle" + "_" + ((String)localeObjectArray[i]) + ".properties");                                     
                                        tmpFile2.delete();
                                    }
                                    catch(Exception e)
                                    {
                                        e.printStackTrace();
                                    }
                            }
                        }                          
                    }                    
                }
   
//Jar file manifest goes here              
                
                // automatic update startup jar
                if(prjAutoUpdateSupport == 0)
                {     
                    theAUStartJarTempList1.trimToSize();
                    theAUStartJarTempZipEntryList.trimToSize();
                    Object[] theAUObjectList = theAUStartJarTempZipEntryList.toArray();
                    String[] theAUStringList = new String[theAUObjectList.length];
                    for(int i = 0;i<theAUObjectList.length;i++)
                    {
                        theAUStringList[i] = (String)theAUObjectList[i];
                    }
                    ZipBuilder.compress(new File(new URL(BuildOutputDir.toURL().toString() + "/" + ProjectManager.get("project_jarfile_name")).getFile()), theAUStringList, theAUStartJarTempList1);                    
                }
                else
                {
                    try
                    {
                        File autoUpdateStartJar = new File(new URL(BuildOutputDir.toURL().toString() + "/" + ProjectManager.get("project_jarfile2_name")).getFile());
                        if(autoUpdateStartJar.exists()==true)
                        {
                            autoUpdateStartJar.delete();
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println("Could not remove the " + ProjectManager.get("project_jarfile_name") + " file. Please manually remove the file.");
                    }
                }
                
                 theTempList1.trimToSize();
                 theTempZipEntryList.trimToSize();
                 Object[] theObjectList = theTempZipEntryList.toArray();
                 String[] theStringList = new String[theObjectList.length];
                 for(int i = 0;i<theObjectList.length;i++)
                 {
                    theStringList[i] = (String)theObjectList[i];
                 }
                 if(ProjectManager.get("project_auto_update_support_is_enabled")!=null)
                 {
                     if(ProjectManager.get("project_auto_update_support_is_enabled").equalsIgnoreCase("true")==true)
                     {                     
                            ZipBuilder.compress(new File(new URL(BuildOutputDir.toURL().toString() + "/" + ProjectManager.get("project_jarfile2_name")).getFile()), theStringList, theTempList1);
                     }
                     else
                     {
                          ZipBuilder.compress(new File(new URL(BuildOutputDir.toURL().toString() + "/" + ProjectManager.get("project_jarfile_name")).getFile()), theStringList, theTempList1);
                     }
                 }
                 else
                 {
                      ZipBuilder.compress(new File(new URL(BuildOutputDir.toURL().toString() + "/" + ProjectManager.get("project_jarfile_name")).getFile()), theStringList, theTempList1);
                 }   
                 // Set the manifest file to make the Jar an executable jar file.
                 try
                 {
                    ManifestBuilder.getMakeExecutableManifest("com.trinity.ea.EvaluateAnywhere", new File(new URL(BuildOutputDir.toURL().toString() + "/" + ProjectManager.get("project_jarfile_name")).getFile()));
                 } 
                 catch(Exception e)
                 {

                 } 
                 if(ProjectManager.get("allowInternalStartTrialInstanciation")!=null)
                 {
                     if(ProjectManager.get("allowInternalStartTrialInstanciation").equalsIgnoreCase("false")==true)
                     {        
                         theTempStartTrialList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/util/EAProperties.class"));
                         theTempStartTrialZipEntryList.add("com/trinity/ea/util/EAProperties.class");                          
                         theTempStartTrialList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/rules/reader/RuleHandler.class"));
                         theTempStartTrialZipEntryList.add("com/trinity/ea/rules/reader/RuleHandler.class");                          
                         theTempStartTrialList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/rules/reader/StartTrial.class"));
                         theTempStartTrialZipEntryList.add("com/trinity/ea/rules/reader/StartTrial.class"); 
                         theTempStartTrialList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/rules/reader/EncryptedRuleReader.class"));
                         theTempStartTrialZipEntryList.add("com/trinity/ea/rules/reader/EncryptedRuleReader.class");  
                         theTempStartTrialList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/rules/reader/Indexer.class"));
                         theTempStartTrialZipEntryList.add("com/trinity/ea/rules/reader/Indexer.class"); 
                         theTempStartTrialList1.add(ZipBuilder.getClassByteArray(new File(new URL(new File(System.getProperty("user.dir")).toURL().toString() + "/lib/ea1.jar").getFile()), "/com/trinity/ea/rules/reader/IndexHandler.class"));
                         theTempStartTrialZipEntryList.add("com/trinity/ea/rules/reader/IndexHandler.class");                          
                         theTempStartTrialList1.trimToSize();
                         theTempStartTrialZipEntryList.trimToSize();
                         Object[] theObjectList2 = theTempStartTrialZipEntryList.toArray();
                         String[] theStringList2 = new String[theObjectList2.length];
                         for(int i = 0;i<theObjectList2.length;i++)
                         { 
                            theStringList2[i] = (String)theObjectList2[i]; 
                         }
                         ZipBuilder.compress(new File(new URL(BuildOutputDir.toURL().toString() + "/easigner.jar").getFile()), theStringList2, theTempStartTrialList1);
                         try
                         {
                            ManifestBuilder.getMakeExecutableManifest("com.trinity.ea.rules.reader.StartTrial", new File(new URL(BuildOutputDir.toURL().toString() + "/easigner.jar").getFile()));
                         }
                         catch(Exception e)
                         {

                         }                         
                     }
                 }
        
}
             catch(Exception e) 
             {
                 e.printStackTrace();
             }
            return 0;
        }
        catch(Exception e)
        {
            return -1;
        }
    } 
 
     /** Verify the specified jar resource exists before attempting to copy */
    private boolean urlExists(String strURL)
    {
     try
     {
        if(strURL!=null)
        {
            if(strURL.equalsIgnoreCase("")==false)
            {
                try
                {
                    URL resURL = new URL(strURL);
                    InputStream is = resURL.openStream();
                    is.close();
                    return true;
                }
                catch(Exception e)
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
     }
     catch(Exception e)
     {
         return false;
     }
    }   
    
    /** Verify the specified jar resource exists before attempting to copy */
    private boolean jarResourceExists(String resourcePath)
    {
     try
     {
        if(resourcePath!=null)
        {
            if(resourcePath.equalsIgnoreCase("")==false)
            {
                try
                {
                    URL resURL = new String().getClass().getResource(resourcePath);
                    InputStream is = resURL.openStream();
                    is.close();
                    return true;
                }
                catch(Exception e)
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
     }
     catch(Exception e)
     {
         return false;
     }
    }
    
    private File getDefaultLocaleFile(File localeFile)
    {
        try
        {
            ProjectFile theLocaleFile = new ProjectFile(localeFile.toURL().toString()); 
            theLocaleFile.openProject();
            
            theLocaleFile.put("#","#Resource Bundle: MessagesBundle.properties - Copyright 2004-2005, Trinity Software, LLC. All rights reserved.");
            // registration UI Variables
            theLocaleFile.put("registerSoftwareWindowTitle", replaceUIExpressions(ProjectManager.get("registerSoftwareWindowTitle")));
            theLocaleFile.put("registrationCodeLabel", replaceUIExpressions(ProjectManager.get("registrationCodeLabel")));
            theLocaleFile.put("registrationPaidLabel", replaceUIExpressions(ProjectManager.get("registrationPaidLabel")));
            theLocaleFile.put("registrationCodeLabelFontMnemonic", replaceUIExpressions(ProjectManager.get("registrationCodeLabelFontMnemonic")));
            theLocaleFile.put("registrationCancelButtonText", replaceUIExpressions(ProjectManager.get("registrationCancelButtonText"))); 
            theLocaleFile.put("registrationFinishButtonText", replaceUIExpressions(ProjectManager.get("registrationFinishButtonText"))); 
            theLocaleFile.put("registrationCancelButtonMnemonic", replaceUIExpressions(ProjectManager.get("registrationCancelButtonMnemonic"))); 
            theLocaleFile.put("registrationFinishButtonMnemonic", replaceUIExpressions(ProjectManager.get("registrationFinishButtonMnemonic")));  
            //registration failed window user interface strings
            theLocaleFile.put("registrationFailedWindowTitle", replaceUIExpressions(ProjectManager.get("registrationFailedWindowTitle")));
            theLocaleFile.put("registrationFailedMessage", replaceUIExpressions(ProjectManager.get("registrationFailedMessage")));
            theLocaleFile.put("registrationFailureOK", replaceUIExpressions(ProjectManager.get("registrationFailureOK"))); 
            theLocaleFile.put("registrationFailureOKMnemonic", replaceUIExpressions(ProjectManager.get("registrationFailureOKMnemonic")));   
            //registration success window user interface strings
            theLocaleFile.put("registrationSuccessWindowTitle", replaceUIExpressions(ProjectManager.get("registrationSuccessWindowTitle")));
            theLocaleFile.put("registrationSuccessHeader", replaceUIExpressions(ProjectManager.get("registrationSuccessHeader"))); 
            theLocaleFile.put("registrationSuccessDesc", replaceUIExpressions(ProjectManager.get("registrationSuccessDesc"))); 
            theLocaleFile.put("registrationSuccessOK", replaceUIExpressions(ProjectManager.get("registrationSuccessOK"))); 
            theLocaleFile.put("registrationSuccessOKMnemonic", replaceUIExpressions(ProjectManager.get("registrationSuccessOKMnemonic")));  
            // optin UI Strings
            theLocaleFile.put("privacyPolicy", replaceUIExpressions(ProjectManager.get("privacyPolicy")));
            theLocaleFile.put("optinYourNameLabel", replaceUIExpressions(ProjectManager.get("optinYourNameLabel")));
            theLocaleFile.put("optinYourEMailLabel", replaceUIExpressions(ProjectManager.get("optinYourEMailLabel")));
            theLocaleFile.put("registerSoftwareTitle", replaceUIExpressions(ProjectManager.get("registerSoftwareTitle")));
            theLocaleFile.put("optinPrivacyPolicyLabel", replaceUIExpressions(ProjectManager.get("optinPrivacyPolicyLabel")));
            theLocaleFile.put("privacyPolicyTitle", replaceUIExpressions(ProjectManager.get("privacyPolicyTitle")));
            theLocaleFile.put("optinDescription", replaceUIExpressions(ProjectManager.get("optinDescription")));
// Additional Privacy Policy Variables should be appended to the Designer             
             theLocaleFile.put("privacyPolicyOKBtnText", replaceUIExpressions(ProjectManager.get("privacyPolicyOKBtnText")));  
             theLocaleFile.put("privacyPolicyOKBtnMnemonic", replaceUIExpressions(ProjectManager.get("privacyPolicyOKBtnMnemonic")));
// Additional Opt-In Window Variables
             theLocaleFile.put("optinCancelButtonText", replaceUIExpressions(ProjectManager.get("optinCancelButtonText")));
             theLocaleFile.put("optinCancelButtonMnemonic", replaceUIExpressions(ProjectManager.get("optinCancelButtonMnemonic")));
             theLocaleFile.put("optinContinueButtonText", replaceUIExpressions(ProjectManager.get("optinContinueButtonText")));
             theLocaleFile.put("optinContinueButtonMnemonic", replaceUIExpressions(ProjectManager.get("optinContinueButtonMnemonic")));
// Additional Optin Strings
             theLocaleFile.put("optinEnterNameMessage", replaceUIExpressions(ProjectManager.get("optinEnterNameMessage")));
             theLocaleFile.put("optinEnterValidEMailMessage", replaceUIExpressions(ProjectManager.get("optinEnterValidEMailMessage")));   
             theLocaleFile.put("optinEnterEMailMessage", replaceUIExpressions(ProjectManager.get("optinEnterEMailMessage")));
             // Additional Optin Processing Variables          
             theLocaleFile.put("optinPrivacyPolicyMnemonic", replaceUIExpressions(ProjectManager.get("optinPrivacyPolicyMnemonic")));
             // payment user interface strings
             theLocaleFile.put("paymentWindowTitle", replaceUIExpressions(ProjectManager.get("paymentWindowTitle")));
             theLocaleFile.put("paymentStateLabel", replaceUIExpressions(ProjectManager.get("paymentStateLabel"))); 
             theLocaleFile.put("paymentExpMMYYLabel", replaceUIExpressions(ProjectManager.get("paymentExpMMYYLabel")));    
             theLocaleFile.put("paymentContinueButtonText", replaceUIExpressions(ProjectManager.get("paymentContinueButtonText")));
             theLocaleFile.put("paymentCancelButtonText", replaceUIExpressions(ProjectManager.get("paymentCancelButtonText")));
             theLocaleFile.put("paymentInstructionsLine1", replaceUIExpressions(ProjectManager.get("paymentInstructionsLine1")));
             theLocaleFile.put("paymentVerificationCodeLabel", replaceUIExpressions(ProjectManager.get("paymentVerificationCodeLabel")));
             theLocaleFile.put("paymentRefundPolicyLabel", replaceUIExpressions(ProjectManager.get("paymentRefundPolicyLabel")));
             theLocaleFile.put("paymentFirstNameDataFieldEmptyMessage", replaceUIExpressions(ProjectManager.get("paymentFirstNameDataFieldEmptyMessage")));
             theLocaleFile.put("paymentLastNameDataFieldEmptyMessage", replaceUIExpressions(ProjectManager.get("paymentLastNameDataFieldEmptyMessage")));
             theLocaleFile.put("paymentValidEMailDataFieldEmptyMessage", replaceUIExpressions(ProjectManager.get("paymentValidEMailDataFieldEmptyMessage")));
             theLocaleFile.put("paymentEMailDataFieldEmptyMessage", replaceUIExpressions(ProjectManager.get("paymentEMailDataFieldEmptyMessage")));
             theLocaleFile.put("paymentStreetDataFieldEmptyMessage", replaceUIExpressions(ProjectManager.get("paymentStreetDataFieldEmptyMessage")));
             theLocaleFile.put("paymentCityDataFieldEmptyMessage", replaceUIExpressions(ProjectManager.get("paymentCityDataFieldEmptyMessage")));
             theLocaleFile.put("paymentZipDataFieldEmptyMessage", replaceUIExpressions(ProjectManager.get("paymentZipDataFieldEmptyMessage")));
             theLocaleFile.put("paymentCCDataFieldEmptyMessage", replaceUIExpressions(ProjectManager.get("paymentCCDataFieldEmptyMessage")));
             theLocaleFile.put("paymentCCVerificationCodeFieldEmptyMessage", replaceUIExpressions(ProjectManager.get("paymentCCVerificationCodeFieldEmptyMessage")));
             theLocaleFile.put("paymentPhoneDataFieldEmptyMessage", replaceUIExpressions(ProjectManager.get("paymentPhoneDataFieldEmptyMessage")));
             theLocaleFile.put("paymentFirstNameLabel", replaceUIExpressions(ProjectManager.get("paymentFirstNameLabel"))); 
             theLocaleFile.put("paymentLastNameLabel", replaceUIExpressions(ProjectManager.get("paymentLastNameLabel")));
             theLocaleFile.put("paymentEMailLabel", replaceUIExpressions(ProjectManager.get("paymentEMailLabel")));
             theLocaleFile.put("paymentStreetLabel", replaceUIExpressions(ProjectManager.get("paymentStreetLabel")));
             theLocaleFile.put("paymentCityLabel", replaceUIExpressions(ProjectManager.get("paymentCityLabel")));
             theLocaleFile.put("paymentCountryLabel", replaceUIExpressions(ProjectManager.get("paymentCountryLabel")));
             theLocaleFile.put("paymentZipCodeLabel", replaceUIExpressions(ProjectManager.get("paymentZipCodeLabel")));
             theLocaleFile.put("paymentPaymentMethodLabel", replaceUIExpressions(ProjectManager.get("paymentPaymentMethodLabel")));
             theLocaleFile.put("paymentCCLabel", replaceUIExpressions(ProjectManager.get("paymentCCLabel")));
             theLocaleFile.put("paymentOrdersOutsideUSLabel", replaceUIExpressions(ProjectManager.get("paymentOrdersOutsideUSLabel")));
             if(ProjectManager.get("paymentFormProductLabelImageEnabled")!=null)
             {
                if(ProjectManager.get("paymentFormProductLabelImageEnabled").equalsIgnoreCase("true")==true)
                {           
                     if(urlExists(ProjectManager.get("paymentFormProductLabel"))==true)
                     {
                         theLocaleFile.put("paymentFormProductLabel", "/images/" + ProjectManager.get("paymentFormProductLabel").substring(ProjectManager.get("paymentFormProductLabel").lastIndexOf("/") + 1));                 
                     }     
                     else
                     {
                         theLocaleFile.put("paymentFormProductLabel", replaceUIExpressions(ProjectManager.get("paymentFormProductLabel")));
                     }
                 }
                else
                {
                    theLocaleFile.put("paymentFormProductLabel", replaceUIExpressions(ProjectManager.get("paymentFormProductLabel")));
                }
             }
             else
             {
                 theLocaleFile.put("paymentFormProductLabel", replaceUIExpressions(ProjectManager.get("paymentFormProductLabel")));
             }
             // payment success user interface strings
             theLocaleFile.put("paymentSuccessResponsePanelTitle", replaceUIExpressions(ProjectManager.get("paymentSuccessResponsePanelTitle")));
             theLocaleFile.put("paymentSuccessResponsePanelHeaderDescription", replaceUIExpressions(ProjectManager.get("paymentSuccessResponsePanelHeaderDescription")));
             theLocaleFile.put("paymentSuccessResponsePanelOrderID", replaceUIExpressions(ProjectManager.get("paymentSuccessResponsePanelOrderID")));
             theLocaleFile.put("paymentSuccessResponsePanelNameOnCard", replaceUIExpressions(ProjectManager.get("paymentSuccessResponsePanelNameOnCard")));
             theLocaleFile.put("paymentSuccessResponsePanelEMailAddress", replaceUIExpressions(ProjectManager.get("paymentSuccessResponsePanelEMailAddress")));
             theLocaleFile.put("paymentSuccessResponsePanelAmountBilled", replaceUIExpressions(ProjectManager.get("paymentSuccessResponsePanelAmountBilled")));
             theLocaleFile.put("paymentSucceededActionMessage", replaceUIExpressions(ProjectManager.get("paymentSucceededActionMessage")));
             // payment failed user interface strings
             theLocaleFile.put("paymentFailureResponsePanelTitle", replaceUIExpressions(ProjectManager.get("paymentFailureResponsePanelTitle")));
             theLocaleFile.put("paymentFailureResponsePanelHeaderDescription", replaceUIExpressions(ProjectManager.get("paymentFailureResponsePanelHeaderDescription")));
             theLocaleFile.put("paymentFailureResponsePanelOrderID", replaceUIExpressions(ProjectManager.get("paymentFailureResponsePanelOrderID")));
             theLocaleFile.put("paymentFailureResponsePanelNameOnCard", replaceUIExpressions(ProjectManager.get("paymentFailureResponsePanelNameOnCard")));
             theLocaleFile.put("paymentFailureResponsePanelEMailAddress", replaceUIExpressions(ProjectManager.get("paymentFailureResponsePanelEMailAddress")));
             theLocaleFile.put("paymentFailureResponsePanelAmountBilled", replaceUIExpressions(ProjectManager.get("paymentFailureResponsePanelAmountBilled")));
             theLocaleFile.put("paymentFailureResponsePanelMessage", replaceUIExpressions(ProjectManager.get("paymentFailureResponsePanelMessage")));
             //payment processing updated or added later
             theLocaleFile.put("paymentFailureRetryButtonText", replaceUIExpressions(ProjectManager.get("paymentFailureRetryButtonText")));
             theLocaleFile.put("paymentFailureRetryButtonMnemonic", replaceUIExpressions(ProjectManager.get("paymentFailureRetryButtonMnemonic")));
             theLocaleFile.put("paymentSuccessFinishButtonText", replaceUIExpressions(ProjectManager.get("paymentSuccessFinishButtonText")));
             theLocaleFile.put("paymentSuccessFinishButtonMnemonic", replaceUIExpressions(ProjectManager.get("paymentSuccessFinishButtonMnemonic")));
             theLocaleFile.put("paymentSuccessResponsePanelMessage", replaceUIExpressions(ProjectManager.get("paymentSuccessResponsePanelMessage")));
             theLocaleFile.put("paymentGenericAuthResponseSuccessMsg", replaceUIExpressions(ProjectManager.get("paymentGenericAuthResponseSuccessMsg")));
             theLocaleFile.put("paymentGenericAuthResponseFailureMsg", replaceUIExpressions(ProjectManager.get("paymentGenericAuthResponseFailureMsg")));
             // Additional Payment Processing variables
             if(urlExists(ProjectManager.get("paymentFormLeftTopImagePath"))==true)
             {
                 theLocaleFile.put("paymentFormLeftTopImagePath", "/images/" + ProjectManager.get("paymentFormLeftTopImagePath").substring(ProjectManager.get("paymentFormLeftTopImagePath").lastIndexOf("/") + 1));                 
             }              
             if(urlExists(ProjectManager.get("paymentFormRightTopImagePath"))==true)
             {
                 theLocaleFile.put("paymentFormRightTopImagePath", "/images/" + ProjectManager.get("paymentFormRightTopImagePath").substring(ProjectManager.get("paymentFormRightTopImagePath").lastIndexOf("/") + 1));                 
             }                
             if(urlExists(ProjectManager.get("paymentFormInputBackgroundImagePath"))==true)
             {
                 theLocaleFile.put("paymentFormInputBackgroundImagePath", "/images/" + ProjectManager.get("paymentFormInputBackgroundImagePath").substring(ProjectManager.get("paymentFormInputBackgroundImagePath").lastIndexOf("/") + 1));                 
             }   
             theLocaleFile.put("paymentPriceLabel", replaceUIExpressions(ProjectManager.get("paymentPriceLabel")));                
             theLocaleFile.put("secondaryPaymentMethodButtonText", replaceUIExpressions(ProjectManager.get("secondaryPaymentMethodButtonText")));       
             theLocaleFile.put("secondaryPaymentMethodButtonMnemonic", replaceUIExpressions(ProjectManager.get("secondaryPaymentMethodButtonMnemonic")));   
            int totalMessages = 0;
            if(ProjectManager.get("paymentResponseStatTotalMessages")!=null)
            {
                if(ProjectManager.get("paymentResponseStatTotalMessages").equalsIgnoreCase("")==false)
                {
                        totalMessages = Integer.valueOf(ProjectManager.get("paymentResponseStatTotalMessages")).intValue();						
                }
            }                                        
            if(totalMessages!=0)
            {
                for(int j = 0;j<totalMessages;j++)
                {
                    props.put("paymentResponseMsgDeclined" + String.valueOf(j + 1), replaceUIExpressions(ProjectManager.get("paymentResponseMsgDeclined" + String.valueOf(j + 1))));  
                }
            }    
             // Additional Refund Policy Variables should be appended to the Designer  
             theLocaleFile.put("refundPolicyTitle", replaceUIExpressions(ProjectManager.get("refundPolicyTitle")));      
             theLocaleFile.put("refundPolicy", replaceUIExpressions(ProjectManager.get("refundPolicy")));             
             theLocaleFile.put("refundPolicyOKBtnText", replaceUIExpressions(ProjectManager.get("refundPolicyOKBtnText")));  
             theLocaleFile.put("refundPolicyOKBtnMnemonic", replaceUIExpressions(ProjectManager.get("refundPolicyOKBtnMnemonic")));
             theLocaleFile.put("paymentSSLEnabledText", replaceUIExpressions(ProjectManager.get("paymentSSLEnabledText")));   
             // Startup User Interface
             theLocaleFile.put("startWindowTitle", replaceUIExpressions(ProjectManager.get("startWindowTitle")));
             theLocaleFile.put("btnBarUseEvalButtonText", replaceUIExpressions(ProjectManager.get("btnBarUseEvalButtonText")));
             theLocaleFile.put("btnBarBuyNowButtonText", replaceUIExpressions(ProjectManager.get("btnBarBuyNowButtonText")));
             theLocaleFile.put("btnBarRegButtonText", replaceUIExpressions(ProjectManager.get("btnBarRegButtonText")));
             theLocaleFile.put("btnBarInfoButtonText", replaceUIExpressions(ProjectManager.get("btnBarInfoButtonText")));
             theLocaleFile.put("btnBarExitButtonText", replaceUIExpressions(ProjectManager.get("btnBarExitButtonText")));
             theLocaleFile.put("btnBarUseEvalButtonMnemonic", replaceUIExpressions(ProjectManager.get("btnBarUseEvalButtonMnemonic")));
             theLocaleFile.put("btnBarBuyNowButtonMnemonic", replaceUIExpressions(ProjectManager.get("btnBarBuyNowButtonMnemonic")));
             theLocaleFile.put("btnBarRegButtonMnemonic", replaceUIExpressions(ProjectManager.get("btnBarRegButtonMnemonic")));
             theLocaleFile.put("btnBarInfoButtonMnemonic", replaceUIExpressions(ProjectManager.get("btnBarInfoButtonMnemonic")));
             theLocaleFile.put("btnBarExitButtonMnemonic", replaceUIExpressions(ProjectManager.get("btnBarExitButtonMnemonic")));
             theLocaleFile.put("imageMissingText", replaceUIExpressions(ProjectManager.get("imageMissingText")));
             // common gui scrollbar component variables
             if(urlExists(ProjectManager.get("splashImgPath"))==true)
             {
                theLocaleFile.put("splashImgPath", "/images/" + ProjectManager.get("splashImgPath").substring(ProjectManager.get("splashImgPath").lastIndexOf("/") + 1));                 
             }
             if(ProjectManager.get("btnBarImgBtnEnabled")!=null)
             {
                 if(ProjectManager.get("btnBarImgBtnEnabled").equalsIgnoreCase("true")==true)
                 {                 
                     if(urlExists(ProjectManager.get("btnBarImgPath"))==true)
                     {
                        theLocaleFile.put("btnBarImgPath", "/images/" + ProjectManager.get("btnBarImgPath").substring(ProjectManager.get("btnBarImgPath").lastIndexOf("/") + 1));                 
                     }             
                 }
             }
             if(ProjectManager.get("progressPanelImgEnabled")!=null)
             {
                 if(ProjectManager.get("progressPanelImgEnabled").equalsIgnoreCase("true")==true)
                 {   
                     if(urlExists(ProjectManager.get("progressPanelImgPath"))==true)
                     {
                        theLocaleFile.put("progressPanelImgPath", "/images/" + ProjectManager.get("progressPanelImgPath").substring(ProjectManager.get("progressPanelImgPath").lastIndexOf("/") + 1));                 
                     }   
                 }
             }
             //else if(jarResourceExists(ProjectManager.get("splashImgPath"))==true)
             //{
             //   theLocaleFile.put("splashImgPath", "/images/" + ProjectManager.get("splashImgPath").substring(ProjectManager.get("splashImgPath").lastIndexOf("/") + 1));                 
             //}
             //theLocaleFile.put("btnBarImgPath", ProjectManager.get("btnBarImgPath"));  
             //theLocaleFile.put("progressPanelImgPath", replaceUIExpressions(ProjectManager.get("progressPanelImgPath")));
             theLocaleFile.put("progressBarDaysLeftText", replaceUIExpressions(ProjectManager.get("progressBarDaysLeftText")));
             theLocaleFile.put("progressBarExpiredText", replaceUIExpressions(ProjectManager.get("progressBarExpiredText")));
             // Information Dialog
             theLocaleFile.put("informationOKBtnText", replaceUIExpressions(ProjectManager.get("informationOKBtnText")));  
             theLocaleFile.put("informationOKBtnMnemonic", replaceUIExpressions(ProjectManager.get("informationOKBtnMnemonic")));
             theLocaleFile.put("informationText", replaceUIExpressions(ProjectManager.get("informationText")));
             theLocaleFile.put("informationTextTitle", replaceUIExpressions(ProjectManager.get("informationTextTitle")));
             theLocaleFile.put("paymentCancelButtonMnemonic", replaceUIExpressions(ProjectManager.get("paymentCancelButtonMnemonic")));
             theLocaleFile.put("paymentContinueButtonMnemonic", replaceUIExpressions(ProjectManager.get("paymentContinueButtonMnemonic")));
             theLocaleFile.put("optinPrivacyPolicyMnemonic", replaceUIExpressions(ProjectManager.get("optinPrivacyPolicyMnemonic")));      
             if(urlExists(ProjectManager.get("paymentRespSuccessBackgroundImagePath"))==true)
             {
                 theLocaleFile.put("paymentRespSuccessBackgroundImagePath", "/images/" + ProjectManager.get("paymentRespSuccessBackgroundImagePath").substring(ProjectManager.get("paymentRespSuccessBackgroundImagePath").lastIndexOf("/") + 1));                 
             }              
             if(urlExists(ProjectManager.get("paymentRespFailureBackgroundImagePath"))==true)
             {
                 theLocaleFile.put("paymentRespFailureBackgroundImagePath", "/images/" + ProjectManager.get("paymentRespFailureBackgroundImagePath").substring(ProjectManager.get("paymentRespFailureBackgroundImagePath").lastIndexOf("/") + 1));                 
             }             
             theLocaleFile.put("paymentPhoneLabel", replaceUIExpressions(ProjectManager.get("paymentPhoneLabel")));
             theLocaleFile.put("autoUpdateErrorMessage", replaceUIExpressions(ProjectManager.get("autoUpdateErrorMessage")));                  
             theLocaleFile.put("autoUpdateNotAbleToComplete", replaceUIExpressions(ProjectManager.get("autoUpdateNotAbleToComplete")));  
             theLocaleFile.put("errokbtn", replaceUIExpressions(ProjectManager.get("errokbtn")));
             theLocaleFile.put("errokbtnmnem", replaceUIExpressions(ProjectManager.get("errokbtnmnem")));
             theLocaleFile.put("autoUpdateErrorTitle", replaceUIExpressions(ProjectManager.get("autoUpdateErrorTitle")));
             theLocaleFile.put("errMsgTitle", replaceUIExpressions(ProjectManager.get("errMsgTitle")));
             theLocaleFile.put("infoMsgTitle", replaceUIExpressions(ProjectManager.get("infoMsgTitle")));   
             theLocaleFile.put("msgMsgTitle", replaceUIExpressions(ProjectManager.get("msgMsgTitle")));  
             theLocaleFile.put("evalLockdown", replaceUIExpressions(ProjectManager.get("evalLockdown")));
             theLocaleFile.put("socketException", replaceUIExpressions(ProjectManager.get("socketException")));
             theLocaleFile.put("unknownHostException", replaceUIExpressions(ProjectManager.get("unknownHostException")));
             // Remove added variables that are not used. TODO: add logic to not add them in the first place, then they will not need to be removed.
                // The project setting for optin support is enabled/disabled
                if(ProjectManager.get("project_optin_is_enabled").equalsIgnoreCase("false")==true)
                {
                    // optin UI Strings
                    theLocaleFile.remove("optinYourNameLabel");
                    theLocaleFile.remove("optinYourEMailLabel");
                    theLocaleFile.remove("registerSoftwareTitle");
                    theLocaleFile.remove("optinDescription");
                    theLocaleFile.remove("optinCancelButtonText");
                    theLocaleFile.remove("optinContinueButtonText");                   
                    theLocaleFile.remove("optinCancelButtonMnemonic");
                    theLocaleFile.remove("optinContinueButtonMnemonic");    
                    theLocaleFile.remove("optinEnterNameMessage");
                    theLocaleFile.remove("optinEnterValidEMailMessage");    
                    theLocaleFile.remove("optinEnterEMailMessage");
                    
                    // optin privacy policy
                    theLocaleFile.remove("privacyPolicy");                    
                    theLocaleFile.remove("optinPrivacyPolicyLabel");
                    theLocaleFile.remove("privacyPolicyTitle");                    
                    theLocaleFile.remove("optinPrivacyPolicyMnemonic");                     
                    theLocaleFile.remove("privacyPolicyOKBtnText");
                    theLocaleFile.remove("privacyPolicyOKBtnMnemonic");
                }
                else
                { 
                    // optin ui string replacements here.
                    if(ProjectManager.get("optinPrivacyPolicyEnabled").equalsIgnoreCase("true")==false || ((String)props.get("privacyPolicyActionType")).equalsIgnoreCase("1")!=true)
                    {
                    	// optin privacy policy
                    	theLocaleFile.remove("privacyPolicy");                    
                    	theLocaleFile.remove("optinPrivacyPolicyLabel");
                   	theLocaleFile.remove("privacyPolicyTitle");                    
                    	theLocaleFile.remove("optinPrivacyPolicyMnemonic");                     
                    	theLocaleFile.remove("privacyPolicyOKBtnText");
                    	theLocaleFile.remove("privacyPolicyOKBtnMnemonic");
                    }
                }
                /* The project setting for registration code support is enabled */            
                if(ProjectManager.get("project_registration_code_support_is_enabled").equalsIgnoreCase("false")==true)
                {
                    // registration window user interface strings                
                    theLocaleFile.remove("registerSoftwareWindowTitle");
                    theLocaleFile.remove("registrationCodeLabel");
                    theLocaleFile.remove("registrationPaidLabel");
                    theLocaleFile.remove("registrationCodeLabelFontMnemonic");
                    theLocaleFile.remove("registrationCancelButtonText");
                    theLocaleFile.remove("registrationCancelButtonMnemonic");
                    theLocaleFile.remove("registrationFinishButtonText");
                    theLocaleFile.remove("registrationFinishButtonMnemonic");
                    //registration success window user interface strings
                    theLocaleFile.remove("registrationSuccessWindowTitle");
                    theLocaleFile.remove("registrationSuccessHeader");
                    theLocaleFile.remove("registrationSuccessDesc");
                    theLocaleFile.remove("registrationSuccessOK");
                    theLocaleFile.remove("registrationSuccessOKMnemonic");
                    //registration failed window user interface strings
                    theLocaleFile.remove("registrationFailedWindowTitle");
                    theLocaleFile.remove("registrationFailedMessage");
                    theLocaleFile.remove("registrationFailureOK");
                    theLocaleFile.remove("registrationFailureOKMnemonic");                   
                }
                /* The project setting for payment processing support is enabled */            
                if(ProjectManager.get("project_payment_processing_support_is_enabled").equalsIgnoreCase("false")==true)
                {
                     // payment user interface strings
                     theLocaleFile.remove("paymentWindowTitle");
                     theLocaleFile.remove("paymentStateLabel");
                     theLocaleFile.remove("paymentExpMMYYLabel");    
                     theLocaleFile.remove("paymentContinueButtonText");
                     theLocaleFile.remove("paymentCancelButtonText");
                     theLocaleFile.remove("paymentInstructionsLine1");
                     theLocaleFile.remove("paymentVerificationCodeLabel");
                     theLocaleFile.remove("paymentRefundPolicyLabel");
                     theLocaleFile.remove("paymentFirstNameDataFieldEmptyMessage");
                     theLocaleFile.remove("paymentLastNameDataFieldEmptyMessage");
                     theLocaleFile.remove("paymentValidEMailDataFieldEmptyMessage");
                     theLocaleFile.remove("paymentEMailDataFieldEmptyMessage");
                     theLocaleFile.remove("paymentStreetDataFieldEmptyMessage");
                     theLocaleFile.remove("paymentCityDataFieldEmptyMessage");
                     theLocaleFile.remove("paymentZipDataFieldEmptyMessage");
                     theLocaleFile.remove("paymentCCDataFieldEmptyMessage");
                     theLocaleFile.remove("paymentCCVerificationCodeFieldEmptyMessage");
                     theLocaleFile.remove("paymentPhoneDataFieldEmptyMessage");                    
                     theLocaleFile.remove("paymentFirstNameLabel");
                     theLocaleFile.remove("paymentLastNameLabel");
                     theLocaleFile.remove("paymentEMailLabel");
                     theLocaleFile.remove("paymentPhoneLabel");                     
                     theLocaleFile.remove("paymentStreetLabel");
                     theLocaleFile.remove("paymentCityLabel");
                     theLocaleFile.remove("paymentCountryLabel");
                     theLocaleFile.remove("paymentZipCodeLabel");
                     theLocaleFile.remove("paymentPaymentMethodLabel");
                     theLocaleFile.remove("paymentCCLabel");
                     theLocaleFile.remove("paymentOrdersOutsideUSLabel");
                     theLocaleFile.remove("refundPolicy");   
                     theLocaleFile.remove("refundPolicyTitle");
                     theLocaleFile.remove("refundPolicyOKBtnText");   
                     theLocaleFile.remove("refundPolicyOKBtnMnemonic");
                     theLocaleFile.remove("paymentSuccessFinishButtonMnemonic");
                     theLocaleFile.remove("paymentSuccessFinishButtonText");
                     // payment success user interface strings
                     theLocaleFile.remove("paymentSuccessResponsePanelTitle");
                     theLocaleFile.remove("paymentSuccessResponsePanelHeaderDescription");
                     theLocaleFile.remove("paymentSuccessResponsePanelOrderID");
                     theLocaleFile.remove("paymentSuccessResponsePanelNameOnCard");
                     theLocaleFile.remove("paymentSuccessResponsePanelEMailAddress");
                     theLocaleFile.remove("paymentSuccessResponsePanelAmountBilled");
                     theLocaleFile.remove("paymentSuccessResponsePanelMessage");
                     // payment failed user interface strings
                     theLocaleFile.remove("paymentFailureResponsePanelTitle");
                     theLocaleFile.remove("paymentFailureResponsePanelHeaderDescription");
                     theLocaleFile.remove("paymentFailureResponsePanelOrderID");
                     theLocaleFile.remove("paymentFailureResponsePanelNameOnCard");
                     theLocaleFile.remove("paymentFailureResponsePanelEMailAddress");
                     theLocaleFile.remove("paymentFailureResponsePanelAmountBilled");
                     theLocaleFile.remove("paymentFailureResponsePanelMessage");
                     theLocaleFile.remove("paymentFailureRetryButtonText");                     
                     theLocaleFile.remove("paymentFailureRetryButtonMnemonic");   
                     theLocaleFile.remove("paymentCancelButtonMnemonic");
                     theLocaleFile.remove("paymentContinueButtonMnemonic");
                     theLocaleFile.remove("paymentFormProductLabel"); 
                     theLocaleFile.remove("paymentPriceLabel"); 
                     theLocaleFile.remove("secondaryPaymentMethodButtonText"); 
                     theLocaleFile.remove("secondaryPaymentMethodButtonMnemonic");  
                     theLocaleFile.remove("paymentSSLEnabledText");      
                     theLocaleFile.remove("paymentGenericAuthResponseFailureMsg");  
                     theLocaleFile.remove("paymentGenericAuthResponseSuccessMsg");
                     // payment processing result variables to remove need some logic
                     totalMessages = 0;
                     if(ProjectManager.get("paymentResponseStatTotalMessages")!=null)
                     {
                            if(ProjectManager.get("paymentResponseStatTotalMessages").equalsIgnoreCase("")==false)
                            {
                                    totalMessages = Integer.valueOf(ProjectManager.get("paymentResponseStatTotalMessages")).intValue();						
                            }
                     }                                        
                     if(totalMessages!=0)
                     {
                        for(int j = 0;j<totalMessages;j++)
                        {
                             theLocaleFile.remove("paymentResponseMsgDeclined" + String.valueOf(j + 1));
                        }
                     }       
                     theLocaleFile.remove("paymentRespFailureBackgroundImagePath");
                     theLocaleFile.remove("paymentFormLeftTopImagePath");
                     theLocaleFile.remove("paymentFormRightTopImagePath"); 
                     theLocaleFile.remove("paymentFormInputBackgroundImagePath");
                     theLocaleFile.remove("paymentRespSuccessBackgroundImagePath");
                    // prjExpirationSupport = 0 if Support is Enabled, and 1 if not enabled.
                    int prjExpirationSupport = 0;
                    int prjOptinSupport = 0;        
                    int prjRegistrationSupport = 0;
                    int prjPaymentSupport = 0; 
                    int prjAutoUpdateSupport = 0;        
                    int prjMessagingSupport = 0;     
                    try
                    { 
                       if(ProjectManager.get("project_expiration_support_is_enabled").equalsIgnoreCase("true") == true)
                        {
                            prjExpirationSupport = 0;
                        }
                        else
                        {
                            prjExpirationSupport = 1;
                        }
                        if(ProjectManager.get("project_optin_is_enabled").equalsIgnoreCase("true") == true)
                        {
                            prjOptinSupport = 0;
                        }
                        else
                        {
                            prjOptinSupport = 1;
                        }            
                        if(ProjectManager.get("project_registration_code_support_is_enabled").equalsIgnoreCase("true") == true)
                        {
                            prjRegistrationSupport = 0;
                        }
                        else
                        {
                            prjRegistrationSupport = 1;
                        }   
                        if(ProjectManager.get("project_payment_processing_support_is_enabled").equalsIgnoreCase("true") == true)
                        {
                            prjPaymentSupport = 0;
                        }
                        else
                        {
                            prjPaymentSupport = 1;
                        }   
                        if(ProjectManager.get("project_auto_update_support_is_enabled").equalsIgnoreCase("true") == true)
                        {
                            prjAutoUpdateSupport = 0;
                        }
                        else
                        {
                            prjAutoUpdateSupport = 1;
                        }   
                        if(ProjectManager.get("project_messaging_support_is_enabled").equalsIgnoreCase("true") == true)
                        {
                            prjMessagingSupport = 0;
                        }
                        else
                        {
                            prjMessagingSupport = 1;
                        }
                       
                        if(prjAutoUpdateSupport == 1)
                        {
                            theLocaleFile.remove("autoUpdateErrorMessage");
                            theLocaleFile.remove("autoUpdateErrorTitle");
                            theLocaleFile.remove("autoUpdateNotAbleToComplete");
                        }
                            // startup window variables
                            try
                            {
                                if(prjPaymentSupport != 0 && prjRegistrationSupport != 0 && prjExpirationSupport != 0)
                                {                    
                                    if(ProjectManager.get("project_gui_model")!=null)
                                    {
                                        if(ProjectManager.get("project_gui_model").equalsIgnoreCase("0")==true)
                                        {                        
                                            theLocaleFile.remove("informationText");
                                            theLocaleFile.remove("informationTextTitle"); 
                                            theLocaleFile.remove("informationOKBtnMnemonic"); 
                                            theLocaleFile.remove("informationOKBtnText"); 
                                            theLocaleFile.remove("btnBarInfoButtonMnemonic");
                                            theLocaleFile.remove("btnBarInfoButtonText"); 
                                            theLocaleFile.remove("btnBarRegButtonText");
                                            theLocaleFile.remove("btnBarExitButtonMnemonic");
                                            theLocaleFile.remove("btnBarRegButtonMnemonic");
                                            theLocaleFile.remove("imageMissingText");
                                            theLocaleFile.remove("btnBarUseEvalButtonMnemonic");
                                            theLocaleFile.remove("btnBarBuyNowButtonText");
                                            theLocaleFile.remove("btnBarUseEvalButtonText");
                                            theLocaleFile.remove("btnBarImgPath");
                                            theLocaleFile.remove("progressBarExpiredText");
                                            theLocaleFile.remove("progressBarDaysLeftText");
                                            theLocaleFile.remove("progressPanelImgPath");
                                            theLocaleFile.remove("btnBarExitButtonText");
                                            theLocaleFile.remove("btnBarBuyNowButtonMnemonic");
                                            theLocaleFile.remove("startWindowTitle");
                                            theLocaleFile.remove("splashImgPath");
                                        }
                                    }
                                }
                            else
                            {
                                    if(ProjectManager.get("infoActionType").equalsIgnoreCase("1") == false)
                                    {
                                            theLocaleFile.remove("informationText");
                                            theLocaleFile.remove("informationTextTitle"); 
                                            theLocaleFile.remove("informationOKBtnMnemonic"); 
                                            theLocaleFile.remove("informationOKBtnText"); 
                                    }
                           } 
                            if(prjPaymentSupport != 0 && prjRegistrationSupport != 0 && prjExpirationSupport != 0 && prjMessagingSupport != 0 && prjAutoUpdateSupport != 0 && prjOptinSupport != 0)
                            {                    
                                theLocaleFile.remove("msgMsgTitle"); 
                                theLocaleFile.remove("infoMsgTitle");
                                theLocaleFile.remove("errMsgTitle");
                                theLocaleFile.remove("errokbtnmnem");
                                theLocaleFile.remove("errokbtn");
                                theLocaleFile.remove("socketException");
                                theLocaleFile.remove("unknownHostException");
                            }
                            if(prjExpirationSupport != 0)
                            {
                                theLocaleFile.remove("evalLockdown");
                            }
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                    catch(Exception e)
                    {
                            e.printStackTrace();
                    }                    
                }
                else 
                {
 
                }               
             // end of remove variables
             
             theLocaleFile.saveProject();
             return localeFile;
        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }        
        return null;
   }    

    /** The inputLocaleFile is the original Locale file, the locale File is the updated Locale file based on distribution feature selection. */
    private File getOptimizedLocaleFile(File inputLocaleFile, File localeFile, String strLocale)
    {
        try
        {
            ProjectFile theInputLocaleFile = new ProjectFile(inputLocaleFile.toURL().toString()); 
            theInputLocaleFile.openProject();

            ProjectFile theLocaleFile = new ProjectFile(localeFile.toURL().toString()); 
            theLocaleFile.openProject();
            
            theLocaleFile.put("#","#Resource Bundle: MessagesBundle" + "_" + strLocale + ".properties - Copyright 2004-2005, Trinity Software, LLC. All rights reserved.");
            // registration UI Variables
            theLocaleFile.put("registerSoftwareWindowTitle", replaceUIExpressions(theInputLocaleFile.get("registerSoftwareWindowTitle")));
            theLocaleFile.put("registrationCodeLabel", replaceUIExpressions(theInputLocaleFile.get("registrationCodeLabel")));
            theLocaleFile.put("registrationPaidLabel", replaceUIExpressions(theInputLocaleFile.get("registrationPaidLabel")));
            theLocaleFile.put("registrationCodeLabelFontMnemonic", replaceUIExpressions(theInputLocaleFile.get("registrationCodeLabelFontMnemonic")));
            theLocaleFile.put("registrationCancelButtonText", replaceUIExpressions(theInputLocaleFile.get("registrationCancelButtonText"))); 
            theLocaleFile.put("registrationFinishButtonText", replaceUIExpressions(theInputLocaleFile.get("registrationFinishButtonText"))); 
            theLocaleFile.put("registrationCancelButtonMnemonic", replaceUIExpressions(theInputLocaleFile.get("registrationCancelButtonMnemonic"))); 
            theLocaleFile.put("registrationFinishButtonMnemonic", replaceUIExpressions(theInputLocaleFile.get("registrationFinishButtonMnemonic")));  
            //registration failed window user interface strings
            theLocaleFile.put("registrationFailedWindowTitle", replaceUIExpressions(theInputLocaleFile.get("registrationFailedWindowTitle")));
            theLocaleFile.put("registrationFailedMessage", replaceUIExpressions(theInputLocaleFile.get("registrationFailedMessage")));
            theLocaleFile.put("registrationFailureOK", replaceUIExpressions(theInputLocaleFile.get("registrationFailureOK"))); 
            theLocaleFile.put("registrationFailureOKMnemonic", replaceUIExpressions(theInputLocaleFile.get("registrationFailureOKMnemonic")));   
            //registration success window user interface strings
            theLocaleFile.put("registrationSuccessWindowTitle", replaceUIExpressions(theInputLocaleFile.get("registrationSuccessWindowTitle")));
            theLocaleFile.put("registrationSuccessHeader", replaceUIExpressions(theInputLocaleFile.get("registrationSuccessHeader"))); 
            theLocaleFile.put("registrationSuccessDesc", replaceUIExpressions(theInputLocaleFile.get("registrationSuccessDesc"))); 
            theLocaleFile.put("registrationSuccessOK", replaceUIExpressions(theInputLocaleFile.get("registrationSuccessOK"))); 
            theLocaleFile.put("registrationSuccessOKMnemonic", replaceUIExpressions(theInputLocaleFile.get("registrationSuccessOKMnemonic")));  
            // optin UI Strings
            theLocaleFile.put("privacyPolicy", replaceUIExpressions(theInputLocaleFile.get("privacyPolicy")));
            theLocaleFile.put("optinYourNameLabel", replaceUIExpressions(theInputLocaleFile.get("optinYourNameLabel")));
            theLocaleFile.put("optinYourEMailLabel", replaceUIExpressions(theInputLocaleFile.get("optinYourEMailLabel")));
            theLocaleFile.put("registerSoftwareTitle", replaceUIExpressions(theInputLocaleFile.get("registerSoftwareTitle")));
            theLocaleFile.put("optinPrivacyPolicyLabel", replaceUIExpressions(theInputLocaleFile.get("optinPrivacyPolicyLabel")));
            theLocaleFile.put("privacyPolicyTitle", replaceUIExpressions(theInputLocaleFile.get("privacyPolicyTitle")));
            theLocaleFile.put("optinDescription", replaceUIExpressions(theInputLocaleFile.get("optinDescription")));
// Additional Privacy Policy Variables should be appended to the Designer             
             theLocaleFile.put("privacyPolicyOKBtnText", replaceUIExpressions(theInputLocaleFile.get("privacyPolicyOKBtnText")));  
             theLocaleFile.put("privacyPolicyOKBtnMnemonic", replaceUIExpressions(theInputLocaleFile.get("privacyPolicyOKBtnMnemonic")));
// Additional Opt-In Window Variables
             theLocaleFile.put("optinCancelButtonText", replaceUIExpressions(theInputLocaleFile.get("optinCancelButtonText")));
             theLocaleFile.put("optinCancelButtonMnemonic", replaceUIExpressions(theInputLocaleFile.get("optinCancelButtonMnemonic")));
             theLocaleFile.put("optinContinueButtonText", replaceUIExpressions(theInputLocaleFile.get("optinContinueButtonText")));
             theLocaleFile.put("optinContinueButtonMnemonic", replaceUIExpressions(theInputLocaleFile.get("optinContinueButtonMnemonic")));
// Additional Optin Strings
             theLocaleFile.put("optinEnterNameMessage", replaceUIExpressions(theInputLocaleFile.get("optinEnterNameMessage")));
             theLocaleFile.put("optinEnterValidEMailMessage", replaceUIExpressions(theInputLocaleFile.get("optinEnterValidEMailMessage")));   
             theLocaleFile.put("optinEnterEMailMessage", replaceUIExpressions(theInputLocaleFile.get("optinEnterEMailMessage")));
             // Additional Optin Processing Variables          
             theLocaleFile.put("optinPrivacyPolicyMnemonic", replaceUIExpressions(theInputLocaleFile.get("optinPrivacyPolicyMnemonic")));
             // payment user interface strings
             theLocaleFile.put("paymentWindowTitle", replaceUIExpressions(theInputLocaleFile.get("paymentWindowTitle")));
             theLocaleFile.put("paymentStateLabel", replaceUIExpressions(theInputLocaleFile.get("paymentStateLabel"))); 
             theLocaleFile.put("paymentExpMMYYLabel", replaceUIExpressions(theInputLocaleFile.get("paymentExpMMYYLabel")));    
             theLocaleFile.put("paymentContinueButtonText", replaceUIExpressions(theInputLocaleFile.get("paymentContinueButtonText")));
             theLocaleFile.put("paymentCancelButtonText", replaceUIExpressions(theInputLocaleFile.get("paymentCancelButtonText")));
             theLocaleFile.put("paymentInstructionsLine1", replaceUIExpressions(theInputLocaleFile.get("paymentInstructionsLine1")));
             theLocaleFile.put("paymentVerificationCodeLabel", replaceUIExpressions(theInputLocaleFile.get("paymentVerificationCodeLabel")));
             theLocaleFile.put("paymentRefundPolicyLabel", replaceUIExpressions(theInputLocaleFile.get("paymentRefundPolicyLabel")));
             theLocaleFile.put("paymentFirstNameDataFieldEmptyMessage", replaceUIExpressions(theInputLocaleFile.get("paymentFirstNameDataFieldEmptyMessage")));
             theLocaleFile.put("paymentLastNameDataFieldEmptyMessage", replaceUIExpressions(theInputLocaleFile.get("paymentLastNameDataFieldEmptyMessage")));
             theLocaleFile.put("paymentValidEMailDataFieldEmptyMessage", replaceUIExpressions(theInputLocaleFile.get("paymentValidEMailDataFieldEmptyMessage")));
             theLocaleFile.put("paymentEMailDataFieldEmptyMessage", replaceUIExpressions(theInputLocaleFile.get("paymentEMailDataFieldEmptyMessage")));
             theLocaleFile.put("paymentStreetDataFieldEmptyMessage", replaceUIExpressions(theInputLocaleFile.get("paymentStreetDataFieldEmptyMessage")));
             theLocaleFile.put("paymentCityDataFieldEmptyMessage", replaceUIExpressions(theInputLocaleFile.get("paymentCityDataFieldEmptyMessage")));
             theLocaleFile.put("paymentZipDataFieldEmptyMessage", replaceUIExpressions(theInputLocaleFile.get("paymentZipDataFieldEmptyMessage")));
             theLocaleFile.put("paymentCCDataFieldEmptyMessage", replaceUIExpressions(theInputLocaleFile.get("paymentCCDataFieldEmptyMessage")));
             theLocaleFile.put("paymentCCVerificationCodeFieldEmptyMessage", replaceUIExpressions(theInputLocaleFile.get("paymentCCVerificationCodeFieldEmptyMessage")));
             theLocaleFile.put("paymentPhoneDataFieldEmptyMessage", replaceUIExpressions(theInputLocaleFile.get("paymentPhoneDataFieldEmptyMessage")));
             theLocaleFile.put("paymentFirstNameLabel", replaceUIExpressions(theInputLocaleFile.get("paymentFirstNameLabel"))); 
             theLocaleFile.put("paymentLastNameLabel", replaceUIExpressions(theInputLocaleFile.get("paymentLastNameLabel")));
             theLocaleFile.put("paymentEMailLabel", replaceUIExpressions(theInputLocaleFile.get("paymentEMailLabel")));
             theLocaleFile.put("paymentStreetLabel", replaceUIExpressions(theInputLocaleFile.get("paymentStreetLabel")));
             theLocaleFile.put("paymentCityLabel", replaceUIExpressions(theInputLocaleFile.get("paymentCityLabel")));
             theLocaleFile.put("paymentCountryLabel", replaceUIExpressions(theInputLocaleFile.get("paymentCountryLabel")));
             theLocaleFile.put("paymentZipCodeLabel", replaceUIExpressions(theInputLocaleFile.get("paymentZipCodeLabel")));
             theLocaleFile.put("paymentPaymentMethodLabel", replaceUIExpressions(theInputLocaleFile.get("paymentPaymentMethodLabel")));
             theLocaleFile.put("paymentCCLabel", replaceUIExpressions(theInputLocaleFile.get("paymentCCLabel")));
             theLocaleFile.put("paymentOrdersOutsideUSLabel", replaceUIExpressions(theInputLocaleFile.get("paymentOrdersOutsideUSLabel")));
             //theLocaleFile.put("paymentFormProductLabel", replaceUIExpressions(theInputLocaleFile.get("paymentFormProductLabel")));
             if(ProjectManager.get("paymentFormProductLabelImageEnabled")!=null)
             {
                if(ProjectManager.get("paymentFormProductLabelImageEnabled").equalsIgnoreCase("true")==true)
                {           
                     if(urlExists(theInputLocaleFile.get("paymentFormProductLabel"))==true)
                     {
                         theLocaleFile.put("paymentFormProductLabel", "/images/" + theInputLocaleFile.get("paymentFormProductLabel").substring(theInputLocaleFile.get("paymentFormProductLabel").lastIndexOf("/") + 1));                 
                     }     
                     else
                     {
                         theLocaleFile.put("paymentFormProductLabel", replaceUIExpressions(theInputLocaleFile.get("paymentFormProductLabel")));
                     }
                 }
                else
                {
                    theLocaleFile.put("paymentFormProductLabel", replaceUIExpressions(theInputLocaleFile.get("paymentFormProductLabel")));
                }
             }
             else
             {
                 theLocaleFile.put("paymentFormProductLabel", replaceUIExpressions(theInputLocaleFile.get("paymentFormProductLabel")));
             }
             // payment success user interface strings
             theLocaleFile.put("paymentSuccessResponsePanelTitle", replaceUIExpressions(theInputLocaleFile.get("paymentSuccessResponsePanelTitle")));
             theLocaleFile.put("paymentSuccessResponsePanelHeaderDescription", replaceUIExpressions(theInputLocaleFile.get("paymentSuccessResponsePanelHeaderDescription")));
             theLocaleFile.put("paymentSuccessResponsePanelOrderID", replaceUIExpressions(theInputLocaleFile.get("paymentSuccessResponsePanelOrderID")));
             theLocaleFile.put("paymentSuccessResponsePanelNameOnCard", replaceUIExpressions(theInputLocaleFile.get("paymentSuccessResponsePanelNameOnCard")));
             theLocaleFile.put("paymentSuccessResponsePanelEMailAddress", replaceUIExpressions(theInputLocaleFile.get("paymentSuccessResponsePanelEMailAddress")));
             theLocaleFile.put("paymentSuccessResponsePanelAmountBilled", replaceUIExpressions(theInputLocaleFile.get("paymentSuccessResponsePanelAmountBilled")));
             theLocaleFile.put("paymentSucceededActionMessage", replaceUIExpressions(theInputLocaleFile.get("paymentSucceededActionMessage")));
             // payment failed user interface strings
             theLocaleFile.put("paymentFailureResponsePanelTitle", replaceUIExpressions(theInputLocaleFile.get("paymentFailureResponsePanelTitle")));
             theLocaleFile.put("paymentFailureResponsePanelHeaderDescription", replaceUIExpressions(theInputLocaleFile.get("paymentFailureResponsePanelHeaderDescription")));
             theLocaleFile.put("paymentFailureResponsePanelOrderID", replaceUIExpressions(theInputLocaleFile.get("paymentFailureResponsePanelOrderID")));
             theLocaleFile.put("paymentFailureResponsePanelNameOnCard", replaceUIExpressions(theInputLocaleFile.get("paymentFailureResponsePanelNameOnCard")));
             theLocaleFile.put("paymentFailureResponsePanelEMailAddress", replaceUIExpressions(theInputLocaleFile.get("paymentFailureResponsePanelEMailAddress")));
             theLocaleFile.put("paymentFailureResponsePanelAmountBilled", replaceUIExpressions(theInputLocaleFile.get("paymentFailureResponsePanelAmountBilled")));
             theLocaleFile.put("paymentFailureResponsePanelMessage", replaceUIExpressions(theInputLocaleFile.get("paymentFailureResponsePanelMessage")));
             //payment processing updated or added later
             theLocaleFile.put("paymentFailureRetryButtonText", replaceUIExpressions(theInputLocaleFile.get("paymentFailureRetryButtonText")));
             theLocaleFile.put("paymentFailureRetryButtonMnemonic", replaceUIExpressions(theInputLocaleFile.get("paymentFailureRetryButtonMnemonic")));
             theLocaleFile.put("paymentSuccessFinishButtonText", replaceUIExpressions(theInputLocaleFile.get("paymentSuccessFinishButtonText")));
             theLocaleFile.put("paymentSuccessFinishButtonMnemonic", replaceUIExpressions(theInputLocaleFile.get("paymentSuccessFinishButtonMnemonic")));
             theLocaleFile.put("paymentSuccessResponsePanelMessage", replaceUIExpressions(theInputLocaleFile.get("paymentSuccessResponsePanelMessage")));
             theLocaleFile.put("paymentGenericAuthResponseSuccessMsg", replaceUIExpressions(theInputLocaleFile.get("paymentGenericAuthResponseSuccessMsg")));
             theLocaleFile.put("paymentGenericAuthResponseFailureMsg", replaceUIExpressions(theInputLocaleFile.get("paymentGenericAuthResponseFailureMsg")));
             // Additional Payment Processing variables
             //theLocaleFile.put("paymentFormLeftTopImagePath", replaceUIExpressions(theInputLocaleFile.get("paymentFormLeftTopImagePath")));   
             //theLocaleFile.put("paymentFormRightTopImagePath", replaceUIExpressions(theInputLocaleFile.get("paymentFormRightTopImagePath")));     
             //theLocaleFile.put("paymentFormInputBackgroundImagePath", replaceUIExpressions(theInputLocaleFile.get("paymentFormInputBackgroundImagePath"))); 
             if(urlExists(theInputLocaleFile.get("paymentFormLeftTopImagePath"))==true)
             {
                 theLocaleFile.put("paymentFormLeftTopImagePath", "/images/" + theInputLocaleFile.get("paymentFormLeftTopImagePath").substring(theInputLocaleFile.get("paymentFormLeftTopImagePath").lastIndexOf("/") + 1));                 
             }              
             if(urlExists(theInputLocaleFile.get("paymentFormRightTopImagePath"))==true)
             {
                 theLocaleFile.put("paymentFormRightTopImagePath", "/images/" + theInputLocaleFile.get("paymentFormRightTopImagePath").substring(theInputLocaleFile.get("paymentFormRightTopImagePath").lastIndexOf("/") + 1));                 
             }                
             if(urlExists(theInputLocaleFile.get("paymentFormInputBackgroundImagePath"))==true)
             {
                 theLocaleFile.put("paymentFormInputBackgroundImagePath", "/images/" + theInputLocaleFile.get("paymentFormInputBackgroundImagePath").substring(theInputLocaleFile.get("paymentFormInputBackgroundImagePath").lastIndexOf("/") + 1));                 
             }   
             
             theLocaleFile.put("paymentPriceLabel", replaceUIExpressions(theInputLocaleFile.get("paymentPriceLabel")));                
             theLocaleFile.put("secondaryPaymentMethodButtonText", replaceUIExpressions(theInputLocaleFile.get("secondaryPaymentMethodButtonText")));       
             theLocaleFile.put("secondaryPaymentMethodButtonMnemonic", replaceUIExpressions(theInputLocaleFile.get("secondaryPaymentMethodButtonMnemonic")));   
            int totalMessages = 0;
            if(ProjectManager.get("paymentResponseStatTotalMessages")!=null)
            {
                if(ProjectManager.get("paymentResponseStatTotalMessages").equalsIgnoreCase("")==false)
                {
                        totalMessages = Integer.valueOf(ProjectManager.get("paymentResponseStatTotalMessages")).intValue();						
                }
            }                                        
            if(totalMessages!=0)
            {
                for(int j = 0;j<totalMessages;j++)
                {
                    props.put("paymentResponseMsgDeclined" + String.valueOf(j + 1), replaceUIExpressions(theInputLocaleFile.get("paymentResponseMsgDeclined" + String.valueOf(j + 1))));  
                }
            }   
             // Additional Refund Policy Variables should be appended to the Designer  
             theLocaleFile.put("refundPolicyTitle", replaceUIExpressions(theInputLocaleFile.get("refundPolicyTitle")));      
             theLocaleFile.put("refundPolicy", replaceUIExpressions(theInputLocaleFile.get("refundPolicy")));             
             theLocaleFile.put("refundPolicyOKBtnText", replaceUIExpressions(theInputLocaleFile.get("refundPolicyOKBtnText")));  
             theLocaleFile.put("refundPolicyOKBtnMnemonic", replaceUIExpressions(theInputLocaleFile.get("refundPolicyOKBtnMnemonic")));
             theLocaleFile.put("paymentSSLEnabledText", replaceUIExpressions(theInputLocaleFile.get("paymentSSLEnabledText")));   
             // Startup User Interface
             theLocaleFile.put("startWindowTitle", replaceUIExpressions(theInputLocaleFile.get("startWindowTitle")));
             theLocaleFile.put("btnBarUseEvalButtonText", replaceUIExpressions(theInputLocaleFile.get("btnBarUseEvalButtonText")));
             theLocaleFile.put("btnBarBuyNowButtonText", replaceUIExpressions(theInputLocaleFile.get("btnBarBuyNowButtonText")));
             theLocaleFile.put("btnBarRegButtonText", replaceUIExpressions(theInputLocaleFile.get("btnBarRegButtonText")));
             theLocaleFile.put("btnBarInfoButtonText", replaceUIExpressions(theInputLocaleFile.get("btnBarInfoButtonText")));
             theLocaleFile.put("btnBarExitButtonText", replaceUIExpressions(theInputLocaleFile.get("btnBarExitButtonText")));
             theLocaleFile.put("btnBarUseEvalButtonMnemonic", replaceUIExpressions(theInputLocaleFile.get("btnBarUseEvalButtonMnemonic")));
             theLocaleFile.put("btnBarBuyNowButtonMnemonic", replaceUIExpressions(theInputLocaleFile.get("btnBarBuyNowButtonMnemonic")));
             theLocaleFile.put("btnBarRegButtonMnemonic", replaceUIExpressions(theInputLocaleFile.get("btnBarRegButtonMnemonic")));
             theLocaleFile.put("btnBarInfoButtonMnemonic", replaceUIExpressions(theInputLocaleFile.get("btnBarInfoButtonMnemonic")));
             theLocaleFile.put("btnBarExitButtonMnemonic", replaceUIExpressions(theInputLocaleFile.get("btnBarExitButtonMnemonic")));
             theLocaleFile.put("imageMissingText", replaceUIExpressions(theInputLocaleFile.get("imageMissingText")));
             // common gui scrollbar component variables
             if(urlExists(ProjectManager.get("splashImgPath"))==true)
             {
                theLocaleFile.put("splashImgPath", "/images/" + ProjectManager.get("splashImgPath").substring(ProjectManager.get("splashImgPath").lastIndexOf("/") + 1));                 
             }
             if(ProjectManager.get("btnBarImgBtnEnabled")!=null)
             {
                 if(ProjectManager.get("btnBarImgBtnEnabled").equalsIgnoreCase("true")==true)
                 {                 
                     if(urlExists(ProjectManager.get("btnBarImgPath"))==true)
                     {
                        theLocaleFile.put("btnBarImgPath", "/images/" + ProjectManager.get("btnBarImgPath").substring(ProjectManager.get("btnBarImgPath").lastIndexOf("/") + 1));                 
                     }             
                 }
             }
             if(ProjectManager.get("progressPanelImgEnabled")!=null)
             {
                 if(ProjectManager.get("progressPanelImgEnabled").equalsIgnoreCase("true")==true)
                 {  
                     if(urlExists(ProjectManager.get("progressPanelImgPath"))==true)
                     {
                        theLocaleFile.put("progressPanelImgPath", "/images/" + ProjectManager.get("progressPanelImgPath").substring(ProjectManager.get("progressPanelImgPath").lastIndexOf("/") + 1));                 
                     }                      
                 }
             }
             //else if(jarResourceExists(ProjectManager.get("splashImgPath"))==true)
             //{
             //   theLocaleFile.put("splashImgPath", "/images/" + ProjectManager.get("splashImgPath").substring(ProjectManager.get("splashImgPath").lastIndexOf("/") + 1));                 
             //}
             //theLocaleFile.put("btnBarImgPath", replaceUIExpressions(theInputLocaleFile.get("btnBarImgPath"))); 
             //theLocaleFile.put("progressPanelImgPath", replaceUIExpressions(theInputLocaleFile.get("progressPanelImgPath")));
             theLocaleFile.put("progressBarDaysLeftText", replaceUIExpressions(theInputLocaleFile.get("progressBarDaysLeftText")));
             theLocaleFile.put("progressBarExpiredText", replaceUIExpressions(theInputLocaleFile.get("progressBarExpiredText")));
             // Information Dialog
             theLocaleFile.put("informationOKBtnText", replaceUIExpressions(theInputLocaleFile.get("informationOKBtnText")));  
             theLocaleFile.put("informationOKBtnMnemonic", replaceUIExpressions(theInputLocaleFile.get("informationOKBtnMnemonic")));
             theLocaleFile.put("informationText", replaceUIExpressions(theInputLocaleFile.get("informationText")));
             theLocaleFile.put("informationTextTitle", replaceUIExpressions(theInputLocaleFile.get("informationTextTitle")));
             theLocaleFile.put("paymentCancelButtonMnemonic", replaceUIExpressions(theInputLocaleFile.get("paymentCancelButtonMnemonic")));
             theLocaleFile.put("paymentContinueButtonMnemonic", replaceUIExpressions(theInputLocaleFile.get("paymentContinueButtonMnemonic")));
             theLocaleFile.put("optinPrivacyPolicyMnemonic", replaceUIExpressions(theInputLocaleFile.get("optinPrivacyPolicyMnemonic")));      
             //theLocaleFile.put("paymentRespSuccessBackgroundImagePath", replaceUIExpressions(theInputLocaleFile.get("paymentRespSuccessBackgroundImagePath")));
             //theLocaleFile.put("paymentRespFailureBackgroundImagePath", replaceUIExpressions(theInputLocaleFile.get("paymentRespFailureBackgroundImagePath")));
             if(urlExists(theInputLocaleFile.get("paymentRespSuccessBackgroundImagePath"))==true)
             {
                 theLocaleFile.put("paymentRespSuccessBackgroundImagePath", "/images/" + theInputLocaleFile.get("paymentRespSuccessBackgroundImagePath").substring(theInputLocaleFile.get("paymentRespSuccessBackgroundImagePath").lastIndexOf("/") + 1));                 
             }              
             if(urlExists(theInputLocaleFile.get("paymentRespFailureBackgroundImagePath"))==true)
             {
                 theLocaleFile.put("paymentRespFailureBackgroundImagePath", "/images/" + theInputLocaleFile.get("paymentRespFailureBackgroundImagePath").substring(theInputLocaleFile.get("paymentRespFailureBackgroundImagePath").lastIndexOf("/") + 1));                 
             } 
             theLocaleFile.put("paymentPhoneLabel", replaceUIExpressions(theInputLocaleFile.get("paymentPhoneLabel")));
             theLocaleFile.put("autoUpdateErrorMessage", replaceUIExpressions(theInputLocaleFile.get("autoUpdateErrorMessage")));                  
             theLocaleFile.put("autoUpdateNotAbleToComplete", replaceUIExpressions(theInputLocaleFile.get("autoUpdateNotAbleToComplete")));  
             theLocaleFile.put("errokbtn", replaceUIExpressions(theInputLocaleFile.get("errokbtn")));
             theLocaleFile.put("errokbtnmnem", replaceUIExpressions(theInputLocaleFile.get("errokbtnmnem")));
             theLocaleFile.put("autoUpdateErrorTitle", replaceUIExpressions(theInputLocaleFile.get("autoUpdateErrorTitle")));
             theLocaleFile.put("errMsgTitle", replaceUIExpressions(theInputLocaleFile.get("errMsgTitle")));
             theLocaleFile.put("infoMsgTitle", replaceUIExpressions(theInputLocaleFile.get("infoMsgTitle")));   
             theLocaleFile.put("msgMsgTitle", replaceUIExpressions(theInputLocaleFile.get("msgMsgTitle")));  
             theLocaleFile.put("evalLockdown", replaceUIExpressions(theInputLocaleFile.get("evalLockdown")));
             theLocaleFile.put("socketException", replaceUIExpressions(theInputLocaleFile.get("socketException")));
             theLocaleFile.put("unknownHostException", replaceUIExpressions(theInputLocaleFile.get("unknownHostException")));
             // Remove added variables that are not used. TODO: add logic to not add them in the first place, then they will not need to be removed.
                // The project setting for optin support is enabled/disabled
                if(ProjectManager.get("project_optin_is_enabled").equalsIgnoreCase("false")==true)
                {
                    // optin UI Strings
                    theLocaleFile.remove("optinYourNameLabel");
                    theLocaleFile.remove("optinYourEMailLabel");
                    theLocaleFile.remove("registerSoftwareTitle");
                    theLocaleFile.remove("optinDescription");
                    theLocaleFile.remove("optinCancelButtonText");
                    theLocaleFile.remove("optinContinueButtonText");                   
                    theLocaleFile.remove("optinCancelButtonMnemonic");
                    theLocaleFile.remove("optinContinueButtonMnemonic");    
                    theLocaleFile.remove("optinEnterNameMessage");
                    theLocaleFile.remove("optinEnterValidEMailMessage");    
                    theLocaleFile.remove("optinEnterEMailMessage");
                    
                    // optin privacy policy
                    theLocaleFile.remove("privacyPolicy");                    
                    theLocaleFile.remove("optinPrivacyPolicyLabel");
                    theLocaleFile.remove("privacyPolicyTitle");                    
                    theLocaleFile.remove("optinPrivacyPolicyMnemonic");                     
                    theLocaleFile.remove("privacyPolicyOKBtnText");
                    theLocaleFile.remove("privacyPolicyOKBtnMnemonic");
                }
                else
                { 
                    // optin ui string replacements here.
                    if(ProjectManager.get("optinPrivacyPolicyEnabled").equalsIgnoreCase("true")==false || ((String)props.get("privacyPolicyActionType")).equalsIgnoreCase("1")!=true)
                    {
                    	// optin privacy policy
                    	theLocaleFile.remove("privacyPolicy");                    
                    	theLocaleFile.remove("optinPrivacyPolicyLabel");
                   	theLocaleFile.remove("privacyPolicyTitle");                    
                    	theLocaleFile.remove("optinPrivacyPolicyMnemonic");                     
                    	theLocaleFile.remove("privacyPolicyOKBtnText");
                    	theLocaleFile.remove("privacyPolicyOKBtnMnemonic");
                    }
                }
                /* The project setting for registration code support is enabled */            
                if(ProjectManager.get("project_registration_code_support_is_enabled").equalsIgnoreCase("false")==true)
                {
                    // registration window user interface strings                
                    theLocaleFile.remove("registerSoftwareWindowTitle");
                    theLocaleFile.remove("registrationCodeLabel");
                    theLocaleFile.remove("registrationPaidLabel");
                    theLocaleFile.remove("registrationCodeLabelFontMnemonic");
                    theLocaleFile.remove("registrationCancelButtonText");
                    theLocaleFile.remove("registrationCancelButtonMnemonic");
                    theLocaleFile.remove("registrationFinishButtonText");
                    theLocaleFile.remove("registrationFinishButtonMnemonic");
                    //registration success window user interface strings
                    theLocaleFile.remove("registrationSuccessWindowTitle");
                    theLocaleFile.remove("registrationSuccessHeader");
                    theLocaleFile.remove("registrationSuccessDesc");
                    theLocaleFile.remove("registrationSuccessOK");
                    theLocaleFile.remove("registrationSuccessOKMnemonic");
                    //registration failed window user interface strings
                    theLocaleFile.remove("registrationFailedWindowTitle");
                    theLocaleFile.remove("registrationFailedMessage");
                    theLocaleFile.remove("registrationFailureOK");
                    theLocaleFile.remove("registrationFailureOKMnemonic");                   
                }
                /* The project setting for payment processing support is enabled */            
                if(ProjectManager.get("project_payment_processing_support_is_enabled").equalsIgnoreCase("false")==true)
                {
                     // payment user interface strings
                     theLocaleFile.remove("paymentWindowTitle");
                     theLocaleFile.remove("paymentStateLabel");
                     theLocaleFile.remove("paymentExpMMYYLabel");    
                     theLocaleFile.remove("paymentContinueButtonText");
                     theLocaleFile.remove("paymentCancelButtonText");
                     theLocaleFile.remove("paymentInstructionsLine1");
                     theLocaleFile.remove("paymentVerificationCodeLabel");
                     theLocaleFile.remove("paymentRefundPolicyLabel");
                     theLocaleFile.remove("paymentFirstNameDataFieldEmptyMessage");
                     theLocaleFile.remove("paymentLastNameDataFieldEmptyMessage");
                     theLocaleFile.remove("paymentValidEMailDataFieldEmptyMessage");
                     theLocaleFile.remove("paymentEMailDataFieldEmptyMessage");
                     theLocaleFile.remove("paymentStreetDataFieldEmptyMessage");
                     theLocaleFile.remove("paymentCityDataFieldEmptyMessage");
                     theLocaleFile.remove("paymentZipDataFieldEmptyMessage");
                     theLocaleFile.remove("paymentCCDataFieldEmptyMessage");
                     theLocaleFile.remove("paymentCCVerificationCodeFieldEmptyMessage");
                     theLocaleFile.remove("paymentPhoneDataFieldEmptyMessage");                    
                     theLocaleFile.remove("paymentFirstNameLabel");
                     theLocaleFile.remove("paymentLastNameLabel");
                     theLocaleFile.remove("paymentEMailLabel");
                     theLocaleFile.remove("paymentPhoneLabel");                     
                     theLocaleFile.remove("paymentStreetLabel");
                     theLocaleFile.remove("paymentCityLabel");
                     theLocaleFile.remove("paymentCountryLabel");
                     theLocaleFile.remove("paymentZipCodeLabel");
                     theLocaleFile.remove("paymentPaymentMethodLabel");
                     theLocaleFile.remove("paymentCCLabel");
                     theLocaleFile.remove("paymentOrdersOutsideUSLabel");
                     theLocaleFile.remove("refundPolicy");   
                     theLocaleFile.remove("refundPolicyTitle");
                     theLocaleFile.remove("refundPolicyOKBtnText");   
                     theLocaleFile.remove("refundPolicyOKBtnMnemonic");
                     theLocaleFile.remove("paymentSuccessFinishButtonMnemonic");
                     theLocaleFile.remove("paymentSuccessFinishButtonText");
                     // payment success user interface strings
                     theLocaleFile.remove("paymentSuccessResponsePanelTitle");
                     theLocaleFile.remove("paymentSuccessResponsePanelHeaderDescription");
                     theLocaleFile.remove("paymentSuccessResponsePanelOrderID");
                     theLocaleFile.remove("paymentSuccessResponsePanelNameOnCard");
                     theLocaleFile.remove("paymentSuccessResponsePanelEMailAddress");
                     theLocaleFile.remove("paymentSuccessResponsePanelAmountBilled");
                     theLocaleFile.remove("paymentSuccessResponsePanelMessage");
                     theLocaleFile.remove("paymentSucceededActionMessage");
                     // payment failed user interface strings
                     theLocaleFile.remove("paymentFailureResponsePanelTitle");
                     theLocaleFile.remove("paymentFailureResponsePanelHeaderDescription");
                     theLocaleFile.remove("paymentFailureResponsePanelOrderID");
                     theLocaleFile.remove("paymentFailureResponsePanelNameOnCard");
                     theLocaleFile.remove("paymentFailureResponsePanelEMailAddress");
                     theLocaleFile.remove("paymentFailureResponsePanelAmountBilled");
                     theLocaleFile.remove("paymentFailureResponsePanelMessage");
                     theLocaleFile.remove("paymentFailureRetryButtonText");                     
                     theLocaleFile.remove("paymentFailureRetryButtonMnemonic");   
                     theLocaleFile.remove("paymentFormLeftTopImagePath");                      
                     theLocaleFile.remove("paymentCancelButtonMnemonic");
                     theLocaleFile.remove("paymentContinueButtonMnemonic");
                     theLocaleFile.remove("paymentFormProductLabel"); 
                     theLocaleFile.remove("paymentPriceLabel"); 
                     theLocaleFile.remove("secondaryPaymentMethodButtonText"); 
                     theLocaleFile.remove("secondaryPaymentMethodButtonMnemonic");   
                     theLocaleFile.remove("paymentSSLEnabledText");      
                     theLocaleFile.remove("paymentGenericAuthResponseFailureMsg");  
                     theLocaleFile.remove("paymentGenericAuthResponseSuccessMsg");
                     // payment processing result variables to remove need some logic
                     totalMessages = 0;
                     if(ProjectManager.get("paymentResponseStatTotalMessages")!=null)
                     {
                            if(ProjectManager.get("paymentResponseStatTotalMessages").equalsIgnoreCase("")==false)
                            {
                                    totalMessages = Integer.valueOf(ProjectManager.get("paymentResponseStatTotalMessages")).intValue();						
                            }
                     }                                        
                     if(totalMessages!=0)
                     {
                        for(int j = 0;j<totalMessages;j++)
                        {
                             theLocaleFile.remove("paymentResponseMsgDeclined" + String.valueOf(j + 1));
                        }
                     }           
                     theLocaleFile.remove("paymentRespFailureBackgroundImagePath");
                     theLocaleFile.remove("paymentFormLeftTopImagePath");
                     theLocaleFile.remove("paymentFormRightTopImagePath"); 
                     theLocaleFile.remove("paymentFormInputBackgroundImagePath");
                     theLocaleFile.remove("paymentRespSuccessBackgroundImagePath");
                    // prjExpirationSupport = 0 if Support is Enabled, and 1 if not enabled.
                    int prjExpirationSupport = 0;
                    int prjOptinSupport = 0;        
                    int prjRegistrationSupport = 0;
                    int prjPaymentSupport = 0; 
                    int prjAutoUpdateSupport = 0;        
                    int prjMessagingSupport = 0;     
                    try
                    { 
                       if(ProjectManager.get("project_expiration_support_is_enabled").equalsIgnoreCase("true") == true)
                        {
                            prjExpirationSupport = 0;
                        }
                        else
                        {
                            prjExpirationSupport = 1;
                        }
                        if(ProjectManager.get("project_optin_is_enabled").equalsIgnoreCase("true") == true)
                        {
                            prjOptinSupport = 0;
                        }
                        else
                        {
                            prjOptinSupport = 1;
                        }            
                        if(ProjectManager.get("project_registration_code_support_is_enabled").equalsIgnoreCase("true") == true)
                        {
                            prjRegistrationSupport = 0;
                        }
                        else
                        {
                            prjRegistrationSupport = 1;
                        }   
                        if(ProjectManager.get("project_payment_processing_support_is_enabled").equalsIgnoreCase("true") == true)
                        {
                            prjPaymentSupport = 0;
                        }
                        else
                        {
                            prjPaymentSupport = 1;
                        }   
                        if(ProjectManager.get("project_auto_update_support_is_enabled").equalsIgnoreCase("true") == true)
                        {
                            prjAutoUpdateSupport = 0;
                        }
                        else
                        {
                            prjAutoUpdateSupport = 1;
                        }   
                        if(ProjectManager.get("project_messaging_support_is_enabled").equalsIgnoreCase("true") == true)
                        {
                            prjMessagingSupport = 0;
                        }
                        else
                        {
                            prjMessagingSupport = 1;
                        }
                       
                        if(prjAutoUpdateSupport == 1)
                        {
                            theLocaleFile.remove("autoUpdateErrorMessage");
                            theLocaleFile.remove("autoUpdateErrorTitle");
                            theLocaleFile.remove("autoUpdateNotAbleToComplete");
                        }
                            // startup window variables
                            try
                            {
                                if(prjPaymentSupport != 0 && prjRegistrationSupport != 0 && prjExpirationSupport != 0)
                                {                    
                                    if(ProjectManager.get("project_gui_model")!=null)
                                    {
                                        if(ProjectManager.get("project_gui_model").equalsIgnoreCase("0")==true)
                                        {                        
                                            theLocaleFile.remove("informationText");
                                            theLocaleFile.remove("informationTextTitle"); 
                                            theLocaleFile.remove("informationOKBtnMnemonic"); 
                                            theLocaleFile.remove("informationOKBtnText"); 
                                            theLocaleFile.remove("btnBarInfoButtonMnemonic");
                                            theLocaleFile.remove("btnBarInfoButtonText"); 
                                            theLocaleFile.remove("btnBarRegButtonText");
                                            theLocaleFile.remove("btnBarExitButtonMnemonic");
                                            theLocaleFile.remove("btnBarRegButtonMnemonic");
                                            theLocaleFile.remove("imageMissingText");
                                            theLocaleFile.remove("btnBarUseEvalButtonMnemonic");
                                            theLocaleFile.remove("btnBarBuyNowButtonText");
                                            theLocaleFile.remove("btnBarUseEvalButtonText");
                                            theLocaleFile.remove("btnBarImgPath");
                                            theLocaleFile.remove("progressBarExpiredText");
                                            theLocaleFile.remove("progressBarDaysLeftText");
                                            theLocaleFile.remove("progressPanelImgPath");
                                            theLocaleFile.remove("btnBarExitButtonText");
                                            theLocaleFile.remove("btnBarBuyNowButtonMnemonic");
                                            theLocaleFile.remove("startWindowTitle");
                                            theLocaleFile.remove("splashImgPath");
                                        }
                                    }
                                }
                            else
                            {
                                    if(ProjectManager.get("infoActionType").equalsIgnoreCase("1") == false)
                                    {
                                            theLocaleFile.remove("informationText");
                                            theLocaleFile.remove("informationTextTitle"); 
                                            theLocaleFile.remove("informationOKBtnMnemonic"); 
                                            theLocaleFile.remove("informationOKBtnText"); 
                                    }
                           } 
                            if(prjPaymentSupport != 0 && prjRegistrationSupport != 0 && prjExpirationSupport != 0 && prjMessagingSupport != 0 && prjAutoUpdateSupport != 0 && prjOptinSupport != 0)
                            {                    
                                theLocaleFile.remove("msgMsgTitle"); 
                                theLocaleFile.remove("infoMsgTitle");
                                theLocaleFile.remove("errMsgTitle");
                                theLocaleFile.remove("errokbtnmnem");
                                theLocaleFile.remove("errokbtn");
                                theLocaleFile.remove("socketException");
                                theLocaleFile.remove("unknownHostException");
                            }
                            if(prjExpirationSupport != 0)
                            {
                                theLocaleFile.remove("evalLockdown");
                            }
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                    catch(Exception e)
                    {
                            e.printStackTrace();
                    }                    
                }
                else 
                {
 
                }               
             // end of remove variables
             
             theLocaleFile.saveProject();
             return localeFile;
        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }        
        return null;
   }    
    
  /*  public int compile(File ProjectFile, File BuildOutputDir)
    {
        try 
        {
            EAProperties props;
            try
            {
                    DesignerRuleBuilder.readPropertiesFile();
                    DesignerRuleBuilder.setTempProject(ProjectFile.toURL().toString());
                    //EncryptedRuleBuilder.setFileName(BuildOutputDir.getAbsolutePath() + "/rules.eae");                    
            }
            catch(Exception e)
            {
                    e.printStackTrace();
                    return 1;
            }
            try
            {
			if(BuildOutputDir.exists()==false)
			{
                		if(BuildOutputDir.mkdirs()==false)
                		{
					return 8;
				}
			}
            }
            catch(Exception e)
            {
                    e.printStackTrace();
                    return 7;
            }
            try
            {
		setOpenFile(DesignerRuleBuilder.getTempProject());
            }
            catch(Exception e)
            {
                e.printStackTrace();
                return 5;
            }
            try
            {
                props = ProjectManager.getProjectProperties();
            }
            catch(Exception e)
            {
                e.printStackTrace();
                return 3;
            }
            try
            {
                updateUIExpressionDefines();
            }
            catch(Exception e)
            {
                return 6;
            }
            try
            {
                // project properties
                props.remove("product_vendor_name");
                props.remove("product_name");
                props.remove("product_version");     
                props.remove("product_info_url");
                props.remove("product_url");
                props.remove("product_privacy_policy_email");           
                props.remove("product_copyright");            
                props.remove("project_build_dir_name");
                props.remove("project_build_dir");
                props.remove("project_last_built");      
                 // The project setting for optin project is new. Used to Prompt launch Opt-In Wizard for new projects. 
                props.remove("project_optin_is_new");                
                // The project setting for payment processing project is new. Used to Prompt launch Payment Processing Wizard for new projects. 
                props.remove("project_payment_processing_is_new");  
           */     
// ********************* Platform Support **********************************
                // The project setting for Java platform support is enabled            
//                props.put("javaPlatformEnabled", ProjectManager.get("project_java_platform_support_is_enabled"));            
                /* The project setting for Mac OS X support is enabled */            
//                props.put("osxPlatformEnabled", ProjectManager.get("project_osx_platform_support_is_enabled")); 
                /* The project setting for Windows support is enabled */             
//                props.put("windowsPlatformEnabled", ProjectManager.get("project_windows_platform_support_is_enabled")); 
                /* The project setting for UNIX (All) support is enabled */             
 //               props.put("unixPlatformEnabled", ProjectManager.get("project_unix_platform_support_is_enabled")); 
                /* The project setting for Java platform support is enabled */            
 //               props.remove("project_java_platform_support_is_enabled");            
                /* The project setting for Mac OS X support is enabled */            
//                props.remove("project_osx_platform_support_is_enabled"); 
                /* The project setting for Windows support is enabled */             
//                props.remove("project_windows_platform_support_is_enabled"); 
                /* The project setting for UNIX (All) support is enabled */             
//                props.remove("project_unix_platform_support_is_enabled");     
// ********************* End Platform Support **********************************                
                
                /* The Evaluation Setting for the evaluation checkbox setting. Default should be if enabled set expireAction to notExpiredAction */
                //putTempNoFileWrite("evaluation_disable_expired_software_enabled", "true");  
                /* The project setting for expiration support is enabled */             
                //putTempNoFileWrite("project_expiration_support_is_enabled", "true");  


                // rules base evaluation properties
                //putTempNoFileWrite("applicationClass", "class.not.specified");  
                //putTempNoFileWrite("isRegistered", "false");
                //putTempNoFileWrite("registeredCode", "777" + "-" + String.valueOf(ProjectManager.getRandomInt(999999998)) + "-" + String.valueOf(ProjectManager.getRandomInt(999999999)));           
                //putTempNoFileWrite("regAttempts", "0");    
                //putTempNoFileWrite("maxRegisterAttempts", "20");  
                //putTempNoFileWrite("runtimeMillasecondsToExpire", "1296000000");
                //putTempNoFileWrite("runtimeMillasecondsStartTrial", "");
                //putTempNoFileWrite("allowInternalStartTrialInstanciation", "true");     
                //putTempNoFileWrite("expiredAction", "com.trinity.ea.actions.ExpiredAction");            
                //putTempNoFileWrite("notExpiredAction", "com.trinity.ea.actions.StartAction");
                //putTempNoFileWrite("useEvaluationAction", "com.trinity.ea.actions.OptinAction");

                // expiration rules functionality
                //putTempNoFileWrite("expirationIsEnabled", "true");  
                //putTempNoFileWrite("expirationModel", "timed");            

 // ********************* Optin Support **********************************               
                // optin rules functionality
                /* The project setting for optin support is enabled */
    /*            if(((String)props.get("project_optin_is_enabled")).equalsIgnoreCase("false")==true)
                {
                    props.remove("project_optin_is_enabled");
                    props.remove("optinIsOptedIn");
                    props.remove("optinEMail");
                    props.remove("optinName");
                    props.remove("optinPrivacyPolicyEnabled");
                    props.remove("optinInputFullName");
                    props.remove("optinInputEMailAddress");
                    props.remove("optinFormRequestMethod");
                    props.remove("optinInputHiddenNames");
                    props.remove("optinInputHiddenValues");
                    props.remove("optinFormActionURL");
                // optin actions
                    props.remove("optinCancelAction");
                    props.remove("optinContinueAction");
                    props.remove("showOptinUIAction");           
                    props.remove("privacyPolicyAction");

                // optin UI Strings
                    props.remove("privacyPolicy");
                    props.remove("optinYourNameLabel");
                    props.remove("optinYourEMailLabel");
                    props.remove("registerSoftwareTitle");
                    props.remove("optinPrivacyPolicyLabel");
                    props.remove("privacyPolicyTitle");
                    props.remove("optinDescription");
                   
                }
                else
                {
                    props.remove("project_optin_is_enabled");
                    // optin ui string replacements here.
                    props.put("privacyPolicy", replaceUIExpressions(ProjectManager.get("privacyPolicy")));
                    props.put("optinYourNameLabel", replaceUIExpressions(ProjectManager.get("optinYourNameLabel")));
                    props.put("optinYourEMailLabel", replaceUIExpressions(ProjectManager.get("optinYourEMailLabel")));
                    props.put("registerSoftwareTitle", replaceUIExpressions(ProjectManager.get("registerSoftwareTitle")));
                    props.put("optinPrivacyPolicyLabel", replaceUIExpressions(ProjectManager.get("optinPrivacyPolicyLabel")));
                    props.put("privacyPolicyTitle", replaceUIExpressions(ProjectManager.get("privacyPolicyTitle")));
                    props.put("optinDescription", replaceUIExpressions(ProjectManager.get("optinDescription")));
                }
*/
                // optin network property (is a general setting that applies to all Get Requests both Payments, and EMail. */
                //TODO: implement separate property for optin, and payment processing
                //putTempNoFileWrite("supportMetaRefreshEnabled", "true");
                //putTempNoFileWrite("respInputStatus", "Status");
                //END TODO
  // ********************* End Optin Support **********************************      
                
  // ********************* Registration Support **********************************                
                // registration rules functionality
               // putTempNoFileWrite("registrationCodeSupportEnabled", "true");  
                
                /* The project setting for registration code support is enabled */            
  /*
    if(((String)props.get("project_registration_code_support_is_enabled")).equalsIgnoreCase("false")==true)
                {
                    props.remove("project_registration_code_support_is_enabled");
                    // registration main window actions
                    props.remove("enterRegistrationCodeAction");
                    props.remove("registrationSuccessUIAction");
                    props.remove("registrationFailedUIAction");
                    // registration success window actions
                    props.remove("registrationSucceededAction");

                    //registration window user interface strings                
                    props.remove("registerSoftwareWindowTitle");
                    props.remove("registrationCodeLabel");
                    props.remove("registrationPaidLabel");
                    props.remove("registrationUnpaidHeaderLabel");
                    props.remove("registrationUnpaidLabel");
                    props.remove("registrationPaidHeaderLabel");
                    //registration success window user interface strings
                    props.remove("registrationSuccessWindowTitle");
                    props.remove("registrationSucceededMessage");
                    props.remove("registrationSucceededHeaderMessage");           
                    //registration failed window user interface strings
                    props.remove("registrationFailedWindowTitle");
                    props.remove("registrationFailedMessage");
                    props.remove("registrationFailedActionMessage");
                }
                else
                {
                     props.remove("project_registration_code_support_is_enabled");     
                     //registration window user interface strings                          
                     props.put("registerSoftwareWindowTitle", replaceUIExpressions(ProjectManager.get("registerSoftwareWindowTitle")));                   
                     props.put("registrationCodeLabel", replaceUIExpressions(ProjectManager.get("registrationCodeLabel")));  
                     props.put("registrationPaidLabel", replaceUIExpressions(ProjectManager.get("registrationPaidLabel")));
                     props.put("registrationUnpaidHeaderLabel", replaceUIExpressions(ProjectManager.get("registrationUnpaidHeaderLabel")));
                     props.put("registrationUnpaidLabel", replaceUIExpressions(ProjectManager.get("registrationUnpaidLabel")));
                     props.put("registrationPaidHeaderLabel", replaceUIExpressions(ProjectManager.get("registrationPaidHeaderLabel")));
                     props.put("registrationSuccessWindowTitle", replaceUIExpressions(ProjectManager.get("registrationSuccessWindowTitle")));
                     props.put("registrationSucceededMessage", replaceUIExpressions(ProjectManager.get("registrationSucceededMessage")));
                     props.put("registrationSucceededHeaderMessage", replaceUIExpressions(ProjectManager.get("registrationSucceededHeaderMessage")));
                     props.put("registrationFailedWindowTitle", replaceUIExpressions(ProjectManager.get("registrationFailedWindowTitle")));
                     props.put("registrationFailedMessage", replaceUIExpressions(ProjectManager.get("registrationFailedMessage")));
                }*/
// ********************* End Registration Support **********************************  
                 // payment processing rules functionality        
                 // putTempNoFileWrite("paymentProcessingSupportEnabled", "true");    
                
                /* The project setting for payment processing support is enabled */            
                /*if(((String)props.get("project_payment_processing_support_is_enabled")).equalsIgnoreCase("false")==true)
                {
                     props.remove("project_payment_processing_support_is_enabled");   
                     props.remove("refundPolicyEnabled");
                     // payment user interface strings
                     props.remove("paymentWindowTitle");
                     props.remove("paymentStateLabel");
                     props.remove("paymentExpMMYYLabel");    
                     props.remove("paymentContinueButtonText");
                     props.remove("paymentCancelButtonText");
                     props.remove("paymentInstructionsLine1");
                     props.remove("paymentVerificationCodeLabel");
                     props.remove("paymentRefundPolicyLabel");
                     props.remove("paymentFirstNameDataFieldEmptyMessage");
                     props.remove("paymentLastNameDataFieldEmptyMessage");
                     props.remove("paymentValidEMailDataFieldEmptyMessage");
                     props.remove("paymentEMailDataFieldEmptyMessage");
                     props.remove("paymentStreetDataFieldEmptyMessage");
                     props.remove("paymentCityDataFieldEmptyMessage");
                     props.remove("paymentZipDataFieldEmptyMessage");
                     props.remove("paymentCCDataFieldEmptyMessage");
                     props.remove("paymentCCVerificationCodeFieldEmptyMessage");
                     props.remove("paymentFirstNameLabel");
                     props.remove("paymentLastNameLabel");
                     props.remove("paymentEMailLabel");
                     props.remove("paymentStreetLabel");
                     props.remove("paymentCityLabel");
                     props.remove("paymentCountryLabel");
                     props.remove("paymentZipCodeLabel");
                     props.remove("paymentPaymentMethodLabel");
                     props.remove("paymentCCLabel");
                     props.remove("paymentOrdersOutsideUSLabel");
                     props.remove("refundPolicy");             
                     // payment success user interface strings
                     props.remove("paymentSuccessResponsePanelTitle");
                     props.remove("paymentSuccessResponsePanelHeaderDescription");
                     props.remove("paymentSuccessResponsePanelOrderID");
                     props.remove("paymentSuccessResponsePanelNameOnCard");
                     props.remove("paymentSuccessResponsePanelEMailAddress");
                     props.remove("paymentSuccessResponsePanelAmountBilled");
                     props.remove("paymentSuccessResponsePanelMessage");
                     props.remove("paymentSucceededActionMessage");
                     // payment failed user interface strings 
                     props.remove("paymentFailureResponsePanelTitle");
                     props.remove("paymentFailureResponsePanelHeaderDescription");
                     props.remove("paymentFailureResponsePanelOrderID");
                     props.remove("paymentFailureResponsePanelNameOnCard");
                     props.remove("paymentFailureResponsePanelEMailAddress");
                     props.remove("paymentFailureResponsePanelAmountBilled");
                     props.remove("paymentFailureResponsePanelMessage");
                     // payment actions
                     props.remove("refundPolicyAction");   
                     props.remove("buyNowAction");
                     props.remove("paymentReceiptFinishedAction");
                     props.remove("paymentReceiptFailedRetryAction");
                     props.remove("orderIDGeneratorAction");
                     props.remove("unknownHostExceptionAction");
                     props.remove("socketExceptionAction");
                     //payment html form input values
                     props.remove("inputNameFirstName");
                     props.remove("inputNameLastName");
                     props.remove("inputNameAddress");
                     props.remove("inputNameCity");
                     props.remove("inputNameState");
                     props.remove("inputNameZip");
                     props.remove("inputNameCountry");
                     props.remove("inputNameEMail");
                     props.remove("inputNamePaymentMethod");
                     props.remove("inputNameCC1");
                     props.remove("inputNameCC2");
                     props.remove("inputNameCC3");
                     props.remove("inputNameCC4");
                     props.remove("inputNameVerificationCode");
                     props.remove("inputNameExpirationMonth");
                     props.remove("inputNameExpirationYear");
                     props.remove("inputNameMerchant");
                     props.remove("inputNameOrderID");
                     props.remove("inputNameNameOnCard");
                     props.remove("inputNameResponseURL");
                     props.remove("inputNameTotal");
                     //payment response html form input values
                     props.remove("paymentInputHiddenNames");
                     props.remove("paymentInputHiddenValues");
                     props.remove("respInputAuthResponse");
                     props.remove("respInputEmail");
                     props.remove("respInputTotal");
                     props.remove("respInputOrderID");
                     props.remove("respInputNameonCard");
                     props.remove("respInputCardStreet");
                     props.remove("respInputCardCity");
                     props.remove("respInputCardState");
                     props.remove("respInputCardZip");
                     props.remove("respInputCardCountry");
                     props.remove("respInputCardnumber");
                     props.remove("respInputCardName");
                     props.remove("formActionURL");
                     props.remove("formRequestMethod");
                     //payment processing product configuration
                     props.remove("product_price");
                     props.remove("paymentMethods");
                     props.remove("paymentAttempts");
                     props.remove("maxPaymentAttempts");
                     props.remove("paymentCCVerificationCodeEnabled");            
                     props.remove("merchantValue");
                     props.remove("paymentCCVerificationCodeEnabled");
                     props.remove("responseURLValue");
                     props.remove("orderIDLeadingID");
                     props.remove("secondaryPaymentMethod");
                     props.remove("secondaryPaymentMethodEnabled");                     
                }
                else
                {
                     props.remove("project_payment_processing_support_is_enabled");   
                    // payment user interface strings
                    props.put("paymentWindowTitle", replaceUIExpressions(ProjectManager.get("paymentWindowTitle")));                   
                    props.put("paymentStateLabel", replaceUIExpressions(ProjectManager.get("paymentStateLabel")));                   
                    props.put("paymentExpMMYYLabel", replaceUIExpressions(ProjectManager.get("paymentExpMMYYLabel")));                   
                    props.put("paymentContinueButtonText", replaceUIExpressions(ProjectManager.get("paymentContinueButtonText")));                   
                    props.put("paymentCancelButtonText", replaceUIExpressions(ProjectManager.get("paymentCancelButtonText")));                   
                    props.put("paymentInstructionsLine1", replaceUIExpressions(ProjectManager.get("paymentInstructionsLine1")));                   
                    props.put("paymentVerificationCodeLabel", replaceUIExpressions(ProjectManager.get("paymentVerificationCodeLabel")));                   
                    props.put("paymentRefundPolicyLabel", replaceUIExpressions(ProjectManager.get("paymentRefundPolicyLabel")));                   
                    props.put("paymentFirstNameDataFieldEmptyMessage", replaceUIExpressions(ProjectManager.get("paymentFirstNameDataFieldEmptyMessage")));                   
                    props.put("paymentLastNameDataFieldEmptyMessage", replaceUIExpressions(ProjectManager.get("paymentLastNameDataFieldEmptyMessage")));                   
                    props.put("paymentValidEMailDataFieldEmptyMessage", replaceUIExpressions(ProjectManager.get("paymentValidEMailDataFieldEmptyMessage")));                   
                    props.put("paymentEMailDataFieldEmptyMessage", replaceUIExpressions(ProjectManager.get("paymentEMailDataFieldEmptyMessage")));                   
                    props.put("paymentStreetDataFieldEmptyMessage", replaceUIExpressions(ProjectManager.get("paymentStreetDataFieldEmptyMessage")));                   
                    props.put("paymentCityDataFieldEmptyMessage", replaceUIExpressions(ProjectManager.get("paymentCityDataFieldEmptyMessage")));                   
 
                    props.put("paymentZipDataFieldEmptyMessage", replaceUIExpressions(ProjectManager.get("paymentZipDataFieldEmptyMessage")));                     
                    props.put("paymentCCDataFieldEmptyMessage", replaceUIExpressions(ProjectManager.get("paymentCCDataFieldEmptyMessage"))); 
                    props.put("paymentCCVerificationCodeFieldEmptyMessage", replaceUIExpressions(ProjectManager.get("paymentCCVerificationCodeFieldEmptyMessage")));                     
                    props.put("paymentFirstNameLabel", replaceUIExpressions(ProjectManager.get("paymentFirstNameLabel"))); 
                    props.put("paymentLastNameLabel", replaceUIExpressions(ProjectManager.get("paymentLastNameLabel")));                     
                    props.put("paymentEMailLabel", replaceUIExpressions(ProjectManager.get("paymentEMailLabel"))); 
                    props.put("paymentStreetLabel", replaceUIExpressions(ProjectManager.get("paymentStreetLabel")));                     
                    props.put("paymentCityLabel", replaceUIExpressions(ProjectManager.get("paymentCityLabel"))); 
                    props.put("paymentCountryLabel", replaceUIExpressions(ProjectManager.get("paymentCountryLabel")));                     
                    props.put("paymentZipCodeLabel", replaceUIExpressions(ProjectManager.get("paymentZipCodeLabel"))); 
                    props.put("paymentPaymentMethodLabel", replaceUIExpressions(ProjectManager.get("paymentPaymentMethodLabel")));                     
                    props.put("paymentCCLabel", replaceUIExpressions(ProjectManager.get("paymentCCLabel"))); 
                    props.put("paymentOrdersOutsideUSLabel", replaceUIExpressions(ProjectManager.get("paymentOrdersOutsideUSLabel")));                     
                    props.put("refundPolicy", replaceUIExpressions(ProjectManager.get("refundPolicy"))); 
                    props.put("paymentSuccessResponsePanelTitle", replaceUIExpressions(ProjectManager.get("paymentSuccessResponsePanelTitle"))); 
                    props.put("paymentSuccessResponsePanelHeaderDescription", replaceUIExpressions(ProjectManager.get("paymentSuccessResponsePanelHeaderDescription"))); 
                    props.put("paymentSuccessResponsePanelOrderID", replaceUIExpressions(ProjectManager.get("paymentSuccessResponsePanelOrderID"))); 
                    props.put("paymentSuccessResponsePanelNameOnCard", replaceUIExpressions(ProjectManager.get("paymentSuccessResponsePanelNameOnCard"))); 
                    props.put("paymentSuccessResponsePanelEMailAddress", replaceUIExpressions(ProjectManager.get("paymentSuccessResponsePanelEMailAddress"))); 
                    props.put("paymentSuccessResponsePanelAmountBilled", replaceUIExpressions(ProjectManager.get("paymentSuccessResponsePanelAmountBilled"))); 
                    props.put("paymentSuccessResponsePanelMessage", replaceUIExpressions(ProjectManager.get("paymentSuccessResponsePanelMessage"))); 
                    props.put("paymentSucceededActionMessage", replaceUIExpressions(ProjectManager.get("paymentSucceededActionMessage"))); 
                    props.put("paymentFailureResponsePanelTitle", replaceUIExpressions(ProjectManager.get("paymentFailureResponsePanelTitle"))); 
                    props.put("paymentFailureResponsePanelHeaderDescription", replaceUIExpressions(ProjectManager.get("paymentFailureResponsePanelHeaderDescription"))); 
                    props.put("paymentFailureResponsePanelOrderID", replaceUIExpressions(ProjectManager.get("paymentFailureResponsePanelOrderID"))); 
                    props.put("paymentFailureResponsePanelNameOnCard", replaceUIExpressions(ProjectManager.get("paymentFailureResponsePanelNameOnCard"))); 
                    props.put("paymentFailureResponsePanelEMailAddress", replaceUIExpressions(ProjectManager.get("paymentFailureResponsePanelEMailAddress"))); 
                    props.put("paymentFailureResponsePanelAmountBilled", replaceUIExpressions(ProjectManager.get("paymentFailureResponsePanelAmountBilled"))); 
                    props.put("paymentFailureResponsePanelMessage", replaceUIExpressions(ProjectManager.get("paymentFailureResponsePanelMessage"))); 
                }
                */
                 //putTempNoFileWrite("autoUpdateEnabled", "true");
                
                 /* The project setting for automatic update support is enabled */             
        /*         if(((String)props.get("project_auto_update_support_is_enabled")).equalsIgnoreCase("false")==true)
                 {
                     props.remove("project_auto_update_support_is_enabled"); 
                     props.remove("autoUpdatePwdSeed");
                     props.remove("autoUpdatePwdCount");
                     props.remove("autoUpdateShoeHandler");
                     props.remove("autoUpdateLoadCheckForUpdatesUIAction");
                     props.remove("autoUpdateLoadInstallUIAction");
                     props.remove("autoUpdateInstallAction");
                     props.remove("autoUpdateSkipAction");
                     props.remove("autoUpdateBaseURLChangesAllowed");
                     props.remove("autoUpdateBaseURL"); 
                     props.remove("autoUpdateUpdateInProgress");
                     props.remove("autoUpdateLastCheckedTimestamp");
                     props.remove("autoUpdateUpdateID");
                     props.remove("autoUpdateFileName");
                     props.remove("autoUpdateTempFileName");
                     props.remove("autoUpdateMaxBaseURLs");  
                     props.remove("autoUpdateAllowNotifyServerOnUpdateSuccess");
                     props.remove("autoUpdateAllowExecuteActions");    
                     props.remove("autoUpdateExpirationEnabled");   
                     props.remove("autoUpdateAllowSilent");  
                     props.remove("autoUpdateRootDir");
                     props.remove("autoUpdateRootDirSystemPropertyEnabled");
                     props.remove("/$ROOT_DIR/$");
                     props.remove("autoUpdateDownloadDir");
                     props.remove("autoUpdateDownloadDirSystemPropertyEnabled");
                     props.remove("/$DOWNLOAD_DIR/$");
                     props.remove("autoUpdateWorkDir");
                     props.remove("autoUpdateWorkDirSystemPropertyEnabled");
                     props.remove("/$WORK_DIR/$");
                     props.remove("autoUpdateMillasecondsToExpire");  
                     props.remove("/$USER_HOME_DIR/$");
                 }
                 else
                 {
                     props.remove("project_auto_update_support_is_enabled");                      
                     
                 }
          */       
                //putTempNoFileWrite("msgEnabled","true"); 
                 /* The project setting for messaging support is enabled */             
            /*     if(((String)props.get("project_messaging_support_is_enabled")).equalsIgnoreCase("false")==true)
                 {                
                     props.remove("project_messaging_support_is_enabled");  
                     props.remove("msgBaseURLChangesAllowed");            
                     props.remove("msgPwdCount");
                     props.remove("msgPwdSeed");
                     props.remove("msgShoeHandler");
                     props.remove("msgUpdateID");
                     props.remove("msgDisplayMessageUIAction");
                     props.remove("msgCustomMessageUIAction");
                     props.remove("msgFinishedUIAction"); 
                     props.remove("msgLastCheckedTimestamp");
                     props.remove("msgBaseURL");
                     props.remove("msgMaxBaseURLs");
                     props.remove("msgAllowExecuteActionsOnCustomMessages");
                     props.remove("msgAllowNotifyServerOnMessageReceivedStatus");                     
                 }
                 else
                 {
                      props.remove("project_messaging_support_is_enabled");  
                       
                 }
            }
            catch(Exception e)
            {
                e.printStackTrace();
		    
                return 2;
            }
            try
            {
                EncryptedRuleBuilder.encryptAndWriteRulesFile(new File(new URL(BuildOutputDir.toURL().toString() + "/rules.eae").getFile()), props);
		     
                return 0;
            }
            catch(Exception e)
            {
                e.printStackTrace();
		    
                return 4;
            }             
             
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
	  
        return -1;
    }
    */
    
/** Open an existing EvaluateAnywhere project - UI component loads project with no GUI. */
private void setOpenFile(String strFile)
{
    try  	
    {

        try
        {
            File selFile = new File(new URL(strFile).getFile());
            if(selFile.exists()==false)
            {
                //setNewProject(strFile);
                System.out.println("File " + strFile + " does not exist. Please specify a file project file that exists. Compile Failed.");
            }
        }
        catch(NullPointerException e)
        {
            //leave empty for cancel action on file dialogs.
        }       
        catch(MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch(SecurityException e)
        {
              e.printStackTrace();          
        }     
        catch(Exception e)
        {
            e.printStackTrace();
        }        
  	if(DesignerRuleBuilder.getTempProject()!=null)
	{
		try
		{	
			try
			{
				File tmpFile = new File(new URL(DesignerRuleBuilder.getTempProject().substring(0,DesignerRuleBuilder.getTempProject().lastIndexOf("/"))).getFile()).createTempFile("Project","tmp",new File(new URL(DesignerRuleBuilder.getTempProject().substring(0, DesignerRuleBuilder.getTempProject().lastIndexOf("/")) + "/.eaproject.tmp/").getFile()));
				tmpFile.deleteOnExit();
                                try
                                {
                                        ProjectManager.initialize(tmpFile, DesignerRuleBuilder.getTempProject());
                                }
                                catch(Exception e)
                                {
                                        e.printStackTrace();
                                }                               
                        }
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	  }
     }
     catch(Exception e)
     {
         e.printStackTrace();
     }   
}    

    private File getTempLocaleFile()
    {
        try
        {
                if(DesignerRuleBuilder.get("prjDefaultCreateEnclosingFolder")!=null)
                {
                    if(DesignerRuleBuilder.get("prjDefaultCreateEnclosingFolder").equalsIgnoreCase("true")==true)
                    {
                        try
                        {
                            String theTempFile = DesignerRuleBuilder.getTempProject();
                            String theTempFileDir = DesignerRuleBuilder.getProjectFileName(theTempFile);
                            File theDirect2 = new File(new URL(theTempFile.substring(0,theTempFile.lastIndexOf("/")) + "/.eaproject.tmp/").getFile());   
                            //File theDirect2 = new File(new URL(theTempFile.substring(0,theTempFile.lastIndexOf("/") + 1) + theTempFileDir.substring(0,theTempFileDir.lastIndexOf("."))).getFile()); 
                            if(theDirect2.exists()==false)
                              {
                                  if(theDirect2.mkdirs()==true)
                                  {
							try
							{
								File theEATempDir = new File(new URL(DesignerRuleBuilder.getTempProject().substring(0, DesignerRuleBuilder.getTempProject().lastIndexOf("/")) + "/.eaproject.tmp/").getFile());
								theEATempDir.mkdirs();
								File tmpFile = new File(new URL(DesignerRuleBuilder.getTempProject().substring(0,DesignerRuleBuilder.getTempProject().lastIndexOf("/"))).getFile()).createTempFile("Locale","tmp",new File(new URL(DesignerRuleBuilder.getTempProject().substring(0, DesignerRuleBuilder.getTempProject().lastIndexOf("/")) + "/.eaproject.tmp/").getFile()));
								tmpFile.deleteOnExit();
								return tmpFile;
                             			}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
                                  else
                                  {
                                      //System.out.println("Failed to create Designer Project Enclosed Directory.");
                                  }
                                  //System.out.println("Created Project Directory: " + isCreated);
                              }
					else
					{

						try
						{
							File theEATempDir = new File(new URL(theTempFile.substring(0, theTempFile.lastIndexOf("/")) + "/.eaproject.tmp/").getFile());
							theEATempDir.mkdirs();
							File tmpFile = new File(new URL(DesignerRuleBuilder.getTempProject().substring(0,DesignerRuleBuilder.getTempProject().lastIndexOf("/"))).getFile()).createTempFile("Locale","tmp",theEATempDir);
							tmpFile.deleteOnExit();
							return tmpFile;
                                  	}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
                        }
                        catch(SecurityException e)
                        {

                          e.printStackTrace();             
                        }
                        catch(Exception e) 
                        {
                            e.printStackTrace();
                        } 
                    }
                    else
                    {
                        try
                        {
                            String theTempFile = DesignerRuleBuilder.getTempProject();
                            String theTempFileDir = DesignerRuleBuilder.getProjectFileName(theTempFile);
                            File theDesignerFile = null; 
					try
					{
						File theEATempDir = new File(new URL(DesignerRuleBuilder.getTempProject().substring(0, DesignerRuleBuilder.getTempProject().lastIndexOf("/")) + "/.eaproject.tmp/").getFile());
						theEATempDir.mkdirs();
						File tmpFile = new File(new URL(DesignerRuleBuilder.getTempProject().substring(0,DesignerRuleBuilder.getTempProject().lastIndexOf("/"))).getFile()).createTempFile("Locale","tmp",new File(new URL(DesignerRuleBuilder.getTempProject().substring(0, DesignerRuleBuilder.getTempProject().lastIndexOf("/")) + "/.eaproject.tmp/").getFile()));
						tmpFile.deleteOnExit();
						return tmpFile;
                             	}
					catch(Exception e)
					{
						e.printStackTrace();
					}
                        }
                        catch(SecurityException e)
                        {

                          e.printStackTrace();             
                        }
                        catch(Exception e) 
                        {
                            e.printStackTrace();
                        } 
                    }
                }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    /** Remove locale variables from rules file. */
    private void removeRulesFileLocaleVariables()
    {
        try
        {
            // registration UI Variables
            props.remove("registerSoftwareWindowTitle");
            props.remove("registrationCodeLabel");
            props.remove("registrationPaidLabel");
            props.remove("registrationCodeLabelFontMnemonic");
            props.remove("registrationCancelButtonText");
            props.remove("registrationFinishButtonText");
            props.remove("registrationCancelButtonMnemonic");
            props.remove("registrationFinishButtonMnemonic");
            //registration failed window user interface strings
            props.remove("registrationFailedWindowTitle");
            props.remove("registrationFailedMessage");
            props.remove("registrationFailureOK");
            props.remove("registrationFailureOKMnemonic");
            //registration success window user interface strings
            props.remove("registrationSuccessWindowTitle");
            props.remove("registrationSuccessHeader");
            props.remove("registrationSuccessDesc");
            props.remove("registrationSuccessOK");
            props.remove("registrationSuccessOKMnemonic");
            // optin UI Strings
            props.remove("privacyPolicy");
            props.remove("optinYourNameLabel");
            props.remove("optinYourEMailLabel");
            props.remove("registerSoftwareTitle");
            props.remove("optinPrivacyPolicyLabel");
            props.remove("privacyPolicyTitle");
            props.remove("optinDescription");
// Additional Privacy Policy Variables should be appended to the Designer             
             props.remove("privacyPolicyOKBtnText");
             props.remove("privacyPolicyOKBtnMnemonic");
// Additional Opt-In Window Variables
             props.remove("optinCancelButtonText");
             props.remove("optinCancelButtonMnemonic");
             props.remove("optinContinueButtonText");
             props.remove("optinContinueButtonMnemonic");
// Additional Optin Strings
             props.remove("optinEnterNameMessage");
             props.remove("optinEnterValidEMailMessage");
             props.remove("optinEnterEMailMessage");
             // Additional Optin Processing Variables          
             props.remove("optinPrivacyPolicyMnemonic");
             // payment user interface strings
             props.remove("paymentWindowTitle");
             props.remove("paymentStateLabel");
             props.remove("paymentExpMMYYLabel");
             props.remove("paymentContinueButtonText");
             props.remove("paymentCancelButtonText");
             props.remove("paymentInstructionsLine1");
             props.remove("paymentVerificationCodeLabel");
             props.remove("paymentRefundPolicyLabel");
             props.remove("paymentFirstNameDataFieldEmptyMessage");
             props.remove("paymentLastNameDataFieldEmptyMessage");
             props.remove("paymentValidEMailDataFieldEmptyMessage");
             props.remove("paymentEMailDataFieldEmptyMessage");
             props.remove("paymentStreetDataFieldEmptyMessage");
             props.remove("paymentCityDataFieldEmptyMessage");
             props.remove("paymentZipDataFieldEmptyMessage");
             props.remove("paymentCCDataFieldEmptyMessage");
             props.remove("paymentCCVerificationCodeFieldEmptyMessage");
             props.remove("paymentPhoneDataFieldEmptyMessage");
             props.remove("paymentFirstNameLabel");
             props.remove("paymentLastNameLabel");
             props.remove("paymentEMailLabel");
             props.remove("paymentStreetLabel");
             props.remove("paymentCityLabel");
             props.remove("paymentCountryLabel");
             props.remove("paymentZipCodeLabel");
             props.remove("paymentPaymentMethodLabel");
             props.remove("paymentCCLabel");
             props.remove("paymentOrdersOutsideUSLabel");
             props.remove("paymentFormProductLabel");
             // payment success user interface strings
             props.remove("paymentSuccessResponsePanelTitle");
             props.remove("paymentSuccessResponsePanelHeaderDescription");
             props.remove("paymentSuccessResponsePanelOrderID");
             props.remove("paymentSuccessResponsePanelNameOnCard");
             props.remove("paymentSuccessResponsePanelEMailAddress");
             props.remove("paymentSuccessResponsePanelAmountBilled");
             props.remove("paymentSucceededActionMessage");
             // payment failed user interface strings
             props.remove("paymentFailureResponsePanelTitle");
             props.remove("paymentFailureResponsePanelHeaderDescription");
             props.remove("paymentFailureResponsePanelOrderID");
             props.remove("paymentFailureResponsePanelNameOnCard");
             props.remove("paymentFailureResponsePanelEMailAddress");
             props.remove("paymentFailureResponsePanelAmountBilled");
             props.remove("paymentFailureResponsePanelMessage");
             //payment processing updated or added later
             props.remove("paymentFailureRetryButtonText");
             props.remove("paymentFailureRetryButtonMnemonic");
             props.remove("paymentSuccessFinishButtonText");
             props.remove("paymentSuccessFinishButtonMnemonic");
             props.remove("paymentSuccessResponsePanelMessage");
             props.remove("paymentGenericAuthResponseSuccessMsg");
             props.remove("paymentGenericAuthResponseFailureMsg");
             // Additional Payment Processing variables
             props.remove("paymentFormLeftTopImagePath");
             props.remove("paymentFormRightTopImagePath");
             props.remove("paymentFormInputBackgroundImagePath");
             props.remove("paymentPriceLabel");
             props.remove("secondaryPaymentMethodButtonText");
             props.remove("secondaryPaymentMethodButtonMnemonic");
            int totalMessages = 0;
            if(ProjectManager.get("paymentResponseStatTotalMessages")!=null)
            {
                if(ProjectManager.get("paymentResponseStatTotalMessages").equalsIgnoreCase("")==false)
                {
                        totalMessages = Integer.valueOf(ProjectManager.get("paymentResponseStatTotalMessages")).intValue();						
                }
            }                                        
            if(totalMessages!=0)
            {
                for(int j = 0;j<totalMessages;j++)
                {
                    props.remove("paymentResponseMsgDeclined" + String.valueOf(j + 1)); 
                }
            }    
             // Additional Refund Policy Variables should be appended to the Designer  
             props.remove("refundPolicyTitle");
             props.remove("refundPolicy");
             props.remove("refundPolicyOKBtnText");
             props.remove("refundPolicyOKBtnMnemonic");
             props.remove("paymentSSLEnabledText");
             // Startup User Interface
             props.remove("startWindowTitle");
             props.remove("btnBarUseEvalButtonText");
             props.remove("btnBarBuyNowButtonText");
             props.remove("btnBarRegButtonText");
             props.remove("btnBarInfoButtonText");
             props.remove("btnBarExitButtonText");
             props.remove("btnBarUseEvalButtonMnemonic");
             props.remove("btnBarBuyNowButtonMnemonic");
             props.remove("btnBarRegButtonMnemonic");
             props.remove("btnBarInfoButtonMnemonic");
             props.remove("btnBarExitButtonMnemonic");
             props.remove("imageMissingText");
             // common gui scrollbar component variables
             props.remove("progressBarDaysLeftText");
             props.remove("progressBarExpiredText");
             // Information Dialog
             props.remove("informationOKBtnText");
             props.remove("informationOKBtnMnemonic");
             props.remove("informationText");
             props.remove("informationTextTitle"); 
             props.remove("paymentCancelButtonMnemonic");
             props.remove("paymentContinueButtonMnemonic");
             props.remove("optinPrivacyPolicyMnemonic");
             props.remove("paymentRespSuccessBackgroundImagePath");
             props.remove("paymentRespFailureBackgroundImagePath");
             props.remove("paymentPhoneLabel");
             props.remove("autoUpdateErrorMessage");
             props.remove("autoUpdateNotAbleToComplete");
             props.remove("errokbtn");
             props.remove("errokbtnmnem");
             props.remove("autoUpdateErrorTitle");
             props.remove("errMsgTitle");
             props.remove("infoMsgTitle");
             props.remove("msgMsgTitle");
             props.remove("evalLockdown");
             props.remove("socketException");
             props.remove("unknownHostException");           
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private String replaceUIExpressions(String UIStringToReplaceExpressions)
    {
        try
        {
            for(int i = 0;i<updateUIExpressions.length;i++)
            {
			if(((String)updateUIExpressions[i]).equalsIgnoreCase("product_version")==false)
			{
                    UIStringToReplaceExpressions = UIStringToReplaceExpressions.replaceAll("(?i)" + (String)updateUIExpressions[i],ProjectManager.get((String)updateUIExpressions[i]));
			}
			else
			{
			  //put replace version string code here.
			  Object[] theVersionArray = getStringArraysFromString(ProjectManager.get((String)updateUIExpressions[i]));
			  int tempInt = 1;
			  String strVersionString = "";
  			  for(int a = 0;a<theVersionArray.length;a++)
			  {
				if(0<a)
				{
					try
					{
						if(Integer.parseInt((String)theVersionArray[a])!=0)
						{
							tempInt = a;
						}
					}
					catch(Exception e)
					{
						//The String likely was not a number and threw an exception
					}
				}
			  }
			  tempInt = tempInt + 1;
  			  for(int a = 0;a<tempInt;a++)
			  {
				if(a!=0)
				{
					strVersionString = strVersionString + "." + (String)theVersionArray[a];
				}
				else
				{
					strVersionString = (String)theVersionArray[a];
				}
			  }
                    UIStringToReplaceExpressions = UIStringToReplaceExpressions.replaceAll("(?i)" + (String)updateUIExpressions[i],strVersionString);
			}
            }
            return UIStringToReplaceExpressions;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    Object[] updateUIExpressions = new Object[9];
    private void updateUIExpressionDefines()
    {
        try
        {
            ArrayList theExpressionDefinesArrayList = new ArrayList();
            if(ProjectManager.get("product_vendor_name")!=null)
            {
                theExpressionDefinesArrayList.add("product_vendor_name");
            }
            if(ProjectManager.get("product_name")!=null)
            {
                theExpressionDefinesArrayList.add("product_name");
            }
            if(ProjectManager.get("product_version")!=null)
            {
                theExpressionDefinesArrayList.add("product_version");
            }
            if(ProjectManager.get("product_info_url")!=null)
            {
                theExpressionDefinesArrayList.add("product_info_url");
            }
            if(ProjectManager.get("product_url")!=null)
            {
                theExpressionDefinesArrayList.add("product_url");
            }
            if(ProjectManager.get("product_privacy_policy_email")!=null)
            {
                theExpressionDefinesArrayList.add("product_privacy_policy_email");
            }
            if(ProjectManager.get("product_copyright")!=null)
            {
                theExpressionDefinesArrayList.add("product_copyright");
            }     
            if(ProjectManager.get("product_price")!=null)
            {
                theExpressionDefinesArrayList.add("product_price");
            }
            if(ProjectManager.get("product_purchase_support_email")!=null)
            {
                theExpressionDefinesArrayList.add("product_purchase_support_email");
            }
            theExpressionDefinesArrayList.trimToSize();
            updateUIExpressions = theExpressionDefinesArrayList.toArray();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    } 

    private Object[] getStringArraysFromString(String textArrayString)
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
    
    private byte[] getFileByteArray(File theFile)
    {
        try 
        {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream is = theFile.toURL().openStream();
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

    private byte[] getURLByteArray(URL theURL)
    {
        try 
        {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream is = theURL.openStream();
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
    
    private byte[] getJarFileEntryByteArray(String strJarEntry)
    {
        try 
        {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream is = getClass().getResource(strJarEntry).openStream();
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

   private String getVerifyClasspath()
   {
        try
        { 
  		if(getJarIsInClasspath()==false)
		{
       	    if(ProjectManager.get("autoUpdateCP")!=null)
                {
                    if(ProjectManager.get("autoUpdateCP").equalsIgnoreCase("")==false)
                    {    
                        return ProjectManager.get("autoUpdateCP") + "," + ProjectManager.get("project_jarfile2_name");
                    }
                    else
                    {
                        return ProjectManager.get("project_jarfile2_name");
                    }
                }
                else
                {
                    return ProjectManager.get("project_jarfile2_name");
                }			
		}
        return ProjectManager.get("autoUpdateCP");                
        }
        catch(Exception e)
        {

            //e.printStackTrace();
        }
            return "";
   }


   private boolean getJarIsInClasspath()
   {
       try
        {   
           if(ProjectManager.get("autoUpdateCP")!=null)
           {
                if(ProjectManager.get("autoUpdateCP").equalsIgnoreCase("")==false)
                {    
                    Object[] tempArray = getStringArrayFromString(ProjectManager.get("autoUpdateCP"));
			  for(int i = 0;i<tempArray.length;i++)
			  {
				try
				{
					String currentJarStr = ProjectManager.get("project_jarfile2_name");
					if(currentJarStr.equalsIgnoreCase("")==false)
					{
						String tmpStr = (String)tempArray[i];
						if(tmpStr.indexOf(currentJarStr)!=-1)
						{
							return true;
						}
					}
				}
				catch(Exception e)
				{

				}
			  }
                }
            }
        }
        catch(Exception e)
        {
            //e.printStackTrace();
        }
	  return false;
    }

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
    
    /**
     * @param args the command line arguments
     */
 /*   public static void main(String[] args) 
    {
        try
        {
            new EACompiler().compile(new File(args[0]), new File(args[1]));
        }
        catch(Exception e)
        {
            System.out.println("EACompiler usage: java -classpath classes EACompiler ProjectFilePath OutputDirectory");
        }
    }
   */ 
}
