package Player;

import java.util.*;

public class Snake {

	char snake = 'o';
	
	private int snakePositionX = 10; //This is position x in the gameScene array but position y in real cordinates.
	private int snakePositionY = 20; //This is position y in the gameScene array but position x in real cordinates.
	private List<Integer> snakePositionsX = new ArrayList<Integer>();
	private List<Integer> snakePositionsY = new ArrayList<Integer>();
	
	public char GetSnake() {
		return snake;
	}
	
	public int GetSnakePositionX() {
		return snakePositionX;
	}
	
	public void SetSnakePositionX(int posX) {
		snakePositionX = posX;
	}
	
	public int GetSnakePositionY() {
		return snakePositionY;
	}
	
	public void SetSnakePositionY(int posY) {
		snakePositionY = posY;
	}
	
	public void AddSnakePositionX(int pos) {
		snakePositionsX.add(pos);
	}
	
	public int GetSnakeTailPositionX() {
		return snakePositionsX.get(0);
	}
	
	public void AddSnakePositionY(int pos) {
		snakePositionsY.add(pos);
	}
	
	public int GetSnakeTailPositionY() {
		return snakePositionsY.get(0);
	}
	
	public void RemoveTail() {
		snakePositionsX.remove(0);
		snakePositionsY.remove(0);
	}
	
}
