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

    public double totalAmount(){
        return product.getPrice()*quantity;
    }
}
