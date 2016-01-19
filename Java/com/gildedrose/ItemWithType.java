package com.gildedrose;

import com.gildedrose.shared.Item;

public class ItemWithType extends Item {

	public ItemWithType(String name, ItemType type, int sellIn, int quality) {
		super(name, sellIn, quality);
		
		itemType = type;
		
		if (super.quality > 50 && !itemType.equals(ItemType.LEGENDARY)) {
			super.quality = 50;
		}
	}

	public ItemType itemType;

	@Override
	public String toString() {
		return this.name + ", " + this.itemType + ", " + this.sellIn + ", "
				+ this.quality;
	}

}
