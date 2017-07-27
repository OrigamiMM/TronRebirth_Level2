import java.awt.Color;
import java.awt.Graphics;

public class Trail extends TronObject {
	int color;

	Trail(int x1, int y1, int w1, int h1, int col) {
		super();
		x = x1;
		y = y1;
		width = w1;
		height = h1;
		color = col;
	}

	void update() {
		super.update();
	}

	void draw(Graphics g) {

		if (color == 1) {
			g.setColor(Color.CYAN.brighter());
		}
		if (color == 2) {
			g.setColor(Color.ORANGE);
		}
		g.fillRect(x, y, width, height);

	}
}
