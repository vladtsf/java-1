package alien;

public abstract class Alien {

  private int health; // 0=dead, 100=full strength
  private String name;

  public abstract int getDamage();

  public Alien(int health, String name) {
    this.health = health;
    this.name = name;
  }
}
