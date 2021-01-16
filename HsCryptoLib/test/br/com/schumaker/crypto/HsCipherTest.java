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
        var tested = new HsCipherKey();
        // test
        var result = tested.generate256Key();
        // assertion
        Assert.assertEquals(44, result.length()); 
    }          
}
