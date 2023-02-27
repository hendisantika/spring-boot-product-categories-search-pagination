package com.hendisantika.repository;

import com.hendisantika.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-product-categories-search-pagination
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2/27/23
 * Time: 17:12
 * To change this template use File | Settings | File Templates.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByName(String name);
}
