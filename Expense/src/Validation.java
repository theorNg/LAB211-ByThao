import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

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

    public static double getDouble(){
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                return Double.parseDouble(sc.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Please input again");
            }
        }
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

}
