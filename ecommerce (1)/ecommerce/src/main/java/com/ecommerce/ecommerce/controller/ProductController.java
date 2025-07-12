package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.model.Product;
import com.ecommerce.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    // Home page - list all products
    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products"; // loads templates/products.html
    }

    // Show form to add a new product
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct"; // loads templates/addProduct.html
    }

    // Handle POST request to add product
    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") Product product) {
        productService.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
public String deleteProduct(@PathVariable String id) {
    productService.deleteProduct(id);
    return "redirect:/";
}

}
