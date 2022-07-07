import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

public class zad5 {

//Napisz program wypisujacy w konsoli akualny lokalny i globalny czas.

    public static void main(String[] args) throws IOException {


        Date now = new Date();

        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Warsaw"));
        System.out.println(now);

        //UTC
        TimeZone.setDefault( TimeZone.getTimeZone("UTC"));
        System.out.println(now);
    }
}