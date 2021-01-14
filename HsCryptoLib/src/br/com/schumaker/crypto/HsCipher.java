package br.com.schumaker.crypto;

import java.util.Random;

/**
 *
 * @author Hudson Schumaker
 */
public class HsCipher {

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
    
    public String generate64Key() {
        return createKey(64);
    }
    
    public String generate128Key() {
        return createKey(128);
    }
    
    public String generate256Key() {
        return createKey(256);
    }

    private String createKey(final int size) {
        final Random r = new Random(System.currentTimeMillis());
        final char[] id = new char[size];
        for (int i = 0; i < size; ++i) {
            id[i] = HsCipher.CHARS[r.nextInt(HsCipher.CHARS.length)];
        }
        return new String(id);
    }
}
