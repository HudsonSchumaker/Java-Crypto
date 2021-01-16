package br.com.schumaker.crypto;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Hudson Schumaker
 */
public class HsEncryptionText {
    
    private static final String ALGORITHM = "AES";
    
    public String encrypt(final String key, final String inputText) {
        return this.doEncrypt(key, inputText);
    }
    
    public String decrypt(final String key, final String inputText) {
        return this.doDecrypt(key, inputText);
    }
    
    private String doEncrypt(final String key, String inputText) {
        try {
            final Key secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), ALGORITHM);
            final Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            final byte[] outputBytes = cipher.doFinal(inputText.getBytes(StandardCharsets.UTF_8));
            
            return Base64.getEncoder().encodeToString(outputBytes);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException 
                | IllegalBlockSizeException | NoSuchPaddingException ex) {
            throw new RuntimeException("Encrypt Error", ex);
        }
    }
    
    private String doDecrypt(final String key, String inputText) {
        try {
            final Key secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), ALGORITHM);
            final Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            final byte[] outputBytes = cipher.doFinal(Base64.getDecoder().decode(inputText));
            
            return new String(outputBytes);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException 
                | IllegalBlockSizeException | NoSuchPaddingException ex) {
            throw new RuntimeException("Decrypt Error", ex);
        }
    }
}
