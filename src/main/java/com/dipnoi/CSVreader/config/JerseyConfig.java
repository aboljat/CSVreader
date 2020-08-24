package com.dipnoi.CSVreader.config;

import javax.ws.rs.ApplicationPath;
import com.dipnoi.CSVreader.resources.PersonResource;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
@EnableAutoConfiguration
@ApplicationPath("/csvapp")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(PersonResource.class);
        register(MultiPartFeature.class);
    }
}