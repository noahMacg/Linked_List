public class DoublyLinkedSortedList {

    /*implements DoublyLinkedSortedListInterface*/
    /* Implements the DoublyLinkedSortedListInterface; creates a doubly linked 
     * sorted list from data read in from main and stores the object (based on ACE value)
     * created in HurricaneRowData.java. It then finds the high ACE year, prints it to 
     * the console and a .txt file. 
     * 
     * General source CGPT: "how do I implement a double linked list java"
    */

    private DoublyLinkedSortedList head;

    HurricaneRowData data;
    DoublyLinkedSortedList previous;
    DoublyLinkedSortedList next;

    public DoublyLinkedSortedList() {
        this.data = null;
        this.previous = null;
        this.next = null;
    }

    public DoublyLinkedSortedList(HurricaneRowData data) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }

    //Get the value of the current DoublyLinkedSortedList
    public HurricaneRowData getValue() {
        return this.data;
    }

    //Return true if next is not null
    public boolean hasNext() {
        if (this.next == null) {
            return false;
        } else
            return true;
    }

    //Set next to be the given DoublyLinkedSortedList
    public void setNext(DoublyLinkedSortedList next) {
        this.next = next;
        previous.next = this;
    }

    //Return a reference to the next DoublyLinkedSortedList
    public DoublyLinkedSortedList getNext() {
        return this.next;
    }

    //Return true if previous is not null
    public boolean hasPrevious() {
        if (this.previous == null) {
            return false;
        } else
            return true;
    }

    //Set previous to be the given DoublyLinkedSortedList
    public void setPrevious(DoublyLinkedSortedList previous) {
        this.previous = previous;
        previous.next = this;
    }

    //Return a reference to the previous DoublyLinkedSortedList
    public DoublyLinkedSortedList getPrevious() {
        return this.previous;
    }

    //Return a reference to the first DoublyLinkedSortedList element in the list
    public DoublyLinkedSortedList getFirst() {
        return this.head;
    }

    //Return a reference to the last DoublyLinkedSortedList element in the list
    public DoublyLinkedSortedList getLast() {
        DoublyLinkedSortedList current = head;
        while (current != null) {
            current = current.getNext();
        }
        return current;
    }

    //Remove the DoublyLinkedSortedList element that has toRemove as its value
    // public DoublyLinkedSortedList remove(HurricaneRowData toRemove) {

    //     DoublyLinkedSortedList current = head; 

    //     while (current! = null) {
    //         if (current.get == null) {
    //             System.out.println("The list is empty.");
    //         }
    //     }
    // }

    //Return the entire list as a multi-line String
    //public String toString();

    //Insert a new DoublyLinkedSortedList element that has the given newValue in order in the list.
    public void insert(HurricaneRowData newValue) {
        DoublyLinkedSortedList newNode = new DoublyLinkedSortedList(newValue);
        System.out.println(newNode);
    }

}
