public class Manager {

    public void displayMenu(){
        System.out.println("======Calculator Program======");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    public void printMenu(){
        while(true){
            displayMenu();
            int choice = Validation.getInt(1,3);
            switch (choice){
                case 1:
                    normalCalculator();
                    break;
                case 2:
                    BMICalculator();
                    break;
                case 3:
                    return;
            }
        }
    }

    public void normalCalculator() {
        System.out.println("------Normal Calculator------");
        double memory = Validation.getNumber();
        while (true){
            System.out.print("Enter operator: ");
            String operator = Validation.getOperator();
            if(operator.equals("+")){
                memory += Validation.getNumber();
                System.out.println("Memory: " + memory);
            }
            else if(operator.equals("-")){
                memory -= Validation.getNumber();
                System.out.println("Memory: " + memory);
            }
            else if(operator.equals("*")){
                memory *= Validation.getNumber();
                System.out.println("Memory: " + memory);
            } 
            else if (operator.equals("/")) {
                double input = Validation.getNumber();
                if(input == 0){
                    System.out.println("Division by zero is not allowed");
                }
                else{
                    memory /= Validation.getNumber();
                    System.out.println("Memory: " + memory);
                }
            }
            else if (operator.equals("^")) {
                Math.pow(memory,Validation.getNumber());
                System.out.println("Memory: " + memory);
            }
            else if (operator.equals("=")) {
                System.out.println("Result: " + memory);
                return;
            }
        }
    }

    public void BMICalculator(){
        System.out.println("------BMI Calculator------");
        System.out.print("Enter weight(kg): ");
        double weight = Validation.getDouble();
        System.out.print("Enter height(cm): ");
        double height = Validation.getDouble();
        double bmi = (weight * 10000) / height;
        System.out.printf("BMI number: %.2f\n", bmi);
        System.out.println("BMI Status: " + BMIStatus(bmi));
    }

    public String BMIStatus(double bmi){
        if(bmi < 19){
            return "UNDER-STANDARD";
        }
        if(bmi >= 19 && bmi < 25){
            return "STANDARD";
        }
        if(bmi >= 25 && bmi < 30){
            return "OVERWEIGHT";
        }
        if(bmi >= 30 && bmi < 40){
            return "FAT";
        }
        else{
            return "VERY FAT - SHOULD LOSE WEIGHT IMMEDIATELY";
        }
    }
}
