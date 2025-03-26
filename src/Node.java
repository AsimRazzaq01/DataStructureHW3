/**
 * Node Class -> use for Singly Linked List Data structure (unordered)
 */
public class Node {
    Player data;
    Node next;

    /**
     * Node Constructor -> Player data
     * @param data
     */
    public Node(Player data) {
        this.data = data;
        this.next = null;
    }
}
