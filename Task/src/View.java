import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class View {
    List<Task> list = new ArrayList<>();

    public void printMenu(){
        System.out.println("=======Task program======");
        System.out.println("1. Add a task");
        System.out.println("2. Delete task");
        System.out.println("3. Display all tasks");
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
                case 3:
                    displayAll();
                    break;
                case 2:
                    deleteExpense();
                    break;
                case 4:
                    return;
            }
        }
    }

    public void addExpense(){
        System.out.println("-------- Add a task--------");
        int id = 1;
        if(!list.isEmpty()){
            id = list.get(list.size() - 1).getID() + 1;
        }
        System.out.print("Requirement Name:");
        String requirementName = Validation.getString();
        System.out.print("Task Type:");
        int taskType = Validation.getInt(1,4);
        System.out.print("Date:");
        Date dateInput = Validation.getDate("dd/MM/yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy");
        String date = sdf.format(dateInput);
        System.out.print("From:");
        double from = Validation.getDoubleFrom();
        System.out.print("To:");
        double to = Validation.getDoubleTo(from);
        System.out.print("Assignee:");
        String assignee = Validation.getString();
        System.out.print("Reviewer:");
        String reviewer = Validation.getString();
        if (id <= 0 || from <= 0 || to <= 0 || requirementName.isEmpty() || taskType <= 0 || assignee.isEmpty() || reviewer.isEmpty()) {
            System.out.println("Add failed");
        }
        else{
            list.add(new Task(id,taskType,requirementName,date,from,to,assignee,reviewer));
            System.out.println("Add successfully");

        }
    }

    public void displayAll(){
        if (list == null || list.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        System.out.println("---------Task------------");
        System.out.println("ID \t Name \t\t\t Task Type \t\t Date \t\t\t Time \t\t\t Assignee \t\t\t Reviewer");
        for (Task i : list){
            System.out.println(i.getID() + "\t" + i.getTaskName() + "\t\t\t" + i.getTypeTaskName(i.getTaskTypeID()) +
                    "\t\t\t" + i.getDate() + "\t\t\t" + (i.getPlanTo() - i.getPlanFrom()) + "\t\t\t" + i.getAssignmentName() + "\t\t\t" + i.getReviewName());
        }
    }

    public void deleteExpense(){
        if (list == null || list.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        System.out.println("--------Delete an expense------");
        System.out.print("Enter ID:");
        int idDel = Validation.getInt(1,Integer.MAX_VALUE);
        Task expToDel = null;
        boolean idIsExist = false;
        for (Task i : list){
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

