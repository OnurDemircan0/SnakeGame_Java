package Player;

import java.util.*;

public class Snake {

	char snake = 'o';
	
	char[] obstacles = {snake, '|', '_', '¯'};
	
	public char GetSnake() {
		return snake;
	}
	
	public char[] GetObstacles() {
		return obstacles;
	}
}
