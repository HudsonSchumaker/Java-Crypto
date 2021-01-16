package br.com.schumaker.crypto;

import java.util.Random;

/**
 *
 * @author Hudson Schumaker
 */
public class HsCipherKey {

    private static final char[] CHARS;

    static {
        CHARS = "@!§$%&()=?{[]}+-<>abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
    }

    public String generate16Key() {
        return createKey(16);
    }
    
    public String generate32Key() {
        return createKey(32);
    }
    
    private String createKey(final int size) {
        final Random r = new Random(System.currentTimeMillis());
        final char[] key = new char[size];
        for (int i = 0; i < size; ++i) {
            key[i] = HsCipherKey.CHARS[r.nextInt(HsCipherKey.CHARS.length)];
        }
        return new String(key);
    }
}
