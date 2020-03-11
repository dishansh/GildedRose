package com.inn.model;

import com.inn.iface.InventoryItem;

public class BackstagePassesItem implements InventoryItem {

	@Override
	public void updateItem(Item item) {
		reduceSellByDayByOne(item);
        if (isSellByDayOver(item, 10)) {
            increaseQualityBy(item, 1);
        } else if (isSellByDayOver(item, 5)) {
            increaseQualityBy(item, 2);
        } else if (isSellByDayOver(item, 0)) {
            increaseQualityBy(item, 3);
        } else {
            dropQualityToZero(item);
        }
		
	}
	
	private void reduceSellByDayByOne(Item item) {
        item.setSellIn(item.getSellIn()-1);
    }

    private boolean isSellByDayOver(Item item, int noOfDays) {
        return item.getSellIn() > noOfDays;
    }

    private void increaseQualityBy(Item item, int incrementValue) {
        item.setQuality(item.getQuality()+incrementValue);
    }

    private void dropQualityToZero(Item item) {
        item.setQuality(0);
    }

}
