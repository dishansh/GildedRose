package com.inn.model;

import com.inn.iface.InventoryItem;

public class AgedBrieItem implements InventoryItem {

	@Override
	public void updateItem(Item item) {
		
		updateSellIn(item);
		increaseInQuality(item);		
	}
	
	private void increaseInQuality(Item item) {
		if(item.getQuality()<50) {
			item.setQuality(item.getQuality()+1);
		}
	}
	
	private void updateSellIn(Item item) {
		item.setSellIn(-1);
	}
}