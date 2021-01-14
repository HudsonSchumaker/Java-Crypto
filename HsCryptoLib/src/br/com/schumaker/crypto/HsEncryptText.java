package br.com.schumaker.crypto;

import java.security.Key;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Hudson Schumaker
 */
public class HsEncryptText {
    
    public void encrypt(final String key, final String inputText,  String outputText) {
        this.doCrypto(1, key, inputText, outputText);
    }
    
    private void doCrypto(final int cipherMode, final String key, String inputText, String outputText) {
        try {
            final Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
            final Cipher cipher = Cipher.getInstance("AES");
            cipher.init(cipherMode, secretKey);
            final byte[] outputBytes = cipher.doFinal(inputText.getBytes());
            outputText = Arrays.toString(outputBytes);
        } catch (Exception ex) {
            throw new RuntimeException("Error", ex);
        }
    }
}
