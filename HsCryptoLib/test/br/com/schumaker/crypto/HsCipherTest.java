package br.com.schumaker.crypto;

import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Hudson Schumaker
 */
public class HsCipherTest {
    
    @Test
    public void testGenerate16Key() {
        // preparation
        var tested = new HsCipher();
        // test
        var result = tested.generate16Key();
        // assertion
        Assert.assertEquals(16, result.length()); 
    }
    
    @Test
    public void testGenerate32Key() {
        // preparation
        var tested = new HsCipher();
        // test
        var result = tested.generate32Key();
        // assertion
        Assert.assertEquals(32, result.length()); 
    }
            
}
