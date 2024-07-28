package telran.bulls_cows_impl_tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.bulls_cows.implementations.*;

class BullsCowsMapImplTes {

     BullsCowsMapImpl service;
     long gameId;
    String fixedServerSequence;
    Game game;

    @BeforeEach
    void setUp() {
        service = new BullsCowsMapImpl();
        gameId = service.createNewGame();
        fixedServerSequence = "1234";
        game = new Game(gameId, fixedServerSequence);
    }

    @Test
    void testCreateNewGame() {
        long newGameId = service.createNewGame();
        assertNotEquals(gameId, newGameId);
    }

    @Test
    void testGetResults() {
       
        Move move = new Move(gameId, "1243");
        List<MoveResult> results = game.moveProcess(move);

        assertNotNull(results);
        assertEquals(1, results.size());

        MoveResult result = results.get(0);
        assertEquals("1243", result.clientSequence());
        assertEquals(2, result.bulls());
        assertEquals(2, result.cows());
    }

    @Test
    void testIsGameOver() {
        Move winningMove = new Move(gameId, "1234");
        game.moveProcess(winningMove);
        
        assertTrue(game.isFinished());
    }

    @Test
    void testGameNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.getResults(-1, new Move(gameId, "1245"));
        });
    }

   
}
