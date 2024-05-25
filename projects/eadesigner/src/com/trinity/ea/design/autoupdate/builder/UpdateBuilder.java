/*
 * UpdateBuilder.java
 *
 * Created on December 19, 2004, 7:50 PM
 */ 

package com.trinity.ea.design.autoupdate.builder;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Point;
import java.io.File;
import java.net.URL;
import java.net.MalformedURLException;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableColumn;
import javax.swing.JTable;
import com.trinity.ea.util.BrowserLauncher;
import com.trinity.ea.design.autoupdate.builder.AddFileDialog;
import com.trinity.ea.design.autoupdate.builder.EALFileFilter;
import com.trinity.ea.design.autoupdate.builder.LanguagePanel;
import com.trinity.ea.design.messaging.actions.MessageBuilderAction;
import com.trinity.ea.design.autoupdate.builder.BaseURLChangePanel;
import com.trinity.ea.design.AboutBoxDialog;
import com.trinity.ea.design.help.EAHelpViewer;
import com.trinity.ea.forms.data.RandomNumberGenerator;
import com.trinity.ea.design.common.fontchooser.FontChooser;
import com.trinity.ea.design.autoupdate.actions.UpdateDesignerPreviewAction;
import com.trinity.ea.autoupdate.builder.EncryptedUpdateBuilder;
import com.trinity.ea.util.EAProperties;
import com.trinity.ea.design.common.project.DefaultBuildDirectoryDialog;
import com.trinity.ea.design.common.filechooser.EAXFileView;
import com.trinity.ea.design.autoupdate.builder.AdvancedUpdateBuilderConfigurationDialog;
import com.trinity.ea.design.rules.builder.DesignerRuleBuilder;
import com.trinity.ea.design.common.doc.UpdateDocBuilder;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.autoupdate.builder.EncryptedUpdateBuilder;
import com.trinity.ea.design.common.util.ZipBuilder;
import com.trinity.ea.design.common.util.ManifestBuilder;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.InsetsUIResource;
import javax.swing.plaf.BorderUIResource;
import java.awt.Color;
import com.trinity.ea.design.common.colorchooser.JLocalColorChooser;
import javax.swing.table.JTableHeader;

/** 
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004-2005 Trinity Software. All rights reserved.
 */
public class UpdateBuilder extends javax.swing.JFrame {
    private final String[] strLocales = {"aa","ab","af","am","ar","as","ay","az","ba","be","bg","bh","bi","bn","bo","br","ca","co","cs","cy","da","de","dz","el","en","eo","es","et","eu","fa","fi","fj","fo","fr","fy","ga","gd","gl","gn","gu","ha","hi","hr","hu","hy","ia","ie","ik","in","is","it","iw","ja","ji","jw","ka","kk","kl","km","kn","ko","ks","ku","ky","la","ln","lo","lt","lv","mg","mi","mk","ml","mn","mo","mr","ms","mt","my","na","ne","nl","no","oc","ne","nl","no","oc","om","or","pa","pl","ps","pt","qu","rm","rn","ro","ru","rw","sa","sd","sg","sh","si","sk","sl","sm","sn","so","sq","sr","ss","st","su","sv","sw","ta","te","tg","th","ti","tk","tl","tn","to","tr","ts","tt","tw","uk","ur","uz","vi","vo","wo","xh","yo","zh","zu"};
    private final String[] strLocalesNames = {"Afar","Abkhazian","Afrikaans","Amharic","Arabic","Assamese","Aymara","Azerbaijani","Bashkir","Byelorussian","Bulgarian","Bihari","Bislama","Bengali","Tibetan","Breton","Catalan","Corsican","Czech","Welsh","Danish","German","Bhutani","Greek","English","Esperanto","Spanish","Estonian","Basque","Persian","Finnish","Fiji","Faeroese","French","Frisian","Irish","Gaelic","Galician","Guarani","Gujarati","Hausa","Hindi","Croatian","Hungarian","Armenian","Interlingua","Interlingue","Inupiak","Indonesian","Icelandic","Italian","Hebrew","Japanese","Yiddish","Javanese","Georgian","Kazakh","Greenlandic","Cambodian","Kannada","Korean","Kashmiri","Kurdish","Kirghiz","Latin","Lingala","Laothian","Lithuanian","Latvian","Malagasy","Maori","Macedonian","Malayalam","Mongolian","Moldavian","Marathi","Malay","Maltese","Burmese","Nauru","Nepali","Dutch","Norwegian","Occitan","Nepali","Dutch","Norwegian","Occitan","Oromo","Oriya","Punjabi","Polish","Pashto","Portuguese","Quechua","Rhaeto-Romance","Kirundi","Romanian","Russian","Kinyarwanda","Sanskrit","Sindhi","Sangro","Serbo-Croatian","Singhalese","Slovak","Slovenian","Samoan","Shona","Somali","Albanian","Serbian","Siswati","Sesotho","Sudanese","Swedish","Swahili","Tamil","Tegulu","Tajik","Thai","Tigrinya","Turkmen","Tagalog","Setswana","Tonga","Turkish","Tsonga","Tatar","Twi","Ukrainian","Urdu","Uzbek","Vietnamese","Volapuk","Wolof","Xhosa","Yoruba","Chinese","Zulu"};
    private HashMap langAbbrevHashMap = null;
    private LanguagePanel[] theLangPanelArray = null;
    private BaseURLChangePanel baseURLChangePanel = null;
    private int msgBuildType = 0;
    private ActionListener helpListener = null;    
    private static String strMessageFileName = "update.eal";     
    private java.awt.Image TitleBarIcon = null;
    private String filename = File.separator+"tmp";
    private JFileChooser fc = new JFileChooser(new File(filename)); 
    private EAXFileView fileView = new EAXFileView();   
    private int pwdCount = -1;
    private int msgIDNumber = 0;    
    private String pwdSeed = ""; 
    private int msgType=0;
    private boolean baseurlchange=false;    
    private String msgtitle="Software Update";
    private String msgtext="Software updates were downloaded, and are ready to install. Click the OK button and automatically upgrade to the newest version of your software. Click the Skip button if you do not want to upgrade this program with the newest, most stable version available at this time.";
    private String msgsupport="Please contact a support representative. The Automatic Software Update cannot continue.";
    private String msgerror="Please contact a support representative. The Automatic Software Update cannot continue.";
    private String msgfont="Helvetica,0,13";
    private String msgbtnfont="Helvetica,0,11";
    private String msgfontclr="38,54,69";
    private String msgbtnfontclr="255,255,255";
    private String msgokbtn="OK";
    private char msgokbtnmnem='O';
    private int msgtextalgn=0;
    private String msgskipbtn="Skip";
    private char msgskipbtnmnem='S'; 
    // update specific vars
    private String silent = "false";
    private String lazyUpdate = "true";
    private String msgmaxattempts = "1";
    private String copyfilesto = "";
    private String files = "";
    private String overwriteexistingfiles = "";
    private Object[] copyToArray = new Object[0];
    private Object[] filesArray = new Object[0];
    private Object[] overwriteFilesArray = new Object[0];    
    
    // tabbed pane non-default UI values
    private UIManager uiM;
    private UIDefaults uid;
    
    /** Creates new form UpdateBuilder */
    public UpdateBuilder() 
    {
        uiM = new UIManager();
        uid = uiM.getDefaults();
        setDefaultProperties();
	  try
	  {
	  	TitleBarIcon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/lgpl/eaicon16.png"));
		setIconImage(TitleBarIcon);
	  }
	  catch(Exception e)
	  {
		e.printStackTrace();
	  }      
      try
      {
            helpListener = EAHelpViewer.getEAHelpViewer(this);
      }
      catch(Exception e)
      {}    
        initComponents();
        try
        {
            if(DesignerRuleBuilder.get("prjLocalesEnabled")!=null)
            {
                if(DesignerRuleBuilder.get("prjLocalesEnabled").equalsIgnoreCase("true")==true)
                {

                }
                else
                {
                     ConfigureLanguagesButton.setEnabled(false);    
                     rbOnlySelectedLanguages.setEnabled(false);
                     rbUseDefaultLocales.setEnabled(false);
                }
            }
            else
            {
                 ConfigureLanguagesButton.setEnabled(false);    
                 rbOnlySelectedLanguages.setEnabled(false);
                 rbUseDefaultLocales.setEnabled(false);
            }
        }
        catch(Exception e)
        {
             ConfigureLanguagesButton.setEnabled(false);
             rbOnlySelectedLanguages.setEnabled(false);
             rbUseDefaultLocales.setEnabled(false);
        }
        
        EvaluateAnywhereHelp.addActionListener(helpListener);        
        if(ProjectManager.get("msgBaseURLChangesAllowed")!=null)
        {
            if(ProjectManager.get("msgBaseURLChangesAllowed").equalsIgnoreCase("false")==true)
            {
                modifyURLMenuItem.setEnabled(false);
            }
        }
        setProjectData();
        setMessageGUI();
        btnViewDocumentation.setEnabled(false);
        setTitle("EvaluateAnywhere Automatic Software Update Designer");
    }
 
