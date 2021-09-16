package com.elofaro.bakeryandpastry.model;

import javax.persistence.*;

@Table(name = "product")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Integer id;

    @Column(name = "label", length = 50)
    private String label;

    @Column(name = "price")
    private Double price;

    @Column(name = "description")
    private String description;

    @Column(name = "image_catalog", length = 100)
    private String imageCatalog;

    @Column(name = "image_landing", length = 100)
    private String imageLanding;

    @Column(name = "image_order", length = 100)
    private String imageOrder;


    public Product() {
    }

    public Product(String label, double price, String description,
                   String imageCatalog, String imageLanding, String imageOrder) {
        this.label = label;
        this.price = price;
        this.description = description;
        this.imageCatalog = imageCatalog;
        this.imageLanding = imageLanding;
        this.imageOrder = imageOrder;
    }

    public String getImageCatalog() {
        return imageCatalog;
    }

    public void setImageCatalog(String imageAddress) {
        this.imageCatalog = imageAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageLanding() {
        return imageLanding;
    }

    public void setImageLanding(String imageLanding) {
        this.imageLanding = imageLanding;
    }

    public String getImageOrder() {
        return imageOrder;
    }

    public void setImageOrder(String imageOrder) {
        this.imageOrder = imageOrder;
    }
}
