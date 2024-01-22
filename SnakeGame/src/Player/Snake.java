package Player;

import java.util.*;

public class Snake {

	char snake = 'o';
	
	private int initialSize = 2;
	
	List<Character> obstacles = new ArrayList<>(Arrays.asList(snake, '|', '_', '¯'));
	
	public char GetSnake() {
		return snake;
	}
	
	public List<Character> GetObstacles() {
		return obstacles;
	}
	
	public int GetInitialSize() {
		return initialSize;
	}
}
