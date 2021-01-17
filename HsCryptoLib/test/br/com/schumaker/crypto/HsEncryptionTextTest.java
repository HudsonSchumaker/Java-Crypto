package br.com.schumaker.crypto;

import org.junit.Assert;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Hudson Schumaker
 */
public class HsEncryptionTextTest {

    @Test
    public void testEncrypt() {
        // preparation
        var keyGen = new HsCipherKey();
        var key32 = keyGen.generate256Key();
        var tested = new HsEncryptionText();
        var text = "hello you";

        // test
        var result = tested.encrypt(key32, text);

        // assertion
        assertNotNull(result);
        assertNotEquals(text, result);
    }

    @Test
    public void testDecrypt() {
        // preparation
        var keyGen = new HsCipherKey();
        var key = keyGen.generate256Key();
        var tested = new HsEncryptionText();
        var text = "hello you fool!!";

        var encryptedText = tested.encrypt(key, text);

        // test        
        var result = tested.decrypt(key, encryptedText);
        
        // assertion
        Assert.assertEquals(text, result);
    }
}
