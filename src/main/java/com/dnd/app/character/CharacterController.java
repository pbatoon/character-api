package com.dnd.app.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Character controller
 */
@RestController
@RequestMapping(path = "api/v1/characters")
public class CharacterController {
    private final CharacterService characterService;

    /**
     * Autowire character service to this controller
     * @param characterService - CharacterService object (declared above)
     */
    @Autowired
    public CharacterController(CharacterService characterService) { this.characterService = characterService; }


    /**
     * <h2>GET /api/v1/characters</h2>
     * @return - All characters in table
     */
    @GetMapping
    public List<Character> getCharacters() { return characterService.getCharacters(); }

    /**
     * <h2>GET /api/v1/characters/{id}</h2>
     * @param characterId - character ID of the character you wish to look up (Long)
     * @return Character object with provided ID
     */
    @GetMapping(path = "{characterId}")
    public Character getCharacterById(@PathVariable("characterId") Long characterId) { return characterService.getCharacterById(characterId); }

    /**
     * <h2>POST /api/v1/characters/{id}</h2>
     * Adding a new character.
     * @param character - Character object from the request body
     */
    @PostMapping
    public void addNewCharacter(@RequestBody Character character) { characterService.addNewCharacter(character); }

    /**
     *<h2>DELETE /api/v1/characters/{id}</h2>
     * @param characterId - Character ID of the character to be deleted (Long)
     */
    @DeleteMapping(path = "{characterId}")
    public void deleteCharacter(@PathVariable("characterId") Long characterId) { characterService.deleteCharacter(characterId); }

    /**
     * <h2>PUT /api/v1/characters/{id}?{param}={param_value}</h2>
     * @param characterId - Character ID of the character to be updated
     * @param strength - new stat to update the existing stat to (Integer) (not required)
     * @param constitution - new stat to update the existing stat to (Integer) (not required)
     * @param dexterity - new stat to update the existing stat to (Integer) (not required)
     * @param wisdom - new stat to update the existing stat to (Integer) (not required)
     * @param intelligence - new stat to update the existing stat to (Integer) (not required)
     * @param charisma - new stat to update the existing stat to (Integer) (not required)
     */
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
