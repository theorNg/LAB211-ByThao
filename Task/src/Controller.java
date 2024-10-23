import java.util.List;

public class Controller {
    public static boolean checkDeleteExpense(List<Task> list, Task taskDel){
        return list.remove(taskDel);
    }
}
