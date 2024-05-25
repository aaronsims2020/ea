/*
 * CustomProviderMainPanel.java
 *
 * Created on April 26, 2004, 6:21 PM
 */

package com.trinity.ea.design.optin.provider.panels;
import com.trinity.ea.design.common.panel.EAPanel;
import com.trinity.ea.design.optin.provider.panels.CustomOptinProvider;
import com.trinity.ea.design.optin.provider.panels.OptinWizardMainPanel;
import com.trinity.ea.design.rules.builder.DesignerRuleBuilder;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JOptionPane;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004 Trinity Software. All rights reserved.
 */
public class CustomProviderMainPanel extends EAPanel{
    
    private CustomOptinProvider customOptinProvider = new CustomOptinProvider();
    /** Creates new form CustomProviderMainPanel */
    public CustomProviderMainPanel() {
	  super();
        initComponents();
        //customOptinProvider.setMasterStatusController(this);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        ContentPanel = new javax.swing.JPanel();
        NewProjectPanel = new javax.swing.JPanel();
        NorthNewProjectPanel = new javax.swing.JPanel();
        NorthNewProjectPanelCenterPanel = new javax.swing.JPanel();
        NewProjectImagePanel = new javax.swing.JPanel();
        NewProjectImage = new javax.swing.JLabel();
        NewProjectDescriptionPanel = new javax.swing.JPanel();
        NewProjectDescription = new javax.swing.JTextArea();
        NorthNewProjectPanelSouthPanel = new javax.swing.JPanel();
        CenterNewProjectPanel = new javax.swing.JPanel();
        RightContentPanel = new javax.swing.JPanel();
        NewProjectPanelFileBox = new javax.swing.JPanel();
        SouthNewProjectPanelTopPanel1 = new javax.swing.JPanel();
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

        setLayout(new java.awt.BorderLayout());

        ContentPanel.setLayout(new java.awt.BorderLayout());

        ContentPanel.setBorder(new javax.swing.border.EmptyBorder(new java.awt.Insets(15, 15, 15, 15)));
        ContentPanel.setMinimumSize(new java.awt.Dimension(450, 350));
        ContentPanel.setPreferredSize(new java.awt.Dimension(450, 350));
        NewProjectPanel.setLayout(new java.awt.BorderLayout());

        NewProjectPanel.setBackground(new java.awt.Color(204, 204, 204));
        NewProjectPanel.setMinimumSize(new java.awt.Dimension(450, 320));
        NewProjectPanel.setPreferredSize(new java.awt.Dimension(450, 320));
        NorthNewProjectPanel.setLayout(new java.awt.BorderLayout());

        NorthNewProjectPanel.setBackground(getBackground());
        NorthNewProjectPanelCenterPanel.setLayout(new java.awt.BorderLayout(10,10));

        NorthNewProjectPanelCenterPanel.setBackground(getBackground());
        NewProjectImagePanel.setLayout(new javax.swing.BoxLayout(NewProjectImagePanel, javax.swing.BoxLayout.X_AXIS));

        NewProjectImagePanel.setBackground(new java.awt.Color(204, 204, 204));
        NewProjectImagePanel.setBorder(new javax.swing.border.EtchedBorder());
        NewProjectImagePanel.setMaximumSize(new java.awt.Dimension(131, 76));
        NewProjectImagePanel.setMinimumSize(new java.awt.Dimension(131, 76));
        NewProjectImagePanel.setPreferredSize(new java.awt.Dimension(131, 76));
        NewProjectImagePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NewProjectImagePanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NewProjectImagePanelMouseExited(evt);
            }
        });

        NewProjectImage.setBackground(new java.awt.Color(255, 255, 255));
        NewProjectImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NewProjectImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/unlistedprovider.png")));
        NewProjectImage.setIconTextGap(0);
        NewProjectImagePanel.add(NewProjectImage);

        NorthNewProjectPanelCenterPanel.add(NewProjectImagePanel, java.awt.BorderLayout.WEST);

        NewProjectDescriptionPanel.setLayout(new java.awt.BorderLayout());

        NewProjectDescriptionPanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.EtchedBorder(), null));
        NewProjectDescription.setBackground(getBackground());
        NewProjectDescription.setEditable(false);
        NewProjectDescription.setLineWrap(true);
        NewProjectDescription.setText("An Unlisted Provider must be configured through the Advanced Designer. Click the \"Finish\" button to create the Unlisted Provider Opt-In configuration.");
        NewProjectDescription.setWrapStyleWord(true);
        NewProjectDescription.setMargin(new java.awt.Insets(7, 10, 7, 10));
        NewProjectDescriptionPanel.add(NewProjectDescription, java.awt.BorderLayout.CENTER);

        NorthNewProjectPanelCenterPanel.add(NewProjectDescriptionPanel, java.awt.BorderLayout.CENTER);

        NorthNewProjectPanel.add(NorthNewProjectPanelCenterPanel, java.awt.BorderLayout.CENTER);

        NorthNewProjectPanelSouthPanel.setLayout(new java.awt.BorderLayout());

        NorthNewProjectPanelSouthPanel.setBackground(getBackground());
        NorthNewProjectPanelSouthPanel.setMaximumSize(new java.awt.Dimension(2147483647, 15));
        NorthNewProjectPanelSouthPanel.setMinimumSize(new java.awt.Dimension(0, 15));
        NorthNewProjectPanelSouthPanel.setPreferredSize(new java.awt.Dimension(0, 15));
        NorthNewProjectPanel.add(NorthNewProjectPanelSouthPanel, java.awt.BorderLayout.SOUTH);

        NewProjectPanel.add(NorthNewProjectPanel, java.awt.BorderLayout.NORTH);

        CenterNewProjectPanel.setLayout(new javax.swing.BoxLayout(CenterNewProjectPanel, javax.swing.BoxLayout.Y_AXIS));

        CenterNewProjectPanel.setBackground(getBackground());
        CenterNewProjectPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "Unlisted Provider Configuration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        RightContentPanel.setLayout(new java.awt.BorderLayout());

        RightContentPanel.setBackground(getBackground());
        NewProjectPanelFileBox.setLayout(new javax.swing.BoxLayout(NewProjectPanelFileBox, javax.swing.BoxLayout.Y_AXIS));

        NewProjectPanelFileBox.setBackground(getBackground());
        SouthNewProjectPanelTopPanel1.setBackground(getBackground());
        SouthNewProjectPanelTopPanel1.setMaximumSize(new java.awt.Dimension(32767, 50));
        SouthNewProjectPanelTopPanel1.setMinimumSize(new java.awt.Dimension(10, 50));
        SouthNewProjectPanelTopPanel1.setPreferredSize(new java.awt.Dimension(10, 50));
        NewProjectPanelFileBox.add(SouthNewProjectPanelTopPanel1);

        SouthNewProjectPanelTopPanel3.setBackground(getBackground());
        SouthNewProjectPanelTopPanel3.setMaximumSize(new java.awt.Dimension(32767, 50));
        SouthNewProjectPanelTopPanel3.setMinimumSize(new java.awt.Dimension(10, 50));
        SouthNewProjectPanelTopPanel3.setPreferredSize(new java.awt.Dimension(10, 50));
        NewProjectPanelFileBox.add(SouthNewProjectPanelTopPanel3);

        RightContentPanel.add(NewProjectPanelFileBox, java.awt.BorderLayout.EAST);

        RightContentPanel.add(customOptinProvider, java.awt.BorderLayout.CENTER);
        CenterNewProjectPanel.add(RightContentPanel);

        NewProjectPanel.add(CenterNewProjectPanel, java.awt.BorderLayout.CENTER);

        SouthNewProjectPanel.setLayout(new javax.swing.BoxLayout(SouthNewProjectPanel, javax.swing.BoxLayout.Y_AXIS));

        SouthNewProjectPanel.setBackground(getBackground());
        SouthNewProjectPanelTopPanel.setLayout(new java.awt.BorderLayout());

        SouthNewProjectPanelTopPanel.setBackground(getBackground());
        HelpStatusLabel.setBackground(getBackground());
        HelpStatusLabel.setEditable(false);
        HelpStatusLabel.setFont(new java.awt.Font("Dialog", 0, 10));
        HelpStatusLabel.setMargin(new java.awt.Insets(5, 10, 0, 0));
        HelpStatusLabel.setMaximumSize(new java.awt.Dimension(2147483647, 25));
        HelpStatusLabel.setMinimumSize(new java.awt.Dimension(0, 25));
        HelpStatusLabel.setPreferredSize(new java.awt.Dimension(0, 25));
        SouthNewProjectPanelTopPanel.add(HelpStatusLabel, java.awt.BorderLayout.NORTH);

        HorizontalRulePanel.setBackground(getBackground());
        HorizontalRulePanel.setBorder(new javax.swing.border.EtchedBorder());
        HorizontalRulePanel.setMaximumSize(new java.awt.Dimension(32767, 2));
        HorizontalRulePanel.setMinimumSize(new java.awt.Dimension(10, 2));
        HorizontalRulePanel.setPreferredSize(new java.awt.Dimension(10, 2));
        SouthNewProjectPanelTopPanel.add(HorizontalRulePanel, java.awt.BorderLayout.SOUTH);

        SouthNewProjectPanel.add(SouthNewProjectPanelTopPanel);

        SouthNewProjectPanelBottomPanel.setLayout(new javax.swing.BoxLayout(SouthNewProjectPanelBottomPanel, javax.swing.BoxLayout.X_AXIS));

        SouthNewProjectPanelBottomPanel.setBackground(getBackground());
        LeftButtonPanel.setLayout(new java.awt.FlowLayout());

        LeftButtonPanel.setBackground(getBackground());
        ExitButton.setBackground(getBackground());
        ExitButton.setFont(new java.awt.Font("Dialog", 0, 12));
        ExitButton.setMnemonic('C');
        ExitButton.setText("Cancel");
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

        AdvancedDesignerButton.setBackground(getBackground());
        AdvancedDesignerButton.setFont(new java.awt.Font("Dialog", 0, 12));
        AdvancedDesignerButton.setMnemonic('A');
        AdvancedDesignerButton.setText("Advanced Designer");
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

        RightButtonPanel.setLayout(new java.awt.FlowLayout());

        RightButtonPanel.setBackground(getBackground());
        AboutButton.setBackground(getBackground());
        AboutButton.setFont(new java.awt.Font("Dialog", 0, 12));
        AboutButton.setMnemonic('B');
        AboutButton.setText("< Back");
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

        NextButton.setBackground(getBackground());
        NextButton.setFont(new java.awt.Font("Dialog", 0, 12));
        NextButton.setMnemonic('F');
        NextButton.setText("Finish");
        NextButton.setEnabled(true);
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

        ContentPanel.add(NewProjectPanel, java.awt.BorderLayout.CENTER);

        add(ContentPanel, java.awt.BorderLayout.NORTH);

    }//GEN-END:initComponents


    private void NextButtonMouseExited(java.awt.event.MouseEvent evt) {
        setStatus("");
    }

    private void NextButtonMouseEntered(java.awt.event.MouseEvent evt) {
	if(NextButton.isEnabled()==false)
	{ 
       setStatus("Please specify an Unlisted Provider list name first.");
	}
	else
	{
       setStatus("Click to start the Unlisted Provider Opt-In configuration through the Advanced Designer.");
	}

    }

    private void AboutButtonMouseExited(java.awt.event.MouseEvent evt) {
        setStatus("");
    }

    private void AboutButtonMouseEntered(java.awt.event.MouseEvent evt) {
        setStatus("Click to go back to the previous step.");
    }

    private void AdvancedDesignerButtonMouseExited(java.awt.event.MouseEvent evt) {
        setStatus("");
    }

    private void AdvancedDesignerButtonMouseEntered(java.awt.event.MouseEvent evt) {
      if(AdvancedDesignerButton.isEnabled()==false)
	{  
		//setStatus("Please create a new project or open an existing EvaluateAnywhere project first.");
	}
	else
	{
		setStatus("Switch to EvaluateAnywhere's Advanced Designer.");
	}

    }

    private void NewProjectImagePanelMouseExited(java.awt.event.MouseEvent evt) {
        setStatus(""); 
    }

    private void NewProjectImagePanelMouseEntered(java.awt.event.MouseEvent evt) {
        setStatus("");
    }    

    private void ExitButtonMouseExited(java.awt.event.MouseEvent evt) {
        setStatus("");
    }

    private void ExitButtonMouseEntered(java.awt.event.MouseEvent evt) {
        setStatus("Cancel");
    }    


    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {
	  try      
  	  {
		//customOptinProvider.getDataUpdate();
		parentObj.setFinishConfigurationAction();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }	 
    }

    private void AboutButtonActionPerformed(java.awt.event.ActionEvent evt) {
	  try      
  	  {
		if(parentObj!=null)
		{
			parentObj.setBack();
		}
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }   
    }

    private void AdvancedDesignerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        parentObj.setLaunchAdvancedDesigner();
    }

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {
	  try      
  	  {
        	parentObj.setLaunchAdvancedDesigner();
		//	if(DesignerRuleBuilder.get("actExitAction")!=null)
		//	{
            //		Class.forName(DesignerRuleBuilder.get("actExitAction")).newInstance();
		//	}
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }   
        //catch(IllegalAccessException e)
        //{
        //    e.printStackTrace();
        //}                      
        //catch(ClassNotFoundException e)
        //{
        //    e.printStackTrace();
        //}  
    }

    OptinWizardMainPanel parentObj = null;
    public void setMasterStatusController(Object parentObject)
    {
        parentObj = (OptinWizardMainPanel)parentObject;
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
    private javax.swing.JTextArea NewProjectDescription;
    private javax.swing.JPanel NewProjectDescriptionPanel;
    private javax.swing.JLabel NewProjectImage;
    private javax.swing.JPanel NewProjectImagePanel;
    private javax.swing.JPanel NewProjectPanel;
    private javax.swing.JPanel NewProjectPanelFileBox;
    private javax.swing.JButton NextButton;
    private javax.swing.JPanel NorthNewProjectPanel;
    private javax.swing.JPanel NorthNewProjectPanelCenterPanel;
    private javax.swing.JPanel NorthNewProjectPanelSouthPanel;
    private javax.swing.JPanel RightButtonPanel;
    private javax.swing.JPanel RightContentPanel;
    private javax.swing.JPanel SouthNewProjectPanel;
    private javax.swing.JPanel SouthNewProjectPanelBottomPanel;
    private javax.swing.JPanel SouthNewProjectPanelTopPanel;
    private javax.swing.JPanel SouthNewProjectPanelTopPanel1;
    private javax.swing.JPanel SouthNewProjectPanelTopPanel3;
    // End of variables declaration//GEN-END:variables

    protected void setStatus(String statusText)
    {
        HelpStatusLabel.setText(statusText);
    }
}
