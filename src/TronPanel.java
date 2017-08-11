import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import org.omg.Messaging.SyncScopeHelper;

public class TronPanel extends JPanel implements ActionListener, KeyListener {
	TronPanel() {
		time = new Timer(1000 / 60, this);
		manager1.addObject(Player1);
		manager2.addObject(Player2);

		titleFont = new Font("Arial", Font.BOLD, 70);
		textFont = new Font("Arial", Font.PLAIN, 30);
	}

	ObjectManager manager1 = new ObjectManager();
	ObjectManager manager2 = new ObjectManager();
	Timer time;
	int counter;
	String Time;
	Font titleFont;
	Font textFont;
	int winner;
	TronPlayer1 Player1 = new TronPlayer1(20, 20, 150, 400, 5, 1);
	TronPlayer1 Player2 = new TronPlayer1(20, 20, 650, 400, 5, 2);

	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int CurrentState = MENU_STATE;

	void StartGame() {
		time.start();

	}

	void updateMenuState() {

	}

	void updateGameState() {

	}

	void updateEndState() {

		System.out.println(counter);
		manager1.update();
		manager1.checkCollision();
		manager2.update();
		manager2.checkCollision();
		if (Player1.isAlive == false) {
			winner = 2;
			CurrentState = GAME_STATE;
			manager1.reset();
			Player1 = new TronPlayer1(20, 20, 150, 400, 5, 1);
			manager1.addObject(Player1);
			manager2.reset();
			Player2 = new TronPlayer1(20, 20, 650, 400, 5, 2);
			manager2.addObject(Player2);
		}
		if (Player2.isAlive == false) {
			winner = 1;
			CurrentState = GAME_STATE;
			manager1.reset();
			Player1 = new TronPlayer1(20, 20, 150, 400, 5, 1);
			manager1.addObject(Player1);
			manager2.reset();
			Player2 = new TronPlayer1(20, 20, 650, 400, 5, 2);
			manager2.addObject(Player2);
		}
		// Player1.update();
		// Player2.update();
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800, 800);
		g.setColor(Color.ORANGE);
		g.setFont(titleFont);
		g.drawString("TRON REBIRTH", 125, 250);
		g.setColor(Color.ORANGE.brighter());
		g.drawString("TRON REBIRTH", 128, 254);
		g.setColor(Color.ORANGE.darker());
		g.setFont(textFont);
		g.drawString("v0.0.5", 715, 775);
		g.drawString("Redone by Oscar", 500, 290);
		g.setColor(Color.lightGray);
		g.drawString("Press Enter to Play", 275, 400);
		g.setColor(Color.ORANGE);
		g.drawString("Player 2: Arrow Key Controls", 210, 500);
		g.setColor(Color.CYAN);
		g.drawString("Player 1: WASD Controls", 225, 450);
		g.setColor(Color.GREEN);
		g.drawString("Press R incase of freeze", 235, 550);
		// g.drawRect(400, 0, 1, 800);

	}

	void drawEndState(Graphics g) {
		x1= Player1.x+5;
		y1=Player1.y+20;
		Trail trail1 = new Trail(Player1.x+5, Player1.y+20, 10, 10, 1);
		Trail trail2 = new Trail(Player2.x+5, Player2.y+20, 10, 10, 2);
		manager1.addObject(trail1);
		manager1.addObject(trail2);
		manager2.addObject(trail1);
		manager2.addObject(trail2);
		g.setColor(Color.GRAY.darker());
		g.fillRect(0, 0, 800, 800);
		g.setColor(Color.BLACK);
		g.fillRect(25, 25, 750, 750);
		g.setColor(Color.WHITE);
		g.setFont(textFont);
		manager1.draw(g);
		manager2.draw(g);
if (Player1.CD1==Player1.up1) {
	x1= Player1.x+5
	y1=Player1.x+5
}if (Player1.CD1==Player1.down1) {
	trail1.direct=trail1.down;
}if (Player1.CD1==Player1.left1) {
	trail1.direct=trail1.left;
}if (Player2.CD1==Player2.up1) {
	trail2.direct=trail1.up;
}if (Player2.CD1==Player2.down1) {
	trail1.direct=trail1.down;
}
		// Player1.draw(g);
		// Player2.draw(g);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800, 800);
		g.setColor(Color.RED.darker());
		g.setFont(titleFont);
		g.drawString("GAME OVER", 170, 200);
		g.setColor(Color.RED.brighter());
		g.drawString("GAME OVER", 173, 203);
		g.setColor(Color.GREEN);
		g.setFont(textFont);
		g.drawString("Press Enter or R", 270, 350);
		// g.drawRect(400, 0, 1, 800);
		if (winner == 1) {
			g.setColor(Color.BLUE.darker());
			g.setFont(titleFont);
			g.drawString("PLAYER 1 WINS", 125, 500);
			g.setColor(Color.BLUE.brighter());
			g.drawString("PLAYER 1 WINS", 128, 504);
		}
		if (winner == 2) {
			g.setColor(Color.ORANGE.darker());
			g.setFont(titleFont);
			g.drawString("PLAYER 2 WINS", 125, 500);
			g.setColor(Color.ORANGE.brighter());
			g.drawString("PLAYER 2 WINS", 128, 504);
		}

	}

	public void paintComponent(Graphics g) {
		if (CurrentState == MENU_STATE) {
			drawMenuState(g);
		} else if (CurrentState == GAME_STATE) {
			drawGameState(g);
		} else if (CurrentState == END_STATE) {
			drawEndState(g);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.repaint();
		if (CurrentState == MENU_STATE) {
			updateMenuState();
		} else if (CurrentState == GAME_STATE) {
			updateGameState();
		} else if (CurrentState == END_STATE) {
			updateEndState();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("typed");

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Pressed");
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			CurrentState++;
			if (CurrentState > END_STATE) {
				CurrentState = MENU_STATE;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Player2.CD1 = Player2.left1;
		
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Player2.CD1 = Player2.right1;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Player2.CD1 = Player2.up1;

		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Player2.CD1 = Player2.down1;
		}
		////
		if (e.getKeyCode() == KeyEvent.VK_A) {
			Player1.CD1 = Player1.left1;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			Player1.CD1 = Player1.right1;
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			Player1.CD1 = Player1.up1;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			Player1.CD1 = Player1.down1;

		}
		System.out.println(CurrentState);
		if (e.getKeyCode() == KeyEvent.VK_R) {
			CurrentState = END_STATE;
			manager1.reset();
			Player1 = new TronPlayer1(20, 20, 150, 400, 5, 1);
			manager1.addObject(Player1);
			manager2.reset();
			Player2 = new TronPlayer1(20, 20, 650, 400, 5, 2);
			manager2.addObject(Player2);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Released");

	}
}
