import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;

public class LoadPrivateKeyFromKeystore {
    public static void main(String[] args) throws Exception {
        String keystorePath = "path/to/keystore.jks";
        char[] keystorePassword = "ravi12345".toCharArray();
        String alias = "mykey";

        KeyStore keystore = KeyStore.getInstance("JKS");
        keystore.load(new FileInputStream(keystorePath), keystorePassword);

        // Load private key
        PrivateKey privateKey = (PrivateKey) keystore.getKey(alias, keystorePassword);

        // Use the private key for cryptographic operations
        // For example, you can use it for signing data using a Signature object.
    }
}
