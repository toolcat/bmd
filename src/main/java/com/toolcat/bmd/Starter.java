package com.toolcat.bmd;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;

import javax.swing.JFrame;

public class Starter {

	public static void main(String[] args) throws AWTException {
		blockStandBy();
//		blockDisplay();
	}

	private static void blockStandBy() throws AWTException {
		final Robot robot = new Robot();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {					
					robot.mouseMove(10, 10);
					robot.mouseMove(11, 11);
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	private static void blockDisplay() {
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
