package hu.isrv.survey.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by teddywestside on 2017. 02. 01..
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String main() {
        return "main";
    }
}
