package observerPattern;

import java.util.Observable;
import java.util.Random;
import java.util.Timer;

public class RandomWalker extends Observable {

  private Random r = new Random();
  private Timer t = new Timer();
  
  private int position = 0;
  
  public int getPosition() {
    return position;
  }

  // sleepTime is in milliseconds (thousands of a second)
  public void start(int repetitions) {
    for (int i = 0; i < repetitions; i++) {
      walk();
      try {
        Thread.sleep(50);     // this waits 50/1000 of a second before repeating
      } catch (InterruptedException ex) {
        System.out.println("Got interrupted before the time was up!");
      }
    }
  }

  private void walk() {
    if (r.nextBoolean()) {
      // walk left
      position--;
    } else {
      // walk right
      position++;
    }
    
    setChanged();
    notifyObservers();
  }

}
