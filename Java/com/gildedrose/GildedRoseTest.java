package com.gildedrose;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.gildedrose.shared.Item;

public class GildedRoseTest {

    @Test
    public void testFoo() {
    	List<Item> items = new ArrayList<Item>();
        Item item = new Item("foo", 0, 0);
        items.add(item);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items.get(0).name);
    }
    
    @Test
    public void TestQualityImprovementOnceForBrie() {
    	List<Item> items = new ArrayList<Item>();
        Item item = new Item("Aged Brie", 0, 0);
        items.add(item);
    	GildedRose app = new GildedRose(items);
    	app.updateQuality();
    	assertEquals(app.items.get(0).quality, 2);
    }
    
    @Test
    public void TestQualityImprovementForBrieMultiple() {
    	List<Item> items = new ArrayList<Item>();
        Item item = new Item("Aged Brie", 0, 0);
        items.add(item);
        GildedRose app = new GildedRose(items);
    	int i = 0;
    	while (app.items.get(0).quality != 50) {		
    		app.updateQuality();
    		i= i+2;
    		System.out.println(app.items.get(0).quality);
        	assertEquals(app.items.get(0).quality, i);
    	}
    	assertEquals(app.items.get(0).quality, 50); 	
    }
    
    

}
