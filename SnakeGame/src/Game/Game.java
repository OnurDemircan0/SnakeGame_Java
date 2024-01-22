package Game;

import Player.PlayerController;

import java.util.Timer;
import java.util.TimerTask;

import Collectibles.Apple;
import Collectibles.CollectibleController;
import UI.Scene;
import Player.Difficulty;
import Controllers.DifficultyController;
import Controllers.HighScoreMenuController;
import Controllers.MainMenuController;
import Managers.GameManager;

public class Game {
	
	boolean restartGame = true;
	
	public static void main(String[] args) {
		
		new Game();
		
	}
	
	public Game() {
		GameManager gameManager = new GameManager();
		Difficulty difficulty = new Difficulty();
		Scene scene = new Scene();
		scene.DefaultGameSceneOperation();
		
		Apple apple = new Apple();
		
		MainMenuController mainMenuController = new MainMenuController();
		DifficultyController difficultyController = new DifficultyController();
		HighScoreMenuController highScoreMenuController = new HighScoreMenuController();
		PlayerController playerController = new PlayerController();
		
		gameManager.KeyListenerWindow(mainMenuController, difficultyController, highScoreMenuController, playerController);
		
		System.out.println(scene.GetMainMenu());
		
		Timer timer2 = new Timer();
		
		timer2.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
            	//System.out.println(gameManager.GetGameIsActive() + " " + restartGame);
            	if(gameManager.GetGameIsActive() && restartGame) {
            		System.out.println(gameManager.GetGameIsActive());
        			Timer timer = new Timer();
        	        
        	        timer.scheduleAtFixedRate(new TimerTask() {
        	            @Override
        	            public void run() {
        	            	if(gameManager.GetGameIsActive()) {
        	            		playerController.SnakeMovement();
                        		if(gameManager.GetGameIsActive()) {
                        			new CollectibleController();
                        			scene.GameScene();
                        		}
        	            	}
        	            	else {
        	            		try {
									Thread.sleep(1500);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
        	            		
        	            		timer.cancel();
        	            		gameManager.SetGameIsActive(false);
        	            		gameManager.SetMainMenuIsActive(true);
        	            		System.out.println(scene.GetMainMenu());
        	            		scene.DefaultGameSceneOperation();
        	            		
        	            		playerController.ResetValues();
        	            		apple.SetIsEaten(true);
        	            		
        	            		restartGame = true;
        	            	}
        	            }
        	        }, 0, difficulty.GetDifficulty());
        	        
        	        restartGame = false;
        		}
            	//System.out.println(gameManager.GetDifficultyMenuIsActive());
            }
        }, 0, 20);
		
		
		
		
		
	}
	
}
