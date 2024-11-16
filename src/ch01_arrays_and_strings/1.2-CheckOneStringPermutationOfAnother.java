package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class CheckOneStringPermutationOfAnother {
    
    static boolean checkPrerequisite(String str1, String str2){
        if (str1 == null || str2 == null) return false;
        if (str1.length() != str2.length()) return false;
        return true;
    }
    
    // Time Complexity: O(n log n) where n is the length of input strings
    // - Converting strings to char arrays: O(n)
    // - Sorting both arrays: O(n log n) 
    // - Comparing arrays: O(n)
    // Overall complexity dominated by the sorting: O(n log n)
    static boolean checkPermutationOptimised1(String str1, String str2){
        if(!checkPrerequisite(str1, str2)) return false;
        
        char[] str1Array = str1.toCharArray();
        char[] str2Array = str2.toCharArray();
        
        Arrays.sort(str1Array);
        Arrays.sort(str2Array);
        
        return Arrays.equals(str1Array, str2Array);
    }
    
    static boolean checkPermutationOptimised(String str1, String str2){
        if(!checkPrerequisite(str1, str2)) return false;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            int count = 1;
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch)+1);
            }
            else {
                map.put(ch, count);
            }
        }
        
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch)-1);
            }
        }
        
        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Test Identical Strings: " + checkPermutationOptimised("abc", "abc")); // true
        System.out.println("Test Simple Permutation: " + checkPermutationOptimised("abcd", "dcba")); // true
        System.out.println("Test Different Lengths: " + checkPermutationOptimised("abc", "ab")); // false
        System.out.println("Test Non-Permutation: " + checkPermutationOptimised("abcd", "abcf")); // false
        System.out.println("Test Empty Strings: " + checkPermutationOptimised("", "")); // true
        System.out.println("Test Single Character Same: " + checkPermutationOptimised("a", "a")); // true
        System.out.println("Test Single Character Different: " + checkPermutationOptimised("a", "b")); // false
        System.out.println("Test Case Sensitivity: " + checkPermutationOptimised("Abc", "abc")); // false
        System.out.println("Test Long Permutation: " + checkPermutationOptimised("abcdefgh", "hgfedcba")); // true
        System.out.println("Test Permutation with Repeating Characters: " + checkPermutationOptimised("aabbcc", "ccbbaa")); // true
        System.out.println("Test Non-Permutation with Repeating Characters: " + checkPermutationOptimised("aabbcc", "aabbc")); // false
    
    }
}
