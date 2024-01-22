package Managers;

import java.awt.event.KeyListener;

import Controllers.DifficultyController;
import Controllers.HighScoreMenuController;
import Controllers.MainMenuController;
import Player.PlayerController;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class GameManager {

	private static boolean mainMenuIsActive = true;
	private static boolean difficultyMenuIsActive = false;
	private static boolean highScoresMenuIsActive = false;
	private static boolean gameIsActive = false;
	
	JFrame frame;
	JTextArea textArea;
	
	public void KeyListenerWindow(MainMenuController mainMenuController, DifficultyController difficultyController, HighScoreMenuController highScoreMenuController, PlayerController playerController) {
		frame = new JFrame();
        textArea = new JTextArea();

        textArea.addKeyListener(mainMenuController);
        textArea.addKeyListener(difficultyController);
        textArea.addKeyListener(highScoreMenuController);
        textArea.addKeyListener(playerController);
        frame.add(textArea);
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public boolean GetMainMenuIsActive() {
		return mainMenuIsActive;
	}
	
	public void SetMainMenuIsActive(boolean isActive) {
		mainMenuIsActive = isActive;
	}
	
	public boolean GetDifficultyMenuIsActive() {
		return difficultyMenuIsActive;
	}
	
	public void SetDifficultyMenuIsActive(boolean isActive) {
		difficultyMenuIsActive = isActive;
	}
	
	public boolean GetHighScoresMenuIsActive() {
		return highScoresMenuIsActive;
	}
	
	public void SetHighScoresMenuIsActive(boolean isActive) {
		highScoresMenuIsActive = isActive;
	}
	
	public boolean GetGameIsActive() {
		return gameIsActive;
	}
	
	public void SetGameIsActive(boolean isActive) {
		gameIsActive = isActive;
	}
	
}
