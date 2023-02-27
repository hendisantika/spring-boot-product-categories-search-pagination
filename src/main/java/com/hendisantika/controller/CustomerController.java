package com.hendisantika.controller;

import com.hendisantika.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

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
@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerRepository customerRepository;
}
