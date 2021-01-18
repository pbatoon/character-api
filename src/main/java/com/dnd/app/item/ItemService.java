package com.dnd.app.item;

import com.dnd.app.character.Character;
import com.dnd.app.character.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) { this.itemRepository = itemRepository; }

    public List<Item> getItems() { return itemRepository.findAll(); }

    public Item getItemById(Long itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalStateException(
                        "Item with ID " + itemId + " does not exist!"
                ));

        return item;
    }

    public void addItem(Item item) { itemRepository.save(item); }

    public void deleteItem(Long itemId) {
        boolean exists = itemRepository.existsById(itemId);

        if(!exists) {
            throw new IllegalStateException("Item with ID " + itemId + " does not exist!");
        }

        itemRepository.deleteById(itemId);
    }

    @Transactional
    public void updateItemOwner(Long itemId, Long characterId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalStateException(
                        "Item with ID " + itemId + " does not exist!"
                ));

        if(characterId != null && !Objects.equals(item.getOwner_id(), characterId)) {
            item.setOwner_id(characterId);
        }
    }

}
