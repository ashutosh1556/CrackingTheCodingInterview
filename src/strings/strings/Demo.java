package strings;

import java.util.Arrays;

class Demo {

    // Time Complexity: O(n log n) where n is the length of input strings
    // - Converting strings to char arrays: O(n)
    // - Sorting both arrays: O(n log n) 
    // - Comparing arrays: O(n)
    // Overall complexity dominated by the sorting: O(n log n)
static boolean isPermutation(String str1, String str2){
        if (str1 == null || str2 == null) return false;
        if (str1.length() != str2.length()) return false;

        char[] str1Array = str1.toCharArray();
        char[] str2Array = str2.toCharArray();

        Arrays.sort(str1Array);
        Arrays.sort(str2Array);

        return Arrays.equals(str1Array, str2Array);
    }

    public static void main(String[] args) {
        System.out.println("Test Identical Strings: " + isPermutation("abc", "abc")); // true
        System.out.println("Test Simple Permutation: " + isPermutation("abcd", "dcba")); // true
        System.out.println("Test Different Lengths: " + isPermutation("abc", "ab")); // false
        System.out.println("Test Non-Permutation: " + isPermutation("abcd", "abcf")); // false
        System.out.println("Test Empty Strings: " + isPermutation("", "")); // true
        System.out.println("Test Single Character Same: " + isPermutation("a", "a")); // true
        System.out.println("Test Single Character Different: " + isPermutation("a", "b")); // false
        System.out.println("Test Case Sensitivity: " + isPermutation("Abc", "abc")); // false
        System.out.println("Test Long Permutation: " + isPermutation("abcdefgh", "hgfedcba")); // true
        System.out.println("Test Permutation with Repeating Characters: " + isPermutation("aabbcc", "ccbbaa")); // true
        System.out.println("Test Non-Permutation with Repeating Characters: " + isPermutation("aabbcc", "aabbc")); // false
    
    }
}
