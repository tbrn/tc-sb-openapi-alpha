package local.tc.demo.openapi.alpha.hellofeign;

import local.tc.demo.openapi.alpha.hello.api.HelloApi;
import local.tc.demo.openapi.alpha.hello.api.HelloResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class HelloFeignController implements HelloApi {

    private final HelloClient helloClient;

    @Autowired
    public HelloFeignController(HelloClient helloClient) {
        this.helloClient = helloClient;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET) // overriding
    public HelloResponse hello() {
        return helloClient.hello();
    }
}
