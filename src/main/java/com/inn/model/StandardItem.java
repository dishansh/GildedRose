package com.inn.model;

import com.inn.iface.InventoryItem;

public class StandardItem implements InventoryItem {

	private void updateQuality(Item item) {

		if (item.getQuality() > 0) {
			item.setQuality(item.getQuality() - 1);
		}

		if (item.getSellIn() < 0) {
			if (item.getQuality() > 0) {
				item.setQuality(item.getQuality() - 1);
			}
		}
	}

	private void updateSellIn(Item item) {

		item.setSellIn(item.getSellIn() - 1);
	}

	@Override
	public void updateItem(Item item) {

		updateSellIn(item);
		updateQuality(item);
	}
}