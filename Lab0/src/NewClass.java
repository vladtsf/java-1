/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tsvang
 */
public class NewClass {
  
  public static void main(String[] args) {
    int n = 3;
    int sum = sum1(n);
    System.out.println("Sum of first " + n + " ints is " + sum);
  }
  
  public static int sum1(int n) {
    int total = 0;
    int i = 1;
    
    while(i <= n) {
      total += i;
      i++;
    }
    
    return total;
  }
}
