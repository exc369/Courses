/**
 * A class to represent object courses, each with a string courseID and int capacity
 * @author Eric Chang
 */
public class Course {
    //private variables for courseID and capacity
    private String courseId;
    private int capacity;

    //Constructor
    public Course(String courseId, int capacity){
        this.courseId = courseId;
        this.capacity = capacity;
    }

    //CourseList interface implemented in CourseArraylist and CourseLinkedList
    public interface CourseList {
        int size();
        void addCourse(int i, Course course);
        boolean changeCapacity(String ID, int cap);
        boolean removeCourse(int i);
        Course search(int i);
    }

    //Getter method for CourseID
    public String getCourseID(){
        return this.courseId;
    }

    //Getter method for capacity
    public int getCapacity(){
        return this.capacity;
    }

    //Setter method for capacity
    public void setCapacity(int cap){
        this.capacity = cap;
    }
}
