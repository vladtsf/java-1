import java.util.Scanner;

public class DateConverter {

    // Asks user for a integer bewteen 1 and 366, a day number in a leap year
    //  (a year with 29 days in February, such as 2016).
    // Prints the date in month/day format.
    // Example: 
    //   if the user enters 365, this should print 12/30
    //
    // Fill in missing code where indicated (***), although perhaps not in every spot
    public static void main(String[] args) {
        int dayOfYear;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of a day in a leap year (1-366): ");
        dayOfYear = scanner.nextInt();

        convertDayOfYear(dayOfYear);
    }

    public static void convertDayOfYear(int dayOfYear) {
        int month, dateInMonth, daysInMonth;
        month = 1;
        daysInMonth = 31;

        while (dayOfYear > daysInMonth) {
            dayOfYear -= daysInMonth;
            month++;
            daysInMonth = daysInMonth(month);
        }

        dateInMonth = dayOfYear;
        System.out.println(month + "/" + dateInMonth);
    }

    public static int daysInMonth(int month) {
      switch(month) {
        case 2:
          return 29;
        case 4:
        case 6:
        case 9:
        case 11:
          return 30;
        default:
          return 31;
      }
    }
}
/*
  SAMPLE RUNS:
    > Enter the number of a day in a leap year (1-366): 365
    > 12/30

    > Enter the number of a day in a leap year (1-366): 32
    > 2/1

    > Enter the number of a day in a leap year (1-366): 1
    > 1/1

    > Enter the number of a day in a leap year (1-366): 366
    > 12/31

    > Enter the number of a day in a leap year (1-366): 60
    > 2/29

    > Enter the number of a day in a leap year (1-366): 61
    > 3/1  
*/


