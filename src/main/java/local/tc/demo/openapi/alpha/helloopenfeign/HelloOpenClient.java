package local.tc.demo.openapi.alpha.helloopenfeign;

import local.tc.demo.openapi.alpha.api.hello.HelloOpenApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "helloopen", url = "${client.helloopen.target}")
public interface HelloOpenClient extends HelloOpenApi {
}
