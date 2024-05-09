import java.time.LocalTime;

public class HourHand extends ClockHand{
    int angle;

    int map(int x, int in_min, int in_max, int out_min, int out_max) {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }
    public void setTime(LocalTime clockTime){
        this.angle = map(clockTime.getHour(), 0, 24, 0, 180);
    }

    public String toSvg(){
        StringBuilder builder = new StringBuilder();
        builder.append("<line x1=\"0\" y1=\"0\" x2=\"0\" y2=\"-50\" stroke=\"black\" stroke-width=\"4\" transform=\"");
        builder.append("rotate(").append(angle).append(")").append("\"/>");

        System.out.println(builder);
        return builder.toString();
    }
}
