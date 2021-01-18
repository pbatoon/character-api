package com.dnd.app.item;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ItemConfig {

    @Bean
    CommandLineRunner itemCommandLineRunner(ItemRepository repository) {

        return args -> {
            Item sword = new Item(
                    "longsword",
                    50,
                    6,
                    "Slashing"
            );

            Item bagpipes = new Item(
                    "bagpipes",
                    30,
                    6,
                    "Slashing"
            );

            Item battleaxe = new Item(
                    "battleaxe",
                    10,
                    4,
                    "Slashing"
            );

            repository.saveAll(
                    List.of(sword, bagpipes, battleaxe)
            );
        };
    }
}
