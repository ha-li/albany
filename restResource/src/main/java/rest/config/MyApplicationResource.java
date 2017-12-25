package rest.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by hlieu on 10/4/17.
 */
public class MyApplicationResource extends ResourceConfig {
    public MyApplicationResource () {

        packages("rest.resources")
                .register(ObjectMapper.class)      // using the default object mapper
                .register(JacksonFeature.class)    // with jackson (json) support
                .register(MarshallingFeature.class);
    }
}
