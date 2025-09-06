import java.time.LocalDate;
import java.time.Period;

public class DateGap {
    public static void main(String args[]) {
        /*
         * Edge Case 1: Leap Year
         * From: 28-02-2024
         * To: 01-03-2024
         * Expected Output: 0 years, 0 months, 2 days
         * Reason: 2024 is a leap year, so February has 29 days.
         */
        LocalDate from = LocalDate.of(2024, 2, 28);
        LocalDate to = LocalDate.of(2024, 3, 1);
        printDate(Period.between(from, to));

        /*
         * Edge Case 2: End of Month
         * From: 31-01-2025
         * To: 02-03-2025
         * Expected Output: 0 years, 1 month, 2 days
         * Reason: Crossing months with different number of days.
         */
        from = LocalDate.of(2025, 1, 31);
        to = LocalDate.of(2025, 3, 2);
        printDate(Period.between(from, to));

        /*
         * Edge Case 3: Across Years
         * From: 25-12-2024
         * To: 05-01-2025
         * Expected Output: 0 years, 0 months, 11 days
         * Reason: The dates cross a year boundary.
         */
        from = LocalDate.of(2024, 12, 25);
        to = LocalDate.of(2025, 1, 5);
        printDate(Period.between(from, to));

        /*
         * Edge Case 4: Across Years
         * From: 25-12-2024
         * To: 05-03-2026
         * Expected Output: 1 years, 2 months, 8 days
         * Reason: The dates cross a year boundary.
         */
        from = LocalDate.of(2024, 12, 25);
        to = LocalDate.of(2026, 3, 5);
        printDate(Period.between(from, to));
    }

    public static void printDate(Period result) {
        System.out.println(result.getYears() + " Years, " +
                result.getMonths() + " Months, " +
                result.getDays() + " Days");
    }
}
