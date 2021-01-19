package com.dnd.app.spell;

import javax.persistence.*;

/**
 * Spell Schema
 */
@Entity
@Table
public class Spell {

    /**
     * ID generator
     */
    @Id
    @SequenceGenerator(
            name = "spell_sequence",
            sequenceName = "spell_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "spell_sequence"
    )
    private Long id;
    private Integer level;
    private String name;
    private String castingTime;
    private String duration;
    private Integer range;
    private String attackType;
    private String save;
    private String damageEffect;
    private Boolean isVerbal;
    private Boolean isSomatic;
    private Boolean isMaterial;
    private String school;
    private String description;
    private Long casterId;

    public Spell() {
    }

    /**
     * Constructor with ID
     * @param id - unique identifier (Long)
     * @param level - character level (int)
     * @param name - character name (string)
     * @param castingTime - time to cast spell (String)
     * @param duration - spell duration (String)
     * @param range - spell range in ft (int)
     * @param attackType - what kind of attack it is (ie. Ranged) (String)
     * @param save - what saving throw it requires for targets of spell (String)
     * @param damageEffect - what type of damage it inflicts (String)
     * @param isVerbal - indicates if spell is verbally invoked (bool)
     * @param isSomatic - indicates if spell is somatically invoked (bool)
     * @param isMaterial - indicates if spell is material invoked (bool)
     * @param school - what magic school the spell comes from (String)
     * @param description - description of the spell. 700 char limit. (String)
     * @param casterId - character ID of the spellcaster (Long)
     */
    public Spell(Long id, Integer level, String name, String castingTime, String duration,
                 Integer range, String attackType, String save, String damageEffect, Boolean isVerbal, Boolean isSomatic,
                 Boolean isMaterial, String school, String description, Long casterId) {
        this.id = id;
        this.level = level;
        this.name = name;
        this.castingTime = castingTime;
        this.duration = duration;
        this.range = range;
        this.attackType = attackType;
        this.save = save;
        this.damageEffect = damageEffect;
        this.isVerbal = isVerbal;
        this.isSomatic = isSomatic;
        this.isMaterial = isMaterial;
        this.school = school;
        this.description = description;
        this.casterId = casterId;
    }

    public Spell(Integer level, String name, String castingTime,
                 String duration, Integer range, String attackType, String save, String damageEffect,
                 Boolean isVerbal, Boolean isSomatic, Boolean isMaterial,
                 String school, String description, Long casterId) {
        this.level = level;
        this.name = name;
        this.castingTime = castingTime;
        this.duration = duration;
        this.range = range;
        this.attackType = attackType;
        this.save = save;
        this.damageEffect = damageEffect;
        this.isVerbal = isVerbal;
        this.isSomatic = isSomatic;
        this.isMaterial = isMaterial;
        this.school = school;
        this.description = description;
        this.casterId = casterId;
    }

    public Spell(Integer level, String name, String castingTime, String duration, Integer range, String attackType, String save, String damageEffect,
                 Boolean isVerbal, Boolean isSomatic, Boolean isMaterial, String school, String description) {
        this.level = level;
        this.name = name;
        this.castingTime = castingTime;
        this.duration = duration;
        this.range = range;
        this.attackType = attackType;
        this.save = save;
        this.damageEffect = damageEffect;
        this.isVerbal = isVerbal;
        this.isSomatic = isSomatic;
        this.isMaterial = isMaterial;
        this.school = school;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCastingTime() {
        return castingTime;
    }

    public void setCastingTime(String castingTime) {
        this.castingTime = castingTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public String getAttackType() {
        return attackType;
    }

    public void setAttackType(String attackType) {
        this.attackType = attackType;
    }

    public String getSave() {
        return save;
    }

    public void setSave(String save) {
        this.save = save;
    }

    public String getDamageEffect() {
        return damageEffect;
    }

    public void setDamageEffect(String damageEffect) {
        this.damageEffect = damageEffect;
    }

    public Boolean getVerbal() {
        return isVerbal;
    }

    public void setVerbal(Boolean verbal) {
        isVerbal = verbal;
    }

    public Boolean getSomatic() {
        return isSomatic;
    }

    public void setSomatic(Boolean somatic) {
        isSomatic = somatic;
    }

    public Boolean getMaterial() {
        return isMaterial;
    }

    public void setMaterial(Boolean material) {
        isMaterial = material;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCasterId() {
        return casterId;
    }

    public void setCasterId(Long casterId) {
        this.casterId = casterId;
    }

}
