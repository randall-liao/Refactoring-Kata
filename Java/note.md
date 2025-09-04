### Requirements for `Quality`

- Quality degrade twice as fast after sell by date
- Quality increase for **Aged Brie**
- Quality <= 50
- Quality -= 1 for every epoch
-

### Requirements for `Items`

- `items` have a `SellIn` = number of days we have to sell the `items`
- `items` have a `Quality` = quality of the item
- Item enum **"Aged Brie"**, Quality increase for **Aged Brie**
- Item enum **"Sulfuras"**, never has to be sold and Quality will not decrease. This item has a `Quality` of 80 and never alters.
- Item enum **"Backstage passes"**,
  - Quality += 2 (if 5 < `SellIn` - currentDate <= 10)
  - Quality += 3 (if 0 <= `SellIn` - currentDate <= 5)
  - Quality = 0 (if `SellIn` - currentDate < 0)
- Item enum **"Conjured"** Quality degrade twice as fast.

## Requirements on code structure

- `UpdateQuality` method are free to update
- Add new code as needed
- Do not alter `Item` class


