package firstProject;

import info.gridworld.actor.Bug;
import java.awt.Color;
import java.util.Random;

public class WildBug extends Bug {
  private Random rand = new Random();
  
  
  public WildBug() {
    super();
  }

  @Override
  public void act() {
    for (int i = 0; i < rand.nextInt(4  ); i++) {
      turn();
    }

    super.act();
  }
}
