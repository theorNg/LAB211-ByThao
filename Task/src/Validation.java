import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static String getString(){
        Scanner sc = new Scanner(System.in);
        while (true){
            String s = sc.nextLine();
            if (!s.isEmpty()){
                return s;
            }
            System.out.println("String must not be empty");
        }
    }

    public static int getInt(int min, int max){
        Scanner sc = new Scanner(System.in);
        while (true){
            try {
                int number = Integer.parseInt(sc.nextLine().trim());
                if(number < min || number > max){
                    throw new NumberFormatException();
                }
                return  number;
            }catch (NumberFormatException e){
                System.out.println("Pleas input again");
            }
        }
    }

    public static double getDoubleFrom(){
        double from = 0;
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                from = Double.parseDouble(sc.nextLine());
                if (from >= 8 && from <= 17.5){
                    if (from % 0.5 == 0){
                        break;
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Please input again");
            }
        }
        return from;
    }

    public static double getDoubleTo(double from){
        double to = 0;
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                to = Double.parseDouble(sc.nextLine());
                if (to >= 8 && to <= 17.5){
                    if (to % 0.5 == 0){
                        if(to > from){
                            break;
                        }
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Please input greater than From");
            }
        }
        return to;
    }

    public static Date getDate(String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        sdf.setLenient(false);
        while (true){
            try {
                String value = getString();
                date = sdf.parse(value);
                Date currentDate = new Date();  // Lấy ngày hiện tại
                if (date.after(currentDate)) {
                    System.out.println("Date is in the future! Please enter a past date.");
                } else {
                    break;  // Nếu ngày hợp lệ, thoát khỏi vòng lặp
                }
            } catch (ParseException e) {
                System.out.println("Date invalid! Please try again.");
            }
        }
        return date;
    }

    public static boolean isLeapYear(int year){
        if(year % 400 == 0 || year % 4 == 0){
            return true;
        } else if (year % 100 == 0) {
            return false;
        }
        return false;
    }

    public static String getDate(){
        String datePattern = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/([0-9]{4})$";
        while(true){
            String s = getString();
            if (s.matches(datePattern)) {
                int day = Integer.parseInt(s.substring(0, 2));
                int month = Integer.parseInt(s.substring(3, 5));
                int year = Integer.parseInt(s.substring(6, 10));
                if (month == 2) {
                    if (isLeapYear(year)) {
                        if (day <= 29) {
                            return s;
                        }
                    } else {
                        if (day <= 28) {
                            return s;
                        }
                    }
                }
                else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    if (day <= 30) {
                        return s;
                    }
                } else {
                    if (day <= 31) {
                        return s;
                    }
                }
            }
            System.out.println("Invalid day");
        }
    }

}
