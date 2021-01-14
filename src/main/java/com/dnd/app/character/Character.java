package com.dnd.app.character;

import javax.persistence.*;

@Entity
@Table
public class Character {
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
    private Integer strength;
    private Integer constitution;
    private Integer dexterity;
    private Integer wisdom;
    private Integer intelligence;
    private Integer charisma;

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

    public Character() {
    }

    public Character(Long id, String name, String race, String charClass,
                     Integer strength, Integer constitution, Integer dexterity,
                     Integer wisdom, Integer intelligence, Integer charisma) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.charClass = charClass;
        this.strength = strength;
        this.constitution = constitution;
        this.dexterity = dexterity;
        this.wisdom = wisdom;
        this.intelligence = intelligence;
        this.charisma = charisma;
    }

    public Character(String name, String race, String charClass, Integer strength, Integer constitution, Integer dexterity, Integer wisdom, Integer intelligence, Integer charisma) {
        this.name = name;
        this.race = race;
        this.charClass = charClass;
        this.strength = strength;
        this.constitution = constitution;
        this.dexterity = dexterity;
        this.wisdom = wisdom;
        this.intelligence = intelligence;
        this.charisma = charisma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
