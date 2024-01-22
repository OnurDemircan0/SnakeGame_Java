package Player;

public class Difficulty {

	private static int difficulty = 250;
	private int easyMode = 2000;
	private int mediumMode = 1000;
	private int hardMode = 500;
	private int expertMode = 250;
	
	public int GetDifficulty() {
		return difficulty;
	}
	
	public void SetDifficulty(int dif) {
		difficulty = dif;
	}
	
	public int GetEasyMode() {
		return easyMode;
	}
	
	public int GetMediumMode() {
		return mediumMode;
	}
	
	public int GetHardMode() {
		return hardMode;
	}
	
	public int GetExpertMode() {
		return expertMode;
	}
}
