package connect4.player;

import connect4.Board;
import connect4.move.Move;
import java.awt.Color;
import java.util.Random;

/*
 * Class StupidComputerPlayer
 */ 

public class StupidComputerPlayer extends ComputerPlayer {

    public StupidComputerPlayer(String name, Color color) {
        super(name, color);
    }
    
    private Random randGen = new Random();
    
    public Move getMove(Board board) {
        // the stupid computer just chooses randomly.
        return( new Move(randGen.nextInt(board.getCols()), this) );
    }
    

}
