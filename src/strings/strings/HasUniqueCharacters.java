package strings;

class HasUniqueCharacters {
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
        System.out.println("ASCII character set tests:");
        System.out.println(hasUniqueCharacters("abcde")); // true
        System.out.println(hasUniqueCharacters("abcda")); // false
        System.out.println(hasUniqueCharacters("   ")); // false
        System.out.println(hasUniqueCharacters("")); // false
        System.out.println(hasUniqueCharacters(null)); // false
        System.out.println(hasUniqueCharacters("Ab1")); // true
        System.out.println(hasUniqueCharacters("!@#$")); // true
        
}

}
