package org.apns.micro.core;

/**
 * @author Robert Andruschow
 */
public interface ApnsManagementMBean {

    String getName();

    String getExpiryDateOfCertOnDisk();

    String getStartDateOfCertOnDisk();

    String getSubject();

    String getFullCertFilePath();

    String sendNotification(String deviceId, String message);
}
