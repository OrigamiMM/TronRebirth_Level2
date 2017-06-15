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
		titleFont = new Font("Arial", Font.BOLD, 70);
		textFont = new Font("Arial", Font.PLAIN, 30);
	}

	Timer time;
	Font titleFont;
	Font textFont;
	TronPlayer1 Player1 = new TronPlayer1(10, 10, 400, 400);
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
		Player1.update();
	}

	void updateEndState() {

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

	void drawGameState(Graphics g) {
		g.setColor(Color.GRAY.darker());
		g.fillRect(0, 0, 800, 800);
		Player1.draw(g);
	}

	void drawEndState(Graphics g) {
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
		repaint();
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
//		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//			CurrentState++;
//			if(CurrentState>END_STATE){
//				CurrentState = MENU_STATE;
//			}
//			if (CurrentState == END_STATE) {
//				CurrentState = MENU_STATE;
//			} else if (CurrentState == MENU_STATE) {
//				CurrentState = GAME_STATE;
//			} else if (CurrentState == GAME_STATE) {
//				CurrentState = END_STATE;
//			}
//		}
		System.out.println(CurrentState);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Released");
		
	}
}
