import static org.junit.Assert.*;

import org.junit.Test;


public class GildedRoseTest {

	@Test
	public void testTheTruth() {
		assertTrue(true);
	}
	
	@Test
	public void testCreationOfItems() {	
		GildedRose testItem = new GildedRose();
		assertEquals(6, testItem.getItems().size());
	}
}
