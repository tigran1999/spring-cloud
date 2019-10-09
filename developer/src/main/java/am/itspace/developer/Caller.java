package am.itspace.developer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Caller {

    @Autowired
    private ServerFeign serverFeign;

    @HystrixCommand(fallbackMethod = "fallback")
    public Integer convert(int hours){
        return serverFeign.convert(hours);
    }

    public Integer fallback(int hours){
        return 42;
    }

}
