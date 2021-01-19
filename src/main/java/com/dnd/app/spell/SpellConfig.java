package com.dnd.app.spell;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.List;

@Configuration
public class SpellConfig {

    @Bean
    CommandLineRunner spellCommandLineRunner(SpellRepository repository) {

        return args -> {
            Spell fireball = new Spell(
                    3,
                    "Fireball",
                    "1 action",
                    "Instantaneous",
                    150,
                    null,
                    "DEX",
                    "Fire",
                    true,
                    true,
                    true,
                    "Evocation",
                    "A bright streak flashes from your pointing finger to a point you choose within range and then blossoms with a low roar into an explosion of flame. Each creature in a 20-foot-radius sphere centered on that point must make a Dexterity saving throw. A target takes 8d6 fire damage on a failed save, or half as much damage on a successful one.",
                    2L
            );

            Spell eldritch = new Spell(
                    0,
                    "Eldritch Blast",
                    "1 action",
                    "Instantaneous",
                    120,
                    "Ranged",
                    null,
                    "Force",
                    true,
                    true,
                    false,
                    "Invocation",
                    "A beam of crackling energy streaks toward a creature within range. Make a ranged spell attack against the target. On a hit, the target takes 1d10 force damage.",
                    3L
            );

            Spell aid = new Spell(
                    2,
                    "Aid",
                    "1 action",
                    "8 Hours",
                    30,
                    null,
                    null,
                    "Buff",
                    true,
                    true,
                    true,
                    "Abjuration",
                    "Your spell bolsters your allies with toughness and resolve. Choose up to three creatures within range. Each target's hit point maximum and current hit points increase by 5 for the duration.",
                    1L
            );

            repository.saveAll(
                    List.of(fireball, eldritch, aid)
            );
        };
    }
}
