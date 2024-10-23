public class Student implements Comparable<Student> {
    private String nameStudent;
    private String className;
    private double mark;

    public Student() {
    }

    public Student(String nameStudent, String className, double mark) {
        this.nameStudent = nameStudent;
        this.className = className;
        this.mark = mark;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public int compareTo(Student o) {
        return -this.nameStudent.compareTo(o.nameStudent);
    }
}
