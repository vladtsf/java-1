
public class MotorcycleTester {

  public static void main(String[] args) {
    Motorcycle m = new Motorcycle();
    m.make = "Kawasaki 1900";
    m.color = "red";

    System.out.println("Calling showAtts...");
    m.showAtts();
    System.out.println("________");
    System.out.println("Starting engine...");
    m.startEngine();
    System.out.println("________");
    System.out.println("Calling showAtts...");
    m.showAtts();
    System.out.println("________");
    System.out.println("Stopping engine...");
    m.stopEngine();
    System.out.println("________");
    System.out.println("Stopping engine...");
    m.stopEngine();
  }
}
