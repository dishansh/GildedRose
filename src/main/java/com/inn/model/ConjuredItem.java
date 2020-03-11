package com.inn.model;

import com.inn.iface.InventoryItem;

public class ConjuredItem implements InventoryItem {

	@Override
	public void updateItem(Item item) {
		
		updateSellIn(item);
		updateQuality(item);	
	}
	
	private void updateQuality(Item item) {
		if (item.getSellIn() < 0) {
			if (item.getQuality() - 4 >= 0) {
				decrementQuality(item, 4);
			} else {
				item.setQuality(0);
			}
		} else {
			if (item.getQuality() > 0) {
				if (item.getQuality() - 2 >= 0) {
					decrementQuality(item, 2);
				} else {
					decrementQuality(item, 1);
				}
			}
		}
	}

	private void updateSellIn(Item item) {
		item.setSellIn(item.getSellIn()-1);
	}

	private void decrementQuality(Item item, int decrementValue) {
		item.setQuality(item.getQuality() - decrementValue);
	}
}