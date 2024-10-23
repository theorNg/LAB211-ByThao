import java.util.Scanner;

public class Validation {

    public static String getString() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) {
                return s;
            }
            System.out.println("String must not be empty");
        }
    }

    public static int getInt(int min, int max) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int n = Integer.parseInt(getString());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Pleas input again");
            }
        }
    }

    public static double getDouble() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                double number = Double.parseDouble(getString());
                if(number < 0){
                    throw new NumberFormatException();
                }
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Please input again");
            }
        }
    }

    public static double getNumber(){
        System.out.println("Enter number: ");
        double number = getDouble();
        return number;
    }

    public static String getOperator(){
        while(true){
            String operator = getString();
            if(operator.equals("+") || operator.equals("-")
            ||operator.equals("*") || operator.equals("/")
            || operator.equals("^") || operator.equals("=")){
            return operator;
            }
            else{
                System.out.println("Please input +, -, *, / and ^");
                System.out.print("Enter again: ");
            }
        }
    }

}