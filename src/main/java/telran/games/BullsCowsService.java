package telran.games;

import java.util.List;

import telran.games.dto.*;

public interface BullsCowsService {
	long createNewGame();
	List<MoveResult> getResults(Move move);
	boolean isGameOver(long gameId);
}
