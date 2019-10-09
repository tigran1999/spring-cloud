package am.itspace.developer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@RestController
public class MainEndpoint {

    @Autowired
   private Caller caller;

    @GetMapping("/estimation")
    public String getEstimation(){
        int hours = generateTime();
        System.out.println("I think it would take " +hours + " hours");
        Integer receivedValue = caller.convert(hours);
        String result = "Let it be " + receivedValue + " story points";
        System.out.println(result);
        return result;
    }



    private final int[] time = {1,3,6,15,80};

    private int generateTime() {
        return time[new Random().nextInt(time.length)];
    }

}
