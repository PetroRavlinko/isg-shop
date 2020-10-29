package com.intentsg.shop.repository;

import com.intentsg.shop.model.Cart;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartRepositoryImpl implements CartRepository{
    private final List<Cart> cartList = new ArrayList<>();

    private long generatedCartId = 1;

    @Override
    public Cart createCartAtDB(Cart cartToCreate) {
        cartToCreate.setId(generatedCartId);
        cartList.add(cartToCreate);
        generatedCartId++;
        return cartList.get(cartList.indexOf(cartToCreate));
    }

    @Override
    public void updateCartAtDB(Cart cart, int newSomeValue) {
        cartList.get(cartList.indexOf(cart))
                .setSmthToUpdate(newSomeValue);
    }

    @Override
    public void deleteFromDB(Cart cartToDelete) {
        if(cartList.stream().anyMatch(i -> i == cartToDelete)){
            cartList.remove(cartToDelete);
        }
    }

    @Override
    public Cart getCartFromDB(long id) {
        if(cartList.stream().anyMatch(i -> i.getId() == id)){
            return cartList.stream().filter(i -> i.getId() == id).findFirst().orElse(new Cart());
        }else{
            return new Cart();
        }
    }
}
