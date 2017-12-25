package rest.provider;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

/**
 * Created by hlieu on 10/4/17.
 */
@Provider
@Produces({MediaType.APPLICATION_JSON})
public class CustomJacksonJsonProvider extends JacksonJsonProvider {
    private static ObjectMapper OBJ_MAPPER = new ObjectMapper ();

    static {
        OBJ_MAPPER.configure (DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .enable(SerializationFeature.INDENT_OUTPUT);

    }

    public CustomJacksonJsonProvider () {
        super();
        setMapper(OBJ_MAPPER);
    }
}
