package Player;

import UI.*;
import Collectibles.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class PlayerController implements KeyListener {

	private int right = 2;
	private int up = 0;
	
	private int snakePositionX = 10; //This is position x in the gameScene array but position y in real cordinates.
	private int snakePositionY = 20; //This is position y in the gameScene array but position x in real cordinates.
	private List<Integer> snakePositionsX = new ArrayList<Integer>();
	private List<Integer> snakePositionsY = new ArrayList<Integer>();
	
	Scene scene;
	Snake snake;
	Apple apple;
	
	public PlayerController() {
        JFrame frame = new JFrame();
        JTextArea textArea = new JTextArea();

        textArea.addKeyListener(this);
        frame.add(textArea);
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        scene = new Scene();
		snake = new Snake();
		apple = new Apple();
		
		snakePositionsX.add(snakePositionX);
		snakePositionsY.add(snakePositionY);
		
    }
	
	public void SnakeMovement() {
		snakePositionX = snakePositionX + up;
    	snakePositionY = snakePositionY + right;
    	
    	snakePositionsX.add(snakePositionX);
    	snakePositionsY.add(snakePositionY);
    	
    	if(scene.GetGameScene()[snakePositionX].charAt(snakePositionY) != apple.GetApple()) {
    		String strTail = scene.GetGameScene()[snakePositionsX.get(0)];
        	strTail = strTail.substring(0, snakePositionsY.get(0)) + ' ' 
                    + strTail.substring(snakePositionsY.get(0) + 1);
        	
        	scene.SetGameScene(snakePositionsX.get(0), strTail);
        	snakePositionsX.remove(0);
        	snakePositionsY.remove(0);
    	}
    	else {
    		System.out.println("apple geldiiii");
    	}
    	
    	String str = scene.GetGameScene()[snakePositionX];
    	str = str.substring(0, snakePositionY) + snake.GetSnake() 
                + str.substring(snakePositionY + 1);
    	
    	scene.SetGameScene(snakePositionX, str);
    	
	}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            //System.out.println("Up arrow key pressed");
            up = -1;
            right = 0;
            // Your code to run when the up arrow key is pressed
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            //System.out.println("Down arrow key pressed");
            up  = 1;
            right = 0;
            // Your code to run when the down arrow key is pressed
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            //System.out.println("Left arrow key pressed");
            right = -2;
            up = 0;
            // Your code to run when the left arrow key is pressed
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            //System.out.println("Right arrow key pressed");
            right = 2;
            up = 0;
            // Your code to run when the right arrow key is pressed
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used in this example
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used in this example
    }

}
