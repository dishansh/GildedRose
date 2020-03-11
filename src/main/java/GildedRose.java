import java.util.List;

import com.inn.exceptions.InvalidItemException;
import com.inn.factory.ItemFactory;
import com.inn.model.Item;

public class GildedRose {

	private List<Item> items;

	public GildedRose(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}

	public void update() throws InvalidItemException {
		for (Item item : items) {
			if(item.getName()==null || item.getName().equalsIgnoreCase("")) {
				throw new InvalidItemException("Invalid Item Name");
			}
			new ItemFactory().createInventoryItem(item).updateItem(item);
		}
	}
}