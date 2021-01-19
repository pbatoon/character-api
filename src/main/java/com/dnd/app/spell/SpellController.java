package com.dnd.app.spell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest controller for spell
 * Path - /api/v1/spells
 */
@RestController
@RequestMapping(path = "api/v1/spells")
public class SpellController {

    private final SpellService spellService;

    //Autowiring Spell service to controller
    @Autowired
    public SpellController(SpellService spellService) { this.spellService = spellService; }

    /**
     * Get all spells in table
     * @return - all spells in table
     */
    @GetMapping
    public List<Spell> getSpells() { return spellService.getSpells(); }

    /**
     * Add a new spell
     * @param spell - A Spell object to be added to the table
     */
    @PostMapping
    public void addSpell(@RequestBody Spell spell) {
        spellService.addSpell(spell);
    }

    /**
     * Delete a spell by ID
     * DELETE /api/v1/spells/{id}
     * @param spellId - Long id of the spell to be deleted
     */
    @DeleteMapping(path = "{spellId}")
    public void deleteSpell(@PathVariable("spellId") Long spellId) { spellService.deleteSpell(spellId); }


    /**
     * Update a spell's casterId
     * PUT /api/v1/spells/{id}?characterId={charId}
     * @param spellId - ID of the spell to be edited
     * @param characterId - ID of the character to be assigned as spellcaster
     */
    @PutMapping(path = "{spellId}")
    public void updateSpellCaster(@PathVariable("spellId") Long spellId,
                                @RequestParam(required = true) Integer characterId) {
        Long charIdLong = characterId.longValue();
        spellService.updateSpellCaster(spellId, charIdLong);
    }

}
