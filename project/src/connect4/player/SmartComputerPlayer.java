package connect4.player;

import connect4.Connect4;
import connect4.Board;
import connect4.move.Move;
import java.awt.Color;
import java.util.Random;

/*
 * Class StupidComputerPlayer
 */ 

public class SmartComputerPlayer extends ComputerPlayer {
    private Connect4 app;

    public SmartComputerPlayer(String name, Color color, Connect4 app) {
        super(name, color);
        this.app = app;
    }
    
    private Random randGen = new Random();
    
    // Your player should always block if the other player has three in a row. 
    private Move checkMateBlock(Board board) {
      for (int col = 0; col < board.getCols(); col++) {
        for (Player player : app.getPlayers()) {
          if(player.equals(this)) {
            continue;
          }
          
          if(board.winner(new Move(col, player, app)) != null) {
            return new Move(col, this);
          }
        }
      }
      
      return null;
    }
    
    @Override
    public Move getMove(Board board) {
      Move checkMate = checkMateBlock(board);
      
      if(checkMate != null) {
        return checkMate;
      }
      
      return( new Move(randGen.nextInt(board.getCols()), this) );
    }
    

}
