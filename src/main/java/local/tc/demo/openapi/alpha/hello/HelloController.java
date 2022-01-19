package local.tc.demo.openapi.alpha.hello;

import local.tc.demo.openapi.alpha.hello.api.HelloApi;
import local.tc.demo.openapi.alpha.hello.api.HelloResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HelloController implements HelloApi {

    @Value("${spring.application.name:#{null}}")
    private Optional<String> serverName;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public HelloResponse hello() {
        final String helloMessage = serverName.map(s -> String.format("Hello %s World!", s))
                .orElse("Hello World!");
        return new HelloResponse(helloMessage);
    }
}
