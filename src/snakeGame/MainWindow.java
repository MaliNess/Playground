package snakeGame;

import javax.swing.*;

public class MainWindow extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainWindow mv = new MainWindow();
	}
	
	public MainWindow() {
		setTitle("Snake"); // title of the window
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // exit when exit-button pressed
		setSize(340,360); //size of the window
		setLocation(400,400); //window location
		add(new GameField()); //create game field from game field class
		setVisible(true);
	}

}
