import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.bind.DatatypeConverter;

public class Validation {

    public static int getInt(int min, int max){
        Scanner sc = new Scanner(System.in);
        while (true){
            int number = Integer.parseInt(sc.nextLine().trim());
            try{
                if(number > max || number < min){
                    throw new NumberFormatException();
                }
                return number;
            }catch (NumberFormatException e){
                System.out.println("Please input again");
            }
        }
    }

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

    public static String getPhone(){
        String phone = "^\\d{9,10}$";
        while (true){
            String s = getString();
            if(s.matches(phone)){
                return s;
            }
            System.out.println("Phone is number with 10 characters");
            System.out.print("Enter again:");
        }
    }

    public static String getEmail(){
        String email = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";
        while(true){
            String s = getString();
            if (s.matches(email)){
                return s;
            }
            System.out.println("Email with format <account name>@<domain>");
            System.out.print("Enter again:");
        }
    }

    public static String getUser(ArrayList<User> list){
        while(true){
            String s = getString();
            boolean accountExists = false;
            for (User i : list){
                if(i.getUserName().contains(s)){
                    accountExists = true;
                    System.out.println("User exits");
                    System.out.println("Please enter another account");
                    break;
                }
            }
            if (!accountExists){
                return s;
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

    public static String MD5Encryption(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            return DatatypeConverter.printHexBinary(md.digest()).toLowerCase();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
