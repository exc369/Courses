/**
 * A class to represent a linked list of nodes.
 * From EECS 132 with some methods given by Professor Connamacher
 * @author Eric Chang
 */
public class LinkedList<T> {
  /** the first node of the list, or null if the list is empty */
  private LLNode<T> frontNode;
  /** the last node of the list, or null if the list is empty*/
  private LLNode<T> backNode;
  /**
   * Creates an initially empty linked list
   */
  public LinkedList() {
    frontNode = backNode = null;
  }
  
  /**
   * Returns the first node.
   */
  protected LLNode<T> getFront() {
    return frontNode;
  }

  /**
   * Changes the front node.
   * @param node  the node that will be the first node of the new linked list
   */
  protected void setFront(LLNode<T> node) {
    this.frontNode = node;
  }

  protected void setBack(LLNode<T> node) {
    this.backNode = node;
  }
  
  /**
   * Add an element to the front of the linked list
   */
  public void addToFront(T element) {
    LLNode<T> nodeptr = new LLNode<T>(element, getFront());
    setFront(nodeptr);
    if (this.backNode == null)
      setBack(nodeptr);
  }
  
  /**
   * Add an element to the back of the linked list
   */
  public void addToBack(T element) {
    if(frontNode == null) { 
      frontNode = new LLNode<T>(element, null); 
    } else { 
      LLNode<T> mainCursor = frontNode; 
      while(mainCursor.getNext() != null) { 
        mainCursor = mainCursor.getNext(); 
      } 
      mainCursor.setNext(new LLNode<T>(element, null));  
    } 
    
  }

  public LLNode<T> get(int i) {
    LLNode<T> ptr = getFront();
      for (int j = 0; j < i; j++) {
        ptr = ptr.getNext();
      }
      return ptr;
  }
  
  /**
   * Returns a String representation of the list
   * @return a String representing the list
   */
  public String toString() {
    String retStr = "list:";
    LLNode<T> current = frontNode;
    while(current != null){
      retStr += " " + current.getElement();
      current = current.getNext();
    }
    return retStr;
  }
}

