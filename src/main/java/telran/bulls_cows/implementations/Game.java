package telran.bulls_cows.implementations;

import java.time.LocalDateTime;
import java.util.*;

public class Game {

	
	 private final long id;
	    private final String serverSequence;
	    private boolean isFinished;
	    private final LocalDateTime startTime;
	    private LocalDateTime finishTime;
	    private final List<MoveResult> moveResults = new ArrayList<>();

	    public Game(long id, String serverSequence) {
	        this.id = id;
	        this.serverSequence = serverSequence;
	        this.isFinished = false;
	        this.startTime = LocalDateTime.now();
	    }

	    public long getId() {
	        return id;
	    }

	    public String getServerSequence() {
	        return serverSequence;
	    }

	    public boolean isFinished() {
	        return isFinished;
	    }

	    public LocalDateTime getStartTime() {
	        return startTime;
	    }

	    public LocalDateTime getFinishTime() {
	        return finishTime;
	    }

	    public List<MoveResult> getMoveResults() {
	        return moveResults;
	    }

	    public List<MoveResult> moveProcess(Move move) {

	        int bulls = 0;
	        int cows = 0;
	        String clientSequence = move.clientSequence();

	        for (int i = 0; i < 4; i++) {
	            if (serverSequence.charAt(i) == clientSequence.charAt(i)) {
	                bulls++;
	            } else if (serverSequence.contains(String.valueOf(clientSequence.charAt(i)))) {
	                cows++;
	            }
	        }

	        

	        if (bulls == 4) {
	            isFinished = true;
	            finishTime = LocalDateTime.now();
	        }
	        MoveResult moveResult = new MoveResult(clientSequence, bulls, cows);
	        moveResults.add(moveResult);

	        return moveResults;
	    }
	}

