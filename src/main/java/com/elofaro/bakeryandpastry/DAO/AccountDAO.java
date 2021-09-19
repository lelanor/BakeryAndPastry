package com.elofaro.bakeryandpastry.DAO;

import com.elofaro.bakeryandpastry.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface AccountDAO extends CrudRepository<Product, Integer> {
}
