import java.awt.Color;
import java.awt.Graphics;

public class TronPlayer1 extends TronObject {
	int Speed;
	int color; 
	public int up1 = 1;
	public int down1 = 2;
	public int left1 = 3;
	public int right1 = 4;
	public int CD1 = right1;
	TronPlayer1(int w1, int h1, int x1, int y1, int Spd, int col) {
		super();
		x = x1;
		y = y1;
		width = w1;
		height = h1;
		Speed = Spd;
		color = col;
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
		if(x<20){
			x = 760;
		}
		if(x > 760){
			x= 20;
		}
		if(y<20){
			y=760;
		}
		if(y>760){
			y=20;
		}
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
