import java.lang.reflect.Array;
import java.util.List;

/**
 * Class Hash Table - implementing separate chaining instance of player
 */
public class HashTable {
    // Private member variable
    private unorderedList[] buckets ;    // Array of Lists for separate chaining
    private int size;           // variable to get number of elements
    private final double LOAD_FACTOR = 0.75;    // default Load Factor


    /**
     *  Method to get the Hash Function.
     * @param player -> using Player hashCode method on the Player instance
     * @return -> hashing transform method to get Bucket
     */
    public int getBuckets(Player player){
        int mainKey ;
        int tKey;
        tKey = Math.abs(player.hashCode()) ;
        mainKey = tKey % buckets.length;
        return mainKey ;
    }


    /**
     * Default Constructor
     */
    public HashTable() {
        this.buckets = new unorderedList[4];
        initializeBuckets();
        this.size = 0;
    }


    /**
     * Initializes empty lists in each bucket.
     */
    private void initializeBuckets() {
        for (int i = 0; i < buckets.length ; i++) {
            buckets[i] = new unorderedList();
            // Each bucket is a new List
        }
    }


    /**
     * Copy Constructor (DEEP COPY)
     * @param other
     */
    HashTable(HashTable other) {
        this.buckets = new unorderedList[other.buckets.length];
        this.size = other.size;
        // copy contents within using loop
        for (int i = 0; i < other.buckets.length; i++) {
            if (other.buckets[i] != null) {
                this.buckets[i] = other.buckets[i];
            }
        }
    }   // End Copy Constructor

    /**
     * @return a clone of HashTable deep copy
     */
    HashTable createClone() {
        return new HashTable(this);
    }


    /**
     * Method to add player p to hashtable
     * @param p - instance of player
     */
    public void add(Player p){
        // in case resize necessary
        if ( ((double) (size + 1) / buckets.length) > LOAD_FACTOR) {
            resize();
        }
        int hashValue = getBuckets(p) ;
        buckets[hashValue].add(p) ;
        size++;
    }

    /**
     * Method to resize the array * 2 and all the contents of the []
     */
    private void resize() {
        unorderedList[] oldBuckets = buckets ;
        int newLength = oldBuckets.length * 2;
        buckets = new unorderedList[newLength];
        initializeBuckets();
        size = 0;

        for (unorderedList bucket : oldBuckets) {
            Node current = bucket.getHead();
            while (current != null) {
                add(new Player(current.data.getName(),current.data.getScore()));
                current = current.next;
            }
        }
    }

    /**
     * Method to search hash table for player based on name
     * @param name  -> use value to find matching data in hash table
     * @return  -> null if name not found else found data
     */
    public Player find(String name){
        for (unorderedList bucket : buckets) {
            Player found = (Player) bucket.find(name);
            if (found != null) {
                System.out.println("Found player " + name + " with score " + found.getScore());
                return found;
            }
        }
        System.out.println("No player with name " + name + " found");
        return null;
    }

    /**
     * Method to show the entire hash table
     */
    public void show(){
        for (int i = 0; i < buckets.length; i++){
            Node current = buckets[i].getHead();
            while (current != null) {
                System.out.println("Name:  " + current.data.getName() +
                        "\nScore: " + current.data.getScore());
                current = current.next;
            }
        }
        //System.out.println(buckets.length);

    }   // End show method




}   // End Hash Table Class

