import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class View {
    List<Expense> list = new ArrayList<>();

    public void printMenu(){
        System.out.println("=======Handy Expense program======");
        System.out.println("1. Add an expense");
        System.out.println("2. Display all expenses");
        System.out.println("3. Remove an expense");
        System.out.println("4. Exit");
        System.out.println("Your choice: ");
    }

    public void displayMenu(){
        while (true){
            printMenu();
            int choice = Validation.getInt(1,4);
            switch (choice){
                case 1:
                    addExpense();
                    break;
                case 2:
                    displayAll();
                    break;
                case 3:
                    deleteExpense();
                    break;
                case 4:
                    return;
            }
        }
    }

    public void addExpense(){
        System.out.println("-------- Add an expense--------");
        int id = 1;
        if(!list.isEmpty()){
            id = list.get(list.size() - 1).getID() + 1;
        }
        System.out.print("Enter Date:");
        Date dateInput = Validation.getDate("dd/MM/yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy");
        String date = sdf.format(dateInput);
        System.out.print("Enter Amount:");
        double amount = Validation.getDouble();
        System.out.print("Enter Content:");
        String content = Validation.getString();
        if (date == null || id <= 0 || amount <= 0 || content == null || content.isEmpty()) {
            System.out.println("Add failed");
        }
        list.add(new Expense(id,date,amount,content ));
        System.out.println("Add successfully");
    }

    public void displayAll(){
        if (list == null || list.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        System.out.println("---------Display all expenses------------");
        System.out.println("ID \t Date \t\t Amount \t\t Content");
        double total = 0;
        for (Expense i : list){
            System.out.println(i.getID() + "\t" + i.getDate() + "\t\t" + i.getAmount() + "\t\t" + i.getContent());
            total += i.getAmount();
        }
        System.out.println("Total:\t\t\t\t" + total);
    }

    public void deleteExpense(){
        if (list == null || list.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        System.out.println("--------Delete an expense------");
        System.out.print("Enter ID:");
        int idDel = Validation.getInt(1,Integer.MAX_VALUE);
        Expense expToDel = null;
        boolean idIsExist = false;
        for (Expense i : list){
            if(i.getID() == idDel){
                expToDel = i;
                idIsExist = true;
                break;
            }
        }
        if(!idIsExist){
            System.out.println("ID not found");
        }
        boolean delOk = Controller.checkDeleteExpense(list, expToDel);
        if(delOk){
            System.out.println("Delete successfully");
        }
        else {
            System.out.println("Delete failed");
        }
    }

}

