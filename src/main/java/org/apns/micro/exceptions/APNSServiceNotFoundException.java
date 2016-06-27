package org.apns.micro.exceptions;

/**
 * Exception that is thrown when no APNS service with the serviceQualifyingName is available.
 *
 * @author Robert Andruschow
 */
public class APNSServiceNotFoundException extends RuntimeException {

    public APNSServiceNotFoundException(String serviceQualifyingName) {
        super("No configuration for push service with qualifying name '" + serviceQualifyingName + "' was found.");
    }
}
