package com.dnd.app.character;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Character Repository
 */
@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

}
