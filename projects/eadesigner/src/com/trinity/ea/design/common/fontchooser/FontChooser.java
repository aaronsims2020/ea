package com.trinity.ea.design.common.fontchooser;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


/**
* FontChooser
* @author Janos Szatmary
* @version
 * Downloaded by aaronsc on java forums from user JBalles on thread - http://forum.java.sun.com/thread.jsp?forum=57&thread=124810
*/

public class FontChooser extends javax.swing.JDialog 
{

  String[] styleList = new String[]
    { "Plain","Bold","Italic" };
  String[] sizeList = new String[]
    { "2","4","6","8","10","12","14","16","18","20","22","24","30","36","48","72" };

  String currentFont = null;
  int currentStyle = -1;
  int currentSize = -1;

  public boolean ok = false;

  /* ------------------------------------------------------------- */
  private FontChooser(java.awt.Frame parent,boolean modal) {
    super (parent,modal);
    initComponents();
    setListValues(jFontList,GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
    setListValues(jStyleList,styleList);
    setListValues(jSizeList,sizeList);
    setCurrentFont(jSample.getFont());
    pack();
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    setResizable(false);
    int w = getSize().width;
    int h = getSize().height;
    int x = (dim.width-w)/2;
    int y = (dim.height-h)/2;
    setLocation(x, y);  

    try
    {
        setTitle("Font Chooser");
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }   
  }

  private FontChooser(java.awt.Frame parent,boolean modal,Font font) {
    this(parent,modal);
    setCurrentFont(font);
  }

  /* ------------------------------------------------------------- */
  private void setListValues(JList list,String[] values) {
    if (list.getModel() instanceof DefaultListModel) {
      DefaultListModel model = (DefaultListModel)
      list.getModel();
      model.removeAllElements();
      for (int j=0; j < values.length; j++) {
        model.addElement(values[j]);
      }
    }
  }

  /* ------------------------------------------------------------- */
  private void setSampleFont() {
    if (currentFont != null && currentStyle >= 0 && currentSize > 0) {
      jSample.setFont(new Font
      (currentFont,currentStyle,currentSize));
    }
  }

  private String styleToString(int style) {
    String str = "";
    if ((style&Font.BOLD) == Font.BOLD) {
      if (str.length() > 0) {
        str += ",";
      }
      str += "Bold";
    }
    if ((style&Font.ITALIC) == Font.ITALIC) {
      if (str.length() > 0) {
        str += ",";
      }
      str += "Italic";
    }
    if (str.length() <= 0 && (style&Font.PLAIN) == Font.PLAIN) {
      str = "Plain";
    }
    return str;
  }

  /* ------------------------------------------------------------- */
  public Font getCurrentFont() {
    return jSample.getFont();
  }

  /* ------------------------------------------------------------- */
  public void setCurrentFont(Font font) {
    if (font==null) {
      font = jSample.getFont();
    }

    jFont.setText(font.getName());
    jFontActionPerformed(null);

    jStyle.setText(styleToString(font.getStyle()));
    jStyleActionPerformed(null);

    jSize.setText(Integer.toString(font.getSize()));
    jSizeActionPerformed(null);
  }

  public static Font showDialog(Frame parent,String title,Font font) {
    FontChooser dialog = new FontChooser(parent,true,font);
    dialog.setVisible(true);

    Font newfont = null;
    if (dialog.ok) {
      newfont = dialog.getCurrentFont();
    }

    dialog.dispose();
    return newfont;
  }

  /** This method is called from within the constructor to
  * initialize the form.
  * WARNING: Do NOT modify this code. The content of this
  method is
  * always regenerated by the FormEditor.
  */
  private void initComponents() {
    jPanel3 = new javax.swing.JPanel();
    jFont = new javax.swing.JTextField();
    jScrollPane1 = new javax.swing.JScrollPane();
    jFontList = new javax.swing.JList();
    jPanel4 = new javax.swing.JPanel();
    jStyle = new javax.swing.JTextField();
    jScrollPane2 = new javax.swing.JScrollPane();
    jStyleList = new javax.swing.JList();
    jPanel5 = new javax.swing.JPanel();
    jSize = new javax.swing.JTextField();
    jScrollPane3 = new javax.swing.JScrollPane();
    jSizeList = new javax.swing.JList();
    jPanel1 = new javax.swing.JPanel();
    jScrollPane4 = new javax.swing.JScrollPane();
    jSample = new javax.swing.JTextArea();
    jButtons = new javax.swing.JPanel();
    jOk = new javax.swing.JButton();
    jCancel = new javax.swing.JButton();
    jLabel6 = new javax.swing.JLabel();
    getContentPane().setLayout(new java.awt.GridBagLayout());
    java.awt.GridBagConstraints gridBagConstraints1;
    setTitle("Font Chooser");
    addWindowListener(new java.awt.event.WindowAdapter()
      {
        public void windowClosing(java.awt.event.WindowEvent evt) {
          closeDialog(evt);
        }
      }
    );

    jPanel3.setLayout(new java.awt.GridBagLayout());
    java.awt.GridBagConstraints gridBagConstraints2;
    jPanel3.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), " Font "));

    jFont.setColumns(24);
    jFont.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jFontActionPerformed(evt);
        }
      }
    );
    gridBagConstraints2 = new java.awt.GridBagConstraints();
    gridBagConstraints2.gridwidth = 0;
    gridBagConstraints2.fill =
    java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints2.insets = new java.awt.Insets(0, 3, 0, 3);
    gridBagConstraints2.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints2.weightx = 1.0;
    jPanel3.add(jFont, gridBagConstraints2);



    jFontList.setModel(new DefaultListModel());
    jFontList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jFontList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
      public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
          jFontListValueChanged(evt);
        }
      }
    );
    jScrollPane1.setViewportView(jFontList);

    gridBagConstraints2 = new java.awt.GridBagConstraints();
    gridBagConstraints2.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints2.insets = new java.awt.Insets(3, 3, 3, 3);
    gridBagConstraints2.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints2.weightx = 1.0;
    gridBagConstraints2.weighty = 1.0;
    jPanel3.add(jScrollPane1, gridBagConstraints2);


    gridBagConstraints1 = new java.awt.GridBagConstraints();
    gridBagConstraints1.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints1.insets = new java.awt.Insets(5, 5, 0, 0);
    gridBagConstraints1.weightx = 0.5;
    gridBagConstraints1.weighty = 1.0;
    getContentPane().add(jPanel3, gridBagConstraints1);


    jPanel4.setLayout(new java.awt.GridBagLayout());
    java.awt.GridBagConstraints gridBagConstraints3;
    jPanel4.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), " Style "));

    jStyle.setColumns(18);
    jStyle.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
          jStyleActionPerformed(evt);
        }
      }
    );
    gridBagConstraints3 = new java.awt.GridBagConstraints();
    gridBagConstraints3.gridwidth = 0;
    gridBagConstraints3.fill =
    java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints3.insets = new java.awt.Insets(0, 3, 0, 3);
    gridBagConstraints3.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints3.weightx = 1.0;
    jPanel4.add(jStyle, gridBagConstraints3);



    jStyleList.setModel(new DefaultListModel());
    jStyleList.setVisibleRowCount(4);
    jStyleList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
        public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
          jStyleListValueChanged(evt);
        }
      }
    );
    jScrollPane2.setViewportView(jStyleList);

    gridBagConstraints3 = new java.awt.GridBagConstraints();
    gridBagConstraints3.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints3.insets = new java.awt.Insets(3, 3, 3, 3);
    gridBagConstraints3.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints3.weightx = 0.5;
    gridBagConstraints3.weighty = 1.0;
    jPanel4.add(jScrollPane2, gridBagConstraints3);


    gridBagConstraints1 = new java.awt.GridBagConstraints();
    gridBagConstraints1.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints1.insets = new java.awt.Insets(5, 5, 0, 0);
    gridBagConstraints1.weightx = 0.375;
    gridBagConstraints1.weighty = 1.0;
    getContentPane().add(jPanel4, gridBagConstraints1);


    jPanel5.setLayout(new java.awt.GridBagLayout());
    java.awt.GridBagConstraints gridBagConstraints4;
    jPanel5.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), " Size "));

    jSize.setColumns(6);
    jSize.addActionListener(new
    java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
          jSizeActionPerformed(evt);
        }
      }
    );
    gridBagConstraints4 = new java.awt.GridBagConstraints();
    gridBagConstraints4.gridwidth = 0;
    gridBagConstraints4.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints4.insets = new java.awt.Insets(0, 3, 0, 3);
    gridBagConstraints4.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints4.weightx = 1.0;
    jPanel5.add(jSize, gridBagConstraints4);



    jSizeList.setModel(new DefaultListModel());
    jSizeList.setVisibleRowCount(4);
    jSizeList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jSizeList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
        public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
          jSizeListValueChanged(evt);
        }
      }
    );
    jScrollPane3.setViewportView(jSizeList);

    gridBagConstraints4 = new java.awt.GridBagConstraints();
    gridBagConstraints4.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints4.insets = new java.awt.Insets(3, 3, 3, 3);
    gridBagConstraints4.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints4.weightx = 0.25;
    gridBagConstraints4.weighty = 1.0;
    jPanel5.add(jScrollPane3, gridBagConstraints4);


    gridBagConstraints1 = new java.awt.GridBagConstraints();
    gridBagConstraints1.gridwidth = 0;
    gridBagConstraints1.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints1.insets = new java.awt.Insets(5, 5, 0, 5);
    gridBagConstraints1.weightx = 0.125;
    gridBagConstraints1.weighty = 1.0;
    getContentPane().add(jPanel5, gridBagConstraints1);


    jPanel1.setLayout(new java.awt.GridBagLayout());
    java.awt.GridBagConstraints gridBagConstraints5;
    jPanel1.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), " Sample "));


    jSample.setWrapStyleWord(true);
    jSample.setLineWrap(true);
    jSample.setColumns(20);
    jSample.setRows(3);
    jSample.setText("The quick brown fox jumped over the lazy dog.");
    jScrollPane4.setViewportView(jSample);

    gridBagConstraints5 = new java.awt.GridBagConstraints();
    gridBagConstraints5.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints5.insets = new java.awt.Insets(0, 3, 3, 3);
    gridBagConstraints5.weightx = 1.0;
    gridBagConstraints5.weighty = 1.0;
    jPanel1.add(jScrollPane4, gridBagConstraints5);


    gridBagConstraints1 = new java.awt.GridBagConstraints();
    gridBagConstraints1.gridwidth = 0;
    gridBagConstraints1.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints1.insets = new java.awt.Insets(0, 5, 0, 5);
    gridBagConstraints1.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints1.weightx = 1.0;
    getContentPane().add(jPanel1, gridBagConstraints1);


    jButtons.setLayout(new java.awt.GridBagLayout());
    java.awt.GridBagConstraints gridBagConstraints6;

    jOk.setMnemonic(KeyEvent.VK_O);
    jOk.setText("OK");
    jOk.setRequestFocusEnabled(false);
    jOk.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          jOkActionPerformed(evt);
        }
      }
    );
    gridBagConstraints6 = new java.awt.GridBagConstraints();
    gridBagConstraints6.insets = new java.awt.Insets(5, 5, 5, 0);
    gridBagConstraints6.anchor = java.awt.GridBagConstraints.WEST;
    jButtons.add(jOk, gridBagConstraints6);


    jCancel.setMnemonic(KeyEvent.VK_C);
    jCancel.setText("Cancel");
    jCancel.setRequestFocusEnabled(false);
    jCancel.addActionListener(new
    java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
          jCancelActionPerformed(evt);
        }
      }
    );
    gridBagConstraints6 = new java.awt.GridBagConstraints();
    gridBagConstraints6.gridwidth = 0;
    gridBagConstraints6.insets = new java.awt.Insets(5, 5, 5, 5);
    gridBagConstraints6.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints6.weightx = 1.0;
    jButtons.add(jCancel, gridBagConstraints6);


    gridBagConstraints6 = new java.awt.GridBagConstraints();
    gridBagConstraints6.weightx = 1.0;
    jButtons.add(jLabel6, gridBagConstraints6);


    gridBagConstraints1 = new java.awt.GridBagConstraints();
    gridBagConstraints1.gridwidth = 0;
    gridBagConstraints1.anchor = java.awt.GridBagConstraints.SOUTHWEST;
    gridBagConstraints1.weightx = 1.0;
    getContentPane().add(jButtons, gridBagConstraints1);

  }

  private void jCancelActionPerformed(java.awt.event.ActionEvent evt) {
    // Add your handling code here:
    setVisible(false);
  }

  private void jOkActionPerformed (java.awt.event.ActionEvent evt) {
    // Add your handling code here:
    ok = true;
    setVisible(false);
  }

  private void jSizeActionPerformed (java.awt.event.ActionEvent evt) {
    // Add your handling code here:
    int size = 0;
    try {
      size = Integer.parseInt(jSize.getText());
    }
    catch (Exception e) {}
    if (size > 0) {
      currentSize = size;
      setSampleFont();
    }
  }

  private void jStyleActionPerformed (java.awt.event.ActionEvent evt) {
    // Add your handling code here:
    StringTokenizer st = new StringTokenizer(jStyle.getText(),",");
    int style = 0;
    while (st.hasMoreTokens()) {
      String str = st.nextToken().trim();
      if (str.equalsIgnoreCase("Plain")) { style |= Font.PLAIN; } else
      if (str.equalsIgnoreCase("Bold")) { style |= Font.BOLD; } else
      if (str.equalsIgnoreCase("Italic")) { style |= Font.ITALIC; }
    }
    if (style >= 0) {
      currentStyle = style;
      setSampleFont();
    }
  }

  private void jFontActionPerformed (java.awt.event.ActionEvent evt) {
    // Add your handling code here:
    DefaultListModel model = (DefaultListModel)
    jFontList.getModel();
    if (model.indexOf(jFont.getText()) >= 0) {
      currentFont = jFont.getText();
      setSampleFont();
    }
  }

  private void jStyleListValueChanged(javax.swing.event.ListSelectionEvent evt) {
    // Add your handling code here:
    String str = new String();
    Object[] values = jStyleList.getSelectedValues();

    if (values.length > 0) {
      int i;
      for (int j=0; j < values.length; j++) {
        String s = (String) values[j];
        if (s.equalsIgnoreCase("Plain")) {
          str = "Plain";  break;
        }
        if (str.length() > 0) { str += ","; }
        str += (String) values[j];
      }
    }
    else { str = styleToString(currentStyle); }

    jStyle.setText(str);
    jStyleActionPerformed(null);
  }

  private void jSizeListValueChanged(javax.swing.event.ListSelectionEvent evt) {
    // Add your handling code here:
    String str = (String) jSizeList.getSelectedValue();
    if (str==null || str.length() <= 0) { str = Integer.toString(currentSize); }
    jSize.setText(str);
    jSizeActionPerformed(null);
  }

  private void jFontListValueChanged(javax.swing.event.ListSelectionEvent evt) {
    // Add your handling code here:
    String str = (String) jFontList.getSelectedValue();
    if (str==null || str.length() <= 0) { str = currentFont; }
    jFont.setText(str);
    jFontActionPerformed(null);
  }

  /** Closes the dialog */
  private void closeDialog(java.awt.event.WindowEvent evt) {
    setVisible (false);
  }

  // Variables declaration - do not modify
  private javax.swing.JPanel jPanel3;
  private javax.swing.JTextField jFont;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JList jFontList;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JTextField jStyle;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JList jStyleList;
  private javax.swing.JPanel jPanel5;
  private javax.swing.JTextField jSize;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JList jSizeList;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane4;
  private javax.swing.JTextArea jSample;
  private javax.swing.JPanel jButtons;
  private javax.swing.JButton jOk;
  private javax.swing.JButton jCancel;
  private javax.swing.JLabel jLabel6;
  // End of variables declaration
 public void paint(Graphics g)
{
Graphics2D g2 = (Graphics2D) g;

g2.setRenderingHint(
RenderingHints.KEY_TEXT_ANTIALIASING,
RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

super.paint(g);
} 
}



