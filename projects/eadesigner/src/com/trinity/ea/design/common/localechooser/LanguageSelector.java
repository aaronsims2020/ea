/*
 * LanguageSelector.java
 *
 * Created on December 31, 2004, 12:40 AM
 */
package com.trinity.ea.design.common.localechooser;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2004-2005 Trinity Software. All rights reserved.
 */
public class LanguageSelector extends javax.swing.JDialog {
    private final static String[] strLocales = {"aa","ab","af","am","ar","as","ay","az","ba","be","bg","bh","bi","bn","bo","br","ca","co","cs","cy","da","de","dz","el","en","eo","es","et","eu","fa","fi","fj","fo","fr","fy","ga","gd","gl","gn","gu","ha","hi","hr","hu","hy","ia","ie","ik","in","is","it","iw","ja","ji","jw","ka","kk","kl","km","kn","ko","ks","ku","ky","la","ln","lo","lt","lv","mg","mi","mk","ml","mn","mo","mr","ms","mt","my","na","ne","nl","no","oc","ne","nl","no","oc","om","or","pa","pl","ps","pt","qu","rm","rn","ro","ru","rw","sa","sd","sg","sh","si","sk","sl","sm","sn","so","sq","sr","ss","st","su","sv","sw","ta","te","tg","th","ti","tk","tl","tn","to","tr","ts","tt","tw","uk","ur","uz","vi","vo","wo","xh","yo","zh","zu"};
    private final static String[] strLocalesNames = {"Afar","Abkhazian","Afrikaans","Amharic","Arabic","Assamese","Aymara","Azerbaijani","Bashkir","Byelorussian","Bulgarian","Bihari","Bislama","Bengali","Tibetan","Breton","Catalan","Corsican","Czech","Welsh","Danish","German","Bhutani","Greek","English","Esperanto","Spanish","Estonian","Basque","Persian","Finnish","Fiji","Faeroese","French","Frisian","Irish","Gaelic","Galician","Guarani","Gujarati","Hausa","Hindi","Croatian","Hungarian","Armenian","Interlingua","Interlingue","Inupiak","Indonesian","Icelandic","Italian","Hebrew","Japanese","Yiddish","Javanese","Georgian","Kazakh","Greenlandic","Cambodian","Kannada","Korean","Kashmiri","Kurdish","Kirghiz","Latin","Lingala","Laothian","Lithuanian","Latvian","Malagasy","Maori","Macedonian","Malayalam","Mongolian","Moldavian","Marathi","Malay","Maltese","Burmese","Nauru","Nepali","Dutch","Norwegian","Occitan","Nepali","Dutch","Norwegian","Occitan","Oromo","Oriya","Punjabi","Polish","Pashto","Portuguese","Quechua","Rhaeto-Romance","Kirundi","Romanian","Russian","Kinyarwanda","Sanskrit","Sindhi","Sangro","Serbo-Croatian","Singhalese","Slovak","Slovenian","Samoan","Shona","Somali","Albanian","Serbian","Siswati","Sesotho","Sudanese","Swedish","Swahili","Tamil","Tegulu","Tajik","Thai","Tigrinya","Turkmen","Tagalog","Setswana","Tonga","Turkish","Tsonga","Tatar","Twi","Ukrainian","Urdu","Uzbek","Vietnamese","Volapuk","Wolof","Xhosa","Yoruba","Chinese","Zulu"};
    private static String strLocaleName = "English";
    private static String strLocale = "en";    
    private static int result = -1;
    public static int showLanguageSelectorDialog()
    {
        new LanguageSelector(null,true).show();
        return result;
    }
    
    public static String getLocaleString()
    {
        return strLocale;
    }
    
    public static String getLocaleNameString()
    {
        return strLocaleName;
    }
    
