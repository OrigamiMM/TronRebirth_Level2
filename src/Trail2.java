
import java.awt.Color;
import java.awt.Graphics;

public class Trail2 extends TronObject{
	Trail2(int x1, int y1, int w1, int h1){
		super();
		x= x1;
		y= y1;
		width = w1;
		height = h1;
	}
	void update(){
		super.update();
	}
	void draw(Graphics g){
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, width, height);
		
	}
}
