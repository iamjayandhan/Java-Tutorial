import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
    public static void main(String args[]) throws ParseException{
        //https://www.hackerrank.com/challenges/time-conversion/problem
        System.out.println(" -> "+timeFormat24("07:05:45PM"));
        System.out.println(" -> "+timeFormat24("12:01:45AM"));
        System.out.println(" -> "+timeFormat24("12:01:45PM"));
    }

    public static String timeFormat24(String input) throws ParseException{
        DateFormat dataFormat = new SimpleDateFormat("hh:mm:ssaa");
        DateFormat result = new SimpleDateFormat("HH:mm:ss");
        Date time = null;

        time = dataFormat.parse(input);
        String res = result.format(time);
        return res;
    }
}
