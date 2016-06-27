package org.apns.micro.core;

import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import java.io.File;

/**
 * @author Robert Andruschow
 */
class CertObjectName extends ObjectName {

    public CertObjectName(File file) throws MalformedObjectNameException {
        super("org.jmx.apns.mbean:type=ApnsCertificateManagement-" + file.getName());
    }
}
