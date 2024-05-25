/* from bloke in forums.java.sun.com Forums */
package com.trinity.ea.util;

import javax.swing.JWindow;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.awt.MediaTracker;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;

/*
 * Example:
 *  ImageIcon icon = new ImageIcon("images/splash.gif");
 * SplashWindow splash= new SplashWindow(icon);
 *
 * splash.showStatus("Creating frame ........");
 *
 * //your code.... like create frame
 *
 * splash.showStatus("Build menu system...");
 * 
 * // your code....while building..like..frame.build() or as ur wish
 *
 * splash.showStatus("show frame ...");
 * frame.pack();
 * frame.setVisible(true);
 *
 * //Close splash window once the loading is done
 * splash.close();
 */
public class SplashWindow extends JWindow {

/**
* SplashWindow constructor comment.
*/
public SplashWindow() {
super();
}
public SplashWindow(ImageIcon icon) {
super();

setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

JLabel iconLabel;

if (icon == null || icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
iconLabel= new JLabel( "Unable to find image!", JLabel.CENTER);
iconLabel.setBackground(Color.blue);
iconLabel.setForeground(Color.yellow);
iconLabel.setOpaque(true);
iconLabel.setPreferredSize(new Dimension(400,200));
}
else
iconLabel= new JLabel(icon);
getContentPane().setLayout(new BorderLayout());
getContentPane().add(iconLabel, BorderLayout.CENTER);
pack();
Dimension dim= getToolkit().getScreenSize();
setLocation(
dim.width/2 - getSize().width/2, dim.height/2 - getSize().height/2);
setVisible(true);
}
public void close() {
SwingUtilities.invokeLater( new Runnable() {
public void run(){
setVisible(false);
dispose();
}
});
}
public void showStatus(final String status)
{
SwingUtilities.invokeLater(
new Runnable() {

public void run() {
} });
}
}
