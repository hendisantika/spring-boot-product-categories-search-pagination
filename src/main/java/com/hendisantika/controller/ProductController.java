package com.hendisantika.controller;

import com.hendisantika.entity.Product;
import com.hendisantika.repository.CategoryRepository;
import com.hendisantika.repository.ProductRepository;
import com.hendisantika.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping(value = "/product/filter")
    public String filterCategory(
            @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
            @RequestParam(value = "size", required = false, defaultValue = "5") int size,
            @RequestParam(value = "category") Integer categoryId, Model model) {
        model.addAttribute("products", productService.filterByCategory(pageNumber, size, categoryId));
        return "index";
    }

    @PostMapping(value = "/product/search")
    public String search(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                         @RequestParam(value = "size", required = false, defaultValue = "5") int size,
                         @RequestParam(value = "searchKey") String searchKey, Model model) {
        model.addAttribute("products", productService.search(pageNumber, size, searchKey));
        return "index";
    }

    @PostMapping("/product/create")
    public String saveBank(Model model, @Validated @ModelAttribute("product") Product product,
                           BindingResult bindingResult, RedirectAttributes flashMessages) throws Exception {
        if (bindingResult.hasErrors()) {
            model.addAttribute("product", product);
            return "product";
        }
        Product optinalProduct = productService.saveOrUpdate(product);
        if (optinalProduct != null) {
            flashMessages.addFlashAttribute("success", "Product added Successfully!! ");
        } else {
            flashMessages.addFlashAttribute("error", "Details are not saved!! Please retry.");
        }
        return "redirect:/";
    }
}
