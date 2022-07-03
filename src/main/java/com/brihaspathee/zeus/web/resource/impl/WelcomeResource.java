package com.brihaspathee.zeus.web.resource.impl;

import com.brihaspathee.zeus.web.resource.interfaces.WelcomeApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 03, July 2022
 * Time: 5:20 PM
 * Project: Zeus
 * Package Name: com.brihaspathee.zeus.web.resource.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class WelcomeResource implements WelcomeApi {

    @GetMapping
    @Override
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Welcome to Reference Data Service");
    }
}
