package date;

public class Date implements Comparable<Date> {
  
  protected int day, month;
  
  Date(int month, int day) {
    this.day = day;
    this.month = month;
  }

  @Override
  public int compareTo(Date date) {
    int monthDiff = this.month - date.month;
    
    if(monthDiff == 0) {
      return this.day - date.day;
    }
    
    return monthDiff;
  }

  @Override
  public String toString() {
    return String.format("%d/%d", month, day);
  }
}
