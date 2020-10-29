package com.intentsg.shop.services;

import com.intentsg.shop.model.Cart;
import com.intentsg.shop.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{
    private final CartRepository cartRepository;

    @Override
    public Cart createCart() {
        return cartRepository.createCartAtDB(new Cart());
    }

    @Override
    public void updateCart(Cart cart, int newSomeValue) {
        cartRepository.updateCartAtDB(cart, newSomeValue);
    }

    @Override
    public void deleteCart(Cart cartToDelete) {
        cartRepository.deleteFromDB(cartToDelete);
    }

    @Override
    public Cart getCart(long id) {
        return cartRepository.getCartFromDB(id);
    }
}
