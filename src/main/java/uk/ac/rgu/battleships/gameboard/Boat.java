package uk.ac.rgu.battleships.gameboard;

// Class to model a boat

public class Boat {
    // Attributes
    private String id;
    private int length;
    private BoatDirection direction;
    private int[] boatOrigin = new int[2];

    // Constructor
    public Boat(String id, int length, BoatDirection direction, int[] boatOrigin) {
        this.id = id;
        this.length = length;
        this.direction = direction;
        this.boatOrigin = boatOrigin;
    }

    // Getters and setters
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public BoatDirection getDirection() {
        return this.direction;
    }

    public void setBoatDirection(BoatDirection direction){
        this.direction = direction;
    }
    
    public int[] getBoatOrigin() {
        return this.boatOrigin;
    }
    
    public void setBoatOrigin(int[] boatOrigin){
        this.boatOrigin = boatOrigin;
    }
    
    public String getBoatOriginString() {
        return "[" + String.valueOf(getBoatOrigin()[0]) + "," + String.valueOf(getBoatOrigin()[1]) + "]";
    }
    // To string method
    public String toString(){
        return ("id = " + getId() + "\nlength = " + getLength() + "\ndirection = " + 
        getDirection().toString() + " \nboatOrigin = " + getBoatOriginString());
    }
} 
