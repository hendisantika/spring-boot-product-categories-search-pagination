package com.hendisantika.repository;

import com.hendisantika.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-product-categories-search-pagination
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2/25/23
 * Time: 20:49
 * To change this template use File | Settings | File Templates.
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
