package org.apns.jmx.core;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;
import org.apns.jmx.CertsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;
import java.lang.management.ManagementFactory;

/**
 * @author Robert Andruschow
 */
@Configuration
public class JmxApnsConfiguration {

    private CertsConfiguration certsConfiguration;

    @Inject
    public void setCertsConfiguration(CertsConfiguration certsConfiguration) {
        this.certsConfiguration = certsConfiguration;
    }

    @Bean
    public ApnsManagementBeans apnsManagementBeans() throws Exception {
        ApnsManagementBeans beans = new ApnsManagementBeans();
        for (CertsConfiguration.CertConfiguration cert : certsConfiguration.getCerts()) {
            beans.add(buildAndRegisterApnsManagementBean(cert));
        }
        return beans;
    }

    private ApnsManagement buildAndRegisterApnsManagementBean(CertsConfiguration.CertConfiguration cert) throws Exception {
        ApnsManagement managementBean = new ApnsManagement(
                cert.getFilePath(),
                cert.getPassword(),
                buildApnsService(cert)
        );
        CertObjectName objectName = new CertObjectName(
                managementBean.getFile()
        );
        ManagementFactory.getPlatformMBeanServer().registerMBean(
                managementBean, objectName
        );
        return managementBean;
    }

    public ApnsService buildApnsService(CertsConfiguration.CertConfiguration cert) {
        return APNS.newService()
                .withCert(cert.getFilePath(), cert.getPassword())
                .withSandboxDestination()
                .build();
    }
}
