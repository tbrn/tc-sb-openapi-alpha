package local.tc.demo.openapi.alpha.hellofeign;

import local.tc.demo.openapi.alpha.hello.api.HelloApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "hello", url = "${client.hello.target}")
public interface HelloClient extends HelloApi {
}
