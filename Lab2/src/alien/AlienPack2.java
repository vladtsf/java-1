package alien;
import java.util.ArrayList;

public class AlienPack2 extends ArrayList<Alien> {
  
  public void addAlien(Alien newAlien) {
    add(newAlien);
  }

  public Alien[] getAliens() {
    return toArray(new Alien[size()]);
  }

  public int calculateDamage() {
    int damage = 0;

    for (Alien alien : this) {
      damage += alien.getDamage();
    }
    
    return damage;
  }
}
