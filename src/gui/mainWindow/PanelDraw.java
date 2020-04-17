package gui.mainWindow;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JPanel;

import constant.ConstantGui;
import controller.Controller;
import logic.entity.Ball;

@SuppressWarnings("serial")
public class PanelDraw extends JPanel {

	private Point p;
	private Point p1;
	private ArrayList<Ball> list;

	public PanelDraw(Controller controller, ArrayList<Ball> list) {
		this.list = list;
		p = new Point(getWidth(), getHeight());
		p1 = new Point(getWidth(), getHeight());
		addMouseMotionListener(controller);
		addMouseListener(controller);
	}

	public void updateList(ArrayList<Ball> list) {
		this.list = list;
		repaint();
	}

	public void updatePoint(int x, int y, int x1, int y1) {
		synchronized (p) {
			synchronized (p1) {
				p.x = x;
				p.y = y;
				p1.x = x1;
				p1.y = y1;
			}
		}
		repaint();
	}

	@Override
	public void paint(Graphics g2) {
		super.paint(g2);
		Graphics2D g = (Graphics2D) g2;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g.drawString(ConstantGui.ACTUAL_CURSOR_X + " " + ConstantGui.ACTUAL_CURSOR_Y, ConstantGui.ACTUAL_CURSOR_X,
				ConstantGui.ACTUAL_CURSOR_Y);
		p1 = new Point(ConstantGui.ACTUAL_CURSOR_X - 10, ConstantGui.ACTUAL_CURSOR_Y - 10);
		for (Ball ball : list) {
			p = ball.getP();
			g.setColor(Color.BLACK);
			g.fillOval(p.x, p.y, 20, 20);
			g.setColor(Color.GREEN);
			g.drawLine(p1.x + 10, p1.y + 10, p.x + 10, p.y + 10);
			p1 = p;
		}

		g.setColor(Color.BLUE);
		g.fillOval(ConstantGui.ACTUAL_CURSOR_X - 5, ConstantGui.ACTUAL_CURSOR_Y - 5, 10, 10);
	}

}
