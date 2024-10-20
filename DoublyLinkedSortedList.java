public class DoublyLinkedSortedList implements DoublyLinkedSortedListInterface {

    /**/
    /* Implements the DoublyLinkedSortedListInterface; creates a doubly linked 
     * sorted list from data read in from main and stores the object (based on ACE value)
     * created in HurricaneRowData.java. It then finds the high ACE year, prints it to 
     * the console and a .txt file. 
     * 
     * General source CGPT: "how do I implement a double linked list java"
    */

    private HurricaneRowData data;
    private DoublyLinkedSortedList previous;
    private DoublyLinkedSortedList next;

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
        return next;
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
        return previous;
    }

    //Return a reference to the first DoublyLinkedSortedList element in the list
    public DoublyLinkedSortedList getFirst() {
        if (this.previous == null) {
            return this;
        } else {
            return previous.getFirst();
        }

    }

    //Return a reference to the last DoublyLinkedSortedList element in the list
    public DoublyLinkedSortedList getLast() {
        if (data == null) {
            return this;
        } else {
            return next.getNext();
        }
    }

    //Remove the DoublyLinkedSortedList element that has toRemove as its value
    //public DoublyLinkedSortedList remove(HurricaneRowData toRemove);

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
        DoublyLinkedSortedList current = getFirst();
        while (current != null) {
            dataSet = dataSet + current.getValue() + "\n";
            current = current.next;
        }
        return dataSet;
    }

    //Insert a new DoublyLinkedSortedList element that has the given newValue in order in the list.
    public void insert(HurricaneRowData newValue) {
        DoublyLinkedSortedList newNode = new DoublyLinkedSortedList(newValue);

        // Places first node
        // Source: CGPT: "why don't you need to create a new node for the first element?"
        if (data == null) {
            data = newValue;
            return;
        }
        //Check if new node should be the head
        if (newValue.getAceIndex() > data.getAceIndex()) {
            if (!this.hasNext()) {
                newNode.setNext(this);
                newNode.setPrevious(null);
                this.setPrevious(newNode);
                return;
            } else {
                newNode.setNext(this);
                newNode.setPrevious(null);
                this.setPrevious(newNode);
                this.setNext(this.next);

                return;
            }

        }

        DoublyLinkedSortedList current = getFirst();

        while (current.next != null && newValue.getAceIndex() > data.getAceIndex()) {
            current = current.next;
        }
        if (current.getValue().getAceIndex() < newValue.getAceIndex() && current.previous == null) {
            newNode.setNext(current);
            current.setPrevious(newNode);
        }

        if (current.next == null) {
            current.setNext(newNode);
            newNode.setPrevious(current);
        }
    }
}
