package br.com.schumaker.crypto;

import org.junit.Assert;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Hudson Schumaker
 */
public class HsEncryptTextTest {
    @Test
    public void testEncrypt() {
        // preparation
        var keyGen = new HsCipherKey();
        var key = keyGen.generate32Key();
        var tested = new HsEncryptText();
        var text = "hello you";
        
        // test
        var result = tested.encrypt(key, text);
        
        // assertion
        System.out.println(result);
        assertNotNull(result);
        assertNotEquals(text, result);
    }
}
