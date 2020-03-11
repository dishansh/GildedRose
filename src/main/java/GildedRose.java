import java.util.List;

import com.inn.model.Item;

public class GildedRose {

	private static List<Item> items = null;
	private static final int MAX_ALLOWED_QUALITY = 50;
	
	private static final String BACKSTAGE_PASS_ITEM = "Backstage passes to a TAFKAL80ETC concert";
	private static final String SULFURAS_ITEM = "Sulfuras, Hand of Ragnaros";
	private static final String AGED_BRIE_ITEM = "Aged Brie";
	private static final String CONJURED_ITEM = "Conjured Item";

	public GildedRose(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}

	private static boolean withinMaximumQualityLimit(int quantity) {
		return quantity < MAX_ALLOWED_QUALITY;
	}

	private static void updateSellInDays(Item item) {
		// Updating SellIn Day for all items except "Sulfuras" - Legendary Item
		if (!SULFURAS_ITEM.equals(item.getName())) {
			item.setSellIn(item.getSellIn() - 1);
		}
	}

	private static void incrementQuality(Item item) {
		item.setQuality(item.getQuality() + 1);
	}

	private static void decrementQuality(Item item) {
		item.setQuality(item.getQuality() - 1);
	}

	private static void updateQualityForConjuredItem(Item item) {
		if (item.getSellIn() < 0) {
			if (item.getQuality() - 4 >= 0) {
				item.setQuality(item.getQuality() - 4);
			} else {
				item.setQuality(0);
			}
		} else {
			if (item.getQuality() - 2 >= 0) {
				item.setQuality(item.getQuality() - 2);
			} else {
				decrementQuality(item);
			}
		}
	}

	private static void updateQualityForBackstagePassesItem(Item item) {
		if (item.getSellIn() < 11) {
			if (withinMaximumQualityLimit(item.getQuality())) {
				incrementQuality(item);
			}
		}
		if (item.getSellIn() < 6) {
			if (withinMaximumQualityLimit(item.getQuality())) {
				incrementQuality(item);
			}
		}
	}

	private static boolean ifItemExpired(Item item) {
		return item.getSellIn() < 0;
	}

	private static void updateQualityForExpiredItem(Item item) {
		if (!AGED_BRIE_ITEM.equals(item.getName())) {
			if (!BACKSTAGE_PASS_ITEM.equals(item.getName())) {
				if (item.getQuality() > 0) {
					if (!SULFURAS_ITEM.equals(item.getName())
							&& !CONJURED_ITEM.equals(item.getName())) {
						decrementQuality(item);
					}
				}
			} else {
				item.setQuality(item.getQuality() - item.getQuality());
			}
		} else {
			if (withinMaximumQualityLimit(item.getQuality())) {
				incrementQuality(item);
			}
		}
	}

	private static void updateQuality(Item item) {
		if ((!AGED_BRIE_ITEM.equals(item.getName()))
				&& !BACKSTAGE_PASS_ITEM.equals(item.getName())) {
			if (item.getQuality() > 0) {
				if (!SULFURAS_ITEM.equals(item.getName()) && !CONJURED_ITEM.equals(item.getName())) {
					decrementQuality(item);
				}
				if (CONJURED_ITEM.equals(item.getName())) {
					updateQualityForConjuredItem(item);
				}
			}
		} else {
			if (withinMaximumQualityLimit(item.getQuality())) {
				incrementQuality(item);

				if (BACKSTAGE_PASS_ITEM.equals(item.getName())) {
					updateQualityForBackstagePassesItem(item);
				}
			}
		}
		if (ifItemExpired(item)) {
			updateQualityForExpiredItem(item);
		}
	}

	public static void update() {
		for (Item item : items) {
			// Decreasing SellIn Day for each item by-default
			updateSellInDays(item);

			// Updating Quality for Items before expiring
			updateQuality(item);
		}
	}
}