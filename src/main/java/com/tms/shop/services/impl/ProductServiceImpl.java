package com.tms.shop.services.impl;

import static com.tms.shop.utils.Constants.PRODUCT_PAGE;

import com.tms.shop.entities.Product;
import com.tms.shop.repositories.ProductRepository;
import com.tms.shop.services.ProductService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getProductsByCategoryId(Long categoryId) {
        return productRepository.findAllByCategory_Id(categoryId);
    }

    @Override
    public ModelAndView getProductData(Long id) {
        ModelMap modelMap = new ModelMap();
        Product product = productRepository.findById(id);
        if (Optional.ofNullable(product).isPresent()) {
            modelMap.addAttribute("product", product);
        }
        return new ModelAndView(PRODUCT_PAGE, modelMap);
    }
}