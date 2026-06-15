package classroomManagement;

public class Classroom {
    private String classroomId;
    private Boolean available;

    public Classroom(String classroomId, Boolean available) {
        this.classroomId = classroomId;
        this.available = available;
    }

    public String getClassroomId(){
        return classroomId;
    }

    public void setClassroomId(String classroomId) {
        this.classroomId = classroomId;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String toText(){
        return classroomId + "," + available;
    }
}
