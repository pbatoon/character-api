package com.dnd.app.character;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
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
                    20
            );

            Character reani = new Character(
                    "Reani",
                    "Scourge Aasimar",
                    "Druid",
                    10,
                    12,
                    16,
                    18,
                    14,
                    15
            );

            Character athard = new Character(
                    "Athard Pyrethorn",
                    "Half-Elf",
                    "Barbarian Druid",
                    17,
                    14,
                    15,
                    18,
                    9,
                    12
            );


            repository.saveAll(
                    List.of(frumpkin, reani, athard)
            );
        };
    }

}
