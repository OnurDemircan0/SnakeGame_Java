package Game;

import Player.PlayerController;

import java.util.Timer;
import java.util.TimerTask;

import Collectibles.CollectibleController;
import UI.Scene;

public class Game {
	
	public static void main(String[] args) {
		
		PlayerController playerController = new PlayerController();
		
		Timer timer = new Timer();
        
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                
            	playerController.SnakeMovement();
        		new CollectibleController();
        		new Scene();
            }
        }, 0, 250);
        
		
	}
	
}
