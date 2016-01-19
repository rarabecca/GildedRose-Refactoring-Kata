package com.gildedrose;

import java.util.List;

public class GildedRose {
	private static final int BACKSTAGE_PASS_SECOND_QUALITY_JUMP = 5;
	private static final int BACKSTAGE_PASS_FIRST_QUALITY_JUMP = 10;
	private static final int MAX_QUALITY = 50;
	private static final int MIN_QUALITY = 0;
	private static final int MIN_SELL_IN = 0;

	public List<ItemWithType> items = null;

	public GildedRose(List<ItemWithType> items) {
		this.items = items;
	}

	public void updateQuality() {
		for (ItemWithType item : items) {

			changeQuality(item);
			decreaseSellInDays(item);
		}
	}

	private void changeQuality(ItemWithType item) {

		switch (item.itemType) {

		case GENERAL:
			changeQualityForGeneralItem(item);
			break;
		case AGEDBRIE:
			changeQualityForAgedBrie(item);
			break;
		case BACKSTAGE_PASSES:
			changeQualityForBackstagePasses(item);
			break;
		case CONJURED:
			changeQualityForConjuredItem(item);
			break;
		case LEGENDARY:
			changeQualityForLegendaryItem(item);
			break;
		default:
			changeQualityForGeneralItem(item);
		}
	}

	private void changeQualityForGeneralItem(ItemWithType item) {
		
		if (item.sellIn >= MIN_SELL_IN) {
			item.quality = item.quality - 1;
		} else if (item.sellIn < MIN_SELL_IN) {
			item.quality = item.quality - 2;
		}

		if (item.quality < MIN_QUALITY) {
			item.quality = MIN_QUALITY;
		}
	}

	private void changeQualityForAgedBrie(ItemWithType item) {
		
		if (item.quality < MAX_QUALITY) {
			item.quality = item.quality + 1;
		}
	}

	private void changeQualityForBackstagePasses(ItemWithType item) {
		if (item.sellIn > MIN_SELL_IN) {
			
			if (item.sellIn <= BACKSTAGE_PASS_FIRST_QUALITY_JUMP) {
				item.quality = item.quality + 2;
			}
			if (item.sellIn <= BACKSTAGE_PASS_SECOND_QUALITY_JUMP) {
				item.quality = item.quality + 3;
			} else {
				item.quality = item.quality + 1;
			}
			
			if (item.quality > MAX_QUALITY) {
				item.quality = MAX_QUALITY;
			}
			
		} else {
			item.quality = MIN_QUALITY;
		}
	}

	private void changeQualityForLegendaryItem(ItemWithType item) {
		item.quality = 80;
	}

	private void changeQualityForConjuredItem(ItemWithType item) {
		item.quality = item.quality - 2;

		if (item.quality < MIN_QUALITY) {
			item.quality = MIN_QUALITY;
		}
	}

	private void decreaseSellInDays(ItemWithType item) {
		if (!item.itemType.equals(ItemType.LEGENDARY)) {
			item.sellIn = item.sellIn - 1;
		}
	}
}
