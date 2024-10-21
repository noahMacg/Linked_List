public class DoublyLinkedSortedList implements DoublyLinkedSortedListInterface {

    /**/
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

    /*Source: CGPT: why will this not work:
    public String toString() {
        String dataSet = null;
        DoublyLinkedSortedList current = head; 
        while (current != null) {
            dataSet = current.getValue(); 
            current = current.next; 
        }
        return dataSet;
    } */
    //Return the entire list as a multi-line String
    public String toString() {

        String dataSet = "";
        DoublyLinkedSortedList current = head;
        while (current != null) {
            dataSet = dataSet + current.getValue() + "\n";
            current = current.next;
        }
        return dataSet;
    }

    //Insert a new DoublyLinkedSortedList element that has the given newValue in order in the list.
    public void insert(HurricaneRowData newValue) {
        DoublyLinkedSortedList newNode = new DoublyLinkedSortedList(newValue);

        //Inserts at the head if the list is empty
        if (head == null) {
            head = newNode;
            return;
        }
        //Check if new node should be the head
        if (newValue.getAceIndex() > head.getValue().getAceIndex()) {

            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
            return;
        }
        /*  Source: CGPT "why is this not working : while (current.hasNext() && current.getValue().getAceIndex() > newValue.getAceIndex()) {
            current = current.next;}
        //current = current.getPrevious();
        System.out.println("newValue " + newValue.getAceIndex());
        System.out.println("currentValue  " + current.getValue().getAceIndex());
        if (current.hasNext() == false) {
            newNode.setPrevious(current);
            current.setNext(newNode);
            System.out.println("hasNext()==false ran");
            return;
        } else {
            newNode.setPrevious(current);
            newNode.setNext(current.next);
            current.next.setPrevious(newNode);
            return;}"*/

        //Loops through the list and inserts based on it's ACE value 
        DoublyLinkedSortedList current = head;
        while (current.hasNext() && current.next.getValue().getAceIndex() > newValue.getAceIndex()) {
            current = current.next;
        }

        //Inserts at the tail
        if (current.hasNext() == false) {
            newNode.setPrevious(current);
            current.setNext(newNode);
            return;
            //Inserts in-between two nodes 
        } else {
            newNode.setPrevious(current);
            newNode.setNext(current.next);
            current.next.setPrevious(newNode);
            current.setNext(newNode);
            return;
        }
    }
}