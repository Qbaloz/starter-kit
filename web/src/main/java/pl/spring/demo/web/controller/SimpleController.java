package pl.spring.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Map;

@Controller
public class SimpleController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Map<String, Object> parameters) {
        return "home";
    }
}

