import javax.swing.JFrame;
import javax.swing.JPanel;

public class TronReboot {
	TronReboot() {
		frame = new JFrame();
		Jpan = new TronPanel();
		setup();
	}

	final int width = 800;
	final int height = 800;
	TronPanel Jpan;
	JFrame frame;

	public static void main(String[] args) {
		TronReboot Tron = new TronReboot();
		Tron.setup();
	}

	void setup() {
		frame.add(Jpan);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.addKeyListener(Jpan);
		Jpan.StartGame();
	}
}