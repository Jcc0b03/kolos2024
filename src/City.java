import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.*;

public class City {
    String name;

    double timeZone;
    String szerokoscGeograficzna;
    String dlugoscGeograficzna;

    private City(String name, double timeZone, String szerokoscGeograficzna, String dlugoscGeograficzna){
        this.name = name;
        this.timeZone = timeZone;
        this.szerokoscGeograficzna = szerokoscGeograficzna;
        this.dlugoscGeograficzna = dlugoscGeograficzna;
    }

    static City parseLine(String fileLine){
        StringTokenizer parser = new StringTokenizer(fileLine, ",");

        String cityName = parser.nextToken();
        double timeZone = Double.valueOf(parser.nextToken().replace("+", "").trim());
        String szerokoscGeograficzna = parser.nextToken();
        String dlugoscGeograficzna = parser.nextToken();

        return new City(cityName, timeZone, szerokoscGeograficzna, dlugoscGeograficzna);
    }

    public static HashMap<String, City> parseFile(Path filePath){
        File dataFile = new File(filePath.toString());
        HashMap cities = new HashMap<String, City>();
        try{
            Scanner reader = new Scanner(dataFile);
            reader.nextLine(); //skipping first line
            while(reader.hasNextLine()){
                String currentLine = reader.nextLine();
                City parsedCity = parseLine(currentLine);
                cities.put(parsedCity.name, parsedCity);
            }
            return cities;
        }catch(FileNotFoundException e){
            throw new RuntimeException(e.toString());
        }
    }

    double map(double x, double in_min, double in_max, double out_min, double out_max) {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }

    public LocalTime localMeanTime(LocalTime time){
        return null;
    }

    public static void generateAnalogClockSvg(List<City>cities, AnalogClock clock){
        String directory = clock.toString();

        new File(directory).mkdirs();


        for(City city : cities){
            clock.setCity(city);
            clock.toSvg(Paths.get(directory+"/"+city.name+".svg"));
        }
    }
    int map(int x, int in_min, int in_max, int out_min, int out_max) {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }
    public int parseDlugoscGeograficzna(){
        StringTokenizer tokenizer = new StringTokenizer(this.dlugoscGeograficzna, " ");
        String data = tokenizer.nextToken();
        String east_west = tokenizer.nextToken();

        if(east_west=="E"){
            return (int) (Double.parseDouble(data)*-1);
        }

        return (int) Double.parseDouble(data);
    }
    public static void worstTimezoneFit(List<City> cities){
        cities.sort(new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return 1;
            }
        });
    }
}
