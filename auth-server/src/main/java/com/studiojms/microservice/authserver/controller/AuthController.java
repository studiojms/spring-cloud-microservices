package com.studiojms.microservice.authserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author studiojms
 */
@RestController
public class AuthController {

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
