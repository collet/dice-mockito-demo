package god;

import org.junit.jupiter.api.Test;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class PlayerTest {

    Player p;
    
    @Test
    void lastValueNotInitialized() {
        p = new Player("John Doe", new Dice(new Random()));
        assertFalse(p.getLastValue().isPresent());
    }

    @Test
    void lastValueInitialized() {
        p = new Player("John Doe", new Dice(new Random()));
        p.play();
        assertTrue(p.getLastValue().isPresent());
    }

    @Test
    void throwDiceOnlyTwice() {
        Dice d = mock(Dice.class);
        p = new Player("John Doe", d);
        p.play();
        verify(d, times(2)).roll();
    }
    
    @Test
    void keepTheMaximum() {
        Dice d = mock(Dice.class);
        p = new Player("John Doe", d);

        when(d.roll()).thenReturn(2,5);
        p.play();
        assertEquals(new PlayResult(5), p.getLastValue().get());
        
        when(d.roll()).thenReturn(6).thenReturn(1);
        p.play();
        assertEquals(new PlayResult(6), p.getLastValue().get());
        
    }
    
}