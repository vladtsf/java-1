package connect4.move;

import connect4.Board;
import connect4.Connect4;
import connect4.player.Player;

public class Move {

  private int column;
  private Player player;
  protected int row;

  /**
   * Constructor for objects of class Move
   */
  public Move(int column, Player player) {
    this.column = column;
    this.player = player;
  }
  
  public Move(int column, Player player, Connect4 app) {
    this(column, player);
    
    Board board = app.getBoard();
    
    for (int row = 0; row < board.getRows(); row++) {
      if(board.getCell(row, column) == null) {
        this.row = row;
        break;
      }
    }
  }

  public int getColumn() {
    return this.column;
  }

  public Player getPlayer() {
    return this.player;
  }

  public int getRow() {
    return row;
  }

  public void setRow(int row) {
    this.row = row;
  }
}
