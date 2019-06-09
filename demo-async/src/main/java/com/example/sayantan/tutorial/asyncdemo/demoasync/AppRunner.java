package com.example.sayantan.tutorial.asyncdemo.demoasync;

import com.example.sayantan.tutorial.asyncdemo.demoasync.dto.User;
import com.example.sayantan.tutorial.asyncdemo.demoasync.service.GitHubLookupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@Slf4j
public class AppRunner implements CommandLineRunner {

    private final GitHubLookupService gitHubLookupService;

    public AppRunner(GitHubLookupService gitHubLookupService) {
        this.gitHubLookupService = gitHubLookupService;
    }

    @Override
    public void run(String... args) throws Exception {

        long start = System.currentTimeMillis();
        CompletableFuture<User> user1 = gitHubLookupService.getUser("PivotalSoftware");
        CompletableFuture<User> user2 = gitHubLookupService.getUser("CloudFoundry");
        CompletableFuture<User> user3 = gitHubLookupService.getUser("Spring-Projects");

        CompletableFuture.allOf(user1,user2,user3).join();
        log.info("Printing user details");
        log.info("User1  : {}",user1.get());
        log.info("User2  : {}",user2.get());
        log.info("User3  : {}",user3.get());

        log.info("Time elapsed : {}",System.currentTimeMillis()-start);



    }
}
