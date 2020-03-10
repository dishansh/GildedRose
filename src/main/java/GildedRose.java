import java.util.List;

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
		return quantity<MAX_ALLOWED_QUALITY;
	}
	
	public static void updateQuality() {
		for (Item item : items) {
			if ((!"Aged Brie".equals(item.getName()))
					&& !"Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
				if (item.getQuality() > 0) {
					if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
						item.setQuality(item.getQuality() - 1);
					}
				}
			} else {
				if (withinMaximumQualityLimit(item.getQuality())) {
					item.setQuality(item.getQuality() + 1);

					if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
						if (item.getSellIn() < 11) {
							if (withinMaximumQualityLimit(item.getQuality())) {
								item.setQuality(item.getQuality() + 1);
							}
						}

						if (item.getSellIn() < 6) {
							if (withinMaximumQualityLimit(item.getQuality())) {
								item.setQuality(item.getQuality() + 1);
							}
						}
					}
				}
			}

			if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
				item.setSellIn(item.getSellIn() - 1);
			}

			if (item.getSellIn() < 0) {
				if (!"Aged Brie".equals(item.getName())) {
					if (!"Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
						if (item.getQuality() > 0) {
							if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
								item.setQuality(item.getQuality() - 1);
							}
						}
					} else {
						item.setQuality(item.getQuality() - item.getQuality());
					}
				} else {
					if (withinMaximumQualityLimit(item.getQuality())) {
						item.setQuality(item.getQuality() + 1);
					}
				}
			}
		}
	}

}