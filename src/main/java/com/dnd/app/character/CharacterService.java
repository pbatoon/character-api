package com.dnd.app.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

/**
 * Character Service
 */
@Service
public class CharacterService {
    private final CharacterRepository characterRepository;

    /**
     * Autowire service to repository
     * @param characterRepository - CharacterRepository declared above
     */
    @Autowired
    public CharacterService(CharacterRepository characterRepository) { this.characterRepository = characterRepository; }

    /**
     * <h2>GET /api/v1/characters/</h2>
     * @return - All characters
     */
    public List<Character> getCharacters() { return characterRepository.findAll(); }

    /**
     * <h2>GET /api/v1/characters/{id}</h2>
     * @param characterId - Character ID of the character to be updated (Long)
     * @return - Character object with specified ID
     */
    public Character getCharacterById(Long characterId) {
        Character character = characterRepository.findById(characterId)
                .orElseThrow(() -> new IllegalStateException(
                        "Character with ID " + characterId + " does not exist!"
                ));

        return character;

    }

    /**
     * <h2>POST /api/v1/characters/{id}</h2>
     * Adding a new character.
     * @param character - Character object from the request body
     */
    public void addNewCharacter(Character character) {
        characterRepository.save(character);
    }

    /**
     *<h2>DELETE /api/v1/characters/{id}</h2>
     * @param characterId - Character ID of the character to be deleted (Long)
     */
    public void deleteCharacter(Long characterId) {
        boolean exists = characterRepository.existsById(characterId);

        if(!exists) {
            throw new IllegalStateException("Character with ID " + characterId + " does not exist!");
        }

        characterRepository.deleteById(characterId);
    }

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
    @Transactional
    public void updateStats(Long characterId, Integer strength, Integer constitution,
                            Integer dexterity, Integer wisdom,
                            Integer intelligence, Integer charisma) {

        Character character = characterRepository.findById(characterId)
                .orElseThrow(() -> new IllegalStateException(
                        "Character with ID " + characterId + " does not exist!"
                ));

        if(strength != null && !Objects.equals(character.getStrength(), strength)) {
            character.setStrength(strength);
        }

        if(constitution != null && !Objects.equals(character.getConstitution(), constitution)) {
            character.setConstitution(constitution);
        }

        if(dexterity != null && !Objects.equals(character.getDexterity(), dexterity)) {
            character.setDexterity(dexterity);
        }

        if(wisdom != null && !Objects.equals(character.getWisdom(), wisdom)) {
            character.setWisdom(wisdom);
        }

        if(intelligence != null && !Objects.equals(character.getIntelligence(), intelligence)) {
            character.setIntelligence(intelligence);
        }

        if(charisma != null && !Objects.equals(character.getCharisma(), charisma)) {
            character.setCharisma(charisma);
        }

    }

}
