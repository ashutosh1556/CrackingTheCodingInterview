package strings;

class Urlify {

  static String replaceSpaces(String str, int trueLength) {
    char[] chars = str.toCharArray();
    int spaceCount = 0;

    // Count spaces
    for (int i = 0; i < trueLength; i++) {
      if (chars[i] == ' ') {
        spaceCount++;
      }
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
    System.out.println(replaceSpaces("Mr Ashutosh Verma    ", 17));
  }
}
