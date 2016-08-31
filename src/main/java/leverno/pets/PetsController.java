package leverno.pets;

import java.io.ByteArrayInputStream;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author vern
 */
@RestController
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class PetsController {
    
    final static Logger logger = Logger.getLogger(PetsController.class);
    private Integer healthCheckCount = 0;
    
    @RequestMapping("/health")
    public void health(@Context final HttpServletResponse response) {
        
        healthCheckCount = healthCheckCount + 1;
        ByteArrayInputStream input = new ByteArrayInputStream(healthCheckCount.toString().getBytes());
        
        response.reset();
        response.setHeader("CUSTOM-HEALTH", "health");
        response.setStatus(200);
    }
    
    @RequestMapping(value = "/pets", method = { RequestMethod.POST, RequestMethod.GET })
    public @ResponseBody Pet process(@Context final HttpServletResponse response) {
        
        
        //        logger.info("----> REST request");
        
        Pet result = new Pet();
        result.setType("Dog");
        result.setPrice(11.22);
        
        response.setHeader("CUSTOM-PET", "gotcha");
        response.setStatus(200);
        
        return result;
    }
    
    public static void main(String[] args) {
        SpringApplication.run(PetsController.class, args);
    }
}
