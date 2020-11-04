package com.intentsg.shop.services.impl;

import com.intentsg.shop.model.Cart;
import com.intentsg.shop.repository.CartRepository;
import com.intentsg.shop.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;

//@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.INTERFACES)
@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private Cart currentCart;

    @PostConstruct
    public void initiate() {
        this.currentCart = this.createCart();
    }

    @Override
    public Cart getCurrentCart() {
        return this.currentCart;
    }

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
