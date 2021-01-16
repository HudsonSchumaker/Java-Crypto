package br.com.schumaker.crypto;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
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
        return this.doCrypto(Cipher.ENCRYPT_MODE, key, inputText);
    }
    
    private String doCrypto(final int cipherMode, final String key, String inputText) {
        try {
            final Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            final Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(cipherMode, secretKey);
            final byte[] outputBytes = cipher.doFinal(inputText.getBytes());
            return new String(outputBytes, "UTF8");
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException 
                | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
            throw new RuntimeException("Encrypt error", ex);
        }
    }
}
