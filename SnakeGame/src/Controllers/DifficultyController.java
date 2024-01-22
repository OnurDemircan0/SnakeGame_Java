package Controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Managers.GameManager;
import Player.Difficulty;
import UI.Scene;

public class DifficultyController implements KeyListener {

	Difficulty difficulty = new Difficulty();
	Scene scene = new Scene();
	GameManager gameManager = new GameManager();

	public DifficultyController() {
		
		
	}
	
	@Override
    public void keyPressed(KeyEvent e) {
		
    }

    @Override
    public void keyTyped(KeyEvent e) {
    	
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    	if(gameManager.GetDifficultyMenuIsActive()) {
			switch(e.getKeyCode()) {
    		case KeyEvent.VK_Q:
    			difficulty.SetDifficulty(difficulty.GetEasyMode());
    			
    			gameManager.SetDifficultyMenuIsActive(false);
    			gameManager.SetMainMenuIsActive(true);
    			
    			System.out.println(scene.GetMainMenu());
    			break;
    		case KeyEvent.VK_W:
    			difficulty.SetDifficulty(difficulty.GetMediumMode());
    			
    			gameManager.SetDifficultyMenuIsActive(false);
    			gameManager.SetMainMenuIsActive(true);
    			
    			System.out.println(scene.GetMainMenu());
    			break;
    		case KeyEvent.VK_E:
    			difficulty.SetDifficulty(difficulty.GetHardMode());
    			
    			gameManager.SetDifficultyMenuIsActive(false);
    			gameManager.SetMainMenuIsActive(true);
    			
    			System.out.println(scene.GetMainMenu());
    			break;
    		case KeyEvent.VK_R:
    			difficulty.SetDifficulty(difficulty.GetExpertMode());
    			
    			gameManager.SetDifficultyMenuIsActive(false);
    			gameManager.SetMainMenuIsActive(true);
    			
    			System.out.println(scene.GetMainMenu());
    			break;
			}
		}
    }
}
