package org.apns.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main entrance point of the app.
 *
 * @author Robert Andruschow
 */
@EnableAutoConfiguration
@ComponentScan("org.apns.micro")
public class MicroApnsApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MicroApnsApplication.class, args);
    }

}
