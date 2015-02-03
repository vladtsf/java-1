public class Nametag {
  private final int WIDTH = 80;
  private final int MARGIN = 3;
  private final int LEFT_PADDING = 2;

  
  public static void main(String[] args) {
    Nametag tag = new Nametag();
    tag.print();
  }
  
  void print() {
    printDashLine();
    printCenteredLine("annual conference");
    printDashLine();
    printLeftAlignedLine("name:");
    printLeftAlignedLine("");
    printDashLine();
    printLeftAlignedLine("organization:");
    printLeftAlignedLine("");
    printDashLine();
  }
  
  void printCenteredLine(String text) {
    int spacesNumber = (WIDTH - text.length()) / 2 - MARGIN;
    printDashes(MARGIN);
    printCharacter(" ", spacesNumber);
    System.out.print(text.toUpperCase());
    printCharacter(" ", spacesNumber);
    
    if(text.length() % 2 == 1) {
      System.out.print(" ");
    }
    
    printDashes(MARGIN);
    System.out.println();
  }
  
  void printLeftAlignedLine(String text) {
    int spacesNumber = WIDTH - MARGIN * 2 - LEFT_PADDING - text.length();
    
    printDashes(MARGIN);
    printCharacter(" ", LEFT_PADDING);
    System.out.print(text.toUpperCase());
    printCharacter(" ", spacesNumber);
    printDashes(MARGIN);
    System.out.println();
  }
  
  void printDashLine() {
    printDashes(WIDTH);
    System.out.println();
  }
  
  void printDashes(int times) {
    printCharacter("#", times);
  }
  
  void printCharacter(String character, int times) {
    for (int i = 0; i < times; i++) {
      System.out.print(character);
    }
  }
}
