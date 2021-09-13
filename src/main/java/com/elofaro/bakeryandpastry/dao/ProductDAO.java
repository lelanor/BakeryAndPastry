package com.elofaro.bakeryandpastry.dao;

import com.elofaro.bakeryandpastry.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDAO extends CrudRepository<Product, Integer> {
}
