public class DigitalClock extends Clock{

    TimeFormat format;
    public enum TimeFormat {
        twelveHours,
        twentyFourHours
    }

    DigitalClock(TimeFormat format, City city){

        this.format = format;
        this.setCity(city);
    }

    @Override
    public String toString() {
        StringBuilder timeStringBuilder = new StringBuilder();

        //for 12H time format
        if(format==TimeFormat.twelveHours){
            int hourInTwelveHours;

            if(clockTime.getHour()==12){
                hourInTwelveHours = 12;
            }else{
                hourInTwelveHours = clockTime.getHour()%12;
            }


            String dayTime = "";
            if(clockTime.getHour() < 12){
                dayTime = "AM";
            }else{
                dayTime = "PM";
            }

            //hour
            if(hourInTwelveHours < 10){
                timeStringBuilder.append("0");
            }
            timeStringBuilder.append(hourInTwelveHours).append(":");

            //minute
            if(clockTime.getMinute() < 10){
                timeStringBuilder.append("0");
            }

            timeStringBuilder.append(clockTime.getMinute()).append(":");

            //second
            if(clockTime.getSecond() < 10){
                timeStringBuilder.append("0");
            }

            timeStringBuilder.append(clockTime.getSecond()).append(" ");

            //AM/PM
            timeStringBuilder.append(dayTime);

            return timeStringBuilder.toString();
        }

        //for 24H time format

        //hour
        if(clockTime.getHour() < 10){
            timeStringBuilder.append("0");
        }
        timeStringBuilder.append(clockTime.getHour()).append(":");

        //minute
        if(clockTime.getMinute() < 10){
            timeStringBuilder.append("0");
        }
        timeStringBuilder.append(clockTime.getMinute()).append(":");

        //second
        if(clockTime.getSecond() < 10){
            timeStringBuilder.append("0");
        }
        timeStringBuilder.append(clockTime.getSecond());

        return timeStringBuilder.toString();
    }
}
