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
        var result = tested.generate16Key();
        // assertion
        Assert.assertEquals(16, result.length()); 
    }
    
    @Test
    public void testGenerate32Key() {
        // preparation
        var tested = new HsCipherKey();
        // test
        var result = tested.generate32Key();
        // assertion
        Assert.assertEquals(32, result.length()); 
    }
    
    @Test
    public void testGenerate64Key() {
        // preparation
        var tested = new HsCipherKey();
        // test
        var result = tested.generate64Key();
        // assertion
        Assert.assertEquals(64, result.length()); 
    }
    
    @Test
    public void testGenerate128Key() {
        // preparation
        var tested = new HsCipherKey();
        // test
        var result = tested.generate128Key();
        // assertion
        Assert.assertEquals(128, result.length()); 
    }
    
    @Test
    public void testGenerate256Key() {
        // preparation
        var tested = new HsCipherKey();
        // test
        var result = tested.generate128Key();
        // assertion
        Assert.assertEquals(256, result.length()); 
    }
            
}
