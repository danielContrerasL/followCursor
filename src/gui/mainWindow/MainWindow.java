package gui.mainWindow;

import java.awt.BorderLayout;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;

import constant.ConstantGui;
import controller.Controller;
import logic.entity.Ball;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private PanelDraw draw;
	private Point p;
	private Point p1;
	private double d;
	private ArrayList<Ball> ballList;

	public MainWindow(Controller controller) {
		setSize(600, 600);
		setMinimumSize(getSize());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ballList = new ArrayList<>();
		draw = new PanelDraw(controller, ballList);
		for (int i = 0; i < 5; i++) {
			ballList.add(new Ball(draw.getWidth() / 2, draw.getHeight() / 2));
		}
		add(draw, BorderLayout.CENTER);
	}

	public void repaintPanel() {
		ballList.get(0).moveBall();
		p = ballList.get(0).getP();
		for (int i = 1; i < ballList.size(); i++) {
			p1 = ballList.get(i).getP();
			d = Math.sqrt(getValue(p.x, p1.x) + getValue(p.y, p1.y));
			p = p1;
			if (d > ConstantGui.MIN_DISTANCE)
				ballList.get(i).moveBall();
		}
		draw.updateList(ballList);
		// ball.moveBall();
		// p = ball.getP();
		// p1 = ball2.getP();
		// d = Math.sqrt(getValue(p.x, p1.x) + getValue(p.y, p1.y));
		// if (d > ConstantGui.MIN_DISTANCE) {
		// ball2.moveBall();
		// }
		// draw.updatePoint(p.x, p.y, p1.x, p1.y);
	}

	private double getValue(int a, int b) {
		return Math.pow(Math.abs(a - b), 2);

	}

}
