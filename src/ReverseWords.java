import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Stack;

public class ReverseWords {
    public static String reverseWords(String str) {
        //String reversed = new StringBuilder(str).reverse().toString();
       String reversed = "";
       for(int i= str.length()-1;i>=0;i--){
           reversed = reversed + str.charAt(i);
       }
        return reversed;
    }
    public static int reverseNumber(int number) {
        int reverse = 0;
        Scanner sc = new Scanner(System.in);
        while (number != 0) {
            int digit = number % 10;
            reverse = reverse * 10 + digit;
            number = number / 10;
        }
        return reverse;
    }
    public static String reverse(String str) {
        if (str.isEmpty()) return str;
        return reverse(str.substring(1)) + str.charAt(0);
    }
    public static int[] getArray(int count) {
        int[] arr = new int[count];
        return arr;
    }


    public static void main(String[] args) {
        String str, str1;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter an option[1 to 10]: ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Enter a number: ");
                    int number = sc.nextInt();
                    System.out.print("Reversed a Number: " + reverseNumber(number));
                    break;
                case 2:
                    System.out.print("Enter a word to remove spaces from both ends: ");
                    str = sc.next();
                    System.out.println("Word without spaces :" + str.trim());
                    break;
              case 3:
                  System.out.print("Enter 2 words to compare: ");
                  str = sc.next();
                  str1 = sc.next();
                  System.out.println("Compared status: " + 3str1.compareTo(str));
                  break;
            case 4:
                System.out.println("Using StringBuilder to reverse a word: ");
                System.out.print("Enter a word to reverse: ");
                str = sc.next();
                String reversed = new StringBuilder(str).reverse().toString();
                System.out.println("Reversed String: " + reversed);
                break;
            case 5:
                System.out.println("Using a for loop (manual approach)");
                System.out.print("Enter a word to reverse: ");
                str = sc.next();
                String rever = "";
                for (int i = str.length() - 1; i >= 0; i--) {
                    rever += str.charAt(i);
                }
                System.out.println("Reversed String: " + rever);
                break;
            case 6:
                System.out.println("Using a char array (two-pointer swap)");
                System.out.print("Enter a word to reverse: ");
                str = sc.next();
                char[] arr = str.toCharArray();

                int left = 0, right = arr.length - 1;
                while (left < right) {
                    char temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    left++;
                    right--;
                }
                System.out.println("Reversed String: " + new String(arr));
                break;
            case 7:
                System.out.println("String reverse Using recursion");
                System.out.print("Enter a word to reverse: ");
                str = sc.next();
                System.out.println("Reversed String : " + reverse(str));
                break;
            case 8:
                System.out.println("String reverse Using Java 8 Streams");
                System.out.print("Enter a word to reverse: ");
                str = sc.next();
                String rev = new StringBuilder(
                        str.chars()
                                .mapToObj(c -> (char) c)
                                .collect(Collectors.toList())
                                .toString()
                ).reverse().toString();
                System.out.println("Reversed String : " + rev);
                break;
            case 9:
                System.out.println("String Reverse Using Stack");
                System.out.print("Enter a word to reverse: ");
                str = sc.next();
                Stack<Character> stack = new Stack<>();

                for (char c : str.toCharArray()) {
                    stack.push(c);
                }

                String rev1 = "";
                while (!stack.isEmpty()) {
                    rev1 += stack.pop();
                }

                System.out.println("Reversed String : " + rev1);
                break;
            case 10:
                System.out.println("String reverse Without using built-in reverse (optimized with StringBuilder)");
                System.out.print("Enter a word to reverse: ");
                str = sc.next();
                StringBuilder reverse = new StringBuilder();

                for (int i = str.length() - 1; i >= 0; i--) {
                    reverse.append(str.charAt(i));
                }

                System.out.println("Reversed String : " + reverse.toString());
                break;
                default:
                    System.out.println("Invalid option");
            }
            System.out.println("Do you want to continue? (yes/no): ");
        } while (sc.next().equalsIgnoreCase("yes"));
        System.out.println("Program ended.");
        sc.close();
    }
}