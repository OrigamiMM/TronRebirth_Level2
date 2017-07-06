import java.awt.Graphics;
import java.awt.Rectangle;

public class TronObject {
	TronObject() {

	}
	int x;
	int y;
	int width;
	int height;
	boolean isAlive = true;
	Rectangle CollisionBox = new Rectangle(x,y,width,height);
	void update() {
CollisionBox.setBounds(x,y,width,height);
	}

	void draw(Graphics g) {

	}
}
