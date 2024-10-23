import java.util.ArrayList;
import java.util.Calendar;

public class View {

    ArrayList<Candidate> list = new ArrayList<>();

    public void displayMenu(){
        System.out.println("======Candidate Managament=====");
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Internship");
        System.out.println("4. Searching");
        System.out.println("5. Exit");
        System.out.print("Enter your choice:");
    }

    public void printMenu(){
        while (true){
            displayMenu();
            int choice = Validation.getInt(1,5);
            switch (choice){
                case 1:
                    createCandidate(list, 0);
                    break;
                case 2:
                    createCandidate(list, 1);
                    break;
                case 3:
                    createCandidate(list, 2);
                    break;
                case 4:
                    searchCandidate(list);
                    break;
                case 5:
                    return;
            }
        }
    }

    public void createCandidate(ArrayList<Candidate> list, int type){
        while(true){
            System.out.print("Enter ID: ");
            String ID = Validation.getString();
            System.out.print("Enter first name: ");
            String firstName = Validation.getString();
            System.out.print("Enter last name: ");
            String lastName = Validation.getString();
            System.out.print("Enter birth date: ");
            int birthDate = Validation.getInt(1900, Calendar.getInstance().get(Calendar.YEAR));
            System.out.print("Enter address: ");
            String address = Validation.getString();
            System.out.print("Enter phone: ");
            String phone = Validation.getPhone();
            System.out.print("Enter email: ");
            String email = Validation.getEmail();
            Candidate candidate = new Candidate(ID,firstName,lastName,birthDate,address,phone, email, type);
            if(Validation.checkID(list, ID)) {
                switch (type) {
                    case 0:
                        createExperience(list, candidate);
                        break;
                    case 1:
                        createFresher(list, candidate);
                        break;
                    case 2:
                        createInternship(list, candidate);
                        break;
                }
            }
            System.out.print("Do you want to continue: ");
            if(!Validation.checkYN()){
                return;
            }
        }
    }

    public static void createExperience(ArrayList<Candidate> list, Candidate candidate) {
        System.out.print("Enter year of experience: ");
        int yearExperience = Validation.checkExperience(candidate.getDate());
        System.out.print("Enter professional skill: ");
        String professionalSkill = Validation.getString();
        list.add(new Experience(yearExperience, professionalSkill,
                candidate.getId(), candidate.getFirstName(), candidate.getLastName(),
                candidate.getDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate()));
        System.out.println("Create success.");
    }
    public static void createFresher(ArrayList<Candidate> list,
                                     Candidate candidate) {
        System.out.print("Enter graduation date: ");
        String graduationDate = Validation.getString();
        System.out.print("Enter graduation rank: ");
        String graduationRank = Validation.getGraduation();
        list.add(new Fresher(graduationDate, graduationRank, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate()));
        System.out.println("Create success.");
    }

    public static void createInternship(ArrayList<Candidate> list,
                                        Candidate candidate) {
        System.out.print("Enter major: ");
        String major = Validation.getString();
        System.out.print("Enter semester: ");
        String semester = Validation.getString();
        System.out.print("Enter university: ");
        String university = Validation.getString();
        list.add(new Intern(major,semester,university,candidate.getId(), candidate.getFirstName(), candidate.getLastName(), candidate.getDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate()));
        System.out.println("Create success.");
    }

    public static void printListNameCandidate(ArrayList<Candidate> list) {
        System.out.println("Experience Candidate");
        for (Candidate candidate : list) {
            if (candidate instanceof Experience && candidate.getFirstName() != null && candidate.getLastName() != null) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        System.out.println("Fresher Candidate");
        for (Candidate candidate : list) {
            if (candidate instanceof Fresher && candidate.getFirstName() != null && candidate.getLastName() != null) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        System.out.println("Internship Candidate");
        for (Candidate candidate : list) {
            if (candidate instanceof Intern && candidate.getFirstName() != null && candidate.getLastName() != null) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
    }

    public static void searchCandidate(ArrayList<Candidate> list) {
        printListNameCandidate(list);
        System.out.print("Enter candidate name (First name or Last name): ");
        String nameSearch = Validation.getString();
        System.out.print("Enter type of candidate: ");
        int typeCandidate = Validation.getInt(0,2);
        for (Candidate candidate : list) {
            if (candidate.getTypeCandidate() == typeCandidate
                    && candidate.getFirstName().contains(nameSearch)
                    || candidate.getLastName().contains(nameSearch)) {
                candidate.toString();
            }
        }
    }

}
