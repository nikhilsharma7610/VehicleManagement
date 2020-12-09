package com.zeta.vehicle.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nikhil sharma created on 09/12/20
 */
@RestController
public class PingController {

    @GetMapping("/ping")
    public String ping() {
        return "OK";
    }

}
