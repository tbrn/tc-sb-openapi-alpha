package local.tc.demo.openapi.alpha.helloopenfeign;

import com.google.common.collect.ImmutableMap;
import local.tc.demo.openapi.alpha.api.hello.HelloOpenApi;
import local.tc.demo.openapi.alpha.api.hello.model.HelloOpenApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/feignopenapi")
public class HelloFeignOpenApiController implements HelloOpenApi {

    private final HelloOpenClient helloClient;

    @Autowired
    public HelloFeignOpenApiController(HelloOpenClient helloClient) {
        this.helloClient = helloClient;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET) // overriding
    public Map<String, String> test() {
        return ImmutableMap.of("message", "test");
    }

    @Override
    public ResponseEntity<HelloOpenApiResponse> hello() {
        return helloClient.hello();
    }
}
