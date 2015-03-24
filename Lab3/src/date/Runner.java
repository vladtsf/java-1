package date;

import java.util.Arrays;

public class Runner {
  
  public static void main(String[] args) {
    dateArrayTest();
  }

  public static void dateArrayTest() {
    Date[] dArray = new Date[4];
    dArray[0] = new Date(5, 2);  // May 2nd 
    dArray[1] = new Date(2, 9);  // Feb 9th 
    dArray[2] = new Date(6, 3);  // June 3rd 
    dArray[3] = new Date(1, 11); // Jan 11th 
    Arrays.sort(dArray);
    for (int k = 0; k < dArray.length; k++) {
      System.out.println(dArray[k]);
    }
        // should print the dates in chronological order: 
    // 1/11, 2/9, 5/2, 6/3 

  }

}
