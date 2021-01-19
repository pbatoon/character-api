package com.dnd.app.spell;

import com.dnd.app.character.*;
import com.dnd.app.character.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class SpellService {
    private final SpellRepository spellRepository;

    @Autowired
    public SpellService(SpellRepository spellRepository) {this.spellRepository = spellRepository; }

    public List<Spell> getSpells() { return spellRepository.findAll(); }

    public void addSpell(Spell spell) { spellRepository.save(spell); }

    public void deleteSpell(Long spellId) {
        boolean exists = spellRepository.existsById(spellId);

        if(!exists) {
            throw new IllegalStateException("Spell with ID " + spellId + " does not exist!");
        }

        spellRepository.deleteById(spellId);
    }

    @Transactional
    public void updateSpellCaster(Long spellId, Long characterId) {
        Spell spell = spellRepository.findById(spellId)
                .orElseThrow(() -> new IllegalStateException(
                        "Spell with ID " + spellId + " does not exist!"
                ));

        if(characterId != null && !Objects.equals(spell.getCasterId(), characterId)) spell.setCasterId(characterId);
    }

}
