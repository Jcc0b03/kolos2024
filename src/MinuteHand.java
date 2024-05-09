import java.time.LocalTime;

public class MinuteHand extends ClockHand{
    int angle;
    public void setTime(LocalTime clockTime){
        angle = clockTime.getMinute()*6;
    }

    public String toSvg(){
        StringBuilder builder = new StringBuilder();
        builder.append("<line x1=\"0\" y1=\"0\" x2=\"0\" y2=\"-70\" stroke=\"black\" stroke-width=\"2\" transform=\"");
        builder.append("rotate(").append(angle).append(")").append("\"/>");

        System.out.println(builder);
        return builder.toString();
    }
}
