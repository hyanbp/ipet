package me.hyanbp.ipet.entity;

import javax.persistence.*;

@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;
    private String name;
    private String breed;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    public Pet(String name, String breed, Long customerId) {
        this.name = name;
        this.breed = breed;
        this.customerId = customerId;
    }

    public Pet() {
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

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerId() {
        return customerId;


    }
}
