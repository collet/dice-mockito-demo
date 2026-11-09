package god;

import org.junit.jupiter.api.Test;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

public class GameTest {

	Game g;
	
    @Test
    void noWinnerAfter5Attempts() {
        Dice single = mock(Dice.class);
        when(single.roll()).thenReturn(1);

        Player p1 =  spy(new Player("John", single));
        Player p2 =  spy(new Player("Jane", single));

        g = new Game(p1,p2);
        assertFalse(g.play().isPresent());
        verify(p1, times(5)).play();
        verify(p2, times(5)).play();
    }


    @Test
    void andTheWinnerIsP1() {

        Player p1 = mock(Player.class);
        when(p1.getLastValue()).thenReturn(Optional.of(new PlayResult(5)));

        Player p2 = mock(Player.class);
        when(p2.getLastValue()).thenReturn(Optional.of(new PlayResult(2)));

        g = new Game(p1,p2);
        assertEquals(p1, g.play().get());
    }
    
    @Test
    void andTheWinnerIsP2() {

        Player p1 = mock(Player.class);
        when(p1.getLastValue()).thenReturn(Optional.of(new PlayResult(1)));

        Player p2 = mock(Player.class);
        when(p2.getLastValue()).thenReturn(Optional.of(new PlayResult(6)));

        g = new Game(p1,p2);
        assertEquals(p2, g.play().get());
    }
}
