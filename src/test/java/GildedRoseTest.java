import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class GildedRoseTest {

	@Test
	public void creationOfInventoryWithItem() {

		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Custom Item", 20, 15)));
		assertEquals("Custom Item", inventoryApp.getItems().get(0).getName());
	}

	@Test
	public void standardDecreaseInQualityAfterOneDay() {

		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Custom Item", 20, 15)));
		inventoryApp.updateQuality();
		assertEquals(14, inventoryApp.getItems().get(0).getQuality());
	}

	@Test
	public void standardDecreaseInSellInAfterOneDay() {

		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Custom Item", 20, 15)));
		inventoryApp.updateQuality();
		assertEquals(19, inventoryApp.getItems().get(0).getSellIn());
	}

	@Test
	public void standardDecreaseInQualityAfterTwoDays() {

		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Custom Item", 20, 15)));
		inventoryApp.updateQuality();
		inventoryApp.updateQuality();
		assertEquals(13, inventoryApp.getItems().get(0).getQuality());
	}

	@Test
	public void standardDecreaseInSellInAfterTwoDays() {

		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Custom Item", 20, 15)));
		inventoryApp.updateQuality();
		inventoryApp.updateQuality();
		assertEquals(18, inventoryApp.getItems().get(0).getSellIn());
	}

	@Test
	public void standardDecreaseInQualityShouldNotBeBelowZero() {

		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Custom Item", 20, 0)));
		inventoryApp.updateQuality();
		assertEquals(0, inventoryApp.getItems().get(0).getQuality());
	}
	
	@Test
	public void qualityForAgedBrieIncreasesByDay() {
		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Aged Brie", 20, 32)));
		inventoryApp.updateQuality();
		inventoryApp.updateQuality();
		assertEquals(34, inventoryApp.getItems().get(0).getQuality());
	}

	@Test
	public void qualityForAgedBrieCanNeverBeMoreThanFifty() {

		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Aged Brie", 20, 50)));
		inventoryApp.updateQuality();
		assertEquals(50, inventoryApp.getItems().get(0).getQuality());
	}

	@Test
	public void qualityOfSulfurusRemainsUnchanged() {

		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Sulfuras, Hand of Ragnaros", 20, 80)));
		inventoryApp.updateQuality();
		assertEquals(80, inventoryApp.getItems().get(0).getQuality());
	}
}
