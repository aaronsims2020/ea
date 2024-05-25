/*
 * NewProject.java
 *
 * Created on March 16, 2004, 11:25 PM
 */

package com.trinity.ea.design.common.project;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.rules.builder.DesignerRuleBuilder;
import com.trinity.ea.design.common.file.ProjectManager;
import com.trinity.ea.util.BrowserLauncher;
import com.trinity.ea.design.common.project.ProductInformationPanel;
import com.trinity.ea.design.common.project.ProjectNotFoundDialog;
import com.trinity.ea.design.common.project.ProductEvaluationPanel;
import com.trinity.ea.design.common.project.BuildFeatureSettings;
import com.trinity.ea.design.common.project.ProductMainClassPanel;
import com.trinity.ea.design.common.project.ProductOptinPanel;
import com.trinity.ea.design.common.project.UnlistedProviderOptinProviderPanel;
import com.trinity.ea.design.common.project.AWeberOptinProviderPanel;
import com.trinity.ea.design.common.project.GetRespOptinProviderPanel;
import com.trinity.ea.design.common.project.ProductPaymentPanel;
import com.trinity.ea.design.common.project.UnlistedProviderPaymentProviderPanel;
import com.trinity.ea.design.common.project.SkipjackPaymentProvider;
import com.trinity.ea.design.common.project.WebPagePaymentProvider;
import com.trinity.ea.design.common.project.ProductAutoUpdatePanel;
import com.trinity.ea.design.common.project.ProductMessagingPanel;
import com.trinity.ea.design.common.project.ProductBuildPanel;
import com.trinity.ea.design.common.project.ProductBuildSummaryPanel;
import com.trinity.ea.design.common.compiler.EACompiler;
//import com.trinity.ea.design.common.status.ProgressWindow;
import com.trinity.ea.util.SplashWindow;
import com.trinity.ea.design.common.filechooser.EAXFileFilter;
import com.trinity.ea.design.common.filechooser.EAXFileView;
import com.trinity.ea.design.EADesigner;
import java.awt.*;
import java.awt.event.*; 
import javax.swing.event.*; 
import javax.swing.*;
import java.util.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.File;
import javax.swing.JFileChooser;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.DefaultMetalTheme;


