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
        
        // Storing the score of the player
        int moveCounter = 0;
        
        // Creating the game board
        GameBoard gameBoard = new GameBoard();

        // Creating the boats and adding them to the gameboard
        gameBoard.addBoat(new Boat("Submarine", 3, BoatDirection.EAST,1,1));
        gameBoard.addBoat(new Boat("Battleship", 4, BoatDirection.EAST,1,2));
        gameBoard.addBoat(new Boat("Carrier", 5, BoatDirection.EAST,1,3));
        gameBoard.addBoat(new Boat("Destroyer", 2, BoatDirection.EAST,1,4));
        gameBoard.addBoat(new Boat("Cruiser", 3, BoatDirection.EAST,1,5));
        
        // Main Loop
        while (!gameBoard.isComplete()) {
            // Counting the number of moves
            moveCounter++;

            // Displaying gameboard
            System.out.println(gameBoard.toString());

            // Getting the users move
            Scanner userInput = new Scanner(System.in);
            System.out.println("Please enter where you want to fire a missile!!!: (x,y)");
            String[] input = userInput.nextLine().split(",");
            int posx = Integer.parseInt(input[0]); int posy = Integer.parseInt(input[1]);
            userInput.close();

            // Checking if the move hit a ship
            Boat result = gameBoard.checkTile(posx + 1, posy + 1);

            // Checking results
            if (result== null) {
                // Miss
                System.out.println("You missed!! Try again.");
            } else {
                // Hit
                gameBoard.foundBoat(result);
                System.out.println("You hit a " + result.getId() + "!!");
            }
        }

       System.out.println("---You Win!!---\nYou're final score is: " + moveCounter + "\nHow aboat that ;)!!!");
    }
}
