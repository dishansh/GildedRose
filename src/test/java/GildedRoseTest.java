import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.inn.model.Item;

public class GildedRoseTest {

	@Test
	public void creationOfInventoryWithItem() {

		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Custom Item", 20, 15)));
		assertEquals("Custom Item", inventoryApp.getItems().get(0).getName());
	}

	@Test
	public void standardDecreaseInQualityAfterOneDay() {

		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Custom Item", 20, 15)));
		inventoryApp.update();
		assertEquals(14, inventoryApp.getItems().get(0).getQuality());
	}

	@Test
	public void standardDecreaseInSellInAfterOneDay() {

		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Custom Item", 20, 15)));
		inventoryApp.update();
		assertEquals(19, inventoryApp.getItems().get(0).getSellIn());
	}

	@Test
	public void standardDecreaseInQualityAfterTwoDays() {

		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Custom Item", 20, 15)));
		inventoryApp.update();
		inventoryApp.update();
		assertEquals(13, inventoryApp.getItems().get(0).getQuality());
	}

	@Test
	public void standardDecreaseInSellInAfterTwoDays() {

		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Custom Item", 20, 15)));
		inventoryApp.update();
		inventoryApp.update();
		assertEquals(18, inventoryApp.getItems().get(0).getSellIn());
	}

	@Test
	public void standardDecreaseInQualityShouldNotBeBelowZero() {

		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Custom Item", 20, 0)));
		inventoryApp.update();
		assertEquals(0, inventoryApp.getItems().get(0).getQuality());
	}

	@Test
	public void qualityForAgedBrieIncreasesByDay() {

		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Aged Brie", 20, 32)));
		inventoryApp.update();
		inventoryApp.update();
		assertEquals(34, inventoryApp.getItems().get(0).getQuality());
	}

	@Test
	public void qualityForAgedBrieCanNeverBeMoreThanFifty() {

		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Aged Brie", 20, 50)));
		inventoryApp.update();
		assertEquals(50, inventoryApp.getItems().get(0).getQuality());
	}

	@Test
	public void qualityOfSulfurusRemainsUnchanged() {

		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Sulfuras, Hand of Ragnaros", 20, 80)));
		inventoryApp.update();
		assertEquals(80, inventoryApp.getItems().get(0).getQuality());
	}

	@Test
	public void sellInDaysRemainConstantForSulfuras() {

		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Sulfuras, Hand of Ragnaros", 20, 80)));
		inventoryApp.update();
		assertEquals(20, inventoryApp.getItems().get(0).getSellIn());
	}

	@Test
	public void standardDecreaseInQualityAfterSellByDateShouldBeTwiceAsNormal() {

		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Custom Item", 0, 22)));
		inventoryApp.update();
		assertEquals(20, inventoryApp.getItems().get(0).getQuality());
	}

	@Test
	public void backStagePassesQualityIncreaseAsSellByDateDecreases() {

		GildedRose inventoryApp = new GildedRose(
				Arrays.asList(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 22)));
		inventoryApp.update();
		assertEquals(23, inventoryApp.getItems().get(0).getQuality());
	}

	@Test
	public void backStagePassesQualityIncreaseByTwo_whenSellByDateIsLessThanOrEqualToTen() {

		GildedRose inventoryApp = new GildedRose(
				Arrays.asList(new Item("Backstage passes to a TAFKAL80ETC concert", 9, 22)));
		inventoryApp.update();
		assertEquals(24, inventoryApp.getItems().get(0).getQuality());
	}

	@Test
	public void backStagePassesQualityIncreaseByThree_whenSellByDateIsLessThanOrEqualToFive() {

		GildedRose inventoryApp = new GildedRose(
				Arrays.asList(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 47)));
		inventoryApp.update();
		assertEquals(50, inventoryApp.getItems().get(0).getQuality());
	}

	@Test
	public void backStagePassesQualityDropsToZero_whenSellByDateIsPassed() {

		GildedRose inventoryApp = new GildedRose(
				Arrays.asList(new Item("Backstage passes to a TAFKAL80ETC concert", -1, 22)));
		inventoryApp.update();
		assertEquals(0, inventoryApp.getItems().get(0).getQuality());
	}

	@Test
	public void conjuredItemQualityDecreasesTwiceThanNormal() {

		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Conjured Item", 6, 3)));
		inventoryApp.update();
		assertEquals(1, inventoryApp.getItems().get(0).getQuality());
	}

	@Test
	public void conjuredItemQualityDecreasesByFour_whenSellInDayIsPassed() {

		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Conjured Item", -1, 3)));
		inventoryApp.update();
		assertEquals(0, inventoryApp.getItems().get(0).getQuality());
	}
	
	@Test
	public void conjuredItemQualityCannotBeLessThanZero() {
		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("Conjured Item", 3, 0)));
		inventoryApp.update();
		assertEquals(0, inventoryApp.getItems().get(0).getQuality());
	}
	
	@Test
	public void checkIfEmptyNameItemIsAllowed() {
		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item("",0,0)));
		inventoryApp.update();
		assertEquals(0, inventoryApp.getItems().get(0).getQuality());	
	}
	
	@Test
	public void itemWithNameAsNullShouldNotBeCreated() {
		GildedRose inventoryApp = new GildedRose(Arrays.asList(new Item(null,0,0)));
		inventoryApp.update();
		assertEquals(0, inventoryApp.getItems().size());	
	}
}
