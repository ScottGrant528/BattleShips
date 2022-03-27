package uk.ac.rgu.battleships.gameboard;

import java.util.ArrayList;
import uk.ac.rgu.battleships.gameboard.Boat;

// Class to model a game board

public class GameBoard {
    // Attributes
    private ArrayList<Boat> boats;

    // Constructor
    public GameBoard() {
        this.boats = new ArrayList<>();
    }

    // Getters and setters
    public ArrayList<Boat> getBoats() {
        return this.boats;
    }
    
    public void setBoats(ArrayList<Boat> boats) {
        this.boats = boats;
    }
    
    // Get a certian boat from an index
    public Boat getBoat(int pos) {
        return this.boats.get(pos);
    }

    // Checks a tile for a boat, returns if one is present
    public Boat checkTile(int[] checkPos) {
        Boat result = getBoat(0);

        getBoats().forEach(currentBoat -> {
            
        });

        return result;
    }

    // toString method
    public String toString() {

        /**
         *
         * Board 10x10  
         *  Boarder of 2 on Top and Left
         *  Boarder of 1 on bottom and right
         *
         */
        String result = "";
        //iterating through the x axis
        for(int i = 0; i < 13; i++){
            //iterating through the y axis
            for(int j = 0; j < 13; j++){
                //if in co ord [0,0]
                if(j == 0 & i == 0){
                    result += "┌";
                } 
                else if(i == 0 & (j > 0 & j < 11)) //if in co ord [0,1-11]
                {
                    result += "─";
                }
                else if(i == 0 & j == 12){ //if in co ord [0,12]
                    result += "┐";
                }
            }

        }

        return result;
    }
}
