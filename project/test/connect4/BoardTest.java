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
          bombTarget;
//  private Board boardWithTwoDots;
//  private Player p1 = new Player("vova", Color.yellow);
//  private Player p2 = new StupidComputerPlayer("computer", Color.yellow);
//  private Field grid;
  
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
  }
  
  @After
  public void tearDown() {
    emptyBoard = null;
    onePieceBoard = null;
    twoPieceBoard = null;
    bombTarget = null;
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
}
