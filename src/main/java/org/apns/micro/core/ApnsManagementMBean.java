package org.apns.micro.core;

/**
 * Interface for exposing ApnsManagement via JMX.
 *
 * @author Robert Andruschow
 */
interface ApnsManagementMBean {

    String getName();

    String getExpiryDateOfCertOnDisk();

    String getStartDateOfCertOnDisk();

    String getSubject();

    String getFullCertFilePath();

    String sendNotification(String deviceId, String message);
}
