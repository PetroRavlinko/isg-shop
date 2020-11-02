package com.intentsg.shop.services;

import com.intentsg.shop.model.Cart;

public interface CartService {

    Cart getCurrentCart();
    Cart createCart();
    void updateCart(Cart cart, int newSomeValue);
    void deleteCart(Cart cartToDelete);
    Cart getCart(long id);

}
