package UI;

import java.util.Timer;
import java.util.TimerTask;

public class Scene {

	private static String[] gameScene = {"_________________________________________",
					   	  "|                                       |",
					   	  "|                                       |",
					   	  "|                                       |",
					   	  "|                                       |",
					   	  "|                                       |",
					   	  "|                                       |",
					   	  "|                                       |",
					   	  "|                                       |",
					   	  "|                                       |",
					   	  "|                                       |",
					   	  "|                                       |",
					   	  "|                                       |",
					   	  "|                                       |",
					   	  "|                                       |",
					   	  "|                                       |",
					   	  "|                                       |",
					   	  "|                                       |",
					   	  "|                                       |",
					   	  "|                                       |",
					   	  "|                                       |",
					   	  "¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯"};
	
	
	public Scene() {
		
		for(String var : gameScene) {
			System.out.println(var);
		}
	}
	
	public String[] GetGameScene() {
		return gameScene;
	}
	
	public void SetGameScene(int index, String updatedLine) {
		gameScene[index] = updatedLine;
	}
	
}
