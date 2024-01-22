package Controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Managers.GameManager;
import UI.Scene;

public class HighScoreMenuController implements KeyListener {

	Scene scene = new Scene();
	GameManager gameManager = new GameManager();
	
	public HighScoreMenuController() {
		
		
	}
	
	@Override
    public void keyPressed(KeyEvent e) {
		
    }

    @Override
    public void keyTyped(KeyEvent e) {
    	
    }

    @Override
    public void keyReleased(KeyEvent e) {
    	
    	if(gameManager.GetHighScoresMenuIsActive()) {
    		if(e.getKeyCode() == KeyEvent.VK_Z) {
    			gameManager.SetHighScoresMenuIsActive(false);
    			gameManager.SetMainMenuIsActive(true);
    			
    			System.out.println(scene.GetMainMenu());
    		}
    	}
    }
}
