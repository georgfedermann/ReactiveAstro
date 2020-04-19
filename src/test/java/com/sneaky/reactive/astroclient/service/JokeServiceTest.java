package com.sneaky.reactive.astroclient.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class JokeServiceTest {

    @Autowired
    private JokeService service;

    private Logger logger = LoggerFactory.getLogger(JokeService.class);

    @Test
    public void testAutowiring() {
        assertNotNull(service);
    }

    @Test
    void getJokeTest() {
        String joke = service.getJoke("Paul", "Deitel");
        logger.info(joke);
        assertAll(
                () -> assertThat(joke).contains("Paul"),
                () -> assertThat(joke).contains("Deitel")
        );
    }

}