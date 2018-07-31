package snakeGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.*;

public class GameField extends JPanel implements ActionListener {

	private final int SIZE = 320;
	private final int DOT_SIZE = 16;
	private final int ALL_DOTS = 400;
	private Image bodyPart;
	private Image apple;
	private int appleX;
	private int appleY;
	private int[] x = new int[ALL_DOTS];
	private int[] y = new int[ALL_DOTS];
	private int bodyParts;
	private Timer timer;
	private boolean isLeft = false;
	private boolean isRight = true;
	private boolean isUp = false;
	private boolean isDown = false;
	private boolean inGame = true;
	
	public GameField() {
		setBackground(Color.black);
		loadImages();
		initGame();
		addKeyListener(new FieldKeyListener());
		setFocusable(true);
	}

	public void loadImages() {
		ImageIcon iia = new ImageIcon("images//apple.png");
		apple = iia.getImage();
		ImageIcon iid = new ImageIcon("images//bodyPart.png");
		bodyPart = iid.getImage();
	}
	
	public void initGame() {
		bodyParts = 3;
		for (int i = 0; i < bodyParts; i++) {
			x[i]=0-i*DOT_SIZE;
			y[i]=0;
		}
		timer = new Timer(200,this);
		timer.start();
		createApple();
	}
	
	public void createApple() {
		appleX = new Random().nextInt(20)*DOT_SIZE;
		appleY = new Random().nextInt(20)*DOT_SIZE;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(inGame) {
			checkApple();
			checkIntersections();
			move();
		}
		
		repaint();
	}
	
	public void move() {
		for(int i = bodyParts; i>0; i--) {
			x[i]=x[i-1];
			y[i]=y[i-1];
		}
		if(isLeft) {
			x[0]-=DOT_SIZE;
		}
		if(isRight) {
			x[0]+=DOT_SIZE;
		}
		if(isUp) {
			y[0]-=DOT_SIZE;
		}
		if(isDown) {
			y[0]+=DOT_SIZE;
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		if(inGame) {
			g.drawImage(apple,appleX,appleY,this);
			for(int i = 0; i < bodyParts; i++) {
				g.drawImage(bodyPart, x[i], y[i], this);
			}
		}
		else {
			String str = "Game Over";
			//Font f = new Font("Arial",14,Font.BOLD);
			g.setColor(Color.white);
			//g.setFont(f);
			g.drawString(str,125,SIZE/2);
		}
	}
	
	public void checkApple() {
		if(x[0]==appleX && y[0]==appleY) {
			bodyParts++;
			createApple();
		}
	}
	
	public void checkIntersections() {
		for(int i = bodyParts; i>0; i--) {
			if(i>4 && x[0] == x[i] && y[0]==y[i]) {
				inGame = false;
			}
		}
		
		if(x[0] > SIZE || x[0] < 0 || y[0] > SIZE || y[0] < 0) {
			inGame = false;
		}
	}
	
	class FieldKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_LEFT && !isRight) {
				isLeft = true;
				isUp = false;
				isDown = false;
			}
			if(key == KeyEvent.VK_RIGHT && !isLeft) {
				isRight = true;
				isUp = false;
				isDown = false;
			}
			if(key == KeyEvent.VK_UP && !isDown) {
				isUp = true;
				isLeft = false;
				isRight = false;
			}
			if(key == KeyEvent.VK_DOWN && !isUp) {
				isDown = true;
				isRight = false;
				isLeft = false;
			}
		}
	}
	
}
