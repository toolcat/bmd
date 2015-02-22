package com.toolcat.bmd;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class Starter {

	public static void main(String[] args) {
		GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] devices = g.getScreenDevices();
		
		for (GraphicsDevice device : devices) {
			System.out.println(device.isWindowTranslucencySupported(java.awt.GraphicsDevice.WindowTranslucency.TRANSLUCENT));
			System.out.println(device.getDefaultConfiguration().getBounds());
			Rectangle rectangle = device.getDefaultConfiguration().getBounds();
			JFrame frame = new JFrame();
			frame.getContentPane().setBackground(Color.BLUE);
			frame.setUndecorated(true);
			frame.setOpacity(0.01f);
			frame.setBounds(rectangle);
			frame.setVisible(true);
		}
	}
}
