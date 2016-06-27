package org.apns.micro;

import org.apns.micro.core.ApnsManagement;
import org.apns.micro.core.ApnsManagementService;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Map;


@Controller
@RequestMapping("/apns")
public class ApnsController {

    @Inject
    ApnsManagementService apnsManagementService;

    @ResponseBody
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    Map<String, ApnsManagement> info() {
        return apnsManagementService.retrieveInfo();
    }

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