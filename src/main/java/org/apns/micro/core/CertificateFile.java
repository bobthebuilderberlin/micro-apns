package org.apns.micro.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @author Robert Andruschow
 */
class CertificateFile {

    private static final String KEYSTORE_TYPE = "PKCS12";

    private final File file;
    private X509Certificate certificate;

    CertificateFile(File file, String password) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        this.file = file;
        this.certificate = loadX509Certificate(password);
    }

    private X509Certificate loadX509Certificate(String password) throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException {
        KeyStore keyStore = getKeyStore(password);
        return (X509Certificate) keyStore.getCertificate(
                keyStore.aliases().nextElement()
        );
    }

    private KeyStore getKeyStore(String password)
            throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException {
        KeyStore keyStore = KeyStore.getInstance(KEYSTORE_TYPE);
        keyStore.load(new FileInputStream(file), password.toCharArray());
        return keyStore;
    }

    public File getFile() {
        return file;
    }

    String getExpiryDate() {
        return certificate.getNotAfter().toString();
    }

    String getStartDate() {
        return certificate.getNotBefore().toString();
    }

    String getSubject() {
        return certificate.getSubjectX500Principal().toString();
    }
}
