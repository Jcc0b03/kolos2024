import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AnalogClock extends Clock{

    List<ClockHand> hands;

    private void setHands(){
        this.hands = new ArrayList<ClockHand>();

        HourHand hourHand = new HourHand();
        hourHand.setTime(this.clockTime);

        MinuteHand minuteHand = new MinuteHand();
        minuteHand.setTime(this.clockTime);

        SecondHand secondHand = new SecondHand();
        secondHand.setTime(this.clockTime);

        this.hands.add(hourHand);
        this.hands.add(minuteHand);
        this.hands.add(secondHand);
    }
    void toSvg(Path outputFilePath){
        try {
            setHands();
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath.toString()));

            writer.write("<svg width=\"200\" height=\"200\" viewBox=\"-100 -100 200 200\" xmlns=\"http://www.w3.org/2000/svg\">");

            writer.write(
                    "  <circle cx=\"0\" cy=\"0\" r=\"90\" fill=\"none\" stroke=\"black\" stroke-width=\"2\" />\n" +
                            "  <g text-anchor=\"middle\">\n" +
                            "    <text x=\"0\" y=\"-80\" dy=\"6\">12</text>\n" +
                            "    <text x=\"80\" y=\"0\" dy=\"4\">3</text>\n" +
                            "    <text x=\"0\" y=\"80\" dy=\"6\">6</text>\n" +
                            "    <text x=\"-80\" y=\"0\" dy=\"4\">9</text>\n" +
                            "  </g>"
            );

            for(ClockHand hand : hands){
                writer.write(hand.toSvg());
            }

            writer.write("</svg>");

            writer.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
