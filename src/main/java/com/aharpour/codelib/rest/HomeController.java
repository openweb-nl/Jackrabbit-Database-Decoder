package com.aharpour.codelib.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Senussi on 11/12/2017.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "redirect:swagger/index.html";
    }
}
