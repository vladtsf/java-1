package connect4;

import connect4.move.Move;
import connect4.player.Player;

public class Board {

  private int rows;
  private int cols;
  
  private final int CONNECT_HOW_MANY = 4;

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
    return grid[rows - 1][move.getColumn()] == null;
  }
  
  private int possibleMoveRow(Move move) {
    for (int i = 0; i < rows; i++) {
      if(grid[i][move.getColumn()] == null) {
        return i;
      }
    }
    
    return -1;
  }

  // Adds a piece to the board for a given Move
  public void addPiece(Move move) {
    if(possibleMove(move)) {
      int row = possibleMoveRow(move);
      move.setRow(row);
      grid[row][move.getColumn()] = move.getPlayer();
    }
  }

  // if the board contains a winning position, returns the Player that wins.
  // Otherwise, returns null.  You could ignore lastMove.
  public Player winner(Move lastMove) {
    for(int x = -1; x <= 1; x++) {
      for(int y = -1; y <= 1 && !(x == 0 && y == 0); y++) {
        try {
          for(int i = 0; grid[lastMove.getRow() + i * y][lastMove.getColumn() + i * x] == lastMove.getPlayer(); i++) {
            // check boundaries         
            if(i == CONNECT_HOW_MANY - 1) {
              return lastMove.getPlayer();
            }
          }
        } catch(ArrayIndexOutOfBoundsException e) {
          continue;
        }
      }
    }
      
    // TODO: write this.  Currently, there is never a winner.
    return null;
  }
  
//  private void winner(Move lastMove, int x, int y) {
//    
//  }
  
  

} // end Board class
