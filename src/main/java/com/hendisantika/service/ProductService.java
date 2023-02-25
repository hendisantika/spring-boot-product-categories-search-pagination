package com.hendisantika.service;

import com.hendisantika.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-product-categories-search-pagination
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2/25/23
 * Time: 20:50
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

}
