package com.intentsg.shop.services;

import com.intentsg.shop.model.Cart;
import com.intentsg.shop.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    @Override
    public Cart createCart() {
        return cartRepository.save(new Cart());
    }

    @Override
    public void updateCart(Cart cart, int newSomeValue) {
        cart.setSmthToUpdate(newSomeValue);
        cartRepository.save(cart);
    }

    @Override
    public void deleteCart(Cart cartToDelete) {
        cartRepository.delete(cartToDelete);
    }

    @Override
    public Cart getCart(long id) {
        return cartRepository.findById(id).orElseThrow();
    }
}
