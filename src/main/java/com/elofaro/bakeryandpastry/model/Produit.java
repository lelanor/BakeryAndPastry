package com.elofaro.bakeryandpastry.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Produit {

    private String label;
    private double price;
    private String description;
    private String imageAddress;

    public Produit(String label, double price, String description, String imageAddress) {
        this.label = label;
        this.price = price;
        this.description = description;
        this.imageAddress = imageAddress;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
