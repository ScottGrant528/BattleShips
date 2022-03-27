package uk.ac.rgu.battleships;

import uk.ac.rgu.battleships.gameboard.*;

/**
 *
 * @author euan & scottjjwd
 */
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("----Starting program!----");
        int[] b1BoatOrigin = {2,4};
        Boat b1 = new Boat("Submarine", 2, BoatDirection.NORTH, b1BoatOrigin);
        System.out.println(b1.toString());
    }
}
