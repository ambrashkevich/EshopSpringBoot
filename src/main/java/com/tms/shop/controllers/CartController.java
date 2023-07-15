package com.tms.shop.controllers;

import static com.tms.shop.utils.Constants.CART_PAGE;

import com.tms.shop.entities.Cart;
import com.tms.shop.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@RequiredArgsConstructor
@Controller
@SessionAttributes({"cart"})
@RequestMapping("/cart")
public class CartController {

    public final CartService cartService;

    @PostMapping("/add")
    public String addProductToCart(Model model, @RequestParam("product_id") Long id, @ModelAttribute("cart") Cart shopCart) {
        model.addAttribute("product", cartService.addProductToCart(id, shopCart));
        model.addAttribute("cart", shopCart);
        return CART_PAGE;
    }

    @GetMapping("/delete")
    public String deleteProductFromCart(@RequestParam("product_id") Long id, @ModelAttribute("cart") Cart shopCart) {
        cartService.deleteProductFromCart(id, shopCart);
        return "redirect:/cart";
    }

    @GetMapping("")
    public String openShoppingCart() {
        return CART_PAGE;
    }

    @ModelAttribute("cart")
    public Cart shoppingCart() {
        return new Cart();
    }
}