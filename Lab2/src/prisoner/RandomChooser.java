package prisoner;

import java.util.Random;

public class RandomChooser extends Player {

  private Random rand = new Random();
  
  public RandomChooser(String name) {
    super(name);
  }
  
  @Override
  public boolean cooperate() {
    return rand.nextBoolean();
  }
  
}
