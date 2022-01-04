package test;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class test {
    public static void main(String[] args) throws ParseException {
        LocalTime time = LocalTime.now();
        System.out.println(time);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println(time.format(formatter));

        String start = "8:00";
        System.out.println(String.format(start, formatter));

        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date1 = dateFormat.parse(start);
//        LocalTime date2 = dateFormat.parse(start);
        System.out.println(date1.getTime()>time.getHour());

        Date curDate   =new Date(System.currentTimeMillis());
        System.out.println(date1.after(curDate));
//        System.out.println(time.format(formatter)> );
    }
}
