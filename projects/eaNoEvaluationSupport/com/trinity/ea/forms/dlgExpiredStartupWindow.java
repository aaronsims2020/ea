/*
 * dlgExpiredStartupWindow.java
 *
 * Created on October 23, 2003, 11:10 PM
 */

package com.trinity.ea.forms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
import com.trinity.ea.util.Trial;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2003 Trinity Software. All rights reserved.
 */
public class dlgExpiredStartupWindow extends javax.swing.JDialog {
    
    /** Creates new form StartupWindow */
    public dlgExpiredStartupWindow(java.awt.Frame parent, boolean modal) {
        super(parent,false);
        initComponents();
        setSize(553,440);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = getSize().width;
        int h = getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        setLocation(x, y);   
        long days  = Trial.getRunTimeBeforeExpiration() / (1000 * 60 * 60 * 24);
	daysLeft.setText("Expired. Buy Now, or enter your software registration number.");
        try
        {
            setTitle(EncryptedRuleReader.get("startWindowTitle"));
        }
        catch(Exception e){}

    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        btnUseEvaluation = new javax.swing.JButton();
        btnBuyNow = new javax.swing.JButton();
        btnEnterRegistrationCode = new javax.swing.JButton();
        SplashScreenImageArea = new javax.swing.JLabel();
        DaysLeftLabel = new javax.swing.JLabel();
        daysLeft = new javax.swing.JLabel();
        lEvaluateAnywhereInfo = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setModal(true);
        setName("dlgStartWindow");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        btnUseEvaluation.setFont(new java.awt.Font("Arial", 0, 12));
        btnUseEvaluation.setText("Use Evaluation Version");
	  btnUseEvaluation.setEnabled(false);
        btnUseEvaluation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUseEvaluationActionPerformed(evt);
            }
        });

        getContentPane().add(btnUseEvaluation);
        btnUseEvaluation.setBounds(10, 340, 170, 26);

        btnBuyNow.setFont(new java.awt.Font("Arial", 0, 12));
        btnBuyNow.setText("Buy Now");
        btnBuyNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyNowActionPerformed(evt);
            }
        });

        getContentPane().add(btnBuyNow);
        btnBuyNow.setBounds(190, 340, 170, 26);

        btnEnterRegistrationCode.setFont(new java.awt.Font("Arial", 0, 12));
        btnEnterRegistrationCode.setText("Enter Registration Code");
        btnEnterRegistrationCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterRegistrationCodeActionPerformed(evt);
            }
        });

        getContentPane().add(btnEnterRegistrationCode);
        btnEnterRegistrationCode.setBounds(370, 340, 170, 26);

        SplashScreenImageArea.setBackground(new java.awt.Color(255, 255, 255));
        SplashScreenImageArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/splash.JPG")));
        getContentPane().add(SplashScreenImageArea);
        SplashScreenImageArea.setBounds(10, 10, 530, 320);

        DaysLeftLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        DaysLeftLabel.setText("Days Left:");
        getContentPane().add(DaysLeftLabel);
        DaysLeftLabel.setBounds(30, 380, 60, 16);

        daysLeft.setFont(new java.awt.Font("Dialog", 0, 12));
        daysLeft.setText("0");
        getContentPane().add(daysLeft);
        daysLeft.setBounds(90, 380, 400, 16);

        lEvaluateAnywhereInfo.setFont(new java.awt.Font("Arial", 0, 10));
        lEvaluateAnywhereInfo.setText("Free Trial Software created with EvaluateAnywhere by Trinity Software, \u00a92003. www.evaluateanywhere.com");
        lEvaluateAnywhereInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lEvaluateAnywhereInfoMouseClicked(evt);
            }
        });

        getContentPane().add(lEvaluateAnywhereInfo);
        lEvaluateAnywhereInfo.setBounds(30, 400, 520, 15);

        pack();
    }//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
                         System.exit(0);
    }//GEN-LAST:event_closeDialog

    private void lEvaluateAnywhereInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lEvaluateAnywhereInfoMouseClicked
            // TODO: Command Line implementation
            // TODO: MIDP implementation
            // Trial Expired
            //System.out.println("Attempting to read property expired action. ");
            if(EncryptedRuleReader.get("startWindowBottomLabelAction")!=null)
            {
                try
                {
                    //dispose();
                    Class.forName(EncryptedRuleReader.get("startWindowBottomLabelAction")).newInstance();
                }
                catch(InstantiationException e)
                {
                    System.out.println(e);
                }   
                catch(IllegalAccessException e)
                {
                    System.out.println(e);
                }                      
                catch(ClassNotFoundException e)
                {
                    System.out.println(e);
                }       
            }
            else
            {
                //Problem in Properties File
            }            
    }//GEN-LAST:event_lEvaluateAnywhereInfoMouseClicked

    private void btnEnterRegistrationCodeActionPerformed(java.awt.event.ActionEvent evt) {
                // TODO: Command Line implementation
                // TODO: MIDP implementation
                // Trial Expired
                //System.out.println("Attempting to read property expired action. ");
                if(EncryptedRuleReader.get("enterRegistrationCodeAction")!=null)
                {
                    try
                    {
                        //dispose();
                        Class.forName(EncryptedRuleReader.get("enterRegistrationCodeAction")).newInstance();
                    }
                    catch(InstantiationException e)
                    {
                        System.out.println(e);
                    }   
                    catch(IllegalAccessException e)
                    {
                        System.out.println(e);
                    }                      
                    catch(ClassNotFoundException e)
                    {
                        System.out.println(e);
                    }       
                }
                else
                {
                    //Problem in Properties File
                }        
    }

    private void btnUseEvaluationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUseEvaluationActionPerformed

    }//GEN-LAST:event_btnUseEvaluationActionPerformed
    private void btnBuyNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyNowActionPerformed
                if(EncryptedRuleReader.get("buyNowAction")!=null)
                {
                    try
                    {
                        //dispose();
                        Class.forName(EncryptedRuleReader.get("buyNowAction")).newInstance();
                    }
                    catch(InstantiationException e)
                    {
                        System.out.println(e);
                    }   
                    catch(IllegalAccessException e)
                    {
                        System.out.println(e);
                    }                      
                    catch(ClassNotFoundException e)
                    {
                        System.out.println(e);
                    }       
                }
                else
                {
                    //Problem in Properties File
                }
    }//GEN-LAST:event_btnBuyNowActionPerformed
    /** Closes the Window */
    private void closeWindow(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeWindow
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeWindow
    
    /**
     * @param args the command line arguments
     */
 /*   public static void main(String args[]) {
        new dlgExpiredStartupWindow(new javax.swing.JFrame(), true).show();
    }
  */  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DaysLeftLabel;
    private javax.swing.JLabel SplashScreenImageArea;
    private javax.swing.JButton btnBuyNow;
    private javax.swing.JButton btnEnterRegistrationCode;
    private javax.swing.JButton btnUseEvaluation;
    private javax.swing.JLabel daysLeft;
    private javax.swing.JLabel lEvaluateAnywhereInfo;
    // End of variables declaration//GEN-END:variables
    
}
