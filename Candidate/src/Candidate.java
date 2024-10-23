public class Candidate {

    private String id;
    private String firstName;
    private String lastName;
    private int date;
    private String address;
    private String phone;
    private String email;
    private int typeCandidate;

    public Candidate(String id, String firstName, String lastName, int date, String address, String phone, String email, int typeCandidate) {
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
        this.date = date;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.typeCandidate = typeCandidate;
    }

    public Candidate() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTypeCandidate() {
        return typeCandidate;
    }

    public void setTypeCandidate(int typeCandidate) {
        this.typeCandidate = typeCandidate;
    }

    @Override
    public String toString() {
        return this.firstName + this.lastName + "|" + this.date + "|"
                + this.address + "|" + this.phone + "|" + this.email + "|"
                + this.typeCandidate;
    }
}
