package me.hyanbp.ipet.api.pet;

public class PetRequest {

    private String name;
    private String breed;
    private Long customerId;

    public PetRequest(String name, String breed, Long customerId) {
        this.name = name;
        this.breed = breed;
        this.customerId = customerId;
    }

    public PetRequest() {
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public Long getCustomerId() {
        return customerId;
    }
}
