package connect4;

import connect4.move.BombMove;
import connect4.move.Move;
import connect4.player.Player;
import connect4.player.ComputerPlayer;
import connect4.player.SmartComputerPlayer;
import connect4.player.StupidComputerPlayer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect4 extends JPanel implements MouseListener, KeyListener {

    // These control the size of the board.  The traditional Connect 4 board is 
  // seven spaces wide by six spaces high
  private static final int ROWS = 6;
  private static final int COLS = 7;

  private static final int pieceSize = 50;     //size of the pieces in pixels
  private static final int spacing = 10;       //spacing between adjacent pieces in pixels;
  private static final int headerHeight = 50;  // height of header for messages and column numbers
  private String message = "";

  private JFrame myFrame;
  private Board myBoard;

  // this contains the ordered list of players in the game
  private ArrayList<Player> players;
  private int currentPlayerIndex = 0;
  
  private boolean isGameOver = false;
  
  // literally tells us if the "b" button is pressed 
  private boolean isBombMoveRequested = false;

  private Cursor bombSelectedCursor;
  private Cursor bombSelectedDisabledCursor;
  
  
  /**
   * creates the connect four interface with the specified number of rows and
   * colonms
   *
   * @param rows int
   * @param cols int
   */
  public Connect4(int rows, int cols) {
    myFrame = new JFrame();
    this.myBoard = new Board(rows, cols);
    addMouseListener(this);
    // the hard numbers at the end are for the menubar at the top and side handles
    myFrame.setSize(myBoard.getCols() * (pieceSize + spacing) + spacing + 10,
            myBoard.getRows() * (pieceSize + spacing) + spacing + headerHeight + 35);
    myFrame.add(this);
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //myFrame.setResizable( false );
    myFrame.setTitle("Connect Four");
    myFrame.setVisible(true);
    
    myFrame.setFocusable(true);
    myFrame.addKeyListener(this);
    
    initCursors();
    
    // start a new game 
    newGame();
  }

  private void initCursors() {
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Image bomb = toolkit.getImage("assets/images/bomb.gif");
    Image disabledBomb = toolkit.getImage("assets/images/bomb-disabled.gif");
    Point cursorHotSpot = new Point(16, 16);
    bombSelectedCursor = toolkit.createCustomCursor(bomb, cursorHotSpot, "BombSelectedCursor");
    bombSelectedDisabledCursor = toolkit.createCustomCursor(disabledBomb, cursorHotSpot, "BombSelectedDisabledCursor");
  }
  
  //////  Gameplay
  //////
  // Note, the main loop in the gameplay (players alternating turns) happens between 
  //  the play() and takeTurn() methods.  These call each other, which is a type of
  //  recursion (called mutual recursion).  
  // Call newGame() to restart the game, or start it for the first time.
  public void newGame() {
    myBoard.reset();
    players = new ArrayList<Player>();
    Player p1 = new Player("Jane", Color.black);
//    Player p2 = new Player("Joe", Color.red);
    Player p2 = new SmartComputerPlayer("Robot Joe", Color.red, this);
    players.add(p1);
    players.add(p2);

    message = "Let's play!  " + getCurrentPlayer().getName() + " goes first.  ";
    repaint();
    play();
  }

  public ArrayList<Player> getPlayers() {
    return players;
  } 
  
  public Board getBoard() {
    return myBoard;
  }
  
  // start the recursion to play the game.  
  private void play() {
    if ((getCurrentPlayer() instanceof ComputerPlayer)) {
            // the player is a ComputerPlayer, so can calculate its own move
      // only ComputerPlayers have a getMove method, so we have to cast getCurrentPlayer into one.
      ComputerPlayer computer = (ComputerPlayer) getCurrentPlayer();
      takeTurn(computer.getMove(myBoard));
    }
    // otherwise, the player isn't a ComputerPlayer, so we stop, and let the listener invoke takeTurn()
  }

  private void takeTurn(Move move) {
    // quit
    if(!myBoard.isPossibleMove()) {
      isGameOver = true;
      message = "Draw – No one won.  ";
      repaint();
      return;
    }
    
    if(isGameOver) {
      return;
    }
    
    myBoard.addPiece(move);
    message = getCurrentPlayer().getName() + " goes in column " + move.getColumn() + ".  ";

    Player winner;
    
    if(move instanceof BombMove && (winner = myBoard.winner()) != null) {
      isGameOver = true;
      message += winner.getName() + " wins!  " + winner.getName() + " wins!  ";
      repaint();
    } else if (myBoard.winner(move) != null) {
      isGameOver = true;
      message += getCurrentPlayer().getName() + " wins!  " + getCurrentPlayer().getName() + " wins!  ";
      repaint();
    } else {
      advanceToNextPlayer();
      message += "It is now " + getCurrentPlayer().getName() + "'s turn.  ";
      repaint();
      play();
    }
  }

  // returns the current player
  private Player getCurrentPlayer() {
    return players.get(currentPlayerIndex);
  }

  // advance the next player in line
  private void advanceToNextPlayer() {
    currentPlayerIndex++;
    if (currentPlayerIndex == players.size()) {
      currentPlayerIndex = 0;
    }
  }
  
  //////Listener
  //////
  @Override
  public void mouseClicked(MouseEvent e) {
    Player player = getCurrentPlayer();
    // only process the click if the current player isn't a computer player
    if (!(player instanceof ComputerPlayer)) {
      // find out which column was clicked on...
      int column = myBoard.getCols();
      
      while ((e.getX() < horizontalPos(column)) && (column > 0)) {
        column--;
      }
      
      // find out which column was clicked on...
      int row = 0;
      
      while ((e.getY() < verticalPos(row)) && (row < myBoard.getRows())) {
        row++;
      }
      
      // and restart the gameplay recursion
      Move move = new Move(column, player);

      try {
        if(isBombMoveRequested) {
          move = new BombMove(column, row, player);
          player.useBomb();
          
          if(!player.hasBomb()) {
            myFrame.setCursor(bombSelectedDisabledCursor);
            isBombMoveRequested = false;
          }
        }
      } catch (Player.PlayerOutOfBombsException ex) {
        Logger.getLogger(Connect4.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      if(myBoard.possibleMove(move)) {
        takeTurn(move);
      }
    }
  }

  @Override
  public void mouseEntered(MouseEvent e) {
  }

  @Override
  public void mouseExited(MouseEvent e) {
  }

  @Override
  public void mousePressed(MouseEvent e) {
  }

  @Override
  public void mouseReleased(MouseEvent e) {
  }
  
  @Override
  public void keyPressed(KeyEvent e) {
    if(isGameOver) {
      return;
    }
    
    // "b" is pressed
    if(e.getKeyCode() == 66) {
      Player player = getCurrentPlayer();
      
      if(player.hasBomb()) {
        isBombMoveRequested = true;
        myFrame.setCursor(bombSelectedCursor);
      } else {
        myFrame.setCursor(bombSelectedDisabledCursor);
      }
      
    } 
  }
  
  @Override
  public void keyReleased(KeyEvent e) {
    // "b" is released
    if(e.getKeyCode() == 66) {
      isBombMoveRequested = false;
      myFrame.setCursor(Cursor.DEFAULT_CURSOR);
    }
  }
  
  @Override
  public void keyTyped(KeyEvent e) {
  }
  
//  public void 

  ///// GRAPHICS
  /////
  public void paint(Graphics g) {
    g.setColor(Color.BLUE);
    g.fillRect(0, 0, myFrame.getWidth(), myFrame.getHeight());
    Player cell;

    // draw column header (numbers and message)
    g.setColor(Color.white);
    g.drawString(message, pieceSize, headerHeight - 25);
    for (int c = 0; c < myBoard.getCols(); c++) {
      g.drawString(Integer.toString(c), horizontalPos(c) + pieceSize / 2 - 4, headerHeight);
    }

    // draw pieces
    for (int r = 0; r < myBoard.getRows(); r++) {
      for (int c = 0; c < myBoard.getCols(); c++) {
        cell = myBoard.getCell(r, c);
        if (cell != null) {
          drawPiece(g, r, c, cell.getColor());
        } else {
          drawPiece(g, r, c, Color.gray);
        }
      }
    }
  }

  //shows a piece at location row r and col column for given color
  private void drawPiece(Graphics g, int r, int c, Color color) {
    g.setColor(color);
    g.fillOval(horizontalPos(c), verticalPos(r), pieceSize, pieceSize);

    g.setColor(Color.white);
    g.drawOval(horizontalPos(c) - 1, verticalPos(r) - 1, pieceSize + 1, pieceSize + 1);

        //g.setColor( new Color( 128, 128, 0 ) );
    //g.drawOval( horizontalPos(column), verticalPos(r), pieceSize, pieceSize );
  }

  // returns the horizontal pixel position of a given 0-based column index   
  private int horizontalPos(int c) {
    return (spacing + c * (pieceSize + spacing));
  }

  // returns the vertical pixel position of a given 0-based row index   
  private int verticalPos(int r) {
    return (spacing + headerHeight + (myBoard.getRows() - r - 1) * (pieceSize + spacing));
  }

  // This method causes your program to pause for a certain number of milliseconds
  private void delay(int ms) {
    try {
      Thread.sleep(ms);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

    ////// Main
  //////
  public static void main(String[] args) {
    Connect4 connect4 = new Connect4(ROWS, COLS);
  }

}
