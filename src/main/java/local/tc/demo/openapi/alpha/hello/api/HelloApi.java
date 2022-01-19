package local.tc.demo.openapi.alpha.hello.api;

import local.tc.demo.openapi.alpha.hello.api.model.HelloResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface HelloApi {

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    HelloResponse hello();

}
