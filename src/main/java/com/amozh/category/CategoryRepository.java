package com.amozh.category;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

/**
 * Created by Andrii Mozharovskyi on 07.04.2016.
 */
@RepositoryRestResource
public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Query("SELECT c FROM Category c LEFT JOIN FETCH c.parent WHERE c.contentType = com.amozh.category.CategoryContentType.I")
    Collection<Category> findForIngredientsTree();

}