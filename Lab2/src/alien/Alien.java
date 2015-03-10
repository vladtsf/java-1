package alien;

public class Alien {

  private int health; // 0=dead, 100=full strength
  private String name;
  protected int damage;

  public int getDamage() {
    return damage;
  }

  public Alien(int health, String name) {
    this.health = health;
    this.name = name;
  }
}
