package ch01_arrays_and_strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Class to check if one string is a permutation of another string.
 * A permutation is a rearrangement of letters where the frequency of each character remains the same.
 */
class CheckPermutation {

  /**
   * Checks prerequisite conditions for permutation check
   * @param str1 First input string
   * @param str2 Second input string
   * @return true if prerequisite conditions are met, false otherwise
   */
  static boolean checkPrerequisite(String str1, String str2) {
    if (str1 == null || str2 == null) return false;
    if (str1.length() != str2.length()) return false;
    return true;
  }

  /**
   * Checks if two strings are permutations using sorting approach
   * Time Complexity: O(n log n) where n is the length of input strings
   * - Converting strings to char arrays: O(n)
   * - Sorting both arrays: O(n log n)
   * - Comparing arrays: O(n)
   * Overall complexity dominated by the sorting: O(n log n)
   * Space Complexity: O(n) for the character arrays
   * @param str1 First input string
   * @param str2 Second input string
   * @return true if strings are permutations, false otherwise
   */
  static boolean checkPermutationOptimised1(String str1, String str2) {
    if (!checkPrerequisite(str1, str2)) return false;

    char[] str1Array = str1.toCharArray();
    char[] str2Array = str2.toCharArray();

    Arrays.sort(str1Array);
    Arrays.sort(str2Array);

    return Arrays.equals(str1Array, str2Array);
  }

  /**
   * Checks if two strings are permutations using hash map approach
   * Time Complexity: O(n) where n is the length of input strings
   * Space Complexity: O(k) where k is the number of unique characters
   * @param str1 First input string
   * @param str2 Second input string
   * @return true if strings are permutations, false otherwise
   */
  static boolean checkPermutationOptimised(String str1, String str2) {
    if (!checkPrerequisite(str1, str2)) return false;

    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < str1.length(); i++) {
      char ch = str1.charAt(i);
      int count = 1;
      if (map.containsKey(ch)) {
        map.put(ch, map.get(ch) + 1);
      } else {
        map.put(ch, count);
      }
    }

    for (int i = 0; i < str2.length(); i++) {
      char ch = str2.charAt(i);
      if (map.containsKey(ch)) {
        map.put(ch, map.get(ch) - 1);
      }
    }

    for (Integer value : map.values()) {
      if (value != 0) {
        return false;
      }
    }

    return true;
  }

  /**
   * Main method with test cases
   * @param args command line arguments (not used)
   */
  public static void main(String[] args) {
    System.out.println(
      "Test Identical Strings: " + checkPermutationOptimised("abc", "abc")
    ); // true
    System.out.println(
      "Test Simple Permutation: " + checkPermutationOptimised("abcd", "dcba")
    ); // true
    System.out.println(
      "Test Different Lengths: " + checkPermutationOptimised("abc", "ab")
    ); // false
    System.out.println(
      "Test Non-Permutation: " + checkPermutationOptimised("abcd", "abcf")
    ); // false
    System.out.println(
      "Test Empty Strings: " + checkPermutationOptimised("", "")
    ); // true
    System.out.println(
      "Test Single Character Same: " + checkPermutationOptimised("a", "a")
    ); // true
    System.out.println(
      "Test Single Character Different: " + checkPermutationOptimised("a", "b")
    ); // false
    System.out.println(
      "Test Case Sensitivity: " + checkPermutationOptimised("Abc", "abc")
    ); // false
    System.out.println(
      "Test Long Permutation: " +
      checkPermutationOptimised("abcdefgh", "hgfedcba")
    ); // true
    System.out.println(
      "Test Permutation with Repeating Characters: " +
      checkPermutationOptimised("aabbcc", "ccbbaa")
    ); // true
    System.out.println(
      "Test Non-Permutation with Repeating Characters: " +
      checkPermutationOptimised("aabbcc", "aabbc")
    ); // false
  }
}
