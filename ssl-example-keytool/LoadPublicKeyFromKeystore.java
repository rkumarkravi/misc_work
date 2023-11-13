import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.cert.Certificate;

public class LoadPublicKeyFromKeystore {
    public static void main(String[] args) throws Exception {
        String keystorePath = "path/to/keystore.jks";
        char[] keystorePassword = "ravi12345".toCharArray();
        String alias = "mykey";

        KeyStore keystore = KeyStore.getInstance("JKS");
        keystore.load(new FileInputStream(keystorePath), keystorePassword);

        // Load public key
        Certificate cert = keystore.getCertificate(alias);
        PublicKey publicKey = cert.getPublicKey();

        // Use the public key for cryptographic operations
        // For example, you can use it for verifying a signature using a Signature object.
    }
}
