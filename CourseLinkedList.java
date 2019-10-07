/**
 * A class to represent and modify a LinkedList of courses
 * @author Eric Chang
 */
public class CourseLinkedList implements Course.CourseList {

    //private field to hold a linkedlist of Courses
    private LinkedList<Course> list = new LinkedList<Course>();

    //Method to return the number of elements in the LinkedList
    //Worst-case runtime is O(n)
    public int size() {
        LLNode<Course> ptr = list.getFront();
        //counter to count number of elements
        int counter = 0;
        while (ptr != null){
            ptr = ptr.getNext();
            counter++;
        }
        return counter;
    }

    //Method to slot a Course course in at interval i
    //Worst-case runtime is O(n)
    public void addCourse(int i, Course course) {
        //checking if i is greater than the number of elements
        if (i > size()) {
            list.addToBack(course);
        }
        //checking special case i = 0
        else if (i == 0) {
            list.addToFront(course);
        }
        //every other case
        else {
                LLNode<Course> newNode = new LLNode<Course>(course, list.get(i));
                list.get(i - 1).setNext(newNode);
            }
        }

    //Checks the course IDs of all elements in the LinkedList and changes the capacity of the
    //  first instance where the element IDs are the same
    //Worst-case runtime is O(n)
    public boolean changeCapacity(String ID, int cap){
        LLNode<Course> ptr = list.getFront();
        while(ptr != null){
            if (ptr.getElement().getCourseID() == ID){
                ptr.getElement().setCapacity(cap);
                return true;
            }
            ptr = ptr.getNext();
        }
        return false;
    }

    //Method to remove a course at interval i by pointing the node before interval i to the node after i
    //Worst-case runtime is O(n)
    public boolean removeCourse(int i){
        //checks to make sure size is enough to support interval i
        if (i != 0 && size() >= i){
            list.get(i - 1).setNext(list.get(i+1));
            return true;
        }
        //takes care of special case i = 0 where the first course is removed
        else if (i == 0){
            list.setFront(list.get(i + 1));
            return true;
        }
        return false;
    }

    //Method to search through the LinkedList to find the i-th element
    //Worst-case runtime is O(n)
    public Course search(int i){
        if ( size() >= i){
            return list.get(i).getElement();
        }
        return null;
    }
}
