
public class Motorcycle {

  String make;
  String color;
  boolean engineState;

  void startEngine() {
    if (engineState == true) {
      System.out.println("The engine is already on.");
    } else {
      engineState = true;
      System.out.println("The engine is now on.");
    }
  }

  void stopEngine() {
    if (engineState == false) {
      System.out.println("The engine is already off.");
    } else {
      engineState = false;
      System.out.println("The engine is now off.");
    }
  }

  void showAtts() {
    System.out.println("This motorcycle is a " + color + " " + make);
    if (engineState == true) {
      System.out.println("The engine is on.");
    } else {
      System.out.println("The engine is off.");
    }
  }
}
