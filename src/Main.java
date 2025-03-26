//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main Class
 */
public class Main {
    public static void main(String[] args) {

        HashTable hashTable = new HashTable();

        /**
         * use to get file player.txt
         */
        File playerFile = new File("src/players.txt");

        /**
         use to read file and or test/fix the FileNotFoundException error
         */
        Scanner scanner = null;
        try {
            scanner = new Scanner(playerFile);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /**
         * create player array
         * Amount of buckets of players
         */
        Player[] players = new Player[1000];
        int playerIndex = 0;

        /**
         * while loop to Populate the priority queue with all data from the player file
         */
        while (scanner.hasNextLine() && playerIndex < players.length) {
            // first line will be name of player
            String name = scanner.nextLine();
            if (scanner.hasNextLine()) {
                int score = Integer.parseInt(scanner.nextLine());


                hashTable.add(new Player(name, score));
                players[playerIndex] = new Player(name, score);
            }
        }
        scanner.close();

        /**
         *  Hash Table show Method
         */
//        hashTable.show();

        /**
         * Copy Constructor Method
         */
        HashTable hashTable2 = new HashTable(hashTable) ;
//        hashTable2.show();


        /**
         * createClone Method
         */
        HashTable hashTable3 = new HashTable(hashTable).createClone();
//        hashTable3.show();


        /**
         * find Method
         */
        hashTable3.find("Sara Rogers");
        hashTable2.find("Carl Bailey");
        hashTable.find("Donald Green");












    }   // End Main Method
}   // End Main Class

