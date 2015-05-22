package connect4;

import connect4.move.BombMove;
import connect4.move.Move;
import connect4.player.Player;
import java.awt.Color;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Board implements Cloneable {

  private int rows;
  private int cols;
  
  public final int CONNECT_HOW_MANY = 4;

  /**
   * The grid of pieces
   */
  private Player[][] grid;

  public Board(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    grid = new Player[rows][cols];
    // set each cell of the board to null (empty).
    reset();
  }

  public void reset() {
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        grid[r][c] = null;
      }
    }
  }

  public int getRows() {
    return rows;
  }

  public int getCols() {
    return cols;
  }

  /**
   * Returns the Player whose piece occupies the given location,
   *
   * @param row int
   * @param col int
   */
  public Player getCell(int row, int col) throws IndexOutOfBoundsException {
    if ((row < 0) || (col < 0) || (row >= rows) || (col >= cols)) {
      throw new IndexOutOfBoundsException();
    } else {
      return grid[row][col];
    }
  }
  
  // Returns true if move is possible given board state.  
  public boolean possibleMove(Move move) {
    if(move instanceof BombMove) {
      return true;
    }
    
    return grid[rows - 1][move.getColumn()] == null;
  }

  public boolean isPossibleMove() {
    Player dummyPlayer = new Player("dummy", Color.yellow);
    Move move;
            
    for (int i = cols - 1; i >= 0; i--) {
      move = new Move(i, dummyPlayer);
      
      if(possibleMove(move)) {
        return true;
      }
    }
    
    return false;
  }
  
  // Used only when bomb is landed to get rid of the shifts 
  // that the bomb left after itself
  public void normalize() {
    for (int x = cols - 1; x >= 0; x--) {
      for(int y = 0; y < rows; y++) {
        for(int y1 = y + 1; y1 < rows; y1++) {
          if(grid[y][x] == null) {
            grid[y][x] = grid[y1][x];
            grid[y1][x] = null;
          }
        }
      }
    }
  }
  
  // Adds a piece to the board for a given Move
  public void addPiece(Move move) {
    if(move instanceof BombMove) {
      for(int dx = -1; dx <= 1; dx++) {
        for (int dy = -1; dy <= 1; dy++) {
          try {
            grid[move.getRow() + dy][move.getColumn() + dx] = null;
          } catch(ArrayIndexOutOfBoundsException e) {
            // it's okay, just don't do anything
          }
        }
      }
      
      normalize();
    } else {
      for (int y = 0; y < rows; y++) {
        if(grid[y][move.getColumn()] == null) {
          grid[y][move.getColumn()] = move.getPlayer();
          move.setRow(y);
          return;
        }
      }
    }
  }

  // if the board contains a winning position, returns the Player that wins.
  // Otherwise, returns null.  You could ignore lastMove.
  public Player winner(Move lastMove) {
    for(int x = -1; x <= 1; x++) {
      for(int y = -1; y <= 1; y++) {
        if(x == 0 && y == 0) {
          continue;
        }
        
        if(1 + checkWinnerInDirection(lastMove, x, y) + checkWinnerInDirection(lastMove, -x, -y) >= CONNECT_HOW_MANY) {
          return lastMove.getPlayer();
        }
      }
    }
    return null;
  }
  
  public Player winner() {
    for (int row = 0; row < getRows(); row++) {
      for(int col = 0; col < getCols(); col++) {
        Player player;
        
        if((player = getCell(row, col)) != null) {
          Move move = new Move(col, player);
          Player winner;
          move.setRow(row);
          if((winner = winner(move)) != null) {
            return winner;
          }
        }
      }  
    }
    
    return null;
  }
  
  private int checkWinnerInDirection(Move move, int xDirection, int yDirection) {
    int x = move.getColumn();
    int y = move.getRow();
    
    for (int i = 1; i <= CONNECT_HOW_MANY; i++) {
      try {
        if(grid[y + i * yDirection][x + i * xDirection] != move.getPlayer()) {
          return i - 1;
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        return i - 1;
      }
    }
    
    return 0;
  }
  
  @Override
  public Board clone() {
    Board board = new Board(rows, cols);
    board.grid = new Player[rows][cols];
    
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        board.grid[i][j] = grid[i][j];
      }
    }
    
    return board;
  }
  
  @Override
  public boolean equals(Object o) {
    Board other = (Board) o;
    
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        try {
          if(!grid[row][col].equals(other.grid[row][col])) {
            return false;
          }
        } catch(NullPointerException e) {
          if(grid[row][col] != other.grid[row][col]) {
            return false;
          }
        }
      }
    }
    
    return true;
  }
} // end Board class
