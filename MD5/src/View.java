import java.util.ArrayList;

public class View {

    ArrayList<User> list = new ArrayList<>();

    public void displayMenu(){
        System.out.println("============ Login Program =========");
        System.out.println("1. Add User");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    public void printMenu(){
        dataMaking();
        while(true){
            displayMenu();
            int choice = Validation.getInt(1,3);
            switch (choice){
                case 1:
                    addUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    return;
            }
        }
    }

    public void dataMaking(){
        if (list.isEmpty()) {
            list.add(new User("vinhng", Validation.MD5Encryption("123"), "thanhvinh", "0123456789", "vinh123@gmail.com", "hanoi", "07/05/2005"));
        }
    }

    public void addUser(){
        System.out.print("Account: ");
        String account = Validation.getUser(list);
        System.out.print("Password: ");
        String password = Validation.getString();
        System.out.print("Name: ");
        String name = Validation.getString();
        System.out.print("Phone: ");
        String phone = Validation.getPhone();
        System.out.print("Email: ");
        String email = Validation.getEmail();
        System.out.print("Address: ");
        String address = Validation.getString();
        System.out.print("DOB: ");
        String dob = Validation.getString();
        User newUser = new User(account, Validation.MD5Encryption(password), name, phone, email, address, dob);
        list.add(newUser);
        System.out.println("User added successfully.");
    }

    public void changePassword(User accountLogin){
        if(Validation.checkYN()){
            System.out.print("Old password: ");
            String oldPassword = Validation.getString();
            if (!Validation.MD5Encryption(oldPassword).equalsIgnoreCase(accountLogin.getPassword())){
                System.out.println("Old password is not correct.");
                return;
            }
            System.out.print("New password: ");
            String newPassword = Validation.getString();
            System.out.print("Re-enter new password: ");
            String reNewPassword = Validation.getString();
            if (!newPassword.equalsIgnoreCase(reNewPassword)){
                System.out.println("Re-entered password does not match new password.");
                return; // Exit if passwords don't match
            }
            accountLogin.setPassword(Validation.MD5Encryption(newPassword));
            System.out.println("Password changed successfully.");
        }
    }

    public void loginUser(){
        if(list.isEmpty()){
            System.out.println("User list is empty.");
            return;
        }
        System.out.print("Account: ");
        String enterAccount = Validation.getString();
        User accountLogin = null;
        for (User user : list) {
            if (user.getUserName().equalsIgnoreCase(enterAccount)) {
                accountLogin = user;
                break;
            }
        }
        if (accountLogin == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.print("Password: ");
        String enterPassword = Validation.getString();
        if (Validation.MD5Encryption(enterPassword).equalsIgnoreCase(accountLogin.getPassword())) {
            System.out.println("------------ Welcome -----------");
            System.out.println("Hi " + accountLogin.getName() + ", do you want to change your password now? Y/N: ");
            changePassword(accountLogin);
            return;
        } else {
            System.out.println("Invalid password.");
        }
//        int attempts = 0;
//        while (attempts < 3) {
//            System.out.print("Password: ");
//            String enterPassword = Validation.getString();
//            if (Validation.MD5Encryption(enterPassword).equalsIgnoreCase(accountLogin.getPassword())) {
//                System.out.println("------------ Welcome -----------");
//                System.out.println("Hi " + accountLogin.getName() + ", do you want to change your password now? Y/N: ");
//                changePassword(accountLogin);
//                return;
//            } else {
//                System.out.println("Invalid password.");
//                attempts++;
//            }
//            if (attempts == 3) {
//                System.out.println("You have entered the wrong password 3 times. Returning to the main menu.");
//                return;
//            }
        }
    }
