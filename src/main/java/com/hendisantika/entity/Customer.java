package com.hendisantika.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-product-categories-search-pagination
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2/27/23
 * Time: 17:11
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String address;

}
