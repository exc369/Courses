/**
 * Created by Leonard Dervishi on 09/20/2019.
 */
import java.util.LinkedList;

public class Demo {

	/**
	 * Counts the number of courses starting with a given prefix
	 * @param list The list of courses
	 * @param prefix The given prefix
	 * @return the count of courses
	 */
	public static int prefixCountArrayList(CourseArrayList list, String prefix){	
		//TODO implementation
		int counter = 0;
		int prefixLength = prefix.length();
		for (int i = 0; i < list.size(); i++) {
			if (list.search(i) != null) {
				if (list.search(i).getCourseID().substring(0, prefixLength).equals(prefix)) {
					counter++;
				}
			}
		}
			return counter;
	}
	
	/**
	 * Counts the number of courses starting with a given prefix
	 * @param list The list of courses
	 * @param prefix The given prefix
	 * @return the count of courses
	 */
	public static int prefixCountLinkedList(CourseLinkedList list, String prefix){
		//TODO implementation
		int counter = 0;
		int prefixLength = prefix.length();
		for (int i = 0; i < list.size(); i++) {
			if (list.search(i) != null) {
				if (list.search(i).getCourseID().substring(0, prefixLength).equals(prefix)) {
					counter++;
				}
			}
		}
		return counter;
	}
	
	public static void main (String [] args)
	{
		CourseArrayList alist = new CourseArrayList();		
		Course course1 = new Course("MATH444", 30);
		Course course2 = new Course("EECS123", 120);
		Course course3 = new Course("EECS233", 140);
		Course course4 = new Course("EBME399", 50);
		
		
		// Add course objects to arraylist
		alist.addCourse(0, course1);
		alist.addCourse(0, course2);
		alist.addCourse(5, course3);
		alist.addCourse(3, course4);
		
		System.out.println("----------------------------------------");
		//Testing ArrayList methods
		System.out.println("Capacity of " + alist.search(1).getCourseID() + " is " + alist.search(1).getCapacity());
		
		System.out.println("\nCapacity of EECS233: " + alist.search(2).getCapacity());
		System.out.println("Change capacity method: " + alist.changeCapacity("EECS233", 100));
		System.out.println("Change capacity method: " + alist.changeCapacity("EECS133", 100));
		System.out.println("Capacity of EECS233: " + alist.search(2).getCapacity());
		
		System.out.println("\nNumber of courses: " + alist.size());
		System.out.println("Course removed:" + alist.removeCourse(1));
		System.out.println("Course removed:" + alist.removeCourse(5));
		System.out.println("Number of courses: " + alist.size());
		
		System.out.println("\nNumber of courses starting with EECS: " + prefixCountArrayList(alist, "EECS"));
		System.out.println("----------------------------------------");
		
		//Change back the capacity of EECS233 to 140
		alist.changeCapacity("EECS233", 140);
		
		CourseLinkedList llist = new CourseLinkedList();	
		// Add course objects to Linkedlist
		llist.addCourse(0, course1);
		llist.addCourse(0, course2);
		llist.addCourse(5, course3);
		llist.addCourse(3, course4);
		
		
		System.out.println("----------------------------------------");
		//Testing LinkedList methods		
		System.out.println("Capacity of " + llist.search(1).getCourseID() + " is " + llist.search(1).getCapacity());
		
		System.out.println("\nCapacity of EECS233: " + llist.search(2).getCapacity());
		System.out.println("Change capacity method: " + llist.changeCapacity("EECS233", 100));
		System.out.println("Change capacity method: " + llist.changeCapacity("EECS133", 100));
		System.out.println("Capacity of EECS233: " + llist.search(2).getCapacity());
		
		System.out.println("\nNumber of courses: " + llist.size());
		System.out.println("Course removed:" + llist.removeCourse(1));
		System.out.println("Course removed:" + llist.removeCourse(5));
		System.out.println("Number of courses: " + llist.size());
		
		System.out.println("\nNumber of courses starting with EECS: " + prefixCountLinkedList(llist, "EECS"));
		System.out.println("----------------------------------------");
		
	}
}
