package org.apns.micro;

import org.apns.micro.core.ApnsManagement;
import org.apns.micro.core.ApnsManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.Map;

/**
 * Controller for the /apns/* domain.
 */
@Controller
@RequestMapping("/apns")
public class ApnsController {

    @Inject
    ApnsManagementService apnsManagementService;

    /**
     * Provides basic information about the certificate files(start and expiry dates).
     * @return A Map String->ApnsManagement containing this information per service qualifying name(the name of the cert file)
     */
    @ResponseBody
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    Map<String, ApnsManagement> info() {
        return apnsManagementService.retrieveInfo();
    }

    /**
     * Endpoint for pushing APNS notifications.
     * @param serviceQualifyingName The qualifying name of the service for pushing notifications.
     * @param deviceToken The token of the device to push to.
     * @param message The message to be pushed.
     * @return Success message and HTTP 200 code in case of successful sending of messages. Else, error message and 500 error code..
     */
    @ResponseBody
    @RequestMapping(value = "/push", method = RequestMethod.POST)
    String push(
            @RequestParam String serviceQualifyingName,
            @RequestParam String deviceToken,
            @RequestParam String message
    ) {
        return apnsManagementService.push(serviceQualifyingName, deviceToken, message);
    }
}