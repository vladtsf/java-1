package partAZippingArrays;

public class ArrayZipper {
  
  public int[] zip(int[] left, int[] right) {
    if(left == null && right == null) {
      return new int[0];
    }
    
    if(left == null) {
      return right;
    } else if(right == null) {
      return left;
    }
    
    int mutualLength = left.length + right.length;
    int[] zipped = new int[mutualLength];
    
    // "i" is the last reached index of the zipped array
    int i = 0;
    
    // "j" is the last reached index of each single array
    for (int j = 0; i < mutualLength; j++) {
      if(j < left.length) {
        zipped[i] = left[j];
        i++;
      }
      
      if(j < right.length) {
        zipped[i] = right[j];
        i++;
      }
    }
    
    return zipped;
  }
}
