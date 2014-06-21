/* Author: Luigi Vincent

*/

import java.awt.FontMetrics;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MessagePanel extends JPanel {
	
	private String message = "Welcome to Java";

	private int xCoord = 20, yCoord = 20;
	private boolean centered;
	private int interval = 10;

	public MessagePanel(String message) {
		this.message = message;
	}

	public void setMessage(String message) { this.message = message; repaint(); }

	public int getXCoord() { return xCoord; }
	public void setXCoord() { this.xCoord = xCoord; repaint(); }

	public int getYCoord() { return yCoord; }
	public void setYCoord() { this.yCoord = yCoord; repaint(); }

	public boolean isCentered() { return centered; }
	public void setCentered(boolean centered) { this.centered = centered; repaint(); }

	public int getInterval() { return interval; }
	public void setInterval(int interval) { this.interval = interval; repaint(); }

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (centered) {
			FontMetrics fm = g.getFontMetrics();

			int stringWidth = fm.stringWidth(message);
			int stringAscent = fm.getAscent();

			xCoord = getWidth() / 2 - stringWidth / 2; 
			yCoord = getHeight() / 2 - stringAscent / 2;
		 }

		 g.drawString(message, xCoord, yCoord);
	}

	public void moveLeft() { xCoord -= interval; repaint(); }
	public void moveRight() { xCoord += interval; repaint(); }
	public void moveUp() { yCoord -= interval; repaint(); }
	public void moveDown() { yCoord += interval; repaint(); }

	@Override
	public Dimension getPreferredSize() { return new Dimension(200, 40); }
}
