/**
 * A class with methods to represent and modify an ArrayList of object courses
 * @author Eric Chang
 */
public class CourseArrayList implements Course.CourseList {

    //Private field to hold Course array
    private Course[] course;

    //Constructor
    public CourseArrayList() {
        this.course = new Course[10];
    }

    //Method to return the number of elements in the arraylist
    //Worst-case runtime is O(n)
    public int size(){
        //counter to keep track of number of courses
        int counter = 0;
        for (int i = 0; i < course.length; i++){
            //checking to see if element at ith position contains an element or null
            if (course[i] != null){
                //if element is not null, then it is a course object
               counter++;
            }
        }
        return counter;
    }

    //Method to slot a Course course in at interval i
    //Worst-case runtime is O(n)
    public void addCourse(int i, Course course){
        //Check to see if the interval i is greater than the number of elements in the arraylist
        if (i >= this.size()){
            this.course[size()] = course;
        }
        else{
            //Works backwards to move all elements past i one slot to the right to create space for new element
            for (int j = size(); j > i; j--){
                this.course[j] = this.course[j - 1];
            }
            this.course[i] = course;
        }

    }

    //Checks the course IDs of all elements in the arraylist and changes the capacity of the
    //First instance where the element IDs are the same
    //Worst-case runtime is O(n)
    public boolean changeCapacity(String ID, int cap){
        for (int i = 0; i < course.length; i++){
            if (this.course[i] != null){
                //if statement to check if the course id is the same as the parameter ID
                if (this.course[i].getCourseID() == ID){
                    //if the IDs are the same, change the capacity and return true
                    this.course[i].setCapacity(cap);
                    return true;
                }
            }
        }
        //if the ID is never found after parsing through the arrayList, returns false
        return false;
    }

    //Method to remove a course at interval i and change it to null
    //Worst-case runtime is O(n)
    public boolean removeCourse(int i) {
        //counter to keep track of number of elements
        int counter = 0;
        //makes sure the size of the arraylist is greater than i, else returns false
        if (size() >= i) {
            for (int j = 0; j < course.length; j++) {
                if (this.course[j] != null) {
                    if (counter == i) {
                        this.course[j] = null;
                        return true;
                    }
                    counter++;
                }
            }
        }
        return false;
    }

    //Method to search through the arraylist to find the i-th element
    //Worst-case runtime is O(n)
    public Course search(int i){
        //counter to keep track of elements
        int counter = 0;
        if (size() >= i) {
            for (int j = 0; j < course.length; j++) {
                if (this.course[j] != null) {
                    if (counter == i) {
                        //Returns the course at position j if the counter keeping track of number of elements is the
                        //  same as i
                        return this.course[j];
                    }
                    counter++;
                }
            }
        }
        return null;
    }
}
