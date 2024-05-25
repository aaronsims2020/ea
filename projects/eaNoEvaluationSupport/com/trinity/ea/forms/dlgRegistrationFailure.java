/*
 * dlgRegistrationFailure.java
 *
 * Created on October 24, 2003, 3:39 AM
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
public class dlgRegistrationFailure extends javax.swing.JDialog {
    
    /** Creates new form RegistrationComplete */
    public dlgRegistrationFailure(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(190,122);
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
            setTitle(EncryptedRuleReader.get("registrationFailedWindowTitle"));
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
        lHeaderDescription = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();

        getContentPane().setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Invalid Code");
        setBackground(new java.awt.Color(204, 204, 204));
        setModal(true);
        setName("dlgInvalidRegistrationCode");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        lHeaderDescription.setFont(new java.awt.Font("Arial", 1, 12));
        lHeaderDescription.setText(EncryptedRuleReader.get("registrationFailedMessage"));
        getContentPane().add(lHeaderDescription);
        lHeaderDescription.setBounds(20, 20, 200, 23);

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        getContentPane().add(btnOK);
        btnOK.setBounds(50, 50, 81, 26);

        pack();
    }//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        dispose();// Add your handling code here:
    }//GEN-LAST:event_btnOKActionPerformed
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new dlgRegistrationFailure(new javax.swing.JFrame(), true).show();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel lHeaderDescription;
    // End of variables declaration//GEN-END:variables
    
}
