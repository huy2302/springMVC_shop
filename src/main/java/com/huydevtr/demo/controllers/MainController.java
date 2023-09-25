package com.huydevtr.demo.controllers;

import com.huydevtr.demo.models.entities.Product;
import com.huydevtr.demo.services.ProductService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "product", method = RequestMethod.GET)
    public String getProduct(ModelMap modelMap) {
        Iterable<Product> products = productService.findAll();
        modelMap.addAttribute("products", products);
        return "product/product";
    }

    @RequestMapping(value = {"/home", "/"}, method = RequestMethod.GET)
    public String getHomePage() {
        return "index";
    }

//    @RequestMapping(value = "/shop", method = RequestMethod.GET)
//    public String getShopPage () {
//        return "product/shop";
//    }
    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public String getShop (
            @RequestParam String category,
            Model modelMap
    ) {
        modelMap.addAttribute("category", category);
        return "product/shop";
    }
    @RequestMapping(value = "/product-details", method = RequestMethod.GET)
    public String getProductDetails(
            @RequestParam Long id,
            Model modelMap
    ) {
        modelMap.addAttribute("productId", id);
        return "product/product-details";
    }

}
