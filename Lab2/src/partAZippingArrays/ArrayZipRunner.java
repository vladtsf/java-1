package partAZippingArrays;

import java.util.Arrays;

public class ArrayZipRunner {
  public static void main(String[] args) {
    ArrayZipper az = new ArrayZipper();
    
    System.out.println(Arrays.toString(az.zip(new int[]{1,2,3}, new int[]{11,12,13})));
    System.out.println(Arrays.toString(az.zip(new int[]{1,2,3,4}, new int[]{11,12})));
    System.out.println(Arrays.toString(az.zip(new int[]{11,12}, new int[]{1,2,3,4})));
    System.out.println(Arrays.toString(az.zip(new int[]{1,2,3}, null)));
    System.out.println(Arrays.toString(az.zip(null, new int[]{1,2,3})));
    System.out.println(Arrays.toString(az.zip(null, null)));
  }
}
