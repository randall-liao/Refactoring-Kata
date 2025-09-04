package com.gildedrose.item.handlers;

import com.gildedrose.Item;

public class SellInDateHandler implements ItemHandler{

    @Override
    public Item handle(Item item) {
        item.sellIn = item.sellIn - 1;
        return item;
    }

}
