package local.tc.demo.openapi.alpha.hellomapstruct;

import local.tc.demo.openapi.alpha.api.hello.model.HelloOpenApiResponse;
import local.tc.demo.openapi.alpha.hello.api.HelloApi;
import local.tc.demo.openapi.alpha.hello.api.model.HelloResponse;
import local.tc.demo.openapi.alpha.helloopenfeign.HelloOpenClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloMapstructController implements HelloApi {

    private final HelloOpenClient helloClient;
    private final HelloMapper helloMapper;

    @Autowired
    public HelloMapstructController(HelloOpenClient helloClient, HelloMapper helloMapper) {
        this.helloClient = helloClient;
        this.helloMapper = helloMapper;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hellomapstruct")
    @Override
    public HelloResponse hello() {
        final HelloOpenApiResponse helloOpenResponse = helloClient.hello().getBody();
        return helloMapper.helloResponse(helloOpenResponse);
    }
}