    /** Creates new form LanguageSelector */
    public LanguageSelector(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        comboLanguage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Afar","Abkhazian","Afrikaans","Amharic","Arabic","Assamese","Aymara","Azerbaijani","Bashkir","Byelorussian","Bulgarian","Bihari","Bislama","Bengali","Tibetan","Breton","Catalan","Corsican","Czech","Welsh","Danish","German","Bhutani","Greek","English","Esperanto","Spanish","Estonian","Basque","Persian","Finnish","Fiji","Faeroese","French","Frisian","Irish","Gaelic","Galician","Guarani","Gujarati","Hausa","Hindi","Croatian","Hungarian","Armenian","Interlingua","Interlingue","Inupiak","Indonesian","Icelandic","Italian","Hebrew","Japanese","Yiddish","Javanese","Georgian","Kazakh","Greenlandic","Cambodian","Kannada","Korean","Kashmiri","Kurdish","Kirghiz","Latin","Lingala","Laothian","Lithuanian","Latvian","Malagasy","Maori","Macedonian","Malayalam","Mongolian","Moldavian","Marathi","Malay","Maltese","Burmese","Nauru","Nepali","Dutch","Norwegian","Occitan","Nepali","Dutch","Norwegian","Occitan","Oromo","Oriya","Punjabi","Polish","Pashto","Portuguese","Quechua","Rhaeto-Romance","Kirundi","Romanian","Russian","Kinyarwanda","Sanskrit","Sindhi","Sangro","Serbo-Croatian","Singhalese","Slovak","Slovenian","Samoan","Shona","Somali","Albanian","Serbian","Siswati","Sesotho","Sudanese","Swedish","Swahili","Tamil","Tegulu","Tajik","Thai","Tigrinya","Turkmen","Tagalog","Setswana","Tonga","Turkish","Tsonga","Tatar","Twi","Ukrainian","Urdu","Uzbek","Vietnamese","Volapuk","Wolof","Xhosa","Yoruba","Chinese","Zulu" }));
        comboLanguage.setSelectedIndex(24);
        tfLocale.setText(strLocales[24]);
        result = -1;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = getSize().width;
        int h = getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        setLocation(x, y);         
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        TopFiller = new javax.swing.JPanel();
        Language = new javax.swing.JPanel();
        lLanguage = new javax.swing.JLabel();
        comboLanguage = new javax.swing.JComboBox();
        Country = new javax.swing.JPanel();
        lLocale = new javax.swing.JLabel();
        tfLocale = new javax.swing.JTextField();
        ButtonPanel = new javax.swing.JPanel();
        OKButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();

        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Language Chooser");
        setResizable(false);
        getContentPane().add(TopFiller);

        lLanguage.setDisplayedMnemonic('L');
        lLanguage.setLabelFor(comboLanguage);
        lLanguage.setText("Language:");
        lLanguage.setMaximumSize(new java.awt.Dimension(80, 15));
        lLanguage.setMinimumSize(new java.awt.Dimension(80, 15));
        lLanguage.setPreferredSize(new java.awt.Dimension(80, 15));
        Language.add(lLanguage);

        comboLanguage.setEditable(true);
        comboLanguage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Arabic" }));
        comboLanguage.setPreferredSize(new java.awt.Dimension(200, 21));
        comboLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboLanguageActionPerformed(evt);
            }
        });

        Language.add(comboLanguage);

        getContentPane().add(Language);

        lLocale.setDisplayedMnemonic('a');
        lLocale.setLabelFor(tfLocale);
        lLocale.setText("Locale:");
        lLocale.setMaximumSize(new java.awt.Dimension(80, 15));
        lLocale.setMinimumSize(new java.awt.Dimension(80, 15));
        lLocale.setPreferredSize(new java.awt.Dimension(80, 15));
        Country.add(lLocale);

        tfLocale.setMinimumSize(new java.awt.Dimension(100, 21));
        tfLocale.setPreferredSize(new java.awt.Dimension(200, 21));
        Country.add(tfLocale);

        getContentPane().add(Country);

        OKButton.setMnemonic('O');
        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        ButtonPanel.add(OKButton);

        CancelButton.setMnemonic('C');
        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        ButtonPanel.add(CancelButton);

        getContentPane().add(ButtonPanel);

        pack();
    }//GEN-END:initComponents

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        result = -1;
        setVisible(false);
        dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        result = 0;
        strLocale = tfLocale.getText();
        strLocaleName = comboLanguage.getSelectedItem().toString();
        setVisible(false);
        dispose();
    }//GEN-LAST:event_OKButtonActionPerformed

    private void comboLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboLanguageActionPerformed
    try
    {
        if(comboLanguage.getSelectedIndex()!=-1)
        {
            tfLocale.setText(strLocales[comboLanguage.getSelectedIndex()]);
        }
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    }//GEN-LAST:event_comboLanguageActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JButton CancelButton;
    private javax.swing.JPanel Country;
    private javax.swing.JPanel Language;
    private javax.swing.JButton OKButton;
    private javax.swing.JPanel TopFiller;
    private javax.swing.JComboBox comboLanguage;
    private javax.swing.JLabel lLanguage;
    private javax.swing.JLabel lLocale;
    private javax.swing.JTextField tfLocale;
    // End of variables declaration//GEN-END:variables
    
}
