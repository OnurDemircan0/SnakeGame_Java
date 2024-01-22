package Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scores {

	private static int currentScore = 0;
	private static List<Integer> highScores = new ArrayList<Integer>();
	
	public int GetCurrentScore() {
		return currentScore;
	}
	
	public void SetCurrentScore(int score) {
		currentScore = score;
	}
	
	public List<Integer> GetHighScores(){
		return highScores;
	}
	
	public void AddHighScore() {
		highScores.add(currentScore);
		
		Collections.sort(highScores, Collections.reverseOrder());
		
		if(highScores.size() > 10) {
			highScores.remove(highScores.size() - 1);
		}
	}
	
	public void PrintHighScores() {
		if(!highScores.isEmpty()) {
			for(int i = 0; i < highScores.size(); i++) {
				System.out.println((i + 1) + ". " + highScores.get(i));
			}
		}
		else {
			System.out.println("There isn't any score you've got!");
		}
		
	}
	
}
