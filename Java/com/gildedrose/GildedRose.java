package com.gildedrose;

import java.util.List;

import com.gildedrose.shared.Item;

public class GildedRose {
    public List<ItemWithType> items = null;
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    public GildedRose(List<ItemWithType> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (ItemWithType item : items) {
        	
            changeQuality(item);
            decreaseSellInDays(item);        
        }
    }

	private void changeQuality(Item item) {
		if (!item.name.equals("Aged Brie")
		        && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
		    if (item.quality > MIN_QUALITY) {
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
                    if (item.quality > MIN_QUALITY) {
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
	
	private void decreaseSellInDays(ItemWithType item) {
		if (!item.itemType.equals(ItemType.LEGENDARYITEM)) {
			item.sellIn = item.sellIn - 1;
		}
	}
}
