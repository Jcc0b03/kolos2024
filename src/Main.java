import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HashMap<String, City> cities = City.parseFile(Paths.get("data/strefy.csv"));
        City warsaw = cities.get("Warszawa");

        DigitalClock test = new DigitalClock(DigitalClock.TimeFormat.twentyFourHours, cities.get("Warszawa"));
        test.setCurrentTime();
        System.out.println(test);

        test.setCity(cities.get("Kijów"));
        System.out.println(test);

        AnalogClock test2 = new AnalogClock();
        test2.setCurrentTime();

        test2.toSvg(Paths.get("data/test.svg"));

        HourHand testsecondhand = new HourHand();
        testsecondhand.setTime(LocalTime.now());

        List<City> cities2= new ArrayList<City>(cities.values());
        City.generateAnalogClockSvg(cities2, test2);

        System.out.println(cities.get("Warszawa").parseDlugoscGeograficzna());
    }
}