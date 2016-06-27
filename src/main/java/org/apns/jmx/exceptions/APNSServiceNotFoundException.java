package org.apns.jmx.exceptions;

/**
 * @author Robert Andruschow
 */
public class APNSServiceNotFoundException extends RuntimeException {

    public APNSServiceNotFoundException(String serviceQualifyingName) {
        super("No configuration for push service with qualifying name '" + serviceQualifyingName + "' was found.");
    }
}
