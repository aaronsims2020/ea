/*
 * LocaleSelector.java
 *
 * Created on August 2, 2004, 3:03 PM
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
public class LocaleSelector extends javax.swing.JDialog {
    private String[] strLocales = {"ar","ar_AE","ar_BH","ar_DZ","ar_EG","ar_IQ","ar_JO","ar_KW","ar_LB","ar_LY","ar_MA","ar_OM","ar_QA","ar_SA","ar_SD","ar_SY","ar_TN","ar_YE","hi_IN","iw","iw_IL","ja","ja_JP","ko","ko_KR","th","th_TH","th_TH","zh","zh_CN","zh_HK","zh_TW","be","be_BY","bg","bg_BG","ca","ca_ES","cs","cs_CZ","da","da_DK","de","de_AT","de_CH","de_DE","de_LU","el","el_GR","en_AU","en_CA","en_GB","en_IE","en_IN","en_NZ","en_ZA","es","es_AR","es_BO","es_CL","es_CO","es_CR","es_DO","es_EC","es_ES","es_GT","es_HN","es_MX","es_NI","es_PA","es_PE","es_PR","es_PY","es_SV","es_UY","es_VE","et","et_EE","fi","fi_FI","fr","fr_BE","fr_CA","fr_CH","fr_FR","fr_LU","hr","hr_HR","hu","hu_HU","is","is_IS","it","it_CH","it_IT","lt","lt_LT","lv","lv_LV","mk","mk_MK","nl","nl_BE","nl_NL","no","no_NO","no_NO","pl","pl_PL","pt","pt_BR","pt_PT","ro","ro_RO","ru","ru_RU","sh","sh_YU","sk","sk_SK","sl","sl_SI","sq","sq_AL","sr","sr_YU","sv","sv_SE","tr","tr_TR","uk","uk_UA","en","en_US"};
    private String[] strLocalesNames = {"Arabic","Arabic (United Arab Emirates)","Arabic (Bahrain)","Arabic (Algeria)","Arabic (Egypt)","Arabic (Iraq)","Arabic (Jordan)","Arabic (Kuwait)","Arabic (Lebanon)","Arabic (Libya)","Arabic (Morocco)","Arabic (Oman)","Arabic (Qatar)","Arabic (Saudi Arabia)","Arabic (Sudan)","Arabic (Syria)","Arabic (Tunisia)","Arabic (Yemen)","Hindi (India)","Hebrew","Hebrew (Israel)","Japanese","Japanese (Japan)","Korean","Korean (South Korea)","Thai","Thai (Thailand)","Thai (Thailand,TH)","Chinese","Chinese (China)","Chinese (Hong Kong)","Chinese (Taiwan)","Byelorussian","Byelorussian (Belarus)","Bulgarian","Bulgarian (Bulgaria)","Catalan","Catalan (Spain)","Czech","Czech (Czech Republic)","Danish","Danish (Denmark)","German","German (Austria)","German (Switzerland)","German (Germany)","German (Luxembourg)","Greek","Greek (Greece)","English (Australia)","English (Canada)","English (United Kingdom)","English (Ireland)","English (India)","English (New Zealand)","English (South Africa)","Spanish","Spanish (Argentina)","Spanish (Bolivia)","Spanish (Chile)","Spanish (Colombia)","Spanish (Costa Rica)","Spanish (Dominican Republic)","Spanish (Ecuador)","Spanish (Spain)","Spanish (Guatemala)","Spanish (Honduras)","Spanish (Mexico)","Spanish (Nicaragua)","Spanish (Panama)","Spanish (Peru)","Spanish (Puerto Rico)","Spanish (Paraguay)","Spanish (El Salvador)","Spanish (Uruguay)","Spanish (Venezuela)","Estonian","Estonian (Estonia)","Finnish","Finnish (Finland)","French","French (Belgium)","French (Canada)","French (Switzerland)","French (France)","French (Luxembourg)","Croatian","Croatian (Croatia)","Hungarian","Hungarian (Hungary)","Icelandic","Icelandic (Iceland)","Italian","Italian (Switzerland)","Italian (Italy)","Lithuanian","Lithuanian (Lithuania)","Latvian (Lettish)","Latvian (Lettish) (Latvia)","Macedonian","Macedonian (Macedonia)","Dutch","Dutch (Belgium)","Dutch (Netherlands)","Norwegian","Norwegian (Norway)","Norwegian (Norway,Nynorsk)","Polish","Polish (Poland)","Portuguese","Portuguese (Brazil)","Portuguese (Portugal)","Romanian","Romanian (Romania)","Russian","Russian (Russia)","Serbo-Croatian","Serbo-Croatian (Yugoslavia)","Slovak","Slovak (Slovakia)","Slovenian","Slovenian (Slovenia)","Albanian","Albanian (Albania)","Serbian","Serbian (Yugoslavia)","Swedish","Swedish (Sweden)","Turkish","Turkish (Turkey)","Ukrainian","Ukrainian (Ukraine)","English","English (United States)"};
    private static String strLocaleName = "English";
    private static String strLocale = "en";    
    private static int result = -1;
    public static int showLocaleSelectorDialog()
    {
        new LocaleSelector(null,true).show();
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
    
    /** Creates new form LocaleSelector */
    public LocaleSelector(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        comboLanguage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Arabic","Arabic (United Arab Emirates)","Arabic (Bahrain)","Arabic (Algeria)","Arabic (Egypt)","Arabic (Iraq)","Arabic (Jordan)","Arabic (Kuwait)","Arabic (Lebanon)","Arabic (Libya)","Arabic (Morocco)","Arabic (Oman)","Arabic (Qatar)","Arabic (Saudi Arabia)","Arabic (Sudan)","Arabic (Syria)","Arabic (Tunisia)","Arabic (Yemen)","Hindi (India)","Hebrew","Hebrew (Israel)","Japanese","Japanese (Japan)","Korean","Korean (South Korea)","Thai","Thai (Thailand)","Thai (Thailand,TH)","Chinese","Chinese (China)","Chinese (Hong Kong)","Chinese (Taiwan)","Byelorussian","Byelorussian (Belarus)","Bulgarian","Bulgarian (Bulgaria)","Catalan","Catalan (Spain)","Czech","Czech (Czech Republic)","Danish","Danish (Denmark)","German","German (Austria)","German (Switzerland)","German (Germany)","German (Luxembourg)","Greek","Greek (Greece)","English (Australia)","English (Canada)","English (United Kingdom)","English (Ireland)","English (India)","English (New Zealand)","English (South Africa)","Spanish","Spanish (Argentina)","Spanish (Bolivia)","Spanish (Chile)","Spanish (Colombia)","Spanish (Costa Rica)","Spanish (Dominican Republic)","Spanish (Ecuador)","Spanish (Spain)","Spanish (Guatemala)","Spanish (Honduras)","Spanish (Mexico)","Spanish (Nicaragua)","Spanish (Panama)","Spanish (Peru)","Spanish (Puerto Rico)","Spanish (Paraguay)","Spanish (El Salvador)","Spanish (Uruguay)","Spanish (Venezuela)","Estonian","Estonian (Estonia)","Finnish","Finnish (Finland)","French","French (Belgium)","French (Canada)","French (Switzerland)","French (France)","French (Luxembourg)","Croatian","Croatian (Croatia)","Hungarian","Hungarian (Hungary)","Icelandic","Icelandic (Iceland)","Italian","Italian (Switzerland)","Italian (Italy)","Lithuanian","Lithuanian (Lithuania)","Latvian (Lettish)","Latvian (Lettish) (Latvia)","Macedonian","Macedonian (Macedonia)","Dutch","Dutch (Belgium)","Dutch (Netherlands)","Norwegian","Norwegian (Norway)","Norwegian (Norway,Nynorsk)","Polish","Polish (Poland)","Portuguese","Portuguese (Brazil)","Portuguese (Portugal)","Romanian","Romanian (Romania)","Russian","Russian (Russia)","Serbo-Croatian","Serbo-Croatian (Yugoslavia)","Slovak","Slovak (Slovakia)","Slovenian","Slovenian (Slovenia)","Albanian","Albanian (Albania)","Serbian","Serbian (Yugoslavia)","Swedish","Swedish (Sweden)","Turkish","Turkish (Turkey)","Ukrainian","Ukrainian (Ukraine)","English","English (United States)" }));
        comboLanguage.setSelectedIndex(132);
        tfLocale.setText(strLocales[132]);
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
