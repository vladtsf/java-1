package observerPattern;

import java.util.Observable;
import java.util.Observer;

public class Runner {

  public static void main(String[] args) {
    Observable rw = new RandomWalker();
    Observer rwo = new RandomWalkerObserver();
    rw.addObserver(rwo);
    ((RandomWalker) rw).start(1000);
  }

}
