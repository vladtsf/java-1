package connect4.player;

import connect4.Connect4;
import connect4.Board;
import connect4.move.BombMove;
import connect4.move.Move;
import java.awt.Color;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    private Move twoInRowBlock(Board board) {
      for (Player player : app.getPlayers()) {
        if(player != this) {
          for(int col = 0; col < board.getCols() - 3; col++) {
            Board newBoard = board.clone();

            newBoard.addPiece(new Move(col, player, app));
            if(newBoard.winner(new Move(col + 3, player, app)) != null) {
              return new Move(col, this, app);
            }
          }
        }
      }
      
      return null;
    }
    
    private Move closestToCenter(Board board) {
      for(int row = 0; row < board.getRows(); row++) {
        for(int d = 0; d < board.getCols() / 2; d++) {
          try {
            int col1 = ((int) (board.getCols() / 2)) + d;
            int col2 = ((int) (board.getCols() / 2)) - d;
            
            if(board.getCell(row, col1) == null) {
              return new Move(col1, this, app);
            } else if(board.getCell(row, col2) == null) {
              return new Move(col2, this, app);
            }
          } catch (ArrayIndexOutOfBoundsException e) {
          }
        }
      }
      
      // it should neve happen      
      return null;
    }
    
    // if we know for sure that some move can make us a winner,
    // we should definitely make that move
    public Move otherSmartThing(Board board) {
      
      for (int col = 0; col < board.getCols(); col++) {  
        Move move = new Move(col, this, app);
        if(board.winner(move) != null) {
          if(board.possibleMove(move))
          return move;
        }
      }
      
      return null;
    }
    
    private BombMove considerBombMove(Board board) {
      if(!this.hasBomb()) {
        return null;
      }
      
      for (Player player : app.getPlayers()) {
        if(player != this) {
          for (int col = 0; col < board.getCols(); col++) {
            Move move = new Move(col, player, app);
            
            if(board.winner(move) != null) {
              return new BombMove(move.getColumn(), move.getRow(), this);
            }
          }
        }
      }
      
      return null;
    }
    
    @Override
    public Move getMove(Board board) {
      Move checkMate = checkMateBlock(board);
      Move twoInRow = twoInRowBlock(board);
      Move otherSmartThing = otherSmartThing(board);
      BombMove bombMove = considerBombMove(board);

      if(checkMate != null) {
        return checkMate;
      }
      
      if(twoInRow != null) {
        return twoInRow;
      }
      
      if(otherSmartThing != null) {
        return otherSmartThing;
      }
      
      if(bombMove != null) {
        return bombMove;
      }
      
      return closestToCenter(board);
    }
    

}
