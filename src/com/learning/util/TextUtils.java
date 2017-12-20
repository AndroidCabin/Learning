package com.learning.util;

/**
 * @author  Ivan on 2017-12-20 23:30.
 * @version v0.1
 * @since   v1.0
 */

public class TextUtils {

    /**
     * Returns whether the given CharSequence contains only digits.
     */
    public static boolean isDigitsOnly(CharSequence str) {
        final int len = str.length();
        for (int cp, i = 0; i < len; i += Character.charCount(cp)) {
            cp = Character.codePointAt(str, i);
            if (!Character.isDigit(cp)) {
                return false;
            }
        }
        return true;
    }
}
