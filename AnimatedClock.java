/* Author: Luigi Vincent

*/

import java.awt.event.*;
import javax.swing.*;

public class AnimatedClock extends JFrame {
	private StillClock clock = new StillClock();

	public AnimatedClock() {
		add(clock);

		Timer timer = new Timer(1000, new TimerListener());
		timer.start();
	}

	private class TimerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			clock.setCurrentTime();
			clock.repaint();

		}
	}

	public static void main(String[] args) {
		JFrame frame = new AnimatedClock();
		frame.setTitle("Luigi's Animated Clock");
		frame.setSize(300, 250);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
