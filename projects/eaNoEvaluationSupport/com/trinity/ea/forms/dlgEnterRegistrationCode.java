/*
 * EnterRegistrationCode.java
 *
 * Created on October 24, 2003, 2:38 AM
 */

package com.trinity.ea.forms;
import javax.swing.*;
import java.awt.*;
import com.trinity.ea.rules.reader.EncryptedRuleReader;
/**
 *
 * @author  aaronsc Trinity Software
 * Copyright �2003 Trinity Software. All rights reserved.
 */
public class dlgEnterRegistrationCode extends javax.swing.JDialog 
{
    
    /** Creates new form EnterRegistrationCode */
    public dlgEnterRegistrationCode(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
        setSize(340,285);
        setResizable(false);       
        // Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        int w = getSize().width;
        int h = getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        try
        {
            setTitle(EncryptedRuleReader.get("registerSoftwareWindowTitle"));
        }
        catch(Exception e){}

        // Move the window
        setLocation(x, y);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        tfRegistrationCode = new javax.swing.JTextField();
        lRegistrationCode = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        taDescription = new javax.swing.JTextArea();
        lDescriptionHeader = new javax.swing.JLabel();
        lNotPaidDescriptionHeader = new javax.swing.JLabel();
        taNotPaidDescription = new javax.swing.JTextArea();

        getContentPane().setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        getContentPane().add(tfRegistrationCode);
        tfRegistrationCode.setBounds(20, 190, 300, 20);

        lRegistrationCode.setFont(new java.awt.Font("Arial", 0, 12));
        lRegistrationCode.setText(EncryptedRuleReader.get("registrationCodeLabel"));
        getContentPane().add(lRegistrationCode);
        lRegistrationCode.setBounds(20, 170, 160, 15);

        btnRegister.setFont(new java.awt.Font("Arial", 0, 12));
        btnRegister.setText("Finish");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        getContentPane().add(btnRegister);
        btnRegister.setBounds(250, 220, 68, 25);

        btnCancel.setFont(new java.awt.Font("Arial", 0, 12));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        getContentPane().add(btnCancel);
        btnCancel.setBounds(170, 220, 73, 25);

        taDescription.setBackground(new java.awt.Color(204, 204, 204));
        taDescription.setLineWrap(true);
        taDescription.setRows(2);
        taDescription.setText(EncryptedRuleReader.get("registrationPaidLabel"));
        taDescription.setWrapStyleWord(true);
        getContentPane().add(taDescription);
        taDescription.setBounds(20, 30, 300, 33);

        lDescriptionHeader.setFont(new java.awt.Font("Arial", 1, 12));
        lDescriptionHeader.setText(EncryptedRuleReader.get("registrationPaidHeaderLabel"));
        getContentPane().add(lDescriptionHeader);
        lDescriptionHeader.setBounds(20, 10, 300, 15);

        lNotPaidDescriptionHeader.setFont(new java.awt.Font("Arial", 1, 12));
        lNotPaidDescriptionHeader.setText(EncryptedRuleReader.get("registrationUnpaidHeaderLabel"));
        getContentPane().add(lNotPaidDescriptionHeader);
        lNotPaidDescriptionHeader.setBounds(20, 70, 300, 15);

        taNotPaidDescription.setBackground(new java.awt.Color(204, 204, 204));
        taNotPaidDescription.setLineWrap(true);
        taNotPaidDescription.setRows(2);
        taNotPaidDescription.setText(EncryptedRuleReader.get("registrationUnpaidLabel"));
        taNotPaidDescription.setWrapStyleWord(true);
        getContentPane().add(taNotPaidDescription);
        taNotPaidDescription.setBounds(20, 90, 300, 65);

        pack();
    }//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
            EncryptedRuleReader.readPropertiesFile();
            if(EncryptedRuleReader.register(tfRegistrationCode.getText().trim())==true)
            {
                if(EncryptedRuleReader.get("registrationSuccessUIAction")!=null)
                {
                    try
                    {
                        dispose();
                        Class.forName(EncryptedRuleReader.get("registrationSuccessUIAction")).newInstance();
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
            else
            {
                if(EncryptedRuleReader.get("registrationFailedUIAction")!=null)
                {
                    try
                    {
                        Class.forName(EncryptedRuleReader.get("registrationFailedUIAction")).newInstance();
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
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new dlgEnterRegistrationCode(new javax.swing.JFrame(), true).show();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel lDescriptionHeader;
    private javax.swing.JLabel lNotPaidDescriptionHeader;
    private javax.swing.JLabel lRegistrationCode;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTextArea taNotPaidDescription;
    private javax.swing.JTextField tfRegistrationCode;
    // End of variables declaration//GEN-END:variables
    
}
