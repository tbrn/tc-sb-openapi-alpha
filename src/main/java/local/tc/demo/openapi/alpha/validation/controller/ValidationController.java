package local.tc.demo.openapi.alpha.validation.controller;

import local.tc.demo.openapi.alpha.hello.api.model.HelloResponse;
import local.tc.demo.openapi.alpha.validation.model.HelloInput;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ValidationController {
    @RequestMapping(value = "/testvalidation", method = RequestMethod.POST)
    public HelloResponse testValidation(@Valid @RequestBody HelloInput input) {
        return new HelloResponse(String.format("Hello %s's Validation World", input.getName()));
    }
}
