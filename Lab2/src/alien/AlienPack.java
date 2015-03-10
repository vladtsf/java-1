package alien;

import java.util.ArrayList;

public class AlienPack {

  private ArrayList<Alien> aliens;

  public AlienPack() {
    aliens = new ArrayList<>();
  }

  public void addAlien(Alien newAlien) {
    aliens.add(newAlien);
  }

  public Alien[] getAliens() {
    return aliens.toArray(new Alien[aliens.size()]);
  }

  public int calculateDamage() {
    int damage = 0;

    for (Alien alien : aliens) {
      damage += alien.getDamage();
    }
    
    return damage;
  }
}
