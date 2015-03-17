package alien;

public class Orge extends Alien {

  public Orge(int health, String name) {
    super(health, name);
  }
  
  @Override
  public int getDamage() {
    return 6;
  }
}
