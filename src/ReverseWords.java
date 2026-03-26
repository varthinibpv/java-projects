public class ReverseWords {
    public static String reverseWords(String s) {
        // Remove leading/trailing spaces and split by one or more spaces
        String[] words = s.trim().split("\\s+");

        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        String str = "  Hello   World  Java  ";
        System.out.println("'" + reverseWords(str) + "'");
        // Output: 'Java World Hello'
    }
}