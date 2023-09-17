package com.restapi.repositories;

import com.restapi.entities.ProductEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface ProductRepository extends PanacheRepository<ProductEntity> {
}