/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class NewProject extends javax.swing.JFrame {
    private Object[] newProjectWizardPanelNames = null;
    private String[] recentFileListArray = null;
    private int wizardPanel = 0;
    private boolean saveProjectIsSet=false;
    private String[] saveFileArray = {};
    private String saveFileURL = null;
    private ImageIcon NewProjectIcon = null;
    private ImageIcon OpenProjectIcon = null;
    private java.awt.Image TitleBarIcon = null;
    String filename = File.separator+"tmp";
    JFileChooser fc = new JFileChooser(new File(filename)); 
    private EAXFileFilter filter = new EAXFileFilter();
    private EAXFileView fileView = new EAXFileView();
    private static EADesigner eaDesigner = null;
    private Color defaultColor = null;
    private static int currentIndex = 0;
    private int buildStatus = 1;
        private ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/images/eacl_splash.png"));
        private ImageIcon setInfoIcon = new javax.swing.ImageIcon(getClass().getResource("/images/setinfo.png"));
        private ImageIcon setFeaturesIcon = new javax.swing.ImageIcon(getClass().getResource("/images/setfeatures.png"));
        private ImageIcon setMainClassIcon = new javax.swing.ImageIcon(getClass().getResource("/images/setmainclass.png"));
        private ImageIcon setEvaluationIcon = new javax.swing.ImageIcon(getClass().getResource("/images/setexpiration.png"));
        private ImageIcon setOptinProviderIcon = new javax.swing.ImageIcon(getClass().getResource("/images/setprovider.png"));
        private ImageIcon setAWeberProviderIcon = new javax.swing.ImageIcon(getClass().getResource("/images/awlogo2.gif"));
        private ImageIcon setGetResponseProviderIcon = new javax.swing.ImageIcon(getClass().getResource("/images/getresp.jpg"));
        private ImageIcon setUnlistedProviderIcon = new javax.swing.ImageIcon(getClass().getResource("/images/unlistedprovider.png"));
        private ImageIcon setPaymentWebProviderIcon = new javax.swing.ImageIcon(getClass().getResource("/images/webpageprovider.png"));
        private ImageIcon setSkipjackProviderIcon = new javax.swing.ImageIcon(getClass().getResource("/images/thirdparty/SkipJackTNh161x63.gif"));
        private ImageIcon setPaymentProviderIcon = new javax.swing.ImageIcon(getClass().getResource("/images/setprovider.png"));
        private ImageIcon setAutoUpdateIcon = new javax.swing.ImageIcon(getClass().getResource("/images/setupdates.png"));
        private ImageIcon setMessagingIcon = new javax.swing.ImageIcon(getClass().getResource("/images/setmessaging.png"));
        private ImageIcon setBuildIcon = new javax.swing.ImageIcon(getClass().getResource("/images/buildproject.png"));
        private ImageIcon setBuildSummaryIcon = new javax.swing.ImageIcon(getClass().getResource("/images/buildsummary.png"));
 
       private SplashWindow splash;

    private Boolean[] boolFeatureArray = new Boolean[14];
    // configure the next/back panel array by features selections. 
    private void setFeaturesPanelArray()
    {
        try
        {
		// New/Open Project Step
		boolFeatureArray[0] = new Boolean(true);
		// Set Info Step
		boolFeatureArray[1] = new Boolean(true);
		// Set Features Step
		boolFeatureArray[2] = new Boolean(true);

	      // Expiration Timer Step   
            if(ProjectManager.get("project_expiration_support_is_enabled").equalsIgnoreCase("true")==true)
            {
			boolFeatureArray[3] = new Boolean(true);     
            }
            else
            {
			boolFeatureArray[3] = new Boolean(false);               
            }
		// Opt-In Step
            if(ProjectManager.get("project_optin_is_enabled").equalsIgnoreCase("true")==true)
            {
			boolFeatureArray[4] = new Boolean(true);     
			boolFeatureArray[5] = new Boolean(true);     
            }
            else
            {
			boolFeatureArray[4] = new Boolean(false);    
			boolFeatureArray[5] = new Boolean(false);            
            }
		// Payment Processing Step
            if(ProjectManager.get("project_payment_processing_support_is_enabled").equalsIgnoreCase("true")==true)
            {
			boolFeatureArray[6] = new Boolean(true);     
			boolFeatureArray[7] = new Boolean(true);     
            }
            else
            {
			boolFeatureArray[6] = new Boolean(false);    
			boolFeatureArray[7] = new Boolean(false);            
            }
		// Auto Update Step
            if(ProjectManager.get("project_auto_update_support_is_enabled").equalsIgnoreCase("true")==true)
            {
			boolFeatureArray[8] = new Boolean(true);     
            }
            else
            {
			boolFeatureArray[8] = new Boolean(false);               
            }   
		// Messaging Step
            if(ProjectManager.get("project_messaging_support_is_enabled").equalsIgnoreCase("true")==true)
            {
			boolFeatureArray[9] = new Boolean(true);     
            }
            else
            {
			boolFeatureArray[9] = new Boolean(false);               
            }  
            // Application Main Class Step
		boolFeatureArray[10] = new Boolean(true);
		// Build Step
		boolFeatureArray[11] = new Boolean(true);
		// Build Summary Step
		boolFeatureArray[12] = new Boolean(true);

		// Not used
		boolFeatureArray[13] = new Boolean(false);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
  
    // return number of steps till completion.
    private int getTotalWizardSteps()
    {
	try
	{
		int total = 0;
		for(int i = 0;i<boolFeatureArray.length;i++)
		{
			if(boolFeatureArray[i].booleanValue()==true)
			{
				total++;
			}
		}
		total = total-2;
		return total;
	}
	catch(Exception e)
	{

	}
	return 12;
    }

    private int currentStep = 1;
    // return current wizard step
    private int getCurrentStep()
    {
	try
	{
		return currentStep;
	}
	catch(Exception e)
	{

	}
	return currentIndex;
    }

    private void getTitleUpdate()
    {
	  try
	  {
     	 	setTitle(DesignerRuleBuilder.get("eaProductName") + " " + DesignerRuleBuilder.get("eaEditionName") + " - " + " Step " + String.valueOf(getCurrentStep()) + " of " + String.valueOf(getTotalWizardSteps()));
	  }
	  catch(Exception e)
	  {
		//e.printStackTrace();
	  }
    }

    // Return the next wizard panel index. A call to setFeaturesPanelArray() on initialization of NewProject(), and must be made upon Features panel Next button. 
    private int getNavigateNextIndex()
    {
        try
        {
		for(int i = (currentIndex + 1);i<boolFeatureArray.length;i++)
		{
			if(boolFeatureArray[i].booleanValue()==true)
			{
				return i;
			}
		}
	  }
        catch(Exception e)
        {
            e.printStackTrace();
        }
	  if(11<currentIndex)
	  {
	  	return currentIndex + 1;
	  }
	  else
	  {
		return currentIndex;
	  }
    }

    // A portion of the Next button Action Performed code. Renders the Next Panel (second half of Next Action) 
    private void getNavigateNextAction()
    {
        try
        {

		if(currentIndex==1)
		{
			if(productInformationPanel!=null)
			{}
			else
			{
	  			productInformationPanel = new ProductInformationPanel();
	  			productInformationPanel.setParentComponent(this);
			}
			setProductInformationUIUpdate();
			try
			{
     				setTitle(DesignerRuleBuilder.get("eaProductName") + " " + DesignerRuleBuilder.get("eaEditionName") + " - " + " Step " + String.valueOf(getCurrentStep()));
			}
	  		catch(Exception e)
	  		{
				//e.printStackTrace();
	  		}
		}
		else if(currentIndex==2)
		{
			if(buildFeatureSettings!=null)
			{}
			else
			{
	  			buildFeatureSettings = new BuildFeatureSettings();
	  			buildFeatureSettings.setParentComponent(this);
			}
			productInformationPanel.getDataUpdate();
			setFeaturesUIUpdate();
			try
			{
     				setTitle(DesignerRuleBuilder.get("eaProductName") + " " + DesignerRuleBuilder.get("eaEditionName") + " - " + " Step " + String.valueOf(getCurrentStep()));
			}
	  		catch(Exception e)
	  		{
				//e.printStackTrace();
	  		}
		}
		else if(currentIndex==3)
		{
			if(productEvaluationPanel!=null)
			{}
			else
			{
	  			productEvaluationPanel = new ProductEvaluationPanel();
	  			productEvaluationPanel.setParentComponent(this);
			}
			setEvaluationPanelUIUpdate();
			getTitleUpdate();	
		}
		else if(currentIndex==4)
		{
			if(productOptinPanel!=null)
			{}
			else
			{
	  			productOptinPanel = new ProductOptinPanel();
	  			productOptinPanel.setParentComponent(this);
			}
			setOptinProviderPanelUIUpdate();
			getTitleUpdate();	
		}
		else if(currentIndex==5)
		{
				if(optinCurrentIndex==0)
				{
					if(aWeberOptinProviderPanel!=null)
					{}
					else
					{
	  					aWeberOptinProviderPanel = new AWeberOptinProviderPanel();
	  					aWeberOptinProviderPanel.setParentComponent(this);
					}
					setOptinAWeberPanelUIUpdate();
				}
				else if(optinCurrentIndex==1)
				{
					if(getRespOptinProviderPanel!=null)
					{}
					else
					{
	  					getRespOptinProviderPanel = new GetRespOptinProviderPanel();
	  					getRespOptinProviderPanel.setParentComponent(this);
					}
					setOptinGetResponsePanelUIUpdate();
				}
				if(optinCurrentIndex==2)
				{
					if(unlistedProviderOptinProviderPanel!=null)
					{}
					else
					{
	  					unlistedProviderOptinProviderPanel = new UnlistedProviderOptinProviderPanel();
	  					unlistedProviderOptinProviderPanel.setParentComponent(this);
					}
					setOptinUnlistedProviderPanelUIUpdate();
				}
			getTitleUpdate();	
		}
		else if(currentIndex==6)
		{
			if(productPaymentPanel!=null)
			{}
			else
			{
  				productPaymentPanel = new ProductPaymentPanel();
  				productPaymentPanel.setParentComponent(this);
			}
    			setPaymentProviderPanelUIUpdate();
			getTitleUpdate();	
		}
		else if(currentIndex==7)
		{
				if(paymentCurrentIndex==0)
				{
					if(skipjackPaymentProvider!=null)
					{}
					else
					{
	  					skipjackPaymentProvider = new SkipjackPaymentProvider();
	  					skipjackPaymentProvider.setParentComponent(this);
					}
					setSkipjackPanelUIUpdate();
				}
				else if(paymentCurrentIndex==1)
				{
					if(webPagePaymentProvider!=null)
					{}
					else
					{
	  					webPagePaymentProvider = new WebPagePaymentProvider();
	  					webPagePaymentProvider.setParentComponent(this);
					}
					setWebPaymentPanelUIUpdate();
				}
				if(paymentCurrentIndex==2)
				{
					if(unlistedProviderPaymentProviderPanel!=null)
					{}
					else
					{
	  					unlistedProviderPaymentProviderPanel = new UnlistedProviderPaymentProviderPanel();
	  					unlistedProviderPaymentProviderPanel.setParentComponent(this);
					}
					setPaymentUnlistedProviderPanelUIUpdate();
				}
			getTitleUpdate();	
		}
		else if(currentIndex==8)
		{
			if(productAutoUpdatePanel!=null)
			{}
			else
			{
  				productAutoUpdatePanel = new ProductAutoUpdatePanel();
  				productAutoUpdatePanel.setParentComponent(this);
			}
			setAutoUpdatePanelUIUpdate();
			getTitleUpdate();	
		}
		else if(currentIndex==9)
		{
			if(productMessagingPanel!=null)
			{}
			else
			{
  				productMessagingPanel = new ProductMessagingPanel();
  				productMessagingPanel.setParentComponent(this);
			}
			setMessagingPanelUIUpdate();
			getTitleUpdate();	
		}
		else if(currentIndex==10)
		{
			if(productMainClassPanel!=null)
			{}
			else
			{
	  			productMainClassPanel = new ProductMainClassPanel();
	  			productMainClassPanel.setParentComponent(this);
			}
			setMainClassPanelUIUpdate();
			getTitleUpdate();	
		}
		else if(currentIndex==11)
		{
			if(productBuildPanel!=null)
			{}
			else
			{
  				productBuildPanel = new ProductBuildPanel();
  				productBuildPanel.setParentComponent(this);
			}
			setBuildPanelUIUpdate();
			getTitleUpdate();	
		}
		else if(currentIndex==12)
		{
			if(productBuildSummaryPanel!=null)
			{}
			else
			{
  				productBuildSummaryPanel = new ProductBuildSummaryPanel();
  				productBuildSummaryPanel.setParentComponent(this);
			}
			setBuildSummaryPanelUIUpdate();
			try
			{
     				setTitle(DesignerRuleBuilder.get("eaProductName") + " " + DesignerRuleBuilder.get("eaEditionName") + " - " + " Build Summary");
			}
	  		catch(Exception e)
	  		{
				//e.printStackTrace();
	  		}
		}
		else if(currentIndex==13)
		{

		}
	}
      catch(Exception e)
      {
          e.printStackTrace();
      }
    }

    // Return the previous wizard panel index. A call to setFeaturesPanelArray() on initialization of NewProject(), and must be made upon Features panel Next button. 
    private int getNavigateBackIndex()
    {
        try
        {
		int i = currentIndex - 1;
		if(0<i)
		{

			while(0!=currentIndex)
			{
				if(i<0)
				{
					return currentIndex;
				}
				if(boolFeatureArray[i].booleanValue()==true)
				{
					return i;
				}
				else
				{
					i = i-1;
				}			
			}
			return 0;
		}
		else
		{
			return 0;
		}
	  }
        catch(Exception e)
        {
            e.printStackTrace();
        }
	  return currentIndex;
    }

    // A portion of the Back button Action Performed code. Renders the Back Panel (second half of Back Action) 
    private void getNavigateBackAction()
    {
	  try      
  	  {
		if(currentIndex==0)
		{
			setOpenFileUIUpdate();
		}
		else if(currentIndex==1)
		{
			setProductInformationUIUpdate();
			try
			{
     				setTitle(DesignerRuleBuilder.get("eaProductName") + " " + DesignerRuleBuilder.get("eaEditionName") + " - " + " Step " + String.valueOf(getCurrentStep()));
			}
	  		catch(Exception e)
	  		{
				//e.printStackTrace();
	  		}		
		}
		else if(currentIndex==2)
		{
			setFeaturesUIUpdate();
			try
			{
     				setTitle(DesignerRuleBuilder.get("eaProductName") + " " + DesignerRuleBuilder.get("eaEditionName") + " - " + " Step " + String.valueOf(getCurrentStep()));
			}
	  		catch(Exception e)
	  		{
				//e.printStackTrace();
	  		}	
		}
		else if(currentIndex==3)
		{
			setEvaluationPanelUIUpdate();
			getTitleUpdate();		
		}
		else if(currentIndex==4)
		{
			setOptinProviderPanelUIUpdate();
			getTitleUpdate();		
		}
		else if(currentIndex==5)
		{
			if(optinCurrentIndex == -1)
			{

			}
			else if(optinCurrentIndex == 0)
			{
				setOptinAWeberPanelUIUpdate();
			}
			else if(optinCurrentIndex == 1)
			{
				setOptinGetResponsePanelUIUpdate();
			}
			else if(optinCurrentIndex == 2)
			{
				setOptinUnlistedProviderPanelUIUpdate();
			}
			getTitleUpdate();	
		}
		else if(currentIndex==6)
		{
			setPaymentProviderPanelUIUpdate();
			getTitleUpdate();	
		}
		else if(currentIndex==7)
		{
			if(paymentCurrentIndex == -1)
			{

			}
			else if(paymentCurrentIndex == 0)
			{
				setSkipjackPanelUIUpdate();
			}
			else if(paymentCurrentIndex == 1)
			{
				setWebPaymentPanelUIUpdate();
			}	
			else if(paymentCurrentIndex == 2)
			{
				setPaymentUnlistedProviderPanelUIUpdate();
			}	
			getTitleUpdate();	
		}
		else if(currentIndex==8)
		{
			setAutoUpdatePanelUIUpdate();
			getTitleUpdate();	
		}
		else if(currentIndex==9)
		{
			setMessagingPanelUIUpdate();
			getTitleUpdate();	
		}
		else if(currentIndex==10)
		{
			setMainClassPanelUIUpdate();
			getTitleUpdate();	
		}
		else if(currentIndex==11)
		{
			eaDesigner.getTerminateEAPreview();
			setBuildPanelUIUpdate();
			getTitleUpdate();	
		}
		else if(currentIndex==12)
		{

		}
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }   
    }
 
    /** Called from Advanced Designer, assumes Advanced Designer was initialized.  */
    public NewProject(int wizPanel, String prjFileURL)
    {
      super();
	currentIndex = 1;
	try
	{
		//MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());

   		// re-install the Metal Look and Feel
   		//UIManager.setLookAndFeel(new MetalLookAndFeel());

   		// only needed to update existing widgets
   		//SwingUtilities.updateComponentTreeUI(this);
	}
	catch(Exception e)
	{

	}
	try
	{
		DesignerRuleBuilder.readPropertiesFile();
		DesignerRuleBuilder.setTempProject(prjFileURL);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	initialize(0);
      initComponents();
	setFeaturesPanelArray();
	try
	{
     		setTitle(DesignerRuleBuilder.get("eaProductName") + " " + DesignerRuleBuilder.get("eaEditionName") + " - " + DesignerRuleBuilder.getProjectFileName(DesignerRuleBuilder.getTempProject()).substring(0,DesignerRuleBuilder.getProjectFileName(DesignerRuleBuilder.getTempProject()).lastIndexOf(".")) + " (" + DesignerRuleBuilder.getProjectFileName(DesignerRuleBuilder.getTempProject()) + ")");
	}
	  catch(Exception e)
	  {
		e.printStackTrace();
	  }

//	  setWizardPanel(NewProjectPanel);
         // Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Determine the new location of the window
        int w = getSize().width;
        int h = getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;

        // Move the window
        setLocation(x, y);
	  splash.close();
	  try      
  	  {
		if(DesignerRuleBuilder.get("prjWizardPanels")!=null)
		{
			Object theWizPanel = Class.forName((String)newProjectWizardPanelNames[wizPanel]).newInstance();
            	setWizardPanel((JPanel)theWizPanel);
		}
        }
        catch(InstantiationException e)
        {
            e.printStackTrace();
        }   
        catch(IllegalAccessException e)
        {
            e.printStackTrace();
        }                      
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }   
    }

    public NewProject(int intWizPanel, EADesigner designer) 
    {
	try
	{
		eaDesigner = designer;
		currentIndex = intWizPanel;
		new NewProject().show();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

    /** Creates new form NewProject */
    public NewProject() {
        super();
	try
	{
		//MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());

   		// re-install the Metal Look and Feel
   		//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

   		// only needed to update existing widgets
   		//SwingUtilities.updateComponentTreeUI(this);
	}
	catch(Exception e)
	{

	}
	if(currentIndex==0)
	{
        		try
	{

	    splash = new SplashWindow(icon);
	    //splash.showStatus("Loading EvaluateAnywhere Projects Window........");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	try
{
DesignerRuleBuilder.readPropertiesFile();
}
catch(Exception e)
{
e.printStackTrace();
}
initialize(0);
}
else
{
	initialize(1);
}
       initComponents();
try
{
     setTitle(DesignerRuleBuilder.get("eaProductName") + " " + DesignerRuleBuilder.get("eaEditionName"));
}
catch(Exception e)
{
	e.printStackTrace();
}
	  setWizardPanel(NewProjectPanel);
         // Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Determine the new location of the window
        int w = getSize().width;
        int h = getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;

        // Move the window
        setLocation(x, y);
	if(currentIndex==0)
	{
	      splash.close();
		//setNewFileUIUpdate();
	}
	else if(currentIndex==1)
	{
		setProductInformationUIUpdate();
	}
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
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
		NewProjectIcon = new javax.swing.ImageIcon(getClass().getResource("/images/newproj.png"));
	  }
	  catch(Exception e)
	  {
		e.printStackTrace();
	  }

	  try
	  {
	  	OpenProjectIcon = new javax.swing.ImageIcon(getClass().getResource("/images/openproj.png"));
	  }
	  catch(Exception e)
	  {
		e.printStackTrace();
	  }  
        NewOrExistingProjectButtonGroup = new javax.swing.ButtonGroup();
        ContentPanel = new javax.swing.JPanel();
        NewProjectPanel = new javax.swing.JPanel();
        NorthNewProjectPanel = new javax.swing.JPanel();
        NorthNewProjectPanelCenterPanel = new javax.swing.JPanel();
        NewProjectImagePanel = new javax.swing.JPanel();
        NewProjectImage = new javax.swing.JLabel();
        NewProjectDescriptionPanel = new javax.swing.JPanel();
        NewProjectDescription = new javax.swing.JTextArea();
        NorthNewProjectPanelSouthPanel = new javax.swing.JPanel();
        rbNewProjectButton = new javax.swing.JRadioButton();
        rbOpenProjectButton = new javax.swing.JRadioButton();
        CenterNewProjectPanel = new javax.swing.JPanel();
        RightContentPanel = new javax.swing.JPanel();
        NewProjectPanelFileBox = new EAPanel();
        SouthNewProjectPanelTopPanel1 = new javax.swing.JPanel();
        SouthNewProjectPanelTopPanel2 = new javax.swing.JPanel();
        ProjectFileNameLabel = new javax.swing.JLabel();
        NewProjectSaveAsTextField = new javax.swing.JTextField();
        NewProjectSaveAsButton = new javax.swing.JButton();
        SouthNewProjectPanelTopPanel3 = new javax.swing.JPanel();
        SouthNewProjectPanel = new javax.swing.JPanel();
        SouthNewProjectPanelTopPanel = new javax.swing.JPanel();
        HelpStatusLabel = new javax.swing.JTextArea();
        HorizontalRulePanel = new javax.swing.JPanel();
        SouthNewProjectPanelBottomPanel = new javax.swing.JPanel();
        LeftButtonPanel = new javax.swing.JPanel();
        ExitButton = new javax.swing.JButton();
        AdvancedDesignerButton = new javax.swing.JButton();
        RightButtonPanel = new javax.swing.JPanel();
        AboutButton = new javax.swing.JButton();
        NextButton = new javax.swing.JButton();

        setResizable(false);

        OpenProjectPanelFileBox = new EAPanel();
        SouthOpenProjectPanelLeftPanel = new javax.swing.JPanel();
        InnerProjectListPanel = new javax.swing.JPanel();
        ProjectListScrollPane = new javax.swing.JScrollPane();
        ProjectList = new javax.swing.JList();
        SouthOpenProjectPanelRightPanel = new javax.swing.JPanel();
        OpenProjectOpenOtherButton = new javax.swing.JButton();

        OpenProjectPanelFileBox.setLayout(new java.awt.BorderLayout());

        SouthOpenProjectPanelLeftPanel.setLayout(new java.awt.BorderLayout());

	  // Set Parent Component for EAPanel's
        NewProjectPanelFileBox.setParentComponent(this);
        OpenProjectPanelFileBox.setParentComponent(this);
	  //

	  defaultColor = getBackground();

        SouthOpenProjectPanelLeftPanel.setMaximumSize(new java.awt.Dimension(32767, 30));
        SouthOpenProjectPanelLeftPanel.setMinimumSize(new java.awt.Dimension(368, 30));
        SouthOpenProjectPanelLeftPanel.setPreferredSize(new java.awt.Dimension(368, 30));
        InnerProjectListPanel.setLayout(new java.awt.BorderLayout());

        InnerProjectListPanel.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(10, 10, 10, 10)));
        ProjectListScrollPane.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        ProjectListScrollPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProjectListScrollPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProjectListScrollPaneMouseExited(evt);
            }
        });

        ProjectList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = getRecentFileListToFileNamesList(recentFileListArray = (String[])DesignerRuleBuilder.getRecentProjectsList());
		public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        ProjectList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ProjectList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ProjectListValueChanged(evt);
            }
        });
        ProjectList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProjectListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProjectListMouseExited(evt);
            }
        });
        ProjectListScrollPane.setViewportView(ProjectList);

        InnerProjectListPanel.add(ProjectListScrollPane, java.awt.BorderLayout.CENTER);

        SouthOpenProjectPanelLeftPanel.add(InnerProjectListPanel, java.awt.BorderLayout.CENTER);

        OpenProjectPanelFileBox.add(SouthOpenProjectPanelLeftPanel, java.awt.BorderLayout.CENTER);

        SouthOpenProjectPanelRightPanel.setLayout(new javax.swing.BoxLayout(SouthOpenProjectPanelRightPanel, javax.swing.BoxLayout.X_AXIS));

        SouthOpenProjectPanelRightPanel.setMaximumSize(new java.awt.Dimension(32767, 30));
        SouthOpenProjectPanelRightPanel.setMinimumSize(new java.awt.Dimension(120, 30));
        SouthOpenProjectPanelRightPanel.setPreferredSize(new java.awt.Dimension(120, 30));
        OpenProjectOpenOtherButton.setFont(new java.awt.Font("Dialog", 0, 12));
        OpenProjectOpenOtherButton.setText("Open Other......");
        OpenProjectOpenOtherButton.setMnemonic('O');
        OpenProjectOpenOtherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenProjectOpenOtherButtonActionPerformed(evt);
            }
        });
        OpenProjectOpenOtherButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OpenProjectOpenOtherButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OpenProjectOpenOtherButtonMouseExited(evt);
            }
        });

        SouthOpenProjectPanelRightPanel.add(OpenProjectOpenOtherButton);

        OpenProjectPanelFileBox.add(SouthOpenProjectPanelRightPanel, java.awt.BorderLayout.EAST);

        ContentPanel.setLayout(new java.awt.BorderLayout());

        ContentPanel.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(15, 15, 15, 15)));
        ContentPanel.setMinimumSize(new java.awt.Dimension(450, 350));
        ContentPanel.setPreferredSize(new java.awt.Dimension(450, 350));
        NewProjectPanel.setLayout(new java.awt.BorderLayout());

        NewProjectPanel.setMinimumSize(new java.awt.Dimension(450, 320));
        NewProjectPanel.setPreferredSize(new java.awt.Dimension(450, 320));
        NorthNewProjectPanel.setLayout(new java.awt.BorderLayout());

        NorthNewProjectPanelCenterPanel.setLayout(new java.awt.BorderLayout(10, 10));
        NewProjectImagePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));
        NewProjectImagePanel.setBackground(new java.awt.Color(255,255,255));
        NewProjectImagePanel.setBorder(new javax.swing.border.EtchedBorder());
        NewProjectImage.setBackground(new java.awt.Color(255,255,255));
        NewProjectImage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        //NewProjectImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NewProjectImage.setMaximumSize(new java.awt.Dimension(165, 76));
        NewProjectImage.setMinimumSize(new java.awt.Dimension(125,62));
        NewProjectImage.setPreferredSize(new java.awt.Dimension(125,76));
        NewProjectImage.setText("");
        NewProjectImage.setIconTextGap(0);
        NewProjectImagePanel.add(NewProjectImage);

        NorthNewProjectPanelCenterPanel.add(NewProjectImagePanel, java.awt.BorderLayout.WEST);

        NewProjectDescriptionPanel.setLayout(new java.awt.BorderLayout(10, 7));

        NewProjectDescriptionPanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.EtchedBorder(), null));
        NewProjectDescription.setBackground(getBackground());
        NewProjectDescription.setEditable(false);
        NewProjectDescription.setLineWrap(true);
        NewProjectDescription.setWrapStyleWord(true);
        NewProjectDescription.setMargin(new java.awt.Insets(7, 10, 7, 10));
        NewProjectDescriptionPanel.add(NewProjectDescription, java.awt.BorderLayout.CENTER);

        NorthNewProjectPanelCenterPanel.add(NewProjectDescriptionPanel, java.awt.BorderLayout.CENTER);

        NorthNewProjectPanel.add(NorthNewProjectPanelCenterPanel, java.awt.BorderLayout.CENTER);

        NorthNewProjectPanelSouthPanel.setLayout(new java.awt.BorderLayout(50, 0));

        rbNewProjectButton.setFont(new java.awt.Font("Dialog", 0, 12));
        rbNewProjectButton.setSelected(true);
        rbNewProjectButton.setText("Create New Project");
        NewOrExistingProjectButtonGroup.add(rbNewProjectButton);
        rbNewProjectButton.setMargin(new java.awt.Insets(10, 50, 5, 2));
        rbNewProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNewProjectButtonActionPerformed(evt);
            }
        });
        rbNewProjectButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rbNewProjectButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rbNewProjectButtonMouseExited(evt);
            }
        });

        NorthNewProjectPanelSouthPanel.add(rbNewProjectButton, java.awt.BorderLayout.WEST);

        rbOpenProjectButton.setFont(new java.awt.Font("Dialog", 0, 12));
        rbOpenProjectButton.setText("Open Existing Project");
        NewOrExistingProjectButtonGroup.add(rbOpenProjectButton);
        rbOpenProjectButton.setMargin(new java.awt.Insets(10, 2, 5, 2));
        rbOpenProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbOpenProjectButtonActionPerformed(evt);
            }
        });
        rbOpenProjectButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rbOpenProjectButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rbOpenProjectButtonMouseExited(evt);
            }
        });

        NorthNewProjectPanelSouthPanel.add(rbOpenProjectButton, java.awt.BorderLayout.CENTER);

        NorthNewProjectPanel.add(NorthNewProjectPanelSouthPanel, java.awt.BorderLayout.SOUTH);

        NewProjectPanel.add(NorthNewProjectPanel, java.awt.BorderLayout.NORTH);

        CenterNewProjectPanel.setLayout(new javax.swing.BoxLayout(CenterNewProjectPanel, javax.swing.BoxLayout.Y_AXIS));

        CenterNewProjectPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "New Project"));
        RightContentPanel.setLayout(new java.awt.BorderLayout());

        NewProjectPanelFileBox.setLayout(new javax.swing.BoxLayout(NewProjectPanelFileBox, javax.swing.BoxLayout.Y_AXIS));

        SouthNewProjectPanelTopPanel1.setMaximumSize(new java.awt.Dimension(32767, 40));
        SouthNewProjectPanelTopPanel1.setMinimumSize(new java.awt.Dimension(10, 40));
        SouthNewProjectPanelTopPanel1.setPreferredSize(new java.awt.Dimension(10, 40));
        NewProjectPanelFileBox.add(SouthNewProjectPanelTopPanel1);

        SouthNewProjectPanelTopPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 0));

        SouthNewProjectPanelTopPanel2.setMaximumSize(new java.awt.Dimension(32767, 30));
        SouthNewProjectPanelTopPanel2.setMinimumSize(new java.awt.Dimension(488, 30));
        SouthNewProjectPanelTopPanel2.setPreferredSize(new java.awt.Dimension(488, 30));
        ProjectFileNameLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        ProjectFileNameLabel.setText("Project File Name:");
        ProjectFileNameLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProjectFileNameLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProjectFileNameLabelMouseExited(evt);
            }
        });

        SouthNewProjectPanelTopPanel2.add(ProjectFileNameLabel);

        NewProjectSaveAsTextField.setBackground(javax.swing.UIManager.getDefaults().getColor("TextField.inactiveBackground"));
        NewProjectSaveAsTextField.setText("Click \"Save As...\"");
        NewProjectSaveAsTextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        NewProjectSaveAsTextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        NewProjectSaveAsTextField.setMargin(new java.awt.Insets(0, 10, 0, 5));
        NewProjectSaveAsTextField.setMinimumSize(new java.awt.Dimension(165, 22));
        NewProjectSaveAsTextField.setPreferredSize(new java.awt.Dimension(165, 22));
        NewProjectSaveAsTextField.setEnabled(false);
        NewProjectSaveAsTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NewProjectSaveAsTextFieldMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NewProjectSaveAsTextFieldMouseExited(evt);
            }
        });

        SouthNewProjectPanelTopPanel2.add(NewProjectSaveAsTextField);

        NewProjectSaveAsButton.setFont(new java.awt.Font("Dialog", 0, 12));
        NewProjectSaveAsButton.setText("Save As...");
        NewProjectSaveAsButton.setMnemonic('S');
        NewProjectSaveAsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewProjectSaveAsButtonActionPerformed(evt);
            }
        });
        NewProjectSaveAsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NewProjectSaveAsButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NewProjectSaveAsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NewProjectSaveAsButtonMouseExited(evt);
            }
        });

        SouthNewProjectPanelTopPanel2.add(NewProjectSaveAsButton);

        NewProjectPanelFileBox.add(SouthNewProjectPanelTopPanel2);

        SouthNewProjectPanelTopPanel3.setMaximumSize(new java.awt.Dimension(32767, 45));
        SouthNewProjectPanelTopPanel3.setMinimumSize(new java.awt.Dimension(10, 45));
        SouthNewProjectPanelTopPanel3.setPreferredSize(new java.awt.Dimension(10, 45));
        //NewProjectPanelFileBox.add(SouthNewProjectPanelTopPanel3);

        RightContentPanel.add(NewProjectPanelFileBox, java.awt.BorderLayout.EAST);

        CenterNewProjectPanel.add(RightContentPanel);

        NewProjectPanel.add(CenterNewProjectPanel, java.awt.BorderLayout.CENTER);

        SouthNewProjectPanel.setLayout(new javax.swing.BoxLayout(SouthNewProjectPanel, javax.swing.BoxLayout.Y_AXIS));

        SouthNewProjectPanelTopPanel.setLayout(new java.awt.BorderLayout());

        HelpStatusLabel.setBackground(getBackground());
        HelpStatusLabel.setEditable(false);
        HelpStatusLabel.setFont(new java.awt.Font("Dialog", 0, 10));
        HelpStatusLabel.setMargin(new java.awt.Insets(5, 10, 0, 0));
        HelpStatusLabel.setMaximumSize(new java.awt.Dimension(2147483647, 25));
        HelpStatusLabel.setMinimumSize(new java.awt.Dimension(0, 25));
        HelpStatusLabel.setPreferredSize(new java.awt.Dimension(0, 25));
        SouthNewProjectPanelTopPanel.add(HelpStatusLabel, java.awt.BorderLayout.NORTH);

        HorizontalRulePanel.setBorder(new javax.swing.border.EtchedBorder());
        HorizontalRulePanel.setMaximumSize(new java.awt.Dimension(32767, 2));
        HorizontalRulePanel.setMinimumSize(new java.awt.Dimension(10, 2));
        HorizontalRulePanel.setPreferredSize(new java.awt.Dimension(10, 2));
        SouthNewProjectPanelTopPanel.add(HorizontalRulePanel, java.awt.BorderLayout.SOUTH);

        SouthNewProjectPanel.add(SouthNewProjectPanelTopPanel);

        SouthNewProjectPanelBottomPanel.setLayout(new javax.swing.BoxLayout(SouthNewProjectPanelBottomPanel, javax.swing.BoxLayout.X_AXIS));

        LeftButtonPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        ExitButton.setFont(new java.awt.Font("Dialog", 0, 12));
        ExitButton.setText("Exit");
        ExitButton.setMnemonic('x');
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });
        ExitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExitButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExitButtonMouseExited(evt);
            }
        });

        LeftButtonPanel.add(ExitButton);

        AdvancedDesignerButton.setFont(new java.awt.Font("Dialog", 0, 12));
        AdvancedDesignerButton.setText("Advanced Designer");
        AdvancedDesignerButton.setMnemonic('A');
        AdvancedDesignerButton.setEnabled(false);
        AdvancedDesignerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdvancedDesignerButtonActionPerformed(evt);
            }
        });
        AdvancedDesignerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AdvancedDesignerButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AdvancedDesignerButtonMouseExited(evt);
            }
        });

        LeftButtonPanel.add(AdvancedDesignerButton);

        SouthNewProjectPanelBottomPanel.add(LeftButtonPanel);

        RightButtonPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        AboutButton.setFont(new java.awt.Font("Dialog", 0, 12));
        AboutButton.setText("About...");
        AboutButton.setMnemonic('b');
        AboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutButtonActionPerformed(evt);
            }
        });
        AboutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AboutButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AboutButtonMouseExited(evt);
            }
        });

        RightButtonPanel.add(AboutButton);

        NextButton.setFont(new java.awt.Font("Dialog", 0, 12));
        NextButton.setText("Next >");
        NextButton.setMnemonic('N');
        NextButton.setEnabled(false);
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });
        NextButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NextButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NextButtonMouseExited(evt);
            }
        });

        RightButtonPanel.add(NextButton);

        SouthNewProjectPanelBottomPanel.add(RightButtonPanel);

        SouthNewProjectPanel.add(SouthNewProjectPanelBottomPanel);

        NewProjectPanel.add(SouthNewProjectPanel, java.awt.BorderLayout.SOUTH);

        getContentPane().add(ContentPanel, java.awt.BorderLayout.NORTH);
	  setNewFileUIUpdate();
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        pack();
    }//GEN-END:initComponents

    private void NextButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextButtonMouseExited
        HelpStatusLabel.setText("");
    }//GEN-LAST:event_NextButtonMouseExited

    private void NextButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NextButtonMouseEntered
	if(currentIndex==0)
	{
		if(NextButton.isEnabled()==false)
		{ 
       		HelpStatusLabel.setText("Please create a new project or open an existing EvaluateAnywhere project first.");
		}
		else
		{
       		HelpStatusLabel.setText("Click to go to the \"Set Product Information\" step.");
		}
	}
	else if(currentIndex==1)
	{
       	HelpStatusLabel.setText("Click to go to the \"Set Features\" step.");
	}
	else if(getNavigateNextIndex()==3)
	{
       	HelpStatusLabel.setText("Click to go to the \"Set Evaluation Timer\" step.");
	}
	else if(getNavigateNextIndex()==4)
	{
       	HelpStatusLabel.setText("Click to go to the \"Set Opt-In Autoresponder Provider\" step.");
	}
	else if(getNavigateNextIndex()==5)
	{
		if(productOptinPanel.getSelectedOptinProviderIndex() == -1)
		{
			
		}
		else if(productOptinPanel.getSelectedOptinProviderIndex() == 0)
		{
        		HelpStatusLabel.setText("Click to go to the \"AWeber AutoResponder Configuration\" step.");
		}
		else if(productOptinPanel.getSelectedOptinProviderIndex() == 1)
		{
        		HelpStatusLabel.setText("Click to go to the \"GetResponse Autoresponder Configuration\" step.");
		}	
		else if(productOptinPanel.getSelectedOptinProviderIndex() == 2)
		{
        		HelpStatusLabel.setText("Click to go to the \"Unlisted Opt-In Provider Configuration\" step.");
		}
	}
	else if(getNavigateNextIndex()==6)
	{
       	HelpStatusLabel.setText("Click to go to the \"Set Payment Processing Provider\" step.");
	}
	else if(getNavigateNextIndex()==7)
	{
		if(productPaymentPanel.getSelectedOptinProviderIndex() == -1)
		{
			
		}
		else if(productPaymentPanel.getSelectedOptinProviderIndex() == 0)
		{
        		HelpStatusLabel.setText("Click to go to the \"Skipjack Payment Processing Configuration\" step.");
		}
		else if(productPaymentPanel.getSelectedOptinProviderIndex() == 1)
		{
        		HelpStatusLabel.setText("Click to go to the \"Payment Processing Web Page Configuration\" step.");
		}	
		else if(productPaymentPanel.getSelectedOptinProviderIndex() == 2)
		{
        		HelpStatusLabel.setText("Click to go to the \"Unlisted Payment Processing Provider Configuration\" step.");
		}
	}
	else if(getNavigateNextIndex()==8)
	{
        HelpStatusLabel.setText("Click to go to the \"Set Automatic Software Update Client Configuration\" step.");
	}
	else if(getNavigateNextIndex()==9)
	{
        HelpStatusLabel.setText("Click to go to the \"Set Message Client Configuration\" step.");
	}
	else if(getNavigateNextIndex()==10)
	{
       	HelpStatusLabel.setText("Click to go to the \"Set Main Class\" step.");
	}
	else if(getNavigateNextIndex()==11)
	{
        HelpStatusLabel.setText("Click to go to the \"Build Project\" step.");
	}
	else if(getNavigateNextIndex()==12)
	{
        HelpStatusLabel.setText("Click to Build EvaluateAnywhere Project.");
	}
	//else if(currentIndex==13)
	//{
	else if(getNavigateNextIndex()==13)
	{
        HelpStatusLabel.setText("Click to Try the EvaluateAnywhere Build.");
	}
	else
	{
       	//HelpStatusLabel.setText("Click to go to the next step.");
	}
    }//GEN-LAST:event_NextButtonMouseEntered

    private void AboutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AboutButtonMouseExited
        HelpStatusLabel.setText("");
    }//GEN-LAST:event_AboutButtonMouseExited

    private void AboutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AboutButtonMouseEntered
	if(currentIndex==0)
	{
        HelpStatusLabel.setText("Click to find out more about EvaluateAnywhere.");
	}
	else if(currentIndex==1)
	{
        HelpStatusLabel.setText("Click to go back to the \"Open Project\" step.");
	}
	else if(currentIndex==2)
	{
        HelpStatusLabel.setText("Click to go back to the \"Set Product Information\" step.");
	}
	else if(getNavigateBackIndex()==2)
	{
        HelpStatusLabel.setText("Click to go back to the \"Set Features\" step.");
	}
	else if(getNavigateBackIndex()==3)
	{
        HelpStatusLabel.setText("Click to go back to the \"Set Evaluation Timer\" step.");
	}
	else if(getNavigateBackIndex()==4)
	{
        HelpStatusLabel.setText("Click to go back to the \"Set Opt-In Autoresponder Provider\" step.");
	}
	else if(getNavigateBackIndex()==5)
	{
		if(optinCurrentIndex == -1)
		{
			
		}
		else if(optinCurrentIndex == 0)
		{
        		HelpStatusLabel.setText("Click to go back to the \"AWeber AutoResponder Configuration\" step.");
		}
		else if(optinCurrentIndex == 1)
		{
        		HelpStatusLabel.setText("Click to go back to the \"GetResponse Autoresponder Configuration\" step.");
		}	
		else if(optinCurrentIndex == 2)
		{
        		HelpStatusLabel.setText("Click to go back to the \"Unlisted Opt-In Provider Configuration\" step.");
		}
	}
	else if(getNavigateBackIndex()==6)
	{
        HelpStatusLabel.setText("Click to go back to the \"Set Payment Processing Provider\" step.");
	}
	else if(getNavigateBackIndex()==7)
	{
		if(paymentCurrentIndex == -1)
		{
			
		}
		else if(paymentCurrentIndex == 0)
		{
        		HelpStatusLabel.setText("Click to go back to the \"Skipjack Payment Processing Configuration\" step.");
		}
		else if(paymentCurrentIndex == 1)
		{
        		HelpStatusLabel.setText("Click to go back to the \"Payment Processing Web Page Configuration\" step.");
		}	
		else if(paymentCurrentIndex == 2)
		{
        		HelpStatusLabel.setText("Click to go back to the \"Unlisted Payment Processing Provider Configuration\" step.");
		}
	}
	else if(getNavigateBackIndex()==8)
	{
        HelpStatusLabel.setText("Click to go back to the \"Set Automatic Software Update Client Configuration\" step.");
	}
	else if(getNavigateBackIndex()==9)
	{
        HelpStatusLabel.setText("Click to go back to the \"Set Message Client Configuration\" step.");
	}
	else if(getNavigateBackIndex()==10)
	{
        HelpStatusLabel.setText("Click to go back to the \"Set Main Class\" step.");
	}
	else if(getNavigateBackIndex()==11)
	{
        HelpStatusLabel.setText("Click to go back to the \"Build Project\" step.");
	}
	else if(getNavigateBackIndex()==12)
	{
        HelpStatusLabel.setText("Click to go back to the \"Build Summary\" step.");
	}
	else
	{
        HelpStatusLabel.setText("Click to go back to the previous step.");
	}
    }//GEN-LAST:event_AboutButtonMouseEntered

    private void AdvancedDesignerButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdvancedDesignerButtonMouseExited
        HelpStatusLabel.setText("");
    }//GEN-LAST:event_AdvancedDesignerButtonMouseExited

    private void AdvancedDesignerButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdvancedDesignerButtonMouseEntered
      if(AdvancedDesignerButton.isEnabled()==false)
	{  
		HelpStatusLabel.setText("Please create a new project or open an existing EvaluateAnywhere project first.");
	}
	else
	{
		HelpStatusLabel.setText("Switch to EvaluateAnywhere's Advanced Designer.");
	}

    }//GEN-LAST:event_AdvancedDesignerButtonMouseEntered
   
 private void ProjectListValueChanged(javax.swing.event.ListSelectionEvent evt) {
	try
	{
        recentFileListArray = DesignerRuleBuilder.getRecentProjectsListWithTempFile();
        HelpStatusLabel.setText(new File(new URL(getSelectedListFileByProjectFileName((String)ProjectList.getSelectedValue())).getFile()).getCanonicalPath());
	}
	catch(Exception e)
	{
		//e.printStackTrace();
	}
    }

