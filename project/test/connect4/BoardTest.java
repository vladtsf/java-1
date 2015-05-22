/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

import connect4.move.BombMove;
import connect4.move.Move;
import connect4.player.Player;
import connect4.player.StupidComputerPlayer;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tsvang
 */
public class BoardTest {
  
  public BoardTest() {
  }
  
  private Board 
          emptyBoard,
          onePieceBoard,
          twoPieceBoard,
          bombTarget,
          impossibleMove,
          winnerHorizontal,
          winnerVertical,
          winnerDiagonal;
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, FileNotFoundException {  
    emptyBoard = new BoardFactory().load("empty");
    onePieceBoard = new BoardFactory().load("one_piece");
    twoPieceBoard = new BoardFactory().load("two_pieces");
    bombTarget = new BoardFactory().load("bomb_target");
    impossibleMove = new BoardFactory().load("impossible_move");
    winnerHorizontal = new BoardFactory().load("winner_horizontal");
    winnerVertical = new BoardFactory().load("winner_vertical");
    winnerDiagonal = new BoardFactory().load("winner_diagonal");
  }
  
  @After
  public void tearDown() {
  }

  @Test
  public void addPiece() {
    emptyBoard.addPiece(new Move(3, BoardFactory.player1));
    assertEquals("Should add a piece", emptyBoard, onePieceBoard);
    emptyBoard.addPiece(new Move(3, BoardFactory.player2));
    assertEquals("Should add more than one piece", emptyBoard, twoPieceBoard);
  }
  
  @Test
  public void addBombPiece() {
    bombTarget.addPiece(new BombMove(3, 1, BoardFactory.player1));
    assertEquals("Should be able to handle a bomb piece", bombTarget, emptyBoard);
  }
  
  @Test
  public void possibleMove() {
    assertTrue("On on empty board any move should be possible", emptyBoard.possibleMove(new Move(2, BoardFactory.player1)));
    assertFalse("Should handle an impossible move properly", impossibleMove.possibleMove(new Move(2, BoardFactory.player1)));
    assertTrue("BombMove should work no matter what", impossibleMove.possibleMove(new BombMove(2, 6, BoardFactory.player1)));
  }
  
  @Test
  public void winner() {
    assertNotNull("Should properly determine a horizontal winner", winnerDiagonal.winner());
    assertNotNull("Should properly determine a vertical winner", winnerVertical.winner());
    assertNotNull("Should properly determine a diagonal winner", winnerDiagonal.winner());
    assertNull("Should not return a Player if there's no winner", emptyBoard.winner());
  }
}
