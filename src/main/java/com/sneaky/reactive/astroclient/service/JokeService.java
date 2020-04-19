package com.sneaky.reactive.astroclient.service;

import com.sneaky.reactive.astroclient.json.JokeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Service
public class JokeService {

    private WebClient client;
    private String baseUrl = "https://api.icndb.com/jokes/random";

    @Autowired
    public JokeService(WebClient.Builder builder) {
        this.client = builder.baseUrl(baseUrl).build();
    }

    public String getJoke(String firstName, String lastName) {
        String url = String.format(baseUrl, firstName, lastName);
        return client.get()
                .uri(uriBuilder -> uriBuilder.path(baseUrl)
                        .queryParam("exclude", "[explicit]")
                        .queryParam("firstName", firstName)
                        .queryParam("lastName", lastName)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(JokeResponse.class)
                .map(jokeResponse -> jokeResponse.getValue().getJoke())
                .block(Duration.ofSeconds(2));
    }
}
