import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String literal = "Hello World  ";
        String strObj = new String("Hello World");

        System.out.println("*** String Functions ***");
        System.out.println("String Object memory: " + strObj.hashCode());
        System.out.println("String Object equals: " + literal.equals(strObj));
        System.out.println("String Concatenation: " + literal.concat(strObj));
        System.out.println("String Length: " + literal.length());     // 11
        System.out.println("String Character : " + literal.charAt(0));   // H
        System.out.println("Substring: " + literal.substring(0, 5)); // Hello
        System.out.println("Substring: " + literal.substring(6));
        System.out.println("Changing Case: " +literal.toUpperCase());
        System.out.println("Changing Case: " +literal.toLowerCase());
        System.out.println("Trimming and Replacing: " +literal.trim().replace(" ", "Java"));
        System.out.println("Checking Equality: " +literal.equals(strObj));
        System.out.println("Checking Concatenation: " +literal.equalsIgnoreCase(strObj));
        System.out.println("Checking Length: " +literal.length());

        // 9. StringBuilder for efficient concatenation
        StringBuilder sb = new StringBuilder();
        sb.append("Hello").append(" ").append("StringBuilder");
        System.out.println("StringBuilder: " + sb.toString());

        // 10. User Input Example
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        scanner.close();

    }
}