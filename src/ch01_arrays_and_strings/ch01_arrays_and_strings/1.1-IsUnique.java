package ch01_arrays_and_strings;

class IsUnique {

  static boolean hasUniqueCharacters(String str) {
    // Handle edge cases
    if (str == null || str.length() < 1) {
      return false;
    }

    // If string length exceeds ASCII character set size,
    // it must have duplicates
    if (str.length() > 128) {
      return false;
    }

    // Create boolean array for character set
    // Default values are false
    boolean[] charSet = new boolean[128];

    for (int i = 0; i < str.length(); i++) {
      char currentChar = str.charAt(i);

      // If character already seen, return false
      if (charSet[currentChar]) {
        return false;
      }

      // Mark character as seen
      charSet[currentChar] = true;
    }

    return true;
  }

  public static void main(String[] args) {
    // Test cases for ASCII solution
    System.out.println("ASCII character set tests:"); // Print header for test cases
    System.out.println(hasUniqueCharacters("abcde")); // Test string with all unique lowercase letters
    System.out.println(hasUniqueCharacters("abcda")); // Test string with duplicate 'a' character
    System.out.println(hasUniqueCharacters("   ")); // Test string with multiple spaces
    System.out.println(hasUniqueCharacters("")); // Test empty string
    System.out.println(hasUniqueCharacters(null)); // Test null input
    System.out.println(hasUniqueCharacters("Ab1")); // Test string with mixed case and number
    System.out.println(hasUniqueCharacters("!@#$")); // Test string with special characters
  }
}
