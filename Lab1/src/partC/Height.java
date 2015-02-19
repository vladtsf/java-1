package partC;
import java.util.Random;

public class Height {
  public int heightInInches = 0;

  public static Height getRandomHeight(int min, int max) {
    Random seed = new Random();
    return new Height(seed.nextInt(max - min + 1) + min);
  }
  
  public static Height getRandomHeight(int max) {
    return getRandomHeight(51, max);
  }
  
  public static Height getRandomHeight() {
    return getRandomHeight(51, 90);
  }
  
  Height(int heightInInches) {
    this.heightInInches = heightInInches;
  }
  
  
}
