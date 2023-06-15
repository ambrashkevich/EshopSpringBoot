package com.tms.shop.services;

import static com.tms.shop.utils.Constants.CART_PAGE;

import com.tms.shop.entities.Cart;
import com.tms.shop.entities.Product;
import com.tms.shop.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Service
public class CartService {

    private final ProductRepository productRepository;

    public ModelAndView addProductToCart(int productId, Cart shopCart) {
        ModelMap modelParams = new ModelMap();
        Product product = productRepository.findById(productId);
        shopCart.addProduct(product);
        modelParams.addAttribute("product", product);
        modelParams.addAttribute("cart", shopCart);
        return new ModelAndView(CART_PAGE, modelParams);
    }

    public ModelAndView deleteProductFromCart(int productId, Cart shopCart) {
        Product product = productRepository.findById(productId);
        shopCart.deleteProduct(product);
        return new ModelAndView(CART_PAGE);
    }
}