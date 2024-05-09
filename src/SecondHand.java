import java.time.LocalTime;

public class SecondHand extends ClockHand{
    int angle;
    public void setTime(LocalTime clockTime){
        angle = clockTime.getSecond()*6;
    }

    public String toSvg(){
        StringBuilder builder = new StringBuilder();
        builder.append("<line x1=\"0\" y1=\"0\" x2=\"0\" y2=\"-80\" stroke=\"red\" stroke-width=\"1\" transform=\"");
        builder.append("rotate(").append(angle).append(")").append("\"/>");

        System.out.println(builder);
        return builder.toString();
    }
}
