package kz.satbayev.medicalservices.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("web")
public class WebController {

    @GetMapping("native-users")
    public String nativeUsers(){
        return "native-users";
    }

    @GetMapping("react-users")
    public String reactUsers(){
        return "react-users";
    }
}
