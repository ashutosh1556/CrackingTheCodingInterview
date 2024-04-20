package strings;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.Objects;

public class HasUniqueCharacters {

    private static boolean hasUniqueCharactersUsingBooleanArray(String str) {

        if (Objects.isNull(str)) return false;
        if (str.isEmpty()) return false;
        if (str.length() > 128) return false;

        str = str.trim().toLowerCase();
        boolean hasUniqueCharacters = true;
        boolean[] characterArray = new boolean[128];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (characterArray[ch]) {
                return false;
            }
            characterArray[ch] = true;
        }
        return hasUniqueCharacters;
    }

    private static boolean hasUniqueCharactersUsingBitSet(String str) {

        if (Objects.isNull(str)) return false;
        if (str.isEmpty()) return false;
        if (str.length() > 128) return false;

        str = str.trim().toLowerCase();
        BitSet seen = new BitSet(128);

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (seen.get(c)) {
                return false;
            }
            seen.set(c);
        }

        return true;
    }

    public static void main(String[] args) {
        List<String> sampleStrings = Arrays.asList("aaa", "abc", "abcbd", "", "abc123", null);
        for (String str : sampleStrings)
            System.out.println("String '" + str + "' : " + hasUniqueCharactersUsingBitSet(str));
    }
}