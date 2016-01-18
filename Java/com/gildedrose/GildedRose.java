package com.gildedrose;

import java.util.List;

import com.gildedrose.shared.Item;

class GildedRose {
    List<ItemWithType> items = null;
    private static final int MAX_QUALITY = 50;

    public GildedRose(List<ItemWithType> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
        	
            changeQuality(item);
            decreaseSellInDays(item);        
        }
    }

	private void changeQuality(Item item) {
		if (!item.name.equals("Aged Brie")
		        && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
		    if (item.quality > 0) {
		        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
		        	item.quality = item.quality - 1;
		        }
		    }
		} else {
		    if (item.quality < MAX_QUALITY) {
		    	item.quality = item.quality + 1;

		        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
		            if (item.sellIn < 11) {
		                if (item.quality < MAX_QUALITY) {
		                	item.quality = item.quality + 1;
		                }
		            }

		            if (item.sellIn < 6) {
		                if (item.quality < MAX_QUALITY) {
		                	item.quality = item.quality + 1;
		                }
		            }
		        }
		    }
		}
		
		if (item.sellIn < 0) {
            if (!item.name.equals("Aged Brie")) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        	item.quality = item.quality - 1;
                        }
                    }
                } else {
                	item.quality = item.quality - item.quality;
                }
            } else {
                if (item.quality < MAX_QUALITY) {
                	item.quality = item.quality + 1;
                }
            }
        }
	}
	
	private void decreaseSellInDays(Item item) {
		if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
			item.sellIn = item.sellIn - 1;
		}
	}
}
