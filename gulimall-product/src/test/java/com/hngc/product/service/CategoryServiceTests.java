package com.hngc.product.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CategoryServiceTests {

    @Autowired
    CategoryService categoryService;

    @Test
    void contextLoads() {
        System.out.println(categoryService.listMemuTree());

    }

}
