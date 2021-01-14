package com.dnd.app.character;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CharacterConfig {

    @Bean
    CommandLineRunner commandLineRunner(CharacterRepository repository) {

        return args -> {
            Character frumpkin = new Character(
                    "Frumpkin",
                    "Cat",
                    "God",
                    20,
                    20,
                    20,
                    20,
                    20,
                    20,
                    20,
                    40,
                    5000
            );

            Character reani = new Character(
                    "Reani",
                    "Scourge Aasimar",
                    "Druid",
                    9,
                    10,
                    12,
                    16,
                    18,
                    14,
                    15,
                    30,
                    48

            );

            Character athard = new Character(
                    "Athard Pyrethorn",
                    "Half-Elf",
                    "Barbarian Druid",
                    2,
                    17,
                    14,
                    15,
                    18,
                    9,
                    12,
                    30,
                    21
            );

            repository.saveAll(
                    List.of(frumpkin, reani, athard)
            );
        };
    }

}
