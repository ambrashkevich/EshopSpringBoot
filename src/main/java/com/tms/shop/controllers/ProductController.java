package com.tms.shop.controllers;


import static com.tms.shop.utils.Constants.PRODUCTS_PAGE;
import static com.tms.shop.utils.Constants.PRODUCT_PAGE;

import com.tms.shop.entities.Product;
import com.tms.shop.services.ProductService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final static int PAGE_SIZE = 4;

    @GetMapping("/{id}")
    public String openProductPage(Model model, @PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (Optional.ofNullable(product).isPresent()) {
            model.addAttribute("product", product);
        }
        return PRODUCT_PAGE;
    }

    @GetMapping
    public String openAllProductPage(Model model, @RequestParam(required = false, name = "page") Integer pageNumber,
                                     @RequestParam(required = false, name = "name") String productName) {
        int currentPage = 0;
        if (pageNumber != null) {
            currentPage = pageNumber - 1;
        }
        if (productName == null) {
            productName = "";
        }
        Page<Product> pageProduct = productService.getProducts(productName, currentPage, PAGE_SIZE);
        model.addAttribute("products", pageProduct.getContent());
        model.addAttribute("page", pageProduct);
        model.addAttribute("name", productName);
        return PRODUCTS_PAGE;
    }
}
