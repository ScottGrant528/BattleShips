package uk.ac.rgu.battleships.gameboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;

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
    
    // Add a boat to the game board
    public void addBoat(Boat boat) {
        this.boats.add(boat);
    }

    // Get a certian boat from an index
    public Boat getBoat(int pos) {
        return this.boats.get(pos);
    }
    
    // Get a boat by its checkPos
    public Boat getBoatByPos(int posX, int posY) {
        Boat result = null;

        for (Boat current : getBoats()) {
            if ((current.getBoatX() == posX) && (current.getBoatY() == posY)) {
                result = current;
            }
        }

        return result;
    }
    
    // Update boat
    public void foundBoat(Boat boat) {
        for (Boat current : getBoats()) {
            current.setFound(true);
        }
    }
    
    // Checks a tile for a boat
    public Boat checkTile(int posX, int posY) {
        Boat result = null;

        // Iteratting over the list of boats
        for (Boat current : getBoats()) {
            
            // Checking the origin point of the boat
            if ((current.getBoatX() == posX) && (current.getBoatY() == posY)) {
                return current;
            }

            // Checking the boats direction
            if (current.getDirection().equals(BoatDirection.NORTH)) {
                for (int index = 0; index < current.getLength(); index++) {
                    if ((current.getBoatX() == posX) && (current.getBoatY() == (posY + index))) {
                        return current;
                    }
                }
            } else if (current.getDirection().equals(BoatDirection.EAST)) {
                for (int index = 0; index < current.getLength(); index++) {
                    if ((current.getBoatX()) == (posX - index) && (current.getBoatY() == posY)) {
                       return current;
                    }
                }
            } else if (current.getDirection().equals(BoatDirection.SOUTH)) {
                for (int index = 0; index < current.getLength(); index++) {
                    if ((current.getBoatX() == posX) && (current.getBoatY() == (posY - index))) {
                        return current;
                    }
                }
            } else if (current.getDirection().equals(BoatDirection.WEST)) {
                for (int index = 0; index < current.getLength(); index++) {
                    if ((current.getBoatX() == (posX + index)) && (current.getBoatY() == posY)) {
                        return current;
                    }
                }
            }
            
        }

        return result;
    }
    // Function to check if the game is complete
    public boolean isComplete() {
        Boolean result = false;

        for (Boat current : getBoats()) {
            if (current.getFound()) {
                result = true;
            }
        }

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
        String[][] tempGameBoard = new String[13][13];

         

        for (int index = 0; index < tempGameBoard.length; index++) {
            for (int jindex = 0; jindex < tempGameBoard[0].length; jindex++) {
                tempGameBoard[index][jindex] = " ";
            }
        }

        //iterating through the x axis
        for(int i = 0; i < 13; i++){
            //iterating through the y axis
            for(int j = 0; j < 13; j++){
                //if in co ord [0,0]
                if(j == 0 & i == 0){
                    tempGameBoard[i][j] = "┌";
                } 
                else if((i == 0 & (j > 0 & j < 12)) || (i == 12 & (j > 0 & j < 12))){ //if in co ord [0,1-11] or [12, 1-11] 
                    tempGameBoard[i][j] =  "─";
                }
                else if(i == 0 & j == 12){ //if in co ord [0,12]
                    tempGameBoard[i][j] =  "┐";
                } 
                else if((i > 0 & i < 12) & (j == 0 || j == 12)) {
                    tempGameBoard[i][j] = "│";
                }
                else if (i == 12 & j == 0){
                    tempGameBoard[i][j] = "└";
                } else if (i == 12 & j == 12){
                    tempGameBoard[i][j] = "┘";
                }
            };
        };
        

        //adds horizontal numbers 
        //iterating through the x axis
        for(int i = 0; i < 13; i++){
            //iterating through the y axis
            for(int j = 0; j < 13; j++){
                if(j == 2 & i == 1){
                    for(int k = 1; k < 11; k++){
                        if (k == 10) {
                            tempGameBoard[i][k+1] = "X";
                        } else {
                            tempGameBoard[i][k+1] = String.valueOf(k);
                        }
                    }
                    
                }
            };
        };

        //adds vertical numbers
        //iterating through the x axis
        for(int i = 0; i < 13; i++){
            //iterating through the y axis
            for(int j = 0; j < 13; j++){
                if(j == 1 & i == 2){
                    for(int k = 1; k < 11; k++){
                        if (k == 10) {
                            tempGameBoard[k+1][j] = "X";
                        } else {
                            tempGameBoard[k+1][j] = String.valueOf(k);
                        }
                    }
                    
                }
            };
        };

        String result = "";

        for (int index = 0; index < tempGameBoard.length; index++) {
            for (int jindex = 0; jindex < tempGameBoard[0].length; jindex++) {

                if ((checkTile(jindex, index) != null) && (checkTile(jindex, index).getFound())) {
                    result += "*";
                } else if (tempGameBoard[index][jindex].equals("")) {
                    result += " ";
                } else {
                    result += tempGameBoard[index][jindex];
                }
            }

            result += "\n";
        }
        
        return result;
    }
}
