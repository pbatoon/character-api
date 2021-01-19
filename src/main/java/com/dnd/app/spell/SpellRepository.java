package com.dnd.app.spell;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spell Repositorys
 */
@Repository
public interface SpellRepository extends JpaRepository<Spell, Long> {

}
