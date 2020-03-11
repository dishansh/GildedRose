import java.util.List;

import com.inn.factory.ItemFactory;
import com.inn.model.Item;

public class GildedRose {

	private List<Item> items = null;

	public GildedRose(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}

	public void update() {
		for (Item item : items) {
			new ItemFactory().createInventoryItem(item).updateItem(item);
		}
	}
}