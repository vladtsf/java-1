package alien;

public class Snake extends Alien {
  public Snake(int health, String name) {
    super(health, name);
  }

  @Override
  public int getDamage() {
    return 10;
  }
  
}
