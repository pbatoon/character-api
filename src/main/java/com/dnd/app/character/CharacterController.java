package com.dnd.app.character;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/character")
public class CharacterController {
    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) { this.characterService = characterService; }

    @GetMapping
    public List<Character> getCharacters() { return characterService.getCharacters(); }

    @GetMapping(path = "{characterId}")
    public Character getCharacterById(@PathVariable("characterId") Long characterId) { return characterService.getCharacterById(characterId); }

    @PostMapping
    public void addNewCharacter(@RequestBody Character character) { characterService.addNewCharacter(character); }

    @DeleteMapping(path = "{characterId}")
    public void deleteCharacter(@PathVariable("characterId") Long characterId) { characterService.deleteCharacter(characterId); }

    @PutMapping(path = "{characterId}")
    public void updateStats(@PathVariable("characterId") Long characterId,
                                @RequestParam(required = false) Integer strength,
                                @RequestParam(required = false) Integer constitution,
                                @RequestParam(required = false) Integer dexterity,
                                @RequestParam(required = false) Integer wisdom,
                                @RequestParam(required = false) Integer intelligence,
                                @RequestParam(required = false) Integer charisma) {
        characterService.updateStats(characterId, strength, constitution, dexterity, wisdom, intelligence, charisma);
    }

}
