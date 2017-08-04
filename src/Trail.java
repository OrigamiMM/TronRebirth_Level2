import java.awt.Color;
import java.awt.Graphics;

public class Trail extends TronObject {
	int color;
public int down = 1;
public int up = 2;
public int left = 3;
public int right = 4;
public int direct = right; 

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
			g.setColor(Color.GREEN);
		}
		if (color == 2) {
			g.setColor(Color.WHITE);
		}
		g.fillRect(x, y, width, height);

	}
}
