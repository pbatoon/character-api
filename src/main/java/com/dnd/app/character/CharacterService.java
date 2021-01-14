package com.dnd.app.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository) { this.characterRepository = characterRepository; }

    public List<Character> getCharacters() { return characterRepository.findAll(); }

    public Character getCharacterById(Long characterId) {
        Character character = characterRepository.findById(characterId)
                .orElseThrow(() -> new IllegalStateException(
                        "Character with ID " + characterId + " does not exist!"
                ));

        return character;

    }

    public void addNewCharacter(Character character) {
        characterRepository.save(character);
    }

    public void deleteCharacter(Long characterId) {
        boolean exists = characterRepository.existsById(characterId);

        if(!exists) {
            throw new IllegalStateException("Character with ID " + characterId + " does not exist!");
        }

        characterRepository.deleteById(characterId);
    }

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
