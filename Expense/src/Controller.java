import java.util.List;

public class Controller {
    public static boolean checkDeleteExpense(List<Expense> list, Expense exp){
        return list.remove(exp);
    }
}
