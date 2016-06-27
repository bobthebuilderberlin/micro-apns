package org.apns.micro;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Class representing configuration for cert files, found in application.yml
 * See application-template.yml for an example.
 *
 * @author Robert Andruschow
 */
@ConfigurationProperties(prefix = "apns.jmx")
@Configuration
public class CertsConfiguration {


    private List<CertConfiguration> certs;

    public List<CertConfiguration> getCerts() {
        return certs;
    }

    public void setCerts(List<CertConfiguration> certs) {
        this.certs = certs;
    }

    public static class CertConfiguration {

        private String filePath;
        private String password;

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
