package local.tc.demo.openapi.alpha.hellomapstruct;

import local.tc.demo.openapi.alpha.api.hello.model.HelloOpenApiResponse;
import local.tc.demo.openapi.alpha.hello.api.model.HelloResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HelloMapper {

    HelloResponse helloResponse(final HelloOpenApiResponse helloOpenApiResponse);

}
