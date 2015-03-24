package observerPattern;

import java.util.Observable;
import java.util.Observer;

public class RandomWalkerObserver implements Observer {
  private int stepsTaken = 0;
  private int howFarLeftTheWalkerHasBeen = 0, 
              howFarRightTheWalkerHasBeen = 0;
  
  private static final int MAX_MONITORED_OFFSET = 30;
  private static final int MONITORED_STEP_SIZE = 10;
  
  private class RandomWalkerNotification {
    
    int position;
    private String message = null;
    
    RandomWalkerNotification(int position) {
      this.position = position;
      init();
    }
    
    public String getMessage() {
      return message;
    }
    
    private void init() {
      String direction = null;
      
      if(Math.abs(position) > MAX_MONITORED_OFFSET) {
        // we're not going to monitor -50 or +100     
      } else if(position == howFarRightTheWalkerHasBeen + MONITORED_STEP_SIZE) {
        direction = "right";
        howFarRightTheWalkerHasBeen = position;
      } else if(position == howFarLeftTheWalkerHasBeen - MONITORED_STEP_SIZE) {
        direction = "left";
        howFarLeftTheWalkerHasBeen = position;
      }
      
      if(direction != null) {
        message = String.format("The walker reached %d spaces to the %s after %d steps.",
              Math.abs(position), direction, stepsTaken);
      }
    }
  }
  
  @Override
  public void update(Observable o, Object arg) {
    int position = ((RandomWalker) o).getPosition();
    RandomWalkerNotification notification = new RandomWalkerNotification(position);
    
    stepsTaken++;
    
    // DEBUG    
    //    System.out.println(stepsTaken + ": " + position);
    if(notification.getMessage() != null) {
      System.out.println(notification.getMessage());
    }
  }
  
}
