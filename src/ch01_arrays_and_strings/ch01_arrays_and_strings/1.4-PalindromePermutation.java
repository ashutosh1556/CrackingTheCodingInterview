package ch01_arrays_and_strings;

import java.util.HashMap;

class PalindromePermutation {

  private static boolean isStringPalindromPermutation(String string) {
    // Handle null input
    if (string == null) {
      return false;
    }

    // Handle empty string or string with only spaces
    if (string.trim().isEmpty()) {
      return true;
    }

    HashMap<Character, Integer> charCount = new HashMap<>();

    // Count occurrences of each character, ignoring spaces and case
    for (char c : string.toLowerCase().toCharArray()) {
      if (c == ' ') continue;
      charCount.merge(c, 1, Integer::sum);
    }

    // If no characters were counted (e.g. all spaces), return true
    if (charCount.isEmpty()) {
      return true;
    }

    // Count characters with odd occurrences
    int oddCount = 0;
    for (Integer value : charCount.values()) {
      if (value % 2 == 1) {
        oddCount++;
      }
    }

    // A palindrome permutation can have at most one character with odd occurrences
    return oddCount <= 1;
  }

  public static void main(String[] args) {
    // Test cases for palindrome permutation
    System.out.println("Test 1 - Basic palindrome permutation:");
    System.out.println(isStringPalindromPermutation("tact coa")); // Should return true - can form "taco cat"

    System.out.println("\nTest 2 - Simple palindrome:");
    System.out.println(isStringPalindromPermutation("racecar")); // Should return true

    System.out.println("\nTest 3 - Case insensitive test:");
    System.out.println(
      isStringPalindromPermutation("Able was I ere I saw Elba")
    ); // Should return true

    System.out.println("\nTest 4 - Non-palindrome:");
    System.out.println(isStringPalindromPermutation("hello world")); // Should return false

    System.out.println("\nTest 5 - Empty string:");
    System.out.println(isStringPalindromPermutation("")); // Should return true

    System.out.println("\nTest 6 - Single character:");
    System.out.println(isStringPalindromPermutation("a")); // Should return true

    System.out.println("\nTest 7 - All spaces:");
    System.out.println(isStringPalindromPermutation("   ")); // Should return true

    System.out.println("\nTest 8 - Special characters:");
    System.out.println(isStringPalindromPermutation("!@#! @#")); // Should return true

    System.out.println("\nTest 9 - Null input:");
    System.out.println(isStringPalindromPermutation(null)); // Should return false
  }
}
