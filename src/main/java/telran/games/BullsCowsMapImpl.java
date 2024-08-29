package telran.games;

import java.util.*;
import java.util.stream.Collectors;

import telran.games.dto.*;

public class BullsCowsMapImpl implements BullsCowsService {
    private static final long N_SYMBOLS = 4;
	HashMap <Long, Game> games = new HashMap<>();
    
	@Override
	public long createNewGame() {
		long id = getId();
		String toBeGuessed = getRandomSequence();
		games.put(id, new Game(id, toBeGuessed));
		return id;
	}

	private String getRandomSequence() {
		String toBeGuessed =  new Random().ints(0, 10).distinct()
				.limit(N_SYMBOLS).mapToObj(Integer::toString)
				.collect(Collectors.joining());
		return toBeGuessed;
	}

	private long getId() {
		long id;
		do {
			id = new Random().nextLong();
		}while(games.containsKey(id));
		return id;
	}

	@Override
	public List<MoveResult> getResults(Move move) {
		Game game = getGame(move.gameId());
		if (game.isFinished()) {
			throw new RuntimeException("game is over");
		}
		List<MoveResult> res = game.moveProcess(move.guess());
		return res;
	}

	 Game getGame(long id) {
		Game game = games.get(id);
		if(game == null ) {
			throw new RuntimeException("move contains wrong game id");
		}
		return game;
	}

	@Override
	public boolean isGameOver(long gameId) {
		Game game = getGame(gameId);
		return game.isFinished();
	}

}
