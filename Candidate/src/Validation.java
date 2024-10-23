import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

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

    public static String getPhone(){
        String phone = "^\\d{10}\\d*$";
        while (true){
            String s = getString();
            if(s.matches(phone)){
                return s;
            }
            System.out.println("Phone is number with mininum 10 characters");
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

    public static String getGraduation(){
        while (true){
            String s = getString();
            if(s.equalsIgnoreCase("Exellent")
            || s.equalsIgnoreCase("Good")
            || s.equalsIgnoreCase("Fair")
            || s.equalsIgnoreCase("Poor")){
                return s;
            }
            System.out.println("Please input string: Excellence, Good, Fair, Poor");
            System.out.print("Enter again:");
        }
    }

    public static boolean checkID(ArrayList<Candidate> list, String id){
        for (Candidate i : list){
            if(i.getId().equalsIgnoreCase(id)){
                System.out.println("ID exits");
                return false;
            }
        }
        return true;
    }

    public static int checkExperience(int date){
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int age = yearCurrent - date;
        while (true){
            int yearExperience = getInt(1,100);
            if(yearExperience <= age){
                return yearCurrent;
            }
            else {
                System.out.println("Experience must be smaller than or equal to age");
            }
        }
    }

}
