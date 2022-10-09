package com.ortopedic.ortopedicWork.repositories;

import com.ortopedic.ortopedicWork.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<Category,Integer> {
}
