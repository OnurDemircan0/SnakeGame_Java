package Controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Player.Scores;
import UI.Scene;
import Managers.GameManager;

public class MainMenuController implements KeyListener {
	
	Scene scene = new Scene();
	GameManager gameManager = new GameManager();
	Scores scores = new Scores();
	
	public MainMenuController() {
		
		
	}
	
	@Override
    public void keyPressed(KeyEvent e) {
		
    }

    @Override
    public void keyTyped(KeyEvent e) {
    	
    }

    @Override
    public void keyReleased(KeyEvent e) {
    	
    	if(gameManager.GetMainMenuIsActive()) {
			switch(e.getKeyCode()) {
    		case KeyEvent.VK_NUMPAD1:
    			gameManager.SetMainMenuIsActive(false);
    			gameManager.SetGameIsActive(true);
    			break;
    		case KeyEvent.VK_NUMPAD2:
    			gameManager.SetMainMenuIsActive(false);
    			gameManager.SetDifficultyMenuIsActive(true);
    			
    			System.out.println(scene.GetDifficultyMenu());
    			break;
    		case KeyEvent.VK_NUMPAD3:
    			gameManager.SetMainMenuIsActive(false);
    			gameManager.SetHighScoresMenuIsActive(true);
    			
    			System.out.println(scene.GetHighScoresMenu());
    			scores.PrintHighScores();
    			break;
			}
		}
    }
}
