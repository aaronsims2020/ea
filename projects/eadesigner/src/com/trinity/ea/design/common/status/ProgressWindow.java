package com.trinity.ea.design.common.status;

import com.trinity.ea.design.common.status.ProgressPanel;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JWindow;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.awt.MediaTracker;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;

/**
 *
 * @author  aaronsc Trinity Software
 * Copyright ©2003-2005 Trinity Software. All rights reserved.
 */
public class ProgressWindow extends JWindow {

protected ProgressPanel progPanel = new ProgressPanel();
private Timer timer;

public ProgressWindow(Frame owner)
{
	  super();
	  timer = new Timer();
	  progPanel.setOpaque(true);
	  getContentPane().setLayout(new BorderLayout());
	  getContentPane().add(progPanel, java.awt.BorderLayout.CENTER);
	  getContentPane().setSize(220,63);
	  pack();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = getSize().width;
        int h = getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        setLocation(x, y);   
	  setVisible(false);
} 

public ProgressWindow() 
{
	  super();
	  timer = new Timer();
	  progPanel.setOpaque(true);
	  getContentPane().setLayout(new BorderLayout());
	  getContentPane().add(progPanel, java.awt.BorderLayout.CENTER);
	  getContentPane().setSize(220,63);
	  pack();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = getSize().width;
        int h = getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        setLocation(x, y);   
	  setVisible(false);
}

public void close() 
{
	SwingUtilities.invokeLater( new Runnable() {
	public void run()
	{
		timer.cancel();
		setVisible(false);
		dispose();
		timer.cancel();
	}
	});
}
    
class RemindTask extends TimerTask {
        public void run() {
		setVisible(true);
        }
    }

public void showStatus(final String headerText, final int seconds)
{
SwingUtilities.invokeLater(
new Runnable() {

public void run() {
	timer.schedule(new RemindTask(), seconds*1000);
	progPanel.setText(headerText);
} });
}
}
