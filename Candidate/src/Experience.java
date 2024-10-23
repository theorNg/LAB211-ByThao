public class Experience extends Candidate{

    private int yearExperience;
    private String professionalSkills;

    public Experience() {
        super();
    }

    public Experience(int yearExperience, String professionalSkill,
                      String id, String firstName, String lastName, int birthDate,
                      String address, String phone, String email, int typeCandidate) {
        super(id, firstName, lastName, birthDate, address, phone, email,
                typeCandidate);
        this.yearExperience = yearExperience;
        this.professionalSkills = professionalSkill;
    }

    public int getYearExperience() {
        return yearExperience;
    }

    public void setYearExperience(int yearExperience) {
        this.yearExperience = yearExperience;
    }

    public String getProfessionalSkills() {
        return professionalSkills;
    }

    public void setProfessionalSkills(String professionalSkills) {
        this.professionalSkills = professionalSkills;
    }
}
