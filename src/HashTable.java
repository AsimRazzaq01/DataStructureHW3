import java.util.ArrayList;
import java.util.Arrays;

public class HashTable {

    private List[] Buckets ;
    private int size;

    /**
     * Default Constructor
     */
    public HashTable() {
        this.Buckets = new List[4];
        this.size = 0;
    }

    /**
     * Copy Constructor
     * @param other
     */
    HashTable(HashTable other) {
        this.Buckets = new List[other.Buckets.length];
        this.Buckets = other.Buckets;
        this.size = other.size;
    }




}
