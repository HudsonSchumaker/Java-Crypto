package br.com.schumaker.crypto;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author Hudson Schumaker
 */
public class HsCipherKey {
    
    private static final String ALGORITHM = "AES";
    
    public String generate256Key() {
        return this.createKey();
    }
    
    private String createKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
            SecureRandom secureRandom = new SecureRandom();
            int keyBitSize = 256;
            keyGenerator.init(keyBitSize, secureRandom);
            
            SecretKey secretKey = keyGenerator.generateKey();
            
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException("Algorithm not supported.");
        }
    }
}
