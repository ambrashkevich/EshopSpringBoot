package com.tms.shop.services;

import static com.tms.shop.utils.Constants.CART_PAGE;

import com.tms.shop.entities.Cart;
import com.tms.shop.entities.Product;
import com.tms.shop.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Service
public class CartService {

    private final ProductRepository productRepository;

    public Product addProductToCart(Long productId, Cart shopCart) {
        Product product = productRepository.getProductById(productId);
        shopCart.addProduct(product);
        return product;
    }

    public ModelAndView deleteProductFromCart(Long productId, Cart shopCart) {
        Product product = productRepository.getProductById(productId);
        shopCart.deleteProduct(product);
        return new ModelAndView(CART_PAGE);
    }
}