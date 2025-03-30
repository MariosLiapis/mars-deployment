package com.example.mars_deployment.model;

import jakarta.persistence.*;

@Entity
public class SpaceResources {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String name;
  private int quantity;

  public SpaceResources() {

  }

  public SpaceResources(String name, int quantity) {
    this.name = name;
    this.quantity = quantity;
  }

  
  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getQuantity() {
    return quantity;
  }


  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
