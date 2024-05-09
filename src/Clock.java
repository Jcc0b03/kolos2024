import java.time.LocalTime;

public abstract class Clock {
    LocalTime clockTime;

    public City getCity() {
        return city;
    }

    private City city;
    public void setCurrentTime(){
        this.clockTime = LocalTime.now();
    }

    public void setTime(int hour, int minute, int second) throws IllegalArgumentException{
        if(hour < 0 || hour > 23){
            throw new IllegalArgumentException("Hour is not between 0 and 23");
        }

        if(minute < 0 || minute > 59){
            throw new IllegalArgumentException("Minute is not between 0 and 59");
        }

        if(minute < 0 || minute > 59){
            throw new IllegalArgumentException("Second is not between 0 and 59");
        }

        this.clockTime = LocalTime.of(hour, minute, second);
    }

    void setCity(City city){
        if(this.city==null){
            this.city = city;
            return;
        }

        double currentTimeZone = this.city.timeZone;
        double newTimeZone = city.timeZone;

        int timeZoneDifference = Math.toIntExact(Math.round(newTimeZone-currentTimeZone));
        this.clockTime = clockTime.plusHours(timeZoneDifference);
    }

    public String toString(){
        return clockTime.toString();
    }
}
