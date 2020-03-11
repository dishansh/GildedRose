package com.inn.factory;

import com.inn.iface.InventoryItem;
import com.inn.model.AgedBrieItem;
import com.inn.model.BackstagePassesItem;
import com.inn.model.ConjuredItem;
import com.inn.model.Item;
import com.inn.model.LegendarySulfurasItem;
import com.inn.model.StandardItem;

public class ItemFactory {
	
	public InventoryItem createInventoryItem(Item item) {
		if(item.getName().equals("Sulfuras, Hand of Ragnaros")) {
			return new LegendarySulfurasItem();
		} else if(item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
			return new BackstagePassesItem();
		} else if(item.getName().equals("Aged Brie")) {
			return new AgedBrieItem();
		} else if(item.getName().equals("Conjured Item")) {
			return new ConjuredItem();
		} else {
			return new StandardItem();
		}
	}
}