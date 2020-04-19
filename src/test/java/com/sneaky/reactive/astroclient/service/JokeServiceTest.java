package com.sneaky.reactive.astroclient.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class JokeServiceTest {

    @Autowired
    private JokeService service;

    @Test
    public void testAutowiring() {
        assertNotNull(service);
    }

    @Test
    void getJokeTest() {
        String joke = service.getJoke("Paul", "Deitel");
        System.out.println(joke);
    }

}