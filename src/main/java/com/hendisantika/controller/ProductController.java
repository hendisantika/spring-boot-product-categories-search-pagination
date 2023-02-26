package com.hendisantika.controller;

import com.hendisantika.repository.CategoryRepository;
import com.hendisantika.repository.ProductRepository;
import com.hendisantika.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-product-categories-search-pagination
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2/26/23
 * Time: 17:02
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;
}
