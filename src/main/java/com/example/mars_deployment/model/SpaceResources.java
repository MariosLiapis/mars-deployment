package com.example.mars_deployment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represents a space resource item used in the Mars station.
 */
@Entity
public final class SpaceResources {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int quantity;

    /**
     * Default constructor.
     */
    public SpaceResources() {
    }

    /**
     * Constructor with fields.
     *
     * @param name     the name of the resource
     * @param quantity the quantity of the resource
     */
    public SpaceResources(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    /**
     * Returns the ID of the resource.
     *
     * @return the resource ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Returns the name of the resource.
     *
     * @return the name of the resource
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the quantity of the resource.
     *
     * @return the quantity available
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the ID of the resource.
     *
     * @param id the ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Sets the name of the resource.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the quantity of the resource.
     *
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
