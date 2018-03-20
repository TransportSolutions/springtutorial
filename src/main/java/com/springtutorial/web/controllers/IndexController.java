package com.springtutorial.web.controllers;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Api(value="welcome", description="Operations pertaining to products in Online Store")
public class IndexController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

}
