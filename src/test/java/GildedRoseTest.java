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
	
	@Test
	public void sellInDaysRemainConstantForSulfuras() {
		
		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Sulfuras, Hand of Ragnaros", 20, 80)));
		inventoryApp.updateQuality();
		assertEquals(20, inventoryApp.getItems().get(0).getSellIn());
	}
	
	@Test
	public void standardDecreaseInQualityAfterSellByDateShouldBeTwiceAsNormal() {
		
		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Custom Item", 0, 22)));
		inventoryApp.updateQuality();
		assertEquals(20, inventoryApp.getItems().get(0).getQuality());
	}
	
	@Test
	public void backStagePassesQualityIncreaseAsSellByDateDecreases() {
		
		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 22)));
		inventoryApp.updateQuality();
		assertEquals(23, inventoryApp.getItems().get(0).getQuality());	
	}
	
	@Test
	public void backStagePassesQualityIncreaseByTwo_whenSellByDateIsLessThanOrEqualToTen() {
		
		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Backstage passes to a TAFKAL80ETC concert", 9, 22)));
		inventoryApp.updateQuality();
		assertEquals(24, inventoryApp.getItems().get(0).getQuality());	
	}
	
	@Test
	public void backStagePassesQualityIncreaseByThree_whenSellByDateIsLessThanOrEqualToFive() {
		
		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 22)));
		inventoryApp.updateQuality();
		assertEquals(25, inventoryApp.getItems().get(0).getQuality());	
	}
	
	@Test
	public void backStagePassesQualityDropsToZero_whenSellByDateIsPassed() {
		
		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Backstage passes to a TAFKAL80ETC concert", -1, 22)));
		inventoryApp.updateQuality();
		assertEquals(0, inventoryApp.getItems().get(0).getQuality());	
	}
	
	@Test
	public void conjuredItemQualityDecreasesTwiceThanNormal() {
		
		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Conjured Item", 6, 22)));
		inventoryApp.updateQuality();
		assertEquals(20, inventoryApp.getItems().get(0).getQuality());
	}
}
