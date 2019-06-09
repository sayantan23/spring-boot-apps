package com.example.sayantan.tutorial.asyncdemo.demoasync.service;

import com.example.sayantan.tutorial.asyncdemo.demoasync.dto.User;
import com.sun.xml.internal.ws.util.CompletedFuture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;


@Service
@Slf4j
public class GitHubLookupService {

    private final RestTemplate restTemplate;

    public GitHubLookupService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @Async
    public CompletableFuture<User> getUser(String name) throws InterruptedException {
        log.info("Looking for User : {}",name);
        User user = restTemplate.getForObject(String.format("https://api.github.com/users/%s", name),User.class);
        Thread.sleep(5000);
        return CompletableFuture.completedFuture(user);
    }
}
