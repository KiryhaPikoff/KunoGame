package components;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import item.Item;
import utils.Drawable;
import utils.ImageLoader;

public class Inventory implements Drawable {
	private List<Item> arrayList = new ArrayList<Item>();
	private Image image;
	
	public Inventory() {
		this.image = ImageLoader.loadImage("resources/images/inventory.png");
	}
	
	public List<Item> getArrayList() {
		return arrayList;
	}

	public void paint(Graphics g) {
	//	g.drawImage(this.image, 650, 330, null);
	}

}

