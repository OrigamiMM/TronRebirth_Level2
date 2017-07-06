import java.awt.Color;
import java.awt.Graphics;

public class TronPlayer1 extends TronObject {
	int Speed;
	public int up1 = 1;
	public int down1 = 2;
	public int left1 = 3;
	public int right1 = 4;
	public int CD1 = up1;
	TronPlayer1(int w1, int h1, int x1, int y1, int Spd) {
		super();
		x = x1;
		y = y1;
		width = w1;
		height = h1;
		Speed = Spd;
	}


	void update() {
		super.update();
		if(CD1 == up1){
			y-=Speed;
		}if(CD1 == down1){
			y+=Speed;
		}if(CD1 == left1){
			x-=Speed;
		}if(CD1 == right1){
			x+=Speed;
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(x, y, width, height);
	}
}
