package com.dnd.app.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/items")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) { this.itemService = itemService; }

    @GetMapping
    public List<Item> getItems() { return itemService.getItems(); }

    @GetMapping(path = "{itemId}")
    public Item getItemById(@PathVariable("itemId") Long itemId) { return itemService.getItemById(itemId); }

    @PostMapping
    public void addItem(@RequestBody Item item) { itemService.addItem(item);}

    @DeleteMapping(path = "{itemId}")
    public void deleteItem(@PathVariable("itemId") Long itemId) { itemService.deleteItem(itemId); }

    @PutMapping(path = "{itemId}")
    public void updateItemOwner(@PathVariable("itemId") Long itemId,
                            @RequestParam(required = true) Integer ownerId) {
        Long charIdLong = ownerId.longValue();
        itemService.updateItemOwner(itemId, charIdLong);
    }


}
