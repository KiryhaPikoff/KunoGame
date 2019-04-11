package entity.components;

import java.util.ArrayList;
import java.util.List;

import item.Item;

public class Inventory {
	protected List<Item> arrayList = new ArrayList<Item>();
	
	public Inventory() {
		
	}
	
	public List<Item> getArrayList() {
		return arrayList;
	}

}

