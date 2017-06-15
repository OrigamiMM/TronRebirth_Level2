import java.awt.Color;
import java.awt.Graphics;

public class TronPlayer1 extends TronObject {
	TronPlayer1(int w1, int h1, int x1, int y1) {
		x = x1;
		y = y1;
		width = w1;
		height = h1;
	}

	int Speed;

	void update() {

	}

	void draw(Graphics g) {
		g.setColor(Color.CYAN.brighter());
		g.fillRect(x, y, width, height);
	}
}
