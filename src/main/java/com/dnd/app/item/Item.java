package com.dnd.app.item;

import javax.persistence.*;

@Entity
@Table
public class Item {
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
    private Integer cost;
    private Integer weight;
    private String attribute;

    public Item() {
    }

    public Item(Long id, String name, Integer cost, Integer weight, String attribute) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.weight = weight;
        this.attribute = attribute;
    }

    public Item(String name, Integer cost, Integer weight, String attribute) {
        this.name = name;
        this.cost = cost;
        this.weight = weight;
        this.attribute = attribute;
    }

    public Item(String name, Integer cost, Integer weight) {
        this.name = name;
        this.cost = cost;
        this.weight = weight;
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

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}
