package Player;

import UI.*;
import Collectibles.*;
import Managers.GameManager;

import java.util.ArrayList;
import java.util.List;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class PlayerController implements KeyListener {

	private int right = 2;
	private int up = 0;
	
	private boolean canGoVerticle = true;
	private boolean canGoHorizontal = false;
	
	private int sizeCounter = 1;
	
	private int snakePositionX = 10; //This is position x in the gameScene array but position y in real cordinates.
	private int snakePositionY = 19; //This is position y in the gameScene array but position x in real cordinates.
	private List<Integer> snakePositionsX = new ArrayList<Integer>();
	private List<Integer> snakePositionsY = new ArrayList<Integer>();
	
	Scene scene;
	Snake snake;
	Apple apple;
	Scores scores;
	
	GameManager gameManager = new GameManager();
	
	public PlayerController() {
        scene = new Scene();
		snake = new Snake();
		apple = new Apple();
		scores = new Scores();
		
		snakePositionsX.add(snakePositionX);
		snakePositionsY.add(snakePositionY);
		
    }
	
	public void ResetValues() {
		right = 2;
		up = 0;
		
		canGoVerticle = true;
		canGoHorizontal = false;
		
		sizeCounter = 1;
		
		snakePositionX = 10;
		snakePositionY = 19;
		
		snakePositionsX.clear();
		snakePositionsY.clear();
		
		snakePositionsX.add(snakePositionX);
		snakePositionsY.add(snakePositionY);
	}
	
	public void SnakeMovement() {
		snakePositionX = snakePositionX + up;
    	snakePositionY = snakePositionY + right;
    	
    	snakePositionsX.add(snakePositionX);
    	snakePositionsY.add(snakePositionY);
    	
    	//Game Over
    	if(snakePositionX < 0 || snakePositionX > scene.GetGameScene().length - 1 || snakePositionY < 0 || snakePositionY > scene.GetGameScene()[1].length() - 1) {
    		gameManager.SetGameIsActive(false);
    		System.out.println(scene.GetGameOverScene());
    		
    		scores.AddHighScore();
    		scores.SetCurrentScore(0);
    		return;
    	}
    	
    	char nextCharPosition = scene.GetGameScene()[snakePositionX].charAt(snakePositionY);
    	
    	if(nextCharPosition == apple.GetApple() || sizeCounter < snake.GetInitialSize()){//Apple
    		apple.SetIsEaten(true);
    		scores.SetCurrentScore(scores.GetCurrentScore() + 1);
    		
    		sizeCounter++;
    	}
    	else if(nextCharPosition == ' ') {//Movement
    		String strTail = scene.GetGameScene()[snakePositionsX.get(0)];
        	strTail = strTail.substring(0, snakePositionsY.get(0)) + ' ' 
                    + strTail.substring(snakePositionsY.get(0) + 1);
        	
        	scene.SetGameScene(snakePositionsX.get(0), strTail);
        	snakePositionsX.remove(0);
        	snakePositionsY.remove(0);
    	}
    	else if(snake.GetObstacles().contains(nextCharPosition)) {//GameOver
    		gameManager.SetGameIsActive(false);
    		System.out.println(scene.GetGameOverScene());
    		
    		scores.AddHighScore();
    		scores.SetCurrentScore(0);
    		return;
    	}
    	
    	String str = scene.GetGameScene()[snakePositionX];
    	str = str.substring(0, snakePositionY) + snake.GetSnake() 
                + str.substring(snakePositionY + 1);
    	
    	scene.SetGameScene(snakePositionX, str);
    	
	}

    @Override
    public void keyPressed(KeyEvent e) {
    	if(gameManager.GetGameIsActive()) {
    		switch(e.getKeyCode()) {
    		case KeyEvent.VK_UP:
    			if(canGoVerticle) {
    				up = -1;
                    right = 0;
                    
                    canGoVerticle = false;
                    canGoHorizontal = true;
    			}
    			break;
    		case KeyEvent.VK_DOWN:
    			if(canGoVerticle) {
    				up  = 1;
                    right = 0;
                    
                    canGoVerticle = false;
                    canGoHorizontal = true;
    			}
    			break;
    		case KeyEvent.VK_LEFT:
    			if(canGoHorizontal) {
    				right = -2;
                    up = 0;
                    
                    canGoHorizontal = false;
                    canGoVerticle = true;
    			}
    			break;
    		case KeyEvent.VK_RIGHT:
    			if(canGoHorizontal) {
    				right = 2;
                    up = 0;
                    
                    canGoHorizontal = false;
                    canGoVerticle = true;
    			}
    			break;
    		}
    	}
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

}
