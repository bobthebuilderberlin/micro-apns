package org.apns.micro.core;

import org.apns.micro.ApnsController;
import org.apns.micro.exceptions.APNSServiceNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Service providing business logic for the {@link org.apns.micro.ApnsController}.
 *
 * @author Robert Andruschow
 */
@Service
public class ApnsManagementService {

    @Inject
    ApnsManagementBeans apnsManagementBeans;

    /**
     * Business logic for the {@link ApnsController#info()} endpoint.
     */
    public Map<String, ApnsManagement> retrieveInfo() {
        Map<String, ApnsManagement> result = new LinkedHashMap<String, ApnsManagement>();
        for (ApnsManagement cert : apnsManagementBeans) {
            result.put(cert.getFile().getName(), cert);
        }
        return result;
    }

    /**
     * Business logic for the {@link ApnsController#push()} endpoint.
     * Pushes APNS messages.
     */
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
