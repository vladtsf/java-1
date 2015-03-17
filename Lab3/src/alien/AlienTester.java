package alien;

public class AlienTester {
  
  public static void main(String[] args) {
    AlienTester tester = new AlienTester();
    tester.test();
  }
  
  public void test() {
    // before all   
    Snake snake = new Snake(100, "Pearl");
    Orge orge = new Orge(100, "Esther");
    MarshmallowMan man = new MarshmallowMan(100, "Arthur");
    AlienPack pack = new AlienPack();
    AlienPack2 pack2 = new AlienPack2();
    int expectedCollectiveDamage = snake.getDamage() + orge.getDamage() + man.getDamage();

    // tests
    module("Aliens");
      context("getDamage()");
        expect("a snake to inflict 10 of damage", snake.getDamage() == 10);
        expect("an orge to inflict 6 of damage", orge.getDamage() == 6);
        expect("a marshmallow man to inflict 1 of damage", man.getDamage() == 1);
        
    module("AlienPack");
      context("addAlien()");
        pack.addAlien(man);
        expect("addAlien() to add an alien", pack.getAliens()[0] == man);
      context("getAliens()");
        pack.addAlien(orge);
        pack.addAlien(snake);
        expect("getAliens() to return the list of aliens of size 3", 
                pack.getAliens().length == 3);
      context("calculateDamage()");
        expect("calculateDamage() to return " + expectedCollectiveDamage, 
                pack.calculateDamage() == expectedCollectiveDamage);
        
    module("AlienPack2");
      context("addAlien()");
        pack2.addAlien(man);
        expect("addAlien() to add an alien", pack2.getAliens()[0] == man);
      context("getAliens()");
        pack2.addAlien(orge);
        pack2.addAlien(snake);
        expect("getAliens() to return the list of aliens of size 3", 
                pack2.getAliens().length == 3);
      context("calculateDamage()");
        expect("calculateDamage() to return " + expectedCollectiveDamage, 
                pack2.calculateDamage() == expectedCollectiveDamage);
        
    // It says, "Alien is abstract; cannot be instantiated"
    //    Alien al = new Alien(1, "Abstract Alien");
  }
  
  
  //////////////////////////////////////////////////////////////////////////////
  // my own unit testing framework =)
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  
  private int nestingLevel = 0;
  
  private boolean deepEqual(Object left, Object right) {
    if(left.equals(right)) {
      return true;
    }
    
    return false;
  }
  
  private boolean expect(String message, boolean result) {
    if(result) {
      printOk("Expecting: " + message);
      return true;
    }
    
    printFail("Expecting: " + message);
    return false;
  }
  
  private String nestingIndentation() {
    String result = "";
    
    for(int i = 0; i < nestingLevel; i++) {
      result += "  ";
    }
    
    return result;
  }
  
  private void module(String name) {
    nestingLevel = 0;
    printNotice(name, ANSI_BLUE);
  }
  
  private void context(String name) {
    nestingLevel = 1;
    printNotice(name, ANSI_YELLOW);
    nestingLevel = 2;
  }
  
  private void printNotice(String message, String color) {
    System.out.println(nestingIndentation() + color + message + ANSI_RESET);
  }
  
  private void printOk(String message) {
    System.out.println(nestingIndentation() + ANSI_GREEN + message + ": √" + ANSI_RESET);
  }
  
  private void printFail(String message) {
    System.out.println(nestingIndentation() + ANSI_RED + message + ": X" + ANSI_RESET);
  }
}
