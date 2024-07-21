package com.pjcart.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {

    private static final Logger log = LoggerFactory.getLogger(ShopController.class);

    @GetMapping(value = "/")
    public String mainPage() throws Exception {
        log.info("Main Page In");
        return "/index";
    }
}
