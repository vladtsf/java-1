package connect4.move;

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
