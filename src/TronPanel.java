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
	Font titleFont;
	Font textFont;
	TronPlayer1 Player1 = new TronPlayer1(20, 20, 150, 400, 5);
	TronPlayer2 Player2 = new TronPlayer2(20,20,350,400,5);
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
		manager1.update();
		manager1.checkCollision();
		manager2.update();
		manager2.checkCollision();
		//Player1.update();
		//Player2.update();
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800, 800);
		g.setColor(Color.ORANGE);
		g.setFont(titleFont);
		g.drawString("TRON REBIRTH", 150, 300);
		g.setColor(Color.ORANGE.brighter());
		g.drawString("TRON REBIRTH", 153, 304);
		g.setColor(Color.ORANGE.darker());
		g.setFont(textFont);
		g.drawString("v0.0.3", 715, 775);
		g.setColor(Color.ORANGE);
		g.drawString("Press Enter to Play", 275, 400);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.GRAY.darker());
		g.fillRect(0, 0, 800, 800);
		g.setColor(Color.BLACK);
		g.fillRect(25, 25, 750, 750);
		manager1.draw(g);
		manager2.draw(g);
		manager1.addObject(new Trail(Player1.x+5, Player1.y+5, 10,10));
		manager2.addObject(new Trail2(Player2.x+5, Player2.y+5, 10,10));
		//Player1.draw(g);
		//Player2.draw(g);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.GRAY.brighter());
		g.fillRect(0, 0, 800, 800);

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
			Player1.CD1 = Player1.left1;
			
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Player1.CD1 = Player1.right1;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Player1.CD1 = Player1.up1;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Player1.CD1 = Player1.down1;

			// if (CurrentState == END_STATE) {
			// CurrentState = MENU_STATE;
			// } else if (CurrentState == MENU_STATE) {
			// CurrentState = GAME_STATE;
			// } else if (CurrentState == GAME_STATE) {
			// CurrentState = END_STATE;
			// }
			// }

		}if (e.getKeyCode() == KeyEvent.VK_A) {
			Player2.CD2 = Player2.left2;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			Player2.CD2 = Player2.right2;
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			Player2.CD2 = Player2.up2;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			Player2.CD2 = Player2.down2;
		}
		System.out.println(CurrentState);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Released");

	}
}
