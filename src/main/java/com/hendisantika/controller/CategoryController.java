package com.hendisantika.controller;

import com.hendisantika.entity.Category;
import com.hendisantika.exception.RecordNotFoundException;
import com.hendisantika.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-product-categories-search-pagination
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2/26/23
 * Time: 16:59
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @GetMapping(value = {"/category", "/category/{id}"})
    public String getCategory(Model model, @PathVariable("id") Optional<Integer> id) throws RecordNotFoundException {
        if (id.isPresent()) {
            Optional<Category> categroy = categoryRepository.findById(id.get());
            if (categroy.isPresent()) {
                model.addAttribute("category", categroy);
            } else {
                throw new RecordNotFoundException("No category record exist for given id : " + id.get());
            }
        } else {
            model.addAttribute("category", new Category());
        }
        return "category_form";
    }

    @PostMapping("/category/create")
    public String saveBank(Model model, @Validated @ModelAttribute("categroy") Category categroy,
                           BindingResult bindingResult, RedirectAttributes flashMessages) throws Exception {
        if (bindingResult.hasErrors()) {
            model.addAttribute("category", categroy);
            return "category";
        }
        Category optinalCategory = categoryRepository.save(categroy);
        if (optinalCategory != null) {
            flashMessages.addFlashAttribute("success", "Product added Successfully!! ");
        } else {
            flashMessages.addFlashAttribute("error", "Details are not saved!! Please retry.");
        }
        return "redirect:/";
    }
}
