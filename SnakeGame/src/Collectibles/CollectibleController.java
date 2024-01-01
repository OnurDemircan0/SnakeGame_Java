package Collectibles;

import java.util.Timer;
import java.util.TimerTask;
import UI.Scene;
import java.util.Random;

public class CollectibleController {

	public CollectibleController() {
		
		Scene scene = new Scene();
		Apple apple = new Apple();
		
		if(apple.GetIsEaten()) {
    		Random random = new Random();
    		boolean appleInstantiated = false;
    		while(!appleInstantiated) {
    			
    			int applePositionX = random.nextInt(1, scene.GetGameScene().length - 1);
        		int applePositionY = random.nextInt(1, scene.GetGameScene()[1].length() - 1);
        		//System.out.println(applePositionX);
        		//System.out.println(applePositionY);
        		if(scene.GetGameScene()[applePositionX].charAt(applePositionY) != ' ') continue;
        		
        		String str = scene.GetGameScene()[applePositionX];
            	str = str.substring(0, applePositionY) + apple.apple 
                        + str.substring(applePositionY + 1);
            	//System.out.println("sorun var");
            	scene.SetGameScene(applePositionX, str);
            	
            	apple.SetIsEaten(false);
            	appleInstantiated = true;
    		}
    		
    	}
		
		
    }
}
