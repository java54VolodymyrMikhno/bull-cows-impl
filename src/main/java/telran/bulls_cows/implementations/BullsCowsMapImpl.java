package telran.bulls_cows.implementations;

import java.util.*;
import java.util.stream.Collectors;


public class BullsCowsMapImpl implements BullsCowsService {
    private  Map<Long, Game> games = new HashMap<>();
    private  long idCounter = 0;

    @Override
    public Long createNewGame() {
        long gameId = ++idCounter;
        String serverSequence = generateServerSequence();
        games.put(gameId, new Game(gameId, serverSequence));
        return gameId;
    }

    @Override
    public List<MoveResult> getResults(long gameId, Move move) {
        Game game = games.get(gameId);
        if (game == null) {
            throw new IllegalArgumentException("Game not found");
        }
        return game.moveProcess(move);
    }

    @Override
    public boolean isGameOver(long gameId) {
        Game game = games.get(gameId);
        return game != null && game.isFinished();
    }

    private String generateServerSequence() {
        List<Character> digits = "0123456789".chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        Collections.shuffle(digits);
        StringBuilder sequence = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sequence.append(digits.get(i));
        }
       
        return sequence.toString();
    }
}
