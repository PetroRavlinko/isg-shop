package com.intentsg.shop.repository;

import com.intentsg.shop.model.Cart;

public interface CartRepository {
    Cart createCartAtDB(Cart cart);
    void updateCartAtDB(Cart cart, int newSomeValue);
    void deleteFromDB(Cart cartToDelete);
    Cart getCartFromDB(long id);
}