private String getSelectedListFileByProjectFileName(String strFileName)
{
	try
	{
	String[] stringArray2 = DesignerRuleBuilder.getRecentProjectsList();
	for(int i = 0;i<stringArray2.length;i++)
	{
		if(DesignerRuleBuilder.getProjectFileName(stringArray2[i]).equalsIgnoreCase(strFileName)==true)
		{
			return stringArray2[i];
		}
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return null;
	}
	return null;
}

    private void ProjectListMouseEntered(java.awt.event.MouseEvent evt) {
	try
	{
		if(ProjectList.getSelectedIndex()!=-1)
		{
        		HelpStatusLabel.setText(new File(new URL(recentFileListArray[ProjectList.getSelectedIndex()]).getFile()).getCanonicalPath());
		}
		else
		{
        		HelpStatusLabel.setText("Please create a new project or open an existing EvaluateAnywhere project first.");
		}		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

    private void ProjectListMouseExited(java.awt.event.MouseEvent evt) {
        HelpStatusLabel.setText("");
    }

    private void ExitButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitButtonMouseExited
        HelpStatusLabel.setText("");
    }//GEN-LAST:event_ExitButtonMouseExited

    private void ExitButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitButtonMouseEntered
        HelpStatusLabel.setText("Exit EvaluateAnywhere.");
    }//GEN-LAST:event_ExitButtonMouseEntered

    private static int optinCurrentIndex = -1;
    private static int paymentCurrentIndex = -1;
    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
	  try      
  	  {
		if(currentIndex==0)
		{
//Prep for Project Load
		try
		{
			if(launchInvisibleAdvancedDesigner()==true)
			{
		  		try      
  		  		{
					setFeaturesPanelArray();
        			}
        			catch(Exception e)
        			{
            			e.printStackTrace();
        			}  

				//Prep for Project Load Complete

				currentIndex=getNavigateNextIndex();
				getNavigateNextAction();
			}
		}
		catch(Exception e)
		{

		}
		}
		else if(currentIndex==1)
		{
			setFeaturesPanelArray();
			if(productInformationPanel!=null)
			{}
			else
			{
	  			productInformationPanel = new ProductInformationPanel();
	  			productInformationPanel.setParentComponent(this);
			}
			productInformationPanel.getDataUpdate();
			eaDesigner.getNewProjectWizardGUIUpdate();
			// Next Panel code goes below here
			currentStep++;
			currentIndex=getNavigateNextIndex();
			getNavigateNextAction();
		}
		else if(currentIndex==2)
		{
			buildFeatureSettings.getDataUpdate();
			setFeaturesPanelArray();
			eaDesigner.getNewProjectWizardGUIUpdate();
			//Next Frame code goes below here
			currentStep++;
			currentIndex=getNavigateNextIndex();
			getNavigateNextAction();
		}
		else if(currentIndex==3)
		{
			productEvaluationPanel.getDataUpdate();
			eaDesigner.getNewProjectWizardGUIUpdate();
			//Next Frame code goes below here
			currentStep++;
			currentIndex=getNavigateNextIndex();
			getNavigateNextAction();
		}
		else if(currentIndex==4)
		{
			productOptinPanel.getDataUpdate();
			if(productOptinPanel.getSelectedOptinProviderIndex()!=-1)
			{
				if(productOptinPanel.getSelectedOptinProviderIndex()==0)
				{
					optinCurrentIndex = 0;
					eaDesigner.getNewProjectWizardGUIUpdate();
					//Next Frame code goes below here
					currentStep++;
					currentIndex=getNavigateNextIndex();
					getNavigateNextAction();
				}
				else if(productOptinPanel.getSelectedOptinProviderIndex()==1)
				{
					optinCurrentIndex = 1;
					eaDesigner.getNewProjectWizardGUIUpdate();
					//Next Frame code goes below here
					currentStep++;
					currentIndex=getNavigateNextIndex();
					getNavigateNextAction();
				}
				if(productOptinPanel.getSelectedOptinProviderIndex()==2)
				{
					optinCurrentIndex = 2;
					eaDesigner.getNewProjectWizardGUIUpdate();
					//Next Frame code goes below here
					currentStep++;
					currentIndex=getNavigateNextIndex();
					getNavigateNextAction();
				}
			}
			else
			{
				eaDesigner.showMessageDialog("Select a provider, and click \"Next\" to proceed to the next step.");
			}
		}
		else if(currentIndex==5)
		{
			if(optinCurrentIndex == -1)
			{

			}
			else if(optinCurrentIndex == 0)
			{
				aWeberOptinProviderPanel.getDataUpdate();
			}
			else if(optinCurrentIndex == 1)
			{
				getRespOptinProviderPanel.getDataUpdate();
			}	
			else if(optinCurrentIndex == 2)
			{
				unlistedProviderOptinProviderPanel.getDataUpdate();
			}		
			eaDesigner.getNewProjectWizardGUIUpdate();
			//Next Frame code goes below here
			currentStep++;
			currentIndex=getNavigateNextIndex();
			getNavigateNextAction();
		}
		else if(currentIndex==6)
		{
			productPaymentPanel.getDataUpdate();
			if(productPaymentPanel.getSelectedOptinProviderIndex()!=-1)
			{
				if(productPaymentPanel.getSelectedOptinProviderIndex()==0)
				{
					paymentCurrentIndex = 0;
					eaDesigner.getNewProjectWizardGUIUpdate();
					//Next Frame code goes below here
					currentStep++;
					currentIndex=getNavigateNextIndex();
					getNavigateNextAction();
				}
				else if(productPaymentPanel.getSelectedOptinProviderIndex()==1)
				{
					paymentCurrentIndex = 1;
					eaDesigner.getNewProjectWizardGUIUpdate();
					//Next Frame code goes below here
					currentStep++;
					currentIndex=getNavigateNextIndex();
					getNavigateNextAction();
				}
				if(productPaymentPanel.getSelectedOptinProviderIndex()==2)
				{
					paymentCurrentIndex = 2;
					eaDesigner.getNewProjectWizardGUIUpdate();
					//Next Frame code goes below here
					currentStep++;
					currentIndex=getNavigateNextIndex();
					getNavigateNextAction();
				}
			}
			else
			{
				eaDesigner.showMessageDialog("Select a provider, and click \"Next\" to proceed to the next step.");
			}
		}
		else if(currentIndex==7)
		{
			if(paymentCurrentIndex == -1)
			{
			}
			else if(paymentCurrentIndex == 0)
			{
				skipjackPaymentProvider.getDataUpdate();
			}
			else if(paymentCurrentIndex == 1)
			{
				webPagePaymentProvider.getDataUpdate();
			}	
			else if(paymentCurrentIndex == 2)
			{
				unlistedProviderPaymentProviderPanel.getDataUpdate();
			}		
			eaDesigner.getNewProjectWizardGUIUpdate();
			//Next Frame code goes below here
			currentStep++;
			currentIndex=getNavigateNextIndex();
			getNavigateNextAction();
		}
		else if(currentIndex==8)
		{
			productAutoUpdatePanel.getDataUpdate();
			eaDesigner.getNewProjectWizardGUIUpdate();
			//Next Frame code goes below here
			currentStep++;
			currentIndex=getNavigateNextIndex();
			getNavigateNextAction();
		}
		else if(currentIndex==9)
		{
			productMessagingPanel.getDataUpdate();
			eaDesigner.getNewProjectWizardGUIUpdate();
			//Next Frame code goes below here
			currentStep++;
			currentIndex=getNavigateNextIndex();
			getNavigateNextAction();
		}
		else if(currentIndex==10)
		{
			productMainClassPanel.getDataUpdate();
			eaDesigner.getNewProjectWizardGUIUpdate();
			//Next Frame code goes below here
			currentStep++;
			currentIndex=getNavigateNextIndex();
			getNavigateNextAction();
		}
		else if(currentIndex==11)
		{
			if(buildProject()==0)
			{
				productBuildPanel.getDataUpdate();
				eaDesigner.getNewProjectWizardGUIUpdate();
				//Next Frame code goes below here
				currentStep++;
				currentIndex=getNavigateNextIndex();
				getNavigateNextAction();
			}
		}
		else if(currentIndex==12)
		{
            	eaDesigner.getEAPreview();
		}
		HelpStatusLabel.setText("");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }  
    }//GEN-LAST:event_NextButtonActionPerformed

    private void AboutButtonActionPerformed(java.awt.event.ActionEvent evt) {
	  try      
  	  {
		if(currentIndex==0)
		{
			currentIndex=0;
			if(DesignerRuleBuilder.get("actAboutAction")!=null)
			{
            		Class.forName(DesignerRuleBuilder.get("actAboutAction")).newInstance();
			}
			try
			{
     				setTitle(DesignerRuleBuilder.get("eaProductName") + " " + DesignerRuleBuilder.get("eaEditionName"));
			}
	  		catch(Exception e)
	  		{
				//e.printStackTrace();
	  		}
		}
		else if(currentIndex==1)
		{
			productInformationPanel.getDataUpdate();
			eaDesigner.getNewProjectWizardGUIUpdate();
			currentIndex=getNavigateBackIndex();
			getNavigateBackAction();
			try
			{
     				setTitle(DesignerRuleBuilder.get("eaProductName") + " " + DesignerRuleBuilder.get("eaEditionName"));
			}
	  		catch(Exception e)
	  		{
				//e.printStackTrace();
	  		}
		}
		else if(currentIndex==2)
		{
			buildFeatureSettings.getDataUpdate();
			eaDesigner.getNewProjectWizardGUIUpdate();
			currentStep--;
			currentIndex=getNavigateBackIndex();
			getNavigateBackAction();
		}
		else if(currentIndex==3)
		{
			productEvaluationPanel.getDataUpdate();
			eaDesigner.getNewProjectWizardGUIUpdate();
			currentStep--;
			currentIndex=getNavigateBackIndex();
			getNavigateBackAction();
		}
		else if(currentIndex==4)
		{
			productOptinPanel.getDataUpdate();
			eaDesigner.getNewProjectWizardGUIUpdate();
			currentStep--;
			currentIndex=getNavigateBackIndex();
			getNavigateBackAction();
		}
		else if(currentIndex==5)
		{
			if(optinCurrentIndex == -1)
			{

			}
			else if(optinCurrentIndex == 0)
			{
				aWeberOptinProviderPanel.getDataUpdate();
			}
			else if(optinCurrentIndex == 1)
			{
				getRespOptinProviderPanel.getDataUpdate();
			}	
			else if(optinCurrentIndex == 2)
			{
				unlistedProviderOptinProviderPanel.getDataUpdate();
			}
			eaDesigner.getNewProjectWizardGUIUpdate();
			currentStep--;
			currentIndex=getNavigateBackIndex();
			getNavigateBackAction();
		}
		else if(currentIndex==6)
		{
			productPaymentPanel.getDataUpdate();
			eaDesigner.getNewProjectWizardGUIUpdate();
			currentStep--;
			currentIndex=getNavigateBackIndex();
			getNavigateBackAction();
		}
		else if(currentIndex==7)
		{
			if(paymentCurrentIndex == -1)
			{

			}
			else if(paymentCurrentIndex == 0)
			{
				skipjackPaymentProvider.getDataUpdate();
			}
			else if(paymentCurrentIndex == 1)
			{
				webPagePaymentProvider.getDataUpdate();
			}	
			else if(paymentCurrentIndex == 2)
			{
				unlistedProviderPaymentProviderPanel.getDataUpdate();
			}	
			eaDesigner.getNewProjectWizardGUIUpdate();
			currentStep--;
			currentIndex=getNavigateBackIndex();
			getNavigateBackAction();
		}
		else if(currentIndex==8)
		{
			productAutoUpdatePanel.getDataUpdate();
			eaDesigner.getNewProjectWizardGUIUpdate();
			currentStep--;
			currentIndex=getNavigateBackIndex();
			getNavigateBackAction();
		}
		else if(currentIndex==9)
		{
			productMessagingPanel.getDataUpdate();
			eaDesigner.getNewProjectWizardGUIUpdate();
			currentStep--;
			currentIndex=getNavigateBackIndex();
			getNavigateBackAction();
		}
		else if(currentIndex==10)
		{
			productMainClassPanel.getDataUpdate();
			eaDesigner.getNewProjectWizardGUIUpdate();
			currentStep--;
			currentIndex=getNavigateBackIndex();
			getNavigateBackAction();
		}
		else if(currentIndex==11)
		{
			productBuildPanel.getDataUpdate();
			eaDesigner.getNewProjectWizardGUIUpdate();
			currentStep--;
			currentIndex=getNavigateBackIndex();
			getNavigateBackAction();
		}
		else if(currentIndex==12)
		{
			productBuildSummaryPanel.getDataUpdate();
			eaDesigner.getNewProjectWizardGUIUpdate();
			currentStep--;
			currentIndex=getNavigateBackIndex();
			getNavigateBackAction();
		}

        	HelpStatusLabel.setText("");
        }
        catch(InstantiationException e)
        {
            e.printStackTrace();
        }   
        catch(IllegalAccessException e)
        {
            e.printStackTrace();
        }                      
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }   
    }

    private void AdvancedDesignerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdvancedDesignerButtonActionPerformed
	  try      
  	  {
		if(currentIndex==0)
		{
			if(launchAdvancedDesigner()==true)
			{
				dispose();
			}
		}
		else
		{
			if(currentIndex==1)
			{
				productInformationPanel.getDataUpdate();
			}
			else if(currentIndex==2)
			{
				buildFeatureSettings.getDataUpdate();
			}
			else if(currentIndex==3)
			{
				productEvaluationPanel.getDataUpdate();
			}
			else if(currentIndex==4)
			{
				productOptinPanel.getDataUpdate();
			}
			else if(currentIndex==5)
			{
				if(optinCurrentIndex == -1)
				{
					
				}
				else if(optinCurrentIndex == 0)
				{
					aWeberOptinProviderPanel.getDataUpdate();
				}
				else if(optinCurrentIndex == 1)
				{
					getRespOptinProviderPanel.getDataUpdate();
				}	
				else if(optinCurrentIndex == 2)
				{
					unlistedProviderOptinProviderPanel.getDataUpdate();
				}
			}
			else if(currentIndex==6)
			{
				productPaymentPanel.getDataUpdate();
			}
			else if(currentIndex==7)
			{
				if(paymentCurrentIndex == -1)
				{

				}
				else if(paymentCurrentIndex == 0)
				{
					skipjackPaymentProvider.getDataUpdate();
				}
				else if(paymentCurrentIndex == 1)
				{
					webPagePaymentProvider.getDataUpdate();
				}	
				else if(paymentCurrentIndex == 2)
				{
					unlistedProviderPaymentProviderPanel.getDataUpdate();
				}				
			}
			else if(currentIndex==8)
			{
				productAutoUpdatePanel.getDataUpdate();
			}
			else if(currentIndex==9)
			{
				productMessagingPanel.getDataUpdate();
			}
			else if(currentIndex==10)
			{
				productMainClassPanel.getDataUpdate();
			}
			else if(currentIndex==11)
			{
				productBuildPanel.getDataUpdate();
			}
			else if(currentIndex==12)
			{
				productBuildSummaryPanel.getDataUpdate();
				eaDesigner.getTerminateEAPreview();
			}

			eaDesigner.getNewProjectWizardGUIUpdate();

			setVisible(false);
			eaDesigner.show();
			dispose();
		}
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }   
    }//GEN-LAST:event_AdvancedDesignerButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {
	  try      
  	  {

		if(currentIndex==1)
		{
			productInformationPanel.getDataUpdate();
			eaDesigner.getNewProjectWizardGUIUpdate();
		}
		else if(currentIndex==2)
		{
			buildFeatureSettings.getDataUpdate();
			eaDesigner.getNewProjectWizardGUIUpdate();
		}
		else if(currentIndex==3)
		{
			productEvaluationPanel.getDataUpdate();
			eaDesigner.getNewProjectWizardGUIUpdate();
		}
		else if(currentIndex==4)
		{
			productOptinPanel.getDataUpdate();
			eaDesigner.getNewProjectWizardGUIUpdate();
		}
		else if(currentIndex==5)
		{
			if(optinCurrentIndex == -1)
			{
				
			}
			else if(optinCurrentIndex == 0)
			{
				aWeberOptinProviderPanel.getDataUpdate();
			}
			else if(optinCurrentIndex == 1)
			{
				getRespOptinProviderPanel.getDataUpdate();
			}	
			else if(optinCurrentIndex == 2)
			{
				unlistedProviderOptinProviderPanel.getDataUpdate();
			}
			eaDesigner.getNewProjectWizardGUIUpdate();
		}
		else if(currentIndex==6)
		{
			productPaymentPanel.getDataUpdate();
			eaDesigner.getNewProjectWizardGUIUpdate();
		}
		else if(currentIndex==7)
		{
			if(paymentCurrentIndex == -1)
			{

			}
			else if(paymentCurrentIndex == 0)
			{
				skipjackPaymentProvider.getDataUpdate();
			}
			else if(paymentCurrentIndex == 1)
			{
				webPagePaymentProvider.getDataUpdate();
			}	
			else if(paymentCurrentIndex == 2)
			{
				unlistedProviderPaymentProviderPanel.getDataUpdate();
			}
			eaDesigner.getNewProjectWizardGUIUpdate();
		}
		else if(currentIndex==8)
		{
			productAutoUpdatePanel.getDataUpdate();
			eaDesigner.getNewProjectWizardGUIUpdate();
		}
		else if(currentIndex==9)
		{
			productMessagingPanel.getDataUpdate();
			eaDesigner.getNewProjectWizardGUIUpdate();
		}
		else if(currentIndex==10)
		{
			productMainClassPanel.getDataUpdate();
			eaDesigner.getNewProjectWizardGUIUpdate();
		}
		else if(currentIndex==11)
		{
			productBuildPanel.getDataUpdate();
			eaDesigner.getNewProjectWizardGUIUpdate();
		}
		else if(currentIndex==12)
		{
			productBuildSummaryPanel.getDataUpdate();
			eaDesigner.getTerminateEAPreview();
			eaDesigner.getNewProjectWizardGUIUpdate();
		}

		if(saveProjectIsSet==true)
		{
			//new EADesigner(null).show();
			if(eaDesigner!=null)
			{
				eaDesigner.setExitApplication();
			}
			else
			{
				if(DesignerRuleBuilder.get("actExitAction")!=null)
				{
            			Class.forName(DesignerRuleBuilder.get("actExitAction")).newInstance();
				}
			}
		}
		else
		{
			if(DesignerRuleBuilder.get("actExitAction")!=null)
			{
            		Class.forName(DesignerRuleBuilder.get("actExitAction")).newInstance();
			}
		}
        }
        catch(InstantiationException e)
        {
            e.printStackTrace();
        }   
        catch(IllegalAccessException e)
        {
            e.printStackTrace();
        }                      
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }     
    }

    JCheckBox cb = new JCheckBox();
    private void cbItemStateChanged(java.awt.event.ItemEvent evt) {
                        if(cb.isSelected()==true)
            		{
                			DesignerRuleBuilder.setEnclosedDirProject("true");
            		}
            		else
            		{
                			DesignerRuleBuilder.setEnclosedDirProject("false");
            		}
    }


  private void NewProjectSaveAsButtonActionPerformed(java.awt.event.ActionEvent evt) 
  {//GEN-FIRST:event_NewProjectSaveAsButtonActionPerformed
	setSaveAsProject();
    }//GEN-LAST:event_NewProjectSaveAsButtonActionPerformed

    private void NewProjectSaveAsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewProjectSaveAsButtonMouseExited
        HelpStatusLabel.setText("");
    }//GEN-LAST:event_NewProjectSaveAsButtonMouseExited

    private void NewProjectSaveAsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewProjectSaveAsButtonMouseEntered
        HelpStatusLabel.setText("Specify the file name of your project by clicking \"Save As...\"");         
    }//GEN-LAST:event_NewProjectSaveAsButtonMouseEntered

    private void NewProjectSaveAsTextFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewProjectSaveAsTextFieldMouseExited
        HelpStatusLabel.setText("");
    }//GEN-LAST:event_NewProjectSaveAsTextFieldMouseExited

    private void NewProjectSaveAsTextFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewProjectSaveAsTextFieldMouseEntered
			if(DesignerRuleBuilder.getTempProject()!=null)
			{
	try
	{
        HelpStatusLabel.setText(new File(new URL(DesignerRuleBuilder.getTempProject()).getFile()).getCanonicalPath());
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
			}
			else
			{
        			HelpStatusLabel.setText("Specify the file name of your project by clicking \"Save As...\"");
			}
			 



   }//GEN-LAST:event_NewProjectSaveAsTextFieldMouseEntered

    private void ProjectFileNameLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProjectFileNameLabelMouseExited
        HelpStatusLabel.setText("");
    }//GEN-LAST:event_ProjectFileNameLabelMouseExited

    private void ProjectFileNameLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProjectFileNameLabelMouseEntered
        // Add your handling code here:
    }//GEN-LAST:event_ProjectFileNameLabelMouseEntered

    private void rbOpenProjectButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbOpenProjectButtonMouseExited
        HelpStatusLabel.setText("");
    }//GEN-LAST:event_rbOpenProjectButtonMouseExited

    private void rbOpenProjectButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbOpenProjectButtonMouseEntered
        HelpStatusLabel.setText("Select if you want to open an existing EvaluateAnywhere project.");
    }//GEN-LAST:event_rbOpenProjectButtonMouseEntered

    private void rbNewProjectButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbNewProjectButtonMouseExited
        HelpStatusLabel.setText("");
    }//GEN-LAST:event_rbNewProjectButtonMouseExited

    private void rbNewProjectButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbNewProjectButtonMouseEntered
        HelpStatusLabel.setText("Select if you want to create a new EvaluateAnywhere project.");       
    }//GEN-LAST:event_rbNewProjectButtonMouseEntered

    private void rbOpenProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbOpenProjectButtonActionPerformed
	  currentIndex=0;
        setOpenFileUIUpdate();
    }//GEN-LAST:event_rbOpenProjectButtonActionPerformed

    private void rbNewProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNewProjectButtonActionPerformed
	  currentIndex=0;
        setNewFileUIUpdate();
    }//GEN-LAST:event_rbNewProjectButtonActionPerformed

    private void NewProjectSaveAsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewProjectSaveAsButtonMouseClicked
        // Add your handling code here:
    }//GEN-LAST:event_NewProjectSaveAsButtonMouseClicked
   
    /** set the currently displayed wizard image. */
    public void setWizardImage(ImageIcon theImage)
    {
		try
		{
			NewProjectImage.setIcon(theImage);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    /** set the currently displayed wizard panel description text. */
    public void setWizardDescriptionText(String panelDescription)
    {
	try
	{
		NewProjectDescription.setText(panelDescription);
	}
	catch(Exception e)
	{
		NewProjectDescription.setText("");	
	}
    }

    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        setVisible(false);
        System.exit(0);
    }//GEN-LAST:event_exitForm
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        new NewProject().show();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AboutButton;
    private javax.swing.JButton AdvancedDesignerButton;
    private javax.swing.JPanel CenterNewProjectPanel;
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JButton ExitButton;
    private javax.swing.JTextArea HelpStatusLabel;
    private javax.swing.JPanel HorizontalRulePanel;
    private javax.swing.JPanel LeftButtonPanel;
    private javax.swing.ButtonGroup NewOrExistingProjectButtonGroup;
    private javax.swing.JTextArea NewProjectDescription;
    private javax.swing.JPanel NewProjectDescriptionPanel;
    private javax.swing.JLabel NewProjectImage;
    private javax.swing.JPanel NewProjectImagePanel;
    private javax.swing.JPanel NewProjectPanel;
    private EAPanel NewProjectPanelFileBox;
    private javax.swing.JButton NewProjectSaveAsButton;
    private javax.swing.JTextField NewProjectSaveAsTextField;
    private javax.swing.JButton NextButton;
    private javax.swing.JPanel NorthNewProjectPanel;
    private javax.swing.JPanel NorthNewProjectPanelCenterPanel;
    private javax.swing.JPanel NorthNewProjectPanelSouthPanel;
    private javax.swing.JLabel ProjectFileNameLabel;
    private javax.swing.JPanel RightButtonPanel;
    private javax.swing.JPanel RightContentPanel;
    private javax.swing.JPanel SouthNewProjectPanel;
    private javax.swing.JPanel SouthNewProjectPanelBottomPanel;
    private javax.swing.JPanel SouthNewProjectPanelTopPanel;
    private javax.swing.JPanel SouthNewProjectPanelTopPanel1;
    private javax.swing.JPanel SouthNewProjectPanelTopPanel2;
    private javax.swing.JPanel SouthNewProjectPanelTopPanel3;
    private javax.swing.JRadioButton rbNewProjectButton;
    private javax.swing.JRadioButton rbOpenProjectButton;

    private ProductInformationPanel productInformationPanel = null;
    private BuildFeatureSettings buildFeatureSettings = null;
    private ProductEvaluationPanel productEvaluationPanel = null;

    // End of variables declaration//GEN-END:variables
    private void OpenProjectOpenOtherButtonMouseExited(java.awt.event.MouseEvent evt) {
           HelpStatusLabel.setText("");
    }

    private void OpenProjectOpenOtherButtonMouseEntered(java.awt.event.MouseEvent evt) {
        HelpStatusLabel.setText("Click to open another EvaluateAnywhere project.");
    }

    private void ProjectListScrollPaneMouseExited(java.awt.event.MouseEvent evt) {
        HelpStatusLabel.setText("");
    }

    private void ProjectListScrollPaneMouseEntered(java.awt.event.MouseEvent evt) {
        // Add your handling code here:
    }

    private void OpenProjectOpenOtherButtonActionPerformed(java.awt.event.ActionEvent evt) 
    {
    	setOpenOtherProject();
    }

    /** update the wizard middle header gui. */
    private void setHeaderUpdate()
    {
	try
	{
        	NorthNewProjectPanel.remove(NorthNewProjectPanelSouthPanel);
        	NorthNewProjectPanelSouthPanel = new javax.swing.JPanel();
		if(currentIndex==0)
		{
        		NorthNewProjectPanelSouthPanel.setLayout(new java.awt.BorderLayout(50, 0));
        		NorthNewProjectPanelSouthPanel.add(rbNewProjectButton, java.awt.BorderLayout.WEST);
        		NorthNewProjectPanelSouthPanel.add(rbOpenProjectButton, java.awt.BorderLayout.CENTER);
        		NorthNewProjectPanel.add(NorthNewProjectPanelSouthPanel, java.awt.BorderLayout.SOUTH);
			AboutButton.setText("About...");
			AboutButton.setMnemonic('b');
		}
		else
		{
        		NorthNewProjectPanelSouthPanel.setLayout(new java.awt.BorderLayout());
        		NorthNewProjectPanelSouthPanel.setMinimumSize(new java.awt.Dimension(0, 3));
        		NorthNewProjectPanelSouthPanel.setPreferredSize(new java.awt.Dimension(0, 3));
        		NorthNewProjectPanel.add(NorthNewProjectPanelSouthPanel, java.awt.BorderLayout.SOUTH);
			AboutButton.setText("< Back");
			AboutButton.setMnemonic('B');
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

    private javax.swing.JPanel InnerProjectListPanel;
    private javax.swing.JButton OpenProjectOpenOtherButton;
    private EAPanel OpenProjectPanelFileBox;
    private javax.swing.JList ProjectList;
    private ProductMainClassPanel productMainClassPanel = null;
    private ProductOptinPanel productOptinPanel = null;
    private UnlistedProviderOptinProviderPanel unlistedProviderOptinProviderPanel = null;
    private AWeberOptinProviderPanel aWeberOptinProviderPanel = null;
    private GetRespOptinProviderPanel getRespOptinProviderPanel = null;
    private ProductPaymentPanel productPaymentPanel = null;
    private UnlistedProviderPaymentProviderPanel unlistedProviderPaymentProviderPanel = null;
    private SkipjackPaymentProvider skipjackPaymentProvider = null;
    private WebPagePaymentProvider webPagePaymentProvider = null;
    private ProductMessagingPanel productMessagingPanel = null;
    private ProductAutoUpdatePanel productAutoUpdatePanel = null;
    private ProductBuildPanel productBuildPanel = null;
    private ProductBuildSummaryPanel productBuildSummaryPanel = null;
    private javax.swing.JScrollPane ProjectListScrollPane;
    private javax.swing.JPanel SouthOpenProjectPanelLeftPanel;
    private javax.swing.JPanel SouthOpenProjectPanelRightPanel;
    
    private void setOpenFileUIUpdate()
    {
	   	try
		{	
			rbOpenProjectButton.setSelected(true);
			rbNewProjectButton.setSelected(false);
			String[] theStrArray2 = getRecentFileListToFileNamesList(recentFileListArray = DesignerRuleBuilder.getRecentProjectsListWithTempFile());
					if(theStrArray2.length==0 || theStrArray2[0] == null || theStrArray2[0].equalsIgnoreCase("")==true)
					{
						ProjectList.setEnabled(false);
						AdvancedDesignerButton.setEnabled(false);
						NextButton.setText("Next >");
						NextButton.setMnemonic('N');
						NextButton.setEnabled(false);
       					setContentPanel(OpenProjectPanelFileBox);
        					CenterNewProjectPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "Open Recent Project"));
        					NewProjectDescription.setText("Select a project from the list of recent projects, or click \"Open Other...\" to browse for other projects.");
					}
					else
					{
						ProjectList.setSelectedIndex(0);
						NextButton.setText("Next >");
						NextButton.setMnemonic('N');
        					NextButton.setEnabled(true);
        					AdvancedDesignerButton.setEnabled(true);  
       					setContentPanel(OpenProjectPanelFileBox);
        					CenterNewProjectPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "Open Recent Project"));
        					NewProjectDescription.setText("Select a project from the list of recent projects, or click \"Open Other...\" to browse for other projects.");
   
					}

				}
				catch(Exception ee)
				{
						ProjectList.setEnabled(false);
						AdvancedDesignerButton.setEnabled(false);
						NextButton.setText("Next >");
						NextButton.setMnemonic('N');
						NextButton.setEnabled(false);
       					setContentPanel(OpenProjectPanelFileBox);
        					CenterNewProjectPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "Open Recent Project"));
        					NewProjectDescription.setText("Select a project from the list of recent projects, or click \"Open Other...\" to browse for other projects.");
				}
		try
		{
			NewProjectImage.setIcon(OpenProjectIcon);
			setHeaderUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

    private void setNewFileUIUpdate()
    {
	try
	{
	rbOpenProjectButton.setSelected(false);
	rbNewProjectButton.setSelected(true);
	if(saveProjectIsSet==false)
	{
	  NextButton.setText("Next >");
	  NextButton.setMnemonic('N');
        NextButton.setEnabled(false);
        AdvancedDesignerButton.setEnabled(false);
        setContentPanel(NewProjectPanelFileBox);
        CenterNewProjectPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "New Project"));
        NewProjectDescription.setText("Click the \"Save As...\" button and specify a file name for your EvaluateAnywhere project.");
		try
		{
			NewProjectImage.setIcon(NewProjectIcon);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	else
	{
	  NextButton.setText("Next >");
	  NextButton.setMnemonic('N');
        NextButton.setEnabled(false);
        AdvancedDesignerButton.setEnabled(false);
        setContentPanel(NewProjectPanelFileBox);
        CenterNewProjectPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "New Project"));
	}
	setHeaderUpdate();
	//setDialogBackgroundColor(new java.awt.Color(119, 151, 172));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

    private void setProductInformationUIUpdate()
    {
	try
	{
		if(productInformationPanel!=null)
		{
		}
		else
		{
  			productInformationPanel = new ProductInformationPanel();
  			productInformationPanel.setParentComponent(this);
		}
//	if(productInformationPanel.getDataEntryIsComplete()==false)
//	{
//        NextButton.setEnabled(false);
//        AdvancedDesignerButton.setEnabled(true);
//        setContentPanel(productInformationPanel);
//        CenterNewProjectPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "Product Information"));
//        NewProjectDescription.setText("Specify the product information for your EvaluateAnywhere project.");
//		try
//		{
//			NewProjectImage.setIcon(setInfoIcon);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//	}
//	else
//	{
	  NextButton.setText("Next >");
	  NextButton.setMnemonic('N');
        NextButton.setEnabled(true);
        AdvancedDesignerButton.setEnabled(true);
        setContentPanel(productInformationPanel);
        CenterNewProjectPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "Product Information"));
//	}

	setWizardDescriptionText("Specify the product information for your EvaluateAnywhere project.");
	setWizardImage(setInfoIcon);
	setHeaderUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

    private void setFeaturesUIUpdate()
    {
	try
	{
		if(buildFeatureSettings!=null)
		{}
		else
		{
  			buildFeatureSettings = new BuildFeatureSettings();
  			buildFeatureSettings.setParentComponent(this);
		}
		NextButton.setText("Next >");
		NextButton.setMnemonic('N');
        	NextButton.setEnabled(true);
        	AdvancedDesignerButton.setEnabled(true);
        	setContentPanel(buildFeatureSettings);
        	CenterNewProjectPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "Features"));

		setWizardDescriptionText("Select the features for your EvaluateAnywhere project.");
		setWizardImage(setFeaturesIcon);
		setHeaderUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

    private void setMainClassPanelUIUpdate()
    {
	try
	{
		if(productMainClassPanel!=null)
		{}
		else
		{
  			productMainClassPanel = new ProductMainClassPanel();
  			productMainClassPanel.setParentComponent(this);
		}
		NextButton.setText("Next >");
		NextButton.setMnemonic('N');
        	NextButton.setEnabled(true);
        	AdvancedDesignerButton.setEnabled(true);
        	setContentPanel(productMainClassPanel);
        	CenterNewProjectPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "Specify Your Main Class"));

		setWizardDescriptionText("Type the name of the Java application main class in the text field.");
		setWizardImage(setMainClassIcon);
		setHeaderUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

    private void setEvaluationPanelUIUpdate()
    {
	try
	{
		setDialogBackgroundColor(defaultColor);
		if(productEvaluationPanel!=null)
		{}
		else
		{
  			productEvaluationPanel = new ProductEvaluationPanel();
  			productEvaluationPanel.setParentComponent(this);
		}
		NextButton.setText("Next >");
		NextButton.setMnemonic('N');
        	NextButton.setEnabled(true);
        	AdvancedDesignerButton.setEnabled(true);
        	setContentPanel(productEvaluationPanel);
        	CenterNewProjectPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "Timed Evaluation Expiration Processing Configuration"));

		setWizardDescriptionText("Type the time to elapse, before the software evaluation expires. Check the \"Disable Expired Software\" checkbox to lockout application use upon evaluation expiration.");
		setWizardImage(setEvaluationIcon);
		setHeaderUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

    private void setOptinProviderPanelUIUpdate()
    {
	try
	{
		setDialogBackgroundColor(defaultColor);
		if(productOptinPanel!=null)
		{}
		else
		{
  			productOptinPanel = new ProductOptinPanel();
  			productOptinPanel.setParentComponent(this);
		}
		NextButton.setText("Next >");
		NextButton.setMnemonic('N');
        	NextButton.setEnabled(true);
        	AdvancedDesignerButton.setEnabled(true);
        	setContentPanel(productOptinPanel);
        	CenterNewProjectPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "Opt-In Autoresponder Providers"));

		setWizardDescriptionText("Select an Opt-In Autoresponder Preferred Provider from the Providers list, or select \"Unlisted Provider\" from the Providers list to configure a Provider not in the list.");
        	NewProjectImage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        	NewProjectImage.setBackground(new java.awt.Color(255,255,255));
        	NewProjectImagePanel.setBackground(new java.awt.Color(255,255,255));
        	NewProjectImage.setMaximumSize(new java.awt.Dimension(125, 76));
        	NewProjectImage.setMinimumSize(new java.awt.Dimension(125,76));
        	NewProjectImage.setPreferredSize(new java.awt.Dimension(125,76));
		setWizardImage(setOptinProviderIcon);
		setHeaderUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

    private void setOptinUnlistedProviderPanelUIUpdate()
    {
	try
	{
		if(unlistedProviderOptinProviderPanel!=null)
		{}
		else
		{
  			unlistedProviderOptinProviderPanel = new UnlistedProviderOptinProviderPanel();
  			unlistedProviderOptinProviderPanel.setParentComponent(this);
		}
		NextButton.setText("Next >");
		NextButton.setMnemonic('N');
        	NextButton.setEnabled(true);
        	AdvancedDesignerButton.setEnabled(true);
        	setContentPanel(unlistedProviderOptinProviderPanel);
        	CenterNewProjectPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "Unlisted Provider Configuration"));

		setWizardDescriptionText("An Unlisted Provider must be configured through the Advanced Designer. Click the \"Next\" button to continue to the next step.");
        	NewProjectImage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        	NewProjectImage.setMaximumSize(new java.awt.Dimension(125, 76));
        	NewProjectImage.setMinimumSize(new java.awt.Dimension(125,76));
        	NewProjectImage.setPreferredSize(new java.awt.Dimension(125,76));
		setWizardImage(setUnlistedProviderIcon);
		setHeaderUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

    private void setOptinAWeberPanelUIUpdate()
    {
	try
	{
		if(aWeberOptinProviderPanel!=null)
		{}
		else
		{
  			aWeberOptinProviderPanel = new AWeberOptinProviderPanel();
  			aWeberOptinProviderPanel.setParentComponent(this);
		}
		NextButton.setText("Next >");
		NextButton.setMnemonic('N');
        	NextButton.setEnabled(true);
        	AdvancedDesignerButton.setEnabled(true);
        	setContentPanel(aWeberOptinProviderPanel);
        	CenterNewProjectPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "AWeber AutoResponder Configuration"));

		setWizardDescriptionText("Specify your AWeber AutoResponder list name, and click the \"Next\" button to continue to the next step.");
        	NewProjectImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        	NewProjectImage.setMaximumSize(new java.awt.Dimension(165, 62));
        	NewProjectImage.setMinimumSize(new java.awt.Dimension(165,62));
        	NewProjectImage.setPreferredSize(new java.awt.Dimension(165,62));
		setWizardImage(setAWeberProviderIcon);
		setHeaderUpdate();
		setDialogBackgroundColor(new java.awt.Color(228, 210, 159));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

private void setDialogBackgroundColor(Color bgColor)
{
	try
	{
        setBackground(bgColor);
        ContentPanel.setBackground(bgColor);
        NewProjectPanel.setBackground(bgColor);
        NorthNewProjectPanel.setBackground(bgColor);
        NorthNewProjectPanelCenterPanel.setBackground(bgColor);
        NewProjectImagePanel.setBackground(bgColor);
        NewProjectDescription.setBackground(bgColor);
        NorthNewProjectPanelSouthPanel.setBackground(bgColor);
        CenterNewProjectPanel.setBackground(bgColor);
        RightContentPanel.setBackground(bgColor);
        NewProjectPanelFileBox.setBackground(bgColor);
        SouthNewProjectPanelTopPanel1.setBackground(bgColor);
        SouthNewProjectPanelTopPanel3.setBackground(bgColor);
        SouthNewProjectPanel.setBackground(bgColor);
        SouthNewProjectPanelTopPanel.setBackground(bgColor);
        HelpStatusLabel.setBackground(bgColor);
        HorizontalRulePanel.setBackground(bgColor);
        SouthNewProjectPanelBottomPanel.setBackground(bgColor);
        LeftButtonPanel.setBackground(bgColor);
        ExitButton.setBackground(bgColor);
        AdvancedDesignerButton.setBackground(bgColor);
        RightButtonPanel.setBackground(bgColor);
        AboutButton.setBackground(bgColor);
        NextButton.setBackground(bgColor);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

    private void setOptinGetResponsePanelUIUpdate()
    {
	try
	{
		if(getRespOptinProviderPanel!=null)
		{}
		else
		{
  			getRespOptinProviderPanel = new GetRespOptinProviderPanel();
  			getRespOptinProviderPanel.setParentComponent(this);
		}
		NextButton.setText("Next >");
		NextButton.setMnemonic('N');
        	NextButton.setEnabled(true);
        	AdvancedDesignerButton.setEnabled(true);
        	setContentPanel(getRespOptinProviderPanel);
        	CenterNewProjectPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "GetResponse Autoresponder Configuration"));

		setWizardDescriptionText("Specify your GetResponse Autoresponder list name, and click the \"Next\" button to continue to the next step.");
        	NewProjectImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        	NewProjectImage.setMaximumSize(new java.awt.Dimension(160, 62));
        	NewProjectImage.setMinimumSize(new java.awt.Dimension(160,62));
        	NewProjectImage.setPreferredSize(new java.awt.Dimension(160,62));
		setWizardImage(setGetResponseProviderIcon);
		setHeaderUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

    private void setPaymentProviderPanelUIUpdate()
    {
	try
	{
		setDialogBackgroundColor(defaultColor);
		if(productPaymentPanel!=null)
		{}
		else
		{
  			productPaymentPanel = new ProductPaymentPanel();
  			productPaymentPanel.setParentComponent(this);
		}
		NextButton.setText("Next >");
		NextButton.setMnemonic('N');
        	NextButton.setEnabled(true);
        	AdvancedDesignerButton.setEnabled(true);
        	setContentPanel(productPaymentPanel);
        	CenterNewProjectPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "Payment Processing Providers"));

		setWizardDescriptionText("Select a Payment Processing Gateway Preferred Provider from the Providers list, or select \"Unlisted Provider\" from the Providers list to configure a Provider not in the list.");
        	NewProjectImage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        	NewProjectImage.setBackground(new java.awt.Color(255,255,255));
        	NewProjectImagePanel.setBackground(new java.awt.Color(255,255,255));
        	NewProjectImage.setMaximumSize(new java.awt.Dimension(125, 76));
        	NewProjectImage.setMinimumSize(new java.awt.Dimension(125,76));
        	NewProjectImage.setPreferredSize(new java.awt.Dimension(125,76));
        	NewProjectImage.setBackground(new Color(255,255,255));
        	NewProjectImagePanel.setBackground(new Color(255,255,255));
		setWizardImage(setPaymentProviderIcon);
		setDialogBackgroundColor(defaultColor);
		setHeaderUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

    private void setPaymentUnlistedProviderPanelUIUpdate()
    {
	try
	{
		if(unlistedProviderPaymentProviderPanel!=null)
		{}
		else
		{
  			unlistedProviderPaymentProviderPanel = new UnlistedProviderPaymentProviderPanel();
  			unlistedProviderPaymentProviderPanel.setParentComponent(this);
		}
		NextButton.setText("Next >");
		NextButton.setMnemonic('N');
        	NextButton.setEnabled(true);
        	AdvancedDesignerButton.setEnabled(true);
        	setContentPanel(unlistedProviderPaymentProviderPanel);
        	CenterNewProjectPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "Unlisted Provider Configuration"));

		setWizardDescriptionText("An Unlisted Provider must be configured through the Advanced Designer. Click the \"Next\" button to continue to the next step.");
        	NewProjectImage.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        	NewProjectImage.setMaximumSize(new java.awt.Dimension(125, 76));
        	NewProjectImage.setMinimumSize(new java.awt.Dimension(125,76));
        	NewProjectImage.setPreferredSize(new java.awt.Dimension(125,76));
		setWizardImage(setUnlistedProviderIcon);
		setHeaderUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

    private void setSkipjackPanelUIUpdate()
    {
	try
	{
		if(skipjackPaymentProvider!=null)
		{}
		else
		{
  			skipjackPaymentProvider = new SkipjackPaymentProvider();
  			skipjackPaymentProvider.setParentComponent(this);
		}
		NextButton.setText("Next >");
		NextButton.setMnemonic('N');
        	NextButton.setEnabled(true);
        	AdvancedDesignerButton.setEnabled(true);
        	setContentPanel(skipjackPaymentProvider);
        	CenterNewProjectPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "Skipjack Payment Processing Configuration"));

		setWizardDescriptionText("Specify your Skipjack Account HTML Processing Serial Number, Product Price, and click the \"Finish\" button to generate the Payment Processing configuration.");
        	NewProjectImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        	NewProjectImage.setMaximumSize(new java.awt.Dimension(165, 76));
        	NewProjectImage.setMinimumSize(new java.awt.Dimension(165,76));
        	NewProjectImage.setPreferredSize(new java.awt.Dimension(165,76));
        	NewProjectImage.setBackground(new Color(255,255,255));
        	NewProjectImagePanel.setBackground(new Color(255,255,255));
		setWizardImage(setSkipjackProviderIcon);
		setHeaderUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

    private void setWebPaymentPanelUIUpdate()
    {
	try
	{
		if(webPagePaymentProvider!=null)
		{}
		else
		{
  			webPagePaymentProvider = new WebPagePaymentProvider();
  			webPagePaymentProvider.setParentComponent(this);
		}
		NextButton.setText("Next >");
		NextButton.setMnemonic('N');
        	NextButton.setEnabled(true);
        	AdvancedDesignerButton.setEnabled(true);
        	setContentPanel(webPagePaymentProvider);
        	CenterNewProjectPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "Payment Processing Web Page Configuration"));

		setWizardDescriptionText("Specify your Payment Processing Web Page URL, and click the \"Next\" button to generate the Payment Processing configuration.");
        	NewProjectImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        	NewProjectImage.setMaximumSize(new java.awt.Dimension(125, 76));
        	NewProjectImage.setMinimumSize(new java.awt.Dimension(125, 76));
        	NewProjectImage.setPreferredSize(new java.awt.Dimension(125, 76));
		setWizardImage(setPaymentWebProviderIcon);
		setHeaderUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

    private void setAutoUpdatePanelUIUpdate()
    {
	try
	{
		setDialogBackgroundColor(defaultColor);
		if(productAutoUpdatePanel!=null)
		{}
		else
		{
  			productAutoUpdatePanel = new ProductAutoUpdatePanel();
  			productAutoUpdatePanel.setParentComponent(this);
		}
		NextButton.setText("Next >");
		NextButton.setMnemonic('N');
        	NextButton.setEnabled(true);
        	AdvancedDesignerButton.setEnabled(true);
        	setContentPanel(productAutoUpdatePanel);
        	//CenterNewProjectPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "Automatic Software Update Client Configuration"));
CenterNewProjectPanel.setBorder(null);

		setWizardDescriptionText("Type the Software Update File Download URL. The Software Update File Download URL is the location on your website the \"update.eal\" file will be located.");
        	NewProjectImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        	NewProjectImage.setMaximumSize(new java.awt.Dimension(125, 76));
        	NewProjectImage.setMinimumSize(new java.awt.Dimension(125, 76));
        	NewProjectImage.setPreferredSize(new java.awt.Dimension(125, 76));
		setWizardImage(setAutoUpdateIcon);
		setHeaderUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

    private void setMessagingPanelUIUpdate()
    {
	try
	{
		setDialogBackgroundColor(defaultColor);
		if(productMessagingPanel!=null)
		{}
		else
		{
  			productMessagingPanel = new ProductMessagingPanel();
  			productMessagingPanel.setParentComponent(this);
		}
		NextButton.setText("Next >");
		NextButton.setMnemonic('N');
        	NextButton.setEnabled(true);
        	AdvancedDesignerButton.setEnabled(true);
        	setContentPanel(productMessagingPanel);
        	//CenterNewProjectPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "Message Client Configuration"));
		CenterNewProjectPanel.setBorder(null);
		setWizardDescriptionText("Type the Message File Download URL. The Message File Download URL is the location on your website the \"message.eam\" file will be located.");
        	NewProjectImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        	NewProjectImage.setMaximumSize(new java.awt.Dimension(125, 76));
        	NewProjectImage.setMinimumSize(new java.awt.Dimension(125, 76));
        	NewProjectImage.setPreferredSize(new java.awt.Dimension(125, 76));
		setWizardImage(setMessagingIcon);
		setHeaderUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

    private void setBuildPanelUIUpdate()
    {
	try
	{
		setDialogBackgroundColor(defaultColor);
		if(productBuildPanel!=null)
		{}
		else
		{
  			productBuildPanel = new ProductBuildPanel();
  			productBuildPanel.setParentComponent(this);
  			productBuildPanel.setParentComp(eaDesigner);
  			productBuildPanel.setProjectData();
		}
        	NextButton.setEnabled(true);
		NextButton.setText("Build");
		NextButton.setMnemonic('u');
        	AdvancedDesignerButton.setEnabled(true);
        	setContentPanel(productBuildPanel);
        	CenterNewProjectPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "Build Output Location"));

		setWizardDescriptionText("Click \"Build\" to create EvaluateAnywhere application support.");
        	NewProjectImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        	NewProjectImage.setMaximumSize(new java.awt.Dimension(125, 76));
        	NewProjectImage.setMinimumSize(new java.awt.Dimension(125, 76));
        	NewProjectImage.setPreferredSize(new java.awt.Dimension(125, 76));
		setWizardImage(setBuildIcon);
		setHeaderUpdate();
  		productBuildPanel.setParentComp(eaDesigner);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }

    private void setBuildSummaryPanelUIUpdate()
    {
	try
	{
		if(productBuildSummaryPanel!=null)
		{}
		else
		{
  			productBuildSummaryPanel = new ProductBuildSummaryPanel();
  			productBuildSummaryPanel.setParentComponent(this);
  			productBuildSummaryPanel.setParentComp(eaDesigner);
  			productBuildSummaryPanel.setProjectData();
		}

        	NextButton.setEnabled(true);
            // If no evaluation/registration/payment processing features enabled set product value to registered so features like messaging/auto-update/(possibly opt-in) function
            if(ProjectManager.get("project_expiration_support_is_enabled").equalsIgnoreCase("false") == true)
            {
                if(ProjectManager.get("project_registration_code_support_is_enabled").equalsIgnoreCase("false") == true)
                {
                    if(ProjectManager.get("project_payment_processing_support_is_enabled").equalsIgnoreCase("false") == true)
                    {
     				NextButton.setEnabled(false);
                    }
                }
            } 
            //
		NextButton.setText("Try");
		NextButton.setMnemonic('T');
        	AdvancedDesignerButton.setEnabled(true);
        	setContentPanel(productBuildSummaryPanel);
        	CenterNewProjectPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "Build Summary"));

		setWizardDescriptionText("Click the \"Try\" button to try the EvaluateAnywhere application support.");
        	NewProjectImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        	NewProjectImage.setMaximumSize(new java.awt.Dimension(125, 76));
        	NewProjectImage.setMinimumSize(new java.awt.Dimension(125, 76));
        	NewProjectImage.setPreferredSize(new java.awt.Dimension(125, 76));
		setWizardImage(setBuildSummaryIcon);
		setHeaderUpdate();
  		productBuildPanel.setParentComp(eaDesigner);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
    }


  private EAPanel TheContentPanelReference = new EAPanel();
  private void setContentPanel(EAPanel theContentPanel)
  {
    try
    {
	  TheContentPanelReference.setVisible(false);
        RightContentPanel.remove(TheContentPanelReference);        
        TheContentPanelReference = theContentPanel;
        RightContentPanel.add(TheContentPanelReference);     
        TheContentPanelReference.setVisible(true);

    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
  }    

  private JPanel TheWizardPanelReference = new JPanel();
  private void setWizardPanel(JPanel theWizardPanel)
  {
    try
    {
	TheWizardPanelReference.setVisible(false);
        ContentPanel.remove(TheWizardPanelReference);        
        TheWizardPanelReference = theWizardPanel;
        ContentPanel.add(TheWizardPanelReference, java.awt.BorderLayout.CENTER);     
        TheWizardPanelReference.setVisible(true);

    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
  }  

    private int buildProject()
    {
        try
        {
            try
            {
                eaDesigner.setSaveEAProject();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
		int retCode = new EACompiler().uiCompile(new File(new URL(ProjectManager.get("project_build_dir")).getFile()));
		int retCodeJarBuild = new EACompiler().buildJar(new File(new URL(ProjectManager.get("project_build_dir")).getFile()));
		if(retCodeJarBuild!=0)
		{
			retCode=10 + retCodeJarBuild;
		}
            if(retCode==0)
		{
			buildStatus = 0;
        	      ProjectManager.saveSinglePut("project_last_built",new Date().toString());
			if(productBuildPanel!=null)
			{
				productBuildPanel.setProjectData();
			}
        		//eaDesigner.showMessageDialog("Build Completed Successfully.");
			return 0;
  		}
		else
		{
			buildStatus = retCode;
        		eaDesigner.showMessageDialog("Build Failed. Return Code: " + String.valueOf(retCode));
			return retCode;
		}
        }
        catch(Exception e)
        {
		e.printStackTrace();
        }
	return 1;
    }

    private Object[] getStringArraysFromString(String textArrayString)
    {
        ArrayList aryList = new ArrayList();
        String tempString = "";
        try
        {
            while(textArrayString.indexOf(",")!=-1)
            {
                tempString = textArrayString.substring(0,textArrayString.indexOf(","));
                textArrayString = textArrayString.substring(textArrayString.indexOf(",") + 1);
                aryList.add(tempString);
            }
            aryList.add(textArrayString);
            aryList.trimToSize();
        }
        catch(NullPointerException e)
        {
         
        }

        return aryList.toArray();
    }

      private boolean saveFileExists(String saveFileURL2)
	{
		for(int i = 0;i<saveFileArray.length;i++)
		{
			if(saveFileURL2.equalsIgnoreCase(saveFileArray[i])==true)
			{
				return true;
			}
		}
		return false;
	}
 
      private void setSaveAsProject(String saveFileURL2)
	{
		saveProjectIsSet=true;
		saveFileURL=saveFileURL2;
		String[] tempStringArray = new String[saveFileArray.length + 1];
		tempStringArray[0]=saveFileURL2;
		if(saveFileArray.length>0)
		{
			for(int i = 1;i<saveFileArray.length;i++)
			{
				tempStringArray[i]=saveFileArray[i-1];
			}
		}
		recentFileListArray = tempStringArray;
	}

private void setSaveAsProject()
{
	  // Begin Save As
        boolean isCreated=false;
        try
        {
            fileView.putIcon("eax", new javax.swing.ImageIcon(getClass().getResource("/images/lgpl/eaicon16.png")));
            fc.setFileView(fileView);
            filter.addExtension("eax");
            filter.setDescription("EvaluateAnywhere Project Files");
            fc.setFileFilter(filter);    
            fc.setDialogTitle("Save new project as");
            
                if(DesignerRuleBuilder.get("prjDefaultCreateEnclosingFolder")!=null)
                {
                    if(DesignerRuleBuilder.get("prjDefaultCreateEnclosingFolder").equalsIgnoreCase("true")==true)
                    {
     			       cb.setSelected(true);
			  }
			  else
		  	  {
 		           cb.setSelected(false);
			  }
		   }

            cb.setText("Create Enclosing Folder for Project");
        cb.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbItemStateChanged(evt);
            }
        });
            JPanel jcomp = (JPanel)fc.getComponent(2);
            jcomp.add(cb,java.awt.BorderLayout.SOUTH);
		fc.setSelectedFile(new File("My_Product.eax"));

    		int returnVal = fc.showSaveDialog(this); 
	      if(returnVal == JFileChooser.APPROVE_OPTION) 
		{
            URL theProjectURL = fc.getSelectedFile().toURL();
	      if(theProjectURL.toString().endsWith(".eax")==false)
		{
			try
			{
				theProjectURL = new URL(theProjectURL.toString() + ".eax");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
            if(DesignerRuleBuilder.setTempProject(theProjectURL.toString())==true)
            {
			if(DesignerRuleBuilder.getTempProject()!=null)
			{
				NewProjectSaveAsTextField.setText(DesignerRuleBuilder.getProjectFileName(DesignerRuleBuilder.getTempProject()));
				NextButton.setEnabled(true);
        			AdvancedDesignerButton.setEnabled(true);
				try
				{	
					ProjectList.setEnabled(true);
					ProjectList.setListData(getRecentFileListToFileNamesList(recentFileListArray = DesignerRuleBuilder.getRecentProjectsListWithTempFile()));
					setSaveAsProject(DesignerRuleBuilder.getTempProject());
					ProjectList.setSelectedIndex(0);
					try
					{
     						setTitle(DesignerRuleBuilder.get("eaProductName") + " " + DesignerRuleBuilder.get("eaEditionName") + " - " + DesignerRuleBuilder.getProjectFileName(DesignerRuleBuilder.getTempProject()).substring(0,DesignerRuleBuilder.getProjectFileName(DesignerRuleBuilder.getTempProject()).lastIndexOf(".")) + " (" + DesignerRuleBuilder.getProjectFileName(DesignerRuleBuilder.getTempProject()) + ")");
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
                //System.out.println("Successfully set save file vars in Designer Rules.");                
            }
            else
            {
                //System.out.println("Failed to set save file vars in Designer Rules.");
            }
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
}


/** A call to setTempProject(String strFileURL) must be made prior to using this method. */
private void setSaveAsProjectNoGUI()
{
	  // Begin Save As
        boolean isCreated=false;
        try
        {
            URL theProjectURL = new URL(DesignerRuleBuilder.getTempProject());
	      if(theProjectURL.toString().endsWith(".eax")==false)
		{
			try
			{
				theProjectURL = new URL(theProjectURL.toString() + ".eax");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
            if(DesignerRuleBuilder.setTempProject(theProjectURL.toString())==true)
            {
			if(DesignerRuleBuilder.getTempProject()!=null)
			{
				NewProjectSaveAsTextField.setText(DesignerRuleBuilder.getProjectFileName(DesignerRuleBuilder.getTempProject()));
				NextButton.setEnabled(true);
        			AdvancedDesignerButton.setEnabled(true);
				try
				{	
					ProjectList.setEnabled(true);
					ProjectList.setListData(getRecentFileListToFileNamesList(recentFileListArray = DesignerRuleBuilder.getRecentProjectsListWithTempFile()));
					setSaveAsProject(DesignerRuleBuilder.getTempProject());
					ProjectList.setSelectedIndex(0);
					try
					{
     						setTitle(DesignerRuleBuilder.get("eaProductName") + " " + DesignerRuleBuilder.get("eaEditionName") + " - " + DesignerRuleBuilder.getProjectFileName(DesignerRuleBuilder.getTempProject()).substring(0,DesignerRuleBuilder.getProjectFileName(DesignerRuleBuilder.getTempProject()).lastIndexOf(".")) + " (" + DesignerRuleBuilder.getProjectFileName(DesignerRuleBuilder.getTempProject()) + ")");
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
                //System.out.println("Successfully set save file vars in Designer Rules.");                
            }
            else
            {
                //System.out.println("Failed to set save file vars in Designer Rules.");
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
}

private void setOpenOtherProject()
{
	try
	{
            fileView.putIcon("eax", new javax.swing.ImageIcon(getClass().getResource("/images/lgpl/eaicon16.png")));
            fc.setFileView(fileView);
            filter.addExtension("eax");
            filter.setDescription("EvaluateAnywhere Project Files");
            fc.setFileFilter(filter);    
            fc.setDialogTitle("Open Project File");

    		int returnVal = fc.showOpenDialog(this);
	      if(returnVal == JFileChooser.APPROVE_OPTION) 
		{
            File selFile = fc.getSelectedFile();
            URL theProjectURL = fc.getSelectedFile().toURL();
            if(selFile.exists()==false)
            {
                if(DesignerRuleBuilder.setTempProject(theProjectURL.toString())==true)
                {
	                setSaveAsProjectNoGUI();
		    }
			else
			{
				System.out.println("Failure setting Temp Project.");
			}

            }
            else
            {
                if(DesignerRuleBuilder.setTempProject(theProjectURL.toString())==true)
                {
    			if(DesignerRuleBuilder.getTempProject()!=null)
			{
				try
				{	
					ProjectList.setEnabled(true);
					ProjectList.setListData(getRecentFileListToFileNamesList(recentFileListArray = DesignerRuleBuilder.getRecentProjectsListWithTempFile()));
					setOpenOtherProject(DesignerRuleBuilder.getTempProject());
					ProjectList.setSelectedIndex(0);
					try
					{
     						setTitle(DesignerRuleBuilder.get("eaProductName") + " " + DesignerRuleBuilder.get("eaEditionName") + " - " + DesignerRuleBuilder.getProjectFileName(DesignerRuleBuilder.getTempProject()).substring(0,DesignerRuleBuilder.getProjectFileName(DesignerRuleBuilder.getTempProject()).lastIndexOf(".")) + " (" + DesignerRuleBuilder.getProjectFileName(DesignerRuleBuilder.getTempProject()) + ")");
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
				setOpenFileUIUpdate();
			}
			

                  //System.out.println("Successfully set open file vars in Designer Rules."); 
                }
                else
                {
                    //System.out.println("Failed to set open file vars in Designer Rules.");
                }
            }
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
}    

      private void setOpenOtherProject(String openFileURL2)
	{
		saveProjectIsSet=false;
		saveFileURL=openFileURL2;
		String[] tempStringArray = new String[saveFileArray.length + 1];
		tempStringArray[0]=openFileURL2;
		if(saveFileArray.length>0)
		{
			for(int i = 1;i<saveFileArray.length;i++)
			{
				tempStringArray[i]=saveFileArray[i-1];
			}
		}
	}

	private boolean launchAdvancedDesigner()
	{
		//ProgressWindow progWindow = new ProgressWindow();
		//try
		//{
  		//progWindow.showStatus("Launching Advanced Designer", 0);
		/* Sets the Currently Selected Project List File */
		setSelectedProjectListItem();
		if(saveProjectIsSet==true)
		{
			if(saveFileExists(DesignerRuleBuilder.getTempProject())==true)
			{
		  		try      
	  	  		{
					setVisible(false);
					new EADesigner(false).show();
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
					setVisible(false);
					new EADesigner(true).show();
 	       		}
 	       		catch(Exception e)
 	      		 {
    	       		   e.printStackTrace();
 	      		 }   
			}
		}
		else
		{
		if(getProjectExists()==true)
		{
			try      
	  		{
				setVisible(false);
				new EADesigner(false).show();
 	      	}
  	      	catch(Exception e)
  	      	{
  	       		   e.printStackTrace();
				  //progWindow.close();
   		      }   	
		}
		else
		{
			//Project does not exist
			if(ProjectNotFoundDialog.showDialog(null, "EvaluateAnywhere Project", DesignerRuleBuilder.getTempProject()) == 1)
			{
				DesignerRuleBuilder.removeProjectFromRecentFilesList(DesignerRuleBuilder.getTempProject());
			}
			ProjectList.setListData(getRecentFileListToFileNamesList(recentFileListArray = (String[])DesignerRuleBuilder.getRecentProjectsList()));
			ProjectList.setSelectedIndex(0);
			setOpenFileUIUpdate();
			return false;
		}	
	    }
	    return true;
	//}
	//catch(Exception ee)
	//{
	//	ee.printStackTrace();
	//	progWindow.close();
	//}
	//  progWindow.close();
	}

	private boolean getProjectExists()
	{
		try
		{
			return new File(new URL(DesignerRuleBuilder.getTempProject()).getFile()).exists();
		}
		catch(Exception e)
		{
			return false;
		}
	}

	private boolean launchInvisibleAdvancedDesigner()
	{
		/* Sets the Currently Selected Project List File */
		setSelectedProjectListItem();
		if(saveProjectIsSet==true)
		{
			if(saveFileExists(DesignerRuleBuilder.getTempProject())==true)
			{
		  		try      
	  	  		{
					eaDesigner = new EADesigner(false);
					eaDesigner.hide();
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
					eaDesigner = new EADesigner(true);
					eaDesigner.hide();
 	       		}
 	       		catch(Exception e)
 	      		 {
    	       		   e.printStackTrace();
 	      		 }   
			}
		}
		else
		{
		if(getProjectExists()==true)
		{
			try      
	  		{
				eaDesigner = new EADesigner(false);
				eaDesigner.hide();
 	       	}
  	      	catch(Exception e)
  	      	{
  	       		e.printStackTrace();
   	      	}   	
		}
		else
		{
			//Project does not exist
			if(ProjectNotFoundDialog.showDialog(null, "EvaluateAnywhere Project", DesignerRuleBuilder.getTempProject()) == 1)
			{
				DesignerRuleBuilder.removeProjectFromRecentFilesList(DesignerRuleBuilder.getTempProject());
			}
			ProjectList.setListData(getRecentFileListToFileNamesList(recentFileListArray = (String[])DesignerRuleBuilder.getRecentProjectsList()));
			ProjectList.setSelectedIndex(0);
			setOpenFileUIUpdate();
			return false;
		}
	    }
		return true;
	}

	/** Set the status line text in the New Project Wizard. */
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


	private String[] getRecentFileListToFileNamesList(String[] strArray)
	{
	
		String[] tempStrArray = new String[strArray.length];
		try
		{
		for(int i=0;i<strArray.length;i++)
		{
			tempStrArray[i]=DesignerRuleBuilder.getProjectFileName(strArray[i]);
		}
			return tempStrArray;
		}
		catch(Exception e)
		{
			return tempStrArray;
		}
	}
	
	private void setSelectedProjectListItem()
	{
		try
		{
			if(ProjectList.getSelectedIndex()!=-1)
			{
				DesignerRuleBuilder.setTempProject(recentFileListArray[ProjectList.getSelectedIndex()]);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private void initialize(int intPanel)
	{
		try
		{
			newProjectWizardPanelNames = getStringArraysFromString(DesignerRuleBuilder.get("prjWizardPanels"));
			if(intPanel==0)
			{	
				DesignerRuleBuilder.setTempProject("");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
