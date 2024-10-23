import java.util.ArrayList;
import java.util.Scanner;

public class Validation {
    public static String getString(){
        Scanner sc = new Scanner(System.in);
        while(true){
            String s = sc.nextLine().trim();
            if(!s.isEmpty()){
                return s;
            }
            System.out.println("Please input again");
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

    public static boolean checkYN(){
        Scanner sc = new Scanner(System.in);
        while(true){
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("Y")){
                return true;
            }
            if (s.equalsIgnoreCase("N")){
                return false;
            }
            System.out.println("Please input Y or N");
        }
    }
}
