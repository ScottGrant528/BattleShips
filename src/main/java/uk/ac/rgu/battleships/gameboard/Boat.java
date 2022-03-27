package uk.ac.rgu.battleships.gameboard;

// Class to model a boat

public class Boat {
    // Attributes
    private String id;
    private int length;
    private BoatDirection direction;
    private int boatx; private int boaty; //boatymcboatface
    private boolean found;

    // Constructor
    public Boat(String id, int length, BoatDirection direction, int boatx, int boaty, boolean found) {
        this.id = id;
        this.length = length;
        this.direction = direction;
        this.boatx = boatx + 1;
        this.boaty = boaty + 1;
        this.found = found;
    }

    public Boat(String id, int length, BoatDirection direction, int boatx, int boaty) {
        this.id = id;
        this.length = length;
        this.direction = direction;
        this.boatx = boatx + 1;
        this.boaty = boaty + 1;
        this.found = false;
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
    
    public int getBoatX() {
        return this.boatx;
    }
    
    public void setBoatX(int boatx) {
        this.boatx = boatx;
    }

    public int getBoatY() {
        return this.boaty;
    }

    public void setBoatY(int boaty) {
        this.boaty = boaty;
    }
    
    public boolean getFound(){
        return this.found;
    }

    public void setFound(Boolean found) {
        this.found = found;
    }
    
    // To string method
    public String toString(){
        return ("id = " + getId() + "\nlength = " + getLength() + "\ndirection = " + 
        getDirection().toString() + " \nboatOrigin = " + "[" + getBoatX() + "," + getBoatY() + "]" + "\nfound = " + getFound());
    }
} 
