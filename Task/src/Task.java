public class Task {
    private int ID;
    private int taskTypeID;
    private String taskName;
    private String date;
    private double planFrom;
    private double planTo;
    private String assignmentName;
    private String reviewName;

    public Task() {
    }

    public Task(int ID, int taskTypeID, String taskName, String date, double planFrom, double planTo, String assignmentName, String reviewName) {
        this.ID = ID;
        this.taskTypeID = taskTypeID;
        this.taskName = taskName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignmentName = assignmentName;
        this.reviewName = reviewName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getTaskTypeID() {
        return taskTypeID;
    }

    public void setTaskTypeID(int taskTypeID) {
        this.taskTypeID = taskTypeID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getReviewName() {
        return reviewName;
    }

    public void setReviewName(String reviewName) {
        this.reviewName = reviewName;
    }

    public String getTypeTaskName(int taskTypeID){
        switch (taskTypeID){
            case 1:
                return "Code";
            case 2:
                return "Test";
            case 3:
                return "Design";
            case 4:
                return "Review";
        }
        return null;
    }
}
