package telran.games;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import telran.games.dto.Move;
import telran.games.dto.MoveResult;

abstract class BullsCowsTest {
BullsCowsService bullsCows = getBullsCowsImpl();
long id = bullsCows.createNewGame();
Game game = getGame(id, bullsCows);

	@Test
	void movesTest() {
		String sequence = game.getToBeGuessed();
		char[]seqChars = sequence.toCharArray();
		seqChars[0] ='*';
		seqChars[1] = seqChars[2];
		seqChars[2] = '*';
		String guess = new String(seqChars);
		MoveResult res1 = new MoveResult(guess, 1, 1);
		MoveResult resLast = new MoveResult(sequence, 4, 0);
		List<MoveResult> expected1 = List.of(res1);
		List<MoveResult> expectedLast = List.of(res1, resLast);
		assertIterableEquals(expected1, bullsCows.getResults(new Move(id, guess)));
		assertIterableEquals(expectedLast, bullsCows.getResults(new Move(id, sequence)));
		assertTrue(bullsCows.isGameOver(id));
		
	}

	protected abstract BullsCowsService getBullsCowsImpl() ;
	protected abstract Game getGame(long id, BullsCowsService bullsCows);
}
