package telran.games;

import java.time.LocalDateTime;
import java.util.*;

import telran.games.dto.*;

public class Game {
	long id;
	String toBeGuessed;
	boolean isFinished;
	LocalDateTime start;
	LocalDateTime finish;
	List<MoveResult> history;
	public Game(long id, String toBeGuessed) {
		this.id = id;
		this.toBeGuessed = toBeGuessed;
		isFinished = false;
		start = LocalDateTime.now();
		history = new ArrayList<>();
	}
	public boolean isFinished() {
		return isFinished;
	}
	
	public LocalDateTime getFinish() {
		return finish;
	}
	
	
	public String getToBeGuessed() {
		//for testing purpose only
		return toBeGuessed;
	}
	public List<MoveResult> moveProcess(String guess) {
		int [] bullsCows = new int[2];
		fillBullsCows(guess, bullsCows);
		history.add(new MoveResult(guess, bullsCows[0], bullsCows[1]));
		if(bullsCows[0] == 4) {
			isFinished = true;
		}
		return history;
	}
	private void fillBullsCows(String guess, int[] bullsCows) {
		int j = 0; //index in bullsCows; 0 - number of bulls, 1 - number of cows
		char chars[] = guess.toCharArray();
		for(int i = 0; i < chars.length; i++) {
			int index = toBeGuessed.indexOf(chars[i]);
			if (index >= 0) {
				j = index == i ? 0 : 1;
				bullsCows[j]++;
			}
		}
	}
	
}
