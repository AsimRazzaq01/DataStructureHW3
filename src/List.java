public class List{

    Node head;

    /**
     * Default Constructor
     */
    public List() {
        this.head = null;
    }

    /**
     * @param other -> Deep Copy
     */
    public List(List other){
        this.head = other.head;
    }

    /**
     * @return Deep copy Clone of list
     */
    public List createClone(){
        return new List(this);
    }

    /**
     *
     * @param player -> added to front of list
     */
    public void add(Player player) {
        Node newNode = new Node(player);
        newNode.next = head;
        head = newNode;
    }

    /**
     * @param target -> target is the name for the Player we want to find
     * @return  return the player after find matching name
     */
    public Player find(String target) {
        Node current = head;
        while (current != null) {
            if (current.data.getName().equals(target)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }





}   // End Linked List






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


