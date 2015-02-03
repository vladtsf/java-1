
public class TriangleDrawer {

  // these statements are jumbled up!  
  // Use *some* of the statements below, with some 
  // close braces, so that a triangle is drawn:
  //      *
  //      **
  //      ***
  // ... up to SIZE height and width
  public static void main(String[] args) {
    int row = 0;
    int SIZE = 10;
    
    while (row < SIZE) {
      row = row + 1;
      int col = 0;
      
      while (col < row) {
        System.out.print("*");
        col = col + 1;
      }
      
      System.out.println();
    }
  }
}
