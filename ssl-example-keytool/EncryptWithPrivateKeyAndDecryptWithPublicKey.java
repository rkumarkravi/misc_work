import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import javax.crypto.Cipher;
import java.security.PublicKey;

public class EncryptWithPrivateKeyAndDecryptWithPublicKey {
    public static void main(String[] args) throws Exception {
        String keystorePath = "keystore.jks";
        char[] keystorePassword = "ravi12345".toCharArray();
        String alias = "mykey";
        String plaintext = "Hello, world!";

        KeyStore keystore = KeyStore.getInstance("JKS");
        keystore.load(new FileInputStream(keystorePath), keystorePassword);

        // Load private key
        PrivateKey privateKey = (PrivateKey) keystore.getKey(alias, keystorePassword);

        // Create Cipher for encryption
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        // Encrypt the plaintext
        byte[] ciphertext = cipher.doFinal(plaintext.getBytes());

        System.out.println("Encrypted Text: \n" + new String(ciphertext));
		
		// Load public key
        Certificate cert = keystore.getCertificate(alias);
        PublicKey publicKey = cert.getPublicKey();

        // Create Cipher for decryption
        cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);

        // Decrypt the ciphertext
        byte[] decryptedText = cipher.doFinal(ciphertext);

        System.out.println("Decrypted Text: \n" + new String(decryptedText));
    }
}
