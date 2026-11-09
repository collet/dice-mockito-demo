package god;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayResultTest {
	
	PlayResult pr1;
	PlayResult pr2;
	
	@BeforeEach
	void setUp() {
	  pr1 = new PlayResult(5);
	  pr2 = new PlayResult(2);
	}
	
	@Test
	void testCompareTo() {
		assertTrue(pr1.compareTo(pr2) > 0);
		assertTrue(pr2.compareTo(pr1) < 0);
        assertEquals(0, pr1.compareTo(pr1));
		assertEquals(0, pr1.compareTo(new PlayResult(5)));
	}
	
	@Test
	void testEquals() {
		assertEquals(pr1,pr1);
		assertEquals(new PlayResult(5), pr1);
		assertNotEquals(pr1,pr2);		
	}

}

