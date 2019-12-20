package Snake;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

public class Snake {
	SnakeState state = SnakeState.ALIVE;
	public void head(Graphics g, int xHead, int yHead) {
		Image head = Toolkit.getDefaultToolkit().getImage("head.png");
		GridCoordinates GC = new GridCoordinates();
		g.drawImage(head, xHead, yHead, null);
	}
}
