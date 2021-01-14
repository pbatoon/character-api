package com.dnd.app.item;

import com.dnd.app.character.Character;
import com.dnd.app.character.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) { this.itemRepository = itemRepository; }

    public List<Item> getItems() { return itemRepository.findAll(); }

}
