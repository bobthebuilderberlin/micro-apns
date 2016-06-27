package org.apns.jmx.core;

import org.apns.jmx.exceptions.APNSServiceNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author Robert Andruschow
 */
@Service
public class ApnsManagementService {

    @Inject
    ApnsManagementBeans apnsManagementBeans;

    public Map<String, ApnsManagement> retrieveInfo() {
        Map<String, ApnsManagement> result = new LinkedHashMap<String, ApnsManagement>();
        for (ApnsManagement cert : apnsManagementBeans) {
            result.put(cert.getFile().getName(), cert);
        }
        return result;
    }

    public String push(String serviceQualifyingName, String deviceToken, String message) {
        for (ApnsManagement cert : apnsManagementBeans) {
            if (cert.getFile().getName().equals(serviceQualifyingName)) {
                cert.sendNotification(deviceToken, message);
                return "Successfully sent message to device " + deviceToken;
            }
        }
        //Throw exception causing 500 status code and rendering error as JSON.
        throw new APNSServiceNotFoundException(serviceQualifyingName);
    }

}