   public synchronized void getDataUpdate()
   {
        try
        {
	    // Message ID Build ID Number Update
            ProjectManager.saveSinglePut("project_lastUpdateIDNumber", String.valueOf(Integer.valueOf(ProjectManager.get("project_lastUpdateIDNumber")).intValue() + 1));
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
            msgIDNumber = Integer.valueOf(ProjectManager.get("project_lastUpdateIDNumber")).intValue();
            spinMessageID.setModel(new SpinnerNumberModel(new Integer(msgIDNumber),new Integer(0),new Integer(999999999),new Integer(1)));
            /////////////////
            if(msgType == 0)
            {
                rbShortMessage.setSelected(true);
                rbLongMessage.setSelected(false);
            }
            else
            {
                rbShortMessage.setSelected(false);
                rbLongMessage.setSelected(true);                
            }
  	// Bring up a color chooser 
        if(msgfontclr!=null)
        {
            if(msgfontclr.equalsIgnoreCase("")==false)
            {
                cbDefaultTextColor.setSelected(false);
            }
            else
            {
                cbDefaultTextColor.setSelected(false);
            }
        }
        else
        {
            cbDefaultTextColor.setSelected(false);
        }         
        try
        {
            if(msgfont!=null)
            {
                if(msgfont.equalsIgnoreCase("")==false)
                {
                    cbDefaultFont.setSelected(false);
                }
                else
                {
                    cbDefaultFont.setSelected(true);
                }
            }
            else
            {
                  cbDefaultFont.setSelected(true);           
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
             
            if(msgtextalgn==0)
            {
                LeftAlignButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
                CenterAlignButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
                RightAlignButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));            
            }            
            else if(msgtextalgn==1)
            {
                LeftAlignButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
                CenterAlignButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
                RightAlignButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));            
            }
             else if(msgtextalgn==2)
            {
                LeftAlignButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
                CenterAlignButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
                RightAlignButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));            
            }     
            tfBuildLocation1.setText(new File(new URL(ProjectManager.get("update_build_dir")).getFile()).getCanonicalPath());
            File tmpFileCheck = new File(new URL(DesignerRuleBuilder.getTempProject()).getFile());
            if(tmpFileCheck.exists()==true)
            {
         
            }
            else if(tmpFileCheck.exists()==false)
            {

            }      
            tfBuildLocation1.setCaretPosition(0);
            if(ProjectManager.get("project_default_update_langs")!=null)
            {
               if(ProjectManager.get("project_default_update_langs").equalsIgnoreCase("")==true)
               {            
                    rbUseDefaultLocales.setSelected(true);
                    rbOnlySelectedLanguages.setSelected(false);
                    rbUseDefaultLocales.setEnabled(false);
                    rbOnlySelectedLanguages.setEnabled(false);                    
               }
               else
               {
                    rbUseDefaultLocales.setEnabled(true);
                    rbOnlySelectedLanguages.setEnabled(true);                     
               }
            }
            else
            {
                rbUseDefaultLocales.setSelected(true);
                rbOnlySelectedLanguages.setSelected(false);  
                rbUseDefaultLocales.setEnabled(false);
                rbOnlySelectedLanguages.setEnabled(false);                  
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }      
   
    public synchronized void setDefaultProperties()
    {
        try
        {
            msgIDNumber = Integer.valueOf(ProjectManager.get("project_lastUpdateIDNumber")).intValue();
            if(ProjectManager.get("autoUpdatePwdSeed")!=null)
            {
                pwdSeed = ProjectManager.get("autoUpdatePwdSeed"); 
            }
            if(ProjectManager.get("autoUpdatePwdCount")!=null)
            {
                pwdCount = Integer.valueOf(ProjectManager.get("autoUpdatePwdCount")).intValue();
            }   
            if(ProjectManager.get("project_default_update_msgType")!=null)
            {
                msgType = Integer.valueOf(ProjectManager.get("project_default_update_msgType")).intValue();
            }
            if(ProjectManager.get("project_default_update_baseurlchange")!=null)
            {
                baseurlchange = Boolean.getBoolean(ProjectManager.get("project_default_update_baseurlchange"));
            }
            if(ProjectManager.get("project_default_update_msgtitle")!=null)
            {
                msgtitle = ProjectManager.get("project_default_update_msgtitle");
            }
            if(ProjectManager.get("project_default_update_msgtext")!=null)
            {
                msgtext = ProjectManager.get("project_default_update_msgtext");
            }
            if(ProjectManager.get("project_default_update_msgsupport")!=null)
            {
                msgsupport = ProjectManager.get("project_default_update_msgsupport");
            }
            if(ProjectManager.get("project_default_update_msgerror")!=null)
            {
                msgerror = ProjectManager.get("project_default_update_msgerror");
            }           
            if(ProjectManager.get("project_default_update_msgfont")!=null)
            {
                msgfont = ProjectManager.get("project_default_update_msgfont");
            }
            if(ProjectManager.get("errbtnfont")!=null)
            {
                msgbtnfont = ProjectManager.get("errbtnfont");
            }
            if(ProjectManager.get("project_default_update_msgfontclr")!=null)
            {
                msgfontclr = ProjectManager.get("project_default_update_msgfontclr");
            }            
            if(ProjectManager.get("msgbtnfontclr")!=null)
            {
                msgbtnfontclr = ProjectManager.get("msgbtnfontclr");
            } 
            if(ProjectManager.get("project_default_update_msgokbtn")!=null)
            {
                msgokbtn = ProjectManager.get("project_default_update_msgokbtn");
            } 
            if(ProjectManager.get("project_default_update_msgokbtnmnem")!=null)
            {
                msgokbtnmnem = ProjectManager.get("project_default_update_msgokbtnmnem").charAt(0);
            } 
            if(ProjectManager.get("project_default_update_msgskipbtn")!=null)
            {
                msgskipbtn = ProjectManager.get("project_default_update_msgskipbtn");
            } 
            if(ProjectManager.get("project_default_update_msgskipbtnmnem")!=null)
            {
                msgskipbtnmnem = ProjectManager.get("project_default_update_msgskipbtnmnem").charAt(0);
            } 
            if(ProjectManager.get("project_default_update_msgtextalgn")!=null)
            {
                msgtextalgn = Integer.valueOf(ProjectManager.get("project_default_update_msgtextalgn")).intValue();
            } 
            if(ProjectManager.get("project_default_update_silent")!=null)
            {
                silent = ProjectManager.get("project_default_update_silent");
            }        
            if(ProjectManager.get("project_default_update_lazyUpdate")!=null)
            {
                lazyUpdate = ProjectManager.get("project_default_update_lazyUpdate");
            }                
            if(ProjectManager.get("project_default_update_msgmaxattempts")!=null)
            {
                msgmaxattempts = ProjectManager.get("project_default_update_msgmaxattempts");
            }       
            if(ProjectManager.get("project_default_update_copyfilesto")!=null)
            {
                copyfilesto = ProjectManager.get("project_default_update_copyfilesto");
                copyToArray = getStringArraysFromString(ProjectManager.get("project_default_update_copyfilesto"));
            }        
            if(ProjectManager.get("project_default_update_files")!=null)
            {
                files = ProjectManager.get("project_default_update_files");
                filesArray = getStringArraysFromString(ProjectManager.get("project_default_update_files"));
            }                
            if(ProjectManager.get("project_default_update_overwriteexistingfiles")!=null)
            {
                overwriteexistingfiles = ProjectManager.get("project_default_update_overwriteexistingfiles");
                overwriteFilesArray = getStringArraysFromString(ProjectManager.get("project_default_update_overwriteexistingfiles"));              
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
        SouthContentPanel1 = new javax.swing.JPanel();
        MessageURLPanel1 = new javax.swing.JPanel();
        cbMessageURLPanel1 = new javax.swing.JPanel();
        Separator39 = new javax.swing.JLabel();
        cbURLAddressBar1 = new javax.swing.JComboBox();
        lFiller28 = new javax.swing.JLabel();
        MessageBuildLocation1 = new javax.swing.JPanel();
        MessageOutputTextFieldPanel2 = new javax.swing.JPanel();
        Separator40 = new javax.swing.JLabel();
        tfBuildLocation2 = new javax.swing.JTextField();
        lFiller29 = new javax.swing.JLabel();
        MessageOutputLabelPanel1 = new javax.swing.JPanel();
        Separator41 = new javax.swing.JLabel();
        Separator42 = new javax.swing.JLabel();
        MessageOutputTextFieldPanel3 = new javax.swing.JPanel();
        Separator43 = new javax.swing.JLabel();
        ChooseButton1 = new javax.swing.JButton();
        lFiller34 = new javax.swing.JLabel();
        DefaultButton1 = new javax.swing.JButton();
        lFiller35 = new javax.swing.JLabel();
        btnViewDocumentation1 = new javax.swing.JButton();
        lFiller36 = new javax.swing.JLabel();
        ButtonPanel1 = new javax.swing.JPanel();
        MessageIDPanel1 = new javax.swing.JPanel();
        MessageIDLabel1 = new javax.swing.JLabel();
        spinMessageID1 = new javax.swing.JSpinner();
        MessagePreviewPanel1 = new javax.swing.JPanel();
        MessagePreviewButton1 = new javax.swing.JButton();
        BuildMessageButton1 = new javax.swing.JButton();
        MessageBuilderToolbar = new javax.swing.JToolBar();
        LeftAlignButton = new javax.swing.JButton();
        CenterAlignButton = new javax.swing.JButton();
        RightAlignButton = new javax.swing.JButton();
        Separator19 = new javax.swing.JLabel();
        AdvancedConfigurationOptionsButton = new javax.swing.JButton();
        Separator1 = new javax.swing.JLabel();
        FontColorButton = new javax.swing.JButton();
        FontButton = new javax.swing.JButton();
        Separator20 = new javax.swing.JLabel();
        MessageTextColorPanel = new javax.swing.JPanel();
        cbDefaultTextColor = new javax.swing.JCheckBox();
        cbDefaultFont = new javax.swing.JCheckBox();
        RootPanel = new javax.swing.JPanel();
        MainContentPanel = new javax.swing.JPanel();
        ContentPanel = new javax.swing.JPanel();
        MessagePanel = new javax.swing.JPanel();
        tpLanguageTabs = new javax.swing.JTabbedPane();
        MessageDataPanel = new javax.swing.JPanel();
        MessageTitlePanel = new javax.swing.JPanel();
        Separator13 = new javax.swing.JLabel();
        MessageTitleLabelPanel = new javax.swing.JPanel();
        Separator3 = new javax.swing.JLabel();
        MessageTitleLabel = new javax.swing.JLabel();
        Separator2 = new javax.swing.JLabel();
        MessageTitleTextFieldPanel = new javax.swing.JPanel();
        Separator5 = new javax.swing.JLabel();
        tfMessageTitle = new javax.swing.JTextField();
        Separator4 = new javax.swing.JLabel();
        MessageBodyPanel = new javax.swing.JPanel();
        Separator12 = new javax.swing.JLabel();
        MessageBodyLabelPanel = new javax.swing.JPanel();
        Separator8 = new javax.swing.JLabel();
        MessageBodyLabel = new javax.swing.JLabel();
        Separator9 = new javax.swing.JLabel();
        MessageBodyTextAreaPanel = new javax.swing.JPanel();
        Separator10 = new javax.swing.JLabel();
        scrollPaneMessageBody = new javax.swing.JScrollPane();
        taMessageBody = new javax.swing.JTextArea();
        Separator11 = new javax.swing.JLabel();
        MessageTypePanel = new javax.swing.JPanel();
        MessageTitleLabelPanel1 = new javax.swing.JPanel();
        Separator6 = new javax.swing.JLabel();
        rbShortMessage = new javax.swing.JRadioButton();
        Separator7 = new javax.swing.JLabel();
        rbLongMessage = new javax.swing.JRadioButton();
        Separator14 = new javax.swing.JLabel();
        ConfigureLanguagesButton = new javax.swing.JButton();
        Separator21 = new javax.swing.JLabel();
        BorderSeparator = new javax.swing.JPanel();
        FillerLabel2 = new javax.swing.JLabel();
        BorderSeparator1 = new javax.swing.JPanel();
        FillerLabel3 = new javax.swing.JLabel();
        MessageDeliveryPanel = new javax.swing.JPanel();
        Separator22 = new javax.swing.JLabel();
        rbDefaultOptionPanel = new javax.swing.JPanel();
        rbUseDefaultLocales = new javax.swing.JRadioButton();
        SpacerPanel2 = new javax.swing.JPanel();
        taUseDefaultLocale = new javax.swing.JTextArea();
        FillerLabel1 = new javax.swing.JLabel();
        rbOnlySelectedLanguagesPanel = new javax.swing.JPanel();
        rbOnlySelectedLanguages = new javax.swing.JRadioButton();
        SpacerPanel = new javax.swing.JPanel();
        taOnlySelectedLanguages = new javax.swing.JTextArea();
        FillerLabel = new javax.swing.JLabel();
        MainEastContentPanel = new javax.swing.JPanel();
        EastContentPanel = new javax.swing.JPanel();
        ContentPanel1 = new javax.swing.JPanel();
        AutoUpdateFilesPanel = new javax.swing.JPanel();
        NorthPanel = new javax.swing.JPanel();
        Filller2 = new javax.swing.JLabel();
        HeaderTitleLabel = new javax.swing.JLabel();
        Filller1 = new javax.swing.JLabel();
        FilesContentPanel = new javax.swing.JPanel();
        TheFileListPanel = new javax.swing.JPanel();
        Filller3 = new javax.swing.JLabel();
        FileListScrollPane = new javax.swing.JScrollPane();
        FileList = new javax.swing.JTable();
        Filller4 = new javax.swing.JLabel();
        ButtonPanel2 = new javax.swing.JPanel();
        AddFileButtonPanel = new javax.swing.JPanel();
        Filler1 = new javax.swing.JLabel();
        AddFile = new javax.swing.JButton();
        RemoveFileButtonPanel = new javax.swing.JPanel();
        Filler2 = new javax.swing.JLabel();
        RemoveFile = new javax.swing.JButton();
        SouthNewProjectPanelTopPanel = new javax.swing.JPanel();
        HelpStatusLabel = new javax.swing.JTextArea();
        HorizontalRulePanel = new javax.swing.JPanel();
        SouthContentPanel = new javax.swing.JPanel();
        MessageURLPanel = new javax.swing.JPanel();
        cbMessageURLPanel = new javax.swing.JPanel();
        Separator23 = new javax.swing.JLabel();
        cbURLAddressBar = new javax.swing.JComboBox();
        lFiller27 = new javax.swing.JLabel();
        MessageBuildLocation = new javax.swing.JPanel();
        MessageOutputTextFieldPanel = new javax.swing.JPanel();
        Separator17 = new javax.swing.JLabel();
        tfBuildLocation1 = new javax.swing.JTextField();
        lFiller26 = new javax.swing.JLabel();
        MessageOutputLabelPanel = new javax.swing.JPanel();
        Separator15 = new javax.swing.JLabel();
        Separator16 = new javax.swing.JLabel();
        MessageOutputTextFieldPanel1 = new javax.swing.JPanel();
        Separator18 = new javax.swing.JLabel();
        ChooseButton = new javax.swing.JButton();
        lFiller31 = new javax.swing.JLabel();
        DefaultButton = new javax.swing.JButton();
        lFiller32 = new javax.swing.JLabel();
        btnViewDocumentation = new javax.swing.JButton();
        lFiller33 = new javax.swing.JLabel();
        ButtonPanel = new javax.swing.JPanel();
        MessageIDPanel = new javax.swing.JPanel();
        MessageIDLabel = new javax.swing.JLabel();
        spinMessageID = new javax.swing.JSpinner();
        MessagePreviewPanel = new javax.swing.JPanel();
        MessagePreviewButton = new javax.swing.JButton();
        BuildMessageButton = new javax.swing.JButton();
        MainSouthContentPanel = new javax.swing.JPanel();
        MessageDesignerMenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        newMenuItem = new javax.swing.JMenu();
        newMessageMenuItem = new javax.swing.JMenuItem();
        modifyURLMenuItem = new javax.swing.JMenuItem();
        saveDefaultsMenuItem = new javax.swing.JMenuItem();
        advancedPropertiesMenuItem = new javax.swing.JMenuItem();
        closeMenuItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JSeparator();
        exitMenuItem = new javax.swing.JMenuItem();
        DesignerMenu = new javax.swing.JMenu();
        ProjectDesignerMenuItem = new javax.swing.JMenuItem();
        MessageDesignerMenuItem = new javax.swing.JMenuItem();
        HelpMenu = new javax.swing.JMenu();
        AboutHelp = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        EvaluateAnywhereHelp = new javax.swing.JMenuItem();

        SouthContentPanel1.setLayout(new javax.swing.BoxLayout(SouthContentPanel1, javax.swing.BoxLayout.Y_AXIS));

        SouthContentPanel1.setMinimumSize(new java.awt.Dimension(600, 190));
        SouthContentPanel1.setPreferredSize(new java.awt.Dimension(800, 190));
        MessageURLPanel1.setLayout(new javax.swing.BoxLayout(MessageURLPanel1, javax.swing.BoxLayout.Y_AXIS));

        MessageURLPanel1.setBorder(new javax.swing.border.TitledBorder(null, "The Message File Download URL:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12)));
        MessageURLPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 55));
        MessageURLPanel1.setMinimumSize(new java.awt.Dimension(527, 55));
        MessageURLPanel1.setPreferredSize(new java.awt.Dimension(1232, 55));
        cbMessageURLPanel1.setLayout(new javax.swing.BoxLayout(cbMessageURLPanel1, javax.swing.BoxLayout.X_AXIS));

        Separator39.setMaximumSize(new java.awt.Dimension(10, 10));
        Separator39.setMinimumSize(new java.awt.Dimension(10, 10));
        Separator39.setPreferredSize(new java.awt.Dimension(10, 10));
        cbMessageURLPanel1.add(Separator39);

        cbURLAddressBar1.setEditable(true);
        cbURLAddressBar1.setFont(new java.awt.Font("Arial", 0, 12));
        cbURLAddressBar1.setMaximumSize(new java.awt.Dimension(32767, 21));
        cbURLAddressBar1.setMinimumSize(new java.awt.Dimension(300, 21));
        cbURLAddressBar1.setPreferredSize(new java.awt.Dimension(450, 21));
        cbMessageURLPanel1.add(cbURLAddressBar1);

        lFiller28.setBackground(new java.awt.Color(140, 160, 210));
        lFiller28.setText("   ");
        lFiller28.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller28.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller28.setPreferredSize(new java.awt.Dimension(10, 16));
        cbMessageURLPanel1.add(lFiller28);

        MessageURLPanel1.add(cbMessageURLPanel1);

        SouthContentPanel1.add(MessageURLPanel1);

        MessageBuildLocation1.setLayout(new javax.swing.BoxLayout(MessageBuildLocation1, javax.swing.BoxLayout.Y_AXIS));

        MessageBuildLocation1.setBorder(new javax.swing.border.TitledBorder(null, "Message Build Location", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12)));
        MessageBuildLocation1.setMaximumSize(new java.awt.Dimension(2147483647, 90));
        MessageBuildLocation1.setMinimumSize(new java.awt.Dimension(527, 90));
        MessageBuildLocation1.setPreferredSize(new java.awt.Dimension(1232, 90));
        MessageOutputTextFieldPanel2.setLayout(new javax.swing.BoxLayout(MessageOutputTextFieldPanel2, javax.swing.BoxLayout.X_AXIS));

        Separator40.setMaximumSize(new java.awt.Dimension(10, 10));
        Separator40.setMinimumSize(new java.awt.Dimension(10, 10));
        Separator40.setPreferredSize(new java.awt.Dimension(10, 10));
        MessageOutputTextFieldPanel2.add(Separator40);

        tfBuildLocation2.setBackground(javax.swing.UIManager.getDefaults().getColor("TextField.inactiveBackground"));
        tfBuildLocation2.setFont(new java.awt.Font("Arial", 0, 12));
        tfBuildLocation2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfBuildLocation2.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfBuildLocation2.setMinimumSize(new java.awt.Dimension(300, 20));
        tfBuildLocation2.setPreferredSize(new java.awt.Dimension(450, 20));
        MessageOutputTextFieldPanel2.add(tfBuildLocation2);

        lFiller29.setBackground(new java.awt.Color(140, 160, 210));
        lFiller29.setText("   ");
        lFiller29.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller29.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller29.setPreferredSize(new java.awt.Dimension(10, 16));
        MessageOutputTextFieldPanel2.add(lFiller29);

        MessageBuildLocation1.add(MessageOutputTextFieldPanel2);

        MessageOutputLabelPanel1.setLayout(new javax.swing.BoxLayout(MessageOutputLabelPanel1, javax.swing.BoxLayout.X_AXIS));

        Separator41.setMaximumSize(new java.awt.Dimension(10, 10));
        Separator41.setMinimumSize(new java.awt.Dimension(10, 10));
        Separator41.setPreferredSize(new java.awt.Dimension(10, 10));
        MessageOutputLabelPanel1.add(Separator41);

        Separator42.setMaximumSize(new java.awt.Dimension(10, 10));
        Separator42.setMinimumSize(new java.awt.Dimension(10, 10));
        Separator42.setPreferredSize(new java.awt.Dimension(10, 10));
        MessageOutputLabelPanel1.add(Separator42);

        MessageBuildLocation1.add(MessageOutputLabelPanel1);

        MessageOutputTextFieldPanel3.setLayout(new javax.swing.BoxLayout(MessageOutputTextFieldPanel3, javax.swing.BoxLayout.X_AXIS));

        Separator43.setMaximumSize(new java.awt.Dimension(10, 10));
        Separator43.setMinimumSize(new java.awt.Dimension(10, 10));
        Separator43.setPreferredSize(new java.awt.Dimension(10, 10));
        MessageOutputTextFieldPanel3.add(Separator43);

        ChooseButton1.setFont(new java.awt.Font("Arial", 0, 12));
        ChooseButton1.setMnemonic('C');
        ChooseButton1.setText("Choose...");
        MessageOutputTextFieldPanel3.add(ChooseButton1);

        lFiller34.setBackground(new java.awt.Color(140, 160, 210));
        lFiller34.setText("   ");
        lFiller34.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller34.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller34.setPreferredSize(new java.awt.Dimension(10, 16));
        MessageOutputTextFieldPanel3.add(lFiller34);

        DefaultButton1.setFont(new java.awt.Font("Arial", 0, 12));
        DefaultButton1.setMnemonic('D');
        DefaultButton1.setText("Default");
        MessageOutputTextFieldPanel3.add(DefaultButton1);

        lFiller35.setBackground(new java.awt.Color(140, 160, 210));
        lFiller35.setText("   ");
        lFiller35.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller35.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller35.setPreferredSize(new java.awt.Dimension(15, 16));
        MessageOutputTextFieldPanel3.add(lFiller35);

        btnViewDocumentation1.setFont(new java.awt.Font("Arial", 0, 12));
        btnViewDocumentation1.setMnemonic('V');
        btnViewDocumentation1.setText("View Implementation Instructions");
        MessageOutputTextFieldPanel3.add(btnViewDocumentation1);

        lFiller36.setBackground(new java.awt.Color(140, 160, 210));
        lFiller36.setText("   ");
        lFiller36.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller36.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller36.setPreferredSize(new java.awt.Dimension(10, 16));
        MessageOutputTextFieldPanel3.add(lFiller36);

        MessageBuildLocation1.add(MessageOutputTextFieldPanel3);

        SouthContentPanel1.add(MessageBuildLocation1);

        ButtonPanel1.setLayout(new javax.swing.BoxLayout(ButtonPanel1, javax.swing.BoxLayout.X_AXIS));

        ButtonPanel1.setMaximumSize(new java.awt.Dimension(32767, 45));
        ButtonPanel1.setMinimumSize(new java.awt.Dimension(0, 45));
        ButtonPanel1.setPreferredSize(new java.awt.Dimension(0, 45));
        MessageIDPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        MessageIDLabel1.setFont(new java.awt.Font("Arial", 0, 12));
        MessageIDLabel1.setText("Message ID Number:");
        MessageIDPanel1.add(MessageIDLabel1);

        spinMessageID1.setFont(new java.awt.Font("Arial", 0, 12));
        spinMessageID1.setMinimumSize(new java.awt.Dimension(50, 20));
        spinMessageID1.setPreferredSize(new java.awt.Dimension(50, 20));
        spinMessageID1.setEnabled(false);
        MessageIDPanel1.add(spinMessageID1);

        ButtonPanel1.add(MessageIDPanel1);

        MessagePreviewPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 10));

        MessagePreviewButton1.setFont(new java.awt.Font("Arial", 0, 12));
        MessagePreviewButton1.setMnemonic('P');
        MessagePreviewButton1.setText("Preview");
        MessagePreviewPanel1.add(MessagePreviewButton1);

        BuildMessageButton1.setFont(new java.awt.Font("Arial", 0, 12));
        BuildMessageButton1.setMnemonic('B');
        BuildMessageButton1.setText("Build Message");
        MessagePreviewPanel1.add(BuildMessageButton1);

        ButtonPanel1.add(MessagePreviewPanel1);

        SouthContentPanel1.add(ButtonPanel1);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        LeftAlignButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lgpl/stock_text_left.png")));
        LeftAlignButton.setToolTipText("Left Align Message");
        LeftAlignButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeftAlignButtonActionPerformed(evt);
            }
        });

        MessageBuilderToolbar.add(LeftAlignButton);

        CenterAlignButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        CenterAlignButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lgpl/stock_text_justify.png")));
        CenterAlignButton.setToolTipText("Center Align Message");
        CenterAlignButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CenterAlignButtonActionPerformed(evt);
            }
        });

        MessageBuilderToolbar.add(CenterAlignButton);

        RightAlignButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lgpl/stock_text_right.png")));
        RightAlignButton.setToolTipText("Right Align Message");
        RightAlignButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RightAlignButtonActionPerformed(evt);
            }
        });

        MessageBuilderToolbar.add(RightAlignButton);

        Separator19.setMaximumSize(new java.awt.Dimension(10, 10));
        Separator19.setMinimumSize(new java.awt.Dimension(10, 10));
        Separator19.setPreferredSize(new java.awt.Dimension(10, 10));
        MessageBuilderToolbar.add(Separator19);

        AdvancedConfigurationOptionsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lgpl/stock_form-control-properties.png")));
        AdvancedConfigurationOptionsButton.setToolTipText("Advanced Message Configuration Properties");
        AdvancedConfigurationOptionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdvancedConfigurationOptionsButtonActionPerformed(evt);
            }
        });

        MessageBuilderToolbar.add(AdvancedConfigurationOptionsButton);

        Separator1.setMaximumSize(new java.awt.Dimension(10, 10));
        Separator1.setMinimumSize(new java.awt.Dimension(10, 10));
        Separator1.setPreferredSize(new java.awt.Dimension(10, 10));
        MessageBuilderToolbar.add(Separator1);

        FontColorButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lgpl/stock_text_color_foreground.png")));
        FontColorButton.setToolTipText("Text Color");
        FontColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FontColorButtonActionPerformed(evt);
            }
        });

        MessageBuilderToolbar.add(FontColorButton);

        FontButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lgpl/stock_font.png")));
        FontButton.setToolTipText("Font");
        FontButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FontButtonActionPerformed(evt);
            }
        });

        MessageBuilderToolbar.add(FontButton);

        Separator20.setMaximumSize(new java.awt.Dimension(5, 10));
        Separator20.setMinimumSize(new java.awt.Dimension(5, 10));
        Separator20.setPreferredSize(new java.awt.Dimension(5, 10));
        MessageBuilderToolbar.add(Separator20);

        MessageTextColorPanel.setLayout(new javax.swing.BoxLayout(MessageTextColorPanel, javax.swing.BoxLayout.Y_AXIS));

        cbDefaultTextColor.setFont(new java.awt.Font("Arial", 0, 11));
        cbDefaultTextColor.setText("Use default text color");
        cbDefaultTextColor.setOpaque(false);
        cbDefaultTextColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDefaultTextColorActionPerformed(evt);
            }
        });

        MessageTextColorPanel.add(cbDefaultTextColor);

        cbDefaultFont.setFont(new java.awt.Font("Arial", 0, 11));
        cbDefaultFont.setText("Use default font");
        cbDefaultFont.setOpaque(false);
        cbDefaultFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDefaultFontActionPerformed(evt);
            }
        });

        MessageTextColorPanel.add(cbDefaultFont);

        MessageBuilderToolbar.add(MessageTextColorPanel);

        getContentPane().add(MessageBuilderToolbar, java.awt.BorderLayout.NORTH);

        RootPanel.setLayout(new java.awt.BorderLayout());

        RootPanel.setMinimumSize(new java.awt.Dimension(430, 350));
        MainContentPanel.setLayout(new java.awt.BorderLayout());

        MainContentPanel.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        MainContentPanel.setMinimumSize(new java.awt.Dimension(430, 350));
        MainContentPanel.setPreferredSize(new java.awt.Dimension(430, 500));
        ContentPanel.setLayout(new java.awt.BorderLayout());

        ContentPanel.setBorder(new javax.swing.border.TitledBorder(null, "Software Update Ready to Install Message", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12)));
        ContentPanel.setFont(new java.awt.Font("Arial", 0, 12));
        ContentPanel.setMaximumSize(new java.awt.Dimension(325, 137));
        ContentPanel.setMinimumSize(new java.awt.Dimension(325, 137));
        ContentPanel.setPreferredSize(new java.awt.Dimension(325, 137));
        ContentPanel.setRequestFocusEnabled(false);
        MessagePanel.setLayout(new javax.swing.BoxLayout(MessagePanel, javax.swing.BoxLayout.Y_AXIS));

        tpLanguageTabs.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tpLanguageTabs.setFont(new java.awt.Font("Arial", 0, 12));
        tpLanguageTabs.setMinimumSize(new java.awt.Dimension(109, 168));
        tpLanguageTabs.setPreferredSize(new java.awt.Dimension(1225, 168));
        MessageDataPanel.setLayout(new javax.swing.BoxLayout(MessageDataPanel, javax.swing.BoxLayout.Y_AXIS));

        MessageDataPanel.setFont(new java.awt.Font("Arial", 0, 12));
        MessageTitlePanel.setLayout(new javax.swing.BoxLayout(MessageTitlePanel, javax.swing.BoxLayout.Y_AXIS));

        Separator13.setMaximumSize(new java.awt.Dimension(10, 10));
        Separator13.setMinimumSize(new java.awt.Dimension(10, 10));
        Separator13.setPreferredSize(new java.awt.Dimension(10, 10));
        MessageTitlePanel.add(Separator13);

        MessageTitleLabelPanel.setLayout(new javax.swing.BoxLayout(MessageTitleLabelPanel, javax.swing.BoxLayout.X_AXIS));

        Separator3.setMaximumSize(new java.awt.Dimension(10, 10));
        Separator3.setMinimumSize(new java.awt.Dimension(10, 10));
        Separator3.setPreferredSize(new java.awt.Dimension(10, 10));
        MessageTitleLabelPanel.add(Separator3);

        MessageTitleLabel.setDisplayedMnemonic('T');
        MessageTitleLabel.setFont(new java.awt.Font("Arial", 0, 12));
        MessageTitleLabel.setLabelFor(tfMessageTitle);
        MessageTitleLabel.setText("Message Title:");
        MessageTitleLabel.setMaximumSize(new java.awt.Dimension(32767, 15));
        MessageTitleLabel.setPreferredSize(new java.awt.Dimension(1200, 15));
        MessageTitleLabelPanel.add(MessageTitleLabel);

        Separator2.setMaximumSize(new java.awt.Dimension(10, 10));
        Separator2.setMinimumSize(new java.awt.Dimension(10, 10));
        Separator2.setPreferredSize(new java.awt.Dimension(10, 10));
        MessageTitleLabelPanel.add(Separator2);

        MessageTitlePanel.add(MessageTitleLabelPanel);

        MessageTitleTextFieldPanel.setLayout(new javax.swing.BoxLayout(MessageTitleTextFieldPanel, javax.swing.BoxLayout.X_AXIS));

        Separator5.setMaximumSize(new java.awt.Dimension(10, 10));
        Separator5.setMinimumSize(new java.awt.Dimension(10, 10));
        Separator5.setPreferredSize(new java.awt.Dimension(10, 10));
        MessageTitleTextFieldPanel.add(Separator5);

        tfMessageTitle.setFont(new java.awt.Font("Arial", 0, 12));
        tfMessageTitle.setMaximumSize(new java.awt.Dimension(2147483647, 21));
        MessageTitleTextFieldPanel.add(tfMessageTitle);

        Separator4.setMaximumSize(new java.awt.Dimension(10, 10));
        Separator4.setMinimumSize(new java.awt.Dimension(10, 10));
        Separator4.setPreferredSize(new java.awt.Dimension(10, 10));
        MessageTitleTextFieldPanel.add(Separator4);

        MessageTitlePanel.add(MessageTitleTextFieldPanel);

        MessageDataPanel.add(MessageTitlePanel);

        MessageBodyPanel.setLayout(new javax.swing.BoxLayout(MessageBodyPanel, javax.swing.BoxLayout.Y_AXIS));

        Separator12.setMaximumSize(new java.awt.Dimension(10, 5));
        Separator12.setMinimumSize(new java.awt.Dimension(10, 5));
        Separator12.setPreferredSize(new java.awt.Dimension(10, 5));
        MessageBodyPanel.add(Separator12);

        MessageBodyLabelPanel.setLayout(new javax.swing.BoxLayout(MessageBodyLabelPanel, javax.swing.BoxLayout.X_AXIS));

        Separator8.setMaximumSize(new java.awt.Dimension(10, 10));
        Separator8.setMinimumSize(new java.awt.Dimension(10, 10));
        Separator8.setPreferredSize(new java.awt.Dimension(10, 10));
        MessageBodyLabelPanel.add(Separator8);

        MessageBodyLabel.setDisplayedMnemonic('o');
        MessageBodyLabel.setFont(new java.awt.Font("Arial", 0, 12));
        MessageBodyLabel.setLabelFor(taMessageBody);
        MessageBodyLabel.setText("Message Body:");
        MessageBodyLabel.setMaximumSize(new java.awt.Dimension(32767, 15));
        MessageBodyLabel.setPreferredSize(new java.awt.Dimension(1200, 15));
        MessageBodyLabelPanel.add(MessageBodyLabel);

        Separator9.setMaximumSize(new java.awt.Dimension(10, 10));
        Separator9.setMinimumSize(new java.awt.Dimension(10, 10));
        Separator9.setPreferredSize(new java.awt.Dimension(10, 10));
        MessageBodyLabelPanel.add(Separator9);

        MessageBodyPanel.add(MessageBodyLabelPanel);

        MessageBodyTextAreaPanel.setLayout(new javax.swing.BoxLayout(MessageBodyTextAreaPanel, javax.swing.BoxLayout.X_AXIS));

        Separator10.setMaximumSize(new java.awt.Dimension(10, 10));
        Separator10.setMinimumSize(new java.awt.Dimension(10, 10));
        Separator10.setPreferredSize(new java.awt.Dimension(10, 10));
        MessageBodyTextAreaPanel.add(Separator10);

        scrollPaneMessageBody.setMaximumSize(new java.awt.Dimension(32767, 69));
        scrollPaneMessageBody.setMinimumSize(new java.awt.Dimension(23, 69));
        scrollPaneMessageBody.setPreferredSize(new java.awt.Dimension(4, 69));
        taMessageBody.setFont(new java.awt.Font("Arial", 0, 12));
        taMessageBody.setLineWrap(true);
        taMessageBody.setWrapStyleWord(true);
        taMessageBody.setMinimumSize(new java.awt.Dimension(0, 0));
        taMessageBody.setPreferredSize(new java.awt.Dimension(0, 0));
        scrollPaneMessageBody.setViewportView(taMessageBody);

        MessageBodyTextAreaPanel.add(scrollPaneMessageBody);

        Separator11.setMaximumSize(new java.awt.Dimension(10, 10));
        Separator11.setMinimumSize(new java.awt.Dimension(10, 10));
        Separator11.setPreferredSize(new java.awt.Dimension(10, 10));
        MessageBodyTextAreaPanel.add(Separator11);

        MessageBodyPanel.add(MessageBodyTextAreaPanel);

        MessageDataPanel.add(MessageBodyPanel);

        tpLanguageTabs.addTab("English", MessageDataPanel);

        MessagePanel.add(tpLanguageTabs);

        MessageTypePanel.setLayout(new javax.swing.BoxLayout(MessageTypePanel, javax.swing.BoxLayout.Y_AXIS));

        MessageTypePanel.setMaximumSize(new java.awt.Dimension(33033, 43));
        MessageTypePanel.setMinimumSize(new java.awt.Dimension(276, 43));
        MessageTypePanel.setPreferredSize(new java.awt.Dimension(246, 43));
        MessageTitleLabelPanel1.setLayout(new javax.swing.BoxLayout(MessageTitleLabelPanel1, javax.swing.BoxLayout.X_AXIS));

        MessageTitleLabelPanel1.setMaximumSize(new java.awt.Dimension(33033, 43));
        MessageTitleLabelPanel1.setMinimumSize(new java.awt.Dimension(276, 43));
        MessageTitleLabelPanel1.setPreferredSize(new java.awt.Dimension(246, 43));
        Separator6.setMaximumSize(new java.awt.Dimension(10, 10));
        Separator6.setMinimumSize(new java.awt.Dimension(10, 10));
        Separator6.setPreferredSize(new java.awt.Dimension(10, 10));
        MessageTitleLabelPanel1.add(Separator6);

        rbShortMessage.setFont(new java.awt.Font("Arial", 0, 12));
        rbShortMessage.setMnemonic('h');
        rbShortMessage.setSelected(true);
        rbShortMessage.setText("Short Message");
        rbShortMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbShortMessageActionPerformed(evt);
            }
        });

        MessageTitleLabelPanel1.add(rbShortMessage);

        Separator7.setMaximumSize(new java.awt.Dimension(40, 10));
        Separator7.setMinimumSize(new java.awt.Dimension(40, 10));
        Separator7.setPreferredSize(new java.awt.Dimension(10, 10));
        MessageTitleLabelPanel1.add(Separator7);

        rbLongMessage.setFont(new java.awt.Font("Arial", 0, 12));
        rbLongMessage.setMnemonic('L');
        rbLongMessage.setText("Long Message");
        rbLongMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbLongMessageActionPerformed(evt);
            }
        });

        MessageTitleLabelPanel1.add(rbLongMessage);

        Separator14.setMaximumSize(new java.awt.Dimension(32767, 10));
        Separator14.setMinimumSize(new java.awt.Dimension(10, 10));
        Separator14.setPreferredSize(new java.awt.Dimension(10, 10));
        MessageTitleLabelPanel1.add(Separator14);

        ConfigureLanguagesButton.setFont(new java.awt.Font("Arial", 0, 12));
        ConfigureLanguagesButton.setMnemonic('o');
        ConfigureLanguagesButton.setText("Configure Languages");
        ConfigureLanguagesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfigureLanguagesButtonActionPerformed(evt);
            }
        });

        MessageTitleLabelPanel1.add(ConfigureLanguagesButton);

        Separator21.setMaximumSize(new java.awt.Dimension(40, 10));
        Separator21.setMinimumSize(new java.awt.Dimension(40, 10));
        Separator21.setPreferredSize(new java.awt.Dimension(10, 10));
        MessageTitleLabelPanel1.add(Separator21);

        MessageTypePanel.add(MessageTitleLabelPanel1);

        MessagePanel.add(MessageTypePanel);

        BorderSeparator.setLayout(new java.awt.BorderLayout());

        BorderSeparator.setMaximumSize(new java.awt.Dimension(32767, 2));
        BorderSeparator.setMinimumSize(new java.awt.Dimension(10, 2));
        BorderSeparator.setPreferredSize(new java.awt.Dimension(10, 2));
        FillerLabel2.setMaximumSize(new java.awt.Dimension(10, 2));
        FillerLabel2.setMinimumSize(new java.awt.Dimension(10, 2));
        FillerLabel2.setPreferredSize(new java.awt.Dimension(10, 2));
        BorderSeparator.add(FillerLabel2, java.awt.BorderLayout.WEST);

        BorderSeparator1.setBorder(new javax.swing.border.EtchedBorder());
        BorderSeparator1.setMaximumSize(new java.awt.Dimension(32767, 2));
        BorderSeparator1.setMinimumSize(new java.awt.Dimension(10, 2));
        BorderSeparator1.setPreferredSize(new java.awt.Dimension(10, 2));
        BorderSeparator.add(BorderSeparator1, java.awt.BorderLayout.CENTER);

        FillerLabel3.setMaximumSize(new java.awt.Dimension(10, 2));
        FillerLabel3.setMinimumSize(new java.awt.Dimension(10, 2));
        FillerLabel3.setPreferredSize(new java.awt.Dimension(10, 2));
        BorderSeparator.add(FillerLabel3, java.awt.BorderLayout.EAST);

        MessagePanel.add(BorderSeparator);

        MessageDeliveryPanel.setLayout(new javax.swing.BoxLayout(MessageDeliveryPanel, javax.swing.BoxLayout.X_AXIS));

        MessageDeliveryPanel.setMaximumSize(new java.awt.Dimension(520, 40));
        MessageDeliveryPanel.setMinimumSize(new java.awt.Dimension(66, 40));
        MessageDeliveryPanel.setPreferredSize(new java.awt.Dimension(42, 40));
        Separator22.setMaximumSize(new java.awt.Dimension(10, 10));
        Separator22.setMinimumSize(new java.awt.Dimension(10, 10));
        Separator22.setPreferredSize(new java.awt.Dimension(10, 10));
        MessageDeliveryPanel.add(Separator22);

        rbDefaultOptionPanel.setLayout(new javax.swing.BoxLayout(rbDefaultOptionPanel, javax.swing.BoxLayout.X_AXIS));

        rbDefaultOptionPanel.setMaximumSize(new java.awt.Dimension(220, 30));
        rbDefaultOptionPanel.setMinimumSize(new java.awt.Dimension(45, 30));
        rbDefaultOptionPanel.setPreferredSize(new java.awt.Dimension(21, 30));
        rbUseDefaultLocales.setFont(new java.awt.Font("Arial", 0, 11));
        rbUseDefaultLocales.setSelected(true);
        rbUseDefaultLocales.setMaximumSize(new java.awt.Dimension(21, 80));
        rbUseDefaultLocales.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        rbUseDefaultLocales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbUseDefaultLocalesActionPerformed(evt);
            }
        });

        rbDefaultOptionPanel.add(rbUseDefaultLocales);

        SpacerPanel2.setLayout(new javax.swing.BoxLayout(SpacerPanel2, javax.swing.BoxLayout.X_AXIS));

        SpacerPanel2.setMaximumSize(new java.awt.Dimension(195, 30));
        taUseDefaultLocale.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        taUseDefaultLocale.setEditable(false);
        taUseDefaultLocale.setFont(new java.awt.Font("Arial", 0, 12));
        taUseDefaultLocale.setLineWrap(true);
        taUseDefaultLocale.setText("Deliver message to all application users.");
        taUseDefaultLocale.setWrapStyleWord(true);
        taUseDefaultLocale.setMaximumSize(new java.awt.Dimension(235, 30));
        taUseDefaultLocale.setMinimumSize(new java.awt.Dimension(50, 15));
        SpacerPanel2.add(taUseDefaultLocale);

        FillerLabel1.setMaximumSize(new java.awt.Dimension(10, 10));
        FillerLabel1.setMinimumSize(new java.awt.Dimension(10, 10));
        FillerLabel1.setPreferredSize(new java.awt.Dimension(10, 10));
        SpacerPanel2.add(FillerLabel1);

        rbDefaultOptionPanel.add(SpacerPanel2);

        MessageDeliveryPanel.add(rbDefaultOptionPanel);

        rbOnlySelectedLanguagesPanel.setLayout(new javax.swing.BoxLayout(rbOnlySelectedLanguagesPanel, javax.swing.BoxLayout.X_AXIS));

        rbOnlySelectedLanguagesPanel.setMaximumSize(new java.awt.Dimension(300, 30));
        rbOnlySelectedLanguagesPanel.setMinimumSize(new java.awt.Dimension(21, 30));
        rbOnlySelectedLanguagesPanel.setPreferredSize(new java.awt.Dimension(21, 30));
        rbOnlySelectedLanguages.setFont(new java.awt.Font("Arial", 0, 11));
        rbOnlySelectedLanguages.setMaximumSize(new java.awt.Dimension(21, 80));
        rbOnlySelectedLanguages.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        rbOnlySelectedLanguages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbOnlySelectedLanguagesActionPerformed(evt);
            }
        });

        rbOnlySelectedLanguagesPanel.add(rbOnlySelectedLanguages);

        SpacerPanel.setLayout(new javax.swing.BoxLayout(SpacerPanel, javax.swing.BoxLayout.X_AXIS));

        SpacerPanel.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        taOnlySelectedLanguages.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        taOnlySelectedLanguages.setEditable(false);
        taOnlySelectedLanguages.setFont(new java.awt.Font("Arial", 0, 12));
        taOnlySelectedLanguages.setLineWrap(true);
        taOnlySelectedLanguages.setText("Only Deliver Message to specified language groups.");
        taOnlySelectedLanguages.setWrapStyleWord(true);
        taOnlySelectedLanguages.setMaximumSize(new java.awt.Dimension(2147483647, 30));
        taOnlySelectedLanguages.setMinimumSize(new java.awt.Dimension(50, 15));
        SpacerPanel.add(taOnlySelectedLanguages);

        FillerLabel.setMaximumSize(new java.awt.Dimension(10, 10));
        FillerLabel.setMinimumSize(new java.awt.Dimension(10, 10));
        FillerLabel.setPreferredSize(new java.awt.Dimension(10, 10));
        SpacerPanel.add(FillerLabel);

        rbOnlySelectedLanguagesPanel.add(SpacerPanel);

        MessageDeliveryPanel.add(rbOnlySelectedLanguagesPanel);

        MessagePanel.add(MessageDeliveryPanel);

        ContentPanel.add(MessagePanel, java.awt.BorderLayout.CENTER);

        MainContentPanel.add(ContentPanel, java.awt.BorderLayout.CENTER);

        RootPanel.add(MainContentPanel, java.awt.BorderLayout.CENTER);

        MainEastContentPanel.setLayout(new java.awt.BorderLayout());

        MainEastContentPanel.setMaximumSize(new java.awt.Dimension(430, 2147483647));
        MainEastContentPanel.setMinimumSize(new java.awt.Dimension(430, 327));
        MainEastContentPanel.setPreferredSize(new java.awt.Dimension(430, 327));
        EastContentPanel.setLayout(new java.awt.BorderLayout());

        EastContentPanel.setMaximumSize(new java.awt.Dimension(430, 2147483647));
        EastContentPanel.setMinimumSize(new java.awt.Dimension(430, 327));
        EastContentPanel.setPreferredSize(new java.awt.Dimension(430, 327));
        ContentPanel1.setLayout(new java.awt.BorderLayout());

        ContentPanel1.setBorder(new javax.swing.border.TitledBorder(null, "File Update Configuration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12)));
        ContentPanel1.setFont(new java.awt.Font("Arial", 0, 12));
        ContentPanel1.setMaximumSize(new java.awt.Dimension(325, 137));
        ContentPanel1.setMinimumSize(new java.awt.Dimension(325, 137));
        ContentPanel1.setPreferredSize(new java.awt.Dimension(325, 137));
        ContentPanel1.setRequestFocusEnabled(false);
        AutoUpdateFilesPanel.setLayout(new javax.swing.BoxLayout(AutoUpdateFilesPanel, javax.swing.BoxLayout.Y_AXIS));

        NorthPanel.setLayout(new javax.swing.BoxLayout(NorthPanel, javax.swing.BoxLayout.X_AXIS));

        NorthPanel.setMaximumSize(new java.awt.Dimension(2147483647, 15));
        Filller2.setMaximumSize(new java.awt.Dimension(10, 10));
        Filller2.setMinimumSize(new java.awt.Dimension(10, 10));
        Filller2.setPreferredSize(new java.awt.Dimension(10, 10));
        NorthPanel.add(Filller2);

        HeaderTitleLabel.setFont(new java.awt.Font("Arial", 0, 12));
        HeaderTitleLabel.setText("Update Files (Click a cell to display the data below):");
        HeaderTitleLabel.setMinimumSize(new java.awt.Dimension(290, 15));
        HeaderTitleLabel.setPreferredSize(new java.awt.Dimension(290, 15));
        NorthPanel.add(HeaderTitleLabel);

        Filller1.setMaximumSize(new java.awt.Dimension(10, 10));
        Filller1.setMinimumSize(new java.awt.Dimension(10, 10));
        Filller1.setPreferredSize(new java.awt.Dimension(10, 10));
        NorthPanel.add(Filller1);

        AutoUpdateFilesPanel.add(NorthPanel);

        FilesContentPanel.setLayout(new javax.swing.BoxLayout(FilesContentPanel, javax.swing.BoxLayout.Y_AXIS));

        TheFileListPanel.setLayout(new javax.swing.BoxLayout(TheFileListPanel, javax.swing.BoxLayout.X_AXIS));

        Filller3.setMaximumSize(new java.awt.Dimension(10, 10));
        Filller3.setMinimumSize(new java.awt.Dimension(10, 10));
        Filller3.setPreferredSize(new java.awt.Dimension(10, 10));
        TheFileListPanel.add(Filller3);

        FileListScrollPane.setPreferredSize(new java.awt.Dimension(400, 60));
        FileList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        FileList.setTableHeader(null);
        FileList.setVerifyInputWhenFocusTarget(false);
        FileList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FileListMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FileListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FileListMouseExited(evt);
            }
        });
        FileList.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                FileListMouseMoved(evt);
            }
        });

        FileListScrollPane.setViewportView(FileList);

        TheFileListPanel.add(FileListScrollPane);

        Filller4.setMaximumSize(new java.awt.Dimension(10, 10));
        Filller4.setMinimumSize(new java.awt.Dimension(10, 10));
        Filller4.setPreferredSize(new java.awt.Dimension(10, 10));
        TheFileListPanel.add(Filller4);

        FilesContentPanel.add(TheFileListPanel);

        ButtonPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));

        ButtonPanel2.setMaximumSize(new java.awt.Dimension(32767, 45));
        ButtonPanel2.setMinimumSize(new java.awt.Dimension(110, 45));
        ButtonPanel2.setPreferredSize(new java.awt.Dimension(400, 45));
        AddFileButtonPanel.setLayout(new javax.swing.BoxLayout(AddFileButtonPanel, javax.swing.BoxLayout.X_AXIS));

        AddFileButtonPanel.setMaximumSize(new java.awt.Dimension(110, 26));
        AddFileButtonPanel.setMinimumSize(new java.awt.Dimension(110, 26));
        AddFileButtonPanel.setPreferredSize(new java.awt.Dimension(110, 26));
        Filler1.setText("jLabel1");
        Filler1.setMaximumSize(new java.awt.Dimension(5, 5));
        Filler1.setMinimumSize(new java.awt.Dimension(5, 5));
        Filler1.setPreferredSize(new java.awt.Dimension(5, 5));
        AddFileButtonPanel.add(Filler1);

        AddFile.setFont(new java.awt.Font("Arial", 0, 12));
        AddFile.setMnemonic('A');
        AddFile.setLabel("Add File");
        AddFile.setMargin(new java.awt.Insets(0, 0, 0, 0));
        AddFile.setMaximumSize(new java.awt.Dimension(103, 25));
        AddFile.setMinimumSize(new java.awt.Dimension(103, 25));
        AddFile.setPreferredSize(new java.awt.Dimension(103, 25));
        AddFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddFileActionPerformed(evt);
            }
        });

        AddFileButtonPanel.add(AddFile);

        ButtonPanel2.add(AddFileButtonPanel);

        RemoveFileButtonPanel.setLayout(new javax.swing.BoxLayout(RemoveFileButtonPanel, javax.swing.BoxLayout.X_AXIS));

        RemoveFileButtonPanel.setMaximumSize(new java.awt.Dimension(110, 26));
        RemoveFileButtonPanel.setMinimumSize(new java.awt.Dimension(110, 26));
        RemoveFileButtonPanel.setPreferredSize(new java.awt.Dimension(110, 26));
        Filler2.setText("jLabel1");
        Filler2.setMaximumSize(new java.awt.Dimension(5, 5));
        Filler2.setMinimumSize(new java.awt.Dimension(5, 5));
        Filler2.setPreferredSize(new java.awt.Dimension(5, 5));
        RemoveFileButtonPanel.add(Filler2);

        RemoveFile.setFont(new java.awt.Font("Arial", 0, 12));
        RemoveFile.setMnemonic('R');
        RemoveFile.setLabel("Remove File");
        RemoveFile.setMargin(new java.awt.Insets(0, 0, 0, 0));
        RemoveFile.setMaximumSize(new java.awt.Dimension(103, 25));
        RemoveFile.setMinimumSize(new java.awt.Dimension(103, 25));
        RemoveFile.setPreferredSize(new java.awt.Dimension(103, 25));
        RemoveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveFileActionPerformed(evt);
            }
        });

        RemoveFileButtonPanel.add(RemoveFile);

        ButtonPanel2.add(RemoveFileButtonPanel);

        FilesContentPanel.add(ButtonPanel2);

        SouthNewProjectPanelTopPanel.setLayout(new javax.swing.BoxLayout(SouthNewProjectPanelTopPanel, javax.swing.BoxLayout.Y_AXIS));

        HelpStatusLabel.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        HelpStatusLabel.setEditable(false);
        HelpStatusLabel.setFont(new java.awt.Font("Arial", 0, 12));
        HelpStatusLabel.setMargin(new java.awt.Insets(5, 10, 0, 0));
        HelpStatusLabel.setMaximumSize(new java.awt.Dimension(2147483647, 25));
        HelpStatusLabel.setMinimumSize(new java.awt.Dimension(0, 25));
        HelpStatusLabel.setPreferredSize(new java.awt.Dimension(0, 25));
        SouthNewProjectPanelTopPanel.add(HelpStatusLabel);

        HorizontalRulePanel.setBorder(new javax.swing.border.EtchedBorder());
        HorizontalRulePanel.setMaximumSize(new java.awt.Dimension(32767, 2));
        HorizontalRulePanel.setMinimumSize(new java.awt.Dimension(10, 2));
        HorizontalRulePanel.setPreferredSize(new java.awt.Dimension(10, 2));
        SouthNewProjectPanelTopPanel.add(HorizontalRulePanel);

        FilesContentPanel.add(SouthNewProjectPanelTopPanel);

        AutoUpdateFilesPanel.add(FilesContentPanel);

        ContentPanel1.add(AutoUpdateFilesPanel, java.awt.BorderLayout.CENTER);

        EastContentPanel.add(ContentPanel1, java.awt.BorderLayout.CENTER);

        SouthContentPanel.setLayout(new javax.swing.BoxLayout(SouthContentPanel, javax.swing.BoxLayout.Y_AXIS));

        SouthContentPanel.setMaximumSize(new java.awt.Dimension(430, 190));
        SouthContentPanel.setMinimumSize(new java.awt.Dimension(430, 190));
        SouthContentPanel.setPreferredSize(new java.awt.Dimension(430, 190));
        MessageURLPanel.setLayout(new javax.swing.BoxLayout(MessageURLPanel, javax.swing.BoxLayout.Y_AXIS));

        MessageURLPanel.setBorder(new javax.swing.border.TitledBorder(null, "Automatic Software Update File Download URL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12)));
        MessageURLPanel.setMaximumSize(new java.awt.Dimension(2147483647, 55));
        MessageURLPanel.setMinimumSize(new java.awt.Dimension(527, 55));
        MessageURLPanel.setPreferredSize(new java.awt.Dimension(1232, 55));
        cbMessageURLPanel.setLayout(new javax.swing.BoxLayout(cbMessageURLPanel, javax.swing.BoxLayout.X_AXIS));

        Separator23.setMaximumSize(new java.awt.Dimension(10, 10));
        Separator23.setMinimumSize(new java.awt.Dimension(10, 10));
        Separator23.setPreferredSize(new java.awt.Dimension(10, 10));
        cbMessageURLPanel.add(Separator23);

        cbURLAddressBar.setEditable(true);
        cbURLAddressBar.setFont(new java.awt.Font("Arial", 0, 12));
        cbURLAddressBar.setMaximumSize(new java.awt.Dimension(32767, 21));
        cbURLAddressBar.setMinimumSize(new java.awt.Dimension(300, 21));
        cbURLAddressBar.setPreferredSize(new java.awt.Dimension(450, 21));
        cbMessageURLPanel.add(cbURLAddressBar);

        lFiller27.setBackground(new java.awt.Color(140, 160, 210));
        lFiller27.setText("   ");
        lFiller27.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller27.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller27.setPreferredSize(new java.awt.Dimension(10, 16));
        cbMessageURLPanel.add(lFiller27);

        MessageURLPanel.add(cbMessageURLPanel);

        SouthContentPanel.add(MessageURLPanel);

        MessageBuildLocation.setLayout(new javax.swing.BoxLayout(MessageBuildLocation, javax.swing.BoxLayout.Y_AXIS));

        MessageBuildLocation.setBorder(new javax.swing.border.TitledBorder(null, "Automatic Software Update File Build Location", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12)));
        MessageBuildLocation.setMaximumSize(new java.awt.Dimension(2147483647, 90));
        MessageBuildLocation.setMinimumSize(new java.awt.Dimension(527, 90));
        MessageBuildLocation.setPreferredSize(new java.awt.Dimension(1232, 90));
        MessageOutputTextFieldPanel.setLayout(new javax.swing.BoxLayout(MessageOutputTextFieldPanel, javax.swing.BoxLayout.X_AXIS));

        Separator17.setMaximumSize(new java.awt.Dimension(10, 10));
        Separator17.setMinimumSize(new java.awt.Dimension(10, 10));
        Separator17.setPreferredSize(new java.awt.Dimension(10, 10));
        MessageOutputTextFieldPanel.add(Separator17);

        tfBuildLocation1.setBackground(javax.swing.UIManager.getDefaults().getColor("TextField.inactiveBackground"));
        tfBuildLocation1.setFont(new java.awt.Font("Arial", 0, 12));
        tfBuildLocation1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfBuildLocation1.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        tfBuildLocation1.setMinimumSize(new java.awt.Dimension(300, 20));
        tfBuildLocation1.setPreferredSize(new java.awt.Dimension(450, 20));
        tfBuildLocation1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBuildLocation1ActionPerformed(evt);
            }
        });

        MessageOutputTextFieldPanel.add(tfBuildLocation1);

        lFiller26.setBackground(new java.awt.Color(140, 160, 210));
        lFiller26.setText("   ");
        lFiller26.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller26.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller26.setPreferredSize(new java.awt.Dimension(10, 16));
        MessageOutputTextFieldPanel.add(lFiller26);

        MessageBuildLocation.add(MessageOutputTextFieldPanel);

        MessageOutputLabelPanel.setLayout(new javax.swing.BoxLayout(MessageOutputLabelPanel, javax.swing.BoxLayout.X_AXIS));

        Separator15.setMaximumSize(new java.awt.Dimension(10, 10));
        Separator15.setMinimumSize(new java.awt.Dimension(10, 10));
        Separator15.setPreferredSize(new java.awt.Dimension(10, 10));
        MessageOutputLabelPanel.add(Separator15);

        Separator16.setMaximumSize(new java.awt.Dimension(10, 10));
        Separator16.setMinimumSize(new java.awt.Dimension(10, 10));
        Separator16.setPreferredSize(new java.awt.Dimension(10, 10));
        MessageOutputLabelPanel.add(Separator16);

        MessageBuildLocation.add(MessageOutputLabelPanel);

        MessageOutputTextFieldPanel1.setLayout(new javax.swing.BoxLayout(MessageOutputTextFieldPanel1, javax.swing.BoxLayout.X_AXIS));

        Separator18.setMaximumSize(new java.awt.Dimension(10, 10));
        Separator18.setMinimumSize(new java.awt.Dimension(10, 10));
        Separator18.setPreferredSize(new java.awt.Dimension(10, 10));
        MessageOutputTextFieldPanel1.add(Separator18);

        ChooseButton.setFont(new java.awt.Font("Arial", 0, 12));
        ChooseButton.setMnemonic('C');
        ChooseButton.setText("Choose...");
        ChooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseButtonActionPerformed(evt);
            }
        });

        MessageOutputTextFieldPanel1.add(ChooseButton);

        lFiller31.setBackground(new java.awt.Color(140, 160, 210));
        lFiller31.setText("   ");
        lFiller31.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller31.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller31.setPreferredSize(new java.awt.Dimension(10, 16));
        MessageOutputTextFieldPanel1.add(lFiller31);

        DefaultButton.setFont(new java.awt.Font("Arial", 0, 12));
        DefaultButton.setMnemonic('D');
        DefaultButton.setText("Default");
        DefaultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DefaultButtonActionPerformed(evt);
            }
        });

        MessageOutputTextFieldPanel1.add(DefaultButton);

        lFiller32.setBackground(new java.awt.Color(140, 160, 210));
        lFiller32.setText("   ");
        lFiller32.setMaximumSize(new java.awt.Dimension(32767, 15));
        lFiller32.setMinimumSize(new java.awt.Dimension(15, 16));
        lFiller32.setPreferredSize(new java.awt.Dimension(15, 16));
        MessageOutputTextFieldPanel1.add(lFiller32);

        btnViewDocumentation.setFont(new java.awt.Font("Arial", 0, 12));
        btnViewDocumentation.setMnemonic('V');
        btnViewDocumentation.setText("View Implementation Instructions");
        btnViewDocumentation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDocumentationActionPerformed(evt);
            }
        });

        MessageOutputTextFieldPanel1.add(btnViewDocumentation);

        lFiller33.setBackground(new java.awt.Color(140, 160, 210));
        lFiller33.setText("   ");
        lFiller33.setMaximumSize(new java.awt.Dimension(10, 15));
        lFiller33.setMinimumSize(new java.awt.Dimension(10, 16));
        lFiller33.setPreferredSize(new java.awt.Dimension(10, 16));
        MessageOutputTextFieldPanel1.add(lFiller33);

        MessageBuildLocation.add(MessageOutputTextFieldPanel1);

        SouthContentPanel.add(MessageBuildLocation);

        ButtonPanel.setLayout(new javax.swing.BoxLayout(ButtonPanel, javax.swing.BoxLayout.X_AXIS));

        ButtonPanel.setMaximumSize(new java.awt.Dimension(32767, 45));
        ButtonPanel.setMinimumSize(new java.awt.Dimension(0, 45));
        ButtonPanel.setPreferredSize(new java.awt.Dimension(0, 45));
        MessageIDPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        MessageIDLabel.setFont(new java.awt.Font("Arial", 0, 12));
        MessageIDLabel.setText("Message ID Number:");
        MessageIDPanel.add(MessageIDLabel);

        spinMessageID.setFont(new java.awt.Font("Arial", 0, 12));
        spinMessageID.setMinimumSize(new java.awt.Dimension(50, 20));
        spinMessageID.setPreferredSize(new java.awt.Dimension(50, 20));
        spinMessageID.setEnabled(false);
        MessageIDPanel.add(spinMessageID);

        ButtonPanel.add(MessageIDPanel);

        MessagePreviewPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 10));

        MessagePreviewButton.setFont(new java.awt.Font("Arial", 0, 12));
        MessagePreviewButton.setMnemonic('P');
        MessagePreviewButton.setText("Preview");
        MessagePreviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MessagePreviewButtonActionPerformed(evt);
            }
        });

        MessagePreviewPanel.add(MessagePreviewButton);

        BuildMessageButton.setFont(new java.awt.Font("Arial", 0, 12));
        BuildMessageButton.setMnemonic('B');
        BuildMessageButton.setText("Build Message");
        BuildMessageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuildMessageButtonActionPerformed(evt);
            }
        });

        MessagePreviewPanel.add(BuildMessageButton);

        ButtonPanel.add(MessagePreviewPanel);

        SouthContentPanel.add(ButtonPanel);

        EastContentPanel.add(SouthContentPanel, java.awt.BorderLayout.SOUTH);

        MainEastContentPanel.add(EastContentPanel, java.awt.BorderLayout.CENTER);

        RootPanel.add(MainEastContentPanel, java.awt.BorderLayout.EAST);

        MainSouthContentPanel.setLayout(new java.awt.BorderLayout());

        MainSouthContentPanel.setMaximumSize(new java.awt.Dimension(0, 0));
        MainSouthContentPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        MainSouthContentPanel.setPreferredSize(new java.awt.Dimension(0, 0));
        RootPanel.add(MainSouthContentPanel, java.awt.BorderLayout.SOUTH);

        getContentPane().add(RootPanel, java.awt.BorderLayout.CENTER);

        FileMenu.setMnemonic('F');
        FileMenu.setText("File");
        FileMenu.setFont(new java.awt.Font("Arial", 0, 12));
        FileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileMenuActionPerformed(evt);
            }
        });

        newMenuItem.setMnemonic('N');
        newMenuItem.setText("New");
        newMenuItem.setFont(new java.awt.Font("Arial", 0, 12));
        newMessageMenuItem.setFont(new java.awt.Font("Arial", 0, 12));
        newMessageMenuItem.setMnemonic('M');
        newMessageMenuItem.setText("Automatic Software Update");
        newMessageMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMessageMenuItemActionPerformed(evt);
            }
        });

        newMenuItem.add(newMessageMenuItem);

        modifyURLMenuItem.setFont(new java.awt.Font("Arial", 0, 12));
        modifyURLMenuItem.setMnemonic('h');
        modifyURLMenuItem.setText("Change Automatic Software Update URL");
        modifyURLMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyURLMenuItemActionPerformed(evt);
            }
        });

        newMenuItem.add(modifyURLMenuItem);

        FileMenu.add(newMenuItem);

        saveDefaultsMenuItem.setFont(new java.awt.Font("Arial", 0, 12));
        saveDefaultsMenuItem.setMnemonic('S');
        saveDefaultsMenuItem.setLabel("Save Configuration As Default");
        saveDefaultsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveDefaultsMenuItemActionPerformed(evt);
            }
        });

        FileMenu.add(saveDefaultsMenuItem);

        advancedPropertiesMenuItem.setFont(new java.awt.Font("Arial", 0, 12));
        advancedPropertiesMenuItem.setMnemonic('A');
        advancedPropertiesMenuItem.setText("Advanced Message Properties");
        advancedPropertiesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                advancedPropertiesMenuItemActionPerformed(evt);
            }
        });

        FileMenu.add(advancedPropertiesMenuItem);

        closeMenuItem.setFont(new java.awt.Font("Arial", 0, 12));
        closeMenuItem.setMnemonic('C');
        closeMenuItem.setText("Close");
        closeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeMenuItemActionPerformed(evt);
            }
        });

        FileMenu.add(closeMenuItem);

        FileMenu.add(jSeparator3);

        exitMenuItem.setFont(new java.awt.Font("Arial", 0, 12));
        exitMenuItem.setMnemonic('X');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });

        FileMenu.add(exitMenuItem);

        MessageDesignerMenuBar.add(FileMenu);

        DesignerMenu.setMnemonic('D');
        DesignerMenu.setText("Designers");
        DesignerMenu.setFont(new java.awt.Font("Arial", 0, 12));
        ProjectDesignerMenuItem.setFont(new java.awt.Font("Arial", 0, 12));
        ProjectDesignerMenuItem.setMnemonic('E');
        ProjectDesignerMenuItem.setText("EvaluateAnywhere Project Designer");
        ProjectDesignerMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProjectDesignerMenuItemActionPerformed(evt);
            }
        });

        DesignerMenu.add(ProjectDesignerMenuItem);

        MessageDesignerMenuItem.setFont(new java.awt.Font("Arial", 0, 12));
        MessageDesignerMenuItem.setMnemonic('a');
        MessageDesignerMenuItem.setText("Message Designer");
        MessageDesignerMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MessageDesignerMenuItemActionPerformed(evt);
            }
        });

        DesignerMenu.add(MessageDesignerMenuItem);

        MessageDesignerMenuBar.add(DesignerMenu);

        HelpMenu.setMnemonic('H');
        HelpMenu.setText("Help");
        HelpMenu.setFont(new java.awt.Font("Arial", 0, 12));
        AboutHelp.setFont(new java.awt.Font("Arial", 0, 12));
        AboutHelp.setMnemonic('A');
        AboutHelp.setText("About EvaluateAnywhere...");
        AboutHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutHelpActionPerformed(evt);
            }
        });

        HelpMenu.add(AboutHelp);

        HelpMenu.add(jSeparator2);

        EvaluateAnywhereHelp.setFont(new java.awt.Font("Arial", 0, 12));
        EvaluateAnywhereHelp.setMnemonic('H');
        EvaluateAnywhereHelp.setText("EvaluateAnywhere Help...");
        HelpMenu.add(EvaluateAnywhereHelp);

        MessageDesignerMenuBar.add(HelpMenu);

        setJMenuBar(MessageDesignerMenuBar);

        pack();
    }//GEN-END:initComponents

    private void FileListMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FileListMouseMoved
    try
    {
            java.awt.Point p = evt.getPoint();
            int rowIndex = FileList.rowAtPoint(p);
            int colIndex = FileList.columnAtPoint(p);    
            setStatus(((String)dataModel.getValueAt(rowIndex,colIndex)));
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    }//GEN-LAST:event_FileListMouseMoved

    private void FileListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FileListMouseExited
        setStatus("");
    }//GEN-LAST:event_FileListMouseExited

    private void FileListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FileListMouseEntered
    try
    {
            java.awt.Point p = evt.getPoint();
            int rowIndex = FileList.rowAtPoint(p);
            int colIndex = FileList.columnAtPoint(p);    
            setStatus(((String)dataModel.getValueAt(rowIndex,colIndex)));
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    }//GEN-LAST:event_FileListMouseEntered

    private void FileListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FileListMouseClicked

    }//GEN-LAST:event_FileListMouseClicked

    private void RemoveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveFileActionPerformed
        removeRow();
        FileList.updateUI();
        scrollPaneMessageBody.getViewport().updateUI();       
    }//GEN-LAST:event_RemoveFileActionPerformed

    private void AddFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddFileActionPerformed
        addRow();
        FileList.updateUI();
        scrollPaneMessageBody.getViewport().updateUI();
    }//GEN-LAST:event_AddFileActionPerformed

    private void btnViewDocumentationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDocumentationActionPerformed
        try
        {
             BrowserLauncher.openURL(new URL(new File(new URL(ProjectManager.get("update_build_dir")).getFile()).toURL().toString() + "README.html").toString());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnViewDocumentationActionPerformed

    private void rbOnlySelectedLanguagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbOnlySelectedLanguagesActionPerformed
     try
     {
        rbUseDefaultLocales.setSelected(false);
        rbOnlySelectedLanguages.setSelected(true);
        getPopulateUpdateDownloadURLs(); 
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }       
    }//GEN-LAST:event_rbOnlySelectedLanguagesActionPerformed

    private void rbUseDefaultLocalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbUseDefaultLocalesActionPerformed
      try
      {
        rbUseDefaultLocales.setSelected(true);
        rbOnlySelectedLanguages.setSelected(false);
        getPopulateUpdateDownloadURLs();
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
    }//GEN-LAST:event_rbUseDefaultLocalesActionPerformed

    private String parseLocalesToLanguages(String localesString)
    {
        String retString = "";
        HashMap theStrMap = new HashMap();
        try
        {
            Object[] locArray = getStringArraysFromString(localesString);
            for(int i = 0;i<locArray.length;i++)
            {
                String stringLocale = (String)locArray[i];
                stringLocale = stringLocale.substring(0,2);
                if(theStrMap.get(stringLocale)!=null)
                {

                }
                else
                {
                    theStrMap.put(stringLocale,stringLocale);
                    if(retString.equalsIgnoreCase("")==false)
                    {
                        retString = retString + "," + stringLocale;
                    }
                    else
                    {
                        retString = stringLocale;                    
                    }
                }
            }
        }
        catch(Exception e)
        {

        }
        return retString;
    }
    
    private String getLanguageNamesFromLanguageAbbreviations(String langAbbreviations)
    {
        String retString = "";
        if(langAbbrevHashMap!=null)
        {}
        else
        {
            langAbbrevHashMap = new HashMap(strLocales.length);
            for(int i = 0;i<strLocales.length;i++)
            {
                langAbbrevHashMap.put(strLocales[i],strLocalesNames[i]);
            }
        }
        try
        {
            Object[] localesArray = getStringArraysFromString(langAbbreviations);
            for(int i = 0;i<localesArray.length;i++)
            {
                if(retString.equalsIgnoreCase("")==false)
                {
                    try
                    {
                        if(langAbbrevHashMap.get(((String)localesArray[i]))!=null)
                        {
                            retString = retString + "," + (String)langAbbrevHashMap.get(((String)localesArray[i]));
                        }
                    }
                    catch(Exception e)
                    {
                        retString = retString + ",";                    
                    }
                }
                else
                {
                    try
                    {
                        if(langAbbrevHashMap.get(((String)localesArray[i]))!=null)
                        {
                            retString = (String)langAbbrevHashMap.get((String)localesArray[i]);
                        }
                    }
                    catch(Exception e)
                    {
                        retString = ",";                        
                    }
                }
            }
        }
        catch(Exception e)
        {
            
        }
        return retString;
    }
     
    private void ConfigureLanguagesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfigureLanguagesButtonActionPerformed
        String theLanguages = "en";
        if(ProjectManager.get("project_default_update_langs").equalsIgnoreCase("")==false)
        {
            theLanguages = parseLocalesToLanguages(ProjectManager.get("prjlocales") + "," + ProjectManager.get("project_default_update_langs"));
        }
        else
        {
            theLanguages = parseLocalesToLanguages(ProjectManager.get("prjlocales"));
        }
        String theLanguagesNames = getLanguageNamesFromLanguageAbbreviations(theLanguages);
        if(LanguageChooser.showLanguageChooserDialog(this, "Choose Message Languages",ProjectManager.get("prjdefaultlocale"),theLanguages,ProjectManager.get("project_default_update_langs"),theLanguagesNames)==true)
        {
            if(LanguageChooser.getMessageBuildLocales()!=null)
            {
                if(LanguageChooser.getMessageBuildLocales().equalsIgnoreCase("null")==true)
                {
                   ProjectManager.saveSinglePut("project_default_update_langs", "");
                   cbURLAddressBar.setEnabled(false);
                }
                else
                {
                    ProjectManager.saveSinglePut("project_default_update_langs", LanguageChooser.getMessageBuildLocales());
                    if(ProjectManager.get("project_default_update_langs").indexOf(",")==-1)
                    {
                        cbURLAddressBar.setEnabled(false);
                    }
                    else
                    {
                         cbURLAddressBar.setEnabled(true);                       
                    }
                }
            }
            else
            {
                ProjectManager.saveSinglePut("project_default_update_langs", "");
                cbURLAddressBar.setEnabled(false);               
            }
            if(ProjectManager.get("project_default_update_langs")!=null)
            {
               if(ProjectManager.get("project_default_update_langs").equalsIgnoreCase("")==true)
               {            
                    rbUseDefaultLocales.setSelected(true);
                    rbOnlySelectedLanguages.setSelected(false);
                    rbUseDefaultLocales.setEnabled(false);
                    rbOnlySelectedLanguages.setEnabled(false);                    
               }
               else
               {
                    rbUseDefaultLocales.setEnabled(true);
                    rbOnlySelectedLanguages.setEnabled(true);                     
               }
            }
            else
            {
                rbUseDefaultLocales.setSelected(true);
                rbOnlySelectedLanguages.setSelected(false);  
                rbUseDefaultLocales.setEnabled(false);
                rbOnlySelectedLanguages.setEnabled(false);                  
            }            
            setMessageGUI(); 
            //System.out.println("Languages Choosen: " + LanguageChooser.getMessageBuildLocales());
        }
    }//GEN-LAST:event_ConfigureLanguagesButtonActionPerformed

    
    private void advancedPropertiesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_advancedPropertiesMenuItemActionPerformed
        try
        {
            if(AdvancedUpdateBuilderConfigurationDialog.showLocaleSelectorDialog(msgIDNumber, pwdSeed, pwdCount)==0)
            {
                pwdCount = AdvancedUpdateBuilderConfigurationDialog.getPasswordCount();
                msgIDNumber = AdvancedUpdateBuilderConfigurationDialog.getMessageIDNumber();  
                pwdSeed = AdvancedUpdateBuilderConfigurationDialog.getPasswordSeed();
                spinMessageID.setModel(new SpinnerNumberModel(new Integer(msgIDNumber),new Integer(0),new Integer(999999999),new Integer(1)));                       
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        } 
    }//GEN-LAST:event_advancedPropertiesMenuItemActionPerformed

    private void newMessageMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMessageMenuItemActionPerformed
        setMessageGUI();
        ContentPanel.setBorder(new javax.swing.border.TitledBorder(null, "Message", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12)));
    }//GEN-LAST:event_newMessageMenuItemActionPerformed

    private void modifyURLMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyURLMenuItemActionPerformed
        if(baseURLChangePanel!=null)
        {}
        else
        {
           baseURLChangePanel = new BaseURLChangePanel();           
        }
        setModifyBaseURLGUI();
        ContentPanel.setBorder(null);
    }//GEN-LAST:event_modifyURLMenuItemActionPerformed

    private void ProjectDesignerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProjectDesignerMenuItemActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_ProjectDesignerMenuItemActionPerformed

    private void MessageDesignerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MessageDesignerMenuItemActionPerformed
        setVisible(false);
        new MessageBuilderAction();
        dispose();
    }//GEN-LAST:event_MessageDesignerMenuItemActionPerformed

    private void AboutHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutHelpActionPerformed
         new AboutBoxDialog(this, true).show();
    }//GEN-LAST:event_AboutHelpActionPerformed

    private void saveDefaultsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveDefaultsMenuItemActionPerformed
        try
        {
            LanguagePanel theLangPanel = getCurrentLanguagePanel();
            ProjectManager.put("project_default_update_msgType", String.valueOf(msgType));
            ProjectManager.put("project_default_update_msgtitle", theLangPanel.getMessageTitle());
            ProjectManager.put("project_default_update_msgtext", theLangPanel.getMessage());
            ProjectManager.put("project_default_update_msgfont", msgfont);
            ProjectManager.put("project_default_msgbtnfont", msgbtnfont);
            ProjectManager.put("project_default_update_msgfontclr", msgfontclr);
            ProjectManager.put("project_default_msgbtnfontclr", msgbtnfontclr);
            ProjectManager.put("project_default_update_msgokbtn", theLangPanel.getMessageOKText());
            if(theLangPanel.getMessageOKMnemonic().equalsIgnoreCase("")==false)
            {
                ProjectManager.put("project_default_update_msgokbtnmnem", theLangPanel.getMessageOKMnemonic());
            }
            else
            {
                ProjectManager.put("project_default_update_msgokbtnmnem", "");                
            }
            ProjectManager.put("project_default_update_msgskipbtn", theLangPanel.getMessageSkipText());
            if(theLangPanel.getMessageSkipMnemonic().equalsIgnoreCase("")==false)
            {
                ProjectManager.put("project_default_update_msgskipbtnmnem", theLangPanel.getMessageSkipMnemonic());
            }
            else
            {
                ProjectManager.put("project_default_update_msgskipbtnmnem", "");                
            }    
            ProjectManager.put("project_default_update_msgsupport", theLangPanel.getSupportMessage());
            ProjectManager.put("project_default_update_msgerror", theLangPanel.getErrorMessage());
            ProjectManager.put("project_default_update_msgtextalgn", String.valueOf(msgtextalgn));
  
            ProjectManager.put("project_default_update_copyfilesto", copyfilesto);
            ProjectManager.put("project_default_update_files", files);
            ProjectManager.put("project_default_update_overwriteexistingfiles", overwriteexistingfiles);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_saveDefaultsMenuItemActionPerformed

    private void closeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeMenuItemActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
       System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void FileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FileMenuActionPerformed

    private void BuildMessageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuildMessageButtonActionPerformed
        try
        {
            int msgResult = compileMessage(new File(new URL(ProjectManager.get("update_build_dir")).getFile()));
            if(msgResult == 0)
            {
                btnViewDocumentation.setEnabled(true);          
                JOptionPane.showMessageDialog(this,"Automatic Software Update Created Successfully.");
            }
            else if(msgResult == 1)
            {
                btnViewDocumentation.setEnabled(false);                
                JOptionPane.showMessageDialog(this,"Automatic Software Update Build Failed. Return Code: " + String.valueOf(msgResult));
            }
            else if(msgResult == 7)
            {
                btnViewDocumentation.setEnabled(false);                  
                JOptionPane.showMessageDialog(this,"Automatic Software Update Build Failed. Return Code: " + String.valueOf(msgResult));
            }      
            else if(msgResult == 8)
            {
                btnViewDocumentation.setEnabled(false);                  
                JOptionPane.showMessageDialog(this,"Automatic Software Update Build Failed. Could not create the automatic software update output directory");
            } 
            else if(msgResult == 18)
            {
                btnViewDocumentation.setEnabled(false);                  
                JOptionPane.showMessageDialog(this,"Automatic Software Update Build Failed. The Build Directory could not be cleaned up (old .eal files erased). Manually remove .eal files to proceed.");
            }              
            else if(msgResult == 19)
            {
                btnViewDocumentation.setEnabled(false);                  
                JOptionPane.showMessageDialog(this,"Automatic Software Update Build Failed. The Automatic Software Update File Download URL is not a valid URL.");
            }      
            else if(msgResult == 20)
            {
                btnViewDocumentation.setEnabled(false);                  
                JOptionPane.showMessageDialog(this,"Automatic Software Update Build Failed. Please specify the file(s) to be updated.");
            }     
            else if(msgResult == 21)
            {
                btnViewDocumentation.setEnabled(false);                  
                JOptionPane.showMessageDialog(this,"Automatic Software Update Build Failed. Please specify the Download File URLs to be updated.");
            }                 
            else
            {
                btnViewDocumentation.setEnabled(false);                  
                JOptionPane.showMessageDialog(this,"Automatic Software Update Build Failed. Return Code: " + String.valueOf(msgResult));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            btnViewDocumentation.setEnabled(false);              
        }
    }//GEN-LAST:event_BuildMessageButtonActionPerformed

    private void cbDefaultFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDefaultFontActionPerformed
        if(cbDefaultFont.isSelected()==true)
        {
            msgfont = "";
        }
        else
        {
             msgfont="Helvetica,0,13";
        }
    }//GEN-LAST:event_cbDefaultFontActionPerformed

    private void cbDefaultTextColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDefaultTextColorActionPerformed
        if(cbDefaultTextColor.isSelected()==true)
        {
            msgfontclr = "";
        }
        else
        {
             msgfontclr = "38,54,69";       
        }
    }//GEN-LAST:event_cbDefaultTextColorActionPerformed

    private void AdvancedConfigurationOptionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdvancedConfigurationOptionsButtonActionPerformed
        try
        {
            if(AdvancedUpdateBuilderConfigurationDialog.showLocaleSelectorDialog(msgIDNumber, pwdSeed, pwdCount)==0)
            {
                pwdCount = AdvancedUpdateBuilderConfigurationDialog.getPasswordCount();
                msgIDNumber = AdvancedUpdateBuilderConfigurationDialog.getMessageIDNumber();  
                pwdSeed = AdvancedUpdateBuilderConfigurationDialog.getPasswordSeed();
                spinMessageID.setModel(new SpinnerNumberModel(new Integer(msgIDNumber),new Integer(0),new Integer(999999999),new Integer(1)));                       
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_AdvancedConfigurationOptionsButtonActionPerformed

    private void DefaultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DefaultButtonActionPerformed
    try
    {
        DefaultBuildDirectoryDialog ddd = new DefaultBuildDirectoryDialog(null,true);
        if(ddd.getMethod()==0)
        {
            String tempStr = DesignerRuleBuilder.getTempProject().substring(0,DesignerRuleBuilder.getTempProject().lastIndexOf("."));
            ProjectManager.putTempNoFileWrite("update_build_dir", DesignerRuleBuilder.getTempProject().substring(0,DesignerRuleBuilder.getTempProject().lastIndexOf("/")) + "/Update" + ProjectManager.get("project_build_dir_name") + "/");
            ProjectManager.saveTempNow(); 
            tfBuildLocation1.setText(new File(new URL(ProjectManager.get("update_build_dir")).getFile()).getCanonicalPath());
            tfBuildLocation1.setCaretPosition(0);
        }
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    }//GEN-LAST:event_DefaultButtonActionPerformed

    private void ChooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseButtonActionPerformed
        try
        {
                fc.setFileView(fileView);
                fc.setDialogTitle("Choose Output Folder");
                fc.setApproveButtonText("Select");
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fc.setCurrentDirectory(new File(new URL(ProjectManager.get("update_build_dir")).getFile()));
                fc.showSaveDialog(this); 
                ProjectManager.put("update_build_dir",fc.getSelectedFile().toURL().toString());
                String tempStr = DesignerRuleBuilder.getTempProject().substring(0,DesignerRuleBuilder.getTempProject().lastIndexOf("."));
                tfBuildLocation1.setText(new File(new URL(ProjectManager.get("update_build_dir")).getFile()).getCanonicalPath());
		tfBuildLocation1.setCaretPosition(0);
        }
        catch(NullPointerException e)
        {
            //Leave empty for calls to Cancel in the JFileChooser
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_ChooseButtonActionPerformed

    private void tfBuildLocation1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBuildLocation1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBuildLocation1ActionPerformed

    private void RightAlignButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RightAlignButtonActionPerformed
        msgtextalgn=2;
        LeftAlignButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
                CenterAlignButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
                RightAlignButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));            
    }//GEN-LAST:event_RightAlignButtonActionPerformed

    private void CenterAlignButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CenterAlignButtonActionPerformed
        msgtextalgn=1;
        LeftAlignButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
                CenterAlignButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
                RightAlignButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));            
    }//GEN-LAST:event_CenterAlignButtonActionPerformed

    private void LeftAlignButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeftAlignButtonActionPerformed
        msgtextalgn=0; 
        LeftAlignButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
                CenterAlignButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
                RightAlignButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));    
    }//GEN-LAST:event_LeftAlignButtonActionPerformed

    private void FontButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FontButtonActionPerformed
        try
        {
 if(msgfont!=null)
        {
            if(msgfont.equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(msgfont);
                Font retFont = FontChooser.showDialog(this,"Font Chooser", new Font((String)tmpArray[0],new Integer((String)tmpArray[1]).intValue(), new Integer((String)tmpArray[2]).intValue()));
                if(retFont!=null)
                {
                    msgfont = retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize());
                }
            }
            else
            {
                Font retFont = FontChooser.showDialog(this,"Font Chooser", new Font("Arial", 0, 12));
                if(retFont!=null)
                {
                    msgfont = retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize());
                }
            }
        }
        else
        {
                Font retFont = FontChooser.showDialog(this,"Font Chooser", new Font("Arial", 0, 12));
                if(retFont!=null)
                {
                    msgfont = retFont.getName() + "," + String.valueOf(retFont.getStyle()) + "," + String.valueOf(retFont.getSize());
                }
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }//GEN-LAST:event_FontButtonActionPerformed

    private void FontColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FontColorButtonActionPerformed
 	// Bring up a color chooser 
        if(msgfontclr!=null)
        {
            if(msgfontclr.equalsIgnoreCase("")==false)
            {
                Object[] tmpArray = getStringArraysFromString(msgfontclr);
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(new Integer((String)tmpArray[0]).intValue(), new Integer((String)tmpArray[1]).intValue(),new Integer((String)tmpArray[2]).intValue())); 
                if(c!=null)
                {
                    msgfontclr = String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue());
                    cbDefaultTextColor.setSelected(false);
                }
            }
            else
            {
                Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
                if(c!=null)
                {
                    msgfontclr = String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue());                
                    cbDefaultTextColor.setSelected(false);
                }
            }
        }
        else
        {
            Color c = JLocalColorChooser.showDialog(this,"Color Chooser",new java.awt.Color(255,255,255)); 
            if(c!=null)
            {
                msgfontclr = String.valueOf(c.getRed()) + "," + String.valueOf(c.getGreen()) + "," + String.valueOf(c.getBlue());                
                cbDefaultTextColor.setSelected(false);
            }
        }
    }//GEN-LAST:event_FontColorButtonActionPerformed
    
    private LanguagePanel getCurrentLanguagePanel()
    {
        try
        {
            LanguagePanel theLangPanel = (LanguagePanel)tpLanguageTabs.getSelectedComponent();
            if(theLangPanel!=null)
            {
                return theLangPanel;
            }
            else
            {
                return theLangPanelArray[0];
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return theLangPanelArray[0];
    }
    
    private void MessagePreviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MessagePreviewButtonActionPerformed
    try
    {
        LanguagePanel theLangPanel = getCurrentLanguagePanel();
        char theChar = ' ';
        if(theLangPanel.getMessageOKMnemonic().equalsIgnoreCase("")==false)
        {
            theChar = theLangPanel.getMessageOKMnemonic().charAt(0);
        }
       
        new UpdateDesignerPreviewAction(msgType, theLangPanel.getMessageTitle(), theLangPanel.getMessage(), msgsupport, msgerror, msgfont, msgfontclr, msgbtnfont, msgbtnfontclr, theLangPanel.getMessageOKText(), theChar, msgskipbtn, msgskipbtnmnem, msgtextalgn);
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    }//GEN-LAST:event_MessagePreviewButtonActionPerformed

    private void rbLongMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbLongMessageActionPerformed
        rbShortMessage.setSelected(false);
        rbLongMessage.setSelected(true);  
        msgType = 1;
    }//GEN-LAST:event_rbLongMessageActionPerformed

    private void rbShortMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbShortMessageActionPerformed
        rbShortMessage.setSelected(true);
        rbLongMessage.setSelected(false);
        msgType = 0;                
    }//GEN-LAST:event_rbShortMessageActionPerformed
    
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        setVisible(false);
        dispose();
    }//GEN-LAST:event_exitForm

    private int compileLocalizedRootMessage(File MessageOutputDir)
    {
       try
       {
/////////////////////////Build Root Message///////////////////////////
            try
            {
                if(MessageOutputDir.exists()==false)
                {
                        if(MessageOutputDir.mkdirs()==false)
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
            EAProperties eaProps = new EAProperties();           
            // Add vars below 

            eaProps.put("#","#" + ProjectManager.get("update_file_name") + " EvaluateAnywhere Automatic Software Update 1.0 - Copyright 2004-2005, Trinity Software, LLC. All rights reserved.");            
            eaProps.put("locale", "true");
            if(rbUseDefaultLocales.isSelected()==true)
            {
                eaProps.put("delnalocale", "true");
            }
            else if(rbOnlySelectedLanguages.isSelected()==true)
            {
                 eaProps.put("delnalocale", "false");               
            }
            
            String[] msgFileArray = {};
            String[] msgURLArray = {};            
            if(ProjectManager.get("project_default_update_langs")!=null)
            {
               if(ProjectManager.get("project_default_update_langs").equalsIgnoreCase("")==false)
               {
                    Object[] msgLangsArray = getStringArraysFromString(ProjectManager.get("project_default_update_langs"));
                    msgFileArray = new String[msgLangsArray.length + 1];
                    msgURLArray = new String[msgLangsArray.length + 1];   
                    msgFileArray[0] = ProjectManager.get("update_file_name");
                    msgURLArray[0] = ((String)cbURLAddressBar.getSelectedItem());
                    boolean isENAvailable = false;
                    for(int i = 0;i<msgLangsArray.length;i++)
                    {
                        if(((String)msgLangsArray[i]).equalsIgnoreCase("en")==true)
                        {
                            isENAvailable = true;
                        }
                    }
                    // Set the Default Language
                    if(isENAvailable==true)
                    {
                        //System.out.println("Default English URL:" + ((String)cbURLAddressBar.getSelectedItem()).substring(0,((String)cbURLAddressBar.getSelectedItem()).lastIndexOf("/")) + "/" + ProjectManager.get("update_file_name").substring(0,ProjectManager.get("update_file_name").lastIndexOf(".")) + "_" + "en" + ".eal");
                        eaProps.put("msg",((String)cbURLAddressBar.getSelectedItem()).substring(0,((String)cbURLAddressBar.getSelectedItem()).lastIndexOf("/")) + "/" + getLocaleMessageFileName("en"));
                    }
                    else
                    {
                        //System.out.println("Default " +  ((String)msgLangsArray[0]) + " Locale URL:" + ((String)cbURLAddressBar.getSelectedItem()).substring(0,((String)cbURLAddressBar.getSelectedItem()).lastIndexOf("/")) + "/" + ProjectManager.get("update_file_name").substring(0,ProjectManager.get("update_file_name").lastIndexOf(".")) + "_" + ((String)msgLangsArray[0]) + ".eal");
                        eaProps.put("msg",((String)cbURLAddressBar.getSelectedItem()).substring(0,((String)cbURLAddressBar.getSelectedItem()).lastIndexOf("/")) + "/" + getLocaleMessageFileName(((String)msgLangsArray[0])));                        
                    }
                    
                    // Set all other languages
                    for(int i = 0;i<msgLangsArray.length;i++)
                    {
                       //System.out.println(((String)msgLangsArray[i]) + " Locale URL:" + ((String)cbURLAddressBar.getSelectedItem()).substring(0,((String)cbURLAddressBar.getSelectedItem()).lastIndexOf("/")) + "/" + ProjectManager.get("update_file_name").substring(0,ProjectManager.get("update_file_name").lastIndexOf(".")) + "_" + ((String)msgLangsArray[i]) + ".eal");
                       eaProps.put("msg_" + ((String)msgLangsArray[i]),((String)cbURLAddressBar.getSelectedItem()).substring(0,((String)cbURLAddressBar.getSelectedItem()).lastIndexOf("/")) + "/" + getLocaleMessageFileName(((String)msgLangsArray[i])));                        
                       msgFileArray[i + 1] = getLocaleMessageFileName(((String)msgLangsArray[i]));
                       msgURLArray[i + 1] = ((String)cbURLAddressBar.getSelectedItem()).substring(0,((String)cbURLAddressBar.getSelectedItem()).lastIndexOf("/")) + "/" + getLocaleMessageFileName(((String)msgLangsArray[i]));
                    }                    
               }
            } 
            
            // End Add vars
            Object[] resultArray = EncryptedUpdateBuilder.encryptAndWriteMessageFileToByteArray(eaProps);
            if(((Boolean)resultArray[0]).booleanValue()==true)
            {
                ArrayList theTempList1 = new ArrayList();
                ArrayList theTempZipEntryList = new ArrayList();    
                theTempList1.add(((byte[])resultArray[1]));
                theTempZipEntryList.add(getMessageFileName());                    
                theTempList1.trimToSize();
                theTempZipEntryList.trimToSize();
                Object[] theObjectList = theTempZipEntryList.toArray();
                String[] theStringList = new String[theObjectList.length];     
                for(int i = 0;i<theObjectList.length;i++)
                {
                    theStringList[i] = (String)theObjectList[i];
                }      
                ManifestBuilder.getMakeDefaultManifest(ZipBuilder.compress(new File(new URL(ProjectManager.get("update_build_dir") + getMessageFileName()).getFile()), theStringList, theTempList1));
                try
                {
                    UpdateDocBuilder.buildMultiLangMessageREADMEHTMLFile(new File(new URL(ProjectManager.get("update_build_dir") + "README.html").getFile()), String.valueOf(msgIDNumber), msgFileArray, msgURLArray, getStringArraysFromString(copyfilesto), getStringArraysFromString(files), getStringArraysFromString(overwriteexistingfiles));
                }
                catch(Exception e)
                {
                    
                }
                return 0;
            }
            else
            {
                return 1;
            }           
/////////////////////////End Build Root Message///////////////////////////           
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       return 1;
    }

    private synchronized String getMessageFileName()
    {
        try
        {
            if(ProjectManager.get("update_file_name")!=null)
            {
                if(ProjectManager.get("update_file_name").equalsIgnoreCase("")==false)
                { 
                    return ProjectManager.get("update_file_name");
                }
                else
                {
                    return "update.eal";                    
                }
            }
            else
            {
                return "update.eal";                 
            }
        }
        catch(Exception e)
        {
            return "update.eal";
        }
    }    
    
    private synchronized String getLocaleMessageFileName(String locale)
    {
        try
        {
            if(ProjectManager.get("update_file_name")!=null)
            {
                if(ProjectManager.get("update_file_name").equalsIgnoreCase("")==false)
                {             
                    if(ProjectManager.get("update_file_name").lastIndexOf(".")!=-1)
                    {
                        return ProjectManager.get("update_file_name").substring(0,ProjectManager.get("update_file_name").lastIndexOf(".")) + "_" + locale + ProjectManager.get("update_file_name").substring(ProjectManager.get("update_file_name").lastIndexOf("."));                 
                    }
                    else
                    {
                        return ProjectManager.get("update_file_name").substring(0,(ProjectManager.get("update_file_name").length())) + "_" + locale;            
                    }         
                }
                else 
                {
                    return "update_" + locale + ".eal";
                }
            }
            else
            {
                return "update_" + locale + ".eal";
            }
        }
        catch(Exception e)
        {
            return "update_" + locale + ".eal";
        }
    }
    
    private int compileLocalizedMessages(File MessageOutputDir)
    {
        
       int result = 0;
       try
       {
/////////////////////////Build Localized Messages///////////////////////////
            try
            {
                if(MessageOutputDir.exists()==false)
                {
                        if(MessageOutputDir.mkdirs()==false)
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
            if(ProjectManager.get("project_default_update_langs")!=null)
            {
               if(ProjectManager.get("project_default_update_langs").equalsIgnoreCase("")==false)
               {
                    Object[] msgLangsArray = getStringArraysFromString(ProjectManager.get("project_default_update_langs"));
                    for(int i = 0;i<theLangPanelArray.length;i++)
                    {           
                        String currentLang = theLangPanelArray[i].getLanguage();
                        EAProperties eaProps = new EAProperties();           
                        // Add vars below 
                        eaProps.put("#","#" + ProjectManager.get("update_file_name").substring(0,ProjectManager.get("update_file_name").lastIndexOf(".")) + "_" + currentLang + ".eal" + " EvaluateAnywhere Messaging 1.0 - Copyright 2004, Trinity Software, LLC. All rights reserved.");            
                        eaProps.put("updateid", String.valueOf(msgIDNumber));
                        eaProps.put("type", String.valueOf(msgType));
                        eaProps.put("baseurlchange", String.valueOf(baseurlchange));
                        eaProps.put("msgtitle", theLangPanelArray[i].getMessageTitle());
                        eaProps.put("msgtext", theLangPanelArray[i].getMessage());
                        eaProps.put("msgfont", msgfont);
                        eaProps.put("msgbtnfont", msgbtnfont);
                        eaProps.put("msgfontclr", msgfontclr);
                        eaProps.put("msgbtnfontclr", msgbtnfontclr);
                        eaProps.put("msgokbtn", theLangPanelArray[i].getMessageOKText());
                        eaProps.put("msgokbtnmnem", theLangPanelArray[i].getMessageOKMnemonic());
                        eaProps.put("msgskipbtn", theLangPanelArray[0].getMessageSkipText());
                        eaProps.put("msgskipbtnmnem", theLangPanelArray[0].getMessageSkipMnemonic());                    
                        eaProps.put("msgtextalgn", String.valueOf(msgtextalgn));
                        eaProps.put("msgsupport", theLangPanelArray[0].getSupportMessage());
                        eaProps.put("msgerror", theLangPanelArray[0].getErrorMessage());  
                        // update vars
                        eaProps.put("msgmaxattempts", msgmaxattempts);
                        eaProps.put("silent", silent);
                        eaProps.put("lazyUpdate", lazyUpdate);
                        eaProps.put("copyfilesto", copyfilesto);
                        eaProps.put("files", files);
                        eaProps.put("overwriteexistingfiles", overwriteexistingfiles);
                        try
                        {
                            long tmpCde = RandomNumberGenerator.getRandomLong();
                            if(9999<tmpCde)
                            {
                                eaProps.put("validationCode", String.valueOf(tmpCde));   
                            }
                            else
                            {
                                eaProps.put("validationCode", String.valueOf(tmpCde + 48610));                       
                            }
                        }
                        catch(Exception e){}

                            // End Add vars
                         /*   if(EncryptedUpdateBuilder.encryptAndWriteMessageFile(new File(new URL(ProjectManager.get("update_build_dir") + ProjectManager.get("update_file_name").substring(0,ProjectManager.get("update_file_name").lastIndexOf(".")) + "_" + currentLang + ".eal").getFile()), eaProps)==true)
                            {
                                // return 0
                            }
                            else
                            {
                               result = 1;
                            } 
                          */
            // End Add vars
                            Object[] resultArray = EncryptedUpdateBuilder.encryptAndWriteMessageFileToByteArray(eaProps);
                            if(((Boolean)resultArray[0]).booleanValue()==true)
                            {
                                ArrayList theTempList1 = new ArrayList();
                                ArrayList theTempZipEntryList = new ArrayList();    
                                theTempList1.add(((byte[])resultArray[1]));
                                theTempZipEntryList.add(getMessageFileName());                    
                                theTempList1.trimToSize();
                                theTempZipEntryList.trimToSize();
                                Object[] theObjectList = theTempZipEntryList.toArray();
                                String[] theStringList = new String[theObjectList.length];     
                                for(int j = 0;j<theObjectList.length;j++)
                                {
                                    theStringList[j] = (String)theObjectList[j];
                                }      
                                ManifestBuilder.getMakeDefaultManifest(ZipBuilder.compress(new File(new URL(ProjectManager.get("update_build_dir") + getLocaleMessageFileName(currentLang)).getFile()), theStringList, theTempList1));
                            }
                            else
                            {
                               result = 1;
                            }                         
                        }
               }
            }
            // Message ID Build ID Number Update
            SpinnerNumberModel sm2 = (SpinnerNumberModel)spinMessageID.getModel();
            Integer msgIDNumber2 = new Integer(msgIDNumber); 
            msgIDNumber = sm2.getNumber().intValue();  
            if(msgIDNumber2.intValue()==msgIDNumber)
            {
                ProjectManager.saveSinglePut("project_lastUpdateIDNumber", String.valueOf(Integer.valueOf(ProjectManager.get("project_lastUpdateIDNumber")).intValue() + 1));
                msgIDNumber = Integer.valueOf(ProjectManager.get("project_lastUpdateIDNumber")).intValue();
                spinMessageID.setModel(new SpinnerNumberModel(new Integer(msgIDNumber),new Integer(0),new Integer(999999999),new Integer(1)));                       
            }
            else
            {
                msgIDNumber = Integer.valueOf(ProjectManager.get("project_lastUpdateIDNumber")).intValue();
                spinMessageID.setModel(new SpinnerNumberModel(new Integer(msgIDNumber),new Integer(0),new Integer(999999999),new Integer(1)));                       
            }   
/////////////////////////End Build Root Message///////////////////////////           
       }
       catch(Exception e)
       {
           result = 1;
           e.printStackTrace();
       }
       return result;
    }    
    
    private boolean getCleanupMessageBuildDir(File MessageOutputDir)
    {
        try
        {
            File[] returnedFiles = MessageOutputDir.listFiles(new EALFileFilter());
            boolean result = true;
            if(returnedFiles!=null)
            {
                for(int i = 0;i<returnedFiles.length;i++)
                {
                    try 
                    {
                        returnedFiles[i].delete();
                    }
                    catch(Exception e)
                    {
                        result = false;
                    }
                }
            }
            return result;
        }
        catch(Exception e)
        {
        }
        return false;
    }
    
    public int compileMessage(File MessageOutputDir)
    {
        try 
        {
            if(ProjectManager.get("project_default_update_langs")!=null)
            {
               if(ProjectManager.get("project_default_update_langs").equalsIgnoreCase("")==false)
               {            
                   Object[] tempLangArray = getStringArraysFromString(ProjectManager.get("project_default_update_langs"));
                   if(tempLangArray.length==1 && rbUseDefaultLocales.isSelected()==true)
                   {}
                   else
                   {                    
                        if(cbURLAddressBar.getSelectedItem()!=null)
                        {
                            if(((String)cbURLAddressBar.getSelectedItem()).equalsIgnoreCase("")==true ||((String)cbURLAddressBar.getSelectedItem()).equalsIgnoreCase("http://")==true)
                            {                
                                return 19;
                            }
                            else
                            {
                                try 
                                {
                                    new URL(((String)cbURLAddressBar.getSelectedItem()));
                                }
                                catch(MalformedURLException e)
                                {
                                    return 19;
                                }
                            }
                        }
                        else
                        {
                            return 19;
                        }    
                   }
                }
            }
            if(getCleanupMessageBuildDir(MessageOutputDir)==false)
            {
                return 18;
            }
            // msgBuildType 0 Application to User Message
            if(msgBuildType==0)
            {
                if(copyfilesto.equalsIgnoreCase("")==true)
                {
                    return 20;
                }
               if(ProjectManager.get("project_default_update_langs")!=null)
               {
                   Object[] tempLangArray = getStringArraysFromString(ProjectManager.get("project_default_update_langs"));
                   if(ProjectManager.get("project_default_update_langs").equalsIgnoreCase("")==true || (rbUseDefaultLocales.isSelected()==true && tempLangArray.length==1))
                   {
                    try
                    {
                        if(MessageOutputDir.exists()==false)
                        {
                                if(MessageOutputDir.mkdirs()==false)
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
                    EAProperties eaProps = new EAProperties();           
                    // Add vars below 
                    eaProps.put("#","#" + ProjectManager.get("update_file_name") + " EvaluateAnywhere Automatic Software Update 1.0 - Copyright 2004-2005, Trinity Software, LLC. All rights reserved.");            
                    try
                    {
                        long tmpCde = RandomNumberGenerator.getRandomLong();
                        if(9999<tmpCde)
                        {
                            eaProps.put("validationCode", String.valueOf(tmpCde));   
                        }
                        else
                        {
                            eaProps.put("validationCode", String.valueOf(tmpCde + 87683));                       
                        }
                    }
                    catch(Exception e){}
                    eaProps.put("updateid", String.valueOf(msgIDNumber));
                    eaProps.put("type", String.valueOf(msgType));
                    eaProps.put("baseurlchange", String.valueOf(baseurlchange));
                    eaProps.put("msgtitle", theLangPanelArray[0].getMessageTitle());
                    eaProps.put("msgtext", theLangPanelArray[0].getMessage());
                    eaProps.put("msgfont", msgfont);
                    eaProps.put("msgbtnfont", msgbtnfont);
                    eaProps.put("msgfontclr", msgfontclr);
                    eaProps.put("msgbtnfontclr", msgbtnfontclr);
                    eaProps.put("msgokbtn", theLangPanelArray[0].getMessageOKText());
                    eaProps.put("msgokbtnmnem", theLangPanelArray[0].getMessageOKMnemonic());
                    eaProps.put("msgskipbtn", theLangPanelArray[0].getMessageSkipText());
                    eaProps.put("msgskipbtnmnem", theLangPanelArray[0].getMessageSkipMnemonic());                    
                    eaProps.put("msgtextalgn", String.valueOf(msgtextalgn));
                    eaProps.put("msgsupport", theLangPanelArray[0].getSupportMessage());
                    eaProps.put("msgerror", theLangPanelArray[0].getErrorMessage());  
                    // update vars
                    eaProps.put("msgmaxattempts", msgmaxattempts);
                    eaProps.put("silent", silent);
                    eaProps.put("lazyUpdate", lazyUpdate);
                    eaProps.put("copyfilesto", copyfilesto);
                    eaProps.put("files", files);
                    eaProps.put("overwriteexistingfiles", overwriteexistingfiles);
                    
                    // End Add vars
                    //if(EncryptedUpdateBuilder.encryptAndWriteMessageFile(new File(new URL(ProjectManager.get("update_build_dir") + ProjectManager.get("update_file_name")).getFile()), eaProps)==true)
                    //{
////////////////
                    Object[] resultArray = EncryptedUpdateBuilder.encryptAndWriteMessageFileToByteArray(eaProps);
                    if(((Boolean)resultArray[0]).booleanValue()==true)
                    {
                        try
                        {
                            ArrayList theTempList1 = new ArrayList();
                            ArrayList theTempZipEntryList = new ArrayList();    
                            theTempList1.add(((byte[])resultArray[1]));
                            theTempZipEntryList.add(getMessageFileName());                    
                            theTempList1.trimToSize();
                            theTempZipEntryList.trimToSize();
                            Object[] theObjectList = theTempZipEntryList.toArray();
                            String[] theStringList = new String[theObjectList.length];     
                            for(int i = 0;i<theObjectList.length;i++)
                            {
                                theStringList[i] = (String)theObjectList[i];
                            }      
                            ManifestBuilder.getMakeDefaultManifest(ZipBuilder.compress(new File(new URL(ProjectManager.get("update_build_dir") + getMessageFileName()).getFile()), theStringList, theTempList1));
                        }
                        catch(Exception e)
                        {
                            return 1;
                        }
////////////////                    
                        // Message ID Build ID Number Update
                        SpinnerNumberModel sm2 = (SpinnerNumberModel)spinMessageID.getModel();
                        Integer msgIDNumber2 = new Integer(msgIDNumber); 
                        msgIDNumber = sm2.getNumber().intValue();  
                        if(msgIDNumber2.intValue()==msgIDNumber)
                        {
                            ProjectManager.saveSinglePut("project_lastUpdateIDNumber", String.valueOf(Integer.valueOf(ProjectManager.get("project_lastUpdateIDNumber")).intValue() + 1));
                            msgIDNumber = Integer.valueOf(ProjectManager.get("project_lastUpdateIDNumber")).intValue();
                            spinMessageID.setModel(new SpinnerNumberModel(new Integer(msgIDNumber),new Integer(0),new Integer(999999999),new Integer(1)));                       
                        }
                        else
                        {
                            msgIDNumber = Integer.valueOf(ProjectManager.get("project_lastUpdateIDNumber")).intValue();
                            spinMessageID.setModel(new SpinnerNumberModel(new Integer(msgIDNumber),new Integer(0),new Integer(999999999),new Integer(1)));                       
                        }   
                        try
                        {
                            UpdateDocBuilder.buildUniversalMessageREADMEHTMLFile(new File(new URL(ProjectManager.get("update_build_dir") + "README.html").getFile()), String.valueOf(msgIDNumber), ProjectManager.get("update_file_name"), getUpdateDownloadURLs(), getStringArraysFromString(copyfilesto), getStringArraysFromString(files), getStringArraysFromString(overwriteexistingfiles));
                        }
                        catch(Exception e)
                        {

                        }                        
                        return 0;
                    }
                    else
                    {
                        return 1;
                    }
                   }
                   else
                   {
                       // Compile localized message
                        if(compileLocalizedRootMessage(MessageOutputDir)==0)
                        {
                            return compileLocalizedMessages(MessageOutputDir);
                        }
                        else
                        {
                            return 1;
                        }
                   }
               }
               else
               {
                   // Compile localized message
                    if(compileLocalizedRootMessage(MessageOutputDir)==0)
                    {
                        return compileLocalizedMessages(MessageOutputDir);
                    }
                    else
                    {
                        return 1;
                    }            
               }
            }
            // msgBuildType 1 is a URL Change Message
            else if(msgBuildType==1)
            {
                try
                {
                    if(MessageOutputDir.exists()==false)
                    {
                            if(MessageOutputDir.mkdirs()==false)
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
                    if(getStringFromArray(baseURLChangePanel.getBaseURLArray()).equalsIgnoreCase("")==true)
                    {
                        return 21;
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                    return 7;
                }
                EAProperties eaProps = new EAProperties();           
                // Add vars below 
                eaProps.put("#","#" + ProjectManager.get("update_file_name") + " EvaluateAnywhere Automatic Software Update 1.0 - Copyright 2004-2005, Trinity Software, LLC. All rights reserved.");            
                try
                {
                    long tmpCde = RandomNumberGenerator.getRandomLong();
                    if(9999<tmpCde)
                    {
                        eaProps.put("validationCode", String.valueOf(tmpCde));   
                    }
                    else
                    {
                        eaProps.put("validationCode", String.valueOf(tmpCde + 87683));                       
                    }
                }
                catch(Exception e){}
                try
                {
                    SpinnerNumberModel sm2 = (SpinnerNumberModel)spinMessageID.getModel();
                    Integer msgIDNumber2 = new Integer(msgIDNumber); 
                    msgIDNumber = sm2.getNumber().intValue();  
                    eaProps.put("updateid", String.valueOf(msgIDNumber));
                }
                catch(Exception e)
                {
                  
                }
                eaProps.put("baseurlchange", String.valueOf(baseurlchange));   
                try
                {
                    eaProps.put("baseurlupdates", getStringFromArray(baseURLChangePanel.getBaseURLArray()));
                }
                catch(Exception e){}
                
                // End Add vars
 //               if(EncryptedUpdateBuilder.encryptAndWriteMessageFile(new File(new URL(ProjectManager.get("update_build_dir") + ProjectManager.get("update_file_name")).getFile()), eaProps)==true)
 //               {
                Object[] resultArray = EncryptedUpdateBuilder.encryptAndWriteMessageFileToByteArray(eaProps);
                if(((Boolean)resultArray[0]).booleanValue()==true)
                { 
                    try
                    {
                        ArrayList theTempList1 = new ArrayList();
                        ArrayList theTempZipEntryList = new ArrayList();    
                        theTempList1.add(((byte[])resultArray[1]));
                        theTempZipEntryList.add(getMessageFileName());                    
                        theTempList1.trimToSize();
                        theTempZipEntryList.trimToSize();
                        Object[] theObjectList = theTempZipEntryList.toArray();
                        String[] theStringList = new String[theObjectList.length];     
                        for(int i = 0;i<theObjectList.length;i++)
                        {
                            theStringList[i] = (String)theObjectList[i];
                        }      
                        ManifestBuilder.getMakeDefaultManifest(ZipBuilder.compress(new File(new URL(ProjectManager.get("update_build_dir") + getMessageFileName()).getFile()), theStringList, theTempList1));
                    }
                    catch(Exception e)
                    {
                        return 1;
                    } 
                
                // Message ID Build ID Number Update
                    SpinnerNumberModel sm2 = (SpinnerNumberModel)spinMessageID.getModel();
                    Integer msgIDNumber2 = new Integer(msgIDNumber); 
                    msgIDNumber = sm2.getNumber().intValue();  
                    if(msgIDNumber2.intValue()==msgIDNumber)
                    {
                        ProjectManager.saveSinglePut("project_lastUpdateIDNumber", String.valueOf(Integer.valueOf(ProjectManager.get("project_lastUpdateIDNumber")).intValue() + 1));
                        msgIDNumber = Integer.valueOf(ProjectManager.get("project_lastUpdateIDNumber")).intValue();
                        spinMessageID.setModel(new SpinnerNumberModel(new Integer(msgIDNumber),new Integer(0),new Integer(999999999),new Integer(1)));                       
                    }
                    else
                    {
                        msgIDNumber = Integer.valueOf(ProjectManager.get("project_lastUpdateIDNumber")).intValue();
                        spinMessageID.setModel(new SpinnerNumberModel(new Integer(msgIDNumber),new Integer(0),new Integer(999999999),new Integer(1)));                       
                    }                    
                    try
                    {
                        UpdateDocBuilder.buildChangeURLMessageREADMEHTMLFile(new File(new URL(ProjectManager.get("update_build_dir") + "README.html").getFile()), String.valueOf(msgIDNumber), ProjectManager.get("update_file_name"), getUpdateDownloadURLs());
                    }
                    catch(Exception e)
                    {

                    }      
                    return 0;
                }
                else
                {
                    return 1;
                }
            
            }

        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
        return 2;
    }

    private String[] getUpdateDownloadURLs()
    {
        try
        {
            int maxURLs = Integer.valueOf(ProjectManager.get("autoUpdateMaxBaseURLs")).intValue();
            int intAltURL = 0;
            for(int i = 1;i<maxURLs;i++)
            {
                if(ProjectManager.get("autoUpdateAlternateURL" + String.valueOf(i))!=null)
                {
                    if(ProjectManager.get("autoUpdateAlternateURL" + String.valueOf(i)).equalsIgnoreCase("")==false)
                    {                        
                        intAltURL++;
                    }
                }	
                else
                {
                    i=maxURLs;
                }
             }            
                String[] strURLArray = new String[intAltURL + 1];               
                if(ProjectManager.get("autoUpdateBaseURL")!=null)
                {
                    if(ProjectManager.get("autoUpdateBaseURL").equalsIgnoreCase("")==false)
                    {                    
                        strURLArray[0] = ProjectManager.get("autoUpdateBaseURL");
                    }
                    else
                    {
                        strURLArray[0] = "";                      
                    }
                }
                else
                {
                    strURLArray[0] = "";                   
                }
                
                for(int i = 1;i<maxURLs;i++)
                {
                    if(ProjectManager.get("autoUpdateAlternateURL" + String.valueOf(i))!=null)
                    {
                        if(ProjectManager.get("autoUpdateAlternateURL" + String.valueOf(i)).equalsIgnoreCase("")==false)
                        {                        
                            strURLArray[i] = ProjectManager.get("autoUpdateAlternateURL" + String.valueOf(i));
                        }
                    }	
                    else
                    {
                        i=maxURLs;
                    }
                 }                
                return strURLArray;
        }
        catch(Exception e)
        {
            
        }
        return new String[0];
    }
    private void getPopulateUpdateDownloadURLs()
    {
        try
        { 
            if(msgBuildType==0)
            {
                if(ProjectManager.get("project_default_update_langs")!=null)
                {            
                    if(ProjectManager.get("project_default_update_langs").equalsIgnoreCase("")==false)
                    {
                        if(ProjectManager.get("project_default_update_langs").indexOf(",")==-1 && rbUseDefaultLocales.isSelected()==true)
                        {
                            cbURLAddressBar.setEnabled(false);
                        }
                        else
                        {
                             cbURLAddressBar.setEnabled(true);                       
                        }
                    }
                    else
                    {
                         cbURLAddressBar.setEnabled(false);                    
                    }
                }
                else
                {
                     cbURLAddressBar.setEnabled(false);               
                }
            }
            try
            {
                int maxURLs = Integer.valueOf(ProjectManager.get("autoUpdateMaxBaseURLs")).intValue();
                int intAltURL = 0;
                for(int i = 1;i<maxURLs;i++)
                {
                    if(ProjectManager.get("autoUpdateAlternateURL" + String.valueOf(i))!=null)
                    {
                        if(ProjectManager.get("autoUpdateAlternateURL" + String.valueOf(i)).equalsIgnoreCase("")==false)
                        {                        
                            intAltURL++;
                        }
                    }	
                    else
                    {
                        i=maxURLs;
                    }
                 }
                
                String[] strURLArray = new String[intAltURL + 1];               
                if(ProjectManager.get("autoUpdateBaseURL")!=null)
                {
                    if(ProjectManager.get("autoUpdateBaseURL").equalsIgnoreCase("")==false)
                    {                    
                        strURLArray[0] = ProjectManager.get("autoUpdateBaseURL");
                    }
                    else
                    {
                        strURLArray[0] = "";                      
                    }
                }
                else
                {
                    strURLArray[0] = "";                   
                }
                
                for(int i = 1;i<maxURLs;i++)
                {
                    if(ProjectManager.get("autoUpdateAlternateURL" + String.valueOf(i))!=null)
                    {
                        if(ProjectManager.get("autoUpdateAlternateURL" + String.valueOf(i)).equalsIgnoreCase("")==false)
                        {                        
                            strURLArray[i] = ProjectManager.get("autoUpdateAlternateURL" + String.valueOf(i));
                        }
                    }	
                    else
                    {
                        i=maxURLs;
                    }
                 }                
                cbURLAddressBar.setModel(new javax.swing.DefaultComboBoxModel(strURLArray));
            }
            catch(Exception e)
            {
                    e.printStackTrace();
            }           
        }
        catch(Exception e)
        {
            
        }
    }
    
    private String getStringFromArray(Object[] theArray)
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

    /** Set the message filename. */
    public static void setFileName(String strFileName)
    {
        strMessageFileName = strFileName;
    }
    
    /** Return the Message File filename. Default Message filename is MessagesBundle.properties */
    public static String getFileName()
    {
        return strMessageFileName;
    }
    
    private static Object[] getStringArraysFromString(String textArrayString)
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
    
  private JPanel TheContentPanelReference = new JPanel();
  private void setContentPanel(JPanel theContentPanel)
  {
    try
    {
	TheContentPanelReference.setVisible(false);
        //ContentPanel.remove(TheContentPanelReference);   
        ContentPanel.removeAll();
        TheContentPanelReference = theContentPanel;
        ContentPanel.add(TheContentPanelReference,java.awt.BorderLayout.CENTER);     
        TheContentPanelReference.setVisible(true);
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
  }
    
  private JPanel TheEastContentPanelReference = new JPanel();
  private void setEastContentPanel(JPanel theContentPanel)
  {
    try
    {
	TheEastContentPanelReference.setVisible(false);
        //ContentPanel.remove(TheContentPanelReference);   
        MainEastContentPanel.removeAll();
        TheEastContentPanelReference = theContentPanel;
        MainEastContentPanel.add(TheEastContentPanelReference,java.awt.BorderLayout.CENTER);     
        TheEastContentPanelReference.setVisible(true);
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
  }
  private JPanel TheSouthContentPanelReference = new JPanel();
  private void setSouthContentPanel(JPanel theContentPanel)
  {
    try
    {
	TheSouthContentPanelReference.setVisible(false);
        //ContentPanel.remove(TheContentPanelReference);   
        MainSouthContentPanel.removeAll();
        TheSouthContentPanelReference = theContentPanel;
        MainSouthContentPanel.add(TheSouthContentPanelReference,java.awt.BorderLayout.CENTER);     
        TheSouthContentPanelReference.setVisible(true);
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
  }
  
    private void setMessageGUI()
    {
        try 
        {
            setSize(864,609);
            RootPanel.setPreferredSize(new java.awt.Dimension(860, 500));           
            //set to your main Panel bg color
            uid.put("TabbedPane.tabAreaInsets", new InsetsUIResource(1, 1, 1, 1));
            uid.put("TabbedPane.contentBorderInsets", new InsetsUIResource(1, 1, 1, 1));
            uid.put("TabbedPane.selectedTabPadInsets", new InsetsUIResource(2, 2, 2, 2));
            uid.put("TabbedPane.selectHighlight", new ColorUIResource(Color.white));
            UIManager.put("TabbedPane.tabAreaBackground", new java.awt.Color(200, 221, 242));
            UIManager.put("TabbedPane.background", new java.awt.Color(200, 221, 242));
            UIManager.put("TabbedPane.foreground", new ColorUIResource(Color.black));
            UIManager.put("TabbedPane.selected", new java.awt.Color(200, 221, 242));
            UIManager.put("TabbedPane.border", new BorderUIResource(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0)));
           
            HashMap theLangPanelsHashMap = null;
            try
            {
               if(ProjectManager.get("project_default_update_langs")!=null)
            {
                    if(ProjectManager.get("project_default_update_langs").equalsIgnoreCase("")==false)
                    {             
                        if(0<theLangPanelArray.length)
                        {
                            theLangPanelsHashMap = new HashMap(theLangPanelArray.length);                   
                            for(int i = 0;i<theLangPanelArray.length;i++)
                            {
                               if(theLangPanelArray[i]!=null)
                               { 
                                    theLangPanelsHashMap.put(theLangPanelArray[i].getLanguage(),theLangPanelArray[i]); 
                               }
                            }
                        }
                        else
                        {
                            theLangPanelArray = null;
                        }
                    }
                    else
                    {
                        theLangPanelsHashMap = null;
                        theLangPanelArray = null;
                    }
               }
               else
               {
                    theLangPanelsHashMap = null;
                    theLangPanelArray = null;                   
               }
            }
            catch(Exception e)
            {}
            msgBuildType = 0;
            MessagePanel.removeAll();
            tpLanguageTabs = new javax.swing.JTabbedPane();
            tpLanguageTabs.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
            tpLanguageTabs.setFont(new java.awt.Font("Arial", 0, 12));
            tpLanguageTabs.setMinimumSize(new java.awt.Dimension(109, 168));
            tpLanguageTabs.setPreferredSize(new java.awt.Dimension(1225, 168));
            if(ProjectManager.get("project_default_update_langs")!=null)
            {
                if(ProjectManager.get("project_default_update_langs").equalsIgnoreCase("")==false)
                {
                    //System.out.println("Multiple Languages");
                    String languageNames2 = getLanguageNamesFromLanguageAbbreviations(ProjectManager.get("project_default_update_langs"));                  
                    Object[] languageNames3 = getStringArraysFromString(languageNames2);
                    Object[] langObjArray = getStringArraysFromString(ProjectManager.get("project_default_update_langs"));
                    theLangPanelArray = new LanguagePanel[langObjArray.length];
                    for(int i = 0;i<langObjArray.length;i++)
                    {
                        try
                        {
                            if(theLangPanelsHashMap!=null)
                            {
                                if(theLangPanelsHashMap.get(((String)langObjArray[i]))!=null)
                                {
                                   theLangPanelArray[i] = (LanguagePanel)theLangPanelsHashMap.get(((String)langObjArray[i]));                                    
                                }
                                else
                                {
                                  LanguagePanel nextPanel = new LanguagePanel();
                                  nextPanel.setLanguage(((String)langObjArray[i]));
                                  nextPanel.setMessageTitle(msgtitle);
                                  nextPanel.setMessage(msgtext.replaceAll("\\\\r\\\\n", "\n"));
                                  nextPanel.setMessageOKText(msgokbtn);  
                                  nextPanel.setMessageOKMnemonic(String.valueOf(msgokbtnmnem));
                                  nextPanel.setMessageSkipText(msgskipbtn);  
                                  nextPanel.setMessageSkipMnemonic(String.valueOf(msgskipbtnmnem));                                  
                                  nextPanel.setSupportMessage(msgsupport);  
                                  nextPanel.setErrorMessage(msgerror);                                    
                                  theLangPanelArray[i] = nextPanel;                                    
                                }
                            }
                            else
                            {
                              LanguagePanel nextPanel = new LanguagePanel();
                              nextPanel.setLanguage(((String)langObjArray[i]));
                              nextPanel.setMessageTitle(msgtitle);
                              nextPanel.setMessage(msgtext.replaceAll("\\\\r\\\\n", "\n"));
                              nextPanel.setMessageOKText(msgokbtn);  
                              nextPanel.setMessageOKMnemonic(String.valueOf(msgokbtnmnem));
                              nextPanel.setMessageSkipText(msgskipbtn);  
                              nextPanel.setMessageSkipMnemonic(String.valueOf(msgskipbtnmnem));                                  
                              nextPanel.setSupportMessage(msgsupport);  
                              nextPanel.setErrorMessage(msgerror);                                
                              theLangPanelArray[i] = nextPanel;
                            }
                        }
                        catch(Exception e)
                        {}
                    }
                    for(int i = 0;i<theLangPanelArray.length;i++)
                    {
                          tpLanguageTabs.addTab(getLanguageNamesFromLanguageAbbreviations(theLangPanelArray[i].getLanguage()),theLangPanelArray[i]);                         
                    }
                    //
                    MessagePanel.add(tpLanguageTabs);
                    MessagePanel.add(MessageTypePanel); 
                    MessagePanel.add(BorderSeparator);
                    MessagePanel.add(MessageDeliveryPanel);
                }
                else
                {
                    //System.out.println("Default Language");                  
                    String languageNames2 = getLanguageNamesFromLanguageAbbreviations(ProjectManager.get("project_default_update_langs"));                  
                    Object[] languageNames3 = getStringArraysFromString(languageNames2);
                    Object[] langObjArray = getStringArraysFromString(ProjectManager.get("project_default_update_langs"));
                    theLangPanelArray = new LanguagePanel[1];
                    for(int i = 0;i<1;i++)
                    {
                         try
                        {
                            if(theLangPanelsHashMap!=null)
                            {
                                if(theLangPanelsHashMap.get("en")!=null)
                                {
                                   theLangPanelArray[i] = (LanguagePanel)theLangPanelsHashMap.get(((String)langObjArray[i]));                                    
                                }
                                else
                                {                       
                                  LanguagePanel nextPanel = new LanguagePanel();
                                  nextPanel.setLanguage("en");
                                  nextPanel.setMessageTitle(msgtitle);
                                  nextPanel.setMessage(msgtext.replaceAll("\\\\r\\\\n", "\n"));
                                  nextPanel.setMessageOKText(msgokbtn);  
                                  nextPanel.setMessageOKMnemonic(String.valueOf(msgokbtnmnem));
                                  nextPanel.setMessageSkipText(msgskipbtn);  
                                  nextPanel.setMessageSkipMnemonic(String.valueOf(msgskipbtnmnem));                                  
                                  nextPanel.setSupportMessage(msgsupport);  
                                  nextPanel.setErrorMessage(msgerror);                                                    
                                  theLangPanelArray[0] = nextPanel;  
                                }
                            }
                            else
                            {                       
                              LanguagePanel nextPanel = new LanguagePanel();
                              nextPanel.setLanguage("en");
                              nextPanel.setMessageTitle(msgtitle);
                              nextPanel.setMessage(msgtext.replaceAll("\\\\r\\\\n", "\n"));
                              nextPanel.setMessageOKText(msgokbtn);  
                              nextPanel.setMessageOKMnemonic(String.valueOf(msgokbtnmnem));
                              nextPanel.setMessageSkipText(msgskipbtn);  
                              nextPanel.setMessageSkipMnemonic(String.valueOf(msgskipbtnmnem));                                  
                              nextPanel.setSupportMessage(msgsupport);  
                              nextPanel.setErrorMessage(msgerror);                                                
                              theLangPanelArray[0] = nextPanel;  
                            }
                         }
                         catch(Exception e)
                         {
                             e.printStackTrace();
                         }
                    }
                    tpLanguageTabs.addTab("Default",theLangPanelArray[0]);   
                    MessagePanel.add(tpLanguageTabs);
                    MessagePanel.add(MessageTypePanel); 
                    MessagePanel.add(BorderSeparator);
                    MessagePanel.add(MessageDeliveryPanel);
                }
            }
            else
            {
                //System.out.println("Default Language");                  
                String languageNames2 = getLanguageNamesFromLanguageAbbreviations(ProjectManager.get("project_default_update_langs"));                  
                Object[] languageNames3 = getStringArraysFromString(languageNames2);
                Object[] langObjArray = getStringArraysFromString(ProjectManager.get("project_default_update_langs"));
                theLangPanelArray = new LanguagePanel[1];
                for(int i = 0;i<1;i++)
                {
                     try
                    {
                        if(theLangPanelsHashMap!=null)
                        {
                            if(theLangPanelsHashMap.get("en")!=null)
                            {
                               theLangPanelArray[i] = (LanguagePanel)theLangPanelsHashMap.get(((String)langObjArray[i]));                                    
                            }
                            else
                            {                       
                              LanguagePanel nextPanel = new LanguagePanel();
                              nextPanel.setLanguage("en");
                              nextPanel.setMessageTitle(msgtitle);
                              nextPanel.setMessage(msgtext.replaceAll("\\\\r\\\\n", "\n"));
                              nextPanel.setMessageOKText(msgokbtn);  
                              nextPanel.setMessageOKMnemonic(String.valueOf(msgokbtnmnem));
                              nextPanel.setMessageSkipText(msgskipbtn);  
                              nextPanel.setMessageSkipMnemonic(String.valueOf(msgskipbtnmnem));                                  
                              nextPanel.setSupportMessage(msgsupport);  
                              nextPanel.setErrorMessage(msgerror);                                                
                              theLangPanelArray[0] = nextPanel;  
                            }
                        }
                        else 
                        {                       
                          LanguagePanel nextPanel = new LanguagePanel();
                          nextPanel.setLanguage("en");
                          nextPanel.setMessageTitle(msgtitle);
                          nextPanel.setMessage(msgtext.replaceAll("\\\\r\\\\n", "\n"));
                          nextPanel.setMessageOKText(msgokbtn);  
                          nextPanel.setMessageOKMnemonic(String.valueOf(msgokbtnmnem));
                          nextPanel.setMessageSkipText(msgskipbtn);  
                          nextPanel.setMessageSkipMnemonic(String.valueOf(msgskipbtnmnem));                                  
                          nextPanel.setSupportMessage(msgsupport);  
                          nextPanel.setErrorMessage(msgerror);                                            
                          theLangPanelArray[0] = nextPanel;  
                        }
                     }
                     catch(Exception e)
                     {
                         e.printStackTrace();
                     }
                }
                tpLanguageTabs.addTab("Default",theLangPanelArray[0]);   
                MessagePanel.add(tpLanguageTabs);
                MessagePanel.add(MessageTypePanel); 
                MessagePanel.add(BorderSeparator);
                MessagePanel.add(MessageDeliveryPanel);
            }
            //tpLanguageTabs.remove(0);  
            MainEastContentPanel.removeAll();               
            MainEastContentPanel.setMaximumSize(new java.awt.Dimension(430, 2147483647));              
            MainEastContentPanel.setMinimumSize(new java.awt.Dimension(430, 327));
            MainEastContentPanel.setPreferredSize(new java.awt.Dimension(430, 327));    
            MainSouthContentPanel.removeAll();     
            MainSouthContentPanel.setMaximumSize(new java.awt.Dimension(0,0));              
            MainSouthContentPanel.setMinimumSize(new java.awt.Dimension(0,0));
            MainSouthContentPanel.setPreferredSize(new java.awt.Dimension(0,0));  
            MainContentPanel.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
            MainContentPanel.setMinimumSize(new java.awt.Dimension(430, 350));
            MainContentPanel.setPreferredSize(new java.awt.Dimension(430, 500));            
            //setPreferredSize(864,609);
            EastContentPanel.removeAll();            
            EastContentPanel.add(ContentPanel1, java.awt.BorderLayout.CENTER);           
            EastContentPanel.add(SouthContentPanel, java.awt.BorderLayout.SOUTH);           
            setEastContentPanel(EastContentPanel);        
            setContentPanel(MessagePanel);
            getTableUpdate();
            LeftAlignButton.setEnabled(true);
            CenterAlignButton.setEnabled(true);
            RightAlignButton.setEnabled(true); 
            FontColorButton.setEnabled(true); 
            FontButton.setEnabled(true); 
            cbDefaultTextColor.setEnabled(true); 
            cbDefaultFont.setEnabled(true);   
            MessagePreviewButton.setEnabled(true);
            getPopulateUpdateDownloadURLs();
            MessagePanel.updateUI();
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            int w = getSize().width;
            int h = getSize().height;
            int x = (dim.width-w)/2;
            int y = (dim.height-h)/2;
            setLocation(x, y);      
            //setPreferredSize(864,609);  
            //getRootPane().updateUI();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void setModifyBaseURLGUI()
    {
        try
        { 
            msgBuildType = 1;  
            setSize(446,609);  
            RootPanel.setPreferredSize(new java.awt.Dimension(430, 500));
            MainEastContentPanel.removeAll();
            MainEastContentPanel.setMaximumSize(new java.awt.Dimension(0, 0));            
            MainEastContentPanel.setMinimumSize(new java.awt.Dimension(0, 0));
            MainEastContentPanel.setPreferredSize(new java.awt.Dimension(0, 0));   
            MainSouthContentPanel.setMaximumSize(new java.awt.Dimension(430,190));              
            MainSouthContentPanel.setMinimumSize(new java.awt.Dimension(300,190));
            MainSouthContentPanel.setPreferredSize(new java.awt.Dimension(410,190));            
            setContentPanel(baseURLChangePanel);
            setSouthContentPanel(SouthContentPanel);
            LeftAlignButton.setEnabled(false);
            CenterAlignButton.setEnabled(false);
            RightAlignButton.setEnabled(false);    
            FontColorButton.setEnabled(false); 
            FontButton.setEnabled(false); 
            cbDefaultTextColor.setEnabled(false); 
            cbDefaultFont.setEnabled(false); 
            MessagePreviewButton.setEnabled(false);            
            eastFiller.setSize(10,10);
            ContentPanel.add(eastFiller,java.awt.BorderLayout.EAST);     
            eastFiller.setVisible(true);
            westFiller.setSize(10,10);
            ContentPanel.add(westFiller,java.awt.BorderLayout.WEST);   
            westFiller.setVisible(true);
            northFiller.setSize(10,10);
            ContentPanel.add(northFiller,java.awt.BorderLayout.NORTH);  
            northFiller.setVisible(true);
            southFiller.setSize(10,10);
            ContentPanel.add(southFiller,java.awt.BorderLayout.SOUTH);   
            southFiller.setVisible(true);
            cbURLAddressBar.setEnabled(false);   
          

            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            int w = getSize().width;
            int h = getSize().height;
            int x = (dim.width-w)/2;
            int y = (dim.height-h)/2;
            setLocation(x, y);              
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }        
    }     

    private boolean removeRow()
    {
        try
        {
            int rowNum = FileList.getSelectedRow();
            if(rowNum != -1 || rowNum < copyToArray.length)
            {
                copyfilesto = "";
                files = "";
                overwriteexistingfiles = "";   
                for(int i = 0;i<copyToArray.length;i++)
                {
                    if(i!=0)
                    {
                        if(i != rowNum)
                        {
                            if(rowNum==0 && i==1)
                            {
                                copyfilesto = (String)copyToArray[i];
                                files = (String)filesArray[i];
                                overwriteexistingfiles = (String)overwriteFilesArray[i];                                
                            }
                            else
                            {
                                copyfilesto = copyfilesto + "," + (String)copyToArray[i];
                                files = files + "," + (String)filesArray[i];
                                overwriteexistingfiles = overwriteexistingfiles + "," + (String)overwriteFilesArray[i]; 
                            }
                        }
                    }
                    else
                    {
                        if(i != rowNum)
                        {                       
                            copyfilesto = (String)copyToArray[i];
                            files = (String)filesArray[i];
                            overwriteexistingfiles = (String)overwriteFilesArray[i]; 
                         }
                    }
                }
                getTableUpdate();      
                return true; 
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    private boolean addRow()
    {
        try
        {
            if(AddFileDialog.showDialog(this, "Add File to Software Update")==true)
            {
                return addRowData(AddFileDialog.getInstallFile(), AddFileDialog.getOverwriteExistingFile(), AddFileDialog.getDownloadURL());  
            }
            else
            {
                return false;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    
    private boolean addRowData(String copyToFile1, String strOverwriteExistingFile1, String strFile1)
    {
        try
        {
            if(copyToArray.length!=0)
            {
                copyfilesto = copyfilesto + "," + copyToFile1;
                files = files + "," + strFile1;
                overwriteexistingfiles = overwriteexistingfiles + "," + strOverwriteExistingFile1;                   
            }
            else
            {
                copyfilesto = copyToFile1;
                files = strFile1;
                overwriteexistingfiles = strOverwriteExistingFile1;                 
            }
            getTableUpdate();              
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }    
    
    String[] columnNames = {"File Install Location", "Overwrite Existing File", "File Download URL"};
    private Object[][] data = new Object[0][0];
    private AUTableModel dataModel = new AUTableModel();
    private void getTableUpdate()
    {
        
        try 
        {
            copyToArray = getStringArraysFromString(copyfilesto);            
            if(copyToArray.length==1)
            {
                if(((String)copyToArray[0]).equalsIgnoreCase("")==true)
                {
                    copyToArray = new Object[0];
                    overwriteFilesArray = new Object[0];
                    filesArray = new Object[0];        
                }
                else
                {
                        filesArray = getStringArraysFromString(files);
                        overwriteFilesArray = getStringArraysFromString(overwriteexistingfiles);              
                }
            }
            else
            {
                filesArray = getStringArraysFromString(files);
                overwriteFilesArray = getStringArraysFromString(overwriteexistingfiles);      
            }
            data = new Object[copyToArray.length][3];
            for(int i = 0;i<copyToArray.length;i++)
            {
                dataModel.setValueAt(copyToArray[i], i, 0);
                data[i][0] = copyToArray[i]; 
                if(((String)overwriteFilesArray[i]).equalsIgnoreCase("true")==true)
                {
                    dataModel.setValueAt(((String)overwriteFilesArray[i]), i, 1);
                    data[i][1] = ((String)overwriteFilesArray[i]);    
                }
                else
                {
                    dataModel.setValueAt(((String)overwriteFilesArray[i]), i, 1);
                    data[i][1] = ((String)overwriteFilesArray[i]);                        
                }
                dataModel.setValueAt(filesArray[i], i, 2);
                data[i][2] = filesArray[i];                
            }
            //FileList = new JTable(data, columnNames);
            FileList = new JTable(dataModel);
            FileList.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    FileListMouseClicked(evt);
                }
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    FileListMouseEntered(evt);
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    FileListMouseExited(evt);
                }
            });
            FileList.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() 
            {
                public void mouseMoved(java.awt.event.MouseEvent evt) 
                {
                    FileListMouseMoved(evt);
                }
             });       
             FileListScrollPane.setViewportView(FileList);

             //cbColumn = FileList.getColumnModel().getColumn(1);
             //JCheckBox cb = new JCheckBox("");
             //cbColumn.setCellEditor(new DefaultCellEditor(cb));
             //FileListScrollPane.setViewportView(FileList);
            
            //FileList.setModel(dataModel);
            //getTableHeaderUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
	public void setStatus(String status)
	{
		try
		{
			HelpStatusLabel.setText(status);
		}
		catch(Exception e)
		{
			HelpStatusLabel.setText("");			
		}
	}    
    
    private TableColumn cbColumn = new TableColumn();
    private JTableHeader tableHeader = new JTableHeader();
    private void getTableHeaderUpdate()
    {
        try
        {
                FileList.setTableHeader(tableHeader);          
                tableHeader = FileList.getTableHeader();
                TableColumn URLColumn = tableHeader.getColumnModel().getColumn(0);
                URLColumn.setHeaderValue(columnNames[0]);    
                URLColumn.setPreferredWidth(200);            
                TableColumn overwriteColumn = tableHeader.getColumnModel().getColumn(1);   
                overwriteColumn.setHeaderValue(columnNames[1]);        
                overwriteColumn.setPreferredWidth(100);    
                TableColumn installColumn = tableHeader.getColumnModel().getColumn(2);
                installColumn.setHeaderValue(columnNames[2]);  
                installColumn.setPreferredWidth(100);                
        }
        catch(Exception e)
        {
            e.printStackTrace(); 
        }
    }
    
        // Create a model of the data. 
        class AUTableModel extends AbstractTableModel 
        { 
             private String[] columnNames = {"File Install Location", "Overwrite Existing File", "File Download URL"};
             public int getColumnCount() { return 3; } 
             public int getRowCount() {  return copyToArray.length;} 
             public Object getValueAt(int row, int col) {return data[row][col];} 
             public String getColumnName(int column) {return columnNames[column];} 
             public boolean isCellEditable(int row, int col){ return false; }            
             public Class getColumnClass(int c) {return getValueAt(0, c).getClass();} 
             public void setValueAt(Object aValue, int row, int column) { data[row][column] = aValue; } 
         }
  
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AboutHelp;
    private javax.swing.JButton AddFile;
    private javax.swing.JPanel AddFileButtonPanel;
    private javax.swing.JButton AdvancedConfigurationOptionsButton;
    private javax.swing.JPanel AutoUpdateFilesPanel;
    private javax.swing.JPanel BorderSeparator;
    private javax.swing.JPanel BorderSeparator1;
    private javax.swing.JButton BuildMessageButton;
    private javax.swing.JButton BuildMessageButton1;
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JPanel ButtonPanel1;
    private javax.swing.JPanel ButtonPanel2;
    private javax.swing.JButton CenterAlignButton;
    private javax.swing.JButton ChooseButton;
    private javax.swing.JButton ChooseButton1;
    private javax.swing.JButton ConfigureLanguagesButton;
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JPanel ContentPanel1;
    private javax.swing.JButton DefaultButton;
    private javax.swing.JButton DefaultButton1;
    private javax.swing.JMenu DesignerMenu;
    private javax.swing.JPanel EastContentPanel;
    private javax.swing.JMenuItem EvaluateAnywhereHelp;
    private javax.swing.JTable FileList;
    private javax.swing.JScrollPane FileListScrollPane;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JPanel FilesContentPanel;
    private javax.swing.JLabel Filler1;
    private javax.swing.JLabel Filler2;
    private javax.swing.JLabel FillerLabel;
    private javax.swing.JLabel FillerLabel1;
    private javax.swing.JLabel FillerLabel2;
    private javax.swing.JLabel FillerLabel3;
    private javax.swing.JLabel Filller1;
    private javax.swing.JLabel Filller2;
    private javax.swing.JLabel Filller3;
    private javax.swing.JLabel Filller4;
    private javax.swing.JButton FontButton;
    private javax.swing.JButton FontColorButton;
    private javax.swing.JLabel HeaderTitleLabel;
    private javax.swing.JMenu HelpMenu;
    private javax.swing.JTextArea HelpStatusLabel;
    private javax.swing.JPanel HorizontalRulePanel;
    private javax.swing.JButton LeftAlignButton;
    private javax.swing.JPanel MainContentPanel;
    private javax.swing.JPanel MainEastContentPanel;
    private javax.swing.JPanel MainSouthContentPanel;
    private javax.swing.JLabel MessageBodyLabel;
    private javax.swing.JPanel MessageBodyLabelPanel;
    private javax.swing.JPanel MessageBodyPanel;
    private javax.swing.JPanel MessageBodyTextAreaPanel;
    private javax.swing.JPanel MessageBuildLocation;
    private javax.swing.JPanel MessageBuildLocation1;
    private javax.swing.JToolBar MessageBuilderToolbar;
    private javax.swing.JPanel MessageDataPanel;
    private javax.swing.JPanel MessageDeliveryPanel;
    private javax.swing.JMenuBar MessageDesignerMenuBar;
    private javax.swing.JMenuItem MessageDesignerMenuItem;
    private javax.swing.JLabel MessageIDLabel;
    private javax.swing.JLabel MessageIDLabel1;
    private javax.swing.JPanel MessageIDPanel;
    private javax.swing.JPanel MessageIDPanel1;
    private javax.swing.JPanel MessageOutputLabelPanel;
    private javax.swing.JPanel MessageOutputLabelPanel1;
    private javax.swing.JPanel MessageOutputTextFieldPanel;
    private javax.swing.JPanel MessageOutputTextFieldPanel1;
    private javax.swing.JPanel MessageOutputTextFieldPanel2;
    private javax.swing.JPanel MessageOutputTextFieldPanel3;
    private javax.swing.JPanel MessagePanel;
    private javax.swing.JButton MessagePreviewButton;
    private javax.swing.JButton MessagePreviewButton1;
    private javax.swing.JPanel MessagePreviewPanel;
    private javax.swing.JPanel MessagePreviewPanel1;
    private javax.swing.JPanel MessageTextColorPanel;
    private javax.swing.JLabel MessageTitleLabel;
    private javax.swing.JPanel MessageTitleLabelPanel;
    private javax.swing.JPanel MessageTitleLabelPanel1;
    private javax.swing.JPanel MessageTitlePanel;
    private javax.swing.JPanel MessageTitleTextFieldPanel;
    private javax.swing.JPanel MessageTypePanel;
    private javax.swing.JPanel MessageURLPanel;
    private javax.swing.JPanel MessageURLPanel1;
    private javax.swing.JPanel NorthPanel;
    private javax.swing.JMenuItem ProjectDesignerMenuItem;
    private javax.swing.JButton RemoveFile;
    private javax.swing.JPanel RemoveFileButtonPanel;
    private javax.swing.JButton RightAlignButton;
    private javax.swing.JPanel RootPanel;
    private javax.swing.JLabel Separator1;
    private javax.swing.JLabel Separator10;
    private javax.swing.JLabel Separator11;
    private javax.swing.JLabel Separator12;
    private javax.swing.JLabel Separator13;
    private javax.swing.JLabel Separator14;
    private javax.swing.JLabel Separator15;
    private javax.swing.JLabel Separator16;
    private javax.swing.JLabel Separator17;
    private javax.swing.JLabel Separator18;
    private javax.swing.JLabel Separator19;
    private javax.swing.JLabel Separator2;
    private javax.swing.JLabel Separator20;
    private javax.swing.JLabel Separator21;
    private javax.swing.JLabel Separator22;
    private javax.swing.JLabel Separator23;
    private javax.swing.JLabel Separator3;
    private javax.swing.JLabel Separator39;
    private javax.swing.JLabel Separator4;
    private javax.swing.JLabel Separator40;
    private javax.swing.JLabel Separator41;
    private javax.swing.JLabel Separator42;
    private javax.swing.JLabel Separator43;
    private javax.swing.JLabel Separator5;
    private javax.swing.JLabel Separator6;
    private javax.swing.JLabel Separator7;
    private javax.swing.JLabel Separator8;
    private javax.swing.JLabel Separator9;
    private javax.swing.JPanel SouthContentPanel;
    private javax.swing.JPanel SouthContentPanel1;
    private javax.swing.JPanel SouthNewProjectPanelTopPanel;
    private javax.swing.JPanel SpacerPanel;
    private javax.swing.JPanel SpacerPanel2;
    private javax.swing.JPanel TheFileListPanel;
    private javax.swing.JMenuItem advancedPropertiesMenuItem;
    private javax.swing.JButton btnViewDocumentation;
    private javax.swing.JButton btnViewDocumentation1;
    private javax.swing.JCheckBox cbDefaultFont;
    private javax.swing.JCheckBox cbDefaultTextColor;
    private javax.swing.JPanel cbMessageURLPanel;
    private javax.swing.JPanel cbMessageURLPanel1;
    private javax.swing.JComboBox cbURLAddressBar;
    private javax.swing.JComboBox cbURLAddressBar1;
    private javax.swing.JMenuItem closeMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lFiller26;
    private javax.swing.JLabel lFiller27;
    private javax.swing.JLabel lFiller28;
    private javax.swing.JLabel lFiller29;
    private javax.swing.JLabel lFiller31;
    private javax.swing.JLabel lFiller32;
    private javax.swing.JLabel lFiller33;
    private javax.swing.JLabel lFiller34;
    private javax.swing.JLabel lFiller35;
    private javax.swing.JLabel lFiller36;
    private javax.swing.JMenuItem modifyURLMenuItem;
    private javax.swing.JMenu newMenuItem;
    private javax.swing.JMenuItem newMessageMenuItem;
    private javax.swing.JPanel rbDefaultOptionPanel;
    private javax.swing.JRadioButton rbLongMessage;
    private javax.swing.JRadioButton rbOnlySelectedLanguages;
    private javax.swing.JPanel rbOnlySelectedLanguagesPanel;
    private javax.swing.JRadioButton rbShortMessage;
    private javax.swing.JRadioButton rbUseDefaultLocales;
    private javax.swing.JMenuItem saveDefaultsMenuItem;
    private javax.swing.JScrollPane scrollPaneMessageBody;
    private javax.swing.JSpinner spinMessageID;
    private javax.swing.JSpinner spinMessageID1;
    private javax.swing.JTextArea taMessageBody;
    private javax.swing.JTextArea taOnlySelectedLanguages;
    private javax.swing.JTextArea taUseDefaultLocale;
    private javax.swing.JTextField tfBuildLocation1;
    private javax.swing.JTextField tfBuildLocation2;
    private javax.swing.JTextField tfMessageTitle;
    private javax.swing.JTabbedPane tpLanguageTabs;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JLabel eastFiller = new JLabel();
    private javax.swing.JLabel westFiller = new JLabel();
    private javax.swing.JLabel northFiller = new JLabel();
    private javax.swing.JLabel southFiller = new JLabel();   
}
