package Snake;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JPanel implements KeyListener{
	private static int xApple;
	private static int yApple;
	int xHead;
	int yHead;
	public Main() {
	}
	
	public void drawBackground(Graphics g){
		Color lightGreen = new Color(144, 238, 144);
		g.setColor(lightGreen);
        g.fillRect(0, 0, 600, 600);
        for(int i = 0; i <= 560; i+=80){
            for(int j = 0; j <= 560; j+=80){
                g.clearRect(i, j, 40, 40);
            }
        }
        
        for(int i = 40; i <= 560; i+=80){
            for(int j = 40; j <= 560; j+=80){
                g.clearRect(i, j, 40, 40);
            }
        }
    }
	
	Timer timer;
	class MoveLeft extends TimerTask {
		public void run() {
			GridCoordinates GC = new GridCoordinates();
			xHead = xHead - GC.coord(1);
		}
	}
	
	class MoveRight extends TimerTask {
		public void run() {
			GridCoordinates GC = new GridCoordinates();
			xHead = xHead + GC.coord(1);
		}
	}
	
	class MoveUp extends TimerTask {
		public void run() {
			GridCoordinates GC = new GridCoordinates();
			yHead = yHead + GC.coord(1);
		}
	}
	
	class MoveDown extends TimerTask {
		public void run() {
			GridCoordinates GC = new GridCoordinates();
			yHead = yHead - GC.coord(1);
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		GridCoordinates GC = new GridCoordinates();
		timer = new Timer();
		if (key == KeyEvent.VK_LEFT) {
			timer.schedule(new MoveLeft(), 500);
		}
		
		if (key == KeyEvent.VK_RIGHT) {
			timer.schedule(new MoveRight(), 500);
		}
		
		if (key == KeyEvent.VK_UP) {
			timer.schedule(new MoveUp(), 500);
		}
		
		if (key == KeyEvent.VK_DOWN) {
			timer.schedule(new MoveDown(), 500);
		}
	}
	
	public void keyReleased(KeyEvent e) {
		
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void paint(Graphics g) {
		drawBackground(g);
		Image apple = Toolkit.getDefaultToolkit().getImage("apple.png");
		GridCoordinates GC = new GridCoordinates();
		xApple = GC.randCoord();
		yApple = GC.randCoord();
		xHead = GC.coord(7);
		yHead = GC.coord(7);
		g.drawImage(apple, xApple, yApple, this);
		
		Snake snake = new Snake();
		snake.head(g, xHead, yHead);
	}
	
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.getContentPane().add(new Main());
        frame.getContentPane().setPreferredSize(new Dimension(600,600));
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }  
}