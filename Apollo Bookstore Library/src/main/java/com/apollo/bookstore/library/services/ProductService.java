package com.apollo.bookstore.library.services;

import com.apollo.bookstore.library.dto.ProductDto;
import com.apollo.bookstore.library.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    List<ProductDto> searchProducts(String keyword);

    Product save(MultipartFile imageProduct, ProductDto product);

    Product update(MultipartFile imageProduct, ProductDto productDto);

    List<ProductDto> products();

    void enableById(Long id);

    void deleteById(Long id);

    ProductDto getById(Long id);

    Product findById(Long id);

    List<ProductDto> randomProduct();

    Page<ProductDto> searchProducts(int pageNo, String keyword);

    Page<ProductDto> getAllProducts(int pageNo);

    Page<ProductDto> getAllProductsForCustomer(int pageNo);

    List<ProductDto> findAllByCategory(String category);

    List<ProductDto> filterHighProducts();

    List<ProductDto> filterLowerProducts();

    List<ProductDto> listViewProducts();

    List<ProductDto> findByCategoryId(Long id);

}
