package com.dnd.app.character;

import javax.persistence.*;

/**
 * Character Entity
 */
@Entity
@Table
public class Character {

    /**
     * ID Generator
     */
    @Id
    @SequenceGenerator(
            name = "character_sequence",
            sequenceName = "character_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "character_sequence"
    )
    private Long id;
    private String name;
    private String race;
    private String charClass;
    private Integer level;
    private Integer strength;
    private Integer constitution;
    private Integer dexterity;
    private Integer wisdom;
    private Integer intelligence;
    private Integer charisma;
    private Integer speed;
    private Integer hp;


    /**
     * Modifiers calculated based on corresponding stat
     */
    @Transient
    private Integer strModifier;

    @Transient
    private Integer conModifier;

    @Transient
    private Integer dexModifier;

    @Transient
    private Integer wisModifier;

    @Transient
    private Integer intModifier;

    @Transient
    private Integer chaModifier;

    @Transient
    private String[] inventory;

    public Character() {
    }

    /**
     * Constructor for Character class
     * @param id - unique identifier, auto generated (Long)
     * @param name - character name (String)
     * @param race - character race (String)
     * @param charClass - character class (String)
     * @param level - character level (int)
     * @param strength - STR (int)
     * @param constitution - CON (int)
     * @param dexterity - DEX (int)
     * @param wisdom - WIS (int)
     * @param intelligence - INT (int)
     * @param charisma - CHA (int)
     * @param speed - character speed in ft (int)
     * @param hp - character hit points (int)
     */
    public Character(Long id, String name, String race, String charClass, Integer level,
                     Integer strength, Integer constitution, Integer dexterity,
                     Integer wisdom, Integer intelligence, Integer charisma, Integer speed,
                     Integer hp) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.charClass = charClass;
        this.level = level;
        this.strength = strength;
        this.constitution = constitution;
        this.dexterity = dexterity;
        this.wisdom = wisdom;
        this.intelligence = intelligence;
        this.charisma = charisma;
        this.speed = speed;
        this.hp = hp;
    }

    public Character(String name, String race, String charClass, Integer level,
                     Integer strength, Integer constitution, Integer dexterity,
                     Integer wisdom, Integer intelligence, Integer charisma, Integer speed, Integer hp) {
        this.name = name;
        this.race = race;
        this.charClass = charClass;
        this.level = level;
        this.strength = strength;
        this.constitution = constitution;
        this.dexterity = dexterity;
        this.wisdom = wisdom;
        this.intelligence = intelligence;
        this.charisma = charisma;
        this.speed = speed;
        this.hp = hp;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getCharClass() {
        return charClass;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getConstitution() {
        return constitution;
    }

    public void setConstitution(Integer constitution) {
        this.constitution = constitution;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public Integer getWisdom() {
        return wisdom;
    }

    public void setWisdom(Integer wisdom) {
        this.wisdom = wisdom;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getCharisma() {
        return charisma;
    }

    public void setCharisma(Integer charisma) {
        this.charisma = charisma;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    /**
     * Calculating modifier from corresponding stat
     * @return - stat modifier
     */
    public Integer getStrModifier() {
        int str_divide = this.strength - 10;
        Integer div = Integer.valueOf(str_divide);

        return Math.floorDiv(div, 2);

    }

    public void setStrModifier(Integer strModifier) {
        this.strModifier = strModifier;
    }

    public Integer getConModifier() {
        int con_divide = this.constitution - 10;
        Integer div = Integer.valueOf(con_divide);

        return Math.floorDiv(div, 2);
    }

    public void setConModifier(Integer conModifier) {
        this.conModifier = conModifier;
    }

    public Integer getDexModifier() {
        int divide = this.dexterity - 10;
        Integer div = Integer.valueOf(divide);

        return Math.floorDiv(div, 2);
    }

    public void setDexModifier(Integer dexModifier) {
        this.dexModifier = dexModifier;
    }

    public Integer getWisModifier() {
        int divide = this.wisdom - 10;
        Integer div = Integer.valueOf(divide);

        return Math.floorDiv(div, 2);
    }

    public void setWisModifier(Integer wisModifier) {
        this.wisModifier = wisModifier;
    }

    public Integer getIntModifier() {
        int divide = this.intelligence - 10;
        Integer div = Integer.valueOf(divide);

        return Math.floorDiv(div, 2);
    }

    public void setIntModifier(Integer intModifier) {
        this.intModifier = intModifier;
    }

    public Integer getChaModifier() {
        int divide = this.charisma - 10;
        Integer div = Integer.valueOf(divide);

        return Math.floorDiv(div, 2);
    }

    public void setChaModifier(Integer chaModifier) {
        this.chaModifier = chaModifier;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", charClass='" + charClass + '\'' +
                ", strength=" + strength +
                ", constitution=" + constitution +
                ", dexterity=" + dexterity +
                ", wisdom=" + wisdom +
                ", intelligence=" + intelligence +
                ", charisma=" + charisma +
                ", strModifier=" + strModifier +
                ", conModifier=" + conModifier +
                ", dexModifier=" + dexModifier +
                ", wisModifier=" + wisModifier +
                ", intModifier=" + intModifier +
                ", chaModifier=" + chaModifier +
                '}';
    }
}
