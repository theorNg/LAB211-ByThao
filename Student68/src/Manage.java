import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Manage {

    List<Student> list = new ArrayList<>();

    public void displayStudent(List<Student> list){
        if(list.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++){
            System.out.println("------Student" + (i + 1) + "------");
            System.out.println("Name: " + list.get(i).getNameStudent());
            System.out.println("Classes: " + list.get(i).getClassName());
            System.out.println("Mark: " + list.get(i).getMark());
        }
    }

    public void addStudent(List<Student> list){
        System.out.println("======Collection Sort Program======");
        System.out.println("Please input student information");
        System.out.print("Name: ");
        String name = Validation.getString();
        System.out.print("Classes: ");
        String className = Validation.getString();
        System.out.print("Mark: ");
        double mark = Validation.getDouble();
        list.add(new Student(name, className, mark));
    }

     public void printProgram(){
        addStudent(list);
        while (true){
            System.out.print("Do you want to continue (Y/N): ");
            if(Validation.checkYN()){
               addStudent(list);
            }
            else{
                break;
            }
        }
        displayStudent(list);
     }
}
