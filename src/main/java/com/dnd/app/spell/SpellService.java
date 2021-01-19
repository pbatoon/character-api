package com.dnd.app.spell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

/**
 * Service for API operations. Called by SpellController.
 */
@Service
public class SpellService {
    private final SpellRepository spellRepository;

    @Autowired
    public SpellService(SpellRepository spellRepository) {this.spellRepository = spellRepository; }

    /**
     * GET /api/v1/spells
     * @return All Spell objects in the spell repository
     */
    public List<Spell> getSpells() { return spellRepository.findAll(); }

    /**
     * POST /api/v1/spells
     * @param spell - A Spell object
     */
    public void addSpell(Spell spell) { spellRepository.save(spell); }

    /**
     * DELETE /api/v1/spells/{id}
     * @param spellId - A Long indicating the desired spell's ID.
     */
    public void deleteSpell(Long spellId) {
        boolean exists = spellRepository.existsById(spellId);

        if(!exists) {
            throw new IllegalStateException("Spell with ID " + spellId + " does not exist!");
        }

        spellRepository.deleteById(spellId);
    }

    /**
     * PUT /api/v1/{id}?characterId={charId}
     * @param spellId - unique spell ID as a Long
     * @param characterId - unique character ID
     */
    @Transactional
    public void updateSpellCaster(Long spellId, Long characterId) {
        Spell spell = spellRepository.findById(spellId)
                .orElseThrow(() -> new IllegalStateException(
                        "Spell with ID " + spellId + " does not exist!"
                ));

        if(characterId != null && !Objects.equals(spell.getCasterId(), characterId)) spell.setCasterId(characterId);
    }

}
