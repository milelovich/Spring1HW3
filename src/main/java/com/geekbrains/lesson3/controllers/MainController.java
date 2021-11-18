package com.geekbrains.lesson3.controllers;

import com.geekbrains.lesson3.model.Product;
import com.geekbrains.lesson3.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MainController {

    private ProductRepository productRepository; // связываем бины между собой

    public MainController(ProductRepository productRepository) { // заинжектили репозиторий в контроллер
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public String showProductPage(Model model){
        model.addAttribute("products", productRepository.getAllProduct());
    return "products_page";
    }

    @GetMapping("/products/{id}")
    public String showProductPage(Model model, @PathVariable Long id){
        Product product = productRepository.findById(id);
        model.addAttribute("products", product);
        return "product_info_page";
    }

}
