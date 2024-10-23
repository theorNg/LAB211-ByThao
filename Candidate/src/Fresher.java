public class Fresher extends Candidate {
    private String graduationTime;
    private String getGraduationRank;

    public Fresher(){
        super();
    }

    public Fresher(String graduationTime, String getGraduationRank, String id, String firstName, String lastName, int date, String address, String phone, String email, int typeCandidate) {
        super(id, firstName, lastName, date, address, phone, email, typeCandidate);
        this.graduationTime = graduationTime;
        this.getGraduationRank = getGraduationRank;
    }

    public String getGraduationTime() {
        return graduationTime;
    }

    public void setGraduationTime(String graduationTime) {
        this.graduationTime = graduationTime;
    }

    public String getGetGraduationRank() {
        return getGraduationRank;
    }

    public void setGetGraduationRank(String getGraduationRank) {
        this.getGraduationRank = getGraduationRank;
    }
}
