package local.tc.demo.openapi.alpha.error.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ErrorController {
    @RequestMapping("/testerror")
    public HashMap<String, String> testError() {
        throw new RuntimeException("Something went wrong");
    }
}
