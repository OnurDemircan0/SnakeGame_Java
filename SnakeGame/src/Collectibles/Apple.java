package Collectibles;

public class Apple {

	char apple = 'a';
	
	static boolean isEaten = true;
	
	public char GetApple() {
		return apple;
	}
	
	public boolean GetIsEaten() {
		return isEaten;
	}
	
	public void SetIsEaten(boolean eaten) {
		isEaten = eaten;
	}
}
