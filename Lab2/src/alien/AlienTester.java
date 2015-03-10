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
        
    /*
        # describe which of the AlienPack/AlienPack2 classes you prefer. Which 
        was easier to write? 
        > I would rather go AlienPack2, because I can literally get rid of the
        `addAlien()` as well as `getAliens()` methods. Basically, AlienPack is
        a list of aliens that provides accessors. Instead of implementing the
        accessor methods, I would extend from ArrayList and implement only 
        `calculateDamage().` With that being said, it was much easier to write
        AlienPack2 rather than AlienPack
        
        # Which would be easier for some else to use?
        > It would be easier for anyone who knows Java to use AlienPack2. As soon
        as they realize the class is inherited from ArrayList, they will feel 
        themselves more comfortable, because they can use ArrayList's API and know 
        nothing about mine.
        
        # Which would be safer for someone else to use?
        > AlienPack seems to be safer since it stops the user from removing aliens.
        However, it is possible to implement almost the same behavior in AlienPack2 
        by overriding the `remove()` method and making it do nothing.
    */    
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
