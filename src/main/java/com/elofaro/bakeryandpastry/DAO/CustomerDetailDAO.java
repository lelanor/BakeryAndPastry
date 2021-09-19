package com.elofaro.bakeryandpastry.DAO;

import com.elofaro.bakeryandpastry.model.CustomerDetail;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDetailDAO extends CrudRepository<CustomerDetail, Integer> {
}
