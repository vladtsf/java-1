package connect4.player;

import java.awt.Color;

/**
 * Player class.  
 * Represents players who get their input from a listener (i.e., a users click)
 */
public class Player {
  
  public class PlayerOutOfBombsException extends Exception {
    PlayerOutOfBombsException(String name) {
      super("Player " + name + " doesn't have any bombs to use!");
    }
  }

	private String name;
	private Color color;
	private int numBombs = 2;
    
    
    public Player (String name, Color color) {
        this.name = name;
        this.color = color;
    }
    
    public String getName() {
        return name;
    }
    
    public Color getColor() {
        return color;
    }
    
    @Override
    public boolean equals(Object o) {
      Player other = (Player) o;
      
      return color.equals(color) && name.equals(other.name);
    }
    
    
    public boolean hasBomb () {
        return (numBombs != 0);
    }
    

    // this method will generate an error -- an exception! -- if there are no bombs.
    public void useBomb() throws PlayerOutOfBombsException {
        if (numBombs == 0) {
            throw new PlayerOutOfBombsException(name);
        } else {
            numBombs -= 1;
        }
    }

} // end Player class
