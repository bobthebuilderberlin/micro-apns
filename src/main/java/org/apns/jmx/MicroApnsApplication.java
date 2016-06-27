package org.apns.jmx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Robert Andruschow
 */
@EnableAutoConfiguration
@ComponentScan("org.apns.jmx")
public class MicroApnsApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MicroApnsApplication.class, args);
    }

}
