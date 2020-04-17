package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import constant.ConstantGui;
import gui.mainWindow.MainWindow;

public class Controller implements MouseMotionListener, MouseListener {

	private MainWindow mainWindow;
	private volatile boolean isMove;

	public Controller() {
		openMainwindow();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true){
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
					}
					if (isMove) 
						mainWindow.repaintPanel();
					
			}
		}}).start();
	}

	private void openMainwindow() {
		mainWindow = new MainWindow(this);
		mainWindow.setVisible(true);
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		ConstantGui.ACTUAL_CURSOR_X = e.getX();
		ConstantGui.ACTUAL_CURSOR_Y = e.getY();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		isMove = true;

	}

	@Override
	public void mouseExited(MouseEvent e) {
		isMove = false;

	}

}
