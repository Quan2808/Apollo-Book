package com.apollo.bookstore.library.services;

import com.apollo.bookstore.library.dto.ProductDto;
import com.apollo.bookstore.library.dto.ShoppingCartDto;
import com.apollo.bookstore.library.entities.ShoppingCart;

public interface ShoppingCartService {
    ShoppingCart addItemToCart(ProductDto productDto, int quantity, String username);

    ShoppingCart updateCart(ProductDto productDto, int quantity, String username);

    ShoppingCart removeItemFromCart(ProductDto productDto, String username);

    ShoppingCartDto addItemToCartSession(ShoppingCartDto cartDto, ProductDto productDto, int quantity);

    ShoppingCartDto updateCartSession(ShoppingCartDto cartDto, ProductDto productDto, int quantity);

    ShoppingCartDto removeItemFromCartSession(ShoppingCartDto cartDto, ProductDto productDto, int quantity);

    ShoppingCart combineCart(ShoppingCartDto cartDto, ShoppingCart cart);

    void deleteCartById(Long id);

    ShoppingCart getCart(String username);
}
