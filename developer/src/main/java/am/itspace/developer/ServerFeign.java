package am.itspace.developer;

import am.itspace.server.Server;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("server")
public interface ServerFeign extends Server {
}
