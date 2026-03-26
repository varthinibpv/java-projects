//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String literal = "Hello World";
        String strObj = new String("Hello World");

        System.out.println("*** String Functions ***");

        System.out.println("String literal : " + literal);
        System.out.println("String Object : " + strObj);

        System.out.println("String Object memory: " + strObj.hashCode());
        System.out.println("String Object equals: " + literal.equals(strObj));
    }
}