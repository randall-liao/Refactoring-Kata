package com.gildedrose.handlers;

import com.gildedrose.Item;

public class QualityHandler implements ItemHandler {


    @Override
    public Item handle(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        switch (item.name) {
            case("Aged Brie"):
                System.out.println("");
                break;
            default:
                throw new IllegalArgumentException(String.format("Unexpected Item:%s", item));
        }
        return item;
    }

}
