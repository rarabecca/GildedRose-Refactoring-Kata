package com.gildedrose.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.gildedrose.GildedRose;
import com.gildedrose.ItemType;
import com.gildedrose.ItemWithType;

public class GildedRoseTest {

	@Test
	public void testFoo() {
		List<ItemWithType> items = new ArrayList<ItemWithType>();
		ItemWithType item = new ItemWithType("foo", ItemType.GENERAL, 0, 0);
		items.add(item);
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("foo", app.items.get(0).name);
	}

	@Test
	public void TestGeneralItemQualityChange() {
		List<ItemWithType> items = new ArrayList<ItemWithType>();
		ItemWithType item = new ItemWithType("general test Item",
				ItemType.GENERAL, 4, 10);
		items.add(item);
		GildedRose app = new GildedRose(items);
		int i = 10;
		while (app.items.get(0).sellIn >= 0) {
			app.updateQuality();
			i = i - 1;
			assertEquals(app.items.get(0).quality, i);
		}
		assertEquals(app.items.get(0).quality, 5);
		app.updateQuality();
		assertEquals(app.items.get(0).quality, 3);
		app.updateQuality();
		app.updateQuality();
		assertEquals(app.items.get(0).quality, 0);
	}

	@Test
	public void TestQualityImprovementOnceForBrie() {
		List<ItemWithType> items = new ArrayList<ItemWithType>();
		ItemWithType item = new ItemWithType("Aged Brie", ItemType.AGEDBRIE, 0,
				0);
		items.add(item);
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(app.items.get(0).quality, 1);
	}

	@Test
	public void TestQualityImprovementForBrieMultiple() {
		List<ItemWithType> items = new ArrayList<ItemWithType>();
		ItemWithType item = new ItemWithType("Aged Brie", ItemType.AGEDBRIE, 0,
				0);
		items.add(item);
		GildedRose app = new GildedRose(items);
		int i = 0;
		while (app.items.get(0).quality != 50) {
			app.updateQuality();
			i = i + 1;
			assertEquals(app.items.get(0).quality, i);
		}
		assertEquals(app.items.get(0).quality, 50);
	}

	@Test
	public void TestBackstagePassQualityChangeMoreThan10Days() {
		List<ItemWithType> items = new ArrayList<ItemWithType>();
		ItemWithType item = new ItemWithType("Backstage pass test", ItemType.BACKSTAGE_PASSES, 12,
				3);
		items.add(item);
		GildedRose app = new GildedRose(items);
		int i = 3;
		while (app.items.get(0).sellIn > 10) {
			app.updateQuality();
			i = i + 1;			
			assertEquals(app.items.get(0).quality, i);
		}
	}
	
	@Test
	public void TestBackstagePassQualityChangeLessThan10Days() {
		List<ItemWithType> items = new ArrayList<ItemWithType>();
		ItemWithType item = new ItemWithType("Backstage pass test", ItemType.BACKSTAGE_PASSES, 10,
				3);
		items.add(item);
		GildedRose app = new GildedRose(items);
		int i = 3;
		while (app.items.get(0).sellIn > 5) {
			app.updateQuality();
			i = i + 2;			
			assertEquals(app.items.get(0).quality, i);
		}
	}
	
	@Test
	public void TestBackstagePassQualityChangeLessThan5Days() {
		List<ItemWithType> items = new ArrayList<ItemWithType>();
		ItemWithType item = new ItemWithType("Backstage pass test", ItemType.BACKSTAGE_PASSES, 5,
				3);
		items.add(item);
		GildedRose app = new GildedRose(items);
		int i = 3;
		while (app.items.get(0).sellIn > 0) {
			app.updateQuality();
			i = i + 3;			
			assertEquals(app.items.get(0).quality, i);
		}
		app.updateQuality();
		assertEquals(app.items.get(0).quality, 0);
	}
	
	@Test
	public void TestLegendaryItemQualityChange() {
		List<ItemWithType> items = new ArrayList<ItemWithType>();
		ItemWithType item = new ItemWithType("Legendary Item test", ItemType.LEGENDARY, 12,
				3);
		items.add(item);
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals(app.items.get(0).quality, 80);
	}

	@Test
	public void TestConjuredItemQualityChange() {
		List<ItemWithType> items = new ArrayList<ItemWithType>();
		ItemWithType item = new ItemWithType("conjured test Item",
				ItemType.CONJURED, 4, 20);
		items.add(item);
		GildedRose app = new GildedRose(items);
		int i = 20;
		while (app.items.get(0).sellIn > 0) {
			app.updateQuality();
			i = i - 2;
			System.out.println(app.items.get(0).quality);
			assertEquals(app.items.get(0).quality, i);
		}
		assertEquals(app.items.get(0).quality, 12);
		app.updateQuality();
		assertEquals(app.items.get(0).quality, 8);
		app.updateQuality();
		app.updateQuality();
		assertEquals(app.items.get(0).quality, 0);
	}

}
