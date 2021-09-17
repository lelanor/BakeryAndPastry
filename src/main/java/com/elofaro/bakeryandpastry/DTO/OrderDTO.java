package com.elofaro.bakeryandpastry.DTO;

import com.elofaro.bakeryandpastry.model.Product;
import lombok.Data;

@Data
public class OrderDTO {

    Product product;
    Integer quantity;

    public OrderDTO() {
    }

    public OrderDTO(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
