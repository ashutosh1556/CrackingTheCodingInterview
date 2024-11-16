package strings;

class Urlify {

// Time Complexity: O(n) where n is the true length of the string
// - First pass to count spaces: O(n)
// - Second pass to replace spaces: O(n)
// Overall time complexity is O(n)

// Space Complexity: O(n) 
// - We create a char array of the input string length
// - No additional data structures are used that grow with input size
// - The space needed is proportional to input string length
  static String replaceSpaces(String str, int trueLength) {
    char[] chars = str.toCharArray();
    int spaceCount = 0;

    // Count spaces
    for (int i = 0; i < trueLength; i++) {
      if (chars[i] == ' ') {
        spaceCount++;
    }

    // Calculate new index
    int newIndex = trueLength + spaceCount * 2;

    // Replace spaces from end
    for (int i = trueLength - 1; i >= 0; i--) {
      if (chars[i] == ' ') {
        chars[newIndex - 1] = '0';
        chars[newIndex - 2] = '2';
        chars[newIndex - 3] = '%';
        newIndex = newIndex - 3;
      } else {
        chars[newIndex - 1] = chars[i];
        newIndex--;
      }
    }

    return new String(chars);
  }

  public static void main(String[] args) {
    // Test case 1: Basic string with spaces
    System.out.println(replaceSpaces("Mr Ashutosh Verma    ", 17));
    
    // Test case 2: String with multiple consecutive spaces
    System.out.println(replaceSpaces("Hello  World      ", 12));
    
    // Test case 3: String with space at start
    System.out.println(replaceSpaces(" Hello World     ", 12));
    
    // Test case 4: String with space at end
    System.out.println(replaceSpaces("Hello World      ", 11));
    
    // Test case 5: String with no spaces
    System.out.println(replaceSpaces("HelloWorld  ", 10));
    
    // Test case 6: Empty string
    System.out.println(replaceSpaces("", 0));
    
    // Test case 7: Single space
    System.out.println(replaceSpaces("   ", 1));  }
}
