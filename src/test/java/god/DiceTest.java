
package god;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DiceTest {

	Dice theDice;

	@Mock Random trickedRandom = mock(Random.class);

	@Test
	void rollReturnsAValue() {
		theDice = new Dice(new Random());
		for (int i = 0; i < 100; i++) {
			int result = theDice.roll();
			assertTrue(result >= 1);
			assertTrue(result <= 6);
		}
	}

	@Test
	void identifyBadValuesGreaterThanNumberOfFaces() {
		when(trickedRandom.nextInt(anyInt())).thenReturn(7);
		theDice = new Dice(trickedRandom);
		assertThrows(RuntimeException.class, () -> theDice.roll());
	}

	@Test
    void identifyBadValuesLesserThanOne() {
        when(trickedRandom.nextInt(eq(Dice.FACES))).thenReturn(-1);
        theDice = new Dice(trickedRandom);
		assertThrows(RuntimeException.class, () -> theDice.roll());
	}

}
