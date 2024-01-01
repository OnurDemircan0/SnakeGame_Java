package Collectibles;

public class Apple {

	char apple = 'a';
	int sizeUpgrade = 1;
	static boolean isEaten = true;
	
	public char GetApple() {
		return apple;
	}
	
	public int GetSizeUpgrade() {
		return sizeUpgrade;
	}
	
	public boolean GetIsEaten() {
		return isEaten;
	}
	
	public void SetIsEaten(boolean eaten) {
		isEaten = eaten;
	}
}
