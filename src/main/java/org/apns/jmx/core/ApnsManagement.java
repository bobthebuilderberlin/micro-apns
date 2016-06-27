package org.apns.jmx.core;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.notnoop.apns.ApnsService;

import java.io.File;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * @author Robert Andruschow
 */
public class ApnsManagement implements ApnsManagementMBean {

    private CertificateFile certificateFile;
    private ApnsService apnsService;

    public ApnsManagement(String filePath, String password, ApnsService apnsService) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        this.certificateFile = new CertificateFile(new File(filePath), password);
        this.apnsService = apnsService;
    }

    @JsonIgnore
    File getFile() {
        return certificateFile.getFile();
    }

    @Override
    public String getName() {
        return certificateFile.getFile().getName();
    }

    /*
     Exposed properties
    */
    @Override
    public String getExpiryDateOfCertOnDisk() {
        return certificateFile.getExpiryDate();
    }

    @Override
    public String getStartDateOfCertOnDisk() {
        return certificateFile.getStartDate();
    }

    @Override
    public String getFullCertFilePath() {
        return certificateFile.getFile().getPath();
    }

    @Override
    public String getSubject() {
        return certificateFile.getSubject();
    }

    @Override
    public String sendNotification(String deviceId, String message) {
        apnsService.push(deviceId, message);
        return "Successfully pushed";
    }
}
