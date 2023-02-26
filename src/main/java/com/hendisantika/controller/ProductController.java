package com.hendisantika.controller;

import com.hendisantika.repository.CategoryRepository;
import com.hendisantika.repository.ProductRepository;
import com.hendisantika.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping(value = "/")
    public String posts(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                        @RequestParam(value = "size", required = false, defaultValue = "4") int size, Model model) {
        model.addAttribute("products", productService.getProduct(pageNumber, size));
        model.addAttribute("categories", categoryRepository.findAll());
        return "index";
    }
}
