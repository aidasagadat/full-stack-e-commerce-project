package com.aida.service.impl;

import com.aida.model.Category;
import com.aida.model.Product;
import com.aida.model.Seller;
import com.aida.repository.CategoryRepository;
import com.aida.repository.ProductRepository;
import com.aida.request.CreateProductRequest;
import com.aida.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Override
    public Product createProduct(CreateProductRequest req, Seller seller) {

        Category category1 = categoryRepository.findByCategoryId(req.getCategory());

        if(category1 == null){
            Category category = new Category();
            category.setCategoryId(req.getCategory());
            category.setLevel(1);
            category1 = categoryRepository.save(category);
        }

        Category category2 = categoryRepository.findByCategoryId(req.getCategory());

        if(category2 == null){
            Category category = new Category();
            category.setCategoryId(req.getCategory());
            category.setLevel(2);
            category.setParentCategory(category1);
            category2 = categoryRepository.save(category);
        }

        Category category3 = categoryRepository.findByCategoryId(req.getCategory());

        if(category3 == null){
            Category category = new Category();
            category.setCategoryId(req.getCategory());
            category.setLevel(3);
            category.setParentCategory(category2);
            category3 = categoryRepository.save(category);
        }

        int discountPercentage = calculateDiscountPercentage(req.getMrpPrice(), req.getSellingPrice());

        Product product = new Product();
        product.setSeller(seller);
        product.setCategory(category3);
        product.setDescription(req.getDescription());
        product.setCreatedAt(LocalDateTime.now());
        product.setTitle(req.getTitle());
        product.setColor(req.getColor());
        product.setSellingPrice(req.getSellingPrice());
        product.setImages(req.getImages());
        product.setMrpPrice(req.getMrpPrice());
        product.setSizes((req.getSizes()));
        product.setDiscountPercent(discountPercentage);

        return productRepository.save(product);
    }

    private int calculateDiscountPercentage(int mrpPrice, int sellingPrice) {
        if(mrpPrice <= 0){
            throw new IllegalArgumentException("Actual price must be greater than 0");
        }
        double discount = mrpPrice-sellingPrice;
        double discountPercentage =(discount/mrpPrice)*100;
        return (int)discountPercentage;
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product =findProductById(productId);
        productRepository.delete(product);
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Product findProductById(Long productId) {
        return null;
    }

    @Override
    public List<Product> searchProduct() {
        return List.of();
    }

    @Override
    public Page<Product> getAllProducts(String category, String brand, String colors, String sizes, Integer minPrice, Integer maxPrice, Integer minDiscount, String sort, String stock, Integer pageNumber) {
        return null;
    }

    @Override
    public List<Product> getProductBySellerId(Long sellerId) {
        return List.of();
    }
}
