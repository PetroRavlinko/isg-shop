package com.intentsg.shop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShopApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testMain() {
        String[] args = new String[]{"app"};
        ShopApplication.main(args);
    }

}