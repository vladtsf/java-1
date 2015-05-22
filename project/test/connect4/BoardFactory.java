package connect4;

import connect4.player.ComputerPlayer;
import connect4.player.Player;
import connect4.player.SmartComputerPlayer;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BoardFactory {
//  private static init
  
  public Connect4 app;
  public static Player player1, player2;

  public BoardFactory() {
    app = new Connect4(6, 7);
    player1 = new SmartComputerPlayer("SmartComputer", Color.blue, app);
    player2 = new Player("Player", Color.red);
  }
  
  public Board load(String fName) {
    try {
      List<String> lines = Files.readAllLines(Paths.get("test/connect4/fixtures/boards/" + fName +  ".txt"));
      Player[][] grid = new Player[6][7];
      
      int row = 5;
      
      for (String line : lines) {
        for(int col = 0; col < line.length(); col++) {
          char ch = line.charAt(col);
          switch(ch) {
            case '1':
              grid[row][col] = player1;
              break;
            case '2':
              grid[row][col] = player2;
              break;
          }
        }
        
        row--;
      }

      Board board = app.getBoard();
      Field grd = Board.class.getDeclaredField("grid");
      grd.setAccessible(true);
      
      grd.set(board, grid);
      return board;
    } catch (IOException ex) {
      Logger.getLogger(BoardFactory.class.getName()).log(Level.SEVERE, null, ex);
    } catch (NoSuchFieldException ex) {
      Logger.getLogger(BoardFactory.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SecurityException ex) {
      Logger.getLogger(BoardFactory.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalArgumentException ex) {
      Logger.getLogger(BoardFactory.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(BoardFactory.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return null;
  }
}
