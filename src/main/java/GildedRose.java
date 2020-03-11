import java.util.List;

import com.inn.model.Item;

public class GildedRose {

	private static List<Item> items = null;

	private static final int MAX_ALLOWED_QUALITY = 50;

	public GildedRose(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}
	
	public static boolean withinMaximumQualityLimit(int quantity) {
		return quantity < MAX_ALLOWED_QUALITY;
	}

	public static void updateSellInDays(Item item) {

		// Updating SellIn Day for all items except "Sulfuras" - Legendary Item
		if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
			item.setSellIn(item.getSellIn() - 1);
		}
	}

	public static void incrementQuality(Item item) {
		item.setQuality(item.getQuality() + 1);
	}

	public static void decrementQuality(Item item) {
		item.setQuality(item.getQuality() - 1);
	}

	public static void decrementQualityForConjuredItem(Item item) {
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

	public static void update() {
		for (Item item : items) {

			// Decreasing SellIn Day for each item by-default
			updateSellInDays(item);

			if ((!"Aged Brie".equals(item.getName()))
					&& !"Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
				if (item.getQuality() > 0) {
					if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())
							&& !"Conjured Item".equals(item.getName())) {
						decrementQuality(item);
					}
					if ("Conjured Item".equals(item.getName())) {
						decrementQualityForConjuredItem(item);
					}

				}
			} else {
				if (withinMaximumQualityLimit(item.getQuality())) {
					incrementQuality(item);

					if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
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
				}
			}

			if (item.getSellIn() < 0) {
				if (!"Aged Brie".equals(item.getName())) {
					if (!"Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
						if (item.getQuality() > 0) {
							if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()) && !"Conjured Item".equals(item.getName())) {
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
		}
	}

}