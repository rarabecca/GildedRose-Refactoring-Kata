package com.gildedrose.test;

import java.util.ArrayList;
import java.util.List;

import com.gildedrose.GildedRose;
import com.gildedrose.ItemType;
import com.gildedrose.ItemWithType;
import com.gildedrose.shared.Item;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        List<ItemWithType> items = new ArrayList<ItemWithType>();
        
                items.add(new ItemWithType("+5 Dexterity Vest", ItemType.GENERAL,10, 20)); //
                items.add(new ItemWithType("Aged Brie", ItemType.AGEDBRIE, 2, 0)); //
                items.add(new ItemWithType("Elixir of the Mongoose", ItemType.GENERAL, 5, 7));//
                items.add(new ItemWithType("Sulfuras, Hand of Ragnaros", ItemType.LEGENDARYITEM, 0, 80)); //
                items.add(new ItemWithType("Sulfuras, Hand of Ragnaros", ItemType.LEGENDARYITEM, -1, 80));
                items.add(new ItemWithType("Backstage passes to a TAFKAL80ETC concert", ItemType.BACKSTAGE_PASSES, 15, 20));
                items.add(new ItemWithType("Backstage passes to a TAFKAL80ETC concert", ItemType.BACKSTAGE_PASSES, 10, 49));
                items.add(new ItemWithType("Backstage passes to a TAFKAL80ETC concert", ItemType.BACKSTAGE_PASSES, 5, 49));
                // this conjured item does not work properly yet
                items.add(new ItemWithType("Conjured Mana Cake", ItemType.CONJURED, 3, 6));

        GildedRose app = new GildedRose(items);

        int days = 4;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
