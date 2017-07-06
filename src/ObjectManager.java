
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<TronObject> objects;
	
	private int score = 0;
	
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	
	public ObjectManager() {
		objects = new ArrayList<TronObject>();
	}

	public void addObject(TronObject o) {
		objects.add(o);
	}

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			TronObject o = objects.get(i);
			o.update();
		}
		
		purgeObjects();	
	}

	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			TronObject o = objects.get(i);
			o.draw(g);
		}
	}

	private void purgeObjects() {
		for (int i = 0; i < objects.size(); i++) {
			if (!objects.get(i).isAlive) {
				objects.remove(i);
			}
		}
	}

//	public void manageEnemies(){
//		if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
//			addObject(new Alien(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
//			enemyTimer = System.currentTimeMillis();
//		}
//	}
//
public void checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				TronObject o1 = objects.get(i);
				TronObject o2 = objects.get(j);
				
				if(o1.CollisionBox.intersects(o2.CollisionBox)){
					if((o1 instanceof Trail && o2 instanceof Trail2) ||
					   (o2 instanceof Trail && o1 instanceof Trail2)){
						score++;
						System.out.println(score);
						o1.isAlive = false;
						o2.isAlive = false;
						System.out.println("intersect");
					}
					else if((o1 instanceof Trail && o2 instanceof Trail2) ||
							(o2 instanceof Trail && o1 instanceof Trail2)){
						o1.isAlive = false;
						o2.isAlive = false;
					}
	
				}
			}
		}
	}
	
	public int getScore(){
		return score;
	}
	
	public void setScore(int s){
		score = s;
	}
	
	public void reset(){
		objects.clear();
	}
}
