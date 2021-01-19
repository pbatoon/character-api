package com.dnd.app.spell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/spells")
public class SpellController {
    private final SpellService spellService;

    @Autowired
    public SpellController(SpellService spellService) { this.spellService = spellService; }

    @GetMapping
    public List<Spell> getSpells() { return spellService.getSpells(); }

    @PostMapping
    public void addSpell(@RequestBody Spell spell) {
        spellService.addSpell(spell);
    }

    @DeleteMapping(path = "{spellId}")
    public void deleteSpell(@PathVariable("spellId") Long spellId) { spellService.deleteSpell(spellId); }

    @PutMapping(path = "{spellId}")
    public void updateSpellCaster(@PathVariable("spellId") Long spellId,
                                @RequestParam(required = true) Integer characterId) {
        Long charIdLong = characterId.longValue();
        spellService.updateSpellCaster(spellId, charIdLong);
    }

}
