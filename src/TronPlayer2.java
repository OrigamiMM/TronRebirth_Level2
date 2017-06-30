import java.awt.Color;
import java.awt.Graphics;

public class TronPlayer2 extends TronObject {
	int Speed;
	public int up2 = 1;
	public int down2 = 2;
	public int left2 = 3;
	public int right2 = 4;
	public int CD2 = down2;
	TronPlayer2(int w1, int h1, int x1, int y1, int Spd) {
		x = x1;
		y = y1;
		width = w1;
		height = h1;
		Speed = Spd;
	}


	void update() {
		if(CD2 == up2){
			y-=Speed;
		}if(CD2 == down2){
			y+=Speed;
		}if(CD2 == left2){
			x-=Speed;
		}if(CD2 == right2){
			x+=Speed;
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.ORANGE.brighter());
		g.fillRect(x, y, width, height);
	}
}
