package com.dnd.app.item;

import com.dnd.app.character.Character;
import com.dnd.app.character.CharacterService;
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

    @PostMapping
    public void addItem(@RequestBody Item item) { itemService.addItem(item);}
}
