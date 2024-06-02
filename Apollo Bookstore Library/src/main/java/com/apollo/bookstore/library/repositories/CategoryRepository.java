package com.apollo.bookstore.library.repositories;

import com.apollo.bookstore.library.dto.CategoryDto;
import com.apollo.bookstore.library.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Modifying
    @Transactional
    @Query("update Category c set c.name = ?1 where c.id = ?2")
    void update(String name, Long id);

    @Query(value = "select * from categories where is_activated = 1", nativeQuery = true)
    List<Category> findAllByActivatedTrue();

    @Query("select new com.apollo.bookstore.library.dto.CategoryDto(c.id, c.name, count(p.category.id)) " +
            "from Category c left join Product p on c.id = p.category.id " +
            "where c.activated = true and c.deleted = false " +
            "group by c.id")
    List<CategoryDto> getCategoriesAndSize();
}