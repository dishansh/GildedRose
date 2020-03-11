package com.inn.factory;

import com.inn.constants.ItemConstants;
import com.inn.iface.InventoryItem;
import com.inn.model.AgedBrieItem;
import com.inn.model.BackstagePassesItem;
import com.inn.model.ConjuredItem;
import com.inn.model.Item;
import com.inn.model.LegendarySulfurasItem;
import com.inn.model.StandardItem;

public class ItemFactory {
	
	public InventoryItem createInventoryItem(Item item) {
		if(ItemConstants.SULFURAS_ITEM.equals(item.getName())) {
			return new LegendarySulfurasItem();
		} else if(ItemConstants.BACKSTAGE_PASS_ITEM.equals(item.getName())) {
			return new BackstagePassesItem();
		} else if(ItemConstants.AGED_BRIE_ITEM.equals(item.getName())) {
			return new AgedBrieItem();
		} else if(ItemConstants.CONJURED_ITEM.equals(item.getName())) {
			return new ConjuredItem();
		} else {
			return new StandardItem();
		}
	}
}