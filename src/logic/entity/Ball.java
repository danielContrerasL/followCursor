package logic.entity;

import java.awt.Point;

import constant.ConstantGui;

public class Ball {

	private Point p;

	public Ball(int x, int y) {
		p = new Point(x, y);
	}

	public void moveBall() {
		p.x = ConstantGui.ACTUAL_CURSOR_X > p.x?++p.x:--p.x;
		p.y = ConstantGui.ACTUAL_CURSOR_Y > p.y ? ++p.y:--p.y;
	}
	
	public Point getP() {
		return p;
	}
	

}
