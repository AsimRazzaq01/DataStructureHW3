import java.util.Objects;

/**
 * Player Class
 */
public class Player {
    /** Player class variables
     */
    private String Name;
    private int Score;

    /**
     *  Default Constructor
     */
    public Player() {
        this.Name = "";
        this.Score = 0;
    }   // End default Constructor

    /**
     * Constructor with parameter values
     */
    public Player(String Name , int Score){
        this.Name = Name;
        this.Score = Score;
    }   // End Player Constructor

    /**
     * Copy Constructor (DEEP COPY)
     */
    public Player(Player other){
        this.Name = new String(other.Name) ;
        this.Score = other.Score;
    }   // End Player copy Constructor

    /**
     *  Implement the getter and setter methods
     */
    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public int getScore(){
        return Score;
    }
    public void setScore(int Score){
        this.Score = Score;
    }

    /**
     * Method for createClone()
     * @return a clone of this-player
     */
    public Player createClone(){
        return new Player(this.Name ,this.Score);
    }   // End createClone Method


    /**
     * override equals method based in "Values" Not references
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        Player p = (Player) obj;
        return this.Name.equals(p.Name);
    }   // End equals Method

    /**
     * To String method
     * @return name and score as a String
     */
    @Override
    public String toString(){
        return "Name: " + this.Name + "\nScore: " + this.Score;
    }   // End toString Method

    /**
     *
     * @return hashcode based on player name obj
     */
    public int hashCode(){
        //return Objects.hashCode(this.Name);
        return Objects.hash(Name);
    }   // End hashCode


}   // End Player Class
