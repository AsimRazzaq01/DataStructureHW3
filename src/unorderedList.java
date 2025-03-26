/**
 * List Class - singly-linked-unordered list that stores instances of player
 */
public class unorderedList {
    // Private member variable
    private Node head;

    // getter method for head as it is a private variable need getter to access
    public Node getHead() {
        return head;
    }

    /**
     * Default Constructor
     */
    public unorderedList() {
        this.head = null;
    }


    /**
     * @param other -> Copy Constructor (Deep Copy)
     */
    public unorderedList(unorderedList other){
        if (other.head == null) {
            this.head = null;
            return;
        }
        // method to copy node in head of new list - this
        this.head = new Node(new Player(other.head.data.getName(), other.head.data.getScore()));

        Node curr = this.head;
        Node myOther = other.head.next;

        // loop to add rest of nodes in new list while list other.head.next != null
        // then increment both variables until head.next is empty
        while (myOther != null) {
            curr.next = new Node( new Player(myOther.data.getName(),myOther.data.getScore()));
            curr = curr.next;
            myOther = myOther.next;
        }
    }   // End List copy constructor


    /**
     * @return createClone method (Deep copy)
     */
    public unorderedList createClone(){
        // utilize the copy constructor to createClone method
        return new unorderedList(this);
    }   // End List createClone method

    /**
     *
     * @param player -> added to start of the list
     */
    public void add(Player player) {
        // makes the new player node with player data
        Node newPlayerNode = new Node(player);
        // makes the new node point towards head of Linked List
        newPlayerNode.next = head;
        // sets the head to the new player node making it the first node in the list
        // this now points towards the previous head of the list etc...
        head = newPlayerNode;
    }

    /**
     * @param name -> target is the name for the Player we want to find
     * @return  return the player instance after find matching name
     *          else returns null
     */
    public Player find(String name) {
        Node curr = this.head ;
        // base case for loop goes through player list if != null
        while (curr != null) {
            if (curr.data.getName().equals(name)) {
                return curr.data;
            }
            // Increment to next node if not found
            curr = curr.next;
        }
        return null;
    }



}   // End unordered Linked List






//    Possible implementations from class slides
//    public void insertItem(int item);
//
//    public void deleteItem(int item);
//
//    public boolean hasItem(int target);
//
//    public int retriveItem(int target) throws Exception;
//
//    public void  makeEmpty();
//
//    public boolean isFull();
//
//    public int getLength();


