package com.intentsg.shop.repository;

import com.intentsg.shop.model.Catalog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends CrudRepository<Catalog, Long> {
}
