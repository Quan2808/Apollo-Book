package com.apollo.bookstore.library.dto;

import com.apollo.bookstore.library.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartDto {
    private Long id;

    private User user;

    private double totalPrice;

    private int totalItems;

    private Set<CartItemDto> cartItems;

}
