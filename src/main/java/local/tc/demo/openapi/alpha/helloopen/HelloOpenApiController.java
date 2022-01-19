package local.tc.demo.openapi.alpha.helloopen;

import com.google.common.collect.ImmutableMap;
import local.tc.demo.openapi.alpha.api.hello.HelloOpenApi;
import local.tc.demo.openapi.alpha.api.hello.model.HelloOpenApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
public class HelloOpenApiController implements HelloOpenApi {

    @Value("${spring.application.name:#{null}}")
    private Optional<String> serverName;

    @RequestMapping(value = "/pingopenapicontroller", method = RequestMethod.GET) // overriding
    public Map<String, String> test() {
        return ImmutableMap.of("message", "server running");
    }

    @Override
    public ResponseEntity<HelloOpenApiResponse> hello() {
        final String message = serverName.map(s -> String.format("Hello %s's Open API World!", s))
                .orElse("Hello Open API World!");
        final HelloOpenApiResponse response = new HelloOpenApiResponse();
        response.setMessage(message);
        return ResponseEntity.ok(response);
    }
}
