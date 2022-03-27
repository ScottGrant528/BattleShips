package uk.ac.rgu.battleships;

import java.util.Scanner;

import uk.ac.rgu.battleships.gameboard.*;

/**
 *
 * @author euan & scottjjwd
 */
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("---Welcome to 2D Terminal Battleships!---");
        //int[] b1BoatOrigin = {2,4};
        //Boat b1 = new Boat("Submarine", 2, BoatDirection.NORTH, b1BoatOrigin);
        //System.out.println(b1.toString());
        
        // Storing the score of the player
        int moveCounter = 0;
        
        // Creating the game board
        GameBoard gameBoard = new GameBoard();

        gameBoard.addBoat(new Boat("Submarine", 3, BoatDirection.EAST,1,1));
        gameBoard.addBoat(new Boat("Battleship", 4, BoatDirection.EAST,1,2));
        gameBoard.addBoat(new Boat("Carrier", 5, BoatDirection.EAST,1,3));
        gameBoard.addBoat(new Boat("Destroyer", 2, BoatDirection.EAST,1,4));
        gameBoard.addBoat(new Boat("Cruiser", 3, BoatDirection.EAST,1,5));
        
       //System.out.println(gameBoard.toString());
        //System.out.println(gameBoard.getBoats());
        
        
        while (!gameBoard.isComplete()) {
            moveCounter++;
            System.out.println(gameBoard.toString());
            Scanner userInput = new Scanner(System.in);
            System.out.println("Please enter where you want to fire a missile!!!: (x,y)\n");
            String[] input = userInput.nextLine().split(",");
            int posx = Integer.parseInt(input[0]); int posy = Integer.parseInt(input[1]);
            
            Boat result = gameBoard.checkTile(posx + 1, posy + 1);

            if (result== null) {
                System.out.println("You missed loser!! Try again nerd.");
            } else {
                gameBoard.foundBoat(result);
                System.out.println("You hit a " + result.getId() + "!!");
            }
        }

       System.out.println("---You Win!!---\nYou're final score is: " + moveCounter + "\nHow aboat that ;)!!!");
   
        
    }
}
